package com.google.common.io;

import java.io.*;

enum Files$FilePredicate$1
{
    Files$FilePredicate$1(final String s, final int n) {
    }
    
    public boolean apply(final File file) {
        return file.isDirectory();
    }
    
    @Override
    public String toString() {
        return "Files.isDirectory()";
    }
}
