package com.google.security.zynamics.zylib.disassembly;

import java.util.Date;

public interface IViewListener {
   void changedDescription(Object var1, String var2);

   void changedModificationDate(Object var1, Date var2);

   void changedName(Object var1, String var2);

   boolean closingView(Object var1);

   void loadedView(Object var1);
}
