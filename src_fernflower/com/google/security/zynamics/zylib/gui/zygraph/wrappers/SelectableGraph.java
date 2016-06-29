package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.Collection;

public class SelectableGraph implements ISelectableGraph {
   private final AbstractZyGraph m_graph;

   private SelectableGraph(AbstractZyGraph var1) {
      this.m_graph = var1;
   }

   public static SelectableGraph wrap(AbstractZyGraph var0) {
      return new SelectableGraph(var0);
   }

   public void iterateSelected(INodeCallback var1) {
      IteratorFunctions.iterateSelected(this.m_graph, var1);
   }

   public void selectNodes(Collection var1, boolean var2) {
      this.m_graph.selectNodes(var1, var2);
   }

   public void selectNodes(Collection var1, Collection var2) {
      this.m_graph.selectNodes(var1, var2);
   }
}
