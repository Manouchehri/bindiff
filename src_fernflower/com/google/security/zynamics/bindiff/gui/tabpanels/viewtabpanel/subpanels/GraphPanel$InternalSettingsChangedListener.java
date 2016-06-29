package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$1;

class GraphPanel$InternalSettingsChangedListener extends GraphSettingsChangedListenerAdapter {
   // $FF: synthetic field
   final GraphPanel this$0;

   private GraphPanel$InternalSettingsChangedListener(GraphPanel var1) {
      this.this$0 = var1;
   }

   public void focusSideChanged(GraphSettings var1) {
      GraphPanel.access$100(this.this$0, var1);
      this.this$0.updateUI();
   }

   public void graphSyncChanged(GraphSettings var1) {
      GraphPanel.access$100(this.this$0, var1);
      this.this$0.updateUI();
   }

   public void showScrollbarsChanged(GraphSettings var1) {
      if(var1.getShowScrollbars()) {
         GraphPanel.access$200(this.this$0).getPrimaryGraph().getEditMode().setAdjustScrollBarPolicy(true);
         GraphPanel.access$200(this.this$0).getView().setHorizontalScrollBarPolicy(32);
         GraphPanel.access$200(this.this$0).getView().setVerticalScrollBarPolicy(22);
      } else {
         GraphPanel.access$200(this.this$0).getEditMode().setAdjustScrollBarPolicy(false);
         GraphPanel.access$200(this.this$0).getView().setHorizontalScrollBarPolicy(31);
         GraphPanel.access$200(this.this$0).getView().setVerticalScrollBarPolicy(21);
      }

      GraphPanel.access$200(this.this$0).getView().updateView();
   }

   // $FF: synthetic method
   GraphPanel$InternalSettingsChangedListener(GraphPanel var1, GraphPanel$1 var2) {
      this(var1);
   }
}
