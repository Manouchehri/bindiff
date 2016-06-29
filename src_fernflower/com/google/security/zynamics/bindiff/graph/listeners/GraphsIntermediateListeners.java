package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$InternalGraphVisibilityListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import java.util.Iterator;

public class GraphsIntermediateListeners {
   private final BinDiffGraph graph;
   private final ListenerProvider intermediateSelectionListener = new ListenerProvider();
   private final ListenerProvider intermediateVisibilityListener = new ListenerProvider();
   private final GraphsIntermediateListeners$InternalGraphSelectionListener selectionListener;
   private final GraphsIntermediateListeners$InternalGraphVisibilityListener visibilityListener;
   private GraphsIntermediateListeners$InternalGraphSelectionListener[] savedSelectionListeners = new GraphsIntermediateListeners$InternalGraphSelectionListener[4];
   private GraphsIntermediateListeners$InternalGraphVisibilityListener[] savedVisibilityListeners = new GraphsIntermediateListeners$InternalGraphVisibilityListener[4];

   public GraphsIntermediateListeners(BinDiffGraph var1) {
      Preconditions.checkNotNull(var1);
      this.graph = var1;
      this.selectionListener = new GraphsIntermediateListeners$InternalGraphSelectionListener(var1, (GraphsIntermediateListeners$1)null);
      this.visibilityListener = new GraphsIntermediateListeners$InternalGraphVisibilityListener(var1, (GraphsIntermediateListeners$1)null);
      this.addListeners();
   }

   public static void notifyIntermediateSelectionListeners(BinDiffGraph var0) {
      if(var0.getSettings().isSync()) {
         var0.getPrimaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
         var0.getSecondaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
         var0.getCombinedGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
         var0.getSuperGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
      } else {
         var0.getIntermediateListeners().notifyIntermediateSelectionListener();
      }

   }

   public static void notifyIntermediateVisibilityListeners(BinDiffGraph var0) {
      if(var0.getSettings().isSync()) {
         var0.getPrimaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
         var0.getSecondaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
         var0.getCombinedGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
         var0.getSuperGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
      } else {
         var0.getIntermediateListeners().notifyIntermediateSelectionListener();
      }

   }

   private void addListeners() {
      this.graph.addListener(this.selectionListener);
      this.graph.addListener(this.visibilityListener);
   }

   private GraphsIntermediateListeners getGraphIntermediateListener(EGraph var1) {
      Preconditions.checkNotNull(this.graph);
      switch(GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[var1.ordinal()]) {
      case 1:
         Preconditions.checkNotNull(this.graph.getPrimaryGraph());
         return this.graph.getPrimaryGraph().getIntermediateListeners();
      case 2:
         Preconditions.checkNotNull(this.graph.getSecondaryGraph());
         return this.graph.getSecondaryGraph().getIntermediateListeners();
      case 3:
         Preconditions.checkNotNull(this.graph.getCombinedGraph());
         return this.graph.getCombinedGraph().getIntermediateListeners();
      case 4:
         Preconditions.checkNotNull(this.graph.getSuperGraph());
         return this.graph.getSuperGraph().getIntermediateListeners();
      default:
         throw new IllegalStateException();
      }
   }

   private GraphsIntermediateListeners$InternalGraphSelectionListener getSelectionListener() {
      return this.selectionListener;
   }

   private GraphsIntermediateListeners$InternalGraphVisibilityListener getVisibilityListener() {
      return this.visibilityListener;
   }

   private void notifyIntermediateSelectionListener() {
      Iterator var1 = this.intermediateSelectionListener.iterator();

      while(var1.hasNext()) {
         IZyGraphSelectionListener var2 = (IZyGraphSelectionListener)var1.next();
         var2.selectionChanged();
      }

   }

   private void notifyIntermediateVisibilityListener() {
      Iterator var1 = this.intermediateVisibilityListener.iterator();

      while(var1.hasNext()) {
         IZyGraphVisibilityListener var2 = (IZyGraphVisibilityListener)var1.next();
         var2.visibilityChanged();
      }

   }

   public void addIntermediateListener(IZyGraphSelectionListener var1) {
      this.intermediateSelectionListener.addListener(var1);
   }

   public void addIntermediateListener(IZyGraphVisibilityListener var1) {
      this.intermediateVisibilityListener.addListener(var1);
   }

   public void blockZyLibSelectionListeners() {
      this.savedSelectionListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getSelectionListener();
      this.savedSelectionListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getSelectionListener();
      this.savedSelectionListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getSelectionListener();
      this.savedSelectionListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getSelectionListener();
      GraphsIntermediateListeners$InternalGraphSelectionListener[] var1 = this.savedSelectionListeners;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         GraphsIntermediateListeners$InternalGraphSelectionListener var4 = var1[var3];
         if(var4 != null) {
            var4.getGraph().removeListener(var4);
         }
      }

   }

   public void blockZyLibVisibilityListeners() {
      this.savedVisibilityListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getVisibilityListener();
      this.savedVisibilityListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getVisibilityListener();
      this.savedVisibilityListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getVisibilityListener();
      this.savedVisibilityListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getVisibilityListener();
      GraphsIntermediateListeners$InternalGraphVisibilityListener[] var1 = this.savedVisibilityListeners;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         GraphsIntermediateListeners$InternalGraphVisibilityListener var4 = var1[var3];
         if(var4 != null) {
            var4.getGraph().removeListener(var4);
         }
      }

   }

   public void dispose() {
      this.graph.removeListener(this.selectionListener);
      this.graph.removeListener(this.visibilityListener);
      this.savedSelectionListeners = null;
      this.savedVisibilityListeners = null;
   }

   public void freeZyLibSelectionListeners() {
      GraphsIntermediateListeners$InternalGraphSelectionListener[] var1 = this.savedSelectionListeners;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         GraphsIntermediateListeners$InternalGraphSelectionListener var4 = var1[var3];
         if(var4 != null) {
            var4.getGraph().addListener(var4);
         }
      }

   }

   public void freeZyLibVisibilityListeners() {
      GraphsIntermediateListeners$InternalGraphVisibilityListener[] var1 = this.savedVisibilityListeners;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         GraphsIntermediateListeners$InternalGraphVisibilityListener var4 = var1[var3];
         if(var4 != null) {
            var4.getGraph().addListener(var4);
         }
      }

   }

   public void removeIntermediateListener(IZyGraphSelectionListener var1) {
      this.intermediateSelectionListener.removeListener(var1);
   }

   public void removeIntermediateListener(IZyGraphVisibilityListener var1) {
      this.intermediateVisibilityListener.removeListener(var1);
   }
}
