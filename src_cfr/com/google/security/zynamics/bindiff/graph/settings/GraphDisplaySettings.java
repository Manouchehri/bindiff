/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettingsListener;
import java.util.Iterator;

public class GraphDisplaySettings
implements IDisplaySettings {
    private boolean gradientBackground;
    private int animationSpeed;
    private final ListenerProvider zySettingsListeners = new ListenerProvider();
    private final ListenerProvider settingsListeners = new ListenerProvider();

    public GraphDisplaySettings(GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.animationSpeed = graphViewSettingsConfigItem.getAnimationSpeed();
        this.gradientBackground = graphViewSettingsConfigItem.getGradientBackground();
    }

    protected void addListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(iGraphSettingsChangedListener);
            return;
        }
        catch (RuntimeException var2_2) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }

    protected void removeListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(iGraphSettingsChangedListener);
            return;
        }
        catch (RuntimeException var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    @Override
    public void addListener(IDisplaySettingsListener iDisplaySettingsListener) {
        this.zySettingsListeners.addListener(iDisplaySettingsListener);
    }

    @Override
    public int getAnimationSpeed() {
        return this.animationSpeed;
    }

    public boolean getGradientBackground() {
        return this.gradientBackground;
    }

    @Override
    public boolean getMagnifyingGlassMode() {
        return false;
    }

    @Override
    public void removeListener(IDisplaySettingsListener iDisplaySettingsListener) {
        this.zySettingsListeners.removeListener(iDisplaySettingsListener);
    }

    public void setAnimationSpeed(int n2) {
        if (this.animationSpeed == n2) {
            return;
        }
        this.animationSpeed = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.animationSpeedChanged(this);
        }
    }

    public void setGradientBackground(boolean bl2) {
        if (this.gradientBackground == bl2) {
            return;
        }
        this.gradientBackground = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.gradientBackgroundChanged(this);
        }
    }

    @Override
    public void setMagnifyingGlassMode(boolean bl2) {
    }
}

