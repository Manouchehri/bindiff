package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import java.util.*;
import javax.swing.tree.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import java.awt.*;
import javax.swing.*;

public class JCriteriumTree extends JTree
{
    private final JCriteriumTree$InternalMouseListener mouseListener;
    private final JCriteriumTreeModel model;
    private TreePath currentCriteriumPath;
    
    public JCriteriumTree(final CriteriumTree criteriumTree, final List list) {
        this.mouseListener = new JCriteriumTree$InternalMouseListener(this, null);
        this.currentCriteriumPath = null;
        this.model = new JCriteriumTreeModel(this, criteriumTree, list);
        this.setRootVisible(true);
        this.setModel(this.model);
        this.setCellRenderer(new TreeNodeRenderer());
        this.addMouseListener(this.mouseListener);
        this.updateUI();
    }
    
    private void showPopupMenu(final MouseEvent mouseEvent) {
        final AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractCriteriumTreeNode != null) {
            final JPopupMenu popupMenu = abstractCriteriumTreeNode.getPopupMenu();
            if (popupMenu != null) {
                popupMenu.show(this, mouseEvent.getX(), mouseEvent.getY());
            }
        }
    }
    
    public void delete() {
        this.removeMouseListener(this.mouseListener);
    }
    
    public TreePath getCurrentCriteriumPath() {
        return this.currentCriteriumPath;
    }
    
    @Override
    public JCriteriumTreeModel getModel() {
        return this.model;
    }
    
    public void setCurrentCriteriumPath(final TreePath currentCriteriumPath) {
        this.currentCriteriumPath = currentCriteriumPath;
    }
}
