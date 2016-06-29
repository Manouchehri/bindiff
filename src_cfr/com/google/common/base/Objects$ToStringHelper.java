/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Objects$1;
import com.google.common.base.Objects$ToStringHelper$ValueHolder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@Deprecated
public final class Objects$ToStringHelper {
    private final String className;
    private Objects$ToStringHelper$ValueHolder holderHead;
    private Objects$ToStringHelper$ValueHolder holderTail;
    private boolean omitNullValues;

    private Objects$ToStringHelper(String string) {
        this.holderTail = this.holderHead = new Objects$ToStringHelper$ValueHolder(null);
        this.omitNullValues = false;
        this.className = (String)Preconditions.checkNotNull(string);
    }

    public Objects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }

    public Objects$ToStringHelper add(String string, @Nullable Object object) {
        return this.addHolder(string, object);
    }

    public Objects$ToStringHelper add(String string, boolean bl2) {
        return this.addHolder(string, String.valueOf(bl2));
    }

    public Objects$ToStringHelper add(String string, char c2) {
        return this.addHolder(string, String.valueOf(c2));
    }

    public Objects$ToStringHelper add(String string, double d2) {
        return this.addHolder(string, String.valueOf(d2));
    }

    public Objects$ToStringHelper add(String string, float f2) {
        return this.addHolder(string, String.valueOf(f2));
    }

    public Objects$ToStringHelper add(String string, int n2) {
        return this.addHolder(string, String.valueOf(n2));
    }

    public Objects$ToStringHelper add(String string, long l2) {
        return this.addHolder(string, String.valueOf(l2));
    }

    public Objects$ToStringHelper addValue(@Nullable Object object) {
        return this.addHolder(object);
    }

    public Objects$ToStringHelper addValue(boolean bl2) {
        return this.addHolder(String.valueOf(bl2));
    }

    public Objects$ToStringHelper addValue(char c2) {
        return this.addHolder(String.valueOf(c2));
    }

    public Objects$ToStringHelper addValue(double d2) {
        return this.addHolder(String.valueOf(d2));
    }

    public Objects$ToStringHelper addValue(float f2) {
        return this.addHolder(String.valueOf(f2));
    }

    public Objects$ToStringHelper addValue(int n2) {
        return this.addHolder(String.valueOf(n2));
    }

    public Objects$ToStringHelper addValue(long l2) {
        return this.addHolder(String.valueOf(l2));
    }

    public String toString() {
        boolean bl2 = this.omitNullValues;
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(32).append(this.className).append('{');
        Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder = this.holderHead.next;
        while (objects$ToStringHelper$ValueHolder != null) {
            if (!bl2 || objects$ToStringHelper$ValueHolder.value != null) {
                stringBuilder.append(string);
                string = ", ";
                if (objects$ToStringHelper$ValueHolder.name != null) {
                    stringBuilder.append(objects$ToStringHelper$ValueHolder.name).append('=');
                }
                stringBuilder.append(objects$ToStringHelper$ValueHolder.value);
            }
            objects$ToStringHelper$ValueHolder = objects$ToStringHelper$ValueHolder.next;
        }
        return stringBuilder.append('}').toString();
    }

    private Objects$ToStringHelper$ValueHolder addHolder() {
        Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder;
        this.holderTail = this.holderTail.next = (objects$ToStringHelper$ValueHolder = new Objects$ToStringHelper$ValueHolder(null));
        return objects$ToStringHelper$ValueHolder;
    }

    private Objects$ToStringHelper addHolder(@Nullable Object object) {
        Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder = this.addHolder();
        objects$ToStringHelper$ValueHolder.value = object;
        return this;
    }

    private Objects$ToStringHelper addHolder(String string, @Nullable Object object) {
        Objects$ToStringHelper$ValueHolder objects$ToStringHelper$ValueHolder = this.addHolder();
        objects$ToStringHelper$ValueHolder.value = object;
        objects$ToStringHelper$ValueHolder.name = (String)Preconditions.checkNotNull(string);
        return this;
    }

    /* synthetic */ Objects$ToStringHelper(String string, Objects$1 objects$1) {
        this(string);
    }
}

