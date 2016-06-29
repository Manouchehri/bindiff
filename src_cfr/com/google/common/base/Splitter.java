/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter$1;
import com.google.common.base.Splitter$2;
import com.google.common.base.Splitter$3;
import com.google.common.base.Splitter$4;
import com.google.common.base.Splitter$5;
import com.google.common.base.Splitter$MapSplitter;
import com.google.common.base.Splitter$Strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=1)
public final class Splitter {
    private final CharMatcher trimmer;
    private final boolean omitEmptyStrings;
    private final Splitter$Strategy strategy;
    private final int limit;

    private Splitter(Splitter$Strategy splitter$Strategy) {
        this(splitter$Strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    private Splitter(Splitter$Strategy splitter$Strategy, boolean bl2, CharMatcher charMatcher, int n2) {
        this.strategy = splitter$Strategy;
        this.omitEmptyStrings = bl2;
        this.trimmer = charMatcher;
        this.limit = n2;
    }

    @CheckReturnValue
    public static Splitter on(char c2) {
        return Splitter.on(CharMatcher.is(c2));
    }

    @CheckReturnValue
    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Splitter$1(charMatcher));
    }

    @CheckReturnValue
    public static Splitter on(String string) {
        Preconditions.checkArgument(string.length() != 0, "The separator may not be the empty string.");
        return new Splitter(new Splitter$2(string));
    }

    @CheckReturnValue
    @GwtIncompatible(value="java.util.regex")
    public static Splitter on(Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter(new Splitter$3(pattern));
    }

    @CheckReturnValue
    @GwtIncompatible(value="java.util.regex")
    public static Splitter onPattern(String string) {
        return Splitter.on(Pattern.compile(string));
    }

    @CheckReturnValue
    public static Splitter fixedLength(int n2) {
        Preconditions.checkArgument(n2 > 0, "The length may not be less than 1");
        return new Splitter(new Splitter$4(n2));
    }

    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    @CheckReturnValue
    public Splitter limit(int n2) {
        Preconditions.checkArgument(n2 > 0, "must be greater than zero: %s", n2);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, n2);
    }

    @CheckReturnValue
    public Splitter trimResults() {
        return this.trimResults(CharMatcher.WHITESPACE);
    }

    @CheckReturnValue
    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    @CheckReturnValue
    public Iterable split(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Splitter$5(this, charSequence);
    }

    private Iterator splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    @CheckReturnValue
    @Beta
    public List splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator iterator = this.splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(String string) {
        return this.withKeyValueSeparator(Splitter.on(string));
    }

    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(char c2) {
        return this.withKeyValueSeparator(Splitter.on(c2));
    }

    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new Splitter$MapSplitter(this, splitter, null);
    }

    static /* synthetic */ Iterator access$000(Splitter splitter, CharSequence charSequence) {
        return splitter.splittingIterator(charSequence);
    }

    static /* synthetic */ CharMatcher access$200(Splitter splitter) {
        return splitter.trimmer;
    }

    static /* synthetic */ boolean access$300(Splitter splitter) {
        return splitter.omitEmptyStrings;
    }

    static /* synthetic */ int access$400(Splitter splitter) {
        return splitter.limit;
    }
}

