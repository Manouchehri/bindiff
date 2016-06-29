package y.h;

import y.f.*;
import java.util.*;
import y.h.a.*;
import java.awt.geom.*;
import y.d.*;
import java.awt.*;
import y.c.*;
import java.io.*;

public abstract class fj implements am
{
    private static final Color l;
    public static final byte HOTSPOT_NW = 0;
    public static final byte HOTSPOT_N = 1;
    public static final byte HOTSPOT_NE = 2;
    public static final byte HOTSPOT_SW = 3;
    public static final byte HOTSPOT_S = 4;
    public static final byte HOTSPOT_SE = 5;
    public static final byte HOTSPOT_W = 6;
    public static final byte HOTSPOT_E = 7;
    public static final byte HOTSPOT_NONE = 8;
    private Color g;
    private Color e;
    private Color c;
    private dr n;
    private boolean o;
    private boolean i;
    private boolean d;
    private ArrayList m;
    private List k;
    private Map f;
    private byte q;
    private static Color b;
    private static Color p;
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    q j;
    public static boolean z;
    
    public fj() {
        this(0.0, 0.0, "");
    }
    
    public fj(final double n, final double n2) {
        this(n, n2, "");
    }
    
    public fj(final double n, final double n2, final String s) {
        this.e = fj.l;
        this.o = false;
        this.d = true;
        this.c = Color.black;
        this.n = dr.a;
        this.width = 30.0;
        this.height = 30.0;
        this.x = n - this.width / 2.0;
        this.y = n2 - this.height / 2.0;
        this.m = new ArrayList(1);
        this.b(s);
        this.q = 0;
    }
    
    void b(final String text) {
        final eR nodeLabel = this.createNodeLabel();
        nodeLabel.setText(text);
        this.setLabel(nodeLabel);
    }
    
    public fj(final fj fj) {
        final boolean z = fj.z;
        this.e = fj.e;
        this.g = fj.g;
        this.o = fj.o;
        this.c = fj.c;
        this.width = fj.width;
        this.height = fj.height;
        this.x = fj.x;
        this.y = fj.y;
        this.n = fj.n;
        this.d = fj.d;
        final int portCount = fj.portCount();
        fj fj2 = null;
        Label_0188: {
            if (portCount > 0) {
                this.k = new ArrayList(portCount);
                this.f = new HashMap();
                final Iterator ports = fj.ports();
                while (ports.hasNext()) {
                    final eU eu = ports.next();
                    final eU a = eu.a();
                    this.b(a);
                    fj2 = this;
                    if (z) {
                        break Label_0188;
                    }
                    this.f.put(a, fj.c(eu));
                    if (z) {
                        break;
                    }
                }
            }
            fj2 = fj;
        }
        final int labelCount = fj2.labelCount();
        this.m = new ArrayList(labelCount);
        int i = 0;
        while (i < labelCount) {
            this.addLabel((eR)fj.getLabel(i).clone());
            ++i;
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.i = fj.isSelected();
        this.q = 0;
    }
    
    public fj createCopy() {
        return this.createCopy(this);
    }
    
    public abstract fj createCopy(final fj p0);
    
    public q getNode() {
        return this.j;
    }
    
    public void setFillColor(final Color e) {
        this.e = e;
    }
    
    public Color getFillColor() {
        return this.e;
    }
    
    public void setFillColor2(final Color g) {
        this.g = g;
    }
    
    public Color getFillColor2() {
        return this.g;
    }
    
    public void setLineColor(final Color c) {
        this.c = c;
    }
    
    public Color getLineColor() {
        return this.c;
    }
    
    public void setLineType(final dr n) {
        this.n = n;
    }
    
    public dr getLineType() {
        return this.n;
    }
    
    public void setTransparent(final boolean o) {
        this.o = o;
    }
    
    public boolean isTransparent() {
        return this.o;
    }
    
    public void setLabelText(final String text) {
        this.getLabel().setText(text);
    }
    
    public void repaint() {
        final q node = this.getNode();
        if (node != null) {
            final i e = node.e();
            if (e instanceof bu) {
                final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
                this.calcUnionRect(double1);
                ((bu)e).a(double1.x, double1.y, double1.width, double1.height);
            }
        }
    }
    
    public String getLabelText() {
        return this.getLabel().getText();
    }
    
    public eR createNodeLabel() {
        return new eR();
    }
    
    public void setLabel(final eR er) {
        if (this.m.size() == 0) {
            this.m.add(er);
        }
        else {
            this.m.set(0, er);
        }
        er.a(this);
    }
    
    public void addLabel(final eR er) {
        this.m.add(er);
        er.a(this);
    }
    
    public void removeLabel(final eR er) {
        this.m.remove(er);
    }
    
    public void removeLabel(final int n) {
        try {
            this.m.remove(n);
        }
        catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + this.m.size());
        }
    }
    
    public eR getLabel() {
        if (this.labelCount() == 0) {
            this.addLabel(this.createNodeLabel());
        }
        return this.m.get(0);
    }
    
    public eR getLabel(final int n) {
        return this.m.get(n);
    }
    
    public int labelCount() {
        return this.m.size();
    }
    
    public eU getPort(final int n) {
        if (this.k == null) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: 0");
        }
        return this.k.get(n);
    }
    
    public void addPort(final eU eu) {
        if (eu == null) {
            throw new IllegalArgumentException("null");
        }
        if (this.k == null) {
            this.k = new ArrayList(1);
            this.f = new HashMap();
        }
        if (!this.f.containsKey(eu)) {
            this.b(eu);
            this.f.put(eu, new Object());
        }
    }
    
    private void b(final eU eu) {
        this.k.add(eu);
        eu.a(this);
    }
    
    public void removePort(final eU eu) {
        if (eu == null) {
            throw new IllegalArgumentException("null");
        }
        if (this.k != null) {
            final int index = this.k.indexOf(eu);
            if (index > -1) {
                this.b(index);
            }
        }
    }
    
    public void removePort(final int n) {
        if (this.k == null) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: 0");
        }
        if (n < this.k.size()) {
            this.b(n);
        }
    }
    
    private void b(final int n) {
        final boolean z = fj.z;
        final eU eu = this.k.remove(n);
        final Object remove = this.f.remove(eu);
        final q node = this.getNode();
        Label_0193: {
            if (node != null) {
                while (true) {
                    e e = null;
                    aB ab = null;
                    Object o = null;
                    Object zb = null;
                    Label_0173: {
                        if (node.b() > 0) {
                            final bu bu = this.d();
                            e = node.k();
                            while (e.f()) {
                                ab = bu.i(e.a());
                                o = remove;
                                zb = ab.zb;
                                if (z) {
                                    break Label_0173;
                                }
                                if (o == zb) {
                                    ab.setDirty();
                                }
                                e.g();
                                if (z) {
                                    break;
                                }
                            }
                        }
                        if (node.c() <= 0) {
                            break Label_0193;
                        }
                        final bu bu = this.d();
                        e = node.l();
                        if (!e.f()) {
                            break Label_0193;
                        }
                        ab = bu.i(e.a());
                        if (z) {
                            return;
                        }
                        final Object vb = ab.vb;
                    }
                    if (o == zb) {
                        ab.setDirty();
                    }
                    e.g();
                    if (!z) {
                        continue;
                    }
                    break;
                }
            }
        }
        eu.a((fj)null);
    }
    
    public int portCount() {
        return (this.k == null) ? 0 : this.k.size();
    }
    
    Iterator ports() {
        return (this.k == null) ? Collections.EMPTY_LIST.iterator() : this.k.iterator();
    }
    
    Object c(final eU eu) {
        return (this.f == null) ? null : this.f.get(eu);
    }
    
    eU b(final Object o) {
        if (o != null && this.f != null && !this.f.isEmpty()) {
            for (final Map.Entry<eU, V> entry : this.f.entrySet()) {
                if (o == entry.getValue()) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }
    
    public double getCenterX() {
        return this.x + this.width / 2.0;
    }
    
    public double getCenterY() {
        return this.y + this.height / 2.0;
    }
    
    public void setCenter(final double n, final double n2) {
        this.x = n - this.width / 2.0;
        this.y = n2 - this.height / 2.0;
        this.setEdgesDirty();
        this.boundsChanged();
    }
    
    public void setCenterX(final double n) {
        this.setCenter(n, this.getCenterY());
    }
    
    public void setCenterY(final double n) {
        this.setCenter(this.getCenterX(), n);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setLocation(final double x, final double y) {
        if (this.x == x && this.y == y) {
            return;
        }
        this.x = x;
        this.y = y;
        this.setEdgesDirty();
        this.boundsChanged();
    }
    
    public void setX(final double n) {
        this.setLocation(n, this.y);
    }
    
    public void setY(final double n) {
        this.setLocation(this.x, n);
    }
    
    public void moveBy(final double n, final double n2) {
        this.x += n;
        this.y += n2;
        this.setEdgesDirty();
        this.boundsChanged();
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public void setFrame(final double n, final double n2, final double n3, final double n4) {
        this.setSize(n3, n4);
        this.setLocation(n, n2);
    }
    
    public void setFrame(final Rectangle2D rectangle2D) {
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setLocation(rectangle2D.getX(), rectangle2D.getY());
    }
    
    public void setSize(final double width, final double height) {
        final boolean z = fj.z;
        final double n = (this.width - width) / 2.0;
        final double n2 = (this.height - height) / 2.0;
        this.x += n;
        this.y += n2;
        this.width = width;
        this.height = height;
        int i = 0;
        while (i < this.m.size()) {
            this.getLabel(i).setOffsetDirty();
            ++i;
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        this.setEdgesDirty();
        this.invalidatePortPositions();
        this.boundsChanged();
    }
    
    protected void boundsChanged() {
    }
    
    protected void labelBoundsChanged(final eR er) {
    }
    
    public void setWidth(final double n) {
        this.setSize(n, this.height);
    }
    
    public void setHeight(final double n) {
        this.setSize(this.width, n);
    }
    
    public void setVisible(final boolean d) {
        this.d = d;
    }
    
    public boolean isVisible() {
        return this.d;
    }
    
    public void setLayer(final byte q) {
        this.q = q;
    }
    
    public byte getLayer() {
        return this.q;
    }
    
    public void setLayer(final byte b, final boolean b2) {
        final boolean z = fj.z;
        if (b2 && this.getNode() != null) {
            final bu bu = (bu)this.getNode().e();
            final e j = this.getNode().j();
            while (j.f()) {
                bu.i(j.a()).setLayer(b);
                j.g();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
        }
        this.setLayer(b);
    }
    
    public void setSelected(final boolean i) {
        if (i != this.i) {
            this.i = i;
            final bu d = this.d();
            if (d != null) {
                d.e((Object)this.getNode());
            }
            this.c();
        }
    }
    
    void c() {
    }
    
    public boolean isSelected() {
        return this.i;
    }
    
    public static void setHotSpotColor(final Color b) {
        fj.b = b;
    }
    
    public static Color getHotSpotColor() {
        return fj.b;
    }
    
    public static void setSloppySelectionColor(final Color p) {
        fj.p = p;
    }
    
    public static Color getSloppySelectionColor() {
        return fj.p;
    }
    
    public a getAutoBoundsFeature() {
        if (this instanceof a) {
            return (a)this;
        }
        return null;
    }
    
    public gt getSizeConstraintProvider() {
        if (this instanceof gt) {
            return (gt)this;
        }
        return null;
    }
    
    public dy getMouseInputEditorProvider() {
        if (this instanceof dy) {
            return (dy)this;
        }
        return null;
    }
    
    public Rectangle2D.Double getBoundingBox() {
        return new Rectangle2D.Double(this.x, this.y, this.width, this.height);
    }
    
    public byte hotSpotHit(final double n, final double n2) {
        if (!this.isSelected()) {
            return 8;
        }
        if (n < this.x - 6.0 || n > this.x + this.width + 7.0 || n2 < this.y - 6.0 || n2 > this.y + this.height + 7.0) {
            return 8;
        }
        if (n >= this.x && n <= this.x + this.width && n2 >= this.y && n2 <= this.y + this.height) {
            return 8;
        }
        if (n > this.x + this.width) {
            if (n2 < this.y) {
                return 2;
            }
            if (n2 > this.y + this.height) {
                return 5;
            }
            if (n2 >= this.y + this.height / 2.0 - 3.0 && n2 < this.y + this.height / 2.0 + 3.0) {
                return 7;
            }
        }
        else if (n < this.x) {
            if (n2 < this.y) {
                return 0;
            }
            if (n2 > this.y + this.height) {
                return 3;
            }
            if (n2 >= this.y + this.height / 2.0 - 3.0 && n2 < this.y + this.height / 2.0 + 3.0) {
                return 6;
            }
        }
        else if (n > this.x + this.width / 2.0 - 3.0 && n < this.x + this.width / 2.0 + 3.0) {
            if (n2 > this.y + this.height) {
                return 4;
            }
            if (n2 < this.y) {
                return 1;
            }
        }
        return 8;
    }
    
    public boolean findBBIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        final boolean z = fj.z;
        if (this.getCenterX() != n || this.getCenterY() != n2) {
            return false;
        }
        final double n5 = n3 - this.getCenterX();
        final double n6 = n4 - this.getCenterY();
        if (this.height < 1.0E-6 || this.width < 1.0E-6) {
            point2D.setLocation(this.getCenterX(), this.getCenterY());
            if (!z) {
                return true;
            }
        }
        double n7 = 0.0;
        Label_0103: {
            if (n6 > 0.0) {
                n7 = 1.0;
                if (!z) {
                    break Label_0103;
                }
            }
            n7 = -1.0;
        }
        final double n8 = n7 * n6;
        final double n9 = this.height / 2.0 * n5 / n8;
        if (Math.abs(n9) < this.width / 2.0) {
            point2D.setLocation(this.getCenterX() + n9, this.getCenterY() + n7 * this.height / 2.0);
            if (!z) {
                return true;
            }
        }
        final double n10 = n7 * n8;
        double n11 = 0.0;
        Label_0203: {
            if (n5 > 0.0) {
                n11 = 1.0;
                if (!z) {
                    break Label_0203;
                }
            }
            n11 = -1.0;
        }
        point2D.setLocation(this.getCenterX() + n11 * this.width / 2.0, this.getCenterY() + this.width / 2.0 * n10 / (n11 * n5));
        return true;
    }
    
    public boolean findIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        final boolean z = fj.z;
        if (this.contains(n, n2)) {
            if (this.contains(n3, n4)) {
                point2D.setLocation(n3, n4);
                return false;
            }
        }
        else if (!this.contains(n3, n4)) {
            point2D.setLocation(n, n2);
            return false;
        }
        double sqrt = Math.sqrt((n3 - n) * (n3 - n) + (n4 - n2) * (n4 - n2));
        if (Double.isNaN(sqrt) || Double.isInfinite(sqrt)) {
            point2D.setLocation(n, n2);
            return true;
        }
        double n5 = (n3 - n) / 2.0;
        double n6 = (n4 - n2) / 2.0;
        double n7 = n + n5;
        double n8 = n2 + n6;
        boolean contains = false;
        while (sqrt > 0.1) {
            sqrt /= 2.0;
            n5 /= 2.0;
            n6 /= 2.0;
            contains = this.contains(n7, n8);
            if (z) {
                return contains;
            }
            if (contains) {
                n7 += n5;
                n8 += n6;
                if (!z) {
                    continue;
                }
            }
            n7 -= n5;
            n8 -= n6;
            if (z) {
                break;
            }
        }
        point2D.setLocation(n7, n8);
        return contains;
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D, final byte b) {
        if (b == this.getLayer()) {
            this.calcUnionRect(rectangle2D);
        }
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        this.calcUnionRectImpl(rectangle2D);
        this.calcUnionRectLabels(rectangle2D);
        this.calcUnionRectPorts(rectangle2D);
    }
    
    protected void calcUnionRectImpl(final Rectangle2D rectangle2D) {
        if (rectangle2D.getWidth() <= 0.0) {
            rectangle2D.setFrame(this.x, this.y, this.width, this.height);
            if (!fj.z) {
                return;
            }
        }
        final double min = Math.min(this.x, rectangle2D.getX());
        final double max = Math.max(this.x + this.width, rectangle2D.getX() + rectangle2D.getWidth());
        final double min2 = Math.min(this.y, rectangle2D.getY());
        rectangle2D.setFrame(min, min2, max - min, Math.max(this.y + this.height, rectangle2D.getY() + rectangle2D.getHeight()) - min2);
    }
    
    protected void calcUnionRectLabels(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        int i = this.m.size() - 1;
        while (i >= 0) {
            ((eR)this.m.get(i)).calcUnionRect(rectangle2D);
            --i;
            if (z) {
                break;
            }
        }
    }
    
    protected void calcUnionRectPorts(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        if (this.portCount() > 0) {
            final Iterator ports = this.ports();
            while (ports.hasNext()) {
                ports.next().a(rectangle2D);
                if (z) {
                    break;
                }
            }
        }
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        return n + n3 >= this.x && n <= this.x + this.width && n2 + n4 >= this.y && n2 <= this.y + this.height;
    }
    
    public boolean contains(final double n, final double n2) {
        return n >= this.x && n <= this.x + this.width && n2 >= this.y && n2 <= this.y + this.height;
    }
    
    public boolean isInBox(final double n, final double n2, final double n3, final double n4) {
        final double centerX = this.getCenterX();
        final double centerY = this.getCenterY();
        return centerX <= n + n3 && centerX >= n && centerY <= n2 + n4 && centerY >= n2;
    }
    
    public D getPortCandidates(final double n) {
        final boolean z = fj.z;
        double n2 = this.getCenterX() - (int)(this.getWidth() / 2.0 / n) * n;
        double n3 = this.getCenterY() - (int)(this.getHeight() / 2.0 / n) * n;
        final D d = new D();
        final Point2D.Double double1 = new Point2D.Double();
        final double n4 = this.getHeight() / 10.0;
        while (true) {
            do {
                double contains = 0.0;
                Label_0074: {
                    contains = dcmpg(n2, this.x + this.width);
                }
                Label_0085:
            Label_0202_Outer:
                while (contains < 0) {
                    final double n5 = this.getY() + 1.0;
                    if (!z) {
                        double n6 = n5;
                        while (true) {
                            while (n6 < this.getY() + this.getHeight()) {
                                double contains2;
                                final int n7 = (int)(contains2 = (this.contains(n2, n6) ? 1 : 0));
                                if (z) {
                                Label_0285:
                                    while (true) {
                                        if (contains2 > 0) {
                                            final int n8 = (int)(contains = (this.contains(n2, n6) ? 1 : 0));
                                            if (z) {
                                                continue Label_0085;
                                            }
                                            if (n8 != 0 && this.findIntersection(n2, n6, n2, n6 + n4, double1)) {
                                                d.add(new t(double1.getX(), double1.getY()));
                                                if (!z) {
                                                    break Label_0285;
                                                }
                                            }
                                            n6 -= n4;
                                            if (!z) {
                                                contains2 = dcmpl(n6, this.getY());
                                                continue Label_0202_Outer;
                                            }
                                        }
                                        break;
                                    }
                                    n2 += n;
                                    continue Label_0074;
                                }
                                if (n7 != 0 && this.findIntersection(n2, n6, n2, n6 - n4, double1)) {
                                    d.add(new t(double1.getX(), double1.getY()));
                                    if (!z) {
                                        break;
                                    }
                                }
                                n6 += n4;
                                if (z) {
                                    break;
                                }
                            }
                            n6 = this.getY() + this.getHeight() - 1.0;
                            continue;
                        }
                    }
                    final double n9 = n5;
                    do {
                        Label_0304:
                        double contains3 = dcmpg(n3, this.y + this.height);
                        Label_0316:
                    Label_0431_Outer:
                        while (contains3 < 0) {
                            double n10 = this.getX() + 1.0;
                            while (true) {
                                while (n10 < this.getX() + this.getWidth()) {
                                    double contains4;
                                    final int n11 = (int)(contains4 = (this.contains(n10, n3) ? 1 : 0));
                                    if (z) {
                                    Label_0517:
                                        while (true) {
                                            if (contains4 > 0) {
                                                final int n12 = (int)(contains3 = (this.contains(n10, n3) ? 1 : 0));
                                                if (z) {
                                                    continue Label_0316;
                                                }
                                                if (n12 != 0 && this.findIntersection(n10, n3, n10 + n9, n3, double1)) {
                                                    d.add(new t(double1.getX(), double1.getY()));
                                                    if (!z) {
                                                        break Label_0517;
                                                    }
                                                }
                                                n10 -= n9;
                                                if (!z) {
                                                    contains4 = dcmpl(n10, this.getX());
                                                    continue Label_0431_Outer;
                                                }
                                            }
                                            break;
                                        }
                                        n3 += n;
                                        continue Label_0304;
                                    }
                                    if (n11 != 0 && this.findIntersection(n10, n3, n10 - n9, n3, double1)) {
                                        d.add(new t(double1.getX(), double1.getY()));
                                        if (!z) {
                                            break;
                                        }
                                    }
                                    n10 += n9;
                                    if (z) {
                                        break;
                                    }
                                }
                                n10 = this.getX() + this.getWidth() - 1.0;
                                continue;
                            }
                        }
                        break;
                    } while (!z);
                    d.add(new t(this.getCenterX(), this.getCenterY()));
                    return d;
                }
                break;
            } while (!z);
            final double n13 = this.getWidth() / 10.0;
            continue;
        }
    }
    
    protected abstract void paintNode(final Graphics2D p0);
    
    public void paintHotSpots(final Graphics2D graphics2D) {
        graphics2D.setColor(fj.b);
        final double n = this.width / 2.0;
        final double n2 = this.height / 2.0;
        final Rectangle2D.Double k;
        final Rectangle2D.Double double2;
        final Rectangle2D.Double double1 = double2 = (k = hC.a().k);
        final double n3 = 5.0;
        double2.height = n3;
        k.width = n3;
        double1.x = this.x - 6.0;
        double1.y = this.y - 6.0;
        graphics2D.fill(double1);
        double1.y = this.y + n2 - 2.0;
        graphics2D.fill(double1);
        double1.y = this.y + this.height + 2.0;
        graphics2D.fill(double1);
        double1.x = this.x + n - 2.0;
        graphics2D.fill(double1);
        double1.y = this.y - 6.0;
        graphics2D.fill(double1);
        double1.x = this.x + this.width + 2.0;
        graphics2D.fill(double1);
        double1.y = this.y + n2 - 2.0;
        graphics2D.fill(double1);
        double1.y = this.y + this.height + 2.0;
        graphics2D.fill(double1);
    }
    
    public void paintLayer(final Graphics2D graphics2D, final byte b) {
        if (b == this.getLayer()) {
            this.paint(graphics2D);
        }
    }
    
    public void paintLayerSloppy(final Graphics2D graphics2D, final byte b) {
        if (b == this.getLayer()) {
            this.paintSloppy(graphics2D);
        }
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if (this.b()) {
            return;
        }
        this.b(graphics2D);
        if (b(graphics2D, true)) {
            this.paintPorts(graphics2D);
        }
        if (c(graphics2D, true)) {
            this.paintText(graphics2D);
        }
    }
    
    void b(final Graphics2D graphics2D) {
        Label_0084: {
            if (b(this, graphics2D)) {
                graphics2D.setColor(fj.p);
                graphics2D.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
                if (!fj.z) {
                    break Label_0084;
                }
            }
            if (this.e != null) {
                graphics2D.setColor(this.e);
                graphics2D.fillRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
            }
        }
        if (this.c != null) {
            graphics2D.setColor(this.c);
            graphics2D.drawRect((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        }
    }
    
    public void paint(final Graphics2D graphics2D) {
        if (this.b()) {
            return;
        }
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        this.paintNode(graphics2D);
        graphics2D.setColor(color);
        graphics2D.setStroke(stroke);
    }
    
    boolean b() {
        return this.width <= 0.0 || this.height <= 0.0 || !this.isVisible();
    }
    
    public void paintText(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        int i = 0;
        while (i < this.m.size()) {
            this.getLabel(i).paint(graphics2D);
            ++i;
            if (z) {
                break;
            }
        }
    }
    
    public void paintPorts(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (this.portCount() > 0) {
            final Iterator ports = this.ports();
            while (ports.hasNext()) {
                ports.next().a(graphics2D);
                if (z) {
                    break;
                }
            }
        }
    }
    
    static boolean b(final fj fj, final Graphics2D graphics2D) {
        return fj.isSelected() && hk.b(graphics2D);
    }
    
    static boolean c(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.g);
        if (b) {
            return hk.i.equals(renderingHint);
        }
        return !hk.j.equals(renderingHint);
    }
    
    static boolean b(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.k);
        if (b) {
            return hk.m.equals(renderingHint);
        }
        return !hk.n.equals(renderingHint);
    }
    
    protected void invalidatePortPositions() {
        if (this.portCount() > 0) {
            final Iterator ports = this.ports();
            while (ports.hasNext()) {
                ports.next().i();
            }
        }
    }
    
    public void setEdgesDirty() {
        if (this.j == null) {
            return;
        }
        for (d d = this.j.g(); d != null; d = d.h()) {
            final aB l = ((hH)d).l;
            if (l != null) {
                l.setDirty();
            }
        }
        for (d d2 = this.j.f(); d2 != null; d2 = d2.g()) {
            final aB i = ((hH)d2).l;
            if (i != null) {
                i.setDirty();
            }
        }
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final boolean z = fj.z;
        objectOutputStream.writeByte(4);
        objectOutputStream.writeInt(this.labelCount());
        int i = 0;
        while (i < this.labelCount()) {
            this.getLabel(i).write(objectOutputStream);
            ++i;
            if (z) {
                return;
            }
            if (z) {
                break;
            }
        }
        objectOutputStream.writeObject(this.e);
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeObject(this.g);
        objectOutputStream.writeFloat((float)this.width);
        objectOutputStream.writeFloat((float)this.height);
        objectOutputStream.writeFloat((float)this.x);
        objectOutputStream.writeFloat((float)this.y);
        objectOutputStream.writeBoolean(this.o);
        dr.a(objectOutputStream, this.n);
        objectOutputStream.writeBoolean(this.isVisible());
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0699: {
            Label_0586: {
                switch (objectInputStream.readByte()) {
                    case 4: {
                        final int int1 = objectInputStream.readInt();
                        this.m = new ArrayList(int1);
                        int i = 0;
                        while (true) {
                            while (i < int1) {
                                final eR nodeLabel = this.createNodeLabel();
                                this.addLabel(nodeLabel);
                                nodeLabel.read(objectInputStream);
                                ++i;
                                if (!z) {
                                    if (z) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (z) {
                                        break Label_0586;
                                    }
                                    break Label_0699;
                                }
                            }
                            this.e = (Color)objectInputStream.readObject();
                            this.c = (Color)objectInputStream.readObject();
                            this.g = (Color)objectInputStream.readObject();
                            this.setSize(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.setLocation(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.o = objectInputStream.readBoolean();
                            this.n = dr.a(objectInputStream);
                            this.d = objectInputStream.readBoolean();
                            continue;
                        }
                    }
                    case 3: {
                        final int int2 = objectInputStream.readInt();
                        this.m = new ArrayList(int2);
                        int j = 0;
                        while (true) {
                            while (j < int2) {
                                final eR nodeLabel2 = this.createNodeLabel();
                                this.addLabel(nodeLabel2);
                                nodeLabel2.read(objectInputStream);
                                ++j;
                                if (!z) {
                                    if (z) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (z) {
                                        break Label_0586;
                                    }
                                    break Label_0699;
                                }
                            }
                            this.e = (Color)objectInputStream.readObject();
                            this.c = (Color)objectInputStream.readObject();
                            this.g = (Color)objectInputStream.readObject();
                            this.setSize(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.setLocation(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.o = objectInputStream.readBoolean();
                            this.n = dr.a(objectInputStream);
                            continue;
                        }
                    }
                    case 2: {
                        final int int3 = objectInputStream.readInt();
                        this.m = new ArrayList(int3);
                        int k = 0;
                        while (true) {
                            while (k < int3) {
                                final eR nodeLabel3 = this.createNodeLabel();
                                this.addLabel(nodeLabel3);
                                nodeLabel3.read(objectInputStream);
                                ++k;
                                if (!z) {
                                    if (z) {
                                        break;
                                    }
                                    continue;
                                }
                                else {
                                    if (z) {
                                        break Label_0586;
                                    }
                                    break Label_0699;
                                }
                            }
                            this.e = (Color)objectInputStream.readObject();
                            this.c = (Color)objectInputStream.readObject();
                            this.g = (Color)objectInputStream.readObject();
                            this.setSize(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.setLocation(objectInputStream.readFloat(), objectInputStream.readFloat());
                            this.o = objectInputStream.readBoolean();
                            this.n = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                            continue;
                        }
                    }
                    case 1: {
                        this.m = new ArrayList(1);
                        final eR nodeLabel4 = this.createNodeLabel();
                        nodeLabel4.read(objectInputStream);
                        this.setLabel(nodeLabel4);
                        this.e = (Color)objectInputStream.readObject();
                        this.c = (Color)objectInputStream.readObject();
                        this.g = (Color)objectInputStream.readObject();
                        this.setSize(objectInputStream.readFloat(), objectInputStream.readFloat());
                        this.setLocation(objectInputStream.readFloat(), objectInputStream.readFloat());
                        this.o = objectInputStream.readBoolean();
                        this.n = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                        if (z) {
                            break Label_0586;
                        }
                        break Label_0699;
                    }
                    case 0: {
                        this.m = new ArrayList(1);
                        final eR nodeLabel5 = this.createNodeLabel();
                        nodeLabel5.read(objectInputStream);
                        this.setLabel(nodeLabel5);
                        this.e = (Color)objectInputStream.readObject();
                        this.c = (Color)objectInputStream.readObject();
                        this.setSize(objectInputStream.readFloat(), objectInputStream.readFloat());
                        this.setLocation(objectInputStream.readFloat(), objectInputStream.readFloat());
                        this.o = objectInputStream.readBoolean();
                        this.n = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                        if (z) {
                            break;
                        }
                        break Label_0699;
                    }
                }
            }
            throw new y.e.a();
        }
        this.q = 0;
    }
    
    void b(final q j) {
        this.j = j;
        this.invalidatePortPositions();
        this.setEdgesDirty();
    }
    
    bu d() {
        if (this.j != null) {
            return (bu)this.j.e();
        }
        return null;
    }
    
    static {
        l = new Color(204, 204, 255);
        fj.b = Color.lightGray;
        fj.p = Color.gray;
    }
}
