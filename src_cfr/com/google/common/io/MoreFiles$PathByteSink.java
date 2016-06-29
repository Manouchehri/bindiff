/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.MoreFiles$1;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

final class MoreFiles$PathByteSink
extends ByteSink {
    private final Path path;
    private final OpenOption[] options;

    private /* varargs */ MoreFiles$PathByteSink(Path path, OpenOption ... arropenOption) {
        this.path = (Path)Preconditions.checkNotNull(path);
        this.options = (OpenOption[])arropenOption.clone();
    }

    @Override
    public OutputStream openStream() {
        return Files.newOutputStream(this.path, this.options);
    }

    public String toString() {
        String string = String.valueOf(this.path);
        String string2 = String.valueOf(Arrays.toString(this.options));
        return new StringBuilder(24 + String.valueOf(string).length() + String.valueOf(string2).length()).append("MoreFiles.asByteSink(").append(string).append(", ").append(string2).append(")").toString();
    }

    /* synthetic */ MoreFiles$PathByteSink(Path path, OpenOption[] arropenOption, MoreFiles$1 moreFiles$1) {
        this(path, arropenOption);
    }
}

