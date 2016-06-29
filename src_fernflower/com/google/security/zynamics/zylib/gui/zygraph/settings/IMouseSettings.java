package com.google.security.zynamics.zylib.gui.zygraph.settings;

import com.google.security.zynamics.zylib.gui.zygraph.MouseWheelAction;

public interface IMouseSettings {
   MouseWheelAction getMouseWheelAction();

   int getScrollSensitivity();

   int getZoomSensitivity();
}
