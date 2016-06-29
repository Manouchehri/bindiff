/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.f.X;

public class aG {
    private byte a;
    private byte b;
    private byte c;
    private double d;
    private byte e;
    private byte f;
    private byte g;
    private double h;
    private boolean i;
    private static final aG[] j = new aG[256];

    public aG() {
        this.a = 4;
        this.b = 8;
        this.c = 1;
        this.d = 0.0;
        this.e = 1;
        this.f = 1;
        this.g = 1;
        this.h = -1.0;
    }

    public aG(aG aG2) {
        this.a = aG2.a;
        this.b = aG2.b;
        this.c = aG2.c;
        this.d = aG2.d;
        this.e = aG2.e;
        this.f = aG2.f;
        this.g = aG2.g;
        this.h = aG2.h;
    }

    public byte a() {
        return this.a;
    }

    public void a(byte by2) {
        this.B();
        this.a = (byte)(by2 & 7);
    }

    public byte b() {
        return this.b;
    }

    public void b(byte by2) {
        this.B();
        this.b = (byte)(by2 & 56);
    }

    public byte c() {
        return this.c;
    }

    public void c(byte by2) {
        this.B();
        int n2 = by2 & 7;
        if (n2 == 0) {
            throw new IllegalArgumentException(Byte.toString(by2));
        }
        this.c = (byte)n2;
    }

    public double d() {
        return this.d;
    }

    public void a(double d2) {
        this.B();
        this.d = aG.b(d2);
    }

    private static double b(double d2) {
        return d2 - 6.283185307179586 * Math.floor(d2 / 6.283185307179586);
    }

    public byte e() {
        return this.e;
    }

    public void d(byte by2) {
        this.B();
        int n2 = by2 & 3;
        if (n2 == 0) {
            throw new IllegalArgumentException(Byte.toString(by2));
        }
        this.e = (byte)n2;
    }

    public byte f() {
        return this.f;
    }

    public void e(byte by2) {
        this.B();
        int n2 = by2 & 3;
        if (n2 == 0) {
            throw new IllegalArgumentException(Byte.toString(by2));
        }
        this.f = (byte)n2;
    }

    public byte g() {
        return this.g;
    }

    public void f(byte by2) {
        this.B();
        int n2 = by2 & 3;
        if (n2 == 0) {
            throw new IllegalArgumentException(Byte.toString(by2));
        }
        this.g = (byte)n2;
    }

    public double h() {
        return this.h;
    }

    private byte z() {
        byte by2 = this.a();
        if (by2 == 0) {
            return 7;
        }
        byte by3 = by2;
        return by3;
    }

    public boolean i() {
        if ((this.z() & 1) == 0) return false;
        return true;
    }

    public boolean j() {
        if ((this.z() & 4) == 0) return false;
        return true;
    }

    public boolean k() {
        if ((this.z() & 2) == 0) return false;
        return true;
    }

    private byte A() {
        byte by2 = this.b();
        if (by2 == 0) {
            return 56;
        }
        byte by3 = by2;
        return by3;
    }

    public boolean l() {
        if ((this.A() & 16) == 0) return false;
        return true;
    }

    public boolean m() {
        if ((this.A() & 8) == 0) return false;
        return true;
    }

    public boolean n() {
        if ((this.A() & 32) == 0) return false;
        return true;
    }

    public boolean o() {
        if ((this.e() & 1) == 0) return false;
        return true;
    }

    public boolean p() {
        if ((this.e() & 2) == 0) return false;
        return true;
    }

    public boolean q() {
        if ((this.f() & 1) == 0) return false;
        return true;
    }

    public boolean r() {
        if ((this.f() & 2) == 0) return false;
        return true;
    }

    public boolean s() {
        if ((this.g() & 1) == 0) return false;
        return true;
    }

    public boolean t() {
        if ((this.g() & 2) == 0) return false;
        return true;
    }

    public boolean u() {
        if ((this.c() & 1) == 0) return false;
        return true;
    }

    public boolean v() {
        if ((this.c() & 2) == 0) return false;
        return true;
    }

    public boolean w() {
        if ((this.c() & 4) == 0) return false;
        return true;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("placement=");
        this.a(stringBuffer, this.a());
        stringBuffer.append(", side=");
        this.b(stringBuffer, this.b());
        stringBuffer.append(", sideReference=");
        this.c(stringBuffer, this.c());
        stringBuffer.append(", angle=");
        stringBuffer.append(this.d());
        stringBuffer.append(", angleReference=");
        this.d(stringBuffer, this.e());
        stringBuffer.append(", angleRotation=");
        this.e(stringBuffer, this.f());
        stringBuffer.append(", angleOffset=");
        this.f(stringBuffer, this.g());
        stringBuffer.append(", distance=");
        stringBuffer.append(this.h());
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        aG aG2 = (aG)object;
        if (aG.a(aG2.d, this.d) != 0) {
            return false;
        }
        if (this.g != aG2.g) {
            return false;
        }
        if (this.e != aG2.e) {
            return false;
        }
        if (this.f != aG2.f) {
            return false;
        }
        if (aG.a(aG2.h, this.h) != 0) {
            return false;
        }
        if (this.a != aG2.a) {
            return false;
        }
        if (this.b != aG2.b) {
            return false;
        }
        if (this.c == aG2.c) return true;
        return false;
    }

    public int hashCode() {
        int n2 = this.a;
        n2 = 31 * n2 + this.b;
        n2 = 31 * n2 + this.c;
        long l2 = this.d != 0.0 ? Double.doubleToLongBits(this.d) : 0;
        n2 = 31 * n2 + (int)(l2 ^ l2 >>> 32);
        n2 = 31 * n2 + this.e;
        n2 = 31 * n2 + this.f;
        n2 = 31 * n2 + this.g;
        l2 = this.h != 0.0 ? Double.doubleToLongBits(this.h) : 0;
        return 31 * n2 + (int)(l2 ^ l2 >>> 32);
    }

    private void a(StringBuffer stringBuffer, byte by2) {
        if (by2 == 0) {
            stringBuffer.append("anywhere");
            if (!X.j) return;
        }
        if ((by2 & 1) != 0) {
            this.a(stringBuffer, "source");
        }
        if ((by2 & 4) != 0) {
            this.a(stringBuffer, "center");
        }
        if ((by2 & 2) == 0) return;
        this.a(stringBuffer, "target");
    }

    private void b(StringBuffer stringBuffer, byte by2) {
        if (by2 == 0) {
            stringBuffer.append("anywhere");
            if (!X.j) return;
        }
        if ((by2 & 16) != 0) {
            this.a(stringBuffer, "left");
        }
        if ((by2 & 8) != 0) {
            this.a(stringBuffer, "onEdge");
        }
        if ((by2 & 32) == 0) return;
        this.a(stringBuffer, "right");
    }

    private void c(StringBuffer stringBuffer, byte by2) {
        if ((by2 & 2) == 0) return;
        this.a(stringBuffer, "absolute_left_in_north");
    }

    private void d(StringBuffer stringBuffer, byte by2) {
        if ((by2 & 1) != 0) {
            this.a(stringBuffer, "absolute");
        }
        if ((by2 & 2) == 0) return;
        this.a(stringBuffer, "relative_to_edge_flow");
    }

    private void e(StringBuffer stringBuffer, byte by2) {
        if ((by2 & 1) != 0) {
            this.a(stringBuffer, "co");
        }
        if ((by2 & 2) == 0) return;
        this.a(stringBuffer, "counter");
    }

    private void f(StringBuffer stringBuffer, byte by2) {
        if ((by2 & 1) != 0) {
            this.a(stringBuffer, "0");
        }
        if ((by2 & 2) == 0) return;
        this.a(stringBuffer, "180");
    }

    private void a(StringBuffer stringBuffer, String string) {
        if (stringBuffer.length() != 0 && stringBuffer.charAt(stringBuffer.length() - 1) != '=') {
            stringBuffer.append('|');
        }
        stringBuffer.append(string);
    }

    public boolean x() {
        return this.i;
    }

    public void y() {
        this.i = true;
    }

    private void B() {
        if (!this.x()) return;
        throw new IllegalStateException("Immutable instance!");
    }

    static int a(double d2, double d3) {
        long l2;
        if (d2 > d3) {
            return 1;
        }
        if (d2 < d3) {
            return -1;
        }
        long l3 = Double.doubleToLongBits(d2);
        if (l3 == (l2 = Double.doubleToLongBits(d3))) {
            return 0;
        }
        if (l3 <= l2) return -1;
        return 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static aG g(byte by2) {
        aG[] arraG = j;
        synchronized (arraG) {
            int n2 = by2 & 255;
            aG aG2 = j[n2];
            if (aG2 != null) return aG2;
            aG.j[n2] = aG2 = aG.h(by2);
            return aG2;
        }
    }

    private static aG h(byte by2) {
        aG aG2 = new aG();
        aG2.a((byte)(by2 & 7));
        aG2.b((byte)(by2 & 56));
        aG2.y();
        return aG2;
    }
}

