package com.google.security.zynamics.zylib.gui.zygraph.settings;

public interface IDisplaySettings
{
    void addListener(final IDisplaySettingsListener p0);
    
    int getAnimationSpeed();
    
    boolean getMagnifyingGlassMode();
    
    void removeListener(final IDisplaySettingsListener p0);
    
    void setMagnifyingGlassMode(final boolean p0);
}
