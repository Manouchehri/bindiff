/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.Files$1;
import com.google.common.io.Files$FilePredicate;
import java.io.File;

final class Files$FilePredicate$2
extends Files$FilePredicate {
    Files$FilePredicate$2(String string2, int n3) {
        super(string, n2, null);
    }

    public boolean apply(File file) {
        return file.isFile();
    }

    public String toString() {
        return "Files.isFile()";
    }
}

