/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class FilesizeSorter
implements Serializable,
Comparator {
    private static final long serialVersionUID = 7060651903531011219L;

    public int compare(File file, File file2) {
        return (int)(file.length() - file2.length());
    }
}

