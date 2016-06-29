package y.f.c.a;

import y.f.*;
import y.f.c.*;
import y.c.*;
import y.a.*;
import y.d.*;
import java.util.*;

public class by implements aZ
{
    private z a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private aV g;
    private double h;
    private boolean i;
    private double j;
    private double k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    
    public by() {
        this.b = 800;
        this.c = 16000;
        this.d = 32000;
        this.e = 40;
        this.f = 16000;
        this.h = 0.5;
        this.j = 0.0;
        this.k = 0.0;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = Long.MAX_VALUE;
        this.p = 0;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = false;
    }
    
    public boolean a() {
        return this.q;
    }
    
    public boolean b() {
        return this.r;
    }
    
    public boolean c() {
        return this.t;
    }
    
    public long d() {
        return this.o;
    }
    
    public void a(final long o) {
        this.o = o;
    }
    
    public boolean e() {
        return this.i;
    }
    
    private static boolean a(final aV av, final q q) {
        return ((X)q.e()).p(q) == 0.0 && av.a(q).b() == 1;
    }
    
    private static boolean b(final aV av, final q q) {
        final byte b = av.a(q).b();
        return b == 12 || b == 13;
    }
    
    private void a(final aU au, final aV av, final h h, final int[] array) {
        final boolean x = N.x;
        au.b();
        int n = 1;
        do {
            int i = 0;
            int n2 = 0;
        Label_0020:
            while (i < n2) {
                int max = -1;
                int n3 = 0;
                int n4 = 0;
                p p4;
                p a = p4 = au.a(n).d().k();
                while (p4 != null) {
                    Object o = p4.c();
                    Label_0295: {
                        int n5;
                        while (true) {
                            final q q = (q)o;
                            q c = null;
                            boolean b = false;
                            i = q.b();
                            n2 = 1;
                            if (x) {
                                continue Label_0020;
                            }
                            if (i == n2) {
                                c = q.g().c();
                                if (a(av, c) && a(av, q)) {
                                    b = true;
                                }
                            }
                            if (n4 == au.a(n).d().size() - 1 || b) {
                                n5 = (b ? array[c.d()] : au.a(n - 1).d().size());
                                do {
                                    int j = 0;
                                    int n6 = 0;
                                Label_0188:
                                    while (j <= n6) {
                                        final d d = (d)(o = ((q)a.c()).g());
                                        if (x) {
                                            continue Label_0295;
                                        }
                                        d h2 = d;
                                        while (h2 != null) {
                                            final int n7 = j = array[h2.c().d()];
                                            n6 = max;
                                            if (x) {
                                                continue Label_0188;
                                            }
                                            if (j < n6 || n7 > n5) {
                                                h.a(h2, true);
                                            }
                                            h2 = h2.h();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        a = a.a();
                                        ++n3;
                                    }
                                    break;
                                } while (!x);
                                break;
                            }
                            break Label_0295;
                        }
                        max = Math.max(max, n5);
                    }
                    ++n4;
                    p4 = p4.a();
                    if (x) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x);
    }
    
    private void a(final aU au, final aV av, final h h) {
        final boolean x = N.x;
        final int b = au.b();
        int n = 1;
    Label_0016:
        while (true) {
            int i = 0;
            while (i < b) {
                final f f = new f();
                final x a = au.a(n).d().a();
                while (a.f()) {
                    f.a(a.e().k());
                    a.g();
                    if (x) {
                        continue Label_0016;
                    }
                    if (x) {
                        break;
                    }
                }
                final d[] e = f.e();
                int n2 = 0;
                do {
                    int j = 0;
                Label_0112:
                    while (j < e.length) {
                        final d d = e[n2];
                        i = n2 + 1;
                        if (x) {
                            continue Label_0016;
                        }
                        int k = i;
                        while (k < e.length) {
                            final d d2 = e[k];
                            j = (a(d, d2, av) ? 1 : 0);
                            if (x) {
                                continue Label_0112;
                            }
                            if (j != 0) {
                                h.a(d, true);
                                h.a(d2, true);
                            }
                            ++k;
                            if (x) {
                                break;
                            }
                        }
                        ++n2;
                    }
                    break;
                } while (!x);
                ++n;
                if (x) {
                    break;
                }
            }
            break;
        }
    }
    
    private void a(final aU au, final aV av, final h h, final h h2, final int[] array) {
        final boolean x = N.x;
        au.b();
        int n = 1;
        do {
            int i = 0;
            int n2 = 0;
        Label_0020:
            while (i < n2) {
                int max = -1;
                int n3 = 0;
                int n4 = 0;
                p p5;
                p a = p5 = au.a(n).d().k();
                while (p5 != null) {
                    Object o = p5.c();
                    Label_0306: {
                        int n5;
                        while (true) {
                            final q q = (q)o;
                            av.a(q);
                            q c = null;
                            boolean b = false;
                            i = q.b();
                            n2 = 1;
                            if (x) {
                                continue Label_0020;
                            }
                            if (i == n2) {
                                c = q.g().c();
                                if (b(av, q)) {
                                    b = true;
                                }
                            }
                            if (n4 == au.a(n).d().size() - 1 || b) {
                                n5 = (b ? array[c.d()] : au.a(n - 1).d().size());
                                do {
                                    int j = 0;
                                    int n6 = 0;
                                Label_0189:
                                    while (j <= n6) {
                                        final d d = (d)(o = ((q)a.c()).g());
                                        if (x) {
                                            continue Label_0306;
                                        }
                                        d h3 = d;
                                        while (h3 != null) {
                                            final int n7 = j = array[h3.c().d()];
                                            n6 = max;
                                            if (x) {
                                                continue Label_0189;
                                            }
                                            if (j < n6 || n7 > n5) {
                                                h.a(h3, true);
                                                h2.a(h3, true);
                                            }
                                            h3 = h3.h();
                                            if (x) {
                                                break;
                                            }
                                        }
                                        a = a.a();
                                        ++n3;
                                    }
                                    break;
                                } while (!x);
                                break;
                            }
                            break Label_0306;
                        }
                        max = Math.max(max, n5);
                    }
                    ++n4;
                    p5 = p5.a();
                    if (x) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x);
    }
    
    public void a(final X x, final aV av, final aU au) {
        final boolean x2 = N.x;
        if (this.m) {
            final x o = x.o();
            boolean a = false;
            Label_0075: {
                while (o.f()) {
                    a = this.a(x, av, o.e(), true);
                    if (x2 || (a && !x2)) {
                        break Label_0075;
                    }
                    o.g();
                    if (x2) {
                        goto Label_0073;
                    }
                }
                goto Label_0073;
            }
            if (a) {
                this.b(au, x, av);
                if (!x2) {
                    return;
                }
            }
            this.a(au, x, av);
            if (!x2) {
                return;
            }
        }
        this.a(au, x, av);
    }
    
    private void a(final aU au, final X x, final aV av) {
        final boolean x2 = N.x;
        double n = 0.0;
        int i = 0;
        while (i < au.b()) {
            final aQ a = au.a(i);
            final double max = Math.max(this.a(x, av, a), this.a(x, a.d()));
            this.a(x, av, i, a.d(), max, n);
            n += max;
            ++i;
            if (x2) {
                break;
            }
        }
    }
    
    private double a(final X x, final D d) {
        final boolean x2 = N.x;
        double n = 0.0;
        p p2 = d.k();
        double max = 0.0;
        while (p2 != null) {
            max = Math.max(n, x.q((q)p2.c()));
            if (x2) {
                return max;
            }
            n = max;
            p2 = p2.a();
            if (x2) {
                break;
            }
        }
        return max;
    }
    
    private void a(final X x, final aV av, final int n, final D d, final double n2, final double n3) {
        final boolean x2 = N.x;
        p p6 = d.k();
        while (p6 != null) {
            final q q = (q)p6.c();
            final double q2 = x.q((q)p6.c());
            x.a(q, x.j(q), n3 + this.a(x, av, q, n, n2) * (n2 - q2) + q2 * 0.5);
            p6 = p6.a();
            if (x2) {
                break;
            }
        }
    }
    
    private void a(final X x, final aV av, final int n, final q q, final D d, final double n2, final double n3) {
        final boolean x2 = N.x;
        double n4 = x.k(q);
        p p7 = d.k();
        while (p7 != null) {
            if (p7.c().equals(q)) {
                break;
            }
            p7 = p7.a();
            if (x2) {
                break;
            }
        }
        p p8 = d.k();
        while (p8 != null) {
            Object c = null;
            Label_0189: {
                Label_0184: {
                    if (p8 == p7) {
                        final p p9 = p8;
                        p7 = p7.a();
                        while (p7 != null) {
                            c = this;
                            if (x2) {
                                break Label_0189;
                            }
                            if (this.a(x, av, (q)p7.c(), true)) {
                                break;
                            }
                            p7 = p7.a();
                            if (x2) {
                                break;
                            }
                        }
                        if (p7 == null) {
                            n4 = x.k((q)p9.c());
                            if (!x2) {
                                break Label_0184;
                            }
                        }
                        n4 = 0.5 * (x.k((q)p7.c()) + x.k((q)p9.c()));
                    }
                }
                c = p8.c();
            }
            final q q2 = (q)c;
            Label_0306: {
                if (this.a(x, av, q2, true)) {
                    x.a(q2, x.j(q2), x.k(q2));
                    if (!x2) {
                        break Label_0306;
                    }
                }
                final double q3 = x.q((q)p8.c());
                final double a = this.a(x, av, q2, n, n2);
                double n5 = 0.0;
                Label_0285: {
                    if (q3 < 1.0) {
                        n5 = n4;
                        if (!x2) {
                            break Label_0285;
                        }
                    }
                    n5 = n3 + a * (n2 - q3);
                }
                x.a(q2, x.j(q2), n5 + q3 * 0.5);
            }
            p8 = p8.a();
            if (x2) {
                break;
            }
        }
    }
    
    private void b(final aU au, final X x, final aV av) {
        final boolean x2 = N.x;
        final q[] array = new q[au.b()];
        final double[] array2 = new double[au.b()];
        final double[] array3 = new double[au.b()];
        int n = -1;
        int n2 = 0;
    Label_0449:
        while (true) {
            do {
                int i = 0;
            Label_0044:
                while (i < au.b()) {
                    final aQ a = au.a(n2);
                    array3[n2] = Math.max(this.a(x, av, a), this.a(x, a.d()));
                    final int e;
                    final byte b = (byte)(e = a.e());
                    if (x2) {
                    Label_0517:
                        while (true) {
                            if (e > -1) {
                                int j = n + 1;
                                while (j < au.b()) {
                                    array2[j] = array2[j - 1] + array3[j - 1] + 20.0;
                                    ++j;
                                    if (x2) {
                                        break Label_0517;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            Label_0514: {
                                break Label_0514;
                                int j = 0;
                                while (j < au.b()) {
                                    final aQ a2 = au.a(j);
                                    Label_0606: {
                                        if (array[j] != null) {
                                            this.a(x, av, j, array[j], a2.d(), array3[j], array2[j]);
                                            if (!x2) {
                                                break Label_0606;
                                            }
                                        }
                                        this.a(x, av, j, a2.d(), array3[j], array2[j]);
                                    }
                                    ++j;
                                    if (x2) {
                                        break;
                                    }
                                }
                                return;
                            }
                            int j = 0;
                            continue Label_0517;
                        }
                    }
                    if (b == 0) {
                        double min = Double.MAX_VALUE;
                        double max = -1.7976931348623157E308;
                        final x a3 = a.d().a();
                        while (a3.f()) {
                            final q e2 = a3.e();
                            i = (this.a(x, av, e2, true) ? 1 : 0);
                            if (x2) {
                                continue Label_0044;
                            }
                            if (i != 0) {
                                if (array[n2] == null) {
                                    array[n2] = e2;
                                }
                                min = Math.min(min, x.n(e2));
                                max = Math.max(max, x.n(e2) + x.q(e2));
                            }
                            a3.g();
                            if (x2) {
                                break;
                            }
                        }
                        if (array[n2] != null) {
                            if (array3[n2] > max - min) {
                                final double n3 = (array3[n2] - (max - min)) * 0.5;
                                min -= n3;
                                array3[n2] = max + n3 - min;
                            }
                            else {
                                array3[n2] = max - min;
                            }
                            array2[n2] = min;
                            Label_0442: {
                                if (n2 > 0) {
                                    double n4 = 0.0;
                                    int k = n2 - 1;
                                    while (k > n) {
                                        n4 += array3[k];
                                        --k;
                                        if (x2) {
                                            break Label_0442;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    double n5 = 20.0;
                                    if (n > -1) {
                                        n5 = (array2[n2] - (array2[n] + array3[n]) - n4) / (n2 - n);
                                    }
                                    int l = n2 - 1;
                                    while (l > n) {
                                        array2[l] = array2[l + 1] - array3[l] - n5;
                                        --l;
                                        if (x2) {
                                            continue Label_0449;
                                        }
                                        if (x2) {
                                            break;
                                        }
                                    }
                                }
                            }
                            n = n2;
                        }
                    }
                    ++n2;
                }
                break;
            } while (!x2);
            int e = n;
            continue;
        }
    }
    
    protected boolean a(final X x, final aV av, final q q, final boolean b) {
        if (q == null) {
            return false;
        }
        final aX a = av.a(q);
        if (b) {
            return a != null && a.b() == 0 && (a.c().a() == 6 || a.c().a() == 4);
        }
        return a != null && a.b() == 0 && (a.c().a() == 5 || a.c().a() == 4);
    }
    
    protected double a(final X x, final aV av, final aQ aq) {
        final boolean x2 = N.x;
        double max = 0.0;
        boolean b = false;
        p p3 = aq.d().k();
        while (p3 != null) {
            final aY i = av.a((q)p3.c()).i();
            if (x2) {
                return this.j;
            }
            if (i != null) {
                b = true;
                max = Math.max(max, i.c());
            }
            p3 = p3.a();
            if (x2) {
                break;
            }
        }
        if (b) {
            return max;
        }
        return this.j;
    }
    
    protected double a(final X x, final aV av, final q q, final int n, final double n2) {
        final aY i = av.a(q).i();
        return (i != null) ? i.a() : this.h;
    }
    
    public void a(final X x, final aV g, final aU au, final z a) {
        final boolean x2 = N.x;
        final long currentTimeMillis = System.currentTimeMillis();
        this.g = g;
        this.a = a;
        final int[] array = new int[x.e()];
        final int[] array2 = new int[x.e()];
        int max = -1;
        boolean b = false;
        int n = 0;
    Label_0251_Outer:
        while (true) {
            while (true) {
                do {
                    int i = 0;
                    int n2;
                    p p4;
                    q q;
                    int d;
                    bK h;
                    int j;
                    boolean b2;
                    boolean b3;
                    c c;
                    c c2;
                    h b4;
                    h b5;
                    e p5;
                    d a2;
                    h h2 = null;
                    h h3;
                    i k;
                    h u;
                    h u2;
                    q[] array3;
                    q[] array4;
                    q d2;
                    q d3;
                    q d4;
                    int n3;
                    double[] array5;
                    double[] array6;
                    q[] array7;
                    double[] array8;
                    double[] array9;
                    int l;
                    int b6;
                    int n4;
                    p p6;
                    q q2;
                    bK h4;
                    int m;
                    int n5;
                    e p7;
                    d a3;
                    int d5;
                    int d6;
                    int n6 = 0;
                    boolean n7;
                    int n8;
                    int a4 = 0;
                    aQ a5;
                    p p8;
                    boolean a6 = false;
                    p p9;
                    q q3;
                    e p10;
                    int n9 = 0;
                    int n10;
                    d a7;
                    int n11;
                    HashMap<Object, Object> hashMap;
                    HashMap<Object, Object> hashMap2;
                    f f;
                    int n12;
                    A a8;
                    e p11;
                    d a9;
                    int d7 = 0;
                    int n13;
                    x o;
                    q e;
                    int n14;
                    int b7;
                    int b8 = 0;
                    aQ a10 = null;
                    double max2;
                    double min;
                    q q4;
                    q q5;
                    aX ax;
                    q q6;
                    q q7;
                    q q8;
                    aX ax2;
                    q q9;
                    q q10;
                    q q11;
                    q q12 = null;
                    q q13 = null;
                    HashMap<Object, q> hashMap3;
                    q q14;
                    q q15;
                    q q16;
                    q q17;
                    ArrayList<q> list;
                    ArrayList<q> list2;
                    HashMap<d, bG> hashMap4;
                    x a11;
                    q e2;
                    aX a12;
                    byte b10;
                    byte b9;
                    int n15;
                    d g2;
                    bG bg;
                    y y = null;
                    p p12;
                    q q18;
                    int d8;
                    aX a13;
                    aX a14;
                    q d9;
                    q q19 = null;
                    q d10;
                    double n16;
                    double n17;
                    d d11;
                    d d12;
                    p d13;
                    p a15;
                    d d14;
                    q c3 = null;
                    q q20 = null;
                    double n18 = 0.0;
                    y.f.c.a.A a16;
                    p d15;
                    int j2 = 0;
                    double n19 = 0.0;
                    d d16;
                    p p13 = null;
                    d d17;
                    d d18 = null;
                    q q22;
                    q q21 = null;
                    q q24;
                    q q23 = null;
                    double n20 = 0.0;
                    y.f.c.a.A a17;
                    q q25;
                    double n21 = 0.0;
                    y.f.c.a.A a18;
                    q q26;
                    int n22;
                    int n23;
                    q f2;
                    boolean j3 = false;
                    q f3;
                    q q27;
                    q q28;
                    d g3;
                    bG bg2;
                    q a19;
                    q b11;
                    q q29;
                    q q30;
                    p p14;
                    d d19;
                    boolean containsKey;
                    q a20;
                    q q31;
                    q q32;
                    q a21;
                    x a22;
                    q e3;
                    aX a23;
                    q f4;
                    d g4;
                    int d20;
                    q a24;
                    aX a25;
                    aX a26;
                    q q33;
                    q q34;
                    int[] array10;
                    bz bz;
                    x o2;
                    q q35 = null;
                    boolean b12;
                    int n24;
                    d d21;
                    int b13;
                    q q36;
                    q q37;
                    int e4;
                    boolean a27;
                    boolean a28;
                    bA ba;
                    x o3;
                    q q38 = null;
                    int n25;
                    d d22;
                    q q39;
                    q q40;
                    int b14;
                    int[] array11;
                    int n26;
                    e e5;
                    d a29;
                    int b15;
                    double n28;
                    double n27;
                    boolean d23;
                    d a30;
                    int d24;
                    int d25;
                    int[] array12;
                    int b16;
                    h b17;
                    int n29;
                    int n30 = 0;
                    f f5;
                    p p15;
                    q q41;
                    d d26;
                    int b18;
                    int n31;
                    q q42;
                    q q43;
                    q d27;
                    d a31;
                    d a32;
                    double n32;
                    double n33;
                    int n34;
                    e a33;
                    d a34;
                    aX a35;
                    aX a36;
                    byte b20;
                    byte b19;
                    boolean b21;
                    boolean b22;
                    int n35;
                    e j4;
                    d a37;
                    int n36;
                    int d28;
                    x o4;
                    q e6;
                    int n37 = 0;
                    boolean b23;
                    q q44;
                    q d29;
                    d a38;
                    d a39;
                    double n38;
                    double n39;
                    int n40;
                    int max3 = 0;
                    e p16;
                    d a40;
                    int n41;
                    int n42 = 0;
                    int n43 = 0;
                    e a41;
                    e a42;
                    e p17;
                    int n44;
                    e p18;
                    d a43;
                    int a44 = 0;
                    int n45;
                    boolean i2;
                    int[] array13;
                    int[] array14;
                    e p19;
                    int n46;
                    q q46;
                    q q45;
                    d g5;
                    d h5;
                    int a45;
                    int min2;
                    int min3;
                    d d30;
                    int d31;
                    int a46;
                    double n47;
                    x o5;
                    q e7;
                    int d32;
                    int n48;
                    int d33;
                    int n49;
                    double[] array15;
                    int length;
                    int length2;
                    int[] array16;
                    double n50;
                    int n51 = 0;
                    int min4;
                    d d34;
                    x o6;
                    q e8;
                    int n52;
                    int n53;
                    double[] array17;
                    int length3;
                    int length4;
                    D d35;
                    x o7;
                    q e9;
                    C m2;
                    bI bi;
                    int n54;
                    int n55;
                    p p20;
                    q q47;
                    bK h6;
                    int j5;
                    double n56;
                    d b24;
                    q q48 = null;
                    q q49 = null;
                    aX a47;
                    aX a48;
                    Label_0744_Outer:Label_6750_Outer:Label_6847_Outer:
                    while (i < au.b()) {
                        n2 = 0;
                        if (!x2) {
                            p4 = au.a(n).d().k();
                            while (p4 != null) {
                                q = (q)p4.c();
                                i = (this.a(x, g, q, false) ? 1 : 0);
                                if (x2) {
                                    continue Label_0744_Outer;
                                }
                                if (i != 0) {
                                    b = true;
                                }
                                d = q.d();
                                array[d] = n2++;
                                h = this.g.a(q).h();
                                Label_0206: {
                                    if (h != null) {
                                        j = h.j();
                                        array2[d] = j;
                                        max = Math.max(max, j);
                                        if (!x2) {
                                            break Label_0206;
                                        }
                                        y.c.i.g = !y.c.i.g;
                                    }
                                    array2[d] = -1;
                                }
                                p4 = p4.a();
                                if (x2) {
                                    break;
                                }
                            }
                            ++n;
                        }
                        else {
                            b2 = false;
                            b3 = b2;
                            c = x.c(M.n);
                            c2 = x.c("y.layout.hierarchic.incremental.SimlexNodePlacer.NODE_TO_ALIGN_WITH");
                            b4 = y.g.M.b(new boolean[x.g()]);
                            Label_0413: {
                                Label_0410: {
                                    Label_0382: {
                                        if (c != null || c2 != null) {
                                            b5 = y.g.M.b(new boolean[x.g()]);
                                            this.a(x, au, g, b5, c2);
                                            p5 = x.p();
                                            while (p5.f()) {
                                                a2 = p5.a();
                                                h2 = b4;
                                                if (x2) {
                                                    break Label_0413;
                                                }
                                                h2.a(a2, !b5.d(a2));
                                                p5.g();
                                                if (x2) {
                                                    break Label_0382;
                                                }
                                            }
                                            break Label_0410;
                                        }
                                    }
                                    if (b3) {
                                        this.a(au, g, b4);
                                        if (!x2) {
                                            break Label_0410;
                                        }
                                    }
                                    this.a(au, g, b4, array);
                                }
                                y.g.M.b();
                            }
                            h3 = h2;
                            this.a(au, g, b4, h3, array);
                            k = new i();
                            u = k.u();
                            u2 = k.u();
                            array3 = new q[x.g()];
                            array4 = new q[x.e()];
                            d2 = k.d();
                            d3 = k.d();
                            d4 = null;
                            n3 = max + 1;
                            array5 = null;
                            array6 = null;
                            array7 = null;
                            Label_1063: {
                                Label_1059: {
                                    if (n3 > 0) {
                                        array7 = new q[n3 - 1];
                                        array5 = new double[n3];
                                        array6 = new double[n3];
                                        array8 = new double[n3];
                                        array9 = new double[n3];
                                        l = 0;
                                        b6 = au.b();
                                    Label_0549:
                                        while (true) {
                                        Label_0741:
                                            while (l < b6) {
                                                n4 = 0;
                                                if (!x2) {
                                                    p6 = au.a(l).d().k();
                                                    while (true) {
                                                        while (p6 != null) {
                                                            q2 = (q)p6.c();
                                                            array[q2.d()] = n4++;
                                                            h4 = this.g.a(q2).h();
                                                            if (!x2) {
                                                                if (h4 != null) {
                                                                    m = h4.j();
                                                                    array5[m] = Math.max(array5[m], h4.f());
                                                                    array6[m] = Math.max(array6[m], h4.g());
                                                                    array9[m] = Math.max(array9[m], h4.e());
                                                                    array8[m] = Math.max(array8[m], h4.c());
                                                                }
                                                                p6 = p6.a();
                                                                if (x2) {
                                                                    break;
                                                                }
                                                                continue Label_0251_Outer;
                                                            }
                                                            else {
                                                                if (x2) {
                                                                    break Label_0741;
                                                                }
                                                                continue Label_0549;
                                                            }
                                                        }
                                                        ++l;
                                                        continue Label_0744_Outer;
                                                    }
                                                }
                                                while (true) {
                                                    while (l < n3 - 1) {
                                                        array7[l] = k.d();
                                                        n5 = l;
                                                        if (!x2) {
                                                            if (n5 > 0) {
                                                                this.a(array7[l - 1], array7[l], array9[l], this.f * array8[l], k, u, u2);
                                                            }
                                                            ++l;
                                                            if (x2) {
                                                                break;
                                                            }
                                                            continue Label_0251_Outer;
                                                        }
                                                        else {
                                                            Label_0950: {
                                                                if (n5 > 1) {
                                                                    this.a(d2, array7[0], array9[0] - array5[0], this.f * array8[0], k, u, u2);
                                                                    this.a(array7[n3 - 2], d3, array9[n3 - 1] - array6[n3 - 1], this.f * array8[n3 - 1], k, u, u2);
                                                                    if (!x2) {
                                                                        break Label_0950;
                                                                    }
                                                                }
                                                                this.a(d2, d3, array9[0] - array5[0] - array6[0], this.f * array8[0], k, u, u2);
                                                            }
                                                            if (array7 != null) {
                                                                p7 = x.p();
                                                                while (p7.f()) {
                                                                    a3 = p7.a();
                                                                    d5 = a3.c().d();
                                                                    d6 = a3.d().d();
                                                                    n6 = array2[d5];
                                                                    if (x2) {
                                                                        break Label_1063;
                                                                    }
                                                                    if (n6 != array2[d6] || array2[d5] == -1) {
                                                                        b4.a(a3, true);
                                                                        h3.a(a3, true);
                                                                    }
                                                                    p7.g();
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            break Label_1059;
                                                        }
                                                    }
                                                    continue Label_6750_Outer;
                                                }
                                            }
                                            l = 0;
                                            continue Label_6750_Outer;
                                        }
                                    }
                                }
                                n7 = this.n;
                            }
                            Label_1358: {
                                Label_1357: {
                                    Label_1344: {
                                        if (n6 != 0 && b) {
                                            n8 = 0;
                                            do {
                                            Label_1076:
                                                while (a4 < au.b()) {
                                                    a5 = au.a(n8);
                                                    if (x2) {
                                                        break Label_1344;
                                                    }
                                                    p8 = a5.d().k();
                                                    Label_1169: {
                                                        while (p8 != null) {
                                                            a6 = this.a(x, g, (q)p8.c(), false);
                                                            if (x2 || (a6 && !x2)) {
                                                                break Label_1169;
                                                            }
                                                            p8 = p8.a();
                                                            if (x2) {
                                                                goto Label_1167;
                                                            }
                                                        }
                                                        goto Label_1167;
                                                    }
                                                    if (a6) {
                                                        p9 = a5.d().k();
                                                        while (p9 != null) {
                                                            q3 = (q)p9.c();
                                                            a4 = (a(g, q3) ? 1 : 0);
                                                            if (x2) {
                                                                continue Label_1076;
                                                            }
                                                            if (a4 != 0) {
                                                                b4.a(q3.g(), true);
                                                                b4.a(q3.f(), true);
                                                                h3.a(q3.g(), true);
                                                                h3.a(q3.f(), true);
                                                            }
                                                            p9 = p9.a();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    ++n8;
                                                }
                                                break;
                                            } while (!x2);
                                        }
                                        if (this.f()) {
                                            p10 = x.p();
                                            while (p10.f()) {
                                                b4.a(p10.a(), true);
                                                p10.g();
                                                if (x2) {
                                                    break Label_1357;
                                                }
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (this.b()) {
                                        n9 = 100000000;
                                        break Label_1358;
                                    }
                                }
                                n9 = 1;
                            }
                            n10 = n9;
                            Label_1424: {
                                if (!this.i) {
                                    u.a(k.a(d2, d3), n10);
                                    if (!x2) {
                                        break Label_1424;
                                    }
                                }
                                a7 = k.a(d2, d3);
                                if (n3 != 0) {
                                    u.a(a7, n10);
                                }
                            }
                            n11 = ((n3 == 0) ? this.c : this.b);
                            hashMap = new HashMap<Object, Object>();
                            hashMap2 = new HashMap<Object, Object>();
                            f = new f();
                            n12 = 0;
                            a8 = null;
                            Label_1656: {
                                Label_1655: {
                                    if (c != null || c2 != null) {
                                        a8 = y.g.M.a();
                                        p11 = x.p();
                                        while (p11.f()) {
                                            a9 = p11.a();
                                            n13 = (d7 = (b4.d(a9) ? 1 : 0));
                                            if (x2) {
                                                break Label_1656;
                                            }
                                            if (n13 == 0) {
                                                a8.a(a9.d(), a9.c());
                                                this.a(a9, x, g, 0.5, true);
                                            }
                                            p11.g();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        if (c2 != null) {
                                            o = x.o();
                                            while (o.f()) {
                                                e = o.e();
                                                if (x2) {
                                                    break Label_1655;
                                                }
                                                if (c2.b(e) != null) {
                                                    a8.a(e, c2.b(e));
                                                }
                                                o.g();
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    this.a(au);
                                }
                                d7 = 0;
                            }
                            n14 = d7;
                            Label_5965:Label_5878_Outer:Label_5957_Outer:
                            do {
                            Label_5615:
                                while (true) {
                                    b7 = au.b();
                                Label_1666:
                                    while (b8 < b7) {
                                        a10 = au.a(n14);
                                        max2 = -1.7976931348623157E308;
                                        min = Double.MAX_VALUE;
                                        q4 = null;
                                        q5 = null;
                                        ax = null;
                                        q6 = null;
                                        q7 = null;
                                        q8 = null;
                                        ax2 = null;
                                        q9 = null;
                                        q10 = null;
                                        q11 = null;
                                        q12 = null;
                                        q13 = null;
                                        hashMap3 = new HashMap<Object, q>();
                                        q14 = null;
                                        q15 = null;
                                        q16 = null;
                                        q17 = null;
                                        list = new ArrayList<q>(16);
                                        list2 = new ArrayList<q>(16);
                                        hashMap4 = new HashMap<d, bG>();
                                        a11 = a10.d().a();
                                        while (a11.f()) {
                                            e2 = a11.e();
                                            a12 = this.g.a(e2);
                                            b9 = (b10 = a12.b());
                                            n15 = (b7 = 3);
                                            if (x2) {
                                                continue Label_1666;
                                            }
                                            Label_1998: {
                                                if (b9 == n15) {
                                                    g2 = a12.g();
                                                    if (!hashMap4.containsKey(g2)) {
                                                        hashMap4.put(g2, new bG(null));
                                                    }
                                                    bg = hashMap4.get(g2);
                                                    if (this.g.a(g2.c()).k() < this.g.a(g2.d()).k()) {
                                                        if (g2.c() == a12.f()) {
                                                            bg.a(e2);
                                                            if (!x2) {
                                                                break Label_1998;
                                                            }
                                                        }
                                                        bg.b(e2);
                                                        if (!x2) {
                                                            break Label_1998;
                                                        }
                                                    }
                                                    if (g2.c() == a12.f()) {
                                                        bg.b(e2);
                                                        if (!x2) {
                                                            break Label_1998;
                                                        }
                                                    }
                                                    bg.a(e2);
                                                }
                                            }
                                            a11.g();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        y = new y();
                                        p12 = a10.d().k();
                                        while (p12 != null) {
                                            q18 = (q)p12.c();
                                            d8 = q18.d();
                                            a13 = g.a(q18);
                                            b8 = (b(g, q18) ? 1 : 0);
                                            if (x2) {
                                                continue Label_5615;
                                            }
                                            Label_2643: {
                                                if (b8 != 0) {
                                                    a14 = g.a(q18);
                                                    if (a14.b() == 12) {
                                                        d9 = hashMap.get(a14.f());
                                                        if (d9 == null) {
                                                            d9 = k.d();
                                                            hashMap.put(a14.f(), d9);
                                                        }
                                                        q19 = (array4[d8] = d9);
                                                        hashMap3.put(a14.f(), q18);
                                                        list.add(a14.f());
                                                        list2.add(a14.f());
                                                        if (!x2) {
                                                            break Label_2643;
                                                        }
                                                    }
                                                    d10 = hashMap2.get(a14.f());
                                                    if (d10 == null) {
                                                        d10 = k.d();
                                                        hashMap2.put(a14.f(), d10);
                                                    }
                                                    q19 = (array4[d8] = d10);
                                                    if (q14 != null && g.a(q14).f() == a14.f()) {
                                                        this.a(array4[q14.d()], q19, this.a(x, a10, q14, q18), 0, k, u, u2);
                                                    }
                                                    if (q16 != null && g.a(q16).f() == a14.f()) {
                                                        this.a(array4[q16.d()], q19, this.a(x, a10, q16, q18), 0, k, u, u2);
                                                    }
                                                    if (list.size() > 0 && list.get(list.size() - 1) == a14.f()) {
                                                        list.remove(list.size() - 1);
                                                    }
                                                    if (list2.size() <= 0 || list2.get(list2.size() - 1) != a14.f()) {
                                                        break Label_2643;
                                                    }
                                                    list2.remove(list2.size() - 1);
                                                    if (!x2) {
                                                        break Label_2643;
                                                    }
                                                }
                                                if (a8 != null && a8.b(q18) != null) {
                                                    q19 = (array4[d8] = array4[((q)a8.b(q18)).d()]);
                                                    if (!x2) {
                                                        break Label_2643;
                                                    }
                                                }
                                                if (a8 == null && a(g, q18) && a(g, q18.g().c()) && !b4.d(q18.g())) {
                                                    q19 = (array4[d8] = array4[q18.g().c().d()]);
                                                    if (!x2) {
                                                        break Label_2643;
                                                    }
                                                }
                                                q19 = (array4[d8] = k.d());
                                            }
                                            if (a13.b() == 3) {
                                                y.add(q18);
                                            }
                                            Label_5090: {
                                                Label_4979: {
                                                    Label_4971: {
                                                        Label_4923: {
                                                            Label_3065: {
                                                                if (a13.b() != 15) {
                                                                    n16 = Double.MAX_VALUE;
                                                                    n17 = Double.MAX_VALUE;
                                                                    Label_2800: {
                                                                        if (q18.b() > 0) {
                                                                            d11 = q18.g();
                                                                            while (d11 != null) {
                                                                                n16 = Math.min(n16, x.b((Object)d11).getTargetPoint().a);
                                                                                d11 = d11.h();
                                                                                if (x2) {
                                                                                    break Label_2800;
                                                                                }
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        if (q18.c() > 0) {
                                                                            d12 = q18.f();
                                                                            while (d12 != null) {
                                                                                n17 = Math.min(n17, x.b((Object)d12).getSourcePoint().a);
                                                                                d12 = d12.g();
                                                                                if (x2) {
                                                                                    break Label_3065;
                                                                                }
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    d13 = a13.d();
                                                                    if (d13 != null) {
                                                                        a15 = d13;
                                                                        while (a15 != null) {
                                                                            d14 = (d)a15.c();
                                                                            c3 = d14.c();
                                                                            q20 = q18;
                                                                            if (x2) {
                                                                                break Label_4923;
                                                                            }
                                                                            Label_2885: {
                                                                                if (c3 == q20) {
                                                                                    n18 = x.b((Object)d14).getSourcePoint().a;
                                                                                    if (!x2) {
                                                                                        break Label_2885;
                                                                                    }
                                                                                }
                                                                                n18 = x.b((Object)d14).getTargetPoint().a;
                                                                            }
                                                                            a16 = g.a(d14);
                                                                            Label_2933: {
                                                                                if (a16 != null) {
                                                                                    if (a16.j()) {
                                                                                        n16 = Math.min(n16, n18);
                                                                                        if (!x2) {
                                                                                            break Label_2933;
                                                                                        }
                                                                                    }
                                                                                    n17 = Math.min(n17, n18);
                                                                                }
                                                                            }
                                                                            a15 = a15.a();
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                        }
                                                                    }
                                                                    if (n17 != Double.MAX_VALUE) {
                                                                        if (q16 != null) {
                                                                            this.a(array4[q16.d()], q19, Math.max(0.0, this.a(x, a10, q16, null) - n17), 0, k, u, u2);
                                                                            q16 = null;
                                                                        }
                                                                        q17 = q18;
                                                                    }
                                                                    if (n16 != Double.MAX_VALUE) {
                                                                        if (q14 != null) {
                                                                            this.a(array4[q14.d()], q19, Math.max(0.0, this.a(x, a10, q14, null) - n16), 0, k, u, u2);
                                                                            q14 = null;
                                                                        }
                                                                        q15 = q18;
                                                                    }
                                                                }
                                                            }
                                                            Label_4139: {
                                                                if (a13.b() == 15) {
                                                                    Label_3159: {
                                                                        if (q18.a() == 0) {
                                                                            d15 = a13.d();
                                                                            if (d15 != null) {
                                                                                j2 = (this.g.a((d)d15.c()).j() ? 1 : 0);
                                                                                if (!x2) {
                                                                                    break Label_3159;
                                                                                }
                                                                            }
                                                                            j2 = 1;
                                                                            if (!x2) {
                                                                                break Label_3159;
                                                                            }
                                                                        }
                                                                        j2 = ((q18.b() > 0) ? 1 : 0);
                                                                    }
                                                                    Label_3748: {
                                                                    Label_3266_Outer:
                                                                        while (true) {
                                                                            while (true) {
                                                                                Label_3618: {
                                                                                    Label_3391: {
                                                                                        if (j2 != 0) {
                                                                                            if (q15 == null) {
                                                                                                break Label_3391;
                                                                                            }
                                                                                            n19 = -1.7976931348623157E308;
                                                                                            d16 = q15.g();
                                                                                            while (d16 != null) {
                                                                                                n19 = Math.max(n19, x.b((Object)d16).getTargetPoint().a);
                                                                                                d16 = d16.h();
                                                                                                if (x2) {
                                                                                                    break Label_3391;
                                                                                                }
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            p13 = g.a(q15).d();
                                                                                        }
                                                                                        else {
                                                                                            if (q17 != null) {
                                                                                                n19 = -1.7976931348623157E308;
                                                                                                d17 = q17.f();
                                                                                                while (d17 != null) {
                                                                                                    n19 = Math.max(n19, x.b((Object)d17).getSourcePoint().a);
                                                                                                    d17 = d17.g();
                                                                                                    if (x2) {
                                                                                                        break Label_3748;
                                                                                                    }
                                                                                                    if (x2) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                p13 = g.a(q17).d();
                                                                                                break Label_3596;
                                                                                            }
                                                                                            break Label_3748;
                                                                                        }
                                                                                    Label_3352:
                                                                                        while (true) {
                                                                                            if (p13 == null) {
                                                                                                break Label_3352;
                                                                                            }
                                                                                            d18 = (d)p13.c();
                                                                                            q21 = (q22 = d18.c());
                                                                                            q23 = (q24 = q18);
                                                                                            if (x2) {
                                                                                                break Label_3618;
                                                                                            }
                                                                                            Label_3306: {
                                                                                                if (q22 == q24) {
                                                                                                    n20 = x.b((Object)d18).getSourcePoint().a;
                                                                                                    if (!x2) {
                                                                                                        break Label_3306;
                                                                                                    }
                                                                                                }
                                                                                                n20 = x.b((Object)d18).getTargetPoint().a;
                                                                                            }
                                                                                            a17 = g.a(d18);
                                                                                            if (a17 != null && a17.j()) {
                                                                                                n19 = Math.max(n19, n20);
                                                                                            }
                                                                                            p13 = p13.a();
                                                                                            if (!x2) {
                                                                                                continue Label_3266_Outer;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        this.a(array4[q15.d()], q19, Math.max(0.0, n19 + this.a(x, a10, null, q18)), 0, k, u, u2);
                                                                                    }
                                                                                    if (list.size() > 0) {
                                                                                        q25 = list.get(list.size() - 1);
                                                                                        list.clear();
                                                                                        this.a(hashMap.get(q25), q19, this.a(x, a10, null, q18) * 0.5, 0, k, u, u2);
                                                                                    }
                                                                                    if (q14 != null) {
                                                                                        this.a(array4[q14.d()], q19, this.a(x, a10, q14, q18), 0, k, u, u2);
                                                                                    }
                                                                                    q14 = q18;
                                                                                    q15 = null;
                                                                                    break Label_4139;
                                                                                    if (p13 == null) {
                                                                                        break Label_3266_Outer;
                                                                                    }
                                                                                    d18 = (d)p13.c();
                                                                                    q21 = (q22 = d18.c());
                                                                                    q23 = (q24 = q18);
                                                                                }
                                                                                if (x2) {
                                                                                    continue Label_5878_Outer;
                                                                                }
                                                                                break;
                                                                            }
                                                                            Label_3663: {
                                                                                if (q21 == q23) {
                                                                                    n21 = x.b((Object)d18).getSourcePoint().a;
                                                                                    if (!x2) {
                                                                                        break Label_3663;
                                                                                    }
                                                                                }
                                                                                n21 = x.b((Object)d18).getTargetPoint().a;
                                                                            }
                                                                            a18 = g.a(d18);
                                                                            if (a18 != null && !a18.j()) {
                                                                                n19 = Math.max(n19, n21);
                                                                            }
                                                                            p13 = p13.a();
                                                                            if (!x2) {
                                                                                continue Label_3266_Outer;
                                                                            }
                                                                            break;
                                                                        }
                                                                        this.a(array4[q17.d()], q19, Math.max(0.0, n19 + this.a(x, a10, null, q18)), 0, k, u, u2);
                                                                    }
                                                                    if (list2.size() > 0) {
                                                                        q26 = list2.get(list2.size() - 1);
                                                                        list2.clear();
                                                                        this.a(hashMap.get(q26), q19, this.a(x, a10, null, q18) * 0.5, 0, k, u, u2);
                                                                    }
                                                                    if (q16 != null) {
                                                                        this.a(array4[q16.d()], q19, this.a(x, a10, q16, q18), 0, k, u, u2);
                                                                    }
                                                                    q16 = q18;
                                                                    q17 = null;
                                                                }
                                                                else {
                                                                    if (q12 == null) {
                                                                        if (array2[d8] > 0) {
                                                                            this.a(array7[array2[d8] - 1], q19, this.a(x, a10, null, q18) + x.p(q18) * 0.5 + array5[array2[d8]], 0, k, u, u2);
                                                                            if (!x2) {
                                                                                break Label_4139;
                                                                            }
                                                                        }
                                                                        this.a(d2, q19, this.a(x, a10, null, q18) + x.p(q18) * 0.5, 0, k, u, u2);
                                                                        if (!x2) {
                                                                            break Label_4139;
                                                                        }
                                                                    }
                                                                    n22 = array2[q18.d()];
                                                                    n23 = array2[q12.d()];
                                                                    if (n23 != n22) {
                                                                        if (n22 > 0 && n22 <= array7.length) {
                                                                            this.a(array7[n22 - 1], q19, this.a(x, a10, null, q18) + array5[n22] + x.p(q18) * 0.5, 0, k, u, u2);
                                                                        }
                                                                        if (n23 >= 0 && n23 < array7.length) {
                                                                            this.a(q13, array7[n23], this.a(x, a10, q12, null) + array6[n23] + x.p(q12) * 0.5, 0, k, u, u2);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (a13.b() == 2 || a13.b() == 3) {
                                                                if (a13.b() != 15) {
                                                                    f2 = a13.f();
                                                                }
                                                                else {
                                                                    f2 = q10;
                                                                }
                                                                Label_4252: {
                                                                    if (a13.b() == 2 || a13.b() == 15) {
                                                                        j3 = (q18.b() > 0);
                                                                        if (!x2) {
                                                                            break Label_4252;
                                                                        }
                                                                    }
                                                                    j3 = g.a(a13.g()).j();
                                                                }
                                                                if (j3) {
                                                                    Label_4359: {
                                                                        if (q8 != null) {
                                                                            this.a(q8, q19, this.a(x, a10, q7, q18), (q9 == f2) ? 1 : 0, k, u, u2);
                                                                            if (!x2) {
                                                                                break Label_4359;
                                                                            }
                                                                        }
                                                                        if (q13 != null) {
                                                                            this.a(q13, q19, x.p(q12) * 0.5 + this.a(x, a10, q12, q18), (q12 == f2) ? 1 : 0, k, u, u2);
                                                                        }
                                                                    }
                                                                    max2 = Math.max(max2, x.k(q18));
                                                                    if (q5 != null && q6 != f2 && min <= x.k(q18)) {
                                                                        this.a(q5, q19, this.a(x, a10, q4, q18), 0, k, u, u2);
                                                                        min = Double.MAX_VALUE;
                                                                    }
                                                                    if (a13.b() != 15) {
                                                                        q9 = f2;
                                                                    }
                                                                    q7 = q18;
                                                                    ax2 = a13;
                                                                    q8 = q19;
                                                                    if (!x2) {
                                                                        break Label_5090;
                                                                    }
                                                                }
                                                                Label_4563: {
                                                                    if (q5 != null) {
                                                                        this.a(q5, q19, this.a(x, a10, q4, q18), (q6 == f2) ? 1 : 0, k, u, u2);
                                                                        if (!x2) {
                                                                            break Label_4563;
                                                                        }
                                                                    }
                                                                    if (q13 != null) {
                                                                        this.a(q13, q19, x.p(q12) * 0.5 + this.a(x, a10, q12, q18), (q12 == f2) ? 1 : 0, k, u, u2);
                                                                    }
                                                                }
                                                                min = Math.min(min, x.k(q18));
                                                                if (q8 != null && q9 != f2 && max2 >= x.k(q18)) {
                                                                    this.a(q8, q19, this.a(x, a10, q7, q18), 0, k, u, u2);
                                                                    max2 = -1.7976931348623157E308;
                                                                }
                                                                q4 = q18;
                                                                q5 = q19;
                                                                ax = a13;
                                                                if (a13.b() != 15) {
                                                                    q6 = f2;
                                                                }
                                                                break Label_5090;
                                                            }
                                                            else {
                                                                if (a13.b() == 15) {
                                                                    break Label_5090;
                                                                }
                                                                if (q5 != null) {
                                                                    this.a(q5, q19, x.p(q18) * 0.5 + this.a(x, a10, q4, q18), (ax.b() != 15 && ax.f() == q18) ? 1 : 0, k, u, u2);
                                                                    min = Double.MAX_VALUE;
                                                                    q5 = null;
                                                                    ax = null;
                                                                    q4 = null;
                                                                    q6 = null;
                                                                }
                                                                if (q8 != null) {
                                                                    this.a(q8, q19, x.p(q18) * 0.5 + this.a(x, a10, q7, q18), (ax2.b() != 15 && ax2.f() == q18) ? 1 : 0, k, u, u2);
                                                                    max2 = -1.7976931348623157E308;
                                                                    q8 = null;
                                                                    ax2 = null;
                                                                    q7 = null;
                                                                    q9 = null;
                                                                }
                                                                if (q13 != null) {
                                                                    this.a(q13, q19, 0.5 * (x.p(q12) + x.p(q18)) + this.a(x, a10, q12, q18), 0, k, u, u2);
                                                                }
                                                                if (a13.b() != 0) {
                                                                    break Label_4979;
                                                                }
                                                                if (q11 == null) {
                                                                    break Label_4971;
                                                                }
                                                            }
                                                        }
                                                        if (c3 != q20) {
                                                            this.a(q11, q19, 0.5 * (x.p(q10) + x.p(q18)) + this.a(x, a10, q10, q18), 0, k, u, u2);
                                                        }
                                                    }
                                                    q11 = q19;
                                                    q10 = q18;
                                                }
                                                if (a13.b() == 13) {
                                                    f3 = a13.f();
                                                    q27 = hashMap.get(f3);
                                                    q28 = hashMap2.get(f3);
                                                    if (!k.b(q27, q28)) {
                                                        f.add(this.a(q27, q28, this.a(x, a10, hashMap3.get(f3), q18), 0, k, u, u2));
                                                    }
                                                }
                                                q13 = q19;
                                                q12 = q18;
                                            }
                                            if (a13.b() == 3) {
                                                g3 = a13.g();
                                                if (!hashMap4.containsKey(g3)) {
                                                    throw new RuntimeException("Proxy must have a same layer edge");
                                                }
                                                bg2 = hashMap4.get(g3);
                                                a19 = bg2.a();
                                                if (a19 == null) {
                                                    a19 = ((this.g.a(g3.c()).k() < this.g.a(g3.d()).k()) ? g3.c() : g3.d());
                                                }
                                                b11 = bg2.b();
                                                if (b11 == null) {
                                                    b11 = ((this.g.a(g3.c()).k() > this.g.a(g3.d()).k()) ? g3.c() : g3.d());
                                                }
                                                q29 = array4[b11.d()];
                                                q30 = array4[a19.d()];
                                                if (q29 != null && q30 != null) {
                                                    this.a(q30, q29, this.a(x, a10, a19, b11) + (x.p(a19) + x.p(b11)) * 0.5, 1, k, u, u2);
                                                    if (x2) {
                                                        throw new RuntimeException("Proxy must have a same layer edge");
                                                    }
                                                }
                                            }
                                            else if (a13.e() > 0) {
                                                p14 = a13.d();
                                                while (p14 != null) {
                                                    d19 = (d)p14.c();
                                                    containsKey = hashMap4.containsKey(d19);
                                                    if (x2) {
                                                        continue Label_5615;
                                                    }
                                                    if (!containsKey || hashMap4.get(d19).a() == null) {
                                                        a20 = d19.a(q18);
                                                        q31 = array4[q18.d()];
                                                        q32 = array4[a20.d()];
                                                        if (hashMap4.containsKey(d19)) {
                                                            a21 = hashMap4.get(d19).a();
                                                            if (a21 != null) {
                                                                q32 = array4[a21.d()];
                                                                a20 = a21;
                                                            }
                                                        }
                                                        if (q31 != null && q32 != null) {
                                                            this.a(q32, q31, this.a(x, a10, a20, q18) + x.p(q18) * 0.5 + x.p(a20) * 0.5, 1, k, u, u2);
                                                            ++n12;
                                                        }
                                                    }
                                                    p14 = p14.a();
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                            }
                                            p12 = p12.a();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        break Label_5615;
                                    }
                                    break Label_5965;
                                }
                                a22 = y.a();
                                while (true) {
                                    while (true) {
                                        while (a22.f()) {
                                            e3 = a22.e();
                                            a23 = this.g.a(e3);
                                            f4 = a23.f();
                                            g4 = a23.g();
                                            if (x2) {
                                                d20 = q12.d();
                                                if (array2[d20] >= 0 && array2[d20] < array7.length) {
                                                    this.a(q13, array7[array2[d20]], this.a(x, a10, q12, null) + array6[array2[d20]] + x.p(q12) * 0.5, 0, k, u, u2);
                                                }
                                                ++n14;
                                                continue Label_5615;
                                            }
                                            Label_5825: {
                                                if (g4 != null) {
                                                    a24 = g4.a(f4);
                                                    a25 = this.g.a(a24);
                                                    a26 = this.g.a(f4);
                                                    if (a25.b() == 15) {
                                                        q33 = array4[a24.d()];
                                                        q34 = array4[e3.d()];
                                                        if (a25.k() < a26.k()) {
                                                            this.a(q33, q34, this.a(x, a10, a24, e3), 1, k, u, u2);
                                                            if (!x2) {
                                                                break Label_5825;
                                                            }
                                                        }
                                                        this.a(q34, q33, this.a(x, a10, e3, a24), 1, k, u, u2);
                                                    }
                                                }
                                            }
                                            a22.g();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        if (q12 != null) {
                                            this.a(q13, d3, this.a(x, a10, q12, null) + x.p(q12) * 0.5, 0, k, u, u2);
                                            continue Label_5957_Outer;
                                        }
                                        break;
                                    }
                                    continue Label_6750_Outer;
                                }
                            } while (!x2);
                            array10 = new int[x.g()];
                            bz = new bz(this);
                            o2 = x.o();
                            while (o2.f()) {
                                o2.e();
                            Label_6006:
                                while (true) {
                                    b12 = ((q35.c() & 0x1) == 0x1);
                                    if (b12) {
                                        o2.e().b(bz);
                                    }
                                    n24 = -o2.e().c() / 2;
                                    d21 = o2.e().f();
                                    while (d21 != null) {
                                        b13 = d21.b();
                                        q36 = array4[d21.c().d()];
                                        q37 = array4[d21.d().d()];
                                        q35 = q36;
                                        if (x2) {
                                            continue Label_6006;
                                        }
                                        if (q35 != q37) {
                                            e4 = this.e;
                                            Label_6186: {
                                                if (!b4.d(d21)) {
                                                    a27 = a(g, d21.c());
                                                    a28 = a(g, d21.d());
                                                    if (a27 && a28) {
                                                        e4 = n11;
                                                        if (!x2) {
                                                            break Label_6186;
                                                        }
                                                    }
                                                    if (a27) {
                                                        ++e4;
                                                    }
                                                }
                                            }
                                            if (b12 && n24 == 0) {
                                                e4 += this.e * 4;
                                            }
                                            array10[b13] = e4;
                                        }
                                        d21 = d21.g();
                                        ++n24;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                o2.g();
                                if (x2) {
                                    break;
                                }
                            }
                            ba = new bA(this);
                            o3 = x.o();
                            while (o3.f()) {
                                o3.e();
                            Label_6274:
                                while ((q38.b() & 0x1) == 0x1) {
                                    o3.e().a(ba);
                                    n25 = -o3.e().b() / 2;
                                    d22 = o3.e().g();
                                    while (d22 != null) {
                                        q39 = array4[d22.c().d()];
                                        q40 = array4[d22.d().d()];
                                        q38 = q39;
                                        if (x2) {
                                            continue Label_6274;
                                        }
                                        if (q38 != q40) {
                                            if (n25 == 0) {
                                                b14 = d22.b();
                                                array11 = array10;
                                                n26 = b14;
                                                array11[n26] += this.e * 4;
                                            }
                                        }
                                        d22 = d22.h();
                                        ++n25;
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                o3.g();
                                if (x2) {
                                    break;
                                }
                            }
                            e5 = x.p();
                            while (true) {
                                while (true) {
                                Label_9249_Outer:
                                    while (e5.f()) {
                                        a29 = e5.a();
                                        b15 = a29.b();
                                        n27 = (n28 = array10[b15]) * (1.0 - 0.1 * Math.min(8, a29.c().c() + a29.d().b() - 2));
                                        d23 = b4.d(a29);
                                        if (x2) {
                                            while (true) {
                                                if (d23) {
                                                    a30 = e5.a();
                                                    d24 = a30.c().d();
                                                    d25 = a30.d().d();
                                                    if (array2[d24] != array2[d25] && array2[d24] >= 0 && array2[d25] >= 0) {
                                                        array12 = array10;
                                                        b16 = a30.b();
                                                        array12[b16] *= (int)this.k;
                                                    }
                                                    e5.g();
                                                    if (!x2) {
                                                        e5.f();
                                                        continue Label_6750_Outer;
                                                    }
                                                }
                                                break;
                                            }
                                            b17 = y.g.M.b();
                                            n29 = 0;
                                        Label_7452:
                                            do {
                                            Label_6857:
                                                while (n30 < au.b()) {
                                                    f5 = new f();
                                                    p15 = au.a(n29).d().k();
                                                    while (p15 != null) {
                                                        q41 = (q)p15.c();
                                                        if (x2) {
                                                            continue Label_7452;
                                                        }
                                                        d26 = q41.f();
                                                        while (d26 != null) {
                                                            b18 = d26.b();
                                                            n31 = (n30 = array10[b18]);
                                                            if (x2) {
                                                                continue Label_6857;
                                                            }
                                                            Label_7161: {
                                                                if (n30 > 0) {
                                                                    f5.add(d26);
                                                                    q42 = array4[d26.c().d()];
                                                                    q43 = array4[d26.d().d()];
                                                                    if (q42 != q43) {
                                                                        d27 = k.d();
                                                                        array3[b18] = d27;
                                                                        a31 = k.a(d27, q42);
                                                                        a32 = k.a(d27, q43);
                                                                        u.a(a31, n31);
                                                                        u.a(a32, n31);
                                                                        n32 = 2520.0 * x.n(d26).a();
                                                                        n33 = 2520.0 * x.o(d26).a();
                                                                        if (n32 > n33) {
                                                                            n34 = (int)Math.rint(n32 - n33);
                                                                            u2.a(a31, 0);
                                                                            u2.a(a32, n34);
                                                                            if (!x2) {
                                                                                break Label_7161;
                                                                            }
                                                                        }
                                                                        u2.a(a31, (int)Math.rint(n33 - n32));
                                                                        u2.a(a32, 0);
                                                                    }
                                                                }
                                                            }
                                                            d26 = d26.g();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        p15 = p15.a();
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                    Label_7449: {
                                                        if (c == null && c2 == null && b3) {
                                                            a33 = this.a(f5, (c)h3).a();
                                                        Label_7217:
                                                            while (a33.f()) {
                                                                a34 = a33.a();
                                                                a35 = this.g.a(a34.c());
                                                                a36 = this.g.a(a34.d());
                                                                b19 = (b20 = a35.b());
                                                                if (!x2) {
                                                                    b21 = (b19 != 0 && a36.b() != 0);
                                                                    b22 = (a35.b() == 6 || a36.b() == 7);
                                                                    n35 = ((b21 && !b22) ? 100000 : 10000);
                                                                    j4 = array3[a34.b()].j();
                                                                    while (true) {
                                                                        while (j4.f()) {
                                                                            a37 = j4.a();
                                                                            n36 = u.a(a37) + n35;
                                                                            b17.a(a37, n35);
                                                                            u.a(a37, n36);
                                                                            j4.g();
                                                                            if (!x2) {
                                                                                if (x2) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0251_Outer;
                                                                            }
                                                                            else {
                                                                                if (x2) {
                                                                                    break Label_7449;
                                                                                }
                                                                                continue Label_7217;
                                                                            }
                                                                        }
                                                                        a33.g();
                                                                        continue;
                                                                    }
                                                                }
                                                                continue Label_6857;
                                                            }
                                                        }
                                                    }
                                                    ++n29;
                                                }
                                                break;
                                            } while (!x2);
                                            Label_7696: {
                                                if (this.l && b) {
                                                    d4 = k.d();
                                                    d28 = this.d;
                                                    o4 = x.o();
                                                    while (o4.f()) {
                                                        e6 = o4.e();
                                                        b23 = ((n37 = (this.a(x, g, e6, 0 != 0) ? 1 : 0)) != 0);
                                                        if (x2) {
                                                            break Label_7696;
                                                        }
                                                        Label_7680: {
                                                            if (b23) {
                                                                q44 = array4[e6.d()];
                                                                d29 = k.d();
                                                                a38 = k.a(d29, d4);
                                                                a39 = k.a(d29, q44);
                                                                u.a(a38, d28);
                                                                u.a(a39, d28);
                                                                n38 = 2520.0 * x.j(e6);
                                                                n39 = 0.0;
                                                                if (n38 > n39) {
                                                                    n40 = (int)Math.rint(n38 - n39);
                                                                    u2.a(a38, 0);
                                                                    u2.a(a39, n40);
                                                                    if (!x2) {
                                                                        break Label_7680;
                                                                    }
                                                                }
                                                                u2.a(a38, (int)Math.rint(n39 - n38));
                                                                u2.a(a39, 0);
                                                            }
                                                        }
                                                        o4.g();
                                                        if (x2) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                n37 = this.p;
                                            }
                                            Label_8049: {
                                                Label_8045: {
                                                    Label_7954: {
                                                        Label_7890: {
                                                            Label_7887: {
                                                                Label_7839: {
                                                                    if (n37 == 1) {
                                                                        max3 = 0;
                                                                        p16 = k.p();
                                                                        while (p16.f()) {
                                                                            a40 = p16.a();
                                                                            n41 = u.a(a40) - b17.a(a40);
                                                                            n42 = max3;
                                                                            n43 = n41;
                                                                            if (x2) {
                                                                                break Label_7954;
                                                                            }
                                                                            max3 = n42 + ((n43 == 0) ? 1 : n41);
                                                                            p16.g();
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        a41 = f.a();
                                                                        while (a41.f()) {
                                                                            u.a(a41.a(), 2 * max3);
                                                                            a41.g();
                                                                            if (x2) {
                                                                                break Label_7890;
                                                                            }
                                                                            if (x2) {
                                                                                break Label_7839;
                                                                            }
                                                                        }
                                                                        break Label_7887;
                                                                    }
                                                                }
                                                                a42 = f.a();
                                                                while (a42.f()) {
                                                                    u.a(a42.a(), 1);
                                                                    a42.g();
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            max3 = 0;
                                                        }
                                                        p17 = k.p();
                                                        while (p17.f()) {
                                                            max3 = Math.max(max3, u.a(p17.a()));
                                                            p17.g();
                                                            if (x2) {
                                                                break Label_8045;
                                                            }
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    if (n42 > n43) {
                                                        n44 = max3 / 19000;
                                                        p18 = k.p();
                                                        while (p18.f()) {
                                                            a43 = p18.a();
                                                            n45 = (a44 = u.a(a43));
                                                            if (x2) {
                                                                break Label_8049;
                                                            }
                                                            if (a44 >= 1000) {
                                                                u.a(a43, n45 / n44 + 1000);
                                                            }
                                                            p18.g();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                i2 = this.i;
                                            }
                                            Label_9390: {
                                                Label_8797: {
                                                    if (a44 != 0) {
                                                        array13 = new int[k.e()];
                                                        y.a.u.a(k, y.g.M.a(array13), u, u2, this.o - System.currentTimeMillis() + currentTimeMillis);
                                                        if (d4 != null) {
                                                            this.a(x, au, g, -array13[d4.d()], array13, array4);
                                                        }
                                                        array14 = new int[k.e()];
                                                        p19 = k.p();
                                                        while (p19.f()) {
                                                            k.c(p19.a());
                                                            p19.g();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        n46 = 0;
                                                    Label_8376_Outer:
                                                        while (true) {
                                                        Label_8376:
                                                            while (true) {
                                                                while (n46 < array3.length) {
                                                                    q45 = (q46 = array3[n46]);
                                                                    if (!x2) {
                                                                        if (q46 != null) {
                                                                            g5 = q45.g();
                                                                            h5 = g5.h();
                                                                            k.c(g5);
                                                                            k.c(h5);
                                                                            a45 = u2.a(g5);
                                                                            u2.a(g5, u2.a(h5));
                                                                            u2.a(h5, a45);
                                                                        }
                                                                        ++n46;
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                        continue Label_0251_Outer;
                                                                    }
                                                                    else {
                                                                        if (q46 != null) {
                                                                            n46 = -array14[d4.d()];
                                                                            this.a(x, au, g, n46, array14, array4);
                                                                        }
                                                                        Label_8520: {
                                                                            if (d4 != null) {
                                                                                n46 = -(array13[d4.d()] + array14[d4.d()]);
                                                                                if (!x2) {
                                                                                    break Label_8520;
                                                                                }
                                                                            }
                                                                            min2 = Integer.MAX_VALUE;
                                                                            min3 = Integer.MAX_VALUE;
                                                                            Label_8517: {
                                                                                if (d2.b() > 0) {
                                                                                    d30 = d2.g();
                                                                                    while (true) {
                                                                                        while (d30 != null) {
                                                                                            d31 = d30.c().d();
                                                                                            a46 = u2.a(d30);
                                                                                            min2 = Math.min(min2, array13[d31] - a46);
                                                                                            min3 = Math.min(min3, array14[d31] - a46);
                                                                                            d30 = d30.h();
                                                                                            if (!x2) {
                                                                                                if (x2) {
                                                                                                    break;
                                                                                                }
                                                                                                continue Label_0251_Outer;
                                                                                            }
                                                                                            else {
                                                                                                if (x2) {
                                                                                                    break Label_8517;
                                                                                                }
                                                                                                break Label_8520;
                                                                                            }
                                                                                        }
                                                                                        n46 = -(min2 + min3);
                                                                                        continue Label_9249_Outer;
                                                                                    }
                                                                                }
                                                                            }
                                                                            n46 = 0;
                                                                        }
                                                                        n47 = 1.984126984126984E-4;
                                                                        o5 = x.o();
                                                                        while (o5.f()) {
                                                                            e7 = o5.e();
                                                                            d32 = array4[e7.d()].d();
                                                                            if (x2) {
                                                                                break Label_9390;
                                                                            }
                                                                            if (d4 == null || !this.a(x, g, e7, false)) {
                                                                                x.a(e7, (array13[d32] + array14[d32] + n46) * n47, x.k(e7));
                                                                            }
                                                                            o5.g();
                                                                            if (x2) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (array7 != null) {
                                                                            array5[0] = (array13[d2.d()] + array14[d2.d()] + n46) * n47 - array5[0];
                                                                            n48 = 0;
                                                                            while (true) {
                                                                                while (n48 < array7.length) {
                                                                                    d33 = array7[n48].d();
                                                                                    array6[n48] = (array13[d33] + array14[d33] + n46) * n47;
                                                                                    n49 = n48;
                                                                                    if (!x2) {
                                                                                        if (n49 > 0) {
                                                                                            array5[n48] = array6[n48 - 1];
                                                                                        }
                                                                                        ++n48;
                                                                                        if (x2) {
                                                                                            break;
                                                                                        }
                                                                                        continue Label_0251_Outer;
                                                                                    }
                                                                                    else {
                                                                                        if (n49 > 0) {
                                                                                            array5[array7.length] = array6[array7.length - 1];
                                                                                        }
                                                                                        array15 = array6;
                                                                                        length = array7.length;
                                                                                        array15[length] += (array13[d3.d()] + array14[d3.d()] + n46) * n47;
                                                                                        if (x2) {
                                                                                            break Label_8797;
                                                                                        }
                                                                                        break Label_9390;
                                                                                    }
                                                                                }
                                                                                length2 = array7.length;
                                                                                continue Label_9249_Outer;
                                                                            }
                                                                        }
                                                                        break Label_9390;
                                                                    }
                                                                }
                                                                y.a.u.a(k, y.g.M.a(array14), u, u2, this.o - System.currentTimeMillis() + currentTimeMillis);
                                                                n46 = 0;
                                                                while (n46 < array14.length) {
                                                                    array14[n46] = -array14[n46];
                                                                    ++n46;
                                                                    if (x2) {
                                                                        continue Label_8376;
                                                                    }
                                                                    if (x2) {
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            continue Label_8376_Outer;
                                                        }
                                                    }
                                                }
                                                array16 = new int[k.e()];
                                                y.a.u.a(k, y.g.M.a(array16), u, u2, this.o - System.currentTimeMillis() + currentTimeMillis);
                                                n50 = 3.968253968253968E-4;
                                                Label_8966: {
                                                    if (d4 != null) {
                                                        n51 = -array16[d4.d()];
                                                        this.a(x, au, g, n51, array16, array4);
                                                        if (!x2) {
                                                            break Label_8966;
                                                        }
                                                    }
                                                    min4 = Integer.MAX_VALUE;
                                                    if (d2.c() > 0) {
                                                        d34 = d2.f();
                                                        while (d34 != null) {
                                                            min4 = Math.min(min4, array16[d34.d().d()] - u2.a(d34));
                                                            d34 = d34.g();
                                                            if (x2) {
                                                                break Label_9390;
                                                            }
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        n51 = -min4;
                                                        if (!x2) {
                                                            break Label_8966;
                                                        }
                                                    }
                                                    n51 = 0;
                                                }
                                                o6 = x.o();
                                            Label_9249:
                                                while (true) {
                                                    while (o6.f()) {
                                                        e8 = o6.e();
                                                        if (!x2) {
                                                            if (d4 == null || !this.a(x, g, e8, false)) {
                                                                x.a(e8, (n51 + array16[array4[e8.d()].d()]) * n50, x.k(e8));
                                                            }
                                                            o6.g();
                                                            if (x2) {
                                                                break;
                                                            }
                                                            continue Label_0251_Outer;
                                                        }
                                                        else {
                                                            if (array7 != null) {
                                                                array5[0] = (array16[d2.d()] + n51) * n50 - array5[0];
                                                                n52 = 0;
                                                                while (true) {
                                                                    while (n52 < array7.length) {
                                                                        array6[n52] = (array16[array7[n52].d()] + n51) * n50;
                                                                        n53 = n52;
                                                                        if (x2) {
                                                                            if (n53 > 0) {
                                                                                array5[array7.length] = array6[array7.length - 1];
                                                                            }
                                                                            array17 = array6;
                                                                            length3 = array7.length;
                                                                            array17[length3] += (array16[d3.d()] + n51) * n50;
                                                                            break Label_9390;
                                                                        }
                                                                        if (n53 > 0) {
                                                                            array5[n52] = array6[n52 - 1];
                                                                        }
                                                                        ++n52;
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    length4 = array7.length;
                                                                    continue;
                                                                }
                                                            }
                                                            break Label_9390;
                                                        }
                                                    }
                                                    if (this.c()) {
                                                        d35 = new D();
                                                        o7 = x.o();
                                                        while (true) {
                                                            while (o7.f()) {
                                                                e9 = o7.e();
                                                                d35.add(new bI(e9, false, e9.b(), null));
                                                                d35.add(new bI(e9, true, e9.c(), null));
                                                                o7.g();
                                                                if (x2) {
                                                                    m2 = d35.m();
                                                                    while (m2.f()) {
                                                                        bi = (bI)m2.d();
                                                                        this.a(bi.a, x, this.g, 0.5, bi.b);
                                                                        m2.g();
                                                                        if (x2) {
                                                                            break Label_9390;
                                                                        }
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    continue Label_9249;
                                                                }
                                                                if (x2) {
                                                                    break;
                                                                }
                                                            }
                                                            d35.sort(new bB(this));
                                                            continue;
                                                        }
                                                    }
                                                    continue Label_9249;
                                                }
                                            }
                                            Label_9548: {
                                                if (array7 != null) {
                                                    n54 = 0;
                                                    Label_9398:
                                                    while (n54 < au.b()) {
                                                        n55 = 0;
                                                        if (!x2) {
                                                            p20 = au.a(n54).d().k();
                                                            while (true) {
                                                                while (p20 != null) {
                                                                    q47 = (q)p20.c();
                                                                    array[q47.d()] = n55++;
                                                                    h6 = this.g.a(q47).h();
                                                                    if (!x2) {
                                                                        if (h6 != null) {
                                                                            j5 = h6.j();
                                                                            h6.e(array5[j5]);
                                                                            h6.f(array6[j5] - array5[j5]);
                                                                        }
                                                                        p20 = p20.a();
                                                                        if (x2) {
                                                                            break;
                                                                        }
                                                                        continue Label_0251_Outer;
                                                                    }
                                                                    else {
                                                                        if (x2) {
                                                                            break Label_9548;
                                                                        }
                                                                        continue Label_9398;
                                                                    }
                                                                }
                                                                ++n54;
                                                                continue;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                }
                                            }
                                            this.g = null;
                                            this.a = null;
                                            return;
                                        }
                                        if (d23) {
                                            n56 = 1.0;
                                            if (this.f()) {
                                                b24 = this.g.a(a29).b();
                                                Label_6596: {
                                                    if (b24 != null) {
                                                        q48 = b24.c();
                                                        q49 = b24.d();
                                                        if (!x2) {
                                                            break Label_6596;
                                                        }
                                                    }
                                                    q48 = a29.c();
                                                    q49 = a29.d();
                                                }
                                                a47 = this.g.a(q48);
                                                a48 = this.g.a(q49);
                                                if (a47 != null && a48 != null) {
                                                    n56 = Math.abs(a48.j() - a47.j()) / (au.b() - 1);
                                                }
                                            }
                                            n27 *= 0.5 * n56;
                                        }
                                        if (a(this.g, a29.c()) && n27 > 0.0) {
                                            n27 += 2.0;
                                        }
                                        array10[b15] = (int)((n28 > 0.0) ? Math.max(1.0, n27) : 0.0);
                                        e5.g();
                                        if (x2) {
                                            break;
                                        }
                                    }
                                    if (array7 != null) {
                                        e5 = x.p();
                                        continue Label_6847_Outer;
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    break;
                } while (!x2);
                if (this.a() && this.d() > x.h()) {
                    final boolean b2 = true;
                    continue;
                }
                break;
            }
            continue Label_0251_Outer;
        }
    }
    
    void a(final aU au) {
        final boolean x = N.x;
        int n = 0;
        do {
            int i = 0;
        Label_0008:
            while (i < au.b()) {
                final aQ a = au.a(n);
                int n2 = 0;
                p p = a.d().k();
                while (p != null) {
                    final aX a2 = this.g.a((q)p.c());
                    i = ((a2 instanceof as) ? 1 : 0);
                    if (x) {
                        continue Label_0008;
                    }
                    if (i != 0) {
                        ((as)a2).b(n2);
                    }
                    p = p.a();
                    ++n2;
                    if (x) {
                        break;
                    }
                }
                ++n;
            }
            break;
        } while (!x);
    }
    
    private f a(final f f, final c c) {
        final boolean x = N.x;
        final i i = new i();
        final HashSet<q> set = new HashSet<q>();
        final y y = new y();
        final HashSet<q> set2 = new HashSet<q>();
        final y y2 = new y();
        final h b = y.g.M.b();
        final A a = y.g.M.a();
        final e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            if (!c.d(a3)) {
                if (set.add(a3.c())) {
                    y.add(a3.c());
                }
                if (set2.add(a3.d())) {
                    y2.add(a3.d());
                }
                final q d = i.d();
                b.a(a3, d);
                a.a(d, a3);
            }
            a2.g();
            if (x) {
                break;
            }
        }
        x x2 = y.a();
    Label_0405:
        while (true) {
            do {
                Label_0190: {
                    x2.f();
                }
                boolean d2 = false;
                Label_0197:
                while (d2) {
                    final q e = x2.e();
                    final byte b2 = this.g.a(e).b();
                    if (!x) {
                        if (b2 != 0) {
                            final d[] e2 = new f(e.l()).e();
                            int n = 0;
                            do {
                                int j = 0;
                                Label_0259:
                                while (j < e2.length) {
                                    d2 = c.d(e2[n]);
                                    if (x) {
                                        continue Label_0197;
                                    }
                                    if (!d2) {
                                        final q q = (q)b.b(e2[n]);
                                        int k = n + 1;
                                        while (k < e2.length) {
                                            j = (c.d(e2[k]) ? 1 : 0);
                                            if (x) {
                                                continue Label_0259;
                                            }
                                            if (j == 0) {
                                                final q q2 = (q)b.b(e2[k]);
                                                if (q.c(q2) == null) {
                                                    i.a(q, q2);
                                                }
                                            }
                                            ++k;
                                            if (x) {
                                                break;
                                            }
                                        }
                                    }
                                    ++n;
                                }
                                break;
                            } while (!x);
                        }
                        x2.g();
                        continue Label_0190;
                    }
                Label_0608:
                    while (true) {
                        while (b2 != 0) {
                            final q e3 = x2.e();
                            if (this.g.a(e3).b() != 0) {
                                final d[] e4 = new f(e3.k()).e();
                                int n2 = 0;
                                do {
                                    int l = 0;
                                    Label_0469:
                                    while (l < e4.length) {
                                        final boolean d3;
                                        final boolean b3 = d3 = c.d(e4[n2]);
                                        if (x) {
                                            continue Label_0412;
                                        }
                                        if (!b3) {
                                            final q q3 = (q)b.b(e4[n2]);
                                            int n3 = n2 + 1;
                                            while (n3 < e4.length) {
                                                l = (c.d(e4[n3]) ? 1 : 0);
                                                if (x) {
                                                    continue Label_0469;
                                                }
                                                if (l == 0) {
                                                    final q q4 = (q)b.b(e4[n3]);
                                                    if (q3.c(q4) == null) {
                                                        i.a(q3, q4);
                                                    }
                                                }
                                                ++n3;
                                                if (x) {
                                                    break;
                                                }
                                            }
                                        }
                                        ++n2;
                                    }
                                    break;
                                } while (!x);
                            }
                            x2.g();
                            if (x) {
                                break;
                            }
                            break Label_0405;
                        }
                        break Label_0608;
                        x2.f();
                        continue;
                    }
                    final d[] e5 = f.e();
                    int n4 = 0;
                    do {
                        int d4 = 0;
                        Label_0619:
                        while (d4 < e5.length) {
                            final d d5 = e5[n4];
                            if (!c.d(d5)) {
                                final q q5 = (q)b.b(d5);
                                int n5 = n4 + 1;
                                while (n5 < e5.length) {
                                    final d d6 = e5[n5];
                                    d4 = (c.d(d6) ? 1 : 0);
                                    if (x) {
                                        continue Label_0619;
                                    }
                                    if (d4 == 0 && a(d5, d6, this.g)) {
                                        i.a(q5, (q)b.b(d6));
                                    }
                                    ++n5;
                                    if (x) {
                                        break;
                                    }
                                }
                            }
                            ++n4;
                        }
                        break;
                    } while (!x);
                    final f f2 = new f();
                    final x a4 = y.a.k.b(i).a();
                    while (a4.f()) {
                        final d d7 = (d)a.b(a4.e());
                        final aX a5 = this.g.a(d7.c());
                        final aX a6 = this.g.a(d7.d());
                        if (!this.e() || (a5.b() != 6 && a6.b() != 7)) {
                            f2.add(d7);
                        }
                        a4.g();
                        if (x) {
                            break;
                        }
                    }
                    return f2;
                }
                break;
            } while (!x);
            x2 = y2.a();
            continue Label_0405;
        }
    }
    
    private static boolean a(final d d, final d d2, final aV av) {
        final aX a = av.a(d.c());
        final aX a2 = av.a(d2.c());
        final aX a3 = av.a(d.d());
        final aX a4 = av.a(d2.d());
        if (a.j() != a2.j() || a3.j() != a4.j()) {
            throw new RuntimeException("wrong input");
        }
        return (a.k() < a2.k() && a3.k() > a4.k()) || (a.k() > a2.k() && a3.k() < a4.k());
    }
    
    private void a(final X x, final aU au, final aV av, final int n, final int[] array, final q[] array2) {
        final boolean x2 = N.x;
        if (!this.n) {
            return;
        }
        int i = 0;
    Label_0487_Outer:
        while (i < au.b()) {
            final aQ a = au.a(i);
            p p6 = null;
            int n2 = 0;
            p p7 = a.d().k();
            while (true) {
                while (p7 != null) {
                    final q q = (q)p7.c();
                    final int a2 = this.a(x, av, q, false) ? 1 : 0;
                    if (!x2) {
                        if (a2 != 0) {
                            final int n3 = (int)Math.rint(x.j(q) * 2520.0) - (n + array[array2[q.d()].d()]);
                            Label_0469: {
                                if (n3 != 0 || n2 != 0) {
                                    Label_0446: {
                                        Label_0206: {
                                            if (p6 == null) {
                                                if (n3 < 0) {
                                                    p p8 = a.d().k();
                                                    while (p8 != p7) {
                                                        final int d = array2[((q)p8.c()).d()].d();
                                                        array[d] += n3;
                                                        p8 = p8.a();
                                                        if (x2) {
                                                            break Label_0469;
                                                        }
                                                        if (x2) {
                                                            break Label_0206;
                                                        }
                                                    }
                                                }
                                                break Label_0446;
                                            }
                                        }
                                        final int n4 = n3 - n2;
                                        Label_0372: {
                                            if (n4 < 0) {
                                                int n5 = 1;
                                                final int n6 = array[array2[((q)p6.c()).d()].d()] - n2;
                                                final int n7 = array[array2[q.d()].d()];
                                                p p9 = p6.a();
                                                while (p9 != p7) {
                                                    final q q2 = (q)p9.c();
                                                    array[array2[q2.d()].d()] = n6 + n2 + (int)Math.rint((array[array2[q2.d()].d()] - n6) / (n7 - n6) * (n7 + n3 - (n6 + n2)));
                                                    p9 = p9.a();
                                                    ++n5;
                                                    if (x2) {
                                                        break Label_0469;
                                                    }
                                                    if (x2) {
                                                        break Label_0372;
                                                    }
                                                }
                                                break Label_0446;
                                            }
                                        }
                                        if (n2 > 0) {
                                            final int n8 = n2 + n4 / 2;
                                            p p10 = p6.a();
                                            while (p10 != p7) {
                                                final int d2 = array2[((q)p10.c()).d()].d();
                                                array[d2] += n8;
                                                p10 = p10.a();
                                                if (x2) {
                                                    break Label_0469;
                                                }
                                                if (x2) {
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    final int d3 = array2[q.d()].d();
                                    array[d3] += n3;
                                }
                                n2 = n3;
                            }
                            p6 = p7;
                        }
                        p7 = p7.a();
                        if (x2) {
                            break;
                        }
                        continue Label_0487_Outer;
                    }
                    else {
                        Label_0556: {
                            if (a2 > 0 && p6 != null) {
                                p p11 = p6.a();
                                while (p11 != null) {
                                    final int d4 = array2[((q)p11.c()).d()].d();
                                    array[d4] += n2;
                                    p11 = p11.a();
                                    if (x2) {
                                        break Label_0556;
                                    }
                                    if (x2) {
                                        break;
                                    }
                                }
                            }
                            ++i;
                        }
                        if (x2) {
                            break Label_0487_Outer;
                        }
                        continue Label_0487_Outer;
                    }
                }
                continue;
            }
        }
    }
    
    private void a(final q q, final q q2, final double n, final double n2, final i i, final h h, final h h2) {
        this.a(q, q2, n, (int)Math.rint(n2), i, h, h2);
    }
    
    private d a(final q q, final q q2, final double n, final int n2, final i i, final h h, final h h2) {
        final d a = i.a(q, q2);
        h.a(a, n2);
        if (n > 0.0) {
            h2.a(a, (int)Math.ceil(2520.0 * n));
            if (!N.x) {
                return a;
            }
        }
        h2.a(a, 0);
        return a;
    }
    
    protected double a(final X x, final aQ aq, final q q, final q q2) {
        if (this.n && q != null && q2 != null && this.a(x, this.g, q, false) && this.a(x, this.g, q2, false)) {
            return 0.0;
        }
        if (this.a != null) {
            final double a = this.a.a(x, aq, this.g, q, q2);
            if (a >= 0.0) {
                return a;
            }
        }
        return 0.0;
    }
    
    public boolean f() {
        return this.s;
    }
    
    private void a(final d d, final X x, final aV av, final double n, final boolean b) {
        final boolean x2 = N.x;
        if (a(av.a(d), false)) {
            D d2 = this.a(d.c(), av, x);
            final D d3 = new D();
            final D d4 = new D();
            boolean b2 = false;
            final C m = d2.m();
            while (m.f()) {
                final bF bf = (bF)m.d();
                if (x2) {
                    return;
                }
                Label_0161: {
                    if (bf.a(d)) {
                        b2 = true;
                        bf.c(new t(0.0, bf.g().b));
                        if (!x2) {
                            break Label_0161;
                        }
                    }
                    if (!b2) {
                        d3.add(bf);
                        if (!x2) {
                            break Label_0161;
                        }
                    }
                    d4.add(bf);
                }
                m.g();
                if (x2) {
                    break;
                }
            }
            final double n2 = x.p(d.c()) / 2.0;
            final double n3 = n2 / ((b ? Math.max(d3.size(), d4.size()) : d3.size()) + n);
            double n4 = 0.0;
            d3.n();
            final C i = d3.m();
        Label_0335_Outer:
            while (true) {
                while (true) {
                    while (i.f()) {
                        final bF bf2 = (bF)i.d();
                        n4 -= n3;
                        bf2.c(new t(n4, bf2.g().b));
                        i.g();
                        if (x2) {
                            final int n5 = d4.size();
                            final double n6 = n2 / (n5 + n);
                            double n7 = 0.0;
                            final C j = d4.m();
                            while (true) {
                                while (j.f()) {
                                    final bF bf3 = (bF)j.d();
                                    n7 += n6;
                                    bf3.c(new t(n7, bf3.g().b));
                                    j.g();
                                    if (!x2) {
                                        if (x2) {
                                            break;
                                        }
                                        continue Label_0335_Outer;
                                    }
                                    else {
                                        final f f = new f();
                                        final f f2 = new f();
                                        boolean b3 = false;
                                        final C k = d2.m();
                                        while (k.f()) {
                                            final bF bf4 = (bF)k.d();
                                            if (x2) {
                                                return;
                                            }
                                            Label_0564: {
                                                if (bf4.a(d)) {
                                                    b3 = true;
                                                    bf4.d(new t(0.0, bf4.h().b));
                                                    if (!x2) {
                                                        break Label_0564;
                                                    }
                                                }
                                                if (!b3) {
                                                    f.add(bf4);
                                                    if (!x2) {
                                                        break Label_0564;
                                                    }
                                                }
                                                f2.add(bf4);
                                            }
                                            k.g();
                                            if (x2) {
                                                break;
                                            }
                                        }
                                        final double n8 = x.p(d.d()) / 2.0;
                                        final double n9 = n8 / ((b ? Math.max(f.size(), f2.size()) : f.size()) + n);
                                        double n10 = 0.0;
                                        f.n();
                                        final C l = f.m();
                                    Label_0738_Outer:
                                        while (true) {
                                            while (true) {
                                                while (l.f()) {
                                                    final bF bf5 = (bF)l.d();
                                                    n10 -= n9;
                                                    bf5.d(new t(n10, bf5.h().b));
                                                    l.g();
                                                    if (x2) {
                                                        final int n11 = f2.size();
                                                        final double n12 = n8 / (n11 + n);
                                                        double n13 = 0.0;
                                                        final C m2 = f2.m();
                                                        while (m2.f()) {
                                                            final bF bf6 = (bF)m2.d();
                                                            n13 += n12;
                                                            bf6.d(new t(n13, bf6.h().b));
                                                            m2.g();
                                                            if (x2) {
                                                                break;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    if (x2) {
                                                        break;
                                                    }
                                                }
                                                if (b) {
                                                    final int n11 = Math.max(f.size(), f2.size());
                                                    continue;
                                                }
                                                break;
                                            }
                                            continue Label_0738_Outer;
                                        }
                                    }
                                }
                                d2 = this.b(d.d(), av, x);
                                continue;
                            }
                        }
                        if (x2) {
                            break;
                        }
                    }
                    if (b) {
                        final int n5 = Math.max(d3.size(), d4.size());
                        continue;
                    }
                    break;
                }
                continue Label_0335_Outer;
            }
        }
    }
    
    private void a(final q q, final X x, final aV av, final double n, final boolean b) {
        final boolean x2 = N.x;
        final double m = x.m(q);
        final double n2 = m + x.p(q);
        Label_0308: {
            if (b) {
                final D a = this.a(q, av, x);
                final D d = new D();
                double a2 = m;
                final D d2 = new D();
                D d3 = new D();
                int size = a.size();
                final C i = a.m();
                while (true) {
                    while (i.f()) {
                        final bF bf = (bF)i.d();
                        --size;
                        final double a3 = bf.f().a;
                        final boolean a4 = a(bf, x, true);
                        if (!x2) {
                            Label_0248: {
                                if (a4 && a3 > a2 && a3 - a2 > 3.0 * (d3.size() + 1) && n2 - a3 > 3.0 * (size + 1)) {
                                    a2 = bf.f().a;
                                    bf.a(new t(a2, bf.e().b));
                                    d.add(bf);
                                    d2.add(d3);
                                    d3 = new D();
                                    if (!x2) {
                                        break Label_0248;
                                    }
                                }
                                d3.add(bf);
                            }
                            i.g();
                            if (x2) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (a4) {
                                return;
                            }
                            d2.add(d3);
                            this.a((bF[])d.toArray(new bF[d.size()]), d2, x, true, n, false);
                            if (x2) {
                                break Label_0308;
                            }
                            return;
                        }
                    }
                    d.isEmpty();
                    continue;
                }
            }
        }
        final D b2 = this.b(q, av, x);
        final D d4 = new D();
        double a5 = m;
        final D d5 = new D();
        D d6 = new f();
        int size2 = b2.size();
        final C j = b2.m();
        while (true) {
            while (j.f()) {
                final bF bf2 = (bF)j.d();
                --size2;
                final double a6 = bf2.e().a;
                final boolean a7 = a(bf2, x, false);
                if (!x2) {
                    Label_0529: {
                        if (a7 && a6 > a5 && a6 - a5 > 3.0 * (d6.size() + 1) && n2 - a6 > 3.0 * (size2 + 1)) {
                            a5 = bf2.e().a;
                            bf2.b(new t(a5, bf2.f().b));
                            d4.add(bf2);
                            d5.add(d6);
                            d6 = new D();
                            if (!x2) {
                                break Label_0529;
                            }
                        }
                        d6.add(bf2);
                    }
                    j.g();
                    if (x2) {
                        break;
                    }
                    continue;
                }
                else {
                    if (!a7) {
                        d5.add(d6);
                        this.a((bF[])d4.toArray(new bF[d4.size()]), d5, x, false, n, false);
                    }
                    return;
                }
            }
            d4.isEmpty();
            continue;
        }
    }
    
    private static boolean a(final bF bf, final X x, final boolean b) {
        if (b) {
            final y.d.y s = x.s(bf.a());
            final double a = bf.f().a;
            return (bf.c() == null || (!bf.c().a() && bf.c().d())) && a > s.c() && a < s.c() + s.a();
        }
        final y.d.y s2 = x.s(bf.b());
        final double a2 = bf.e().a;
        return (bf.d() == null || (!bf.d().a() && bf.d().c())) && a2 > s2.c() && a2 < s2.c() + s2.a();
    }
    
    private void a(final bF[] array, final D d, final X x, final boolean b, final double n, final boolean b2) {
        final boolean x2 = N.x;
        if (array == null || array.length == 0) {
            return;
        }
        int max = 0;
        C c = null;
        Label_0086: {
            if (b2) {
                c = d.m();
                while (c.f()) {
                    max = Math.max(max, ((D)c.d()).size());
                    c.g();
                    if (x2) {
                        break Label_0086;
                    }
                    if (x2) {
                        break;
                    }
                }
            }
            c = d.m();
        }
        double n2 = b ? x.m(array[0].a()) : x.m(array[0].b());
        int n3 = 0;
        while (true) {
            do {
                int i = 0;
                Label_0119: {
                    i = n3;
                }
                Label_0121:
                while (i < array.length) {
                    final Object d2;
                    final bF bf = (bF)(d2 = array[n3]);
                    if (!x2) {
                        final bF bf2 = bf;
                        final double n4 = b ? bf2.e().a : bf2.f().a;
                        final D d3 = (D)c.d();
                        if (!d3.isEmpty()) {
                            final int n5 = b2 ? max : d3.size();
                            final double n6 = (n4 - n2) / ((n3 == 0) ? (n5 + n) : (n5 + 1));
                            d3.n();
                            double n7 = n4;
                            final C m = d3.m();
                            while (m.f()) {
                                final bF bf3 = (bF)m.d();
                                n7 -= n6;
                                i = (b ? 1 : 0);
                                if (x2) {
                                    continue Label_0121;
                                }
                                Label_0335: {
                                    if (b) {
                                        bf3.a(new t(n7, bf3.e().b));
                                        if (!x2) {
                                            break Label_0335;
                                        }
                                    }
                                    bf3.b(new t(n7, bf3.f().b));
                                }
                                m.g();
                                if (x2) {
                                    break;
                                }
                            }
                        }
                        n2 = n4;
                        c.g();
                        ++n3;
                        continue Label_0119;
                    }
                    final D d4 = (D)d2;
                    if (!d4.isEmpty()) {
                        final bF bf4 = array[array.length - 1];
                        final double n8 = ((b ? (x.m(bf4.a()) + x.p(bf4.a())) : (x.m(bf4.b()) + x.p(bf4.b()))) - n2) / ((b2 ? max : d4.size()) + n);
                        double n9 = n2;
                        final C j = d4.m();
                        while (j.f()) {
                            final bF bf5 = (bF)j.d();
                            n9 += n8;
                            Label_0567: {
                                if (b) {
                                    bf5.a(new t(n9, bf5.e().b));
                                    if (!x2) {
                                        break Label_0567;
                                    }
                                }
                                bf5.b(new t(n9, bf5.f().b));
                            }
                            j.g();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    return;
                }
                break;
            } while (!x2);
            Object d2 = c.d();
            continue;
        }
    }
    
    private static boolean a(final y.f.c.a.A a, final boolean b) {
        return (a.c() == null || ((!a.c().a() || b) && a.c().d())) && (a.e() == null || ((!a.e().a() || b) && a.e().c()));
    }
    
    private D a(final q q, final aV av, final X x) {
        final boolean x2 = N.x;
        final D d = new D();
        final e l = q.l();
        while (true) {
            while (l.f()) {
                final d a = l.a();
                final aV av2 = av;
                if (x2) {
                    final aX a2 = av2.a(q);
                    if (a2.e() > 0) {
                        p p3 = a2.d();
                        while (p3 != null) {
                            final d d2 = (d)p3.c();
                            final y.f.c.a.A a3 = av.a(d2);
                            if (x2) {
                                return d;
                            }
                            Label_0301: {
                                if (d2.c() == q && a3.c() != null && !a3.c().a() && a3.c().b() == 2) {
                                    d.add(new bF(d2, x, av, false, null));
                                    if (!x2) {
                                        break Label_0301;
                                    }
                                }
                                if (d2.d() == q && a3.e() != null && !a3.e().a() && a3.e().b() == 2) {
                                    d.add(new bF(d2, x, av, true, null));
                                }
                            }
                            p3 = p3.a();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    d.sort(new bC(this));
                    return d;
                }
                final y.f.c.a.A a4 = av.a(a);
                if (a4.c() == null || !a4.c().a()) {
                    d.add(new bF(a, x, av, false, null));
                }
                l.g();
                if (x2) {
                    break;
                }
            }
            final aV av2 = av;
            continue;
        }
    }
    
    private D b(final q q, final aV av, final X x) {
        final boolean x2 = N.x;
        final f f = new f();
        final e k = q.k();
        while (true) {
            while (k.f()) {
                final d a = k.a();
                final aV av2 = av;
                if (x2) {
                    final aX a2 = av2.a(q);
                    if (a2.e() > 0) {
                        p p3 = a2.d();
                        while (p3 != null) {
                            final d d = (d)p3.c();
                            final y.f.c.a.A a3 = av.a(d);
                            if (x2) {
                                return f;
                            }
                            Label_0301: {
                                if (d.d() == q && a3.e() != null && !a3.e().a() && a3.e().b() == 1) {
                                    f.add(new bF(d, x, av, false, null));
                                    if (!x2) {
                                        break Label_0301;
                                    }
                                }
                                if (d.c() == q && a3.c() != null && !a3.c().a() && a3.c().b() == 1) {
                                    f.add(new bF(d, x, av, true, null));
                                }
                            }
                            p3 = p3.a();
                            if (x2) {
                                break;
                            }
                        }
                    }
                    f.sort(new bD(this));
                    return f;
                }
                final y.f.c.a.A a4 = av.a(a);
                if (a4.e() == null || !a4.e().a()) {
                    f.add(new bF(a, x, av, false, null));
                }
                k.g();
                if (x2) {
                    break;
                }
            }
            final aV av2 = av;
            continue;
        }
    }
    
    private void a(final X x, final aU au, final aV av, final h h, final c c) {
        final boolean x2 = N.x;
        final int[] array = new int[x.f()];
        final int b = au.b();
        int n = 0;
        final x a = au.a(0).d().a();
        while (a.f()) {
            array[a.e().d()] = n++;
            a.g();
            if (x2) {
                break;
            }
        }
        int i = 1;
    Label_0321:
        while (i < b) {
            final D d = new D();
            int n2 = 0;
            final x a2 = au.a(i).d().a();
            while (true) {
                do {
                    double f = 0.0;
                    Label_0121: {
                        f = (a2.f() ? 1 : 0);
                    }
                    Label_0128:
                    while (f != 0) {
                        final q e = a2.e();
                        array[e.d()] = n2++;
                        if (!x2) {
                            final e k = e.k();
                            while (k.f()) {
                                final d a3 = k.a();
                                final y.f.c.a.A a4 = av.a(a3);
                                h.a(a3, false);
                                final double n3 = this.a(x, a3, av, c);
                                final double n4 = f = dcmpl(n3, 0.0);
                                if (x2) {
                                    continue Label_0128;
                                }
                                if (n4 > 0 && a(a4, true)) {
                                    d.add(new bJ(array[a3.c().d()], array[a3.d().d()], a3, n3));
                                }
                                k.g();
                                if (x2) {
                                    break;
                                }
                            }
                            a2.g();
                            continue Label_0121;
                        }
                        if (x2) {
                            break Label_0321;
                        }
                        continue Label_0321;
                    }
                    break;
                } while (!x2);
                this.a(d, h);
                ++i;
                continue;
            }
        }
    }
    
    private int a(final X x, final d d, final aV av, final c c) {
        final y.f.c.a.A a = av.a(d);
        final d d2 = (a.b() != null) ? a.b() : d;
        final c c2 = x.c(M.n);
        final int n = (c != null && c.b(d.d()) == d.c()) ? 1 : 0;
        if (c2 != null) {
            return c2.a(d2) + n;
        }
        if (n != 0) {
            return 1;
        }
        return 0;
    }
    
    private void a(final D d, final h h) {
        final boolean x = N.x;
        final i i = new i();
        final A a = y.g.M.a();
        final C m = d.m();
        while (m.f()) {
            final bJ bj = (bJ)m.d();
            a.a(bj.f = i.d(), bj);
            m.g();
            if (x) {
                break;
            }
        }
        final D d2 = new D(d);
        d2.sort(new bH(null));
        final C j = d.m();
        while (true) {
            while (j.f()) {
                final bJ bj2 = (bJ)j.d();
                final D d3 = d2;
                bJ bj4 = null;
                Label_0279: {
                    if (!x) {
                        final C k = d3.m();
                        while (k.f()) {
                            final bJ bj3 = bj4 = (bJ)k.d();
                            if (x) {
                                break Label_0279;
                            }
                            if (bj4 != bj2) {
                                if (bj3.b > bj2.b) {
                                    break;
                                }
                                if (a(bj2, bj3) && !i.b(bj3.f, bj2.f)) {
                                    i.a(bj2.f, bj3.f);
                                }
                            }
                            k.g();
                            if (x) {
                                break;
                            }
                        }
                        j.g();
                        if (x) {
                            break;
                        }
                        continue;
                    }
                    else {
                        d3.sort(new bE(null));
                        this.a(d2);
                    }
                }
                bJ a2 = bj4;
            Label_0390_Outer:
                while (a2 != null) {
                    h.a(a2.e, true);
                    final x l = a2.f.m();
                    while (true) {
                        while (l.f()) {
                            final bJ bj5 = (bJ)a.b(l.e());
                            i.a(bj5.f);
                            bj5.f = null;
                            l.g();
                            if (!x) {
                                if (x) {
                                    break;
                                }
                                continue Label_0390_Outer;
                            }
                            else {
                                if (x) {
                                    break Label_0390_Outer;
                                }
                                continue Label_0390_Outer;
                            }
                        }
                        i.a(a2.f);
                        a2 = this.a(d2);
                        continue;
                    }
                }
                return;
            }
            continue;
        }
    }
    
    private bJ a(final D d) {
        final boolean x = N.x;
        double c = -1.7976931348623157E308;
        int a = Integer.MAX_VALUE;
        p p = null;
        p p2 = d.k();
        while (p2 != null) {
            final bJ bj = (bJ)p2.c();
            final Object o;
            final q q = (q)(o = bj.f);
            if (x) {
                return (bJ)o;
            }
            if (q != null) {
                if (bj.c < c) {
                    break;
                }
                if (bj.f.a() < a) {
                    c = bj.c;
                    a = bj.f.a();
                    p = p2;
                }
            }
            p2 = p2.a();
            if (x) {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        Object o = d.h(p);
        return (bJ)o;
    }
    
    private static boolean a(final bJ bj, final bJ bj2) {
        return bj.a == bj2.a || bj.b == bj2.b || (bj.a > bj2.a && bj.b < bj2.b) || (bj.a < bj2.a && bj.b > bj2.b);
    }
    
    static aV a(final by by) {
        return by.g;
    }
}
