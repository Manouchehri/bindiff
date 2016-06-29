package com.google.common.io;

import java.nio.file.*;
import java.io.*;
import com.google.common.collect.*;

final class MoreFiles$DirectoryTreeTraverser extends TreeTraverser
{
    private static final MoreFiles$DirectoryTreeTraverser INSTANCE;
    
    public Iterable children(final Path path) {
        if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            try {
                return MoreFiles.listFiles(path);
            }
            catch (IOException ex) {
                throw new DirectoryIteratorException(ex);
            }
        }
        return ImmutableList.of();
    }
    
    static {
        INSTANCE = new MoreFiles$DirectoryTreeTraverser();
    }
}
