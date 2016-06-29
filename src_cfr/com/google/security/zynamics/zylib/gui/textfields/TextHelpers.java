/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class TextHelpers {
    public static int getLineAtCaret(JTextComponent jTextComponent) {
        int n2 = jTextComponent.getCaretPosition();
        Element element = jTextComponent.getDocument().getDefaultRootElement();
        return element.getElementIndex(n2) + 1;
    }

    public static int getNumberOfLines(JTextComponent jTextComponent) {
        Element element = jTextComponent.getDocument().getDefaultRootElement();
        return element.getElementCount();
    }

    public static void insert(JTextComponent jTextComponent, int n2, String string) {
        String string2 = jTextComponent.getText();
        String string3 = String.valueOf(string2.substring(0, n2));
        String string4 = String.valueOf(string2.substring(n2));
        jTextComponent.setText(new StringBuilder(0 + String.valueOf(string3).length() + String.valueOf(string).length() + String.valueOf(string4).length()).append(string3).append(string).append(string4).toString());
    }

    public static void insert(JTextComponent jTextComponent, String string) {
        int n2 = jTextComponent.getSelectionStart();
        TextHelpers.insert(jTextComponent, n2, string);
        jTextComponent.setSelectionStart(n2 + string.length());
        jTextComponent.setSelectionEnd(n2 + string.length());
    }
}

