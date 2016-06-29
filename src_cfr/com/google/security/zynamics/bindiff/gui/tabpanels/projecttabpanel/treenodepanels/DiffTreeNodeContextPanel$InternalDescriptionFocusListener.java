/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DiffTreeNodeContextPanel$1;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class DiffTreeNodeContextPanel$InternalDescriptionFocusListener
implements FocusListener {
    final /* synthetic */ DiffTreeNodeContextPanel this$0;

    private DiffTreeNodeContextPanel$InternalDescriptionFocusListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel) {
        this.this$0 = diffTreeNodeContextPanel;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        DiffTreeNodeContextPanel.access$300(this.this$0);
    }

    /* synthetic */ DiffTreeNodeContextPanel$InternalDescriptionFocusListener(DiffTreeNodeContextPanel diffTreeNodeContextPanel, DiffTreeNodeContextPanel$1 diffTreeNodeContextPanel$1) {
        this(diffTreeNodeContextPanel);
    }
}

