package com.google.security.zynamics.zylib.gui.imagecombobox;

import javax.swing.*;

public class JImageComboBox extends JComboBox
{
    public JImageComboBox(final ImageElement[] array) {
        super(array);
        this.setRenderer(new JImageComboBox$ComboBoxRenderer(0));
    }
    
    public JImageComboBox(final ImageElement[] array, final int n) {
        super(array);
        if (n != 2 && n != 0 && n != 4) {
            throw new IllegalArgumentException("Erorr: Label alignment in invalid.");
        }
        this.setRenderer(new JImageComboBox$ComboBoxRenderer(n));
    }
}
