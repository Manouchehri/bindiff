/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.D;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.f.X;
import y.f.aW;
import y.f.ae;
import y.f.ai;
import y.f.aj;
import y.f.ak;
import y.f.al;
import y.f.am;

public class A
implements al {
    static final Integer[] a = new Integer[]{new Integer(1), new Integer(2), new Integer(4), new Integer(8), new Integer(16), new Integer(32), new Integer(64), new Integer(128), new Integer(256), new Integer(512), new Integer(1024), new Integer(2048), new Integer(4096), new Integer(8192), new Integer(16384), new Integer(32768), new Integer(65536)};
    private static final Object b = new Integer(256);
    private static final Object c = new Integer(4);
    private static final Object d = new Integer(1);
    private static final Object e = new Integer(8);
    private double f;
    private final int g;

    public A() {
        this(130816, 4.0);
    }

    public A(int n2, double d2) {
        this.f = d2;
        this.g = n2;
    }

    public int a() {
        return this.g;
    }

    public double b() {
        return this.f;
    }

    public void a(double d2) {
        this.f = d2;
    }

    @Override
    public Object c() {
        if ((this.g & 256) != 0) {
            return b;
        }
        if ((this.g & 4) != 0) {
            return c;
        }
        if ((this.g & 1) != 0) {
            return d;
        }
        if ((this.g & 8) == 0) return b;
        return e;
    }

    public boolean a(Object object) {
        if (!(object instanceof Integer)) return false;
        int n2 = (Integer)object;
        if ((this.g & n2) == 0) return false;
        return true;
    }

    @Override
    public n a(q q2, am am2, Object object) {
        return this.a(q2, am2, (Integer)object);
    }

    @Override
    public D a(aj aj2, am am2) {
        boolean bl2 = X.j;
        D d2 = new D();
        y y2 = aj2.getBox();
        int n2 = 0;
        do {
            if (n2 >= a.length) return d2;
            int n3 = a[n2];
            if ((this.g & n3) != 0) {
                boolean bl3 = false;
                switch (n3) {
                    case 256: 
                    case 512: 
                    case 1024: 
                    case 2048: 
                    case 4096: 
                    case 8192: 
                    case 16384: 
                    case 32768: 
                    case 65536: {
                        bl3 = true;
                    }
                }
                n n4 = this.a((q)y2, am2, n3);
                d2.add(new ai(n4, a[n2], aj2, bl3));
            }
            ++n2;
        } while (!bl2);
        return d2;
    }

    protected n a(q q2, am am2, int n2) {
        boolean bl2 = X.j;
        double d2 = Double.NaN;
        double d3 = Double.NaN;
        switch (n2) {
            case 256: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
                d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 512: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
                d3 = am2.getY() + (am2.getHeight() - q2.b()) - this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 1024: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
                d3 = am2.getY() + this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 2048: {
                d2 = am2.getX() + this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 4096: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) - this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 8192: {
                d2 = am2.getX() + this.b();
                d3 = am2.getY() + this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 16384: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) - this.b();
                d3 = am2.getY() + this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 32768: {
                d2 = am2.getX() + this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) - this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 65536: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) - this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) - this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 1: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
                d3 = am2.getY() - q2.b() - this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 2: {
                d2 = am2.getX() - q2.a() - this.b();
                d3 = am2.getY() - q2.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 4: {
                d2 = am2.getX() + am2.getWidth() + this.b();
                d3 = am2.getY() - q2.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 8: {
                d2 = am2.getX() + am2.getWidth() + this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 16: {
                d2 = am2.getX() - q2.a() - this.b();
                d3 = am2.getY() + (am2.getHeight() - q2.b()) / 2.0;
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 32: {
                d2 = am2.getX() + (am2.getWidth() - q2.a()) / 2.0;
                d3 = am2.getY() + am2.getHeight() + this.b();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 64: {
                d2 = am2.getX() - q2.a() - this.b();
                d3 = am2.getY() + am2.getHeight();
                if (!bl2) return new n(new t(d2, d3 + q2.b()), q2);
            }
            case 128: {
                d2 = am2.getX() + am2.getWidth() + this.b();
                d3 = am2.getY() + am2.getHeight();
            }
        }
        return new n(new t(d2, d3 + q2.b()), q2);
    }

    @Override
    public Object a(n n2, am am2) {
        if (ae.a(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
        }
        ak ak2 = new ak();
        ak2.a(n2);
        D d2 = this.a(ak2, am2);
        if (d2.isEmpty()) {
            return this.c();
        }
        t t2 = n2.k();
        return aW.a(d2, t2).b();
    }
}

