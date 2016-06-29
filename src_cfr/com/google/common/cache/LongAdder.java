/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.LongAddable;
import com.google.common.cache.Striped64;
import com.google.common.cache.Striped64$Cell;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible(emulated=1)
final class LongAdder
extends Striped64
implements LongAddable,
Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override
    final long fn(long l2, long l3) {
        return l2 + l3;
    }

    @Override
    public void add(long l2) {
        Striped64$Cell striped64$Cell;
        int n2;
        Striped64$Cell[] arrstriped64$Cell = this.cells;
        if (arrstriped64$Cell == null) {
            long l3 = this.base;
            if (this.casBase(l3, l3 + l2)) return;
        }
        boolean bl2 = true;
        int[] arrn = (int[])threadHashCode.get();
        if (arrn != null && arrstriped64$Cell != null && (n2 = arrstriped64$Cell.length) >= 1 && (striped64$Cell = arrstriped64$Cell[n2 - 1 & arrn[0]]) != null) {
            long l4 = striped64$Cell.value;
            bl2 = striped64$Cell.cas(l4, l4 + l2);
            if (bl2) return;
        }
        this.retryUpdate(l2, arrn, bl2);
    }

    @Override
    public void increment() {
        this.add(1);
    }

    public void decrement() {
        this.add(-1);
    }

    @Override
    public long sum() {
        long l2 = this.base;
        Striped64$Cell[] arrstriped64$Cell = this.cells;
        if (arrstriped64$Cell == null) return l2;
        int n2 = arrstriped64$Cell.length;
        int n3 = 0;
        while (n3 < n2) {
            Striped64$Cell striped64$Cell = arrstriped64$Cell[n3];
            if (striped64$Cell != null) {
                l2 += striped64$Cell.value;
            }
            ++n3;
        }
        return l2;
    }

    public void reset() {
        this.internalReset(0);
    }

    public long sumThenReset() {
        long l2 = this.base;
        Striped64$Cell[] arrstriped64$Cell = this.cells;
        this.base = 0;
        if (arrstriped64$Cell == null) return l2;
        int n2 = arrstriped64$Cell.length;
        int n3 = 0;
        while (n3 < n2) {
            Striped64$Cell striped64$Cell = arrstriped64$Cell[n3];
            if (striped64$Cell != null) {
                l2 += striped64$Cell.value;
                striped64$Cell.value = 0;
            }
            ++n3;
        }
        return l2;
    }

    public String toString() {
        return Long.toString(this.sum());
    }

    @Override
    public long longValue() {
        return this.sum();
    }

    @Override
    public int intValue() {
        return (int)this.sum();
    }

    @Override
    public float floatValue() {
        return this.sum();
    }

    @Override
    public double doubleValue() {
        return this.sum();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.sum());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }
}

