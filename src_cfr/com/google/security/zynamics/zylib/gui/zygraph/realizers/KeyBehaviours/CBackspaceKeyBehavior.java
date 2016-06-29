/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.List;

public class CBackspaceKeyBehavior
extends CAbstractKeyBehavior {
    private int m_caretX;
    private int m_caretY;
    private boolean m_wasSelection = false;
    private boolean m_isBehindComment = false;
    private boolean m_isAboveComment = false;
    private boolean m_isLabelComment = false;
    private IZyEditableObject m_editableObject = null;
    private IZyEditableObject m_lineModel = null;
    private boolean m_wasEditablePosition = false;

    public CBackspaceKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    private void handleLineComments() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        if (this.m_editableObject == null) {
            return;
        }
        int n4 = this.getLabelContent().getFirstLineIndexOfModelAt(n3);
        int n5 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n3);
        int n6 = n5 != -1 && this.m_isBehindComment ? n5 : n4;
        String string = zyLineContent.getText();
        String string2 = "";
        if (!this.isCommentDelimiter(n2, n3)) {
            char c2;
            if (string.length() > 0 && string.length() == this.m_editableObject.getEnd() && n2 == string.length() && ((c2 = string.charAt(string.length() - 1)) == '\n' || c2 == '\r')) {
                n2 = -1;
            }
            string2 = String.format("%s%s", string.substring(this.m_editableObject.getStart(), n2 - 1), string.substring(n2, this.m_editableObject.getEnd()));
            this.m_caretY = n3;
            this.m_caretX = n2 - 1;
            string2 = this.getMultilineComment(this.m_caretY, string2);
        } else {
            List list = zyLineContent.getLineFragmentObjectList();
            this.m_editableObject = (IZyEditableObject)list.get(list.size() - 1);
            if (n6 == n3) {
                if (this.m_editableObject.getLength() != 1) {
                    this.m_caretX = this.getCaretEndPosX();
                    this.m_caretY = this.getCaretMouseReleasedY();
                    return;
                }
                if (n3 > 0) {
                    this.m_caretY = n3 - 1;
                    ZyLineContent zyLineContent2 = this.getLineContent(this.m_caretY);
                    this.m_caretX = zyLineContent2.getText().length();
                }
                string2 = this.getMultilineComment(n3, string2);
            } else {
                ZyLineContent zyLineContent3 = this.getLineContent(n3 - 1);
                String string3 = zyLineContent3.getText();
                if (!string3.isEmpty() && !zyLineContent3.getLineObject().isPlaceholder()) {
                    IZyEditableObject iZyEditableObject = zyLineContent3.getLineFragmentObjectAt(string3.length() - 1);
                    string2 = string3.substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd() - 1);
                    this.m_caretY = n3 - 1;
                    this.m_caretX = string3.length() - 1;
                    string2 = this.getMultilineComment(this.m_caretY, string2);
                } else {
                    this.m_caretY = n3 - 1;
                    this.m_caretX = 0;
                }
            }
        }
        if (string2.endsWith("\n")) {
            string2 = String.valueOf(string2.substring(0, string2.length() - 1)).concat("\r");
        }
        if (this.m_isAboveComment) {
            this.m_editableObject.updateComment(string2, ECommentPlacement.ABOVE_LINE);
        } else if (this.m_isBehindComment) {
            this.m_editableObject.updateComment(string2, ECommentPlacement.BEHIND_LINE);
        } else if (this.m_isLabelComment) {
            this.m_editableObject.update(string2);
        }
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.m_editableObject.getPersistentModel());
    }

    private void handleTextFragment() {
        throw new RuntimeException("Not implemneted yet");
    }

    private boolean isCommentDelimiter(int n2, int n3) {
        IZyEditableObject iZyEditableObject;
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(n2);
        IZyEditableObject iZyEditableObject3 = iZyEditableObject = n2 > 0 ? (iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2 - 1)) : null;
        if (iZyEditableObject2 != null) {
            if (iZyEditableObject2.isCommentDelimiter()) return true;
        }
        if (iZyEditableObject == null) return false;
        if (!iZyEditableObject.isCommentDelimiter()) return false;
        return true;
    }

    @Override
    protected void initUndoHistory() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        this.m_editableObject = zyLineContent.getLineFragmentObjectAt(n2);
        this.m_lineModel = zyLineContent.getLineObject();
        if (this.m_editableObject == null) return;
        this.m_wasEditablePosition = true;
        String string = zyLineContent.getText().substring(this.m_editableObject.getStart(), this.m_editableObject.getEnd());
        this.m_isAboveComment = this.isAboveLineComment(n3);
        this.m_isBehindComment = this.isBehindLineComment(n2, n3);
        this.m_isLabelComment = this.isLabelComment(n3);
        if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_editableObject, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
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
        if (this.m_wasSelection) return;
        if (this.isComment(this.m_caretX, this.m_caretY)) {
            this.handleLineComments();
            return;
        }
        if (this.getLineContent(this.m_caretY).getLineFragmentObjectAt(this.m_caretX) == null) return;
        this.handleTextFragment();
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
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        String string = "";
        if (zyLineContent == null || zyLineContent.getLineObject() == null || this.m_lineModel.getPersistentModel() != zyLineContent.getLineObject().getPersistentModel()) {
            if (!this.m_isLabelComment) {
                int n4 = 0;
                if (n3 + 1 < this.getLabelContent().getLineCount()) {
                    n4 = 1;
                    zyLineContent = this.getLineContent(n3 + n4);
                }
                if (this.m_lineModel.getPersistentModel() != zyLineContent.getLineObject().getPersistentModel() && n3 > 0) {
                    n4 = -1;
                    zyLineContent = this.getLineContent(n3 + n4);
                }
                n3 += n4;
            }
        } else if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), this.m_lineModel.getPersistentModel(), this.m_lineModel, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }
}

