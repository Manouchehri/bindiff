package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.project.diff.*;

public interface IWorkspaceListener
{
    void addedDiff(final Diff p0);
    
    void closedWorkspace();
    
    void loadedWorkspace(final Workspace p0);
    
    void removedDiff(final Diff p0);
}
