package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphConverters;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.ITextNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityNodeFunctions$1;
import com.google.security.zynamics.zylib.gui.zygraph.wrappers.ViewableGraph;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class ProximityNodeFunctions {
   private Collection filterVisibleNodes(Collection var1) {
      return CollectionHelpers.filter(var1, new ProximityNodeFunctions$1(this));
   }

   private Collection getNeighborhood(AbstractZyGraph var1, ZyProximityNode var2) {
      List var3 = var2.isIncoming()?((IGraphNode)var2.getRawNode().getAttachedNode()).getChildren():((IGraphNode)var2.getRawNode().getAttachedNode()).getParents();
      LinkedHashSet var4 = new LinkedHashSet();
      Iterator var5 = var3.iterator();

      IViewNode var6;
      while(var5.hasNext()) {
         var6 = (IViewNode)var5.next();
         if(!var6.isVisible()) {
            if(var6.getParentGroup() != null) {
               var4.add(var6.getParentGroup());
               var4.add(var6);
            } else {
               var4.add(var6);
            }
         }
      }

      var5 = (new ArrayList(var4)).iterator();

      while(true) {
         while(var5.hasNext()) {
            var6 = (IViewNode)var5.next();
            Iterator var7;
            IViewNode var8;
            if(var2.isIncoming()) {
               var7 = ((IGraphNode)var6).getParents().iterator();

               while(var7.hasNext()) {
                  var8 = (IViewNode)var7.next();
                  if(var8 instanceof ITextNode) {
                     var4.add(var8);
                  }
               }
            } else {
               var7 = ((IGraphNode)var6).getChildren().iterator();

               while(var7.hasNext()) {
                  var8 = (IViewNode)var7.next();
                  if(var8 instanceof ITextNode) {
                     var4.add(var8);
                  }
               }
            }
         }

         return GraphConverters.convert(var1, var4);
      }
   }

   protected abstract void showNodes(Window var1, AbstractZyGraph var2, List var3, boolean var4);

   public void showHiddenNodes(Window var1, AbstractZyGraph var2, ZyProximityNode var3) {
      LinkedHashSet var4 = new LinkedHashSet();
      Set var5 = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(var2));
      var4.addAll(this.filterVisibleNodes(var5));
      var4.addAll(this.filterVisibleNodes(this.getNeighborhood(var2, var3)));
      this.showNodes(var1, var2, new ArrayList(var4), false);
   }

   public void unhideAndSelect(AbstractZyGraph var1, ZyProximityNode var2) {
      var1.selectNodes(this.getNeighborhood(var1, var2), true);
   }

   public void unhideAndSelectOnly(AbstractZyGraph var1, ZyProximityNode var2) {
      Collection var3 = this.getNeighborhood(var1, var2);
      List var4 = GraphHelpers.getNodes(var1);
      var4.removeAll(var3);
      var1.selectNodes(var3, var4);
   }

   public void unhideChildren(Window var1, AbstractZyGraph var2, ZyProximityNode var3) {
      ArrayList var4 = new ArrayList();
      Set var5 = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(var2));
      var4.addAll(var5);
      var4.addAll(GraphConverters.convert(var2, GraphAlgorithms.getSuccessors((IGraphNode)var3.getRawNode().getAttachedNode())));
      this.showNodes(var1, var2, var4, true);
   }

   public void unhideParents(Window var1, AbstractZyGraph var2, ZyProximityNode var3) {
      ArrayList var4 = new ArrayList();
      Set var5 = GraphHelpers.getVisibleNodes(ViewableGraph.wrap(var2));
      var4.addAll(var5);
      var4.addAll(GraphConverters.convert(var2, GraphAlgorithms.getPredecessors((IGraphNode)var3.getRawNode().getAttachedNode())));
      this.showNodes(var1, var2, var4, true);
   }
}
