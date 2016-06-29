/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import y.c.A;
import y.c.D;
import y.c.I;
import y.c.K;
import y.c.N;

final class J
implements A {
    int a;
    String b;
    boolean c = false;
    K d;
    static final Integer[] e = N.e;
    static final Integer[] f = N.f;

    J(int n2, String string, K k2) {
        this.a = n2;
        this.b = string;
        this.d = k2;
    }

    @Override
    public void a(Object object, Object object2) {
        try {
            if (((I)object).k.length > this.a) {
                ((I)object).k[this.a] = object2;
                if (!D.e) return;
            }
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            this.a(object, object2);
            return;
        }
        catch (IndexOutOfBoundsException var3_4) {
            I i3 = (I)object;
            this.d.a(i3, i3.k.length, this.d.a);
            this.a(object, object2);
        }
    }

    @Override
    public Object b(Object object) {
        try {
            if (((I)object).k.length <= this.a) return null;
            return ((I)object).k[this.a];
        }
        catch (IndexOutOfBoundsException var2_2) {
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            return null;
        }
    }

    @Override
    public void a(Object object, boolean bl2) {
        try {
            if (((I)object).k.length > this.a) {
                ((I)object).k[this.a] = bl2 ? Boolean.TRUE : Boolean.FALSE;
                if (!D.e) return;
            }
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            this.a(object, bl2);
            return;
        }
        catch (IndexOutOfBoundsException var3_4) {
            I i3 = (I)object;
            this.d.a(i3, i3.k.length, this.d.a);
            this.a(object, bl2);
        }
    }

    @Override
    public boolean d(Object object) {
        try {
            if (((I)object).k.length <= this.a) return false;
            Object object2 = ((I)object).k[this.a];
            if (object2 != null) return (Boolean)object2;
            return false;
        }
        catch (IndexOutOfBoundsException var2_3) {
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            return this.d(object);
        }
    }

    @Override
    public void a(Object object, int n2) {
        boolean bl2 = D.e;
        try {
            if (((I)object).k.length > this.a) {
                if (n2 >= 0) {
                    if (n2 < e.length) {
                        ((I)object).k[this.a] = e[n2];
                        if (!bl2) return;
                    }
                    ((I)object).k[this.a] = new Integer(n2);
                    if (!bl2) return;
                }
                if (n2 > - f.length) {
                    ((I)object).k[this.a] = f[- n2];
                    if (!bl2) return;
                }
                ((I)object).k[this.a] = new Integer(n2);
                if (!bl2) return;
            }
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            this.a(object, n2);
            return;
        }
        catch (IndexOutOfBoundsException var3_5) {
            I i3 = (I)object;
            this.d.a(i3, i3.k.length, this.d.a);
            this.a(object, n2);
        }
    }

    @Override
    public int a(Object object) {
        try {
            if (((I)object).k.length <= this.a) return 0;
            Object object2 = ((I)object).k[this.a];
            if (object2 != null) return ((Number)object2).intValue();
            return 0;
        }
        catch (IndexOutOfBoundsException var2_3) {
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            return this.a(object);
        }
    }

    @Override
    public void a(Object object, double d2) {
        try {
            if (((I)object).k.length > this.a) {
                ((I)object).k[this.a] = new Double(d2);
                if (!D.e) return;
            }
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            this.a(object, d2);
            return;
        }
        catch (IndexOutOfBoundsException var4_4) {
            I i3 = (I)object;
            this.d.a(i3, i3.k.length, this.d.a);
            this.a(object, d2);
        }
    }

    @Override
    public double c(Object object) {
        try {
            if (((I)object).k.length <= this.a) return 0.0;
            Object object2 = ((I)object).k[this.a];
            if (object2 != null) return ((Number)object2).doubleValue();
            return 0.0;
        }
        catch (IndexOutOfBoundsException var2_3) {
            I i2 = (I)object;
            this.d.a(i2, i2.k.length, this.d.a);
            return this.c(object);
        }
    }

    public String toString() {
        return new StringBuffer().append(this.getClass()).append(" : ").append(this.b).append(" : ").append(this.a).toString();
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        this.c = true;
    }
}

