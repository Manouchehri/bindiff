/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.zylib.gui.jtree.TreeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public abstract class AbstractGraphNodeTree
extends JTree {
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

    private void handleMouseEvent(MouseEvent mouseEvent) {
        AbstractTreeNode abstractTreeNode = (AbstractTreeNode)TreeHelpers.getNodeAt(this, mouseEvent.getX(), mouseEvent.getY());
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

    public void setUpdateFroozen(boolean bl2) {
        this.udpateFrozen = bl2;
    }

    @Override
    public void updateUI() {
        if (this.udpateFrozen) return;
        super.updateUI();
    }

    static /* synthetic */ void access$300(AbstractGraphNodeTree abstractGraphNodeTree, MouseEvent mouseEvent) {
        abstractGraphNodeTree.handleMouseEvent(mouseEvent);
    }
}

