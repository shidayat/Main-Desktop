
/*
 * LookUp.java
 *
 * Created on MaRCH 12, 2014, 16:16:25 
 */
package mfauz.desktop.panel.lookup;


import com.artitraining.mfauz.model.Menu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import mfauz.desktop.Main;
import mfauz.desktop.util.FormUtil;
import mfauz.desktop.util.TextComponentUtils;


/**
 *
 * @author ASUS
 */
public class LookUpMenu extends javax.swing.JDialog
    implements ListSelectionListener{

    private static Menu menu;
    private List<Menu> listMenu;
     
    /** Creates new form LookUpBarang */
    public LookUpMenu(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        listMenu = Main.getAppService().findAllMenu();
        tblMenu.setModel(new MenuTableModel(listMenu));
        tblMenu.setAutoCreateColumnsFromModel(true);
        FormUtil.centerWindow(this);   
        TextComponentUtils.setAutoUpperCaseText(25, txtNama);
    }
    
    public Menu getMenu() {
        setVisible(true);
        return menu;
    
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        btnOK = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        KODE = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(580, 450));
        setModal(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("List Menu"));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jPanel1.setMinimumSize(new java.awt.Dimension(590, 500));

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAMA MENU", "MENU LEVEL", "PANEL CLASS", "URUTAN", "ID PARENT"
            }
        ));
        tblMenu.setToolTipText("Sorot dataPerson dan Klik OK!!");
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMenu);

        btnOK.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mfauz/desktop/image/cekmark_1.png"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnBatal.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mfauz/desktop/image/kali_1.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        txtKode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKodeKeyReleased(evt);
            }
        });

        KODE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mfauz/desktop/image/panah kanan_2.png"))); // NOI18N
        KODE.setText("KODE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mfauz/desktop/image/barang.png"))); // NOI18N
        jLabel2.setText("NAMA MENU");

        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Cari dgn");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(KODE))
                        .addGap(53, 53, 53))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnOK)
                .addGap(18, 18, 18)
                .addComponent(btnBatal)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(KODE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnOK))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
// TODO add your handling code here:
    dispose();
}//GEN-LAST:event_btnBatalActionPerformed

private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        try{
        menu = listMenu.get(tblMenu.getSelectedRow());
        this.setVisible(false);  
        } catch(Exception ex) {
        
        }  
}//GEN-LAST:event_btnOKActionPerformed

private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
// TODO add your handling code here:
    listMenu = null;
//    listMenu = Main.getAppService().findMenuListNama(txtNama.getText());
    tblMenu.setModel(new MenuTableModel(listMenu));
    
    if(listMenu==null || listMenu.isEmpty()){
        JOptionPane.showMessageDialog(this, "Menu Tidak Ada!! Perbaiki Pencarian!",
            "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_txtNamaKeyReleased

private void txtKodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeKeyReleased
// TODO add your handling code here:
    listMenu = null;
//    listMenu = Main.getAppService().findMenuByKode(txtKode.getText());
    tblMenu.setModel(new MenuTableModel(listMenu));   
    
    if(listMenu==null || listMenu.isEmpty()){
    JOptionPane.showMessageDialog(this, "Menu Tidak Ada!! Perbaiki Pencarian!",
            "Peringatan", JOptionPane.ERROR_MESSAGE);
    }
}//GEN-LAST:event_txtKodeKeyReleased

private void tblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMouseClicked
}//GEN-LAST:event_tblMenuMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
}//GEN-LAST:event_jButton1ActionPerformed

public class MenuTableModel extends AbstractTableModel{
    private List<Menu> listMenu;
    private String[] HEADER = new String[] {"NAMA MENU", "MENULEVEL", "PANELCLASS" ,
          "URUTAN"};
   
    public MenuTableModel(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }
    
    
    @Override
    public int getRowCount() {
        return listMenu.size();   // size untuk tipe List
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;   //length untuk tipe array
    }
    
    @Override
    public String getColumnName(int column){
        return HEADER[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Menu m = listMenu.get(rowIndex);
      switch(columnIndex){
          
          case 0:
              return m.getId();
          case 1:
              return m.getMenuLevel();
          case 2:
              return m.getPanelClass();
          case 3:
              return m.getUrutan();   
//          case 4:
//              return m.getParent().getId();
          default:
              return "";
      }
    }
    
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
        case 1:
        case 3:
            return Integer.class;
        }
        return String.class;
    }
}

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getValueIsAdjusting()) {
            return;
        }
    }   
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel KODE;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

   
}
