package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;

public class CCursorKeyBehavior extends CAbstractKeyBehavior
{
    public CCursorKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    private int getXdelta() {
        int n = 0;
        if (this.getEvent().getKeyCode() == 37) {
            n = -1;
        }
        else if (this.getEvent().getKeyCode() == 39) {
            n = 1;
        }
        return n;
    }
    
    private int getYdelta() {
        int n = 0;
        if (this.getEvent().getKeyCode() == 38) {
            n = -1;
        }
        else if (this.getEvent().getKeyCode() == 40) {
            n = 1;
        }
        return n;
    }
    
    protected void handleNotShiftAndCtrl(final int n, final int n2) {
        final ZyLabelContent labelContent = this.getLabelContent();
        int caretStartPosX = this.getCaretStartPosX();
        int caretMousePressedX = this.getCaretMousePressedX();
        final int caretMousePressedY = this.getCaretMousePressedY();
        int caretEndPosX = this.getCaretEndPosX();
        int caretMouseReleasedX = this.getCaretMouseReleasedX();
        final int caretMouseReleasedY = this.getCaretMouseReleasedY();
        if (n != 0) {
            final ZyLineContent lineContent = labelContent.getLineContent(caretMouseReleasedY);
            final String concat = String.valueOf(lineContent.getText()).concat(" ");
            if (n > 0) {
                final boolean b = concat.charAt(caretEndPosX) == ' ';
                int n3 = 0;
                for (int i = caretEndPosX; i < concat.length(); ++i) {
                    n3 = i;
                    if (b) {
                        if (concat.charAt(i) != ' ') {
                            break;
                        }
                    }
                    else if (concat.charAt(i) == ' ') {
                        break;
                    }
                }
                if ((lineContent.getText().endsWith("\n") || lineContent.getText().endsWith("\r")) && lineContent.getText().length() == n3) {
                    --n3;
                }
                caretStartPosX = n3;
                caretMousePressedX = n3;
                caretMouseReleasedX = n3;
                caretEndPosX = n3;
            }
            else if (n < 0) {
                if (caretEndPosX == 0) {
                    return;
                }
                final boolean b2 = concat.charAt(caretEndPosX - 1) == ' ';
                int n4 = caretEndPosX - 1;
                for (int j = caretEndPosX - 1; j >= 0; --j) {
                    if (b2) {
                        if (concat.charAt(j) != ' ') {
                            break;
                        }
                    }
                    else if (concat.charAt(j) == ' ') {
                        break;
                    }
                    n4 = j;
                }
                caretStartPosX = n4;
                caretMousePressedX = n4;
                caretMouseReleasedX = n4;
                caretEndPosX = n4;
            }
            this.setCaret(caretStartPosX, caretMousePressedX, caretMousePressedY, caretEndPosX, this.correctMouseReleasedX(caretMouseReleasedX, caretMouseReleasedY, caretMousePressedY), caretMouseReleasedY);
        }
        else if (n2 != 0) {
            this.handleNotShiftAndNotCtrl(0, n2);
        }
    }
    
    protected void handleNotShiftAndNotCtrl(final int n, final int n2) {
        final ZyLabelContent labelContent = this.getLabelContent();
        int caretStartPosX = this.getCaretStartPosX();
        int n3 = this.getCaretMousePressedX();
        int caretMousePressedY = this.getCaretMousePressedY();
        int caretEndPosX = this.getCaretEndPosX();
        int caretMouseReleasedX = this.getCaretMouseReleasedX();
        int caretMouseReleasedY = this.getCaretMouseReleasedY();
        if (this.isSelection() && n != 0 && n2 == 0) {
            if (caretMousePressedY <= caretMouseReleasedY && n3 <= caretMouseReleasedX) {
                if (n < 0) {
                    caretMouseReleasedX = n3;
                    caretEndPosX = caretStartPosX;
                    caretMouseReleasedY = caretMousePressedY;
                }
                else {
                    n3 = caretMouseReleasedX;
                    caretStartPosX = caretMouseReleasedX;
                    caretMousePressedY = caretMouseReleasedY;
                }
            }
            else if (n > 0) {
                caretMouseReleasedX = n3;
                caretEndPosX = caretStartPosX;
                caretMouseReleasedY = caretMousePressedY;
            }
            else {
                n3 = caretMouseReleasedX;
                caretStartPosX = caretMouseReleasedX;
                caretMousePressedY = caretMouseReleasedY;
            }
        }
        else {
            final int n4 = caretMouseReleasedX;
            caretMousePressedY = caretMouseReleasedY + n2;
            if (caretMousePressedY < 0) {
                caretMousePressedY = 0;
            }
            if (caretMousePressedY > labelContent.getLineCount() - 1) {
                caretMousePressedY = labelContent.getLineCount() - 1;
            }
            caretMouseReleasedY = caretMousePressedY;
            n3 = n4 + n;
            if (n3 < 0) {
                n3 = 0;
            }
            if (n3 > labelContent.getLineContent(caretMouseReleasedY).getTextLayout().getCharacterCount() - 1) {
                n3 = labelContent.getLineContent(caretMouseReleasedY).getTextLayout().getCharacterCount();
            }
            caretEndPosX = n3;
            caretMouseReleasedX = n3;
            caretStartPosX = caretEndPosX;
        }
        this.setCaret(caretStartPosX, n3, caretMousePressedY, caretEndPosX, this.correctMouseReleasedX(caretMouseReleasedX, caretMouseReleasedY, caretMousePressedY), caretMouseReleasedY);
    }
    
    protected void handleShiftAndCtrl(final int n, final int n2) {
        if (n2 != 0) {
            this.handleShiftAndNotCtrl(0, n2);
        }
        else if (n != 0) {
            final ZyLineContent lineContent = this.getLabelContent().getLineContent(this.getCaretMouseReleasedY());
            int caretStartPosX = this.getCaretStartPosX();
            final int caretMousePressedX = this.getCaretMousePressedX();
            final int caretMousePressedY = this.getCaretMousePressedY();
            int caretEndPosX = this.getCaretEndPosX();
            int n3 = this.getCaretMouseReleasedX();
            final int caretMouseReleasedY = this.getCaretMouseReleasedY();
            final String concat = String.valueOf(lineContent.getText()).concat(" ");
            if (n > 0) {
                final boolean b = concat.charAt(caretEndPosX) == ' ';
                int n4 = 0;
                for (int i = caretEndPosX; i < concat.length(); ++i) {
                    n4 = i;
                    if (b) {
                        if (concat.charAt(i) != ' ') {
                            break;
                        }
                    }
                    else if (concat.charAt(i) == ' ') {
                        break;
                    }
                }
                if ((lineContent.getText().endsWith("\n") || lineContent.getText().endsWith("\r")) && lineContent.getText().length() == n4) {
                    --n4;
                }
                caretStartPosX = caretMousePressedX;
                n3 = n4;
                caretEndPosX = n4;
                final boolean b2 = this.getCaretEndPosX() == lineContent.getText().length();
                final boolean b3 = lineContent.getText().endsWith("\n") && this.getCaretEndPosX() == lineContent.getText().length() - 1;
                final boolean b4 = lineContent.getText().endsWith("\r") && this.getCaretEndPosX() == lineContent.getText().length() - 1;
                if (b2 || b3 || b4) {
                    n3 = this.getMaxLineLength(this.getCaretMousePressedY(), this.getCaretMouseReleasedY());
                }
            }
            else if (n < 0) {
                if (caretEndPosX == 0) {
                    return;
                }
                final boolean b5 = concat.charAt(caretEndPosX - 1) == ' ';
                int n5 = caretEndPosX - 1;
                for (int j = caretEndPosX - 1; j >= 0; --j) {
                    if (b5) {
                        if (concat.charAt(j) != ' ') {
                            break;
                        }
                    }
                    else if (concat.charAt(j) == ' ') {
                        break;
                    }
                    n5 = j;
                }
                caretStartPosX = caretMousePressedX;
                n3 = n5;
                caretEndPosX = n5;
            }
            this.setCaret(caretStartPosX, caretMousePressedX, caretMousePressedY, caretEndPosX, this.correctMouseReleasedX(n3, caretMouseReleasedY, caretMousePressedY), caretMouseReleasedY);
        }
    }
    
    protected void handleShiftAndNotCtrl(final int n, final int n2) {
        final ZyLabelContent labelContent = this.getLabelContent();
        int caretStartPosX = this.getCaretStartPosX();
        final int caretMousePressedX = this.getCaretMousePressedX();
        final int caretMousePressedY = this.getCaretMousePressedY();
        int n3 = this.getCaretEndPosX();
        int caretMouseReleasedX = this.getCaretMouseReleasedX();
        int caretMouseReleasedY = this.getCaretMouseReleasedY();
        final int lineCount = labelContent.getLineCount();
        if (n != 0 || n2 != 0) {
            caretMouseReleasedY += n2;
            if (caretMouseReleasedY < 0) {
                caretMouseReleasedY = 0;
            }
            if (caretMouseReleasedY > lineCount - 1) {
                caretMouseReleasedY = lineCount - 1;
            }
            caretMouseReleasedX += n;
            if (caretMouseReleasedX < 0) {
                caretMouseReleasedX = 0;
            }
            int n4 = caretMousePressedY;
            int n5 = caretMouseReleasedY;
            if (n4 > n5) {
                n4 = caretMouseReleasedY;
                n5 = caretMousePressedY;
            }
            int max = 0;
            for (int i = n4; i <= n5; ++i) {
                max = Math.max(max, labelContent.getLineContent(i).getText().length());
            }
            if (caretMouseReleasedX > max) {
                caretMouseReleasedX = max;
            }
            if (caretMouseReleasedX <= labelContent.getLineContent(caretMouseReleasedY).getTextLayout().getCharacterCount()) {
                n3 = caretMouseReleasedX;
            }
            else {
                n3 = labelContent.getLineContent(caretMouseReleasedY).getTextLayout().getCharacterCount();
            }
            caretStartPosX = caretMousePressedX;
        }
        this.setCaret(caretStartPosX, caretMousePressedX, caretMousePressedY, n3, this.correctMouseReleasedX(caretMouseReleasedX, caretMouseReleasedY, caretMousePressedY), caretMouseReleasedY);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
        final int xdelta = this.getXdelta();
        final int ydelta = this.getYdelta();
        if (!this.isShiftPressed() && !this.isCtrlPressed()) {
            this.handleNotShiftAndNotCtrl(xdelta, ydelta);
        }
        else if (this.isShiftPressed() && !this.isCtrlPressed()) {
            this.handleShiftAndNotCtrl(xdelta, ydelta);
        }
        else if (!this.isShiftPressed() && this.isCtrlPressed()) {
            this.handleNotShiftAndCtrl(xdelta, ydelta);
        }
        else if (this.isShiftPressed() && this.isCtrlPressed()) {
            this.handleShiftAndCtrl(xdelta, ydelta);
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
