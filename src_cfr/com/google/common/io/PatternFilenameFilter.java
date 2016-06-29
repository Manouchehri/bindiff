/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@Beta
public final class PatternFilenameFilter
implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String string) {
        this(Pattern.compile(string));
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.pattern = (Pattern)Preconditions.checkNotNull(pattern);
    }

    @Override
    public boolean accept(@Nullable File file, String string) {
        return this.pattern.matcher(string).matches();
    }
}

