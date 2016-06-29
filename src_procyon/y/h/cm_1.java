package y.h;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import y.f.*;
import java.lang.ref.*;
import java.util.*;
import y.d.*;
import java.awt.geom.*;
import y.c.*;

public class cm
{
    ch a;
    ActionMap b;
    public static final Object c;
    public static final Object d;
    public static final Object e;
    public static final Object f;
    public static final Object g;
    public static final Object h;
    public static final Object i;
    public static final Object j;
    public static final Object k;
    public static final Object l;
    public static final Object m;
    public static final Object n;
    public static final Object o;
    public static final Object p;
    public static final Object q;
    public static final Object r;
    public static final Object s;
    public static final Object t;
    public static final Object u;
    public static final Object v;
    public static final Object w;
    public static final Object x;
    public static final Object y;
    public static final Object z;
    public static final Object A;
    public static final Object B;
    public static final Object C;
    public static final Object D;
    public static final Object E;
    Map F;
    
    public cm() {
        this(null);
    }
    
    public cm(final ch a) {
        this.F = new WeakHashMap();
        this.a = a;
        (this.b = new ActionMap()).put(cm.g, this.e());
        this.b.put(cm.f, this.d());
        this.b.put(cm.e, this.b());
        this.b.put(cm.c, this.c());
        this.b.put(cm.t, this.j());
        this.b.put(cm.s, this.i());
        this.b.put(cm.q, this.f());
        this.b.put(cm.r, this.g());
        this.b.put(cm.u, this.k());
        this.b.put(cm.B, this.u());
        this.b.put(cm.d, this.a());
        this.b.put(cm.h, this.h());
        this.b.put(cm.m, this.a(cm.m, false, (byte)(-1)));
        this.b.put(cm.n, this.a(cm.n, false, (byte)0));
        this.b.put(cm.o, this.a(cm.o, false, (byte)1));
        this.b.put(cm.p, this.a(cm.p, false, (byte)2));
        this.b.put(cm.i, this.a(cm.i, true, (byte)(-1)));
        this.b.put(cm.j, this.a(cm.j, true, (byte)0));
        this.b.put(cm.k, this.a(cm.k, true, (byte)1));
        this.b.put(cm.l, this.a(cm.l, true, (byte)2));
        this.b.put(cm.A, this.l());
        this.b.put(cm.z, this.m());
        this.b.put(cm.v, this.n());
        this.b.put(cm.w, this.o());
        this.b.put(cm.x, this.p());
        this.b.put(cm.y, this.q());
        this.b.put(cm.C, this.r());
        this.b.put(cm.D, this.s());
        this.b.put(cm.E, this.t());
    }
    
    Action a() {
        return new cn(this, cm.d.toString());
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return b(actionEvent, this.a);
    }
    
    private static ch b(final ActionEvent actionEvent, final ch ch) {
        if (actionEvent.getSource() instanceof bw) {
            return (ch)((bw)actionEvent.getSource()).getParent();
        }
        if (actionEvent.getSource() instanceof ch) {
            return (ch)actionEvent.getSource();
        }
        return ch;
    }
    
    Action b() {
        return new cs(this, cm.e.toString());
    }
    
    Action c() {
        return new ct(this, cm.c.toString());
    }
    
    Action d() {
        return new cu(this, cm.f.toString());
    }
    
    Action e() {
        return new cv(this, cm.g.toString());
    }
    
    Action f() {
        return new cw(this, cm.q.toString());
    }
    
    Action g() {
        return new cx(this, cm.r.toString());
    }
    
    Action h() {
        return new cK(this.a);
    }
    
    Action a(final Object o, final boolean b, final byte b2) {
        return new cy(this, o.toString(), b, b2);
    }
    
    Action i() {
        return new cz(this, cm.s.toString());
    }
    
    Action j() {
        return new co(this, cm.t.toString());
    }
    
    Action k() {
        return new cE(this.a);
    }
    
    Action l() {
        return new cD(this.a);
    }
    
    Action m() {
        return new cJ(this.a);
    }
    
    Action n() {
        return new cI(this.a);
    }
    
    Action o() {
        return new cH(this.a);
    }
    
    Action p() {
        return new cM(this.a);
    }
    
    Action q() {
        return new cL(this.a);
    }
    
    Action r() {
        return new cF(this.a);
    }
    
    Action s() {
        return new cC(this.a);
    }
    
    Action t() {
        return new cB(this.a);
    }
    
    private static fj b(final bu bu, final q q) {
        final fj t = bu.t(q);
        if (t instanceof gd) {
            return ((gd)t).e();
        }
        return t;
    }
    
    Action u() {
        return new cq(this);
    }
    
    public ActionMap v() {
        final boolean z = fj.z;
        final ActionMap actionMap = new ActionMap();
        final Object[] keys = this.b.keys();
        int i = 0;
        ActionMap actionMap2 = null;
        while (i < keys.length) {
            actionMap2 = actionMap;
            if (z) {
                return actionMap2;
            }
            actionMap2.put(keys[i], this.b.get(keys[i]));
            ++i;
            if (z) {
                break;
            }
        }
        return actionMap2;
    }
    
    public InputMap a(final ActionMap actionMap) {
        final boolean z = fj.z;
        final HashSet<Object> set = new HashSet<Object>();
        final Object[] keys = actionMap.keys();
        int i = 0;
        Label_0064: {
            if (keys != null) {
                i = 0;
                while (i < keys.length) {
                    set.add(keys[i]);
                    ++i;
                    if (z) {
                        break Label_0064;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            i = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        }
        final InputMap inputMap = new InputMap();
        if (set.contains(cm.e)) {
            inputMap.put(KeyStroke.getKeyStroke(37, 0), cm.e);
        }
        if (set.contains(cm.c)) {
            inputMap.put(KeyStroke.getKeyStroke(39, 0), cm.c);
        }
        if (set.contains(cm.g)) {
            inputMap.put(KeyStroke.getKeyStroke(40, 0), cm.g);
        }
        if (set.contains(cm.f)) {
            inputMap.put(KeyStroke.getKeyStroke(38, 0), cm.f);
        }
        final int n = 8;
        if (set.contains(cm.q)) {
            inputMap.put(KeyStroke.getKeyStroke(37, n), cm.q);
        }
        if (set.contains(cm.r)) {
            inputMap.put(KeyStroke.getKeyStroke(39, n), cm.r);
        }
        if (set.contains(cm.t)) {
            inputMap.put(KeyStroke.getKeyStroke(40, n), cm.t);
        }
        if (set.contains(cm.s)) {
            inputMap.put(KeyStroke.getKeyStroke(38, n), cm.s);
        }
        if (set.contains(cm.u)) {
            inputMap.put(KeyStroke.getKeyStroke(127, 0), cm.u);
        }
        if (set.contains(cm.h)) {
            inputMap.put(KeyStroke.getKeyStroke(65, i), cm.h);
        }
        if (set.contains(cm.B)) {
            inputMap.put(KeyStroke.getKeyStroke(113, 0), cm.B);
        }
        if (set.contains(cm.d)) {
            inputMap.put(KeyStroke.getKeyStroke(10, 0), cm.d);
        }
        final int n2 = 10;
        if (set.contains(cm.o)) {
            inputMap.put(KeyStroke.getKeyStroke(39, n2), cm.o);
        }
        if (set.contains(cm.m)) {
            inputMap.put(KeyStroke.getKeyStroke(37, n2), cm.m);
        }
        if (set.contains(cm.n)) {
            inputMap.put(KeyStroke.getKeyStroke(72, n2), cm.n);
        }
        if (set.contains(cm.j)) {
            inputMap.put(KeyStroke.getKeyStroke(86, n2), cm.j);
        }
        if (set.contains(cm.i)) {
            inputMap.put(KeyStroke.getKeyStroke(38, n2), cm.i);
        }
        if (set.contains(cm.k)) {
            inputMap.put(KeyStroke.getKeyStroke(40, n2), cm.k);
        }
        if (set.contains(cm.A)) {
            inputMap.put(KeyStroke.getKeyStroke(67, n2), cm.A);
        }
        if (set.contains(cm.z)) {
            inputMap.put(KeyStroke.getKeyStroke(79, n2), cm.z);
        }
        if (set.contains(cm.v)) {
            inputMap.put(KeyStroke.getKeyStroke(71, n2), cm.v);
        }
        if (set.contains(cm.w)) {
            inputMap.put(KeyStroke.getKeyStroke(70, n2), cm.w);
        }
        if (set.contains(cm.x)) {
            inputMap.put(KeyStroke.getKeyStroke(85, n2), cm.x);
        }
        if (set.contains(cm.y)) {
            inputMap.put(KeyStroke.getKeyStroke(77, n2), cm.y);
        }
        final int n3 = 3;
        if (set.contains(cm.l)) {
            inputMap.put(KeyStroke.getKeyStroke(86, n3), cm.l);
        }
        if (set.contains(cm.p)) {
            inputMap.put(KeyStroke.getKeyStroke(72, n3), cm.p);
        }
        return inputMap;
    }
    
    protected void a(final ch ch) {
        final boolean z = fj.z;
        final bu d = this.d(ch);
        if (d.I()) {
            final x j = d.J();
            if (j.f()) {
                final q e = j.e();
                aC ac = null;
                D d2 = null;
                final Iterator viewModes = ch.getViewModes();
                while (true) {
                    while (viewModes.hasNext()) {
                        final gX gx = viewModes.next();
                        if (gx instanceof D) {
                            d2 = (D)gx;
                        }
                        if (gx instanceof aC) {
                            ac = (aC)gx;
                            if (!z) {
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (ac != null && ac.isActive() && !ac.isEditing()) {
                                    ac.editNode(e, null);
                                }
                                return;
                            }
                        }
                    }
                    if (d2 == null || !d2.isActive() || d2.a()) {
                        continue;
                    }
                    if (d2.a(e)) {
                        d2.a(e, null);
                        if (z) {
                            continue;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    void a(final byte b, final ch ch) {
        final boolean z = fj.z;
        final bu d = this.d(ch);
        final q b2 = this.b(ch);
        x x = d.o();
        double n = 0.0;
        double n2 = 0.0;
        Label_0169: {
            if (b2 == null) {
                final d c = this.c(ch);
                if (c != null) {
                    n = 0.5 * (d.j(c.c()) + d.j(c.d()));
                    n2 = 0.5 * (d.k(c.c()) + d.k(c.d()));
                    final y y = new y(c.c());
                    y.add(c.d());
                    x = y.a();
                    if (!z) {
                        break Label_0169;
                    }
                }
                final Point2D center = ch.getCenter();
                n = center.getX();
                n2 = center.getY();
                if (!z) {
                    break Label_0169;
                }
            }
            n = d.j(b2);
            n2 = d.k(b2);
        }
        double n3 = Double.MAX_VALUE;
        q q = null;
        final x x2 = x;
        while (x2.f()) {
            final q e = x2.e();
            final double a = this.a(n, n2, d.j(e), d.k(e), b);
            if (z) {
                return;
            }
            if (a < n3 && e != b2) {
                n3 = a;
                q = e;
            }
            x2.g();
            if (z) {
                break;
            }
        }
        if (q != null) {
            d.N();
            d.a(q, true);
            ch.focusView(ch.getZoom(), new Point2D.Double(d.j(q), d.k(q)), false);
            d.T();
        }
    }
    
    void a(final ch ch, final boolean b, final byte b2) {
        final bu d = this.d(ch);
        final y y = new y(d.J());
        d.r();
        d.a(y.a());
        ae.a(d, y, null, b, b2);
        d.s();
        d.T();
    }
    
    void b(final byte b, final ch ch) {
        final boolean z = fj.z;
        final bu d = this.d(ch);
        double n = Double.MAX_VALUE;
        d d2 = null;
        final q b2 = this.b(ch);
        if (b2 != null) {
            this.F.put(ch, new WeakReference<q>(b2));
            final t l = d.l(b2);
            final e j = b2.j();
            while (j.f()) {
                final d a = j.a();
                if (z) {
                    return;
                }
                if (b2 == a.c()) {
                    final Point2D sourceIntersection = d.i(a).getSourceIntersection();
                    if (sourceIntersection != null) {
                        final double a2 = this.a(l.a, l.b, sourceIntersection.getX(), sourceIntersection.getY(), b);
                        if (a2 < n) {
                            n = a2;
                            d2 = a;
                        }
                    }
                }
                if (b2 == a.d()) {
                    final Point2D targetIntersection = d.i(a).getTargetIntersection();
                    if (targetIntersection != null) {
                        final double a3 = this.a(l.a, l.b, targetIntersection.getX(), targetIntersection.getY(), b);
                        if (a3 < n) {
                            n = a3;
                            d2 = a;
                        }
                    }
                }
                j.g();
            }
        }
        else {
            final d c = this.c(ch);
            if (c != null) {
                q c2 = c.c();
                final WeakReference<Object> weakReference = this.F.get(ch);
                final q q = (weakReference != null) ? weakReference.get() : null;
                Label_0348: {
                    if (q != null) {
                        if (q == c.c() || q == c.d()) {
                            c2 = q;
                            if (!z) {
                                break Label_0348;
                            }
                        }
                        this.F.put(ch, new WeakReference<q>(b2));
                    }
                }
                final q q2 = c2;
                final t i = d.l(q2);
                final HashMap<Object, d> hashMap = new HashMap<Object, d>();
                final y.c.D d3 = new y.c.D();
                final e k = q2.j();
                while (k.f()) {
                    final d a4 = k.a();
                    final GeneralPath path = d.i(a4).getPath();
                    if (a4.c() == q2 && !hashMap.containsValue(a4)) {
                        hashMap.put(path, a4);
                        d3.add(path);
                    }
                    if (a4.d() == q2 && !a4.e()) {
                        final GeneralPath a5 = ij.a(path);
                        hashMap.put(a5, a4);
                        d3.add(a5);
                    }
                    k.g();
                    if (z) {
                        break;
                    }
                }
                d3.sort(new cr(this, new AffineTransform(), new double[6], new double[6], i));
                final C m = d3.m();
                while (m.f()) {
                    if (hashMap.get(m.d()) == c) {
                        Label_0662: {
                            if (b == 1 || b == 3) {
                                m.g();
                                if (m.f()) {
                                    break Label_0662;
                                }
                                m.i();
                                if (!z) {
                                    break Label_0662;
                                }
                            }
                            m.h();
                            if (!m.f()) {
                                m.j();
                            }
                        }
                        final d d4 = hashMap.get(m.d());
                        if (c != d4) {
                            d2 = d4;
                            break;
                        }
                        break;
                    }
                    else {
                        m.g();
                    }
                }
            }
        }
        if (d2 != null) {
            d.N();
            d.a(d2, true);
            ch.updateView();
        }
    }
    
    private double a(final double n, final double n2, final double n3, final double n4) {
        return Math.atan2(n4 - n2, n3 - n);
    }
    
    double a(final double n, final double n2, final double n3, final double n4, final byte b) {
        final boolean z = fj.z;
        final double n5 = n3 - n;
        final double n6 = n4 - n2;
        double n7 = 0.0;
        double n8 = 0.0;
        Label_0093: {
            switch (b) {
                case 0: {
                    n7 = -1.0;
                    n8 = 0.0;
                    if (z) {
                        break Label_0093;
                    }
                    break;
                }
                case 1: {
                    n7 = 1.0;
                    n8 = 0.0;
                    if (z) {
                        break Label_0093;
                    }
                    break;
                }
                case 2: {
                    n7 = 0.0;
                    n8 = -1.0;
                    if (z) {
                        break Label_0093;
                    }
                    break;
                }
                case 3: {
                    n7 = 0.0;
                    n8 = 1.0;
                    break;
                }
            }
        }
        final double a = y.d.t.a(n, n2, n3, n4);
        if (a == 0.0) {
            return a;
        }
        final double acos = Math.acos((n7 * n5 + n8 * n6) / a);
        if (acos >= 1.5707963267948966) {
            return Double.MAX_VALUE;
        }
        return y.d.t.a(n, n2, n3, n4) * (1.0 + Math.pow(2.0 * acos / 3.141592653589793, 8.0));
    }
    
    q b(final ch ch) {
        final boolean z = fj.z;
        final bu d = this.d(ch);
        final x o = d.o();
        while (o.f()) {
            final q e = o.e();
            if (d.v(e)) {
                return e;
            }
            o.g();
            if (z) {
                break;
            }
        }
        return null;
    }
    
    d c(final ch ch) {
        final boolean z = fj.z;
        final bu d = this.d(ch);
        final e p = d.p();
        while (p.f()) {
            final d a = p.a();
            if (d.r(a)) {
                return a;
            }
            p.g();
            if (z) {
                break;
            }
        }
        return null;
    }
    
    bu d(final ch ch) {
        return ch.getGraph2D();
    }
    
    static ch a(final ActionEvent actionEvent, final ch ch) {
        return b(actionEvent, ch);
    }
    
    static fj a(final bu bu, final q q) {
        return b(bu, q);
    }
    
    static double a(final cm cm, final double n, final double n2, final double n3, final double n4) {
        return cm.a(n, n2, n3, n4);
    }
    
    static {
        c = "FOCUS_RIGHT_NODE";
        d = "EDIT_NODE";
        e = "FOCUS_LEFT_NODE";
        f = "FOCUS_TOP_NODE";
        g = "FOCUS_BOTTOM_NODE";
        h = "SELECT_ALL";
        i = "TOP_ALIGN";
        j = "ALIGN_VERTICALLY";
        k = "BOTTOM_ALIGN";
        l = "DISTRIBUTE_VERTICALLY";
        m = "LEFT_ALIGN";
        n = "ALIGN_HORIZONTALLY";
        o = "RIGHT_ALIGN";
        p = "DISTRIBUTE_HORIZONTALLY";
        q = "SELECT_LEFT_EDGE";
        r = "SELECT_RIGHT_EDGE";
        s = "SELECT_TOP_EDGE";
        t = "SELECT_BOTTOM_EDGE";
        u = "DELETE_SELECTION";
        v = "GROUP_SELECTION";
        w = "FOLD_SELECTION";
        x = "UNGROUP_SELECTION";
        y = "UNFOLD_SELECTION";
        z = "OPEN_FOLDERS";
        A = "CLOSE_GROUPS";
        B = "EDIT_LABEL";
        C = "DUPLICATE_GRAPH";
        D = "ADD_SUCCESSORS";
        E = "ADD_PREDECESSORS";
    }
}
