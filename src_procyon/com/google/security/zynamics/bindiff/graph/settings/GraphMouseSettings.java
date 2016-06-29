package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import java.util.*;

public class GraphMouseSettings implements IMouseSettings
{
    private EMouseAction mouseWheelAction;
    private int scrollSensitivity;
    private int zoomSensitivity;
    private final ListenerProvider settingsListeners;
    
    public GraphMouseSettings(final GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.settingsListeners = new ListenerProvider();
        this.mouseWheelAction = EMouseAction.getEnum(graphViewSettingsConfigItem.getMouseWheelAction());
        this.scrollSensitivity = graphViewSettingsConfigItem.getScrollSensitivity();
        this.zoomSensitivity = graphViewSettingsConfigItem.getZoomSensitivity();
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
    public MouseWheelAction getMouseWheelAction() {
        return (this.mouseWheelAction == EMouseAction.ZOOM) ? MouseWheelAction.ZOOM : MouseWheelAction.SCROLL;
    }
    
    @Override
    public int getScrollSensitivity() {
        return this.scrollSensitivity;
    }
    
    @Override
    public int getZoomSensitivity() {
        return this.zoomSensitivity;
    }
    
    public void setMousewheelAction(final EMouseAction mouseWheelAction) {
        if (this.mouseWheelAction == mouseWheelAction) {
            return;
        }
        this.mouseWheelAction = mouseWheelAction;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().mouseWheelActionChanged(this);
        }
    }
    
    public void setScrollSensitivity(final int scrollSensitivity) {
        if (scrollSensitivity == this.scrollSensitivity) {
            return;
        }
        this.scrollSensitivity = scrollSensitivity;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().scrollSensitivityChanged(this);
        }
    }
    
    public void setZoomSensitivity(final int zoomSensitivity) {
        if (zoomSensitivity == this.zoomSensitivity) {
            return;
        }
        this.zoomSensitivity = zoomSensitivity;
        final Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().zoomSensitivityChanged(this);
        }
    }
}
