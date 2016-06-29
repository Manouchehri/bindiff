package org.jfree.io;

import java.io.*;
import java.util.*;

public class FileUtilities
{
    public static File findFileOnClassPath(final String s) {
        final StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), System.getProperty("path.separator"));
        while (stringTokenizer.hasMoreTokens()) {
            final File file = new File(stringTokenizer.nextToken());
            final File absoluteFile = file.getAbsoluteFile();
            if (absoluteFile.isFile()) {
                final File file2 = new File(absoluteFile.getParent(), s);
                if (file2.exists()) {
                    return file2;
                }
                continue;
            }
            else {
                final File file3 = new File(file, s);
                if (file3.exists()) {
                    return file3;
                }
                continue;
            }
        }
        return null;
    }
}
