package y.f.e;

import java.awt.*;
import java.util.*;
import y.g.*;
import y.f.*;
import y.c.*;
import y.d.*;

public class l implements ad
{
    public static final Object a;
    public static final Object b;
    private ah c;
    private double d;
    private boolean e;
    private byte f;
    private Rectangle[] g;
    private int[] h;
    private int[] i;
    private q[] n;
    private Comparator o;
    private boolean p;
    private c q;
    private boolean r;
    
    public l() {
        this.r = true;
        this.d = 5.0;
        this.e = false;
        this.f = 2;
    }
    
    public void c(final X x) {
        if (this.c != null) {
            this.c.c(x);
        }
        if (x.e() > 0) {
            this.a(x);
        }
    }
    
    public void a(final ah c) {
        this.c = c;
    }
    
    public ah a() {
        return this.c;
    }
    
    public void a(final byte f) {
        this.f = f;
    }
    
    public void a(final double d) {
        if (d < 0.0) {
            throw new IllegalArgumentException("Minimal distance must be non-negative");
        }
        this.d = d;
    }
    
    public double b() {
        return this.d;
    }
    
    public void a(final boolean e) {
        this.e = e;
    }
    
    public boolean c() {
        return this.e;
    }
    
    private void a(final X x) {
        final boolean b = y.f.e.i.b;
        this.n = x.m();
        this.g = new Rectangle[x.e()];
        final double[] array = new double[x.e() * 2];
        final double[] array2 = new double[x.e() * 2];
        this.q = x.c(l.b);
        final c c = x.c(l.a);
        final double b2 = this.b();
        Label_1103: {
            boolean b3 = false;
            Label_0975: {
                Label_0974: {
                    c c2 = null;
                    Label_0967: {
                        Label_0517: {
                            Label_0505: {
                                Label_0341: {
                                    if (b2 != 0.0 || c != null) {
                                        double n = b2 * 0.5;
                                        int i = this.n.length - 1;
                                        while (i >= 0) {
                                            c2 = c;
                                            if (b) {
                                                break Label_0967;
                                            }
                                            Label_0156: {
                                                if (c2 != null) {
                                                    final double c3 = c.c(this.n[i]);
                                                    if (c3 > 0.0) {
                                                        n = c3 * 0.5;
                                                        if (!b) {
                                                            break Label_0156;
                                                        }
                                                    }
                                                    n = b2 * 0.5;
                                                }
                                            }
                                            final am a = x.a((Object)this.n[i]);
                                            array[i << 1] = a.getWidth();
                                            array[(i << 1) + 1] = a.getHeight();
                                            array2[i << 1] = a.getX();
                                            array2[(i << 1) + 1] = a.getY();
                                            final int n2 = (int)Math.floor(a.getX() - n);
                                            final int n3 = (int)Math.floor(a.getY() - n);
                                            this.g[i] = new Rectangle(n2, n3, (int)Math.ceil(a.getX() + a.getWidth() + n) - n2, (int)Math.ceil(a.getY() + a.getHeight() + n) - n3);
                                            --i;
                                            if (b) {
                                                break Label_0341;
                                            }
                                        }
                                        break Label_0505;
                                    }
                                }
                                int j = this.n.length - 1;
                                while (j >= 0) {
                                    final am a2 = x.a((Object)this.n[j]);
                                    array[j << 1] = a2.getWidth();
                                    array[(j << 1) + 1] = a2.getHeight();
                                    final int n4 = (int)Math.floor(a2.getX());
                                    final int n5 = (int)Math.floor(a2.getY());
                                    this.g[j] = new Rectangle(n4, n5, (int)Math.ceil(a2.getX() + a2.getWidth()) - n4, (int)Math.ceil(a2.getY() + a2.getHeight()) - n5);
                                    --j;
                                    if (b) {
                                        break Label_0517;
                                    }
                                    if (b) {
                                        break;
                                    }
                                }
                            }
                            this.o = new n(this);
                        }
                        if (this.c()) {
                            if (this.p) {
                                final int[] array3 = new int[this.g.length];
                                final int[] array4 = new int[this.g.length];
                                final int[] array5 = new int[this.g.length];
                                final int[] array6 = new int[this.g.length];
                                this.a(this.g, array3, array4);
                                y.g.e.a(this.n, this.o);
                                this.h();
                                this.a(this.g, array5, array6);
                                this.b(array3, array4, this.g);
                                this.g();
                                this.a(this.n);
                                this.h();
                                this.g();
                                this.a(array5, array6, this.g);
                                if (!b) {
                                    break Label_1103;
                                }
                            }
                            y.g.e.a(this.n, this.o);
                            this.h();
                            if (!b) {
                                break Label_1103;
                            }
                        }
                        if (this.p) {
                            final int[] array7 = new int[this.g.length];
                            final int[] array8 = new int[this.g.length];
                            final int[] array9 = new int[this.g.length];
                            final int[] array10 = new int[this.g.length];
                            this.a(this.g);
                            this.e();
                            this.a(this.g, array7, array8);
                            y.g.e.a(this.n, this.o);
                            this.h();
                            this.a(this.g, array9, array10);
                            this.b(array7, array8, this.g);
                            this.g();
                            this.a(this.n);
                            this.h();
                            this.g();
                            this.a(array9, array10, this.g);
                            this.d();
                            this.a(this.g);
                            this.f();
                            this.a(this.g, array7, array8);
                            y.g.e.a(this.n, this.o);
                            this.h();
                            this.a(this.g, array9, array10);
                            this.b(array7, array8, this.g);
                            this.g();
                            this.a(this.n);
                            this.h();
                            this.g();
                            this.a(array9, array10, this.g);
                            this.f();
                            this.b(this.g);
                            this.b(this.g);
                            if (!b) {
                                break Label_1103;
                            }
                        }
                        this.e();
                        y.g.e.a(this.n, this.o);
                        this.h();
                        if (!this.r) {
                            break Label_0974;
                        }
                        final c q = this.q;
                    }
                    if (c2 != null) {
                        b3 = true;
                        break Label_0975;
                    }
                }
                b3 = false;
            }
            final boolean b4 = b3;
            if (b4) {
                this.g();
                y.g.e.a(this.n, this.o);
                this.h();
                this.g();
            }
            this.d();
            this.f();
            y.g.e.a(this.n, this.o);
            this.h();
            if (b4) {
                this.g();
                y.g.e.a(this.n, this.o);
                this.h();
                this.g();
            }
            this.f();
            if (b4) {
                y.g.e.a(this.n, this.o);
                this.h();
                this.g();
                y.g.e.a(this.n, this.o);
                this.h();
                this.g();
            }
        }
        int k = this.n.length - 1;
        while (k >= 0) {
            final q q2 = this.n[k];
            final int d = q2.d();
            x.b(q2, array[d << 1], array[(d << 1) + 1]);
            x.a(q2, this.g[d].x + this.g[d].width * 0.5, this.g[d].y + this.g[d].height * 0.5);
            --k;
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        this.n = null;
        this.g = null;
        this.q = null;
    }
    
    private void a(final Object[] array) {
        final boolean b = y.f.e.i.b;
        int i = (array.length - 1) / 2;
        while (i >= 0) {
            final Object o = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = o;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void d() {
        final boolean b = y.f.e.i.b;
        int i = this.n.length - 1;
        while (i >= 0) {
            this.g[i].width = this.h[i];
            this.g[i].x = this.i[i];
            --i;
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        this.h = null;
        this.i = null;
    }
    
    private void a(final Rectangle[] array) {
        final boolean b = y.f.e.i.b;
        int i = array.length - 1;
        while (i >= 0) {
            final Rectangle rectangle = array[i];
            rectangle.x <<= 1;
            final Rectangle rectangle2 = array[i];
            rectangle2.y <<= 1;
            final Rectangle rectangle3 = array[i];
            rectangle3.width <<= 1;
            final Rectangle rectangle4 = array[i];
            rectangle4.height <<= 1;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void b(final Rectangle[] array) {
        final boolean b = y.f.e.i.b;
        int i = array.length - 1;
        while (i >= 0) {
            final Rectangle rectangle = array[i];
            rectangle.x >>= 1;
            final Rectangle rectangle2 = array[i];
            rectangle2.y >>= 1;
            final Rectangle rectangle3 = array[i];
            rectangle3.width >>= 1;
            final Rectangle rectangle4 = array[i];
            rectangle4.height >>= 1;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void e() {
        final boolean b = y.f.e.i.b;
        this.h = new int[this.g.length];
        this.i = new int[this.g.length];
        y.g.e.a(this.n, this.o);
        final D d = new D();
        int i = this.n.length - 1;
        while (i >= 0) {
            this.h[i] = this.g[i].width;
            this.i[i] = this.g[i].x;
            d.add(new o(this.g[i]));
            --i;
            if (b) {
                return;
            }
            if (b) {
                break;
            }
        }
        y.d.f.a(d, new m(this));
    }
    
    private void f() {
        final boolean b = y.f.e.i.b;
        int i = this.g.length - 1;
        while (i >= 0) {
            final Rectangle rectangle = this.g[i];
            final int x = rectangle.x;
            final int y = rectangle.y;
            final int width = rectangle.width;
            final int height = rectangle.height;
            rectangle.x = y;
            rectangle.y = x;
            rectangle.width = height;
            rectangle.height = width;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void a(final int[] array, final int[] array2, final Rectangle[] array3) {
        final boolean b = y.f.e.i.b;
        int i = array3.length - 1;
        while (i >= 0) {
            array3[i].x = array3[i].x + array[i] >> 1;
            array3[i].y = array3[i].y + array2[i] >> 1;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void a(final Rectangle[] array, final int[] array2, final int[] array3) {
        final boolean b = y.f.e.i.b;
        int i = array.length - 1;
        while (i >= 0) {
            array2[i] = array[i].x;
            array3[i] = array[i].y;
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void b(final int[] array, final int[] array2, final Rectangle[] array3) {
        final boolean b = y.f.e.i.b;
        int i = array3.length - 1;
        while (i >= 0) {
            array3[i].x = array[i];
            array3[i].y = array2[i];
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void g() {
        final boolean b = y.f.e.i.b;
        int i = this.g.length - 1;
        while (i >= 0) {
            final Rectangle rectangle = this.g[i];
            rectangle.y = -(rectangle.y + rectangle.height);
            --i;
            if (b) {
                break;
            }
        }
    }
    
    private void h() {
        final boolean b = y.f.e.i.b;
        int x;
        int y = x = Integer.MAX_VALUE;
        int n2;
        int n = n2 = Integer.MIN_VALUE;
        int i = this.g.length - 1;
        while (true) {
            while (i >= 0) {
                final Rectangle rectangle2;
                final Rectangle rectangle = rectangle2 = this.g[i];
                if (b) {
                    final Rectangle rectangle3 = rectangle2;
                    final D d = new D();
                    d.add(new p(rectangle3.y, rectangle3.x - 10, rectangle3.x + rectangle3.width + 10));
                    int n3 = 0;
                    do {
                        Label_0212: {
                            final int length = this.n.length;
                        }
                        int j = 0;
                        int c = 0;
                        Rectangle rectangle4;
                        int y2;
                        int x2;
                        int n4;
                        y.c.p p;
                        y.c.p p2;
                        int n5;
                        y.c.p p3;
                        p p4;
                        p p5;
                        int n6;
                        int c2;
                        int a;
                        p p6;
                        p p7;
                        p p8;
                        p p9;
                        y.c.p a2;
                        y.c.p a3;
                        p p10;
                        int a4;
                        int n7;
                        int c3;
                        int b2;
                        int max;
                        int n8;
                        p p11;
                        p p12;
                        p p13;
                        y.c.p p14;
                        Label_0219:
                        Label_0831_Outer:Label_1127_Outer:
                        while (j < c) {
                            rectangle4 = this.g[this.n[n3].d()];
                            y2 = rectangle4.y;
                            x2 = rectangle4.x;
                            n4 = rectangle4.x + rectangle4.width;
                            p = null;
                            p2 = null;
                            n5 = rectangle3.y;
                            for (p3 = d.k(); p3 != null; p3 = p3.a()) {
                                p4 = (p)p3.c();
                                j = x2;
                                c = p4.c;
                                if (b) {
                                    continue Label_0219;
                                }
                                if (j < c) {
                                    p = p3;
                                    n5 = Math.max(n5, p4.a);
                                    break;
                                }
                            }
                            while (p3 != null) {
                                p5 = (p)p3.c();
                                n5 = Math.max(n5, p5.a);
                                n6 = n4;
                                c2 = p5.c;
                                if (b) {
                                    continue Label_0219;
                                }
                                if (n6 <= c2) {
                                    p2 = p3;
                                    break;
                                }
                                p3 = p3.a();
                            }
                            Label_1169: {
                                Label_0868: {
                                    if (this.a(this.n[n3]) && n5 > y2) {
                                        a = y2 + rectangle4.height;
                                        p6 = new p(a, x2, n4);
                                        p7 = (p)p.c();
                                        p8 = (p)p2.c();
                                        if (p == p2) {
                                            if (p7.a >= p6.a) {
                                                break Label_1169;
                                            }
                                            if (p7.b == x2 && p7.c == n4) {
                                                p.a(p6);
                                                if (!b) {
                                                    break Label_1169;
                                                }
                                            }
                                            p8 = new p(p7.a, n4, p7.c);
                                            p7.c = x2;
                                            p2 = d.b(p8, p);
                                            d.b(p6, p);
                                            if (p7.c == p7.b) {
                                                d.h(p);
                                            }
                                            if (p8.c != p8.b) {
                                                break Label_1169;
                                            }
                                            d.h(p2);
                                            if (!b) {
                                                break Label_1169;
                                            }
                                        }
                                        p9 = p7;
                                        a2 = p.a();
                                        if (p7.a < p6.a) {
                                            d.b(p9 = new p(a, x2, p7.c), p);
                                            p7.c = x2;
                                        }
                                        if (p8.a < p6.a) {
                                            d.a(new p(a, p8.b, n4), p2);
                                            p8.b = n4;
                                        }
                                        a3 = a2;
                                        while (true) {
                                            while (a3 != p2) {
                                                p10 = (p)a3.c();
                                                a4 = p10.a;
                                                n7 = a;
                                                if (!b) {
                                                    Label_0809: {
                                                        if (a4 > n7) {
                                                            p9 = p10;
                                                            if (!b) {
                                                                break Label_0809;
                                                            }
                                                        }
                                                        if (p9.a == (p10.a = a)) {
                                                            d.h(a3);
                                                            p9.c = p10.c;
                                                            if (!b) {
                                                                break Label_0809;
                                                            }
                                                        }
                                                        p9 = p10;
                                                    }
                                                    a3 = a3.a();
                                                    if (b) {
                                                        break;
                                                    }
                                                    continue Label_0831_Outer;
                                                }
                                                else {
                                                    if (a4 == n7) {
                                                        d.h(p);
                                                    }
                                                    if (p8.c != p8.b) {
                                                        break Label_1169;
                                                    }
                                                    d.h(p2);
                                                    if (b) {
                                                        break Label_0868;
                                                    }
                                                    break Label_1169;
                                                }
                                            }
                                            c3 = p7.c;
                                            b2 = p7.b;
                                            continue Label_1127_Outer;
                                        }
                                    }
                                }
                                max = Math.max(y2, n5);
                                n8 = max + rectangle4.height;
                                rectangle4.y = max;
                                p11 = new p(n8, x2, n4);
                                p12 = (p)p.c();
                                p13 = (p)p2.c();
                                if (p == p2) {
                                    if (p12.b == x2 && p12.c == n4) {
                                        p.a(p11);
                                        if (!b) {
                                            break Label_1169;
                                        }
                                    }
                                    p13 = new p(p12.a, n4, p12.c);
                                    p12.c = x2;
                                    p2 = d.b(p13, p);
                                    d.b(p11, p);
                                    if (p12.c == p12.b) {
                                        d.h(p);
                                    }
                                    if (p13.c != p13.b) {
                                        break Label_1169;
                                    }
                                    d.h(p2);
                                    if (!b) {
                                        break Label_1169;
                                    }
                                }
                                p12.c = x2;
                                p13.b = n4;
                                p14 = p.a();
                                while (true) {
                                    while (p14 != p2) {
                                        d.h(p14);
                                        p14 = p14.a();
                                        if (!b) {
                                            if (b) {
                                                break;
                                            }
                                            continue Label_1127_Outer;
                                        }
                                        else {
                                            if (p12.c == p12.b) {
                                                d.h(p);
                                            }
                                            if (p13.c == p13.b) {
                                                d.h(p2);
                                            }
                                            break Label_1169;
                                        }
                                    }
                                    d.b(p11, p);
                                    continue;
                                }
                            }
                            ++n3;
                            continue Label_0212;
                        }
                        break;
                    } while (!b);
                    return;
                }
                if (rectangle2.x < x) {
                    x = rectangle.x;
                }
                if (rectangle.y < y) {
                    y = rectangle.y;
                }
                if (rectangle.x + rectangle.width > n2) {
                    n2 = rectangle.x + rectangle.width;
                }
                if (rectangle.y + rectangle.height > n) {
                    n = rectangle.y + rectangle.height;
                }
                --i;
                if (b) {
                    break;
                }
            }
            final Rectangle rectangle5 = new Rectangle(x, y, n2 - x, n - y);
            continue;
        }
    }
    
    private boolean a(final q q) {
        return this.q != null && this.q.d(q);
    }
    
    public void b(final boolean p) {
        this.p = p;
    }
    
    static final boolean a(final Rectangle rectangle, final Rectangle rectangle2) {
        return rectangle.width > 0 && rectangle.height > 0 && rectangle2.width > 0 && rectangle2.height > 0 && rectangle2.x >= rectangle.x && rectangle2.x + rectangle2.width <= rectangle.x + rectangle.width && rectangle2.y >= rectangle.y && rectangle2.y + rectangle2.height <= rectangle.y + rectangle.height;
    }
    
    static Rectangle[] a(final l l) {
        return l.g;
    }
    
    static boolean a(final l l, final q q) {
        return l.a(q);
    }
    
    static byte b(final l l) {
        return l.f;
    }
    
    static {
        a = "y.layout.organic.ShuffleLayouter.MINIMAL_DISTANCE_DPKEY";
        b = "y.layout.organic.ShuffleLayouter.FIXED_NODE_DPKEY";
    }
}
