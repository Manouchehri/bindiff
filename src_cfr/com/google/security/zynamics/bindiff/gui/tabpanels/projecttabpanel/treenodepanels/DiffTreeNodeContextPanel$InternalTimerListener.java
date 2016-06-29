/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class DiffTreeNodeContextPanel$InternalTimerListener
implements ActionListener {
    final /* synthetic */ DiffTreeNodeContextPanel this$0;

    private DiffTreeNodeContextPanel$InternalTimerListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        this.this$0 = diffTreeNodeContextPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DiffTreeNodeContextPanel.access$400(this.this$0).setTitleColor(Color.BLACK);
        DiffTreeNodeContextPanel.access$400(this.this$0).setTitle("Description");
        this.this$0.updateUI();
        DiffTreeNodeContextPanel.access$500(this.this$0).stop();
    }

    /* synthetic */ DiffTreeNodeContextPanel$InternalTimerListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel, DiffTreeNodeContextPanel$1 diffTreeNodeContextPanel$1) {
        this(diffTreeNodeContextPanel);
    }
}

