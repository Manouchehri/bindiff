package com.google.security.zynamics.bindiff.gui.components;

import java.awt.*;
import javax.swing.*;

public class MessageBox
{
    private static Component validateParent(final Component component) {
        if (isIconified(component)) {
            return null;
        }
        return component;
    }
    
    public static boolean isIconified(final Component component) {
        return component != null && component instanceof Frame && (((Frame)component).getExtendedState() == 1 || ((Frame)component).getExtendedState() == 7);
    }
    
    public static void showError(final Component component, final String s) {
        JOptionPane.showMessageDialog(validateParent(component), s, "BinDiff", 0);
    }
    
    public static void showInformation(final Component component, final String s) {
        JOptionPane.showMessageDialog(validateParent(component), s, "BinDiff", 1);
    }
    
    public static void showWarning(final Component component, final String s) {
        JOptionPane.showMessageDialog(validateParent(component), s, "BinDiff", 2);
    }
    
    public static int showYesNoCancelQuestion(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(validateParent(component), s, "BinDiff", 1, 3);
    }
    
    public static int showYesNoError(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(validateParent(component), s, "BinDiff", 0, 0);
    }
    
    public static int showYesNoQuestion(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(validateParent(component), s, "BinDiff", 0, 3);
    }
    
    public static int showYesNoWarning(final Component component, final String s) {
        return JOptionPane.showConfirmDialog(validateParent(component), s, "BinDiff", 0, 2);
    }
}
