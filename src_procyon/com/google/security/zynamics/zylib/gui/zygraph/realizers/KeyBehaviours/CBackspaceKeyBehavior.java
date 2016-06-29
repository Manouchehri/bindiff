package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public class CBackspaceKeyBehavior extends CAbstractKeyBehavior
{
    private int m_caretX;
    private int m_caretY;
    private boolean m_wasSelection;
    private boolean m_isBehindComment;
    private boolean m_isAboveComment;
    private boolean m_isLabelComment;
    private IZyEditableObject m_editableObject;
    private IZyEditableObject m_lineModel;
    private boolean m_wasEditablePosition;
    
    public CBackspaceKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
        this.m_wasSelection = false;
        this.m_isBehindComment = false;
        this.m_isAboveComment = false;
        this.m_isLabelComment = false;
        this.m_editableObject = null;
        this.m_lineModel = null;
        this.m_wasEditablePosition = false;
    }
    
    private void handleLineComments() {
        int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        if (this.m_editableObject == null) {
            return;
        }
        final int firstLineIndexOfModel = this.getLabelContent().getFirstLineIndexOfModelAt(caretMouseReleasedY);
        final int nonPureCommentLineIndexOfModel = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(caretMouseReleasedY);
        final int n = (nonPureCommentLineIndexOfModel != -1 && this.m_isBehindComment) ? nonPureCommentLineIndexOfModel : firstLineIndexOfModel;
        final String text = lineContent.getText();
        String s = "";
        if (!this.isCommentDelimiter(caretEndPosX, caretMouseReleasedY)) {
            if (text.length() > 0 && text.length() == this.m_editableObject.getEnd() && caretEndPosX == text.length()) {
                final char char1 = text.charAt(text.length() - 1);
                if (char1 == '\n' || char1 == '\r') {
                    caretEndPosX = -1;
                }
            }
            final String format = String.format("%s%s", text.substring(this.m_editableObject.getStart(), caretEndPosX - 1), text.substring(caretEndPosX, this.m_editableObject.getEnd()));
            this.m_caretY = caretMouseReleasedY;
            this.m_caretX = caretEndPosX - 1;
            s = this.getMultilineComment(this.m_caretY, format);
        }
        else {
            final List lineFragmentObjectList = lineContent.getLineFragmentObjectList();
            this.m_editableObject = lineFragmentObjectList.get(lineFragmentObjectList.size() - 1);
            if (n == caretMouseReleasedY) {
                if (this.m_editableObject.getLength() != 1) {
                    this.m_caretX = this.getCaretEndPosX();
                    this.m_caretY = this.getCaretMouseReleasedY();
                    return;
                }
                if (caretMouseReleasedY > 0) {
                    this.m_caretY = caretMouseReleasedY - 1;
                    this.m_caretX = this.getLineContent(this.m_caretY).getText().length();
                }
                s = this.getMultilineComment(caretMouseReleasedY, s);
            }
            else {
                final ZyLineContent lineContent2 = this.getLineContent(caretMouseReleasedY - 1);
                final String text2 = lineContent2.getText();
                if (!text2.isEmpty() && !lineContent2.getLineObject().isPlaceholder()) {
                    final IZyEditableObject lineFragmentObject = lineContent2.getLineFragmentObjectAt(text2.length() - 1);
                    final String substring = text2.substring(lineFragmentObject.getStart(), lineFragmentObject.getEnd() - 1);
                    this.m_caretY = caretMouseReleasedY - 1;
                    this.m_caretX = text2.length() - 1;
                    s = this.getMultilineComment(this.m_caretY, substring);
                }
                else {
                    this.m_caretY = caretMouseReleasedY - 1;
                    this.m_caretX = 0;
                }
            }
        }
        if (s.endsWith("\n")) {
            s = String.valueOf(s.substring(0, s.length() - 1)).concat("\r");
        }
        if (this.m_isAboveComment) {
            this.m_editableObject.updateComment(s, ECommentPlacement.ABOVE_LINE);
        }
        else if (this.m_isBehindComment) {
            this.m_editableObject.updateComment(s, ECommentPlacement.BEHIND_LINE);
        }
        else if (this.m_isLabelComment) {
            this.m_editableObject.update(s);
        }
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.m_editableObject.getPersistentModel());
    }
    
    private void handleTextFragment() {
        throw new RuntimeException("Not implemneted yet");
    }
    
    private boolean isCommentDelimiter(final int n, final int n2) {
        final ZyLineContent lineContent = this.getLineContent(n2);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(n);
        final IZyEditableObject lineFragmentObject2;
        if (n > 0) {
            lineFragmentObject2 = lineContent.getLineFragmentObjectAt(n - 1);
        }
        final IZyEditableObject zyEditableObject = lineFragmentObject2;
        return (lineFragmentObject != null && lineFragmentObject.isCommentDelimiter()) || (zyEditableObject != null && zyEditableObject.isCommentDelimiter());
    }
    
    @Override
    protected void initUndoHistory() {
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        this.m_editableObject = lineContent.getLineFragmentObjectAt(caretEndPosX);
        this.m_lineModel = lineContent.getLineObject();
        if (this.m_editableObject != null) {
            this.m_wasEditablePosition = true;
            String s = lineContent.getText().substring(this.m_editableObject.getStart(), this.m_editableObject.getEnd());
            this.m_isAboveComment = this.isAboveLineComment(caretMouseReleasedY);
            this.m_isBehindComment = this.isBehindLineComment(caretEndPosX, caretMouseReleasedY);
            this.m_isLabelComment = this.isLabelComment(caretMouseReleasedY);
            if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
                s = this.getMultiLineComment(caretMouseReleasedY);
            }
            this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_editableObject, s, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
        }
    }
    
    @Override
    protected void updateCaret() {
        this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
        this.m_wasSelection = false;
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
        this.m_caretX = this.getCaretEndPosX();
        this.m_caretY = this.getCaretMouseReleasedY();
        if (!this.m_wasSelection) {
            if (this.isComment(this.m_caretX, this.m_caretY)) {
                this.handleLineComments();
            }
            else if (this.getLineContent(this.m_caretY).getLineFragmentObjectAt(this.m_caretX) != null) {
                this.handleTextFragment();
            }
        }
    }
    
    @Override
    protected void updateSelection() {
        this.m_wasSelection = this.isSelection();
        this.deleteSelection();
    }
    
    @Override
    protected void updateUndoHistory() {
        if (!this.m_wasEditablePosition) {
            return;
        }
        this.m_wasEditablePosition = false;
        final int caretEndPosX = this.getCaretEndPosX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(caretMouseReleasedY);
        String multiLineComment = "";
        if (zyLineContent == null || zyLineContent.getLineObject() == null || this.m_lineModel.getPersistentModel() != zyLineContent.getLineObject().getPersistentModel()) {
            if (!this.m_isLabelComment) {
                int n = 0;
                if (caretMouseReleasedY + 1 < this.getLabelContent().getLineCount()) {
                    n = 1;
                    zyLineContent = this.getLineContent(caretMouseReleasedY + n);
                }
                if (this.m_lineModel.getPersistentModel() != zyLineContent.getLineObject().getPersistentModel() && caretMouseReleasedY > 0) {
                    n = -1;
                    this.getLineContent(caretMouseReleasedY + n);
                }
            }
        }
        else if (this.isComment(caretEndPosX, caretMouseReleasedY)) {
            multiLineComment = this.getMultiLineComment(caretMouseReleasedY);
        }
        this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_lineModel, multiLineComment, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }
}
