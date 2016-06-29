package y.h;

import java.awt.geom.*;
import java.awt.event.*;
import y.g.*;
import y.d.*;
import y.h.a.*;
import y.c.*;
import java.awt.*;
import java.util.*;

public class dP extends gX
{
    private double b;
    private double c;
    private double d;
    private double e;
    private boolean f;
    private y g;
    private List h;
    private Cursor i;
    private int j;
    private f k;
    private dU l;
    private boolean m;
    private byte n;
    private boolean o;
    private boolean p;
    private boolean q;
    private az r;
    private y s;
    private y t;
    private boolean u;
    private boolean v;
    private Map w;
    private Rectangle2D.Double[] x;
    private boolean y;
    private y z;
    private Set A;
    private int B;
    boolean a;
    
    public void activate(final boolean b) {
        if (!b) {
            this.c().f();
        }
        super.activate(b);
        this.c().a(this.view);
    }
    
    public int a() {
        return this.B;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.a()) != 0x0;
    }
    
    public dU c() {
        if (this.l == null) {
            this.l = this.e();
        }
        return this.l;
    }
    
    protected dU e() {
        return new dU(this.view);
    }
    
    public boolean f() {
        return this.m;
    }
    
    public void a(final boolean m) {
        this.m = m;
    }
    
    public dP() {
        this.n = 1;
        this.o = true;
        this.r = new dQ(this);
        this.A = Collections.EMPTY_SET;
        this.B = 2;
    }
    
    public void mouseShiftPressedLeft(final double n, final double n2) {
        this.a(n, n2, this.u = (this.i() != null && this.k()));
    }
    
    public void mousePressedLeft(final double n, final double n2) {
        this.a(n, n2, this.u = false);
    }
    
    public void mouseShiftReleasedLeft(final double n, final double n2) {
        final boolean k = this.k();
        this.a = k;
        this.v = k;
        this.d(n, n2);
        this.v = false;
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.a = this.u;
        this.d(n, n2);
    }
    
    private void d(double n, double n2) {
        final boolean z = fj.z;
        Label_0077: {
            if (this.f() && !this.a(this.lastReleaseEvent)) {
                final t b = this.c().b(new t(n, n2));
                n = b.a;
                n2 = b.b;
                if (!z) {
                    break Label_0077;
                }
            }
            this.c().h();
            n = this.getGridX(n);
            n2 = this.getGridY(n2);
        }
        final bu graph2D = this.getGraph2D();
        this.view.updateWorldRect();
        this.view.setDrawingMode(0);
        boolean contains = false;
        Label_0184: {
            if (this.k != null) {
                p p2 = this.k.k();
                while (p2 != null) {
                    final d d = (d)p2.c();
                    final aB i = graph2D.i(d);
                    contains = this.A.contains(d);
                    if (z) {
                        break Label_0184;
                    }
                    if (contains) {
                        fu.a(i);
                    }
                    p2 = p2.a();
                    if (z) {
                        break;
                    }
                }
                this.k = null;
            }
            final boolean y = this.y;
        }
        Label_0341: {
            if (contains) {
                final HashSet<d> set = new HashSet<d>();
                final x j = this.getGraph2D().J();
                while (true) {
                    while (j.f()) {
                        set.addAll((Collection<?>)new f(j.e().j()));
                        j.g();
                        if (z) {
                            fu.a(graph2D, set);
                            break Label_0341;
                        }
                        if (z) {
                            break;
                        }
                    }
                    if (this.h != null) {
                        for (final el el : this.h) {
                            if (el instanceof ek) {
                                set.add(((ek)el).a().a());
                                if (z) {
                                    return;
                                }
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        this.q();
        this.c().f();
        this.b(n - this.b, n2 - this.c, n, n2);
        this.view.setViewCursor(this.i);
        this.i = null;
        graph2D.T();
        this.setEditing(false);
        this.reactivateParent();
        this.g = null;
        this.A = Collections.EMPTY_SET;
        this.h = null;
        this.x = null;
    }
    
    private void m() {
        final boolean z = fj.z;
        final bu graph2D;
        if (this.view == null || (graph2D = this.view.getGraph2D()) == null) {
            return;
        }
        if (this.j != 1) {
            y.g.o.a((Object)("Unexpected BracketCounter in MoveSelectionMode : " + this.j));
        }
        while (this.j > 0) {
            --this.j;
            graph2D.s();
            if (z) {
                break;
            }
        }
    }
    
    public void reactivateParent() {
        this.m();
        super.reactivateParent();
    }
    
    public void mouseDraggedLeft(double n, double n2) {
        final boolean z = fj.z;
        Label_0077: {
            if (this.f() && !this.a(this.lastDragEvent)) {
                final t b = this.c().b(new t(n, n2));
                n = b.a;
                n2 = b.b;
                if (!z) {
                    break Label_0077;
                }
            }
            n = this.getGridX(n);
            n2 = this.getGridY(n2);
            this.c().h();
        }
        Label_0184: {
            if (this.f && this.n() && this.isGridMode()) {
                this.f = false;
                this.d = n;
                this.e = n2;
                if (!z) {
                    break Label_0184;
                }
            }
            final double n3 = n - this.d;
            final double n4 = n2 - this.e;
            if (n3 != 0.0 || n4 != 0.0) {
                this.d = n;
                this.e = n2;
                this.e(n - this.b, n2 - this.c);
                this.a(n3, n4, n, n2);
            }
        }
        this.view.updateView();
    }
    
    private void e(final double n, final double n2) {
        final boolean z = fj.z;
        if (this.g == null) {
            return;
        }
        final bu graph2D = this.getGraph2D();
        p p2 = this.g.k();
        while (p2 != null) {
            final q q = (q)p2.c();
            try {
                final Rectangle2D.Double double1 = this.x[q.d()];
                graph2D.t(q).setLocation(double1.x + n, double1.y + n2);
            }
            catch (ArrayIndexOutOfBoundsException ex) {}
            catch (NullPointerException ex2) {}
            p2 = p2.a();
            if (z) {
                break;
            }
        }
        int i = 0;
        while (i < this.h.size()) {
            try {
                ((el)this.h.get(i)).a(n, n2);
                if (z) {
                    return;
                }
            }
            catch (NullPointerException ex3) {}
            ++i;
            if (z) {
                break;
            }
        }
        this.o();
    }
    
    private void b(final fj fj) {
        final boolean z = fj.z;
        final q node = fj.getNode();
        final bu graph2D = this.getGraph2D();
        d d = node.f();
        while (true) {
            while (d != null) {
                final boolean contains = this.A.contains(d);
                if (z) {
                    while (true) {
                        if (contains) {
                            ic.a(this.view, graph2D.i(d), false);
                        }
                        d = d.h();
                        if (!z) {
                            if (d != null) {
                                this.A.contains(d);
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (contains) {
                    ic.a(this.view, graph2D.i(d), true);
                }
                d = d.g();
                if (z) {
                    break;
                }
            }
            d = node.g();
            continue;
        }
    }
    
    protected void a(final double n, final double n2) {
    }
    
    protected void a(final double n, final double n2, final double n3, final double n4) {
        if (this.s != null) {
            this.a(this.s);
        }
    }
    
    private void a(final y y) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        if (this.j() == 1) {
            p p = y.k();
            while (p != null) {
                final q q = (q)p.c();
                final a autoBoundsFeature = graph2D.t(q).getAutoBoundsFeature();
                if (autoBoundsFeature != null) {
                    final Rectangle2D rectangle2D = this.w.get(q);
                    final Rectangle2D minimalAutoBounds = autoBoundsFeature.getMinimalAutoBounds();
                    autoBoundsFeature.setAutoBoundsInsets(new r(Math.max(0.0, minimalAutoBounds.getY() - rectangle2D.getY()), Math.max(0.0, minimalAutoBounds.getX() - rectangle2D.getX()), Math.max(0.0, rectangle2D.getMaxY() - minimalAutoBounds.getMaxY()), Math.max(0.0, rectangle2D.getMaxX() - minimalAutoBounds.getMaxX())));
                }
                p = p.a();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void b(final double n, final double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        final v i = this.i();
        Label_0377: {
            if (i != null) {
                final bu graph2D = this.getGraph2D();
                if (this.v || this.u) {
                    final Object b = this.b(n3, n4);
                    if (b != null) {
                        final y y = new y();
                        final x a = this.t.a();
                        while (true) {
                        Label_0338_Outer:
                            while (a.f()) {
                                final q e = a.e();
                                final i e2;
                                final i j = e2 = e.e();
                                if (z) {
                                    Label_0372: {
                                        if (e2 instanceof q) {
                                            final q q = (q)b;
                                            i.c(y, q);
                                            final y y2 = new y();
                                            y2.add(b);
                                            q n5 = (q)b;
                                        Label_0338:
                                            while (true) {
                                                while (true) {
                                                    while ((n5 = i.n(n5)) != null) {
                                                        final Object o;
                                                        final i k = (i)(o = n5.e());
                                                        if (z) {
                                                            final Rectangle2D union = graph2D.t(q).getBoundingBox().createUnion((Rectangle2D)o);
                                                            final fj t = graph2D.t(q);
                                                            final a autoBoundsFeature = t.getAutoBoundsFeature();
                                                            if (autoBoundsFeature != null) {
                                                                if (autoBoundsFeature.isAutoBoundsEnabled() && i.p(q).f()) {
                                                                    break Label_0338;
                                                                }
                                                                t.setFrame(union);
                                                                if (!z) {
                                                                    break Label_0338;
                                                                }
                                                            }
                                                            t.setFrame(union);
                                                            this.a(y2);
                                                            break Label_0372;
                                                        }
                                                        if (k != graph2D) {
                                                            break;
                                                        }
                                                        y2.add(n5);
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                    graph2D.a(y2.a());
                                                    if (this.w != null && this.j() == 0) {
                                                        final Object o = this.w.get(q);
                                                        continue Label_0338_Outer;
                                                    }
                                                    break;
                                                }
                                                continue Label_0338;
                                            }
                                        }
                                        else if (b instanceof bu) {
                                            i.c(y, i.e((i)b));
                                        }
                                    }
                                    graph2D.T();
                                    break Label_0377;
                                }
                                if (j == graph2D) {
                                    y.add(e);
                                }
                                a.g();
                                if (z) {
                                    break;
                                }
                            }
                            i e2 = (i)b;
                            continue;
                        }
                    }
                }
            }
        }
        this.d(this.a);
    }
    
    protected y g() {
        final boolean z = fj.z;
        final y y = new y();
        final bu graph2D = this.getGraph2D();
        final x o = graph2D.o();
        while (o.f()) {
            if (graph2D.v(o.e())) {
                y.add(o.e());
            }
            o.g();
            if (z) {
                break;
            }
        }
        return y;
    }
    
    protected z h() {
        final boolean z = fj.z;
        final z z2 = new z();
        final bu graph2D = this.getGraph2D();
        final y.h.y d = graph2D.D();
        while (d.f()) {
            final y.h.x a = d.a();
            if (graph2D.a(a)) {
                z2.b(a);
            }
            d.g();
            if (z) {
                break;
            }
        }
        return z2;
    }
    
    private void a(final y y, final z z) {
        if (this.i() == null) {
            this.s = null;
            this.t = null;
            y.addAll(this.g());
            z.addAll(this.h());
            if (!fj.z) {
                return;
            }
        }
        this.s = new y();
        y.addAll(this.t = this.g());
        z.addAll(this.h());
        this.a(y, this.s, z);
    }
    
    protected void a(final y y, final y y2, final z z) {
        gg.a(this.getGraph2D(), new dR(this, new HashSet(y)), new dS(this, new HashSet(z)), y, y2, z);
    }
    
    void a(double gridX, double gridY, final boolean b) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        this.setEditing(true);
        this.f = true;
        gridX = this.getGridX(gridX);
        gridY = this.getGridY(gridY);
        final double n = gridX;
        this.d = n;
        this.b = n;
        final double n2 = gridY;
        this.e = n2;
        this.c = n2;
        this.view.updateView();
        this.i = this.view.getViewCursor();
        this.view.setViewCursor(Cursor.getPredefinedCursor(13));
        this.g = new y();
        final z z2 = new z();
        this.a(this.g, z2);
        graph2D.r();
        ++this.j;
        graph2D.b((byte)1);
        final HashSet set = new HashSet(this.g);
        this.A = new HashSet();
        final ArrayList<d> list = new ArrayList<d>();
        final ArrayList list2 = new ArrayList<d>();
        int n3 = 0;
        final e p3 = graph2D.p();
        while (p3.f()) {
            final d a = p3.a();
            if (this.a(a)) {
                this.A.add(a);
            }
            n3 += graph2D.i(a).bendCount();
            p3.g();
            if (z) {
                break;
            }
        }
        p p4 = z2.k();
        while (true) {
        Label_0547_Outer:
            while (p4 != null) {
                final y.h.x x = (y.h.x)p4.c();
                final d a2 = x.a();
                final dP dp = this;
                if (z) {
                    dp.k = new f();
                    final ArrayList<Object> list3 = new ArrayList<Object>();
                    final HashSet set2 = new HashSet(z2);
                    while (true) {
                        for (final d d : this.A) {
                            if (graph2D.i(d).bendCount() == 0) {
                                final boolean contains = set.contains(d.c());
                                if (z) {
                                    if (!contains) {
                                        graph2D.a(new f(list3.iterator()).a());
                                    }
                                    final HashSet set3 = new HashSet(list);
                                    set3.addAll(list2);
                                    if (!set3.isEmpty()) {
                                        graph2D.a(new f(set3.iterator()).a());
                                    }
                                    final byte[] array = new byte[n3];
                                    int n4 = 0;
                                    final e p5 = graph2D.p();
                                    while (true) {
                                        do {
                                            Label_0641: {
                                                p5.f();
                                            }
                                            boolean contains2 = false;
                                            Label_0648:
                                            while (contains2) {
                                                final d a3 = p5.a();
                                                final boolean contains3 = this.A.contains(a3);
                                                final int n5 = 0;
                                                if (!z) {
                                                    int n6 = n5;
                                                    final y.h.y bends = graph2D.i(a3).bends();
                                                    while (bends.f()) {
                                                        final y.h.x a4 = bends.a();
                                                        bends.g();
                                                        contains2 = set2.contains(a4);
                                                        if (z) {
                                                            continue Label_0648;
                                                        }
                                                        Label_0865: {
                                                            if (contains2) {
                                                                final byte[] array2 = array;
                                                                final int n7 = n4;
                                                                array2[n7] |= 0x1;
                                                                if (!contains3) {
                                                                    break Label_0865;
                                                                }
                                                                if (n6 > 0) {
                                                                    final byte[] array3 = array;
                                                                    final int n8 = n4 - 1;
                                                                    array3[n8] |= 0x2;
                                                                }
                                                                if (!bends.f()) {
                                                                    break Label_0865;
                                                                }
                                                                final byte[] array4 = array;
                                                                final int n9 = n4 + 1;
                                                                array4[n9] |= 0x4;
                                                                if (!z) {
                                                                    break Label_0865;
                                                                }
                                                            }
                                                            if (contains3) {
                                                                if (n6 == 0 && set.contains(a3.c())) {
                                                                    final byte[] array5 = array;
                                                                    final int n10 = n4;
                                                                    array5[n10] |= 0x4;
                                                                }
                                                                if (!bends.f() && set.contains(a3.d())) {
                                                                    final byte[] array6 = array;
                                                                    final int n11 = n4;
                                                                    array6[n11] |= 0x2;
                                                                }
                                                            }
                                                        }
                                                        if (array[n4] != 0) {
                                                            this.k.add(a3);
                                                        }
                                                        ++n4;
                                                        ++n6;
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                    p5.g();
                                                    continue Label_0641;
                                                }
                                                int n12 = n5;
                                                int i = 0;
                                                while (true) {
                                                    byte b2;
                                                    int n13;
                                                    e e;
                                                    byte b3 = 0;
                                                    aB j;
                                                    y.h.x x2;
                                                    aB ab;
                                                    y.h.y bends2;
                                                    y.h.x a5;
                                                    byte b4;
                                                    byte b5;
                                                    y.h.x a6;
                                                    fj targetRealizer;
                                                    fL targetPort;
                                                    double a7;
                                                    double b6;
                                                    fj sourceRealizer;
                                                    fL sourcePort;
                                                    double a8;
                                                    double b7;
                                                    x a9;
                                                    Object o;
                                                    double n14;
                                                    double n15;
                                                    fj t;
                                                    ek ek;
                                                    y.h.x a10;
                                                    x a11;
                                                    q e2;
                                                    Object o2;
                                                    q q;
                                                    fj fj;
                                                    y.h.x x3;
                                                    fj t2;
                                                    Object o3;
                                                    d d2;
                                                    aB k;
                                                    t p6;
                                                    t q2;
                                                    double n16;
                                                    d d3;
                                                    aB l;
                                                    y.h.x firstBend;
                                                    t p7;
                                                    double n17;
                                                    double n18;
                                                    boolean b8;
                                                    int bendCount = 0;
                                                    double gridX2;
                                                    y.h.x bend;
                                                    y.h.x bend2;
                                                    double gridY2;
                                                    y.h.x bend3;
                                                    y.h.x bend4;
                                                    d d4;
                                                    aB m;
                                                    y.h.x lastBend;
                                                    t q3;
                                                    double gridX3;
                                                    y.h.x bend5;
                                                    double gridY3;
                                                    y.h.x bend6;
                                                    double gridX4;
                                                    y.h.x appendBend;
                                                    y.h.x appendBend2;
                                                    double gridY4;
                                                    y.h.x appendBend3;
                                                    y.h.x appendBend4;
                                                    Label_2525_Outer:Label_1847_Outer:
                                                    while (i < array.length) {
                                                        b2 = array[i];
                                                        if (z) {
                                                            n13 = b2;
                                                            e = graph2D.p();
                                                        Label_1847:
                                                            while (true) {
                                                            Label_2525:
                                                                while (true) {
                                                                    do {
                                                                        Label_1012:
                                                                        e.f();
                                                                        Label_1019:
                                                                        while (b3 != 0) {
                                                                            j = graph2D.i(e.a());
                                                                            x2 = null;
                                                                            ab = j;
                                                                            if (!z) {
                                                                                bends2 = ab.bends();
                                                                                while (bends2.f()) {
                                                                                    a5 = bends2.a();
                                                                                    bends2.g();
                                                                                    b4 = (b3 = array[n13]);
                                                                                    if (z) {
                                                                                        continue Label_1019;
                                                                                    }
                                                                                    if (b3 != 0) {
                                                                                        z2.add(a5);
                                                                                        b5 = 0;
                                                                                        Label_1410: {
                                                                                            if ((b4 & 0x1) != 0x0) {
                                                                                                b5 = 3;
                                                                                                if (!z) {
                                                                                                    break Label_1410;
                                                                                                }
                                                                                            }
                                                                                            Label_1272: {
                                                                                                if ((b4 & 0x2) == 0x2) {
                                                                                                    if (bends2.f()) {
                                                                                                        a6 = bends2.a();
                                                                                                        if (a6.b() == a5.b()) {
                                                                                                            b5 |= 0x1;
                                                                                                            if (!z) {
                                                                                                                break Label_1272;
                                                                                                            }
                                                                                                        }
                                                                                                        if (a6.c() != a5.c()) {
                                                                                                            break Label_1272;
                                                                                                        }
                                                                                                        b5 |= 0x2;
                                                                                                        if (!z) {
                                                                                                            break Label_1272;
                                                                                                        }
                                                                                                    }
                                                                                                    targetRealizer = j.getTargetRealizer();
                                                                                                    targetPort = j.getTargetPort();
                                                                                                    a7 = targetPort.a(targetRealizer);
                                                                                                    b6 = targetPort.b(targetRealizer);
                                                                                                    if (a7 == a5.b()) {
                                                                                                        b5 |= 0x1;
                                                                                                        if (!z) {
                                                                                                            break Label_1272;
                                                                                                        }
                                                                                                    }
                                                                                                    if (b6 == a5.c()) {
                                                                                                        b5 |= 0x2;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if ((b4 & 0x4) == 0x4) {
                                                                                                if (x2 == null) {
                                                                                                    sourceRealizer = j.getSourceRealizer();
                                                                                                    sourcePort = j.getSourcePort();
                                                                                                    a8 = sourcePort.a(sourceRealizer);
                                                                                                    b7 = sourcePort.b(sourceRealizer);
                                                                                                    if (a8 == a5.b()) {
                                                                                                        b5 |= 0x1;
                                                                                                        if (!z) {
                                                                                                            break Label_1410;
                                                                                                        }
                                                                                                    }
                                                                                                    if (b7 != a5.c()) {
                                                                                                        break Label_1410;
                                                                                                    }
                                                                                                    b5 |= 0x2;
                                                                                                    if (!z) {
                                                                                                        break Label_1410;
                                                                                                    }
                                                                                                }
                                                                                                if (x2.b() == a5.b()) {
                                                                                                    b5 |= 0x1;
                                                                                                    if (!z) {
                                                                                                        break Label_1410;
                                                                                                    }
                                                                                                }
                                                                                                if (x2.c() == a5.c()) {
                                                                                                    b5 |= 0x2;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (b5 != 0) {
                                                                                            this.h.add(new ek(a5, new t(a5.b(), a5.c()), b5));
                                                                                        }
                                                                                    }
                                                                                    x2 = a5;
                                                                                    ++n13;
                                                                                    if (z) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                e.g();
                                                                                continue Label_1012;
                                                                            }
                                                                            while (true) {
                                                                                ab.setLayer((byte)0);
                                                                                e.g();
                                                                                if (!z) {
                                                                                    if (!z) {
                                                                                        if (e.f()) {
                                                                                            graph2D.i(e.a());
                                                                                            continue Label_2525_Outer;
                                                                                        }
                                                                                    }
                                                                                    this.getGraph2D().a(this.g.a());
                                                                                }
                                                                                break;
                                                                            }
                                                                            a9 = this.g.a();
                                                                            while (true) {
                                                                                while (a9.f()) {
                                                                                    graph2D.t(a9.e()).setLayer((byte)0, true);
                                                                                    a9.g();
                                                                                    if (z) {
                                                                                        o = null;
                                                                                        n14 = 0.0;
                                                                                        n15 = 0.0;
                                                                                        if (this.g.size() + this.h.size() == 1 && this.isGridMode()) {
                                                                                            if (this.g.size() == 1) {
                                                                                                t = graph2D.t(this.g.b());
                                                                                                n14 = t.getCenterX();
                                                                                                n15 = t.getCenterY();
                                                                                                t.setCenter(this.getGridX(n14), this.getGridY(n15));
                                                                                                this.b(t);
                                                                                                o = t;
                                                                                            }
                                                                                            else {
                                                                                                ek = this.h.get(0);
                                                                                                a10 = ek.a();
                                                                                                n14 = a10.b();
                                                                                                n15 = a10.c();
                                                                                                a10.a(this.getGridX(n14), this.getGridY(n15));
                                                                                                o = a10;
                                                                                                this.h.set(0, new ek(a10, a10.e(), ek.a));
                                                                                            }
                                                                                        }
                                                                                        a11 = this.g.a();
                                                                                        while (true) {
                                                                                            while (a11.f()) {
                                                                                                e2 = a11.e();
                                                                                                q = (q)(o2 = e2);
                                                                                                if (z) {
                                                                                                    if (o2 != null) {
                                                                                                        if (o instanceof fj) {
                                                                                                            fj = (fj)o;
                                                                                                            if (n14 != fj.getCenterX() || n15 != fj.getCenterY()) {
                                                                                                                this.a(fj.getCenterX() - n14, fj.getCenterY() - n15, gridX, gridY);
                                                                                                            }
                                                                                                        }
                                                                                                        if (o instanceof y.h.x) {
                                                                                                            x3 = (y.h.x)o;
                                                                                                            if (n14 != x3.b() || n15 != x3.c()) {
                                                                                                                this.a(x3.b() - n14, x3.c() - n15, gridX, gridY);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                    if (y.c.i.g) {
                                                                                                        y.h.fj.z = !z;
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                if (q != null && e2.e() != null) {
                                                                                                    t2 = graph2D.t(e2);
                                                                                                    this.x[e2.d()] = new Rectangle2D.Double(t2.getX(), t2.getY(), t2.getWidth(), t2.getHeight());
                                                                                                }
                                                                                                a11.g();
                                                                                                if (z) {
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            if (this.f()) {
                                                                                                this.c().a(new t(gridX, gridY), this.g, this.h, Collections.EMPTY_SET, y.g.q.a(this.x));
                                                                                                if (this.isGridMode()) {
                                                                                                    this.c().a(new dT(this, Double.POSITIVE_INFINITY));
                                                                                                }
                                                                                            }
                                                                                            this.a(gridX, gridY);
                                                                                            o2 = o;
                                                                                            continue Label_1847_Outer;
                                                                                        }
                                                                                    }
                                                                                    if (z) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                this.view.setDrawingMode(3);
                                                                                this.b(b);
                                                                                this.x = new Rectangle2D.Double[graph2D.e()];
                                                                                continue Label_1847_Outer;
                                                                            }
                                                                        }
                                                                        break;
                                                                    } while (!z);
                                                                    o3 = list3.iterator();
                                                                    while (((Iterator)o3).hasNext()) {
                                                                        d2 = ((Iterator<d>)o3).next();
                                                                        k = graph2D.i(d2);
                                                                        p6 = graph2D.p(d2);
                                                                        q2 = graph2D.q(d2);
                                                                        n16 = dcmpl(Math.abs(p6.a - q2.a), Math.abs(p6.b - q2.b));
                                                                        if (z) {
                                                                            while (true) {
                                                                                Label_2268: {
                                                                                    while (true) {
                                                                                        if (n16 != 0) {
                                                                                            d3 = ((Iterator<d>)o3).next();
                                                                                            l = graph2D.i(d3);
                                                                                            firstBend = l.firstBend();
                                                                                            p7 = graph2D.p(d3);
                                                                                            n17 = p7.a - firstBend.b();
                                                                                            n18 = p7.b - firstBend.c();
                                                                                            b8 = true;
                                                                                            bendCount = l.bendCount();
                                                                                            if (z) {
                                                                                                break Label_2268;
                                                                                            }
                                                                                            if (bendCount == 1 && d3.e() && list2.contains(d3)) {
                                                                                                b8 = false;
                                                                                            }
                                                                                            Label_2113: {
                                                                                                if (Math.abs(n17) <= Math.abs(n18)) {
                                                                                                    break Label_2113;
                                                                                                }
                                                                                                gridX2 = this.getGridX((firstBend.b() + p7.a()) * 0.5);
                                                                                                l.createBend(gridX2, p7.b, firstBend, 1);
                                                                                                bend = l.createBend(gridX2, firstBend.c(), firstBend, 1);
                                                                                                if (b8) {
                                                                                                    this.h.add(new ek(bend, bend.e(), (byte)2));
                                                                                                    if (!z) {
                                                                                                        break Label_1847;
                                                                                                    }
                                                                                                }
                                                                                                bend2 = l.createBend(firstBend.b(), firstBend.c(), firstBend, 1);
                                                                                                this.h.add(new ek(bend2, bend2.e(), (byte)1));
                                                                                                if (z) {
                                                                                                    break Label_2113;
                                                                                                }
                                                                                                ((Iterator)o3).hasNext();
                                                                                                continue Label_1847_Outer;
                                                                                            }
                                                                                            gridY2 = this.getGridY((firstBend.c() + p7.b()) * 0.5);
                                                                                            l.createBend(p7.a, gridY2, firstBend, 1);
                                                                                            bend3 = l.createBend(firstBend.b(), gridY2, firstBend, 1);
                                                                                            if (b8) {
                                                                                                this.h.add(new ek(bend3, bend3.e(), (byte)1));
                                                                                                if (!z) {
                                                                                                    continue Label_1847;
                                                                                                }
                                                                                            }
                                                                                            bend4 = l.createBend(firstBend.b(), firstBend.c(), firstBend, 1);
                                                                                            this.h.add(new ek(bend4, bend4.e(), (byte)2));
                                                                                            if (!z) {
                                                                                                continue Label_1847;
                                                                                            }
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                    o3 = list2.iterator();
                                                                                    ((Iterator)o3).hasNext();
                                                                                }
                                                                                if (bendCount != 0) {
                                                                                    d4 = ((Iterator<d>)o3).next();
                                                                                    m = graph2D.i(d4);
                                                                                    lastBend = m.lastBend();
                                                                                    q3 = graph2D.q(d4);
                                                                                    if (Math.abs(q3.a - lastBend.b()) > Math.abs(q3.b - lastBend.c())) {
                                                                                        gridX3 = this.getGridX((lastBend.b() + q3.a()) * 0.5);
                                                                                        m.createBend(gridX3, q3.b, lastBend, 0);
                                                                                        bend5 = m.createBend(gridX3, lastBend.c(), lastBend, 0);
                                                                                        this.h.add(new ek(bend5, bend5.e(), (byte)2));
                                                                                        if (!z) {
                                                                                            continue;
                                                                                        }
                                                                                    }
                                                                                    gridY3 = this.getGridY((lastBend.c() + q3.b()) * 0.5);
                                                                                    m.createBend(q3.a, gridY3, lastBend, 0);
                                                                                    bend6 = m.createBend(lastBend.b(), gridY3, lastBend, 0);
                                                                                    this.h.add(new ek(bend6, bend6.e(), (byte)1));
                                                                                    if (!z) {
                                                                                        continue;
                                                                                    }
                                                                                }
                                                                                break;
                                                                            }
                                                                            e = this.k.a();
                                                                            continue Label_2525;
                                                                        }
                                                                        Label_1823: {
                                                                            if (n16 > 0) {
                                                                                gridX4 = this.getGridX((p6.a + q2.a) * 0.5);
                                                                                appendBend = k.appendBend(gridX4, p6.b);
                                                                                appendBend2 = k.appendBend(gridX4, q2.b);
                                                                                if (this.g.contains(d2.c())) {
                                                                                    this.h.add(new ek(appendBend, appendBend.e(), (byte)2));
                                                                                    if (!z) {
                                                                                        break Label_1823;
                                                                                    }
                                                                                }
                                                                                this.h.add(new ek(appendBend2, appendBend2.e(), (byte)2));
                                                                                if (!z) {
                                                                                    break Label_1823;
                                                                                }
                                                                            }
                                                                            gridY4 = this.getGridY((p6.b + q2.b) * 0.5);
                                                                            appendBend3 = k.appendBend(p6.a, gridY4);
                                                                            appendBend4 = k.appendBend(q2.a, gridY4);
                                                                            if (this.g.contains(d2.c())) {
                                                                                this.h.add(new ek(appendBend3, appendBend3.e(), (byte)1));
                                                                                if (!z) {
                                                                                    break Label_1823;
                                                                                }
                                                                            }
                                                                            this.h.add(new ek(appendBend4, appendBend4.e(), (byte)1));
                                                                        }
                                                                        this.k.add(d2);
                                                                        if (z) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    break;
                                                                }
                                                                o3 = list.iterator();
                                                                continue Label_1847;
                                                            }
                                                        }
                                                        if (b2 > 0) {
                                                            ++n12;
                                                        }
                                                        ++i;
                                                        if (z) {
                                                            break;
                                                        }
                                                    }
                                                    graph2D.a(this.k.a());
                                                    this.h = new ArrayList(n12 + list3.size() + list.size() + list2.size());
                                                    z2.clear();
                                                    continue;
                                                }
                                            }
                                            break;
                                        } while (!z);
                                        continue;
                                    }
                                }
                                if (contains == set.contains(d.d())) {
                                    continue Label_0547_Outer;
                                }
                                list3.add(d);
                                if (z) {
                                    break;
                                }
                                continue Label_0547_Outer;
                            }
                        }
                        list3.isEmpty();
                        continue;
                    }
                }
                if (this.A.contains(a2)) {
                    this.A.add(a2);
                    final aB i2 = graph2D.i(a2);
                    if (i2.firstBend() == x && !set.contains(a2.c())) {
                        list.add(a2);
                    }
                    if (i2.lastBend() == x && !set.contains(a2.d())) {
                        list2.add(a2);
                    }
                }
                p4 = p4.a();
                if (z) {
                    break;
                }
            }
            final dP dp = this;
            continue;
        }
    }
    
    protected boolean a(final d d) {
        return aC.b(d, this.getGraph2D());
    }
    
    private boolean n() {
        return ((this.h != null) ? this.h.size() : 0) + ((this.g != null) ? this.g.size() : 0) == 1;
    }
    
    public void cancelEditing() {
        this.c().f();
        if (this.isEditing()) {
            this.b(this.d - this.b, this.e - this.c, this.d, this.e);
            this.q();
            this.view.setDrawingMode(0);
            if (this.i != null) {
                this.view.setViewCursor(this.i);
                this.i = null;
            }
            this.view.getGraph2D().T();
            this.setEditing(false);
            this.reactivateParent();
            this.g = null;
            this.A = Collections.EMPTY_SET;
            this.h = null;
            this.x = null;
        }
    }
    
    protected Object b(final double n, final double n2) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        final cW c = this.c(n, n2);
        if (!c.t()) {
            return graph2D;
        }
        final v i = this.i();
        final C e = c.e();
        bu bu = null;
        while (e.f()) {
            final q q = (q)e.d();
            bu = graph2D;
            if (z) {
                return bu;
            }
            if (!bu.v(q) && i.k(q)) {
                return q;
            }
            e.g();
            if (z) {
                break;
            }
        }
        return bu;
    }
    
    protected cW c(final double n, final double n2) {
        return new cW(this.view, n, n2, false, 4);
    }
    
    protected v i() {
        return y.h.a.v.a(this.getGraph2D());
    }
    
    public byte j() {
        return this.n;
    }
    
    public boolean k() {
        return this.o;
    }
    
    public boolean l() {
        return this.p;
    }
    
    protected void a(final Graphics2D graphics2D, final fj fj) {
        dI.b(graphics2D, fj);
    }
    
    protected Rectangle2D a(final fj fj) {
        return new Rectangle2D.Double(fj.getX() - 10.0, fj.getY() - 10.0, fj.getWidth() + 20.0, fj.getHeight() + 20.0);
    }
    
    private void o() {
        final boolean z = fj.z;
        if (this.k() && this.l()) {
            final MouseEvent mouseEvent = (this.lastDragEvent != null) ? this.lastDragEvent : this.lastPressEvent;
            if (mouseEvent != null && (mouseEvent.getModifiers() & 0x1) != 0x0) {
                this.p();
                if (!z) {
                    return;
                }
            }
            this.q();
            if (!z) {
                return;
            }
        }
        this.q();
    }
    
    private void p() {
        if (!this.q) {
            this.q = true;
            this.view.addDrawable(this.r);
        }
    }
    
    private void q() {
        if (this.q) {
            this.view.removeDrawable(this.r);
            this.q = false;
        }
    }
    
    private void b(final boolean b) {
        final boolean z = fj.z;
        final v i = this.i();
        if (i == null) {
            this.s = null;
            return;
        }
        final bu graph2D = this.getGraph2D();
        Label_0106: {
            if (this.s != null) {
                graph2D.a(this.s.a());
                p p = this.s.k();
                while (p != null) {
                    graph2D.t((q)p.c()).setLayer((byte)0, true);
                    p = p.a();
                    if (z) {
                        break Label_0106;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            this.w = new HashMap();
        }
        final x o = graph2D.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                final boolean k = i.k(e);
                if (z) {
                    if (k) {
                        this.e(false);
                    }
                    return;
                }
                if (k) {
                    this.w.put(e, graph2D.t(e).getBoundingBox());
                }
                o.g();
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    private void d(final boolean b) {
        if (b) {
            this.e(true);
        }
        this.s = null;
        this.t = null;
        this.w = null;
    }
    
    private void e(final boolean b) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        Label_0091: {
            if (b) {
                if (this.z != null) {
                    p p = this.z.k();
                    while (true) {
                        while (p != null) {
                            final a autoBoundsFeature = graph2D.t((q)p.c()).getAutoBoundsFeature();
                            if (!z) {
                                if (autoBoundsFeature != null) {
                                    autoBoundsFeature.setAutoBoundsEnabled(true);
                                }
                                p = p.a();
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (z) {
                                    break Label_0091;
                                }
                                return;
                            }
                        }
                        this.z = null;
                        continue;
                    }
                }
                return;
            }
        }
        if (this.s != null) {
            if (this.z == null) {
                this.z = new y();
            }
            p p2 = this.s.k();
            while (p2 != null) {
                final q q = (q)p2.c();
                final a autoBoundsFeature2 = graph2D.t(q).getAutoBoundsFeature();
                if (autoBoundsFeature2 != null && autoBoundsFeature2.isAutoBoundsEnabled()) {
                    autoBoundsFeature2.setAutoBoundsEnabled(false);
                    this.z.add(q);
                }
                p2 = p2.a();
                if (z) {
                    break;
                }
            }
        }
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);
        this.u = false;
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    public void mouseDraggedRight(final double n, final double n2) {
        this.mouseDraggedLeft(n, n2);
    }
    
    static double a(final dP dp) {
        return dp.d;
    }
    
    static double b(final dP dp) {
        return dp.e;
    }
}
