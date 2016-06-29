/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.imagecombobox;

import com.google.security.zynamics.zylib.gui.imagecombobox.ImageElement;
import com.google.security.zynamics.zylib.gui.imagecombobox.JImageComboBox$ComboBoxRenderer;
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;

public class JImageComboBox
extends JComboBox {
    public JImageComboBox(ImageElement[] arrimageElement) {
        super(arrimageElement);
        this.setRenderer(new JImageComboBox$ComboBoxRenderer(0));
    }

    public JImageComboBox(ImageElement[] arrimageElement, int n2) {
        super(arrimageElement);
        if (n2 != 2 && n2 != 0 && n2 != 4) {
            throw new IllegalArgumentException("Erorr: Label alignment in invalid.");
        }
        this.setRenderer(new JImageComboBox$ComboBoxRenderer(n2));
    }
}

