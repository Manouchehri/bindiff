package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CUndoStateData
{
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
    
    public CUndoStateData(final ZyLabelContent labelContent, final Object persistentModel, final IZyEditableObject editableObject, final String text, final boolean isAboveLineComment, final boolean isBehindLineComment, final boolean isLabelComment, final int caretStartX, final int caretMousePressedX, final int caretMousePressedY, final int caretEndX, final int caretMouseReleasedX, final int caretMouseReleasedY) {
        Preconditions.checkNotNull(labelContent, (Object)"Error: Label content can't be null.");
        Preconditions.checkNotNull(persistentModel, (Object)"Error: Persistent model can't be null.");
        Preconditions.checkNotNull(editableObject, (Object)"Error: Editable object cant be null.");
        Preconditions.checkNotNull(text, (Object)"Error: Text can't be null.");
        this.m_labelContent = labelContent;
        this.m_persistentModel = persistentModel;
        this.m_editableObject = editableObject;
        this.m_text = text;
        this.m_isAboveLineComment = isAboveLineComment;
        this.m_isBehindLineComment = isBehindLineComment;
        this.m_isLabelComment = isLabelComment;
        this.m_caretStartX = caretStartX;
        this.m_caretMousePressedX = caretMousePressedX;
        this.m_caretMousePressedY = caretMousePressedY;
        this.m_caretEndX = caretEndX;
        this.m_caretMouseReleasedX = caretMouseReleasedX;
        this.m_caretMouseReleasedY = caretMouseReleasedY;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof CUndoStateData) {
            final CUndoStateData cUndoStateData = (CUndoStateData)o;
            return this.m_isAboveLineComment == cUndoStateData.m_isAboveLineComment && this.m_isBehindLineComment == cUndoStateData.m_isBehindLineComment && this.m_isLabelComment == cUndoStateData.m_isLabelComment && this.m_persistentModel == cUndoStateData.m_persistentModel && this.m_text.equals(cUndoStateData.m_text);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 0 + (this.m_isAboveLineComment ? 1 : 2) + (this.m_isBehindLineComment ? 4 : 8) + (this.m_isBehindLineComment ? 16 : 32) + (64 + this.m_text.hashCode()) * this.m_persistentModel.hashCode();
    }
    
    public void restore() {
        if (this.m_isAboveLineComment) {
            this.m_editableObject.updateComment(this.m_text, ECommentPlacement.ABOVE_LINE);
        }
        else if (this.m_isBehindLineComment) {
            this.m_editableObject.updateComment(this.m_text, ECommentPlacement.BEHIND_LINE);
        }
        else {
            if (!this.m_isLabelComment) {
                throw new RuntimeException("Not implemented yet.");
            }
            this.m_editableObject.update(this.m_text);
        }
        this.m_labelContent.getLineEditor().recreateLabelLines(this.m_labelContent, this.m_persistentModel);
        this.m_labelContent.getCaret().setCaret(this.m_caretStartX, this.m_caretMousePressedX, this.m_caretMousePressedY, this.m_caretEndX, this.m_caretMouseReleasedX, this.m_caretMouseReleasedY);
    }
}
