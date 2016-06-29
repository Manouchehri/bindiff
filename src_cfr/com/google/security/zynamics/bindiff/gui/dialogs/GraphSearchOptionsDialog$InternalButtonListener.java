/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.GraphSearchOptionsDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphSearchOptionsDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ GraphSearchOptionsDialog this$0;

    private GraphSearchOptionsDialog$InternalButtonListener(GraphSearchOptionsDialog graphSearchOptionsDialog) {
        this.this$0 = graphSearchOptionsDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(GraphSearchOptionsDialog.access$100(this.this$0))) {
            GraphSearchOptionsDialog.access$200(this.this$0).setRegEx(false);
            GraphSearchOptionsDialog.access$200(this.this$0).setCaseSensitive(false);
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlySelected(false);
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlyVisible(false);
            GraphSearchOptionsDialog.access$300(this.this$0).setSelected(false);
            GraphSearchOptionsDialog.access$400(this.this$0).setSelected(false);
            GraphSearchOptionsDialog.access$500(this.this$0).setSelected(false);
            GraphSearchOptionsDialog.access$600(this.this$0).setSelected(false);
            return;
        }
        if (actionEvent.getSource().equals(GraphSearchOptionsDialog.access$700(this.this$0))) {
            GraphSearchOptionsDialog.access$200(this.this$0).setRegEx(GraphSearchOptionsDialog.access$300(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setCaseSensitive(GraphSearchOptionsDialog.access$400(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlySelected(GraphSearchOptionsDialog.access$500(this.this$0).isSelected());
            GraphSearchOptionsDialog.access$200(this.this$0).setOnlyVisible(GraphSearchOptionsDialog.access$600(this.this$0).isSelected());
        }
        if (actionEvent.getSource().equals(GraphSearchOptionsDialog.access$800(this.this$0))) {
            GraphSearchOptionsDialog.access$300(this.this$0).setSelected(GraphSearchOptionsDialog.access$900(this.this$0));
            GraphSearchOptionsDialog.access$400(this.this$0).setSelected(GraphSearchOptionsDialog.access$1000(this.this$0));
            GraphSearchOptionsDialog.access$600(this.this$0).setSelected(GraphSearchOptionsDialog.access$1100(this.this$0));
            GraphSearchOptionsDialog.access$500(this.this$0).setSelected(GraphSearchOptionsDialog.access$1200(this.this$0));
        }
        this.this$0.setVisible(false);
    }

    /* synthetic */ GraphSearchOptionsDialog$InternalButtonListener(GraphSearchOptionsDialog graphSearchOptionsDialog, GraphSearchOptionsDialog$1 graphSearchOptionsDialog$1) {
        this(graphSearchOptionsDialog);
    }
}

