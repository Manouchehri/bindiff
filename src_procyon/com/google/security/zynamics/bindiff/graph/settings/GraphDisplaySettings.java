package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import java.util.*;

public class GraphDisplaySettings implements IDisplaySettings
{
    private boolean gradientBackground;
    private int animationSpeed;
    private final ListenerProvider zySettingsListeners;
    private final ListenerProvider settingsListeners;
    
    public GraphDisplaySettings(final GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.zySettingsListeners = new ListenerProvider();
        this.settingsListeners = new ListenerProvider();
        this.animationSpeed = graphViewSettingsConfigItem.getAnimationSpeed();
        this.gradientBackground = graphViewSettingsConfigItem.getGradientBackground();
    }
    
    protected void addListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(graphSettingsChangedListener);
        }
        catch (RuntimeException ex) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }
    
    protected void removeListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(graphSettingsChangedListener);
        }
        catch (RuntimeException ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    @Override
    public void addListener(final IDisplaySettingsListener displaySettingsListener) {
        this.zySettingsListeners.addListener(displaySettingsListener);
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
    public void removeListener(final IDisplaySettingsListener displaySettingsListener) {
        this.zySettingsListeners.removeListener(displaySettingsListener);
    }
    
    public void setAnimationSpeed(final int animationSpeed) {
        if (this.animationSpeed == animationSpeed) {
            return;
        }
        this.animationSpeed = animationSpeed;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().animationSpeedChanged(this);
        }
    }
    
    public void setGradientBackground(final boolean gradientBackground) {
        if (this.gradientBackground == gradientBackground) {
            return;
        }
        this.gradientBackground = gradientBackground;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().gradientBackgroundChanged(this);
        }
    }
    
    @Override
    public void setMagnifyingGlassMode(final boolean b) {
    }
}
