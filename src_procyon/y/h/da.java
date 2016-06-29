package y.h;

import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import y.c.*;
import y.d.*;
import y.h.a.*;
import java.awt.*;

public class da extends gX
{
    private double a;
    private double b;
    private byte c;
    private boolean d;
    private q e;
    private t f;
    private byte g;
    private boolean h;
    private byte i;
    private HashMap j;
    private boolean k;
    private Set l;
    private int m;
    private Rectangle2D.Double[] n;
    private t o;
    private int p;
    private KeyListener q;
    private int r;
    private boolean s;
    private dc t;
    
    public int a() {
        return this.m;
    }
    
    protected boolean a(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.a()) != 0x0;
    }
    
    public dc c() {
        if (this.t == null) {
            this.t = this.f();
        }
        return this.t;
    }
    
    public boolean e() {
        return this.h;
    }
    
    public void a(final boolean h) {
        this.h = h;
    }
    
    protected dc f() {
        return new dc(this.view);
    }
    
    public da() {
        this.g = 3;
        this.i = 1;
        this.l = Collections.EMPTY_SET;
        this.m = 2;
        this.p = 2;
        this.r = 27;
    }
    
    public void mousePressedLeft(final double a, final double b) {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        this.s = false;
        this.n = new Rectangle2D.Double[graph2D.f()];
        this.o = new t(a, b);
        this.l = new HashSet();
        final v c = graph2D.C();
        x x = null;
        Label_0213: {
            if (c != null && this.l() == 1) {
                final y y = new y(graph2D.J());
                final HashSet set = new HashSet<q>(y);
                p p2 = y.k();
                while (p2 != null) {
                    Object o = p2.c();
                Label_0114:
                    while (true) {
                        final q q = (q)o;
                        q q2 = c.n(q);
                        while (q2 != null) {
                            final i i = (i)(o = q2.e());
                            if (z) {
                                continue Label_0114;
                            }
                            if (i != graph2D || !set.add(q2)) {
                                break;
                            }
                            q2 = c.n(q);
                            if (z) {
                                break;
                            }
                        }
                        break;
                    }
                    p2 = p2.a();
                    if (z) {
                        break;
                    }
                }
                x = new y(set.iterator()).a();
                if (!z) {
                    break Label_0213;
                }
            }
            x = graph2D.J();
        }
        byte c2 = 8;
        final x o2 = graph2D.o();
        while (true) {
            while (o2.f()) {
                final q e = o2.e();
                final byte v;
                final boolean b2 = (v = (byte)(graph2D.v(e) ? 1 : 0)) != 0;
                if (!z) {
                    if (b2) {
                        final fj t = graph2D.t(e);
                        this.n[e.d()] = t.getBoundingBox();
                        final byte hotSpotHit;
                        if (c2 == 8 && (hotSpotHit = t.hotSpotHit(a, b)) != 8) {
                            this.e = o2.e();
                            c2 = hotSpotHit;
                        }
                    }
                    o2.g();
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    boolean b3 = false;
                    Label_0694: {
                        if (v != 8) {
                            this.a = a;
                            this.b = b;
                            this.setEditing(this.d = true);
                            this.view.setDrawingMode(1);
                            this.f = this.a(a, b);
                            final f f = new f();
                            final e p3 = graph2D.p();
                            while (p3.f()) {
                                final d a2 = p3.a();
                                final boolean v2 = graph2D.v(a2.c());
                                final boolean v3 = graph2D.v(a2.d());
                                b3 = v2;
                                if (z) {
                                    break Label_0694;
                                }
                                Label_0611: {
                                    if (b3 || v3) {
                                        final boolean a3 = this.a(a2);
                                        if (v2 && (a3 || (this.k && graph2D.i(a2).bendCount() > 0) || !graph2D.n(a2).equals(y.d.t.c))) {
                                            f.add(a2);
                                            if (!a3) {
                                                break Label_0611;
                                            }
                                            this.l.add(a2);
                                            if (!z) {
                                                break Label_0611;
                                            }
                                        }
                                        if (v3 && (a3 || (this.k && graph2D.i(a2).bendCount() > 0) || !graph2D.o(a2).equals(y.d.t.c))) {
                                            f.add(a2);
                                            if (a3) {
                                                this.l.add(a2);
                                            }
                                        }
                                    }
                                }
                                p3.g();
                                if (z) {
                                    break;
                                }
                            }
                            graph2D.r();
                            graph2D.a(x);
                            graph2D.a(f.a());
                            graph2D.s();
                        }
                        if (this.q == null && this.r >= 0) {
                            this.q = new db(this);
                            this.view.getCanvasComponent().addKeyListener(this.q);
                        }
                        this.e();
                    }
                    if (b3) {
                        this.c().a(this.o, new y(graph2D.J()), y.g.q.a(this.n));
                    }
                    final y y2 = new y();
                    gg.a(this.getGraph2D(), y2, y2, null);
                    final x a4 = y2.a();
                Label_0898:
                    while (true) {
                        while (a4.f()) {
                            graph2D.t(a4.e()).setLayer((byte)0);
                            a4.g();
                            if (z) {
                                this.j = null;
                                return;
                            }
                            if (z) {
                                break;
                            }
                        }
                        if (c != null && this.l() == 1) {
                            this.j = new HashMap();
                            final x o3 = graph2D.o();
                            while (o3.f()) {
                                final q e2 = o3.e();
                                if (c.k(e2)) {
                                    this.j.put(e2, graph2D.t(e2).getBoundingBox());
                                }
                                o3.g();
                                if (z) {
                                    continue Label_0898;
                                }
                            }
                            return;
                        }
                        continue Label_0898;
                    }
                }
            }
            this.c = c2;
            byte v = c2;
            continue;
        }
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        super.mouseReleased(mouseEvent);
        this.j = null;
    }
    
    protected boolean a(final d d) {
        return aC.b(d, this.getGraph2D());
    }
    
    public void mouseDraggedLeft(double a, double b) {
        final boolean z = fj.z;
        if (!this.d) {
            return;
        }
        Label_0568: {
            if (this.g == 3) {
                this.b(a, b);
                if (!z) {
                    break Label_0568;
                }
            }
            if (this.g == 1) {
                final t c = this.c(a, b);
                a = c.a;
                b = c.b;
            }
            final bu graph2D = this.getGraph2D();
            double n = a - this.a;
            double n2 = b - this.b;
            double n3 = (n > 0.0) ? 1.0 : -1.0;
            double n4 = (n2 > 0.0) ? 1.0 : -1.0;
            Label_0242: {
                switch (this.c) {
                    case 0: {
                        n = -n;
                        n2 = -n2;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 6: {
                        n = -n;
                        n2 = 0.0;
                        n4 = 0.0;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 3: {
                        n = -n;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 1: {
                        n = 0.0;
                        n3 = 0.0;
                        n2 = -n2;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 4: {
                        n = 0.0;
                        n3 = 0.0;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 2: {
                        n2 = -n2;
                        if (z) {
                            break Label_0242;
                        }
                        break;
                    }
                    case 7: {
                        n2 = 0.0;
                        n4 = 0.0;
                        break;
                    }
                }
            }
            final x j = graph2D.J();
            while (j.f()) {
                final fj t = graph2D.t(j.e());
                final double width = t.getWidth();
                final double height = t.getHeight();
                if (z) {
                    return;
                }
                final double n5 = (width + n < 1.0) ? 1.0 : (width + n);
                final double n6 = (height + n2 < 1.0) ? 1.0 : (height + n2);
                this.a(t, t.getX() + Math.abs(n5 - t.getWidth()) * n3 / 2.0 + (width - n5) / 2.0, t.getY() + Math.abs(n6 - t.getHeight()) * n4 / 2.0 + (height - n6) / 2.0, n5, n6);
                this.a(graph2D, j.e(), width, height, t.getWidth(), t.getHeight());
                if (j.e() == this.e) {
                    this.a = a;
                    this.b = b;
                    if (this.g == 2) {
                        if (width > 1.0 && n5 <= 1.0) {
                            this.b(this.c = this.h());
                        }
                        if (height > 1.0 && n6 <= 1.0) {
                            this.b(this.c = this.i());
                        }
                    }
                }
                j.g();
                if (z) {
                    break;
                }
            }
        }
        this.view.updateView();
    }
    
    private void b(double a, double b) {
        final boolean z = fj.z;
        final boolean modifierPressed = this.isModifierPressed(this.lastDragEvent);
        final boolean b2 = this.b(this.lastDragEvent);
        Label_0093: {
            if (this.e() && !this.a(this.lastDragEvent)) {
                final t a2 = this.c().a(new t(a, b), this.c, modifierPressed, b2);
                a = a2.a;
                b = a2.b;
                if (!z) {
                    break Label_0093;
                }
            }
            this.c().h();
        }
        final double n = a - this.o.a;
        final double n2 = b - this.o.b;
        final bu graph2D = this.getGraph2D();
        final x j = graph2D.J();
        while (j.f()) {
            final fj t = graph2D.t(j.e());
            final double width = t.getWidth();
            final double height = t.getHeight();
            y.d.q b3 = new y.d.q(1.0, 1.0);
            y.d.q a3 = new y.d.q(Double.MAX_VALUE, Double.MAX_VALUE);
            final gt sizeConstraintProvider = t.getSizeConstraintProvider();
            if (sizeConstraintProvider != null) {
                b3 = ((sizeConstraintProvider.getMinimumSize() != null) ? sizeConstraintProvider.getMinimumSize() : b3);
                a3 = ((sizeConstraintProvider.getMaximumSize() != null) ? sizeConstraintProvider.getMaximumSize() : a3);
            }
            final double[] array = { 0.0, 0.0, 0.0, 0.0 };
            if (j.e().d() < this.n.length) {
                final Rectangle2D.Double double1 = this.n[j.e().d()];
                if (double1 != null) {
                    final double n3 = double1.getWidth() / double1.getHeight();
                    if (modifierPressed) {
                        b3 = this.b(n3, b3);
                        a3 = this.a(n3, a3);
                    }
                    Label_1717: {
                        switch (this.c) {
                            case 0: {
                                if (modifierPressed) {
                                    if (n3 * n2 < n) {
                                        if (b2) {
                                            this.a(n3 * n2, array, b3, a3, double1, true);
                                            this.b(n2, array, b3, a3, double1, true);
                                            if (!z) {
                                                break;
                                            }
                                        }
                                        this.a(n3 * n2, array, b3, a3, double1, false);
                                        this.b(n2, array, b3, a3, double1, false);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    if (b2) {
                                        this.a(n, array, b3, a3, double1, true);
                                        this.b(n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.a(n, array, b3, a3, double1, false);
                                    this.b(n / n3, array, b3, a3, double1, false);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(n, array, b3, a3, double1, true);
                                    this.b(n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.a(n, array, b3, a3, double1, false);
                                this.b(n2, array, b3, a3, double1, false);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 1: {
                                if (modifierPressed) {
                                    if (b2) {
                                        this.a(n3 * n2, array, b3, a3, double1, true);
                                        this.b(n2, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.a(n3 * n2 * 0.5, array, b3, a3, double1, true);
                                    this.b(n2, array, b3, a3, double1, false);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.b(n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.b(n2, array, b3, a3, double1, false);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 2: {
                                if (modifierPressed) {
                                    if (-n3 * n2 > n) {
                                        if (b2) {
                                            this.a(n3 * n2, array, b3, a3, double1, true);
                                            this.b(n2, array, b3, a3, double1, true);
                                            if (!z) {
                                                break;
                                            }
                                        }
                                        this.b(-n3 * n2, array, b3, a3, double1);
                                        this.b(n2, array, b3, a3, double1, false);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    if (b2) {
                                        this.a(-n, array, b3, a3, double1, true);
                                        this.b(-n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.b(n, array, b3, a3, double1);
                                    this.b(-n / n3, array, b3, a3, double1, false);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(-n, array, b3, a3, double1, true);
                                    this.b(n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.b(n, array, b3, a3, double1);
                                this.b(n2, array, b3, a3, double1, false);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 6: {
                                if (modifierPressed) {
                                    if (b2) {
                                        this.a(n, array, b3, a3, double1, true);
                                        this.b(n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.a(n, array, b3, a3, double1, false);
                                    this.b(n / n3 * 0.5, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(n, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.a(n, array, b3, a3, double1, false);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 7: {
                                if (modifierPressed) {
                                    if (b2) {
                                        this.a(-n, array, b3, a3, double1, true);
                                        this.b(-n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.b(n, array, b3, a3, double1);
                                    this.b(-n / n3 * 0.5, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(-n, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.b(n, array, b3, a3, double1);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 3: {
                                if (modifierPressed) {
                                    if (-n3 * n2 < n) {
                                        if (b2) {
                                            this.a(-n3 * n2, array, b3, a3, double1, true);
                                            this.b(-n2, array, b3, a3, double1, true);
                                            if (!z) {
                                                break;
                                            }
                                        }
                                        this.a(-n3 * n2, array, b3, a3, double1, false);
                                        this.a(n2, array, b3, a3, double1);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    if (b2) {
                                        this.a(n, array, b3, a3, double1, true);
                                        this.b(n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.a(n, array, b3, a3, double1, false);
                                    this.a(-n / n3, array, b3, a3, double1);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(n, array, b3, a3, double1, true);
                                    this.b(-n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.a(n, array, b3, a3, double1, false);
                                this.a(n2, array, b3, a3, double1);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 4: {
                                if (modifierPressed) {
                                    if (b2) {
                                        this.a(-n3 * n2, array, b3, a3, double1, true);
                                        this.b(-n2, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.a(-n3 * n2 * 0.5, array, b3, a3, double1, true);
                                    this.a(n2, array, b3, a3, double1);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.b(-n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.a(n2, array, b3, a3, double1);
                                if (z) {
                                    break Label_1717;
                                }
                                break;
                            }
                            case 5: {
                                if (modifierPressed) {
                                    if (n3 * n2 > n) {
                                        if (b2) {
                                            this.a(-n3 * n2, array, b3, a3, double1, true);
                                            this.b(-n2, array, b3, a3, double1, true);
                                            if (!z) {
                                                break;
                                            }
                                        }
                                        this.b(n3 * n2, array, b3, a3, double1);
                                        this.a(n2, array, b3, a3, double1);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    if (b2) {
                                        this.a(-n, array, b3, a3, double1, true);
                                        this.b(-n / n3, array, b3, a3, double1, true);
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    this.b(n, array, b3, a3, double1);
                                    this.a(n / n3, array, b3, a3, double1);
                                    if (!z) {
                                        break;
                                    }
                                }
                                if (b2) {
                                    this.a(-n, array, b3, a3, double1, true);
                                    this.b(-n2, array, b3, a3, double1, true);
                                    if (!z) {
                                        break;
                                    }
                                }
                                this.b(n, array, b3, a3, double1);
                                this.a(n2, array, b3, a3, double1);
                                break;
                            }
                        }
                    }
                    final double n4 = array[0];
                    final double n5 = array[1];
                    final double n6 = array[2];
                    final double n7 = array[3];
                    final double n8 = double1.getX() + n6;
                    final double n9 = double1.getY() + n7;
                    final double n10 = double1.getWidth() + n4;
                    final double n11 = double1.getHeight() + n5;
                    if (n8 != t.getX() || n10 != t.getWidth() || n9 != t.getY() || n11 != t.getHeight()) {
                        this.a(t, n8, n9, n10, n11);
                        this.a(graph2D, j.e(), width, height, t.getWidth(), t.getHeight());
                    }
                }
            }
            j.g();
            if (z) {
                break;
            }
        }
    }
    
    private y.d.q a(final double n, final y.d.q q) {
        double a = q.a();
        double b = q.b();
        if (n > q.a() / q.b()) {
            b = q.a() / n;
            if (!fj.z) {
                return new y.d.q(a, b);
            }
        }
        a = q.b() * n;
        return new y.d.q(a, b);
    }
    
    private y.d.q b(final double n, final y.d.q q) {
        double a = q.a();
        double b = q.b();
        if (n < q.a() / q.b()) {
            b = q.a() / n;
            if (!fj.z) {
                return new y.d.q(a, b);
            }
        }
        a = q.b() * n;
        return new y.d.q(a, b);
    }
    
    protected boolean isModifierPressed(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.getModifierMask()) != 0x0;
    }
    
    protected boolean b(final MouseEvent mouseEvent) {
        return (mouseEvent.getModifiers() & this.g()) != 0x0;
    }
    
    public int g() {
        return this.p;
    }
    
    private void a(final double n, final double[] array, final y.d.q q, final y.d.q q2, final Rectangle2D.Double double1) {
        final boolean z = fj.z;
        if (n < 0.0) {
            final double b = q.b();
            if (b >= 0.0 && double1.getHeight() + n < b) {
                array[1] = b - double1.getHeight();
                if (!z) {
                    return;
                }
            }
            array[1] = n;
            if (!z) {
                return;
            }
        }
        if (n > 0.0) {
            final double b2 = q2.b();
            if (b2 < Double.MAX_VALUE && double1.getHeight() + n > b2) {
                array[1] = b2 - double1.getHeight();
                if (!z) {
                    return;
                }
            }
            array[1] = n;
        }
    }
    
    private void b(final double n, final double[] array, final y.d.q q, final y.d.q q2, final Rectangle2D.Double double1) {
        final boolean z = fj.z;
        if (n < 0.0) {
            final double a = q.a();
            if (a >= 0.0 && double1.getWidth() + n < a) {
                array[0] = a - double1.getWidth();
                if (!z) {
                    return;
                }
            }
            array[0] = n;
            if (!z) {
                return;
            }
        }
        if (n > 0.0) {
            final double a2 = q2.a();
            if (a2 < Double.MAX_VALUE && double1.getWidth() + n > a2) {
                array[0] = a2 - double1.getWidth();
                if (!z) {
                    return;
                }
            }
            array[0] = n;
        }
    }
    
    private void a(final double n, final double[] array, final y.d.q q, final y.d.q q2, final Rectangle2D.Double double1, final boolean b) {
        final boolean z = fj.z;
        final double n2 = b ? 2.0 : 1.0;
        if (n > 0.0) {
            final double a = q.a();
            if (a >= 0.0 && double1.getWidth() - n * n2 < a) {
                array[0] = a - double1.getWidth();
                array[2] = -array[0] / n2;
                if (!z) {
                    return;
                }
            }
            array[0] = -n * n2;
            array[2] = n;
            if (!z) {
                return;
            }
        }
        if (n < 0.0) {
            final double a2 = q2.a();
            if (a2 < Double.MAX_VALUE && double1.getWidth() - n * n2 > a2) {
                array[0] = a2 - double1.getWidth();
                array[2] = -array[0] / n2;
                if (!z) {
                    return;
                }
            }
            array[0] = -(array[2] = n) * n2;
        }
    }
    
    private void b(final double n, final double[] array, final y.d.q q, final y.d.q q2, final Rectangle2D.Double double1, final boolean b) {
        final boolean z = fj.z;
        final double n2 = b ? 2.0 : 1.0;
        if (n > 0.0) {
            final double b2 = q.b();
            if (b2 >= 0.0 && double1.getHeight() - n * n2 < b2) {
                array[1] = b2 - double1.getHeight();
                array[3] = -array[1] / n2;
                if (!z) {
                    return;
                }
            }
            array[1] = -n * n2;
            array[3] = n;
            if (!z) {
                return;
            }
        }
        if (n < 0.0) {
            final double b3 = q2.b();
            if (b3 < Double.MAX_VALUE && double1.getHeight() - n * n2 > b3) {
                array[1] = b3 - double1.getHeight();
                array[3] = -array[1] / n2;
                if (!z) {
                    return;
                }
            }
            array[1] = -(array[3] = n) * n2;
        }
    }
    
    protected void a(final bu bu, final q q, final double n, final double n2, final double n3, final double n4) {
        this.a(bu, q, (n > 0.0) ? (n3 / n) : 1.0, (n2 > 0.0) ? (n4 / n2) : 1.0, false);
    }
    
    private void a(final bu bu, final q q, final double n, final double n2, final boolean b) {
        final boolean z = fj.z;
        final fj t = bu.t(q);
        d d = q.f();
        while (true) {
            while (d != null) {
                aB ab = bu.i(d);
                fL fl = ab.getSourcePort();
                final eU b2 = t.b(ab.vb);
                if (z) {
                    while (true) {
                        if (b2 == null) {
                            fl.b(fl.g() * n, fl.h() * n2);
                        }
                        if (this.l.contains(d)) {
                            ic.a(this.view, ab, fl.a(t), fl.b(t), false);
                            if (b) {
                                fu.a(ab);
                            }
                        }
                        d = d.h();
                        if (!z) {
                            if (d != null) {
                                ab = bu.i(d);
                                fl = ab.getTargetPort();
                                t.b(ab.zb);
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (b2 == null) {
                    fl.b(fl.g() * n, fl.h() * n2);
                }
                if (this.l.contains(d)) {
                    ic.a(this.view, ab, fl.a(t), fl.b(t), true);
                    if (b) {
                        fu.a(ab);
                    }
                }
                d = d.g();
                if (z) {
                    break;
                }
            }
            d = q.g();
            continue;
        }
    }
    
    byte h() {
        switch (this.c) {
            case 7: {
                return 6;
            }
            case 6: {
                return 7;
            }
            case 0: {
                return 2;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 5;
            }
            case 5: {
                return 3;
            }
            default: {
                return this.c;
            }
        }
    }
    
    byte i() {
        switch (this.c) {
            case 1: {
                return 4;
            }
            case 4: {
                return 1;
            }
            case 0: {
                return 3;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return 5;
            }
            case 5: {
                return 2;
            }
            default: {
                return this.c;
            }
        }
    }
    
    protected void a(final fj fj, double n, double n2, double n3, double n4) {
        final boolean z = fj.z;
        if (fj.getSizeConstraintProvider() != null) {
            final gt sizeConstraintProvider = fj.getSizeConstraintProvider();
            final y.d.q minimumSize = sizeConstraintProvider.getMinimumSize();
            if (n3 < minimumSize.a()) {
                n3 = minimumSize.a();
                if (n != fj.getX()) {
                    n = fj.getX() + fj.getWidth() - n3;
                }
            }
            if (n4 < minimumSize.b()) {
                n4 = minimumSize.b();
                if (n2 != fj.getY()) {
                    n2 = fj.getY() + fj.getHeight() - n4;
                }
            }
            final y.d.q maximumSize = sizeConstraintProvider.getMaximumSize();
            if (n3 > maximumSize.a()) {
                n3 = maximumSize.a();
                if (n != fj.getX()) {
                    n = fj.getX() + fj.getWidth() - n3;
                }
            }
            if (n4 > maximumSize.b()) {
                n4 = maximumSize.b();
                if (n2 != fj.getY()) {
                    n2 = fj.getY() + fj.getHeight() - n4;
                }
            }
        }
        final v a = v.a(this.view.getGraph2D());
        Label_0387: {
            if (a != null && fj.getAutoBoundsFeature() != null) {
                final a autoBoundsFeature = fj.getAutoBoundsFeature();
                if (autoBoundsFeature.isAutoBoundsEnabled() && fj.getNode() != null && a.p(fj.getNode()).f()) {
                    final Rectangle2D minimalAutoBounds = autoBoundsFeature.getMinimalAutoBounds();
                    autoBoundsFeature.setAutoBoundsInsets(new r(Math.max(0.0, minimalAutoBounds.getY() - n2), Math.max(0.0, minimalAutoBounds.getX() - n), Math.max(0.0, n2 + n4 - minimalAutoBounds.getMaxY()), Math.max(0.0, n + n3 - minimalAutoBounds.getMaxX())));
                    if (!z) {
                        break Label_0387;
                    }
                }
                fj.setFrame(n, n2, n3, n4);
                if (!z) {
                    break Label_0387;
                }
            }
            fj.setFrame(n, n2, n3, n4);
        }
        if (a != null && this.j != null && this.l() == 1) {
            q q = fj.getNode();
            final bu graph2D = this.getGraph2D();
            while ((q = a.n(q)) != null && graph2D.f(q)) {
                final a autoBoundsFeature2 = graph2D.t(q).getAutoBoundsFeature();
                if (autoBoundsFeature2 != null) {
                    final Rectangle2D rectangle2D = this.j.get(q);
                    final Rectangle2D minimalAutoBounds2 = autoBoundsFeature2.getMinimalAutoBounds();
                    autoBoundsFeature2.setAutoBoundsInsets(new r(Math.max(0.0, minimalAutoBounds2.getY() - rectangle2D.getY()), Math.max(0.0, minimalAutoBounds2.getX() - rectangle2D.getX()), Math.max(0.0, rectangle2D.getMaxY() - minimalAutoBounds2.getMaxY()), Math.max(0.0, rectangle2D.getMaxX() - minimalAutoBounds2.getMaxX())));
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    public void mouseReleasedLeft(final double n, final double n2) {
        this.c().f();
        if (this.d) {
            this.d = false;
            this.k();
            this.m();
            this.view.updateWorldRect();
            this.view.setDrawingMode(0);
            this.getGraph2D().T();
            this.setEditing(false);
            this.reactivateParent();
            if (!fj.z) {
                return;
            }
        }
        if (this.s) {
            this.s = false;
            this.reactivateParent();
        }
    }
    
    private void m() {
        final boolean z = fj.z;
        if (this.k) {
            final HashSet set = new HashSet();
            final x j = this.getGraph2D().J();
            while (j.f()) {
                set.addAll(new f(j.e().j()));
                j.g();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
            fu.a(this.getGraph2D(), set);
        }
    }
    
    public void activate(final boolean b) {
        Label_0033: {
            if (b) {
                this.s = false;
                this.c().a(this.view);
                if (!fj.z) {
                    break Label_0033;
                }
            }
            this.c().f();
        }
        super.activate(b);
    }
    
    public void reactivateParent() {
        this.c().f();
        if (this.q != null) {
            this.view.getCanvasComponent().removeKeyListener(this.q);
            this.q = null;
        }
        this.d = false;
        this.n = null;
        this.l = Collections.EMPTY_SET;
        this.o = null;
        this.setEditing(false);
        super.reactivateParent();
    }
    
    protected void j() {
        final boolean z = fj.z;
        final bu graph2D = this.view.getGraph2D();
        Label_0112: {
            if (this.n != null) {
                final x j = graph2D.J();
                while (j.f()) {
                    final q e = j.e();
                    final Rectangle2D.Double double1 = this.n[e.d()];
                    this.a(graph2D.t(e), double1.getX(), double1.getY(), double1.getWidth(), double1.getHeight());
                    j.g();
                    if (z) {
                        break Label_0112;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            this.view.setDrawingMode(0);
            this.view.updateView();
        }
        if (this.d) {
            this.d = false;
            this.s = true;
            if (!z) {
                return;
            }
        }
        this.setEditing(false);
        this.reactivateParent();
    }
    
    void k() {
        final boolean z = fj.z;
        final bu graph2D = this.getGraph2D();
        final x o = graph2D.o();
        while (o.f()) {
            final q e = o.e();
            if (graph2D.v(e)) {
                final fj t = graph2D.t(e);
                t.setCenter(this.getGridX(t.getCenterX()), this.getGridY(t.getCenterY()));
                this.a(graph2D, e, 1.0, 1.0, true);
            }
            o.g();
            if (z) {
                break;
            }
        }
    }
    
    public static Cursor a(final byte b) {
        switch (b) {
            case 0: {
                return Cursor.getPredefinedCursor(6);
            }
            case 6: {
                return Cursor.getPredefinedCursor(10);
            }
            case 3: {
                return Cursor.getPredefinedCursor(4);
            }
            case 1: {
                return Cursor.getPredefinedCursor(8);
            }
            case 4: {
                return Cursor.getPredefinedCursor(9);
            }
            case 2: {
                return Cursor.getPredefinedCursor(7);
            }
            case 7: {
                return Cursor.getPredefinedCursor(11);
            }
            case 5: {
                return Cursor.getPredefinedCursor(5);
            }
            default: {
                return Cursor.getPredefinedCursor(0);
            }
        }
    }
    
    private void b(final byte b) {
        this.view.setViewCursor(a(b));
    }
    
    private t c(final double n, final double n2) {
        final boolean z = fj.z;
        final bu graph2D = this.view.getGraph2D();
        final double m = graph2D.m(this.e);
        final double n3 = graph2D.n(this.e);
        final double n4 = m + graph2D.p(this.e);
        final double n5 = n3 + graph2D.q(this.e);
        final double a = this.f.a;
        final double b = this.f.b;
        double n6 = n;
        double n7 = n2;
        switch (this.c) {
            case 2:
            case 5:
            case 7: {
                if (n6 < m + a) {
                    n6 = m + a;
                    if (!z) {
                        break;
                    }
                }
                if (n6 < n4 + a && this.a <= n) {
                    this.a = n6;
                    break;
                }
                break;
            }
        }
        switch (this.c) {
            case 0:
            case 3:
            case 6: {
                if (n6 > n4 - a) {
                    n6 = n4 - a;
                    if (!z) {
                        break;
                    }
                }
                if (n6 > m - a && this.a >= n) {
                    this.a = n6;
                    break;
                }
                break;
            }
        }
        switch (this.c) {
            case 0:
            case 1:
            case 2: {
                if (n7 > n5 - b) {
                    n7 = n5 - b;
                    if (!z) {
                        break;
                    }
                }
                if (n7 > n3 - b && this.b >= n2) {
                    this.b = n7;
                    break;
                }
                break;
            }
        }
        switch (this.c) {
            case 3:
            case 4:
            case 5: {
                if (n7 < n3 + b) {
                    n7 = n3 + b;
                    if (!z) {
                        break;
                    }
                }
                if (n7 < n5 + b && this.b <= n2) {
                    this.b = n7;
                    break;
                }
                break;
            }
        }
        return new t(n6, n7);
    }
    
    t a(final double n, final double n2) {
        final bu graph2D = this.view.getGraph2D();
        final double m = graph2D.m(this.e);
        final double n3 = graph2D.n(this.e);
        final double n4 = m + graph2D.p(this.e);
        final double n5 = n3 + graph2D.q(this.e);
        double n6 = 0.0;
        double n7 = 0.0;
        switch (this.c) {
            case 2:
            case 5:
            case 7: {
                n6 = n - n4;
                break;
            }
        }
        switch (this.c) {
            case 0:
            case 3:
            case 6: {
                n6 = m - n;
                break;
            }
        }
        switch (this.c) {
            case 0:
            case 1:
            case 2: {
                n7 = n3 - n2;
                break;
            }
        }
        switch (this.c) {
            case 3:
            case 4:
            case 5: {
                n7 = n2 - n5;
                break;
            }
        }
        return new t(n6, n7);
    }
    
    public void cancelEditing() {
        if (this.isEditing()) {
            this.j();
        }
    }
    
    public byte l() {
        return this.i;
    }
    
    static int a(final da da) {
        return da.r;
    }
    
    static KeyListener a(final da da, final KeyListener q) {
        return da.q = q;
    }
}
