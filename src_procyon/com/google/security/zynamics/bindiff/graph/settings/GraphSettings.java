package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.settings.*;
import com.google.security.zynamics.zylib.gui.zygraph.settings.*;

public class GraphSettings extends AbstractZyGraphSettings
{
    public static final int MAX_SELECTION_UNDO_CACHE = 30;
    private final ListenerProvider settingsListeners;
    private final GraphLayoutSettings layoutSettings;
    private final GraphProximityBrowsingSettings proximitySettings;
    private final GraphDisplaySettings displaySettings;
    private final GraphMouseSettings mouseSettings;
    private boolean drawBends;
    private boolean showScrollbars;
    private ESide focusSide;
    private EDiffViewMode diffViewMode;
    private EGraphSynchronization graphSync;
    
    public GraphSettings(final GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.settingsListeners = new ListenerProvider();
        this.layoutSettings = new GraphLayoutSettings(graphViewSettingsConfigItem);
        this.proximitySettings = new GraphProximityBrowsingSettings(graphViewSettingsConfigItem);
        this.displaySettings = new GraphDisplaySettings(graphViewSettingsConfigItem);
        this.mouseSettings = new GraphMouseSettings(graphViewSettingsConfigItem);
        this.drawBends = graphViewSettingsConfigItem.getDrawBends();
        this.showScrollbars = graphViewSettingsConfigItem.getShowScrollbars();
        this.graphSync = (graphViewSettingsConfigItem.getViewSynchronization() ? EGraphSynchronization.SYNC : EGraphSynchronization.ASYNC);
        this.focusSide = ESide.PRIMARY;
        this.diffViewMode = EDiffViewMode.NORMAL_VIEW;
    }
    
    public void addListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        this.settingsListeners.addListener(graphSettingsChangedListener);
        this.layoutSettings.addListener(graphSettingsChangedListener);
        this.proximitySettings.addListener(graphSettingsChangedListener);
        this.displaySettings.addListener(graphSettingsChangedListener);
        this.mouseSettings.addListener(graphSettingsChangedListener);
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
        return EGraphSynchronization.ASYNC == this.getGraphSyncMode();
    }
    
    public boolean isSync() {
        return EGraphSynchronization.SYNC == this.getGraphSyncMode();
    }
    
    public void removeListener(final IGraphSettingsChangedListener graphSettingsChangedListener) {
        try {
            this.layoutSettings.removeListener(graphSettingsChangedListener);
            this.proximitySettings.removeListener(graphSettingsChangedListener);
            this.displaySettings.removeListener(graphSettingsChangedListener);
            this.mouseSettings.removeListener(graphSettingsChangedListener);
        }
        catch (Exception ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    public void setDiffViewMode(final EDiffViewMode diffViewMode) {
        this.diffViewMode = diffViewMode;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().diffViewModeChanged(this);
        }
    }
    
    public void setDrawBends(final boolean drawBends) {
        if (this.drawBends == drawBends) {
            return;
        }
        this.drawBends = drawBends;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().drawBendsChanged(this);
        }
    }
    
    public void setFocusSide(final ESide focusSide) {
        if (this.focusSide == focusSide) {
            return;
        }
        this.focusSide = focusSide;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().focusSideChanged(this);
        }
    }
    
    public void setGraphSyncMode(final EGraphSynchronization graphSync) {
        if (this.graphSync == graphSync) {
            return;
        }
        this.graphSync = graphSync;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().graphSyncChanged(this);
        }
    }
    
    public void setShowScrollbars(final boolean showScrollbars) {
        if (this.showScrollbars == showScrollbars) {
            return;
        }
        this.showScrollbars = showScrollbars;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().showScrollbarsChanged(this);
        }
    }
}
