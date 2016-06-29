/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ColorPanel;

import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel;
import com.google.security.zynamics.zylib.gui.ColorPanel.ColorPanel$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorPanel$InternalListener
extends MouseAdapter {
    final /* synthetic */ ColorPanel this$0;

    private ColorPanel$InternalListener(ColorPanel colorPanel) {
        this.this$0 = colorPanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!ColorPanel.access$100(this.this$0)) return;
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.getClickCount() != 1) return;
        ColorPanel.access$200(this.this$0);
    }

    /* synthetic */ ColorPanel$InternalListener(ColorPanel colorPanel, ColorPanel$1 colorPanel$1) {
        this(colorPanel);
    }
}

