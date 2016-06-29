/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.JCheckedListbox;
import com.google.security.zynamics.zylib.gui.JCheckedListbox$1;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class JCheckedListbox$InternalListener
extends MouseAdapter {
    final /* synthetic */ JCheckedListbox this$0;

    private JCheckedListbox$InternalListener(JCheckedListbox jCheckedListbox) {
        this.this$0 = jCheckedListbox;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!this.this$0.isEnabled()) {
            return;
        }
        if (mouseEvent.getPoint().x > 20) {
            return;
        }
        int n2 = this.this$0.locationToIndex(mouseEvent.getPoint());
        JCheckedListbox.access$200((JCheckedListbox)this.this$0)[n2] = !JCheckedListbox.access$200(this.this$0)[n2];
        this.this$0.updateUI();
        JCheckedListbox.access$300(this.this$0, n2, n2, false);
    }

    /* synthetic */ JCheckedListbox$InternalListener(JCheckedListbox jCheckedListbox, JCheckedListbox$1 jCheckedListbox$1) {
        this(jCheckedListbox);
    }
}

