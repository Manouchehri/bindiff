package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.ISnapshotListener;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class SelectionSnapshot {
   private final ListenerProvider listeners = new ListenerProvider();
   private final List selectedNodes = new ArrayList();

   public SelectionSnapshot(Collection var1) {
      var1.addAll(var1);
   }

   public void add(ZyGraphNode var1) {
      this.selectedNodes.add(var1);
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ISnapshotListener var3 = (ISnapshotListener)var2.next();
         var3.addedNode(var1);
      }

   }

   public void addListener(ISnapshotListener var1) {
      this.listeners.addListener(var1);
   }

   public boolean equals(SelectionSnapshot var1) {
      return var1 != null && var1.selectedNodes.equals(this.selectedNodes);
   }

   public Collection getCombinedGraphSelection() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(var3 instanceof CombinedDiffNode) {
            var1.add((CombinedDiffNode)var3);
         }
      }

      return var1;
   }

   public String getDescription() {
      // $FF: Couldn't be decompiled
   }

   public int getNumberOfSelectedNodes() {
      return this.selectedNodes.size();
   }

   public Collection getSelection() {
      return this.selectedNodes;
   }

   public Collection getSingleGraphSelection() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ZyGraphNode var3 = (ZyGraphNode)var2.next();
         if(var3 instanceof SingleDiffNode) {
            var1.add((SingleDiffNode)var3);
         }
      }

      return var1;
   }

   public int hashCode() {
      return this.selectedNodes.hashCode();
   }

   public void modicationFinished() {
      Iterator var1 = this.listeners.iterator();

      while(var1.hasNext()) {
         ISnapshotListener var2 = (ISnapshotListener)var1.next();
         var2.finished();
      }

   }

   public void remove(ZyGraphNode var1) {
      this.selectedNodes.remove(var1);
      Iterator var2 = this.listeners.iterator();

      while(var2.hasNext()) {
         ISnapshotListener var3 = (ISnapshotListener)var2.next();
         var3.removedNode(var1);
      }

   }

   public void removeListener(ISnapshotListener var1) {
      this.listeners.removeListener(var1);
   }
}
