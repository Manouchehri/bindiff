package y.h;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import y.e.*;
import java.util.*;

public class gn extends fj
{
    public static final RenderingHints.Key KEY_SLOPPY_RECT_PAINTING;
    public static final Object VALUE_SLOPPY_RECT_PAINTING_OFF;
    public static final byte RECT = 0;
    public static final byte ROUND_RECT = 1;
    public static final byte ELLIPSE = 2;
    public static final byte PARALLELOGRAM = 3;
    public static final byte HEXAGON = 4;
    public static final byte TRIANGLE = 5;
    public static final byte RECT_3D = 6;
    public static final byte OCTAGON = 7;
    public static final byte DIAMOND = 8;
    public static final byte TRAPEZOID = 9;
    public static final byte TRAPEZOID_2 = 10;
    protected Shape shape;
    private byte t;
    private static final double cb = 5.0;
    private static final double bb = 1.2217304763960306;
    private static Color ab;
    private byte s;
    private byte r;
    private Color v;
    private static final double u = 0.7;
    
    public gn() {
        this((byte)0, 0.0, 0.0, "");
    }
    
    public gn(final byte b) {
        this(b, 0.0, 0.0, "");
    }
    
    public gn(final byte shapeType, final double n, final double n2, final String s) {
        super(n, n2, s);
        this.s = 0;
        this.r = 0;
        this.v = gn.ab;
        this.setShapeType(shapeType);
    }
    
    public gn(final fj fj) {
        super(fj);
        this.s = 0;
        this.r = 0;
        this.v = gn.ab;
        if (fj instanceof gn) {
            final gn gn = (gn)fj;
            this.setShapeType(gn.getShapeType());
            this.v = gn.v;
            this.r = gn.r;
            this.s = gn.s;
            if (!fj.z) {
                return;
            }
        }
        this.setShapeType((byte)0);
    }
    
    public fj createCopy(final fj fj) {
        return new gn(fj);
    }
    
    public void setCenter(final double n, final double n2) {
        this.b(n - this.getWidth() / 2.0, n2 - this.getHeight() / 2.0);
    }
    
    public void setLocation(final double n, final double n2) {
        this.b(n, n2);
    }
    
    private void b(final double n, final double n2) {
        if (this.shape instanceof RectangularShape) {
            super.setLocation(n, n2);
            ((RectangularShape)this.shape).setFrame(this.x, this.y, this.width, this.height);
            if (!fj.z) {
                return;
            }
        }
        if (this.shape instanceof GeneralPath) {
            ((GeneralPath)this.shape).transform(AffineTransform.getTranslateInstance(n - this.x, n2 - this.y));
            super.setLocation(n, n2);
        }
    }
    
    public void moveBy(final double n, final double n2) {
        this.b(this.getX() + n, this.getY() + n2);
    }
    
    public void setSize(final double n, final double n2) {
        final boolean z = fj.z;
        if (n == this.width && n2 == this.height) {
            return;
        }
        if (this.shape instanceof RectangularShape) {
            super.setSize(n, n2);
            ((RectangularShape)this.shape).setFrame(this.x, this.y, n, n2);
            if (!z) {
                return;
            }
        }
        if (this.shape instanceof GeneralPath) {
            if (this.width == 0.0 || this.height == 0.0) {
                super.setSize(n, n2);
                this.setShapeType(this.getShapeType());
                if (!z) {
                    return;
                }
            }
            final double n3 = this.x + this.width / 2.0;
            final double n4 = this.y + this.height / 2.0;
            final AffineTransform translateInstance = AffineTransform.getTranslateInstance(n3, n4);
            translateInstance.scale(n / this.width, n2 / this.height);
            translateInstance.translate(-n3, -n4);
            ((GeneralPath)this.shape).transform(translateInstance);
            super.setSize(n, n2);
            if (!z) {
                return;
            }
        }
        super.setSize(n, n2);
    }
    
    private double e() {
        return this.width / 2.0;
    }
    
    public void setShapeType(final byte t) {
        switch (t) {
            case 2: {
                this.shape = new Ellipse2D.Double(this.x, this.y, this.width, this.height);
                break;
            }
            case 0:
            case 6: {
                this.shape = new Rectangle2D.Double(this.x, this.y, this.width, this.height);
                break;
            }
            case 1: {
                this.shape = new RoundRectangle2D.Double(this.x, this.y, this.width, this.height, 8.0, 8.0);
                break;
            }
            case 3: {
                final GeneralPath shape = new GeneralPath(0, 5);
                shape.moveTo((float)(this.x + this.width * 0.1), (float)this.y);
                shape.lineTo((float)(this.x + this.width), (float)this.y);
                shape.lineTo((float)(this.x + this.width * 0.9), (float)(this.y + this.height));
                shape.lineTo((float)this.x, (float)(this.y + this.height));
                shape.closePath();
                this.shape = shape;
                break;
            }
            case 4: {
                final GeneralPath shape2 = new GeneralPath(0, 6);
                shape2.moveTo((float)this.x, (float)(this.y + this.height / 2.0));
                shape2.lineTo((float)(this.x + this.width * 0.1), (float)this.y);
                shape2.lineTo((float)(this.x + this.width * 0.9), (float)this.y);
                shape2.lineTo((float)(this.x + this.width), (float)(this.y + this.height / 2.0));
                shape2.lineTo((float)(this.x + this.width * 0.9), (float)(this.y + this.height));
                shape2.lineTo((float)(this.x + this.width * 0.1), (float)(this.y + this.height));
                shape2.closePath();
                this.shape = shape2;
                break;
            }
            case 5: {
                final GeneralPath shape3 = new GeneralPath(0, 3);
                shape3.moveTo((float)(this.x + this.width / 2.0), (float)this.y);
                shape3.lineTo((float)(this.x + this.width), (float)(this.y + this.height));
                shape3.lineTo((float)this.x, (float)(this.y + this.height));
                shape3.closePath();
                this.shape = shape3;
                break;
            }
            case 7: {
                final double sqrt = Math.sqrt(2.0);
                final double n = this.width / (2.0 + sqrt);
                final double n2 = this.height / (2.0 + sqrt);
                final GeneralPath shape4 = new GeneralPath(0, 8);
                shape4.moveTo((float)this.x, (float)(this.y + n2));
                shape4.lineTo((float)(this.x + n), (float)this.y);
                shape4.lineTo((float)(this.x + this.width - n), (float)this.y);
                shape4.lineTo((float)(this.x + this.width), (float)(this.y + n2));
                shape4.lineTo((float)(this.x + this.width), (float)(this.y + this.height - n2));
                shape4.lineTo((float)(this.x + this.width - n), (float)(this.y + this.height));
                shape4.lineTo((float)(this.x + n), (float)(this.y + this.height));
                shape4.lineTo((float)this.x, (float)(this.y + this.height - n2));
                shape4.closePath();
                this.shape = shape4;
                break;
            }
            case 8: {
                final GeneralPath shape5 = new GeneralPath(0, 4);
                shape5.moveTo((float)this.x, (float)(this.y + this.height * 0.5));
                shape5.lineTo((float)(this.x + this.width * 0.5), (float)this.y);
                shape5.lineTo((float)(this.x + this.width), (float)(this.y + this.height * 0.5));
                shape5.lineTo((float)(this.x + this.width * 0.5), (float)(this.y + this.height));
                shape5.closePath();
                this.shape = shape5;
                break;
            }
            case 9: {
                final GeneralPath shape6 = new GeneralPath(0, 4);
                shape6.moveTo((float)this.x, (float)(this.y + this.height));
                shape6.lineTo((float)(this.x + this.width * 0.25), (float)this.y);
                shape6.lineTo((float)(this.x + this.width * 0.75), (float)this.y);
                shape6.lineTo((float)(this.x + this.width), (float)(this.y + this.height));
                shape6.closePath();
                this.shape = shape6;
                break;
            }
            case 10: {
                final GeneralPath shape7 = new GeneralPath(0, 4);
                shape7.moveTo((float)this.x, (float)this.y);
                shape7.lineTo((float)(this.x + this.width), (float)this.y);
                shape7.lineTo((float)(this.x + this.width * 0.75), (float)(this.y + this.height));
                shape7.lineTo((float)(this.x + this.width * 0.25), (float)(this.y + this.height));
                shape7.closePath();
                this.shape = shape7;
                break;
            }
        }
        this.t = t;
        this.setEdgesDirty();
    }
    
    public byte getShapeType() {
        return this.t;
    }
    
    public Color getDropShadowColor() {
        return this.v;
    }
    
    public void setDropShadowColor(final Color v) {
        this.v = v;
    }
    
    public byte getDropShadowOffsetY() {
        return this.r;
    }
    
    public void setDropShadowOffsetY(final byte r) {
        this.r = r;
    }
    
    public byte getDropShadowOffsetX() {
        return this.s;
    }
    
    public void setDropShadowOffsetX(final byte s) {
        this.s = s;
    }
    
    public boolean isDropShadowVisible() {
        return this.v != null && (this.s != 0 || this.r != 0);
    }
    
    void b(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (gn.VALUE_SLOPPY_RECT_PAINTING_OFF.equals(graphics2D.getRenderingHint(gn.KEY_SLOPPY_RECT_PAINTING))) {
            final Color fillColor = this.getFillColor();
            Label_0071: {
                if (fj.b(this, graphics2D)) {
                    graphics2D.setColor(fj.getSloppySelectionColor());
                    graphics2D.fill(this.shape);
                    if (!z) {
                        break Label_0071;
                    }
                }
                if (fillColor != null) {
                    graphics2D.setColor(fillColor);
                    graphics2D.fill(this.shape);
                }
            }
            final Color lineColor = this.getLineColor();
            if (lineColor == null) {
                return;
            }
            graphics2D.setColor(lineColor);
            graphics2D.draw(this.shape);
            if (!z) {
                return;
            }
        }
        super.b(graphics2D);
    }
    
    protected void paintNode(final Graphics2D graphics2D) {
        if (fj.b(this, graphics2D)) {
            this.paintHotSpots(graphics2D);
        }
        if (hk.d(graphics2D)) {
            this.paintShadow(graphics2D);
        }
        this.paintFilledShape(graphics2D);
        if (fj.b(graphics2D, false)) {
            this.paintPorts(graphics2D);
        }
        if (fj.c(graphics2D, false)) {
            this.paintText(graphics2D);
        }
        this.paintShapeBorder(graphics2D);
    }
    
    protected void paintShapeBorder(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        final byte shapeType = this.getShapeType();
        if (shapeType == 6) {
            final Color fillColor = this.getFillColor();
            if (fillColor == null) {
                return;
            }
            graphics2D.setColor(fillColor);
            this.paint3DBorder(graphics2D, true);
            if (!z) {
                return;
            }
        }
        final Color lineColor = this.getLineColor();
        if (lineColor != null) {
            final Stroke stroke = graphics2D.getStroke();
            graphics2D.setStroke(this.getLineType());
            graphics2D.setColor(lineColor);
            Label_0172: {
                if (shapeType == 2) {
                    final cV cv = (cV)graphics2D.getRenderingHint(hk.z);
                    final Object renderingHint = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
                    if (!RenderingHints.VALUE_ANTIALIAS_ON.equals(renderingHint) && (cv == null || !cv.b())) {
                        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        graphics2D.draw(this.shape);
                        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, renderingHint);
                        if (!z) {
                            break Label_0172;
                        }
                    }
                    graphics2D.draw(this.shape);
                    if (!z) {
                        break Label_0172;
                    }
                }
                graphics2D.draw(this.shape);
            }
            graphics2D.setStroke(stroke);
        }
    }
    
    protected void paintFilledShape(final Graphics2D graphics2D) {
        Color color = this.getFillColor();
        if (color != null && !this.isTransparent()) {
            final boolean b = fj.b(this, graphics2D);
            Color color2 = this.getFillColor2();
            Label_0130: {
                if (color2 != null && hk.c(graphics2D)) {
                    if (b) {
                        color2 = this.createSelectionColor(color2);
                        color = this.createSelectionColor(color);
                    }
                    graphics2D.setPaint(new GradientPaint((float)(this.x + this.width / 3.0), (float)this.y, color, (float)(this.x + this.width), (float)this.y, color2, true));
                    if (!fj.z) {
                        break Label_0130;
                    }
                }
                graphics2D.setColor(b ? this.createSelectionColor(color) : color);
            }
            graphics2D.fill(this.shape);
        }
    }
    
    protected Color createSelectionColor(final Color color) {
        return new Color(Math.max((int)(color.getRed() * 0.7), 0), Math.max((int)(color.getGreen() * 0.7), 0), Math.max((int)(color.getBlue() * 0.7), 0), color.getAlpha());
    }
    
    protected void paint3DBorder(final Graphics2D graphics2D, final boolean b) {
        final Paint paint = graphics2D.getPaint();
        final Color color = graphics2D.getColor();
        final Color brighter = color.brighter();
        final Color darker = color.darker();
        Label_0053: {
            if (!b) {
                graphics2D.setColor(darker);
                if (!fj.z) {
                    break Label_0053;
                }
            }
            if (paint != color) {
                graphics2D.setColor(color);
            }
        }
        graphics2D.setColor(b ? brighter : darker);
        final Rectangle2D.Double k = hC.a().k;
        k.setFrame(this.x, this.y, 1.0, this.height);
        graphics2D.fill(k);
        k.setFrame(this.x + 1.0, this.y, this.width - 2.0, 1.0);
        graphics2D.fill(k);
        graphics2D.setColor(b ? darker : brighter);
        k.setFrame(this.x + 1.0, this.y + this.height - 1.0, this.width - 1.0, 1.0);
        graphics2D.fill(k);
        k.setFrame(this.x + this.width - 1.0, this.y, 1.0, this.height - 1.0);
        graphics2D.fill(k);
        graphics2D.setPaint(paint);
    }
    
    protected void paintShadow(final Graphics2D graphics2D) {
        if (this.v == null || (this.s == 0 && this.r == 0)) {
            return;
        }
        final Color color = graphics2D.getColor();
        final AffineTransform transform = graphics2D.getTransform();
        graphics2D.setColor(this.v);
        graphics2D.translate(this.s, this.r);
        graphics2D.fill(this.shape);
        graphics2D.setColor(color);
        graphics2D.setTransform(transform);
    }
    
    public boolean contains(final double n, final double n2) {
        if (this.isTransparent()) {
            final Rectangle2D.Double k = hC.a().k;
            k.setRect(n - 5.0, n2 - 5.0, 10.0, 10.0);
            return this.shape.intersects(k) && (!this.shape.contains(n - 5.0, n2 - 5.0) || !this.shape.contains(n + 5.0, n2 - 5.0) || !this.shape.contains(n - 5.0, n2 + 5.0) || !this.shape.contains(n + 5.0, n2 + 5.0));
        }
        return this.shape.contains(n, n2);
    }
    
    public boolean findIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        final boolean z = fj.z;
        if (n == n3 && n2 == n4) {
            return false;
        }
        if (!this.contains(n, n2) || this.contains(n3, n4)) {
            return false;
        }
        if (this.t == 2 && n == this.getCenterX() && n2 == this.getCenterY()) {
            final double n5 = n3 - this.getCenterX();
            final double n6 = n4 - this.getCenterY();
            double n7 = 0.0;
            double n8 = 0.0;
            Label_0190: {
                if (this.width < 1.0E-6 || this.height < 1.0E-6) {
                    n7 = 0.0;
                    n8 = 0.0;
                    if (!z) {
                        break Label_0190;
                    }
                }
                final double n9 = this.width / this.height;
                final double n10 = 1.0 / Math.sqrt(n5 * n5 + n6 * n6 * n9 * n9);
                n7 = n5 * (this.width * 0.5) * n10;
                n8 = n9 * n6 * (this.height * 0.5) * n10;
            }
            point2D.setLocation(this.getCenterX() + n7, this.getCenterY() + n8);
            if (!z) {
                return true;
            }
        }
        if (this.t == 0 && n == this.getCenterX() && n2 == this.getCenterY()) {
            return !this.contains(n3, n4) && this.findBBIntersection(n, n2, n3, n4, point2D);
        }
        super.findIntersection(n, n2, n3, n4, point2D);
        return true;
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        super.calcUnionRect(rectangle2D);
        if ((this.s != 0 || this.r != 0) && this.v != null) {
            if (this.s > 0) {
                if (this.r > 0) {
                    rectangle2D.add(this.x + this.width + this.s, this.y + this.height + this.r);
                    if (!z) {
                        return;
                    }
                }
                rectangle2D.add(this.x + this.width + this.s, this.y + this.r);
                if (!z) {
                    return;
                }
            }
            if (this.r > 0) {
                rectangle2D.add(this.x + this.s, this.y + this.height + this.r);
                if (!z) {
                    return;
                }
            }
            rectangle2D.add(this.x + this.s, this.y + this.r);
        }
    }
    
    public void paintHotSpots(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if ((this.s != 0 || this.r != 0) && this.v != null) {
            final double width = this.width;
            final double height = this.height;
            final double x = this.x;
            final double y = this.y;
            Label_0103: {
                if (this.s >= 0) {
                    this.width += this.s;
                    if (!z) {
                        break Label_0103;
                    }
                }
                this.width -= this.s;
                this.x += this.s;
            }
            Label_0157: {
                if (this.r >= 0) {
                    this.height += this.r;
                    if (!z) {
                        break Label_0157;
                    }
                }
                this.y += this.r;
                this.height -= this.r;
            }
            super.paintHotSpots(graphics2D);
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            if (!z) {
                return;
            }
        }
        super.paintHotSpots(graphics2D);
    }
    
    public byte hotSpotHit(final double n, final double n2) {
        final boolean z = fj.z;
        if ((this.s != 0 || this.r != 0) && this.v != null) {
            final double width = this.width;
            final double height = this.height;
            final double x = this.x;
            final double y = this.y;
            Label_0104: {
                if (this.s >= 0) {
                    this.width += this.s;
                    if (!z) {
                        break Label_0104;
                    }
                }
                this.width -= this.s;
                this.x += this.s;
            }
            Label_0158: {
                if (this.r >= 0) {
                    this.height += this.r;
                    if (!z) {
                        break Label_0158;
                    }
                }
                this.y += this.r;
                this.height -= this.r;
            }
            final byte hotSpotHit = super.hotSpotHit(n, n2);
            this.width = width;
            this.height = height;
            this.x = x;
            this.y = y;
            return hotSpotHit;
        }
        return super.hotSpotHit(n, n2);
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeByte(1);
        super.write(objectOutputStream);
        objectOutputStream.writeByte(this.t);
        objectOutputStream.writeByte(this.s);
        objectOutputStream.writeByte(this.r);
        objectOutputStream.writeObject(this.v);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_0053: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    super.read(objectInputStream);
                    this.setShapeType(objectInputStream.readByte());
                    if (z) {
                        break Label_0053;
                    }
                    return;
                }
                case 1: {
                    super.read(objectInputStream);
                    this.setShapeType(objectInputStream.readByte());
                    this.s = objectInputStream.readByte();
                    this.r = objectInputStream.readByte();
                    this.v = (Color)objectInputStream.readObject();
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
    }
    
    public static Map shapeTypeToStringMap() {
        final HashMap<Byte, String> hashMap = new HashMap<Byte, String>(23);
        hashMap.put(new Byte((byte)0), "Rectangle");
        hashMap.put(new Byte((byte)1), "Round Rect");
        hashMap.put(new Byte((byte)2), "Ellipse");
        hashMap.put(new Byte((byte)3), "Parallelogram");
        hashMap.put(new Byte((byte)4), "Hexagon");
        hashMap.put(new Byte((byte)5), "Triangle");
        hashMap.put(new Byte((byte)6), "Rectangle 3D");
        hashMap.put(new Byte((byte)7), "Octagon");
        hashMap.put(new Byte((byte)8), "Diamond");
        hashMap.put(new Byte((byte)9), "Trapezoid");
        hashMap.put(new Byte((byte)10), "Trapezoid 2");
        return hashMap;
    }
    
    static {
        KEY_SLOPPY_RECT_PAINTING = new go();
        VALUE_SLOPPY_RECT_PAINTING_OFF = new gp();
        gn.ab = new Color(179, 166, 145);
    }
}
