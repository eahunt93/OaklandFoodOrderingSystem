/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author elijahhunt93
 */
public class StudentClient11 extends javax.swing.JFrame {

    ArrayList<Menu> menuList = new ArrayList<>();
    //ChickFilA items
    Menu m1 = new Menu("1", "Chick FilA Chicken Sandwich", "piece of chicken in between two pieces of bread.", 4.99);
    Menu m2 = new Menu("2", "Chick FilA Chicken Delux Sandwich", "The deluxe version of number one.", 5.99);
    Menu m3 = new Menu("3", "Spicy Chicken Sandwich", "The spicy version of number one.", 5.99);
    Menu m4 = new Menu("4", "Spicy Chicken Deluxe", "The deluxe version of number three.", 6.29);
    
    //Moes items
    Menu m5 = new Menu("1", "HomeWrecker Burrito", "Griled meat, beans, rice shreded cheese, pico de gallo, lettuce, sour cream, guacamole", 6.79);
    Menu m6 = new Menu("2", "Art Vandala Burrito", "Beans, rice, shredded cheese, pico de gallo, lettuce, sour cream, guacamole", 5.29);
    Menu m7 = new Menu("3", "John Coctostan Quesadilla", "Grilled meat, beans, shredded cheese, with a side of pico de gallo and sour cream", 5.79);
    Menu m8 = new Menu("4", "Instant Friend Quesadilla", "Beans, shredded cheese, and sauteed veggies, with a side of pico de gallo and sour cream", 4.29);
    public static ArrayList<String> order = new ArrayList<String>();
    private static Socket clientSocket = null; //client socket
    private static DataOutputStream os = null; //the output stream
    private static DataInputStream is = null; //the inputstream
    public static String title = "";
    public double ordertotal = 0.0;

    /**
     * Creates new form TryClient
     */
    public StudentClient11() {
        initComponents();
        itemnumber.setVisible(false);
        addcart.setVisible(false);
        itemlabel.setVisible(false);

        if (title.equals("Chick Fila")) {
            setChickFilA();
        } else if (title.equals("Moes")) {
            setMoes();
        }
    }

    private void setChickFilA() {
        //Popualte the client with the menu of ChickFilA
        menuList.clear();
        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        menuList.add(m4);
        orders.setText(menuList.toString());
    }

    private void setMoes() {
        //Populate the client with the menu of Moes
        menuList.clear();
        menuList.add(m5);
        menuList.add(m6);
        menuList.add(m7);
        menuList.add(m8);
        orders.setText(menuList.toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        orders = new javax.swing.JTextArea();
        ordername = new javax.swing.JTextField();
        namebtn = new javax.swing.JButton();
        SendName = new javax.swing.JLabel();
        itemnumber = new javax.swing.JComboBox<>();
        addcart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cart = new javax.swing.JTextArea();
        send = new javax.swing.JButton();
        itemlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orders.setEditable(false);
        orders.setColumns(20);
        orders.setRows(5);
        jScrollPane1.setViewportView(orders);

        namebtn.setText("Send name for pickup");
        namebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namebtnActionPerformed(evt);
            }
        });

        SendName.setText("Send Name");

        itemnumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        itemnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemnumberActionPerformed(evt);
            }
        });

        addcart.setText("add to cart");
        addcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcartActionPerformed(evt);
            }
        });

        cart.setColumns(20);
        cart.setRows(5);
        jScrollPane2.setViewportView(cart);

        send.setText("Send order");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        itemlabel.setText("Select items that you want");

        jLabel1.setText("Your cart");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namebtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SendName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ordername, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addcart)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(itemnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(itemlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(send)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ordername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SendName)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(namebtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(send))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(itemlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addcart)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namebtnActionPerformed
        // TODO add your handling code here:
        String name = "";
        try {
            //Send name and show/hide buttons appropriately
            name = ordername.getText().trim();
            os.writeUTF(name);
            os.flush();
            System.out.println(name);
            itemlabel.setVisible(true);
            itemnumber.setVisible(true);
            addcart.setVisible(true);
            System.out.println("Name sent");
            namebtn.setVisible(false);
        } catch (Exception e) {
            System.out.println("Error sending name!");
        }
    }//GEN-LAST:event_namebtnActionPerformed

    private void itemnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemnumberActionPerformed

    private void addcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcartActionPerformed
        // TODO add your handling code here:
         DecimalFormat m = new DecimalFormat("###.##");
        String order = "";
        int i = Integer.parseInt((String) itemnumber.getSelectedItem()); //Item number
        order = "Item number: " + menuList.get(i-1).getIndex();
        cart.setText(cart.getText() + "\n" + order);
        ordertotal = ordertotal + menuList.get(i-1).getprice();  
       System.out.println(m.format(ordertotal));
        send.setVisible(true);
        total.setText("Your total is $" + m.format(ordertotal));
    }//GEN-LAST:event_addcartActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
        DecimalFormat m = new DecimalFormat("###.##");
        String order = "";
        try {
            order = getTitle().substring(14) + " " + cart.getText() + "\n" + "Total = $" + m.format(ordertotal);
            os.writeUTF(order);
            os.flush();
            System.out.println(order);
            send.setVisible(false);
        } catch (Exception e) {
            System.out.println("Error sending order!");
        }
        

    }//GEN-LAST:event_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentClient11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentClient11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentClient11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentClient11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //setting up the MainGUi
                MainGUI mainGui = new MainGUI();
                mainGui.setVisible(true);
                if (!mainGui.isVisible()) {
                    new StudentClient11().setVisible(true);
                } else {
                    new StudentClient11().setVisible(false);
                }
            }
        });
        try {
            clientSocket = new Socket("localhost", 2222);
            System.out.println("Connectd to server");
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());

            String msgin = "";
            while (!msgin.equals("exit")) {
                msgin = is.readUTF();
                if (msgin.equals("please submit name")) {
                    System.out.println(msgin);
                    break;
                } else {
                    System.out.println("Waiting for server to prompt us...");
                }
            }

            while (!msgin.equals("exit")) {
                msgin = is.readUTF();
                if (msgin.startsWith("Hello")) {
                    System.out.println(msgin);
                    os.writeUTF(title + " hey");
                    os.flush();
                    break;
                } else {
                    System.out.println("Waiting for server welcome message...");
                }
            }

            if (!msgin.equals("exit")) {
                msgin = is.readUTF();
                System.out.println(msgin);
                JOptionPane.showMessageDialog(null, msgin);
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SendName;
    private static javax.swing.JButton addcart;
    private static javax.swing.JTextArea cart;
    private javax.swing.JLabel itemlabel;
    private static javax.swing.JComboBox<String> itemnumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton namebtn;
    private javax.swing.JTextField ordername;
    private static javax.swing.JTextArea orders;
    private static javax.swing.JButton send;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

}
