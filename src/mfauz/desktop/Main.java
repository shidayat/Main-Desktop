
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfauz.desktop;


import com.artitraining.mfauz.service.AppService;
import java.util.logging.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mfauz.desktop.frame.MainFrame;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Sarip
 */
public class Main {
  private static final Logger log = Logger.getLogger(Main.class.getName());
//    private static ApplicationContext appCtx;
    private static AppService appService;
    private static MainFrame mainFrame;

    public static AppService getAppService() {
        return appService;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * @param args the command line arguments
     * 
     * yang di bikin jadi komen adalah untuk ganti ke konfigurasi three thier. 
     * di POSServer-nya sudah OK (?!) bgmn ceknya(?)
     */
    public static void main(String[] args) {
//      AbstractApplicationContext   ctx = new ClassPathXmlApplicationContext(
//                 "classpath:com/artitraining/mfauz/config/applicationContext.xml");
     AbstractApplicationContext   ctx = new ClassPathXmlApplicationContext("clientContext.xml", Main.class);
      ctx.registerShutdownHook();

     appService = (AppService) ctx.getBean("appService");
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        

        String msg = appService.halo("admin: S.Hidayat");
        log.info("Pesan dari server : "+msg);
   
    }
    

   
    
}
