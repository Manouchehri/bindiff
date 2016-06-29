/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyEditableObject;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyLineEditor;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyCaret;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;

public abstract class CAbstractKeyBehavior {
    private ZyLabelContent m_labelContent = null;
    private final CUndoManager m_undoManager;
    private KeyEvent m_event = null;
    private boolean m_alt;
    private boolean m_ctrl;
    private boolean m_shift;

    public CAbstractKeyBehavior(CUndoManager cUndoManager) {
        this.m_undoManager = (CUndoManager)Preconditions.checkNotNull(cUndoManager, "Error: Undo manager can't be null.");
    }

    private ZyCaret getCaret() {
        return this.m_labelContent.getCaret();
    }

    private String getSingleLineCommentText(ZyLineContent zyLineContent) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = zyLineContent.getText();
        boolean bl2 = false;
        Iterator iterator = zyLineContent.getLineFragmentObjectList().iterator();
        while (iterator.hasNext()) {
            IZyEditableObject iZyEditableObject = (IZyEditableObject)iterator.next();
            if (iZyEditableObject.isCommentDelimiter()) {
                bl2 = true;
                continue;
            }
            if (!bl2) continue;
            String string2 = string.substring(iZyEditableObject.getStart(), iZyEditableObject.getEnd());
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    private void setModifier(KeyEvent keyEvent) {
        this.m_ctrl = false;
        this.m_shift = false;
        this.m_alt = false;
        if (keyEvent.getModifiersEx() == 192) {
            this.m_ctrl = true;
            this.m_shift = true;
            return;
        }
        if (keyEvent.getModifiersEx() == 640) {
            this.m_ctrl = true;
            this.m_alt = true;
            return;
        }
        if (keyEvent.getModifiersEx() == 576) {
            this.m_alt = true;
            this.m_shift = true;
            return;
        }
        if (keyEvent.isAltDown()) {
            this.m_alt = true;
            return;
        }
        if (keyEvent.isControlDown()) {
            this.m_ctrl = true;
            return;
        }
        if (!keyEvent.isShiftDown()) return;
        this.m_shift = true;
    }

    private void updateLabelSize() {
        ZyLabelContent zyLabelContent = this.getLabelContent();
        IZyEditableObject iZyEditableObject = zyLabelContent.getModel();
        zyLabelContent.getLineEditor().recreateLabelLines(zyLabelContent, iZyEditableObject);
    }

    protected int correctMouseReleasedX(int n2, int n3, int n4) {
        int n5 = this.getLastLineXPos(n3);
        if (n2 <= n5) return n2;
        if (n3 != n4) return n2;
        return n5;
    }

    protected void deleteSelection() {
        ZyLineContent zyLineContent;
        int n2;
        if (!this.isSelection()) return;
        if (!this.isDeleteableSelection()) return;
        int n3 = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        int n4 = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        int n5 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n6 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n7 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
        int n8 = this.m_labelContent.getFirstLineIndexOfModelAt(n5);
        int n9 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n5);
        int n10 = this.m_labelContent.getLastLineIndexOfModelAt(n5);
        int n11 = n8;
        int n12 = n10;
        if (n9 != -1) {
            if (n5 < n9) {
                n12 = n9 - 1;
            } else {
                n11 = n9;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        ZyLineContent zyLineContent2 = this.getLineContent(n5);
        IZyEditableObject iZyEditableObject = zyLineContent2.getLineFragmentObjectAt(n3);
        if (iZyEditableObject == null) {
            for (n2 = n11; n2 <= n12 && (iZyEditableObject = (zyLineContent = this.getLineContent(n2)).getLineFragmentObjectAt(n3)) == null; ++n2) {
            }
        }
        if (n11 == n12 && !this.isComment(n7, n5)) {
            if (iZyEditableObject.isCommentDelimiter()) {
                n3 = iZyEditableObject.getEnd();
                n7 = iZyEditableObject.getEnd();
                iZyEditableObject = zyLineContent2.getLineFragmentObjectAt(n7);
            }
            String string = zyLineContent2.getText();
            stringBuilder = new StringBuilder(String.format("%s%s", string.substring(iZyEditableObject.getStart(), n3), string.substring(n4)));
        } else {
            for (n2 = n11; n2 <= n12; ++n2) {
                zyLineContent = this.getLineContent(n2);
                IZyEditableObject iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(n3);
                if (iZyEditableObject2 == null) {
                    iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(this.getLastLineXPos(n2));
                }
                int n13 = n3;
                int n14 = n4;
                if (iZyEditableObject2.isCommentDelimiter() && n4 < (n13 = (iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(iZyEditableObject2.getEnd())).getStart())) {
                    n14 = n13;
                }
                String string = zyLineContent.getText();
                int n15 = Math.min(string.length(), n14);
                if (n2 >= n5 && n2 <= n6 && string.length() > n13) {
                    String string2 = String.format("%s%s", string.substring(iZyEditableObject2.getStart(), n13), string.substring(n15));
                    if (string2.equals("\n") || string2.equals("\r")) continue;
                    stringBuilder.append(string2);
                    continue;
                }
                stringBuilder.append(zyLineContent.getText(iZyEditableObject2));
            }
        }
        if (stringBuilder.toString().endsWith("\n")) {
            stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 1));
        }
        if (!stringBuilder.toString().endsWith("\r")) {
            stringBuilder.append("\r");
        }
        if (iZyEditableObject != null && iZyEditableObject.isCommentDelimiter()) {
            n7 = iZyEditableObject.getEnd();
            n3 = iZyEditableObject.getEnd();
        }
        for (int i2 = n11; i2 <= n12; ++i2) {
            zyLineContent2 = this.getLineContent(i2);
            if (zyLineContent2.getText().length() < n3 || n5 > i2) continue;
            n5 = i2;
            n7 = n3;
            break;
        }
        if (iZyEditableObject != null) {
            iZyEditableObject.update(stringBuilder.toString());
            this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), iZyEditableObject.getPersistentModel());
        }
        this.setCaret(n7, n3, n5, n7, n3, n5);
    }

    protected int getCaretEndPosX() {
        return this.getCaret().getCaretEndPos();
    }

    protected int getCaretMousePressedX() {
        return this.getCaret().getXmousePressed();
    }

    protected int getCaretMousePressedY() {
        return this.getCaret().getYmousePressed();
    }

    protected int getCaretMouseReleasedX() {
        return this.getCaret().getXmouseReleased();
    }

    protected int getCaretMouseReleasedY() {
        return this.getCaret().getYmouseReleased();
    }

    protected int getCaretStartPosX() {
        return this.getCaret().getCaretStartPos();
    }

    protected KeyEvent getEvent() {
        return this.m_event;
    }

    protected ZyLabelContent getLabelContent() {
        return this.m_labelContent;
    }

    protected int getLastLineXPos(int n2) {
        ZyLineContent zyLineContent = this.getLineContent(n2);
        String string = zyLineContent.getText();
        if (string.endsWith("\n")) return string.length() - 1;
        if (!string.endsWith("\r")) return string.length();
        return string.length() - 1;
    }

    protected ZyLineContent getLineContent(int n2) {
        return this.m_labelContent.getLineContent(n2);
    }

    protected int getMaxLineLength(int n2, int n3) {
        return this.getCaret().getMaxLineLength(n2, n3);
    }

    protected String getMultilineComment(int n2, String string) {
        int n3;
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        int n4 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n2);
        int n5 = this.m_labelContent.getFirstLineIndexOfModelAt(n2);
        int n6 = this.m_labelContent.getLastLineIndexOfModelAt(n2);
        int n7 = this.isAboveLineComment(n2) ? n5 : n4;
        int n8 = n3 = this.isAboveLineComment(n2) ? n4 - 1 : n6;
        if (n4 == -1) {
            n7 = n5;
            n3 = n6;
        }
        for (int i2 = n7; i2 <= n3; ++i2) {
            if (i2 == n2) {
                stringBuilder.append(string);
                continue;
            }
            ZyLineContent zyLineContent = this.m_labelContent.getLineContent(i2);
            String string3 = this.getSingleLineCommentText(zyLineContent);
            stringBuilder.append(string3);
        }
        if (stringBuilder.toString().equals("")) {
            string2 = string;
            return string2;
        }
        string2 = stringBuilder.toString();
        return string2;
    }

    protected String getMultiLineComment(int n2) {
        int n3;
        StringBuilder stringBuilder = new StringBuilder();
        int n4 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n2);
        int n5 = this.m_labelContent.getFirstLineIndexOfModelAt(n2);
        int n6 = this.m_labelContent.getLastLineIndexOfModelAt(n2);
        int n7 = this.isAboveLineComment(n2) ? n5 : n4;
        int n8 = n3 = this.isAboveLineComment(n2) ? n4 - 1 : n6;
        if (n4 < 0) {
            n7 = n5;
            n3 = n6;
        }
        int n9 = n7;
        while (n9 <= n3) {
            ZyLineContent zyLineContent = this.m_labelContent.getLineContent(n9);
            String string = this.getSingleLineCommentText(zyLineContent);
            stringBuilder.append(string);
            ++n9;
        }
        return stringBuilder.toString();
    }

    protected ZyLineContent getNextModelLineContent(int n2) {
        ZyLineContent zyLineContent = this.m_labelContent.getLineContent(n2);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineObject();
        int n3 = n2 + 1;
        while (n3 < this.m_labelContent.getLineCount()) {
            ZyLineContent zyLineContent2 = this.m_labelContent.getLineContent(n3);
            if (zyLineContent2 == null) {
                return null;
            }
            IZyEditableObject iZyEditableObject2 = zyLineContent2.getLineObject();
            if (iZyEditableObject != iZyEditableObject2 && !iZyEditableObject2.isPlaceholder()) {
                return zyLineContent2;
            }
            ++n3;
        }
        return null;
    }

    protected int getNextModelLineIndex(int n2) {
        ZyLineContent zyLineContent = this.getNextModelLineContent(n2);
        int n3 = n2 + 1;
        while (n3 < this.m_labelContent.getLineCount()) {
            if (zyLineContent != null && !zyLineContent.getLineObject().isPlaceholder()) {
                return this.getLabelContent().getLineIndex(zyLineContent);
            }
            ++n3;
        }
        return -1;
    }

    protected String getSelectedText() {
        if (!this.isSelection()) {
            return "";
        }
        int n2 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n3 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n4 = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        int n5 = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        StringBuilder stringBuilder = new StringBuilder();
        int n6 = n2;
        while (n6 <= n3) {
            ZyLineContent zyLineContent = this.getLineContent(n6);
            int n7 = zyLineContent.getText().length();
            if (n4 < n7) {
                String string;
                String string2;
                int n8 = n5;
                if (n5 > n7) {
                    n8 = n7;
                }
                if (!(string2 = (string = zyLineContent.getText()).substring(n4, n8)).endsWith("\n") && n6 != n3) {
                    string2 = String.valueOf(string2).concat("\n");
                }
                if (string2.endsWith("\r") || n6 == n3 && string2.endsWith("\n")) {
                    string2 = string2.substring(0, string2.length() - 1);
                }
                stringBuilder.append(string2);
            } else if (n6 != n3) {
                stringBuilder.append("\n");
            }
            ++n6;
        }
        return stringBuilder.toString();
    }

    protected abstract void initUndoHistory();

    protected boolean isAboveLineComment(int n2) {
        int n3 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n2);
        if (n3 < 0) {
            return false;
        }
        if (n3 > n2) return true;
        return false;
    }

    protected boolean isAltPressed() {
        return this.m_alt;
    }

    protected boolean isBehindLineComment(int n2, int n3) {
        IZyEditableObject iZyEditableObject;
        int n4 = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n3);
        if (n4 < 0) {
            return false;
        }
        if (n4 < n3) {
            return true;
        }
        if (n4 != n3) return false;
        ZyLineContent zyLineContent = this.getLabelContent().getLineContent(n3);
        if (zyLineContent == null) {
            return false;
        }
        Iterator<E> iterator = zyLineContent.getLineFragmentObjectList().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(iZyEditableObject = (IZyEditableObject)iterator.next()).isCommentDelimiter());
        if (iZyEditableObject.getStart() > n2) return false;
        return true;
    }

    protected boolean isComment(int n2, int n3) {
        IZyEditableObject iZyEditableObject;
        ZyLineContent zyLineContent = this.getLabelContent().getLineContent(n3);
        if (zyLineContent == null) return false;
        boolean bl2 = false;
        Iterator<E> iterator = zyLineContent.getLineFragmentObjectList().iterator();
        do {
            if (!iterator.hasNext()) return false;
            iZyEditableObject = (IZyEditableObject)iterator.next();
            if (!iZyEditableObject.isCommentDelimiter()) continue;
            bl2 = true;
        } while (n2 < iZyEditableObject.getStart() || !bl2);
        return true;
    }

    protected boolean isCtrlPressed() {
        return this.m_ctrl;
    }

    protected boolean isDeleteableSelection() {
        int n2 = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n3 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        int n4 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
        int n5 = Math.max(this.getCaretStartPosX(), this.getCaretEndPosX());
        ZyLineContent zyLineContent = this.getLineContent(n2);
        ZyLineContent zyLineContent2 = this.getLineContent(n3);
        IZyEditableObject iZyEditableObject = zyLineContent.getLineFragmentObjectAt(n4);
        IZyEditableObject iZyEditableObject2 = zyLineContent.getLineFragmentObjectAt(n5);
        if (zyLineContent.getLineObject() != zyLineContent2.getLineObject()) {
            return false;
        }
        if (!this.isComment(n4, n2)) {
            if (iZyEditableObject != iZyEditableObject2) return false;
            if (iZyEditableObject != null) return true;
            if (iZyEditableObject2 != null) return true;
            return false;
        }
        if (n3 <= n2) return true;
        int n6 = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n2);
        if (n6 == -1) return true;
        if (n2 < n6 && n3 >= n6) {
            return false;
        }
        if (n2 < n6) return true;
        if (n3 >= n6) return true;
        return false;
    }

    protected boolean isEditable(int n2, int n3) {
        ZyLineContent zyLineContent = this.getLabelContent().getLineContent(n3);
        return zyLineContent.isEditable(n2);
    }

    protected boolean isLabelComment(int n2) {
        if (this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n2) != -1) return false;
        return true;
    }

    protected boolean isSelection() {
        return this.getCaret().isSelection();
    }

    protected boolean isShiftPressed() {
        return this.m_shift;
    }

    /*
     * Exception decompiling
     */
    protected Point pasteClipboardText() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.NullPointerException
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$ExpressionStatement.access$200(LValueAssignmentAndAliasCondenser.java:237)
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$MutationRewriterSecondPass.getLValueReplacement(LValueAssignmentAndAliasCondenser.java:480)
        // org.benf.cfr.reader.bytecode.analysis.parse.expression.LValueExpression.replaceSingleUsageLValues(LValueExpression.java:59)
        // org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.replaceSingleUsageLValues(CastExpression.java:99)
        // org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractConstructorInvokation.replaceSingleUsageLValues(AbstractConstructorInvokation.java:62)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.ReturnValueStatement.replaceSingleUsageLValues(ReturnValueStatement.java:50)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.IfExitingStatement.replaceSingleUsageLValues(IfExitingStatement.java:40)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.condense(Op03SimpleStatement.java:434)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LValueProp.condenseLValues(LValueProp.java:47)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.AnonymousArray.resugarAnonymousArrays(AnonymousArray.java:129)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:564)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    protected void redo() {
        this.m_undoManager.redo();
    }

    protected void setCaret(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.getCaret().setCaret(n2, n3, n4, n5, n6, n7);
    }

    protected void udpateUndolist(ZyLabelContent zyLabelContent, Object object, IZyEditableObject iZyEditableObject, String string, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.m_undoManager.addUndoState(zyLabelContent, object, iZyEditableObject, string, bl2, bl3, bl4, n2, n3, n4, n5, n6, n7);
    }

    protected void undo() {
        this.m_undoManager.undo();
    }

    protected abstract void updateCaret();

    protected abstract void updateClipboard();

    protected abstract void updateLabelContent();

    protected abstract void updateSelection();

    protected abstract void updateUndoHistory();

    public void keyPressed(ZyLabelContent zyLabelContent, KeyEvent keyEvent) {
        this.m_labelContent = zyLabelContent;
        this.m_event = keyEvent;
        this.setModifier(keyEvent);
        if (zyLabelContent.isEditable()) {
            this.initUndoHistory();
        }
        this.updateClipboard();
        this.updateSelection();
        if (zyLabelContent.isEditable()) {
            this.updateLabelContent();
        }
        this.updateCaret();
        if (zyLabelContent.isEditable()) {
            this.updateUndoHistory();
            this.updateLabelSize();
        }
        this.m_alt = false;
        this.m_shift = false;
        this.m_ctrl = false;
    }
}

