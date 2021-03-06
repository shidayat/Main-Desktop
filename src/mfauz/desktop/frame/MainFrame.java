
/*
 * MainFrame.java
 *
 * Created on May 23, 2012, 9:38:32 AM
 */
package mfauz.desktop.frame;


import com.artitraining.mfauz.model.Menu;
import com.artitraining.mfauz.model.Person;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import mfauz.desktop.Main;
import mfauz.desktop.panel.lookup.LoginDialog1;
import mfauz.desktop.panel.master.PanelJenisMutasi;
import mfauz.desktop.panel.master.PanelMenu1;
import mfauz.desktop.panel.master.PanelNotaDokumen;
import mfauz.desktop.panel.master.PanelPerson;
import mfauz.desktop.panel.transaksi.PanelPengeluaranR;
import mfauz.desktop.panel.transaksi.PanelReceipt;
import org.openide.util.Exceptions;

/**
 *
 * @author kuring sarip
 */
public class MainFrame extends javax.swing.JFrame {
     private static final Logger log = Logger.getLogger(MainFrame.class);
//     public static JTabbedPane mainTabPane;
     private Person person;
     List<Menu> menus=new ArrayList<Menu>();
     private static MainFrame instance;
     
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        instance=this;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       jam();
//        tampilanAwal();
//        loginProcess();
//        bacaHakAskes();
    }
     
    //tambahan
        public static MainFrame getInstance() {
        return instance;
    }
    
    private void setSelectedPanel(String panelName) {
        mainTabPane.setSelectedComponent(mainTabPane
        .getComponentAt(getComponentIndexByName(panelName)));
    } 
    
    // berdsrkan nama panel indexnya direturn dan diambil tabpane nya
    // getComponentAt me-return int
    
    private int getComponentIndexByName(String panelName) {
        cekModeTabPane();
        return mainTabPane.indexOfTab(panelName);
    }
 
    private void cekModeTabPane() {
        Component[] comp = mainTabPane.getComponents();
        if(comp.length >=10) {
            mainTabPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        } else {
            mainTabPane.setTabLayoutPolicy(javax.swing.JTabbedPane.WRAP_TAB_LAYOUT);
        }
    }

    public JTabbedPane getMainTabPane() { 
        return mainTabPane;
    }
    
    //tambahan
    public void removeInternalFrame(JInternalFrame c){
        c.dispose();
//      internalFrameMap.remove(c.getClass().getName()); //gak perlu //diganti dgn:
        mainTabPane.remove(c);
    }
    
   private void loginProcess(){ 
           Person p = new LoginDialog1().showDialog();
        if(p!=null){
            person = p;
            lblPengguna.setText("User : " + person.getNama());
            lblID.setText("ID : "+person.getPersonId());  
//                }
//            }
            //construct menu
            menuLogin.setText("Logout");
        }
   }
    
    private void tampilanAwal() {
        menubarMaster.setVisible(false);
        menubarTransaksi.setVisible(false);
        menubarLaporan.setVisible(false);
        menuCreateMenu.setVisible(false);
        menuReceipt.setVisible(false);
        menuPerson.setVisible(false);
        menuTB.setVisible(false);
    }
private void bacaHakAskes() {
  
//     for(Peran p : person.getListPerans()){
//            menus.addAll(p.getMenus());
//     }  
        
     for(Menu menu: menus){ 
        if(menubarMaster.getText().equals(menu.getId())) {
           menubarMaster.setVisible(true);   }
        if(menubarTransaksi.getText().equals(menu.getId())) {
           menubarTransaksi.setVisible(true); }
        if(menubarLaporan.getText().equals(menu.getId())){
           menubarLaporan.setVisible(true); }
        if(menuCreateMenu.getText().equals(menu.getId())) {
           menuCreateMenu.setVisible(true);       }
         if(menuReceipt.getText().equals(menu.getId())) {
            menuReceipt.setVisible(true);       }
         if(menuPerson.getText().equals(menu.getId())) {
            menuPerson.setVisible(true);       }
         if(menuTB.getText().equals(menu.getId())) {
            menuTB.setVisible(true);       }
     }
}
    

        
    
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainTabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblPengguna = new javax.swing.JLabel();
        lblShift = new javax.swing.JLabel();
        lblJam = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menubarFile = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menubarMaster = new javax.swing.JMenu();
        menuPerson = new javax.swing.JMenuItem();
        menuCreateMenu = new javax.swing.JMenuItem();
        menuJenisMutasi = new javax.swing.JMenuItem();
        menuNotaDokumen = new javax.swing.JMenuItem();
        menubarTransaksi = new javax.swing.JMenu();
        menuReceipt = new javax.swing.JMenuItem();
        menuPayment = new javax.swing.JMenuItem();
        menubarLaporan = new javax.swing.JMenu();
        menuTB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Desktop ConToWeb");

        jScrollPane1.setViewportView(mainTabPane);

        lblID.setText(" Id :              ");
        jPanel1.add(lblID);

        lblPengguna.setText("User :                                          ");
        jPanel1.add(lblPengguna);

        lblShift.setText("Tanggal :               ");
        jPanel1.add(lblShift);

        lblJam.setText("jam :                            ");
        jPanel1.add(lblJam);

        menubarFile.setText("File");

        menuLogin.setText("Login");
        menubarFile.add(menuLogin);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menubarFile.add(menuExit);

        jMenuBar1.add(menubarFile);

        menubarMaster.setText("Master");

        menuPerson.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menuPerson.setText("Person");
        menuPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonActionPerformed(evt);
            }
        });
        menubarMaster.add(menuPerson);

        menuCreateMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        menuCreateMenu.setText("Menu");
        menuCreateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCreateMenuActionPerformed(evt);
            }
        });
        menubarMaster.add(menuCreateMenu);

        menuJenisMutasi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_MASK));
        menuJenisMutasi.setText("Jenis Mutasi");
        menuJenisMutasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJenisMutasiActionPerformed(evt);
            }
        });
        menubarMaster.add(menuJenisMutasi);

        menuNotaDokumen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        menuNotaDokumen.setText("Nota Dokumen");
        menuNotaDokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNotaDokumenActionPerformed(evt);
            }
        });
        menubarMaster.add(menuNotaDokumen);

        jMenuBar1.add(menubarMaster);

        menubarTransaksi.setText("Transaksi");

        menuReceipt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK));
        menuReceipt.setText("Input Penerimaan");
        menuReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReceiptActionPerformed(evt);
            }
        });
        menubarTransaksi.add(menuReceipt);

        menuPayment.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        menuPayment.setText("Input Pengeluaran");
        menuPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPaymentActionPerformed(evt);
            }
        });
        menubarTransaksi.add(menuPayment);

        jMenuBar1.add(menubarTransaksi);

        menubarLaporan.setText("Laporan");

        menuTB.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuTB.setText("Trial Balance");
        menuTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTBActionPerformed(evt);
            }
        });
        menubarLaporan.add(menuTB);

        jMenuBar1.add(menubarLaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(260, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

private void menuReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReceiptActionPerformed
    PanelReceipt.getPanelReceipt().setName(PanelReceipt.PANEL_NAME);
    int index = getComponentIndexByName(PanelReceipt.PANEL_NAME);
    if(index == -1) {
        mainTabPane.addTab(PanelReceipt.PANEL_NAME, 
                PanelReceipt.getPanelReceipt());
        setSelectedPanel(PanelReceipt.PANEL_NAME);
    } else {
        mainTabPane.setSelectedIndex(index);
    }
}//GEN-LAST:event_menuReceiptActionPerformed

private void menuPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonActionPerformed
    PanelPerson.getPanelPerson().setName(PanelPerson.PANEL_NAME);
    int index = getComponentIndexByName(PanelPerson.PANEL_NAME);
    if(index == -1) {
        mainTabPane.addTab(PanelPerson.PANEL_NAME, 
                PanelPerson.getPanelPerson());
        setSelectedPanel(PanelPerson.PANEL_NAME);
    } else {
        mainTabPane.setSelectedIndex(index);
    }
}//GEN-LAST:event_menuPersonActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuCreateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCreateMenuActionPerformed
        // TODO add your handling code here:
        PanelMenu1.getPanelMenu().setName(PanelMenu1.PANEL_NAME);
        int index = getComponentIndexByName(PanelMenu1.PANEL_NAME);
        if(index == -1) {
            mainTabPane.addTab(PanelMenu1.PANEL_NAME, PanelMenu1.getPanelMenu());
            setSelectedPanel(PanelMenu1.PANEL_NAME);
        } else {
            mainTabPane.setSelectedIndex(index);
        }
    }//GEN-LAST:event_menuCreateMenuActionPerformed

    private void menuTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTBActionPerformed
        // TODO add your handling code here:
//        try {
//            PanelLapTrialBalance.getPanelLapTB().setName(PanelLapTrialBalance.PANEL_NAME);
//
//            int index = getComponentIndexByName(PanelLapTrialBalance.PANEL_NAME);
//            if(index == -1) {
//                mainTabPane.addTab(PanelLapTrialBalance.PANEL_NAME,
//                    PanelLapTrialBalance.getPanelLapTB());
//                setSelectedPanel(PanelLapTrialBalance.PANEL_NAME);
//            } else {
//                mainTabPane.setSelectedIndex(index);
//            }
//        } catch (Exception ex) {
//            Exceptions.printStackTrace(ex);
//        }
    }//GEN-LAST:event_menuTBActionPerformed

    private void menuJenisMutasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJenisMutasiActionPerformed
        // TODO add your handling code here:
        PanelJenisMutasi.getPanelJenisMutasi().setName(PanelJenisMutasi.PANEL_NAME);
        int index = getComponentIndexByName(PanelJenisMutasi.PANEL_NAME);
        if(index == -1){
           mainTabPane.addTab(PanelJenisMutasi.PANEL_NAME,PanelJenisMutasi.getPanelJenisMutasi());
            setSelectedPanel(PanelJenisMutasi.PANEL_NAME);
        } else {
           mainTabPane.setSelectedIndex(index);
        }
    }//GEN-LAST:event_menuJenisMutasiActionPerformed

    private void menuPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPaymentActionPerformed
        // TODO add your handling code here:
        PanelPengeluaranR.getPanelPayment().setName(PanelPengeluaranR.PANEL_NAME);
        int index = getComponentIndexByName(PanelPengeluaranR.PANEL_NAME);
        if(index == -1){
           mainTabPane.addTab(PanelPengeluaranR.PANEL_NAME,PanelPengeluaranR.getPanelPayment());
            setSelectedPanel(PanelPengeluaranR.PANEL_NAME);
        } else {
           mainTabPane.setSelectedIndex(index);
        } 
    }//GEN-LAST:event_menuPaymentActionPerformed

    private void menuNotaDokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNotaDokumenActionPerformed
        // TODO add your handling code here:
        PanelNotaDokumen.getPanelKodeDokumen().setName(PanelNotaDokumen.PANEL_NAME);
        int index = getComponentIndexByName(PanelNotaDokumen.PANEL_NAME);
        if(index == -1){
           mainTabPane.addTab(PanelNotaDokumen.PANEL_NAME,PanelNotaDokumen.getPanelKodeDokumen());
            setSelectedPanel(PanelNotaDokumen.PANEL_NAME);
        } else {
           mainTabPane.setSelectedIndex(index);
        }        
    }//GEN-LAST:event_menuNotaDokumenActionPerformed
 
 private void jam(){
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                   
                    lblJam.setText(new SimpleDateFormat("EEEE, dd-MMM-yyyy  HH:mm:ss").format(Main.getAppService().tanggalServer()));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }
        });
        t.start();
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblJam;
    private javax.swing.JLabel lblPengguna;
    private javax.swing.JLabel lblShift;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JMenuItem menuCreateMenu;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuJenisMutasi;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuNotaDokumen;
    private javax.swing.JMenuItem menuPayment;
    private javax.swing.JMenuItem menuPerson;
    private javax.swing.JMenuItem menuReceipt;
    private javax.swing.JMenuItem menuTB;
    private javax.swing.JMenu menubarFile;
    private javax.swing.JMenu menubarLaporan;
    private javax.swing.JMenu menubarMaster;
    private javax.swing.JMenu menubarTransaksi;
    // End of variables declaration//GEN-END:variables


}
