package com.google.common.base;

import javax.annotation.*;
import java.util.regex.*;
import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class Splitter
{
    private final CharMatcher trimmer;
    private final boolean omitEmptyStrings;
    private final Splitter$Strategy strategy;
    private final int limit;
    
    private Splitter(final Splitter$Strategy splitter$Strategy) {
        this(splitter$Strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }
    
    private Splitter(final Splitter$Strategy strategy, final boolean omitEmptyStrings, final CharMatcher trimmer, final int limit) {
        this.strategy = strategy;
        this.omitEmptyStrings = omitEmptyStrings;
        this.trimmer = trimmer;
        this.limit = limit;
    }
    
    @CheckReturnValue
    public static Splitter on(final char c) {
        return on(CharMatcher.is(c));
    }
    
    @CheckReturnValue
    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Splitter$1(charMatcher));
    }
    
    @CheckReturnValue
    public static Splitter on(final String s) {
        Preconditions.checkArgument(s.length() != 0, (Object)"The separator may not be the empty string.");
        return new Splitter(new Splitter$2(s));
    }
    
    @CheckReturnValue
    @GwtIncompatible("java.util.regex")
    public static Splitter on(final Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter(new Splitter$3(pattern));
    }
    
    @CheckReturnValue
    @GwtIncompatible("java.util.regex")
    public static Splitter onPattern(final String s) {
        return on(Pattern.compile(s));
    }
    
    @CheckReturnValue
    public static Splitter fixedLength(final int n) {
        Preconditions.checkArgument(n > 0, (Object)"The length may not be less than 1");
        return new Splitter(new Splitter$4(n));
    }
    
    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }
    
    @CheckReturnValue
    public Splitter limit(final int n) {
        Preconditions.checkArgument(n > 0, "must be greater than zero: %s", n);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, n);
    }
    
    @CheckReturnValue
    public Splitter trimResults() {
        return this.trimResults(CharMatcher.WHITESPACE);
    }
    
    @CheckReturnValue
    public Splitter trimResults(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }
    
    @CheckReturnValue
    public Iterable split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Splitter$5(this, charSequence);
    }
    
    private Iterator splittingIterator(final CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }
    
    @CheckReturnValue
    @Beta
    public List splitToList(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        final Iterator splittingIterator = this.splittingIterator(charSequence);
        final ArrayList<Object> list = new ArrayList<Object>();
        while (splittingIterator.hasNext()) {
            list.add(splittingIterator.next());
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(final String s) {
        return this.withKeyValueSeparator(on(s));
    }
    
    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(final char c) {
        return this.withKeyValueSeparator(on(c));
    }
    
    @CheckReturnValue
    @Beta
    public Splitter$MapSplitter withKeyValueSeparator(final Splitter splitter) {
        return new Splitter$MapSplitter(this, splitter, null);
    }
}
