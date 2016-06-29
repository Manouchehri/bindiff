package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$1;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;

class CGraphSettingsSynchronizer$InternalSettingsListener implements IDisplaySettingsListener {
   // $FF: synthetic field
   final CGraphSettingsSynchronizer this$0;

   private CGraphSettingsSynchronizer$InternalSettingsListener(CGraphSettingsSynchronizer var1) {
      this.this$0 = var1;
   }

   public void changedMagnifyingGlass(boolean var1) {
      CGraphSettingsSynchronizer.access$100(this.this$0).setMagnifyingMode(var1);
   }

   // $FF: synthetic method
   CGraphSettingsSynchronizer$InternalSettingsListener(CGraphSettingsSynchronizer var1, CGraphSettingsSynchronizer$1 var2) {
      this(var1);
   }
}
