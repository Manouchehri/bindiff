package y.h.b;

import java.util.*;
import y.c.*;
import y.h.*;
import java.beans.*;
import y.d.*;

public class u extends ae
{
    private int a;
    private f b;
    private y.h.b.c c;
    private boolean d;
    private boolean e;
    
    public u() {
        this.a = -1;
        this.d = true;
        this.e = true;
    }
    
    public boolean a(final double n, final double n2) {
        final int h = y.h.b.a.H;
        this.a = -1;
        this.b = null;
        this.c = null;
        if (this.h != null && this.i != null) {
            final cW cw = new cW(this.h, n, n2, true);
            final q a = this.a(cw);
            if (a != null) {
                final bu graph2D = this.h.getGraph2D();
                if (graph2D != null && ae.a(graph2D, a) == this.i) {
                    a j = null;
                    Label_0164: {
                        if (cw.s()) {
                            final eR l = cw.l();
                            int i = 0;
                            while (i < this.i.labelCount()) {
                                j = this.i;
                                if (h != 0) {
                                    break Label_0164;
                                }
                                if (j.getLabel(i) == l) {
                                    this.a = i;
                                    return true;
                                }
                                ++i;
                                if (h != 0) {
                                    break;
                                }
                            }
                        }
                        final a k = this.i;
                    }
                    final f a2 = j.l().a(n, n2);
                    if (a2 != null && this.a(a2, n, n2)) {
                        this.b = a2;
                        return true;
                    }
                    final y.h.b.c b = this.i.l().b(n, n2);
                    if (b != null && this.a(b, n, n2)) {
                        this.c = b;
                        return true;
                    }
                }
            }
        }
        this.i();
        return false;
    }
    
    protected boolean a(final y.h.b.c c, final double n, final double n2) {
        return this.a(this.i, c, n, n2, this.h());
    }
    
    protected boolean a(final f f, final double n, final double n2) {
        return this.a(this.i, f, n, n2, this.h());
    }
    
    protected eR a(final f f) {
        final Collection a = y.h.b.h.a(f);
        if (!a.isEmpty()) {
            return a.iterator().next();
        }
        if (this.g()) {
            return this.b(f);
        }
        return null;
    }
    
    protected eR a(final y.h.b.c c) {
        final Collection a = y.h.b.e.a(c);
        if (!a.isEmpty()) {
            return a.iterator().next();
        }
        if (this.g()) {
            return this.b(c);
        }
        return null;
    }
    
    protected eR b(final f f) {
        final a a = y.h.b.a.a(f);
        final eR nodeLabel = a.createNodeLabel();
        a.a(nodeLabel, f, true, 0.0);
        a.addLabel(nodeLabel);
        return nodeLabel;
    }
    
    protected eR b(final y.h.b.c c) {
        final a a = y.h.b.a.a(c);
        final eR nodeLabel = a.createNodeLabel();
        a.a(nodeLabel, c, true, 0.0);
        a.addLabel(nodeLabel);
        return nodeLabel;
    }
    
    public boolean g() {
        return this.d;
    }
    
    public boolean h() {
        return this.e;
    }
    
    public boolean a(final dw dw) {
        return this.d(dw);
    }
    
    private boolean d(final dw dw) {
        return this.h(dw) && this.a(dw.a(), dw.b());
    }
    
    public void b(final dw dw) {
        final int h = y.h.b.a.H;
        if (this.d(dw)) {
            final q node = this.i.getNode();
            final bu graph2D = this.h.getGraph2D();
            graph2D.r();
            try {
                graph2D.a(new y(node).a());
                final fj a = ae.a(graph2D, node);
                Label_0239: {
                    if (a == this.i) {
                        if (this.a > -1) {
                            a(this.h, this.i.getLabel(this.a));
                            if (h == 0) {
                                break Label_0239;
                            }
                        }
                        if (this.b != null) {
                            this.a(this.h, this.b);
                            if (h == 0) {
                                break Label_0239;
                            }
                        }
                        if (this.c == null) {
                            break Label_0239;
                        }
                        this.a(this.h, this.c);
                        if (h == 0) {
                            break Label_0239;
                        }
                    }
                    if (a instanceof a) {
                        if (this.a > -1) {
                            a(this.h, a.getLabel(this.a));
                            if (h == 0) {
                                break Label_0239;
                            }
                        }
                        if (this.b != null) {
                            this.a(this.h, aa.a(this.b, (a)a));
                            if (h == 0) {
                                break Label_0239;
                            }
                        }
                        if (this.c != null) {
                            this.a(this.h, aa.a(this.c, (a)a));
                        }
                    }
                }
            }
            finally {
                graph2D.s();
            }
        }
        this.e();
    }
    
    void i() {
        super.i();
        this.b = null;
        this.c = null;
    }
    
    private void a(final ch ch, final f f) {
        a(ch, this.a(f));
    }
    
    private void a(final ch ch, final y.h.b.c c) {
        a(ch, this.a(c));
    }
    
    private static void a(final ch ch, final eR er) {
        if (er != null) {
            final t k = er.transformCTW(er.getTextBox()).k();
            ch.openLabelEditorCentered(er, k.a, k.b, null, true);
        }
    }
}
