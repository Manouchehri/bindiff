package y.h;

import y.g.*;
import y.d.*;
import y.c.*;
import java.awt.geom.*;
import javax.swing.event.*;
import java.beans.*;
import java.awt.*;
import java.util.*;
import y.b.*;
import java.awt.event.*;
import javax.swing.*;
import y.f.*;

public class ch extends JComponent implements ScrollPaneConstants, c, gI, gU
{
    public static final int NORMAL_MODE = 0;
    public static final int MOVE_SELECTION_MODE = 1;
    public static final int SELECTION_BOX_MODE = 2;
    public static final int LAYER_MODE = 3;
    public static final int UNBUFFERED_MODE = 4;
    public static final byte FG_LAYER = 0;
    public static final byte BG_LAYER = 1;
    public static final int CONTENT_POLICY_GRAPH = 0;
    public static final int CONTENT_POLICY_GRAPH_DRAWABLES = 1;
    public static final int CONTENT_POLICY_FOREGROUND_DRAWABLES = 2;
    public static final int CONTENT_POLICY_BACKGROUND_DRAWABLES = 4;
    private gV oc;
    private bw ic;
    private bu fc;
    private cZ nc;
    private JScrollBar mc;
    private JScrollBar qc;
    private int hc;
    private int ec;
    private if pc;
    private boolean sc;
    private boolean lc;
    private JPanel gc;
    private int rc;
    private cl jc;
    private RenderingHints kc;
    
    public ch() {
        this(new bu());
    }
    
    public ch(final bu bu) {
        this.hc = 20;
        this.ec = 30;
        this.b(bu);
        this.setViewControl(new gV(this));
    }
    
    public ch(final bu bu, final gV viewControl) {
        this.hc = 20;
        this.ec = 30;
        this.b(bu);
        if (viewControl != null) {
            this.setViewControl(viewControl);
        }
    }
    
    private void b(final bu fc) {
        this.putClientProperty("UnitIncrementPixels", new Integer(20));
        (this.fc = fc).b(this);
        this.nc = new cY(this);
        this.jc = new cl(null);
        (this.ic = this.u()).addMouseListener(this.jc);
        this.ic.addMouseMotionListener(this.jc);
        final ck ck = new ck(this);
        (this.qc = new JScrollBar(0)).addAdjustmentListener(ck);
        (this.mc = new JScrollBar(1)).addAdjustmentListener(ck);
        this.setLayout(this.pc = new if());
        this.gc = this.createGlassPane();
        if (this.gc != null) {
            this.add(this.gc, "GLASS_PANE");
        }
        this.add(this.ic, "CANVAS");
        this.add(this.mc, "VERTICAL_SCROLLBAR");
        this.add(this.qc, "HORIZONTAL_SCROLLBAR");
        final JPanel panel = new JPanel();
        this.add(panel, "CORNER_COMPONENT");
        if (this.gc != null) {
            this.gc.setPreferredSize(this.pc.preferredLayoutSize(this));
        }
        this.setOpaque(this.mc.isOpaque() && this.qc.isOpaque() && panel.isOpaque() && this.ic.isOpaque());
        this.setPreferredSize(new Dimension(480, 480));
        (this.kc = new RenderingHints(new HashMap<RenderingHints.Key, Object>())).put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        this.registerDefaultViewActions();
    }
    
    public boolean isOptimizedDrawingEnabled() {
        return this.gc == null || this.gc.getComponentCount() == 0;
    }
    
    protected void registerDefaultViewActions() {
        final boolean z = fj.z;
        ActionMap actionMap = this.getCanvasComponent().getActionMap();
        if (actionMap == null) {
            actionMap = new ActionMap();
            this.getCanvasComponent().setActionMap(actionMap);
        }
        final ActionMap v = new cm(this).v();
        final Object[] keys = v.keys();
        int i = 0;
        while (i < keys.length) {
            final Object o = keys[i];
            if (actionMap.get(o) == null) {
                actionMap.put(o, v.get(o));
            }
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    bw u() {
        return new bw(this);
    }
    
    MouseEvent p() {
        return this.jc.a;
    }
    
    protected JPanel createGlassPane() {
        final ci ci = new ci(this);
        ci.setOpaque(false);
        ci.setBackground(null);
        return ci;
    }
    
    public JPanel getGlassPane() {
        return this.gc;
    }
    
    public void fitWorldRect() {
        this.ic.l();
    }
    
    public void setFitContentOnResize(final boolean lc) {
        this.lc = lc;
    }
    
    public boolean getFitContentOnResize() {
        return this.lc;
    }
    
    public void setBounds(final int n, final int n2, final int n3, final int n4) {
        o.a(this, ">>>setBounds");
        super.setBounds(n, n2, n3, n4);
        o.a(this, "<<<setBounds");
    }
    
    public void setViewControl(final gV oc) {
        if (this.oc != null) {
            this.oc.a();
        }
        (this.oc = oc).a(this);
    }
    
    public gV getViewControl() {
        return this.oc;
    }
    
    public int getHorizontalScrollBarPolicy() {
        return this.ec;
    }
    
    public int getVerticalScrollBarPolicy() {
        return this.hc;
    }
    
    public void setHorizontalScrollBarPolicy(final int ec) {
        this.ec = ec;
    }
    
    public void setVerticalScrollBarPolicy(final int hc) {
        this.hc = hc;
    }
    
    public void setScrollBarPolicy(final int hc, final int ec) {
        this.hc = hc;
        this.ec = ec;
    }
    
    void q() {
        this.sc = true;
        final Rectangle j = this.ic.j();
        final int x = j.x;
        this.qc.setValues((int)this.ic.b.x, (int)(this.ic.getWidth() / this.getZoom()), x, x + j.width);
        final int y = j.y;
        this.mc.setValues((int)this.ic.b.y, (int)(this.ic.getHeight() / this.getZoom()), y, y + j.height);
        this.mc.setBlockIncrement(this.mc.getVisibleAmount() / 2);
        this.qc.setBlockIncrement(this.qc.getVisibleAmount() / 2);
        final Object clientProperty = this.getClientProperty("UnitIncrementPixels");
        if (clientProperty instanceof Number) {
            final int n = (int)(((Number)clientProperty).intValue() / this.getZoom());
            if (n > 0) {
                this.mc.setUnitIncrement(n);
                this.qc.setUnitIncrement(n);
            }
        }
        this.sc = false;
    }
    
    public boolean adjustScrollBarVisibility() {
        final boolean a = this.pc.a(this);
        if (a) {
            this.doLayout();
        }
        return a;
    }
    
    void b(final int n, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final JScrollBar b5 = this.b(b2, b3);
        if (b5.isVisible()) {
            final int n2 = n * b(b5, b, b4);
            if (b4) {
                b5.setValue(Math.max(b5.getMinimum(), b5.getValue() + n2));
                if (!fj.z) {
                    return;
                }
            }
            b5.setValue(Math.min(b5.getMaximum() - b5.getModel().getExtent(), b5.getValue() + n2));
        }
    }
    
    private JScrollBar b(final boolean b, final boolean b2) {
        if (b2) {
            return b ? this.qc : this.mc;
        }
        final JScrollBar qc = this.qc;
        final JScrollBar mc = this.mc;
        if (mc.isVisible()) {
            if (qc.isVisible()) {
                return b ? qc : mc;
            }
            return mc;
        }
        else {
            if (qc.isVisible()) {
                return qc;
            }
            return b ? qc : mc;
        }
    }
    
    private static int b(final JScrollBar scrollBar, final boolean b, final boolean b2) {
        if (b) {
            return scrollBar.getBlockIncrement(b2 ? -1 : 1);
        }
        return scrollBar.getUnitIncrement(b2 ? -1 : 1);
    }
    
    static ch b(final Object o) {
        if (o instanceof bw) {
            final Container parent = ((bw)o).getParent();
            if (parent instanceof ch) {
                return (ch)parent;
            }
        }
        return null;
    }
    
    public boolean isValidateRoot() {
        return false;
    }
    
    protected cV createGraphicsContext() {
        final cV cv = new cV();
        cv.a(this);
        cv.b(SwingUtilities.getRoot(this) == null);
        return cv;
    }
    
    public void addViewMode(final gX gx) {
        if (gx != null) {
            this.r().a(gx);
            if (!fj.z) {
                return;
            }
        }
        throw new NullPointerException();
    }
    
    public void removeViewMode(final gX gx) {
        if (gx != null) {
            this.r().b(gx);
            if (!fj.z) {
                return;
            }
        }
        throw new NullPointerException();
    }
    
    public Iterator getViewModes() {
        return Collections.unmodifiableList((List<?>)this.r().E()).iterator();
    }
    
    public boolean isInputSuppressed() {
        return this.ic.a();
    }
    
    public void setInputSuppressed(final boolean b) {
        this.ic.a(b);
    }
    
    public void setGridMode(final boolean b) {
        this.ic.e(b);
    }
    
    public void setGridVisible(final boolean b) {
        this.ic.g(b);
    }
    
    public boolean getGridMode() {
        return this.ic.s();
    }
    
    public boolean isGridVisible() {
        return this.ic.C();
    }
    
    public void setGridResolution(final double n) {
        this.ic.g(n);
    }
    
    public double getGridResolution() {
        return this.ic.u();
    }
    
    public void setGridType(final int n) {
        this.ic.b(n);
    }
    
    public int getGridType() {
        return this.ic.t();
    }
    
    public void setGridColor(final Color color) {
        this.ic.a(color);
    }
    
    public Color getGridColor() {
        return this.ic.r();
    }
    
    public void setWorldRect(final int n, final int n2, final int n3, final int n4) {
        this.ic.a(n, n2, n3, n4);
    }
    
    public Rectangle getWorldRect() {
        return this.ic.j();
    }
    
    public void setWorldRect2D(final double n, final double n2, final double n3, final double n4) {
        this.ic.c(n, n2, n3, n4);
    }
    
    public Rectangle2D getWorldRect2D() {
        return this.ic.k();
    }
    
    public JComponent getCanvasComponent() {
        return this.ic;
    }
    
    bw r() {
        return this.ic;
    }
    
    public Image getImage() {
        return this.ic.c();
    }
    
    public void fitContent() {
        this.fitContent(false);
    }
    
    public void fitContent(final boolean b) {
        final boolean z = fj.z;
        if (b) {
            final int verticalScrollBarPolicy = this.getVerticalScrollBarPolicy();
            final int horizontalScrollBarPolicy = this.getHorizontalScrollBarPolicy();
            if (verticalScrollBarPolicy == 20) {
                this.setVerticalScrollBarPolicy(21);
            }
            if (horizontalScrollBarPolicy == 30) {
                this.setHorizontalScrollBarPolicy(31);
            }
            double n = 1.0;
            final Point2D.Double double1 = new Point2D.Double(0.0, 0.0);
            final double n2 = this.getWidth();
            final double n3 = this.getHeight();
            final Rectangle calculateContentBounds = this.calculateContentBounds();
            final double x = calculateContentBounds.getX();
            final double y = calculateContentBounds.getY();
            final double width = calculateContentBounds.getWidth();
            final double height = calculateContentBounds.getHeight();
            Label_0251: {
                if (width <= n2 && height <= n3) {
                    if (width <= 0.0 || height <= 0.0) {
                        break Label_0251;
                    }
                    double1.setLocation(x + 0.5 * width, y + 0.5 * height);
                    if (!z) {
                        break Label_0251;
                    }
                }
                final double n4 = x - 10.0;
                final double n5 = y - 10.0;
                final double n6 = width + 20.0;
                final double n7 = height + 20.0;
                Label_0228: {
                    if (n2 / n3 > n6 / n7) {
                        n = n3 / n7;
                        if (!z) {
                            break Label_0228;
                        }
                    }
                    n = n2 / n6;
                }
                double1.setLocation(n4 + 0.5 * n6, n5 + 0.5 * n7);
            }
            this.focusView(n, double1, true);
            this.fitWorldRect();
            if (verticalScrollBarPolicy == 20) {
                this.setVerticalScrollBarPolicy(20);
            }
            if (horizontalScrollBarPolicy != 30) {
                return;
            }
            this.setHorizontalScrollBarPolicy(30);
            if (!z) {
                return;
            }
        }
        this.ic.i();
    }
    
    public int getContentPolicy() {
        return this.rc;
    }
    
    public void setContentPolicy(final int rc) {
        this.rc = rc;
    }
    
    public Rectangle calculateContentBounds() {
        final boolean z = fj.z;
        final Rectangle a = this.fc.a();
        Label_0097: {
            if ((this.rc & 0x1) != 0x0) {
                final C r = this.fc.R();
                while (r.f()) {
                    e.a(a, ((az)r.d()).getBounds(), a);
                    r.g();
                    if (z) {
                        break Label_0097;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if ((this.rc & 0x2) != 0x0) {
                e.a(a, this.ic.c.getBounds(), a);
            }
        }
        if ((this.rc & 0x4) != 0x0) {
            e.a(a, this.ic.d.getBounds(), a);
        }
        return a;
    }
    
    public void fitRectangle(final Rectangle rectangle) {
        this.ic.a(rectangle);
    }
    
    public Dimension getCanvasSize() {
        return new Dimension(this.ic.y(), this.ic.z());
    }
    
    public void paintVisibleContent(final Graphics2D graphics2D) {
        final AffineTransform transform = graphics2D.getTransform();
        final Shape clip = graphics2D.getClip();
        graphics2D.clipRect(0, 0, this.ic.y(), this.ic.z());
        this.ic.paintComponent(graphics2D);
        graphics2D.setTransform(transform);
        graphics2D.setClip(clip);
    }
    
    public void setCenter(final double n, final double n2) {
        this.ic.b(n, n2);
    }
    
    public Point2D getCenter() {
        return this.ic.g();
    }
    
    public Dimension getViewSize() {
        return this.ic.getSize();
    }
    
    public void updateView() {
        this.q();
        this.adjustScrollBarVisibility();
        this.ic.d();
    }
    
    public void updateView(final Rectangle2D rectangle2D) {
        this.updateView(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }
    
    public void updateView(final double n, final double n2, final double n3, final double n4) {
        this.q();
        this.adjustScrollBarVisibility();
        this.ic.a(n, n2, n3, n4);
    }
    
    void j(final Graphics2D graphics2D) {
        this.r().a(graphics2D);
    }
    
    void k(final Graphics2D graphics2D) {
        this.r().b(graphics2D);
    }
    
    void l(final Graphics2D graphics2D) {
        this.r().c(graphics2D);
    }
    
    protected void paintSelectionBox(final Graphics2D graphics2D, final Rectangle2D frame) {
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        RectangularShape rectangularShape = frame;
        final Object clientProperty = this.getClientProperty("selectionbox.rectangularshape");
        if (clientProperty instanceof RectangularShape) {
            rectangularShape = (RectangularShape)clientProperty;
            rectangularShape.setFrame(frame);
        }
        final Object clientProperty2 = this.getClientProperty("selectionbox.fillcolor");
        if (clientProperty2 instanceof Color) {
            graphics2D.setColor((Color)clientProperty2);
            graphics2D.fill(rectangularShape);
        }
        final Object clientProperty3 = this.getClientProperty("selectionbox.stroke");
        final Stroke stroke2 = (clientProperty3 instanceof Stroke) ? ((Stroke)clientProperty3) : new BasicStroke();
        final Object clientProperty4 = this.getClientProperty("selectionbox.linecolor");
        final Color color2 = (Color)((clientProperty4 instanceof Color) ? clientProperty4 : Color.BLACK);
        graphics2D.setStroke(stroke2);
        graphics2D.setColor(color2);
        graphics2D.draw(rectangularShape);
        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);
    }
    
    public void updateWorldRect() {
        this.ic.n();
    }
    
    public double getZoom() {
        return this.ic.h();
    }
    
    public void setZoom(final double n) {
        this.ic.a(n);
    }
    
    public void zoomToArea(final double n, final double n2, final double n3, final double n4) {
        this.ic.b(n, n2, n3, n4);
    }
    
    public void setViewCursor(final Cursor cursor) {
        if (this.ic.getCursor() != cursor) {
            this.ic.setCursor(cursor);
            if (this.gc != null) {
                this.gc.setCursor(cursor);
            }
        }
    }
    
    public Cursor getViewCursor() {
        return this.ic.getCursor();
    }
    
    public bu getGraph2D() {
        return this.fc;
    }
    
    public void setGraph2D(final bu fc) {
        if (fc != this.fc) {
            this.fc.c(this);
            final bu fc2 = this.fc;
            (this.fc = fc).b(this);
            this.firePropertyChange("Graph2D", fc2, fc);
        }
    }
    
    public cZ getHitInfoFactory() {
        return this.nc;
    }
    
    public void setHitInfoFactory(final cZ nc) {
        this.nc = nc;
    }
    
    public void setDrawingMode(final int n) {
        this.ic.a(n);
    }
    
    public void setSelectionBoxBounds(final Rectangle rectangle) {
        this.ic.b(rectangle);
    }
    
    public void setSelectionBoxBounds2D(final Rectangle2D rectangle2D) {
        this.ic.a(rectangle2D);
    }
    
    public void showPopup(final JPopupMenu popupMenu, final double n, final double n2) {
        if (popupMenu == null) {
            return;
        }
        if (this.gc != null && this.gc.isVisible()) {
            final boolean b = this.gc.getMouseListeners().length == 0;
            if (b) {
                this.gc.addMouseListener(this.jc);
            }
            final boolean b2 = this.gc.getMouseMotionListeners().length == 0;
            if (b2) {
                this.gc.addMouseMotionListener(this.jc);
            }
            popupMenu.addPopupMenuListener(new cj(this, popupMenu, b2, b));
        }
        popupMenu.show(this.ic, this.ic.e(n) + 1, this.ic.f(n2) + 1);
    }
    
    public Frame getFrame() {
        final boolean z = fj.z;
        Container container = this.getParent();
        while (container != null) {
            if (container instanceof Frame) {
                return (Frame)container;
            }
            container = container.getParent();
            if (z) {
                break;
            }
        }
        return null;
    }
    
    public void closeLabelEditor(final boolean b) {
        this.ic.d(b);
    }
    
    public void openLabelEditor(final gZ gz, final double n, final double n2) {
        this.ic.a(gz, n, n2, null, false);
    }
    
    public void openLabelEditor(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener) {
        this.ic.a(gz, n, n2, propertyChangeListener, false);
    }
    
    public void openLabelEditor(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b) {
        this.ic.a(gz, n, n2, propertyChangeListener, b);
    }
    
    public void openLabelEditor(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b, final boolean b2) {
        this.ic.a(gz, n, n2, propertyChangeListener, b, false, b2);
    }
    
    public void openLabelEditorCentered(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b) {
        this.ic.a(gz, n, n2, propertyChangeListener, b, true);
    }
    
    public void openLabelEditorCentered(final gZ gz, final double n, final double n2, final PropertyChangeListener propertyChangeListener, final boolean b, final boolean b2) {
        this.ic.a(gz, n, n2, propertyChangeListener, b, true, b2);
    }
    
    public Component getComponent() {
        return this;
    }
    
    public Rectangle getVisibleRect() {
        return this.ic.getVisibleRect();
    }
    
    public Rectangle2D getVisibleRect2D() {
        return this.ic.v();
    }
    
    public void print(final Graphics graphics) {
        this.ic.print(graphics);
    }
    
    public void setViewPoint(final int n, final int n2) {
        this.ic.a(n, n2);
    }
    
    public void setViewPoint2D(final double n, final double n2) {
        this.ic.a(n, n2);
    }
    
    public Point getViewPoint() {
        return this.ic.e();
    }
    
    public Point2D getViewPoint2D() {
        return this.ic.f();
    }
    
    JComponent s() {
        return this.ic.b();
    }
    
    public gI getCurrentView() {
        return this;
    }
    
    public void addViewChangeListener(final gT gt) {
    }
    
    public void addDrawable(final az az) {
        this.r().a(az);
    }
    
    public Collection getDrawables() {
        return this.r().o();
    }
    
    public void removeDrawable(final az az) {
        this.r().b(az);
    }
    
    public void addBackgroundDrawable(final az az) {
        this.r().c(az);
    }
    
    public Collection getBackgroundDrawables() {
        return this.r().p();
    }
    
    public void removeBackgroundDrawable(final az az) {
        this.r().d(az);
    }
    
    public cd getGraph2DRenderer() {
        return this.ic.w();
    }
    
    public void setGraph2DRenderer(final cd cd) {
        this.ic.a(cd);
    }
    
    public void setPaintDetailThreshold(final double n) {
        this.ic.b(n);
    }
    
    public double getPaintDetailThreshold() {
        return this.ic.q();
    }
    
    public int toViewCoordX(final double n) {
        return this.ic.e(n);
    }
    
    public int toViewCoordY(final double n) {
        return this.ic.f(n);
    }
    
    public double toWorldCoordX(final int n) {
        return this.ic.c(n);
    }
    
    public double toWorldCoordY(final int n) {
        return this.ic.d(n);
    }
    
    public void setBackgroundRenderer(final w w) {
        this.ic.a(w);
    }
    
    public w getBackgroundRenderer() {
        return this.ic.x();
    }
    
    public void animationPerformed(final a a) {
        switch (a.a()) {
            case 0: {
                final Object source = a.getSource();
                final boolean b = source instanceof y.b.e && ((y.b.e)source).b() && ((y.b.e)source).a();
                final boolean b2 = this.r().B();
                if (b) {
                    this.r().f(true);
                }
                this.updateView();
                if (b) {
                    this.r().f(b2);
                    break;
                }
                break;
            }
        }
    }
    
    public boolean isFocusTraversable() {
        return true;
    }
    
    public void setToolTipText(final String toolTipText) {
        this.ic.setToolTipText(toolTipText);
    }
    
    public JToolTip createToolTip() {
        final il il = new il();
        il.setComponent(this);
        return il;
    }
    
    public void focusView(final double zoom, final Point2D point2D, final boolean b) {
        if (b) {
            this.b(this.b(zoom, point2D));
            if (!fj.z) {
                return;
            }
        }
        this.setCenter(point2D.getX(), point2D.getY());
        this.setZoom(zoom);
    }
    
    d b(final double n, final Point2D point2D) {
        return b.a(new gJ(this).a(n, y.g.w.a(point2D), 500L));
    }
    
    void b(final d d) {
        final y.b.e e = new y.b.e();
        e.a(this);
        e.a(d);
    }
    
    boolean t() {
        return this.ic.A();
    }
    
    public boolean isAntialiasedPainting() {
        return this.ic.D();
    }
    
    public void setAntialiasedPainting(final boolean b) {
        this.ic.h(b);
    }
    
    public void registerKeyboardAction(final ActionListener actionListener, final String s, final KeyStroke keyStroke, final int n) {
        this.ic.registerKeyboardAction(actionListener, s, keyStroke, n);
    }
    
    public void registerKeyboardAction(final ActionListener actionListener, final KeyStroke keyStroke, final int n) {
        this.ic.registerKeyboardAction(actionListener, keyStroke, n);
    }
    
    public void unregisterKeyboardAction(final KeyStroke keyStroke) {
        this.ic.unregisterKeyboardAction(keyStroke);
    }
    
    public void requestFocus() {
        this.ic.requestFocus();
    }
    
    public void setRenderingHints(final RenderingHints kc) {
        if (kc == null) {
            throw new IllegalArgumentException("RenderingHints cannot be null");
        }
        this.kc = kc;
    }
    
    public RenderingHints getRenderingHints() {
        return this.kc;
    }
    
    public void applyLayout(final ah ah) {
        new bI((byte)1).d(this, this.getGraph2D(), ah);
    }
    
    public void applyLayoutAnimated(final ah ah) {
        final bI bi = new bI((byte)3);
        bi.e().setSmoothViewTransform(true);
        bi.e().setEasedExecution(true);
        bi.d(this, this.getGraph2D(), ah);
    }
    
    static boolean access$100(final ch ch) {
        return ch.sc;
    }
    
    static JScrollBar access$200(final ch ch) {
        return ch.qc;
    }
    
    static bw access$300(final ch ch) {
        return ch.ic;
    }
    
    static JScrollBar access$400(final ch ch) {
        return ch.mc;
    }
    
    static cl access$500(final ch ch) {
        return ch.jc;
    }
    
    static JPanel access$600(final ch ch) {
        return ch.gc;
    }
}
