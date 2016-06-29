package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.*;

public class BasicCodeDisplayModel$JCodeDisplayColumnDescription
{
    final String name;
    final int width;
    final Color defaultFontColor;
    final Color defaultBackgroundColor;
    final Font defaultHeaderFont;
    final FormattedCharacterBuffer headerLine;
    
    public BasicCodeDisplayModel$JCodeDisplayColumnDescription(final String name, final int width, final Color defaultFontColor, final Color defaultBackgroundColor, final Font defaultHeaderFont) {
        this.name = name;
        this.width = width;
        this.defaultFontColor = defaultFontColor;
        this.defaultBackgroundColor = defaultBackgroundColor;
        this.defaultHeaderFont = defaultHeaderFont;
        this.headerLine = new FormattedCharacterBuffer(CodeDisplay.padRight(this.name, this.width), this.defaultHeaderFont, this.defaultFontColor, this.defaultBackgroundColor);
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public Color getDefaultFontColor() {
        return this.defaultFontColor;
    }
    
    public Color getDefaultBackgroundColor() {
        return this.defaultBackgroundColor;
    }
    
    public FormattedCharacterBuffer getHeader() {
        return this.headerLine;
    }
}
