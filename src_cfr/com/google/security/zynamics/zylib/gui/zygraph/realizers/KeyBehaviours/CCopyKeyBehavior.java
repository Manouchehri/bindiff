/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;

public class CCopyKeyBehavior
extends CAbstractKeyBehavior {
    public CCopyKeyBehavior(CUndoManager cUndoManager) {
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
        String string = this.getSelectedText();
        ClipboardHelpers.copyToClipboard(string);
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

