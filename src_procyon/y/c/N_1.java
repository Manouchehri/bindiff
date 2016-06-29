package y.c;

final class N implements h
{
    int a;
    String b;
    boolean c;
    K d;
    static final Integer[] e;
    static final Integer[] f;
    
    N(final int a, final String b, final K d) {
        this.c = false;
        this.a = a;
        this.b = b;
        this.d = d;
    }
    
    public void a(final Object o, final Object o2) {
        try {
            if (((I)o).k.length > this.a) {
                ((I)o).k[this.a] = o2;
                if (!D.e) {
                    return;
                }
            }
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            this.a(o, o2);
        }
        catch (IndexOutOfBoundsException ex) {
            final I j = (I)o;
            this.d.a(j, j.k.length, this.d.a);
            this.a(o, o2);
        }
    }
    
    public Object b(final Object o) {
        try {
            if (((I)o).k.length > this.a) {
                return ((I)o).k[this.a];
            }
            return null;
        }
        catch (IndexOutOfBoundsException ex) {
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            return null;
        }
    }
    
    public void a(final Object o, final boolean b) {
        try {
            if (((I)o).k.length > this.a) {
                ((I)o).k[this.a] = (b ? Boolean.TRUE : Boolean.FALSE);
                if (!D.e) {
                    return;
                }
            }
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            this.a(o, b);
        }
        catch (IndexOutOfBoundsException ex) {
            final I j = (I)o;
            this.d.a(j, j.k.length, this.d.a);
            this.a(o, b);
        }
    }
    
    public boolean d(final Object o) {
        try {
            if (((I)o).k.length > this.a) {
                final Object o2 = ((I)o).k[this.a];
                return o2 != null && (boolean)o2;
            }
            return false;
        }
        catch (IndexOutOfBoundsException ex) {
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            return this.d(o);
        }
    }
    
    public void a(final Object o, final int n) {
        final boolean e = D.e;
        try {
            if (((I)o).k.length > this.a) {
                if (n >= 0) {
                    if (n < N.e.length) {
                        ((I)o).k[this.a] = N.e[n];
                        if (!e) {
                            return;
                        }
                    }
                    ((I)o).k[this.a] = new Integer(n);
                    if (!e) {
                        return;
                    }
                }
                if (n > -N.f.length) {
                    ((I)o).k[this.a] = N.f[-n];
                    if (!e) {
                        return;
                    }
                }
                ((I)o).k[this.a] = new Integer(n);
                if (!e) {
                    return;
                }
            }
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            this.a(o, n);
        }
        catch (IndexOutOfBoundsException ex) {
            final I j = (I)o;
            this.d.a(j, j.k.length, this.d.a);
            this.a(o, n);
        }
    }
    
    public int a(final Object o) {
        try {
            if (((I)o).k.length <= this.a) {
                return 0;
            }
            final Object o2 = ((I)o).k[this.a];
            if (o2 == null) {
                return 0;
            }
            return ((Number)o2).intValue();
        }
        catch (IndexOutOfBoundsException ex) {
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            return this.a(o);
        }
    }
    
    public void a(final Object o, final double n) {
        try {
            if (((I)o).k.length > this.a) {
                ((I)o).k[this.a] = new Double(n);
                if (!D.e) {
                    return;
                }
            }
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            this.a(o, n);
        }
        catch (IndexOutOfBoundsException ex) {
            final I j = (I)o;
            this.d.a(j, j.k.length, this.d.a);
            this.a(o, n);
        }
    }
    
    public double c(final Object o) {
        try {
            if (((I)o).k.length <= this.a) {
                return 0.0;
            }
            final Object o2 = ((I)o).k[this.a];
            if (o2 == null) {
                return 0.0;
            }
            return ((Number)o2).doubleValue();
        }
        catch (IndexOutOfBoundsException ex) {
            final I i = (I)o;
            this.d.a(i, i.k.length, this.d.a);
            return this.c(o);
        }
    }
    
    public String toString() {
        return this.getClass() + " : " + this.b + " : " + this.a;
    }
    
    public boolean a() {
        return this.c;
    }
    
    public void b() {
        this.c = true;
    }
    
    static {
        e = new Integer[127];
        f = new Integer[127];
        for (int i = N.e.length - 1; i >= 0; --i) {
            N.e[i] = new Integer(i);
        }
        for (int j = N.f.length - 1; j >= 0; --j) {
            N.f[j] = new Integer(-j);
        }
    }
}
