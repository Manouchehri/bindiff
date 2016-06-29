/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CProgressPanel$InternalActionListener
implements ActionListener {
    final /* synthetic */ CProgressPanel this$0;

    private CProgressPanel$InternalActionListener(CProgressPanel cProgressPanel) {
        this.this$0 = cProgressPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CProgressPanel.access$300(this.this$0);
    }

    /* synthetic */ CProgressPanel$InternalActionListener(CProgressPanel cProgressPanel, CProgressPanel$1 cProgressPanel$1) {
        this(cProgressPanel);
    }
}

