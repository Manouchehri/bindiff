package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.awt.*;

public class CPasteKeyBehavior extends CAbstractKeyBehavior
{
    private int m_caretX;
    private int m_caretY;
    private boolean m_isAboveComment;
    private boolean m_isLabelComment;
    private boolean m_isBehindComment;
    private IZyEditableObject m_editableObject;
    private boolean m_wasUneditableSelection;
    
    public CPasteKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_caretX = 0;
        this.m_caretY = 0;
    }
    
    @Override
    protected void initUndoHistory() {
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        IZyEditableObject editableObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        boolean b = false;
        String s = "";
        this.m_isAboveComment = this.isAboveLineComment(caretMouseReleasedY);
        this.m_isLabelComment = this.isLabelComment(caretMouseReleasedY);
        if (caretEndPosX == lineContent.getText().length() && !this.isComment(caretEndPosX, caretMouseReleasedY)) {
            this.m_isBehindComment = true;
            b = true;
            editableObject = lineContent.getLineObject();
        }
        else {
            this.m_isBehindComment = this.isBehindLineComment(caretEndPosX, caretMouseReleasedY);
        }
        this.m_editableObject = editableObject;
        if (editableObject != null) {
            if (!b) {
                s = lineContent.getText().substring(editableObject.getStart(), editableObject.getEnd());
                if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                    s = this.getMultiLineComment(caretMouseReleasedY);
                }
            }
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), editableObject, s, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
    
    @Override
    protected void updateCaret() {
        this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
        if (this.m_wasUneditableSelection) {
            this.m_caretX = this.getCaretEndPosX();
            this.m_caretY = this.getCaretMouseReleasedY();
            return;
        }
        final Point pasteClipboardText = this.pasteClipboardText();
        this.m_caretX = pasteClipboardText.x;
        this.m_caretY = pasteClipboardText.y;
    }
    
    @Override
    protected void updateSelection() {
        this.m_wasUneditableSelection = (!this.isDeleteableSelection() && this.isSelection());
        this.deleteSelection();
    }
    
    @Override
    protected void updateUndoHistory() {
        if (this.m_editableObject != null) {
            final int caretEndPosX = this.getCaretEndPosX();
            final int caretMouseReleasedY = this.getCaretMouseReleasedY();
            final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
            final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
            if (lineFragmentObject != null) {
                String s = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
                if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                    s = this.getMultiLineComment(caretMouseReleasedY);
                }
                this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), lineFragmentObject, s, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
            }
        }
    }
}
