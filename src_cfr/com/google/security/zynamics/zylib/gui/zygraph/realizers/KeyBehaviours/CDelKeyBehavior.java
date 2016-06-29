/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ECommentPlacement;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.Point;
import java.util.List;

public class CDelKeyBehavior
extends CAbstractKeyBehavior {
    private boolean m_wasSelection = false;
    private IZyEditableObject m_editableObject;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;

    public CDelKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    private Point getMultiCommentEndPoint(int n2, int n3) {
        if (!this.isComment(n2, n3)) return null;
        ZyLineContent zyLineContent = this.getLineContent(n3);
        int n4 = ((IZyEditableObject)zyLineContent.getLineFragmentObjectList().get(zyLineContent.getLineFragmentObjectList().size() - 1)).getEnd();
        int n5 = n3;
        int n6 = n3 + 1;
        while (n6 <= this.getLabelContent().getLastLineIndexOfModelAt(n3)) {
            ZyLineContent zyLineContent2 = this.getLineContent(n6);
            int n7 = zyLineContent2.getLineFragmentObjectList().size();
            IZyEditableObject iZyEditableObject = zyLineContent2.getLineFragmentObjectAt(0);
            if (iZyEditableObject == null) return new Point(n4, n5);
            if (iZyEditableObject.isCommentDelimiter()) {
                n4 = zyLineContent2.getLineFragmentObjectAt(n7 - 1).getEnd();
                n5 = n6;
            }
            ++n6;
        }
        return new Point(n4, n5);
    }

    @Override
    protected void initUndoHistory() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        this.m_editableObject = zyLineContent.getLineObject();
        if (iZyEditableObject == null) return;
        String string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
        this.m_isAboveComment = this.isAboveLineComment(n3);
        this.m_isBehindComment = this.isBehindLineComment(n2, n3);
        this.m_isLabelComment = this.isLabelComment(n3);
        if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), this.m_editableObject, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }

    @Override
    protected void updateCaret() {
        this.m_wasSelection = false;
    }

    @Override
    protected void updateClipboard() {
        if (!this.isShiftPressed()) return;
        if (this.isCtrlPressed()) return;
        if (this.isAltPressed()) return;
        String string = this.getSelectedText();
        ClipboardHelpers.copyToClipboard(string);
    }

    @Override
    protected void updateLabelContent() {
        ZyLineContent zyLineContent;
        String string;
        IZyEditableObject iZyEditableObject;
        if (this.m_wasSelection) {
            return;
        }
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent2 = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject2 = zyLineContent2.getLineFragmentObjectAt(n2);
        if (iZyEditableObject2 == null) {
            return;
        }
        if (!this.isComment(n2, n3)) throw new RuntimeException("Not implemented yet.");
        if (iZyEditableObject2.isCommentDelimiter()) {
            return;
        }
        Point point = this.getMultiCommentEndPoint(n2, n3);
        if (n3 == point.y) {
            if (n2 == point.x) return;
            if (n2 == point.x - 1 && zyLineContent2.getText().endsWith("\n")) {
                return;
            }
        }
        int n4 = n2 - iZyEditableObject2.getStart();
        String string2 = string = zyLineContent2.getText().substring(iZyEditableObject2.getStart(), iZyEditableObject2.getEnd());
        if (n4 < string.length()) {
            string2 = String.format("%s%s", string.substring(0, n4), string.substring(n4 + 1));
        } else if (this.isComment(n2, n3) && n3 < this.getLabelContent().getLineCount() - 1 && (zyLineContent = this.getLineContent(n3 + 1)).getLineObject() == zyLineContent2.getLineObject() && (iZyEditableObject = zyLineContent.getLineFragmentObjectAt(0)) != null && iZyEditableObject.isCommentDelimiter()) {
            string2 = string.substring(0, n4 - 1);
        }
        if (this.isComment(n2, n3) && !(string2 = this.getMultilineComment(n3, string2)).endsWith("\r")) {
            string2 = String.valueOf(string2).concat("\r");
        }
        iZyEditableObject2.update(string2);
        if (this.isLabelComment(n3)) {
            zyLineContent2.getLineObject().update(string2);
        } else if (this.isAboveLineComment(n3)) {
            zyLineContent2.getLineObject().updateComment(string2, ECommentPlacement.ABOVE_LINE);
        } else if (this.isBehindLineComment(n2, n3)) {
            zyLineContent2.getLineObject().updateComment(string2, ECommentPlacement.BEHIND_LINE);
        }
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyLineContent2.getLineObject().getPersistentModel());
    }

    @Override
    protected void updateSelection() {
        this.m_wasSelection = this.isSelection();
        this.deleteSelection();
    }

    @Override
    protected void updateUndoHistory() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        String string = "";
        if (iZyEditableObject == null) return;
        string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
        if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), this.m_editableObject, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }
}

