/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

class AbstractTable$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ AbstractTable this$0;

    private AbstractTable$InternalMouseListener(AbstractTable abstractTable) {
        this.this$0 = abstractTable;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.getClickCount() != 2) return;
        this.this$0.handleDoubleClick(AbstractTable.access$200(this.this$0, mouseEvent));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3 && !mouseEvent.isControlDown()) {
            int n2 = this.this$0.rowAtPoint(mouseEvent.getPoint());
            if (!((DefaultListSelectionModel)this.this$0.getSelectionModel()).isSelectedIndex(n2)) {
                this.this$0.getSelectionModel().clearSelection();
            }
            ((DefaultListSelectionModel)this.this$0.getSelectionModel()).addSelectionInterval(n2, n2);
        }
        if (!mouseEvent.isPopupTrigger()) return;
        AbstractTable.access$300(this.this$0, mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (!mouseEvent.isPopupTrigger()) return;
        AbstractTable.access$300(this.this$0, mouseEvent);
    }

    /* synthetic */ AbstractTable$InternalMouseListener(AbstractTable abstractTable, AbstractTable$1 abstractTable$1) {
        this(abstractTable);
    }
}

