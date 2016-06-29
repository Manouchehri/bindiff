package y.f;

import java.util.*;
import y.a.*;
import y.f.b.*;
import y.g.*;
import java.awt.geom.*;
import y.f.e.*;
import y.c.*;
import y.d.*;

public class e extends a
{
    public static final Object a;
    public static final Object b;
    private double c;
    private double d;
    private double e;
    private double f;
    private boolean g;
    private boolean h;
    private byte i;
    private boolean n;
    private k[] o;
    
    public e() {
        this.f = 45.0;
        this.g = true;
        this.h = true;
        this.i = 1;
        this.n = true;
        this.a(400.0, 400.0);
    }
    
    public void a(final double c, final double d) {
        this.c = c;
        this.d = d;
    }
    
    protected int a(final X x, final A a) {
        final boolean j = X.j;
        final c c = x.c(y.f.e.b);
        if (c != null) {
            final ArrayList list = new ArrayList<Object>();
            final HashMap<Object, List<q>> hashMap = new HashMap<Object, List<q>>();
            hashMap.put(null, new ArrayList<q>());
            final x o = x.o();
            while (true) {
            Label_0412_Outer:
                while (o.f()) {
                    final q e = o.e();
                    final Object b = c.b(e);
                    final List<q> list3;
                    List<q> list2 = list3 = hashMap.get(b);
                    if (!j) {
                        if (list3 == null) {
                            list2 = new ArrayList<q>();
                            hashMap.put(b, list2);
                            list.add(b);
                        }
                        list2.add(e);
                        o.g();
                        if (j) {
                            break;
                        }
                        continue;
                    }
                    else {
                        final List<q> list4 = list3;
                        hashMap.remove(null);
                        if (list4.size() == 0) {
                            if (hashMap.size() < 2) {
                                final x o2 = x.o();
                                while (o2.f()) {
                                    a.a(o2.e(), 0);
                                    o2.g();
                                    if (j) {
                                        break;
                                    }
                                }
                                return 1;
                            }
                            y.g.e.a(list, null);
                            int i = 0;
                        Label_0344_Outer:
                            while (i < list.size()) {
                                final Iterator<Object> iterator = hashMap.get(list.get(i)).iterator();
                                while (true) {
                                    while (iterator.hasNext()) {
                                        a.a(iterator.next(), i);
                                        if (!j) {
                                            if (j) {
                                                break;
                                            }
                                            continue Label_0344_Outer;
                                        }
                                        else {
                                            if (j) {
                                                break Label_0344_Outer;
                                            }
                                            continue Label_0344_Outer;
                                        }
                                    }
                                    ++i;
                                    continue;
                                }
                            }
                            return list.size();
                        }
                        else {
                            if (!hashMap.isEmpty()) {
                                final int[] array = new int[this.b(x, a)];
                                int k = 0;
                                while (true) {
                                Label_0515_Outer:
                                    while (k < array.length) {
                                        array[k] = -1;
                                        ++k;
                                        if (j) {
                                            while (true) {
                                                ArrayList<q> list5;
                                                Iterator<Object> iterator2;
                                                int l;
                                                int n;
                                                Iterator<Object> iterator3;
                                                Label_0508:Label_0615_Outer:
                                                while (k < list.size()) {
                                                    list5 = hashMap.get(list.get(k));
                                                    if (!j) {
                                                        iterator2 = list5.iterator();
                                                        while (true) {
                                                            while (iterator2.hasNext()) {
                                                                array[a.a(iterator2.next())] = k;
                                                                if (!j) {
                                                                    if (j) {
                                                                        break;
                                                                    }
                                                                    continue Label_0412_Outer;
                                                                }
                                                                else {
                                                                    if (j) {
                                                                        break Label_0508;
                                                                    }
                                                                    continue Label_0412;
                                                                }
                                                            }
                                                            ++k;
                                                            continue Label_0515_Outer;
                                                        }
                                                    }
                                                    l = 0;
                                                Label_0615:
                                                    while (true) {
                                                        while (l < array.length) {
                                                            n = array[l];
                                                            if (j) {
                                                            Label_0698_Outer:
                                                                while (true) {
                                                                    if (n < list.size()) {
                                                                        iterator3 = hashMap.get(list.get(l)).iterator();
                                                                        while (true) {
                                                                            while (iterator3.hasNext()) {
                                                                                a.a(iterator3.next(), l);
                                                                                if (!j) {
                                                                                    if (j) {
                                                                                        break;
                                                                                    }
                                                                                    continue Label_0412_Outer;
                                                                                }
                                                                                else {
                                                                                    if (j) {
                                                                                        return k;
                                                                                    }
                                                                                    break Label_0615;
                                                                                }
                                                                            }
                                                                            Label_0695: {
                                                                                break Label_0695;
                                                                                continue Label_0698_Outer;
                                                                            }
                                                                            ++l;
                                                                            continue Label_0615_Outer;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                                return k;
                                                            }
                                                            if (n < 0) {
                                                                array[l] = k++;
                                                            }
                                                            ++l;
                                                            if (j) {
                                                                break;
                                                            }
                                                        }
                                                        for (final q q : list4) {
                                                            a.a(q, array[a.a(q)]);
                                                            if (j) {
                                                                break;
                                                            }
                                                        }
                                                        l = 0;
                                                        continue Label_0615;
                                                    }
                                                }
                                                k = list.size();
                                                continue;
                                            }
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                    k = 0;
                                    continue;
                                }
                            }
                            return this.b(x, a);
                        }
                    }
                }
                final ArrayList<q> list6 = hashMap.get(null);
                continue;
            }
        }
        return this.b(x, a);
    }
    
    private int b(final X x, final A a) {
        final boolean j = X.j;
        if (!this.e() || !y.f.b.c.b(x)) {
            return y.a.h.a(x, a);
        }
        final c c = x.c(y.f.b.f.b);
        final c c2 = x.c(y.f.b.f.c);
        final HashMap<Object, q> hashMap = new HashMap<Object, q>();
        final x o = x.o();
        while (o.f()) {
            hashMap.put(c.b(o.e()), o.e());
            o.g();
            if (j) {
                break;
            }
        }
        final y.c.f f = new y.c.f();
        final x o2 = x.o();
        while (o2.f()) {
            final q e = o2.e();
            final Object b = c2.b(e);
            if (b != null) {
                final q q = hashMap.get(b);
                if (q != null) {
                    f.c(x.a(e, q));
                }
            }
            o2.g();
            if (j) {
                break;
            }
        }
        final int a2 = y.a.h.a(x, a);
        while (f.size() > 0) {
            x.a(f.d());
            if (j) {
                break;
            }
        }
        return a2;
    }
    
    public void c(final X x) {
        final boolean j = X.j;
        if (x.i()) {
            return;
        }
        final A t = x.t();
        try {
            final I i = new I(x);
            final c c = x.c(y.f.e.b);
            if (c != null) {
                this.a(i, x, c);
            }
            final int a = this.a(x, t);
            this.o = new k[a];
            final c c2 = x.c(y.f.e.a);
            int k = 0;
        Label_0998:
            while (true) {
                k l;
                x a2 = null;
                x x2;
                e e = null;
                k m;
                y.c.e a3;
                y[] array;
                y.c.f[] array2;
                y.d.y[] array3;
                Rectangle2D.Double[] array4;
                int n;
                c c3 = null;
                y.c.e p;
                d a4;
                x o;
                q e2;
                k k2;
                x x3;
                Point2D.Double e3;
                Point2D.Double e4;
                y.c.e a5;
                Rectangle2D b;
                Rectangle2D b2;
                y.c.e a6;
                x a7;
                Point2D.Double c4;
                Point2D.Double c5;
                Point2D.Double c6;
                Point2D.Double c7;
                Point2D.Double e5;
                Point2D.Double e6;
                Label_1023:Label_1255_Outer:
                while (true) {
                Label_1255:
                    while (true) {
                        Label_1017_Outer:Label_1119_Outer:
                        while (k < a) {
                            this.o[k] = new k();
                            l = this.o[k];
                            if (j) {
                                Label_1125: {
                                    Label_1124: {
                                        Label_1063: {
                                            while (true) {
                                                l.a.a();
                                                x2 = a2;
                                                while (x2.f()) {
                                                    x.d(x2.e());
                                                    x2.g();
                                                    if (j) {
                                                        break Label_0998;
                                                    }
                                                    if (j) {
                                                        break;
                                                    }
                                                }
                                                break Label_1063;
                                                if (k >= a) {
                                                    break Label_1124;
                                                }
                                                e = this;
                                                if (!j) {
                                                    m = this.o[k];
                                                    continue Label_1119_Outer;
                                                }
                                                break;
                                            }
                                            break Label_1125;
                                        }
                                        a3 = this.o[k].b.a();
                                        while (true) {
                                            while (a3.f()) {
                                                x.e(a3.a());
                                                a3.g();
                                                if (!j) {
                                                    if (j) {
                                                        break;
                                                    }
                                                    continue Label_1017_Outer;
                                                }
                                                else {
                                                    if (j) {
                                                        break Label_1124;
                                                    }
                                                    continue Label_0998;
                                                }
                                            }
                                            ++k;
                                            continue Label_1255_Outer;
                                        }
                                    }
                                    e = this;
                                }
                                if (e.h) {
                                    array = new y[a];
                                    array2 = new y.c.f[a];
                                    array3 = new y.d.y[a];
                                    array4 = new Rectangle2D.Double[a];
                                    n = 0;
                                    while (n < a) {
                                        array[n] = this.o[n].a;
                                        array2[n] = this.o[n].b;
                                        array3[n] = this.o[n].h;
                                        array4[n] = this.o[n].g;
                                        ++n;
                                        if (j) {
                                            break Label_1255;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                    this.a(x, array, array2, array3, array4);
                                }
                                if (c3 != null) {
                                    this.a(i);
                                }
                                y.g.o.a(this, "done !");
                                return;
                            }
                            l.i = (c2 == null);
                            ++k;
                            if (j) {
                                break;
                            }
                        }
                        p = x.p();
                        while (p.f()) {
                            a4 = p.a();
                            this.o[t.a(a4.c())].b.add(a4);
                            x.d(a4);
                            p.g();
                            if (j) {
                                continue Label_1255;
                            }
                            if (j) {
                                break;
                            }
                        }
                        o = x.o();
                        while (o.f()) {
                            e2 = o.e();
                            c3 = c2;
                            if (j) {
                                continue Label_1255;
                            }
                            if (c3 != null && c2.d(e2)) {
                                this.o[t.a(e2)].i = true;
                            }
                            this.o[t.a(e2)].a.add(e2);
                            x.c(o.e());
                            o.g();
                            if (j) {
                                break;
                            }
                        }
                        break;
                    }
                    k = 0;
                Label_0317:
                    while (k < a) {
                        k2 = this.o[k];
                        k2.e.x = 0.0;
                        k2.e.y = 0.0;
                        a2 = k2.a.a();
                        if (!j) {
                            x3 = a2;
                            while (true) {
                                while (x3.f()) {
                                    e3 = k2.e;
                                    e3.x += x.j(x3.e());
                                    e4 = k2.e;
                                    e4.y += x.k(x3.e());
                                    x.d(x3.e());
                                    x3.g();
                                    if (j) {
                                        a5 = k2.b.a();
                                        while (a5.f()) {
                                            x.e(a5.a());
                                            a5.g();
                                            if (j) {
                                                continue Label_0317;
                                            }
                                            if (j) {
                                                break;
                                            }
                                        }
                                        b = this.b(x);
                                        k2.f = new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight());
                                        if (k2.i) {
                                            this.a(x);
                                        }
                                        b2 = this.b(x);
                                        k2.h = new y.d.y(b2.getX(), b2.getY(), b2.getWidth(), b2.getHeight());
                                        k2.d = new Rectangle2D.Double(b2.getX(), b2.getY(), b2.getWidth(), b2.getHeight());
                                        Label_0799: {
                                            if (this.e > 0.0) {
                                                k2.g.setFrame(b2.getX(), b2.getY(), this.f + (Math.ceil((b2.getWidth() + 1.0) / this.e) + 1.0) * this.e, this.f + (Math.ceil((b2.getHeight() + 1.0) / this.e) + 1.0) * this.e);
                                                if (!j) {
                                                    break Label_0799;
                                                }
                                            }
                                            k2.g.setFrame(b2.getX(), b2.getY(), b2.getWidth() + this.f, b2.getHeight() + this.f);
                                        }
                                        a6 = k2.b.a();
                                        while (a6.f()) {
                                            x.d(a6.a());
                                            a6.g();
                                            if (j) {
                                                continue Label_0317;
                                            }
                                            if (j) {
                                                break;
                                            }
                                        }
                                        a7 = k2.a.a();
                                        while (true) {
                                            while (a7.f()) {
                                                c4 = k2.c;
                                                c4.x += x.j(a7.e());
                                                c5 = k2.c;
                                                c5.y += x.k(a7.e());
                                                x.c(a7.e());
                                                a7.g();
                                                if (!j) {
                                                    if (j) {
                                                        break;
                                                    }
                                                    continue Label_1255_Outer;
                                                }
                                                else {
                                                    if (j) {
                                                        break Label_1023;
                                                    }
                                                    continue Label_0317;
                                                }
                                            }
                                            c6 = k2.c;
                                            c6.x /= k2.a.size();
                                            c7 = k2.c;
                                            c7.y /= k2.a.size();
                                            ++k;
                                            continue;
                                        }
                                    }
                                    if (j) {
                                        break;
                                    }
                                }
                                e5 = k2.e;
                                e5.x /= k2.a.size();
                                e6 = k2.e;
                                e6.y /= k2.a.size();
                                continue;
                            }
                        }
                        continue Label_1023;
                    }
                    break;
                }
                k = 0;
                continue Label_0998;
            }
        }
        finally {
            this.o = null;
            x.a(t);
        }
    }
    
    protected Rectangle2D b(final X x) {
        return ae.a(x, x.o(), x.p(), this.b());
    }
    
    public void a(final boolean n) {
        this.n = n;
    }
    
    public boolean b() {
        return this.n;
    }
    
    protected void a(final X x, final y[] array, final y.c.f[] array2, final y.d.y[] array3, final Rectangle2D[] array4) {
        final boolean j = X.j;
        final byte f = this.f();
        if ((f & 0x1F) >= 4) {
            final boolean b = (f & 0x20) == 0x20;
            Label_0132: {
                switch (f & 0x1F) {
                    default: {
                        this.a(x, array, array2, array3, array4, false, true, b);
                        if (j) {
                            break Label_0132;
                        }
                        return;
                    }
                    case 5: {
                        this.a(x, array, array2, array3, array4, false, false, b);
                        if (j) {
                            break Label_0132;
                        }
                        return;
                    }
                    case 6: {
                        this.a(x, array, array2, array3, array4, true, true, b);
                        if (j) {
                            break Label_0132;
                        }
                        return;
                    }
                    case 7: {
                        this.a(x, array, array2, array3, array4, true, false, b);
                        if (j) {
                            break;
                        }
                        return;
                    }
                }
            }
        }
        Label_1000: {
            Label_0577: {
                switch (f & 0x1F) {
                    default: {
                        ae.a(array4, null, this.c / this.d);
                        if (j) {
                            break Label_0577;
                        }
                        break;
                    }
                    case 2: {
                        final Integer[] array5 = new Integer[array.length];
                        double max = -1.7976931348623157E308;
                        int i = 0;
                        while (true) {
                            while (i < array5.length) {
                                array5[i] = new Integer(i);
                                max = Math.max(max, this.o[i].d.getHeight());
                                ++i;
                                if (j) {
                                    double n = 0.0;
                                    int k = 0;
                                    while (k < array5.length) {
                                        final int intValue = array5[k];
                                        array4[intValue].setFrame(n, (max - array4[intValue].getHeight()) * 0.5, array4[intValue].getWidth(), array4[intValue].getHeight());
                                        n += array4[intValue].getWidth();
                                        ++k;
                                        if (j) {
                                            break Label_1000;
                                        }
                                        if (j) {
                                            break Label_0577;
                                        }
                                    }
                                    break Label_0577;
                                }
                                if (j) {
                                    break;
                                }
                            }
                            if ((f & 0x20) == 0x20) {
                                y.g.e.a(array5, new y.f.f(this));
                            }
                            continue;
                        }
                    }
                    case 3: {
                        final Integer[] array6 = new Integer[array.length];
                        double max2 = -1.7976931348623157E308;
                        int l = 0;
                        while (true) {
                            while (l < array6.length) {
                                array6[l] = new Integer(l);
                                max2 = Math.max(max2, this.o[l].d.getWidth());
                                ++l;
                                if (j) {
                                    double n2 = 0.0;
                                    int n3 = 0;
                                    while (n3 < array6.length) {
                                        final int intValue2 = array6[n3];
                                        array4[intValue2].setFrame((max2 - array4[intValue2].getWidth()) * 0.5, n2, array4[intValue2].getWidth(), array4[intValue2].getHeight());
                                        n2 += array4[intValue2].getHeight();
                                        ++n3;
                                        if (j) {
                                            break Label_1000;
                                        }
                                        if (j) {
                                            break Label_0577;
                                        }
                                    }
                                    break Label_0577;
                                }
                                if (j) {
                                    break;
                                }
                            }
                            if ((f & 0x20) == 0x20) {
                                y.g.e.a(array6, new g(this));
                            }
                            continue;
                        }
                    }
                    case 0: {
                        int n4 = 0;
                        while (n4 < array4.length) {
                            final k m = this.o[n4];
                            array4[n4].setRect(array4[n4].getX() + (m.e.x - m.c.x), array4[n4].getY() + (m.e.y - m.c.y), array4[n4].getWidth(), array4[n4].getHeight());
                            ++n4;
                            if (j) {
                                break Label_0577;
                            }
                            if (j) {
                                break;
                            }
                        }
                        if ((f & 0x40) == 0x40) {
                            final w w = new w();
                            final q[] array7 = new q[this.o.length];
                            int n5 = 0;
                            while (n5 < this.o.length) {
                                array7[n5] = w.d();
                                final am a = w.a((Object)array7[n5]);
                                a.setSize(array4[n5].getWidth(), array4[n5].getHeight());
                                a.setLocation(array4[n5].getX(), array4[n5].getY());
                                ++n5;
                                if (j) {
                                    break Label_0577;
                                }
                                if (j) {
                                    break;
                                }
                            }
                            final l l2 = new l();
                            l2.b(true);
                            l2.a(false);
                            l2.a(0.0);
                            l2.a((byte)2);
                            l2.c(w);
                            int n6 = 0;
                            while (n6 < this.o.length) {
                                final am a2 = w.a((Object)array7[n6]);
                                array4[n6].setFrame(a2.getX(), a2.getY(), a2.getWidth(), a2.getHeight());
                                ++n6;
                                if (j) {
                                    break Label_1000;
                                }
                                if (j) {
                                    break;
                                }
                            }
                            break;
                        }
                        break;
                    }
                }
            }
            if (this.e <= 0.0) {
                int n7 = 0;
                while (n7 < array4.length) {
                    this.a(x, array[n7], array2[n7], new t(array4[n7].getX(), array4[n7].getY()), array3[n7]);
                    ++n7;
                    if (j) {
                        break Label_1000;
                    }
                }
                return;
            }
        }
        int n8 = 0;
        while (n8 < array4.length) {
            this.a(x, array[n8], array2[n8], new t(array3[n8].c() + Math.floor((array4[n8].getX() - array3[n8].c()) / this.e) * this.e, array3[n8].d() + Math.floor((array4[n8].getY() - array3[n8].d()) / this.e) * this.e), array3[n8]);
            ++n8;
            if (j) {
                break;
            }
        }
    }
    
    protected void a(final X x, final y y, final y.c.f f, final t t, final y.d.y y2) {
        final boolean j = X.j;
        final double n = -y2.c() + t.a();
        final double n2 = -y2.d() + t.b();
        final x a = y.a();
        while (a.f()) {
            final t o = x.o(a.e());
            x.b(a.e(), new t(o.a() + n, o.b() + n2));
            a.g();
            if (j) {
                break;
            }
        }
        final y.c.e a2 = f.a();
    Label_0248_Outer:
        while (a2.f()) {
            final d a3 = a2.a();
            final ArrayList<t> list = new ArrayList<t>();
            if (!j) {
                final C a4 = x.j(a3).a();
                while (true) {
                    while (a4.f()) {
                        final t t2 = (t)a4.d();
                        list.add(new t(t2.a() + n, t2.b() + n2));
                        a4.g();
                        if (!j) {
                            if (j) {
                                break;
                            }
                            continue Label_0248_Outer;
                        }
                        else {
                            if (j) {
                                break Label_0248_Outer;
                            }
                            continue Label_0248_Outer;
                        }
                    }
                    x.b(a3, new v(list));
                    a2.g();
                    continue;
                }
            }
            return;
        }
        this.b(x, y, f, t, y2);
    }
    
    private void a(final I i, final X x, final c c) {
        final boolean j = X.j;
        final y.c.e p3 = x.p();
        while (p3.f()) {
            final d a = p3.a();
            if (c.b(a.c()) != null && c.b(a.d()) != null && !c.b(a.c()).equals(c.b(a.d()))) {
                i.a(a);
            }
            p3.g();
            if (j) {
                break;
            }
        }
    }
    
    private void a(final I i) {
        i.f();
    }
    
    private void b(final X x, final y y, final y.c.f f, final t t, final y.d.y y2) {
        final boolean j = X.j;
        final c c = x.c(U.a);
        if (c != null) {
            final double n = -y2.c() + t.a();
            final double n2 = -y2.d() + t.b();
            final y.c.e a = f.a();
            while (a.f()) {
                final S[] array = (S[])c.b(a.a());
                Label_0148: {
                    if (array != null) {
                        int i = 0;
                        while (i < array.length) {
                            array[i].a(array[i].d() + n, array[i].e() + n2);
                            ++i;
                            if (j) {
                                break Label_0148;
                            }
                            if (j) {
                                break;
                            }
                        }
                    }
                    a.g();
                }
                if (j) {
                    break;
                }
            }
        }
    }
    
    public double c() {
        return this.e;
    }
    
    public void a(final double e) {
        this.e = e;
    }
    
    public double d() {
        return this.f;
    }
    
    public void b(final double f) {
        this.f = f;
    }
    
    public boolean e() {
        return this.g;
    }
    
    public byte f() {
        return this.i;
    }
    
    public void a(final byte i) {
        this.i = i;
    }
    
    private j a(final X x, final y y, final y.c.f f, final double n, final double n2, final boolean b) {
        final boolean j = X.j;
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        int n5 = Integer.MAX_VALUE;
        int n6 = Integer.MIN_VALUE;
        final c c = x.c(U.a);
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final double n7 = this.d() * 0.5;
        final x a = y.a();
        while (a.f()) {
            final am a2 = x.a((Object)a.e());
            double1.setFrame(a2.getX() - n7, a2.getY() - n7, a2.getWidth() + n7 * 2.0, a2.getHeight() + n7 * 2.0);
            n3 = Math.min((int)Math.floor(double1.x / n), n3);
            n5 = Math.min((int)Math.floor(double1.y / n2), n5);
            n4 = Math.max((int)Math.floor((double1.x + double1.width) / n), n4);
            n6 = Math.max((int)Math.floor((double1.y + double1.height) / n2), n6);
            a.g();
            if (j) {
                break;
            }
        }
        y.c.e e = f.a();
    Label_0241:
        while (true) {
            while (true) {
                Object o;
                u u;
                u u2;
                S[] array;
                int i;
                S s;
                j k;
                x a3;
                am a4;
                y.c.e e2;
                Object o2;
                s s2;
                s s3;
                m a5;
                S[] array2;
                int l;
                S s4;
                Label_0406_Outer:Label_0446_Outer:Label_0976_Outer:Label_1172_Outer:
                while (e.f()) {
                    u = (u)(o = x.l(e.a()).b());
                    if (!j) {
                        u2 = u;
                        while (true) {
                            while (u2.f()) {
                                n3 = Math.min(n3, (int)Math.floor(u2.a().a / n));
                                n4 = Math.max(n4, (int)Math.floor(u2.a().a / n));
                                n5 = Math.min(n5, (int)Math.floor(u2.a().b / n2));
                                n6 = Math.max(n6, (int)Math.floor(u2.a().b / n2));
                                u2.g();
                                if (!j) {
                                    if (j) {
                                        break;
                                    }
                                    continue Label_0406_Outer;
                                }
                                else {
                                    if (j) {
                                        break Label_0406_Outer;
                                    }
                                    continue Label_0241;
                                }
                            }
                            e.g();
                            continue Label_0446_Outer;
                        }
                    }
                    while (true) {
                        array = (S[])o;
                        if (!j) {
                            Label_0632: {
                                if (array != null) {
                                    i = 0;
                                    while (i < array.length) {
                                        s = array[i];
                                        double1.setFrame(s.d() - n7, s.e() - n7, s.b() + n7 * 2.0, s.c() + n7 * 2.0);
                                        n3 = Math.min((int)Math.floor(double1.x / n), n3);
                                        n5 = Math.min((int)Math.floor(double1.y / n2), n5);
                                        n4 = Math.max((int)Math.floor((double1.x + double1.width) / n), n4);
                                        n6 = Math.max((int)Math.floor((double1.y + double1.height) / n2), n6);
                                        ++i;
                                        if (j) {
                                            break Label_0632;
                                        }
                                        if (j) {
                                            break;
                                        }
                                    }
                                }
                                e.g();
                            }
                            if (!j) {
                                if (e.f()) {
                                    o = c.b(e.a());
                                    continue Label_0976_Outer;
                                }
                            }
                            n3 -= 2;
                            n5 -= 2;
                            n4 += 2;
                            n6 += 2;
                        }
                        break;
                    }
                    k = new j(n3, n5, n4 - n3, n6 - n5);
                    a3 = y.a();
                    while (a3.f()) {
                        a4 = x.a((Object)a3.e());
                        double1.setFrame(a4.getX() - n7, a4.getY() - n7, a4.getWidth() + n7 * 2.0, a4.getHeight() + n7 * 2.0);
                        k.a((int)Math.floor(double1.x / n), (int)Math.floor(double1.y / n2), 1 + (int)Math.floor((double1.x + double1.width) / n), 1 + (int)Math.floor((double1.y + double1.height) / n2));
                        a3.g();
                        if (j) {
                            break;
                        }
                    }
                    e2 = f.a();
                Label_0841:
                    while (true) {
                        while (true) {
                            Label_0965:Label_1000_Outer:
                            while (e2.f()) {
                                s2 = (s)(o2 = x.l(e2.a()).j());
                                if (!j) {
                                    s3 = s2;
                                    while (true) {
                                        while (s3.f()) {
                                            a5 = s3.a();
                                            a(k, a5.c().a, a5.c().b, a5.d().a, a5.d().b, n, n2);
                                            s3.g();
                                            if (!j) {
                                                if (j) {
                                                    break;
                                                }
                                                continue Label_0446_Outer;
                                            }
                                            else {
                                                if (j) {
                                                    break Label_0965;
                                                }
                                                continue Label_0841;
                                            }
                                        }
                                        e2.g();
                                        continue Label_1000_Outer;
                                    }
                                }
                                while (true) {
                                    array2 = (S[])o2;
                                    if (!j) {
                                        Label_1167: {
                                            if (array2 != null) {
                                                l = 0;
                                                while (l < array2.length) {
                                                    s4 = array2[l];
                                                    double1.setFrame(s4.d() - n7, s4.e() - n7, s4.b() + n7 * 2.0, s4.c() + n7 * 2.0);
                                                    k.a((int)Math.floor(double1.x / n), (int)Math.floor(double1.y / n2), 1 + (int)Math.floor((double1.x + double1.width) / n), 1 + (int)Math.floor((double1.y + double1.height) / n2));
                                                    ++l;
                                                    if (j) {
                                                        break Label_1167;
                                                    }
                                                    if (j) {
                                                        break;
                                                    }
                                                }
                                            }
                                            e2.g();
                                        }
                                        if (!j) {
                                            if (e2.f()) {
                                                o2 = c.b(e2.a());
                                                continue Label_0976_Outer;
                                            }
                                        }
                                        if (b) {
                                            k.c();
                                        }
                                    }
                                    break;
                                }
                                return k;
                            }
                            if (c != null) {
                                e2 = f.a();
                                continue Label_1172_Outer;
                            }
                            break;
                        }
                        continue;
                    }
                }
                if (c != null) {
                    e = f.a();
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    static void a(final j j, final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final boolean i = X.j;
        final double n7 = n3 - n;
        final double n8 = n4 - n2;
        double min = 0.1;
        Label_0079: {
            if (n5 > 1.0) {
                int k = 1 + (int)Math.rint(n5);
                while (k > 0) {
                    min /= 10.0;
                    k /= 10;
                    if (i) {
                        break Label_0079;
                    }
                    if (i) {
                        break;
                    }
                }
            }
            min = Math.min(min, 1.0E-5);
        }
        double min2 = 0.1;
        int l = 0;
        Label_0151: {
            if (n6 > 1.0) {
                l = 1 + (int)Math.rint(n6);
                while (l > 0) {
                    min2 /= 10.0;
                    l /= 10;
                    if (i) {
                        break Label_0151;
                    }
                    if (i) {
                        break;
                    }
                }
            }
            min2 = Math.min(min2, 1.0E-5);
            l = (int)Math.floor(n / n5);
        }
        final int n9 = (int)Math.floor(n2 / n6);
        final int n10 = (int)Math.floor(n3 / n5);
        final int n11 = (int)Math.floor(n4 / n6);
        final int n12 = n10 - l;
        final int n13 = n11 - n9;
        if (n12 == 0 || Math.abs(n7) < min) {
            j.a(l, Math.min(n9, n11), l + 1, Math.max(n9, n11) + 1);
            if (!i) {
                return;
            }
        }
        if (n13 == 0 || Math.abs(n8) < min2) {
            j.a(Math.min(l, n10), n9, Math.max(l, n10) + 1, n9 + 1);
            if (!i) {
                return;
            }
        }
        Label_0642: {
            if (Math.abs(n7) > Math.abs(n8)) {
                Label_0482: {
                    if (l > n10) {
                        final double n14 = n8 / n7;
                        double n15 = n4;
                        double n16 = (Math.floor(n3 / n5) + 1.0 - n10) * n14 + n4;
                        final double n17 = n5 * n14;
                        int n18 = n10;
                        while (true) {
                            while (n18 < l) {
                                final int n19 = (int)Math.floor(n15 / n6);
                                final int n20 = (int)Math.floor(n16 / n6);
                                j.a(n18, n19, true);
                                final int n21 = n19;
                                final int n22 = n20;
                                if (!i) {
                                    if (n21 != n22 && n18 < l) {
                                        j.a(n18, n20, true);
                                    }
                                    n15 = n16;
                                    n16 += n17;
                                    ++n18;
                                    if (i) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (n21 == n22) {
                                        return;
                                    }
                                    j.a(l, n9, true);
                                    if (i) {
                                        break Label_0482;
                                    }
                                    return;
                                }
                            }
                            j.a(l, (int)Math.floor(n15 / n6), true);
                            continue;
                        }
                    }
                }
                final double n23 = n8 / n7;
                double n24 = n2;
                double n25 = (Math.floor(n / n5) + 1.0 - l) * n23 + n2;
                final double n26 = n5 * n23;
                int n27 = l;
                while (true) {
                    while (n27 < n10) {
                        final int n28 = (int)Math.floor(n24 / n6);
                        final int n29 = (int)Math.floor(n25 / n6);
                        j.a(n27, n28, true);
                        final int n30 = n28;
                        final int n31 = n29;
                        if (!i) {
                            if (n30 != n31) {
                                j.a(n27, n29, true);
                            }
                            n24 = n25;
                            n25 += n26;
                            ++n27;
                            if (i) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n30 == n31) {
                                return;
                            }
                            j.a(n10, n11, true);
                            if (i) {
                                break Label_0642;
                            }
                            return;
                        }
                    }
                    j.a(n10, (int)Math.floor(n24 / n6), true);
                    continue;
                }
            }
        }
        Label_0812: {
            if (n9 > n11) {
                final double n32 = n7 / n8;
                double n33 = n3;
                double n34 = (Math.floor(n4 / n6) + 1.0 - n11) * n32 + n3;
                final double n35 = n6 * n32;
                int n36 = n11;
                while (true) {
                    while (n36 < n9) {
                        final int n37 = (int)Math.floor(n33 / n5);
                        final int n38 = (int)Math.floor(n34 / n5);
                        j.a(n37, n36, true);
                        final int n39 = n37;
                        final int n40 = n38;
                        if (!i) {
                            if (n39 != n40) {
                                j.a(n38, n36, true);
                            }
                            n33 = n34;
                            n34 += n35;
                            ++n36;
                            if (i) {
                                break;
                            }
                            continue;
                        }
                        else {
                            if (n39 == n40) {
                                return;
                            }
                            j.a(l, n9, true);
                            if (i) {
                                break Label_0812;
                            }
                            return;
                        }
                    }
                    j.a((int)Math.floor(n33 / n5), n9, true);
                    continue;
                }
            }
        }
        final double n41 = n7 / n8;
        double n42 = n;
        double n43 = (Math.floor(n2 / n6) + 1.0 - n9) * n41 + n;
        final double n44 = n6 * n41;
        int n45 = n9;
        while (true) {
            while (n45 < n11) {
                final int n46 = (int)Math.floor(n42 / n5);
                final int n47 = (int)Math.floor(n43 / n5);
                j.a(n46, n45, true);
                final int n48 = n46;
                final int n49 = n47;
                if (!i) {
                    if (n48 != n49) {
                        j.a(n47, n45, true);
                    }
                    n42 = n43;
                    n43 += n44;
                    ++n45;
                    if (i) {
                        break;
                    }
                    continue;
                }
                else {
                    if (n48 != n49) {
                        j.a(n10, n11, true);
                    }
                    return;
                }
            }
            j.a((int)Math.floor(n42 / n5), n11, true);
            continue;
        }
    }
    
    protected void a(final X x, final y[] array, final y.c.f[] array2, final y.d.y[] array3, final Rectangle2D[] array4, final boolean b, final boolean b2, final boolean b3) {
        final boolean j = X.j;
        double n = 0.0;
        double c = 0.0;
        Label_0098: {
            if (this.c() > 0.0) {
                if (this.c() > 10.0) {
                    n = this.c();
                    c = this.c();
                    if (!j) {
                        break Label_0098;
                    }
                }
                int n2 = (int)Math.ceil(10.0 / this.c());
                if (n2 < 1) {
                    n2 = 1;
                }
                c = (n = this.c() * n2);
                if (!j) {
                    break Label_0098;
                }
            }
            c = (n = Math.max(this.d(), 25.0));
        }
        final y.f.i[] array5 = new y.f.i[array.length];
        int i = 0;
        while (true) {
            while (i < array.length) {
                array5[i] = new y.f.i();
                array5[i].a = i;
                array5[i].b = this.a(x, array[i], array2[i], n, c, b2);
                array5[i].c = y.f.j.c(array5[i].b).cardinality();
                ++i;
                if (j) {
                    final j b4 = array5[0].b;
                    int k = 1;
                    while (k < array5.length) {
                        final y.f.i l = array5[k];
                        int n3 = 0;
                        int n4 = 0;
                        Label_0337: {
                            if (b3) {
                                final y.d.y y = array3[l.a];
                                n3 = (int)Math.round((y.c() + y.a() * 0.5) / n);
                                n4 = (int)Math.round((y.d() + y.b() * 0.5) / c);
                                if (!j) {
                                    break Label_0337;
                                }
                            }
                            n3 = b4.c + b4.a / 2;
                            n4 = b4.d + b4.b / 2;
                        }
                        l.b.a(b4, n3, n4, this.c / this.d, b);
                        final int a = l.a;
                        this.a(x, array[a], array2[a], new t(array3[a].c + l.b.a() * n, array3[a].d + l.b.b() * c), array3[a]);
                        l.b = null;
                        ++k;
                        if (j) {
                            break;
                        }
                    }
                    return;
                }
                if (j) {
                    break;
                }
            }
            y.g.e.a(array5, new y.f.h(this));
            continue;
        }
    }
    
    static k[] a(final e e) {
        return e.o;
    }
    
    static {
        a = "y.layout.ComponentLayouter.LAYOUT_NODE_DPKEY";
        b = "y.layout.ComponentLayouter.GIVEN_COMPONENT_ID_DPKEY";
    }
}
