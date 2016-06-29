package y.f;

public class ax
{
    private static final ax[] c;
    private static final ax[] d;
    private double e;
    private double f;
    private boolean g;
    private int h;
    private double i;
    public static final Object a;
    public static final Object b;
    private static final byte[] j;
    private static final byte[] k;
    private static final byte[] l;
    
    protected ax(final double e, final double f, final boolean g, final int n, final double i) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = (n & 0xFF);
        this.i = i;
    }
    
    protected ax(final int n) {
        this(0.0, 0.0, false, n, 0.0);
    }
    
    protected ax(final int n, final double n2) {
        this(0.0, 0.0, false, n, n2);
    }
    
    public boolean a(final int n) {
        return (this.h & n) != 0x0;
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
    
    public static ax b(final int n) {
        return a(n, 0.0);
    }
    
    public static ax a(final int n, final double n2) {
        final int n3 = n & 0xFF;
        if (n2 == 0.0) {
            ax ax = y.f.ax.c[n3];
            if (ax == null) {
                ax = new ax(n);
                y.f.ax.c[n3] = ax;
            }
            return ax;
        }
        if (n2 == 1.0) {
            ax ax2 = ax.d[n3];
            if (ax2 == null) {
                ax2 = new ax(n);
                ax2.i = 1.0;
                ax.d[n3] = ax2;
            }
            return ax2;
        }
        return new ax(n, n2);
    }
    
    public static ax a(final double n, final double n2, final int n3) {
        return a(n, n2, n3, 0.0);
    }
    
    public static ax a(final double n, final double n2, final int n3, final double n4) {
        return new ax(n, n2, true, n3, n4);
    }
    
    public static ax a(final aE ae) {
        if (ae.g()) {
            return b(15);
        }
        return b((int)ae.b());
    }
    
    public int hashCode() {
        return (this.g ? 4096 : 0) + this.h + (int)(Double.doubleToLongBits(this.i) + Double.doubleToLongBits(this.e) + Double.doubleToLongBits(this.f));
    }
    
    public aE e() {
        final boolean j = X.j;
        Label_0112: {
            switch (this.h) {
                case 1:
                case 2:
                case 4:
                case 8: {
                    final byte b = (byte)this.h;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b, this.b());
                }
                case 16: {
                    final byte b = 2;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b, this.b());
                }
                case 32: {
                    final byte b = 1;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b, this.b());
                }
                case 64: {
                    final byte b = 4;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b, this.b());
                }
                case 128: {
                    final byte b = 8;
                    if (j) {
                        break;
                    }
                    return aE.a(b, this.b());
                }
            }
        }
        final byte b = 0;
        return aE.a(b, this.b());
    }
    
    public aE a(final byte b) {
        final boolean j = X.j;
        Label_0112: {
            switch (this.b(b)) {
                case 1:
                case 2:
                case 4:
                case 8: {
                    final byte b2 = (byte)this.h;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b2, this.b());
                }
                case 16: {
                    final byte b2 = 2;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b2, this.b());
                }
                case 32: {
                    final byte b2 = 1;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b2, this.b());
                }
                case 64: {
                    final byte b2 = 4;
                    if (j) {
                        break Label_0112;
                    }
                    return aE.a(b2, this.b());
                }
                case 128: {
                    final byte b2 = 8;
                    if (j) {
                        break;
                    }
                    return aE.a(b2, this.b());
                }
            }
        }
        final byte b2 = 0;
        return aE.a(b2, this.b());
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ax)) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final ax ax = (ax)o;
        return ax.g == this.g && ax.e == this.e && ax.i == this.i && ax.f == this.f && ax.h == this.h;
    }
    
    public double f() {
        return this.i;
    }
    
    public int b(final byte b) {
        final boolean j = X.j;
        byte[] array = null;
        Label_0059: {
            switch (b) {
                default: {
                    return this.a();
                }
                case 2: {
                    array = ax.j;
                    if (j) {
                        break Label_0059;
                    }
                    break;
                }
                case 1: {
                    array = ax.k;
                    if (j) {
                        break Label_0059;
                    }
                    break;
                }
                case 3: {
                    array = ax.l;
                    break;
                }
            }
        }
        final int a = this.a();
        return (a & 0xFFFFFFF0) | array[a & 0xF];
    }
    
    public double a(final byte b, final int n) {
        switch (b) {
            default: {
                if ((n & 0x1) != 0x0) {
                    return -this.c();
                }
                return this.c();
            }
            case 2: {
                if ((n & 0x4) != 0x0) {
                    return this.c();
                }
                return -this.c();
            }
            case 1: {
                if ((n & 0x8) != 0x0) {
                    return this.d();
                }
                return -this.d();
            }
            case 3: {
                if ((n & 0x2) != 0x0) {
                    return -this.d();
                }
                return this.d();
            }
        }
    }
    
    public double b(final byte b, final int n) {
        switch (b) {
            default: {
                return this.d();
            }
            case 2: {
                return -this.d();
            }
            case 1: {
                return this.c();
            }
            case 3: {
                return -this.c();
            }
        }
    }
    
    public double c(final byte b) {
        switch (b) {
            default: {
                return this.c();
            }
            case 2: {
                return this.c();
            }
            case 1: {
                return -this.d();
            }
            case 3: {
                return this.d();
            }
        }
    }
    
    public double d(final byte b) {
        switch (b) {
            default: {
                return this.d();
            }
            case 2: {
                return -this.d();
            }
            case 1: {
                return this.c();
            }
            case 3: {
                return -this.c();
            }
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer(50);
        sb.append("PortCandidate(");
        sb.append('(').append(this.e).append(':').append(this.f).append(')');
        Label_0075: {
            if (this.g) {
                sb.append("[fixed]");
                if (!X.j) {
                    break Label_0075;
                }
            }
            sb.append("[free]");
        }
        if (this.a(1)) {
            sb.append(" NORTH");
        }
        if (this.a(4)) {
            sb.append(" EAST");
        }
        if (this.a(2)) {
            sb.append(" SOUTH");
        }
        if (this.a(8)) {
            sb.append(" WEST");
        }
        if (this.a(32)) {
            sb.append(" AGAINST_THE_FLOW");
        }
        if (this.a(16)) {
            sb.append(" WITH_THE_FLOW");
        }
        if (this.a(64)) {
            sb.append(" LEFT_IN_FLOW");
        }
        if (this.a(128)) {
            sb.append(" RIGHT_IN_FLOW");
        }
        sb.append(", cost=");
        sb.append(this.i);
        sb.append(')');
        return sb.toString();
    }
    
    static {
        c = new ax[256];
        d = new ax[256];
        a = "y.layout.PortCandidate.SOURCE_PCLIST_DPKEY";
        b = "y.layout.PortCandidate.TARGET_PCLIST_DPKEY";
        j = new byte[] { 0, 2, 1, 3, 4, 6, 5, 7, 8, 10, 9, 11, 12, 14, 13, 15 };
        k = new byte[] { 0, 4, 8, 12, 2, 6, 10, 14, 1, 5, 9, 13, 3, 7, 11, 15 };
        l = new byte[] { 0, 8, 4, 12, 1, 9, 5, 13, 2, 10, 6, 14, 3, 11, 7, 15 };
    }
}
