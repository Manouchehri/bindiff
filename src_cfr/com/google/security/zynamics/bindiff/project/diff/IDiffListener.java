/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.project.diff.Diff;

public interface IDiffListener {
    public void closedView(Diff var1);

    public void loadedDiff(Diff var1);

    public void loadedView(Diff var1);

    public void removedDiff(Diff var1);

    public void unloadedDiff(Diff var1);

    public void willOverwriteDiff(String var1);
}

