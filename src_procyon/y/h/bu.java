package y.h;

import y.h.a.*;
import y.g.*;
import java.awt.*;
import java.awt.geom.*;
import y.f.*;
import java.util.*;
import y.c.*;

public class bu extends X
{
    private fj a;
    private aB b;
    private D h;
    private D i;
    private gI k;
    private v l;
    private bv m;
    private ArrayList n;
    private ArrayList o;
    
    protected C b() {
        return new bE();
    }
    
    public bu() {
        this.a(new gn(), new fJ());
    }
    
    public bu(final bu bu) {
        this(bu, bu.o());
    }
    
    public bu(final bu bu, final y.c.C c) {
        super(bu, c);
        this.a(bu.a.createCopy(), bu.b.createCopy());
    }
    
    private void a(final fj a, final aB b) {
        this.a = a;
        this.b = b;
        this.h = new D();
        this.i = new D();
        this.n = new ArrayList();
        this.o = new ArrayList();
    }
    
    public void a(final d d, final q q, final d d2, final int n, final q q2, final d d3, final int n2) {
        super.a(d, q, d2, n, q2, d3, n2);
        final aB i = this.i(d);
        if (i != null) {
            i.setDirty();
        }
    }
    
    public void a(final d d, final q q, final q q2) {
        super.a(d, q, q2);
        final aB i = this.i(d);
        if (i != null) {
            i.setDirty();
        }
    }
    
    public void a(final v l) {
        this.l = l;
    }
    
    public v C() {
        return this.l;
    }
    
    public d a(final q q, final q q2) {
        return this.a(q, q2, this.b.createCopy());
    }
    
    public d a(final q q, final q q2, final aB ab) {
        return this.a(q, null, q2, null, 0, 0, ab);
    }
    
    public d a(final q q, final d d, final q q2, final d d2, final int n, final int n2) {
        return this.a(q, d, q2, d2, n, n2, this.b.createCopy());
    }
    
    public d a(final q q, final d d, final q q2, final d d2, final int n, final int n2, final aB ab) {
        final hH hh = new hH(this, q, d, q2, d2, n, n2, ab);
        if (this.c()) {
            this.a(new l(this, (byte)1, hh));
        }
        return hh;
    }
    
    public q d() {
        return this.a(this.a.createCopy());
    }
    
    public q a(final double n, final double n2) {
        final fj copy = this.a.createCopy();
        copy.setCenter(n, n2);
        return this.a(copy);
    }
    
    public q a(final fj fj) {
        final ii ii = new ii(this, fj);
        if (this.c()) {
            this.a(new l(this, (byte)0, ii));
        }
        return ii;
    }
    
    public Rectangle a() {
        final boolean z = fj.z;
        final Rectangle rectangle = new Rectangle(0, 0, -1, -1);
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final bu bu = this;
                if (z) {
                    final e p = bu.p();
                    while (p.f()) {
                        this.i(p.a()).calcUnionRect(rectangle);
                        p.g();
                        if (z) {
                            break;
                        }
                    }
                    return rectangle;
                }
                this.t(o.e()).calcUnionRect(rectangle);
                o.g();
                if (z) {
                    break;
                }
            }
            final bu bu = this;
            continue;
        }
    }
    
    public Rectangle a(final byte b) {
        final boolean z = fj.z;
        final Rectangle rectangle = new Rectangle(0, 0, -1, -1);
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final bu bu = this;
                if (z) {
                    final e p = bu.p();
                    while (p.f()) {
                        final aB i = this.i(p.a());
                        if (i.getLayer() == b) {
                            i.calcUnionRect(rectangle);
                        }
                        p.g();
                        if (z) {
                            break;
                        }
                    }
                    return rectangle;
                }
                this.t(o.e()).calcUnionRect(rectangle, b);
                o.g();
                if (z) {
                    break;
                }
            }
            final bu bu = this;
            continue;
        }
    }
    
    public void b(final byte b) {
        final boolean z = fj.z;
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final bu bu = this;
                if (z) {
                    final e p = bu.p();
                    while (p.f()) {
                        this.i(p.a()).setLayer(b);
                        p.g();
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                this.t(o.e()).setLayer(b);
                o.g();
                if (z) {
                    break;
                }
            }
            final bu bu = this;
            continue;
        }
    }
    
    public y D() {
        return new ie(this);
    }
    
    public void b(final fj a) {
        this.a = a;
    }
    
    public void a(final aB b) {
        this.b = b;
    }
    
    public fj F() {
        return this.a;
    }
    
    public aB G() {
        return this.b;
    }
    
    public fj t(final q q) {
        return ((ii)q).l;
    }
    
    public aB i(final d d) {
        return ((hH)d).l;
    }
    
    public void a(final q q, final fj l) {
        final fj i = ((ii)q).l;
        l.b(q);
        this.a(q, "realizer", i, ((ii)q).l = l);
    }
    
    public void a(final d d, final aB l) {
        final aB i = ((hH)d).l;
        l.bindEdge(d);
        this.a(d, "realizer", i, ((hH)d).l = l);
    }
    
    public am h(final q q) {
        return this.t(q);
    }
    
    public I g(final d d) {
        return this.i(d);
    }
    
    public aj[] i(final q q) {
        final boolean z = fj.z;
        final fj t = this.t(q);
        final aj[] array = new aj[t.labelCount()];
        int i = 0;
        aj[] array2 = null;
        while (i < array.length) {
            array2 = array;
            if (z) {
                return array2;
            }
            array2[i] = t.getLabel(i);
            ++i;
            if (z) {
                break;
            }
        }
        return array2;
    }
    
    public y.f.C[] h(final d d) {
        final boolean z = fj.z;
        final aB i = this.i(d);
        final y.f.C[] array = new y.f.C[i.labelCount()];
        int j = 0;
        y.f.C[] array2 = null;
        while (j < array.length) {
            array2 = array;
            if (z) {
                return array2;
            }
            array2[j] = i.getLabel(j);
            ++j;
            if (z) {
                break;
            }
        }
        return array2;
    }
    
    public q a(final aj aj) {
        return ((eR)aj).f();
    }
    
    public d a(final y.f.C c) {
        return ((aA)c).getEdge();
    }
    
    public boolean H() {
        final boolean z = fj.z;
        final x o = this.o();
        while (true) {
            do {
                Label_0010: {
                    o.f();
                }
                boolean b = false;
                Label_0016:
                while (b) {
                    final q e = o.e();
                    final bu bu = this;
                    if (z) {
                        final e p = bu.p();
                        boolean r = false;
                        do {
                            Label_0161:
                            p.f();
                            boolean a = false;
                            Label_0167:
                            while (a) {
                                final d a2 = p.a();
                                r = this.r(a2);
                                if (z) {
                                    return r;
                                }
                                if (r) {
                                    return false;
                                }
                                final aB i = this.i(a2);
                                int a3 = 0;
                                Label_0258: {
                                    if (i.bendCount() > 0) {
                                        final y bends = i.bends();
                                        while (bends.f()) {
                                            a3 = (this.a(bends.a()) ? 1 : 0);
                                            if (z) {
                                                break Label_0258;
                                            }
                                            if (a3 != 0) {
                                                return false;
                                            }
                                            bends.g();
                                            if (z) {
                                                break;
                                            }
                                        }
                                    }
                                    i.labelCount();
                                }
                                if (a3 > 0) {
                                    int j = 0;
                                    while (j < i.labelCount()) {
                                        a = this.a((gZ)i.getLabel(j));
                                        if (z) {
                                            continue Label_0167;
                                        }
                                        if (a) {
                                            return false;
                                        }
                                        ++j;
                                        if (z) {
                                            break;
                                        }
                                    }
                                }
                                p.g();
                                continue Label_0161;
                            }
                            break;
                        } while (!z);
                        return r;
                    }
                    if (this.v(e)) {
                        return false;
                    }
                    final fj t = this.t(e);
                    int a4 = 0;
                    Label_0102: {
                        if (t.labelCount() > 0) {
                            int k = 0;
                            while (k < t.labelCount()) {
                                a4 = (this.a((gZ)t.getLabel(k)) ? 1 : 0);
                                if (z) {
                                    break Label_0102;
                                }
                                if (a4 != 0) {
                                    return false;
                                }
                                ++k;
                                if (z) {
                                    break;
                                }
                            }
                        }
                        t.portCount();
                    }
                    if (a4 > 0) {
                        final Iterator ports = t.ports();
                        while (ports.hasNext()) {
                            if (this.a(ports.next())) {
                                b = false;
                                if (!z) {
                                    return b;
                                }
                                continue Label_0016;
                            }
                        }
                    }
                    o.g();
                    continue Label_0010;
                }
                break;
            } while (!z);
            final bu bu = this;
            continue;
        }
    }
    
    public boolean I() {
        return this.J().k() + this.M().k() == 1;
    }
    
    public x J() {
        final boolean z = fj.z;
        final y.c.y y = new y.c.y();
        final x o = this.o();
        x x = null;
        while (o.f()) {
            x = o;
            if (z) {
                return x;
            }
            final q e = x.e();
            if (this.v(e)) {
                y.b(e);
            }
            o.g();
            if (z) {
                break;
            }
        }
        y.a();
        return x;
    }
    
    public e K() {
        final boolean z = fj.z;
        final f f = new f();
        final e p = this.p();
        e e = null;
        while (p.f()) {
            e = p;
            if (z) {
                return e;
            }
            final d a = e.a();
            if (this.r(a)) {
                f.b(a);
            }
            p.g();
            if (z) {
                break;
            }
        }
        f.a();
        return e;
    }
    
    public y.c.C L() {
        final boolean z = fj.z;
        final D d = new D();
        final e p = this.p();
        while (true) {
            do {
                Label_0018: {
                    p.f();
                }
                boolean a = false;
                Label_0024:
                while (a) {
                    final bu bu = this;
                    if (!z) {
                        final aB i = this.i(p.a());
                        if (i.labelCount() > 0) {
                            int j = 0;
                            while (j < i.labelCount()) {
                                final aA label = i.getLabel(j);
                                a = this.a((gZ)label);
                                if (z) {
                                    continue Label_0024;
                                }
                                if (a) {
                                    d.add(label);
                                }
                                ++j;
                                if (z) {
                                    break;
                                }
                            }
                        }
                        p.g();
                        continue Label_0018;
                    }
                    final x o = bu.o();
                    do {
                        Label_0115:
                        o.f();
                        boolean a2 = false;
                        Label_0121:
                        while (a2) {
                            final fj t = this.t(o.e());
                            if (t.labelCount() > 0) {
                                int k = 0;
                                while (k < t.labelCount()) {
                                    final eR label2 = t.getLabel(k);
                                    a2 = this.a((gZ)label2);
                                    if (z) {
                                        continue Label_0121;
                                    }
                                    if (a2) {
                                        d.add(label2);
                                    }
                                    ++k;
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            o.g();
                            continue Label_0115;
                        }
                        break;
                    } while (!z);
                    return d.m();
                }
                break;
            } while (!z);
            final bu bu = this;
            continue;
        }
    }
    
    public y M() {
        final boolean z = fj.z;
        final z z2 = new z();
        final y d = this.D();
        y y = null;
        while (d.f()) {
            y = d;
            if (z) {
                return y;
            }
            final y.h.x a = y.a();
            if (this.a(a)) {
                z2.b(a);
            }
            d.g();
            if (z) {
                break;
            }
        }
        z2.b();
        return y;
    }
    
    public void N() {
        final boolean z = fj.z;
        this.r();
        final x o = this.o();
        while (true) {
            while (o.f()) {
                final q e = o.e();
                this.a(e, false);
                final bu bu = this;
                if (z) {
                    final e p = bu.p();
                Label_0281_Outer:
                    while (p.f()) {
                        final d a = p.a();
                        this.a(a, false);
                        final aB i = this.i(a);
                        if (!z) {
                            if (i.labelCount() > 0) {
                                int j = 0;
                                while (j < i.labelCount()) {
                                    this.a(i.getLabel(j), false);
                                    ++j;
                                    if (z) {
                                        continue Label_0281_Outer;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            final y bends = i.bends();
                            while (true) {
                                while (bends.f()) {
                                    this.a(bends.a(), false);
                                    bends.g();
                                    if (!z) {
                                        if (z) {
                                            break;
                                        }
                                        continue Label_0281_Outer;
                                    }
                                    else {
                                        if (z) {
                                            break Label_0281_Outer;
                                        }
                                        continue Label_0281_Outer;
                                    }
                                }
                                p.g();
                                continue;
                            }
                        }
                        return;
                    }
                    this.s();
                    return;
                }
                final fj t = this.t(e);
                Label_0144: {
                    if (t.labelCount() > 0) {
                        int k = 0;
                        while (k < t.labelCount()) {
                            this.a(t.getLabel(k), false);
                            ++k;
                            if (z) {
                                break Label_0144;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    if (t.portCount() > 0) {
                        final Iterator ports = t.ports();
                        while (ports.hasNext()) {
                            this.a(ports.next(), false);
                            if (z) {
                                break Label_0144;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    o.g();
                }
                if (z) {
                    break;
                }
            }
            final bu bu = this;
            continue;
        }
    }
    
    public void O() {
        final boolean z = fj.z;
        this.r();
        final x o = this.o();
        while (o.f()) {
            this.a(o.e(), false);
            o.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.s();
    }
    
    public void P() {
        final boolean z = fj.z;
        this.r();
        final e p = this.p();
        while (p.f()) {
            this.a(p.a(), false);
            p.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.s();
    }
    
    public void Q() {
        final boolean z = fj.z;
        this.r();
        final y d = this.D();
        while (d.f()) {
            this.a(d.a(), false);
            d.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.s();
    }
    
    public cW a(final double n, final double n2, final boolean b) {
        return new cW(this, n, n2, b, 0, 1, 2, 3, 4, 6, 5);
    }
    
    public cW b(final double n, final double n2) {
        return this.a(n, n2, true);
    }
    
    public void a(final q q, final String labelText) {
        this.t(q).setLabelText(labelText);
    }
    
    public String u(final q q) {
        return this.t(q).getLabelText();
    }
    
    public void a(final d d, final boolean selected) {
        this.i(d).setSelected(selected);
    }
    
    public void a(final gZ gz, final boolean selected) {
        gz.setSelected(selected);
    }
    
    public void a(final y.h.x x, final boolean b) {
        x.a(b);
    }
    
    public void a(final eU eu, final boolean b) {
        eu.a(b);
    }
    
    public void a(final e e, final boolean b) {
        final boolean z = fj.z;
        if (!e.f()) {
            return;
        }
        this.r();
        while (e.f()) {
            this.a(e.a(), b);
            e.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.s();
    }
    
    public void a(final q q, final boolean selected) {
        this.t(q).setSelected(selected);
    }
    
    public void a(final x x, final boolean b) {
        final boolean z = fj.z;
        if (!x.f()) {
            return;
        }
        this.r();
        while (x.f()) {
            this.a(x.e(), b);
            x.g();
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.s();
    }
    
    public boolean r(final d d) {
        return this.i(d).isSelected();
    }
    
    public boolean a(final gZ gz) {
        return gz.isSelected();
    }
    
    public boolean a(final y.h.x x) {
        return x.d();
    }
    
    public boolean a(final eU eu) {
        return eu.f();
    }
    
    public boolean v(final q q) {
        return this.t(q).isSelected();
    }
    
    public double j(final q q) {
        return this.t(q).getCenterX();
    }
    
    public double k(final q q) {
        return this.t(q).getCenterY();
    }
    
    public double m(final q q) {
        return this.t(q).getX();
    }
    
    public double n(final q q) {
        return this.t(q).getY();
    }
    
    public double p(final q q) {
        return this.t(q).getWidth();
    }
    
    public double q(final q q) {
        return this.t(q).getHeight();
    }
    
    public void a(final q q, final double n, final double n2) {
        this.t(q).setCenter(n, n2);
    }
    
    public void b(final q q, final double n, final double n2) {
        this.t(q).setSize(n, n2);
    }
    
    public void c(final q q, final double n, final double n2) {
        this.t(q).setLocation(n, n2);
    }
    
    public y.c.C R() {
        return this.i.m();
    }
    
    public gI S() {
        if (this.k != null) {
            return this.k;
        }
        if (this.h.size() > 0) {
            return (gI)this.h.f();
        }
        return null;
    }
    
    public void a(final gI k) {
        this.k = k;
    }
    
    public void b(final gI gi) {
        this.h.b(gi);
    }
    
    public void c(final gI gi) {
        if (this.S() == gi) {
            this.a((gI)null);
        }
        this.h.remove(gi);
    }
    
    public void T() {
        final boolean z = fj.z;
        final y.c.C m = this.h.m();
        while (m.f()) {
            ((gI)m.d()).updateView();
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    public void a(final double n, final double n2, final double n3, final double n4) {
        final boolean z = fj.z;
        final y.c.C m = this.h.m();
        while (m.f()) {
            ((gI)m.d()).updateView(n, n2, n3, n4);
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    public void U() {
        if (!(this.S() instanceof ch)) {
            return;
        }
        ((ch)this.S()).fitContent();
    }
    
    public void V() {
        this.r();
        this.a(this.o());
        this.a(this.p());
        this.s();
    }
    
    public void a(final e e) {
        if (this.m != null) {
            this.m.a(this, e);
        }
    }
    
    public void a(final x x) {
        if (this.m != null) {
            this.m.a(this, x);
        }
    }
    
    public void a(final cf cf) {
        this.n.add(cf);
    }
    
    public Iterator W() {
        return this.n.iterator();
    }
    
    public void e(final Object o) {
        final boolean z = fj.z;
        if (!this.n.isEmpty()) {
            final ce ce = new ce(this, o);
            final cf[] array = new cf[this.n.size()];
            this.n.toArray(array);
            int i = 0;
            while (i < array.length) {
                array[i].onGraph2DSelectionEvent(ce);
                ++i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    public void a(final bU bu) {
        this.o.add(bu);
    }
    
    public Iterator X() {
        return this.o.iterator();
    }
    
    public void a(final Object o, final String s, final Object o2, final Object o3) {
        if (!this.o.isEmpty()) {
            final bH bh = new bH(this, o, s, o2, o3);
            final bU[] array = new bU[this.o.size()];
            this.o.toArray(array);
            for (int i = 0; i < array.length; ++i) {
                array[i].a(bh);
            }
        }
    }
}
