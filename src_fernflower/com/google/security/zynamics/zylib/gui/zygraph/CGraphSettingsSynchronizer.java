package com.google.security.zynamics.zylib.gui.zygraph;

import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$1;
import com.google.security.zynamics.zylib.gui.zygraph.CGraphSettingsSynchronizer$InternalSettingsListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;

public class CGraphSettingsSynchronizer {
   private final AbstractZyGraphSettings m_settings;
   private final ZyEditMode m_editMode;
   private final CGraphSettingsSynchronizer$InternalSettingsListener m_settingsListener = new CGraphSettingsSynchronizer$InternalSettingsListener(this, (CGraphSettingsSynchronizer$1)null);

   public CGraphSettingsSynchronizer(ZyEditMode var1, AbstractZyGraphSettings var2) {
      this.m_editMode = var1;
      this.m_settings = var2;
      this.m_settings.getDisplaySettings().addListener(this.m_settingsListener);
   }

   public void dispose() {
      this.m_settings.getDisplaySettings().removeListener(this.m_settingsListener);
   }

   // $FF: synthetic method
   static ZyEditMode access$100(CGraphSettingsSynchronizer var0) {
      return var0.m_editMode;
   }
}
