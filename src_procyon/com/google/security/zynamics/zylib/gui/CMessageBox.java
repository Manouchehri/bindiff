package com.google.security.zynamics.zylib.gui;

import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;

public final class CMessageBox
{
    public static final String DEFAULT_WINDOW_TITLE_PROPERTY;
    
    private static boolean isIconified(final Component component) {
        return component != null && component instanceof Frame && (((Frame)component).getExtendedState() & 0x1) != 0x0;
    }
    
    public static int showCustomQuestionMessageBox(final Component component, final String s, final String s2, final JButton[] array, final JButton button) {
        return JOptionPane.showOptionDialog(component, s, s2, -1, 3, null, array, button);
    }
    
    public static void showError(final Component component, final String s) {
        JOptionPane.showMessageDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 0);
    }
    
    public static void showInformation(final Component component, final String s) {
        JOptionPane.showMessageDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 1);
    }
    
    public static void showWarning(final Component component, final String s) {
        JOptionPane.showMessageDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 2);
    }
    
    public static int showYesNoCancelQuestion(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 1, 3);
    }
    
    public static int showYesNoError(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 0, 0);
    }
    
    public static int showYesNoQuestion(final Component component, final String s) {
        return (int)showYesNoQuestionWithCheckbox(component, s, null).first();
    }
    
    public static Pair showYesNoQuestionWithCheckbox(final Component component, final String s, final String s2) {
        AbstractButton abstractButton = null;
        Object o;
        if (s2 != null) {
            abstractButton = new JCheckBox(s2);
            o = new Object[] { s, abstractButton };
        }
        else {
            o = s;
        }
        return Pair.make(JOptionPane.showConfirmDialog(isIconified(component) ? null : component, o, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 0, 3), s2 != null && abstractButton.isSelected());
    }
    
    public static int showYesNoWarning(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(isIconified(component) ? null : component, s, System.getProperty(CMessageBox.DEFAULT_WINDOW_TITLE_PROPERTY), 0, 2);
    }
    
    static {
        DEFAULT_WINDOW_TITLE_PROPERTY = String.valueOf(CMessageBox.class.getCanonicalName()).concat(".DEFAULT_WINDOW_TITLE");
    }
}
