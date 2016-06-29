/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import java.io.File;

public interface IDirectoryTraversalCallback {
    public void entering(File var1);

    public void leaving(File var1);

    public void nextFile(File var1);
}

