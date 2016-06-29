package com.google.security.zynamics.zylib.types.common;

import com.google.security.zynamics.zylib.types.common.ICommand;

public interface ICancelableCommand extends ICommand {
   void cancel();

   boolean wasCanceled();
}
