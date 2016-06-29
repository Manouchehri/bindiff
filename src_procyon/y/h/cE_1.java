package y.h;

import javax.swing.*;
import y.h.a.*;
import y.c.*;
import y.h.b.*;
import y.f.*;
import java.awt.event.*;
import java.util.*;

public class cE extends AbstractAction
{
    private final ch a;
    private int b;
    private boolean c;
    private boolean d;
    private Map e;
    private Map f;
    private Map g;
    private Set h;
    private boolean i;
    
    public cE() {
        this((ch)null);
    }
    
    public cE(final ch a) {
        super(cm.u.toString());
        this.a = a;
        this.b = 639;
    }
    
    public int a() {
        return this.b;
    }
    
    public boolean b() {
        return this.c;
    }
    
    public boolean c() {
        return this.i;
    }
    
    protected boolean a(final d d, final aA aa) {
        return (this.a() & 0x4) == 0x4 && aa.isSelected();
    }
    
    protected boolean a(final d d, final x x) {
        return (this.a() & 0x1) == 0x1 && x.d();
    }
    
    protected boolean a(final bu bu, final d d) {
        return ((this.a() & 0x2) == 0x2 && bu.r(d)) || this.a(bu, d, true) || this.a(bu, d, false);
    }
    
    private boolean a(final bu bu, final d d, final boolean b) {
        final eU a = eU.a(bu, d, b);
        return a != null && this.a(b ? d.c() : d.d(), a);
    }
    
    protected boolean a(final q q, final eR er) {
        return (this.a() & 0x40) == 0x40 && (er.isSelected() || (this.e.containsKey(er) && this.a(q, this.e.get(er))) || (this.f.containsKey(er) && this.a(q, this.f.get(er))) || (this.g.containsKey(er) && this.a(q, this.g.get(er))));
    }
    
    protected boolean a(final q q, final c c) {
        final boolean b = (this.a() & 0x80) == 0x80 && c.e();
        this.d |= b;
        return b;
    }
    
    protected boolean a(final q q, final f f) {
        final boolean b = (this.a() & 0x100) == 0x100 && f.e();
        this.d |= b;
        return b;
    }
    
    protected boolean a(final bu bu, final q q) {
        final int a = this.a();
        if (!bu.v(q)) {
            return false;
        }
        if (cm.a(bu, q) instanceof a) {
            return (a & 0x20) == 0x20 && (!this.b() || !this.d);
        }
        final v a2 = v.a(bu);
        if (a2 != null && a2.k(q)) {
            return (a & 0x10) == 0x10;
        }
        return (a & 0x8) == 0x8;
    }
    
    protected boolean a(final q q, final eU eu) {
        return (this.a() & 0x200) == 0x200 && eu.f();
    }
    
    protected void b(final bu bu, final q q) {
        this.e(bu, q);
        this.d(bu, q);
        this.f(bu, q);
    }
    
    private void d(final bu bu, final q q) {
        final boolean z = fj.z;
        y.h.a.a a = null;
        final fj a2 = cm.a(bu, q);
        final boolean a3 = this.a(a2, q);
        final boolean a4 = this.a(bu, q);
        if ((a3 || a4) && this.c() && bu.C() != null) {
            final q n = bu.C().n(q);
            if (n != null) {
                if (this.h.add(n)) {
                    bu.a(new y(n).a());
                }
                final y.h.a.a autoBoundsFeature = bu.t(n).getAutoBoundsFeature();
                if (autoBoundsFeature != null && autoBoundsFeature.isAutoBoundsEnabled()) {
                    autoBoundsFeature.setAutoBoundsEnabled(false);
                    a = autoBoundsFeature;
                }
            }
        }
        if (a3) {
            if (this.h.add(q)) {
                bu.a(new y(q).a());
            }
            if (q.a() > 0) {
                bu.a(q.j());
            }
        }
        Label_0515: {
            if (a2 instanceof a) {
                final y.h.b.i l = ((a)a2).l();
                int k = l.k();
            Label_0359:
                while (true) {
                    while (true) {
                    Label_0434_Outer:
                        while (k-- > 1) {
                            this.b(q, l.b(k));
                            if (!z) {
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                final c b = l.b(0);
                                int i = b.k();
                                while (i-- > 0) {
                                    this.b(q, b.b(i));
                                    if (z) {
                                        break Label_0359;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                                if (this.a(q, b) && b.k() > 0) {
                                    this.c(q, b);
                                }
                                int n2 = l.n();
                                while (true) {
                                    while (n2-- > 1) {
                                        this.b(q, l.c(n2));
                                        if (!z) {
                                            if (z) {
                                                break;
                                            }
                                            continue Label_0434_Outer;
                                        }
                                        else {
                                            final f c = l.c(0);
                                            int n3 = c.n();
                                            while (n3-- > 0) {
                                                this.b(q, c.c(n3));
                                                if (z) {
                                                    break Label_0515;
                                                }
                                                if (z) {
                                                    break;
                                                }
                                            }
                                            if (this.a(q, c) && c.n() > 0) {
                                                this.c(q, c);
                                            }
                                            break Label_0515;
                                        }
                                    }
                                    if (l.n() <= 1) {
                                        continue;
                                    }
                                    this.b(q, l.c(0));
                                    if (z) {
                                        continue;
                                    }
                                    break;
                                }
                                break Label_0515;
                            }
                        }
                        if (l.k() <= 1) {
                            continue;
                        }
                        this.b(q, l.b(0));
                        if (z) {
                            continue;
                        }
                        break;
                    }
                    continue Label_0359;
                }
            }
        }
        int n4 = a2.portCount();
        while (true) {
        Label_0638_Outer:
            while (n4-- > 0) {
                final eU port = a2.getPort(n4);
                if (this.a(q, port)) {
                    this.a(a2, port, n4);
                    if (!z) {
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        while (true) {
                            while (n4-- > 0) {
                                final eR label = a2.getLabel(n4);
                                if (this.a(q, label)) {
                                    this.a(a2, label, n4);
                                    if (z) {
                                        if (a != null) {
                                            a.setAutoBoundsEnabled(true);
                                        }
                                        return;
                                    }
                                    if (z) {
                                        break;
                                    }
                                    continue Label_0638_Outer;
                                }
                            }
                            if (a4) {
                                this.c(bu, q);
                            }
                            continue;
                        }
                    }
                }
            }
            n4 = a2.labelCount();
            continue;
        }
    }
    
    private void e(final bu bu, final q q) {
        final boolean z = fj.z;
        this.d = false;
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        final fj a = cm.a(bu, q);
        if (a.labelCount() > 0) {
            final boolean b = a instanceof a;
            final a a2 = b ? ((a)a) : null;
            int i = 0;
            while (i < a.labelCount()) {
                final eR label = a.getLabel(i);
                final al a3 = label.a();
                Label_0239: {
                    if (a3 instanceof fM) {
                        final eU a4 = fM.a(a, label.getModelParameter());
                        if (a4 == null) {
                            break Label_0239;
                        }
                        this.g.put(label, a4);
                        if (!z) {
                            break Label_0239;
                        }
                    }
                    if (b) {
                        if (a3 instanceof e) {
                            final c a5 = y.h.b.e.a(a2, label.getModelParameter());
                            if (a5 == null) {
                                break Label_0239;
                            }
                            this.e.put(label, a5);
                            if (!z) {
                                break Label_0239;
                            }
                        }
                        if (a3 instanceof h) {
                            final f a6 = y.h.b.h.a(a2, label.getModelParameter());
                            if (a6 != null) {
                                this.f.put(label, a6);
                            }
                        }
                    }
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    private void f(final bu bu, final q q) {
        this.g = null;
        this.f = null;
        this.e = null;
        this.d = false;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
            a.getGraph2D().T();
        }
    }
    
    public void a(final ch ch) {
        final boolean z = fj.z;
        final bu graph2D = ch.getGraph2D();
        graph2D.r();
        try {
            final y.c.e p = graph2D.p();
            while (true) {
                while (p.f()) {
                    this.b(graph2D, p.a());
                    p.g();
                    if (z) {
                        final v c = graph2D.C();
                        Label_0194: {
                            Label_0120: {
                                if (c == null) {
                                    final y.c.x o = graph2D.o();
                                    while (o.f()) {
                                        this.b(graph2D, o.e());
                                        o.g();
                                        if (z) {
                                            return;
                                        }
                                        if (z) {
                                            break Label_0120;
                                        }
                                    }
                                    break Label_0194;
                                }
                            }
                            final ArrayList list = new ArrayList<q>(graph2D.f());
                            c.a(c.e(graph2D), new cp(this, list));
                            final Iterator<q> iterator = list.iterator();
                            while (iterator.hasNext()) {
                                this.b(graph2D, iterator.next());
                                if (z) {
                                    return;
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                        this.h = null;
                        return;
                    }
                    if (z) {
                        break;
                    }
                }
                this.h = new HashSet();
                continue;
            }
        }
        finally {
            graph2D.s();
        }
    }
    
    protected void b(final bu bu, final d d) {
        final boolean z = fj.z;
        aB ab = bu.i(d);
        if (this.a(ab, d)) {
            bu.a(new y.c.f(d).a());
            ab = bu.i(d);
        }
        final y.h.y bends = ab.bends();
        while (true) {
            while (bends.f()) {
                final int n2;
                final int n = n2 = (this.a(d, bends.a()) ? 1 : 0);
                if (!z) {
                    if (n != 0) {
                        this.a(ab, bends.a());
                    }
                    bends.g();
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    int n3 = n2;
                    while (n3-- > 0) {
                        final aA label = ab.getLabel(n3);
                        if (this.a(d, label)) {
                            this.a(ab, label, n3);
                            if (z) {
                                return;
                            }
                            if (z) {
                                break;
                            }
                            continue;
                        }
                    }
                    if (this.a(bu, d)) {
                        this.c(bu, d);
                    }
                    return;
                }
            }
            int n2 = ab.labelCount();
            continue;
        }
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
    
    boolean a(final aB ab, final d d) {
        final boolean z = fj.z;
        final y.h.y bends = ab.bends();
        while (true) {
            while (bends.f()) {
                final int a = this.a(d, bends.a()) ? 1 : 0;
                if (z) {
                    boolean a2 = false;
                    if (a > 0) {
                        int i = 0;
                        while (i < ab.labelCount()) {
                            a2 = this.a(d, ab.getLabel(i));
                            if (z) {
                                break;
                            }
                            if (a2) {
                                return true;
                            }
                            ++i;
                            if (z) {
                                break;
                            }
                        }
                    }
                    return a2;
                }
                if (a != 0) {
                    return true;
                }
                bends.g();
                if (z) {
                    break;
                }
            }
            ab.labelCount();
            continue;
        }
    }
    
    boolean a(final fj fj, final q q) {
        final boolean z = fj.z;
        int a2 = 0;
        Label_0182: {
            Label_0178: {
                if (fj instanceof a) {
                    final y.h.b.i l = ((a)fj).l();
                    final ArrayList list = new ArrayList<c>();
                    list.addAll(l.l());
                    while (true) {
                        while (!list.isEmpty()) {
                            final c c = list.remove(list.size() - 1);
                            final boolean a = this.a(q, c);
                            if (z) {
                                while (!list.isEmpty()) {
                                    final f f = (f)list.remove(list.size() - 1);
                                    a2 = (this.a(q, f) ? 1 : 0);
                                    if (z) {
                                        break Label_0182;
                                    }
                                    if (a2 != 0) {
                                        return true;
                                    }
                                    list.addAll(f.o());
                                    if (z) {
                                        break;
                                    }
                                }
                                break Label_0178;
                            }
                            if (a) {
                                return true;
                            }
                            list.addAll(c.l());
                            if (z) {
                                break;
                            }
                        }
                        list.clear();
                        list.addAll(l.o());
                        continue;
                    }
                }
            }
            fj.portCount();
        }
        int n = 0;
        Label_0227: {
            if (a2 > 0) {
                final Iterator ports = fj.ports();
                while (ports.hasNext()) {
                    if (this.a(q, ports.next())) {
                        n = 1;
                        if (!z) {
                            return n != 0;
                        }
                        break Label_0227;
                    }
                }
            }
            fj.labelCount();
        }
        boolean a3 = false;
        if (n > 0) {
            int i = 0;
            while (i < fj.labelCount()) {
                a3 = this.a(q, fj.getLabel(i));
                if (z) {
                    break;
                }
                if (a3) {
                    return true;
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
        return a3;
    }
    
    boolean b(final q q, final c c) {
        final boolean z = fj.z;
        boolean b = false;
        int k = c.k();
        while (k-- > 0) {
            b |= this.b(q, c.b(k));
            if (z) {
                return b;
            }
            if (z) {
                break;
            }
        }
        if (this.a(q, c)) {
            this.c(q, c);
            return true;
        }
        return b;
    }
    
    boolean b(final q q, final f f) {
        final boolean z = fj.z;
        boolean b = false;
        int n = f.n();
        while (n-- > 0) {
            b |= this.b(q, f.c(n));
            if (z) {
                return b;
            }
            if (z) {
                break;
            }
        }
        if (this.a(q, f)) {
            this.c(q, f);
            return true;
        }
        return b;
    }
    
    protected void c(final bu bu, final d d) {
        bu.a(d);
    }
    
    protected void a(final aB ab, final aA aa, final int n) {
        ab.removeLabel(aa);
    }
    
    protected void a(final aB ab, final x x) {
        ab.removeBend(x);
    }
    
    protected void c(final bu bu, final q q) {
        bu.a(q);
    }
    
    protected void a(final fj fj, final eR er, final int n) {
        fj.removeLabel(er);
    }
    
    protected void a(final fj fj, final eU eu, final int n) {
        fj.removePort(n);
    }
    
    protected void c(final q q, final c c) {
        c.c();
    }
    
    protected void c(final q q, final f f) {
        f.c();
    }
}
