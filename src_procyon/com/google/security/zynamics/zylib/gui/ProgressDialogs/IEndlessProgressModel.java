package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IEndlessProgressModel
{
    void addProgressListener(final IEndlessProgressListener p0);
    
    void closeRequested();
    
    void removeProgressListener(final IEndlessProgressListener p0);
}
