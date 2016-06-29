package com.google.common.base;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import java.io.*;

@GwtCompatible
public class Joiner
{
    private final String separator;
    
    @CheckReturnValue
    public static Joiner on(final String s) {
        return new Joiner(s);
    }
    
    @CheckReturnValue
    public static Joiner on(final char c) {
        return new Joiner(String.valueOf(c));
    }
    
    private Joiner(final String s) {
        this.separator = (String)Preconditions.checkNotNull(s);
    }
    
    private Joiner(final Joiner joiner) {
        this.separator = joiner.separator;
    }
    
    public Appendable appendTo(final Appendable appendable, final Iterable iterable) {
        return this.appendTo(appendable, iterable.iterator());
    }
    
    public Appendable appendTo(final Appendable appendable, final Iterator iterator) {
        Preconditions.checkNotNull(appendable);
        if (iterator.hasNext()) {
            appendable.append(this.toString(iterator.next()));
            while (iterator.hasNext()) {
                appendable.append(this.separator);
                appendable.append(this.toString(iterator.next()));
            }
        }
        return appendable;
    }
    
    public final Appendable appendTo(final Appendable appendable, final Object[] array) {
        return this.appendTo(appendable, Arrays.asList(array));
    }
    
    public final Appendable appendTo(final Appendable appendable, @Nullable final Object o, @Nullable final Object o2, final Object... array) {
        return this.appendTo(appendable, iterable(o, o2, array));
    }
    
    public final StringBuilder appendTo(final StringBuilder sb, final Iterable iterable) {
        return this.appendTo(sb, iterable.iterator());
    }
    
    public final StringBuilder appendTo(final StringBuilder sb, final Iterator iterator) {
        try {
            this.appendTo((Appendable)sb, iterator);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
        return sb;
    }
    
    public final StringBuilder appendTo(final StringBuilder sb, final Object[] array) {
        return this.appendTo(sb, Arrays.asList(array));
    }
    
    public final StringBuilder appendTo(final StringBuilder sb, @Nullable final Object o, @Nullable final Object o2, final Object... array) {
        return this.appendTo(sb, iterable(o, o2, array));
    }
    
    @CheckReturnValue
    public final String join(final Iterable iterable) {
        return this.join(iterable.iterator());
    }
    
    @CheckReturnValue
    public final String join(final Iterator iterator) {
        return this.appendTo(new StringBuilder(), iterator).toString();
    }
    
    @CheckReturnValue
    public final String join(final Object[] array) {
        return this.join(Arrays.asList(array));
    }
    
    @CheckReturnValue
    public final String join(@Nullable final Object o, @Nullable final Object o2, final Object... array) {
        return this.join(iterable(o, o2, array));
    }
    
    @CheckReturnValue
    public Joiner useForNull(final String s) {
        Preconditions.checkNotNull(s);
        return new Joiner$1(this, this, s);
    }
    
    @CheckReturnValue
    public Joiner skipNulls() {
        return new Joiner$2(this, this);
    }
    
    @CheckReturnValue
    public Joiner$MapJoiner withKeyValueSeparator(final String s) {
        return new Joiner$MapJoiner(this, s, null);
    }
    
    CharSequence toString(final Object o) {
        Preconditions.checkNotNull(o);
        return (o instanceof CharSequence) ? ((CharSequence)o) : o.toString();
    }
    
    private static Iterable iterable(final Object o, final Object o2, final Object[] array) {
        Preconditions.checkNotNull(array);
        return new Joiner$3(array, o, o2);
    }
}
