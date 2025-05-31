import interface_usuario.*;
import interface_usuario.*;                         // suas interfaces de UI
import conexao_workbench.ConexaoForMySQL;           // conexão MySQL
import java.sql.Connection;                         // JDBC Connection
import java.sql.PreparedStatement;                  // JDBC PreparedStatement
import java.sql.ResultSet;                          // JDBC ResultSet
import java.sql.SQLException;                       // JDBC SQLException
import estrutura.Registro;                          // sua classe Registro
import javax.swing.SwingUtilities;                  // para disparar Swing na EDT

import estrutura.MyQueue;                            // interface de fila custom
import estrutura.MyLinkedQueue;                      // implementação de fila
import estrutura.MySet;                              // interface de conjunto custom
import estrutura.MyHashSet;                          // implementação de hash-set

public class Main {

private static final double VALOR_MINIMO_FRAUDE = 1.0;      // valor mínimo para considerar fraude
private static final int    LIMITE_REGISTROS   = 100000;    // limite de registros a ler

public static void main(String[] args) {
    Connection conexaoLeitura = null;              // referência à conexão de leitura
    Connection conexaoEscrita = null;              // referência à conexão de escrita (nao usado ainda, usado para fazer update no banco online)
    PreparedStatement stmtLeitura = null;          // statement para consulta de leitura
    ResultSet resultado = null;                    // cursor para os resultados da consulta


    MyQueue<Registro> filaFraudes = new MyLinkedQueue();        // fila para armazenar todos os registros
    MySet<Registro>   naoFraudes  = new MyHashSet();            // conjunto para armazenar nao-fraudes

    try {
        // 2. abrir conexão de leitura
        conexaoLeitura = ConexaoForMySQL.getConexao();          // obtem conexao MySQL de leitura
        // conexaoEscrita = OutraConexaoForMySQL.getConexao();

        if (conexaoLeitura != null) {              // conficao para verificar conexao e da retorno de conexao estabelecida
            System.out.println("Conexão de leitura estabelecida com sucesso!");

            String sqlLeitura =                    // prepara consulta no banco mysql workbench
                "SELECT nome, genero, idade, estado, cidade, tipodaconta, " +
                "datatransacao, valortransacao, tipodetransacao, categoria, " +
                "dispositivodetransacao, fraude " +
                "FROM golpes " + "WHERE valortransacao > ? LIMIT ?";        // query de busca com campos selecionados 
            
            stmtLeitura = conexaoLeitura.prepareStatement(sqlLeitura);      // cria PreparedStatement
            stmtLeitura.setDouble(1, VALOR_MINIMO_FRAUDE);                  // define primeiro parametro
            stmtLeitura.setInt(2, LIMITE_REGISTROS);                        // define segundo parametro

            System.out.println("Executando consulta: " + sqlLeitura);
            resultado = stmtLeitura.executeQuery();                         // executa a query

            // 4. ler e enfileirar todos os registros
            while (resultado.next()) {
                String  nome                   = resultado.getString("nome");
                String  genero                 = resultado.getString("genero");
                int     idade                  = resultado.getInt("idade");
                String  estado                 = resultado.getString("estado");
                String  cidade                 = resultado.getString("cidade");
                String  tipoDaConta            = resultado.getString("tipodaconta");
                String  dataTransacao          = resultado.getString("datatransacao");
                Float   valorTransacao         = resultado.getFloat("valortransacao");
                String  tipoDeTransacao        = resultado.getString("tipodetransacao");
                String  categoria              = resultado.getString("categoria");
                String  dispositivoTransacao   = resultado.getString("dispositivodetransacao");
                boolean fraude                 = resultado.getBoolean("fraude");
                
                // cria instância de Registro com os valores obtidos
                Registro registro = new Registro(
                    nome, genero, idade, estado, cidade,
                    tipoDaConta, dataTransacao, valorTransacao,
                    tipoDeTransacao, categoria, dispositivoTransacao, fraude
                );
                
                filaFraudes.enqueue(registro);       // 4.enfileira todo mundo

                if (!registro.isFraude()) {         //marca nao-fraudes
                    naoFraudes.add(registro);
                }
            }


            MyQueue<Registro> apenasFraudes = new MyLinkedQueue();      //filtrar apenas fraudes, usando outra fila
            while (!filaFraudes.isEmpty()) {                            // nova fila para fraudes
                Registro r = filaFraudes.dequeue();                     // retira próximo registro
                if (r.isFraude()) {
                    apenasFraudes.enqueue(r);                           // enfileira só fraudes
                }
            }

            // exibir resultados
            System.out.println("Registros de fraude:");                 // imprime cada fraude
            while (!apenasFraudes.isEmpty()) {
                System.out.println(apenasFraudes.dequeue());
            }
                java.awt.EventQueue.invokeLater(() -> {                 // cria instancia da tela do usuario
                new tela_inicio().setLocationRelativeTo(null);          // centraliza a janela
                new tela_inicio().setVisible(true);                     // exibe a janela
                });
                
            // 8. aqui você pode usar conexaoEscrita para updates, se quiser
        }
        else {
            System.err.println("Falha ao conectar no banco de leitura.");
        }

    } catch (SQLException e) {                                          // tratamento de erro
        System.err.println("Erro em JDBC: " + e.getMessage());
    } finally {
        // 9. liberar recursos
        try {
            if (resultado       != null) resultado.close();             // fecha ResultSet
            if (stmtLeitura     != null) stmtLeitura.close();           // fecha Statement
            if (conexaoLeitura  != null) conexaoLeitura.close();        // fecha conexão leitura
            if (conexaoEscrita  != null) conexaoEscrita.close();        // fecha conexão escrita
        } catch (SQLException e) {
            System.err.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }
}

    // Mantém este método para uso futuro, mas corrija SQL injection. */
public static void consultarFraudesPorTipo(String tipoFraude) {
    // ... implementar com PreparedStatement para evitar injeção ...
}
}