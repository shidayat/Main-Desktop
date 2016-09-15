/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfauz.desktop.util;

/**
 *
 * @author dari buku miftakhulhuda
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FormUtil{

     private static Frame jMainFrame=null;

     public static void setMainFrame(Frame value){
            jMainFrame=value;
      }

     public static Frame getMainFrame(){
         return jMainFrame;
     }
     
     static class EventPump implements InvocationHandler{
        Frame frame;



        public EventPump(Frame frame){
            this.frame = frame;
        }

        public Object invoke(Object proxy, Method method, 
                Object[] args) throws Throwable {
            return frame.isShowing() ? Boolean.TRUE : Boolean.FALSE;
        }

        public void start() throws Exception{
            Class clazz = Class.forName("java.awt.Conditional");
            Object conditional = Proxy.newProxyInstance(
                    clazz.getClassLoader(),
                    new Class[]{clazz},
                    this);
            Method pumpMethod = Class.forName("java.awt.EventDispatchThread")
                    .getDeclaredMethod("pumpEvents", new Class[]{clazz});
            pumpMethod.setAccessible(true);
            pumpMethod.invoke(Thread.currentThread(), new Object[]{conditional});
        }
    }

    public static void showAsModal(final Frame frame){
        frame.addWindowListener(new WindowAdapter(){
            public void windowOpened(WindowEvent e){
                jMainFrame.setEnabled(false);
            }

            public void windowClosed(WindowEvent e){

                jMainFrame.setEnabled(true);
                frame.removeWindowListener(this);
                jMainFrame.toFront();
            }
        });

        jMainFrame.addWindowListener(new WindowAdapter(){
            public void windowActivated(WindowEvent e){
                if(frame.isShowing()){
                    frame.setExtendedState(JFrame.NORMAL);
                    frame.toFront();
                }else
                    jMainFrame.removeWindowListener(this);
            }
        });

        frame.setVisible(true);
        try{
            new EventPump(frame).start();
        } catch(Throwable throwable){
            throw new RuntimeException(throwable);
        }
    }
    
    public static void centerWindow(Component cp){
        Dimension screenSize =
                    Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = cp.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }

            int a, b;
            a=(screenSize.width - frameSize.width  ) / 2;
            b=(screenSize.height - 77 - frameSize.height ) / 2;            
            cp.setLocation(a,b);
   }

    public static void centerWindowChild(Component cp){

        Dimension frameMain =FormUtil.getMainFrame().getSize();

            Dimension frameSize = cp.getSize();
            if (frameSize.height+77 + 33 > frameMain.height) {

                frameSize.height = frameMain.height-77 -33;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);
            }
            
            if (frameSize.width > frameMain.width-10) {

                frameSize.width = frameMain.width-10;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);

            }

            int a, b;
            a=((frameMain.width - frameSize.width  ) / 2) ;
            b=((frameMain.height - 77 - frameSize.height ) / 2);

            cp.setLocation(a,b);
   }

    public static void centerWindowChild(Component cp, boolean vResizeAble){

        Dimension frameMain =FormUtil.getMainFrame().getSize();

            Dimension frameSize = cp.getSize();

            if (frameSize.height+77 > frameMain.height && vResizeAble) {

                frameSize.height = frameMain.height-77;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);
            }

            if (frameSize.width > frameMain.width-10 && vResizeAble) {

                frameSize.width = frameMain.width-10;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);

            }

            int a, b;
            a=((frameMain.width - frameSize.width  ) / 2) ;
            b=((frameMain.height - 77 - frameSize.height ) / 2);

            cp.setLocation(a,b);
   }

    public static void centerWindowFrame(Component cp){

        Dimension frameMain =FormUtil.getMainFrame().getSize();

            Dimension frameSize = cp.getSize();
            if (frameSize.height+77 > frameMain.height) {

                frameSize.height = frameMain.height-77;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);
            }

            if (frameSize.width > frameMain.width-10) {

                frameSize.width = frameMain.width-10;

                cp.setSize(
                    frameSize.width,
                    frameSize.height);

            }

            Dimension screenSize =
                    Toolkit.getDefaultToolkit().getScreenSize();

            int a, b;

            a=((screenSize.width - frameMain.width - frameSize.width  ) / 2) ;
            b=((screenSize.height- frameMain.height - 77 - frameSize.height ) / 2);
            
            cp.setLocation(a,b);
   }

    public static void setMaximize(Component cp){


        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();

        cp.setSize(
                screenSize.width,
                screenSize.height);

        cp.setLocation(0,0);
   }
}