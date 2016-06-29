package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;

public interface IProximitySettings {
   void addListener(IProximitySettingsListener var1);

   boolean getProximityBrowsing();

   int getProximityBrowsingChildren();

   boolean getProximityBrowsingFrozen();

   int getProximityBrowsingParents();

   void removeListener(IProximitySettingsListener var1);
}
