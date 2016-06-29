package com.google.security.zynamics.zylib.gui.textfields;

import javax.swing.text.*;

public class TextHelpers
{
    public static int getLineAtCaret(final JTextComponent textComponent) {
        return textComponent.getDocument().getDefaultRootElement().getElementIndex(textComponent.getCaretPosition()) + 1;
    }
    
    public static int getNumberOfLines(final JTextComponent textComponent) {
        return textComponent.getDocument().getDefaultRootElement().getElementCount();
    }
    
    public static void insert(final JTextComponent textComponent, final int n, final String s) {
        final String text = textComponent.getText();
        final String value = String.valueOf(text.substring(0, n));
        final String value2 = String.valueOf(text.substring(n));
        textComponent.setText(new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(s).length() + String.valueOf(value2).length()).append(value).append(s).append(value2).toString());
    }
    
    public static void insert(final JTextComponent textComponent, final String s) {
        final int selectionStart = textComponent.getSelectionStart();
        insert(textComponent, selectionStart, s);
        textComponent.setSelectionStart(selectionStart + s.length());
        textComponent.setSelectionEnd(selectionStart + s.length());
    }
}
