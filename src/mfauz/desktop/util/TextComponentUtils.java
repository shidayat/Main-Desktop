
package mfauz.desktop.util;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.springframework.util.StringUtils;
import mfauz.desktop.Main;
import java.awt.Rectangle;


/** TextComponentUtils ini adalah utility yang bertugas untuk mengatur segala
 * keperluan pada Component JTextField. Behaviour yang terdapat pada class ini
 * adalah sebagai berikut :
 *
 * @author martin
 */
public class TextComponentUtils {

    private static final String BAD_CHARS = "-`~!@#$%^&*()_+=\\|\"':;?/>.<, \n";
    
 public static void scrollToRect(JTable table,int nextSelectedRow){
        Rectangle currentVisible = table.getVisibleRect();
        Rectangle scrollToRect = table.getCellRect(nextSelectedRow, 0, true);
        if(scrollToRect.getY() > currentVisible.getY() + currentVisible.getHeight()){
            scrollToRect.setLocation(0,
                    (int)(scrollToRect.getY() + currentVisible.getHeight() - scrollToRect.getHeight()));
        }
        table.scrollRectToVisible(scrollToRect);
    }

    /** TextComponentUtils.setMaximumLength()
     */
    //ni utk textfield
    public static void setMaximumLength(final int maximumChar,
            final javax.swing.JTextField textField) {      
        textField.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                limitAction(textField, evt, maximumChar);
            }
        });
    }
    //ni utk textarea
    public static void setMaximumLength(final int maximumChar,
            final javax.swing.JTextArea textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                limitAction(textField, evt, maximumChar);
            }
        });
    }

    public static void setAutoUpperCaseText(final int maxChar,
            final javax.swing.JTextField textField) {
        setMaximumLength(maxChar, textField);
        setAutoUpperCaseText(textField);
    }

    public static void setAutoUpperCaseText(final int maxChar,
            final javax.swing.JTextArea textField) {
        setMaximumLength(maxChar, textField);
        setAutoUpperCaseText(textField);
    }

        public static void setAutoUpperCaseText(final javax.swing.JTextField textField) {
        textField.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    convertToUpperCase((JTextField) e.getSource());
                }
            }
        });
    }
    public static void setAutoUpperCaseText(final javax.swing.JTextArea textArea) {
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (Character.isLetter(e.getKeyChar())) {
                    convertToUpperCase((JTextArea) e.getSource());
                }
            }
        });
    }

    
    public static void setNumericTextOnly(final javax.swing.JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                if (!Character.isDigit(evt.getKeyChar()) ||
                    BAD_CHARS.indexOf(evt.getKeyChar()) > -1) {
                        evt.consume();
                    }
                }
        });
    }

    public static JTextField setCurrency(JTextField textField){
        textField.addKeyListener(new IntegerMasking());
        return textField;
    }

//    private static void setAutoUpperCaseText(final javax.swing.JTextField textField) {
//        textField.addKeyListener(new java.awt.event.KeyAdapter() {
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (Character.isLetter(e.getKeyChar())) {
//                    convertToUpperCase((JTextField) e.getSource());
//                }
//            }
//        });
//    }
//    private static void setAutoUpperCaseText(final javax.swing.JTextArea textArea) {
//        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if (Character.isLetter(e.getKeyChar())) {
//                    convertToUpperCase((JTextArea) e.getSource());
//                }
//            }
//        });
//    }


    private static void limitAction(final javax.swing.JTextField textField,
            java.awt.event.KeyEvent keyEvent, int maxLength) {

        if (textField.getText().length() + 1 > maxLength) {
            keyEvent.consume();
        }
    }
    
    private static void limitAction(final javax.swing.JTextArea textField,
            java.awt.event.KeyEvent keyEvent, int maxLength) {

        if (textField.getText().length() + 1 > maxLength) {
            keyEvent.consume();
        }
    }
    
    private static void convertToUpperCase(final javax.swing.JTextField textField) {
        textField.setText(textField.getText().toUpperCase());
    }
    private static void convertToUpperCase(final javax.swing.JTextArea textField) {
        textField.setText(textField.getText().toUpperCase());
    }

    private static class IntegerMasking implements KeyListener {

        public void keyTyped(KeyEvent evt) {
            JTextField source = (JTextField) evt.getSource();
            if(Locale.getDefault() == Locale.US){
                if (Character.isLetter(evt.getKeyChar()) ||
                        BAD_CHARS.indexOf(evt.getKeyChar()) >= 0) {
                    if(evt.getKeyChar()!='.' || source.getText().indexOf('.') >= 0){
                        evt.consume();
                    }
                }
            } else {
                if (Character.isLetter(evt.getKeyChar()) ||
                        BAD_CHARS.indexOf(evt.getKeyChar()) >= 0 ) {
                    if(evt.getKeyChar()!=',' || source.getText().indexOf(',') >= 0){
                        evt.consume();
                    }
                }

            }
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent evt) {
            if(evt.getKeyCode() == KeyEvent.VK_LEFT
                    || evt.getKeyCode() == KeyEvent.VK_RIGHT){
                return;
            }
            if (evt.getSource() instanceof JTextField ) {
                JTextField textField = (JTextField) evt.getSource();
                int caretPosition = textField.getCaretPosition();
                int initialLentgh = textField.getText()!=null ? textField.getText().length() : 0;
                String formatedNumber = formatNumber(textField.getText());
                textField.setText(formatedNumber);
                if(formatedNumber.length() > initialLentgh){
                    textField.setCaretPosition(caretPosition + 1);
                }
            }
        }
    }

    public static String formatNumber(BigDecimal value){
        if(value == null || value.equals(BigDecimal.ZERO)){
            return "0";
        } else {
            NumberFormat formatter = NumberFormat.getInstance();
            formatter.setMinimumFractionDigits(2); //min disamakan dg max spy tampilan o dec. jg sama 2 digit dec
            formatter.setMaximumFractionDigits(2); //asalnya 0
            return formatter.format(value.setScale(2, RoundingMode.HALF_EVEN)); //2 asalnya 0
            //cattn: ketika ketik qty lebih dr 2 digit decimal, ditampilkan 2 digit(dibulatkan)
            //tapi hitungan subtotal dihitung sbelum pembulatan qty==> Harus dikoreksi
            //dengan pembatasan ketikan digit decimal maksimal 2.
        }
    }

    public static String formatNumberId(BigDecimal value){
        if(value == null || value.equals(BigDecimal.ZERO)){
            return "0";
        } else {
            NumberFormat formatter = NumberFormat.getInstance(new Locale("ID"));
            formatter.setMinimumFractionDigits(0);
            formatter.setMaximumFractionDigits(2);
            return formatter.format(value.setScale(2, RoundingMode.HALF_EVEN));
        }
    }

    public static String formatNumber(String text){
        char thousandsSeparator = '.';
        char decimalSeparator = ',';
        if(Locale.getDefault().equals(Locale.US)){
            thousandsSeparator = ',';
            decimalSeparator = '.';
        } else if(Locale.getDefault().getCountry().equalsIgnoreCase("INDONESIA")
                && Locale.getDefault().getLanguage().equalsIgnoreCase("ID")){
            thousandsSeparator = '.';
            decimalSeparator = ',';
        }
        StringBuilder builder = new StringBuilder();
        boolean isDecimalSeparatorFound = false;
        for (Character c : text.toCharArray()) {
            if (c != thousandsSeparator) {
                builder.append(c);
                if(c == decimalSeparator ){
                    isDecimalSeparatorFound = true;
                }
            }
        }
        char[] arr = builder.toString().toCharArray();
        StringBuilder builder1 = new StringBuilder();
        int maxIndex = arr.length - 1;
        //mengambil pecahan
        int i=0;
        int decimalSeparatorIndex = 0;
        if(isDecimalSeparatorFound){
            for(;i<=maxIndex;i++){
                char c = arr[maxIndex - i];
                if(c!=decimalSeparator){
                    builder1.append(c);
                } else {
                    isDecimalSeparatorFound = false;
                    break;
                }
            }
            builder1.append(arr[maxIndex - i++]);
            decimalSeparatorIndex = i;
        }
        for (i=0; i <= maxIndex - decimalSeparatorIndex; i++) {
            char c = arr[maxIndex - i - decimalSeparatorIndex];
            if (i != 0 && i % 3 == 0 ) {
                builder1.append(thousandsSeparator);
                builder1.append(c);
            } else {
                builder1.append(c);
            }
        }
        StringBuilder builder2 = new StringBuilder();
        char[] arr2 = builder1.toString().toCharArray();
        maxIndex = arr2.length - 1;
        for (i = 0; i <= maxIndex; i++) {
            char c = arr2[maxIndex - i];
            builder2.append(c);
        }
        return builder2.toString();
    }
    
    public static BigDecimal parseNumberToBigDecimal(String text){
        if(!StringUtils.hasText(text)) return BigDecimal.ZERO;
        try {
            NumberFormat numberFormat= NumberFormat.getInstance(Locale.US);
            BigDecimal number = new BigDecimal(numberFormat.parse(text).doubleValue());
            return number;
        } catch (ParseException ex) {
            if(Locale.US == Locale.getDefault()){
                JOptionPane.showMessageDialog(Main.getMainFrame(), "Regional setting anda menggunakan US. Pemisah ribuan adalah . (titik) dan pemisah pecahan adalah , (koma)");
            } else if(Locale.getDefault().getCountry().equalsIgnoreCase("INDONESIA")
                    && Locale.getDefault().getLanguage().equalsIgnoreCase("ID")) {
                JOptionPane.showMessageDialog(Main.getMainFrame(), "Regional setting anda menggunakan Indonesia. Pemisah ribuan adalah , (koma) dan pemisah pecahan adalah . (titik)");
            }
        }
        return null;
    }
}