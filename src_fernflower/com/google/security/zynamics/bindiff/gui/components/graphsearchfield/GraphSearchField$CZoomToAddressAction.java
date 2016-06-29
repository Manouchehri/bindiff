package com.google.security.zynamics.bindiff.gui.components.graphsearchfield;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.GraphAddressSearcher;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField;
import com.google.security.zynamics.bindiff.gui.components.graphsearchfield.GraphSearchField$1;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class GraphSearchField$CZoomToAddressAction extends AbstractAction {
   // $FF: synthetic field
   final GraphSearchField this$0;

   private GraphSearchField$CZoomToAddressAction(GraphSearchField var1) {
      this.this$0 = var1;
   }

   private boolean jumpToAddress(IAddress var1, ESide var2) {
      String var3 = var2 == ESide.PRIMARY?GraphSearchField.access$600(this.this$0).getText():GraphSearchField.access$700(this.this$0).getText();
      if(!var3.isEmpty()) {
         if(var2 == ESide.PRIMARY) {
            GraphSearchField.access$2000(this.this$0).add(var3);
            GraphSearchField.access$600(this.this$0).setCaretPosition(var3.length());
         } else {
            GraphSearchField.access$2100(this.this$0).add(var3);
            GraphSearchField.access$700(this.this$0).setCaretPosition(var3.length());
         }
      }

      Object var4 = GraphSearchField.access$1100(this.this$0).getCombinedGraph();
      if(GraphSearchField.access$1900(this.this$0).getGraphSettings().getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
         var4 = var2 == ESide.PRIMARY?GraphSearchField.access$1100(this.this$0).getPrimaryGraph():GraphSearchField.access$1100(this.this$0).getSecondaryGraph();
      }

      if(var4 instanceof SingleGraph) {
         SingleDiffNode var6 = GraphAddressSearcher.searchAddress((SingleGraph)var4, var1);
         if(var6 != null) {
            GraphZoomer.zoomToNode((BinDiffGraph)var4, var6);
         }

         return var6 != null;
      } else if(var4 instanceof CombinedGraph) {
         CombinedDiffNode var5 = GraphAddressSearcher.searchAddress((CombinedGraph)var4, var2, var1);
         if(var5 != null) {
            GraphZoomer.zoomToNode((BinDiffGraph)var4, var5);
         }

         return var5 != null;
      } else {
         return true;
      }
   }

   public void actionPerformed(ActionEvent var1) {
      CAddress var2;
      if(var1.getSource() == GraphSearchField.access$600(this.this$0) && GraphSearchField.access$600(this.this$0).getText() != null) {
         if(GraphSearchField.access$600(this.this$0).getText().isEmpty()) {
            GraphSearchField.access$600(this.this$0).setBackground(GraphSearchField.access$1700());
            return;
         }

         var2 = new CAddress(GraphSearchField.access$600(this.this$0).getText(), 16);
         GraphSearchField.access$600(this.this$0).setBackground(this.jumpToAddress(var2, ESide.PRIMARY)?GraphSearchField.access$1700():GraphSearchField.access$1400());
         GraphSearchField.access$600(this.this$0).setFocusable(false);
         GraphSearchField.access$600(this.this$0).setFocusable(true);
         GraphSearchField.access$600(this.this$0).grabFocus();
         GraphSearchField.access$600(this.this$0).updateUI();
      }

      if(var1.getSource() == GraphSearchField.access$700(this.this$0) && GraphSearchField.access$700(this.this$0).getText() != null) {
         if(GraphSearchField.access$700(this.this$0).getText().isEmpty()) {
            GraphSearchField.access$700(this.this$0).setBackground(GraphSearchField.access$1700());
            return;
         }

         var2 = new CAddress(GraphSearchField.access$700(this.this$0).getText(), 16);
         GraphSearchField.access$700(this.this$0).setBackground(this.jumpToAddress(var2, ESide.SECONDARY)?GraphSearchField.access$1700():GraphSearchField.access$1400());
         GraphSearchField.access$700(this.this$0).setFocusable(false);
         GraphSearchField.access$700(this.this$0).setFocusable(true);
         GraphSearchField.access$700(this.this$0).grabFocus();
         GraphSearchField.access$700(this.this$0).updateUI();
      }

   }

   // $FF: synthetic method
   GraphSearchField$CZoomToAddressAction(GraphSearchField var1, GraphSearchField$1 var2) {
      this(var1);
   }
}
