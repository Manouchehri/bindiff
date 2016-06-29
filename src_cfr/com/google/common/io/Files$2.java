/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.collect.TreeTraverser;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

final class Files$2
extends TreeTraverser {
    Files$2() {
    }

    public Iterable children(File file) {
        if (!file.isDirectory()) return Collections.emptyList();
        File[] arrfile = file.listFiles();
        if (arrfile == null) return Collections.emptyList();
        return Collections.unmodifiableList(Arrays.asList(arrfile));
    }

    public String toString() {
        return "Files.fileTreeTraverser()";
    }
}

