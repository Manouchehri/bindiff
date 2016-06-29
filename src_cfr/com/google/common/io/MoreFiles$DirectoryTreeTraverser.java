/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.MoreFiles;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

final class MoreFiles$DirectoryTreeTraverser
extends TreeTraverser {
    private static final MoreFiles$DirectoryTreeTraverser INSTANCE = new MoreFiles$DirectoryTreeTraverser();

    private MoreFiles$DirectoryTreeTraverser() {
    }

    public Iterable children(Path path) {
        if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) return ImmutableList.of();
        try {
            return MoreFiles.listFiles(path);
        }
        catch (IOException var2_2) {
            throw new DirectoryIteratorException(var2_2);
        }
    }

    static /* synthetic */ MoreFiles$DirectoryTreeTraverser access$200() {
        return INSTANCE;
    }
}

