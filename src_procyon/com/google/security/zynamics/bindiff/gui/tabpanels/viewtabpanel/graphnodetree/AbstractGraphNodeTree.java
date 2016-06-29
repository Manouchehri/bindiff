package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.jtree.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import javax.swing.tree.*;

public abstract class AbstractGraphNodeTree extends JTree
{
    private AbstractGraphNodeTree$InternalMouseListener mouseListener;
    private AbstractGraphNodeTree$InternalGraphSelectionListener graphSelectionListener;
    private AbstractGraphNodeTree$InternalGraphVisibilityListener graphVisibilityListener;
    private boolean udpateFrozen;
    
    public AbstractGraphNodeTree() {
        this.mouseListener = new AbstractGraphNodeTree$InternalMouseListener(this, null);
        this.graphSelectionListener = new AbstractGraphNodeTree$InternalGraphSelectionListener(this, null);
        this.graphVisibilityListener = new AbstractGraphNodeTree$InternalGraphVisibilityListener(this, null);
        this.udpateFrozen = false;
    }
    
    private void handleMouseEvent(final MouseEvent mouseEvent) {
        final AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
        if (abstractTreeNode == null) {
            return;
        }
        abstractTreeNode.handleMouseEvent(mouseEvent);
    }
    
    public void addListeners() {
        this.getGraph().getIntermediateListeners().addIntermediateListener(this.graphSelectionListener);
        this.getGraph().getIntermediateListeners().addIntermediateListener(this.graphVisibilityListener);
        this.addMouseListener(this.mouseListener);
    }
    
    public void dispose() {
        this.getGraph().getIntermediateListeners().removeIntermediateListener(this.graphSelectionListener);
        this.getGraph().getIntermediateListeners().removeIntermediateListener(this.graphVisibilityListener);
        this.removeMouseListener(this.mouseListener);
        this.graphSelectionListener = null;
        this.graphVisibilityListener = null;
        this.mouseListener = null;
        this.getRootNode().dispose();
    }
    
    public abstract BinDiffGraph getGraph();
    
    @Override
    public DefaultTreeModel getModel() {
        return (DefaultTreeModel)super.getModel();
    }
    
    public AbstractRootTreeNode getRootNode() {
        return (AbstractRootTreeNode)this.getModel().getRoot();
    }
    
    public void setUpdateFroozen(final boolean udpateFrozen) {
        this.udpateFrozen = udpateFrozen;
    }
    
    @Override
    public void updateUI() {
        if (!this.udpateFrozen) {
            super.updateUI();
        }
    }
}
