/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;

public interface IWorkspaceListener {
    public void addedDiff(Diff var1);

    public void closedWorkspace();

    public void loadedWorkspace(Workspace var1);

    public void removedDiff(Diff var1);
}

