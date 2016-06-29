/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import com.google.security.zynamics.zylib.gui.CodeDisplay.CodeDisplay;
import com.google.security.zynamics.zylib.gui.CodeDisplay.FormattedCharacterBuffer;
import java.awt.Color;
import java.awt.Font;

public class BasicCodeDisplayModel$JCodeDisplayColumnDescription {
    final String name;
    final int width;
    final Color defaultFontColor;
    final Color defaultBackgroundColor;
    final Font defaultHeaderFont;
    final FormattedCharacterBuffer headerLine;

    public BasicCodeDisplayModel$JCodeDisplayColumnDescription(String string, int n2, Color color, Color color2, Font font) {
        this.name = string;
        this.width = n2;
        this.defaultFontColor = color;
        this.defaultBackgroundColor = color2;
        this.defaultHeaderFont = font;
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

