/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.general.Pair;
import java.awt.Component;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public final class CMessageBox {
    public static final String DEFAULT_WINDOW_TITLE_PROPERTY = String.valueOf(CMessageBox.class.getCanonicalName()).concat(".DEFAULT_WINDOW_TITLE");

    private CMessageBox() {
    }

    private static boolean isIconified(Component component) {
        if (component == null) return false;
        if (!(component instanceof Frame)) return false;
        if ((((Frame)component).getExtendedState() & 1) == 0) return false;
        return true;
    }

    public static int showCustomQuestionMessageBox(Component component, String string, String string2, JButton[] arrjButton, JButton jButton) {
        return JOptionPane.showOptionDialog(component, string, string2, -1, 3, null, arrjButton, jButton);
    }

    public static void showError(Component component, String string) {
        JOptionPane.showMessageDialog(CMessageBox.isIconified(component) ? null : component, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0);
    }

    public static void showInformation(Component component, String string) {
        JOptionPane.showMessageDialog(CMessageBox.isIconified(component) ? null : component, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 1);
    }

    public static void showWarning(Component component, String string) {
        JOptionPane.showMessageDialog(CMessageBox.isIconified(component) ? null : component, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 2);
    }

    public static int showYesNoCancelQuestion(Component component, String string) {
        Component component2;
        if (CMessageBox.isIconified(component)) {
            component2 = null;
            return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 1, 3);
        }
        component2 = component;
        return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 1, 3);
    }

    public static int showYesNoError(Component component, String string) {
        Component component2;
        if (CMessageBox.isIconified(component)) {
            component2 = null;
            return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 0);
        }
        component2 = component;
        return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 0);
    }

    public static int showYesNoQuestion(Component component, String string) {
        return (Integer)CMessageBox.showYesNoQuestionWithCheckbox(component, string, null).first();
    }

    public static Pair showYesNoQuestionWithCheckbox(Component component, String arrobject, String string) {
        Object[] arrobject2;
        boolean bl2;
        JCheckBox jCheckBox = null;
        if (string != null) {
            jCheckBox = new JCheckBox(string);
            arrobject2 = new Object[]{arrobject, jCheckBox};
        } else {
            arrobject2 = arrobject;
        }
        int n2 = JOptionPane.showConfirmDialog(CMessageBox.isIconified(component) ? null : component, arrobject2, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 3);
        if (string != null) {
            bl2 = jCheckBox.isSelected();
            return Pair.make(n2, bl2);
        }
        bl2 = false;
        return Pair.make(n2, bl2);
    }

    public static int showYesNoWarning(Component component, String string) {
        Component component2;
        if (CMessageBox.isIconified(component)) {
            component2 = null;
            return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 2);
        }
        component2 = component;
        return JOptionPane.showConfirmDialog(component2, string, System.getProperty(DEFAULT_WINDOW_TITLE_PROPERTY), 0, 2);
    }
}

