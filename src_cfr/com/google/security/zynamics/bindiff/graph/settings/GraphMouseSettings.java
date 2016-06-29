/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.settings;

import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;
import com.google.security.zynamics.zylib.gui.zygraph.settings.IMouseSettings;
import java.util.Iterator;

public class GraphMouseSettings
implements IMouseSettings {
    private EMouseAction mouseWheelAction;
    private int scrollSensitivity;
    private int zoomSensitivity;
    private final ListenerProvider settingsListeners = new ListenerProvider();

    public GraphMouseSettings(GraphViewSettingsConfigItem graphViewSettingsConfigItem) {
        this.mouseWheelAction = EMouseAction.getEnum(graphViewSettingsConfigItem.getMouseWheelAction());
        this.scrollSensitivity = graphViewSettingsConfigItem.getScrollSensitivity();
        this.zoomSensitivity = graphViewSettingsConfigItem.getZoomSensitivity();
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
    public MouseWheelAction getMouseWheelAction() {
        MouseWheelAction mouseWheelAction;
        if (this.mouseWheelAction == EMouseAction.ZOOM) {
            mouseWheelAction = MouseWheelAction.ZOOM;
            return mouseWheelAction;
        }
        mouseWheelAction = MouseWheelAction.SCROLL;
        return mouseWheelAction;
    }

    @Override
    public int getScrollSensitivity() {
        return this.scrollSensitivity;
    }

    @Override
    public int getZoomSensitivity() {
        return this.zoomSensitivity;
    }

    public void setMousewheelAction(EMouseAction eMouseAction) {
        if (this.mouseWheelAction == eMouseAction) {
            return;
        }
        this.mouseWheelAction = eMouseAction;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.mouseWheelActionChanged(this);
        }
    }

    public void setScrollSensitivity(int n2) {
        if (n2 == this.scrollSensitivity) {
            return;
        }
        this.scrollSensitivity = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.scrollSensitivityChanged(this);
        }
    }

    public void setZoomSensitivity(int n2) {
        if (n2 == this.zoomSensitivity) {
            return;
        }
        this.zoomSensitivity = n2;
        Iterator iterator = this.settingsListeners.iterator();
        while (iterator.hasNext()) {
            IGraphSettingsChangedListener iGraphSettingsChangedListener = (IGraphSettingsChangedListener)iterator.next();
            iGraphSettingsChangedListener.zoomSensitivityChanged(this);
        }
    }
}

