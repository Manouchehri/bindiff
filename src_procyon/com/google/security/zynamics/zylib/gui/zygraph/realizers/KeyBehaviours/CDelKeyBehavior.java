package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CDelKeyBehavior extends CAbstractKeyBehavior
{
    private boolean m_wasSelection;
    private IZyEditableObject m_editableObject;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;
    
    public CDelKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_wasSelection = false;
    }
    
    private Point getMultiCommentEndPoint(final int n, final int n2) {
        if (this.isComment(n, n2)) {
            final ZyLineContent lineContent = this.getLineContent(n2);
            int n3 = lineContent.getLineFragmentObjectList().get(lineContent.getLineFragmentObjectList().size() - 1).getEnd();
            int n4 = n2;
            for (int i = n2 + 1; i <= this.getLabelContent().getLastLineIndexOfModelAt(n2); ++i) {
                final ZyLineContent lineContent2 = this.getLineContent(i);
                final int size = lineContent2.getLineFragmentObjectList().size();
                final IZyEditableObject lineFragmentObject = lineContent2.getLineFragmentObjectAt(0);
                if (lineFragmentObject == null) {
                    break;
                }
                if (lineFragmentObject.isCommentDelimiter()) {
                    n3 = lineContent2.getLineFragmentObjectAt(size - 1).getEnd();
                    n4 = i;
                }
            }
            return new Point(n3, n4);
        }
        return null;
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
            this.udpateUndolist(this.getLabelContent(), lineContent.getLineObject().getPersistentModel(), this.m_editableObject, s, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
    
    @Override
    protected void updateCaret() {
        this.m_wasSelection = false;
    }
    
    @Override
    protected void updateClipboard() {
        if (this.isShiftPressed() && !this.isCtrlPressed() && !this.isAltPressed()) {
            ClipboardHelpers.copyToClipboard(this.getSelectedText());
        }
    }
    
    @Override
    protected void updateLabelContent() {
        if (this.m_wasSelection) {
            return;
        }
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        if (lineFragmentObject == null) {
            return;
        }
        if (!this.isComment(caretEndPosX, caretMouseReleasedY)) {
            throw new RuntimeException("Not implemented yet.");
        }
        if (lineFragmentObject.isCommentDelimiter()) {
            return;
        }
        final Point multiCommentEndPoint = this.getMultiCommentEndPoint(caretEndPosX, caretMouseReleasedY);
        if (caretMouseReleasedY == multiCommentEndPoint.y && (caretEndPosX == multiCommentEndPoint.x || (caretEndPosX == multiCommentEndPoint.x - 1 && lineContent.getText().endsWith("\n")))) {
            return;
        }
        final int n = caretEndPosX - lineFragmentObject.getStart();
        String s2;
        final String s = s2 = lineContent.getText().substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd());
        if (n < s.length()) {
            s2 = String.format("%s%s", s.substring(0, n), s.substring(n + 1));
        }
        else if (this.isComment(caretEndPosX, caretMouseReleasedY) && caretMouseReleasedY < this.getLabelContent().getLineCount() - 1) {
            final ZyLineContent lineContent2 = this.getLineContent(caretMouseReleasedY + 1);
            if (lineContent2.getLineObject() == lineContent.getLineObject()) {
                final IZyEditableObject lineFragmentObject2 = lineContent2.getLineFragmentObjectAt(0);
                if (lineFragmentObject2 != null && lineFragmentObject2.isCommentDelimiter()) {
                    s2 = s.substring(0, n - 1);
                }
            }
        }
        if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
            s2 = this.getMultilineComment(caretMouseReleasedY, s2);
            if (!s2.endsWith("\r")) {
                s2 = String.valueOf(s2).concat("\r");
            }
        }
        lineFragmentObject.update(s2);
        if (this.isLabelComment(caretMouseReleasedY)) {
            lineContent.getLineObject().update(s2);
        }
        else if (this.isAboveLineComment(caretMouseReleasedY)) {
            lineContent.getLineObject().updateComment(s2, ECommentPlacement.ABOVE_LINE);
        }
        else if (this.isBehindLineComment(caretEndPosX, caretMouseReleasedY)) {
            lineContent.getLineObject().updateComment(s2, ECommentPlacement.BEHIND_LINE);
        }
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), lineContent.getLineObject().getPersistentModel());
    }
    
    @Override
    protected void updateSelection() {
        this.m_wasSelection = this.isSelection();
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
