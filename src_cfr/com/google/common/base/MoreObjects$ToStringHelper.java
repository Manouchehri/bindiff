/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.MoreObjects$1;
import com.google.common.base.MoreObjects$ToStringHelper$ValueHolder;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class MoreObjects$ToStringHelper {
    private final String className;
    private MoreObjects$ToStringHelper$ValueHolder holderHead;
    private MoreObjects$ToStringHelper$ValueHolder holderTail;
    private boolean omitNullValues;

    private MoreObjects$ToStringHelper(String string) {
        this.holderTail = this.holderHead = new MoreObjects$ToStringHelper$ValueHolder(null);
        this.omitNullValues = false;
        this.className = (String)Preconditions.checkNotNull(string);
    }

    public MoreObjects$ToStringHelper omitNullValues() {
        this.omitNullValues = true;
        return this;
    }

    public MoreObjects$ToStringHelper add(String string, @Nullable Object object) {
        return this.addHolder(string, object);
    }

    public MoreObjects$ToStringHelper add(String string, boolean bl2) {
        return this.addHolder(string, String.valueOf(bl2));
    }

    public MoreObjects$ToStringHelper add(String string, char c2) {
        return this.addHolder(string, String.valueOf(c2));
    }

    public MoreObjects$ToStringHelper add(String string, double d2) {
        return this.addHolder(string, String.valueOf(d2));
    }

    public MoreObjects$ToStringHelper add(String string, float f2) {
        return this.addHolder(string, String.valueOf(f2));
    }

    public MoreObjects$ToStringHelper add(String string, int n2) {
        return this.addHolder(string, String.valueOf(n2));
    }

    public MoreObjects$ToStringHelper add(String string, long l2) {
        return this.addHolder(string, String.valueOf(l2));
    }

    public MoreObjects$ToStringHelper addValue(@Nullable Object object) {
        return this.addHolder(object);
    }

    public MoreObjects$ToStringHelper addValue(boolean bl2) {
        return this.addHolder(String.valueOf(bl2));
    }

    public MoreObjects$ToStringHelper addValue(char c2) {
        return this.addHolder(String.valueOf(c2));
    }

    public MoreObjects$ToStringHelper addValue(double d2) {
        return this.addHolder(String.valueOf(d2));
    }

    public MoreObjects$ToStringHelper addValue(float f2) {
        return this.addHolder(String.valueOf(f2));
    }

    public MoreObjects$ToStringHelper addValue(int n2) {
        return this.addHolder(String.valueOf(n2));
    }

    public MoreObjects$ToStringHelper addValue(long l2) {
        return this.addHolder(String.valueOf(l2));
    }

    @CheckReturnValue
    public String toString() {
        boolean bl2 = this.omitNullValues;
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(32).append(this.className).append('{');
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = this.holderHead.next;
        while (moreObjects$ToStringHelper$ValueHolder != null) {
            Object object = moreObjects$ToStringHelper$ValueHolder.value;
            if (!bl2 || object != null) {
                stringBuilder.append(string);
                string = ", ";
                if (moreObjects$ToStringHelper$ValueHolder.name != null) {
                    stringBuilder.append(moreObjects$ToStringHelper$ValueHolder.name).append('=');
                }
                if (object != null && object.getClass().isArray()) {
                    Object[] arrobject = new Object[]{object};
                    String string2 = Arrays.deepToString(arrobject);
                    stringBuilder.append(string2.substring(1, string2.length() - 1));
                } else {
                    stringBuilder.append(object);
                }
            }
            moreObjects$ToStringHelper$ValueHolder = moreObjects$ToStringHelper$ValueHolder.next;
        }
        return stringBuilder.append('}').toString();
    }

    private MoreObjects$ToStringHelper$ValueHolder addHolder() {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder;
        this.holderTail = this.holderTail.next = (moreObjects$ToStringHelper$ValueHolder = new MoreObjects$ToStringHelper$ValueHolder(null));
        return moreObjects$ToStringHelper$ValueHolder;
    }

    private MoreObjects$ToStringHelper addHolder(@Nullable Object object) {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = this.addHolder();
        moreObjects$ToStringHelper$ValueHolder.value = object;
        return this;
    }

    private MoreObjects$ToStringHelper addHolder(String string, @Nullable Object object) {
        MoreObjects$ToStringHelper$ValueHolder moreObjects$ToStringHelper$ValueHolder = this.addHolder();
        moreObjects$ToStringHelper$ValueHolder.value = object;
        moreObjects$ToStringHelper$ValueHolder.name = (String)Preconditions.checkNotNull(string);
        return this;
    }

    /* synthetic */ MoreObjects$ToStringHelper(String string, MoreObjects$1 moreObjects$1) {
        this(string);
    }
}

