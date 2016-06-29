/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;

public class CUndoStateData {
    private final ZyLabelContent m_labelContent;
    private final Object m_persistentModel;
    private final IZyEditableObject m_editableObject;
    private final String m_text;
    private final boolean m_isAboveLineComment;
    private final boolean m_isBehindLineComment;
    private final boolean m_isLabelComment;
    private final int m_caretStartX;
    private final int m_caretMousePressedX;
    private final int m_caretMousePressedY;
    private final int m_caretEndX;
    private final int m_caretMouseReleasedX;
    private final int m_caretMouseReleasedY;

    public CUndoStateData(ZyLabelContent zyLabelContent, Object object, IZyEditableObject iZyEditableObject, String string, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, int n5, int n6, int n7) {
        Preconditions.checkNotNull(zyLabelContent, "Error: Label content can't be null.");
        Preconditions.checkNotNull(object, "Error: Persistent model can't be null.");
        Preconditions.checkNotNull(iZyEditableObject, "Error: Editable object cant be null.");
        Preconditions.checkNotNull(string, "Error: Text can't be null.");
        this.m_labelContent = zyLabelContent;
        this.m_persistentModel = object;
        this.m_editableObject = iZyEditableObject;
        this.m_text = string;
        this.m_isAboveLineComment = bl2;
        this.m_isBehindLineComment = bl3;
        this.m_isLabelComment = bl4;
        this.m_caretStartX = n2;
        this.m_caretMousePressedX = n3;
        this.m_caretMousePressedY = n4;
        this.m_caretEndX = n5;
        this.m_caretMouseReleasedX = n6;
        this.m_caretMouseReleasedY = n7;
    }

    public boolean equals(Object object) {
        if (!(object instanceof CUndoStateData)) return false;
        CUndoStateData cUndoStateData = (CUndoStateData)object;
        if (this.m_isAboveLineComment != cUndoStateData.m_isAboveLineComment) return false;
        if (this.m_isBehindLineComment != cUndoStateData.m_isBehindLineComment) return false;
        if (this.m_isLabelComment != cUndoStateData.m_isLabelComment) return false;
        if (this.m_persistentModel != cUndoStateData.m_persistentModel) return false;
        if (!this.m_text.equals(cUndoStateData.m_text)) return false;
        return true;
    }

    public int hashCode() {
        int n2 = 0;
        int n3 = 64 + this.m_text.hashCode();
        n2 += this.m_isAboveLineComment ? 1 : 2;
        n2 += this.m_isBehindLineComment ? 4 : 8;
        n2 += this.m_isBehindLineComment ? 16 : 32;
        return n2 += (n3 *= this.m_persistentModel.hashCode());
    }

    public void restore() {
        if (this.m_isAboveLineComment) {
            this.m_editableObject.updateComment(this.m_text, ECommentPlacement.ABOVE_LINE);
        } else if (this.m_isBehindLineComment) {
            this.m_editableObject.updateComment(this.m_text, ECommentPlacement.BEHIND_LINE);
        } else {
            if (!this.m_isLabelComment) throw new RuntimeException("Not implemented yet.");
            this.m_editableObject.update(this.m_text);
        }
        this.m_labelContent.getLineEditor().recreateLabelLines(this.m_labelContent, this.m_persistentModel);
        this.m_labelContent.getCaret().setCaret(this.m_caretStartX, this.m_caretMousePressedX, this.m_caretMousePressedY, this.m_caretEndX, this.m_caretMouseReleasedX, this.m_caretMouseReleasedY);
    }
}

