package com.google.security.zynamics.zylib.gui.CodeDisplay;

import java.awt.*;
import java.awt.font.*;
import java.text.*;

public class FormattedCharacterBuffer
{
    private char[] charBuffer;
    private Font[] perCharFonts;
    private static final Font DEFAULT_FONT;
    private Color[] perCharForegroundColor;
    private Color defaultForegroundColor;
    private Color[] perCharBackgroundColor;
    private Color defaultBackgroundColor;
    private int numberOfLinesInBuffer;
    private int numberOfColumnsInBuffer;
    
    public FormattedCharacterBuffer(final int numberOfLinesInBuffer, final int numberOfColumnsInBuffer) {
        this.charBuffer = new char[0];
        this.perCharFonts = new Font[0];
        this.perCharForegroundColor = new Color[0];
        this.defaultForegroundColor = Color.BLACK;
        this.perCharBackgroundColor = new Color[0];
        this.defaultBackgroundColor = Color.WHITE;
        this.numberOfLinesInBuffer = numberOfLinesInBuffer;
        this.numberOfColumnsInBuffer = numberOfColumnsInBuffer;
        this.charBuffer = new char[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharFonts = new Font[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharForegroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.perCharBackgroundColor = new Color[this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer];
        this.clear();
    }
    
    public void clear() {
        for (int i = 0; i < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++i) {
            this.charBuffer[i] = ' ';
            this.perCharFonts[i] = FormattedCharacterBuffer.DEFAULT_FONT;
            this.perCharForegroundColor[i] = this.defaultForegroundColor;
            this.perCharBackgroundColor[i] = this.defaultBackgroundColor;
        }
    }
    
    public FormattedCharacterBuffer(final String s, final Font font, final Color color, final Color color2) {
        this(1, s.length());
        for (int i = 0; i < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++i) {
            this.charBuffer[i] = ((s.charAt(i) == '\n') ? '_' : s.charAt(i));
            this.perCharFonts[i] = font;
            this.perCharForegroundColor[i] = color;
            this.perCharBackgroundColor[i] = color2;
        }
    }
    
    public int getNumberOfColumns() {
        return this.numberOfColumnsInBuffer;
    }
    
    public int getNumberOfLines() {
        return this.numberOfLinesInBuffer;
    }
    
    public FormattedCharacterBuffer setBackgroundColor(final Color color) {
        for (int i = 0; i < this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer; ++i) {
            this.perCharBackgroundColor[i] = color;
        }
        return this;
    }
    
    public void setAt(final int n, final int n2, final char c, final Font font, final Color color, final Color color2) {
        final int n3 = n * this.numberOfColumnsInBuffer + n2;
        this.charBuffer[n3] = c;
        this.perCharFonts[n3] = font;
        this.perCharForegroundColor[n3] = color;
        this.perCharBackgroundColor[n3] = color2;
    }
    
    public boolean copyInto(final int n, final int n2, final FormattedCharacterBuffer formattedCharacterBuffer) {
        if (n + formattedCharacterBuffer.getNumberOfLines() > this.numberOfLinesInBuffer || n2 + formattedCharacterBuffer.getNumberOfColumns() > this.numberOfColumnsInBuffer) {
            return false;
        }
        for (int i = 0; i < formattedCharacterBuffer.getNumberOfLines(); ++i) {
            for (int j = 0; j < formattedCharacterBuffer.getNumberOfColumns(); ++j) {
                final int n3 = i * formattedCharacterBuffer.getNumberOfColumns() + j;
                this.setAt(n + i, n2 + j, formattedCharacterBuffer.charBuffer[n3], formattedCharacterBuffer.perCharFonts[n3], formattedCharacterBuffer.perCharForegroundColor[n3], formattedCharacterBuffer.perCharBackgroundColor[n3]);
            }
        }
        return true;
    }
    
    public FormattedCharacterBuffer getLine(final int n) {
        final FormattedCharacterBuffer formattedCharacterBuffer = new FormattedCharacterBuffer(1, this.numberOfColumnsInBuffer);
        for (int i = 0; i < this.getNumberOfColumns(); ++i) {
            final int n2 = n * this.getNumberOfColumns() + i;
            formattedCharacterBuffer.setAt(0, i, this.charBuffer[n2], this.perCharFonts[n2], this.perCharForegroundColor[n2], this.perCharBackgroundColor[n2]);
        }
        return formattedCharacterBuffer;
    }
    
    protected void paintBuffer(final Graphics2D graphics2D, final int n, final int n2, final int n3) {
        graphics2D.setFont(this.perCharFonts[0]);
        final FontMetrics fontMetrics = graphics2D.getFontMetrics();
        graphics2D.fillRect(0, 0, this.numberOfColumnsInBuffer * fontMetrics.charWidth('a'), this.numberOfLinesInBuffer * fontMetrics.getHeight());
        for (int i = 0; i < this.numberOfLinesInBuffer; ++i) {
            graphics2D.drawString(this.getAttributedStringForLine(i, n3).getIterator(), n, n2 + fontMetrics.getHeight() * (i + 1));
        }
    }
    
    private AttributedString getAttributedStringForLine(final int n, final int n2) {
        final AttributedString attributedString = new AttributedString(new String(this.charBuffer, this.numberOfColumnsInBuffer * n + n2, this.numberOfColumnsInBuffer - n2));
        final int n3 = n * this.numberOfColumnsInBuffer + n2;
        for (int i = 0; i < this.numberOfColumnsInBuffer - n2; ++i) {
            attributedString.addAttribute(TextAttribute.FONT, this.perCharFonts[n3 + i], i, i + 1);
            attributedString.addAttribute(TextAttribute.BACKGROUND, this.perCharBackgroundColor[n3 + i], i, i + 1);
            attributedString.addAttribute(TextAttribute.FOREGROUND, this.perCharForegroundColor[n3 + i], i, i + 1);
        }
        return attributedString;
    }
    
    public String getCharBufferAsString() {
        final StringBuilder sb = new StringBuilder(this.numberOfLinesInBuffer * this.numberOfColumnsInBuffer);
        for (int i = 0; i < this.numberOfLinesInBuffer; ++i) {
            sb.append(this.charBuffer, this.numberOfColumnsInBuffer * i, this.numberOfColumnsInBuffer);
            sb.append("\n");
        }
        return sb.toString();
    }
    
    static {
        DEFAULT_FONT = new Font("Monospaced", 0, 12);
    }
}
