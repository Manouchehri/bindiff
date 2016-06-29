package y.f.e;

import y.f.*;
import y.g.*;
import y.f.k.*;
import java.awt.*;
import y.d.*;
import y.c.*;

class C
{
    X a;
    A b;
    f[] c;
    y[] d;
    I e;
    boolean f;
    
    C(final X a) {
        this.f = false;
        this.a = a;
    }
    
    void a() {
        final boolean b = i.b;
        this.b = this.a.t();
        this.e = new I(this.a);
        this.d = y.a.A.a(this.a);
        this.c = y.a.A.a(this.a, this.d);
        final o o = new o();
        Label_0112: {
            if (this.d.length == 1 && this.d[0].size() == this.a.f()) {
                o.a(360);
                if (!b) {
                    break Label_0112;
                }
            }
            o.a(360);
        }
        this.e.a();
        int i = 0;
    Label_0121:
        while (true) {
        Label_0277_Outer:
            while (i < this.c.length) {
                this.a(this.c[i].a());
                o.a(this.a);
                final q b2 = this.d[i].b();
                final y.d.q r = this.a.r(b2);
                final Rectangle a = this.a.a();
                this.a.b(b2, a.width, a.height);
                a.setSize((int)r.a(), (int)r.b());
                final C c = this;
                if (!b) {
                    this.b.a(b2, a);
                    while (true) {
                        while (!this.a.i()) {
                            this.a.c(this.a.k());
                            if (!b) {
                                if (b) {
                                    break;
                                }
                                continue Label_0277_Outer;
                            }
                            else {
                                if (b) {
                                    break Label_0277_Outer;
                                }
                                continue Label_0121;
                            }
                        }
                        ++i;
                        continue;
                    }
                }
                c.e.f();
                int j = 0;
                while (j < this.d.length) {
                    final x a2 = this.d[j].a();
                    Label_0383: {
                        if (a2.f()) {
                            a2.e();
                            a2.g();
                            while (a2.f()) {
                                this.e.a(a2.e());
                                a2.g();
                                if (b) {
                                    break Label_0383;
                                }
                                if (b) {
                                    break;
                                }
                            }
                        }
                        ++j;
                    }
                    if (b) {
                        break;
                    }
                }
                return;
            }
            final C c = this;
            continue;
        }
    }
    
    void b() {
        final boolean b = i.b;
        this.e.f();
        final int[] array = new int[this.a.f()];
        int i = 0;
    Label_0107:
        while (true) {
            y y2;
            y y;
            x a;
            q b2;
            t l;
            Rectangle rectangle;
            y.d.q r;
            double n;
            double n2;
            double n3;
            double n4;
            double n5;
            double n6;
            int n7;
            double n8;
            double n9;
            e j;
            q a2;
            int n10;
            int n11;
            double n12;
            double n13;
            double sqrt;
            double n14;
            double n15;
            y y3;
            double sqrt2;
            x a3;
            int length;
            Label_0100_Outer:Label_0124_Outer:
            while (i < this.d.length) {
                y = (y2 = this.d[i]);
                if (!b) {
                    a = y2.a();
                    while (true) {
                        while (a.f()) {
                            array[a.e().d()] = i + 1;
                            a.g();
                            if (!b) {
                                if (b) {
                                    break;
                                }
                                continue Label_0100_Outer;
                            }
                            else {
                                if (b) {
                                    break Label_0100_Outer;
                                }
                                continue Label_0107;
                            }
                        }
                        ++i;
                        continue Label_0124_Outer;
                    }
                }
            Label_0113_Outer:
                while (true) {
                    b2 = y2.b();
                    l = this.a.l(b2);
                    rectangle = (Rectangle)this.b.b(b2);
                    r = this.a.r(b2);
                    n = l.a() - r.a() / 2.0;
                    n2 = l.b() - r.b() / 2.0;
                    n3 = rectangle.x;
                    n4 = rectangle.y;
                    n5 = n - n3;
                    n6 = n2 - n4;
                    this.a.b(b2, rectangle.width, rectangle.height);
                    this.a.a(b2, 0.0, 0.0);
                    n7 = array[b2.d()];
                    n8 = 0.0;
                    n9 = 0.0;
                    if (!b) {
                        j = b2.j();
                        Label_0544: {
                            while (true) {
                            Label_0113:
                                while (true) {
                                    while (j.f()) {
                                        a2 = j.a().a(b2);
                                        n10 = array[a2.d()];
                                        n11 = n7;
                                        if (b) {
                                            break Label_0113;
                                        }
                                        if (n10 != n11) {
                                            n12 = l.a() - this.a.j(a2);
                                            n13 = l.b() - this.a.k(a2);
                                            sqrt = Math.sqrt(n12 * n12 + n13 * n13);
                                            n14 = n12 / sqrt;
                                            n15 = n13 / sqrt;
                                            n8 += n14;
                                            n9 += n15;
                                        }
                                        j.g();
                                        if (b) {
                                            break;
                                        }
                                    }
                                    Label_0425: {
                                        break Label_0425;
                                        if (n10 < n11) {
                                            y = (y3 = this.d[i]);
                                            continue Label_0113_Outer;
                                        }
                                        break Label_0544;
                                    }
                                    if (n8 != 0.0 && n9 != 0.0) {
                                        sqrt2 = Math.sqrt(n8 * n8 + n9 * n9);
                                        this.a(y.a(), n8 / sqrt2, n9 / sqrt2);
                                    }
                                    a3 = y.a();
                                    while (a3.f()) {
                                        this.a.d(a3.e(), n5, n6);
                                        a3.g();
                                        if (!b) {
                                            if (b) {
                                                break;
                                            }
                                            continue Label_0124_Outer;
                                        }
                                        else {
                                            if (b) {
                                                break Label_0544;
                                            }
                                            break Label_0107;
                                        }
                                    }
                                    break Label_0113;
                                    length = this.d.length;
                                    continue Label_0113;
                                }
                                ++i;
                                continue;
                            }
                        }
                        this.a.a(this.b);
                        this.c = null;
                        this.d = null;
                        this.e = null;
                    }
                    break;
                }
                return;
            }
            i = 0;
            continue Label_0107;
        }
    }
    
    void a(final x x, final double n, final double n2) {
        final boolean b = i.b;
        x.i();
        while (x.f()) {
            final q e = x.e();
            final double j = this.a.j(e);
            final double k = this.a.k(e);
            this.a.a(x.e(), j * n - n2 * k, j * n2 + n * k);
            x.g();
            if (b) {
                break;
            }
        }
    }
    
    void a(final e e) {
        final boolean b = i.b;
        e.i();
        while (e.f()) {
            final d a = e.a();
            if (!this.a.f(a.c())) {
                this.a.d(a.c());
            }
            if (!this.a.f(a.d())) {
                this.a.d(a.d());
            }
            if (!this.a.f(a)) {
                this.a.e(a);
            }
            e.g();
            if (b) {
                break;
            }
        }
    }
}
