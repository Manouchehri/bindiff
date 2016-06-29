package com.google.security.zynamics.zylib.gui.zygraph.settings;

public interface IProximitySettingsListener
{
    void changedProximityBrowsing(final boolean p0);
    
    void changedProximityBrowsingDepth(final int p0, final int p1);
    
    void changedProximityBrowsingFrozen(final boolean p0);
    
    void changedProximityBrowsingPreview(final boolean p0);
}
