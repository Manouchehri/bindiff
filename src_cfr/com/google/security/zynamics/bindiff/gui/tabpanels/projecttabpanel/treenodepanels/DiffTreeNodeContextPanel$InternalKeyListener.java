/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

final class DiffTreeNodeContextPanel$InternalKeyListener
implements KeyListener {
    private final int KEY_TYPED_SAVE_THRESHOLD = 50;
    private int typedCount;
    final /* synthetic */ DiffTreeNodeContextPanel this$0;

    private DiffTreeNodeContextPanel$InternalKeyListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        this.this$0 = diffTreeNodeContextPanel;
        this.KEY_TYPED_SAVE_THRESHOLD = 50;
        this.typedCount = 0;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        ++this.typedCount;
        if (this.typedCount <= 50) return;
        DiffTreeNodeContextPanel.access$300(this.this$0);
        this.typedCount = 0;
    }

    /* synthetic */ DiffTreeNodeContextPanel$InternalKeyListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel, DiffTreeNodeContextPanel$1 diffTreeNodeContextPanel$1) {
        this(diffTreeNodeContextPanel);
    }
}

