package y.h.a;

import y.d.*;
import y.c.*;
import y.h.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class p extends gn implements a, h, gt
{
    public static final Icon defaultClosedGroupIcon;
    public static final Icon defaultOpenGroupIcon;
    private boolean ue;
    private Icon bf;
    private Icon we;
    private boolean ze;
    private double af;
    private double pe;
    private boolean re;
    private boolean df;
    private double gf;
    private double cf;
    private double ef;
    private double te;
    private double ff;
    private double hf;
    private double xe;
    private double qe;
    private eR ve;
    private boolean se;
    private boolean ye;
    static Class class$y$view$hierarchy$AutoBoundsFeature;
    
    public p() {
        this.ze = false;
        this.af = 100.0;
        this.pe = 80.0;
        this.re = true;
        this.gf = 15.0;
        this.cf = 15.0;
        this.ef = 15.0;
        this.te = 15.0;
        this.ff = 0.0;
        this.hf = 0.0;
        this.xe = 0.0;
        this.qe = 0.0;
        this.se = false;
        this.ye = true;
        this.lb();
    }
    
    public p(final fj fj) {
        super(fj);
        this.ze = false;
        this.af = 100.0;
        this.pe = 80.0;
        this.re = true;
        this.gf = 15.0;
        this.cf = 15.0;
        this.ef = 15.0;
        this.te = 15.0;
        this.ff = 0.0;
        this.hf = 0.0;
        this.xe = 0.0;
        this.qe = 0.0;
        this.se = false;
        this.ye = true;
        if (fj instanceof h) {
            this.b((h)fj);
            if (y.h.a.v.a == 0) {
                return;
            }
        }
        this.bf = p.defaultClosedGroupIcon;
        this.we = p.defaultOpenGroupIcon;
    }
    
    private void b(final h h) {
        Label_0242: {
            if (h instanceof p) {
                final p p = (p)h;
                this.af = p.af;
                this.pe = p.pe;
                this.bf = p.bf;
                this.we = p.we;
                this.ze = p.ze;
                this.ve = p.ve;
                this.gf = p.gf;
                this.cf = p.cf;
                this.ef = p.ef;
                this.te = p.te;
                this.ff = p.ff;
                this.hf = p.hf;
                this.xe = p.xe;
                this.qe = p.qe;
                this.se = p.se;
                this.ye = p.ye;
                this.df = p.df;
                if (y.h.a.v.a == 0) {
                    break Label_0242;
                }
            }
            this.ze = h.isGroupClosed();
            final r minimalInsets = h.getMinimalInsets();
            this.gf = minimalInsets.a;
            this.cf = minimalInsets.c;
            this.ef = minimalInsets.b;
            this.te = minimalInsets.d;
            final r borderInsets = h.getBorderInsets();
            this.ff = borderInsets.a;
            this.hf = borderInsets.c;
            this.xe = borderInsets.b;
            this.qe = borderInsets.d;
        }
        if (this.ve != null) {
            (this.ve = (eR)this.ve.clone()).a(this);
        }
    }
    
    private void lb() {
        final eR label = this.getLabel();
        label.setPosition((byte)102);
        label.setFontSize(16);
        label.setBackgroundColor(Color.darkGray);
        label.setTextColor(Color.white);
        label.setAlignment((byte)2);
        label.setAutoSizePolicy((byte)1);
        label.a(0.0);
        this.bf = p.defaultClosedGroupIcon;
        this.we = p.defaultOpenGroupIcon;
    }
    
    public fj createCopy(final fj fj) {
        final p p = new p(fj);
        if (!(fj instanceof h)) {
            p.b(this);
        }
        return p;
    }
    
    public r getAutoBoundsInsets() {
        final int a = y.h.a.v.a;
        double height = 0.0;
        double height2 = 0.0;
        double width = 0.0;
        double width2 = 0.0;
        if (this.labelCount() > 0) {
            final eR label = this.getLabel();
            if (label.isVisible()) {
                Label_0224: {
                    switch (label.getPosition()) {
                        case 102:
                        case 117:
                        case 118: {
                            if (label.getAutoSizePolicy() == 2 || label.getAutoSizePolicy() == 3) {
                                break;
                            }
                            height = label.getHeight();
                            if (a != 0) {
                                break Label_0224;
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
                                break Label_0224;
                            }
                            break;
                        }
                        case 115: {
                            if (label.getAutoSizePolicy() == 1 || label.getAutoSizePolicy() == 3) {
                                break;
                            }
                            width = label.getWidth();
                            if (a != 0) {
                                break Label_0224;
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
        return new r(this.gf + height, this.ef + width, this.cf + height2, this.te + width2);
    }
    
    public void setAutoBoundsInsets(final Insets insets) {
        this.setAutoBoundsInsets(new r(insets));
    }
    
    public void setAutoBoundsInsets(final r borderInsets) {
        this.setBorderInsets(borderInsets);
    }
    
    public boolean isAutoBoundsEnabled() {
        return this.re && !this.ze;
    }
    
    public void setAutoBoundsEnabled(final boolean b) {
        if (!this.re && b) {
            if (!this.ze && !this.kb()) {
                final Rectangle2D calcMinimumInsetBounds = this.calcMinimumInsetBounds();
                final double n = calcMinimumInsetBounds.getX() + calcMinimumInsetBounds.getWidth();
                final double n2 = calcMinimumInsetBounds.getY() + calcMinimumInsetBounds.getHeight();
                this.qe = ((this.x + this.width > n) ? (this.x + this.width - n) : 0.0);
                this.ff = ((this.y < calcMinimumInsetBounds.getY()) ? (calcMinimumInsetBounds.getY() - this.y) : 0.0);
                this.hf = ((this.y + this.height > n2) ? (this.y + this.height - n2) : 0.0);
                this.xe = ((this.x < calcMinimumInsetBounds.getX()) ? (calcMinimumInsetBounds.getX() - this.x) : 0.0);
            }
            this.re = b;
            this.recalculateBounds();
            if (y.h.a.v.a == 0) {
                return;
            }
        }
        this.re = b;
    }
    
    public Rectangle2D getMinimalAutoBounds() {
        return this.calcMinimumInsetBounds();
    }
    
    public void updateAutoSizeBounds() {
        this.recalculateBounds();
    }
    
    public void setMinimalInsets(final Insets insets) {
        this.setMinimalInsets(new r(insets));
    }
    
    public void setMinimalInsets(final r r) {
        this.cf = r.c;
        this.gf = r.a;
        this.ef = r.b;
        this.te = r.d;
        this.recalculateBounds();
    }
    
    public r getMinimalInsets() {
        return new r(this.gf, this.ef, this.cf, this.te);
    }
    
    public void setBorderInsets(final Insets insets) {
        this.setBorderInsets(new r(insets));
    }
    
    public void setBorderInsets(final r r) {
        this.ff = r.a;
        this.hf = r.c;
        this.qe = r.d;
        this.xe = r.b;
        this.recalculateBounds();
    }
    
    public r getBorderInsets() {
        return new r(this.ff, this.xe, this.hf, this.qe);
    }
    
    public Icon getClosedGroupIcon() {
        return this.bf;
    }
    
    public void setClosedGroupIcon(final Icon bf) {
        this.bf = bf;
        if (this.ze) {
            this.getStateLabel().setIcon(this.bf);
        }
    }
    
    public Icon getOpenGroupIcon() {
        return this.we;
    }
    
    public void setOpenGroupIcon(final Icon we) {
        this.we = we;
        if (!this.ze) {
            this.getStateLabel().setIcon(this.we);
        }
    }
    
    public double getClosedWidth() {
        return this.af;
    }
    
    public void setClosedWidth(final double af) {
        this.af = af;
    }
    
    public double getClosedHeight() {
        return this.pe;
    }
    
    public void setClosedHeight(final double pe) {
        this.pe = pe;
    }
    
    public void setGroupClosed(final boolean ze) {
        this.getStateLabel().setIcon(ze ? this.bf : this.we);
        if (this.ze != ze) {
            this.ze = ze;
            if (ze) {
                final gt sizeConstraintProvider = this.getSizeConstraintProvider();
                if (sizeConstraintProvider != null) {
                    final double a = sizeConstraintProvider.getMinimumSize().a();
                    final double b = sizeConstraintProvider.getMinimumSize().b();
                    if (this.af < a) {
                        this.af = a;
                    }
                    if (this.pe < b) {
                        this.pe = b;
                    }
                }
                super.setFrame(this.x, this.y, this.af, this.pe);
                if (y.h.a.v.a == 0) {
                    return;
                }
            }
            this.af = this.width;
            this.pe = this.height;
            this.setBoundsDirty();
            this.recalculateBounds();
        }
    }
    
    public boolean isGroupClosed() {
        return this.ze;
    }
    
    public void setInnerGraphDisplayEnabled(final boolean se) {
        this.se = se;
    }
    
    public boolean isInnerGraphDisplayEnabled() {
        return this.se;
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if (this.ue) {
            this.recalculateBounds();
        }
        super.paintSloppy(graphics2D);
        this.paintGroupState(graphics2D, true);
    }
    
    protected void paintNode(final Graphics2D graphics2D) {
        final int a = y.h.a.v.a;
        if (this.isBoundsDirty()) {
            this.recalculateBounds();
        }
        final v hierarchyManager = this.getHierarchyManager();
        if (hierarchyManager != null) {
            final Color fillColor = this.getFillColor();
            Label_0140: {
                if (fillColor != null && this.ye) {
                    Color fillColor2 = fillColor;
                    final int o = hierarchyManager.o(this.getNode());
                    if (o > 0) {
                        fillColor2 = new Color(Math.max(fillColor.getRed() - 20 * o, 0), Math.max(fillColor.getGreen() - 20 * o, 0), Math.max(fillColor.getBlue() - 20 * o, 0), fillColor.getAlpha());
                    }
                    this.setFillColor(fillColor2);
                    this.paintShapeNode(graphics2D);
                    this.setFillColor(fillColor);
                    if (a == 0) {
                        break Label_0140;
                    }
                }
                this.paintShapeNode(graphics2D);
            }
            if (this.isGroupClosed() && this.isInnerGraphDisplayEnabled()) {
                this.paintInnerGraph(graphics2D);
            }
            this.paintGroupState(graphics2D, false);
            if (a == 0) {
                return;
            }
        }
        this.paintShapeNode(graphics2D);
    }
    
    protected void paintGroupState(final Graphics2D graphics2D, final boolean b) {
        if (f(graphics2D, b)) {
            this.getStateLabel().paint(graphics2D);
        }
    }
    
    private static boolean f(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.o);
        if (b) {
            return hk.q.equals(renderingHint);
        }
        return !hk.r.equals(renderingHint);
    }
    
    protected void paintShapeNode(final Graphics2D graphics2D) {
        super.paintNode(graphics2D);
    }
    
    public void setGroupDepthFillColorEnabled(final boolean ye) {
        this.ye = ye;
    }
    
    public boolean isGroupDepthFillColorEnabled() {
        return this.ye;
    }
    
    public void setStateLabel(final eR ve) {
        (this.ve = ve).a(this);
    }
    
    public eR getStateLabel() {
        if (this.ve == null) {
            (this.ve = new eR()).setPosition((byte)117);
            this.ve.a(1.0);
            this.ve.a(this);
        }
        return this.ve;
    }
    
    public Rectangle2D.Double getBoundingBox() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getBoundingBox();
    }
    
    private boolean kb() {
        final q node = this.getNode();
        if (node == null) {
            return true;
        }
        final v hierarchyManager = this.getHierarchyManager();
        return hierarchyManager == null || !hierarchyManager.p(node).f();
    }
    
    protected void recalculateBounds() {
        if (!this.re) {
            return;
        }
        if (!this.df && (this.ze || this.kb())) {
            return;
        }
        final Rectangle2D calcMinimumBounds = this.calcMinimumBounds();
        this.setSize(calcMinimumBounds.getWidth(), calcMinimumBounds.getHeight());
        this.setLocation(calcMinimumBounds.getX(), calcMinimumBounds.getY());
        this.ue = false;
        final gt sizeConstraintProvider = this.getSizeConstraintProvider();
        if (sizeConstraintProvider != null) {
            calcMinimumBounds.setFrame(calcMinimumBounds.getX(), calcMinimumBounds.getY(), Math.max(calcMinimumBounds.getWidth(), sizeConstraintProvider.getMinimumSize().a()), Math.max(calcMinimumBounds.getHeight(), sizeConstraintProvider.getMinimumSize().b()));
        }
        if (this.df) {
            final Dimension2D calculateMinimalLabelSize = this.calculateMinimalLabelSize();
            calcMinimumBounds.setFrame(calcMinimumBounds.getX(), calcMinimumBounds.getY(), Math.max(calcMinimumBounds.getWidth(), calculateMinimalLabelSize.getWidth()), Math.max(calcMinimumBounds.getHeight(), calculateMinimalLabelSize.getHeight()));
        }
        this.setSize(calcMinimumBounds.getWidth(), calcMinimumBounds.getHeight());
        this.setLocation(calcMinimumBounds.getX(), calcMinimumBounds.getY());
        this.ue = false;
    }
    
    protected Rectangle2D calcMinimumInsetBounds() {
        final r autoBoundsInsets = this.getAutoBoundsInsets();
        if (!this.ze && !this.kb()) {
            final Rectangle2D calcMinimumGroupBounds = this.calcMinimumGroupBounds();
            calcMinimumGroupBounds.setFrame(calcMinimumGroupBounds.getX() - autoBoundsInsets.b, calcMinimumGroupBounds.getY() - autoBoundsInsets.a, calcMinimumGroupBounds.getWidth() + autoBoundsInsets.b + autoBoundsInsets.d, calcMinimumGroupBounds.getHeight() + autoBoundsInsets.a + autoBoundsInsets.c);
            return calcMinimumGroupBounds;
        }
        return new Rectangle2D.Double(this.x, this.y, autoBoundsInsets.b + autoBoundsInsets.d, autoBoundsInsets.a + autoBoundsInsets.c);
    }
    
    protected Rectangle2D calcMinimumBounds() {
        if (!this.ze && !this.kb()) {
            final Rectangle2D calcMinimumInsetBounds = this.calcMinimumInsetBounds();
            calcMinimumInsetBounds.setFrame(calcMinimumInsetBounds.getX() - this.xe, calcMinimumInsetBounds.getY() - this.ff, calcMinimumInsetBounds.getWidth() + this.xe + this.qe, calcMinimumInsetBounds.getHeight() + this.ff + this.hf);
            return calcMinimumInsetBounds;
        }
        return new Rectangle2D.Double(this.x, this.y, this.width, this.height);
    }
    
    protected Rectangle2D calcMinimumGroupBounds() {
        final int a = y.h.a.v.a;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(-1.0, -1.0, -1.0, -1.0);
        final v hierarchyManager = this.getHierarchyManager();
        if (hierarchyManager != null) {
            final q node = this.getNode();
            final bu bu = (bu)node.e();
            if (hierarchyManager.k(node)) {
                final x p = hierarchyManager.p(node);
                while (p.f()) {
                    bu.t(p.e()).calcUnionRect(double1);
                    p.g();
                    if (a != 0) {
                        break;
                    }
                }
            }
        }
        return double1;
    }
    
    protected v getHierarchyManager() {
        final q node = this.getNode();
        if (node == null) {
            return null;
        }
        return y.h.a.v.a(node.e());
    }
    
    protected boolean isBoundsDirty() {
        return this.ue;
    }
    
    protected void setBoundsDirty() {
        this.ue = true;
    }
    
    protected void paintInnerGraph(final Graphics2D graphics2D) {
        final int a = y.h.a.v.a;
        final v hierarchyManager = this.getHierarchyManager();
        if (hierarchyManager == null) {
            return;
        }
        final q node = this.getNode();
        if (node == null || !hierarchyManager.j(node)) {
            return;
        }
        final bu bu = (bu)hierarchyManager.m(node);
        double n = this.getHeight() - this.gf - this.cf;
        double n2 = this.getWidth() - this.ef - this.te;
        double n3 = this.getX() + this.ef + 0.5 * n2;
        double n4 = this.getY() + this.gf + 0.5 * n;
        Label_0367: {
            if (this.labelCount() > 0) {
                final eR label = this.getLabel();
                if (label.isVisible()) {
                    switch (label.getModel()) {
                        case 1: {
                            Label_0343: {
                                switch (label.getPosition()) {
                                    case 102:
                                    case 117:
                                    case 118: {
                                        n -= label.getHeight();
                                        n4 += label.getHeight() / 2.0;
                                        if (a != 0) {
                                            break Label_0343;
                                        }
                                        break Label_0367;
                                    }
                                    case 101:
                                    case 119:
                                    case 120: {
                                        n -= label.getHeight();
                                        n4 -= label.getHeight() / 2.0;
                                        if (a != 0) {
                                            break Label_0343;
                                        }
                                        break Label_0367;
                                    }
                                    case 115: {
                                        n2 -= label.getWidth();
                                        n3 += label.getWidth() / 2.0;
                                        if (a != 0) {
                                            break Label_0343;
                                        }
                                        break Label_0367;
                                    }
                                    case 116: {
                                        n2 -= label.getWidth();
                                        n3 -= label.getWidth() / 2.0;
                                        break Label_0367;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        if (n2 <= 5.0 || n <= 5.0) {
            return;
        }
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.translate(n3, n4);
        final Rectangle a2 = bu.a();
        final double min = Math.min(n2 / a2.getWidth(), n / a2.getHeight());
        graphics2D.scale(min, min);
        graphics2D.translate(-a2.getCenterX(), -a2.getCenterY());
        final double n5 = min * transform.getScaleX();
        final Double n6 = (Double)graphics2D.getRenderingHint(hk.y);
        final O o = new O();
        Label_0557: {
            if (n6 == null || n5 > n6) {
                o.paint(graphics2D, bu);
                if (a == 0) {
                    break Label_0557;
                }
            }
            if (n6 == null || 4.0 * n5 > n6) {
                o.paintSloppy(graphics2D, bu);
            }
        }
        graphics2D.setTransform(transform);
    }
    
    public double getY() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getY();
    }
    
    public double getCenterX() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getCenterX();
    }
    
    public boolean contains(final double n, final double n2) {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.contains(n, n2);
    }
    
    public double getHeight() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getHeight();
    }
    
    public double getX() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getX();
    }
    
    public boolean findIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.findIntersection(n, n2, n3, n4, point2D);
    }
    
    public double getWidth() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getWidth();
    }
    
    public double getCenterY() {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.getCenterY();
    }
    
    public y.d.q getMinimumSize() {
        final int a = y.h.a.v.a;
        final r autoBoundsInsets = this.getAutoBoundsInsets();
        final double n = autoBoundsInsets.b + autoBoundsInsets.d;
        final double n2 = autoBoundsInsets.a + autoBoundsInsets.c;
        if (this.isConsiderNodeLabelSize()) {
            final Dimension2D calculateMinimalLabelSize = this.calculateMinimalLabelSize();
            final y.d.q q = new y.d.q(Math.max(n, calculateMinimalLabelSize.getWidth()), Math.max(n2, calculateMinimalLabelSize.getHeight()));
            if (a == 0) {
                return q;
            }
        }
        if (this.ze) {
            final y.d.q q = new y.d.q(1.0, 1.0);
            if (a == 0) {
                return q;
            }
        }
        return new y.d.q(n, n2);
    }
    
    public y.d.q getMaximumSize() {
        return new y.d.q(2.147483647E9, 2.147483647E9);
    }
    
    protected Dimension2D calculateMinimalLabelSize() {
        final int a = y.h.a.v.a;
        final Dimension dimension = new Dimension();
        if (this.labelCount() > 0) {
            final eR label = this.getLabel();
            final byte autoSizePolicy = label.getAutoSizePolicy();
            double n = 0.0;
            double n2 = 0.0;
            Label_0119: {
                if (autoSizePolicy == 4) {
                    n = label.getContentWidth();
                    n2 = label.getContentHeight();
                    if (a == 0) {
                        break Label_0119;
                    }
                }
                if (autoSizePolicy != 0) {
                    final double contentWidth = label.getContentWidth();
                    final double contentHeight = label.getContentHeight();
                    label.internalSetAutoSizePolicy((byte)0);
                    label.calculateSize();
                    n = label.getContentWidth();
                    n2 = label.getContentHeight();
                    label.internalSetAutoSizePolicy(autoSizePolicy);
                    label.setContentSize(contentWidth, contentHeight);
                    if (a == 0) {
                        break Label_0119;
                    }
                }
                n = label.getContentWidth();
                n2 = label.getContentHeight();
            }
            double width = 0.0;
            double height = 0.0;
            final eR stateLabel = this.getStateLabel();
            if (stateLabel != null) {
                width = stateLabel.getWidth();
                height = stateLabel.getHeight();
            }
            dimension.setSize(n + width, Math.max(n2, height));
        }
        return dimension;
    }
    
    protected void labelBoundsChanged(final eR er) {
        if (this.df && ((this.labelCount() > 0 && er == this.getLabel()) || er == this.getStateLabel())) {
            this.setBoundsDirty();
        }
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        if (!this.isGroupClosed()) {
            this.ue = true;
        }
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.intersects(n, n2, n3, n4);
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        if (!this.isGroupClosed()) {
            this.ue = true;
        }
        if (this.ue) {
            this.recalculateBounds();
        }
        super.calcUnionRect(rectangle2D);
    }
    
    public boolean findBBIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        if (this.ue) {
            this.recalculateBounds();
        }
        return super.findBBIntersection(n, n2, n3, n4, point2D);
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final int a = y.h.a.v.a;
        objectOutputStream.writeByte(4);
        super.write(objectOutputStream);
        Label_0057: {
            if (this.isGroupClosed()) {
                objectOutputStream.writeDouble(this.width);
                objectOutputStream.writeDouble(this.height);
                if (a == 0) {
                    break Label_0057;
                }
            }
            objectOutputStream.writeDouble(this.af);
            objectOutputStream.writeDouble(this.pe);
        }
        Label_0089: {
            if (this.we == p.defaultOpenGroupIcon) {
                objectOutputStream.writeBoolean(true);
                if (a == 0) {
                    break Label_0089;
                }
            }
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeObject(this.we);
        }
        Label_0121: {
            if (this.bf == p.defaultClosedGroupIcon) {
                objectOutputStream.writeBoolean(true);
                if (a == 0) {
                    break Label_0121;
                }
            }
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeObject(this.bf);
        }
        objectOutputStream.writeBoolean(this.ze);
        objectOutputStream.writeBoolean(this.se);
        objectOutputStream.writeDouble(this.gf);
        objectOutputStream.writeDouble(this.cf);
        objectOutputStream.writeDouble(this.ef);
        objectOutputStream.writeDouble(this.te);
        objectOutputStream.writeDouble(this.ff);
        objectOutputStream.writeDouble(this.hf);
        objectOutputStream.writeDouble(this.xe);
        objectOutputStream.writeDouble(this.qe);
        objectOutputStream.writeBoolean(this.ye);
        objectOutputStream.writeBoolean(this.df);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final int a = y.h.a.v.a;
        final byte byte1 = objectInputStream.readByte();
        super.read(objectInputStream);
        Label_0508: {
            switch (byte1) {
                case 0: {
                    this.af = objectInputStream.readDouble();
                    this.pe = objectInputStream.readDouble();
                    this.we = (Icon)objectInputStream.readObject();
                    this.bf = (Icon)objectInputStream.readObject();
                    this.ze = objectInputStream.readBoolean();
                    this.se = objectInputStream.readBoolean();
                    if (a != 0) {
                        break Label_0508;
                    }
                    return;
                }
                case 1: {
                    this.af = objectInputStream.readDouble();
                    this.pe = objectInputStream.readDouble();
                    this.we = (Icon)objectInputStream.readObject();
                    this.bf = (Icon)objectInputStream.readObject();
                    this.ze = objectInputStream.readBoolean();
                    this.se = objectInputStream.readBoolean();
                    this.gf = objectInputStream.readDouble();
                    this.cf = objectInputStream.readDouble();
                    this.ef = objectInputStream.readDouble();
                    this.te = objectInputStream.readDouble();
                    this.ff = objectInputStream.readDouble();
                    this.hf = objectInputStream.readDouble();
                    this.xe = objectInputStream.readDouble();
                    this.qe = objectInputStream.readDouble();
                    if (a != 0) {
                        break Label_0508;
                    }
                    return;
                }
                case 2: {
                    this.af = objectInputStream.readDouble();
                    this.pe = objectInputStream.readDouble();
                    this.we = (Icon)objectInputStream.readObject();
                    this.bf = (Icon)objectInputStream.readObject();
                    final boolean boolean1 = objectInputStream.readBoolean();
                    this.se = objectInputStream.readBoolean();
                    this.gf = objectInputStream.readDouble();
                    this.cf = objectInputStream.readDouble();
                    this.ef = objectInputStream.readDouble();
                    this.te = objectInputStream.readDouble();
                    this.ff = objectInputStream.readDouble();
                    this.hf = objectInputStream.readDouble();
                    this.xe = objectInputStream.readDouble();
                    this.qe = objectInputStream.readDouble();
                    this.ye = objectInputStream.readBoolean();
                    this.setGroupClosed(boolean1);
                    if (a != 0) {
                        break Label_0508;
                    }
                    return;
                }
                case 3: {
                    this.af = objectInputStream.readDouble();
                    this.pe = objectInputStream.readDouble();
                    this.we = (Icon)objectInputStream.readObject();
                    this.bf = (Icon)objectInputStream.readObject();
                    final boolean boolean2 = objectInputStream.readBoolean();
                    this.se = objectInputStream.readBoolean();
                    this.gf = objectInputStream.readDouble();
                    this.cf = objectInputStream.readDouble();
                    this.ef = objectInputStream.readDouble();
                    this.te = objectInputStream.readDouble();
                    this.ff = objectInputStream.readDouble();
                    this.hf = objectInputStream.readDouble();
                    this.xe = objectInputStream.readDouble();
                    this.qe = objectInputStream.readDouble();
                    this.ye = objectInputStream.readBoolean();
                    this.df = objectInputStream.readBoolean();
                    this.setGroupClosed(boolean2);
                    if (a != 0) {
                        break Label_0508;
                    }
                    return;
                }
                case 4: {
                    this.af = objectInputStream.readDouble();
                    this.pe = objectInputStream.readDouble();
                    Label_0554: {
                        if (objectInputStream.readBoolean()) {
                            this.we = p.defaultOpenGroupIcon;
                            if (a == 0) {
                                break Label_0554;
                            }
                        }
                        this.we = (Icon)objectInputStream.readObject();
                    }
                    Label_0584: {
                        if (objectInputStream.readBoolean()) {
                            this.bf = p.defaultClosedGroupIcon;
                            if (a == 0) {
                                break Label_0584;
                            }
                        }
                        this.bf = (Icon)objectInputStream.readObject();
                    }
                    final boolean boolean3 = objectInputStream.readBoolean();
                    this.se = objectInputStream.readBoolean();
                    this.gf = objectInputStream.readDouble();
                    this.cf = objectInputStream.readDouble();
                    this.ef = objectInputStream.readDouble();
                    this.te = objectInputStream.readDouble();
                    this.ff = objectInputStream.readDouble();
                    this.hf = objectInputStream.readDouble();
                    this.xe = objectInputStream.readDouble();
                    this.qe = objectInputStream.readDouble();
                    this.ye = objectInputStream.readBoolean();
                    this.df = objectInputStream.readBoolean();
                    this.setGroupClosed(boolean3);
                    if (a != 0) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new y.e.a((byte)4, byte1);
    }
    
    public void setSize(final double n, final double n2) {
        super.setSize(n, n2);
        if (this.ve != null) {
            this.ve.setOffsetDirty();
        }
    }
    
    public boolean isConsiderNodeLabelSize() {
        return this.df;
    }
    
    public void setConsiderNodeLabelSize(final boolean df) {
        this.df = df;
        this.setBoundsDirty();
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        final Class clazz = (p.class$y$view$hierarchy$AutoBoundsFeature == null) ? (p.class$y$view$hierarchy$AutoBoundsFeature = class$("y.h.a.a")) : p.class$y$view$hierarchy$AutoBoundsFeature;
        Icon defaultClosedGroupIcon2 = null;
        Icon defaultOpenGroupIcon2 = null;
        try {
            defaultClosedGroupIcon2 = new ImageIcon(clazz.getResource("resource/default_closed_group_icon.gif"));
            defaultOpenGroupIcon2 = new ImageIcon(clazz.getResource("resource/default_open_group_icon.gif"));
        }
        catch (Exception ex) {}
        if (defaultClosedGroupIcon2 == null) {
            defaultClosedGroupIcon2 = new y.h.a.q();
        }
        if (defaultOpenGroupIcon2 == null) {
            defaultOpenGroupIcon2 = new y.h.a.r();
        }
        defaultClosedGroupIcon = defaultClosedGroupIcon2;
        defaultOpenGroupIcon = defaultOpenGroupIcon2;
    }
}
