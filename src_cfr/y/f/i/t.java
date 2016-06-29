/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

class T
implements Cloneable {
    final boolean a;
    final double b;
    double c;
    final double d;
    final double e;

    T(double d2, double d3, double d4, double d5, boolean bl2) {
        this.e = d5;
        this.b = d2;
        this.d = d4;
        this.c = d3;
        this.a = bl2;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException var1_1) {
            throw new InternalError();
        }
    }
}

