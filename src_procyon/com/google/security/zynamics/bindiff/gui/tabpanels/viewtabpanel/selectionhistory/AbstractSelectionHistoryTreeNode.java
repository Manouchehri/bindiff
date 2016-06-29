package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public abstract class AbstractSelectionHistoryTreeNode extends DefaultMutableTreeNode
{
    public AbstractSelectionHistoryTreeNode(final String s) {
        super(s);
    }
    
    public ViewTabPanelFunctions getController() {
        return this.getRootNode().getController();
    }
    
    public abstract Icon getIcon();
    
    public abstract JPopupMenu getPopupMenu();
    
    public SelectionHistoryRootNode getRootNode() {
        return (SelectionHistoryRootNode)this.getRoot();
    }
    
    public JTree getTree() {
        return this.getRootNode().getTree();
    }
    
    public void handleMouseEvent(final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 3 || !mouseEvent.isPopupTrigger()) {
            return;
        }
        final JPopupMenu popupMenu = this.getPopupMenu();
        if (popupMenu != null) {
            popupMenu.show(this.getTree(), mouseEvent.getX(), mouseEvent.getY());
        }
    }
}
