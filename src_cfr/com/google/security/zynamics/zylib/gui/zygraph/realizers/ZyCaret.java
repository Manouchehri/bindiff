/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.font.TextHitInfo;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

public class ZyCaret {
    private final ZyLabelContent m_content;
    private int m_mouse_pressed_x = 0;
    private int m_mouse_pressed_y = 0;
    private int m_mouse_released_x = 0;
    private int m_mouse_released_y = 0;
    private int m_caret_endpos_x = 0;
    private int m_caret_startpos_x = 0;

    public ZyCaret(ZyLabelContent zyLabelContent) {
        Preconditions.checkNotNull(zyLabelContent, "Error: Label content can't be null.");
        this.m_content = zyLabelContent;
    }

    private int calcCaretPosition(int n2, double d2, double d3) {
        ZyLineContent zyLineContent = this.m_content.getLineContent(n2);
        TextLayout textLayout = this.m_content.getLineContent(n2).getTextLayout();
        TextHitInfo textHitInfo = textLayout.hitTestChar((float)d2, (float)d3, zyLineContent.getBounds());
        return textHitInfo.getInsertionIndex();
    }

    private int calcHitLine(double d2) {
        int n2 = this.m_content.getLineCount();
        double d3 = this.m_content.getLineHeight();
        int n3 = 0;
        if (d2 < this.m_content.getLineContent(0).getBounds().getMinY()) {
            return 0;
        }
        if (d2 > this.m_content.getLineContent(n2 - 1).getBounds().getMinY() + (double)n2 * d3) {
            return n2 - 1;
        }
        int n4 = 0;
        while (n4 < n2) {
            Rectangle2D rectangle2D = this.m_content.getLineContent(n4).getBounds();
            double d4 = rectangle2D.getY() + (double)n4 * d3 + (double)this.m_content.getPaddingTop();
            if ((rectangle2D = new Rectangle2D.Double(rectangle2D.getX(), d4, rectangle2D.getWidth(), rectangle2D.getHeight())).getY() < d2 && rectangle2D.getY() + d3 > d2) {
                return n4;
            }
            ++n4;
        }
        return n3;
    }

    private int calcHitPosition(int n2, double d2, double d3, double d4) {
        boolean bl2 = false;
        int n3 = this.m_mouse_pressed_y;
        int n4 = this.m_mouse_released_y;
        if (n3 > n4) {
            n3 = this.m_mouse_released_y;
            n4 = this.m_mouse_pressed_y;
            bl2 = true;
        }
        int n5 = this.m_content.getLineCount();
        double d5 = (float)this.m_content.getLineHeight();
        int n6 = n2;
        int n7 = n3;
        while (n7 <= n4) {
            double d6 = 0.0;
            d6 = bl2 ? d5 * d4 * (double)n7 : - d5 * d4 * (double)(n5 - n7);
            TextLayout textLayout = this.m_content.getLineContent(n7).getTextLayout();
            TextHitInfo textHitInfo = textLayout.hitTestChar((float)d2, (float)(d3 + d6), textLayout.getBounds());
            int n8 = textHitInfo.getInsertionIndex();
            if (n2 < n8 && n8 > n6) {
                n6 = n8;
            }
            ++n7;
        }
        return n6;
    }

    private int calcSelectedLinesMaxLength() {
        int n2 = this.m_mouse_pressed_y;
        int n3 = this.m_mouse_released_y;
        if (n2 > n3) {
            n2 = this.m_mouse_released_y;
            n3 = this.m_mouse_pressed_y;
        }
        int n4 = 0;
        int n5 = n2;
        while (n5 <= n3) {
            n4 = Math.max(n4, this.m_content.getLineContent(n5).getText().length());
            ++n5;
        }
        return n4;
    }

    private int getLastLineXPos(int n2) {
        ZyLineContent zyLineContent = this.m_content.getLineContent(n2);
        String string = zyLineContent.getText();
        if (string.endsWith("\n")) return string.length() - 1;
        if (!string.endsWith("\r")) return string.length();
        return string.length() - 1;
    }

    public int getCaretEndPos() {
        return this.m_caret_endpos_x;
    }

    public int getCaretStartPos() {
        return this.m_caret_startpos_x;
    }

    public int getMaxLineLength(int n2, int n3) {
        int n4;
        int n5 = 0;
        if (n2 > n3) {
            n4 = n2;
            n2 = n3;
            n3 = n4;
        }
        n4 = n2;
        while (n4 <= n3) {
            ZyLineContent zyLineContent = this.m_content.getLineContent(n4);
            int n6 = zyLineContent.getText().length();
            if (n5 < n6) {
                n5 = n6;
            }
            ++n4;
        }
        return n5;
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
        boolean bl2;
        boolean bl3 = bl2 = this.getXmousePressed() != this.getXmouseReleased() && this.getYmousePressed() == this.getYmouseReleased();
        if (bl2) {
            int n2 = this.m_content.getLastLineIndexOfModelAt(this.m_mouse_pressed_y);
            if (n2 < this.m_mouse_pressed_y) return false;
            return true;
        }
        if (this.getXmousePressed() != this.getXmouseReleased()) return true;
        if (this.getYmousePressed() != this.getYmouseReleased()) return true;
        return false;
    }

    public void selectAll() {
        this.m_mouse_pressed_x = 0;
        this.m_mouse_pressed_y = 0;
        this.m_mouse_released_y = this.m_content.getLineCount() - 1;
        this.m_mouse_released_x = this.calcSelectedLinesMaxLength();
        this.m_caret_startpos_x = this.m_mouse_pressed_x;
        this.m_caret_endpos_x = this.m_mouse_released_x;
    }

    public void selectLine(double d2, double d3) {
        double d4 = d3 - d2 - (double)this.m_content.getPaddingTop();
        this.m_mouse_pressed_y = this.m_mouse_released_y = this.calcHitLine(d4);
        this.m_mouse_released_x = this.m_content.getLineContent(this.m_mouse_pressed_y).getTextLayout().getCharacterCount();
        this.m_mouse_pressed_x = 0;
        this.m_caret_endpos_x = this.m_mouse_released_x;
        this.m_caret_startpos_x = this.m_mouse_pressed_x;
    }

    public void selectWord(double d2, double d3, double d4, double d5, double d6) {
        int n2;
        double d7 = d4 - d2 - (double)this.m_content.getPaddingLeft();
        double d8 = d5 - d3 - (double)this.m_content.getPaddingTop();
        this.m_mouse_pressed_y = this.m_mouse_released_y = this.calcHitLine(d8);
        this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, (float)d7, (float)d8, d6);
        String string = this.m_content.getLineContent(this.m_mouse_released_y).getText();
        if (this.m_mouse_released_x > string.length() - 1) {
            return;
        }
        if (string.charAt(this.m_mouse_released_x) == ' ') {
            return;
        }
        this.m_caret_endpos_x = string.length();
        for (n2 = this.m_mouse_released_x; n2 < this.m_caret_endpos_x; ++n2) {
            if (string.charAt(n2) != ' ') continue;
            this.m_caret_endpos_x = n2;
            break;
        }
        this.m_caret_startpos_x = 0;
        for (n2 = this.m_mouse_released_x; n2 >= 0; --n2) {
            if (string.charAt(n2) != ' ') continue;
            this.m_caret_startpos_x = n2 + 1;
            break;
        }
        this.m_mouse_pressed_x = this.m_caret_startpos_x;
        this.m_mouse_released_x = this.m_caret_endpos_x;
    }

    public void setCaret(int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8;
        int n9 = this.getLastLineXPos(n4);
        if (n2 > n9) {
            n2 = n9;
        }
        if (n3 > n9) {
            n3 = n9;
        }
        if (n5 > (n8 = this.getLastLineXPos(n7))) {
            n5 = n8;
        }
        this.m_caret_startpos_x = n2;
        this.m_mouse_pressed_x = n3;
        this.m_mouse_pressed_y = n4;
        this.m_caret_endpos_x = n5;
        this.m_mouse_released_x = n6;
        this.m_mouse_released_y = n7;
    }

    public void setCaretEnd(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d4 - d2 - (double)this.m_content.getPaddingLeft();
        double d8 = d5 - d3;
        this.m_mouse_released_y = this.calcHitLine(d8);
        this.m_caret_endpos_x = this.calcCaretPosition(this.m_mouse_released_y, d7, d8);
        this.m_mouse_released_x = this.calcHitPosition(this.m_caret_endpos_x, d7, d8, d6);
    }

    public void setCaretEndPos(int n2) {
        int n3 = this.getLastLineXPos(this.m_mouse_released_y);
        if (n2 > n3) {
            n2 = n3;
        }
        this.m_caret_endpos_x = n2;
    }

    public void setCaretStart(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d4 - d2 - (double)this.m_content.getPaddingLeft();
        double d8 = d5 - d3;
        this.m_mouse_pressed_y = this.calcHitLine(d8);
        this.m_caret_startpos_x = this.calcCaretPosition(this.m_mouse_pressed_y, d7, d8);
        this.m_mouse_pressed_x = this.calcHitPosition(this.m_caret_startpos_x, d7, d8, d6);
    }

    public void setCaretStartPos(int n2) {
        int n3 = this.getLastLineXPos(this.m_mouse_pressed_y);
        if (n2 > n3) {
            n2 = n3;
        }
        this.m_caret_startpos_x = n2;
    }

    public void setXmousePressed(int n2) {
        int n3 = this.getLastLineXPos(this.m_mouse_pressed_y);
        if (n2 > n3) {
            n2 = n3;
        }
        this.m_mouse_pressed_x = n2;
    }

    public void setXmouseReleased(int n2) {
        int n3 = this.getLastLineXPos(this.m_mouse_released_y);
        if (n2 > n3) {
            n2 = n3;
        }
        this.m_mouse_released_x = n2;
    }

    public void setYmousePressed(int n2) {
        this.m_mouse_pressed_y = n2;
    }

    public void setYmouseReleased(int n2) {
        this.m_mouse_released_y = n2;
    }
}

