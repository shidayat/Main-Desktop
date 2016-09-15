/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfauz.desktop.frame;

import com.artitraining.mfauz.model.Nota;
import com.artitraining.mfauz.model.Person;
import com.artitraining.mfauz.service.AppService;
import java.util.List;
import mfauz.desktop.util.NomorNota;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ASUS
 */
public class tes  {
    private static ApplicationContext appCtx;
    private static AppService appService;
//    static Nota kodeNota;
    /**
     * @param args the command line arguments
     */
private static void  getTes() {
  List<Person> listPerson = appService.findPersonListNama("SURYADI");
  for(Person p : listPerson){
    System.out.println(" person = "+p.getNama()+"-"+p.getKomitmen()+"-"+p.getPembayaranTahunIni());

  }
}
    public static void main(String[] args) {
        appCtx = new ClassPathXmlApplicationContext(
                "classpath:com/artitraining/mfauz/config/applicationContext.xml");

        //bikin object interface AppService sehingga ServiceImpl bisa dieksekusi di sini
        //di class AppService ada @Service
        appService = (AppService) appCtx.getBean("appService");        
        
getTes();
        
}
       
        
    
    
    
    
       
}
