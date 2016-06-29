package y.h;

import java.awt.dnd.*;
import java.awt.geom.*;
import java.awt.image.*;
import y.c.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import java.awt.event.*;

public class bw extends JComponent implements Autoscroll
{
    private double f;
    AffineTransform a;
    private Rectangle2D.Double g;
    Point2D.Double b;
    private Rectangle h;
    private Rectangle2D.Double i;
    private Rectangle2D.Double j;
    private int k;
    private int l;
    private ch m;
    private boolean n;
    private boolean o;
    private double p;
    private double q;
    private Color r;
    private int s;
    private boolean t;
    private bB u;
    im c;
    im d;
    private w v;
    private String w;
    private cd x;
    private double y;
    private boolean z;
    private boolean A;
    private List B;
    private boolean C;
    private JTextArea D;
    Insets e;
    
    protected void processMouseEvent(final MouseEvent mouseEvent) {
        if (this.t) {
            return;
        }
        super.processMouseEvent(mouseEvent);
    }
    
    boolean a() {
        return this.t;
    }
    
    void a(final boolean t) {
        this.t = t;
    }
    
    protected boolean processKeyBinding(final KeyStroke keyStroke, final KeyEvent keyEvent, final int n, final boolean b) {
        return !this.t && super.processKeyBinding(keyStroke, keyEvent, n, b);
    }
    
    protected void processKeyEvent(final KeyEvent keyEvent) {
        if (this.t) {
            return;
        }
        super.processKeyEvent(keyEvent);
    }
    
    protected void processMouseMotionEvent(final MouseEvent mouseEvent) {
        if (this.t) {
            return;
        }
        super.processMouseMotionEvent(mouseEvent);
    }
    
    protected void processMouseWheelEvent(final MouseWheelEvent mouseWheelEvent) {
        if (this.t) {
            return;
        }
        super.processMouseWheelEvent(mouseWheelEvent);
    }
    
    bw(final ch m) {
        this.f = 1.0;
        this.a = new AffineTransform();
        this.b = new Point2D.Double();
        this.i = new Rectangle2D.Double();
        this.k = 0;
        this.l = 0;
        this.y = 0.3;
        this.A = true;
        this.B = new ArrayList(5);
        this.e = new Insets(10, 10, 10, 10);
        this.setOpaque(true);
        this.m = m;
        this.setLayout(new ig());
        this.c = new im();
        this.d = new im();
        this.q = 25.0;
        this.p = 25.0;
        this.r = Color.gray;
        this.s = 3;
        this.v = new M(this.m);
        this.x = new O();
        ToolTipManager.sharedInstance().registerComponent(this);
    }
    
    JComponent b() {
        if (this.u == null) {
            this.add(this.u = new bB());
        }
        return this.u;
    }
    
    public Image c() {
        final int y = this.y();
        final int z = this.z();
        final BufferedImage bufferedImage = new BufferedImage(y, z, 1);
        final Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setClip(0, 0, y, z);
        this.paintComponent(graphics2D);
        return bufferedImage;
    }
    
    private bu F() {
        return this.m.getGraph2D();
    }
    
    public void d() {
        if (this.k == 666) {
            this.d(true);
        }
        this.b(0, 0, this.getWidth(), this.getHeight());
    }
    
    public void a(final double n, final double n2, final double n3, final double n4) {
        final int n5 = (int)Math.floor((n - this.b.x) * this.f);
        final int n6 = (int)Math.floor((n2 - this.b.y) * this.f);
        final int n7 = (int)Math.ceil(n3 * this.f);
        final int n8 = (int)Math.ceil(n4 * this.f);
        if (this.k != 0) {
            this.repaint(n5, n6, n7, n8);
            if (!fj.z) {
                return;
            }
        }
        this.b(n5, n6, n7, n8);
    }
    
    private void b(int n, int n2, int n3, int n4) {
        final boolean z = fj.z;
        Label_0378: {
            if (this.k == 1) {
                final Rectangle a = this.F().a((byte)0);
                final Rectangle bounds = this.c.getBounds();
                final Rectangle bounds2 = this.d.getBounds();
                Rectangle h = null;
                Label_0088: {
                    if (bounds.getWidth() > 0.0) {
                        if (a.getWidth() >= 0.0) {
                            h = a.union(bounds);
                            if (!z) {
                                break Label_0088;
                            }
                        }
                        h = bounds;
                        if (!z) {
                            break Label_0088;
                        }
                    }
                    h = a;
                }
                if (bounds2.getWidth() > 0.0) {
                    h = h.union(bounds2);
                }
                if (h.getWidth() > 0.0 && this.x instanceof O) {
                    h = a(h, ((O)this.x).getClipEnlargementValue());
                }
                if (this.h != null) {
                    final Rectangle a2 = a(h, this.h);
                    final Rectangle a3 = a(a2, 8 + (int)(a2.width * 0.05));
                    this.h = h;
                    h = a3;
                }
                n = (int)Math.round((h.getX() - this.b.getX()) * this.f);
                n2 = (int)Math.round((h.getY() - this.b.getY()) * this.f);
                n3 = (int)Math.round(h.getWidth() * this.f);
                n4 = (int)Math.round(h.getHeight() * this.f);
                if (!z) {
                    break Label_0378;
                }
            }
            if (this.k == 2) {
                final Rectangle2D.Double b = b(this.i);
                if (this.j != null) {
                    Rectangle2D.union(this.i, this.j, b);
                }
                final Rectangle rectangle = new Rectangle();
                this.a(b, rectangle);
                n = rectangle.x - 2;
                n2 = rectangle.y - 2;
                n3 = rectangle.width + 4;
                n4 = rectangle.height + 4;
                this.j = b(this.i);
            }
        }
        if (this.n) {
            this.paintImmediately(n, n2, n3, n4);
            if (!z) {
                return;
            }
        }
        this.repaint(n, n2, n3, n4);
    }
    
    public void setBounds(final int n, final int n2, final int n3, final int n4) {
        if (!this.getBounds().equals(new Rectangle(n, n2, n3, n4))) {
            if (this.k == 666) {
                this.d(false);
            }
            super.setBounds(n, n2, n3, n4);
            this.m();
        }
    }
    
    public void reshape(final int n, final int n2, final int n3, final int n4) {
        if (!this.getBounds().equals(new Rectangle(n, n2, n3, n4))) {
            if (this.k == 666) {
                this.d(false);
            }
            super.reshape(n, n2, n3, n4);
            this.m();
        }
    }
    
    public void setBounds(final Rectangle bounds) {
        final Rectangle bounds2 = this.getBounds();
        super.setBounds(bounds);
        this.firePropertyChange("Bounds", bounds2, bounds);
    }
    
    public Point e() {
        return new Point((int)this.b.x, (int)this.b.y);
    }
    
    public Point2D.Double f() {
        return new Point2D.Double(this.b.x, this.b.y);
    }
    
    public void a(final double x, final double y) {
        if (!this.G()) {
            return;
        }
        final Point2D.Double f = this.f();
        if (this.j != null) {
            this.j.setFrame(this.b.x, this.b.y, this.y() / this.f, this.z() / this.f);
        }
        this.b.x = x;
        this.b.y = y;
        this.m();
        this.firePropertyChange("ViewPoint", f, this.f());
    }
    
    public void b(final double n, final double n2) {
        if (!this.G()) {
            return;
        }
        this.a(n - this.H() / (2.0 * this.f), n2 - this.I() / (2.0 * this.f));
    }
    
    public Point2D g() {
        final Point2D.Double double1 = new Point2D.Double();
        double1.setLocation(this.b.getX() + this.H() / (2.0 * this.f), this.b.getY() + this.I() / (2.0 * this.f));
        return double1;
    }
    
    public double h() {
        return this.f;
    }
    
    public void a(double f) {
        if (f <= 0.0) {
            throw new IllegalArgumentException("Zoom must be positive! was " + f);
        }
        f = Math.max(9.0E-5, f);
        f = Math.min(100001.0, f);
        if (!this.G()) {
            return;
        }
        this.a(this.b.x + this.H() * (1.0 / this.f - 1.0 / f) / 2.0, this.b.y + this.I() * (1.0 / this.f - 1.0 / f) / 2.0);
        this.firePropertyChange("Zoom", this.f, this.f = f);
        this.m();
    }
    
    public void b(final double n, final double n2, final double n3, final double n4) {
        this.a(n, n2, n3, n4, this.m.getParent() != null);
    }
    
    private void a(final double n, final double n2, final double n3, final double n4, final boolean b) {
        final double h = this.h();
        this.a(n, n2, n3, n4, this.H(), this.I());
        if (b) {
            this.m.adjustScrollBarVisibility();
            if (this.getWidth() > 0 && this.getHeight() > 0) {
                this.a(n, n2, n3, n4, this.y(), this.z());
            }
            this.m.q();
        }
        final double h2 = this.h();
        if (h2 != h) {
            this.firePropertyChange("Zoom", h, h2);
        }
    }
    
    private void a(final double n, final double n2, final double n3, final double n4, final int n5, final int n6) {
        final double n7 = n5 / this.h();
        final double n8 = n6 / this.h();
        if (n7 / n8 > n3 / n4) {
            this.f = this.f * n8 / n4;
            this.a(n - (n5 / this.f - n3) / 2.0, n2);
            if (!fj.z) {
                return;
            }
        }
        this.f = this.f * n7 / n3;
        this.a(n, n2 - (n6 / this.f - n4) / 2.0);
    }
    
    public void i() {
        this.a(this.m.calculateContentBounds());
    }
    
    public void a(final Rectangle rectangle) {
        final boolean z = fj.z;
        if (rectangle.getWidth() <= this.H() && rectangle.getHeight() <= this.I()) {
            this.a(1.0);
            Label_0093: {
                if (rectangle.getWidth() <= 0.0 || rectangle.getHeight() <= 0.0) {
                    this.a(0.0, 0.0);
                    if (!z) {
                        break Label_0093;
                    }
                }
                this.b(rectangle.getX() + rectangle.getWidth() / 2.0, rectangle.getY() + rectangle.getHeight() / 2.0);
            }
            this.l();
            if (!z) {
                return;
            }
        }
        this.a(rectangle.getX() - 10.0, rectangle.getY() - 10.0, rectangle.getWidth() + 20.0, rectangle.getHeight() + 20.0, false);
        this.l();
    }
    
    public void a(final int n, final int n2, final int n3, final int n4) {
        this.g = new Rectangle2D.Double(n, n2, n3, n4);
        this.m();
    }
    
    public void c(final double n, final double n2, final double n3, final double n4) {
        this.g = new Rectangle2D.Double(n, n2, n3, n4);
        this.m();
    }
    
    public Rectangle j() {
        if (this.g == null) {
            this.k();
        }
        return a(this.g);
    }
    
    public Rectangle2D.Double k() {
        if (this.g == null) {
            final Dimension preferredSize = this.getPreferredSize();
            this.g = new Rectangle2D.Double(0.0, 0.0, preferredSize.width, preferredSize.height);
        }
        return this.g;
    }
    
    public void l() {
        this.g.setRect(this.b.x, this.b.y, this.y() / this.h(), this.z() / this.h());
    }
    
    public void m() {
        final double n = this.y() / this.f;
        final double n2 = this.z() / this.f;
        final double x = this.b.x;
        final double y = this.b.y;
        final Rectangle2D.Double k = this.k();
        if (k.x > x) {
            final Rectangle2D.Double double1 = k;
            double1.width += k.x - x;
            k.x = x;
        }
        if (k.x + k.width < x + n) {
            k.width = x + n - k.x;
        }
        if (k.y > y) {
            final Rectangle2D.Double double2 = k;
            double2.height += k.y - y;
            k.y = y;
        }
        if (k.y + k.height < y + n2) {
            k.height = y + n2 - k.y;
        }
    }
    
    public void n() {
        final Rectangle calculateContentBounds = this.m.calculateContentBounds();
        Label_0044: {
            if (this.g == null) {
                this.g = c(calculateContentBounds);
                if (!fj.z) {
                    break Label_0044;
                }
            }
            this.g = a(this.g, c(calculateContentBounds));
        }
        this.m();
    }
    
    public void print(final Graphics graphics) {
        final boolean c = this.C;
        this.C = true;
        try {
            super.print(graphics);
        }
        finally {
            this.C = c;
        }
    }
    
    public void paintComponent(final Graphics graphics) {
        final Graphics2D graphics2D = (Graphics2D)((Graphics2D)graphics).create();
        graphics2D.addRenderingHints(this.m.getRenderingHints());
        graphics2D.setRenderingHint(hk.y, new Double(this.q()));
        if (graphics2D.getRenderingHint(hk.z) == null) {
            final cV graphicsContext = this.m.createGraphicsContext();
            if (graphicsContext.a() == null) {
                graphicsContext.a(graphics2D.getTransform());
            }
            if (!graphicsContext.b()) {
                graphicsContext.a(this.C);
            }
            graphics2D.setRenderingHint(hk.z, graphicsContext);
        }
        final double n = -this.b.getX();
        final double n2 = -this.b.getY();
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.scale(this.f, this.f);
        graphics2D.translate(n, n2);
        if (this.A) {
            gF.a(graphics2D);
        }
        this.d(graphics2D);
        final AffineTransform transform2 = graphics2D.getTransform();
        graphics2D.setTransform(transform);
        this.e(graphics2D);
        graphics2D.setTransform(transform2);
        this.b(graphics2D);
        this.c(graphics2D);
        this.a(graphics2D);
        if (this.k == 2) {
            final AffineTransform transform3 = graphics2D.getTransform();
            graphics2D.setTransform(transform);
            this.m.paintSelectionBox(graphics2D, new Rectangle2D.Double((this.i.getX() - this.b.getX()) * this.f, (this.i.getY() - this.b.getY()) * this.f, this.i.getWidth() * this.f, this.i.getHeight() * this.f));
            graphics2D.setTransform(transform3);
        }
        graphics2D.dispose();
    }
    
    private void d(final Graphics2D graphics2D) {
        final Rectangle clipBounds = graphics2D.getClipBounds();
        this.a(graphics2D, clipBounds.x, clipBounds.y, clipBounds.width, clipBounds.height);
    }
    
    private void e(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (this.z && this.f >= this.y) {
            final Color color = graphics2D.getColor();
            final Stroke stroke = graphics2D.getStroke();
            graphics2D.setColor(this.r);
            graphics2D.setStroke(new BasicStroke(1.0f));
            final Rectangle clipBounds = graphics2D.getClipBounds();
            final double n = Math.floor(this.b.x / this.p) * this.p - this.b.x;
            final double n2 = Math.floor(this.b.y / this.q) * this.q - this.b.y;
            final double n3 = n * this.f + Math.floor(-1.0 + clipBounds.x / (this.p * this.f)) * (this.p * this.f);
            final double n4 = n2 * this.f + Math.floor(-1.0 + clipBounds.y / (this.q * this.f)) * (this.q * this.f);
            final double n5 = clipBounds.x + clipBounds.width + this.p * this.f;
            final double n6 = clipBounds.y + clipBounds.height + this.q * this.f;
            final double n7 = this.p * this.f;
            final double n8 = this.q * this.f;
            Label_0645: {
                Label_0540: {
                    switch (this.s) {
                        case 1: {
                            final int y = clipBounds.y;
                            final int n9 = clipBounds.y + clipBounds.height;
                            final int x = clipBounds.x;
                            final int n10 = clipBounds.x + clipBounds.width;
                            double n11 = n3;
                            while (true) {
                                while (n11 <= n5) {
                                    final int n12 = (int)n11;
                                    graphics2D.drawLine(n12, y, n12, n9);
                                    n11 += n7;
                                    if (z) {
                                        while (n11 <= n6) {
                                            final int n13 = (int)n11;
                                            graphics2D.drawLine(x, n13, n10, n13);
                                            n11 += n8;
                                            if (z) {
                                                break Label_0645;
                                            }
                                            if (z) {
                                                break Label_0540;
                                            }
                                        }
                                        break Label_0540;
                                    }
                                    if (z) {
                                        break;
                                    }
                                }
                                n11 = n4;
                                continue;
                            }
                        }
                        case 3: {
                            double n14 = n3;
                        Label_0535_Outer:
                            while (n14 <= n5) {
                                final int n15 = (int)n14;
                                if (!z) {
                                    double n16 = n4;
                                    while (true) {
                                        while (n16 <= n6) {
                                            final int n17 = (int)n16;
                                            graphics2D.drawLine(n15, n17 - 3, n15, n17 + 3);
                                            graphics2D.drawLine(n15 - 3, n17, n15 + 3, n17);
                                            n16 += n8;
                                            if (!z) {
                                                if (z) {
                                                    break;
                                                }
                                                continue Label_0535_Outer;
                                            }
                                            else {
                                                if (z) {
                                                    break Label_0540;
                                                }
                                                continue Label_0535_Outer;
                                            }
                                        }
                                        n14 += n7;
                                        continue;
                                    }
                                }
                                break Label_0645;
                            }
                            break;
                        }
                        case 2: {
                            double n18 = n3;
                        Label_0635_Outer:
                            while (n18 <= n5) {
                                final int n19 = (int)n18;
                                if (!z) {
                                    double n20 = n4;
                                    while (true) {
                                        while (n20 <= n6) {
                                            final int n21 = (int)n20;
                                            graphics2D.drawLine(n19, n21 - 1, n19, n21 + 1);
                                            graphics2D.drawLine(n19 - 1, n21, n19 + 1, n21);
                                            n20 += n8;
                                            if (!z) {
                                                if (z) {
                                                    break;
                                                }
                                                continue Label_0635_Outer;
                                            }
                                            else {
                                                if (z) {
                                                    break Label_0540;
                                                }
                                                continue Label_0635_Outer;
                                            }
                                        }
                                        n18 += n7;
                                        continue;
                                    }
                                }
                                break Label_0645;
                            }
                            break;
                        }
                    }
                }
                graphics2D.setStroke(stroke);
            }
            graphics2D.setColor(color);
        }
    }
    
    private void a(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        final AffineTransform transform = graphics2D.getTransform();
        if (this.v != null) {
            this.v.paint(graphics2D, n, n2, n3, n4);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
        graphics2D.setTransform(transform);
    }
    
    void a(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        Label_0066: {
            if (this.h() >= this.y) {
                this.c.a(graphics2D);
                final C r = this.F().R();
                while (r.f()) {
                    ((az)r.d()).a(graphics2D);
                    r.g();
                    if (z) {
                        break Label_0066;
                    }
                }
                return;
            }
        }
        C c = this.c.m();
        while (true) {
            while (c.f()) {
                final boolean b = c.d() instanceof hG;
                if (!z) {
                    Label_0133: {
                        if (b) {
                            ((hG)c.d()).b(graphics2D);
                            if (!z) {
                                break Label_0133;
                            }
                        }
                        ((az)c.d()).a(graphics2D);
                    }
                    c.g();
                    if (z) {
                        break;
                    }
                    continue;
                }
                else {
                    while (true) {
                        if (!b) {
                            return;
                        }
                        Label_0206: {
                            if (c.d() instanceof hG) {
                                ((hG)c.d()).b(graphics2D);
                                if (!z) {
                                    break Label_0206;
                                }
                            }
                            ((az)c.d()).a(graphics2D);
                        }
                        c.g();
                        if (z) {
                            return;
                        }
                        c.f();
                        continue;
                    }
                }
            }
            c = this.F().R();
            continue;
        }
    }
    
    Collection o() {
        return new ArrayList(this.c);
    }
    
    Collection p() {
        return new ArrayList(this.d);
    }
    
    void b(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (this.h() >= this.y) {
            this.d.a(graphics2D);
            if (!z) {
                return;
            }
        }
        final C m = this.d.m();
        while (m.f()) {
            Label_0091: {
                if (m.d() instanceof hG) {
                    ((hG)m.d()).b(graphics2D);
                    if (!z) {
                        break Label_0091;
                    }
                }
                ((az)m.d()).a(graphics2D);
            }
            m.g();
            if (z) {
                break;
            }
        }
    }
    
    public void c(final Graphics2D graphics2D) {
        if (this.h() >= this.y) {
            this.x.paint(graphics2D, this.F());
            if (!fj.z) {
                return;
            }
        }
        this.x.paintSloppy(graphics2D, this.F());
    }
    
    public void b(final double y) {
        this.y = y;
    }
    
    public double q() {
        return this.y;
    }
    
    public void b(final boolean b) {
        if (b) {
            this.k = 1;
            this.h = this.F().a((byte)0);
            if (!fj.z) {
                return;
            }
        }
        this.k = 0;
        this.h = null;
    }
    
    public void a(final int l) {
        final boolean z = fj.z;
        Label_0139: {
            switch (l) {
                case 0: {
                    if (this.l == 2) {
                        this.c(false);
                        if (!z) {
                            break;
                        }
                    }
                    if (this.l == 0) {
                        break;
                    }
                    this.b(false);
                    if (z) {
                        break Label_0139;
                    }
                    break;
                }
                case 1: {
                    if (this.l == 2) {
                        this.c(false);
                    }
                    this.F().b((byte)1);
                    this.a((byte)0);
                    this.b(true);
                    if (z) {
                        break Label_0139;
                    }
                    break;
                }
                case 2: {
                    this.c(true);
                    if (z) {
                        break Label_0139;
                    }
                    break;
                }
                case 3: {
                    if (this.l == 2) {
                        this.c(false);
                    }
                    this.b(true);
                    if (z) {
                        break Label_0139;
                    }
                    break;
                }
                case 4: {
                    if (this.l == 2) {
                        this.c(false);
                    }
                    this.k = 555;
                    break;
                }
            }
        }
        this.l = l;
    }
    
    private void a(final byte b) {
        final boolean z = fj.z;
        final bu f = this.F();
        final x j = f.J();
        while (true) {
            while (j.f()) {
                final bu bu = f;
                if (z) {
                    final e k = bu.K();
                    while (true) {
                        while (k.f()) {
                            final bu bu2 = f;
                            if (z) {
                                final y m = bu2.M();
                                while (m.f()) {
                                    f.i(m.a().a()).setLayer(b);
                                    m.g();
                                    if (z) {
                                        break;
                                    }
                                }
                                return;
                            }
                            bu2.i(k.a()).setLayer(b);
                            k.g();
                            if (z) {
                                break;
                            }
                        }
                        continue;
                    }
                }
                bu.t(j.e()).setLayer(b, true);
                j.g();
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    public double c(final double n) {
        return n / this.f + this.b.x;
    }
    
    public double d(final double n) {
        return n / this.f + this.b.y;
    }
    
    public int e(final double n) {
        return (int)((n - this.b.x) * this.f);
    }
    
    public int f(final double n) {
        return (int)((n - this.b.y) * this.f);
    }
    
    Rectangle a(final Rectangle2D.Double double1, Rectangle rectangle) {
        if (rectangle == null) {
            rectangle = new Rectangle();
        }
        rectangle.setFrame((double1.getX() - this.b.getX()) * this.f, (double1.getY() - this.b.getY()) * this.f, double1.getWidth() * this.f, double1.getHeight() * this.f);
        return rectangle;
    }
    
    Point a(final Point2D.Double double1, Point point) {
        if (point == null) {
            point = new Point();
        }
        point.setLocation((double1.x - this.b.x) * this.f, (double1.y - this.b.y) * this.f);
        return point;
    }
    
    public void c(final boolean b) {
        if (this.k == 666) {
            this.d(false);
        }
        Label_0035: {
            if (b) {
                this.k = 2;
                if (!fj.z) {
                    break Label_0035;
                }
            }
            this.k = 0;
        }
        this.i.setRect(0.0, 0.0, 0.0, 0.0);
        this.j = null;
    }
    
    public void b(final Rectangle rect) {
        this.i.setRect(rect);
    }
    
    public void a(final Rectangle2D rect) {
        this.i.setRect(rect);
    }
    
    public void a(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b) {
        this.a(gz, n, n2, propertyChangeListener, b, false, true);
    }
    
    public void a(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b, final boolean b2) {
        this.a(gz, n, n2, propertyChangeListener, b, b2, true);
    }
    
    public void a(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b, final boolean b2, final boolean b3) {
        final boolean z = fj.z;
        if (this.k == 666) {
            return;
        }
        final String text = gz.getText();
        final bx d = new bx(this, text);
        d.setFont(gz.getFont());
        d.setEditable(true);
        d.setBorder(BorderFactory.createLineBorder(Color.red));
        this.a.setTransform(this.f, 0.0, 0.0, this.f, 0.0, 0.0);
        d.setFont(d.getFont().deriveFont(this.a));
        try {
            if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                final Font font = gz.getFont();
                d.setFont(new Font(font.getFontName(), font.getStyle(), (int)Math.ceil(this.f * font.getSize())));
            }
        }
        catch (SecurityException ex) {}
        d.setCaretPosition(d.getText().length());
        d.selectAll();
        d.putClientProperty("ylabel", gz);
        d.putClientProperty("pcl", propertyChangeListener);
        d.putClientProperty("oldLabelText", text);
        d.putClientProperty("commitValue", b3 ? Boolean.TRUE : Boolean.FALSE);
        d.addKeyListener(new by(this, b, d));
        d.addCaretListener(new bz(this, d));
        final bA ba = new bA(this, this.m);
        final ArrayList<gX> list = (ArrayList<gX>)new ArrayList<Object>(this.B);
        final ArrayList<gX> list2 = new ArrayList<gX>();
        d.putClientProperty("disabledViewModes", list2);
        while (true) {
            for (final gX gx : list) {
                this.b(gx);
                list2.add(gx);
                if (z) {
                    final Point a = this.a(new Point2D.Double(n, n2), null);
                    d.putClientProperty(ig.a, b2 ? Boolean.TRUE : Boolean.FALSE);
                    d.putClientProperty(ig.b, b2 ? a : new Point(a.x, a.y - 2));
                    d.putClientProperty(ig.c, null);
                    this.k = 666;
                    this.add(this.D = d);
                    this.validate();
                    d.requestFocus();
                    return;
                }
                if (z) {
                    break;
                }
            }
            this.a(ba);
            d.putClientProperty("activeViewMode", ba);
            d.putClientProperty("yvl", ba);
            continue;
        }
    }
    
    void d(final boolean b) {
        final boolean z = fj.z;
        if (this.k == 666) {
            this.k = 0;
            final JTextArea d = this.D;
            if (d != null) {
                final gZ gz = (gZ)d.getClientProperty("ylabel");
                final PropertyChangeListener propertyChangeListener = (PropertyChangeListener)d.getClientProperty("pcl");
                final Object clientProperty = d.getClientProperty("commitValue");
                final boolean b2 = !(clientProperty instanceof Boolean) || (boolean)clientProperty;
                this.remove(d);
                this.D = null;
                final gX gx = (gX)d.getClientProperty("activeViewMode");
                final List list = (List)d.getClientProperty("disabledViewModes");
                if (gx != null) {
                    this.b(gx);
                }
                Label_0266: {
                    if (list != null) {
                        final Iterator<gX> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            this.a(iterator.next());
                            if (z) {
                                break Label_0266;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    Label_0262: {
                        if (b) {
                            final String s = (String)d.getClientProperty("oldLabelText");
                            final String text = gz.getText();
                            final String text2 = d.getText();
                            if (text.equals(s) && !text2.equals(text)) {
                                if (b2) {
                                    gz.setText(text2);
                                    a(propertyChangeListener, gz, text, gz.getText());
                                    if (!z) {
                                        break Label_0262;
                                    }
                                }
                                a(propertyChangeListener, gz, text, text2);
                            }
                        }
                    }
                    this.validate();
                }
                this.d();
            }
            this.m.requestFocus();
        }
    }
    
    private static void a(final PropertyChangeListener propertyChangeListener, final gZ gz, final String s, final String s2) {
        if (propertyChangeListener != null) {
            propertyChangeListener.propertyChange(new PropertyChangeEvent(gz, "text", s, s2));
        }
    }
    
    public void a(final az az) {
        this.c.b(az);
    }
    
    public void b(final az az) {
        this.c.remove(az);
    }
    
    public void c(final az az) {
        this.d.add(az);
    }
    
    public void d(final az az) {
        this.d.remove(az);
    }
    
    public void a(final Color r) {
        this.firePropertyChange("GridColor", this.r, this.r = r);
    }
    
    public Color r() {
        return this.r;
    }
    
    public void e(final boolean o) {
        this.firePropertyChange("GridMode", this.o, this.o = o);
    }
    
    public boolean s() {
        return this.o;
    }
    
    public void b(final int s) {
        this.firePropertyChange("GridType", this.s, this.s = s);
    }
    
    public int t() {
        return this.s;
    }
    
    public void g(final double n) {
        final double p = this.p;
        this.p = n;
        this.q = n;
        this.firePropertyChange("GridResolution", p, this.p);
    }
    
    public double u() {
        return this.p;
    }
    
    private static Rectangle a(final Rectangle rectangle, int n) {
        rectangle.x -= n;
        rectangle.y -= n;
        n *= 2;
        rectangle.width += n;
        rectangle.height += n;
        return rectangle;
    }
    
    private static Rectangle a(final Rectangle2D.Double double1) {
        return new Rectangle((int)double1.x, (int)double1.y, (int)double1.width, (int)double1.height);
    }
    
    private static Rectangle2D.Double b(final Rectangle2D.Double double1) {
        return new Rectangle2D.Double(double1.x, double1.y, double1.width, double1.height);
    }
    
    private static Rectangle2D.Double c(final Rectangle rectangle) {
        return new Rectangle2D.Double(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
    
    private static Rectangle2D.Double a(final Rectangle2D.Double double1, final Rectangle2D.Double double2) {
        Rectangle2D.union(double1, double2, double1);
        return double1;
    }
    
    private static Rectangle a(final Rectangle rectangle, final Rectangle rectangle2) {
        return rectangle.union(rectangle2);
    }
    
    public Rectangle getVisibleRect() {
        return new Rectangle((int)this.b.x, (int)this.b.y, (int)(this.y() / this.h()), (int)(this.z() / this.h()));
    }
    
    public Rectangle2D.Double v() {
        return new Rectangle2D.Double(this.b.x, this.b.y, this.y() / this.h(), this.z() / this.h());
    }
    
    public cd w() {
        return this.x;
    }
    
    public void a(final cd x) {
        this.x = x;
    }
    
    private boolean G() {
        if (this.k == 2) {
            return true;
        }
        if (this.k == 1) {
            this.b(false);
            if (!fj.z) {
                return true;
            }
        }
        if (this.k != 0) {
            return false;
        }
        return true;
    }
    
    public void a(final w v) {
        this.v = v;
    }
    
    public w x() {
        return this.v;
    }
    
    public void setToolTipText(final String w) {
        this.w = w;
    }
    
    public String getToolTipText() {
        return this.w;
    }
    
    public JToolTip createToolTip() {
        if (this.m != null) {
            final JToolTip toolTip = this.m.createToolTip();
            toolTip.setComponent(this);
            return toolTip;
        }
        final il il = new il();
        il.setComponent(this);
        return il;
    }
    
    private int H() {
        return (this.m.getWidth() > 0) ? this.m.getWidth() : this.m.getPreferredSize().width;
    }
    
    private int I() {
        return (this.m.getHeight() > 0) ? this.m.getHeight() : this.m.getPreferredSize().height;
    }
    
    int y() {
        return (this.getWidth() > 0) ? this.getWidth() : this.H();
    }
    
    int z() {
        return (this.getHeight() > 0) ? this.getHeight() : this.I();
    }
    
    boolean A() {
        return this.k != 666;
    }
    
    void f(final boolean n) {
        this.n = n;
    }
    
    boolean B() {
        return this.n;
    }
    
    public boolean C() {
        return this.z;
    }
    
    public void g(final boolean z) {
        this.firePropertyChange("GridVisible", this.z, this.z = z);
    }
    
    public boolean D() {
        return this.A;
    }
    
    public void h(final boolean a) {
        this.A = a;
    }
    
    public void autoscroll(final Point point) {
        if (this.getParent() instanceof ch) {
            final int width = this.getWidth();
            final int height = this.getHeight();
            final int n = (point.x < this.e.left) ? (point.x - this.e.left) : ((point.x > width - this.e.right) ? (point.x - (width - this.e.right)) : 0);
            final int n2 = (point.y < this.e.top) ? (point.y - this.e.top) : ((point.y > height - this.e.bottom) ? (point.y - (height - this.e.bottom)) : 0);
            if (n != 0 || n2 != 0) {
                ((ch)this.getParent()).setViewPoint2D(this.b.x + n * 3.0 / this.f, this.b.y + n2 * 3.0 / this.f);
                ((ch)this.getParent()).updateView();
            }
        }
    }
    
    public Insets getAutoscrollInsets() {
        return this.e;
    }
    
    public List E() {
        return this.B;
    }
    
    public void a(final gX gx) {
        if (gx != null) {
            gx.setActiveView(this.m);
            this.addMouseListener(gx);
            this.addMouseMotionListener(gx);
            this.B.add(gx);
            gx.activate(true);
        }
    }
    
    public void b(final gX gx) {
        if (gx != null) {
            if (this.B.remove(gx)) {
                if (gx.isEditing()) {
                    gx.cancelEditing();
                }
                gx.activate(false);
            }
            this.removeMouseListener(gx);
            this.removeMouseMotionListener(gx);
        }
    }
}
