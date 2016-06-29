package y.f.h;

import y.c.*;
import java.util.*;

public class z
{
    private B a;
    private C b;
    private A c;
    private i d;
    private ArrayList[] e;
    private double[] f;
    private ArrayList[] g;
    private double[] h;
    private q[] i;
    private ArrayList[] j;
    private ArrayList[] k;
    private ArrayList l;
    private ArrayList m;
    private f n;
    private h o;
    
    public z(final i d, final h o) {
        final boolean d2 = N.d;
        this.d = d;
        this.o = o;
        final int e = d.e();
        final int n = d.g() + 1;
        this.e = new ArrayList[n];
        this.f = new double[n];
        this.g = new ArrayList[n];
        this.h = new double[n];
        int i = 0;
        while (true) {
            while (i < n) {
                this.e[i] = new ArrayList(e);
                this.g[i] = new ArrayList(e);
                ++i;
                if (d2) {
                    int j = 0;
                    while (j < d.e()) {
                        this.k[j] = new ArrayList(e);
                        this.j[j] = new ArrayList(e);
                        ++j;
                        if (d2) {
                            return;
                        }
                        if (d2) {
                            break;
                        }
                    }
                    this.n = new f();
                    this.i = new q[d.f() + 1];
                    this.a = new B();
                    this.b = new C();
                    this.c = new A();
                    return;
                }
                if (d2) {
                    break;
                }
            }
            this.k = new ArrayList[e];
            this.j = new ArrayList[e];
            continue;
        }
    }
    
    public ArrayList a() {
        return this.l;
    }
    
    public ArrayList b() {
        return this.m;
    }
    
    public f c() {
        return this.n;
    }
    
    public void a(final y y, final int[] array) {
        final boolean d = N.d;
        final int size = y.size();
        final f f = new f();
        int n = 0;
        final x a = y.a();
        while (true) {
        Label_0189_Outer:
            while (a.f()) {
                this.i[++n] = a.e();
                a.g();
                if (d) {
                    final q b = y.b();
                    final q c = y.c();
                    boolean b2 = false;
                    d d2 = b.b(c);
                    if (d2 == null) {
                        d2 = c.b(b);
                    }
                    if (d2 == null) {
                        b2 = true;
                        d2 = this.d.a(b, c);
                    }
                    int i = 0;
                    while (true) {
                        while (i < this.d.g()) {
                            this.e[i].clear();
                            this.f[i] = 0.0;
                            ++i;
                            if (d) {
                                int j = size - 1;
                                while (true) {
                                    while (j > 0) {
                                        final q q = this.i[j];
                                        final int empty = this.k[q.d()].isEmpty() ? 1 : 0;
                                        if (d) {
                                            if (empty >= 0) {
                                                this.l.remove(j);
                                            }
                                            int k = 0;
                                            while (true) {
                                                while (k < this.l.size()) {
                                                    final d d3 = this.l.get(k);
                                                    f.add(d3);
                                                    this.d.d(d3);
                                                    ++k;
                                                    if (d) {
                                                        while (true) {
                                                            while (k < this.d.g()) {
                                                                this.e[k].clear();
                                                                this.f[k] = 0.0;
                                                                ++k;
                                                                if (d) {
                                                                    int l = size - 1;
                                                                    while (true) {
                                                                        while (l > 0) {
                                                                            final q q2 = this.i[l];
                                                                            final boolean empty2 = this.k[q2.d()].isEmpty();
                                                                            if (!d) {
                                                                                if (!empty2) {
                                                                                    this.a(q2, this.i, this.e, this.f, array);
                                                                                }
                                                                                --l;
                                                                                if (d) {
                                                                                    break;
                                                                                }
                                                                                continue Label_0189_Outer;
                                                                            }
                                                                            else {
                                                                                if (empty2) {
                                                                                    final int index = this.m.indexOf(d2);
                                                                                    if (index >= 0) {
                                                                                        this.m.remove(index);
                                                                                    }
                                                                                }
                                                                                int n2 = 0;
                                                                                while (true) {
                                                                                    while (n2 < this.m.size()) {
                                                                                        final d d4 = this.m.get(n2);
                                                                                        f.add(d4);
                                                                                        this.d.d(d4);
                                                                                        ++n2;
                                                                                        if (d) {
                                                                                            e e = this.d.p();
                                                                                            while (true) {
                                                                                                while (e.f()) {
                                                                                                    final d a2 = e.a();
                                                                                                    this.n.add(a2);
                                                                                                    this.d.d(a2);
                                                                                                    e.g();
                                                                                                    if (d) {
                                                                                                        while (e.f()) {
                                                                                                            this.d.e(e.a());
                                                                                                            e.g();
                                                                                                            if (d) {
                                                                                                                break;
                                                                                                            }
                                                                                                        }
                                                                                                        return;
                                                                                                    }
                                                                                                    if (d) {
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                e = f.a();
                                                                                                continue;
                                                                                            }
                                                                                        }
                                                                                        if (d) {
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    if (b2) {
                                                                                        this.d.a(d2);
                                                                                    }
                                                                                    continue;
                                                                                }
                                                                            }
                                                                        }
                                                                        this.m = new ArrayList(this.e[d2.b()]);
                                                                        continue;
                                                                    }
                                                                }
                                                                if (d) {
                                                                    break;
                                                                }
                                                            }
                                                            this.a(array);
                                                            continue;
                                                        }
                                                    }
                                                    if (d) {
                                                        break;
                                                    }
                                                }
                                                k = 0;
                                                continue;
                                            }
                                        }
                                        if (empty == 0) {
                                            this.a(q, this.i, this.e, this.f, array);
                                        }
                                        --j;
                                        if (d) {
                                            break;
                                        }
                                    }
                                    this.l = new ArrayList(this.e[d2.b()]);
                                    final int index2;
                                    j = (index2 = this.l.indexOf(d2));
                                    continue;
                                }
                            }
                            if (d) {
                                break;
                            }
                        }
                        this.a(array);
                        continue;
                    }
                }
                if (d) {
                    break;
                }
            }
            this.n.clear();
            continue;
        }
    }
    
    private void a(final q q, final q[] array, final ArrayList[] array2, final double[] array3, final int[] array4) {
        final boolean d = N.d;
        final int d2 = q.d();
        final ArrayList list = this.k[d2];
        final int n = array4[list.get(list.size() - 1).a(q).d()];
        final int n2 = array4[d2];
        ArrayList<d> list2 = new ArrayList<d>();
        double n3 = 0.0;
        final y y = new y();
        final e p5 = this.d.p();
        while (true) {
            while (p5.f()) {
                final int b = p5.a().b();
                if (d) {
                    int n4 = b;
                    while (true) {
                        do {
                            int i = 0;
                            int n5 = 0;
                        Label_0157:
                            while (i <= n5) {
                                final q q2 = array[n4];
                                if (d) {
                                    final x a = y.a();
                                    while (a.f()) {
                                        final q e = a.e();
                                        ArrayList<d> list3 = null;
                                        double n6 = 0.0;
                                        final ArrayList list4 = this.j[e.d()];
                                        int n7 = 0;
                                    Label_0338:
                                        while (true) {
                                            list4.size();
                                        Label_0345:
                                            while (true) {
                                                final int n10;
                                                final int n11;
                                                Label_0455: {
                                                    final int n8;
                                                    final int n9;
                                                    if (n8 < n9) {
                                                        final d d3 = list4.get(n7);
                                                        n10 = array4[d3.a(e).d()];
                                                        n11 = n2;
                                                        if (d) {
                                                            break Label_0455;
                                                        }
                                                        if (n10 > n11) {
                                                            final int b2 = d3.b();
                                                            if (n6 < this.h[b2]) {
                                                                list3 = (ArrayList<d>)this.g[b2];
                                                                n6 = this.h[b2];
                                                            }
                                                            ++n7;
                                                            if (!d) {
                                                                continue Label_0338;
                                                            }
                                                        }
                                                    }
                                                    if (n6 > n3) {
                                                        list2 = list3;
                                                        n3 = n6;
                                                    }
                                                    list4.size();
                                                }
                                                if (n10 < n11) {
                                                    final d d4 = list4.get(n7);
                                                    if (array4[d4.a(e).d()] == n2) {
                                                        final int b3 = d4.b();
                                                        list2.add(d4);
                                                        final ArrayList list5 = array2[b3];
                                                        list5.clear();
                                                        list5.addAll(list2);
                                                        n3 += this.o.a(d4);
                                                        array3[b3] = n3;
                                                    }
                                                }
                                                final ArrayList list6 = this.k[e.d()];
                                                int j = 0;
                                                while (j < list6.size()) {
                                                    final d d5 = list6.get(j);
                                                    final int n8 = array4[d5.a(e).d()];
                                                    final int n9 = n;
                                                    if (d) {
                                                        continue Label_0345;
                                                    }
                                                    if (n8 > n9) {
                                                        break;
                                                    }
                                                    if (e != y.b()) {
                                                        final int b4 = d5.b();
                                                        final ArrayList list7 = new ArrayList(list2);
                                                        list7.addAll(array2[b4]);
                                                        this.g[b4] = list7;
                                                        this.h[b4] = n3 + array3[b4];
                                                    }
                                                    ++j;
                                                    if (d) {
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            break;
                                        }
                                        a.g();
                                        if (d) {
                                            break;
                                        }
                                    }
                                    return;
                                }
                                final e k = q2.j();
                                while (k.f()) {
                                    final q a2 = k.a().a(q2);
                                    final int n12 = i = array4[a2.d()];
                                    n5 = n;
                                    if (d) {
                                        continue Label_0157;
                                    }
                                    if (i <= n5 && n12 >= n2 && y.d(a2) == null) {
                                        y.add(a2);
                                    }
                                    k.g();
                                    if (d) {
                                        break;
                                    }
                                }
                                ++n4;
                            }
                            break;
                        } while (!d);
                        this.c.a(array4);
                        y.sort(this.c);
                        continue;
                    }
                }
                final int n13 = b;
                this.g[n13].clear();
                this.h[n13] = 0.0;
                p5.g();
                if (d) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void a(final int[] array) {
        final boolean d = N.d;
        this.a.a(array);
        this.b.a(array);
        final x o = this.d.o();
        do {
            Label_0029: {
                o.f();
            }
            int i = 0;
            Label_0035:
            while (i != 0) {
                final q e = o.e();
                final int d2 = e.d();
                final ArrayList list = this.j[d2];
                list.clear();
                final ArrayList list2 = this.k[d2];
                list2.clear();
                final e j = e.j();
                while (j.f()) {
                    final d a = j.a();
                    final int n = array[e.d()];
                    final int n2 = array[a.a(e).d()];
                    i = n;
                    if (d) {
                        continue Label_0035;
                    }
                    Label_0158: {
                        if (i < n2) {
                            list2.add(a);
                            if (!d) {
                                break Label_0158;
                            }
                        }
                        list.add(a);
                    }
                    j.g();
                    if (d) {
                        break;
                    }
                }
                this.a.a(e);
                y.g.e.a(list, this.a);
                this.b.a(e);
                y.g.e.a(list2, this.b);
                o.g();
                continue Label_0029;
            }
            break;
        } while (!d);
    }
}
