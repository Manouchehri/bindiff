package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;

public interface IWorkspaceListener {
   void addedDiff(Diff var1);

   void closedWorkspace();

   void loadedWorkspace(Workspace var1);

   void removedDiff(Diff var1);
}
