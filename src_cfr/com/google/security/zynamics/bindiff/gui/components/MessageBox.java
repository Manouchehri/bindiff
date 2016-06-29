/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components;

import java.awt.Component;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class MessageBox {
    private static Component validateParent(Component component) {
        if (!MessageBox.isIconified(component)) return component;
        return null;
    }

    public static boolean isIconified(Component component) {
        if (component == null) return false;
        if (!(component instanceof Frame)) return false;
        if (((Frame)component).getExtendedState() == 1) return true;
        if (((Frame)component).getExtendedState() == 7) return true;
        return false;
    }

    public static void showError(Component component, String string) {
        JOptionPane.showMessageDialog(MessageBox.validateParent(component), string, "BinDiff", 0);
    }

    public static void showInformation(Component component, String string) {
        JOptionPane.showMessageDialog(MessageBox.validateParent(component), string, "BinDiff", 1);
    }

    public static void showWarning(Component component, String string) {
        JOptionPane.showMessageDialog(MessageBox.validateParent(component), string, "BinDiff", 2);
    }

    public static int showYesNoCancelQuestion(Component component, String string) {
        return JOptionPane.showConfirmDialog(MessageBox.validateParent(component), string, "BinDiff", 1, 3);
    }

    public static int showYesNoError(Component component, String string) {
        return JOptionPane.showConfirmDialog(MessageBox.validateParent(component), string, "BinDiff", 0, 0);
    }

    public static int showYesNoQuestion(Component component, String string) {
        return JOptionPane.showConfirmDialog(MessageBox.validateParent(component), string, "BinDiff", 0, 3);
    }

    public static int showYesNoWarning(Component component, String string) {
        return JOptionPane.showConfirmDialog(MessageBox.validateParent(component), string, "BinDiff", 0, 2);
    }
}

