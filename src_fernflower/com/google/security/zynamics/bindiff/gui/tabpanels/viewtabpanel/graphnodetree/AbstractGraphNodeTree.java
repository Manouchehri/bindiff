package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
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
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

public abstract class AbstractGraphNodeTree extends JTree {
   private AbstractGraphNodeTree$InternalMouseListener mouseListener = new AbstractGraphNodeTree$InternalMouseListener(this, (AbstractGraphNodeTree$1)null);
   private AbstractGraphNodeTree$InternalGraphSelectionListener graphSelectionListener = new AbstractGraphNodeTree$InternalGraphSelectionListener(this, (AbstractGraphNodeTree$1)null);
   private AbstractGraphNodeTree$InternalGraphVisibilityListener graphVisibilityListener = new AbstractGraphNodeTree$InternalGraphVisibilityListener(this, (AbstractGraphNodeTree$1)null);
   private boolean udpateFrozen = false;

   private void handleMouseEvent(MouseEvent var1) {
      AbstractTreeNode var2 = (AbstractTreeNode)TreeHelpers.getNodeAt(this, var1.getX(), var1.getY());
      if(var2 != null) {
         var2.handleMouseEvent(var1);
      }
   }

   public void addListeners() {
      this.getGraph().getIntermediateListeners().addIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      this.getGraph().getIntermediateListeners().addIntermediateListener((IZyGraphVisibilityListener)this.graphVisibilityListener);
      this.addMouseListener(this.mouseListener);
   }

   public void dispose() {
      this.getGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphSelectionListener)this.graphSelectionListener);
      this.getGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphVisibilityListener)this.graphVisibilityListener);
      this.removeMouseListener(this.mouseListener);
      this.graphSelectionListener = null;
      this.graphVisibilityListener = null;
      this.mouseListener = null;
      this.getRootNode().dispose();
   }

   public abstract BinDiffGraph getGraph();

   public DefaultTreeModel getModel() {
      return (DefaultTreeModel)super.getModel();
   }

   public AbstractRootTreeNode getRootNode() {
      return (AbstractRootTreeNode)this.getModel().getRoot();
   }

   public void setUpdateFroozen(boolean var1) {
      this.udpateFrozen = var1;
   }

   public void updateUI() {
      if(!this.udpateFrozen) {
         super.updateUI();
      }

   }

   // $FF: synthetic method
   static void access$300(AbstractGraphNodeTree var0, MouseEvent var1) {
      var0.handleMouseEvent(var1);
   }
}
