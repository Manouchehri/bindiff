package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CReturnKeyBehavior extends CAbstractKeyBehavior
{
    private int m_caretY;
    private boolean m_wasUneditableSelection;
    
    public CReturnKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_caretY = -1;
    }
    
    @Override
    protected void initUndoHistory() {
        int n = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        if (this.isComment(n, caretMouseReleasedY)) {
            IZyEditableObject zyEditableObject = lineContent.getLineFragmentObjectAt(n);
            if (zyEditableObject.isCommentDelimiter()) {
                n = zyEditableObject.getEnd();
                zyEditableObject = lineContent.getLineFragmentObjectAt(n);
            }
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), zyEditableObject, this.getMultiLineComment(caretMouseReleasedY), this.isAboveLineComment(caretMouseReleasedY), this.isBehindLineComment(n, caretMouseReleasedY), this.isLabelComment(caretMouseReleasedY), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
        else {
            final ZyLineContent nextModelLineContent = this.getNextModelLineContent(caretMouseReleasedY);
            final int nextModelLineIndex = this.getNextModelLineIndex(caretMouseReleasedY);
            String multiLineComment = "";
            boolean b = false;
            boolean b2 = false;
            boolean b3 = false;
            IZyEditableObject lineObject = (nextModelLineContent == null) ? this.getLabelContent().getModel() : nextModelLineContent.getLineObject();
            if (n == lineContent.getText().length() && this.getCaretMouseReleasedY() != 0) {
                lineObject = lineContent.getLineObject();
                b2 = true;
            }
            else if (nextModelLineContent != null && !this.isLabelComment(nextModelLineIndex)) {
                if (this.isComment(0, nextModelLineIndex)) {
                    multiLineComment = this.getMultiLineComment(nextModelLineIndex);
                }
                b = true;
            }
            else if (nextModelLineContent != null && this.isLabelComment(nextModelLineIndex)) {
                final String value = String.valueOf(multiLineComment);
                final String value2 = String.valueOf(this.getMultiLineComment(nextModelLineIndex));
                multiLineComment = ((value2.length() != 0) ? value.concat(value2) : new String(value));
                b3 = true;
            }
            else {
                b3 = true;
            }
            if (lineObject == null) {
                return;
            }
            this.udpateUndolist(this.getLabelContent(), lineObject.getPersistentModel(), lineObject, multiLineComment, b, b2, b3, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
    
    @Override
    protected void updateCaret() {
        if (this.m_caretY > -1 && this.isComment(this.getCaretEndPosX(), this.m_caretY)) {
            final IZyEditableObject zyEditableObject = this.getLineContent(this.m_caretY).getLineFragmentObjectList().get(0);
            int end = 0;
            if (zyEditableObject != null) {
                end = zyEditableObject.getEnd();
            }
            this.setCaret(end, end, this.m_caretY, end, end, this.m_caretY);
        }
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
        if (this.m_wasUneditableSelection) {
            return;
        }
        int n = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        this.m_caretY = caretMouseReleasedY + 1;
        if (this.isComment(n, caretMouseReleasedY)) {
            final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
            IZyEditableObject zyEditableObject = lineContent.getLineFragmentObjectAt(n);
            if (zyEditableObject.isCommentDelimiter()) {
                n = zyEditableObject.getEnd();
                zyEditableObject = lineContent.getLineFragmentObjectAt(n);
            }
            int n2 = n - zyEditableObject.getStart();
            final String substring = lineContent.getText().substring(zyEditableObject.getStart(), zyEditableObject.getEnd());
            if (substring.endsWith("\r") && n2 == substring.length()) {
                --n2;
            }
            final String multilineComment = this.getMultilineComment(caretMouseReleasedY, String.format("%s%s%s", substring.substring(0, n2), "\n", substring.substring(n2)));
            final IZyEditableObject lineObject = lineContent.getLineObject();
            if (lineObject == null) {
                return;
            }
            if (this.isAboveLineComment(caretMouseReleasedY)) {
                lineObject.updateComment(multilineComment, ECommentPlacement.ABOVE_LINE);
            }
            else if (this.isBehindLineComment(n, caretMouseReleasedY)) {
                lineObject.updateComment(multilineComment, ECommentPlacement.BEHIND_LINE);
            }
            else if (this.isLabelComment(caretMouseReleasedY)) {
                lineObject.update(multilineComment);
            }
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), lineObject.getPersistentModel());
        }
        else {
            final ZyLineContent lineContent2 = this.getLineContent(caretMouseReleasedY);
            final ZyLineContent nextModelLineContent = this.getNextModelLineContent(caretMouseReleasedY);
            this.m_caretY = this.getNextModelLineIndex(caretMouseReleasedY);
            if (n == lineContent2.getText().length() && caretMouseReleasedY != 0) {
                this.m_caretY = caretMouseReleasedY;
                final IZyEditableObject lineObject2 = lineContent2.getLineObject();
                if (lineObject2 != null) {
                    lineObject2.updateComment("\r", ECommentPlacement.BEHIND_LINE);
                    this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), lineObject2.getPersistentModel());
                }
            }
            else if (nextModelLineContent != null && nextModelLineContent.getLineObject() != null && !this.isLabelComment(this.m_caretY)) {
                String s = "\r";
                if (this.isComment(0, this.m_caretY)) {
                    final String s2 = "\n";
                    final String value = String.valueOf(this.getMultiLineComment(this.m_caretY));
                    s = ((value.length() != 0) ? s2.concat(value) : new String(s2));
                }
                nextModelLineContent.getLineObject().updateComment(s, ECommentPlacement.ABOVE_LINE);
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), nextModelLineContent.getLineObject().getPersistentModel());
            }
            else if (nextModelLineContent != null && this.isLabelComment(this.m_caretY)) {
                final String value2 = String.valueOf("\n");
                final String value3 = String.valueOf(this.getMultiLineComment(this.m_caretY));
                this.getLabelContent().getModel().update((value3.length() != 0) ? value2.concat(value3) : new String(value2));
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.getLabelContent().getModel().getPersistentModel());
            }
            else {
                this.m_caretY = caretMouseReleasedY + 1;
                this.getLabelContent().getModel().update("\r");
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.getLabelContent().getModel().getPersistentModel());
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
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        if (lineFragmentObject != null) {
            String s = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
            if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                s = this.getMultiLineComment(caretMouseReleasedY);
            }
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), lineFragmentObject, s, this.isAboveLineComment(caretMouseReleasedY), this.isBehindLineComment(caretEndPosX, caretMouseReleasedY), this.isLabelComment(caretMouseReleasedY), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
}
