package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar;

import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ModesMenu$1;

class ModesMenu$InternalSettingsListener extends GraphSettingsChangedListenerAdapter {
   // $FF: synthetic field
   final ModesMenu this$0;

   private ModesMenu$InternalSettingsListener(ModesMenu var1) {
      this.this$0 = var1;
   }

   public void autoLayoutChanged(GraphLayoutSettings var1) {
      ModesMenu.access$100(this.this$0).setSelected(var1.getAutomaticLayouting());
   }

   public void diffViewModeChanged(GraphSettings var1) {
      switch(ModesMenu$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[var1.getDiffViewMode().ordinal()]) {
      case 1:
         ModesMenu.access$200(this.this$0).setSelected(true);
         break;
      case 2:
         ModesMenu.access$300(this.this$0).setSelected(true);
      }

   }

   public void graphSyncChanged(GraphSettings var1) {
      ModesMenu.access$400(this.this$0).setSelected(var1.getGraphSyncMode() == EGraphSynchronization.SYNC);
   }

   public void proximityBrowsingChanged(GraphProximityBrowsingSettings var1) {
      ModesMenu.access$500(this.this$0).setSelected(var1.getProximityBrowsing());
   }

   public void proximityBrowsingFrozenChanged(GraphProximityBrowsingSettings var1) {
      ModesMenu.access$600(this.this$0).setSelected(var1.getProximityBrowsingFrozen());
   }

   // $FF: synthetic method
   ModesMenu$InternalSettingsListener(ModesMenu var1, ModesMenu$1 var2) {
      this(var1);
   }
}
