/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;

public interface IMouseSettings {
    public MouseWheelAction getMouseWheelAction();

    public int getScrollSensitivity();

    public int getZoomSensitivity();
}

