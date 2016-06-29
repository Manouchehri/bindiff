package y.h;

import javax.swing.*;
import java.awt.event.*;
import y.h.a.*;
import y.c.*;
import java.util.*;

class cN extends AbstractAction
{
    ch a;
    boolean b;
    
    public cN(final ch a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final ch a = this.a(actionEvent);
        if (a != null) {
            this.a(a);
            a.getGraph2D().T();
        }
    }
    
    public void a(final ch ch) {
        final bu graph2D = ch.getGraph2D();
        final y a = this.a(graph2D);
        if (!a.isEmpty()) {
            graph2D.r();
            try {
                final y a2 = this.a(graph2D, a);
                this.a(graph2D, a2, a);
                this.b(graph2D, a2, a);
            }
            finally {
                graph2D.s();
            }
            ch.updateWorldRect();
            ch.updateView();
        }
    }
    
    protected y a(final bu bu, final y y) {
        final boolean z = fj.z;
        final y y2 = new y();
        if (y.size() > 0) {
            final q d = bu.d();
            y2.add(d);
            final A t = bu.t();
            final ArrayList<q> list = new ArrayList<q>();
            final v c = bu.C();
            int n = 0;
            final x a = y.a();
            while (true) {
                while (a.f()) {
                    final q e = a.e();
                    final int b;
                    final int n2 = b = (this.b ? 1 : 0);
                    if (!z) {
                        Label_0117: {
                            if (n2 != 0) {
                                bu.a(e, d);
                                if (!z) {
                                    break Label_0117;
                                }
                            }
                            bu.a(d, e);
                        }
                        final q q = (c == null) ? null : c.n(e);
                        Label_0186: {
                            if (q == null) {
                                ++n;
                                if (!z) {
                                    break Label_0186;
                                }
                            }
                            int a2 = t.a(q);
                            if (a2 == 0) {
                                list.add(q);
                            }
                            t.a(q, ++a2);
                        }
                        a.g();
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        int n3 = b;
                        q q2 = null;
                        for (final q q3 : list) {
                            final int a3 = t.a(q3);
                            if (n3 < a3) {
                                n3 = a3;
                                q2 = q3;
                                if (z) {
                                    return y2;
                                }
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                        }
                        if (n3 > n) {
                            c.b(y2, q2);
                            return y2;
                        }
                        return y2;
                    }
                }
                int b = 0;
                continue;
            }
        }
        return y2;
    }
    
    protected y a(final bu bu) {
        final boolean z = fj.z;
        final y y = new y();
        final x o = bu.o();
        while (o.f()) {
            final q e = o.e();
            if (bu.v(e)) {
                y.add(e);
            }
            o.g();
            if (z) {
                break;
            }
        }
        return y;
    }
    
    protected void a(final bu bu, final y y, final y y2) {
        hV.a(bu, y);
    }
    
    protected void b(final bu bu, final y y, final y y2) {
        final boolean z = fj.z;
        bu.N();
        final x a = y.a();
        while (a.f()) {
            bu.a(a.e(), true);
            a.g();
            if (z) {
                break;
            }
        }
    }
    
    protected ch a(final ActionEvent actionEvent) {
        return cm.a(actionEvent, this.a);
    }
}
