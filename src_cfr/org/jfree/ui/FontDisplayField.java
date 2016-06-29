/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Font;
import java.util.ResourceBundle;
import javax.swing.JTextField;

public class FontDisplayField
extends JTextField {
    private Font displayFont;
    protected static final ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");

    public FontDisplayField(Font font) {
        super("");
        this.setDisplayFont(font);
        this.setEnabled(false);
    }

    public Font getDisplayFont() {
        return this.displayFont;
    }

    public void setDisplayFont(Font font) {
        this.displayFont = font;
        this.setText(this.fontToString(this.displayFont));
    }

    private String fontToString(Font font) {
        if (font == null) return localizationResources.getString("No_Font_Selected");
        return new StringBuffer().append(font.getFontName()).append(", ").append(font.getSize()).toString();
    }
}

