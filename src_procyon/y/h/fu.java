package y.h;

import java.beans.*;
import java.awt.event.*;
import y.g.*;
import y.c.*;
import java.util.*;
import java.awt.geom.*;
import y.d.*;

public class fu extends gX
{
    private aB a;
    private boolean b;
    private boolean c;
    private List d;
    private dU e;
    private boolean f;
    private boolean g;
    private boolean h;
    private t i;
    private fz j;
    private boolean k;
    private double l;
    private double m;
    private o n;
    private PropertyChangeListener o;
    private int p;
    
    public fu() {
        this.b = true;
        this.c = true;
        this.d = new ArrayList(3);
        this.f = true;
        this.g = true;
        this.h = true;
        this.j = new fz();
        this.p = 2;
        this.o = new fv(this);
    }
    
    public int a() {
        return this.p;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return mouseEvent != null && (mouseEvent.getModifiers() & this.a()) != 0x0;
    }
    
    public dU c() {
        if (this.e == null) {
            this.e = this.f();
        }
        return this.e;
    }
    
    public boolean e() {
        return this.h;
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    protected dU f() {
        final dU du = new dU(this.view);
        du.e(false);
        du.g(true);
        du.b(false);
        du.c(true);
        du.f(false);
        du.a(false);
        return du;
    }
    
    public void mousePressedLeft(final double l, final double m) {
        final boolean z = fj.z;
        this.l = l;
        this.m = m;
        this.i = new t(l, m);
        final cW hitInfo = this.getHitInfo(l, m);
        this.a = null;
        final x j = hitInfo.j();
        if (this.e() && this.c() != null) {
            this.c().a(this.view);
        }
        this.d.clear();
        Label_0205: {
            if (this.f) {
                final y i = this.getGraph2D().M();
                while (i.f()) {
                    i.a().a(false);
                    i.g();
                    if (z) {
                        break Label_0205;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (this.g) {
                final y.c.x k = this.getGraph2D().J();
                while (k.f()) {
                    this.getGraph2D().a(k.e(), false);
                    k.g();
                    if (z) {
                        break Label_0205;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            this.j = new fz();
        }
        aB a = null;
        if (j != null) {
            this.getGraph2D().a(new f(j.a()).a());
            this.a(this.j, a = this.getGraph2D().i(j.a()), j, this.d);
        }
        else {
            final d k2 = hitInfo.k();
            if (k2 != null) {
                this.getGraph2D().a(new f(k2).a());
                this.a(this.j, a = this.getGraph2D().i(k2), l, m, this.d);
            }
        }
        if (this.d.isEmpty()) {
            this.a = null;
            this.reactivateParent();
            if (!z) {
                return;
            }
        }
        this.a = a;
        Label_0752: {
            if (this.c() != null && this.e()) {
                this.c().a(this.view);
                final HashSet<el> set = new HashSet<el>();
                final HashSet<el> set2 = new HashSet<el>();
                while (true) {
                Label_0731_Outer:
                    for (final en en : this.d) {
                        Label_0486: {
                            if (en.a() instanceof ek) {
                                set2.add(en.a());
                                if (!z) {
                                    break Label_0486;
                                }
                            }
                            if (en.a() instanceof em) {
                                set.add(en.a());
                            }
                        }
                        if (en.b() instanceof ek) {
                            set2.add(en.b());
                            if (!z) {
                                continue;
                            }
                        }
                        if (en.b() instanceof em) {
                            set.add(en.b());
                            if (z) {
                                while (true) {
                                    for (final en en2 : this.d) {
                                        this.c().a(en2);
                                        final byte a2 = a(en2);
                                        final el b = en2.b();
                                        if (b instanceof fA) {
                                            final fA fa = (fA)b;
                                            if (fa.e()) {
                                                this.c().a(this.a(fa, a2));
                                            }
                                        }
                                        final el a3 = en2.a();
                                        if (a3 instanceof fA) {
                                            final fA fa2 = (fA)a3;
                                            final boolean e = fa2.e();
                                            if (!z) {
                                                if (!e) {
                                                    continue Label_0731_Outer;
                                                }
                                                this.c().a(this.a(fa2, a2));
                                                if (z) {
                                                    break;
                                                }
                                                continue Label_0731_Outer;
                                            }
                                            else {
                                                if (e) {
                                                    this.c().a(new fw(this, Double.MAX_VALUE));
                                                }
                                                break Label_0752;
                                            }
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (z) {
                                break;
                            }
                            continue;
                        }
                    }
                    this.c().a(this.i, Collections.EMPTY_SET, set2, set, q.a((Object)null));
                    continue;
                }
            }
        }
        if (this.n == null) {
            this.n = new fx(this);
            this.getGraph2D().a(this.n);
        }
        this.view.addPropertyChangeListener("Graph2D", this.o);
        this.setEditing(true);
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.mouseReleasedLeft(this.l, this.m);
        }
    }
    
    private void g() {
        if (this.c() != null && this.e()) {
            this.c().f();
        }
        this.setEditing(false);
        this.a = null;
        this.d.clear();
        this.reactivateParent();
    }
    
    public void reactivateParent() {
        if (this.n != null) {
            this.getGraph2D().b(this.n);
            this.n = null;
        }
        this.view.removePropertyChangeListener("Graph2D", this.o);
        super.reactivateParent();
    }
    
    private gz a(final fA fa, final byte b) {
        return new fy(this, Double.MAX_VALUE, fa, b);
    }
    
    protected x a(final fz fz, final aB ab, x x, final Collection collection) {
        final boolean z = fj.z;
        final double worldCoordX = this.view.toWorldCoordX(this.lastPressEvent.getX());
        final double worldCoordY = this.view.toWorldCoordY(this.lastPressEvent.getY());
        final boolean a = a(ab);
        x firstBend = ab.firstBend();
        double n = Double.MAX_VALUE;
        int i = 0;
        while (true) {
            while (i < ab.bendCount()) {
                final x bend = ab.getBend(i);
                final double a2 = t.a(worldCoordX, worldCoordY, bend.b(), bend.c());
                final double n2 = dcmpg(a2, n);
                if (z) {
                    Label_0260: {
                        if (n2 < 0) {
                            x = firstBend;
                            if (!z) {
                                break Label_0260;
                            }
                        }
                        final int containsSeg = ab.containsSeg(worldCoordX, worldCoordY);
                        if (containsSeg > 0) {
                            if (containsSeg > ab.bendCount() - 1) {
                                final t b = b(ab, ab.bendCount() - 1);
                                x = ab.appendBend(b.a(), b.b());
                                ab.appendBend(ab.lastBend().b(), ab.lastBend().c());
                                if (!z) {
                                    break Label_0260;
                                }
                            }
                            final x bend2 = ab.getBend(containsSeg);
                            x = ab.createBend(bend2.b(), bend2.c(), bend2, 1);
                            ab.createBend(bend2.b(), bend2.c(), bend2, 1);
                        }
                    }
                    if (x != null && this.b) {
                        x.a(true);
                    }
                    Label_0704: {
                        if (x != null) {
                            final int a3 = this.a(ab, x);
                            final boolean b2 = a3 > 0;
                            final boolean b3 = a3 < ab.bendCount() - 1;
                            final boolean b4 = a == (a3 % 2 == 1);
                            final boolean b5 = !b4;
                            final ek ek = new ek(x, new t(x.b(), x.c()), (byte)3);
                            Label_0542: {
                                if (b2) {
                                    final x bend3 = ab.getBend(a3 - 1);
                                    collection.add(new en(ek, new ek(bend3, new t(bend3.b(), bend3.c()), (byte)(b4 ? 1 : 2))));
                                    if (!z) {
                                        break Label_0542;
                                    }
                                }
                                final fA fa = new fA(eU.b(ab), ab.getSourcePort(), b(ab, 0), (byte)(b4 ? 1 : 2));
                                this.a(fz, worldCoordX, worldCoordY, ab.getSourceRealizer(), ab.getSourcePort(), !b4, b4);
                                collection.add(new en(ek, fa));
                            }
                            if (b3) {
                                final x bend4 = ab.getBend(a3 + 1);
                                collection.add(new en(ek, new ek(bend4, new t(bend4.b(), bend4.c()), (byte)(b5 ? 1 : 2))));
                                if (!z) {
                                    break Label_0704;
                                }
                            }
                            final fA fa2 = new fA(eU.d(ab), ab.getTargetPort(), b(ab, ab.bendCount() + 1), (byte)(b5 ? 1 : 2));
                            this.a(fz, worldCoordX, worldCoordY, ab.getTargetRealizer(), ab.getTargetPort(), !b5, b5);
                            collection.add(new en(ek, fa2));
                        }
                    }
                    this.getGraph2D().T();
                    return x;
                }
                if (n2 < 0) {
                    firstBend = bend;
                    n = a2;
                }
                ++i;
                if (z) {
                    break;
                }
            }
            final double n3 = dcmpg(n, 10.0);
            continue;
        }
    }
    
    protected void a(final fz fz, final aB ab, double gridX, double gridY, final Collection collection) {
        final boolean z = fj.z;
        final boolean a = a(ab);
        if (ab.bendCount() == 0) {
            this.a(fz, ab, gridX, gridY, collection, a);
            return;
        }
        final int max = Math.max(1, ab.containsSeg(gridX, gridY));
        gridX = this.getGridX(gridX);
        gridY = this.getGridY(gridY);
        final boolean b = a == (max % 2 == 0);
        int n = b ? 1 : 2;
        x x = null;
        x x2 = null;
        x x3 = null;
        Label_0792: {
            if (max >= 1) {
                if (max > ab.bendCount()) {
                    if (this.c || this.isModifierPressed(this.lastPressEvent)) {
                        final t b2 = b(ab, ab.bendCount() + 2);
                        if (!b) {
                            x = ab.appendBend(gridX, b2.b);
                            n = 3;
                            x2 = ab.appendBend(gridX, b2.b);
                            x3 = ab.getBend(this.a(ab, x) - 1);
                            if (!z) {
                                break Label_0792;
                            }
                        }
                        x = ab.appendBend(b2.a, gridY);
                        n = 3;
                        x2 = ab.appendBend(b2.a, gridY);
                        x3 = ab.getBend(this.a(ab, x) - 1);
                        if (!z) {
                            break Label_0792;
                        }
                    }
                    final ek ek = new ek(ab.lastBend(), b(ab, ab.bendCount()), (byte)(b ? 1 : 2));
                    final fA fa = new fA(eU.d(ab), ab.getTargetPort(), b(ab, ab.bendCount() + 1), (byte)(b ? 1 : 2));
                    this.a(fz, gridX, gridY, ab.getTargetRealizer(), ab.getTargetPort(), !b, b);
                    collection.add(new en(ek, fa));
                    x = null;
                    x3 = null;
                    x2 = null;
                    if (!z) {
                        break Label_0792;
                    }
                }
                final x bend = ab.getBend(max - 1);
                if (this.isModifierPressed(this.lastPressEvent) || (max == 1 && this.c)) {
                    if (max == 1) {
                        final t b3 = b(ab, max);
                        if (!b) {
                            x2 = ab.createBend(gridX, b3.b, bend, 1);
                            n = 3;
                            x = ab.createBend(gridX, b3.b, bend, 1);
                            x3 = bend;
                            if (!z) {
                                break Label_0792;
                            }
                        }
                        x2 = ab.createBend(b3.a, gridY, bend, 1);
                        n = 3;
                        x = ab.createBend(b3.a, gridY, bend, 1);
                        x3 = bend;
                        if (!z) {
                            break Label_0792;
                        }
                    }
                    final t b4 = b(ab, max);
                    if (!b) {
                        x = ab.createBend(gridX, b4.b, bend, 1);
                        n = 3;
                        x2 = ab.createBend(gridX, b4.b, bend, 1);
                        x3 = ab.getBend(this.a(ab, x) - 1);
                        if (!z) {
                            break Label_0792;
                        }
                    }
                    x = ab.createBend(b4.a, gridY, bend, 1);
                    n = 3;
                    x2 = ab.createBend(b4.a, gridY, bend, 1);
                    x3 = ab.getBend(this.a(ab, x) - 1);
                    if (!z) {
                        break Label_0792;
                    }
                }
                if (max > 1) {
                    x = bend;
                    x3 = ab.getBend(max - 2);
                    x2 = null;
                    if (!z) {
                        break Label_0792;
                    }
                }
                final ek ek2 = new ek(ab.firstBend(), b(ab, 1), (byte)(b ? 1 : 2));
                this.a(fz, gridX, gridY, ab.getSourceRealizer(), ab.getSourcePort(), !b, b);
                collection.add(new en(ek2, new fA(eU.b(ab), ab.getSourcePort(), b(ab, 0), (byte)(b ? 1 : 2))));
                x = null;
                x3 = null;
                x2 = null;
                if (!z) {
                    break Label_0792;
                }
            }
            x3 = null;
            x = null;
            x2 = null;
        }
        if (x != null) {
            final ek ek3 = new ek(x, new t(x.b(), x.c()), (byte)n);
            if (x3 != null) {
                collection.add(new en(ek3, new ek(x3, new t(x3.b(), x3.c()), (byte)(b ? 1 : 2))));
            }
            if (x2 != null) {
                collection.add(new en(ek3, new ek(x2, new t(x2.b(), x2.c()), (byte)(b ? 2 : 1))));
            }
        }
        if (this.b && !collection.isEmpty()) {
            final Iterator<x> iterator = this.a(collection).iterator();
            while (iterator.hasNext()) {
                iterator.next().a(true);
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        this.getGraph2D().T();
    }
    
    private void a(final fz fz, final aB ab, final double n, final double n2, final Collection collection, final boolean b) {
        final t b2 = b(ab, 0);
        final t b3 = b(ab, 1);
        final double n3 = b2.a - b3.a;
        final double n4 = b2.b - b3.b;
        if (this.c || this.isModifierPressed(this.lastPressEvent)) {
            x x = null;
            x x2 = null;
            Label_0437: {
                if (Math.abs(n3) > Math.abs(n4)) {
                    final double n5 = (b2.a + n) * 0.5;
                    final double n6 = (b3.a + n) * 0.5;
                    ab.appendBend(n5, b2.b);
                    x = ab.appendBend(n5, n2);
                    x2 = ab.appendBend(n6, n2);
                    ab.appendBend(n6, b3.b);
                    if (!fj.z) {
                        break Label_0437;
                    }
                }
                final double n7 = (b2.b + n2) * 0.5;
                final double n8 = (b3.b + n2) * 0.5;
                ab.appendBend(b2.a, n7);
                x = ab.appendBend(n, n7);
                x2 = ab.appendBend(n, n8);
                ab.appendBend(b3.a, n8);
            }
            collection.add(new en(new ek(x, new t(x.b(), x.c()), (byte)(b ? 2 : 1)), new ek(x2, new t(x2.b(), x2.c()), (byte)(b ? 2 : 1))));
            if (this.b) {
                x.a(true);
                x2.a(true);
            }
            this.getGraph2D().T();
            return;
        }
        if (n3 != 0.0) {
            this.a(fz, n, n2, ab.getSourceRealizer(), ab.getSourcePort(), true, false);
            this.a(fz, n, n2, ab.getTargetRealizer(), ab.getTargetPort(), true, false);
            collection.add(new en(new fA(eU.b(ab), ab.getSourcePort(), b(ab, 0), (byte)2), new fA(eU.d(ab), ab.getTargetPort(), b(ab, 1), (byte)2)));
            return;
        }
        if (n4 != 0.0) {
            this.a(fz, n, n2, ab.getSourceRealizer(), ab.getSourcePort(), false, true);
            this.a(fz, n, n2, ab.getTargetRealizer(), ab.getTargetPort(), false, true);
            collection.add(new en(new fA(eU.b(ab), ab.getSourcePort(), b(ab, 0), (byte)1), new fA(eU.d(ab), ab.getTargetPort(), b(ab, 1), (byte)1)));
        }
    }
    
    private void a(final fz fz, final double n, final double n2, final fj fj, final fL fl, final boolean b, final boolean b2) {
        if (b) {
            final double n3 = n2 - fl.b(fj);
            fz.c(Math.max(fz.c(), fj.getY() + n3));
            fz.d(Math.min(fz.d(), fj.getY() + fj.getHeight() + n3));
        }
        if (b2) {
            final double n4 = n - fl.a(fj);
            fz.a(Math.max(fz.a(), fj.getX() + n4));
            fz.b(Math.min(fz.b(), fj.getX() + fj.getWidth() + n4));
        }
    }
    
    private Collection a(final Collection collection) {
        final boolean z = fj.z;
        final HashSet<x> set = new HashSet<x>();
        HashSet<x> set2 = null;
        for (final en en : collection) {
            if (en.a() instanceof ek) {
                set.add(((ek)en.a()).a());
            }
            if (en.b() instanceof ek) {
                set2 = set;
                if (z) {
                    return set2;
                }
                set2.add(((ek)en.b()).a());
                if (z) {
                    break;
                }
                continue;
            }
        }
        return set2;
    }
    
    private int a(final aB ab, final x x) {
        final boolean z = fj.z;
        int i = 0;
        while (i < ab.bendCount()) {
            if (ab.getBend(i) == x) {
                return i;
            }
            ++i;
            if (z) {
                break;
            }
        }
        return -1;
    }
    
    public void mouseDraggedLeft(final double l, final double m) {
        this.a(this.l = l, this.m = m, !this.a(this.lastDragEvent));
    }
    
    private void a(double n, double n2, final boolean b) {
        final boolean z = fj.z;
        if (this.d.isEmpty()) {
            if (this.c() != null && this.e()) {
                this.c().h();
            }
            return;
        }
        n = this.getGridX(n);
        n2 = this.getGridY(n2);
        final Point2D.Double double1 = new Point2D.Double(n, n2);
        this.j.a(double1);
        n = double1.x;
        n2 = double1.y;
        int n3 = 1;
        Label_0784: {
            if (this.c() != null && this.e()) {
                if (b) {
                    final t b2 = this.c().b(new t(n, n2));
                    n = b2.a;
                    n2 = b2.b;
                    final Point2D.Double double2 = new Point2D.Double(n, n2);
                    this.j.a(double2);
                    n = double2.x;
                    n2 = double2.y;
                    if (!z) {
                        break Label_0784;
                    }
                }
                this.c().h();
                if (!z) {
                    break Label_0784;
                }
            }
            final double n4 = n - this.i.a;
            final double n5 = n2 - this.i.b;
            final fC fc = new fC(this.i, n, n2);
            while (true) {
            Label_0759:
                for (final en en : this.d) {
                    final byte a = a(en);
                    t c = null;
                    final el b3 = en.b();
                    if (b3 instanceof fA && ((fA)b3).e()) {
                        c = ((fA)b3).c(n4, n5);
                        final t a2 = this.a(c, b3.b(), a);
                        if (!this.j.a(a2.a(), a2.b())) {
                            fc.b();
                            if (!z) {
                                break;
                            }
                        }
                    }
                    t c2 = null;
                    final el a3 = en.a();
                    if (a3 instanceof fA && ((fA)a3).e()) {
                        c2 = ((fA)a3).c(n4, n5);
                        final t a4 = this.a(c2, a3.b(), a);
                        if (!this.j.a(a4.a(), a4.b())) {
                            fc.b();
                            if (!z) {
                                break;
                            }
                        }
                    }
                    if (c != null) {
                        if (c2 != null) {
                            switch (a) {
                                case 0: {
                                    if (!this.a(c.b(), c2.b())) {
                                        fc.b();
                                        if (!z) {
                                            break Label_0759;
                                        }
                                    }
                                    fc.b.b((c.b() - b3.b().b() + c2.b() - a3.b().b()) * 0.5);
                                    if (!fc.a()) {
                                        break Label_0759;
                                    }
                                    break;
                                }
                                case 1: {
                                    if (!this.a(c.a(), c2.a())) {
                                        fc.b();
                                        if (!z) {
                                            break Label_0759;
                                        }
                                    }
                                    fc.a.b((c.a() - b3.b().a() + c2.a() - a3.b().a()) * 0.5);
                                    if (!fc.a()) {
                                        break Label_0759;
                                    }
                                    break;
                                }
                            }
                            if (!z) {
                                continue;
                            }
                        }
                        final t b4 = b3.b();
                        fc.a(c.a() - b4.a(), c.b() - b4.b(), a);
                        if (!fc.a()) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (c2 == null) {
                            continue;
                        }
                        final t b5 = a3.b();
                        fc.a(c2.a() - b5.a(), c2.b() - b5.b(), a);
                        final boolean a5 = fc.a();
                        if (z) {
                            n3 = (a5 ? 1 : 0);
                            n = fc.a.a();
                            n2 = fc.b.a();
                            break Label_0784;
                        }
                        if (!a5) {
                            break;
                        }
                        continue;
                    }
                }
                fc.a();
                continue;
            }
        }
        if (n3 != 0) {
            this.a(n - this.i.a, n2 - this.i.b, this.d);
            this.getGraph2D().T();
        }
    }
    
    private t a(final t t, final t t2, final byte b) {
        switch (b) {
            case 0: {
                return new t(t.a(), t.b() + this.i.b - t2.b());
            }
            case 1: {
                return new t(t.a() + this.i.a - t2.a(), t.b());
            }
            default: {
                return t;
            }
        }
    }
    
    private boolean a(final double n, final double n2) {
        return Math.abs(n - n2) * Math.max(1.0, this.view.getZoom()) <= 0.1;
    }
    
    private static byte a(final en en) {
        final el b = en.b();
        final el a = en.a();
        final double n = b.b().a - a.b().a;
        final double n2 = b.b().b - a.b().b;
        if (n == 0.0 && (n2 != 0.0 || b.c() != a.c())) {
            return 1;
        }
        if (n2 == 0.0 && (n != 0.0 || b.d() != a.d())) {
            return 0;
        }
        return -1;
    }
    
    private void a(final double n, final double n2, final List list) {
        final boolean z = fj.z;
        int i = 0;
        while (i < list.size()) {
            list.get(i).a(n, n2);
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        final boolean z = fj.z;
        super.mouseReleasedLeft(n, n2);
        this.a(n, n2, !this.a(this.lastReleaseEvent));
        if (this.c() != null && this.e()) {
            this.c().f();
        }
        for (final x x : this.a(this.d)) {
            this.a(x, x.b(), x.c());
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        if (this.a != null) {
            this.b(this.a);
            if (this.k) {
                c(this.a);
            }
            this.a = null;
        }
        this.d.clear();
        this.setEditing(false);
        this.reactivateParent();
    }
    
    public void mouseReleasedRight(final double n, final double n2) {
        this.mouseReleasedLeft(n, n2);
    }
    
    private static t b(final aB ab, final int n) {
        final bu bu = (bu)ab.getEdge().a();
        if (n < 1) {
            return bu.p(ab.getEdge());
        }
        if (n > ab.bendCount()) {
            return bu.q(ab.getEdge());
        }
        final x bend = ab.getBend(n - 1);
        return new t(bend.b(), bend.c());
    }
    
    public static boolean a(final aB ab) {
        final boolean z = fj.z;
        if (ab.getMinBendCount() > 0 || ab.getEdge() == null || ab.getEdge().a() == null) {
            return false;
        }
        d(ab);
        int a = a(ab, ab.bendCount() + 2);
        if (ab.getEdge().e()) {
            if (a == 2) {
                final t b = b(ab, 0);
                final t b2 = b(ab, 1);
                if (a(b, b2)) {
                    return true;
                }
                if (b.a == b2.a) {
                    return false;
                }
                if (b.b == b2.b) {
                    return true;
                }
                ab.insertBend(b.a, b2.b);
                return false;
            }
            else if (a == 3) {
                final t b3 = b(ab, 0);
                final t b4 = b(ab, 1);
                final t b5 = b(ab, 2);
                if (Math.abs(b4.a - b3.a) < Math.abs(b4.b - b3.b)) {
                    ab.getBend(0).a(b3.a, b4.b);
                    ab.appendBend(b5.a, b4.b);
                    return false;
                }
                ab.getBend(0).a(b4.a, b3.b);
                ab.appendBend(b4.a, b5.b);
                return true;
            }
        }
        if (a > 2) {
            final t b6 = b(ab, a - 1);
            double n = t.a(b(ab, a - 2), b6);
            int n2 = 0;
            int n3 = 0;
            Label_0333: {
                while (n < 3.0) {
                    n2 = a;
                    n3 = 2;
                    if (z || n2 <= n3) {
                        break Label_0333;
                    }
                    ab.removeBend(ab.lastBend());
                    --a;
                    n = t.a(b(ab, a - 2), b6);
                    if (z) {
                        goto Label_0331;
                    }
                }
                goto Label_0331;
            }
            if (n2 > n3) {
                final t b7 = b(ab, 0);
                double n4 = t.a(b(ab, 1), b7);
                while (n4 < 3.0 && a > 2) {
                    ab.removeBend(ab.firstBend());
                    --a;
                    n4 = t.a(b(ab, 1), b7);
                    if (z) {
                        break;
                    }
                }
            }
            t t = b(ab, 0);
            t t2 = b(ab, 1);
            final z z2 = new z(t2, t);
            boolean b8 = Math.abs(z2.b()) > Math.abs(z2.a());
            final boolean b9 = !b8;
            if (a > 2) {
                final x firstBend = ab.firstBend();
                Label_0510: {
                    if (b8) {
                        firstBend.a(t.a, firstBend.c());
                        if (!z) {
                            break Label_0510;
                        }
                    }
                    firstBend.a(firstBend.b(), t.b);
                }
                t = new t(firstBend.b(), firstBend.c());
                b8 = !b8;
            }
            int i = 1;
            while (true) {
            Label_1121_Outer:
                while (i < ab.bendCount()) {
                    final x bend = ab.getBend(i);
                    final t t3 = new t(bend.b(), bend.c());
                    z z3 = new z(t3, t);
                    final double n5 = dcmpl(z3.b(), 0.0);
                    if (z) {
                        if ((n5 == 0 && b8) || (z3.a() == 0.0 && !b8 && a > 2)) {
                            if (a == 3) {
                                final z z4 = new z(b(ab, a - 3), t);
                                if (z4.a() * z3.a() + z4.b() * z3.b() > 0.0) {
                                    ab.appendBend(t.a(), t.b());
                                    ++a;
                                    final boolean b10 = !b8;
                                    return b9;
                                }
                            }
                            ab.removeBend(ab.lastBend());
                            --a;
                            t = b(ab, a - 2);
                            z3 = new z(t2, t);
                        }
                        double n6 = z3.d();
                        while (true) {
                            while (n6 < 3.0) {
                                final int bendCount = ab.bendCount();
                                if (!z) {
                                    if (bendCount <= 0) {
                                        break;
                                    }
                                    ab.removeBend(ab.lastBend());
                                    --a;
                                    t = b(ab, a - 2);
                                    t2 = b(ab, a - 1);
                                    z3 = new z(t2, t);
                                    n6 = z3.d();
                                    b8 = !b8;
                                    if (z) {
                                        break;
                                    }
                                    continue Label_1121_Outer;
                                }
                                else {
                                    if (bendCount != 0) {
                                        if (z3.b() != 0.0 && z3.a() != 0.0) {
                                            if (!b8) {
                                                ab.lastBend().a(t.a, t2.b());
                                                if (!z) {
                                                    return b9;
                                                }
                                            }
                                            ab.lastBend().a(t2.a(), t.b);
                                        }
                                        return b9;
                                    }
                                    if (t.a == t2.a || t.b == t2.b) {
                                        return b9;
                                    }
                                    if (Math.abs(z3.a()) < Math.abs(z3.b())) {
                                        final double n7 = (t.b + t2.b) * 0.5;
                                        ab.appendBend(t.a, n7);
                                        ab.appendBend(t2.a, n7);
                                        ++a;
                                        return false;
                                    }
                                    final double n8 = (t.a + t2.a) * 0.5;
                                    ab.appendBend(n8, t.b);
                                    ab.appendBend(n8, t2.b);
                                    ++a;
                                    return true;
                                }
                            }
                            ab.bendCount();
                            continue;
                        }
                    }
                    Label_0836: {
                        if ((n5 == 0 && b8) || (z3.a() == 0.0 && !b8)) {
                            ab.removeBend(ab.getBend(i - 1));
                            t = t3;
                            --a;
                            --i;
                            if (!z) {
                                break Label_0836;
                            }
                        }
                        if (Math.abs(z3.b()) > Math.abs(z3.a()) != b8) {
                            final x bend2 = ab.createBend(0.0, 0.0, bend, 1);
                            ++i;
                            ++a;
                            Label_0738: {
                                if (b8) {
                                    bend2.a(t.a, bend.c());
                                    if (!z) {
                                        break Label_0738;
                                    }
                                }
                                bend2.a(bend.b(), t.b);
                            }
                            t = new t(bend.b(), bend.c());
                            b8 = !b8;
                        }
                        Label_0806: {
                            if (b8) {
                                bend.a(t.a, bend.c());
                                if (!z) {
                                    break Label_0806;
                                }
                            }
                            bend.a(bend.b(), t.b);
                        }
                        t = new t(bend.b(), bend.c());
                        b8 = !b8;
                    }
                    ++i;
                    if (z) {
                        break;
                    }
                }
                t = b(ab, a - 2);
                t2 = b(ab, a - 1);
                z z3 = new z(t2, t);
                final double n9 = dcmpl(z3.b(), 0.0);
                continue;
            }
        }
        goto Label_0331;
    }
    
    private static void d(final aB ab) {
        final boolean z = fj.z;
        final t sourcePoint = ab.getSourcePoint();
        if (Double.isNaN(sourcePoint.a()) || Double.isNaN(sourcePoint.b())) {
            ab.setSourcePoint(t.c);
        }
        if (ab.bendCount() > 0) {
            final y bends = ab.bends();
            while (bends.f()) {
                final x a = bends.a();
                if (Double.isNaN(a.b()) || Double.isNaN(a.c())) {
                    ab.removeBend(a);
                }
                bends.g();
                if (z) {
                    break;
                }
            }
        }
        final t targetPoint = ab.getTargetPoint();
        if (Double.isNaN(targetPoint.a()) || Double.isNaN(targetPoint.b())) {
            ab.setTargetPoint(t.c);
        }
    }
    
    public static int a(final aB ab, int n) {
        final boolean z = fj.z;
        if (ab.getMinBendCount() > 0 || ab.getEdge() == null || ab.getEdge().a() == null) {
            return n;
        }
        int i = 1;
        while (true) {
            while (i < n - 1) {
                final int a = a(b(ab, i), b(ab, i - 1)) ? 1 : 0;
                if (z) {
                    if (a > 2 && a(b(ab, n - 1), b(ab, n - 2))) {
                        ab.removeBend(ab.getBend(n - 3));
                        --n;
                    }
                    return n;
                }
                if (a != 0) {
                    ab.removeBend(ab.getBend(i - 1));
                    --n;
                    --i;
                }
                ++i;
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    protected void a(final x x, final double n, final double n2) {
    }
    
    protected void b(final aB ab) {
        final boolean z = fj.z;
        if (ab.getMinBendCount() > 0 || ab.getEdge() == null || ab.getEdge().a() == null) {
            return;
        }
        while (true) {
            while (ab.bendCount() > 0) {
                final int a = a(b(ab, 0), b(ab, 1)) ? 1 : 0;
                if (z) {
                    int a2 = 0;
                    Label_0123: {
                        if (a > 0) {
                            final int n = a2 = (a(b(ab, ab.bendCount()), b(ab, ab.bendCount() + 1)) ? 1 : 0);
                            if (z) {
                                break Label_0123;
                            }
                            if (n != 0) {
                                ab.removeBend(ab.lastBend());
                                if (!z) {
                                    break;
                                }
                            }
                        }
                        a2 = 1;
                    }
                    int i = a2;
                    while (i < ab.bendCount()) {
                        if (a(b(ab, i), b(ab, i + 1))) {
                            ab.removeBend(ab.getBend(i));
                            ab.removeBend(ab.getBend(i - 1));
                            --i;
                        }
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                if (a == 0) {
                    break;
                }
                ab.removeBend(ab.firstBend());
                if (z) {
                    break;
                }
            }
            ab.bendCount();
            continue;
        }
    }
    
    static void a(final bu bu, final Collection collection) {
        final boolean z = fj.z;
        final Iterator<d> iterator = collection.iterator();
        while (iterator.hasNext()) {
            c(bu.i(iterator.next()));
            if (z) {
                break;
            }
        }
    }
    
    static void c(final aB ab) {
        final bu i = ab.i();
        if (ab.bendCount() > 0 && ab.getEdge() != null && ab.getEdge().a() != null) {
            final d edge = ab.getEdge();
            final fj sourceRealizer = ab.getSourceRealizer();
            while (ab.bendCount() > ab.getMinBendCount() && sourceRealizer.contains(ab.firstBend().b(), ab.firstBend().c())) {
                i.c(edge, ab.firstBend().e());
                if (ab.removeBend(ab.firstBend()) == null) {
                    break;
                }
            }
            final fj targetRealizer = ab.getTargetRealizer();
            while (ab.bendCount() > ab.getMinBendCount() && targetRealizer.contains(ab.lastBend().b(), ab.lastBend().c())) {
                i.d(edge, ab.lastBend().e());
                if (null == ab.removeBend(ab.lastBend())) {
                    break;
                }
            }
        }
    }
    
    private static boolean a(final t t, final t t2) {
        return t == t2 || (Double.compare(t.a(), t2.a()) == 0 && Double.compare(t.b(), t2.b()) == 0);
    }
    
    static o a(final fu fu) {
        return fu.n;
    }
    
    static o a(final fu fu, final o n) {
        return fu.n = n;
    }
    
    static fz b(final fu fu) {
        return fu.j;
    }
    
    static aB c(final fu fu) {
        return fu.a;
    }
    
    static void d(final fu fu) {
        fu.g();
    }
    
    static t e(final fu fu) {
        return fu.i;
    }
}
