/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.c.c;
import y.c.d;
import y.f.X;
import y.f.aF;

public class aE
implements aF {
    private static final aE e = new aE(0);
    private static final aE f = new aE(1);
    private static final aE g = new aE(2);
    private static final aE h = new aE(4);
    private static final aE i = new aE(8);
    private static final aE j = new aE(0, true);
    private static final aE k = new aE(4, true);
    private static final aE l = new aE(8, true);
    private static final aE m = new aE(1, true);
    private static final aE n = new aE(2, true);
    private byte o;
    private boolean p;

    public aE() {
        this(0);
    }

    public aE(byte by2) {
        this.o = by2;
    }

    public aE(byte by2, boolean bl2) {
        this(by2);
        this.p = bl2;
    }

    public boolean a() {
        return this.p;
    }

    public byte b() {
        return this.o;
    }

    public boolean c() {
        if (this.o != 1) return false;
        return true;
    }

    public boolean d() {
        if (this.o != 2) return false;
        return true;
    }

    public boolean e() {
        if (this.o != 4) return false;
        return true;
    }

    public boolean f() {
        if (this.o != 8) return false;
        return true;
    }

    public boolean g() {
        if (this.o != 0) return false;
        return true;
    }

    public static boolean a(X x2, d d2) {
        if (aE.b(x2, d2)) return true;
        if (aE.c(x2, d2)) return true;
        return false;
    }

    public static boolean b(X x2, d d2) {
        aE aE2 = aE.d(x2, d2);
        if (aE2 == null) return false;
        if (aE2.o != 0) return true;
        if (!aE2.p) return false;
        return true;
    }

    public static boolean c(X x2, d d2) {
        aE aE2 = aE.e(x2, d2);
        if (aE2 == null) return false;
        if (aE2.o != 0) return true;
        if (!aE2.p) return false;
        return true;
    }

    public static aE d(X x2, d d2) {
        c c2 = x2.c(aF.a);
        if (c2 != null) return (aE)c2.b(d2);
        return null;
    }

    public static aE e(X x2, d d2) {
        c c2 = x2.c(aF.b);
        if (c2 != null) return (aE)c2.b(d2);
        return null;
    }

    public static aE a(byte by2) {
        return aE.a(by2, false);
    }

    public int hashCode() {
        int n2;
        if (this.p) {
            n2 = 1024 + this.o;
            return n2;
        }
        n2 = this.o;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof aE)) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        aE aE2 = (aE)object;
        if (aE2.p != this.p) return false;
        if (aE2.o != this.o) return false;
        return true;
    }

    public static aE a(byte by2, boolean bl2) {
        if (bl2) {
            switch (by2) {
                case 0: {
                    return j;
                }
                case 1: {
                    return m;
                }
                case 2: {
                    return n;
                }
                case 4: {
                    return k;
                }
                case 8: {
                    return l;
                }
            }
            return null;
        }
        switch (by2) {
            case 0: {
                return e;
            }
            case 1: {
                return f;
            }
            case 2: {
                return g;
            }
            case 4: {
                return h;
            }
            case 8: {
                return i;
            }
        }
        return null;
    }

    public String toString() {
        if (this.o == 0) {
            if (!this.p) return "ANY_SIDE [-]";
            return "ANY_SIDE [strong] [-]";
        }
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
            }
        }
        if (!this.p) return string;
        return new StringBuffer().append(string).append(" [strong] ").toString();
    }
}

