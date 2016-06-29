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

public class CReturnKeyBehavior
extends CAbstractKeyBehavior {
    private int m_caretY = -1;
    private boolean m_wasUneditableSelection;

    public CReturnKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    @Override
    protected void initUndoHistory() {
        IZyEditableObject iZyEditableObject;
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        if (this.isComment(n2, n3)) {
            IZyEditableObject iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(n2);
            String string = "";
            if (iZyEditableObject2.isCommentDelimiter()) {
                n2 = iZyEditableObject2.getEnd();
                iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(n2);
            }
            string = this.getMultiLineComment(n3);
            this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), iZyEditableObject2, string, this.isAboveLineComment(n3), this.isBehindLineComment(n2, n3), this.isLabelComment(n3), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
            return;
        }
        ZyLineContent zyLineContent2 = this.getNextModelLineContent(n3);
        n3 = this.getNextModelLineIndex(n3);
        String string = "";
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        IZyEditableObject iZyEditableObject3 = iZyEditableObject = zyLineContent2 == null ? this.getLabelContent().getModel() : zyLineContent2.getLineObject();
        if (n2 == zyLineContent.getText().length() && this.getCaretMouseReleasedY() != 0) {
            iZyEditableObject = zyLineContent.getLineObject();
            bl3 = true;
        } else if (zyLineContent2 != null && !this.isLabelComment(n3)) {
            if (this.isComment(0, n3)) {
                string = this.getMultiLineComment(n3);
            }
            bl2 = true;
        } else if (zyLineContent2 != null && this.isLabelComment(n3)) {
            String string2 = String.valueOf(string);
            String string3 = String.valueOf(this.getMultiLineComment(n3));
            string = string3.length() != 0 ? string2.concat(string3) : new String(string2);
            bl4 = true;
        } else {
            bl4 = true;
        }
        if (iZyEditableObject == null) {
            return;
        }
        this.udpateUndolist(this.getLabelContent(), iZyEditableObject.getPersistentModel(), iZyEditableObject, string, bl2, bl3, bl4, this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }

    @Override
    protected void updateCaret() {
        if (this.m_caretY <= -1) return;
        if (!this.isComment(this.getCaretEndPosX(), this.m_caretY)) return;
        ZyLineContent zyLineContent = this.getLineContent(this.m_caretY);
        IZyEditableObject iZyEditableObject = (IZyEditableObject)zyLineContent.getLineFragmentObjectList().get(0);
        int n2 = 0;
        if (iZyEditableObject != null) {
            n2 = iZyEditableObject.getEnd();
        }
        this.setCaret(n2, n2, this.m_caretY, n2, n2, this.m_caretY);
    }

    @Override
    protected void updateClipboard() {
    }

    @Override
    protected void updateLabelContent() {
        if (this.m_wasUneditableSelection) {
            return;
        }
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        this.m_caretY = n3 + 1;
        if (this.isComment(n2, n3)) {
            ZyLineContent zyLineContent = this.getLineContent(n3);
            IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
            if (iZyEditableObject.isCommentDelimiter()) {
                n2 = iZyEditableObject.getEnd();
                iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
            }
            int n4 = n2 - iZyEditableObject.getStart();
            String string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
            if (string.endsWith("\r") && n4 == string.length()) {
                --n4;
            }
            String string2 = String.format("%s%s%s", string.substring(0, n4), "\n", string.substring(n4));
            string2 = this.getMultilineComment(n3, string2);
            IZyEditableObject iZyEditableObject2 = zyLineContent.getLineObject();
            if (iZyEditableObject2 == null) {
                return;
            }
            if (this.isAboveLineComment(n3)) {
                iZyEditableObject2.updateComment(string2, ECommentPlacement.ABOVE_LINE);
            } else if (this.isBehindLineComment(n2, n3)) {
                iZyEditableObject2.updateComment(string2, ECommentPlacement.BEHIND_LINE);
            } else if (this.isLabelComment(n3)) {
                iZyEditableObject2.update(string2);
            }
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), iZyEditableObject2.getPersistentModel());
            return;
        }
        ZyLineContent zyLineContent = this.getLineContent(n3);
        ZyLineContent zyLineContent2 = this.getNextModelLineContent(n3);
        this.m_caretY = this.getNextModelLineIndex(n3);
        if (n2 == zyLineContent.getText().length() && n3 != 0) {
            this.m_caretY = n3;
            IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
            if (iZyEditableObject == null) return;
            iZyEditableObject.updateComment("\r", ECommentPlacement.BEHIND_LINE);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), iZyEditableObject.getPersistentModel());
            return;
        }
        if (zyLineContent2 != null && zyLineContent2.getLineObject() != null && !this.isLabelComment(this.m_caretY)) {
            String string = "\r";
            if (this.isComment(0, this.m_caretY)) {
                String string3 = String.valueOf(this.getMultiLineComment(this.m_caretY));
                string = string3.length() != 0 ? "\n".concat(string3) : new String("\n");
            }
            zyLineContent2.getLineObject().updateComment(string, ECommentPlacement.ABOVE_LINE);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyLineContent2.getLineObject().getPersistentModel());
            return;
        }
        if (zyLineContent2 != null && this.isLabelComment(this.m_caretY)) {
            String string = "\n";
            String string4 = String.valueOf(string);
            String string5 = String.valueOf(this.getMultiLineComment(this.m_caretY));
            string = string5.length() != 0 ? string4.concat(string5) : new String(string4);
            this.getLabelContent().getModel().update(string);
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.getLabelContent().getModel().getPersistentModel());
            return;
        }
        this.m_caretY = n3 + 1;
        this.getLabelContent().getModel().update("\r");
        this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), this.getLabelContent().getModel().getPersistentModel());
    }

    @Override
    protected void updateSelection() {
        this.m_wasUneditableSelection = !this.isDeleteableSelection() && this.isSelection();
        this.deleteSelection();
    }

    @Override
    protected void updateUndoHistory() {
        int n2 = this.getCaretEndPosX();
        int n3 = this.getCaretMouseReleasedY();
        ZyLineContent zyLineContent = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n2);
        if (iZyEditableObject == null) return;
        String string = zyLineContent.getText().substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
        if (this.isComment(n2, n3)) {
            string = this.getMultiLineComment(n3);
        }
        this.udpateUndolist(this.getLabelContent(), zyLineContent.getLineObject().getPersistentModel(), iZyEditableObject, string, this.isAboveLineComment(n3), this.isBehindLineComment(n2, n3), this.isLabelComment(n3), this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), this.getCaretEndPosX(), this.getCaretMouseReleasedX(), this.getCaretMouseReleasedY());
    }
}

