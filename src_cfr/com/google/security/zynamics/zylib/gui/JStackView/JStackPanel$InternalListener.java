/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JStackView;

import com.google.security.zynamics.zylib.gui.JStackView.IStackModelListener;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel;
import com.google.security.zynamics.zylib.gui.JStackView.JStackPanel$1;

class JStackPanel$InternalListener
implements IStackModelListener {
    final /* synthetic */ JStackPanel this$0;

    private JStackPanel$InternalListener(JStackPanel jStackPanel) {
        this.this$0 = jStackPanel;
    }

    @Override
    public void dataChanged() {
        this.this$0.repaint();
    }

    /* synthetic */ JStackPanel$InternalListener(JStackPanel jStackPanel, JStackPanel$1 jStackPanel$1) {
        this(jStackPanel);
    }
}

