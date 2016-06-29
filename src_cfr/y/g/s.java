/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import y.c.A;
import y.c.i;
import y.c.q;

final class S
implements A {
    double[] a;
    int[] b;
    boolean[] c;
    Object[] d;

    S(double[] arrd, int[] arrn, boolean[] arrbl, Object[] arrobject) {
        this.a = arrd;
        this.b = arrn;
        this.c = arrbl;
        this.d = arrobject;
    }

    @Override
    public Object b(Object object) {
        try {
            return this.d[((q)object).d()];
        }
        catch (ClassCastException var2_2) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException var2_3) {
            if (object == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot get Object from this type of Map!");
            throw new IllegalArgumentException("Argument is not in graph");
        }
    }

    @Override
    public double c(Object object) {
        try {
            return this.a[((q)object).d()];
        }
        catch (ClassCastException var2_2) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException var2_3) {
            if (object == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot get double from this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot get double from this type of Map!");
            throw new IllegalArgumentException("Argument is not in graph");
        }
    }

    @Override
    public int a(Object object) {
        try {
            return this.b[((q)object).d()];
        }
        catch (ClassCastException var2_2) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException var2_3) {
            if (object == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot get int from this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot get int from this type of Map!");
            throw new IllegalArgumentException("Argument is not in graph");
        }
    }

    @Override
    public boolean d(Object object) {
        try {
            return this.c[((q)object).d()];
        }
        catch (ClassCastException var2_2) {
            throw new IllegalArgumentException("Argument must be of type Node.");
        }
        catch (NullPointerException var2_3) {
            if (object == null) {
                throw new IllegalArgumentException("Argument must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot get boolean from this type of Map!");
            throw new IllegalArgumentException("Argument is not in graph");
        }
    }

    @Override
    public void a(Object object, Object object2) {
        try {
            this.d[((q)object).d()] = object2;
            return;
        }
        catch (ClassCastException var3_3) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException var3_4) {
            if (object == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot set Object in this type of Map!");
            throw new IllegalArgumentException("Key is not in graph");
        }
    }

    @Override
    public void a(Object object, double d2) {
        try {
            this.a[((q)object).d()] = d2;
            return;
        }
        catch (ClassCastException var4_3) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException var4_4) {
            if (object == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot set double in this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot set double in this type of Map!");
            throw new IllegalArgumentException("Key is not in graph");
        }
    }

    @Override
    public void a(Object object, int n2) {
        try {
            this.b[((q)object).d()] = n2;
            return;
        }
        catch (ClassCastException var3_3) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException var3_4) {
            if (object == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot set int in this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot set int in this type of Map!");
            throw new IllegalArgumentException("Key is not in graph");
        }
    }

    @Override
    public void a(Object object, boolean bl2) {
        try {
            this.c[((q)object).d()] = bl2;
            return;
        }
        catch (ClassCastException var3_3) {
            throw new IllegalArgumentException("Key must be of type Node.");
        }
        catch (NullPointerException var3_4) {
            if (object == null) {
                throw new IllegalArgumentException("Key must be non-null.");
            }
            if (!(object instanceof q)) throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
            if (((q)object).e() != null) throw new UnsupportedOperationException("Cannot set boolean in this type of Map!");
            throw new IllegalArgumentException("Key is not in graph");
        }
    }
}

