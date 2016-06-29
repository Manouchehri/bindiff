/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView;
import com.google.security.zynamics.zylib.gui.JStackView.JStackView$1;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

class JStackView$InternalListener
implements IStackModelListener,
AdjustmentListener,
ComponentListener {
    final /* synthetic */ JStackView this$0;

    private JStackView$InternalListener(JStackView jStackView) {
        this.this$0 = jStackView;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        if (adjustmentEvent.getSource() == JStackView.access$200(this.this$0)) {
            JStackView.access$300(this.this$0).setFirstRow(adjustmentEvent.getValue());
        } else {
            JStackView.access$300(this.this$0).setFirstColumn(adjustmentEvent.getValue());
        }
        JStackView.access$300(this.this$0).repaint();
    }

    @Override
    public void componentHidden(ComponentEvent componentEvent) {
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        JStackView.access$400(this.this$0);
        JStackView.access$500(this.this$0);
    }

    @Override
    public void componentShown(ComponentEvent componentEvent) {
    }

    @Override
    public void dataChanged() {
        JStackView.access$400(this.this$0);
        JStackView.access$500(this.this$0);
        JStackView.access$300(this.this$0).repaint();
    }

    /* synthetic */ JStackView$InternalListener(JStackView jStackView, JStackView$1 jStackView$1) {
        this(jStackView);
    }
}

