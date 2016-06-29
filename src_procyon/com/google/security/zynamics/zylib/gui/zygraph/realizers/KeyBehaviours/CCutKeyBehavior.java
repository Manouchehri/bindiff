package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.general.*;

public class CCutKeyBehavior extends CAbstractKeyBehavior
{
    private IZyEditableObject m_editableObject;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;
    
    public CCutKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        this.m_editableObject = lineContent.getLineObject();
        if (lineFragmentObject != null) {
            String s = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
            this.m_isAboveComment = this.isAboveLineComment(caretMouseReleasedY);
            this.m_isBehindComment = this.isBehindLineComment(caretEndPosX, caretMouseReleasedY);
            this.m_isLabelComment = this.isLabelComment(caretMouseReleasedY);
            if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                s = this.getMultiLineComment(caretMouseReleasedY);
            }
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), this.m_editableObject, s, this.isAboveLineComment(caretMouseReleasedY), this.isBehindLineComment(caretEndPosX, caretMouseReleasedY), this.isLabelComment(caretMouseReleasedY), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
    
    @Override
    protected void updateCaret() {
    }
    
    @Override
    protected void updateClipboard() {
        ClipboardHelpers.copyToClipboard(this.getSelectedText());
    }
    
    @Override
    protected void updateLabelContent() {
    }
    
    @Override
    protected void updateSelection() {
        this.deleteSelection();
    }
    
    @Override
    protected void updateUndoHistory() {
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        if (lineFragmentObject != null) {
            String s = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
            if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                s = this.getMultiLineComment(caretMouseReleasedY);
            }
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), this.m_editableObject, s, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
}
