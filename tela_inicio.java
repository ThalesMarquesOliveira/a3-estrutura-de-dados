package interface_usuario;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

public class tela_inicio extends javax.swing.JFrame {
private static final String URL_RELATORIO =
   "https://lookerstudio.google.com/u/0/reporting/"
 + "62d41e0e-a657-4c23-8d1d-34b8b0babc5a/page/TRvFF";

private String urlRelatorio;

public tela_inicio() {
    this(URL_RELATORIO);
}

public tela_inicio(String url) {
    initComponents();           // constrói a UI gerada pelo NetBeans
    this.urlRelatorio = url;    // armazena a URL que será aberta
    jButton1.setText("Abrir Site");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jButton1)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try {
        // 3) sempre use o campo urlRelatorio
        if (Desktop.isDesktopSupported() &&
            Desktop.getDesktop().isSupported(Desktop.Action.BROWSE))
        {
            Desktop.getDesktop().browse(new URI(urlRelatorio));
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Não foi possível abrir o navegador.\nPlataforma não suportada.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
            this,
            "Erro ao tentar abrir o link:\n" + ex.getMessage(),
            "Erro",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
// Variables declaration - do not modify
public static void main(String[] args) {
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}