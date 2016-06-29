/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphMouseSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.AbstractZyGraphSettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IDisplaySettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IMouseSettings;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IProximitySettings;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.ILayoutSettings;
import java.util.Iterator;

public class GraphSettings
extends AbstractZyGraphSettings {
    public static final int MAX_SELECTION_UNDO_CACHE = 30;
    private final ListenerProvider settingsListeners = new ListenerProvider();
    private final GraphLayoutSettings layoutSettings;
    private final GraphProximityBrowsingSettings proximitySettings;
    private final GraphDisplaySettings displaySettings;
    private final GraphMouseSettings mouseSettings;
    private boolean drawBends;
    private boolean showScrollbars;
    private ESide focusSide;
    private EDiffViewMode diffViewMode;
    private EGraphSynchronization graphSync;

    public GraphSettings(GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.layoutSettings = new GraphLayoutSettings(graphViewSettingsConfigItem);
        this.proximitySettings = new GraphProximityBrowsingSettings(graphViewSettingsConfigItem);
        this.displaySettings = new GraphDisplaySettings(graphViewSettingsConfigItem);
        this.mouseSettings = new GraphMouseSettings(graphViewSettingsConfigItem);
        this.drawBends = graphViewSettingsConfigItem.getDrawBends();
        this.showScrollbars = graphViewSettingsConfigItem.getShowScrollbars();
        this.graphSync = graphViewSettingsConfigItem.getViewSynchronization() ? EGraphSynchronization.SYNC : EGraphSynchronization.ASYNC;
        this.focusSide = ESide.PRIMARY;
        this.diffViewMode = EDiffViewMode.NORMAL_VIEW;
    }

    public void addListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        this.settingsListeners.addListener(iGraphSettingsChangedListener);
        this.layoutSettings.addListener(iGraphSettingsChangedListener);
        this.proximitySettings.addListener(iGraphSettingsChangedListener);
        this.displaySettings.addListener(iGraphSettingsChangedListener);
        this.mouseSettings.addListener(iGraphSettingsChangedListener);
    }

    public EDiffViewMode getDiffViewMode() {
        return this.diffViewMode;
    }

    @Override
    public GraphDisplaySettings getDisplaySettings() {
        return this.displaySettings;
    }

    public boolean getDrawBends() {
        return this.drawBends;
    }

    public ESide getFocus() {
        return this.focusSide;
    }

    public EGraphSynchronization getGraphSyncMode() {
        return this.graphSync;
    }

    @Override
    public GraphLayoutSettings getLayoutSettings() {
        return this.layoutSettings;
    }

    @Override
    public GraphMouseSettings getMouseSettings() {
        return this.mouseSettings;
    }

    @Override
    public GraphProximityBrowsingSettings getProximitySettings() {
        return this.proximitySettings;
    }

    public boolean getShowScrollbars() {
        return this.showScrollbars;
    }

    public boolean isAsync() {
        if (EGraphSynchronization.ASYNC != this.getGraphSyncMode()) return false;
        return true;
    }

    public boolean isSync() {
        if (EGraphSynchronization.SYNC != this.getGraphSyncMode()) return false;
        return true;
    }

    public void removeListener(IGraphSettingsChangedListener iGraphSettingsChangedListener) {
        try {
            this.layoutSettings.removeListener(iGraphSettingsChangedListener);
            this.proximitySettings.removeListener(iGraphSettingsChangedListener);
            this.displaySettings.removeListener(iGraphSettingsChangedListener);
            this.mouseSettings.removeListener(iGraphSettingsChangedListener);
            return;
        }
        catch (Exception var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    public void setDiffViewMode(EDiffViewMode eDiffViewMode) {
        this.diffViewMode = eDiffViewMode;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.diffViewModeChanged(this);
        }
    }

    public void setDrawBends(boolean bl2) {
        if (this.drawBends == bl2) {
            return;
        }
        this.drawBends = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.drawBendsChanged(this);
        }
    }

    public void setFocusSide(ESide eSide) {
        if (this.focusSide == eSide) {
            return;
        }
        this.focusSide = eSide;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.focusSideChanged(this);
        }
    }

    public void setGraphSyncMode(EGraphSynchronization eGraphSynchronization) {
        if (this.graphSync == eGraphSynchronization) {
            return;
        }
        this.graphSync = eGraphSynchronization;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.graphSyncChanged(this);
        }
    }

    public void setShowScrollbars(boolean bl2) {
        if (this.showScrollbars == bl2) {
            return;
        }
        this.showScrollbars = bl2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.showScrollbarsChanged(this);
        }
    }
}

