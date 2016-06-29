package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import java.util.*;

public class GraphProximityBrowsingSettings implements IProximitySettings
{
    private boolean proximityBrowsing;
    private boolean proximityBrowsingFrozen;
    private int proximityBrowsingChildDepth;
    private int proximityBrowsingParentDepth;
    private int autoProximityBrowsingActivationThreshold;
    private final ListenerProvider zySettingsListeners;
    private final ListenerProvider settingsListeners;
    
    public GraphProximityBrowsingSettings(final GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.zySettingsListeners = new ListenerProvider();
        this.settingsListeners = new ListenerProvider();
        this.proximityBrowsing = graphViewSettingsConfigItem.getProximityBrowsing();
        this.proximityBrowsingFrozen = false;
        this.proximityBrowsingChildDepth = graphViewSettingsConfigItem.getProximityBrowsingChildDepth();
        this.proximityBrowsingParentDepth = graphViewSettingsConfigItem.getProximityBrowsingParentDepth();
        this.autoProximityBrowsingActivationThreshold = graphViewSettingsConfigItem.getAutoProximityBrowsingActivationThreshold();
    }
    
    protected void addListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(graphSettingsChangedListener);
        }
        catch (Exception ex) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }
    
    protected void removeListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(graphSettingsChangedListener);
        }
        catch (Exception ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    @Override
    public void addListener(final IProximitySettingsListener proximitySettingsListener) {
        this.zySettingsListeners.addListener(proximitySettingsListener);
    }
    
    public int getAutoProximityBrowsingActivationThreshold() {
        return this.autoProximityBrowsingActivationThreshold;
    }
    
    @Override
    public boolean getProximityBrowsing() {
        return this.proximityBrowsing;
    }
    
    @Override
    public int getProximityBrowsingChildren() {
        return this.proximityBrowsingChildDepth;
    }
    
    @Override
    public boolean getProximityBrowsingFrozen() {
        return this.proximityBrowsingFrozen;
    }
    
    @Override
    public int getProximityBrowsingParents() {
        return this.proximityBrowsingParentDepth;
    }
    
    @Override
    public void removeListener(final IProximitySettingsListener proximitySettingsListener) {
        this.zySettingsListeners.removeListener(proximitySettingsListener);
    }
    
    public void setAutoProximityBrowsingActivationThreshold(final int autoProximityBrowsingActivationThreshold) {
        if (autoProximityBrowsingActivationThreshold == this.autoProximityBrowsingActivationThreshold) {
            return;
        }
        this.autoProximityBrowsingActivationThreshold = autoProximityBrowsingActivationThreshold;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().autoProximityBrowsingActivationThresholdChanged(this);
        }
    }
    
    public void setProximityBrowsing(final boolean proximityBrowsing) {
        if (this.proximityBrowsing == proximityBrowsing) {
            return;
        }
        this.proximityBrowsing = proximityBrowsing;
        final Iterator iterator = this.zySettingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedProximityBrowsing(proximityBrowsing);
        }
        final Iterator iterator2 = this.settingsListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().proximityBrowsingChanged(this);
        }
    }
    
    public void setProximityBrowsingChildren(final int proximityBrowsingChildDepth) {
        if (proximityBrowsingChildDepth == this.proximityBrowsingChildDepth) {
            return;
        }
        this.proximityBrowsingChildDepth = proximityBrowsingChildDepth;
        final Iterator iterator = this.zySettingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedProximityBrowsingDepth(proximityBrowsingChildDepth, this.getProximityBrowsingParents());
        }
        final Iterator iterator2 = this.settingsListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().proximityBrowsingChildDepthChanged(this);
        }
    }
    
    public void setProximityBrowsingFrozen(final boolean proximityBrowsingFrozen) {
        if (this.proximityBrowsingFrozen == proximityBrowsingFrozen) {
            return;
        }
        this.proximityBrowsingFrozen = proximityBrowsingFrozen;
        final Iterator iterator = this.zySettingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedProximityBrowsingFrozen(this.getProximityBrowsingFrozen());
        }
        final Iterator iterator2 = this.settingsListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().proximityBrowsingFrozenChanged(this);
        }
    }
    
    public void setProximityBrowsingParents(final int proximityBrowsingParentDepth) {
        if (proximityBrowsingParentDepth == this.proximityBrowsingParentDepth) {
            return;
        }
        this.proximityBrowsingParentDepth = proximityBrowsingParentDepth;
        final Iterator iterator = this.zySettingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().changedProximityBrowsingDepth(this.getProximityBrowsingChildren(), proximityBrowsingParentDepth);
        }
        final Iterator iterator2 = this.settingsListeners.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().proximityBrowsingParentDepthChanged(this);
        }
    }
}
