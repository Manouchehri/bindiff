/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicDoubleArray
implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int n2) {
        this.longs = new AtomicLongArray(n2);
    }

    public AtomicDoubleArray(double[] arrd) {
        int n2 = arrd.length;
        long[] arrl = new long[n2];
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.longs = new AtomicLongArray(arrl);
                return;
            }
            arrl[n3] = Double.doubleToRawLongBits(arrd[n3]);
            ++n3;
        } while (true);
    }

    public final int length() {
        return this.longs.length();
    }

    public final double get(int n2) {
        return Double.longBitsToDouble(this.longs.get(n2));
    }

    public final void set(int n2, double d2) {
        long l2 = Double.doubleToRawLongBits(d2);
        this.longs.set(n2, l2);
    }

    public final void lazySet(int n2, double d2) {
        this.set(n2, d2);
    }

    public final double getAndSet(int n2, double d2) {
        long l2 = Double.doubleToRawLongBits(d2);
        return Double.longBitsToDouble(this.longs.getAndSet(n2, l2));
    }

    public final boolean compareAndSet(int n2, double d2, double d3) {
        return this.longs.compareAndSet(n2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final boolean weakCompareAndSet(int n2, double d2, double d3) {
        return this.longs.weakCompareAndSet(n2, Double.doubleToRawLongBits(d2), Double.doubleToRawLongBits(d3));
    }

    public final double getAndAdd(int n2, double d2) {
        long l2;
        double d3;
        long l3;
        double d4;
        while (!this.longs.compareAndSet(n2, l3 = this.longs.get(n2), l2 = Double.doubleToRawLongBits(d4 = (d3 = Double.longBitsToDouble(l3)) + d2))) {
        }
        return d3;
    }

    public double addAndGet(int n2, double d2) {
        long l2;
        double d3;
        long l3;
        double d4;
        while (!this.longs.compareAndSet(n2, l3 = this.longs.get(n2), l2 = Double.doubleToRawLongBits(d4 = (d3 = Double.longBitsToDouble(l3)) + d2))) {
        }
        return d4;
    }

    public String toString() {
        int n2 = this.length() - 1;
        if (n2 == -1) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(19 * (n2 + 1));
        stringBuilder.append('[');
        int n3 = 0;
        do {
            stringBuilder.append(Double.longBitsToDouble(this.longs.get(n3)));
            if (n3 == n2) {
                return stringBuilder.append(']').toString();
            }
            stringBuilder.append(',').append(' ');
            ++n3;
        } while (true);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n2 = this.length();
        objectOutputStream.writeInt(n2);
        int n3 = 0;
        while (n3 < n2) {
            objectOutputStream.writeDouble(this.get(n3));
            ++n3;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n2 = objectInputStream.readInt();
        this.longs = new AtomicLongArray(n2);
        int n3 = 0;
        while (n3 < n2) {
            this.set(n3, objectInputStream.readDouble());
            ++n3;
        }
    }
}

