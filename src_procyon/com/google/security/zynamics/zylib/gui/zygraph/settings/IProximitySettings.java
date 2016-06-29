package com.google.security.zynamics.zylib.gui.zygraph.settings;

public interface IProximitySettings
{
    void addListener(final IProximitySettingsListener p0);
    
    boolean getProximityBrowsing();
    
    int getProximityBrowsingChildren();
    
    boolean getProximityBrowsingFrozen();
    
    int getProximityBrowsingParents();
    
    void removeListener(final IProximitySettingsListener p0);
}
