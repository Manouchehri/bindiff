package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.SelectedVisibleFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.Collection;
import java.util.List;

public abstract class ProximityUpdater implements IZyGraphSelectionListener {
   private Collection m_lastSelectedNodes;
   private final AbstractZyGraph m_graph;

   protected ProximityUpdater(AbstractZyGraph var1) {
      Preconditions.checkNotNull(var1, "Error: Graph argument can not be null");
      this.m_graph = var1;
      this.m_lastSelectedNodes = this.m_graph.getSelectedNodes();
   }

   protected abstract void showNodes(Collection var1, Collection var2);

   public void selectionChanged() {
      if(this.m_graph.getSettings().getProximitySettings().getProximityBrowsing() && !this.m_graph.getSettings().getProximitySettings().getProximityBrowsingFrozen()) {
         Collection var1 = SelectedVisibleFilter.filter(this.m_graph.getSelectedNodes());
         if(!var1.equals(this.m_lastSelectedNodes)) {
            this.m_lastSelectedNodes = var1;
            if(!var1.isEmpty()) {
               List var2 = GraphHelpers.getNodes(this.m_graph);
               var2.removeAll(var1);
               this.showNodes(var1, var2);
            }

         }
      }
   }
}
