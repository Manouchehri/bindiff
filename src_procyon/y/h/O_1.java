package y.h;

import java.awt.geom.*;
import java.awt.*;
import java.util.*;
import y.h.a.*;
import y.c.*;

public class O implements ft
{
    private final R d;
    private final R e;
    private int g;
    private C f;
    
    public O() {
        this.g = 10;
        this.d = new R(this);
        this.e = new R(this);
    }
    
    public cg getPaintOrder() {
        return this.d;
    }
    
    public cg getSloppyPaintOrder() {
        return this.e;
    }
    
    public boolean isLayeredPainting() {
        return this.d.a();
    }
    
    public void setLayeredPainting(final boolean b) {
        this.d.a(b);
        this.e.a(b);
    }
    
    public void setNestedEdgeDrawingOrderEnabled(final boolean b) {
        this.d.c(b);
    }
    
    public boolean isNestedEdgeDrawingOrderEnabled() {
        return this.d.c();
    }
    
    public C getBridgeCalculator() {
        return this.f;
    }
    
    public void setBridgeCalculator(final C f) {
        this.f = f;
    }
    
    public void setDrawEdgesFirst(final boolean b) {
        this.d.d(b);
        this.e.d(b);
    }
    
    public boolean getDrawEdgesFirst() {
        return this.d.d();
    }
    
    public void setDrawSelectionOnTop(final boolean b) {
        this.d.e(b);
        this.e.e(b);
    }
    
    public boolean isDrawSelectionOnTop() {
        return this.d.e();
    }
    
    public void setClipEnlargementValue(final int g) {
        this.g = g;
    }
    
    public int getClipEnlargementValue() {
        return this.g;
    }
    
    public void setHierarchicSloppyPaintOrderEnabled(final boolean b) {
        this.e.b(b);
    }
    
    public boolean isHierarchicSloppyPaintOrderEnabled() {
        return this.e.b();
    }
    
    public void paint(final Graphics2D graphics2D, final bu bu) {
        Object renderingHint = null;
        Rectangle rectangle = graphics2D.getClipBounds();
        if (rectangle == null) {
            rectangle = bu.a();
        }
        final Rectangle rectangle2 = rectangle;
        rectangle2.x -= this.g;
        final Rectangle rectangle3 = rectangle;
        rectangle3.y -= this.g;
        final Rectangle rectangle4 = rectangle;
        rectangle4.width += 2 * this.g;
        final Rectangle rectangle5 = rectangle;
        rectangle5.height += 2 * this.g;
        final C f = this.f;
        if (f != null) {
            this.prepareBridgeCalculator(f, bu, rectangle);
            renderingHint = graphics2D.getRenderingHint(S.a);
            graphics2D.setRenderingHint(S.a, S.a(bu, f));
        }
        this.b(bu, graphics2D, rectangle, false);
        if (f != null) {
            graphics2D.setRenderingHint(S.a, renderingHint);
        }
    }
    
    private void b(final bu bu, final Graphics2D graphics2D, final Rectangle rectangle, final boolean b) {
        final boolean z = fj.z;
        Label_0241: {
            if (!this.isLayeredPainting()) {
                Label_0129: {
                    if (b) {
                        final Iterator a = this.e.a(bu, 3);
                        while (a.hasNext()) {
                            final d next = a.next();
                            if (next instanceof d) {
                                final aB i = bu.i(next);
                                if (!this.intersects(i, rectangle)) {
                                    continue;
                                }
                                this.paintSloppy(graphics2D, i);
                                if (!z) {
                                    continue;
                                }
                            }
                            if (next instanceof q) {
                                final fj t = bu.t((q)next);
                                if (!this.intersects(t, rectangle)) {
                                    continue;
                                }
                                this.paintSloppy(graphics2D, t);
                                if (z) {
                                    break Label_0129;
                                }
                                continue;
                            }
                        }
                        return;
                    }
                }
                final Iterator a2 = this.d.a(bu, 3);
                while (a2.hasNext()) {
                    final d next2 = a2.next();
                    if (next2 instanceof d) {
                        final aB j = bu.i(next2);
                        if (!this.intersects(j, rectangle)) {
                            continue;
                        }
                        this.paint(graphics2D, j);
                        if (!z) {
                            continue;
                        }
                    }
                    if (next2 instanceof q) {
                        final fj t2 = bu.t((q)next2);
                        if (!this.intersects(t2, rectangle)) {
                            continue;
                        }
                        this.paint(graphics2D, t2);
                        if (z) {
                            break Label_0241;
                        }
                        continue;
                    }
                }
                return;
            }
        }
        Label_0486: {
            if (b) {
                int n = -1;
                final Iterator a3 = this.e.a(bu, 3);
                while (true) {
                    while (a3.hasNext()) {
                        final d next3 = a3.next();
                        if (next3 instanceof d) {
                            final d d = next3;
                            final aB k = bu.i(d);
                            if (!this.intersects(k, rectangle)) {
                                continue;
                            }
                            final int layer = this.getLayer(bu, d);
                            if (layer != n) {
                                if (n > -1) {
                                    this.endLayerPainting(graphics2D, n, b);
                                }
                                this.beginLayerPainting(graphics2D, layer, b);
                            }
                            this.paintSloppyLayered(graphics2D, layer, k);
                            n = layer;
                            if (!z) {
                                continue;
                            }
                        }
                        if (next3 instanceof q) {
                            final q q = (q)next3;
                            final fj t3 = bu.t(q);
                            final int intersects = this.intersects(t3, rectangle) ? 1 : 0;
                            if (!z) {
                                if (intersects == 0) {
                                    continue;
                                }
                                final int layer2 = this.getLayer(bu, q);
                                if (layer2 != n) {
                                    if (n > -1) {
                                        this.endLayerPainting(graphics2D, n, b);
                                    }
                                    this.beginLayerPainting(graphics2D, layer2, b);
                                }
                                this.paintSloppyLayered(graphics2D, layer2, t3);
                                n = layer2;
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (intersects <= -1) {
                                    return;
                                }
                                this.endLayerPainting(graphics2D, n, b);
                                if (z) {
                                    break Label_0486;
                                }
                                return;
                            }
                        }
                    }
                    continue;
                }
            }
        }
        int n2 = -1;
        final Iterator a4 = this.d.a(bu, 3);
        while (true) {
            while (a4.hasNext()) {
                final d next4 = a4.next();
                if (next4 instanceof d) {
                    final d d2 = next4;
                    final aB l = bu.i(d2);
                    if (!this.intersects(l, rectangle)) {
                        continue;
                    }
                    final int layer3 = this.getLayer(bu, d2);
                    if (layer3 != n2) {
                        if (n2 > -1) {
                            this.endLayerPainting(graphics2D, n2, b);
                        }
                        this.beginLayerPainting(graphics2D, layer3, b);
                    }
                    this.paintLayered(graphics2D, layer3, l);
                    n2 = layer3;
                    if (!z) {
                        continue;
                    }
                }
                if (next4 instanceof q) {
                    final q q2 = (q)next4;
                    final fj t4 = bu.t(q2);
                    final int intersects2 = this.intersects(t4, rectangle) ? 1 : 0;
                    if (!z) {
                        if (intersects2 == 0) {
                            continue;
                        }
                        final int layer4 = this.getLayer(bu, q2);
                        if (layer4 != n2) {
                            if (n2 > -1) {
                                this.endLayerPainting(graphics2D, n2, b);
                            }
                            this.beginLayerPainting(graphics2D, layer4, b);
                        }
                        this.paintLayered(graphics2D, layer4, t4);
                        n2 = layer4;
                        if (z) {
                            break;
                        }
                        continue;
                    }
                    else {
                        if (intersects2 > -1) {
                            this.endLayerPainting(graphics2D, n2, b);
                        }
                        return;
                    }
                }
            }
            continue;
        }
    }
    
    protected void beginLayerPainting(final Graphics2D graphics2D, final int n, final boolean b) {
    }
    
    protected void endLayerPainting(final Graphics2D graphics2D, final int n, final boolean b) {
    }
    
    protected void paintLayered(final Graphics2D graphics2D, final int n, final fj fj) {
        this.paint(graphics2D, fj);
    }
    
    protected void paintLayered(final Graphics2D graphics2D, final int n, final aB ab) {
        this.paint(graphics2D, ab);
    }
    
    protected void paintSloppyLayered(final Graphics2D graphics2D, final int n, final fj fj) {
        this.paintSloppy(graphics2D, fj);
    }
    
    protected void paintSloppyLayered(final Graphics2D graphics2D, final int n, final aB ab) {
        this.paintSloppy(graphics2D, ab);
    }
    
    protected int getLayer(final bu bu, final d d) {
        return Math.max(this.getLayer(bu, d.c()), this.getLayer(bu, d.d()));
    }
    
    protected int getLayer(final bu bu, q q) {
        final boolean z = fj.z;
        final v c = bu.C();
        int n = 0;
        if (c != null) {
            while (q != null) {
                final q n2 = c.n(q);
                if (n2 != null && n2.e() != q.e()) {
                    return n;
                }
                q = n2;
                ++n;
                if (z) {
                    break;
                }
            }
            return n;
        }
        return n;
    }
    
    protected void prepareBridgeCalculator(final C c, final bu bu, final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        c.a();
        c.a(rectangle2D.getMinX() - this.g, rectangle2D.getMinY() - this.g, rectangle2D.getMaxX() + this.g, rectangle2D.getMaxY() + this.g);
        if (c.b() != 0) {
            final e p3 = bu.p();
            while (p3.f()) {
                final aB i = bu.i(p3.a());
                if (this.intersects(i, rectangle2D)) {
                    i.registerObstacles(c);
                }
                p3.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    public static C getBridgeCalculator(final aB ab, final Graphics2D graphics2D) {
        if (ab != null && ab.getEdge() != null) {
            final T t = (T)graphics2D.getRenderingHint(S.a);
            if (t != null && t.a() == ab.getEdge().a()) {
                return t.b();
            }
        }
        return null;
    }
    
    public void setSloppyNestedEdgeDrawingOrderEnabled(final boolean b) {
        this.e.c(b);
    }
    
    public boolean isSloppyNestedEdgeDrawingOrderEnabled() {
        return this.e.c();
    }
    
    protected boolean intersects(final fj fj, final Rectangle2D rectangle2D) {
        final Rectangle2D.Double j;
        final Rectangle2D.Double double2;
        final Rectangle2D.Double double1 = double2 = (j = hC.a().j);
        final double n = -1.0;
        double2.height = n;
        j.width = n;
        fj.calcUnionRect(double1);
        return double1.intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    protected boolean intersects(final aB ab, final Rectangle2D rectangle2D) {
        return ab.intersects(rectangle2D);
    }
    
    public void paintSloppy(final Graphics2D graphics2D, final bu bu) {
        Rectangle rectangle = graphics2D.getClipBounds();
        if (rectangle == null) {
            rectangle = bu.a();
        }
        final Rectangle rectangle2 = rectangle;
        rectangle2.x -= this.g;
        final Rectangle rectangle3 = rectangle;
        rectangle3.y -= this.g;
        final Rectangle rectangle4 = rectangle;
        rectangle4.width += 2 * this.g;
        final Rectangle rectangle5 = rectangle;
        rectangle5.height += 2 * this.g;
        this.b(bu, graphics2D, rectangle, true);
    }
    
    protected void paint(final Graphics2D graphics2D, final fj fj) {
        fj.paint(graphics2D);
    }
    
    protected void paint(final Graphics2D graphics2D, final aB ab) {
        ab.paint(graphics2D);
    }
    
    protected void paintSloppy(final Graphics2D graphics2D, final fj fj) {
        fj.paintSloppy(graphics2D);
    }
    
    protected void paintSloppy(final Graphics2D graphics2D, final aB ab) {
        ab.paintSloppy(graphics2D);
    }
}
