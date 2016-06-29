/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler$1;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class CDefaultLabelEventHandler$InternalFocusListener
implements FocusListener {
    final /* synthetic */ CDefaultLabelEventHandler this$0;

    private CDefaultLabelEventHandler$InternalFocusListener(CDefaultLabelEventHandler cDefaultLabelEventHandler) {
        this.this$0 = cDefaultLabelEventHandler;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        this.this$0.deactivateLabelContent();
    }

    /* synthetic */ CDefaultLabelEventHandler$InternalFocusListener(CDefaultLabelEventHandler cDefaultLabelEventHandler, CDefaultLabelEventHandler$1 cDefaultLabelEventHandler$1) {
        this(cDefaultLabelEventHandler);
    }
}

