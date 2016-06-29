package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardProgressModel
{
    void addProgressListener(final IStandardProgressListener p0);
    
    void closeRequested();
    
    void removeProgressListener(final IStandardProgressListener p0);
}
