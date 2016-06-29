package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import javax.swing.event.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import java.util.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.popupmenu.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.tree.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.treenodes.*;

class WorkspaceTree$InternalTreeSelectionListener implements TreeSelectionListener
{
    private DefaultMutableTreeNode lastNode;
    final /* synthetic */ WorkspaceTree this$0;
    
    private WorkspaceTree$InternalTreeSelectionListener(final WorkspaceTree this$0) {
        this.this$0 = this$0;
        this.lastNode = null;
    }
    
    @Override
    public void valueChanged(final TreeSelectionEvent treeSelectionEvent) {
        final AbstractTreeNode lastNode = (AbstractTreeNode)this.this$0.getLastSelectedPathComponent();
        if (lastNode != null) {
            this.this$0.nodeSelected(lastNode);
            this.lastNode = lastNode;
        }
        else if (this.lastNode == null || !TreeHelpers.isAncestor(this.lastNode, this.this$0.rootNode)) {
            this.this$0.nodeSelected(this.this$0.rootNode);
        }
        final Iterator iterator = this.this$0.listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedSelection((lastNode != null) ? lastNode : this.this$0.rootNode);
        }
    }
}
