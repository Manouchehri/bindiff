package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IStandardProgressListener;

public interface IStandardProgressModel {
   void addProgressListener(IStandardProgressListener var1);

   void closeRequested();

   void removeProgressListener(IStandardProgressListener var1);
}
