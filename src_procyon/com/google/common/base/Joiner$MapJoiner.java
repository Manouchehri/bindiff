package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

public final class Joiner$MapJoiner
{
    private final Joiner joiner;
    private final String keyValueSeparator;
    
    private Joiner$MapJoiner(final Joiner joiner, final String s) {
        this.joiner = joiner;
        this.keyValueSeparator = (String)Preconditions.checkNotNull(s);
    }
    
    public Appendable appendTo(final Appendable appendable, final Map map) {
        return this.appendTo(appendable, map.entrySet());
    }
    
    public StringBuilder appendTo(final StringBuilder sb, final Map map) {
        return this.appendTo(sb, map.entrySet());
    }
    
    @CheckReturnValue
    public String join(final Map map) {
        return this.join(map.entrySet());
    }
    
    @Beta
    public Appendable appendTo(final Appendable appendable, final Iterable iterable) {
        return this.appendTo(appendable, iterable.iterator());
    }
    
    @Beta
    public Appendable appendTo(final Appendable appendable, final Iterator iterator) {
        Preconditions.checkNotNull(appendable);
        if (iterator.hasNext()) {
            final Map.Entry<Object, V> entry = iterator.next();
            appendable.append(this.joiner.toString(entry.getKey()));
            appendable.append(this.keyValueSeparator);
            appendable.append(this.joiner.toString(entry.getValue()));
            while (iterator.hasNext()) {
                appendable.append(this.joiner.separator);
                final Map.Entry<Object, V> entry2 = iterator.next();
                appendable.append(this.joiner.toString(entry2.getKey()));
                appendable.append(this.keyValueSeparator);
                appendable.append(this.joiner.toString(entry2.getValue()));
            }
        }
        return appendable;
    }
    
    @Beta
    public StringBuilder appendTo(final StringBuilder sb, final Iterable iterable) {
        return this.appendTo(sb, iterable.iterator());
    }
    
    @Beta
    public StringBuilder appendTo(final StringBuilder sb, final Iterator iterator) {
        try {
            this.appendTo((Appendable)sb, iterator);
        }
        catch (IOException ex) {
            throw new AssertionError((Object)ex);
        }
        return sb;
    }
    
    @CheckReturnValue
    @Beta
    public String join(final Iterable iterable) {
        return this.join(iterable.iterator());
    }
    
    @CheckReturnValue
    @Beta
    public String join(final Iterator iterator) {
        return this.appendTo(new StringBuilder(), iterator).toString();
    }
    
    @CheckReturnValue
    public Joiner$MapJoiner useForNull(final String s) {
        return new Joiner$MapJoiner(this.joiner.useForNull(s), this.keyValueSeparator);
    }
}
