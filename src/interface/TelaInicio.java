
package interface_usuario;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaInicio extends javax.swing.JFrame {
    private static final String URL_RELATORIO =
   "https://lookerstudio.google.com/u/0/reporting/"
    + "62d41e0e-a657-4c23-8d1d-34b8b0babc5a/page/TRvFF";
    
    private String urlRelatorio;
    
    public TelaInicio() {
    this(URL_RELATORIO);
}
    public TelaInicio(String url) {
        this.urlRelatorio = url;

    // 1) Substitui o contentPane por um JPanel que desenha a imagem de fundo:
    setContentPane(new JPanel() {
        private final Image background = new ImageIcon(
            getClass().getResource("BackgroundOk.png")
        ).getImage();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // desenha a imagem cobrindo todo o painel
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    });

    initComponents();          // 2) agora inicializa componentes sobre esse painel

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButton1.setText("Abrir Relatorio");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }   
    });
        // Aqui o NetBeans continua usando GroupLayout, só que agora em nosso painel com fundo
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(0,0,150)
          .addComponent(jButton1)
          .addContainerGap(0, Short.MAX_VALUE))            
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
          .addContainerGap(163, Short.MAX_VALUE)
          .addComponent(jButton1)
          .addGap(0, 0, 114))
    );
}// </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

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
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        if (Desktop.isDesktopSupported() &&
            Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
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
    public static void main(String args[]) {
// se você quiser iniciar diretamente esta tela
    java.awt.EventQueue.invokeLater(() -> {
        new TelaInicio().setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
