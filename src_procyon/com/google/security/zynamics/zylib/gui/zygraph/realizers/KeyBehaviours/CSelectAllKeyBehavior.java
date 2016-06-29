package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import java.util.*;

public class CSelectAllKeyBehavior extends CAbstractKeyBehavior
{
    public CSelectAllKeyBehavior(final CUndoManager cUndoManager) {
        super(cUndoManager);
    }
    
    @Override
    protected void initUndoHistory() {
    }
    
    @Override
    protected void updateCaret() {
        final int n = this.getLabelContent().getLineCount() - 1;
        int max = 0;
        final Iterator iterator = this.getLabelContent().iterator();
        while (iterator.hasNext()) {
            max = Math.max(iterator.next().getText().length(), max);
        }
        this.setCaret(0, 0, 0, this.getLineContent(n).getText().length(), max, n);
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
