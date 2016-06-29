package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.io.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import javax.swing.tree.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;

class WorkspaceTree$InternalMouseListener extends MouseAdapter
{
    final /* synthetic */ WorkspaceTree this$0;
    
    private WorkspaceTree$InternalMouseListener(final WorkspaceTree this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.showPopupMenu(mouseEvent);
        }
        else if (mouseEvent.getClickCount() == 2) {
            this.this$0.handleDoubleClick(mouseEvent);
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (mouseEvent.isPopupTrigger()) {
            this.this$0.showPopupMenu(mouseEvent);
        }
    }
}
