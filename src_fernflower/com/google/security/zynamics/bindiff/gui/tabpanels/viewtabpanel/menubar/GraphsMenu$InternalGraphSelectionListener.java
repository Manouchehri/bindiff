package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.GraphsMenu$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import java.util.Iterator;

class GraphsMenu$InternalGraphSelectionListener implements IZyGraphSelectionListener {
   // $FF: synthetic field
   final GraphsMenu this$0;

   private GraphsMenu$InternalGraphSelectionListener(GraphsMenu var1) {
      this.this$0 = var1;
   }

   private int countSelectedMatchedNodes(CombinedGraph var1) {
      int var2 = 0;
      Iterator var3 = var1.getSelectedNodes().iterator();

      while(var3.hasNext()) {
         CombinedDiffNode var4 = (CombinedDiffNode)var3.next();
         if(var4.getRawNode().getMatchState() == EMatchState.MATCHED) {
            ++var2;
         }
      }

      return var2;
   }

   private int countSelectedNodes(SingleGraph var1, boolean var2) {
      int var3 = 0;
      Iterator var4 = var1.getSelectedNodes().iterator();

      while(true) {
         while(var4.hasNext()) {
            SingleDiffNode var5 = (SingleDiffNode)var4.next();
            if(var2 && var5.getRawNode().getMatchState() == EMatchState.MATCHED) {
               ++var3;
            } else if(!var2 && var5.getRawNode().getMatchState() != EMatchState.MATCHED) {
               ++var3;
            }
         }

         return var3;
      }
   }

   private int countSelectedUnmatchedNodes(CombinedGraph var1, ESide var2) {
      int var3 = 0;
      Iterator var4 = var1.getSelectedNodes().iterator();

      while(true) {
         while(var4.hasNext()) {
            CombinedDiffNode var5 = (CombinedDiffNode)var4.next();
            if(var2 == ESide.PRIMARY && var5.getRawNode().getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
               ++var3;
            } else if(var2 == ESide.SECONDARY && var5.getRawNode().getMatchState() != EMatchState.SECONDRAY_UNMATCHED) {
               ++var3;
            }
         }

         return var3;
      }
   }

   public void selectionChanged() {
      GraphsContainer var1 = GraphsMenu.access$100(this.this$0).getGraphs();
      boolean var2 = false;
      boolean var3 = false;
      if(var1.getPrimaryGraph().getNodes().size() != 0 && var1.getSecondaryGraph().getNodes().size() != 0) {
         if(GraphsMenu.access$100(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            var2 = this.countSelectedNodes(var1.getPrimaryGraph(), false) == 1 && this.countSelectedNodes(var1.getSecondaryGraph(), false) == 1;
            var3 = this.countSelectedNodes(var1.getPrimaryGraph(), true) > 0 || this.countSelectedNodes(var1.getSecondaryGraph(), true) > 0;
         } else if(GraphsMenu.access$100(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            CombinedGraph var4 = var1.getCombinedGraph();
            var2 = this.countSelectedUnmatchedNodes(var4, ESide.PRIMARY) == 1 && this.countSelectedUnmatchedNodes(var4, ESide.SECONDARY) == 1;
            var3 = this.countSelectedMatchedNodes(var4) > 0;
         }
      }

      GraphsMenu.access$200(this.this$0).setEnabled(var2);
      GraphsMenu.access$300(this.this$0).setEnabled(var3);
   }

   // $FF: synthetic method
   GraphsMenu$InternalGraphSelectionListener(GraphsMenu var1, GraphsMenu$1 var2) {
      this(var1);
   }
}
