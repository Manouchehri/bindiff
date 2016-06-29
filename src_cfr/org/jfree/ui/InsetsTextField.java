/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Insets;
import java.util.ResourceBundle;
import javax.swing.JTextField;

public class InsetsTextField
extends JTextField {
    protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

    public InsetsTextField(Insets insets) {
        this.setInsets(insets);
        this.setEnabled(false);
    }

    public String formatInsetsString(Insets insets) {
        insets = insets == null ? new Insets(0, 0, 0, 0) : insets;
        return new StringBuffer().append(localizationResources.getString("T")).append(insets.top).append(", ").append(localizationResources.getString("L")).append(insets.left).append(", ").append(localizationResources.getString("B")).append(insets.bottom).append(", ").append(localizationResources.getString("R")).append(insets.right).toString();
    }

    public void setInsets(Insets insets) {
        this.setText(this.formatInsetsString(insets));
    }
}

