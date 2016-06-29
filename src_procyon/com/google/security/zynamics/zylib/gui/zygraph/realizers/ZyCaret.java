package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.*;
import java.awt.geom.*;
import java.awt.font.*;

public class ZyCaret
{
    private final ZyLabelContent m_content;
    private int m_mouse_pressed_x;
    private int m_mouse_pressed_y;
    private int m_mouse_released_x;
    private int m_mouse_released_y;
    private int m_caret_endpos_x;
    private int m_caret_startpos_x;
    
    public ZyCaret(final ZyLabelContent content) {
        this.m_mouse_pressed_x = 0;
        this.m_mouse_pressed_y = 0;
        this.m_mouse_released_x = 0;
        this.m_mouse_released_y = 0;
        this.m_caret_endpos_x = 0;
        this.m_caret_startpos_x = 0;
        Preconditions.checkNotNull(content, (Object)"Error: Label content can't be null.");
        this.m_content = content;
    }
    
    private int calcCaretPosition(final int n, final double n2, final double n3) {
        return this.m_content.getLineContent(n).getTextLayout().hitTestChar((float)n2, (float)n3, this.m_content.getLineContent(n).getBounds()).getInsertionIndex();
    }
    
    private int calcHitLine(final double n) {
        final int lineCount = this.m_content.getLineCount();
        final double lineHeight = this.m_content.getLineHeight();
        int n2 = 0;
        if (n < this.m_content.getLineContent(0).getBounds().getMinY()) {
            n2 = 0;
        }
        else if (n > this.m_content.getLineContent(lineCount - 1).getBounds().getMinY() + lineCount * lineHeight) {
            n2 = lineCount - 1;
        }
        else {
            for (int i = 0; i < lineCount; ++i) {
                final Rectangle2D bounds = this.m_content.getLineContent(i).getBounds();
                final Rectangle2D.Double double1 = new Rectangle2D.Double(bounds.getX(), bounds.getY() + i * lineHeight + this.m_content.getPaddingTop(), bounds.getWidth(), bounds.getHeight());
                if (double1.getY() < n && double1.getY() + lineHeight > n) {
                    n2 = i;
                    break;
                }
            }
        }
        return n2;
    }
    
    private int calcHitPosition(final int n, final double n2, final double n3, final double n4) {
        boolean b = false;
        int n5 = this.m_mouse_pressed_y;
        int n6 = this.m_mouse_released_y;
        if (n5 > n6) {
            n5 = this.m_mouse_released_y;
            n6 = this.m_mouse_pressed_y;
            b = true;
        }
        final int lineCount = this.m_content.getLineCount();
        final double n7 = (float)this.m_content.getLineHeight();
        int n8 = n;
        for (int i = n5; i <= n6; ++i) {
            double n9;
            if (b) {
                n9 = n7 * n4 * i;
            }
            else {
                n9 = -(n7 * n4 * (lineCount - i));
            }
            final TextLayout textLayout = this.m_content.getLineContent(i).getTextLayout();
            final int insertionIndex = textLayout.hitTestChar((float)n2, (float)(n3 + n9), textLayout.getBounds()).getInsertionIndex();
            if (n < insertionIndex && insertionIndex > n8) {
                n8 = insertionIndex;
            }
        }
        return n8;
    }
    
    private int calcSelectedLinesMaxLength() {
        int n = this.m_mouse_pressed_y;
        int n2 = this.m_mouse_released_y;
        if (n > n2) {
            n = this.m_mouse_released_y;
            n2 = this.m_mouse_pressed_y;
        }
        int max = 0;
        for (int i = n; i <= n2; ++i) {
            max = Math.max(max, this.m_content.getLineContent(i).getText().length());
        }
        return max;
    }
    
    private int getLastLineXPos(final int n) {
        final String text = this.m_content.getLineContent(n).getText();
        if (text.endsWith("\n") || text.endsWith("\r")) {
            return text.length() - 1;
        }
        return text.length();
    }
    
    public int getCaretEndPos() {
        return this.m_caret_endpos_x;
    }
    
    public int getCaretStartPos() {
        return this.m_caret_startpos_x;
    }
    
    public int getMaxLineLength(int n, int n2) {
        int n3 = 0;
        if (n > n2) {
            final int n4 = n;
            n = n2;
            n2 = n4;
        }
        for (int i = n; i <= n2; ++i) {
            final int length = this.m_content.getLineContent(i).getText().length();
            if (n3 < length) {
                n3 = length;
            }
        }
        return n3;
    }
    
    public int getXmousePressed() {
        return this.m_mouse_pressed_x;
    }
    
    public int getXmouseReleased() {
        return this.m_mouse_released_x;
    }
    
    public int getYmousePressed() {
        return this.m_mouse_pressed_y;
    }
    
    public int getYmouseReleased() {
        return this.m_mouse_released_y;
    }
    
    public boolean isSelection() {
        if (this.getXmousePressed() != this.getXmouseReleased() && this.getYmousePressed() == this.getYmouseReleased()) {
            return this.m_content.getLastLineIndexOfModelAt(this.m_mouse_pressed_y) >= this.m_mouse_pressed_y;
        }
        return this.getXmousePressed() != this.getXmouseReleased() || this.getYmousePressed() != this.getYmouseReleased();
    }
    
    public void selectAll() {
        this.m_mouse_pressed_x = 0;
        this.m_mouse_pressed_y = 0;
        this.m_mouse_released_y = this.m_content.getLineCount() - 1;
        this.m_mouse_released_x = this.calcSelectedLinesMaxLength();
        this.m_caret_startpos_x = this.m_mouse_pressed_x;
        this.m_caret_endpos_x = this.m_mouse_released_x;
    }
    
    public void selectLine(final double n, final double n2) {
        this.m_mouse_released_y = this.calcHitLine(n2 - n - this.m_content.getPaddingTop());
        this.m_mouse_pressed_y = this.m_mouse_released_y;
        this.m_mouse_released_x = this.m_content.getLineContent(this.m_mouse_pressed_y).getTextLayout().getCharacterCount();
        this.m_mouse_pressed_x = 0;
        this.m_caret_endpos_x = this.m_mouse_released_x;
        this.m_caret_startpos_x = this.m_mouse_pressed_x;
    }
    
    public void selectWord(final double n, final double n2, final double n3, final double n4, final double n5) {
        final double n6 = n3 - n - this.m_content.getPaddingLeft();
        final double n7 = n4 - n2 - this.m_content.getPaddingTop();
        this.m_mouse_released_y = this.calcHitLine(n7);
        this.m_mouse_pressed_y = this.m_mouse_released_y;
        this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, (float)n6, (float)n7, n5);
        final String text = this.m_content.getLineContent(this.m_mouse_released_y).getText();
        if (this.m_mouse_released_x > text.length() - 1) {
            return;
        }
        if (text.charAt(this.m_mouse_released_x) == ' ') {
            return;
        }
        this.m_caret_endpos_x = text.length();
        for (int i = this.m_mouse_released_x; i < this.m_caret_endpos_x; ++i) {
            if (text.charAt(i) == ' ') {
                this.m_caret_endpos_x = i;
                break;
            }
        }
        this.m_caret_startpos_x = 0;
        for (int j = this.m_mouse_released_x; j >= 0; --j) {
            if (text.charAt(j) == ' ') {
                this.m_caret_startpos_x = j + 1;
                break;
            }
        }
        this.m_mouse_pressed_x = this.m_caret_startpos_x;
        this.m_mouse_released_x = this.m_caret_endpos_x;
    }
    
    public void setCaret(int caret_startpos_x, int mouse_pressed_x, final int mouse_pressed_y, int caret_endpos_x, final int mouse_released_x, final int mouse_released_y) {
        final int lastLineXPos = this.getLastLineXPos(mouse_pressed_y);
        if (caret_startpos_x > lastLineXPos) {
            caret_startpos_x = lastLineXPos;
        }
        if (mouse_pressed_x > lastLineXPos) {
            mouse_pressed_x = lastLineXPos;
        }
        final int lastLineXPos2 = this.getLastLineXPos(mouse_released_y);
        if (caret_endpos_x > lastLineXPos2) {
            caret_endpos_x = lastLineXPos2;
        }
        this.m_caret_startpos_x = caret_startpos_x;
        this.m_mouse_pressed_x = mouse_pressed_x;
        this.m_mouse_pressed_y = mouse_pressed_y;
        this.m_caret_endpos_x = caret_endpos_x;
        this.m_mouse_released_x = mouse_released_x;
        this.m_mouse_released_y = mouse_released_y;
    }
    
    public void setCaretEnd(final double n, final double n2, final double n3, final double n4, final double n5) {
        final double n6 = n3 - n - this.m_content.getPaddingLeft();
        final double n7 = n4 - n2;
        this.m_mouse_released_y = this.calcHitLine(n7);
        this.m_caret_endpos_x = this.calcCaretPosition(this.m_mouse_released_y, n6, n7);
        this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, n6, n7, n5);
    }
    
    public void setCaretEndPos(int caret_endpos_x) {
        final int lastLineXPos = this.getLastLineXPos(this.m_mouse_released_y);
        if (caret_endpos_x > lastLineXPos) {
            caret_endpos_x = lastLineXPos;
        }
        this.m_caret_endpos_x = caret_endpos_x;
    }
    
    public void setCaretStart(final double n, final double n2, final double n3, final double n4, final double n5) {
        final double n6 = n3 - n - this.m_content.getPaddingLeft();
        final double n7 = n4 - n2;
        this.m_mouse_pressed_y = this.calcHitLine(n7);
        this.m_caret_startpos_x = this.calcCaretPosition(this.m_mouse_pressed_y, n6, n7);
        this.m_mouse_pressed_x = this.calcHitPosition(this.m_caret_startpos_x, n6, n7, n5);
    }
    
    public void setCaretStartPos(int caret_startpos_x) {
        final int lastLineXPos = this.getLastLineXPos(this.m_mouse_pressed_y);
        if (caret_startpos_x > lastLineXPos) {
            caret_startpos_x = lastLineXPos;
        }
        this.m_caret_startpos_x = caret_startpos_x;
    }
    
    public void setXmousePressed(int mouse_pressed_x) {
        final int lastLineXPos = this.getLastLineXPos(this.m_mouse_pressed_y);
        if (mouse_pressed_x > lastLineXPos) {
            mouse_pressed_x = lastLineXPos;
        }
        this.m_mouse_pressed_x = mouse_pressed_x;
    }
    
    public void setXmouseReleased(int mouse_released_x) {
        final int lastLineXPos = this.getLastLineXPos(this.m_mouse_released_y);
        if (mouse_released_x > lastLineXPos) {
            mouse_released_x = lastLineXPos;
        }
        this.m_mouse_released_x = mouse_released_x;
    }
    
    public void setYmousePressed(final int mouse_pressed_y) {
        this.m_mouse_pressed_y = mouse_pressed_y;
    }
    
    public void setYmouseReleased(final int mouse_released_y) {
        this.m_mouse_released_y = mouse_released_y;
    }
}
