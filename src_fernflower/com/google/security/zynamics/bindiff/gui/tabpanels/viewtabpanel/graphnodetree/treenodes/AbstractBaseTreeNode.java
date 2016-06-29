package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalGraphFilterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalTreeNodeSearcherListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$InternalTreeNodeSorterListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

public abstract class AbstractBaseTreeNode extends AbstractTreeNode {
   private AbstractBaseTreeNode$InternalTreeNodeSearcherListener searchListener = new AbstractBaseTreeNode$InternalTreeNodeSearcherListener(this, (AbstractBaseTreeNode$1)null);
   private AbstractBaseTreeNode$InternalGraphFilterListener filterListener = new AbstractBaseTreeNode$InternalGraphFilterListener(this, (AbstractBaseTreeNode$1)null);
   private AbstractBaseTreeNode$InternalTreeNodeSorterListener sorterListener = new AbstractBaseTreeNode$InternalTreeNodeSorterListener(this, (AbstractBaseTreeNode$1)null);
   private AbstractBaseTreeNode$InternalGraphVisibilityListener visibilityListener = new AbstractBaseTreeNode$InternalGraphVisibilityListener(this, (AbstractBaseTreeNode$1)null);

   public AbstractBaseTreeNode(AbstractRootTreeNode var1) {
      super(var1);
      this.getSearcher().addListener(this.searchListener);
      this.getFilter().addListener(this.filterListener);
      this.getSorter().addListener(this.sorterListener);
      this.getGraph().getCombinedGraph().getIntermediateListeners().addIntermediateListener((IZyGraphVisibilityListener)this.visibilityListener);
   }

   protected void delete() {
      this.getSearcher().removeListener(this.searchListener);
      this.getFilter().removeListener(this.filterListener);
      this.getSorter().removeListener(this.sorterListener);
      this.getGraph().getCombinedGraph().getIntermediateListeners().removeIntermediateListener((IZyGraphVisibilityListener)this.visibilityListener);
      this.filterListener = null;
      this.searchListener = null;
      this.sorterListener = null;
      this.visibilityListener = null;
      super.delete();
   }

   protected abstract void updateTreeNodes(boolean var1);
}
