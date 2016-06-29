package com.google.security.zynamics.zylib.gui.ProgressDialogs;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.IEndlessProgressListener;

public interface IEndlessProgressModel {
   void addProgressListener(IEndlessProgressListener var1);

   void closeRequested();

   void removeProgressListener(IEndlessProgressListener var1);
}
