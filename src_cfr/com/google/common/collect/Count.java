/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class Count
implements Serializable {
    private int value;

    Count(int n2) {
        this.value = n2;
    }

    public int get() {
        return this.value;
    }

    public int getAndAdd(int n2) {
        int n3 = this.value;
        this.value = n3 + n2;
        return n3;
    }

    public int addAndGet(int n2) {
        return this.value += n2;
    }

    public void set(int n2) {
        this.value = n2;
    }

    public int getAndSet(int n2) {
        int n3 = this.value;
        this.value = n2;
        return n3;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Count)) return false;
        if (((Count)object).value != this.value) return false;
        return true;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

