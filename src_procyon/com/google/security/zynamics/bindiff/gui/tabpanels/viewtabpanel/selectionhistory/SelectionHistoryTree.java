package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import javax.swing.tree.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.jtree.*;

public class SelectionHistoryTree extends JTree
{
    private final SelectionHistoryTree$InternalMouseListener mouseListener;
    
    public SelectionHistoryTree(final SelectionHistoryRootNode selectionHistoryRootNode) {
        super(selectionHistoryRootNode);
        this.addMouseListener(this.mouseListener = new SelectionHistoryTree$InternalMouseListener(this, null));
        this.setCellRenderer(new SelectionHistoryTreeCellRenderer(selectionHistoryRootNode.getGraph()));
    }
    
    private void handleMouseEvent(final MouseEvent mouseEvent) {
        final AbstractSelectionHistoryTreeNode abstractSelectionHistoryTreeNode = (AbstractSelectionHistoryTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractSelectionHistoryTreeNode == null) {
            return;
        }
        abstractSelectionHistoryTreeNode.handleMouseEvent(mouseEvent);
    }
    
    public void dispose() {
        this.removeMouseListener(this.mouseListener);
    }
}
