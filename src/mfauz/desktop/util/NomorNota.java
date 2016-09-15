/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfauz.desktop.util;

import com.artitraining.mfauz.model.Nota;
import java.text.SimpleDateFormat;
import java.util.Date;
import mfauz.desktop.Main;
import org.joda.time.DateTime;

/**
 * 26/04/2014
 * @author Sarip
 */
public class NomorNota  {
    private Nota nota;

public Nota findKodeNotaPolaTahunNomorDiAkhir(String jenisTransaksi)  {
    nota = new Nota();
    nota = Main.getAppService().findNotaAkhir(jenisTransaksi);
    if(nota == null){
       return null;
    }
    String polaTgl=nota.getPolaTgl();
//    int panjangPolaTgl = polaTgl.length();
    String thnIni = new SimpleDateFormat("yy").format(new Date());
//    DateTime now=new DateTime();
//    int bln= now.getMonthOfYear();      

    if(polaTgl == null || polaTgl.isEmpty()) {
    //isi metod nya
        String kodejadiawal=nota.getKodeTetap()+thnIni+"00001";
        nota.setId(nota.getId());
        nota.setLastnumber(1);
        nota.setNotajadi(kodejadiawal);
        nota.setPolaTgl(thnIni);
        return nota;
    } else {  
        int id = nota.getId();
//        int bulan=Integer.parseInt(polaTgl.substring(2, 4));

          String pola = nota.getKodeTetap();
          String thnDB = polaTgl;

                int panjangnol= nota.getBanyakDigit()-String.valueOf(nota.getLastnumber()+1).length();
                int i=0;
                String pjgnol="";
                for (i=0;i<panjangnol;i++){
                    pjgnol=pjgnol+"0";
                     }
          int nomorAkhir = nota.getLastnumber()+1;
          String kodeNot = pola+thnDB+pjgnol+String.valueOf(nomorAkhir);
//          String kodeNota= "";    

        nota = new Nota();  
//        if(bulan == bln) {
           nota.setId(id);   
                nota.setNotajadi(kodeNot);
                nota.setLastnumber(nomorAkhir);
                nota.setPolaTgl(polaTgl);
             return nota;
//        }    

//        else {
//            nota.setId(id);      
//                kodeNota=pola+thnIni+"00001";
//                nota.setNotajadi(kodeNota);
//                nota.setLastnumber(1);
//                nota.setPolaTgl(thnIni);
//             return nota; 
//        } 
    }
}    
    
//ini kodenya pakai tahunbulan
public Nota findKodeNotaNomorDiAkhir(String jenisTransaksi)  {
    nota = new Nota();
    nota = Main.getAppService().findNotaAkhir(jenisTransaksi);
    if(nota == null){
       return null;
    }
    String polaTgl=nota.getPolaTgl();
    String thnblnIni = new SimpleDateFormat("yyMM").format(new Date());
    DateTime now=new DateTime();
    int bln= now.getMonthOfYear();      

    if(polaTgl == null || polaTgl.isEmpty()) {
    //isi metod nya
        String kodejadiawal=nota.getKodeTetap()+thnblnIni+"00001";
        nota.setId(nota.getId());
        nota.setLastnumber(1);
        nota.setNotajadi(kodejadiawal);
        nota.setPolaTgl(thnblnIni);
        return nota;
    } else {  
        int id = nota.getId();
        int bulan=Integer.parseInt(polaTgl.substring(2, 4));

          String pola = nota.getKodeTetap();
          String thnblnDB = polaTgl;

                int panjangnol= nota.getBanyakDigit()-String.valueOf(nota.getLastnumber()+1).length();
                int i=0;
                String pjgnol="";
                for (i=0;i<panjangnol;i++){
                    pjgnol=pjgnol+"0";
                     }
          int nomorAkhir = nota.getLastnumber()+1;
          String kodeNot = pola+thnblnDB+pjgnol+String.valueOf(nomorAkhir);
          String kodeNota= "";    

    //    nota = new Nota();  
        if(bulan == bln) {
           nota.setId(id);   
                nota.setNotajadi(kodeNot);
                nota.setLastnumber(nomorAkhir);
                nota.setPolaTgl(polaTgl);
             return nota;
        }    

        else {
            nota.setId(id);      
                kodeNota=pola+thnblnIni+"00001";
                nota.setNotajadi(kodeNota);
                nota.setLastnumber(1);
                nota.setPolaTgl(thnblnIni);
             return nota; 
        } 
    }
}


//ini polatgl nya pakai tahun aja
  public Nota findKodeNotaNomorDiAwal(String jenisDokumen) {
    nota = new Nota();
    nota = Main.getAppService().findNotaAkhir(jenisDokumen);
    if(nota == null){
        return null;
    }
    String polaTgl=nota.getPolaTgl();
    DateTime now=new DateTime();
    int thnIni=now.getYear();
    if(polaTgl == null || polaTgl.isEmpty()) {
    //isi metod nya
        String kodejadiawal="0001"+nota.getKodeTetap()+String.valueOf(thnIni);
        nota.setId(nota.getId());
        nota.setLastnumber(1);
        nota.setNotajadi(kodejadiawal);
        nota.setPolaTgl(String.valueOf(thnIni));
        return nota;
    
    } else {  
        int id = nota.getId();

          String kodetetap = nota.getKodeTetap();

                int panjangnol= nota.getBanyakDigit()-String.valueOf(nota.getLastnumber()+1).length();
                int i=0;
                String pjgnol="";
                for (i=0;i<panjangnol;i++){
                    pjgnol=pjgnol+"0";
                     }
          int nomorAkhir = nota.getLastnumber()+1;
          String kodeNot = pjgnol+String.valueOf(nomorAkhir)+kodetetap+polaTgl;

           nota.setId(id);   
                nota.setNotajadi(kodeNot);
                nota.setLastnumber(nomorAkhir);
                nota.setPolaTgl(polaTgl);
             return nota;
      }
  }
  
  
}
