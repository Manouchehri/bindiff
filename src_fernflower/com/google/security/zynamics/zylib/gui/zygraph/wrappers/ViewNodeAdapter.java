package com.google.security.zynamics.zylib.gui.zygraph.wrappers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.lists.FilledList;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ViewNodeAdapter implements IGraphNode {
   private final IViewNode m_viewNode;

   public ViewNodeAdapter(IViewNode var1) {
      Preconditions.checkNotNull(var1, "Error: View node argument can not be null");
      this.m_viewNode = var1;
   }

   private static Collection convert(AbstractZyGraph var0, Collection var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IViewNode var4 = (IViewNode)var3.next();
         var2.add(var0.getNode((Object)var4));
      }

      return var2;
   }

   public static Collection unwrap(AbstractZyGraph var0, Collection var1) {
      FilledList var2 = new FilledList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ViewNodeAdapter var4 = (ViewNodeAdapter)var3.next();
         var2.add(var4.getNode());
      }

      return convert(var0, var2);
   }

   public static List wrap(List var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         IViewNode var3 = (IViewNode)var2.next();
         var1.add(new ViewNodeAdapter(var3));
      }

      return var1;
   }

   public boolean equals(Object var1) {
      return var1 instanceof ViewNodeAdapter && ((ViewNodeAdapter)var1).getNode() == this.getNode();
   }

   public List getChildren() {
      List var1 = this.m_viewNode.getOutgoingEdges();
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IViewEdge var4 = (IViewEdge)var3.next();
         var2.add(var4.getTarget());
      }

      return wrap(var2);
   }

   public IViewNode getNode() {
      return this.m_viewNode;
   }

   public List getParents() {
      List var1 = this.m_viewNode.getIncomingEdges();
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         IViewEdge var4 = (IViewEdge)var3.next();
         var2.add(var4.getSource());
      }

      return wrap(var2);
   }

   public int hashCode() {
      return this.m_viewNode.hashCode();
   }
}
