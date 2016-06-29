/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.List;

public class CTabKeyBehavior
extends CAbstractKeyBehavior {
    public CTabKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    @Override
    protected void initUndoHistory() {
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void updateCaret() {
        if (this.isAltPressed() != false) return;
        if (this.isCtrlPressed() != false) return;
        var1_1 = this.getCaretEndPosX();
        var2_2 = this.getCaretMousePressedY();
        var3_3 = this.getLineContent(var2_2);
        var4_4 = var3_3.getLineFragmentObjectAt(var1_1);
        var5_5 = var3_3.getLineFragmentObjectList();
        var6_6 = null;
        if (this.isShiftPressed()) ** GOTO lbl26
        if (var4_4 == null) ** GOTO lbl14
        if (this.isComment(var1_1, var2_2) || (var7_7 = var3_3.getLineFragmentObjectList().indexOf(var4_4)) >= var5_5.size() - 1) ** GOTO lbl18
        var6_6 = (IZyEditableObject)var5_5.get(var7_7 + 1);
        ** GOTO lbl18
lbl14: // 2 sources:
        for (IZyEditableObject var8_10 : var5_5) {
            if (var8_10.getStart() <= var1_1) continue;
            var6_6 = var8_10;
            break;
        }
lbl18: // 4 sources:
        var7_7 = var2_2;
        if (this.isComment(var1_1, var2_2)) {
            var8_11 = this.getLabelContent().getLastLineIndexOfModelAt(var7_7);
            var9_17 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var7_7);
            var7_7 = var9_17 != -1 ? (var7_7 < var9_17 ? var9_17 - 1 : var8_11) : this.getLabelContent().getLineCount() - 1;
        }
        if (var6_6 != null) ** GOTO lbl39
        var8_12 = true;
        ** GOTO lbl30
lbl26: // 1 sources:
        if (var4_4 == null) ** GOTO lbl46
        if (this.isComment(var1_1, var2_2) || (var7_9 = var3_3.getLineFragmentObjectList().indexOf(var4_4)) >= 1) ** GOTO lbl51
        var6_6 = (IZyEditableObject)var5_5.get(var7_9 - 1);
        ** GOTO lbl51
lbl30: // 3 sources:
        while (var6_6 == null && var7_7 != var2_2 || var8_12) {
            var8_12 = false;
            v0 = var7_7 == this.getLabelContent().getLineCount() - 1 ? 0 : ++var7_7;
            var7_7 = v0;
            var9_18 = this.getLineContent(var7_7);
            var10_21 = var9_18.getLineFragmentObjectList();
            if (var10_21.size() <= 0) continue;
            var6_6 = (IZyEditableObject)var10_21.get(0);
        }
lbl39: // 2 sources:
        if (var6_6 == null) return;
        var1_1 = var6_6.getStart();
        if (var6_6.isCommentDelimiter()) {
            var1_1 = var6_6.getEnd();
        }
        var2_2 = var7_7;
        this.setCaret(var1_1, var1_1, var2_2, var1_1, var1_1, var2_2);
        return;
lbl46: // 2 sources:
        for (var7_9 = var5_5.size() - 1; var7_9 >= 0; --var7_9) {
            var8_13 = (IZyEditableObject)var5_5.get(var7_9);
            if (var8_13.getEnd() >= var1_1) continue;
            var6_6 = var8_13;
            break;
        }
lbl51: // 4 sources:
        var7_9 = var2_2;
        if (this.isComment(var1_1, var2_2)) {
            var8_14 = this.getLabelContent().getFirstLineIndexOfModelAt(var7_9);
            var9_19 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var7_9);
            if (var9_19 != -1) {
                var7_9 = var7_9 < var9_19 ? var8_14 : var9_19;
            }
        }
        if (var6_6 == null) {
            var8_15 = true;
            while (var6_6 == null && var7_9 != var2_2 || var8_15) {
                var8_15 = false;
                v1 = var7_9 == 0 ? this.getLabelContent().getLineCount() - 1 : --var7_9;
                var7_9 = v1;
                var9_20 = this.getLineContent(var7_9);
                var10_22 = var9_20.getLineFragmentObjectList();
                if (var10_22.size() <= 0) continue;
                var6_6 = (IZyEditableObject)var10_22.get(var10_22.size() - 1);
            }
        }
        if (var6_6 == null) return;
        var1_1 = var6_6.getStart();
        if (var6_6.isCommentDelimiter()) {
            var1_1 = var6_6.getEnd();
        }
        if (this.isComment(var1_1, var2_2 = var7_9)) {
            var8_16 = this.getLabelContent().getFirstLineIndexOfModelAt(var7_9);
            var9_17 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(var7_9);
            var2_2 = var2_2 <= var9_17 || var9_17 < 0 ? var8_16 : var9_17;
            var3_3 = this.getLineContent(var2_2);
            var6_6 = var3_3.getLineFragmentObjectAt(var1_1);
            if (var6_6 != null && var6_6.isCommentDelimiter()) {
                var1_1 = var6_6.getEnd();
            }
        }
        this.setCaret(var1_1, var1_1, var2_2, var1_1, var1_1, var2_2);
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

