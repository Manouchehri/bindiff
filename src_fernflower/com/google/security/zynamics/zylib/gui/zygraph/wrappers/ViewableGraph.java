package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;

public class ViewableGraph implements IViewableGraph {
   private final AbstractZyGraph m_graph;

   private ViewableGraph(AbstractZyGraph var1) {
      this.m_graph = var1;
   }

   public static ViewableGraph wrap(AbstractZyGraph var0) {
      return new ViewableGraph(var0);
   }

   public void iterateInvisible(INodeCallback var1) {
      IteratorFunctions.iterateInvisible(this.m_graph, var1);
   }

   public void iterateVisible(INodeCallback var1) {
      IteratorFunctions.iterateVisible(this.m_graph, var1);
   }
}
