/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog;

import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;

class GraphNodeTreeOptionsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ GraphNodeTreeOptionsDialog this$0;

    private GraphNodeTreeOptionsDialog$InternalButtonListener(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog) {
        this.this$0 = graphNodeTreeOptionsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(GraphNodeTreeOptionsDialog.access$100(this.this$0))) {
            GraphNodeTreeOptionsDialog.access$202(this.this$0, true);
            this.this$0.setVisible(false);
            return;
        }
        if (actionEvent.getSource().equals(GraphNodeTreeOptionsDialog.access$300(this.this$0))) {
            GraphNodeTreeOptionsDialog.access$400(this.this$0).restoreInitialSettings();
            GraphNodeTreeOptionsDialog.access$500(this.this$0).restoreInitialSettings();
            GraphNodeTreeOptionsDialog.access$600(this.this$0).restoreInitialSettings();
            this.this$0.setVisible(false);
            return;
        }
        if (!actionEvent.getSource().equals(GraphNodeTreeOptionsDialog.access$700(this.this$0))) return;
        this.this$0.setDefaults(this.this$0.tab.getSelectedIndex());
    }

    /* synthetic */ GraphNodeTreeOptionsDialog$InternalButtonListener(GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog, GraphNodeTreeOptionsDialog$1 graphNodeTreeOptionsDialog$1) {
        this(graphNodeTreeOptionsDialog);
    }
}

