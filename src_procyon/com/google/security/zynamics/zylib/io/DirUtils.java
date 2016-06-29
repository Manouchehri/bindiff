package com.google.security.zynamics.zylib.io;

import java.io.*;
import java.util.*;

public class DirUtils
{
    public static void traverse(final File file, final IDirectoryTraversalCallback directoryTraversalCallback) {
        traverse(file, directoryTraversalCallback, true);
    }
    
    public static void traverse(final File file, final IDirectoryTraversalCallback directoryTraversalCallback, final boolean b) {
        final File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        directoryTraversalCallback.entering(file);
        for (final File file2 : listFiles) {
            if (!file2.isDirectory()) {
                directoryTraversalCallback.nextFile(file2);
            }
        }
        if (b) {
            for (final File file3 : listFiles) {
                if (file3.isDirectory()) {
                    traverse(file3, directoryTraversalCallback);
                }
            }
        }
        directoryTraversalCallback.leaving(file);
    }
    
    public static void traverse(final File file, final IDirectoryTraversalCallback directoryTraversalCallback, final Comparator comparator) {
        final File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        Arrays.sort(listFiles, comparator);
        directoryTraversalCallback.entering(file);
        for (final File file2 : listFiles) {
            if (!file2.isDirectory()) {
                directoryTraversalCallback.nextFile(file2);
            }
        }
        for (final File file3 : listFiles) {
            if (file3.isDirectory()) {
                traverse(file3, directoryTraversalCallback);
            }
        }
        directoryTraversalCallback.leaving(file);
    }
}
