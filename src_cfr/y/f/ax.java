/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.X;
import y.f.aE;

public class ax {
    private static final ax[] c = new ax[256];
    private static final ax[] d = new ax[256];
    private double e;
    private double f;
    private boolean g;
    private int h;
    private double i;
    public static final Object a = "y.layout.PortCandidate.SOURCE_PCLIST_DPKEY";
    public static final Object b = "y.layout.PortCandidate.TARGET_PCLIST_DPKEY";
    private static final byte[] j = new byte[]{0, 2, 1, 3, 4, 6, 5, 7, 8, 10, 9, 11, 12, 14, 13, 15};
    private static final byte[] k = new byte[]{0, 4, 8, 12, 2, 6, 10, 14, 1, 5, 9, 13, 3, 7, 11, 15};
    private static final byte[] l = new byte[]{0, 8, 4, 12, 1, 9, 5, 13, 2, 10, 6, 14, 3, 11, 7, 15};

    protected ax(double d2, double d3, boolean bl2, int n2, double d4) {
        this.e = d2;
        this.f = d3;
        this.g = bl2;
        this.h = n2 & 255;
        this.i = d4;
    }

    protected ax(int n2) {
        this(0.0, 0.0, false, n2, 0.0);
    }

    protected ax(int n2, double d2) {
        this(0.0, 0.0, false, n2, d2);
    }

    public boolean a(int n2) {
        if ((this.h & n2) == 0) return false;
        return true;
    }

    public int a() {
        return this.h;
    }

    public boolean b() {
        return this.g;
    }

    public double c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public static ax b(int n2) {
        return ax.a(n2, 0.0);
    }

    public static ax a(int n2, double d2) {
        int n3 = n2 & 255;
        if (d2 == 0.0) {
            ax ax2 = c[n3];
            if (ax2 != null) return ax2;
            ax.c[n3] = ax2 = new ax(n2);
            return ax2;
        }
        if (d2 != 1.0) return new ax(n2, d2);
        ax ax3 = d[n3];
        if (ax3 != null) return ax3;
        ax3 = new ax(n2);
        ax3.i = 1.0;
        ax.d[n3] = ax3;
        return ax3;
    }

    public static ax a(double d2, double d3, int n2) {
        return ax.a(d2, d3, n2, 0.0);
    }

    public static ax a(double d2, double d3, int n2, double d4) {
        return new ax(d2, d3, true, n2, d4);
    }

    public static ax a(aE aE2) {
        if (!aE2.g()) return ax.b(aE2.b());
        return ax.b(15);
    }

    public int hashCode() {
        int n2;
        if (this.g) {
            n2 = 4096;
            return n2 + this.h + (int)(Double.doubleToLongBits(this.i) + Double.doubleToLongBits(this.e) + Double.doubleToLongBits(this.f));
        }
        n2 = 0;
        return n2 + this.h + (int)(Double.doubleToLongBits(this.i) + Double.doubleToLongBits(this.e) + Double.doubleToLongBits(this.f));
    }

    public aE e() {
        byte by2;
        boolean bl2 = X.j;
        switch (this.h) {
            case 1: 
            case 2: 
            case 4: 
            case 8: {
                by2 = (byte)this.h;
                if (!bl2) return aE.a(by2, this.b());
            }
            case 16: {
                by2 = 2;
                if (!bl2) return aE.a(by2, this.b());
            }
            case 32: {
                by2 = 1;
                if (!bl2) return aE.a(by2, this.b());
            }
            case 64: {
                by2 = 4;
                if (!bl2) return aE.a(by2, this.b());
            }
            case 128: {
                by2 = 8;
                if (!bl2) return aE.a(by2, this.b());
            }
        }
        by2 = 0;
        return aE.a(by2, this.b());
    }

    public aE a(byte by2) {
        byte by3;
        boolean bl2 = X.j;
        switch (this.b(by2)) {
            case 1: 
            case 2: 
            case 4: 
            case 8: {
                by3 = (byte)this.h;
                if (!bl2) return aE.a(by3, this.b());
            }
            case 16: {
                by3 = 2;
                if (!bl2) return aE.a(by3, this.b());
            }
            case 32: {
                by3 = 1;
                if (!bl2) return aE.a(by3, this.b());
            }
            case 64: {
                by3 = 4;
                if (!bl2) return aE.a(by3, this.b());
            }
            case 128: {
                by3 = 8;
                if (!bl2) return aE.a(by3, this.b());
            }
        }
        by3 = 0;
        return aE.a(by3, this.b());
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ax)) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        ax ax2 = (ax)object;
        if (ax2.g != this.g) return false;
        if (ax2.e != this.e) return false;
        if (ax2.i != this.i) return false;
        if (ax2.f != this.f) return false;
        if (ax2.h != this.h) return false;
        return true;
    }

    public double f() {
        return this.i;
    }

    public int b(byte by2) {
        byte[] arrby;
        boolean bl2 = X.j;
        switch (by2) {
            default: {
                return this.a();
            }
            case 2: {
                arrby = j;
                if (!bl2) break;
            }
            case 1: {
                arrby = k;
                if (!bl2) break;
            }
            case 3: {
                arrby = l;
            }
        }
        int n2 = this.a();
        int n3 = n2 & 15;
        return (n2 &= -16) | arrby[n3];
    }

    public double a(byte by2, int n2) {
        switch (by2) {
            default: {
                if ((n2 & 1) == 0) return this.c();
                return - this.c();
            }
            case 2: {
                if ((n2 & 4) == 0) return - this.c();
                return this.c();
            }
            case 1: {
                if ((n2 & 8) == 0) return - this.d();
                return this.d();
            }
            case 3: 
        }
        if ((n2 & 2) == 0) return this.d();
        return - this.d();
    }

    public double b(byte by2, int n2) {
        switch (by2) {
            default: {
                return this.d();
            }
            case 2: {
                return - this.d();
            }
            case 1: {
                return this.c();
            }
            case 3: 
        }
        return - this.c();
    }

    public double c(byte by2) {
        switch (by2) {
            default: {
                return this.c();
            }
            case 2: {
                return this.c();
            }
            case 1: {
                return - this.d();
            }
            case 3: 
        }
        return this.d();
    }

    public double d(byte by2) {
        switch (by2) {
            default: {
                return this.d();
            }
            case 2: {
                return - this.d();
            }
            case 1: {
                return this.c();
            }
            case 3: 
        }
        return - this.c();
    }

    public String toString() {
        StringBuffer stringBuffer;
        block10 : {
            stringBuffer = new StringBuffer(50);
            stringBuffer.append("PortCandidate(");
            stringBuffer.append('(').append(this.e).append(':').append(this.f).append(')');
            if (this.g) {
                stringBuffer.append("[fixed]");
                if (!X.j) break block10;
            }
            stringBuffer.append("[free]");
        }
        if (this.a(1)) {
            stringBuffer.append(" NORTH");
        }
        if (this.a(4)) {
            stringBuffer.append(" EAST");
        }
        if (this.a(2)) {
            stringBuffer.append(" SOUTH");
        }
        if (this.a(8)) {
            stringBuffer.append(" WEST");
        }
        if (this.a(32)) {
            stringBuffer.append(" AGAINST_THE_FLOW");
        }
        if (this.a(16)) {
            stringBuffer.append(" WITH_THE_FLOW");
        }
        if (this.a(64)) {
            stringBuffer.append(" LEFT_IN_FLOW");
        }
        if (this.a(128)) {
            stringBuffer.append(" RIGHT_IN_FLOW");
        }
        stringBuffer.append(", cost=");
        stringBuffer.append(this.i);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

