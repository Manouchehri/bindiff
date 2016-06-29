package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;

public interface IDisplaySettings {
   void addListener(IDisplaySettingsListener var1);

   int getAnimationSpeed();

   boolean getMagnifyingGlassMode();

   void removeListener(IDisplaySettingsListener var1);

   void setMagnifyingGlassMode(boolean var1);
}
