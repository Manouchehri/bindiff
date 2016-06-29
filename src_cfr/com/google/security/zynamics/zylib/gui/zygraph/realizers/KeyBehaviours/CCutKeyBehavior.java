/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;

public class CCutKeyBehavior
extends CAbstractKeyBehavior {
    private IZyEditableObject m_editableObject;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;

    public CCutKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
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
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), this.m_editableObject, string, this.isAboveLineComment(n3), this.isBehindLineComment(n2, n3), this.isLabelComment(n3), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }

    @Override
    protected void updateCaret() {
    }

    @Override
    protected void updateClipboard() {
        String string = this.getSelectedText();
        ClipboardHelpers.copyToClipboard(string);
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

