package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import javax.swing.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import javax.swing.tree.*;
import com.google.security.zynamics.zylib.gui.jtree.*;

class SelectionHistoryTree$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ SelectionHistoryTree this$0;
    
    private SelectionHistoryTree$InternalMouseListener(final SelectionHistoryTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        this.this$0.handleMouseEvent(mouseEvent);
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.this$0.handleMouseEvent(mouseEvent);
    }
}
