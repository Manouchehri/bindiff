package y.f.c.a;

import y.d.*;
import java.util.*;
import y.f.*;
import y.c.*;

public class bk
{
    public static final Object a;
    public static final Object b;
    private D c;
    private D d;
    private boolean e;
    private boolean f;
    
    public bk() {
        this.c = new D();
        this.d = new D();
        this.e = true;
        this.f = true;
    }
    
    public bk(final int n, final int n2) {
        this(n, n2, 0.0, 0.0, 0.0, 0.0);
    }
    
    public bk(final int n, final int n2, final double n3, final double n4, final double n5, final double n6) {
        final boolean x = N.x;
        this.c = new D();
        this.d = new D();
        this.e = true;
        this.f = true;
        int i = 0;
        while (true) {
            while (i < n) {
                final bt c = this.c();
                c.a(n5);
                c.c(n3);
                c.b(n3);
                ++i;
                if (x) {
                    while (i < n2) {
                        final l d = this.d();
                        d.a(n6);
                        d.c(n4);
                        d.b(n4);
                        ++i;
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                if (x) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    public boolean a() {
        return this.e;
    }
    
    public boolean b() {
        return this.f;
    }
    
    byte a(final i i) {
        final c c = i.c("PARTITION_ORIENTATION_DPKEY");
        if (c != null) {
            return ((an)c.b(i)).b();
        }
        return 0;
    }
    
    boolean b(final i i) {
        final c c = i.c("PARTITION_ORIENTATION_DPKEY");
        if (c != null) {
            final an an = (an)c.b(i);
            return an.b(an.b());
        }
        return false;
    }
    
    public bh a(final int n, final int n2, final int n3, final int n4) {
        final boolean x = N.x;
        final ArrayList<bt> list = new ArrayList<bt>();
        int i = n2;
        while (true) {
            while (i <= n4) {
                final ArrayList<bt> list3;
                final ArrayList<bt> list2 = list3 = list;
                if (x) {
                    final ArrayList<bt> list4 = list3;
                    int j = n;
                    while (j <= n3) {
                        list4.add(this.a(j));
                        ++j;
                        if (x) {
                            break;
                        }
                    }
                    return new bh(list4, list);
                }
                list2.add((bt)this.b(i));
                ++i;
                if (x) {
                    break;
                }
            }
            ArrayList<bt> list3 = new ArrayList<bt>();
            continue;
        }
    }
    
    public bh a(final Collection collection, final Collection collection2) {
        return new bh(collection, collection2);
    }
    
    public static bk c(final i i) {
        final c c = i.c(bk.a);
        if (c == null || i.c(bk.b) == null) {
            return null;
        }
        return (bk)c.b(i);
    }
    
    public bt c() {
        final bt bt = new bt(this.c.size(), this);
        this.c.add(bt);
        return bt;
    }
    
    public l d() {
        final l l = new l(this.d.size(), this);
        this.d.add(l);
        return l;
    }
    
    public static boolean d(final i i) {
        final boolean x = N.x;
        final bk c = c(i);
        if (c != null) {
            final y.f.b.c c2 = new y.f.b.c(i);
            y.f.b.c c4 = null;
            if (c.e().size() > 1) {
                int n = -2;
                final c c3 = i.c(bk.b);
                final x o = i.o();
                while (o.f()) {
                    final q e = o.e();
                    c4 = c2;
                    if (x) {
                        break;
                    }
                    if (c4 == null || !c2.d(e)) {
                        final bh bh = (bh)c3.b(e);
                        final int n2 = (bh != null) ? bh.c().a() : -1;
                        if (n != -2) {
                            if (n != n2) {
                                c2.c();
                                return true;
                            }
                        }
                        else {
                            n = n2;
                        }
                    }
                    o.g();
                    if (x) {
                        break;
                    }
                }
            }
            c4.c();
        }
        return false;
    }
    
    public bt a(final int n) {
        final boolean x = N.x;
        final C m = this.c.m();
        while (m.f()) {
            final bt bt = (bt)m.d();
            if (bt.a() == n) {
                return bt;
            }
            m.g();
            if (x) {
                break;
            }
        }
        return null;
    }
    
    public l b(final int n) {
        final boolean x = N.x;
        final C m = this.d.m();
        while (m.f()) {
            final l l = (l)m.d();
            if (l.a() == n) {
                return l;
            }
            m.g();
            if (x) {
                break;
            }
        }
        return null;
    }
    
    public D e() {
        return this.c;
    }
    
    public D f() {
        return this.d;
    }
    
    public bh a(final bt bt, final l l) {
        return new bh(bt, l);
    }
    
    public bh a(final int n, final int n2) {
        return new bh(this.a(n), this.b(n2));
    }
    
    void e(final i i) {
        if (this.f) {
            this.a(i, true);
        }
    }
    
    void f(final i i) {
        if (this.e) {
            this.a(i, false);
        }
    }
    
    public void a(final an an, final ao ao) {
        final boolean x = N.x;
        final boolean d = an.d();
        C c = this.f().m();
        while (true) {
            while (c.f()) {
                final l l = (l)c.d();
                l.g(ao.a(this.a(l, d)).a());
                c.g();
                if (x) {
                    while (c.f()) {
                        final bt bt = (bt)c.d();
                        bt.g(ao.a(this.a(bt, d)).b());
                        c.g();
                        if (x) {
                            break;
                        }
                    }
                    return;
                }
                if (x) {
                    break;
                }
            }
            c = this.e().m();
            continue;
        }
    }
    
    public void b(final an an, final ao ao) {
        final boolean x = N.x;
        final boolean d = an.d();
        C c = this.f().m();
        while (true) {
            while (c.f()) {
                final l l = (l)c.d();
                final t b = ao.b(new t(l.h(), 0.0));
                Object d2;
                final l i = (l)(d2 = l);
                if (x) {
                    while (true) {
                        final bt bt = (bt)d2;
                        final t b2 = ao.b(new t(0.0, bt.h()));
                        bt.g(d ? b2.a() : b2.b());
                        c.g();
                        if (!x) {
                            if (c.f()) {
                                d2 = c.d();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                i.g(d ? b.b() : b.a());
                c.g();
                if (x) {
                    break;
                }
            }
            c = this.e().m();
            continue;
        }
    }
    
    private t a(final l l, final boolean b) {
        if (b) {
            return new t(0.0, l.h());
        }
        return new t(l.h(), 0.0);
    }
    
    private t a(final bt bt, final boolean b) {
        if (b) {
            return new t(bt.h(), 0.0);
        }
        return new t(0.0, bt.h());
    }
    
    private void a(final i i, final boolean b) {
        final boolean x = N.x;
        final c c = i.c(bk.b);
        if (c != null) {
            final A t = i.t();
            final HashMap<Object, aT> hashMap = new HashMap<Object, aT>();
            final D d = new D();
            boolean b2 = false;
            final x o = i.o();
        Label_0674:
            while (true) {
                while (o.f()) {
                    final q e = o.e();
                    final bh bh = (bh)c.b(e);
                    if (x) {
                        i.a(t);
                        return;
                    }
                    Label_0347: {
                        if (bh != null) {
                            if (b) {
                                final bt c2 = bh.c();
                                Label_0199: {
                                    if (!hashMap.containsKey(c2)) {
                                        d.add(c2);
                                        final aT at = new aT(0, !c2.j());
                                        t.a(e, at);
                                        hashMap.put(c2, at);
                                        if (!x) {
                                            break Label_0199;
                                        }
                                    }
                                    t.a(e, hashMap.get(c2));
                                }
                                b2 = (b2 || !c2.j());
                                if (!x) {
                                    break Label_0347;
                                }
                            }
                            final l d2 = bh.d();
                            Label_0327: {
                                if (!hashMap.containsKey(d2)) {
                                    d.add(d2);
                                    final aT at2 = new aT(0, !d2.j());
                                    t.a(e, at2);
                                    hashMap.put(d2, at2);
                                    if (!x) {
                                        break Label_0327;
                                    }
                                }
                                t.a(e, hashMap.get(d2));
                            }
                            b2 = (b2 || !d2.j());
                        }
                    }
                    o.g();
                    if (x) {
                        break;
                    }
                }
                if (b2) {
                    if (b) {
                        d.sort(new bl(this));
                    }
                    else {
                        d.sort(new bm(this));
                    }
                    int n = 0;
                    final C m = d.m();
                    while (true) {
                        while (m.f()) {
                            hashMap.get(m.d()).a(n++);
                            m.g();
                            if (x) {
                                int size = d.size();
                                Label_0582: {
                                    if (b) {
                                        final C j = this.e().m();
                                        while (j.f()) {
                                            final bt bt = (bt)j.d();
                                            final aT at3 = hashMap.get(bt);
                                            if (x) {
                                                return;
                                            }
                                            Label_0570: {
                                                if (at3 != null) {
                                                    bt.a(at3.a());
                                                    if (!x) {
                                                        break Label_0570;
                                                    }
                                                }
                                                bt.a(size++);
                                            }
                                            j.g();
                                            if (x) {
                                                break Label_0582;
                                            }
                                        }
                                        continue Label_0674;
                                    }
                                }
                                final C k = this.f().m();
                                while (k.f()) {
                                    final l l = (l)k.d();
                                    final aT at4 = hashMap.get(l);
                                    if (x) {
                                        return;
                                    }
                                    Label_0662: {
                                        if (at4 != null) {
                                            l.a(at4.a());
                                            if (!x) {
                                                break Label_0662;
                                            }
                                        }
                                        l.a(size++);
                                    }
                                    k.g();
                                    if (x) {
                                        break;
                                    }
                                }
                                continue Label_0674;
                            }
                            if (x) {
                                break;
                            }
                        }
                        aR.a(i, t, 5, 2);
                        continue;
                    }
                }
                continue Label_0674;
            }
        }
    }
    
    static {
        a = "y.layout.hierarchic.incremental.PartitionGrid.PARTITION_DPKEY";
        b = "y.layout.hierarchic.incremental.PartitionGrid.PARTITION_CELL_DPKEY";
    }
}
