package y.h.b;

import y.d.*;
import y.f.*;
import java.awt.*;
import y.h.*;
import y.h.a.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import y.c.*;

public class a extends e
{
    private static final r I;
    private j J;
    private double K;
    private double L;
    private double M;
    private double N;
    private r O;
    private r P;
    private boolean Q;
    static Class w;
    static Class A;
    static Class B;
    static Class C;
    static Class D;
    static Class E;
    static Class F;
    static Class G;
    public static int H;
    
    public a() {
        this.A();
    }
    
    public a(final fj fj) {
        final int h = a.H;
        super(fj);
        Label_0103: {
            if (fj instanceof a) {
                final a a = (a)fj;
                int i = 0;
                while (i < this.labelCount()) {
                    final eR label = a.getLabel(i);
                    final eR label2 = this.getLabel(i);
                    final al a2 = label2.a();
                    if (a2 instanceof y.h.b.e || a2 instanceof y.h.b.h) {
                        final Object modelParameter = label.getModelParameter();
                        if (modelParameter instanceof n) {
                            label2.setModelParameter(modelParameter);
                        }
                    }
                    ++i;
                    if (h != 0) {
                        break Label_0103;
                    }
                }
                return;
            }
        }
        this.A();
    }
    
    public boolean k() {
        return this.Q;
    }
    
    public void c(final boolean q) {
        this.Q = q;
    }
    
    private double b(final c c) {
        final int h = a.H;
        final List l = c.l();
        if (l.isEmpty()) {
            return c.g();
        }
        final r i = c.i();
        double n = i.b + i.d;
        final Iterator<c> iterator = l.iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + this.b(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        Math.max(n, c.g());
        return n2;
    }
    
    private double y() {
        final int h = a.H;
        final i l = this.l();
        final s s = new s();
        this.b(s);
        double n = s.b + s.d;
        final Iterator iterator = l.l().iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + this.b(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    private double b(final f f) {
        final int h = a.H;
        final List o = f.o();
        if (o.isEmpty()) {
            return f.g();
        }
        final r i = f.i();
        double n = i.a + i.c;
        final Iterator<f> iterator = o.iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + this.b(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        Math.max(n, f.g());
        return n2;
    }
    
    private double z() {
        final int h = a.H;
        final i l = this.l();
        final s s = new s();
        this.a(s);
        double n = s.a + s.c;
        final Iterator iterator = l.o().iterator();
        double n2 = 0.0;
        while (iterator.hasNext()) {
            n2 = n + this.b(iterator.next());
            if (h != 0) {
                return n2;
            }
            n = n2;
            if (h != 0) {
                break;
            }
        }
        return n2;
    }
    
    protected void a(final aZ az) {
        super.a(az);
        if (az instanceof a) {
            final a a = (a)az;
            Label_0051: {
                if (a.J == null) {
                    this.J = null;
                    if (y.h.b.a.H == 0) {
                        break Label_0051;
                    }
                }
                this.J = new j(this, a.J);
            }
            this.K = a.K;
            this.L = a.L;
            this.M = a.M;
            this.N = a.N;
            this.O = a.O;
            this.P = a.P;
            this.Q = a.Q;
        }
    }
    
    public fj createCopy(final fj fj) {
        return new a(fj);
    }
    
    public i l() {
        if (this.J == null) {
            this.J = new j(this, this.K, this.L, this.M, this.N, this.O, this.P);
        }
        return this.J;
    }
    
    public double m() {
        return this.K;
    }
    
    public void c(final double k) {
        this.K = k;
    }
    
    public double n() {
        return this.M;
    }
    
    public void d(final double m) {
        this.M = m;
    }
    
    public r o() {
        return this.O;
    }
    
    public void c(final r o) {
        this.O = o;
    }
    
    public double p() {
        return this.L;
    }
    
    public void e(final double l) {
        this.L = l;
    }
    
    public double q() {
        return this.N;
    }
    
    public void f(final double n) {
        this.N = n;
    }
    
    public r r() {
        return this.P;
    }
    
    public void d(final r p) {
        this.P = p;
    }
    
    public static Map s() {
        final int h = a.H;
        final Map a = aZ.a().a();
        a.put((y.h.b.a.w == null) ? (y.h.b.a.w = f("y.h.bo")) : y.h.b.a.w, J.a());
        a.put((y.h.b.a.A == null) ? (y.h.b.a.A = f("y.h.bd")) : y.h.b.a.A, null);
        a.put((y.h.b.a.B == null) ? (y.h.b.a.B = f("y.h.bj")) : y.h.b.a.B, null);
        final eD ed = new eD();
        ed.a(new u());
        ed.a(new T());
        ed.a(new X());
        ed.a(new S());
        a.put((y.h.b.a.C == null) ? (y.h.b.a.C = f("y.h.bf")) : y.h.b.a.C, ed);
        final o o = new o(null);
        a.put((y.h.b.a.D == null) ? (y.h.b.a.D = f("y.h.a.f")) : y.h.b.a.D, o);
        a.put((y.h.b.a.E == null) ? (y.h.b.a.E = f("y.h.bl")) : y.h.b.a.E, o);
        a.put((y.h.b.a.F == null) ? (y.h.b.a.F = f("y.h.bg")) : y.h.b.a.F, new k(null));
        a.put((y.h.b.a.G == null) ? (y.h.b.a.G = f("y.h.br")) : y.h.b.a.G, new b());
        final Map<Class, J> map = (Map<Class, J>)a;
        if (h != 0) {
            y.c.i.g = !y.c.i.g;
        }
        return map;
    }
    
    private void A() {
        this.setFillColor(new Color(248, 236, 201));
        this.setFillColor2(new Color(0, 66, 244, 64));
        this.a(false);
        this.a(y.h.b.o.b());
        this.K = 30.0;
        this.L = 30.0;
        this.M = 30.0;
        this.N = 30.0;
        this.O = a.I;
        this.P = a.I;
        this.J = null;
        this.Q = true;
        this.B();
        final be a = aZ.a();
        if (!a.c().contains("y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION")) {
            a.a("y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION", s());
        }
        this.d("y.view.TableGroupNodeRealizer.DEFAULT_CONFIGURATION");
    }
    
    private void B() {
        final dr a = dr.a(1, (byte)0);
        final dr a2 = dr.a(3, (byte)0);
        final Z z = new Z(a, Color.BLACK, new Color(71, 74, 67, 64));
        final Z z2 = new Z(a2, Color.BLACK, new Color(71, 74, 67, 128));
        this.a("y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_STYLE", z);
        this.a("y.view.tabular.TableNodePainter.ALTERNATE_ROW_STYLE", z);
        this.a("y.view.tabular.TableNodePainter.ALTERNATE_COLUMN_SELECTION_STYLE", z2);
        this.a("y.view.tabular.TableNodePainter.ALTERNATE_ROW_SELECTION_STYLE", z2);
    }
    
    private void a(final q q) {
        if (this.getNode() != q) {
            if (q == null) {
                throw new IllegalArgumentException("null");
            }
            if (this.getNode() == null) {
                throw new IllegalStateException("realizer not bound to node");
            }
            if (q.e() != this.getNode().e()) {
                throw new IllegalArgumentException("node does not belong to graph");
            }
        }
    }
    
    private fj c(final q q) {
        this.a(q);
        return ((bu)q.e()).t(q);
    }
    
    private v C() {
        final q node = this.getNode();
        if (node != null) {
            final y.c.i e = node.e();
            if (e != null) {
                return y.h.a.v.a(e);
            }
        }
        return null;
    }
    
    private void D() {
        final int h = a.H;
        final int labelCount = this.labelCount();
        if (labelCount > 0) {
            int i = 0;
            while (i < labelCount) {
                this.getLabel(i).setOffsetDirty();
                ++i;
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    private boolean E() {
        return this.getAutoBoundsFeature() != null && this.g() && !this.isGroupClosed();
    }
    
    private void d(final boolean autoBoundsEnabled) {
        final y.h.a.a autoBoundsFeature = this.getAutoBoundsFeature();
        if (autoBoundsFeature != null) {
            autoBoundsFeature.setAutoBoundsEnabled(autoBoundsEnabled);
        }
    }
    
    private Rectangle2D c(final c c) {
        final int h = a.H;
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        c c2 = c;
    Label_0098_Outer:
        while (c2 != null) {
            final d a = c2.a();
            while (true) {
                for (final c c3 : a.l()) {
                    final Object o;
                    final c c4 = (c)(o = c3);
                    if (h == 0) {
                        if (c4 == c2) {
                            break;
                        }
                        n += c3.g();
                        if (h != 0) {
                            break;
                        }
                        continue Label_0098_Outer;
                    }
                    else {
                        if (o instanceof c) {
                            final c c5 = (c)a;
                            final r i = c5.i();
                            if (i != null) {
                                n += i.b;
                                n2 += i.a;
                                n3 += i.c;
                            }
                            c2 = c5;
                            continue Label_0098_Outer;
                        }
                        if (a == this.l()) {
                            n += this.v();
                            final r d = this.l().d();
                            n2 += d.a;
                            n3 += d.c;
                            c2 = null;
                            continue Label_0098_Outer;
                        }
                        throw new IllegalStateException("Invalid or no parent.");
                    }
                }
                Object o = a;
                continue;
            }
        }
        return new Rectangle2D.Double(this.getX() + n, this.getY() + n2, c.g(), this.getHeight() - n2 - n3);
    }
    
    private Rectangle2D c(final f f) {
        final int h = a.H;
        double n = 0.0;
        double n2 = 0.0;
        double n3 = 0.0;
        f f2 = f;
    Label_0100_Outer:
        while (f2 != null) {
            final g a = f2.a();
            while (true) {
                for (final f f3 : a.o()) {
                    final Object o;
                    final f f4 = (f)(o = f3);
                    if (h == 0) {
                        if (f4 == f2) {
                            break;
                        }
                        n3 += f3.g();
                        if (h != 0) {
                            break;
                        }
                        continue Label_0100_Outer;
                    }
                    else {
                        if (o instanceof f) {
                            final f f5 = (f)a;
                            final r i = f5.i();
                            if (i != null) {
                                n += i.b;
                                n2 += i.d;
                                n3 += i.a;
                            }
                            f2 = f5;
                            continue Label_0100_Outer;
                        }
                        if (a == this.l()) {
                            n3 += this.t();
                            final r d = this.l().d();
                            n += d.b;
                            n2 += d.d;
                            f2 = null;
                            continue Label_0100_Outer;
                        }
                        throw new IllegalStateException("Invalid or no parent.");
                    }
                }
                Object o = a;
                continue;
            }
        }
        return new Rectangle2D.Double(this.getX() + n, this.getY() + n3, this.getWidth() - n - n2, f.g());
    }
    
    double t() {
        final s s = new s();
        this.a(s);
        return s.a;
    }
    
    double u() {
        final s s = new s();
        this.a(s);
        return s.c;
    }
    
    private void a(final s s) {
        c(this.l(), s);
    }
    
    private static void c(final i i, final s s) {
        final int h = a.H;
        double a = 0.0;
        double c = 0.0;
        final Iterator<c> iterator = i.l().iterator();
        while (true) {
            while (iterator.hasNext()) {
                a(iterator.next(), s);
                if (a < s.a) {
                    a = s.a;
                }
                if (c < s.c) {
                    c = s.c;
                    if (h != 0) {
                        final r d = i.d();
                        s.a += d.a;
                        s.c += d.c;
                        return;
                    }
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
            }
            s.a = a;
            s.c = c;
            continue;
        }
    }
    
    private static void a(final c c, final s s) {
        final int h = a.H;
        final r i = c.i();
        final double a = (i != null) ? i.a : 0.0;
        final double c2 = (i != null) ? i.c : 0.0;
        final List l = c.l();
        if (l.isEmpty()) {
            s.a = a;
            s.c = c2;
            if (h == 0) {
                return;
            }
        }
        double a2 = 0.0;
        double c3 = 0.0;
        final Iterator<c> iterator = l.iterator();
        while (true) {
            while (iterator.hasNext()) {
                a(iterator.next(), s);
                if (a2 < s.a) {
                    a2 = s.a;
                }
                if (c3 < s.c) {
                    c3 = s.c;
                    if (h != 0) {
                        s.c = c2 + c3;
                        return;
                    }
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
            }
            s.a = a + a2;
            continue;
        }
    }
    
    double v() {
        final s s = new s();
        this.b(s);
        return s.b;
    }
    
    double w() {
        final s s = new s();
        this.b(s);
        return s.d;
    }
    
    private void b(final s s) {
        d(this.l(), s);
    }
    
    private static void d(final i i, final s s) {
        final int h = a.H;
        double b = 0.0;
        double d = 0.0;
        final Iterator<f> iterator = i.o().iterator();
        while (true) {
            while (iterator.hasNext()) {
                a(iterator.next(), s);
                if (b < s.b) {
                    b = s.b;
                }
                if (d < s.d) {
                    d = s.d;
                    if (h != 0) {
                        final r d2 = i.d();
                        s.b += d2.b;
                        s.d += d2.d;
                        return;
                    }
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
            }
            s.b = b;
            s.d = d;
            continue;
        }
    }
    
    private static void a(final f f, final s s) {
        final int h = a.H;
        final r i = f.i();
        final double b = (i != null) ? i.b : 0.0;
        final double d = (i != null) ? i.d : 0.0;
        final List o = f.o();
        if (o.isEmpty()) {
            s.b = b;
            s.d = d;
            if (h == 0) {
                return;
            }
        }
        double b2 = 0.0;
        double d2 = 0.0;
        final Iterator<f> iterator = o.iterator();
        while (true) {
            while (iterator.hasNext()) {
                a(iterator.next(), s);
                if (b2 < s.b) {
                    b2 = s.b;
                }
                if (d2 < s.d) {
                    d2 = s.d;
                    if (h != 0) {
                        s.d = d + d2;
                        return;
                    }
                    if (h != 0) {
                        break;
                    }
                    continue;
                }
            }
            s.b = b + b2;
            continue;
        }
    }
    
    private f a(final double n, final double n2) {
        final int h = a.H;
        if (this.contains(n, n2)) {
            final r d = this.l().d();
            final s s = new s();
            this.a(s);
            final double n3 = n - this.getX();
            double n4 = n2 - this.getY() - s.a;
            final double width = this.getWidth();
            final double n5 = n3 - d.b;
            final double n6 = width - (d.b + d.d);
            if (n5 >= 0.0 && n4 >= 0.0 && n5 <= n6) {
                for (final f f : this.l().o()) {
                    if (n4 <= f.g()) {
                        return this.a(f, n5, n4, n6);
                    }
                    n4 -= f.g();
                    if (h != 0) {
                        break;
                    }
                }
            }
        }
        return null;
    }
    
    private f a(final f f, final double n, final double n2, final double n3) {
        final int h = a.H;
        f f2 = null;
        if (!f.o().isEmpty()) {
            final r i = f.i();
            double n4 = n;
            double n5 = n2;
            double n6 = n3;
            if (i != null) {
                if (n < i.b || n > n3 - i.d || n2 < i.a || n2 > f.g() - i.c) {
                    return f;
                }
                n4 -= i.b;
                n5 -= i.a;
                n6 -= i.b + i.d;
            }
            final Iterator<f> iterator = (Iterator<f>)f.o().iterator();
            while (iterator.hasNext()) {
                f2 = iterator.next();
                if (h != 0) {
                    break;
                }
                final f f3 = f2;
                if (n5 <= f3.g()) {
                    return this.a(f3, n4, n5, n6);
                }
                n5 -= f3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return f2;
    }
    
    private c b(final double n, final double n2) {
        final int h = a.H;
        if (this.contains(n, n2)) {
            final r d = this.l().d();
            final s s = new s();
            this.b(s);
            double n3 = n - this.getX() - s.b;
            final double n4 = n2 - this.getY();
            final double height = this.getHeight();
            final double n5 = n4 - d.a;
            final double n6 = height - (d.a + d.c);
            if (n3 >= 0.0 && n5 >= 0.0 && n5 <= n6) {
                for (final c c : this.l().l()) {
                    if (n3 <= c.g()) {
                        return this.a(c, n3, n5, n6);
                    }
                    n3 -= c.g();
                    if (h != 0) {
                        break;
                    }
                }
            }
        }
        return null;
    }
    
    private c a(final c c, final double n, final double n2, final double n3) {
        final int h = a.H;
        c c2 = null;
        if (!c.l().isEmpty()) {
            final r i = c.i();
            double n4 = n;
            double n5 = n2;
            double n6 = n3;
            if (i != null) {
                if (n < i.b || n > c.g() - i.d || n2 < i.a || n2 > n3 - i.c) {
                    return c;
                }
                n4 -= i.b;
                n5 -= i.a;
                n6 -= i.a + i.c;
            }
            final Iterator<c> iterator = (Iterator<c>)c.l().iterator();
            while (iterator.hasNext()) {
                c2 = iterator.next();
                if (h != 0) {
                    break;
                }
                final c c3 = c2;
                if (n4 <= c3.g()) {
                    return this.a(c3, n4, n5, n6);
                }
                n4 -= c3.g();
                if (h != 0) {
                    break;
                }
            }
        }
        return c2;
    }
    
    public void a(final eR er, final c c, final boolean b, final double n) {
        final n modelParameter = new n(((y.h.b.q)c).a, b, n);
        if (!(er.a() instanceof y.h.b.e)) {
            er.a(new y.h.b.e(), modelParameter);
            if (a.H == 0) {
                return;
            }
        }
        er.setModelParameter(modelParameter);
    }
    
    public void a(final eR er, final f f, final boolean b, final double n) {
        final int h = a.H;
        final n modelParameter = new n(((y.h.b.q)f).a, b, n);
        Label_0058: {
            if (!(er.a() instanceof y.h.b.h)) {
                er.a(new y.h.b.h(), modelParameter);
                if (h == 0) {
                    break Label_0058;
                }
            }
            er.setModelParameter(modelParameter);
        }
        if (n < 0.5) {
            er.setRotationAngle(270.0);
            if (h == 0) {
                return;
            }
        }
        er.setRotationAngle(90.0);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final byte byte1 = objectInputStream.readByte();
        switch (byte1) {
            case 0:
            case 1: {
                super.read(objectInputStream);
                this.c(objectInputStream.readBoolean());
                final m m = new m();
                this.a(m, objectInputStream, byte1);
                this.a(m, objectInputStream);
                if (a.H != 0) {
                    break;
                }
                return;
            }
        }
        throw new y.e.a();
    }
    
    private void a(final m m, final ObjectInputStream objectInputStream) {
        final int h = a.H;
        final int labelCount = this.labelCount();
        final eR[] array = new eR[labelCount];
        int i = 0;
        while (true) {
            while (i < labelCount) {
                array[i] = this.getLabel(i);
                ++i;
                if (h != 0) {
                    while (true) {
                        while (i < objectInputStream.readInt()) {
                            array[objectInputStream.readInt()].a(new y.h.b.e(objectInputStream.readDouble()), new n(m.a(objectInputStream.readInt()), objectInputStream.readBoolean(), objectInputStream.readDouble()));
                            ++i;
                            if (h != 0) {
                                while (i < objectInputStream.readInt()) {
                                    array[objectInputStream.readInt()].a(new y.h.b.h(objectInputStream.readDouble()), new n(m.b(objectInputStream.readInt()), objectInputStream.readBoolean(), objectInputStream.readDouble()));
                                    ++i;
                                    if (h != 0) {
                                        break;
                                    }
                                }
                                return;
                            }
                            if (h != 0) {
                                break;
                            }
                        }
                        i = 0;
                        continue;
                    }
                }
                if (h != 0) {
                    break;
                }
            }
            i = 0;
            continue;
        }
    }
    
    private void a(final m m, final ObjectInputStream objectInputStream, final byte b) {
        this.M = 0.0;
        final double double1 = objectInputStream.readDouble();
        this.K = 0.0;
        final double double2 = objectInputStream.readDouble();
        this.O = null;
        final r a = a(objectInputStream, b);
        this.N = 0.0;
        final double double3 = objectInputStream.readDouble();
        this.L = 0.0;
        final double double4 = objectInputStream.readDouble();
        this.P = null;
        final r a2 = a(objectInputStream, b);
        if (objectInputStream.readBoolean()) {
            final i l = this.l();
            l.a(a(objectInputStream, b));
            this.a((d)l, m, objectInputStream, b);
            this.a((g)l, m, objectInputStream, b);
        }
        this.d(double1);
        this.c(double2);
        this.c(a);
        this.f(double3);
        this.e(double4);
        this.d(a2);
    }
    
    private void a(final d d, final m m, final ObjectInputStream objectInputStream, final byte b) {
        final int h = a.H;
        final int int1 = objectInputStream.readInt();
        if (int1 > 0) {
            Label_0058: {
                if (d == this.l()) {
                    this.a(d.b(0), m, objectInputStream, b);
                    if (h == 0) {
                        break Label_0058;
                    }
                }
                this.a(d.j(), m, objectInputStream, b);
            }
            int i = 1;
            while (i < int1) {
                this.a(d.j(), m, objectInputStream, b);
                ++i;
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    private void a(final c c, final m m, final ObjectInputStream objectInputStream, final byte b) {
        m.a(objectInputStream.readInt(), c);
        c.a(objectInputStream.readDouble());
        c.b(objectInputStream.readDouble());
        c.a(a(objectInputStream, b));
        this.a((d)c, null, objectInputStream, b);
    }
    
    private void a(final g g, final m m, final ObjectInputStream objectInputStream, final byte b) {
        final int h = a.H;
        final int int1 = objectInputStream.readInt();
        if (int1 > 0) {
            Label_0058: {
                if (g == this.l()) {
                    this.a(g.c(0), m, objectInputStream, b);
                    if (h == 0) {
                        break Label_0058;
                    }
                }
                this.a(g.m(), m, objectInputStream, b);
            }
            int i = 1;
            while (i < int1) {
                this.a(g.m(), m, objectInputStream, b);
                ++i;
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    private void a(final f f, final m m, final ObjectInputStream objectInputStream, final byte b) {
        m.a(objectInputStream.readInt(), f);
        f.a(objectInputStream.readDouble());
        f.b(objectInputStream.readDouble());
        f.a(a(objectInputStream, b));
        this.a((g)f, m, objectInputStream, b);
    }
    
    private static r a(final ObjectInputStream objectInputStream, final byte b) {
        switch (b) {
            case 0: {
                return (r)objectInputStream.readObject();
            }
            default: {
                if (objectInputStream.readBoolean()) {
                    return new r(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble());
                }
                return null;
            }
        }
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeBoolean(this.k());
        final p p = new p();
        this.b(p, objectOutputStream);
        this.a(p, objectOutputStream);
    }
    
    private void a(final p p2, final ObjectOutputStream objectOutputStream) {
        final int h = a.H;
        final int labelCount = this.labelCount();
        final HashMap<eR, Integer> hashMap = new HashMap<eR, Integer>();
        final ArrayList list = new ArrayList<eR>(labelCount);
        final ArrayList list2 = new ArrayList<eR>(labelCount);
        int i = 0;
        while (true) {
            while (i < labelCount) {
                final eR label = this.getLabel(i);
                hashMap.put(label, new Integer(i));
                final al a = label.a();
                final boolean b = a instanceof y.h.b.e;
                if (h != 0) {
                    Label_0268: {
                        if (!b) {
                            for (final eR er : list) {
                                objectOutputStream.writeInt(hashMap.get(er));
                                objectOutputStream.writeDouble(((l)er.a()).a());
                                final n a2 = y.h.b.l.a(er.getModelParameter());
                                objectOutputStream.writeInt(p2.a(a2.a));
                                objectOutputStream.writeBoolean(a2.b);
                                objectOutputStream.writeDouble(a2.c);
                                if (h != 0) {
                                    break Label_0268;
                                }
                                if (h != 0) {
                                    break;
                                }
                            }
                        }
                        objectOutputStream.writeInt(list2.size());
                    }
                    if (!list2.isEmpty()) {
                        for (final eR er2 : list2) {
                            objectOutputStream.writeInt(hashMap.get(er2));
                            objectOutputStream.writeDouble(((l)er2.a()).a());
                            final n a3 = y.h.b.l.a(er2.getModelParameter());
                            objectOutputStream.writeInt(p2.b(a3.a));
                            objectOutputStream.writeBoolean(a3.b);
                            objectOutputStream.writeDouble(a3.c);
                            if (h != 0) {
                                break;
                            }
                        }
                    }
                    return;
                }
                Label_0122: {
                    if (b) {
                        list.add(label);
                        if (h == 0) {
                            break Label_0122;
                        }
                    }
                    if (a instanceof y.h.b.h) {
                        list2.add(label);
                    }
                }
                ++i;
                if (h != 0) {
                    break;
                }
            }
            objectOutputStream.writeInt(list.size());
            list.isEmpty();
            continue;
        }
    }
    
    private void b(final p p2, final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeDouble(this.n());
        objectOutputStream.writeDouble(this.m());
        a(this.o(), objectOutputStream);
        objectOutputStream.writeDouble(this.q());
        objectOutputStream.writeDouble(this.p());
        a(this.r(), objectOutputStream);
        if (this.J == null) {
            objectOutputStream.writeBoolean(false);
            if (a.H == 0) {
                return;
            }
        }
        objectOutputStream.writeBoolean(true);
        a(this.J.d(), objectOutputStream);
        this.a(this.J.l(), p2, objectOutputStream);
        this.b(this.J.o(), p2, objectOutputStream);
    }
    
    private void a(final List list, final p p3, final ObjectOutputStream objectOutputStream) {
        final int h = a.H;
        objectOutputStream.writeInt(list.size());
        if (!list.isEmpty()) {
            for (final c c : list) {
                objectOutputStream.writeInt(p3.a(c));
                objectOutputStream.writeDouble(c.f());
                objectOutputStream.writeDouble(c.g());
                a(c.i(), objectOutputStream);
                this.a(c.l(), p3, objectOutputStream);
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    private void b(final List list, final p p3, final ObjectOutputStream objectOutputStream) {
        final int h = a.H;
        objectOutputStream.writeInt(list.size());
        if (!list.isEmpty()) {
            for (final f f : list) {
                objectOutputStream.writeInt(p3.a(f));
                objectOutputStream.writeDouble(f.f());
                objectOutputStream.writeDouble(f.g());
                a(f.i(), objectOutputStream);
                this.b(f.o(), p3, objectOutputStream);
                if (h != 0) {
                    break;
                }
            }
        }
    }
    
    private static void a(final r r, final ObjectOutputStream objectOutputStream) {
        if (r == null) {
            objectOutputStream.writeBoolean(false);
            if (a.H == 0) {
                return;
            }
        }
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeDouble(r.a);
        objectOutputStream.writeDouble(r.b);
        objectOutputStream.writeDouble(r.c);
        objectOutputStream.writeDouble(r.d);
    }
    
    static a a(final c c) {
        return ((t)c).r();
    }
    
    static a a(final f f) {
        return ((y.h.b.r)f).r();
    }
    
    private void c(final double n, final double n2) {
        final double width = this.getWidth();
        final double height = this.getHeight();
        if (n > width || n2 > height) {
            this.a(this.getX(), this.getY(), Math.max(n, width), Math.max(n2, height));
            if (a.H == 0) {
                return;
            }
        }
        this.D();
    }
    
    private void a(final j j, final List list, final c c) {
        final boolean e = this.E();
        if (e) {
            this.d(false);
        }
        try {
            this.b(j, list, c);
        }
        finally {
            if (e) {
                this.d(e);
            }
        }
    }
    
    private void b(final j j, final List list, final c c) {
        final int h = a.H;
        final List l = c.l();
        final d a = c.a();
        final s s = new s();
        this.a(s);
        final int index = list.indexOf(c);
        int i = 0;
        while (true) {
            while (i < l.size()) {
                y.h.b.t.a((t)l.get(i), a);
                ++i;
                if (h != 0) {
                    final s s2 = new s();
                    this.a(s2);
                    final double n = s.a - s2.a;
                    if (n > 0.0) {
                        f f = j.a(j).get(0);
                        while (f != null) {
                            f.b(f.g() + n);
                            final List o = f.o();
                            if (o.isEmpty()) {
                                f = null;
                            }
                            else {
                                f = o.get(0);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    final double n2 = s.c - s2.c;
                    boolean empty = false;
                    Label_0360: {
                        if (n2 > 0.0) {
                            f f2 = j.a(j).get(j.a(j).size() - 1);
                            while (f2 != null) {
                                f2.b(f2.g() + n2);
                                final List o2 = f2.o();
                                empty = o2.isEmpty();
                                if (h != 0) {
                                    break Label_0360;
                                }
                                if (empty) {
                                    f2 = null;
                                }
                                else {
                                    f2 = o2.get(o2.size() - 1);
                                    if (h != 0) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                        l.isEmpty();
                    }
                    Label_0727: {
                        Label_0506: {
                            if (empty) {
                                if (list.size() > 0) {
                                    final boolean b = index == list.size();
                                    c c2 = list.get(b ? (index - 1) : index);
                                    while (c2 != null) {
                                        c2.b(c2.g() + c.g());
                                        final List k = c2.l();
                                        if (h != 0) {
                                            return;
                                        }
                                        if (k.isEmpty()) {
                                            c2 = null;
                                        }
                                        else {
                                            c2 = k.get(b ? (k.size() - 1) : 0);
                                            if (h != 0) {
                                                break Label_0506;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                break Label_0727;
                            }
                        }
                        final r m = c.i();
                        if (m != null) {
                            double empty2 = 0.0;
                            Label_0622: {
                                if (m.b > 0.0) {
                                    c c3 = (t)l.get(0);
                                    while (c3 != null) {
                                        c3.b(c3.g() + m.b);
                                        final List l2 = c3.l();
                                        final int n3 = (int)(empty2 = (l2.isEmpty() ? 1 : 0));
                                        if (h != 0) {
                                            break Label_0622;
                                        }
                                        if (n3 != 0) {
                                            c3 = null;
                                        }
                                        else {
                                            c3 = l2.get(0);
                                            if (h != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                empty2 = dcmpl(m.d, 0.0);
                            }
                            if (empty2 > 0) {
                                c c4 = (t)l.get(l.size() - 1);
                                while (c4 != null) {
                                    c4.b(c4.g() + m.d);
                                    final List l3 = c4.l();
                                    if (h != 0) {
                                        return;
                                    }
                                    if (l3.isEmpty()) {
                                        c4 = null;
                                    }
                                    else {
                                        c4 = l3.get(l3.size() - 1);
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    this.D();
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            list.remove(index);
            list.addAll(index, l);
            continue;
        }
    }
    
    private void a(final j j, final List list, final f f) {
        final boolean e = this.E();
        if (e) {
            this.d(false);
        }
        try {
            this.b(j, list, f);
        }
        finally {
            if (e) {
                this.d(e);
            }
        }
    }
    
    private void b(final j j, final List list, final f f) {
        final int h = a.H;
        final List o = f.o();
        final g a = f.a();
        final s s = new s();
        this.b(s);
        final int index = list.indexOf(f);
        int i = 0;
        while (true) {
            while (i < o.size()) {
                y.h.b.r.a((y.h.b.r)o.get(i), a);
                ++i;
                if (h != 0) {
                    final s s2 = new s();
                    this.b(s2);
                    final double n = s.b - s2.b;
                    if (n > 0.0) {
                        c c = j.b(j).get(0);
                        while (c != null) {
                            c.b(c.g() + n);
                            final List l = c.l();
                            if (l.isEmpty()) {
                                c = null;
                            }
                            else {
                                c = l.get(0);
                                if (h != 0) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    final double n2 = s.d - s2.d;
                    boolean empty = false;
                    Label_0360: {
                        if (n2 > 0.0) {
                            c c2 = j.b(j).get(j.b(j).size() - 1);
                            while (c2 != null) {
                                c2.b(c2.g() + n2);
                                final List k = c2.l();
                                empty = k.isEmpty();
                                if (h != 0) {
                                    break Label_0360;
                                }
                                if (empty) {
                                    c2 = null;
                                }
                                else {
                                    c2 = k.get(k.size() - 1);
                                    if (h != 0) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                        o.isEmpty();
                    }
                    Label_0727: {
                        Label_0506: {
                            if (empty) {
                                if (list.size() > 0) {
                                    final boolean b = index == list.size();
                                    f f2 = list.get(b ? (index - 1) : index);
                                    while (f2 != null) {
                                        f2.b(f2.g() + f.g());
                                        final List o2 = f2.o();
                                        if (h != 0) {
                                            return;
                                        }
                                        if (o2.isEmpty()) {
                                            f2 = null;
                                        }
                                        else {
                                            f2 = o2.get(b ? (o2.size() - 1) : 0);
                                            if (h != 0) {
                                                break Label_0506;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                break Label_0727;
                            }
                        }
                        final r m = f.i();
                        if (m != null) {
                            double empty2 = 0.0;
                            Label_0622: {
                                if (m.a > 0.0) {
                                    f f3 = (y.h.b.r)o.get(0);
                                    while (f3 != null) {
                                        f3.b(f3.g() + m.a);
                                        final List o3 = f3.o();
                                        final int n3 = (int)(empty2 = (o3.isEmpty() ? 1 : 0));
                                        if (h != 0) {
                                            break Label_0622;
                                        }
                                        if (n3 != 0) {
                                            f3 = null;
                                        }
                                        else {
                                            f3 = o3.get(0);
                                            if (h != 0) {
                                                break;
                                            }
                                            continue;
                                        }
                                    }
                                }
                                empty2 = dcmpl(m.c, 0.0);
                            }
                            if (empty2 > 0) {
                                f f4 = (y.h.b.r)o.get(o.size() - 1);
                                while (f4 != null) {
                                    f4.b(f4.g() + m.c);
                                    final List o4 = f4.o();
                                    if (h != 0) {
                                        return;
                                    }
                                    if (o4.isEmpty()) {
                                        f4 = null;
                                    }
                                    else {
                                        f4 = o4.get(o4.size() - 1);
                                        if (h != 0) {
                                            break;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    this.D();
                    return;
                }
                if (h != 0) {
                    break;
                }
            }
            list.remove(index);
            list.addAll(index, o);
            continue;
        }
    }
    
    private void a(final Rectangle2D rectangle2D, final Collection collection) {
        final v c = this.C();
        if (c != null) {
            this.a(c, this.getNode(), rectangle2D, collection);
        }
    }
    
    private void a(final v v, final q q, final Rectangle2D rectangle2D, final Collection collection) {
        final int h = a.H;
        final x p4 = v.p(q);
        while (p4.f()) {
            final q e = p4.e();
            Label_0235: {
                if (v.k(e)) {
                    final x p5 = v.p(e);
                    if (p5.f()) {
                        final LinkedHashSet<q> set = new LinkedHashSet<q>();
                        this.a(v, e, rectangle2D, set);
                        boolean contains = false;
                        Label_0132: {
                            while (p5.f()) {
                                contains = set.contains(p4.e());
                                if (h != 0 || (contains && h == 0)) {
                                    break Label_0132;
                                }
                                p5.g();
                                if (h != 0) {
                                    goto Label_0130;
                                }
                            }
                            goto Label_0130;
                        }
                        if (contains) {
                            collection.add(e);
                        }
                        collection.addAll(set);
                        if (h == 0) {
                            break Label_0235;
                        }
                    }
                    final fj c = this.c(e);
                    if (!rectangle2D.contains(c.getCenterX(), c.getCenterY())) {
                        break Label_0235;
                    }
                    collection.add(e);
                    if (h == 0) {
                        break Label_0235;
                    }
                }
                final fj c2 = this.c(e);
                if (rectangle2D.contains(c2.getCenterX(), c2.getCenterY())) {
                    collection.add(e);
                }
            }
            p4.g();
            if (h != 0) {
                break;
            }
        }
    }
    
    public void setSize(final double n, final double n2) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        super.setSize(n, n2);
        if (double1.getWidth() != this.getWidth() || double1.getHeight() != this.getHeight()) {
            this.a(double1);
        }
    }
    
    public void setFrame(final double n, final double n2, final double n3, final double n4) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        this.a(n, n2, n3, n4);
        if (double1.getWidth() != this.getWidth() || double1.getHeight() != this.getHeight()) {
            this.a(double1);
        }
    }
    
    public void setFrame(final Rectangle2D rectangle2D) {
        this.setFrame(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    protected void a(final Rectangle2D rectangle2D) {
        if (this.k()) {
            y.h.b.k.a(this, rectangle2D);
        }
    }
    
    private void a(final double n, final double n2, final double n3, final double n4) {
        super.setSize(n3, n4);
        super.setLocation(n, n2);
    }
    
    static Class f(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static double a(final a a) {
        return a.y();
    }
    
    static double b(final a a) {
        return a.z();
    }
    
    static r x() {
        return a.I;
    }
    
    static f a(final a a, final double n, final double n2) {
        return a.a(n, n2);
    }
    
    static boolean c(final a a) {
        return a.E();
    }
    
    static void a(final a a, final boolean b) {
        a.d(b);
    }
    
    static Rectangle2D a(final a a, final f f) {
        return a.c(f);
    }
    
    static c b(final a a, final double n, final double n2) {
        return a.b(n, n2);
    }
    
    static Rectangle2D a(final a a, final c c) {
        return a.c(c);
    }
    
    static void a(final a a, final s s) {
        a.b(s);
    }
    
    static void b(final a a, final s s) {
        a.a(s);
    }
    
    static void c(final a a, final double n, final double n2) {
        a.c(n, n2);
    }
    
    static void d(final a a) {
        a.D();
    }
    
    static void a(final a a, final j j, final List list, final c c) {
        a.a(j, list, c);
    }
    
    static j e(final a a) {
        return a.J;
    }
    
    static void a(final a a, final double n, final double n2, final double n3, final double n4) {
        a.a(n, n2, n3, n4);
    }
    
    static void a(final a a, final Rectangle2D rectangle2D, final Collection collection) {
        a.a(rectangle2D, collection);
    }
    
    static void a(final a a, final j j, final List list, final f f) {
        a.a(j, list, f);
    }
    
    static void a(final i i, final s s) {
        d(i, s);
    }
    
    static void b(final i i, final s s) {
        c(i, s);
    }
    
    static {
        I = new r(0.0, 0.0, 0.0, 0.0);
    }
}
