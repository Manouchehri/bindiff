/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.gui.SwingInvoker;

class CProgressPanel$1
extends SwingInvoker {
    final /* synthetic */ CProgressPanel this$0;

    CProgressPanel$1(CProgressPanel cProgressPanel) {
        this.this$0 = cProgressPanel;
    }

    @Override
    public void operation() {
        CProgressPanel.access$100(this.this$0).updateUI();
    }
}

