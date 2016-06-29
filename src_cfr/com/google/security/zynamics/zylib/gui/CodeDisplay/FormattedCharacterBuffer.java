/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class FormattedCharacterBuffer {
    private char[] charBuffer = new char[0];
    private Font[] perCharFonts = new Font[0];
    private static final Font DEFAULT_FONT = new Font("Monospaced", 0, 12);
    private Color[] perCharForegroundColor = new Color[0];
    private Color defaultForegroundColor = Color.BLACK;
    private Color[] perCharBackgroundColor = new Color[0];
    private Color defaultBackgroundColor = Color.WHITE;
    private int numberOfLinesInBuffer;
    private int numberOfColumnsInBuffer;

    public FormattedCharacterBuffer(int n2, int n3) {
        this.numberOfLinesInBuffer = n2;
        this.numberOfColumnsInBuffer = n3;
        this.charBuffer = new char[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharFonts = new Font[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharForegroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharBackgroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.clear();
    }

    public void clear() {
        int n2 = 0;
        while (n2 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer) {
            this.charBuffer[n2] = 32;
            this.perCharFonts[n2] = DEFAULT_FONT;
            this.perCharForegroundColor[n2] = this.defaultForegroundColor;
            this.perCharBackgroundColor[n2] = this.defaultBackgroundColor;
            ++n2;
        }
    }

    public FormattedCharacterBuffer(String string, Font font, Color color, Color color2) {
        this(1, string.length());
        int n2 = 0;
        while (n2 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer) {
            this.charBuffer[n2] = string.charAt(n2) == '\n' ? 95 : (int)string.charAt(n2);
            this.perCharFonts[n2] = font;
            this.perCharForegroundColor[n2] = color;
            this.perCharBackgroundColor[n2] = color2;
            ++n2;
        }
    }

    public int getNumberOfColumns() {
        return this.numberOfColumnsInBuffer;
    }

    public int getNumberOfLines() {
        return this.numberOfLinesInBuffer;
    }

    public FormattedCharacterBuffer setBackgroundColor(Color color) {
        int n2 = 0;
        while (n2 < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer) {
            this.perCharBackgroundColor[n2] = color;
            ++n2;
        }
        return this;
    }

    public void setAt(int n2, int n3, char c2, Font font, Color color, Color color2) {
        int n4 = n2 * this.numberOfColumnsInBuffer + n3;
        this.charBuffer[n4] = c2;
        this.perCharFonts[n4] = font;
        this.perCharForegroundColor[n4] = color;
        this.perCharBackgroundColor[n4] = color2;
    }

    public boolean copyInto(int n2, int n3, FormattedCharacterBuffer formattedCharacterBuffer) {
        if (n2 + formattedCharacterBuffer.getNumberOfLines() > this.numberOfLinesInBuffer) return false;
        if (n3 + formattedCharacterBuffer.getNumberOfColumns() > this.numberOfColumnsInBuffer) {
            return false;
        }
        int n4 = 0;
        while (n4 < formattedCharacterBuffer.getNumberOfLines()) {
            for (int i2 = 0; i2 < formattedCharacterBuffer.getNumberOfColumns(); ++i2) {
                int n5 = n4 * formattedCharacterBuffer.getNumberOfColumns() + i2;
                char c2 = formattedCharacterBuffer.charBuffer[n5];
                Font font = formattedCharacterBuffer.perCharFonts[n5];
                Color color = formattedCharacterBuffer.perCharForegroundColor[n5];
                Color color2 = formattedCharacterBuffer.perCharBackgroundColor[n5];
                this.setAt(n2 + n4, n3 + i2, c2, font, color, color2);
            }
            ++n4;
        }
        return true;
    }

    public FormattedCharacterBuffer getLine(int n2) {
        FormattedCharacterBuffer formattedCharacterBuffer = new FormattedCharacterBuffer(1, this.numberOfColumnsInBuffer);
        int n3 = 0;
        while (n3 < this.getNumberOfColumns()) {
            int n4 = n2 * this.getNumberOfColumns() + n3;
            char c2 = this.charBuffer[n4];
            Font font = this.perCharFonts[n4];
            Color color = this.perCharForegroundColor[n4];
            Color color2 = this.perCharBackgroundColor[n4];
            formattedCharacterBuffer.setAt(0, n3, c2, font, color, color2);
            ++n3;
        }
        return formattedCharacterBuffer;
    }

    protected void paintBuffer(Graphics2D graphics2D, int n2, int n3, int n4) {
        graphics2D.setFont(this.perCharFonts[0]);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        graphics2D.fillRect(0, 0, this.numberOfColumnsInBuffer * fontMetrics.charWidth('a'), this.numberOfLinesInBuffer * fontMetrics.getHeight());
        int n5 = 0;
        while (n5 < this.numberOfLinesInBuffer) {
            AttributedString attributedString = this.getAttributedStringForLine(n5, n4);
            graphics2D.drawString(attributedString.getIterator(), n2, n3 + fontMetrics.getHeight() * (n5 + 1));
            ++n5;
        }
    }

    private AttributedString getAttributedStringForLine(int n2, int n3) {
        String string = new String(this.charBuffer, this.numberOfColumnsInBuffer * n2 + n3, this.numberOfColumnsInBuffer - n3);
        AttributedString attributedString = new AttributedString(string);
        int n4 = n2 * this.numberOfColumnsInBuffer + n3;
        int n5 = 0;
        while (n5 < this.numberOfColumnsInBuffer - n3) {
            attributedString.addAttribute(TextAttribute.FONT, this.perCharFonts[n4 + n5], n5, n5 + 1);
            attributedString.addAttribute(TextAttribute.BACKGROUND, this.perCharBackgroundColor[n4 + n5], n5, n5 + 1);
            attributedString.addAttribute(TextAttribute.FOREGROUND, this.perCharForegroundColor[n4 + n5], n5, n5 + 1);
            ++n5;
        }
        return attributedString;
    }

    public String getCharBufferAsString() {
        StringBuilder stringBuilder = new StringBuilder(this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer);
        int n2 = 0;
        while (n2 < this.numberOfLinesInBuffer) {
            stringBuilder.append(this.charBuffer, this.numberOfColumnsInBuffer * n2, this.numberOfColumnsInBuffer);
            stringBuilder.append("\n");
            ++n2;
        }
        return stringBuilder.toString();
    }
}

