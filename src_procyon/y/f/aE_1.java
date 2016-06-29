package y.f;

import y.c.*;

public class aE implements aF
{
    private static final aE e;
    private static final aE f;
    private static final aE g;
    private static final aE h;
    private static final aE i;
    private static final aE j;
    private static final aE k;
    private static final aE l;
    private static final aE m;
    private static final aE n;
    private byte o;
    private boolean p;
    
    public aE() {
        this((byte)0);
    }
    
    public aE(final byte o) {
        this.o = o;
    }
    
    public aE(final byte b, final boolean p2) {
        this(b);
        this.p = p2;
    }
    
    public boolean a() {
        return this.p;
    }
    
    public byte b() {
        return this.o;
    }
    
    public boolean c() {
        return this.o == 1;
    }
    
    public boolean d() {
        return this.o == 2;
    }
    
    public boolean e() {
        return this.o == 4;
    }
    
    public boolean f() {
        return this.o == 8;
    }
    
    public boolean g() {
        return this.o == 0;
    }
    
    public static boolean a(final X x, final d d) {
        return b(x, d) || c(x, d);
    }
    
    public static boolean b(final X x, final d d) {
        final aE d2 = d(x, d);
        return d2 != null && (d2.o != 0 || d2.p);
    }
    
    public static boolean c(final X x, final d d) {
        final aE e = e(x, d);
        return e != null && (e.o != 0 || e.p);
    }
    
    public static aE d(final X x, final d d) {
        final c c = x.c(aF.a);
        if (c == null) {
            return null;
        }
        return (aE)c.b(d);
    }
    
    public static aE e(final X x, final d d) {
        final c c = x.c(aF.b);
        if (c == null) {
            return null;
        }
        return (aE)c.b(d);
    }
    
    public static aE a(final byte b) {
        return a(b, false);
    }
    
    public int hashCode() {
        return this.p ? (1024 + this.o) : this.o;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof aE)) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final aE ae = (aE)o;
        return ae.p == this.p && ae.o == this.o;
    }
    
    public static aE a(final byte b, final boolean b2) {
        if (b2) {
            switch (b) {
                case 0: {
                    return aE.j;
                }
                case 1: {
                    return aE.m;
                }
                case 2: {
                    return aE.n;
                }
                case 4: {
                    return aE.k;
                }
                case 8: {
                    return aE.l;
                }
                default: {
                    return null;
                }
            }
        }
        else {
            switch (b) {
                case 0: {
                    return aE.e;
                }
                case 1: {
                    return aE.f;
                }
                case 2: {
                    return aE.g;
                }
                case 4: {
                    return aE.h;
                }
                case 8: {
                    return aE.i;
                }
                default: {
                    return null;
                }
            }
        }
    }
    
    public String toString() {
        if (this.o != 0) {
            String string = null;
            switch (this.o) {
                case 1: {
                    string = "NORTH";
                    break;
                }
                case 2: {
                    string = "SOUTH";
                    break;
                }
                case 4: {
                    string = "EAST";
                    break;
                }
                case 8: {
                    string = "WEST";
                    break;
                }
            }
            if (this.p) {
                string += " [strong] ";
            }
            return string;
        }
        if (this.p) {
            return "ANY_SIDE [strong] [-]";
        }
        return "ANY_SIDE [-]";
    }
    
    static {
        e = new aE((byte)0);
        f = new aE((byte)1);
        g = new aE((byte)2);
        h = new aE((byte)4);
        i = new aE((byte)8);
        j = new aE((byte)0, true);
        k = new aE((byte)4, true);
        l = new aE((byte)8, true);
        m = new aE((byte)1, true);
        n = new aE((byte)2, true);
    }
}
