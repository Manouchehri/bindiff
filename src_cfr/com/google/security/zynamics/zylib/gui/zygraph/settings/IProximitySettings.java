/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;

public interface IProximitySettings {
    public void addListener(IProximitySettingsListener var1);

    public boolean getProximityBrowsing();

    public int getProximityBrowsingChildren();

    public boolean getProximityBrowsingFrozen();

    public int getProximityBrowsingParents();

    public void removeListener(IProximitySettingsListener var1);
}

