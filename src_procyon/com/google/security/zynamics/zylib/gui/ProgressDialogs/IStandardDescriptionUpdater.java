package com.google.security.zynamics.zylib.gui.ProgressDialogs;

public interface IStandardDescriptionUpdater
{
    void next();
    
    void reset();
    
    void setDescription(final String p0);
    
    void setMaximum(final int p0);
}
