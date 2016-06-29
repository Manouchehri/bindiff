/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import java.nio.file.FileSystemException;
import javax.annotation.Nullable;

@GoogleInternal
public final class InsecureRecursiveDeleteException
extends FileSystemException {
    public InsecureRecursiveDeleteException(@Nullable String string) {
        super(string, null, "unable to guarantee security of recursive delete");
    }
}

