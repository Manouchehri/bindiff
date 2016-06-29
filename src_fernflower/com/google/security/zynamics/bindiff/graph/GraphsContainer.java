package com.google.security.zynamics.bindiff.graph;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer$1;
import com.google.security.zynamics.bindiff.graph.GraphsContainer$2;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.util.Iterator;
import java.util.List;

public class GraphsContainer extends AbstractGraphsContainer {
   private final List graphs;
   private Diff diff;

   public GraphsContainer(Diff var1, SuperGraph var2, CombinedGraph var3, SingleGraph var4, SingleGraph var5) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      Preconditions.checkNotNull(var4);
      Preconditions.checkNotNull(var5);
      this.diff = var1;
      this.graphs = new GraphsContainer$1(this, 4, var4, var5, var3, var2);
      Iterator var6 = this.graphs.iterator();

      while(var6.hasNext()) {
         BinDiffGraph var7 = (BinDiffGraph)var6.next();
         var7.setGraphs(this);
      }

      var3.getSelectionHistory().registerMatchListener();
      var4.getSelectionHistory().registerMatchListener();
      var5.getSelectionHistory().registerMatchListener();
   }

   public void dispose() {
      Iterator var1 = this.graphs.iterator();

      while(var1.hasNext()) {
         BinDiffGraph var2 = (BinDiffGraph)var1.next();
         if(var2 != null) {
            var2.dispose();
         }
      }

      this.graphs.clear();
   }

   public CombinedGraph getCombinedGraph() {
      return (CombinedGraph)this.graphs.get(EGraph.COMBINED_GRAPH.ordinal());
   }

   public Diff getDiff() {
      return this.diff;
   }

   public BinDiffGraph getFocusedGraph() {
      switch(GraphsContainer$2.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.getSettings().getDiffViewMode().ordinal()]) {
      case 1:
         if(this.getSettings().isSync()) {
            return this.getSuperGraph();
         } else {
            if(this.getSettings().getFocus() == ESide.PRIMARY) {
               return this.getPrimaryGraph();
            }

            return this.getSecondaryGraph();
         }
      case 2:
         return this.getCombinedGraph();
      case 3:
         return null;
      default:
         throw new IllegalStateException("Illegal view mode.");
      }
   }

   public SingleGraph getPrimaryGraph() {
      return (SingleGraph)this.graphs.get(EGraph.PRIMARY_GRAPH.ordinal());
   }

   public SingleGraph getSecondaryGraph() {
      return (SingleGraph)this.graphs.get(EGraph.SECONDARY_GRAPH.ordinal());
   }

   public GraphSettings getSettings() {
      return ((SuperGraph)this.graphs.get(EGraph.SUPER_GRAPH.ordinal())).getSettings();
   }

   public SuperGraph getSuperGraph() {
      return (SuperGraph)this.graphs.get(EGraph.SUPER_GRAPH.ordinal());
   }

   public Iterator iterator() {
      return this.graphs.iterator();
   }

   public void setDiff(Diff var1) {
      this.diff = var1;
   }

   public void updateViews() {
      Iterator var1 = this.graphs.iterator();

      while(var1.hasNext()) {
         BinDiffGraph var2 = (BinDiffGraph)var1.next();
         if(var2 != null) {
            var2.updateViews();
         }
      }

   }
}
