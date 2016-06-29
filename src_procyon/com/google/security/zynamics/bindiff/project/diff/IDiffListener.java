package com.google.security.zynamics.bindiff.project.diff;

public interface IDiffListener
{
    void closedView(final Diff p0);
    
    void loadedDiff(final Diff p0);
    
    void loadedView(final Diff p0);
    
    void removedDiff(final Diff p0);
    
    void unloadedDiff(final Diff p0);
    
    void willOverwriteDiff(final String p0);
}
