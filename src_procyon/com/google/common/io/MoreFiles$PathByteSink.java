package com.google.common.io;

import com.google.common.base.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

final class MoreFiles$PathByteSink extends ByteSink
{
    private final Path path;
    private final OpenOption[] options;
    
    private MoreFiles$PathByteSink(final Path path, final OpenOption... array) {
        this.path = (Path)Preconditions.checkNotNull(path);
        this.options = array.clone();
    }
    
    @Override
    public OutputStream openStream() {
        return Files.newOutputStream(this.path, this.options);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.path);
        final String value2 = String.valueOf(Arrays.toString(this.options));
        return new StringBuilder(24 + String.valueOf(value).length() + String.valueOf(value2).length()).append("MoreFiles.asByteSink(").append(value).append(", ").append(value2).append(")").toString();
    }
}
