/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components;

import com.google.security.zynamics.zylib.gui.textfields.JTextFieldLimit;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class LimitedTextField
extends JTextPane {
    public LimitedTextField(String string) {
        super(new JTextFieldLimit(30000));
        this.setText(string);
    }
}

