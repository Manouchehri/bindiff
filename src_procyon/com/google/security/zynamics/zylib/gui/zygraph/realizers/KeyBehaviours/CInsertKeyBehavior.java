package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.*;

public class CInsertKeyBehavior extends CAbstractKeyBehavior
{
    private int m_caretX;
    private int m_caretY;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;
    private boolean m_wasUneditableSelection;
    private IZyEditableObject m_editableObject;
    
    public CInsertKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_caretX = 0;
        this.m_caretY = 0;
    }
    
    private boolean isCopy() {
        return this.isCtrlPressed() && !this.isShiftPressed() && !this.isAltPressed();
    }
    
    private boolean isPaste() {
        return !this.isCtrlPressed() && this.isShiftPressed() && !this.isAltPressed();
    }
    
    @Override
    protected void initUndoHistory() {
        if (this.isPaste()) {
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
    }
    
    @Override
    protected void updateCaret() {
        if (this.isCopy() || this.isPaste()) {
            this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
        }
    }
    
    @Override
    protected void updateClipboard() {
        if (this.isCopy()) {
            ClipboardHelpers.copyToClipboard(this.getSelectedText());
        }
    }
    
    @Override
    protected void updateLabelContent() {
        if (this.isPaste()) {
            if (this.m_wasUneditableSelection) {
                this.m_caretX = this.getCaretEndPosX();
                this.m_caretY = this.getCaretMouseReleasedY();
                return;
            }
            final Point pasteClipboardText = this.pasteClipboardText();
            this.m_caretX = pasteClipboardText.x;
            this.m_caretY = pasteClipboardText.y;
        }
    }
    
    @Override
    protected void updateSelection() {
        if (this.isPaste()) {
            this.m_wasUneditableSelection = (!this.isDeleteableSelection() && this.isSelection());
            this.deleteSelection();
        }
    }
    
    @Override
    protected void updateUndoHistory() {
        if (this.isPaste() && this.m_editableObject != null) {
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
