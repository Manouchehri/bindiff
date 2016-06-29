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
import java.awt.event.KeyEvent;

public class CCharKeyBehavior
extends CAbstractKeyBehavior {
    private int m_caretX;
    private IZyEditableObject m_editableObject = null;
    private boolean m_isLabelComment = false;
    private boolean m_isAboveComment = false;
    private boolean m_isBehindComment = false;
    private boolean m_wasUneditableSelection;

    public CCharKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    @Override
    protected void initUndoHistory() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        this.m_isAboveComment = this.isAboveLineComment(n3);
        this.m_isBehindComment = this.isBehindLineComment(n2, n3);
        this.m_isLabelComment = this.isLabelComment(n3);
        boolean bl2 = false;
        if (n2 == zyLineContent.getText().length() && !this.isComment(n2, n3)) {
            this.m_isBehindComment = true;
            bl2 = true;
            iZyEditableObject = zyLineContent.getLineObject();
        }
        this.m_editableObject = iZyEditableObject;
        String string = "";
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
        int n2 = this.getCaretMouseReleasedY();
        this.setCaret(this.m_caretX, this.m_caretX, n2, this.m_caretX, this.m_caretX, n2);
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
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        this.m_caretX = n2;
        if (this.isComment(n2, n3)) {
            ++this.m_caretX;
            ZyLineContent zyLineContent = this.getLineContent(n3);
            IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
            if (iZyEditableObject == null) return;
            if (iZyEditableObject.isCommentDelimiter()) {
                return;
            }
            int n4 = n2 - iZyEditableObject.getStart();
            String string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
            String string2 = String.valueOf(this.getEvent().getKeyChar());
            String string3 = String.format("%s%s%s", string.substring(0, n4), string2, string.substring(n4));
            if (this.isComment(n2, n3)) {
                string3 = this.getMultilineComment(n3, string3);
            }
            iZyEditableObject.update(string3);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), iZyEditableObject.getPersistentModel());
            return;
        }
        if (this.isEditable(n2, n3)) {
            throw new RuntimeException("Not implemented yet.");
        }
        ZyLineContent zyLineContent = this.getLineContent(n3);
        if (n2 != zyLineContent.getText().length()) return;
        if (zyLineContent.getLineObject() == null) return;
        zyLineContent.getLineObject().updateComment(Character.toString(this.getEvent().getKeyChar()), ECommentPlacement.BEHIND_LINE);
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel());
        this.m_caretX = this.getLineContent(n3).getText().length();
    }

    @Override
    protected void updateSelection() {
        this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
        this.deleteSelection();
    }

    @Override
    protected void updateUndoHistory() {
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

