/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import com.google.security.zynamics.zylib.io.IDirectoryTraversalCallback;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DirUtils {
    public static void traverse(File file, IDirectoryTraversalCallback iDirectoryTraversalCallback) {
        DirUtils.traverse(file, iDirectoryTraversalCallback, true);
    }

    public static void traverse(File file, IDirectoryTraversalCallback iDirectoryTraversalCallback, boolean bl2) {
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            return;
        }
        iDirectoryTraversalCallback.entering(file);
        for (File file22 : arrfile) {
            if (file22.isDirectory()) continue;
            iDirectoryTraversalCallback.nextFile(file22);
        }
        if (bl2) {
            for (File file22 : arrfile) {
                if (!file22.isDirectory()) continue;
                DirUtils.traverse(file22, iDirectoryTraversalCallback);
            }
        }
        iDirectoryTraversalCallback.leaving(file);
    }

    public static void traverse(File file, IDirectoryTraversalCallback iDirectoryTraversalCallback, Comparator comparator) {
        File[] arrfile = file.listFiles();
        if (arrfile == null) {
            return;
        }
        Arrays.sort(arrfile, comparator);
        iDirectoryTraversalCallback.entering(file);
        for (File file22 : arrfile) {
            if (file22.isDirectory()) continue;
            iDirectoryTraversalCallback.nextFile(file22);
        }
        File[] arrfile2 = arrfile;
        int n2 = arrfile2.length;
        int n3 = 0;
        do {
            File file22;
            if (n3 >= n2) {
                iDirectoryTraversalCallback.leaving(file);
                return;
            }
            file22 = arrfile2[n3];
            if (file22.isDirectory()) {
                DirUtils.traverse(file22, iDirectoryTraversalCallback);
            }
            ++n3;
        } while (true);
    }
}

