package com.google.common.base;

import javax.annotation.*;

@Deprecated
public final class Objects$ToStringHelper
{
    private final String className;
    private Objects$ToStringHelper$ValueHolder holderHead;
    private Objects$ToStringHelper$ValueHolder holderTail;
    private boolean omitNullValues;
    
    private Objects$ToStringHelper(final String s) {
        this.holderHead = new Objects$ToStringHelper$ValueHolder(null);
        this.holderTail = this.holderHead;
        this.omitNullValues = false;
        this.className = (String)Preconditions.checkNotNull(s);
    }
    
    public Objects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }
    
    public Objects$ToStringHelper add(final String s, @Nullable final Object o) {
        return this.addHolder(s, o);
    }
    
    public Objects$ToStringHelper add(final String s, final boolean b) {
        return this.addHolder(s, String.valueOf(b));
    }
    
    public Objects$ToStringHelper add(final String s, final char c) {
        return this.addHolder(s, String.valueOf(c));
    }
    
    public Objects$ToStringHelper add(final String s, final double n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public Objects$ToStringHelper add(final String s, final float n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public Objects$ToStringHelper add(final String s, final int n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public Objects$ToStringHelper add(final String s, final long n) {
        return this.addHolder(s, String.valueOf(n));
    }
    
    public Objects$ToStringHelper addValue(@Nullable final Object o) {
        return this.addHolder(o);
    }
    
    public Objects$ToStringHelper addValue(final boolean b) {
        return this.addHolder(String.valueOf(b));
    }
    
    public Objects$ToStringHelper addValue(final char c) {
        return this.addHolder(String.valueOf(c));
    }
    
    public Objects$ToStringHelper addValue(final double n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public Objects$ToStringHelper addValue(final float n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public Objects$ToStringHelper addValue(final int n) {
        return this.addHolder(String.valueOf(n));
    }
    
    public Objects$ToStringHelper addValue(final long n) {
        return this.addHolder(String.valueOf(n));
    }
    
    @Override
    public String toString() {
        final boolean omitNullValues = this.omitNullValues;
        String s = "";
        final StringBuilder append = new StringBuilder(32).append(this.className).append('{');
        for (Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder = this.holderHead.next; objects$ToStringHelper$ValueHolder != null; objects$ToStringHelper$ValueHolder = objects$ToStringHelper$ValueHolder.next) {
            if (!omitNullValues || objects$ToStringHelper$ValueHolder.value != null) {
                append.append(s);
                s = ", ";
                if (objects$ToStringHelper$ValueHolder.name != null) {
                    append.append(objects$ToStringHelper$ValueHolder.name).append('=');
                }
                append.append(objects$ToStringHelper$ValueHolder.value);
            }
        }
        return append.append('}').toString();
    }
    
    private Objects$ToStringHelper$ValueHolder addHolder() {
        final Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder = new Objects$ToStringHelper$ValueHolder(null);
        final Objects$ToStringHelper$ValueHolder holderTail = this.holderTail;
        final Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder2 = objects$ToStringHelper$ValueHolder;
        holderTail.next = objects$ToStringHelper$ValueHolder2;
        this.holderTail = objects$ToStringHelper$ValueHolder2;
        return objects$ToStringHelper$ValueHolder;
    }
    
    private Objects$ToStringHelper addHolder(@Nullable final Object value) {
        this.addHolder().value = value;
        return this;
    }
    
    private Objects$ToStringHelper addHolder(final String s, @Nullable final Object value) {
        final Objects$ToStringHelper$ValueHolder addHolder = this.addHolder();
        addHolder.value = value;
        addHolder.name = (String)Preconditions.checkNotNull(s);
        return this;
    }
}
