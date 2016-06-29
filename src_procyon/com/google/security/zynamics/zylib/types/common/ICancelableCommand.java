package com.google.security.zynamics.zylib.types.common;

public interface ICancelableCommand extends ICommand
{
    void cancel();
    
    boolean wasCanceled();
}
