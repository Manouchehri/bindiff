/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.JStackView;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

class JStackView$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ JStackView this$0;

    private JStackView$InternalMouseListener(JStackView jStackView) {
        this.this$0 = jStackView;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        int n2 = mouseWheelEvent.getWheelRotation();
        JStackView.access$200(this.this$0).setValue(JStackView.access$200(this.this$0).getValue() + n2);
    }

    /* synthetic */ JStackView$InternalMouseListener(JStackView jStackView, JStackView$1 jStackView$1) {
        this(jStackView);
    }
}

