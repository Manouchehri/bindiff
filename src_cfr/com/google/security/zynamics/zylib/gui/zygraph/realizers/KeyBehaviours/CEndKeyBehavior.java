/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.font.TextLayout;

public class CEndKeyBehavior
extends CAbstractKeyBehavior {
    public CEndKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    @Override
    protected void initUndoHistory() {
    }

    @Override
    protected void updateCaret() {
        if (!this.isShiftPressed() && !this.isCtrlPressed()) {
            int n2 = this.getCaretMouseReleasedY();
            int n3 = this.getLastLineXPos(n2);
            this.setCaret(n3, n3, n2, n3, n3, n2);
            return;
        }
        if (this.isShiftPressed() && !this.isCtrlPressed()) {
            int n4;
            boolean bl2;
            int n5 = this.getCaretMouseReleasedY();
            int n6 = n4 = this.getLineContent(n5).getTextLayout().getCharacterCount();
            ZyLineContent zyLineContent = this.getLineContent(this.getCaretMouseReleasedY());
            boolean bl3 = this.getCaretEndPosX() == zyLineContent.getText().length();
            boolean bl4 = zyLineContent.getText().endsWith("\n") && this.getCaretEndPosX() == zyLineContent.getText().length() - 1;
            boolean bl5 = bl2 = zyLineContent.getText().endsWith("\r") && this.getCaretEndPosX() == zyLineContent.getText().length() - 1;
            if (bl3 || bl4 || bl2) {
                n6 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            }
            if ((zyLineContent.getText().endsWith("\n") || zyLineContent.getText().endsWith("\r")) && n6 > 0) {
                --n6;
            }
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), n4, n6, n5);
            return;
        }
        if (!this.isShiftPressed() && this.isCtrlPressed()) {
            ZyLabelContent zyLabelContent = this.getLabelContent();
            int n7 = zyLabelContent.getLineContent(zyLabelContent.getLineCount() - 1).getText().length();
            int n8 = zyLabelContent.getLineCount() - 1;
            this.setCaret(n7, n7, n8, n7, n7, n8);
            return;
        }
        if (!this.isShiftPressed()) return;
        if (!this.isCtrlPressed()) return;
        int n9 = this.getLabelContent().getLineCount() - 1;
        int n10 = this.getLabelContent().getLineContent(n9).getText().length();
        this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), n10, n10, n9);
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

