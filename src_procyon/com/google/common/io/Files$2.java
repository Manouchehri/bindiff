package com.google.common.io;

import com.google.common.collect.*;
import java.io.*;
import java.util.*;

final class Files$2 extends TreeTraverser
{
    public Iterable children(final File file) {
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return Collections.unmodifiableList((List<?>)Arrays.asList((T[])listFiles));
            }
        }
        return Collections.emptyList();
    }
    
    @Override
    public String toString() {
        return "Files.fileTreeTraverser()";
    }
}
