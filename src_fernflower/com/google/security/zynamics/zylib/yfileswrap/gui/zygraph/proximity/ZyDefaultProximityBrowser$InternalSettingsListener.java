package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser$1;

class ZyDefaultProximityBrowser$InternalSettingsListener implements IProximitySettingsListener {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   private ZyDefaultProximityBrowser$InternalSettingsListener(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   public void changedProximityBrowsing(boolean var1) {
      ZyDefaultProximityBrowser.access$302(this.this$0, true);
      ZyDefaultProximityBrowser.access$400(this.this$0);
      ZyDefaultProximityBrowser.access$302(this.this$0, false);
      ZyDefaultProximityBrowser.access$500(this.this$0).updateViews();
   }

   public void changedProximityBrowsingDepth(int var1, int var2) {
      if(ZyDefaultProximityBrowser.access$500(this.this$0).getSettings().getProximitySettings().getProximityBrowsing()) {
         ZyDefaultProximityBrowser.access$600(this.this$0);
      }

   }

   public void changedProximityBrowsingFrozen(boolean var1) {
   }

   public void changedProximityBrowsingPreview(boolean var1) {
   }

   // $FF: synthetic method
   ZyDefaultProximityBrowser$InternalSettingsListener(ZyDefaultProximityBrowser var1, ZyDefaultProximityBrowser$1 var2) {
      this(var1);
   }
}
