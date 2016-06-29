package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CCharKeyBehavior extends CAbstractKeyBehavior
{
    private int m_caretX;
    private IZyEditableObject m_editableObject;
    private boolean m_isLabelComment;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_wasUneditableSelection;
    
    public CCharKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_editableObject = null;
        this.m_isLabelComment = false;
        this.m_isAboveComment = false;
        this.m_isBehindComment = false;
    }
    
    @Override
    protected void initUndoHistory() {
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        IZyEditableObject editableObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        this.m_isAboveComment = this.isAboveLineComment(caretMouseReleasedY);
        this.m_isBehindComment = this.isBehindLineComment(caretEndPosX, caretMouseReleasedY);
        this.m_isLabelComment = this.isLabelComment(caretMouseReleasedY);
        boolean b = false;
        if (caretEndPosX == lineContent.getText().length() && !this.isComment(caretEndPosX, caretMouseReleasedY)) {
            this.m_isBehindComment = true;
            b = true;
            editableObject = lineContent.getLineObject();
        }
        this.m_editableObject = editableObject;
        String s = "";
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
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        this.setCaret(this.m_caretX, this.m_caretX, caretMouseReleasedY, this.m_caretX, this.m_caretX, caretMouseReleasedY);
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
        if (this.m_wasUneditableSelection) {
            this.m_caretX = this.getCaretEndPosX();
            return;
        }
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        this.m_caretX = caretEndPosX;
        if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
            ++this.m_caretX;
            final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
            final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
            if (lineFragmentObject == null || lineFragmentObject.isCommentDelimiter()) {
                return;
            }
            final int n = caretEndPosX - lineFragmentObject.getStart();
            final String substring = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
            String s = String.format("%s%s%s", substring.substring(0, n), String.valueOf(this.getEvent().getKeyChar()), substring.substring(n));
            if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                s = this.getMultilineComment(caretMouseReleasedY, s);
            }
            lineFragmentObject.update(s);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), lineFragmentObject.getPersistentModel());
        }
        else {
            if (this.isEditable(caretEndPosX, caretMouseReleasedY)) {
                throw new RuntimeException("Not implemented yet.");
            }
            final ZyLineContent lineContent2 = this.getLineContent(caretMouseReleasedY);
            if (caretEndPosX == lineContent2.getText().length() && lineContent2.getLineObject() != null) {
                lineContent2.getLineObject().updateComment(Character.toString(this.getEvent().getKeyChar()), ECommentPlacement.BEHIND_LINE);
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), lineContent2.getLineObject().getPersistentModel());
                this.m_caretX = this.getLineContent(caretMouseReleasedY).getText().length();
            }
        }
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
