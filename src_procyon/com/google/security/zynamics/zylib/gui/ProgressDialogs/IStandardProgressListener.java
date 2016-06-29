package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardProgressListener
{
    void changedDescription(final String p0);
    
    void changedMaximum(final int p0);
    
    void finished();
    
    void next();
    
    void reset();
}
