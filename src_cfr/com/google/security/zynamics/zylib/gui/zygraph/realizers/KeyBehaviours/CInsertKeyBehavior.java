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
import java.awt.Point;

public class CInsertKeyBehavior
extends CAbstractKeyBehavior {
    private int m_caretX = 0;
    private int m_caretY = 0;
    private boolean m_isAboveComment;
    private boolean m_isBehindComment;
    private boolean m_isLabelComment;
    private boolean m_wasUneditableSelection;
    private IZyEditableObject m_editableObject;

    public CInsertKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    private boolean isCopy() {
        if (!this.isCtrlPressed()) return false;
        if (this.isShiftPressed()) return false;
        if (this.isAltPressed()) return false;
        return true;
    }

    private boolean isPaste() {
        if (this.isCtrlPressed()) return false;
        if (!this.isShiftPressed()) return false;
        if (this.isAltPressed()) return false;
        return true;
    }

    @Override
    protected void initUndoHistory() {
        if (!this.isPaste()) return;
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        boolean bl2 = false;
        String string = "";
        this.m_isAboveComment = this.isAboveLineComment(n3);
        this.m_isLabelComment = this.isLabelComment(n3);
        if (n2 == zyLineContent.getText().length() && !this.isComment(n2, n3)) {
            this.m_isBehindComment = true;
            bl2 = true;
            iZyEditableObject = zyLineContent.getLineObject();
        } else {
            this.m_isBehindComment = this.isBehindLineComment(n2, n3);
        }
        this.m_editableObject = iZyEditableObject;
        if (iZyEditableObject == null) return;
        if (!bl2) {
            string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
            if (this.isComment(n2, n3)) {
                string = this.getMultiLineComment(n3);
            }
        }
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), iZyEditableObject, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }

    @Override
    protected void updateCaret() {
        if (!this.isCopy()) {
            if (!this.isPaste()) return;
        }
        this.setCaret(this.m_caretX, this.m_caretX, this.m_caretY, this.m_caretX, this.m_caretX, this.m_caretY);
    }

    @Override
    protected void updateClipboard() {
        if (!this.isCopy()) return;
        String string = this.getSelectedText();
        ClipboardHelpers.copyToClipboard(string);
    }

    @Override
    protected void updateLabelContent() {
        if (!this.isPaste()) return;
        if (this.m_wasUneditableSelection) {
            this.m_caretX = this.getCaretEndPosX();
            this.m_caretY = this.getCaretMouseReleasedY();
            return;
        }
        Point point = this.pasteClipboardText();
        this.m_caretX = point.x;
        this.m_caretY = point.y;
    }

    @Override
    protected void updateSelection() {
        if (!this.isPaste()) return;
        this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
        this.deleteSelection();
    }

    @Override
    protected void updateUndoHistory() {
        if (!this.isPaste()) return;
        if (this.m_editableObject == null) return;
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        if (iZyEditableObject == null) return;
        String string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
        if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), iZyEditableObject, string, this.m_isAboveComment, this.m_isBehindComment, this.m_isLabelComment, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }
}

