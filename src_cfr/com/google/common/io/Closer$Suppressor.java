/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;

@VisibleForTesting
interface Closer$Suppressor {
    public void suppress(Closeable var1, Throwable var2, Throwable var3);
}

