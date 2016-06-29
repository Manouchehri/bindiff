package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.gui.tables.*;
import com.google.common.base.*;
import javax.swing.table.*;
import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.*;

class AbstractTable$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ AbstractTable this$0;
    
    private AbstractTable$InternalMouseListener(final AbstractTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mouseClicked(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 2) {
            this.this$0.handleDoubleClick(this.this$0.getSelectionIndex(mouseEvent));
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3 && !mouseEvent.isControlDown()) {
            final int rowAtPoint = this.this$0.rowAtPoint(mouseEvent.getPoint());
            if (!((DefaultListSelectionModel)this.this$0.getSelectionModel()).isSelectedIndex(rowAtPoint)) {
                this.this$0.getSelectionModel().clearSelection();
            }
            ((DefaultListSelectionModel)this.this$0.getSelectionModel()).addSelectionInterval(rowAtPoint, rowAtPoint);
        }
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.displayPopupMenu(mouseEvent);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.displayPopupMenu(mouseEvent);
        }
    }
}
