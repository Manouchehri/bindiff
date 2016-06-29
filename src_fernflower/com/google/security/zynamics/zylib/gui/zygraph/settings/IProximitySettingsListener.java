package com.google.security.zynamics.zylib.gui.zygraph.settings;

public interface IProximitySettingsListener {
   void changedProximityBrowsing(boolean var1);

   void changedProximityBrowsingDepth(int var1, int var2);

   void changedProximityBrowsingFrozen(boolean var1);

   void changedProximityBrowsingPreview(boolean var1);
}
