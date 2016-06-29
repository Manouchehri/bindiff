package com.google.common.base;

import java.util.*;
import javax.annotation.*;

public final class MoreObjects$ToStringHelper
{
    private final String className;
    private MoreObjects$ToStringHelper$ValueHolder holderHead;
    private MoreObjects$ToStringHelper$ValueHolder holderTail;
    private boolean omitNullValues;
    
    private MoreObjects$ToStringHelper(final String s) {
        this.holderHead = new MoreObjects$ToStringHelper$ValueHolder(null);
        this.holderTail = this.holderHead;
        this.omitNullValues = false;
        this.className = (String)Preconditions.checkNotNull(s);
    }
    
    public MoreObjects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }
    
    public MoreObjects$ToStringHelper add(final String s, @Nullable final Object o) {
        return this.addHolder(s, o);
    }
    
    public MoreObjects$ToStringHelper add(final String s, final boolean b) {
        return this.addHolder(s, String.valueOf(b));
    }
    
    public MoreObjects$ToStringHelper add(final String s, final char c) {
        return this.addHolder(s, String.valueOf(c));
    }
    
    public MoreObjects$ToStringHelper add(final String s, final double n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper add(final String s, final float n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper add(final String s, final int n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper add(final String s, final long n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper addValue(@Nullable final Object o) {
        return this.addHolder(o);
    }
    
    public MoreObjects$ToStringHelper addValue(final boolean b) {
        return this.addHolder(String.valueOf(b));
    }
    
    public MoreObjects$ToStringHelper addValue(final char c) {
        return this.addHolder(String.valueOf(c));
    }
    
    public MoreObjects$ToStringHelper addValue(final double n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper addValue(final float n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper addValue(final int n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public MoreObjects$ToStringHelper addValue(final long n) {
        return this.addHolder(String.valueOf(n));
    }
    
    @CheckReturnValue
    @Override
    public String toString() {
        final boolean omitNullValues = this.omitNullValues;
        String s = "";
        final StringBuilder append = new StringBuilder(32).append(this.className).append('{');
        for (MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = this.holderHead.next; moreObjects$ToStringHelper$ValueHolder != null; moreObjects$ToStringHelper$ValueHolder = moreObjects$ToStringHelper$ValueHolder.next) {
            final Object value = moreObjects$ToStringHelper$ValueHolder.value;
            if (!omitNullValues || value != null) {
                append.append(s);
                s = ", ";
                if (moreObjects$ToStringHelper$ValueHolder.name != null) {
                    append.append(moreObjects$ToStringHelper$ValueHolder.name).append('=');
                }
                if (value != null && value.getClass().isArray()) {
                    final String deepToString = Arrays.deepToString(new Object[] { value });
                    append.append(deepToString.substring(1, deepToString.length() - 1));
                }
                else {
                    append.append(value);
                }
            }
        }
        return append.append('}').toString();
    }
    
    private MoreObjects$ToStringHelper$ValueHolder addHolder() {
        final MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = new MoreObjects$ToStringHelper$ValueHolder(null);
        final MoreObjects$ToStringHelper$ValueHolder holderTail = this.holderTail;
        final MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder2 = moreObjects$ToStringHelper$ValueHolder;
        holderTail.next = moreObjects$ToStringHelper$ValueHolder2;
        this.holderTail = moreObjects$ToStringHelper$ValueHolder2;
        return moreObjects$ToStringHelper$ValueHolder;
    }
    
    private MoreObjects$ToStringHelper addHolder(@Nullable final Object value) {
        this.addHolder().value = value;
        return this;
    }
    
    private MoreObjects$ToStringHelper addHolder(final String s, @Nullable final Object value) {
        final MoreObjects$ToStringHelper$ValueHolder addHolder = this.addHolder();
        addHolder.value = value;
        addHolder.name = (String)Preconditions.checkNotNull(s);
        return this;
    }
}
