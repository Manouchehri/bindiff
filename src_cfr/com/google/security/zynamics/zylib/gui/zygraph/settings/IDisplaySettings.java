/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;

public interface IDisplaySettings {
    public void addListener(IDisplaySettingsListener var1);

    public int getAnimationSpeed();

    public boolean getMagnifyingGlassMode();

    public void removeListener(IDisplaySettingsListener var1);

    public void setMagnifyingGlassMode(boolean var1);
}

