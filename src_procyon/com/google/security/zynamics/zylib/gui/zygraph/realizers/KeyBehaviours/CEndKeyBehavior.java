package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CEndKeyBehavior extends CAbstractKeyBehavior
{
    public CEndKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
        if (!this.isShiftPressed() && !this.isCtrlPressed()) {
            final int caretMouseReleasedY = this.getCaretMouseReleasedY();
            final int lastLineXPos = this.getLastLineXPos(caretMouseReleasedY);
            this.setCaret(lastLineXPos, lastLineXPos, caretMouseReleasedY, lastLineXPos, lastLineXPos, caretMouseReleasedY);
        }
        else if (this.isShiftPressed() && !this.isCtrlPressed()) {
            final int caretMouseReleasedY2 = this.getCaretMouseReleasedY();
            int n2;
            final int n = n2 = this.getLineContent(caretMouseReleasedY2).getTextLayout().getCharacterCount();
            final ZyLineContent lineContent = this.getLineContent(this.getCaretMouseReleasedY());
            final boolean b = this.getCaretEndPosX() == lineContent.getText().length();
            final boolean b2 = lineContent.getText().endsWith("\n") && this.getCaretEndPosX() == lineContent.getText().length() - 1;
            final boolean b3 = lineContent.getText().endsWith("\r") && this.getCaretEndPosX() == lineContent.getText().length() - 1;
            if (b || b2 || b3) {
                n2 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
            }
            if ((lineContent.getText().endsWith("\n") || lineContent.getText().endsWith("\r")) && n2 > 0) {
                --n2;
            }
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), n, n2, caretMouseReleasedY2);
        }
        else if (!this.isShiftPressed() && this.isCtrlPressed()) {
            final ZyLabelContent labelContent = this.getLabelContent();
            final int length = labelContent.getLineContent(labelContent.getLineCount() - 1).getText().length();
            final int n3 = labelContent.getLineCount() - 1;
            this.setCaret(length, length, n3, length, length, n3);
        }
        else if (this.isShiftPressed() && this.isCtrlPressed()) {
            final int n4 = this.getLabelContent().getLineCount() - 1;
            final int length2 = this.getLabelContent().getLineContent(n4).getText().length();
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), length2, length2, n4);
        }
    }
    
    @Override
    protected void updateClipboard() {
    }
    
    @Override
    protected void updateLabelContent() {
    }
    
    @Override
    protected void updateSelection() {
    }
    
    @Override
    protected void updateUndoHistory() {
    }
}
