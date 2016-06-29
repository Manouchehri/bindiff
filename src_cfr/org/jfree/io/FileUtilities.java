/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.io;

import java.io.File;
import java.util.StringTokenizer;

public class FileUtilities {
    private FileUtilities() {
    }

    public static File findFileOnClassPath(String string) {
        File file;
        String string2;
        File file2;
        File file3;
        String string3 = System.getProperty("java.class.path");
        String string4 = System.getProperty("path.separator");
        StringTokenizer stringTokenizer = new StringTokenizer(string3, string4);
        do {
            if (!stringTokenizer.hasMoreTokens()) return null;
        } while (!((file3 = (file2 = new File(string2 = stringTokenizer.nextToken())).getAbsoluteFile()).isFile() ? (file = new File(file3.getParent(), string)).exists() : (file = new File(file2, string)).exists()));
        return file;
    }
}

