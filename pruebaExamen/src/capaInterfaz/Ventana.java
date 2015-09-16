/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package capaInterfaz;

import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Martin-PC
 */
public class Ventana extends javax.swing.JFrame implements ActionListener, KeyListener{
    Casilla [][] tablero;
    int cont;
   ImageIcon player1=new ImageIcon(getClass().getResource("/Imagenes/linux.png"));
   ImageIcon player2=new ImageIcon(getClass().getResource("/Imagenes/linux.png"));
   ImageIcon aux1=null;
   ImageIcon aux2=null;
   ImageIcon iconoGuia=new ImageIcon(getClass().getResource("/Imagenes/guia.png"));
   String nom1;
   String nom2;
   int n1,n2,n3,n4,n5,n6,n7,n8,n9;
    

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        
        Partida.setVisible(true);
        Partida.getContentPane().setBackground(Color.black);
        Partida.setLocationRelativeTo(this);
        Partida.setDefaultCloseOperation(0);
        Instruccion.setVisible(false);
        Instruccion.getContentPane().setBackground(Color.lightGray);
        Instruccion.setLocationRelativeTo(this);
        Instruccion.setDefaultCloseOperation(0);
        this.setLocationRelativeTo(null);
        this.labelGuia.setIcon(iconoGuia);
        this.btnJugador1.setIcon(player1);
        this.btnJugador2.setIcon(player2);
        
        
        
        tablero=new Casilla[3][3];
        for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
             tablero[i][j]=new Casilla();
             tablero[i][j].A.setBounds((i*100)+10, (j*100)+10, 100, 100);
             // los primeros x,y ubican al boton, los dos 100, dan el tamaño;
             tablero[i][j].A.addActionListener(this);
             tablero[i][j].A.addKeyListener(this);
             //todo lo que este presionado va a pasar sobre este jFrame
             // y le permite generar eventos al boton
             this.add(tablero[i][j].A); // esto agrega el boton al Jframe
         }
            }

    }
    
    public void tiro(Casilla x){
        if(cont%2==0){
            x.B=1;
            x.A.setIcon(player1);
            x.A.removeActionListener(this);
            
        }
        else{
            x.B=4;
            x.A.setIcon(player2);
            x.A.removeActionListener(this);
            //x.A.removeKeyListener(this);
            //el remove es para que solo una vez tocar el boton
        }
        
        //icono= new ImageIcon(icono.getImage().getEscaledInstance(90,90,java.awt.Image.ESCALE_DEFAULT));
        
    }
    
    void seleccionarPrimerJugador(){
        if(combo1.getSelectedIndex()==0){
            player1=new ImageIcon(getClass().getResource("/Imagenes/linux.png"));
            this.btnJugador1.setIcon(player1);
            return;
        }
        if(combo1.getSelectedIndex()==1){
            player1=new ImageIcon(getClass().getResource("/Imagenes/android.png"));
            this.btnJugador1.setIcon(player1);
            return;
        }
        if(combo1.getSelectedIndex()==2){
            player1=new ImageIcon(getClass().getResource("/Imagenes/mac.png"));
        this.btnJugador1.setIcon(player1);
        return;}
        if(combo1.getSelectedIndex()==3){
            player1=new ImageIcon(getClass().getResource("/Imagenes/windows.png"));
            this.btnJugador1.setIcon(player1);
            return;
        }
    }
    
    void seleccionarSegundoJugador(){
        if(combo2.getSelectedIndex()==0){
            player2=new ImageIcon(getClass().getResource("/Imagenes/linux.png"));
            this.btnJugador2.setIcon(player2);
            return;
        }
        if(combo2.getSelectedIndex()==1){
            player2=new ImageIcon(getClass().getResource("/Imagenes/android.png"));
            this.btnJugador2.setIcon(player2);
            return;
        }
        if(combo2.getSelectedIndex()==2){
            player2=new ImageIcon(getClass().getResource("/Imagenes/mac.png"));
        this.btnJugador2.setIcon(player2);
        return;
        }
        if(combo2.getSelectedIndex()==3){
            player2=new ImageIcon(getClass().getResource("/Imagenes/windows.png"));
            this.btnJugador2.setIcon(player2);
            return;
        }
    }
    
    public void opcionContinuar(String n){
       int i= JOptionPane.showConfirmDialog(null, n+" Es el ganador!!!"+"\n"+"Desea Cambiar de Usuarios???","Ganador",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {
            reiniciar();
            this.setVisible(false);
            this.Partida.setVisible(true);
            this.txtNom1.setText("");
            this.txtNom2.setText("");
        }
        else{
            reiniciar();
            player1=aux1;
            player2=aux2;
        }
            
    }
    
    public void opcionEmpate(){
        int i= JOptionPane.showConfirmDialog(null, " Juego Empatado"+"\n"+"Desea Cambiar de Usuarios???","Empate",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
        {
            reiniciar();
            this.setVisible(false);
            this.Partida.setVisible(true);
            this.txtNom1.setText("");
            this.txtNom2.setText("");
        }
        else{
            reiniciar();
        }
    }
    
    public void menuPartida(){this.Partida.setVisible(true);}
    
    public void reiniciar(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j].A.addActionListener(this);
                tablero[i][j].A.setIcon(null);
                tablero[i][j].B=0;
            }
        }
        n1=0;n2=0;n3=0;n4=0;n5=0;n6=0;n7=0;n8=0;n9=0;
        cont=0;
    }
    
    public void desactivarTodo(){
           for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j].A.removeActionListener(this);
                tablero[i][j].A.setIcon(null);
                tablero[i][j].B=0;
            }
        }
        n1=1;n2=1;n3=1;n4=1;n5=1;n6=1;n7=1;n8=1;n9=1;
    }
    
    public boolean revisar(){
        int suma=0;
        aux1=player1;
        aux2=player2;
        for(int i=0;i<3;i++){
            suma=tablero[i][0].B+tablero[i][1].B+tablero[i][2].B;
            if(suma==3||suma==12){
                desactivarTodo();
                player1=new ImageIcon(getClass().getResource("/Imagenes/feliz.png"));
                tablero[i][0].A.setIcon(player1);
                tablero[i][1].A.setIcon(player1);
                tablero[i][2].A.setIcon(player1);
                return true;}
        }
        for(int i=0;i<3;i++){
            suma=tablero[0][i].B+tablero[1][i].B+tablero[2][i].B;
            if(suma==3||suma==12){
                desactivarTodo();
                player1=new ImageIcon(getClass().getResource("/Imagenes/feliz.png"));
                tablero[0][i].A.setIcon(player1);
                tablero[1][i].A.setIcon(player1);
                tablero[2][i].A.setIcon(player1);
                return true;}
        }
        suma=tablero[0][2].B+tablero[1][1].B+tablero[2][0].B;
        if(suma==3||suma==12){
                desactivarTodo();
                player1=new ImageIcon(getClass().getResource("/Imagenes/feliz.png"));
                tablero[0][2].A.setIcon(player1);
                tablero[1][1].A.setIcon(player1);
                tablero[2][0].A.setIcon(player1);
                return true;}
        suma=0;
        for(int i=0;i<3;i++)
            suma+=tablero[i][i].B;
        if(suma==3||suma==12){
                desactivarTodo();
                player1=new ImageIcon(getClass().getResource("/Imagenes/feliz.png"));
                tablero[0][0].A.setIcon(player1);
                tablero[1][1].A.setIcon(player1);
                tablero[2][2].A.setIcon(player1);
                return true;}
        
        return false;
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Partida = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNom1 = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox();
        btnJugador1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNom2 = new javax.swing.JTextField();
        combo2 = new javax.swing.JComboBox();
        btnJugador2 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();
        Instruccion = new javax.swing.JDialog();
        labelGuia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Instrucciones = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        Partida.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Partida.setTitle("Nueva Partida");
        Partida.setLocationByPlatform(true);
        Partida.setMinimumSize(new java.awt.Dimension(535, 360));
        Partida.setPreferredSize(new java.awt.Dimension(535, 335));
        Partida.setResizable(false);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3 En Raya");

        jLabel1.setText("  Jugador 1");

        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Linux", "Android", "MAC", "Windows" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        btnJugador1.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNom1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("  Jugador 2");

        combo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Linux", "Android", "MAC", "Windows" }));
        combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo2ActionPerformed(evt);
            }
        });

        btnJugador2.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNom2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(combo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnComenzar.setText("Comenzar");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PartidaLayout = new javax.swing.GroupLayout(Partida.getContentPane());
        Partida.getContentPane().setLayout(PartidaLayout);
        PartidaLayout.setHorizontalGroup(
            PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PartidaLayout.createSequentialGroup()
                .addGroup(PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PartidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PartidaLayout.createSequentialGroup()
                        .addGroup(PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PartidaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnComenzar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PartidaLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        PartidaLayout.setVerticalGroup(
            PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PartidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PartidaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PartidaLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComenzar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );

        Partida.getAccessibleContext().setAccessibleParent(this);

        Instruccion.setMinimumSize(new java.awt.Dimension(462, 395));
        Instruccion.setResizable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Utiliza las teclas para seleccionar la casllia que deseas, suerte!!! "); // NOI18N

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InstruccionLayout = new javax.swing.GroupLayout(Instruccion.getContentPane());
        Instruccion.getContentPane().setLayout(InstruccionLayout);
        InstruccionLayout.setHorizontalGroup(
            InstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstruccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelGuia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        InstruccionLayout.setVerticalGroup(
            InstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstruccionLayout.createSequentialGroup()
                .addGroup(InstruccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InstruccionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InstruccionLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu1.setText("Acciones");

        jMenuItem1.setText("Reiniciar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Menu Inicio");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        Instrucciones.setText("Instrucciones");

        jMenuItem3.setText("Ver Guia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        Instrucciones.add(jMenuItem3);

        jMenuBar1.add(Instrucciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:
//        Linux
//        Android
//        MAC
//        Windows
        seleccionarPrimerJugador();
            
    }//GEN-LAST:event_combo1ActionPerformed

    private void combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo2ActionPerformed
        // TODO add your handling code here:
        seleccionarSegundoJugador();
    }//GEN-LAST:event_combo2ActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        // TODO add your handling code here:
        nom1=this.txtNom1.getText();
        nom2=this.txtNom2.getText();
        if(txtNom2.getText().equals("")||txtNom1.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Debe Ingresar los nombres");
           return;
        }
        if(this.combo1.getSelectedIndex()==this.combo2.getSelectedIndex()){
            JOptionPane.showMessageDialog(rootPane, "Seleccione iconos diferentes");
            return;
        }
        else{
            seleccionarPrimerJugador();
            seleccionarSegundoJugador();
            this.Partida.setVisible(false);
            this.setVisible(true);
        }
        
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        reiniciar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        reiniciar();
        this.setVisible(false);
        this.Partida.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(true);
        this.Instruccion.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.Instruccion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Instruccion;
    private javax.swing.JMenu Instrucciones;
    private javax.swing.JDialog Partida;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnJugador1;
    private javax.swing.JButton btnJugador2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox combo1;
    private javax.swing.JComboBox combo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelGuia;
    private javax.swing.JTextField txtNom1;
    private javax.swing.JTextField txtNom2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //este codigo pone a escuchar los botones del tablero
        for(int i=0;i<3;i++){
         for(int j=0;j<3;j++){
            if(e.getSource()==tablero[i][j].A){
                tiro(tablero[i][j]);
                if(revisar()==true){
                    if(cont%2==0){
                       // JOptionPane.showMessageDialog(null,nom1+ " HA GANADO");
                        opcionContinuar(nom1);
                    }
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
            }
         }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case java.awt.event.KeyEvent.VK_Q:{
                if(n1%2==0){
       tiro(tablero[0][0]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n1=1;}
            break;}
            case java.awt.event.KeyEvent.VK_W:{
                if(n2%2==0){
       tiro(tablero[1][0]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                       opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n2=1;}
            break;}
            case java.awt.event.KeyEvent.VK_E:{
                if(n3%2==0){
       tiro(tablero[2][0]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n3=1;}
            break;}
            case java.awt.event.KeyEvent.VK_A:{
                if(n4%2==0){
       tiro(tablero[0][1]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n4=1;}
            break;}
            case java.awt.event.KeyEvent.VK_S:{
                if(n5%2==0){
       tiro(tablero[1][1]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n5=1;}
            break;}
            case java.awt.event.KeyEvent.VK_D:{
                if(n6%2==0){
       tiro(tablero[2][1]);
                if(revisar()==true){
                    if(cont%2==0)
                       opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n6=1;}
            break;}
            case java.awt.event.KeyEvent.VK_Z:{
                if(n7%2==0){
       tiro(tablero[0][2]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n7=1;
                }
            break;}
            case java.awt.event.KeyEvent.VK_X:{
                if(n8%2==0){
       tiro(tablero[1][2]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n8=1;}
            break;}
            case java.awt.event.KeyEvent.VK_C:{
                if(n9%2==0){
       tiro(tablero[2][2]);
                if(revisar()==true){
                    if(cont%2==0)
                        opcionContinuar(nom1);
                    else
                        opcionContinuar(nom2);
                 return;
                }
                 cont++;
                 if(cont==9)
                     opcionEmpate();
                 n9=1;}
            break;}
    }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

   
        
    
    
    
}