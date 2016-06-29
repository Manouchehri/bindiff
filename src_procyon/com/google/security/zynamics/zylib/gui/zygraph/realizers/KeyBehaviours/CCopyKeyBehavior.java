package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.general.*;

public class CCopyKeyBehavior extends CAbstractKeyBehavior
{
    public CCopyKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
    }
    
    @Override
    protected void updateClipboard() {
        ClipboardHelpers.copyToClipboard(this.getSelectedText());
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
