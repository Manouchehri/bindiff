package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISelectionHistoryListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory$InternalMatchedChangedListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SelectionHistory {
   private final List snapshotList = new ArrayList();
   private final ListenerProvider listeners = new ListenerProvider();
   private final SelectionHistory$InternalMatchedChangedListener matchChangeListener = new SelectionHistory$InternalMatchedChangedListener(this, (SelectionHistory$1)null);
   private SingleGraph singleGraph;
   private CombinedGraph combinedGraph;
   private final int maxSnapshots;
   private int undoIndex = -1;
   private boolean freeze = false;

   public SelectionHistory(AbstractZyGraph var1, int var2) {
      Preconditions.checkNotNull(var1, "Graph can not be null");
      Preconditions.checkArgument(var2 > 0, "Invalid undo level");
      if(var1 instanceof SingleGraph) {
         this.singleGraph = (SingleGraph)var1;
         this.combinedGraph = null;
      } else {
         if(!(var1 instanceof CombinedGraph)) {
            throw new IllegalArgumentException("Graph must be an instance of SingleGraph or CombinedGraph.");
         }

         this.combinedGraph = (CombinedGraph)var1;
         this.singleGraph = null;
      }

      this.maxSnapshots = var2;
      this.addSnapshot(new SelectionSnapshot(new ArrayList()));
   }

   public void addHistoryListener(ISelectionHistoryListener var1) {
      this.listeners.addListener(var1);
   }

   public void addSnapshot(SelectionSnapshot var1) {
      if(!this.freeze) {
         this.snapshotList.add(var1);
         Iterator var2;
         ISelectionHistoryListener var3;
         if(this.snapshotList.size() > this.maxSnapshots) {
            this.snapshotList.remove(0);
            var2 = this.listeners.iterator();

            while(var2.hasNext()) {
               var3 = (ISelectionHistoryListener)var2.next();
               var3.snapshotRemoved();
            }
         }

         this.undoIndex = this.getNumberOfSnapshots() - 1;
         var2 = this.listeners.iterator();

         while(var2.hasNext()) {
            var3 = (ISelectionHistoryListener)var2.next();
            var3.snapshotAdded(var1);
         }

      }
   }

   public boolean canRedo() {
      return this.undoIndex <= this.getNumberOfSnapshots() - 1;
   }

   public boolean canUndo() {
      return this.undoIndex >= 0;
   }

   public void dispose() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ISelectionHistoryListener var2 = (ISelectionHistoryListener)var1.next();
         this.removeHistoryListener(var2);
      }

      this.snapshotList.clear();
      if(this.singleGraph != null) {
         this.singleGraph.getGraphs().getDiff().getMatches().removeListener(this.matchChangeListener);
      }

      if(this.combinedGraph != null) {
         this.combinedGraph.getGraphs().getDiff().getMatches().removeListener(this.matchChangeListener);
      }

      this.singleGraph = null;
      this.combinedGraph = null;
   }

   public int getNumberOfSnapshots() {
      return this.snapshotList.size();
   }

   public SelectionSnapshot getSnapshot(boolean var1) {
      if(var1) {
         if(this.undoIndex != 0) {
            --this.undoIndex;
         }

         return this.getSnapshot(this.undoIndex);
      } else {
         if(this.undoIndex != this.getNumberOfSnapshots() - 1) {
            ++this.undoIndex;
         }

         return this.getSnapshot(this.undoIndex);
      }
   }

   public SelectionSnapshot getSnapshot(int var1) {
      return (SelectionSnapshot)this.snapshotList.get(var1);
   }

   public void redo() {
      Iterator var1 = this.listeners.iterator();

      ISelectionHistoryListener var2;
      while(var1.hasNext()) {
         var2 = (ISelectionHistoryListener)var1.next();

         try {
            var2.startedRedo();
         } catch (Exception var5) {
            Logger.logException(var5, "Selection history listener notification failed.");
         }
      }

      if(!this.snapshotList.isEmpty() && this.canRedo()) {
         List var6;
         Collection var7;
         if(this.combinedGraph == null) {
            var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)this.singleGraph, GraphNodeFilter$Criterium.SELECTED);
            this.singleGraph.selectNodes(var6, false);
            var7 = this.getSnapshot(false).getSingleGraphSelection();
            this.singleGraph.selectNodes(var7, true);
         } else {
            var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)this.combinedGraph, GraphNodeFilter$Criterium.SELECTED);
            this.combinedGraph.selectNodes(var6, false);
            var7 = this.getSnapshot(false).getCombinedGraphSelection();
            this.combinedGraph.selectNodes(var7, true);
         }
      }

      var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         var2 = (ISelectionHistoryListener)var1.next();

         try {
            var2.finishedRedo();
         } catch (Exception var4) {
            Logger.logException(var4, "Selection history listener notification failed.");
         }
      }

   }

   public void registerMatchListener() {
      if(this.singleGraph != null) {
         this.singleGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
      } else {
         this.combinedGraph.getGraphs().getDiff().getMatches().addListener(this.matchChangeListener);
      }

   }

   public void removeHistoryListener(ISelectionHistoryListener var1) {
      try {
         this.listeners.removeListener(var1);
      } catch (Exception var3) {
         Logger.logWarning("Listener was not listening.", new Object[0]);
      }

   }

   public void setEnabled(boolean var1) {
      this.freeze = !var1;
   }

   public void undo() {
      Iterator var1 = this.listeners.iterator();

      ISelectionHistoryListener var2;
      while(var1.hasNext()) {
         var2 = (ISelectionHistoryListener)var1.next();

         try {
            var2.startedUndo();
         } catch (Exception var5) {
            Logger.logException(var5, "Selection history listener notification failed.");
         }
      }

      if(!this.snapshotList.isEmpty() && this.canUndo()) {
         List var6;
         Collection var7;
         if(this.combinedGraph == null) {
            var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)this.singleGraph, GraphNodeFilter$Criterium.SELECTED);
            this.singleGraph.selectNodes(var6, false);
            var7 = this.getSnapshot(true).getSingleGraphSelection();
            this.singleGraph.selectNodes(var7, true);
         } else {
            var6 = GraphNodeFilter.filterNodes((AbstractZyGraph)this.combinedGraph, GraphNodeFilter$Criterium.SELECTED);
            this.combinedGraph.selectNodes(var6, false);
            var7 = this.getSnapshot(true).getCombinedGraphSelection();
            this.combinedGraph.selectNodes(var7, true);
         }
      }

      var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         var2 = (ISelectionHistoryListener)var1.next();

         try {
            var2.finishedUndo();
         } catch (Exception var4) {
            Logger.logException(var4, "Selection history listener notification failed.");
         }
      }

   }

   // $FF: synthetic method
   static SingleGraph access$100(SelectionHistory var0) {
      return var0.singleGraph;
   }

   // $FF: synthetic method
   static CombinedGraph access$200(SelectionHistory var0) {
      return var0.combinedGraph;
   }

   // $FF: synthetic method
   static List access$300(SelectionHistory var0) {
      return var0.snapshotList;
   }
}
