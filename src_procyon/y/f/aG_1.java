package y.f;

public class aG
{
    private byte a;
    private byte b;
    private byte c;
    private double d;
    private byte e;
    private byte f;
    private byte g;
    private double h;
    private boolean i;
    private static final aG[] j;
    
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
    
    public aG(final aG ag) {
        this.a = ag.a;
        this.b = ag.b;
        this.c = ag.c;
        this.d = ag.d;
        this.e = ag.e;
        this.f = ag.f;
        this.g = ag.g;
        this.h = ag.h;
    }
    
    public byte a() {
        return this.a;
    }
    
    public void a(final byte b) {
        this.B();
        this.a = (byte)(b & 0x7);
    }
    
    public byte b() {
        return this.b;
    }
    
    public void b(final byte b) {
        this.B();
        this.b = (byte)(b & 0x38);
    }
    
    public byte c() {
        return this.c;
    }
    
    public void c(final byte b) {
        this.B();
        final byte b2 = (byte)(b & 0x7);
        if (b2 == 0) {
            throw new IllegalArgumentException(Byte.toString(b));
        }
        this.c = b2;
    }
    
    public double d() {
        return this.d;
    }
    
    public void a(final double n) {
        this.B();
        this.d = b(n);
    }
    
    private static double b(final double n) {
        return n - 6.283185307179586 * Math.floor(n / 6.283185307179586);
    }
    
    public byte e() {
        return this.e;
    }
    
    public void d(final byte b) {
        this.B();
        final byte b2 = (byte)(b & 0x3);
        if (b2 == 0) {
            throw new IllegalArgumentException(Byte.toString(b));
        }
        this.e = b2;
    }
    
    public byte f() {
        return this.f;
    }
    
    public void e(final byte b) {
        this.B();
        final byte b2 = (byte)(b & 0x3);
        if (b2 == 0) {
            throw new IllegalArgumentException(Byte.toString(b));
        }
        this.f = b2;
    }
    
    public byte g() {
        return this.g;
    }
    
    public void f(final byte b) {
        this.B();
        final byte b2 = (byte)(b & 0x3);
        if (b2 == 0) {
            throw new IllegalArgumentException(Byte.toString(b));
        }
        this.g = b2;
    }
    
    public double h() {
        return this.h;
    }
    
    private byte z() {
        final byte a = this.a();
        return (byte)((a == 0) ? 7 : a);
    }
    
    public boolean i() {
        return (this.z() & 0x1) != 0x0;
    }
    
    public boolean j() {
        return (this.z() & 0x4) != 0x0;
    }
    
    public boolean k() {
        return (this.z() & 0x2) != 0x0;
    }
    
    private byte A() {
        final byte b = this.b();
        return (byte)((b == 0) ? 56 : b);
    }
    
    public boolean l() {
        return (this.A() & 0x10) != 0x0;
    }
    
    public boolean m() {
        return (this.A() & 0x8) != 0x0;
    }
    
    public boolean n() {
        return (this.A() & 0x20) != 0x0;
    }
    
    public boolean o() {
        return (this.e() & 0x1) != 0x0;
    }
    
    public boolean p() {
        return (this.e() & 0x2) != 0x0;
    }
    
    public boolean q() {
        return (this.f() & 0x1) != 0x0;
    }
    
    public boolean r() {
        return (this.f() & 0x2) != 0x0;
    }
    
    public boolean s() {
        return (this.g() & 0x1) != 0x0;
    }
    
    public boolean t() {
        return (this.g() & 0x2) != 0x0;
    }
    
    public boolean u() {
        return (this.c() & 0x1) != 0x0;
    }
    
    public boolean v() {
        return (this.c() & 0x2) != 0x0;
    }
    
    public boolean w() {
        return (this.c() & 0x4) != 0x0;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("placement=");
        this.a(sb, this.a());
        sb.append(", side=");
        this.b(sb, this.b());
        sb.append(", sideReference=");
        this.c(sb, this.c());
        sb.append(", angle=");
        sb.append(this.d());
        sb.append(", angleReference=");
        this.d(sb, this.e());
        sb.append(", angleRotation=");
        this.e(sb, this.f());
        sb.append(", angleOffset=");
        this.f(sb, this.g());
        sb.append(", distance=");
        sb.append(this.h());
        return sb.toString();
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final aG ag = (aG)o;
        return a(ag.d, this.d) == 0 && this.g == ag.g && this.e == ag.e && this.f == ag.f && a(ag.h, this.h) == 0 && this.a == ag.a && this.b == ag.b && this.c == ag.c;
    }
    
    public int hashCode() {
        final byte b = (byte)(31 * (31 * this.a + this.b) + this.c);
        final long n = (this.d != 0.0) ? Double.doubleToLongBits(this.d) : 0L;
        final int n2 = 31 * (31 * (31 * (31 * b + (int)(n ^ n >>> 32)) + this.e) + this.f) + this.g;
        final long n3 = (this.h != 0.0) ? Double.doubleToLongBits(this.h) : 0L;
        return 31 * n2 + (int)(n3 ^ n3 >>> 32);
    }
    
    private void a(final StringBuffer sb, final byte b) {
        if (b == 0) {
            sb.append("anywhere");
            if (!X.j) {
                return;
            }
        }
        if ((b & 0x1) != 0x0) {
            this.a(sb, "source");
        }
        if ((b & 0x4) != 0x0) {
            this.a(sb, "center");
        }
        if ((b & 0x2) != 0x0) {
            this.a(sb, "target");
        }
    }
    
    private void b(final StringBuffer sb, final byte b) {
        if (b == 0) {
            sb.append("anywhere");
            if (!X.j) {
                return;
            }
        }
        if ((b & 0x10) != 0x0) {
            this.a(sb, "left");
        }
        if ((b & 0x8) != 0x0) {
            this.a(sb, "onEdge");
        }
        if ((b & 0x20) != 0x0) {
            this.a(sb, "right");
        }
    }
    
    private void c(final StringBuffer sb, final byte b) {
        if ((b & 0x2) != 0x0) {
            this.a(sb, "absolute_left_in_north");
        }
    }
    
    private void d(final StringBuffer sb, final byte b) {
        if ((b & 0x1) != 0x0) {
            this.a(sb, "absolute");
        }
        if ((b & 0x2) != 0x0) {
            this.a(sb, "relative_to_edge_flow");
        }
    }
    
    private void e(final StringBuffer sb, final byte b) {
        if ((b & 0x1) != 0x0) {
            this.a(sb, "co");
        }
        if ((b & 0x2) != 0x0) {
            this.a(sb, "counter");
        }
    }
    
    private void f(final StringBuffer sb, final byte b) {
        if ((b & 0x1) != 0x0) {
            this.a(sb, "0");
        }
        if ((b & 0x2) != 0x0) {
            this.a(sb, "180");
        }
    }
    
    private void a(final StringBuffer sb, final String s) {
        if (sb.length() != 0 && sb.charAt(sb.length() - 1) != '=') {
            sb.append('|');
        }
        sb.append(s);
    }
    
    public boolean x() {
        return this.i;
    }
    
    public void y() {
        this.i = true;
    }
    
    private void B() {
        if (this.x()) {
            throw new IllegalStateException("Immutable instance!");
        }
    }
    
    static int a(final double n, final double n2) {
        if (n > n2) {
            return 1;
        }
        if (n < n2) {
            return -1;
        }
        final long doubleToLongBits = Double.doubleToLongBits(n);
        final long doubleToLongBits2 = Double.doubleToLongBits(n2);
        return (doubleToLongBits == doubleToLongBits2) ? 0 : ((doubleToLongBits > doubleToLongBits2) ? 1 : -1);
    }
    
    public static aG g(final byte b) {
        synchronized (aG.j) {
            final int n = b & 0xFF;
            aG h = aG.j[n];
            if (h == null) {
                h = h(b);
                aG.j[n] = h;
            }
            return h;
        }
    }
    
    private static aG h(final byte b) {
        final aG ag = new aG();
        ag.a((byte)(b & 0x7));
        ag.b((byte)(b & 0x38));
        ag.y();
        return ag;
    }
    
    static {
        j = new aG[256];
    }
}
