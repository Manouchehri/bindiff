/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettingsListener;
import java.util.Iterator;

public class GraphProximityBrowsingSettings
implements IProximitySettings {
    private boolean proximityBrowsing;
    private boolean proximityBrowsingFrozen;
    private int proximityBrowsingChildDepth;
    private int proximityBrowsingParentDepth;
    private int autoProximityBrowsingActivationThreshold;
    private final ListenerProvider zySettingsListeners = new ListenerProvider();
    private final ListenerProvider settingsListeners = new ListenerProvider();

    public GraphProximityBrowsingSettings(GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.proximityBrowsing = graphViewSettingsConfigItem.getProximityBrowsing();
        this.proximityBrowsingFrozen = false;
        this.proximityBrowsingChildDepth = graphViewSettingsConfigItem.getProximityBrowsingChildDepth();
        this.proximityBrowsingParentDepth = graphViewSettingsConfigItem.getProximityBrowsingParentDepth();
        this.autoProximityBrowsingActivationThreshold = graphViewSettingsConfigItem.getAutoProximityBrowsingActivationThreshold();
    }

    protected void addListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.addListener(iGraphSettingsChangedListener);
            return;
        }
        catch (Exception var2_2) {
            Logger.logWarning("Listener is already listening.", new Object[0]);
        }
    }

    protected void removeListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.settingsListeners.removeListener(iGraphSettingsChangedListener);
            return;
        }
        catch (Exception var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    @Override
    public void addListener(IProximitySettingsListener iProximitySettingsListener) {
        this.zySettingsListeners.addListener(iProximitySettingsListener);
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
    public void removeListener(IProximitySettingsListener iProximitySettingsListener) {
        this.zySettingsListeners.removeListener(iProximitySettingsListener);
    }

    public void setAutoProximityBrowsingActivationThreshold(int n2) {
        if (n2 == this.autoProximityBrowsingActivationThreshold) {
            return;
        }
        this.autoProximityBrowsingActivationThreshold = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.autoProximityBrowsingActivationThresholdChanged(this);
        }
    }

    public void setProximityBrowsing(boolean bl2) {
        if (this.proximityBrowsing == bl2) {
            return;
        }
        this.proximityBrowsing = bl2;
        for (Object object2 : this.zySettingsListeners) {
            object2.changedProximityBrowsing(bl2);
        }
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (IGraphSettingsChangedListener)iterator.next();
            object2.proximityBrowsingChanged(this);
        }
    }

    public void setProximityBrowsingChildren(int n2) {
        if (n2 == this.proximityBrowsingChildDepth) {
            return;
        }
        this.proximityBrowsingChildDepth = n2;
        for (Object object2 : this.zySettingsListeners) {
            object2.changedProximityBrowsingDepth(n2, this.getProximityBrowsingParents());
        }
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (IGraphSettingsChangedListener)iterator.next();
            object2.proximityBrowsingChildDepthChanged(this);
        }
    }

    public void setProximityBrowsingFrozen(boolean bl2) {
        if (this.proximityBrowsingFrozen == bl2) {
            return;
        }
        this.proximityBrowsingFrozen = bl2;
        for (Object object2 : this.zySettingsListeners) {
            object2.changedProximityBrowsingFrozen(this.getProximityBrowsingFrozen());
        }
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (IGraphSettingsChangedListener)iterator.next();
            object2.proximityBrowsingFrozenChanged(this);
        }
    }

    public void setProximityBrowsingParents(int n2) {
        if (n2 == this.proximityBrowsingParentDepth) {
            return;
        }
        this.proximityBrowsingParentDepth = n2;
        for (Object object2 : this.zySettingsListeners) {
            object2.changedProximityBrowsingDepth(this.getProximityBrowsingChildren(), n2);
        }
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (IGraphSettingsChangedListener)iterator.next();
            object2.proximityBrowsingParentDepthChanged(this);
        }
    }
}

