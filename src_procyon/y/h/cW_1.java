package y.h;

import y.h.a.*;
import y.g.*;
import y.c.*;
import java.util.*;

public class cW
{
    int[] a;
    private D b;
    private D c;
    private D d;
    private D e;
    private D f;
    private D g;
    private D h;
    private D i;
    
    public cW(final bu bu, final double n, final double n2, final boolean b, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        this.a(n3, n4, n5, n6, n7, n8, n9);
        this.a(bu, n, n2, b, true, true, true, true);
    }
    
    public cW(final ch ch, final double n, final double n2, final boolean b, final int n3) {
        this(ch, n, n2, b, n3, -1, -1, -1, -1, -1, -1);
    }
    
    public cW(final ch ch, final double n, final double n2, final boolean b, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        final boolean z = fj.z;
        this.a(n3, n4, n5, n6, n7, n8, n9);
        if (this.a.length == 0) {
            return;
        }
        final boolean b2 = !Boolean.TRUE.equals(ch.getClientProperty("Graph2DView.hitTestInvisibleElements"));
        final bu graph2D = ch.getGraph2D();
        final cd graph2DRenderer = ch.getGraph2DRenderer();
        Label_0333: {
            if (graph2DRenderer instanceof ft) {
                cg cg = null;
                Label_0119: {
                    if (ch.getZoom() >= ch.getPaintDetailThreshold()) {
                        cg = ((ft)graph2DRenderer).getPaintOrder();
                        if (!z) {
                            break Label_0119;
                        }
                    }
                    cg = ((ft)graph2DRenderer).getSloppyPaintOrder();
                }
                int n10 = 0;
                int i = 0;
                while (true) {
                    while (i < this.a.length) {
                        final int n11 = this.a[i];
                        if (!z) {
                            Label_0241: {
                                switch (n11) {
                                    case 0: {
                                        n10 |= 0x4;
                                        if (z) {
                                            break Label_0241;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n10 |= 0x8;
                                        if (z) {
                                            break Label_0241;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        n10 |= 0x20;
                                        if (z) {
                                            break Label_0241;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        n10 |= 0x2;
                                        if (z) {
                                            break Label_0241;
                                        }
                                        break;
                                    }
                                    case 4: {
                                        n10 |= 0x1;
                                        if (z) {
                                            break Label_0241;
                                        }
                                        break;
                                    }
                                    case 5: {
                                        n10 |= 0x10;
                                        break;
                                    }
                                }
                            }
                            ++i;
                            if (z) {
                                break;
                            }
                            continue;
                        }
                        else {
                            final int n12 = (n11 != 0) ? 1 : -1;
                            this.a(graph2D, new A(cg.b(graph2D, n10), new gY(graph2D, n12, n12, n12, n12)), n, n2, b, this.a.length == 1);
                            if (z) {
                                break Label_0333;
                            }
                            return;
                        }
                    }
                    continue;
                }
            }
        }
        this.a(graph2D, n, n2, b, b2, b2, b2, b2);
    }
    
    public cW(final ch ch, final double n, final double n2, final boolean b) {
        this.a(-1, -1, -1, -1, -1, -1, -1);
        final bu graph2D = ch.getGraph2D();
        final cd graph2DRenderer = ch.getGraph2DRenderer();
        if (graph2DRenderer instanceof ft) {
            cg cg = null;
            Label_0077: {
                if (ch.getZoom() >= ch.getPaintDetailThreshold()) {
                    cg = ((ft)graph2DRenderer).getPaintOrder();
                    if (!fj.z) {
                        break Label_0077;
                    }
                }
                cg = ((ft)graph2DRenderer).getSloppyPaintOrder();
            }
            final int n3 = Boolean.TRUE.equals(ch.getClientProperty("Graph2DView.hitTestInvisibleElements")) ? -1 : 1;
            this.a(graph2D, new A(cg.b(graph2D, -1), new gY(graph2D, n3, n3, n3, n3)), n, n2, b, true);
        }
    }
    
    public cW(final bu bu, final Iterator iterator, final double n, final double n2, final boolean b) {
        this.a(-1, -1, -1, -1, -1, -1, -1);
        this.a(bu, iterator, n, n2, b, true);
    }
    
    protected cW() {
        this.a(-1, -1, -1, -1, -1, -1, -1);
    }
    
    protected void a(final x x) {
        this.d.add(x);
        this.i.add(x);
    }
    
    protected void a(final d d) {
        this.b.add(d);
        this.i.add(d);
    }
    
    protected void a(final aA aa) {
        this.e.add(aa);
        this.i.add(aa);
    }
    
    protected void a(final q q) {
        this.c.add(q);
        this.i.add(q);
    }
    
    protected void a(final eR er) {
        this.f.add(er);
        this.i.add(er);
    }
    
    protected void a(final fL fl) {
        this.g.add(fl);
        this.i.add(fl);
    }
    
    protected void a(final eU eu) {
        this.h.add(eu);
        this.i.add(eu);
    }
    
    protected boolean a(final fj fj, final double n, final double n2) {
        return fj.contains(n, n2);
    }
    
    protected boolean a(final eR er, final double n, final double n2) {
        return er.contains(n, n2);
    }
    
    protected boolean a(final aB ab, final double n, final double n2) {
        return ab.contains(n, n2);
    }
    
    protected boolean a(final aA aa, final double n, final double n2) {
        return aa.contains(n, n2);
    }
    
    protected boolean a(final x x, final double n, final double n2) {
        return x.c(n, n2);
    }
    
    protected boolean a(final fL fl, final double n, final double n2) {
        return fl.a(n, n2);
    }
    
    protected boolean a(final eU eu, final double n, final double n2) {
        return eu.a(n, n2);
    }
    
    private void a(final bu bu, final double n, final double n2, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5) {
        final boolean z = fj.z;
        int n3 = 0;
        do {
            int i = 0;
        Label_0010:
            while (i < this.a.length) {
                Label_0536: {
                    switch (this.a[n3]) {
                        case 0: {
                            final e p8 = bu.p();
                            p8.j();
                            while (p8.f()) {
                                final aB j = bu.i(p8.a());
                                if (z) {
                                    continue Label_0010;
                                }
                                if (!b4 || j.isVisible()) {
                                    if (this.a(j.getSourcePort(), n, n2)) {
                                        this.a(j.getSourcePort());
                                        if (b) {
                                            return;
                                        }
                                    }
                                    if (this.a(j.getTargetPort(), n, n2)) {
                                        this.a(j.getTargetPort());
                                        if (b) {
                                            return;
                                        }
                                    }
                                }
                                p8.h();
                                if (z) {
                                    break Label_0536;
                                }
                            }
                            break;
                        }
                        case 1: {
                            final y d = bu.D();
                            d.j();
                            while (d.f()) {
                                final x a = d.a();
                                if (z) {
                                    continue Label_0010;
                                }
                                if (!b4 || bu.i(a.a()).isVisible()) {
                                    if (this.a(a, n, n2)) {
                                        this.a(a);
                                        if (b) {
                                            return;
                                        }
                                    }
                                }
                                d.h();
                                if (z) {
                                    break Label_0536;
                                }
                            }
                            break;
                        }
                        case 2: {
                            final e p9 = bu.p();
                            p9.j();
                            do {
                                boolean f = false;
                                Label_0306: {
                                    f = p9.f();
                                }
                                Label_0313:
                                while (f) {
                                    final aB k = bu.i(p9.a());
                                    if (!z) {
                                        if (!b5 || k.isVisible()) {
                                            int l = k.labelCount() - 1;
                                            while (l >= 0) {
                                                final aA label = k.getLabel(l);
                                                f = b5;
                                                if (z) {
                                                    continue Label_0313;
                                                }
                                                if (!b5 || label.isVisible()) {
                                                    if (this.a(label, n, n2)) {
                                                        this.a(label);
                                                        if (b) {
                                                            return;
                                                        }
                                                    }
                                                }
                                                --l;
                                                if (z) {
                                                    break;
                                                }
                                            }
                                        }
                                        p9.h();
                                        continue Label_0306;
                                    }
                                    continue Label_0010;
                                }
                                break Label_0536;
                            } while (!z);
                        }
                        case 3: {
                            final e p10 = bu.p();
                            p10.j();
                            while (p10.f()) {
                                final aB m = bu.i(p10.a());
                                if (z) {
                                    continue Label_0010;
                                }
                                if (!b4 || m.isVisible()) {
                                    if (this.a(m, n, n2)) {
                                        this.a(p10.a());
                                        if (b) {
                                            return;
                                        }
                                    }
                                }
                                p10.h();
                                if (z) {
                                    break Label_0536;
                                }
                            }
                            break;
                        }
                        case 4: {
                            final v a2 = v.a(bu);
                            final Iterator iterator = (a2 != null) ? a2.i(a2.e(bu)) : l.b(bu.o());
                            while (iterator.hasNext()) {
                                final q q = iterator.next();
                                final fj t = bu.t(q);
                                if (b2 && !t.isVisible()) {
                                    continue;
                                }
                                if (!this.a(t, n, n2)) {
                                    continue;
                                }
                                this.a(q);
                                if (z) {
                                    continue Label_0010;
                                }
                                if (b) {
                                    return;
                                }
                            }
                            break;
                        }
                        case 5: {
                            final y.c.x o = bu.o();
                            o.j();
                            do {
                                boolean f2 = false;
                                Label_0658: {
                                    f2 = o.f();
                                }
                                Label_0665:
                                while (f2) {
                                    final fj t2 = bu.t(o.e());
                                    if (!z) {
                                        if (!b3 || t2.isVisible()) {
                                            int n4 = t2.labelCount() - 1;
                                            while (n4 >= 0) {
                                                final eR label2 = t2.getLabel(n4);
                                                f2 = b3;
                                                if (z) {
                                                    continue Label_0665;
                                                }
                                                if (!b3 || label2.isVisible()) {
                                                    if (this.a(label2, n, n2)) {
                                                        this.a(label2);
                                                        if (b) {
                                                            return;
                                                        }
                                                    }
                                                }
                                                --n4;
                                                if (z) {
                                                    break;
                                                }
                                            }
                                        }
                                        o.h();
                                        continue Label_0658;
                                    }
                                    continue Label_0010;
                                }
                                break;
                            } while (!z);
                        }
                        case 6: {
                            final y.c.x o2 = bu.o();
                            o2.j();
                            do {
                                Label_0803: {
                                    o2.f();
                                }
                                boolean a3 = false;
                                Label_0810:
                                while (a3) {
                                    final fj t3 = bu.t(o2.e());
                                    i = t3.portCount() - 1;
                                    if (!z) {
                                        int n5 = i;
                                        while (n5 >= 0) {
                                            final eU port = t3.getPort(n5);
                                            a3 = this.a(port, n, n2);
                                            if (z) {
                                                continue Label_0810;
                                            }
                                            if (a3) {
                                                this.a(port);
                                                if (b) {
                                                    return;
                                                }
                                            }
                                            --n5;
                                            if (z) {
                                                break;
                                            }
                                        }
                                        o2.h();
                                        continue Label_0803;
                                    }
                                    continue Label_0010;
                                }
                                break;
                            } while (!z);
                            break;
                        }
                    }
                }
                ++n3;
            }
            break;
        } while (!z);
    }
    
    private void a(final bu bu, final Iterator iterator, final double n, final double n2, final boolean b, final boolean b2) {
        final boolean z = fj.z;
        Label_0042: {
            if (!b) {
                while (iterator.hasNext()) {
                    this.a(bu, iterator.next(), n, n2);
                    if (z) {
                        break Label_0042;
                    }
                }
                return;
            }
        }
        Label_1163: {
            if (!b2) {
                int n3 = 0;
                final int[] array = new int[this.a.length];
                int i = 0;
                while (true) {
                    while (i < this.a.length) {
                        final int n4 = this.a[i];
                        if (z) {
                            final Object[] array2 = new Object[n4];
                            while (iterator.hasNext()) {
                                final d next = iterator.next();
                                if ((n3 & 0x2) != 0x0 && array2[array[3]] == null && next instanceof d) {
                                    if (!this.a(bu.i(next), n, n2)) {
                                        continue;
                                    }
                                    array2[array[3]] = next;
                                    if (array[3] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else if ((n3 & 0x1) != 0x0 && array2[array[4]] == null && next instanceof q) {
                                    if (!this.a(bu.t((q)next), n, n2)) {
                                        continue;
                                    }
                                    array2[array[4]] = next;
                                    if (array[4] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else if ((n3 & 0x4) != 0x0 && array2[array[0]] == null && next instanceof fL) {
                                    if (!this.a((fL)next, n, n2)) {
                                        continue;
                                    }
                                    array2[array[0]] = next;
                                    if (array[0] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else if ((n3 & 0x8) != 0x0 && array2[array[1]] == null && next instanceof x) {
                                    if (!this.a((x)next, n, n2)) {
                                        continue;
                                    }
                                    array2[array[1]] = next;
                                    if (array[1] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else if ((n3 & 0x20) != 0x0 && array2[array[2]] == null && next instanceof aA) {
                                    if (!this.a((aA)next, n, n2)) {
                                        continue;
                                    }
                                    array2[array[2]] = next;
                                    if (array[2] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else if ((n3 & 0x10) != 0x0 && array2[array[5]] == null && next instanceof eR) {
                                    if (!this.a((eR)next, n, n2)) {
                                        continue;
                                    }
                                    array2[array[5]] = next;
                                    if (array[5] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if ((n3 & 0x40) == 0x0 || array2[array[6]] != null || !(next instanceof eU) || !this.a((eU)next, n, n2)) {
                                        continue;
                                    }
                                    array2[array[6]] = next;
                                    if (array[6] == 0) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                            int j = 0;
                            while (j < array2.length) {
                                if (array2[j] != null) {
                                    Label_1138: {
                                        switch (this.a[j]) {
                                            case 0: {
                                                this.a((fL)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 1: {
                                                this.a((x)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 2: {
                                                this.a((aA)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 3: {
                                                this.a((d)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 4: {
                                                this.a((q)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 5: {
                                                this.a((eR)array2[j]);
                                                if (z) {
                                                    break Label_1138;
                                                }
                                                break Label_1163;
                                            }
                                            case 6: {
                                                this.a((eU)array2[j]);
                                                if (z) {
                                                    break;
                                                }
                                                break Label_1163;
                                            }
                                        }
                                    }
                                }
                                ++j;
                                if (z) {
                                    break;
                                }
                            }
                            return;
                        }
                        Label_0489: {
                            switch (n4) {
                                case 0: {
                                    n3 |= 0x4;
                                    array[0] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 1: {
                                    n3 |= 0x8;
                                    array[1] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 2: {
                                    n3 |= 0x20;
                                    array[2] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 3: {
                                    n3 |= 0x2;
                                    array[3] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 4: {
                                    n3 |= 0x1;
                                    array[4] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 5: {
                                    n3 |= 0x10;
                                    array[5] = i;
                                    if (z) {
                                        break Label_0489;
                                    }
                                    break;
                                }
                                case 6: {
                                    n3 |= 0x40;
                                    array[6] = i;
                                    break;
                                }
                            }
                        }
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                    final int length = this.a.length;
                    continue;
                }
            }
            while (iterator.hasNext()) {
                final d next2 = iterator.next();
                if (next2 instanceof d) {
                    if (this.a(bu.i(next2), n, n2)) {
                        this.a(next2);
                        return;
                    }
                    continue;
                }
                else if (next2 instanceof q) {
                    if (this.a(bu.t((q)next2), n, n2)) {
                        this.a((q)next2);
                        return;
                    }
                    continue;
                }
                else if (next2 instanceof fL) {
                    if (this.a((fL)next2, n, n2)) {
                        this.a((fL)next2);
                        return;
                    }
                    continue;
                }
                else if (next2 instanceof x) {
                    if (this.a((x)next2, n, n2)) {
                        this.a((x)next2);
                        return;
                    }
                    continue;
                }
                else if (next2 instanceof aA) {
                    if (this.a((aA)next2, n, n2)) {
                        this.a((aA)next2);
                        return;
                    }
                    continue;
                }
                else if (next2 instanceof eR) {
                    if (this.a((eR)next2, n, n2)) {
                        this.a((eR)next2);
                        return;
                    }
                    continue;
                }
                else {
                    if (next2 instanceof eU && this.a((eU)next2, n, n2)) {
                        this.a((eU)next2);
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    private void a(final bu bu, final Object o, final double n, final double n2) {
        final boolean z = fj.z;
        if (o instanceof d) {
            if (!this.a(bu.i((d)o), n, n2)) {
                return;
            }
            this.a((d)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof q) {
            if (!this.a(bu.t((q)o), n, n2)) {
                return;
            }
            this.a((q)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof fL) {
            if (!this.a((fL)o, n, n2)) {
                return;
            }
            this.a((fL)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof x) {
            if (!this.a((x)o, n, n2)) {
                return;
            }
            this.a((x)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof aA) {
            if (!this.a((aA)o, n, n2)) {
                return;
            }
            this.a((aA)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof eR) {
            if (!this.a((eR)o, n, n2)) {
                return;
            }
            this.a((eR)o);
            if (!z) {
                return;
            }
        }
        if (o instanceof eU && this.a((eU)o, n, n2)) {
            this.a((eU)o);
        }
    }
    
    public boolean a() {
        return !this.i.isEmpty();
    }
    
    public boolean b() {
        return this.c() > 1;
    }
    
    int c() {
        return this.i.size();
    }
    
    public C d() {
        return this.i.m();
    }
    
    public C e() {
        return this.c.m();
    }
    
    public C f() {
        return this.g.m();
    }
    
    public C g() {
        return this.f.m();
    }
    
    public Object h() {
        if (this.i.isEmpty()) {
            return null;
        }
        return this.i.f();
    }
    
    public q i() {
        if (this.c.isEmpty()) {
            return null;
        }
        return (q)this.c.f();
    }
    
    public x j() {
        if (this.d.isEmpty()) {
            return null;
        }
        return (x)this.d.f();
    }
    
    public d k() {
        if (this.b.isEmpty()) {
            return null;
        }
        return (d)this.b.f();
    }
    
    public eR l() {
        if (this.f.isEmpty()) {
            return null;
        }
        return (eR)this.f.f();
    }
    
    public aA m() {
        if (this.e.isEmpty()) {
            return null;
        }
        return (aA)this.e.f();
    }
    
    public fL n() {
        if (this.g.isEmpty()) {
            return null;
        }
        return (fL)this.g.f();
    }
    
    public eU o() {
        if (this.h.isEmpty()) {
            return null;
        }
        return (eU)this.h.f();
    }
    
    public boolean p() {
        return !this.h.isEmpty();
    }
    
    public boolean q() {
        return !this.g.isEmpty();
    }
    
    public boolean r() {
        return !this.e.isEmpty();
    }
    
    public boolean s() {
        return !this.f.isEmpty();
    }
    
    public boolean t() {
        return !this.c.isEmpty();
    }
    
    public boolean u() {
        return !this.b.isEmpty();
    }
    
    public boolean v() {
        return !this.d.isEmpty();
    }
    
    public cW a(final bu bu, final double n, final double n2) {
        if (this.c() > 1) {
            final Object h = this.h();
            final Iterator iterator = this.i.iterator();
            iterator.next();
            final cW cw = new cW(bu, iterator, n, n2, false);
            cw.a(bu, h, n, n2);
            return cw;
        }
        return this;
    }
    
    public boolean a(final cW cw) {
        if (cw == null) {
            return false;
        }
        final HashSet set = new HashSet(this.i);
        set.removeAll(cw.i);
        if (!set.isEmpty()) {
            return false;
        }
        final HashSet set2 = new HashSet(cw.i);
        set2.removeAll(this.i);
        return set2.isEmpty();
    }
    
    private void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        final boolean z = fj.z;
        this.g = new D();
        this.b = new D();
        this.c = new D();
        this.d = new D();
        this.e = new D();
        this.f = new D();
        this.h = new D();
        this.i = new D();
        final int[] array = { n, n2, n3, n4, n5, n6, n7 };
        int n8 = 0;
        int i = 0;
        while (true) {
            while (i < array.length) {
                final int n9 = array[i];
                if (z) {
                    int j = n9;
                    while (j < array.length) {
                        switch (array[j]) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6: {
                                this.a[n8++] = array[j];
                                break;
                            }
                        }
                        ++j;
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                switch (n9) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6: {
                        ++n8;
                        break;
                    }
                }
                ++i;
                if (z) {
                    break;
                }
            }
            this.a = new int[n8];
            n8 = 0;
            continue;
        }
    }
}
