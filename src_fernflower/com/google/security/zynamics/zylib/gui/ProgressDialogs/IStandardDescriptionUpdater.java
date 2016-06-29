package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardDescriptionUpdater {
   void next();

   void reset();

   void setDescription(String var1);

   void setMaximum(int var1);
}
