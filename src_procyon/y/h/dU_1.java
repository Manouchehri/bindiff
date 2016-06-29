package y.h;

import y.d.*;
import y.c.*;
import y.h.b.*;
import java.awt.geom.*;
import y.f.*;
import java.util.*;
import y.g.*;

public class dU extends e
{
    private Set a;
    private Set b;
    private c c;
    private List d;
    private List e;
    private boolean f;
    private boolean g;
    private double h;
    private double i;
    private double j;
    private boolean k;
    private boolean l;
    private ai m;
    private ai n;
    private boolean o;
    private boolean p;
    private Set q;
    private boolean r;
    private boolean s;
    private ArrayList t;
    private boolean u;
    private boolean v;
    private double w;
    private Collection x;
    private Collection y;
    private boolean z;
    private boolean A;
    private double B;
    
    public dU() {
        this(null);
    }
    
    public dU(final ch ch) {
        super(ch);
        this.g = true;
        this.i = -1.0;
        this.l = true;
        this.r = true;
        this.s = true;
        this.w = 40.0;
        this.z = true;
        this.B = 10.0;
    }
    
    public boolean l() {
        return this.v;
    }
    
    public void b(final boolean s) {
        this.s = s;
    }
    
    public void c(final boolean u) {
        this.u = u;
    }
    
    public void d(final boolean r) {
        this.r = r;
    }
    
    public void e(final boolean p) {
        this.p = p;
    }
    
    public void f(final boolean o) {
        this.o = o;
    }
    
    public void g(final boolean k) {
        this.k = k;
    }
    
    public double m() {
        return this.j;
    }
    
    public void b(final double j) {
        this.j = j;
    }
    
    public void c(final double i) {
        this.i = i;
    }
    
    public boolean n() {
        return this.A;
    }
    
    public void a(final t t, final Collection collection, final Collection x, final Collection y, final c c) {
        final boolean z = fj.z;
        super.g();
        this.a(t);
        this.a = new HashSet(collection);
        this.b = new HashSet(x.size());
        this.x = x;
        this.y = y;
        final Iterator<ek> iterator = x.iterator();
        while (true) {
            while (iterator.hasNext()) {
                this.b.add(iterator.next().a());
                if (z) {
                    if (this.A) {
                        final gz b = this.b(t, collection, x, y, c);
                        if (b != null) {
                            this.a(b);
                        }
                    }
                    this.v = true;
                    return;
                }
                if (z) {
                    break;
                }
            }
            this.c = c;
            this.a(collection, this.q = new HashSet(Math.max(32, this.c().getGraph2D().e() - collection.size())));
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b(this.d, this.e);
            this.m = new ai();
            this.n = new ai();
            this.o();
            this.q();
            this.p();
            continue;
        }
    }
    
    public void f() {
        super.f();
        this.v = false;
        this.a = null;
        this.b = null;
        this.c = null;
        this.x = null;
        this.y = null;
        this.d = null;
        this.e = null;
        this.q = null;
        this.t = null;
        final ai ai = null;
        this.n = ai;
        this.m = ai;
    }
    
    protected gz b(final t t, final Collection collection, final Collection collection2, final Collection collection3, final c c) {
        final boolean z = fj.z;
        if (collection.isEmpty() && collection2.isEmpty()) {
            return null;
        }
        final ArrayList<ew> list = new ArrayList<ew>();
        for (final q q : collection) {
            final bu bu = (bu)q.e();
            list.add(new ew(bu.l(q), bu.p(q), bu.q(q)));
            if (z) {
                return new ep(1.0, this.c(), this.B, t, list);
            }
            if (z) {
                break;
            }
        }
        if (collection.isEmpty()) {
            for (final ek ek : collection2) {
                list.add(new ew(ek.b(), ek.d(), ek.c(), 1.0, 1.0));
                if (z) {
                    break;
                }
            }
            return new ep(1.0, this.c(), this.B, t, list);
        }
        return new ep(1.0, this.c(), this.B, t, list);
    }
    
    private void o() {
        final boolean z = fj.z;
        if (!this.r) {
            return;
        }
        final HashSet<d> set = new HashSet<d>(Math.min(32, this.b.size()));
        final HashMap hashMap = new HashMap(this.b.size());
        final HashMap hashMap2 = new HashMap(this.y.size());
        this.a(hashMap, hashMap2, set);
        final bu graph2D = this.c().getGraph2D();
        final Iterator<Object> iterator = set.iterator();
    Label_0475:
        while (true) {
            iterator.hasNext();
            boolean d = false;
        Label_0100:
            while (d) {
                final el[] a = this.a(graph2D.i(iterator.next()), hashMap, hashMap2);
                int i = 1;
                while (true) {
                    while (i < a.length) {
                        final el el = a[i - 1];
                        final el el2 = a[i];
                        final double n = el.b().a - el2.b().a;
                        final double n2 = el.b().b - el2.b().b;
                        final int d2;
                        final int n3 = d2 = (el2.d() ? 1 : 0);
                        if (z) {
                            int j = d2;
                            while (j >= 1) {
                                final el el3 = a[j + 1];
                                final ek ek = (ek)a[j];
                                final double n4 = el3.b().a - ek.b().a;
                                final double n5 = el3.b().b - ek.b().b;
                                d = ek.d();
                                if (z) {
                                    continue Label_0100;
                                }
                                if (!d && el3.d()) {
                                    this.m.a(new ev(this.k().a + n4, el3, ek));
                                }
                                if (!ek.c() && el3.c()) {
                                    this.n.a(new ev(this.k().b + n5, el3, ek));
                                }
                                --j;
                                if (z) {
                                    break Label_0475;
                                }
                            }
                            continue Label_0475;
                        }
                        if (n3 == 0 && el.d()) {
                            this.m.a(new ev(this.k().a + n, el, el2));
                        }
                        if (!el2.c() && el.c()) {
                            this.n.a(new ev(this.k().b + n2, el, el2));
                        }
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                    int d2 = a.length - 2;
                    continue;
                }
            }
            break;
        }
    }
    
    private el a(final fL fl, final Map map) {
        if (fl == fl.d().getSourcePort()) {
            if (!this.q.contains(fl.d().getEdge().c())) {
                return new em(fl, fl.f(), (byte)3);
            }
            if (!map.isEmpty()) {
                final el el = map.get(fl);
                if (el != null) {
                    return el;
                }
            }
            return new em(fl, fl.f(), (byte)0);
        }
        else {
            if (!this.q.contains(fl.d().getEdge().d())) {
                return new em(fl, fl.f(), (byte)3);
            }
            if (!map.isEmpty()) {
                final el el2 = map.get(fl);
                if (el2 != null) {
                    return el2;
                }
            }
            return new em(fl, fl.f(), (byte)0);
        }
    }
    
    private void p() {
        final boolean z = fj.z;
        this.t = new ArrayList();
        if (!this.u) {
            return;
        }
        final HashMap hashMap = new HashMap(this.b.size());
        final HashMap hashMap2 = new HashMap(this.y.size());
        final HashSet<d> set = new HashSet<d>(Math.min(32, this.b.size()));
        this.a(hashMap, hashMap2, set);
        final bu graph2D = this.c().getGraph2D();
        final Iterator<Object> iterator = set.iterator();
    Label_0352:
        while (true) {
            double hasNext = iterator.hasNext() ? 1 : 0;
        Label_0111:
            while (hasNext != 0) {
                final el[] a = this.a(graph2D.i(iterator.next()), hashMap, hashMap2);
                int i = 1;
                while (i < a.length) {
                    final el el = a[i - 1];
                    final el el2 = a[i];
                    final double n = el.b().a - el2.b().a;
                    final double n2 = el.b().b - el2.b().b;
                    final double n3 = hasNext = dcmpl(n, 0.0);
                    if (z) {
                        continue Label_0111;
                    }
                    Label_0344: {
                        if (n3 == 0 && (n2 != 0.0 || el.c() != el2.c())) {
                            if (el.d() || el2.d()) {
                                break Label_0344;
                            }
                            this.t.add(new en(el, el2));
                            if (!z) {
                                break Label_0344;
                            }
                        }
                        if (n2 == 0.0 && (n != 0.0 || el.d() != el2.d()) && !el.c() && !el2.c()) {
                            this.t.add(new en(el, el2));
                        }
                    }
                    ++i;
                    if (z) {
                        break Label_0352;
                    }
                }
                continue Label_0352;
            }
            break;
        }
    }
    
    private void a(final Map map, final Map map2, final Set set) {
        final boolean z = fj.z;
        d d;
        Label_0199:Label_0210_Outer:
        while (true) {
        Label_0210:
            while (true) {
                for (final ek ek : this.x) {
                    map.put(ek.a(), ek);
                    if (set != null) {
                        set.add(ek.a().a());
                        if (z) {
                            for (final em em : this.y) {
                                if ((!em.d() || !em.c()) && set != null) {
                                    set.add(em.a().d().getEdge());
                                }
                                map2.put(em.a(), em);
                                if (z) {
                                    break;
                                }
                            }
                            return;
                        }
                        if (z) {
                            break;
                        }
                        continue Label_0210_Outer;
                    }
                }
                if (set != null) {
                Label_0096:
                    for (final q q : this.a) {
                        d = q.g();
                        while (true) {
                            while (d != null) {
                                set.add(d);
                                d = d.h();
                                if (z) {
                                    while (d != null) {
                                        set.add(d);
                                        d = d.g();
                                        if (z) {
                                            continue Label_0210;
                                        }
                                        if (z || z) {
                                            continue Label_0199;
                                        }
                                    }
                                    continue Label_0096;
                                }
                                if (z) {
                                    break;
                                }
                            }
                            d = q.f();
                            continue;
                        }
                    }
                }
                break;
            }
            continue Label_0199;
        }
    }
    
    private el[] a(final aB ab, final Map map, final Map map2) {
        final boolean z = fj.z;
        final el[] array = new el[ab.bendCount() + 2];
        array[0] = this.a(ab.getSourcePort(), map2);
        int n = 1;
        final y bends = ab.bends();
        while (bends.f()) {
            ek ek = map.get(bends.a());
            if (z) {
                return array;
            }
            if (ek == null) {
                ek = new ek(bends.a(), new t(bends.a().b(), bends.a().c()), (byte)0);
            }
            array[n++] = ek;
            bends.g();
            if (z) {
                break;
            }
        }
        array[array.length - 1] = this.a(ab.getTargetPort(), map2);
        return array;
    }
    
    public void a(final en en) {
        this.t.add(en);
    }
    
    public en a(final el el, final el el2) {
        final double n = el2.b().a - el.b().a;
        final double n2 = el2.b().b - el.b().b;
        en en = null;
        if (n == 0.0 && (n2 != 0.0 || el.c() != el2.c())) {
            if (!el.d() && !el2.d()) {
                en = new en(el, el2);
                this.t.add(en);
            }
        }
        else if (n2 == 0.0 && (n != 0.0 || el.d() != el2.d()) && !el.c() && !el2.c()) {
            en = new en(el, el2);
            this.t.add(en);
        }
        return en;
    }
    
    public void b(final en en) {
        if (en != null && this.t != null) {
            this.t.remove(en);
        }
    }
    
    private void q() {
        final boolean z = fj.z;
        if (!this.s) {
            return;
        }
        final bu graph2D = this.c().getGraph2D();
        final Iterator<q> iterator = (Iterator<q>)this.a.iterator();
    Label_0526:
        while (true) {
            iterator.hasNext();
            int i = 0;
        Label_0037:
            while (i != 0) {
                final q q = iterator.next();
                d d = q.g();
                while (d != null) {
                    final aB j = graph2D.i(d);
                    el el = null;
                    i = j.bendCount();
                    if (z) {
                        continue Label_0037;
                    }
                    if (i == 0) {
                        if (this.q.contains(d.c())) {
                            el = new em(j.getSourcePort(), graph2D.p(d), (byte)0);
                        }
                    }
                    else {
                        final x lastBend = j.lastBend();
                        if (!this.b.contains(lastBend)) {
                            el = new ek(lastBend, lastBend.e(), (byte)0);
                        }
                    }
                    if (el != null) {
                        final t q2 = graph2D.q(d);
                        final em em = new em(j.getTargetPort(), q2, (byte)3);
                        this.m.a(new ev(this.k().a + (el.b().a - q2.a), el, em));
                        this.n.a(new ev(this.k().b + (el.b().b - q2.b), el, em));
                    }
                    d = d.h();
                    if (z) {
                        break;
                    }
                }
                d d2 = q.f();
                while (d2 != null) {
                    final aB k = graph2D.i(d2);
                    el el2 = null;
                    final int bendCount = k.bendCount();
                    if (z) {
                        continue Label_0037;
                    }
                    if (bendCount == 0) {
                        if (this.q.contains(d2.d())) {
                            el2 = new em(k.getTargetPort(), graph2D.q(d2), (byte)0);
                        }
                    }
                    else {
                        final x firstBend = k.firstBend();
                        if (!this.b.contains(firstBend)) {
                            el2 = new ek(firstBend, firstBend.e(), (byte)0);
                        }
                    }
                    if (el2 != null) {
                        final t p = graph2D.p(d2);
                        final em em2 = new em(k.getSourcePort(), p, (byte)3);
                        this.m.a(new ev(this.k().a + (el2.b().a - p.a), el2, em2));
                        this.n.a(new ev(this.k().b + (el2.b().b - p.b), el2, em2));
                    }
                    d2 = d2.g();
                    if (z) {
                        break Label_0526;
                    }
                }
                continue Label_0526;
            }
            break;
        }
    }
    
    protected void a(final q q, final fj fj, final Collection collection, final Collection collection2) {
        if (fj instanceof a) {
            this.a(q, (a)fj, collection, collection2);
        }
        final double centerX = fj.getCenterX();
        final double centerY = fj.getCenterY();
        final double x = fj.getX();
        final double width = fj.getWidth();
        final double y = fj.getY();
        final double height = fj.getHeight();
        final double n = x + width;
        final double n2 = y + height;
        final Object a = am.a(q, Boolean.TRUE);
        final Object a2 = am.a(q, Boolean.FALSE);
        final double w = this.w;
        collection.add(new eo((byte)0, (byte)2, new t(centerX, y), x - w, n + w, a2, 0.9));
        collection.add(new eo((byte)0, (byte)1, new t(centerX, n2), x - w, n + w, a2, 0.9));
        collection.add(new eo((byte)1, (byte)8, new t(x, centerY), y - w, n2 + w, a, 0.9));
        collection.add(new eo((byte)1, (byte)4, new t(n, centerY), y - w, n2 + w, a, 0.9));
        final double h = this.h;
        if (h > 0.0) {
            collection.add(new ex((byte)0, (byte)2, new t(centerX, y - h), x - w, n + w, a2, 0.95, h));
            collection.add(new ex((byte)0, (byte)1, new t(centerX, n2 + h), x - w, n + w, a2, 0.95, h));
            collection.add(new ex((byte)1, (byte)8, new t(x - h, centerY), y - w, n2 + w, a, 0.95, h));
            collection.add(new ex((byte)1, (byte)4, new t(n + h, centerY), y - w, n2 + w, a, 0.95, h));
        }
        final double i = this.i;
        if (i >= 0.0) {
            collection2.add(new ex((byte)0, (byte)2, new t(centerX, y - i), x - w, n + w, a2, 0.95, i));
            collection2.add(new ex((byte)0, (byte)1, new t(centerX, n2 + i), x - w, n + w, a2, 0.95, i));
            collection2.add(new ex((byte)1, (byte)8, new t(x - i, centerY), y - w, n2 + w, a, 0.95, i));
            collection2.add(new ex((byte)1, (byte)4, new t(n + i, centerY), y - w, n2 + w, a, 0.95, i));
        }
        final eo eo = new eo((byte)0, (byte)16, new t(centerX, centerY), a2, 1.0);
        final eo eo2 = new eo((byte)1, (byte)16, new t(centerX, centerY), a, 1.0);
        collection.add(eo);
        collection.add(eo2);
        collection2.add(eo);
        collection2.add(eo2);
        collection.add(new eo((byte)0, (byte)1, new t(centerX, y), a2, 0.5));
        collection.add(new eo((byte)0, (byte)2, new t(centerX, n2), a2, 0.5));
        collection.add(new eo((byte)1, (byte)4, new t(x, centerY), a, 0.5));
        collection.add(new eo((byte)1, (byte)8, new t(n, centerY), a, 0.5));
    }
    
    protected void a(final q q, final a a, final Collection collection, final Collection collection2) {
        final boolean z = fj.z;
        final Object a2 = am.a(q, Boolean.TRUE);
        final Object a3 = am.a(q, Boolean.FALSE);
        final ArrayList list = new ArrayList<y.h.b.c>();
        list.addAll(a.l().o());
        while (true) {
            while (!list.isEmpty()) {
                final ArrayList list2 = list;
                if (z) {
                    final ArrayList<y.h.b.c> list3 = (ArrayList<y.h.b.c>)list2;
                    list3.addAll(a.l().l());
                    while (!list3.isEmpty()) {
                        final y.h.b.c c = list3.remove(0);
                        if (c.l().isEmpty()) {
                            final Rectangle2D h = c.h();
                            collection.add(new gy((byte)1, (byte)16, new t(h.getCenterX(), h.getY()), h.getY(), h.getMaxY(), a2, 0.9));
                            if (!z) {
                                continue;
                            }
                        }
                        list3.addAll(c.l());
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                final f f = (f)list2.remove(0);
                if (f.o().isEmpty()) {
                    final Rectangle2D h2 = f.h();
                    collection.add(new gy((byte)0, (byte)16, new t(h2.getX(), h2.getCenterY()), h2.getX(), h2.getMaxX(), a3, 0.9));
                    if (!z) {
                        continue;
                    }
                }
                list.addAll(f.o());
                if (z) {
                    break;
                }
            }
            final ArrayList list4 = new ArrayList();
            continue;
        }
    }
    
    protected void b(final Collection collection, final Collection collection2) {
        final bu graph2D = this.c().getGraph2D();
        if (this.k) {
            this.e(collection, collection2);
        }
        if (this.l) {
            this.c(collection, collection2);
        }
        if (this.f || this.g) {
            new ed(this, graph2D, collection, collection2).a(graph2D, this.q, this.c().getVisibleRect().getBounds2D(), true);
            new ee(this, graph2D, collection, collection2).a(graph2D, this.q, this.c().getVisibleRect().getBounds2D(), false);
        }
        if (this.z) {
            this.d(collection, collection2);
        }
    }
    
    private void c(final Collection collection, final Collection collection2) {
        final boolean z = fj.z;
        final bu graph2D = this.c().getGraph2D();
        for (final q q : this.q) {
            if (this.a(graph2D.t(q))) {
                this.a(q, collection, collection2);
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void d(final Collection collection, final Collection collection2) {
        final boolean z = fj.z;
        if ((collection.isEmpty() && collection2.isEmpty()) || this.q.isEmpty()) {
            return;
        }
        final bu graph2D = this.c().getGraph2D();
        final ArrayList<es> list = new ArrayList<es>();
        final ArrayList<es> list2 = new ArrayList<es>();
        final Iterator<q> iterator = this.q.iterator();
        while (iterator.hasNext()) {
            final fj t = graph2D.t(iterator.next());
            if (this.a(t)) {
                list.add(new es(t.getX(), t.getY(), t.getY() + t.getHeight(), true));
                list.add(new es(t.getX() + t.getWidth(), t.getY(), t.getY() + t.getHeight(), false));
                list2.add(new es(t.getY(), t.getX(), t.getX() + t.getWidth(), true));
                list2.add(new es(t.getY() + t.getHeight(), t.getX(), t.getX() + t.getWidth(), false));
                if (z) {
                    break;
                }
                continue;
            }
        }
        final HashSet set = new HashSet();
        set.addAll(collection);
        set.addAll(collection2);
        this.a(list, list2, set);
        this.a(list);
        this.a(list2);
    }
    
    private void a(final List list) {
        final boolean z = fj.z;
        y.g.e.a(list, null);
        final ai ai = new ai(new ef(this));
    Label_0150_Outer:
        for (final ey ey : list) {
            Label_0266: {
                if (ey instanceof es) {
                    final es es = (es)ey;
                    final eq eq = new eq(null, 0.0, es.a, 0.0, null);
                    final eq eq2 = new eq(null, 0.0, es.c, 0.0, null);
                    if (ai.a() != 0) {
                        final aj c = ai.c(eq2);
                        aj aj = ai.b(eq);
                        while (true) {
                            Label_0143: {
                                if (aj != null) {
                                    break Label_0143;
                                }
                                aj = ai.b();
                                if (z) {
                                    break Label_0143;
                                }
                                while (aj != c) {
                                    final eq eq3 = (eq)aj.c();
                                    aj = aj.a();
                                    if (es.b) {
                                        if (es.f <= eq3.c) {
                                            continue Label_0150_Outer;
                                        }
                                        eq3.a.b(es.f);
                                        ai.a(eq3.e);
                                        eq3.e = null;
                                        if (!z) {
                                            continue Label_0150_Outer;
                                        }
                                    }
                                    if (es.f < eq3.c) {
                                        eq3.a.a(es.f);
                                        if (z) {
                                            break Label_0150_Outer;
                                        }
                                        if (z) {
                                            break Label_0266;
                                        }
                                        continue Label_0150_Outer;
                                    }
                                }
                                continue Label_0150_Outer;
                            }
                            aj = aj.a();
                            continue;
                        }
                    }
                    continue;
                }
            }
            final eq eq4 = (eq)ey;
            if (eq4.d == null) {
                eq4.e = ai.a(eq4);
                if (!z) {
                    continue;
                }
            }
            if (eq4.d.e != null) {
                ai.a(eq4.d.e);
                eq4.d.e = null;
                if (z) {
                    break;
                }
                continue;
            }
        }
    }
    
    private void a(final List list, final List list2, final Collection collection) {
        final boolean z = fj.z;
        for (final gy gy : collection) {
            final t b = gy.b();
            if (gy.c() == 0) {
                final eq eq = new eq(gy, gy.e(), b.b, b.a, null);
                list.add(eq);
                list.add(new eq(gy, gy.f(), b.b, b.a, eq));
                if (!z) {
                    continue;
                }
            }
            final eq eq2 = new eq(gy, gy.e(), b.a, b.b, null);
            list2.add(eq2);
            list2.add(new eq(gy, gy.f(), b.a, b.b, eq2));
            if (z) {
                break;
            }
        }
    }
    
    private void e(final Collection collection, final Collection collection2) {
        final boolean z = fj.z;
        final bu graph2D = this.c().getGraph2D();
        final HashMap hashMap = new HashMap(this.b.size());
        final HashMap hashMap2 = new HashMap(this.y.size());
        this.a(hashMap, hashMap2, null);
        final y.c.e p2 = graph2D.p();
        while (p2.f()) {
            final aB i = graph2D.i(p2.a());
            dU du = this;
        Label_0092:
            while (true) {
                final el[] a = du.a(i, hashMap, hashMap2);
                int j = 1;
                while (j < a.length) {
                    final el el = a[j - 1];
                    final el el2 = a[j];
                    du = this;
                    if (z) {
                        continue Label_0092;
                    }
                    this.a(collection, collection2, i, el.b(), el2.b(), el.d() && el2.d(), el.c() && el2.c());
                    ++j;
                    if (z) {
                        break;
                    }
                }
                break;
            }
            p2.g();
            if (z) {
                break;
            }
        }
    }
    
    private void a(final Collection collection, final Collection collection2, final aB ab, final t t, final t t2, final boolean b, final boolean b2) {
        final double i = this.i;
        final double j = this.j;
        if (t.a == t2.a && b) {
            if (!this.a(ab, t, t2)) {
                return;
            }
            final Object a = am.a(ab.getEdge(), Boolean.TRUE);
            final t t3 = new t(t.a, (t2.b + t.b) * 0.5);
            final double n = Math.min(t.b, t2.b) - this.w;
            final double n2 = Math.max(t.b, t2.b) + this.w;
            collection2.add(new eo((byte)1, (byte)4, t3, a, 0.2));
            collection2.add(new eo((byte)1, (byte)8, t3, a, 0.2));
            if (i > 0.0) {
                collection.add(new ex((byte)1, (byte)4, new t(t3.a + i, t3.b), n, n2, a, 0.4, i));
                collection.add(new ex((byte)1, (byte)8, new t(t3.a - i, t3.b), n, n2, a, 0.4, i));
            }
            if (j <= 0.0) {
                return;
            }
            collection2.add(new ex((byte)1, (byte)4, new t(t3.a + j, t3.b), n, n2, a, 0.4, j));
            collection2.add(new ex((byte)1, (byte)8, new t(t3.a - j, t3.b), n, n2, a, 0.4, j));
            if (!fj.z) {
                return;
            }
        }
        if (t.b == t2.b && b2 && this.a(ab, t, t2)) {
            final Object a2 = am.a(ab.getEdge(), Boolean.FALSE);
            final t t4 = new t((t.a + t2.a) * 0.5, t2.b);
            final double n3 = Math.min(t.a, t2.a) - this.w;
            final double n4 = Math.max(t.a, t2.a) + this.w;
            collection2.add(new eo((byte)0, (byte)1, t4, a2, 0.2));
            collection2.add(new eo((byte)0, (byte)2, t4, a2, 0.2));
            if (i > 0.0) {
                collection.add(new ex((byte)0, (byte)1, new t(t4.a, t4.b + i), n3, n4, a2, 0.4, i));
                collection.add(new ex((byte)0, (byte)2, new t(t4.a, t4.b - i), n3, n4, a2, 0.4, i));
            }
            if (j > 0.0) {
                collection2.add(new ex((byte)0, (byte)1, new t(t4.a, t4.b + j), n3, n4, a2, 0.4, j));
                collection2.add(new ex((byte)0, (byte)2, new t(t4.a, t4.b - j), n3, n4, a2, 0.4, j));
            }
        }
    }
    
    public t b(final t t) {
        final boolean z = fj.z;
        if (!this.v) {
            return t;
        }
        final ArrayList<eh> list = new ArrayList<eh>();
        final double n = this.e() / this.c().getZoom();
        this.a(n, this.m, t.a, list, true);
        this.a(n, this.n, t.b, list, false);
        final double n2 = t.a - this.k().a;
        final double n3 = t.b - this.k().b;
    Label_0102:
        while (true) {
            Iterator<gy> iterator2;
            Iterator<q> iterator4;
            Iterator<q> iterator3;
            Iterator<q> iterator5;
            Iterator<q> iterator6;
            q q;
            Rectangle2D.Double double1;
            double n4;
            double n5;
            double n6;
            double n7;
            eu eu;
            int i;
            Iterator<el> iterator8;
            Iterator<el> iterator7;
            Iterator<el> iterator9;
            el el;
            t b;
            boolean d;
            double n8;
            boolean c;
            double n9;
            int j;
            dU du = null;
            Iterator<gy> iterator10;
            Iterator<el> iterator11;
            Label_0255:Label_0547_Outer:Label_0776_Outer:
            for (final en en : this.t) {
                iterator2 = (Iterator<gy>)this.e.iterator();
                while (iterator2.hasNext()) {
                    this.a(en, n2, n3, n, list, iterator2.next());
                    if (z) {
                        continue Label_0102;
                    }
                    if (z) {
                        break;
                    }
                }
                if (!this.j().isEmpty()) {
                    iterator3 = (iterator4 = this.j().iterator());
                    if (!z) {
                        iterator5 = iterator3;
                        while (iterator5.hasNext()) {
                            this.a(en, n2, n3, n, list, (gy)iterator5.next());
                            if (z || z) {
                                break Label_0255;
                            }
                        }
                    }
                    else {
                        iterator6 = iterator4;
                    Label_0776:
                        while (true) {
                            while (true) {
                            Label_0531:
                                while (iterator6.hasNext()) {
                                    q = iterator6.next();
                                    try {
                                        double1 = (Rectangle2D.Double)this.c.b(q);
                                        if (double1 == null && !z) {
                                            continue Label_0547_Outer;
                                        }
                                    }
                                    catch (Exception ex) {
                                        continue Label_0547_Outer;
                                    }
                                    n4 = double1.getX() + n2;
                                    n5 = n4 + double1.getWidth();
                                    n6 = double1.getY() + n3;
                                    n7 = n6 + double1.getHeight();
                                    eu = new eu(this.c().getGraph2D().t(q));
                                    i = 0;
                                    while (i < this.d.size()) {
                                        this.a((gy)this.d.get(i), eu, t, n4, n6, n5, n7, n, list);
                                        ++i;
                                        if (z) {
                                            continue Label_0776;
                                        }
                                        if (z) {
                                            break;
                                        }
                                    }
                                    if (!this.j().isEmpty()) {
                                        iterator7 = (iterator8 = this.j().iterator());
                                        if (z) {
                                            iterator9 = iterator8;
                                            Label_0777: {
                                                while (iterator9.hasNext()) {
                                                    el = iterator9.next();
                                                    b = el.b();
                                                    d = el.d();
                                                    n8 = (d ? b.a : (b.a + n2));
                                                    c = el.c();
                                                    n9 = (c ? b.b : (b.b + n3));
                                                    j = 0;
                                                    while (j < this.e.size()) {
                                                        this.a((gy)this.e.get(j), t, d, c, n8, n9, list);
                                                        ++j;
                                                        if (z) {
                                                            continue Label_0777;
                                                        }
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                    if (!this.j().isEmpty()) {
                                                        du = this;
                                                        if (z) {
                                                            break Label_0777;
                                                        }
                                                        iterator10 = (Iterator<gy>)this.j().iterator();
                                                        while (iterator10.hasNext()) {
                                                            this.a(iterator10.next(), t, d, c, n8, n9, list);
                                                            if (z || z) {
                                                                break Label_0776;
                                                            }
                                                        }
                                                    }
                                                }
                                                du = this;
                                            }
                                            if (du.o) {
                                                if (Math.abs(n2) < Math.abs(n3)) {
                                                    if (Math.abs(n2) >= n) {
                                                        return this.a(list, t);
                                                    }
                                                    list.add(new eh(this, 10.0, new eg(this, t)));
                                                    if (!z) {
                                                        return this.a(list, t);
                                                    }
                                                }
                                                if (Math.abs(n3) < n) {
                                                    list.add((eh)new ej(this, 10.0, new ei(this, t)));
                                                }
                                            }
                                            return this.a(list, t);
                                        }
                                        iterator11 = iterator7;
                                        while (iterator11.hasNext()) {
                                            this.a((gy)iterator11.next(), eu, t, n4, n6, n5, n7, n, list);
                                            if (z || z) {
                                                break Label_0531;
                                            }
                                        }
                                    }
                                }
                                if (this.p) {
                                    iterator8 = this.x.iterator();
                                    continue Label_0776_Outer;
                                }
                                break;
                            }
                            continue Label_0776;
                        }
                    }
                }
            }
            iterator4 = this.a.iterator();
            continue;
        }
    }
    
    private void a(final gy gy, final t t, final boolean b, final boolean b2, final double n, final double n2, final List list) {
        if (gy.c() == 0) {
            if (b2 || gy.e() > n || gy.f() < n) {
                return;
            }
            final double n3 = gy.b().b - n2;
            if (Math.abs(n3) >= 5.0) {
                return;
            }
            list.add(gz.a(0.1, gy, false, t.b + n3));
            if (!fj.z) {
                return;
            }
        }
        if (!b && gy.e() <= n2 && gy.f() >= n2) {
            final double n4 = gy.b().a - n;
            if (Math.abs(n4) < 5.0) {
                list.add(gz.a(0.1, gy, true, t.a + n4));
            }
        }
    }
    
    private void a(final gy gy, final Rectangle2D rectangle2D, final t t, final double n, final double n2, final double n3, final double n4, final double n5, final List list) {
        final boolean z = fj.z;
        Label_0660: {
            switch (gy.d()) {
                case 16: {
                    if (gy.c() == 1) {
                        if (n2 >= gy.f() || n4 <= gy.e()) {
                            break;
                        }
                        final double n6 = gy.b().a - (n + n3) * 0.5;
                        final double abs = Math.abs(n6);
                        if (abs >= n5) {
                            break;
                        }
                        list.add(gz.a((n5 - abs) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, true, t.a + n6, gy.g()));
                        if (!z) {
                            break;
                        }
                    }
                    if (n >= gy.f() || n3 <= gy.e()) {
                        break;
                    }
                    final double n7 = gy.b().b - (n2 + n4) * 0.5;
                    final double abs2 = Math.abs(n7);
                    if (abs2 >= n5) {
                        break;
                    }
                    list.add(gz.a((n5 - abs2) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, false, t.b + n7, gy.g()));
                    if (z) {
                        break Label_0660;
                    }
                    break;
                }
                case 1: {
                    if (n >= gy.f() || n3 <= gy.e()) {
                        break;
                    }
                    final double n8 = gy.b().b - n2;
                    final double abs3 = Math.abs(n8);
                    if (abs3 >= n5) {
                        break;
                    }
                    list.add(gz.a((n5 - abs3) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, false, t.b + n8, gy.g()));
                    if (z) {
                        break Label_0660;
                    }
                    break;
                }
                case 8: {
                    if (n2 >= gy.f() || n4 <= gy.e()) {
                        break;
                    }
                    final double n9 = gy.b().a - n3;
                    final double abs4 = Math.abs(n9);
                    if (abs4 >= n5) {
                        break;
                    }
                    list.add(gz.a((n5 - abs4) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, true, t.a + n9, gy.g()));
                    if (z) {
                        break Label_0660;
                    }
                    break;
                }
                case 2: {
                    if (n >= gy.f() || n3 <= gy.e()) {
                        break;
                    }
                    final double n10 = gy.b().b - n4;
                    final double abs5 = Math.abs(n10);
                    if (abs5 >= n5) {
                        break;
                    }
                    list.add(gz.a((n5 - abs5) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, false, t.b + n10, gy.g()));
                    if (z) {
                        break Label_0660;
                    }
                    break;
                }
                case 4: {
                    if (n2 >= gy.f() || n4 <= gy.e()) {
                        break;
                    }
                    final double n11 = gy.b().a - n;
                    final double abs6 = Math.abs(n11);
                    if (abs6 < n5) {
                        list.add(gz.a((n5 - abs6) * gy.a(), (gy instanceof id) ? ((id)gy).a(rectangle2D) : gy, true, t.a + n11, gy.g()));
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void a(final en en, final double n, final double n2, final double n3, final List list, final gy gy) {
        final gz a = en.a(gy, this.k(), n, n2, n3);
        if (a != gz.b) {
            list.add(a);
        }
    }
    
    private void a(final double n, final ai ai, final double n2, final List list, final boolean b) {
        final boolean z = fj.z;
        if (ai.a() == 0) {
            return;
        }
        aj aj = ai.b(new ev(n2, null, null));
        aj a = (aj != null) ? aj.a() : ai.b();
        final double n3 = (aj != null) ? ((ev)aj.c()).a : Double.POSITIVE_INFINITY;
        final double n4 = (a != null) ? ((ev)a.c()).a : Double.POSITIVE_INFINITY;
        final double n5 = n3 - n2;
        final double n6 = n4 - n2;
        ev ev = null;
        Label_0193: {
            if (Math.abs(n5) < n) {
                if (Math.abs(n6) < Math.abs(n5)) {
                    ev = (ev)a.c();
                    if (!z) {
                        break Label_0193;
                    }
                }
                ev = (ev)aj.c();
                if (!z) {
                    break Label_0193;
                }
            }
            if (Math.abs(n6) < n) {
                ev = (ev)a.c();
                if (!z) {
                    break Label_0193;
                }
            }
            ev = null;
        }
        if (ev != null) {
            while (true) {
                while (a != null) {
                    final double n7 = dcmpl(((ev)a.c()).a, ev.a);
                    if (!z) {
                        if (n7 != 0) {
                            break;
                        }
                        list.add(((ev)a.c()).a(b));
                        a = a.a();
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (n7 != 0) {
                            return;
                        }
                        list.add(((ev)aj.c()).a(b));
                        aj = aj.b();
                        if (z) {
                            return;
                        }
                        break;
                    }
                }
                if (aj != null) {
                    final double n8 = dcmpl(((ev)aj.c()).a, ev.a);
                    continue;
                }
                break;
            }
        }
    }
    
    protected void a(final q q, final Collection collection, final Collection collection2) {
        final fj t = this.c().getGraph2D().t(q);
        if (this.a(t)) {
            this.a(q, t, collection, collection2);
        }
    }
    
    static double a(final dU du) {
        return du.w;
    }
    
    static boolean b(final dU du) {
        return du.g;
    }
    
    static boolean c(final dU du) {
        return du.f;
    }
}
