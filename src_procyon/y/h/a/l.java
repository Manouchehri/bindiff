package y.h.a;

import javax.swing.*;
import java.awt.image.*;
import java.awt.geom.*;
import y.d.*;
import y.c.*;
import y.h.*;
import java.awt.*;

public class l implements bd, bf, bj, bo
{
    private static final eR a;
    private boolean b;
    private eR c;
    private boolean d;
    private Icon e;
    private Icon f;
    private final bo g;
    
    public l() {
        this(new gm());
    }
    
    public l(final bo g) {
        this.d = true;
        this.e = p.defaultClosedGroupIcon;
        this.f = p.defaultOpenGroupIcon;
        this.g = g;
    }
    
    public void a(final fj fj, final Graphics2D graphics2D) {
        this.g.a(fj, graphics2D);
        if (fj instanceof h && ((h)fj).isGroupClosed() && this.b) {
            this.b(fj, graphics2D);
        }
        this.a(fj, graphics2D, false);
    }
    
    public void e(final fj fj, final Graphics2D graphics2D) {
        this.g.e(fj, graphics2D);
        this.a(fj, graphics2D, true);
    }
    
    protected void a(final fj fj, final Graphics2D graphics2D, final boolean b) {
        synchronized (this) {
            if (!hk.r.equals(graphics2D.getRenderingHint(hk.o))) {
                final float b2 = this.b(fj);
                if (b2 >= 1.0f) {
                    this.d(fj).paint(graphics2D);
                    if (v.a == 0) {
                        return;
                    }
                }
                if (b2 > 0.0f) {
                    final eR d = this.d(fj);
                    final y box = d.getBox();
                    final BufferedImage bufferedImage = new BufferedImage((int)Math.ceil(box.c + box.a) - (int)Math.floor(box.c), (int)Math.ceil(box.d + box.b) - (int)Math.floor(box.d), 2);
                    final Graphics2D graphics = bufferedImage.createGraphics();
                    graphics.translate(-box.c, -box.d);
                    d.paint(graphics);
                    graphics.dispose();
                    final Composite composite = graphics2D.getComposite();
                    final AffineTransform transform = graphics2D.getTransform();
                    graphics2D.translate(box.c, box.d);
                    graphics2D.setComposite(AlphaComposite.getInstance(3, b2));
                    graphics2D.drawImage(bufferedImage, 0, 0, null);
                    graphics2D.setTransform(transform);
                    graphics2D.setComposite(composite);
                }
            }
        }
    }
    
    protected float b(final fj fj) {
        if (fj instanceof aZ) {
            final Object a = ((aZ)fj).a("y.view.hierarchy.GroupNodePainter.GROUP_STATE_STYLE");
            if (a instanceof o) {
                return ((o)a).a();
            }
        }
        return 1.0f;
    }
    
    protected void b(final fj fj, final Graphics2D graphics2D) {
        final int a = v.a;
        final q node = fj.getNode();
        final v a2 = this.a(node.e());
        if (a2 == null) {
            return;
        }
        if (!a2.j(node)) {
            return;
        }
        final bu bu = (bu)a2.m(node);
        final r c = this.c(fj);
        double n = fj.getHeight() - c.a - c.c;
        double n2 = fj.getWidth() - c.b - c.d;
        double n3 = fj.getX() + c.b + 0.5 * n2;
        double n4 = fj.getY() + c.a + 0.5 * n;
        if (fj.labelCount() > 0) {
            final eR label = fj.getLabel();
            if (label.isVisible()) {
                switch (label.getModel()) {
                    case 1: {
                        Label_0359: {
                            switch (label.getPosition()) {
                                case 102:
                                case 117:
                                case 118: {
                                    n -= label.getHeight();
                                    n4 += label.getHeight() / 2.0;
                                    if (a != 0) {
                                        break Label_0359;
                                    }
                                    break;
                                }
                                case 101:
                                case 119:
                                case 120: {
                                    n -= label.getHeight();
                                    n4 -= label.getHeight() / 2.0;
                                    if (a != 0) {
                                        break Label_0359;
                                    }
                                    break;
                                }
                                case 115: {
                                    n2 -= label.getWidth();
                                    n3 += label.getWidth() / 2.0;
                                    if (a != 0) {
                                        break Label_0359;
                                    }
                                    break;
                                }
                                case 116: {
                                    n2 -= label.getWidth();
                                    n3 -= label.getWidth() / 2.0;
                                    if (a != 0) {
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        if (n2 <= 5.0 || n <= 5.0) {
            return;
        }
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.translate(n3, n4);
        final Rectangle a3 = bu.a();
        final double min = Math.min(n2 / a3.getWidth(), n / a3.getHeight());
        graphics2D.scale(min, min);
        graphics2D.translate(-a3.getCenterX(), -a3.getCenterY());
        final double n5 = min * transform.getScaleX();
        final Double n6 = (Double)graphics2D.getRenderingHint(hk.y);
        final O o = new O();
        Label_0567: {
            if (n6 == null || n5 > n6) {
                o.paint(graphics2D, bu);
                if (a == 0) {
                    break Label_0567;
                }
            }
            if (4.0 * n5 > n6) {
                o.paintSloppy(graphics2D, bu);
            }
        }
        graphics2D.setTransform(transform);
    }
    
    protected r c(final fj fj) {
        if (fj instanceof h) {
            return ((h)fj).getMinimalInsets();
        }
        return new r(15.0, 15.0, 15.0, 15.0);
    }
    
    protected eR d(final fj fj) {
        final int a = v.a;
        if (this.c == null) {
            (this.c = new eR()).setPosition((byte)117);
            this.c.a(1.0);
        }
        this.c.a((fj)null);
        Label_0142: {
            if (fj instanceof h) {
                if (((h)fj).isGroupClosed()) {
                    if (this.c.getIcon() == this.e) {
                        break Label_0142;
                    }
                    this.c.setIcon(this.e);
                    if (a == 0) {
                        break Label_0142;
                    }
                }
                if (this.c.getIcon() == this.f) {
                    break Label_0142;
                }
                this.c.setIcon(this.f);
                if (a == 0) {
                    break Label_0142;
                }
            }
            if (this.c.getIcon() != null) {
                this.c.setIcon(null);
            }
        }
        this.c.a(fj);
        return this.c;
    }
    
    protected v a(final i i) {
        return v.a(i);
    }
    
    public dx a(final fj fj, final ch ch, final double n, final double n2, final cW cw) {
        if (!(fj instanceof e)) {
            return null;
        }
        if (this.d(fj).contains(n, n2)) {
            return new m(this, fj, ch);
        }
        return null;
    }
    
    public void a(final fj fj) {
        if (fj instanceof e) {
            final eR label = ((e)fj).getLabel();
            if (label != null && this.a(label)) {
                label.setPosition((byte)102);
                label.setFontSize(16);
                label.setBackgroundColor(Color.darkGray);
                label.setTextColor(Color.white);
                label.setAlignment((byte)2);
                label.setAutoSizePolicy((byte)1);
                label.a(0.0);
            }
        }
    }
    
    private boolean a(final eR er) {
        return l.a.getAlignment() == er.getAlignment() & l.a.getAutoSizePolicy() == er.getAutoSizePolicy() & a(l.a.getBackgroundColor(), er.getBackgroundColor(), false) & a(l.a.getBox(), er.getBox(), false) & a(l.a.getConfiguration(), er.getConfiguration(), false) & l.a.getContentHeight() == er.getContentHeight() & l.a.getContentWidth() == er.getContentWidth() & l.a.e() == er.e() & a(l.a.getFont(), er.getFont(), false) & l.a.getHeight() == er.getHeight() & l.a.getHorizontalTextPosition() == er.getHorizontalTextPosition() & a(l.a.getIcon(), er.getIcon(), false) & a(l.a.getIconBox(), er.getIconBox(), false) & l.a.getIconTextGap() == er.getIconTextGap() & a(l.a.getInsets(), er.getInsets(), false) & a(l.a.a(), er.a(), true) & a(l.a.getLineColor(), er.getLineColor(), false) & l.a.getModel() == er.getModel() & a(l.a.getModelParameter(), er.getModelParameter(), true) & a(l.a.getOffset(), er.getOffset(), false) & l.a.getPosition() == er.getPosition() & l.a.getRotationAngle() == er.getRotationAngle() & a(l.a.getText(), er.getText(), false) & a(l.a.getTextColor(), er.getTextColor(), false) & a(l.a.getTextBox(), er.getTextBox(), false) & a(l.a.getUserData(), er.getUserData(), true) & l.a.getVerticalTextPosition() == er.getVerticalTextPosition() & l.a.getWidth() == er.getWidth();
    }
    
    private static boolean a(Object class1, Object class2, final boolean b) {
        if (b) {
            if (class1 != null) {
                class1 = class1.getClass();
            }
            if (class2 != null) {
                class2 = class2.getClass();
            }
        }
        return class1 == class2 || (class1 != null && class1.equals(class2));
    }
    
    public boolean a(final fj fj, final double n, final double n2) {
        if (this.g instanceof bd) {
            if (((bd)this.g).a(fj, n, n2)) {
                return true;
            }
        }
        else if (n >= fj.getX() && n <= fj.getX() + fj.getWidth() && n2 >= fj.getY() && n2 <= fj.getY() + fj.getHeight()) {
            return true;
        }
        return fj.labelCount() > 0 && fj.getLabel().contains(n, n2);
    }
    
    static {
        a = new e().getLabel();
    }
}
