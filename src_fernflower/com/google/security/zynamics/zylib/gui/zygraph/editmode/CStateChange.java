package com.google.security.zynamics.zylib.gui.zygraph.editmode;

import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseState;
import com.google.security.zynamics.zylib.gui.zygraph.editmode.IMouseStateChange;

public final class CStateChange implements IMouseStateChange {
   private final IMouseState m_nextState;
   private final boolean m_yfiles;

   public CStateChange(IMouseState var1, boolean var2) {
      this.m_nextState = var1;
      this.m_yfiles = var2;
   }

   public IMouseState getNextState() {
      return this.m_nextState;
   }

   public boolean notifyYFiles() {
      return this.m_yfiles;
   }
}
