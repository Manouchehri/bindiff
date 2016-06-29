/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project;

import com.google.security.zynamics.bindiff.project.IWorkspaceListener;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;

public class WorkspaceAdapter
implements IWorkspaceListener {
    @Override
    public void addedDiff(Diff diff) {
    }

    @Override
    public void closedWorkspace() {
    }

    @Override
    public void loadedWorkspace(Workspace workspace) {
    }

    @Override
    public void removedDiff(Diff diff) {
    }
}

