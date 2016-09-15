/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mfauz.desktop.util;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.openide.util.Exceptions;

/**
 *
 * @author Sarip
 * Implements a cell editor that uses a formatted text field
 * to edit Integer values.
 */
public class DoubleEditor extends DefaultCellEditor {
    JFormattedTextField ftf;
    NumberFormat doubleFormat;
    private double minimum, maximum;
    private boolean DEBUG = false;
    public DoubleEditor(double min, double max)  {
        super(new JFormattedTextField());
        ftf = (JFormattedTextField)getComponent();
        minimum = new Double(min);
        maximum = new Double(max);
 
        //Set up the editor for the integer cells.
        doubleFormat = NumberFormat.getCurrencyInstance();
        NumberFormatter dobelFormatter = new NumberFormatter(doubleFormat);

        dobelFormatter.setMinimum(minimum);
        dobelFormatter.setMaximum(maximum);
      
        ftf.setFormatterFactory(
                new DefaultFormatterFactory(dobelFormatter));
        ftf.setValue(minimum);
        ftf.setHorizontalAlignment(JTextField.RIGHT);
        ftf.setFocusLostBehavior(JFormattedTextField.PERSIST);
 
        //React when the user presses Enter while the editor is
        //active.  (Tab is handled as specified by
        //JFormattedTextField's focusLostBehavior property.)
        ftf.getInputMap().put(KeyStroke.getKeyStroke(
                                        KeyEvent.VK_ENTER, 0),
                                        "check");
        ftf.getActionMap().put("check", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
        if (!ftf.isEditValid()) { //The text is invalid.
                    if (userSaysRevert()) { //reverted
                ftf.postActionEvent(); //inform the editor
            }
                } else try {              //The text is valid,
                    ftf.commitEdit();     //so use it.
                    ftf.postActionEvent(); //stop editing
                } catch (java.text.ParseException exc) { }
            }
        });
    }
 
    //Override to invoke setValue on the formatted text field.
    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected,
            int row, int column) {
        JFormattedTextField ftf =
            (JFormattedTextField)super.getTableCellEditorComponent(
                table, value, isSelected, row, column);
        ftf.setValue(value);
        return ftf;
    }
 
    //Override to ensure that the value remains an Integer.
    @Override
    public Object getCellEditorValue() {
        JFormattedTextField ftf = (JFormattedTextField)getComponent();
        Object o = ftf.getValue();
        if (o instanceof Double) {
            return o;
        } else if (o instanceof Number) {
            return new Double(((Number)o).intValue());
        } else {
            if (DEBUG) {
                System.out.println("getCellEditorValue: o isn't a Number");
            }
            try {
                    return doubleFormat.parseObject(o.toString());
                } catch (java.text.ParseException ex) {
                    Exceptions.printStackTrace(ex);
                System.err.println("getCellEditorValue: can't parse o: " + o);
                return null;
                }
            }
        }
 
    //Override to check whether the edit is valid,
    //setting the value if it is and complaining if
    //it isn't.  If it's OK for the editor to go
    //away, we need to invoke the superclass's version 
    //of this method so that everything gets cleaned up.
    @Override
    public boolean stopCellEditing() {
        JFormattedTextField ftf = (JFormattedTextField)getComponent();
        if (ftf.isEditValid()) {
            try {
                ftf.commitEdit();
            } catch (java.text.ParseException exc) { }
         
        } else { //text is invalid
            if (!userSaysRevert()) { //user wants to edit
            return false; //don't let the editor go away
        } 
        }
        return super.stopCellEditing();
    }
 
    /** 
     * Lets the user know that the text they entered is 
     * bad. Returns true if the user elects to revert to
     * the last good value.  Otherwise, returns false, 
     * indicating that the user wants to continue editing.
     */
    protected boolean userSaysRevert() {
        Toolkit.getDefaultToolkit().beep();
        ftf.selectAll();
        Object[] options = {"Edit",
                            "Revert"};
        int answer = JOptionPane.showOptionDialog(
            SwingUtilities.getWindowAncestor(ftf),
            "The value must be an integer between "
            + minimum + " and "
            + maximum + ".\n"
            + "You can either continue editing "
            + "or revert to the last valid value.",
            "Invalid Text Entered",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            options,
            options[1]);
         
        if (answer == 1) { //Revert!
            ftf.setValue(ftf.getValue());
        return true;
        }
    return false;
    }

}
