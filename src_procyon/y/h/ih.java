package y.h;

import java.awt.geom.*;
import y.d.*;
import y.h.a.*;
import y.c.*;
import java.util.*;

class ih
{
    private Map a;
    
    void a(final bu bu, final q q) {
        final boolean z = fj.z;
        this.a = null;
        final v c = bu.C();
        if (c != null) {
            q q2 = c.n(q);
            while (q2 != null) {
                if (this.a == null) {
                    this.a = new LinkedHashMap();
                }
                this.a.put(q2, bu.t(q2).getBoundingBox());
                q2 = c.n(q2);
                if (z) {
                    break;
                }
            }
        }
    }
    
    void a(final bu bu) {
        final boolean z = fj.z;
        if (this.a != null) {
            for (final Map.Entry<q, V> entry : this.a.entrySet()) {
                final a autoBoundsFeature = bu.t((q)entry.getKey()).getAutoBoundsFeature();
                if (autoBoundsFeature != null) {
                    final Rectangle2D rectangle2D = entry.getValue();
                    final Rectangle2D minimalAutoBounds = autoBoundsFeature.getMinimalAutoBounds();
                    autoBoundsFeature.setAutoBoundsInsets(new r(Math.max(0.0, minimalAutoBounds.getY() - rectangle2D.getY()), Math.max(0.0, minimalAutoBounds.getX() - rectangle2D.getX()), Math.max(0.0, rectangle2D.getMaxY() - minimalAutoBounds.getMaxY()), Math.max(0.0, rectangle2D.getMaxX() - minimalAutoBounds.getMaxX())));
                    if (z) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    void a() {
        this.a = null;
    }
    
    void b(final bu bu, final q q) {
        final boolean z = fj.z;
        final y y = new y(q);
        final v c = bu.C();
        if (c != null) {
            q q2 = c.n(q);
            while (q2 != null) {
                y.add(q2);
                q2 = c.n(q2);
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        bu.a(y.a());
    }
    
    void a(final bu bu, final d d) {
        bu.a(new f(d).a());
    }
    
    void a(final ch ch, final gZ gz) {
        if (gz instanceof eR) {
            this.a(ch, ((eR)gz).f());
            if (!fj.z) {
                return;
            }
        }
        if (gz instanceof aA) {
            this.a(ch, ((aA)gz).getEdge());
        }
    }
    
    void a(final ch ch, final q q) {
        this.a(ch, new y(q).a(), null);
    }
    
    void a(final ch ch, final d d) {
        this.a(ch, null, new f(d).a());
    }
    
    void a(final ch ch, final x x, final e e) {
        final boolean z = fj.z;
        final bu graph2D = ch.getGraph2D();
        graph2D.b((byte)1);
        Label_0166: {
            if (x != null && x.f()) {
                final v c = graph2D.C();
                Label_0082: {
                    if (c == null) {
                        while (x.f()) {
                            graph2D.t(x.e()).setLayer((byte)0);
                            x.g();
                            if (z) {
                                return;
                            }
                            if (z) {
                                break Label_0082;
                            }
                        }
                        break Label_0166;
                    }
                }
                final HashSet<q> set = new HashSet<q>();
                set.add(null);
            Label_0161_Outer:
                while (x.f()) {
                    q q = x.e();
                    while (true) {
                        while (set.add(q)) {
                            graph2D.t(q).setLayer((byte)0);
                            q = c.n(q);
                            if (!z) {
                                if (z) {
                                    break;
                                }
                                continue Label_0161_Outer;
                            }
                            else {
                                if (z) {
                                    break Label_0166;
                                }
                                continue Label_0161_Outer;
                            }
                        }
                        x.g();
                        continue;
                    }
                }
            }
        }
        if (e != null && e.f()) {
            while (e.f()) {
                graph2D.i(e.a()).setLayer((byte)0);
                e.g();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        ch.setDrawingMode(3);
    }
}
