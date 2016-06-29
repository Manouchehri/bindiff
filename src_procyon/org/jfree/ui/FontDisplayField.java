package org.jfree.ui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class FontDisplayField extends JTextField
{
    private Font displayFont;
    protected static final ResourceBundle localizationResources;
    
    public FontDisplayField(final Font displayFont) {
        super("");
        this.setDisplayFont(displayFont);
        this.setEnabled(false);
    }
    
    public Font getDisplayFont() {
        return this.displayFont;
    }
    
    public void setDisplayFont(final Font displayFont) {
        this.displayFont = displayFont;
        this.setText(this.fontToString(this.displayFont));
    }
    
    private String fontToString(final Font font) {
        if (font != null) {
            return font.getFontName() + ", " + font.getSize();
        }
        return FontDisplayField.localizationResources.getString("No_Font_Selected");
    }
    
    static {
        localizationResources = ResourceBundle.getBundle("org.jfree.ui.LocalizationBundle");
    }
}
