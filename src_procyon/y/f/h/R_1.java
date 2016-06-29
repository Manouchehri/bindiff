package y.f.h;

import java.util.*;
import y.g.*;
import y.c.*;

public class R
{
    protected i a;
    protected boolean b;
    protected int[] c;
    protected boolean[] d;
    protected ArrayList e;
    protected ArrayList f;
    protected ArrayList g;
    protected ar h;
    protected long i;
    
    public R() {
        this.i = 1306737L;
    }
    
    public void a(final i a) {
        this.a = a;
        this.c = new int[a.f()];
        this.d = new boolean[a.f()];
        this.e = new ArrayList(a.f());
        this.f = new ArrayList(a.f());
        this.g = new ArrayList(a.f());
        this.h = new ar(this.i);
    }
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public void a(final y y) {
        final boolean d = N.d;
        this.a();
        y.clear();
        this.e.clear();
        final x o = this.a.o();
        while (true) {
            while (o.f()) {
                this.e.add(o.e());
                o.g();
                if (!d) {
                    if (d) {
                        break;
                    }
                    continue;
                }
                else {
                    if (this.g.isEmpty()) {
                        throw new RuntimeException("Graph consists only of directed circles");
                    }
                    this.a(this.e, this.g, this.f, y);
                    while (!this.e.isEmpty()) {
                        this.a(this.f, this.g);
                        if (this.g.isEmpty()) {
                            this.a(this.e, this.g);
                        }
                        if (this.g.isEmpty()) {
                            throw new RuntimeException("Graph contains a directed circle");
                        }
                        this.a(this.e, this.g, this.f, y);
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
            }
            this.a(this.e, this.g);
            continue;
        }
    }
    
    protected void a() {
        final boolean d = N.d;
        int i = 0;
        while (true) {
            while (i < this.a.e()) {
                this.c[i] = 0;
                final R r = this;
                if (d) {
                    final e p = r.a.p();
                    while (p.f()) {
                        final d a = p.a();
                        final int[] c = this.c;
                        final int d2 = a.d().d();
                        ++c[d2];
                        final int[] c2 = this.c;
                        final int d3 = a.c().d();
                        ++c2[d3];
                        p.g();
                        if (d) {
                            break;
                        }
                    }
                    return;
                }
                this.d[i] = false;
                ++i;
                if (d) {
                    break;
                }
            }
            final R r = this;
            continue;
        }
    }
    
    protected void a(final ArrayList list, final ArrayList list2) {
        final boolean d = N.d;
        list2.clear();
        int n = Integer.MAX_VALUE;
        int i = 0;
        while (i < list.size()) {
            final q q = list.get(i);
            final int n2 = this.c[q.d()];
            if (n2 < n) {
                n = n2;
                list2.clear();
            }
            if (n2 == n) {
                list2.add(q);
            }
            ++i;
            if (d) {
                break;
            }
        }
    }
    
    public void a(final ArrayList list, final ArrayList list2, final ArrayList list3, final y y) {
        final boolean d = N.d;
        final q q = this.b ? this.a(list2) : list2.get(0);
        final int index = list.indexOf(q);
        if (index >= 0) {
            list.remove(index);
        }
        y.add(q);
        list3.clear();
        this.d[q.d()] = true;
        final e j = q.j();
        while (j.f()) {
            final q a = j.a().a(q);
            final int d2 = a.d();
            if (!this.d[d2]) {
                final int[] c = this.c;
                final int n = d2;
                --c[n];
                list3.add(a);
            }
            j.g();
            if (d) {
                break;
            }
        }
    }
    
    protected q a(final ArrayList list) {
        if (list.size() == 0) {
            throw new RuntimeException("Given an empty list!");
        }
        return list.get(this.h.nextInt(list.size()));
    }
}
