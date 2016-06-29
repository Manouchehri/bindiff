package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IEndlessProgressListener {
   void changedDescription(String var1);

   void changedGeneralDescription(String var1);

   void finished();
}
