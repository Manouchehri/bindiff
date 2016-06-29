package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;

public class CHomeKeyBehavior extends CAbstractKeyBehavior
{
    public CHomeKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
        if (!this.isShiftPressed() && !this.isCtrlPressed()) {
            this.setCaret(0, 0, this.getCaretMousePressedY(), 0, 0, this.getCaretMouseReleasedY());
        }
        else if (this.isShiftPressed() && !this.isCtrlPressed()) {
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), 0, 0, this.getCaretMouseReleasedY());
        }
        else if (!this.isShiftPressed() && this.isCtrlPressed()) {
            this.setCaret(0, 0, 0, 0, 0, 0);
        }
        else if (this.isShiftPressed() && this.isCtrlPressed()) {
            this.setCaret(this.getCaretStartPosX(), this.getCaretMousePressedX(), this.getCaretMousePressedY(), 0, 0, 0);
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
