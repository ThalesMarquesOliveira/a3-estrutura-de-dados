
package estrutura;

 public class Registro {

private String nome;
private String genero;
private int idade;
private String estado;
private String cidade;
private String tipodaconta;
private String datatransacao;
private Float valortransacao;
private String tipodetransacao;
private String categoria;
private String dispositivodetransacao;
private Boolean fraude;

// Construtor (já fornecido)
public Registro(String nome, String genero, int idade, String estado, String cidade, String tipodaconta,
                String datatransacao, Float valortransacao, String tipodetransacao, String categoria, String dispositivodetransacao, Boolean fraude) {
    this.nome = nome;
    this.genero = genero;
    this.idade = idade;
    this.estado = estado;
    this.cidade = cidade;
    this.tipodaconta = tipodaconta;
    this.datatransacao = datatransacao;
    this.valortransacao = valortransacao;
    this.tipodetransacao = tipodetransacao;
    this.categoria = categoria;
    this.dispositivodetransacao = dispositivodetransacao;
    this.fraude = fraude;
}

// Getters e Setters Corrigidos
public String getGenero() {
    return genero;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public int getIdade() {
    return idade;
}

public void setIdade(int idade) {
    this.idade = idade;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public String getCidade() {
    return cidade;
}

public void setCidade(String cidade) {
    this.cidade = cidade;
}

public String getTipodaconta() {
    return tipodaconta;
}

public void setTipodaconta(String tipodedaconta) {
    this.tipodaconta = tipodaconta;
}

public String getDatatransacao() {
    return datatransacao;
}

public void setDatatransacao(String datatransacao) {
    this.datatransacao = datatransacao;
}

public String getTipodetransacao() {
    return tipodetransacao;
}

public void setTipodetransacao(String tipotransacao) {
    this.tipodetransacao = tipotransacao;
}

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public String getDispositivodetransacao() {
    return dispositivodetransacao;
}

public void setDispositivodetransacao(String dispositivodetransacao) {
    this.dispositivodetransacao = dispositivodetransacao;
}

public boolean isFraude() { // Use is para booleanos
    return fraude;
}

public void setFraude(Boolean fraude) {
    this.fraude = fraude;
}

public Float getValortransacao() {
    return valortransacao;
}

public void setValortransacao(Float valortransacao) {
    this.valortransacao = valortransacao;
}
}