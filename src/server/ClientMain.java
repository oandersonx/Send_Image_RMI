
package server;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ClientMain extends javax.swing.JFrame {

   // ArrayList<Integer> listaNumeros = new ArrayList<>();
    String ip = "10.180.54.199", name = "SD";
    
    BufferedImage imagem_com_filtro, imagem;
    
    
    
    public ClientMain() {
        initComponents();
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagem = new javax.swing.JLabel();
        jButtonAdicionarImagem = new javax.swing.JButton();
        jTextFieldPath = new javax.swing.JTextField();
        jLabelImagemAlterada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonAdicionarImagem.setText("Adicionar Imagem");
        jButtonAdicionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarImagemActionPerformed(evt);
            }
        });

        jLabel1.setText("Original");

        jLabel2.setText("Com filtro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(203, 203, 203))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jButtonAdicionarImagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jLabelImagemAlterada, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jLabelImagemAlterada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarImagemActionPerformed
        JFileChooser arquivo = new JFileChooser();
        arquivo.setDialogTitle("Selecione uma imagem");
        arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int opc = arquivo.showOpenDialog(null);
        if(opc == JFileChooser.APPROVE_OPTION){
            //File file = new File("Caminho");
            File arq = arquivo.getSelectedFile();
            
           
           
           
        
           
            //file = arquivo.getSelectedFile();
            //String filename = file.getAbsolutePath();
            //BufferedImage bi = ImageIO.read(filename);
//            jTextFieldPath.setText(arq);   
            
            
            
            
           
           //ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
           //jLabelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_DEFAULT)));
          
            
             
            try {
                Cliente<InterfaceAplica> client = new Cliente<InterfaceAplica>(ip, name);
                System.out.println("Conectoooooooooooou...\n");
                //imagem = ManipularImagem.setImagemDimensao(arq.getAbsolutePath(), 160, 160); // BF - dimensao
              
                ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath()); //IC
                  System.out.println("Paassou pra ca\n");
                //ImageIcon image = new ImageIcon(imagem); // Convertendo BF para ImageIcon
                 
                ImageIcon imagem_com_filtr = new ImageIcon(arquivo.getSelectedFile().getPath());
                System.out.println("aaaaaaaaaaaaaa\n");
                //imagem_com_filtro = ManipularImagem.setImagemDimensao(arq.getAbsolutePath(), 100, 100); //BF - dimensao
            //BufferedImage imagem_com_filtro = new BufferedImage(arq.getAbsolutePath(), 160, 160);
                
               
                
                imagem_com_filtr= client.getRemoteObj().aplicarFiltro(imagem); // Acessa com o obj remotamente
                System.out.println("e teile \n");
                
                //ImageIcon imagem_com_filtro_IC = new ImageIcon(imagem_com_filtro); //BF - IC
                System.out.println("Desceu aqui\n");
                
            //jLabelImagem.setIcon(new ImageIcon());
             System.out.println("e esse\n");
             jLabelImagem.setIcon(new ImageIcon(imagem.getImage().getScaledInstance(jLabelImagem.getWidth(), jLabelImagem.getHeight(), Image.SCALE_DEFAULT)));
             jLabelImagemAlterada.setIcon(new ImageIcon(imagem_com_filtr.getImage().getScaledInstance(jLabelImagemAlterada.getWidth(), jLabelImagemAlterada.getHeight(), Image.SCALE_DEFAULT)));
            //  jLabelImagemAlterada.setIcon(new ImageIcon(imagem_com_filtro));
               
                
               
               
               //BufferedImage bi = ImageIO.read(file);
                //ImageIcon imagem_com_filtro = new ImageIcon();
                //imagem_com_filtro = client.getRemoteObj().aplicarFiltro(imagem);
                
                System.out.println("A imagem chegou!!!!\n");
                //jLabelImagemAlterada.setIcon(new ImageIcon(imagem_com_filtro.getImage().getScaledInstance(jLabelImagemAlterada.getWidth(), jLabelImagemAlterada.getHeight(), Image.SCALE_DEFAULT)));
            } catch (RemoteException ex) {
                System.out.println("Nao rolou...\n" +ex);
           
            } catch (NotBoundException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ClientMain.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_jButtonAdicionarImagemActionPerformed

    
    /*private static BufferedImage toGrayScale(BufferedImage image){
        Color cor;
        int i;
        for (int x = 0; x<image.getWidth(); x++){
            for(int y = 0; y<image.getHeight(); y++){
                cor = new Color(image.getRGB(x,y));
                i = (cor.getRed()+cor.getGreen()+cor.getBlue()/3);
                image.setRGB(x, y, i);
            }
        } return image;
    }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelImagemAlterada;
    private javax.swing.JTextField jTextFieldPath;
    // End of variables declaration//GEN-END:variables
}
