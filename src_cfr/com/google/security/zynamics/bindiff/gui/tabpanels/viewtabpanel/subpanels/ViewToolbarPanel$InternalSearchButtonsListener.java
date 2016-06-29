/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSeacherFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewToolbarPanel$InternalSearchButtonsListener
implements ActionListener {
    final /* synthetic */ ViewToolbarPanel this$0;

    public ViewToolbarPanel$InternalSearchButtonsListener(ViewToolbarPanel viewToolbarPanel) {
        this.this$0 = viewToolbarPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(ViewToolbarPanel.access$3300(this.this$0))) {
            GraphSeacherFunctions.clearResults(ViewToolbarPanel.access$3400(this.this$0).getGraphs());
            ViewToolbarPanel.access$3500(this.this$0).notifySearchFieldListener();
            return;
        }
        if (!actionEvent.getSource().equals(ViewToolbarPanel.access$3600(this.this$0))) return;
        ViewToolbarPanel.access$3700(this.this$0).setVisible(true);
    }
}

