/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CUndoKeyBehavior
extends CAbstractKeyBehavior {
    public CUndoKeyBehavior(CUndoManager cUndoManager) {
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
    }

    @Override
    protected void updateLabelContent() {
        this.undo();
    }

    @Override
    protected void updateSelection() {
    }

    @Override
    protected void updateUndoHistory() {
    }
}

