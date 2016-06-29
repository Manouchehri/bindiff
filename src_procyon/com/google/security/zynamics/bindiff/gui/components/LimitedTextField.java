package com.google.security.zynamics.bindiff.gui.components;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.textfields.*;
import javax.swing.text.*;

public class LimitedTextField extends JTextPane
{
    public LimitedTextField(final String text) {
        super(new JTextFieldLimit(30000));
        this.setText(text);
    }
}
