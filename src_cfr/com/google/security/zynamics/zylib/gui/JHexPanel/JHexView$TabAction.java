/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JHexPanel;

import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$1;
import com.google.security.zynamics.zylib.gui.JHexPanel.JHexView$Views;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class JHexView$TabAction
extends AbstractAction {
    private static final long serialVersionUID = -3265020583339369531L;
    final /* synthetic */ JHexView this$0;

    private JHexView$TabAction(JHexView jHexView) {
        this.this$0 = jHexView;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (JHexView.access$2300(this.this$0) == JHexView$Views.HEX_VIEW) {
            JHexView.access$2302(this.this$0, JHexView$Views.ASCII_VIEW);
            JHexView.access$1300(this.this$0, JHexView.access$1200(this.this$0) - JHexView.access$1200(this.this$0) % 2);
        } else {
            JHexView.access$2302(this.this$0, JHexView$Views.HEX_VIEW);
        }
        JHexView.access$2200(this.this$0).setVisible(true);
        this.this$0.repaint();
    }

    /* synthetic */ JHexView$TabAction(JHexView jHexView, JHexView$1 jHexView$1) {
        this(jHexView);
    }
}

