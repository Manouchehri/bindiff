/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.f.f.b.h;

public class o {
    public static final o a = new o(0);
    public static final o b = new o(1);
    public static final o c = new o(2);
    public static final o d = new o(3);
    public static final o e = new o(1000);
    private static final String[] f = new String[]{"^", ">", "_", "<"};
    private static final char[] g = new char[]{'^', '>', '_', '<'};
    private int h;
    private static double i = 1.0E-4;

    o(int n2) {
        if (n2 != 1000) {
            while (n2 < 0) {
                n2 += 4;
            }
            while (n2 > 3) {
                n2 -= 4;
            }
        }
        this.h = n2;
    }

    public static o a(int n2) {
        block11 : {
            int n3 = h.a;
            if (n2 != 1000) {
                while (n2 < 0) {
                    n2 += 4;
                    if (n3 == 0) {
                        if (n3 == 0) continue;
                    }
                    break block11;
                }
                while (n2 > 3) {
                    n2 -= 4;
                    if (n3 != 0) return a;
                    if (n3 == 0) continue;
                }
            }
        }
        switch (n2) {
            case 0: {
                return a;
            }
            case 1: {
                return b;
            }
            case 2: {
                return c;
            }
            case 3: {
                return d;
            }
            case 1000: {
                return e;
            }
        }
        throw new RuntimeException(new StringBuffer().append("Invalid number in direction construction: ").append(n2).toString());
    }

    public static o a(char c2) {
        int n2 = h.a;
        int n3 = -1;
        switch (c2) {
            case '^': {
                n3 = 0;
                if (n2 == 0) return o.a(n3);
            }
            case '>': {
                n3 = 1;
                if (n2 == 0) return o.a(n3);
            }
            case '_': {
                n3 = 2;
                if (n2 == 0) return o.a(n3);
            }
            case '<': {
                n3 = 3;
                if (n2 == 0) return o.a(n3);
            }
            case '+': {
                n3 = 1000;
                if (n2 == 0) return o.a(n3);
            }
        }
        throw new RuntimeException(new StringBuffer().append("Direction Constructor: Invalid character: ").append(c2).toString());
    }

    public o a() {
        if (this == e) {
            return o.a(this.h);
        }
        int n2 = this.h + 1;
        if (n2 <= 3) return o.a(n2);
        n2 = 0;
        return o.a(n2);
    }

    public o b(int n2) {
        o o2;
        int n3 = h.a;
        if (this == e) {
            return o.a(this.h);
        }
        o o3 = this;
        for (int i2 = 0; i2 < n2; ++i2) {
            o2 = o3.a();
            if (n3 != 0) return o2;
            o3 = o2;
            if (n3 == 0) continue;
        }
        o2 = o3;
        return o2;
    }

    public o b() {
        if (this == e) {
            return o.a(this.h);
        }
        int n2 = this.h - 1;
        if (n2 >= 0) return o.a(n2);
        n2 = 3;
        return o.a(n2);
    }

    public o c() {
        if (this == e) {
            return e;
        }
        int n2 = this.h + 2;
        if (n2 <= 3) return o.a(n2);
        n2 -= 4;
        return o.a(n2);
    }

    public boolean d() {
        int n2 = this.f();
        if (n2 == 1) return true;
        if (n2 == 3) return true;
        return false;
    }

    public boolean e() {
        int n2 = this.f();
        if (n2 == 0) return true;
        if (n2 == 2) return true;
        return false;
    }

    public boolean a(o o2) {
        if (this == e) return false;
        if (o2 == e) {
            return false;
        }
        if (this.h != o2.f()) return false;
        return true;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.h;
    }

    public String toString() {
        if (this != e) return f[this.h];
        return "+";
    }
}

