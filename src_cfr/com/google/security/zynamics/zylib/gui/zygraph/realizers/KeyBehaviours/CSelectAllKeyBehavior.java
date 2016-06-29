/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours;

import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.CAbstractKeyBehavior;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.KeyBehaviours.UndoHistroy.CUndoManager;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import java.util.Iterator;

public class CSelectAllKeyBehavior
extends CAbstractKeyBehavior {
    public CSelectAllKeyBehavior(CUndoManager cUndoManager) {
        super(cUndoManager);
    }

    @Override
    protected void initUndoHistory() {
    }

    @Override
    protected void updateCaret() {
        int n2 = this.getLabelContent().getLineCount() - 1;
        int n3 = 0;
        Object object = this.getLabelContent().iterator();
        do {
            if (!object.hasNext()) {
                object = this.getLineContent(n2);
                int n4 = object.getText().length();
                this.setCaret(0, 0, 0, n4, n3, n2);
                return;
            }
            ZyLineContent zyLineContent = (ZyLineContent)object.next();
            n3 = Math.max(zyLineContent.getText().length(), n3);
        } while (true);
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

