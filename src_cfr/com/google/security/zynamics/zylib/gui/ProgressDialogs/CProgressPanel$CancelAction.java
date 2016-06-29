/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.CProgressPanel;
import com.google.security.zynamics.zylib.resources.Constants;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

class CProgressPanel$CancelAction
extends AbstractAction {
    private static final long serialVersionUID = 3809222494243730570L;
    final /* synthetic */ CProgressPanel this$0;

    public CProgressPanel$CancelAction(CProgressPanel cProgressPanel) {
        this.this$0 = cProgressPanel;
        super("", new ImageIcon(Constants.class.getResource("cancel.png")));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (CProgressPanel.access$200(this.this$0) != null) {
            CProgressPanel.access$200(this.this$0).actionPerformed(actionEvent);
        }
        this.this$0.closeRequested();
    }
}

