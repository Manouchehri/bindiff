package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.ProximityBrowser;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraphMappings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.functions.LayoutFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.ProximityHelper;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Window;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.SwingUtilities;
import y.a.a;
import y.c.d;
import y.c.e;
import y.c.q;
import y.f.O;
import y.f.V;
import y.f.ad;
import y.f.b;
import y.f.c;

public abstract class BinDiffGraph extends AbstractZyGraph {
   private GraphsIntermediateListeners intermediateListeners;
   private final ProximityBrowser proximityBrowser;
   private GraphSettings settings;
   private final EGraphType viewType;
   private GraphsContainer graphs;

   protected BinDiffGraph(ZyGraph2DView var1, LinkedHashMap var2, LinkedHashMap var3, GraphSettings var4, EGraphType var5) {
      super(var1, var2, var3, var4);
      this.settings = (GraphSettings)Preconditions.checkNotNull(var4);
      this.viewType = (EGraphType)Preconditions.checkNotNull(var5);
      this.intermediateListeners = new GraphsIntermediateListeners(this);
      this.proximityBrowser = new ProximityBrowser(this);
      this.setProximityBrowser(this.proximityBrowser);
   }

   public static Window getParentWindow(BinDiffGraph var0) {
      return SwingUtilities.getWindowAncestor(var0.getView());
   }

   public void addEdgeToMappings(ZyGraphEdge var1) {
      d var2 = var1.getEdge();
      ZyGraphMappings var3 = this.getMappings();
      var3.addEdge(var2, var1);
   }

   public void addNodeToMappings(ZyGraphNode var1) {
      q var2 = var1.getNode();
      ZyGraphMappings var3 = this.getMappings();
      var3.addNode(var2, var1);
   }

   public O calculateLayout() {
      O var1 = null;
      c var2 = this.getSettings().getLayoutSettings().getCurrentLayouter();

      try {
         var2.c((ad)(new V()));
         var2.c(true);
         var1 = (new b(var2)).b(this.getGraph());
         LayoutFunctions.recalculatePorts(var2, this.getGraph());
      } catch (a var4) {
         Logger.logException(var4, var4.getMessage());
      } catch (Exception var5) {
         Logger.logException(var5, var5.getMessage());
         throw new GraphLayoutException(var5, "Could not calculate graph layout.");
      }

      return var1;
   }

   public O calculateLayout(c var1) {
      O var2 = null;

      try {
         var1.c((ad)(new V()));
         var1.c(true);
         var2 = (new b(var1)).b(this.getGraph());
         LayoutFunctions.recalculatePorts(var1, this.getGraph());
      } catch (a var4) {
         Logger.logException(var4, var4.getMessage());
      } catch (Exception var5) {
         Logger.logException(var5, var5.getMessage());
         throw new GraphLayoutException(var5, "Could not calculate graph layout.");
      }

      return var2;
   }

   public void deleteEdge(ZyGraphEdge var1) {
      if(var1 != null) {
         ZyGraphNode var2 = var1.getSource();
         ZyGraphNode var3 = var1.getTarget();
         q var4 = null;
         if(ProximityHelper.isProximityNode(this.getGraph(), var2.getNode())) {
            var4 = var2.getNode();
         } else if(ProximityHelper.isProximityNode(this.getGraph(), var3.getNode())) {
            var4 = var3.getNode();
         }

         if(var4 != null) {
            this.getProximityBrowser().deleteProximityNode(var4);
         } else {
            var1.dispose();
            this.getMappings().removeEdge(var1);
            this.getGraph().a((d)var1.getEdge());
            if(var2 instanceof SingleDiffNode && var3 instanceof SingleDiffNode) {
               SingleDiffNode.unlink((SingleDiffNode)var2, (SingleDiffNode)var3);
            } else if(var2 instanceof CombinedDiffNode && var3 instanceof CombinedDiffNode) {
               CombinedDiffNode.unlink((CombinedDiffNode)var2, (CombinedDiffNode)var3);
            } else if(var2 instanceof SuperDiffNode && var3 instanceof SuperDiffNode) {
               SuperDiffNode.unlink((SuperDiffNode)var2, (SuperDiffNode)var3);
            }
         }

         var1 = null;
      }
   }

   public void deleteNode(ZyGraphNode var1) {
      if(var1 != null) {
         q var2 = var1.getNode();
         CViewNode var3 = (CViewNode)var1.getRawNode();
         var3.removeAllListeners();
         ZyGraphMappings var4 = this.getMappings();
         e var5 = var2.j();

         while(var5.f()) {
            ZyGraphEdge var6 = var4.getEdge(var5.a());
            this.deleteEdge(var6);
            var5.g();
         }

         this.getMappings().removeNode(var1);
         this.getGraph().a((q)var2);
         var2 = null;
         var3 = null;
         var1 = null;
      }
   }

   public void dispose() {
      super.dispose();
      this.intermediateListeners.dispose();
      this.settings = null;
      this.intermediateListeners = null;
      this.graphs = null;
   }

   public void doLayout() {
   }

   public CombinedGraph getCombinedGraph() {
      return this.graphs.getCombinedGraph();
   }

   public Collection getEdges() {
      return super.getEdges();
   }

   public GraphsContainer getGraphs() {
      return this.graphs;
   }

   public abstract GraphSearcher getGraphSearcher();

   public EGraphType getGraphType() {
      return this.viewType;
   }

   public GraphsIntermediateListeners getIntermediateListeners() {
      return this.intermediateListeners;
   }

   public Collection getNodes() {
      return super.getNodes();
   }

   public SingleGraph getPrimaryGraph() {
      return this.graphs.getPrimaryGraph();
   }

   public ProximityBrowser getProximityBrowser() {
      return this.proximityBrowser;
   }

   public SingleGraph getSecondaryGraph() {
      return this.graphs.getSecondaryGraph();
   }

   public abstract Set getSelectedNodes();

   public GraphSettings getSettings() {
      return this.settings;
   }

   public SuperGraph getSuperGraph() {
      return this.graphs.getSuperGraph();
   }

   public boolean isCombinedGraph() {
      return this == this.getCombinedGraph();
   }

   public boolean isPrimaryGraph() {
      return this == this.getPrimaryGraph();
   }

   public boolean isSecondaryGraph() {
      return this == this.getSuperGraph();
   }

   public boolean isSingleGraph() {
      return this.isPrimaryGraph() || this.isSecondaryGraph();
   }

   public boolean isSuperGraph() {
      return this == this.getSuperGraph();
   }

   public void setGraphs(GraphsContainer var1) {
      this.graphs = (GraphsContainer)Preconditions.checkNotNull(var1);
   }
}
