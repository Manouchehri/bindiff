package y.h;

import java.util.*;
import y.g.*;
import y.c.*;

public class cY implements cZ
{
    private ch a;
    
    public cY(final ch a) {
        this.a = a;
    }
    
    public cW a(final double n, final double n2, final int n3, final boolean b) {
        final cW a = this.a(this.a(), this.b(), n, n2, n3, b);
        if (b && (n3 & 0x10) != 0x0 && a.s() && !a.l().isSelected()) {
            if ((n3 & 0x1) != 0x0 && (n3 & 0x40) != 0x0) {
                final eR l = a.l();
                final fj g = l.g();
                if (g != null) {
                    if (l.a() instanceof fM) {
                        final eU a2 = fM.a(g, l.getModelParameter());
                        if (a2 != null && a2.f() && a2.a(n, n2)) {
                            return a(a2);
                        }
                        if (g.getNode() != null && g.contains(n, n2)) {
                            return a(g.getNode());
                        }
                    }
                    else if (g.getNode() != null && g.contains(n, n2)) {
                        return a(g.getNode());
                    }
                }
            }
            else if ((n3 & 0x1) != 0x0) {
                final fj g2 = a.l().g();
                if (g2 != null && g2.getNode() != null && g2.contains(n, n2)) {
                    return a(g2.getNode());
                }
            }
            else if ((n3 & 0x40) != 0x0) {
                final eR i = a.l();
                final fj g3 = i.g();
                if (g3 != null && i.a() instanceof fM) {
                    final eU a3 = fM.a(g3, i.getModelParameter());
                    if (a3 != null && a3.f() && a3.a(n, n2)) {
                        return a(a3);
                    }
                }
            }
        }
        return a;
    }
    
    protected cW a(final ch ch, final bu bu, final double n, final double n2, final int n3, final boolean b) {
        return new cW(bu, a(ch, bu, n3), n, n2, b);
    }
    
    protected ch a() {
        return this.a;
    }
    
    protected bu b() {
        return this.a().getGraph2D();
    }
    
    private static Iterator a(final ch ch, final bu bu, final int n) {
        cg cg = null;
        Label_0063: {
            if (ch.getGraph2DRenderer() instanceof ft) {
                final ft ft = (ft)ch.getGraph2DRenderer();
                cg = ((ch.getZoom() >= ch.getPaintDetailThreshold()) ? ft.getPaintOrder() : ft.getSloppyPaintOrder());
                if (!fj.z) {
                    break Label_0063;
                }
            }
            cg = new U();
        }
        if (!Boolean.TRUE.equals(ch.getClientProperty("Graph2DView.hitTestInvisibleElements"))) {
            final boolean b = true;
            return new A(cg.b(bu, n), new gY(bu, b ? 1 : 0, b ? 1 : 0, b ? 1 : 0, b ? 1 : 0));
        }
        return cg.b(bu, n);
    }
    
    private static cW a(final q q) {
        final cW cw = new cW();
        cw.a(q);
        return cw;
    }
    
    private static cW a(final eU eu) {
        final cW cw = new cW();
        cw.a(eu);
        return cw;
    }
}
