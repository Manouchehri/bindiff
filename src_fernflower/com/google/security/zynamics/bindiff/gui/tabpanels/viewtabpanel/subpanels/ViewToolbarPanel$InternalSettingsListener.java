package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettingsChangedListenerAdapter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel$1;
import javax.swing.JButton;

class ViewToolbarPanel$InternalSettingsListener extends GraphSettingsChangedListenerAdapter {
   // $FF: synthetic field
   final ViewToolbarPanel this$0;

   private ViewToolbarPanel$InternalSettingsListener(ViewToolbarPanel var1) {
      this.this$0 = var1;
   }

   public void autoLayoutChanged(GraphLayoutSettings var1) {
      boolean var2 = var1.getAutomaticLayouting();
      JButton var3 = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(0);
      var3.setIcon(var2?ViewToolbarPanel.access$200():ViewToolbarPanel.access$300());
      var3.setRolloverIcon(var2?ViewToolbarPanel.access$400():ViewToolbarPanel.access$500());
      var3.setPressedIcon(var2?ViewToolbarPanel.access$600():ViewToolbarPanel.access$700());
      this.this$0.updateUI();
   }

   public void graphSyncChanged(GraphSettings var1) {
      ViewToolbarPanel.access$1000(this.this$0).setIcon(var1.isSync()?ViewToolbarPanel.access$800():ViewToolbarPanel.access$900());
      ViewToolbarPanel.access$1000(this.this$0).setRolloverIcon(var1.isSync()?ViewToolbarPanel.access$1100():ViewToolbarPanel.access$1200());
      ViewToolbarPanel.access$1000(this.this$0).setPressedIcon(var1.isSync()?ViewToolbarPanel.access$1300():ViewToolbarPanel.access$1400());
      this.this$0.updateUI();
   }

   public void proximityBrowsingChanged(GraphProximityBrowsingSettings var1) {
      boolean var2 = var1.getProximityBrowsing();
      this.proximityBrowsingFrozenChanged(var1);
      JButton var3 = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(1);
      var3.setIcon(var2?ViewToolbarPanel.access$1500():ViewToolbarPanel.access$1600());
      var3.setRolloverIcon(var2?ViewToolbarPanel.access$1700():ViewToolbarPanel.access$1800());
      var3.setPressedIcon(var2?ViewToolbarPanel.access$1900():ViewToolbarPanel.access$2000());
      this.this$0.updateUI();
   }

   public void proximityBrowsingFrozenChanged(GraphProximityBrowsingSettings var1) {
      boolean var2 = var1.getProximityBrowsing();
      boolean var3 = var1.getProximityBrowsingFrozen();
      JButton var4;
      if(var2) {
         var4 = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(2);
         var4.setIcon(var3?ViewToolbarPanel.access$2100():ViewToolbarPanel.access$2200());
         var4.setRolloverIcon(var3?ViewToolbarPanel.access$2300():ViewToolbarPanel.access$2400());
         var4.setPressedIcon(var3?ViewToolbarPanel.access$2500():ViewToolbarPanel.access$2600());
      } else {
         var4 = (JButton)ViewToolbarPanel.access$100(this.this$0).getComponentAtIndex(2);
         var4.setIcon(var3?ViewToolbarPanel.access$2700():ViewToolbarPanel.access$2800());
         var4.setRolloverIcon(var3?ViewToolbarPanel.access$2900():ViewToolbarPanel.access$3000());
         var4.setPressedIcon(var3?ViewToolbarPanel.access$3100():ViewToolbarPanel.access$3200());
      }

      this.this$0.updateUI();
   }

   // $FF: synthetic method
   ViewToolbarPanel$InternalSettingsListener(ViewToolbarPanel var1, ViewToolbarPanel$1 var2) {
      this(var1);
   }
}
