package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardProgressListener {
   void changedDescription(String var1);

   void changedMaximum(int var1);

   void finished();

   void next();

   void reset();
}
