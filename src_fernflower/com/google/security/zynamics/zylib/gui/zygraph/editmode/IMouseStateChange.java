package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;

public interface IMouseStateChange {
   IMouseState getNextState();

   boolean notifyYFiles();
}
