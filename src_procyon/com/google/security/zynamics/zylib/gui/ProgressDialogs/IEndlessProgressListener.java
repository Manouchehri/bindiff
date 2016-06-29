package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IEndlessProgressListener
{
    void changedDescription(final String p0);
    
    void changedGeneralDescription(final String p0);
    
    void finished();
}
