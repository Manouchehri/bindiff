package com.google.common.io;

import java.io.*;

enum Files$FilePredicate$2
{
    Files$FilePredicate$2(final String s, final int n) {
    }
    
    public boolean apply(final File file) {
        return file.isFile();
    }
    
    @Override
    public String toString() {
        return "Files.isFile()";
    }
}
