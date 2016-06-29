package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import java.awt.event.*;
import com.google.common.base.*;
import java.util.*;
import java.awt.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.strings.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.io.*;

public abstract class CAbstractKeyBehavior
{
    private ZyLabelContent m_labelContent;
    private final CUndoManager m_undoManager;
    private KeyEvent m_event;
    private boolean m_alt;
    private boolean m_ctrl;
    private boolean m_shift;
    
    public CAbstractKeyBehavior(final CUndoManager cUndoManager) {
        this.m_labelContent = null;
        this.m_event = null;
        this.m_undoManager = (CUndoManager)Preconditions.checkNotNull(cUndoManager, (Object)"Error: Undo manager can't be null.");
    }
    
    private ZyCaret getCaret() {
        return this.m_labelContent.getCaret();
    }
    
    private String getSingleLineCommentText(final ZyLineContent zyLineContent) {
        final StringBuilder sb = new StringBuilder();
        final String text = zyLineContent.getText();
        boolean b = false;
        for (final IZyEditableObject zyEditableObject : zyLineContent.getLineFragmentObjectList()) {
            if (zyEditableObject.isCommentDelimiter()) {
                b = true;
            }
            else {
                if (!b) {
                    continue;
                }
                sb.append(text.substring(zyEditableObject.getStart(), zyEditableObject.getEnd()));
            }
        }
        return sb.toString();
    }
    
    private void setModifier(final KeyEvent keyEvent) {
        this.m_ctrl = false;
        this.m_shift = false;
        this.m_alt = false;
        if (keyEvent.getModifiersEx() == 192) {
            this.m_ctrl = true;
            this.m_shift = true;
        }
        else if (keyEvent.getModifiersEx() == 640) {
            this.m_ctrl = true;
            this.m_alt = true;
        }
        else if (keyEvent.getModifiersEx() == 576) {
            this.m_alt = true;
            this.m_shift = true;
        }
        else if (keyEvent.isAltDown()) {
            this.m_alt = true;
        }
        else if (keyEvent.isControlDown()) {
            this.m_ctrl = true;
        }
        else if (keyEvent.isShiftDown()) {
            this.m_shift = true;
        }
    }
    
    private void updateLabelSize() {
        final ZyLabelContent labelContent = this.getLabelContent();
        labelContent.getLineEditor().recreateLabelLines(labelContent, labelContent.getModel());
    }
    
    protected int correctMouseReleasedX(final int n, final int n2, final int n3) {
        final int lastLineXPos = this.getLastLineXPos(n2);
        if (n > lastLineXPos && n2 == n3) {
            return lastLineXPos;
        }
        return n;
    }
    
    protected void deleteSelection() {
        if (this.isSelection() && this.isDeleteableSelection()) {
            int n = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
            final int max = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
            int min = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            final int max2 = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            int n2 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
            final int firstLineIndexOfModel = this.m_labelContent.getFirstLineIndexOfModelAt(min);
            final int nonPureCommentLineIndexOfModel = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(min);
            final int lastLineIndexOfModel = this.m_labelContent.getLastLineIndexOfModelAt(min);
            int n3 = firstLineIndexOfModel;
            int n4 = lastLineIndexOfModel;
            if (nonPureCommentLineIndexOfModel != -1) {
                if (min < nonPureCommentLineIndexOfModel) {
                    n4 = nonPureCommentLineIndexOfModel - 1;
                }
                else {
                    n3 = nonPureCommentLineIndexOfModel;
                }
            }
            StringBuilder sb = new StringBuilder();
            final ZyLineContent lineContent = this.getLineContent(min);
            IZyEditableObject zyEditableObject = lineContent.getLineFragmentObjectAt(n);
            if (zyEditableObject == null) {
                for (int i = n3; i <= n4; ++i) {
                    zyEditableObject = this.getLineContent(i).getLineFragmentObjectAt(n);
                    if (zyEditableObject != null) {
                        break;
                    }
                }
            }
            if (n3 == n4 && !this.isComment(n2, min)) {
                if (zyEditableObject.isCommentDelimiter()) {
                    n = zyEditableObject.getEnd();
                    n2 = zyEditableObject.getEnd();
                    zyEditableObject = lineContent.getLineFragmentObjectAt(n2);
                }
                final String text = lineContent.getText();
                sb = new StringBuilder(String.format("%s%s", text.substring(zyEditableObject.getStart(), n), text.substring(max)));
            }
            else {
                for (int j = n3; j <= n4; ++j) {
                    final ZyLineContent lineContent2 = this.getLineContent(j);
                    IZyEditableObject zyEditableObject2 = lineContent2.getLineFragmentObjectAt(n);
                    if (zyEditableObject2 == null) {
                        zyEditableObject2 = lineContent2.getLineFragmentObjectAt(this.getLastLineXPos(j));
                    }
                    int start = n;
                    int n5 = max;
                    if (zyEditableObject2.isCommentDelimiter()) {
                        zyEditableObject2 = lineContent2.getLineFragmentObjectAt(zyEditableObject2.getEnd());
                        start = zyEditableObject2.getStart();
                        if (max < start) {
                            n5 = start;
                        }
                    }
                    final String text2 = lineContent2.getText();
                    final int min2 = Math.min(text2.length(), n5);
                    if (j >= min && j <= max2 && text2.length() > start) {
                        final String format = String.format("%s%s", text2.substring(zyEditableObject2.getStart(), start), text2.substring(min2));
                        if (!format.equals("\n") && !format.equals("\r")) {
                            sb.append(format);
                        }
                    }
                    else {
                        sb.append(lineContent2.getText(zyEditableObject2));
                    }
                }
            }
            if (sb.toString().endsWith("\n")) {
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            }
            if (!sb.toString().endsWith("\r")) {
                sb.append("\r");
            }
            if (zyEditableObject != null && zyEditableObject.isCommentDelimiter()) {
                n2 = zyEditableObject.getEnd();
                n = zyEditableObject.getEnd();
            }
            for (int k = n3; k <= n4; ++k) {
                if (this.getLineContent(k).getText().length() >= n && min <= k) {
                    min = k;
                    n2 = n;
                    break;
                }
            }
            if (zyEditableObject != null) {
                zyEditableObject.update(sb.toString());
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyEditableObject.getPersistentModel());
            }
            this.setCaret(n2, n, min, n2, n, min);
        }
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
    
    protected int getLastLineXPos(final int n) {
        final String text = this.getLineContent(n).getText();
        if (text.endsWith("\n") || text.endsWith("\r")) {
            return text.length() - 1;
        }
        return text.length();
    }
    
    protected ZyLineContent getLineContent(final int n) {
        return this.m_labelContent.getLineContent(n);
    }
    
    protected int getMaxLineLength(final int n, final int n2) {
        return this.getCaret().getMaxLineLength(n, n2);
    }
    
    protected String getMultilineComment(final int n, final String s) {
        final StringBuilder sb = new StringBuilder();
        final int nonPureCommentLineIndexOfModel = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n);
        final int firstLineIndexOfModel = this.m_labelContent.getFirstLineIndexOfModelAt(n);
        final int lastLineIndexOfModel = this.m_labelContent.getLastLineIndexOfModelAt(n);
        int n2 = this.isAboveLineComment(n) ? firstLineIndexOfModel : nonPureCommentLineIndexOfModel;
        int n3 = this.isAboveLineComment(n) ? (nonPureCommentLineIndexOfModel - 1) : lastLineIndexOfModel;
        if (nonPureCommentLineIndexOfModel == -1) {
            n2 = firstLineIndexOfModel;
            n3 = lastLineIndexOfModel;
        }
        for (int i = n2; i <= n3; ++i) {
            if (i == n) {
                sb.append(s);
            }
            else {
                sb.append(this.getSingleLineCommentText(this.m_labelContent.getLineContent(i)));
            }
        }
        return sb.toString().equals("") ? s : sb.toString();
    }
    
    protected String getMultiLineComment(final int n) {
        final StringBuilder sb = new StringBuilder();
        final int nonPureCommentLineIndexOfModel = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(n);
        final int firstLineIndexOfModel = this.m_labelContent.getFirstLineIndexOfModelAt(n);
        final int lastLineIndexOfModel = this.m_labelContent.getLastLineIndexOfModelAt(n);
        int n2 = this.isAboveLineComment(n) ? firstLineIndexOfModel : nonPureCommentLineIndexOfModel;
        int n3 = this.isAboveLineComment(n) ? (nonPureCommentLineIndexOfModel - 1) : lastLineIndexOfModel;
        if (nonPureCommentLineIndexOfModel < 0) {
            n2 = firstLineIndexOfModel;
            n3 = lastLineIndexOfModel;
        }
        for (int i = n2; i <= n3; ++i) {
            sb.append(this.getSingleLineCommentText(this.m_labelContent.getLineContent(i)));
        }
        return sb.toString();
    }
    
    protected ZyLineContent getNextModelLineContent(final int n) {
        final IZyEditableObject lineObject = this.m_labelContent.getLineContent(n).getLineObject();
        for (int i = n + 1; i < this.m_labelContent.getLineCount(); ++i) {
            final ZyLineContent lineContent = this.m_labelContent.getLineContent(i);
            if (lineContent == null) {
                return null;
            }
            final IZyEditableObject lineObject2 = lineContent.getLineObject();
            if (lineObject != lineObject2 && !lineObject2.isPlaceholder()) {
                return lineContent;
            }
        }
        return null;
    }
    
    protected int getNextModelLineIndex(final int n) {
        final ZyLineContent nextModelLineContent = this.getNextModelLineContent(n);
        for (int i = n + 1; i < this.m_labelContent.getLineCount(); ++i) {
            if (nextModelLineContent != null && !nextModelLineContent.getLineObject().isPlaceholder()) {
                return this.getLabelContent().getLineIndex(nextModelLineContent);
            }
        }
        return -1;
    }
    
    protected String getSelectedText() {
        if (!this.isSelection()) {
            return "";
        }
        final int min = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        final int max = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        final int min2 = Math.min(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        final int max2 = Math.max(this.getCaretMousePressedX(), this.getCaretMouseReleasedX());
        final StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; ++i) {
            final ZyLineContent lineContent = this.getLineContent(i);
            final int length = lineContent.getText().length();
            if (min2 < length) {
                int n;
                if ((n = max2) > length) {
                    n = length;
                }
                String s = lineContent.getText().substring(min2, n);
                if (!s.endsWith("\n") && i != max) {
                    s = String.valueOf(s).concat("\n");
                }
                if (s.endsWith("\r") || (i == max && s.endsWith("\n"))) {
                    s = s.substring(0, s.length() - 1);
                }
                sb.append(s);
            }
            else if (i != max) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    protected abstract void initUndoHistory();
    
    protected boolean isAboveLineComment(final int n) {
        final int nonPureCommentLineIndexOfModel = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n);
        return nonPureCommentLineIndexOfModel >= 0 && nonPureCommentLineIndexOfModel > n;
    }
    
    protected boolean isAltPressed() {
        return this.m_alt;
    }
    
    protected boolean isBehindLineComment(final int n, final int n2) {
        final int nonPureCommentLineIndexOfModel = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n2);
        if (nonPureCommentLineIndexOfModel < 0) {
            return false;
        }
        if (nonPureCommentLineIndexOfModel < n2) {
            return true;
        }
        if (nonPureCommentLineIndexOfModel == n2) {
            final ZyLineContent lineContent = this.getLabelContent().getLineContent(n2);
            if (lineContent == null) {
                return false;
            }
            for (final IZyEditableObject zyEditableObject : lineContent.getLineFragmentObjectList()) {
                if (zyEditableObject.isCommentDelimiter()) {
                    return zyEditableObject.getStart() <= n;
                }
            }
        }
        return false;
    }
    
    protected boolean isComment(final int n, final int n2) {
        final ZyLineContent lineContent = this.getLabelContent().getLineContent(n2);
        if (lineContent != null) {
            boolean b = false;
            for (final IZyEditableObject zyEditableObject : lineContent.getLineFragmentObjectList()) {
                if (zyEditableObject.isCommentDelimiter()) {
                    b = true;
                }
                if (n >= zyEditableObject.getStart() && b) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected boolean isCtrlPressed() {
        return this.m_ctrl;
    }
    
    protected boolean isDeleteableSelection() {
        final int min = Math.min(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        final int max = Math.max(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
        final int min2 = Math.min(this.getCaretStartPosX(), this.getCaretEndPosX());
        final int max2 = Math.max(this.getCaretStartPosX(), this.getCaretEndPosX());
        final ZyLineContent lineContent = this.getLineContent(min);
        final ZyLineContent lineContent2 = this.getLineContent(max);
        final IZyEditableObject lineFragmentObject = lineContent.getLineFragmentObjectAt(min2);
        final IZyEditableObject lineFragmentObject2 = lineContent.getLineFragmentObjectAt(max2);
        if (lineContent.getLineObject() != lineContent2.getLineObject()) {
            return false;
        }
        if (this.isComment(min2, min)) {
            if (max > min) {
                final int nonPureCommentLineIndexOfModel = this.m_labelContent.getNonPureCommentLineIndexOfModelAt(min);
                if (nonPureCommentLineIndexOfModel != -1) {
                    if (min < nonPureCommentLineIndexOfModel && max >= nonPureCommentLineIndexOfModel) {
                        return false;
                    }
                    if (min >= nonPureCommentLineIndexOfModel && max < nonPureCommentLineIndexOfModel) {
                        return false;
                    }
                }
            }
        }
        else if (lineFragmentObject != lineFragmentObject2 || (lineFragmentObject == null && lineFragmentObject2 == null)) {
            return false;
        }
        return true;
    }
    
    protected boolean isEditable(final int n, final int n2) {
        return this.getLabelContent().getLineContent(n2).isEditable(n);
    }
    
    protected boolean isLabelComment(final int n) {
        return this.getLabelContent().getNonPureCommentLineIndexOfModelAt(n) == -1;
    }
    
    protected boolean isSelection() {
        return this.getCaret().isSelection();
    }
    
    protected boolean isShiftPressed() {
        return this.m_shift;
    }
    
    protected Point pasteClipboardText() {
        int n = this.getCaretEndPosX();
        int caretMouseReleasedY = this.getCaretMouseReleasedY();
        boolean b = false;
        final ZyLineContent lineContent = this.getLineContent(caretMouseReleasedY);
        IZyEditableObject zyEditableObject = lineContent.getLineFragmentObjectAt(n);
        if (zyEditableObject == null && n == lineContent.getText().length()) {
            final int nonPureCommentLineIndexOfModel = this.getLabelContent().getNonPureCommentLineIndexOfModelAt(caretMouseReleasedY);
            if (nonPureCommentLineIndexOfModel != -1 && nonPureCommentLineIndexOfModel == caretMouseReleasedY) {
                zyEditableObject = lineContent.getLineObject();
                b = true;
            }
        }
        if (zyEditableObject != null) {
            final String clipboardString = ClipboardHelpers.getClipboardString();
            if (zyEditableObject.isCommentDelimiter()) {
                n = zyEditableObject.getEnd();
                zyEditableObject = lineContent.getLineFragmentObjectAt(n);
                if (zyEditableObject == null) {
                    return null;
                }
            }
            if (this.isComment(n, caretMouseReleasedY)) {
                final int count = StringHelper.count(clipboardString, '\n');
                final int lastIndex = clipboardString.lastIndexOf("\n");
                final int n2 = n - zyEditableObject.getStart();
                final String substring = lineContent.getText().substring(zyEditableObject.getStart(), zyEditableObject.getEnd());
                zyEditableObject.update(this.getMultilineComment(caretMouseReleasedY, String.format("%s%s%s", substring.substring(0, n2), clipboardString, substring.substring(n2))));
                this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyEditableObject.getPersistentModel());
                n += clipboardString.length() - lastIndex - 1;
                caretMouseReleasedY += count;
            }
            else if (b) {
                zyEditableObject.updateComment(clipboardString, ECommentPlacement.BEHIND_LINE);
                if (!this.isLabelComment(caretMouseReleasedY)) {
                    this.getLabelContent().getLineEditor().recreateLabelLines(this.getLabelContent(), zyEditableObject.getPersistentModel());
                    caretMouseReleasedY += StringHelper.count(clipboardString, '\n');
                    n += this.getLineContent(caretMouseReleasedY).getText().length() - 1;
                }
            }
            else {
                final String replace = clipboardString.replace("\n", "").replace("\r", "");
                final int n3 = n;
                n += replace.length();
                final String text = lineContent.getText();
                text.substring(zyEditableObject.getStart(), zyEditableObject.getEnd());
                zyEditableObject.update(String.format("%s%s%s", text.substring(zyEditableObject.getStart(), n3 - zyEditableObject.getStart()), replace, text.substring(n, zyEditableObject.getEnd())));
            }
        }
        return new Point(n, caretMouseReleasedY);
    }
    
    protected void redo() {
        this.m_undoManager.redo();
    }
    
    protected void setCaret(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.getCaret().setCaret(n, n2, n3, n4, n5, n6);
    }
    
    protected void udpateUndolist(final ZyLabelContent zyLabelContent, final Object o, final IZyEditableObject zyEditableObject, final String s, final boolean b, final boolean b2, final boolean b3, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        this.m_undoManager.addUndoState(zyLabelContent, o, zyEditableObject, s, b, b2, b3, n, n2, n3, n4, n5, n6);
    }
    
    protected void undo() {
        this.m_undoManager.undo();
    }
    
    protected abstract void updateCaret();
    
    protected abstract void updateClipboard();
    
    protected abstract void updateLabelContent();
    
    protected abstract void updateSelection();
    
    protected abstract void updateUndoHistory();
    
    public void keyPressed(final ZyLabelContent labelContent, final KeyEvent event) {
        this.m_labelContent = labelContent;
        this.setModifier(this.m_event = event);
        if (labelContent.isEditable()) {
            this.initUndoHistory();
        }
        this.updateClipboard();
        this.updateSelection();
        if (labelContent.isEditable()) {
            this.updateLabelContent();
        }
        this.updateCaret();
        if (labelContent.isEditable()) {
            this.updateUndoHistory();
            this.updateLabelSize();
        }
        this.m_alt = false;
        this.m_shift = false;
        this.m_ctrl = false;
    }
}
