package y.f.f.a.b;

import y.f.f.d.*;
import y.f.h.*;
import y.c.*;
import y.f.*;
import java.util.*;

public class f extends F
{
    public f(final h e) {
        this.e = e;
    }
    
    public void a(final D c, final c c2, final int j) {
        final boolean c3 = y.f.f.a.b.a.c;
        this.c = c;
        this.j = j;
        this.d = (X)c.g();
        this.f = this.d.t();
        this.g = null;
        this.d.a(f.a, this.f);
        final y.c.e p3 = this.d.p();
        while (p3.f()) {
            final d a = p3.a();
            final ArrayList list = (ArrayList)this.e.b(a);
            if (c3) {
                return;
            }
            if (list != null && list.size() > 0) {
                this.l.addAll(list);
                if (this.g == null) {
                    final C[] d = this.d.d((Object)a);
                    if (d != null && d.length > 0) {
                        this.g = d[0].getLabelModel();
                    }
                }
            }
            p3.g();
            if (c3) {
                break;
            }
        }
        c.a(this);
        this.k = new y.f.F();
    }
    
    public void a(final a a, final D c, final c c2, final y.c.f f) {
        final boolean c3 = a.c;
        this.c = c;
        this.d = (X)c.g();
        this.f = this.d.t();
        this.g = null;
        this.d.a(f.a, this.f);
        final y.c.e a2 = f.a();
        while (a2.f()) {
            final d a3 = a2.a();
            final ArrayList list = (ArrayList)this.e.b(a3);
            if (c3) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                final y.c.f d = a.d(a3);
                if (d != null) {
                    if (a.r(a3)) {
                        this.a(d, a);
                    }
                    this.d(a3, d.e());
                }
                if (this.g == null) {
                    final C[] d2 = this.d.d((Object)a3);
                    if (d2 != null && d2.length > 0) {
                        this.g = d2[0].getLabelModel();
                    }
                }
            }
            a2.g();
            if (c3) {
                break;
            }
        }
        c.a(this);
    }
    
    private void a(final y.c.f f, final a a) {
        final boolean c = a.c;
        final y.c.e a2 = f.a();
        while (a2.f()) {
            if (a.p(a2.a())) {
                f.b(a2);
            }
            a2.g();
            if (c) {
                break;
            }
        }
    }
    
    private void d(final d d, final d[] array) {
        final boolean c = y.f.f.a.b.a.c;
        final ArrayList list = (ArrayList)this.e.b(d);
        if (list == null || list.isEmpty() || array.length == 0) {
            return;
        }
        if (array.length == 1) {
            this.e.a(array[0], list);
            if (!c) {
                return;
            }
        }
        final ArrayList<S> list2 = new ArrayList<S>();
        final ArrayList<S> list3 = new ArrayList<S>();
        final ArrayList<S> list4 = new ArrayList<S>();
        while (true) {
            for (final S s : list) {
                final byte a = s.f().a();
                final int length;
                final byte b = (byte)(length = a);
                final int n2;
                final int n = n2 = 1;
                if (c) {
                    if (length == n2) {
                        this.e.a(array[0], list2);
                        list3.addAll(list4);
                        this.e.a(array[1], list3);
                        if (!c) {
                            return;
                        }
                    }
                    final d d2 = array[0];
                    final d d3 = array[array.length - 1];
                    final d d4 = array[(array.length + 1) / 2 - 1];
                    this.e.a(d2, list2);
                    this.e.a(d3, list4);
                    this.e.a(d4, list3);
                    return;
                }
                if (b == n) {
                    list2.add(s);
                    if (!c) {
                        continue;
                    }
                }
                if (a == 2) {
                    list4.add(s);
                    if (!c) {
                        continue;
                    }
                }
                list3.add(s);
                if (c) {
                    break;
                }
            }
            int length = array.length;
            int n2 = 2;
            continue;
        }
    }
}
