/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.event.KeyEvent;
import java.awt.font.TextLayout;

public class CCursorKeyBehavior
extends CAbstractKeyBehavior {
    public CCursorKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    private int getXdelta() {
        int n2 = 0;
        if (this.getEvent().getKeyCode() == 37) {
            return -1;
        }
        if (this.getEvent().getKeyCode() != 39) return n2;
        return 1;
    }

    private int getYdelta() {
        int n2 = 0;
        if (this.getEvent().getKeyCode() == 38) {
            return -1;
        }
        if (this.getEvent().getKeyCode() != 40) return n2;
        return 1;
    }

    /*
     * Unable to fully structure code
     */
    protected void handleNotShiftAndCtrl(int var1_1, int var2_2) {
        var3_3 = this.getLabelContent();
        var4_4 = this.getCaretStartPosX();
        var5_5 = this.getCaretMousePressedX();
        var6_6 = this.getCaretMousePressedY();
        var7_7 = this.getCaretEndPosX();
        var8_8 = this.getCaretMouseReleasedX();
        var9_9 = this.getCaretMouseReleasedY();
        if (var1_1 == 0) {
            if (var2_2 == 0) return;
            this.handleNotShiftAndNotCtrl(0, var2_2);
            return;
        }
        var10_10 = var3_3.getLineContent(var9_9);
        var11_11 = String.valueOf(var10_10.getText()).concat(" ");
        if (var1_1 <= 0) ** GOTO lbl18
        var12_12 = var11_11.charAt(var7_7) == ' ';
        var13_14 = 0;
        ** GOTO lbl25
lbl18: // 1 sources:
        if (var1_1 >= 0) ** GOTO lbl43
        if (var7_7 == 0) {
            return;
        }
        var12_13 = var11_11.charAt(var7_7 - 1) == ' ';
        var13_15 = var7_7 - 1;
        var14_17 = var7_7 - 1;
        ** GOTO lbl36
lbl25: // 2 sources:
        for (var14_16 = var7_7; var14_16 < var11_11.length(); ++var14_16) {
            var13_14 = var14_16;
            if (var12_12 != false ? var11_11.charAt(var14_16) != ' ' : var11_11.charAt(var14_16) == ' ') break;
        }
        if ((var10_10.getText().endsWith("\n") || var10_10.getText().endsWith("\r")) && var10_10.getText().length() == var13_14) {
            --var13_14;
        }
        var4_4 = var13_14;
        var5_5 = var13_14;
        var8_8 = var13_14;
        var7_7 = var13_14;
        ** GOTO lbl43
lbl36: // 2 sources:
        while (var14_17 >= 0 && !(var12_13 != false ? var11_11.charAt(var14_17) != ' ' : var11_11.charAt(var14_17) == ' ')) {
            var13_15 = var14_17--;
        }
        var4_4 = var13_15;
        var5_5 = var13_15;
        var8_8 = var13_15;
        var7_7 = var13_15;
lbl43: // 3 sources:
        var8_8 = this.correctMouseReleasedX(var8_8, var9_9, var6_6);
        this.setCaret(var4_4, var5_5, var6_6, var7_7, var8_8, var9_9);
    }

    protected void handleNotShiftAndNotCtrl(int n2, int n3) {
        ZyLabelContent zyLabelContent = this.getLabelContent();
        int n4 = this.getCaretStartPosX();
        int n5 = this.getCaretMousePressedX();
        int n6 = this.getCaretMousePressedY();
        int n7 = this.getCaretEndPosX();
        int n8 = this.getCaretMouseReleasedX();
        int n9 = this.getCaretMouseReleasedY();
        if (this.isSelection() && n2 != 0 && n3 == 0) {
            if (n6 <= n9 && n5 <= n8) {
                if (n2 < 0) {
                    n8 = n5;
                    n7 = n4;
                    n9 = n6;
                } else {
                    n5 = n8;
                    n4 = n8;
                    n6 = n9;
                }
            } else if (n2 > 0) {
                n8 = n5;
                n7 = n4;
                n9 = n6;
            } else {
                n5 = n8;
                n4 = n8;
                n6 = n9;
            }
        } else {
            n5 = n8;
            n6 = n9;
            if ((n6 += n3) < 0) {
                n6 = 0;
            }
            if (n6 > zyLabelContent.getLineCount() - 1) {
                n6 = zyLabelContent.getLineCount() - 1;
            }
            n9 = n6;
            if ((n5 += n2) < 0) {
                n5 = 0;
            }
            if (n5 > zyLabelContent.getLineContent(n9).getTextLayout().getCharacterCount() - 1) {
                n5 = zyLabelContent.getLineContent(n9).getTextLayout().getCharacterCount();
            }
            n7 = n5;
            n8 = n5;
            n4 = n7;
        }
        n8 = this.correctMouseReleasedX(n8, n9, n6);
        this.setCaret(n4, n5, n6, n7, n8, n9);
    }

    /*
     * Unable to fully structure code
     */
    protected void handleShiftAndCtrl(int var1_1, int var2_2) {
        if (var2_2 != 0) {
            this.handleShiftAndNotCtrl(0, var2_2);
            return;
        }
        if (var1_1 == 0) return;
        var3_3 = this.getLabelContent();
        var4_4 = var3_3.getLineContent(this.getCaretMouseReleasedY());
        var5_5 = this.getCaretStartPosX();
        var6_6 = this.getCaretMousePressedX();
        var7_7 = this.getCaretMousePressedY();
        var8_8 = this.getCaretEndPosX();
        var9_9 = this.getCaretMouseReleasedX();
        var10_10 = this.getCaretMouseReleasedY();
        var11_11 = String.valueOf(var4_4.getText()).concat(" ");
        if (var1_1 <= 0) ** GOTO lbl18
        var12_12 = var11_11.charAt(var8_8) == ' ';
        var13_14 = 0;
        ** GOTO lbl25
lbl18: // 1 sources:
        if (var1_1 >= 0) ** GOTO lbl46
        if (var8_8 == 0) {
            return;
        }
        var12_13 = var11_11.charAt(var8_8 - 1) == ' ';
        var13_15 = var8_8 - 1;
        var14_17 = var8_8 - 1;
        ** GOTO lbl40
lbl25: // 2 sources:
        for (var14_16 = var8_8; var14_16 < var11_11.length(); ++var14_16) {
            var13_14 = var14_16;
            if (var12_12 != false ? var11_11.charAt(var14_16) != ' ' : var11_11.charAt(var14_16) == ' ') break;
        }
        if ((var4_4.getText().endsWith("\n") || var4_4.getText().endsWith("\r")) && var4_4.getText().length() == var13_14) {
            --var13_14;
        }
        var5_5 = var6_6;
        var9_9 = var13_14;
        var8_8 = var13_14;
        var14_16 = this.getCaretEndPosX() == var4_4.getText().length() ? 1 : 0;
        var15_18 = var4_4.getText().endsWith("\n") != false && this.getCaretEndPosX() == var4_4.getText().length() - 1;
        v0 = var16_19 = var4_4.getText().endsWith("\r") != false && this.getCaretEndPosX() == var4_4.getText().length() - 1;
        if (var14_16 != 0 || var15_18 || var16_19) {
            var9_9 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        }
        ** GOTO lbl46
lbl40: // 2 sources:
        while (var14_17 >= 0 && !(var12_13 != false ? var11_11.charAt(var14_17) != ' ' : var11_11.charAt(var14_17) == ' ')) {
            var13_15 = var14_17--;
        }
        var5_5 = var6_6;
        var9_9 = var13_15;
        var8_8 = var13_15;
lbl46: // 3 sources:
        var9_9 = this.correctMouseReleasedX(var9_9, var10_10, var7_7);
        this.setCaret(var5_5, var6_6, var7_7, var8_8, var9_9, var10_10);
    }

    protected void handleShiftAndNotCtrl(int n2, int n3) {
        ZyLabelContent zyLabelContent = this.getLabelContent();
        int n4 = this.getCaretStartPosX();
        int n5 = this.getCaretMousePressedX();
        int n6 = this.getCaretMousePressedY();
        int n7 = this.getCaretEndPosX();
        int n8 = this.getCaretMouseReleasedX();
        int n9 = this.getCaretMouseReleasedY();
        int n10 = zyLabelContent.getLineCount();
        if (n2 != 0 || n3 != 0) {
            int n11;
            int n12;
            if ((n9 += n3) < 0) {
                n9 = 0;
            }
            if (n9 > n10 - 1) {
                n9 = n10 - 1;
            }
            if ((n8 += n2) < 0) {
                n8 = 0;
            }
            if ((n11 = n6) > (n12 = n9)) {
                n11 = n9;
                n12 = n6;
            }
            int n13 = 0;
            for (int i2 = n11; i2 <= n12; ++i2) {
                n13 = Math.max(n13, zyLabelContent.getLineContent(i2).getText().length());
            }
            if (n8 > n13) {
                n8 = n13;
            }
            n7 = n8 <= zyLabelContent.getLineContent(n9).getTextLayout().getCharacterCount() ? n8 : zyLabelContent.getLineContent(n9).getTextLayout().getCharacterCount();
            n4 = n5;
        }
        n8 = this.correctMouseReleasedX(n8, n9, n6);
        this.setCaret(n4, n5, n6, n7, n8, n9);
    }

    @Override
    protected void initUndoHistory() {
    }

    @Override
    protected void updateCaret() {
        int n2 = this.getXdelta();
        int n3 = this.getYdelta();
        if (!this.isShiftPressed() && !this.isCtrlPressed()) {
            this.handleNotShiftAndNotCtrl(n2, n3);
            return;
        }
        if (this.isShiftPressed() && !this.isCtrlPressed()) {
            this.handleShiftAndNotCtrl(n2, n3);
            return;
        }
        if (!this.isShiftPressed() && this.isCtrlPressed()) {
            this.handleNotShiftAndCtrl(n2, n3);
            return;
        }
        if (!this.isShiftPressed()) return;
        if (!this.isCtrlPressed()) return;
        this.handleShiftAndCtrl(n2, n3);
    }

    @Override
    protected void updateClipboard() {
    }

    @Override
    protected void updateLabelContent() {
    }

    @Override
    protected void updateSelection() {
    }

    @Override
    protected void updateUndoHistory() {
    }
}

