package y.h.a;

import java.awt.geom.*;
import y.d.*;
import java.awt.*;
import y.c.*;
import y.h.*;

public class b implements f, bg, bl
{
    private boolean b;
    static Class a;
    
    public b() {
        this(false);
    }
    
    public b(final boolean b) {
        this.b = b;
    }
    
    public boolean a() {
        return this.b;
    }
    
    private boolean j(final fj fj) {
        final v i = this.i(fj);
        return i == null || !i.p(fj.getNode()).f();
    }
    
    public void c(final fj fj) {
        final int a = v.a;
        if (fj instanceof e) {
            final e e = (e)fj;
            if (!e.g()) {
                return;
            }
            e.b(false);
            if (e.isGroupClosed() || this.j(e)) {
                q m = this.m(fj);
                Label_0102: {
                    if (m == null) {
                        if (this.a()) {
                            final Dimension2D e2 = this.e(e);
                            m = new q(e2.getWidth(), e2.getHeight());
                            if (a == 0) {
                                break Label_0102;
                            }
                        }
                        m = new q(1.0, 1.0);
                    }
                }
                double n = e.getWidth();
                double n2 = e.getHeight();
                boolean b = false;
                if (n < m.a()) {
                    n = m.a();
                    b = true;
                }
                if (n2 < m.b()) {
                    n2 = m.b();
                    b = true;
                }
                if (!b) {
                    return;
                }
                e.setFrame(e.getX(), e.getY(), n, n2);
                if (a == 0) {
                    return;
                }
            }
            final Rectangle2D d = this.d(fj);
            fj.setFrame(d.getX(), d.getY(), d.getWidth(), d.getHeight());
        }
    }
    
    protected Rectangle2D d(final fj fj) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(fj.getX(), fj.getY(), fj.getWidth(), fj.getHeight());
        if (fj instanceof e) {
            final e e = (e)fj;
            final r borderInsets = e.getBorderInsets();
            final Rectangle2D k = this.k(fj);
            final double n = k.getX() - borderInsets.b;
            final double n2 = k.getY() - borderInsets.a;
            double max = 0.0;
            double max2 = 0.0;
            Label_0204: {
                if (this.a()) {
                    final Dimension2D e2 = this.e(e);
                    max = Math.max(k.getWidth() + borderInsets.b + borderInsets.d, e2.getWidth());
                    max2 = Math.max(k.getHeight() + borderInsets.a + borderInsets.c, e2.getHeight());
                    if (v.a == 0) {
                        break Label_0204;
                    }
                }
                max = k.getWidth() + borderInsets.b + borderInsets.d;
                max2 = k.getHeight() + borderInsets.a + borderInsets.c;
            }
            k.setFrame(n, n2, max, max2);
            return k;
        }
        return double1;
    }
    
    protected Dimension2D e(final fj fj) {
        final int a = v.a;
        final Dimension dimension = new Dimension();
        if (fj.labelCount() > 0) {
            final eR label = fj.getLabel();
            final byte autoSizePolicy = label.getAutoSizePolicy();
            double n = 0.0;
            double n2 = 0.0;
            Label_0147: {
                if (autoSizePolicy == 4) {
                    n = label.getContentWidth();
                    n2 = label.getContentHeight();
                    if (a == 0) {
                        break Label_0147;
                    }
                }
                if (autoSizePolicy != 0) {
                    final boolean offsetDirty = label.isOffsetDirty();
                    final boolean sizeDirty = label.isSizeDirty();
                    final double contentWidth = label.getContentWidth();
                    final double contentHeight = label.getContentHeight();
                    label.internalSetAutoSizePolicy((byte)0);
                    label.calculateSize();
                    n = label.getContentWidth();
                    n2 = label.getContentHeight();
                    label.internalSetAutoSizePolicy(autoSizePolicy);
                    label.setContentSize(contentWidth, contentHeight);
                    label.internalSetSizeDirty(sizeDirty);
                    label.internalSetOffsetDirty(offsetDirty);
                    if (a == 0) {
                        break Label_0147;
                    }
                }
                n = label.getContentWidth();
                n2 = label.getContentHeight();
            }
            double width = 0.0;
            double height = 0.0;
            if (fj instanceof e) {
                final bo bo = (bo)aZ.a().a(((e)fj).f(), (y.h.a.b.a == null) ? (y.h.a.b.a = a("y.h.bo")) : y.h.a.b.a);
                if (bo instanceof l) {
                    final eR d = ((l)bo).d(fj);
                    if (d != null) {
                        width = d.getWidth();
                        height = d.getHeight();
                    }
                }
            }
            dimension.setSize(n + width, Math.max(n2, height));
        }
        return dimension;
    }
    
    public Rectangle2D f(final fj fj) {
        final Rectangle2D g = this.g(fj);
        final r l = this.l(fj);
        if (g != null) {
            g.setFrame(g.getX() - l.b, g.getY() - l.a, g.getWidth() + l.b + l.d, g.getHeight() + l.a + l.c);
        }
        return g;
    }
    
    public Rectangle2D g(final fj fj) {
        final int a = v.a;
        if (!(fj instanceof e)) {
            return new Rectangle2D.Double(fj.getX(), fj.getY(), fj.getWidth(), fj.getHeight());
        }
        final e e = (e)fj;
        final r l = this.l(e);
        if (!e.isGroupClosed() && !this.j(e)) {
            final Rectangle2D.Double double1 = new Rectangle2D.Double(-1.0, -1.0, -1.0, -1.0);
            final v i = this.i(fj);
            if (i != null) {
                final y.c.q node = e.getNode();
                final bu bu = (bu)node.e();
                if (i.k(node) && i.p(node).k() > 0) {
                    final x p = i.p(node);
                    while (p.f()) {
                        this.a(bu, p.e(), double1);
                        p.g();
                        if (a != 0) {
                            break;
                        }
                    }
                    return double1;
                }
            }
            final r j = this.l(e);
            return new Rectangle2D.Double(fj.getX() + j.b, fj.getY() + j.a, fj.getWidth() - j.b - j.d, fj.getHeight() - j.a - j.c);
        }
        return new Rectangle2D.Double(fj.getX(), fj.getY(), l.b + l.d, l.a + l.c);
    }
    
    protected void a(final bu bu, final y.c.q q, final Rectangle2D rectangle2D) {
        bu.t(q).calcUnionRect(rectangle2D);
    }
    
    public r h(final fj fj) {
        final int a = v.a;
        if (fj instanceof e) {
            final e e = (e)fj;
            double height = 0.0;
            double height2 = 0.0;
            double width = 0.0;
            double width2 = 0.0;
            if (e.labelCount() > 0) {
                final eR label = e.getLabel();
                if (label.isVisible()) {
                    Label_0237: {
                        switch (label.getPosition()) {
                            case 102:
                            case 117:
                            case 118: {
                                if (label.getAutoSizePolicy() == 2 || label.getAutoSizePolicy() == 3) {
                                    break;
                                }
                                height = label.getHeight();
                                if (a != 0) {
                                    break Label_0237;
                                }
                                break;
                            }
                            case 101:
                            case 119:
                            case 120: {
                                if (label.getAutoSizePolicy() == 2 || label.getAutoSizePolicy() == 3) {
                                    break;
                                }
                                height2 = label.getHeight();
                                if (a != 0) {
                                    break Label_0237;
                                }
                                break;
                            }
                            case 115: {
                                if (label.getAutoSizePolicy() == 1 || label.getAutoSizePolicy() == 3) {
                                    break;
                                }
                                width = label.getWidth();
                                if (a != 0) {
                                    break Label_0237;
                                }
                                break;
                            }
                            case 116: {
                                if (label.getAutoSizePolicy() != 1 && label.getAutoSizePolicy() != 3) {
                                    width2 = label.getWidth();
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }
            }
            final r minimalInsets = e.getMinimalInsets();
            return new r(minimalInsets.a + height, minimalInsets.b + width, minimalInsets.c + height2, minimalInsets.d + width2);
        }
        return new r(0.0, 0.0, 0.0, 0.0);
    }
    
    protected v i(final fj fj) {
        final y.c.q node = fj.getNode();
        if (node == null) {
            return null;
        }
        return v.a(node.e());
    }
    
    public void a(final fj fj, final eR er) {
        if (this.a()) {
            if (fj instanceof e) {
                final bo bo = (bo)aZ.a().a(((e)fj).f(), (y.h.a.b.a == null) ? (y.h.a.b.a = a("y.h.bo")) : y.h.a.b.a);
                eR d = null;
                if (bo instanceof l) {
                    d = ((l)bo).d(fj);
                }
                if (er != fj.getLabel() && (d == null || er != d)) {
                    return;
                }
                fj.calcUnionRect(new Rectangle2D.Double());
                if (v.a == 0) {
                    return;
                }
            }
            fj.calcUnionRect(new Rectangle2D.Double());
        }
    }
    
    public q a(final fj fj) {
        final r l = this.l(fj);
        final double n = l.b + l.d;
        final double n2 = l.a + l.c;
        if (this.a()) {
            final Dimension2D e = this.e(fj);
            final q q = new q(Math.max(n, e.getWidth()), Math.max(n2, e.getHeight()));
            if (v.a == 0) {
                return q;
            }
        }
        if (fj instanceof e && ((e)fj).isGroupClosed()) {
            return new q(1.0, 1.0);
        }
        return new q(n, n2);
    }
    
    public q b(final fj fj) {
        return new q(2.147483647E9, 2.147483647E9);
    }
    
    private Rectangle2D k(final fj fj) {
        final a autoBoundsFeature = fj.getAutoBoundsFeature();
        if (autoBoundsFeature == null) {
            final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
            fj.calcUnionRect(double1);
            return double1;
        }
        return autoBoundsFeature.getMinimalAutoBounds();
    }
    
    private r l(final fj fj) {
        final a autoBoundsFeature = fj.getAutoBoundsFeature();
        if (autoBoundsFeature == null) {
            return new r(0.0, 0.0, 0.0, 0.0);
        }
        return autoBoundsFeature.getAutoBoundsInsets();
    }
    
    private q m(final fj fj) {
        final gt sizeConstraintProvider = fj.getSizeConstraintProvider();
        if (sizeConstraintProvider == null) {
            return null;
        }
        return sizeConstraintProvider.getMinimumSize();
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
