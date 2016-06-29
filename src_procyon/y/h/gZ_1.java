package y.h;

import java.awt.font.*;
import javax.swing.*;
import java.awt.*;
import y.d.*;
import java.awt.geom.*;
import y.e.*;
import java.io.*;
import java.util.*;

public abstract class gZ
{
    private static FontRenderContext eb;
    static boolean l;
    public static final byte ALIGN_LEFT = 0;
    public static final byte ALIGN_CENTER = 1;
    public static final byte ALIGN_RIGHT = 2;
    public static final byte TOP_TEXT_POSITION = 1;
    public static final byte CENTER_TEXT_POSITION = 2;
    public static final byte BOTTOM_TEXT_POSITION = 4;
    public static final byte LEFT_TEXT_POSITION = 8;
    public static final byte RIGHT_TEXT_POSITION = 16;
    public static final byte LEFT_ALIGNED_TEXT_POSITION = 32;
    public static final byte RIGHT_ALIGNED_TEXT_POSITION = 64;
    byte z;
    byte t;
    byte u;
    boolean cb;
    protected n offsetRectangle;
    protected double width;
    protected double height;
    protected double contentWidth;
    protected double contentHeight;
    String o;
    boolean w;
    Color k;
    Color gb;
    Font fb;
    byte j;
    protected byte model;
    protected byte placement;
    protected boolean sizeDirty;
    protected boolean offsetDirty;
    Object q;
    Object m;
    Icon p;
    Insets x;
    hg db;
    float s;
    Color bb;
    byte v;
    public static final byte AUTOSIZE_CONTENT = 0;
    public static final byte AUTOSIZE_NONE = 4;
    boolean y;
    private static final Font ab;
    public static final Insets defaultInsets;
    static final boolean n;
    private static final hg r;
    static Class class$y$view$YLabel$Layout;
    static Class class$y$view$YLabel$Painter;
    static Class class$y$view$YLabel$BoundsProvider;
    static Class class$y$view$YLabel$UserDataHandler;
    static Class class$y$view$YLabel$SelectionChangeHandler;
    
    public Object getUserData() {
        return this.m;
    }
    
    public void setUserData(final Object m) {
        this.m = m;
    }
    
    public double getContentWidth() {
        return this.contentWidth;
    }
    
    public void setContentWidth(final double contentWidth) {
        this.contentWidth = contentWidth;
        this.setSizeDirty();
    }
    
    public n getContentBox() {
        final n orientedBox = this.getOrientedBox();
        final n g = orientedBox.g(this.contentWidth, this.contentHeight);
        final float s = this.s;
        if (s != 0.0f) {
            final double radians = Math.toRadians(s);
            final double sin = Math.sin(radians);
            final double cos = Math.cos(radians);
            final double g2 = g.g();
            final double i = g.i();
            g.c(cos * g2 - sin * i, sin * g2 + cos * i);
        }
        final t k = orientedBox.k();
        g.e(k.a(), k.b());
        return g;
    }
    
    public boolean isSelected() {
        return this.y;
    }
    
    public void setSelected(final boolean y) {
        if (y != this.y) {
            this.y = y;
            this.b();
            if (this.db.f != null) {
                this.db.f.a(this);
            }
        }
    }
    
    void b() {
    }
    
    public double getContentHeight() {
        return this.contentHeight;
    }
    
    public void setContentHeight(final double contentHeight) {
        this.contentHeight = contentHeight;
        this.setSizeDirty();
    }
    
    public void setContentSize(final double contentWidth, final double contentHeight) {
        this.contentWidth = contentWidth;
        this.contentHeight = contentHeight;
        Label_0405: {
            if (this.s != 0.0f) {
                final double n = 0.0;
                final double n2 = 0.0;
                final double n3 = 0.0;
                final double n4 = 0.0;
                final Point2D.Double double1 = new Point2D.Double();
                final AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(this.s));
                double1.x = -0.5 * contentWidth;
                double1.y = -0.5 * contentHeight;
                rotateInstance.transform(double1, double1);
                final double max = Math.max(n, double1.x);
                final double max2 = Math.max(n2, double1.y);
                final double min = Math.min(n3, double1.x);
                final double min2 = Math.min(n4, double1.y);
                double1.x = 0.5 * contentWidth;
                double1.y = 0.5 * contentHeight;
                rotateInstance.transform(double1, double1);
                final double max3 = Math.max(max, double1.x);
                final double max4 = Math.max(max2, double1.y);
                final double min3 = Math.min(min, double1.x);
                final double min4 = Math.min(min2, double1.y);
                double1.x = -0.5 * contentWidth;
                double1.y = 0.5 * contentHeight;
                rotateInstance.transform(double1, double1);
                final double max5 = Math.max(max3, double1.x);
                final double max6 = Math.max(max4, double1.y);
                final double min5 = Math.min(min3, double1.x);
                final double min6 = Math.min(min4, double1.y);
                double1.x = 0.5 * contentWidth;
                double1.y = -0.5 * contentHeight;
                rotateInstance.transform(double1, double1);
                final double max7 = Math.max(max5, double1.x);
                final double max8 = Math.max(max6, double1.y);
                final double min7 = Math.min(min5, double1.x);
                final double min8 = Math.min(min6, double1.y);
                this.width = max7 - min7;
                this.height = max8 - min8;
                if (!fj.z) {
                    break Label_0405;
                }
            }
            this.width = this.contentWidth;
            this.height = this.contentHeight;
        }
        this.offsetDirty = true;
    }
    
    protected gZ() {
        this.z = 2;
        this.t = 4;
        this.u = 4;
        this.w = true;
        this.v = 0;
        this.fb = gZ.ab;
        this.j = 1;
        this.bb = Color.black;
        this.sizeDirty = true;
        this.offsetDirty = true;
        this.offsetRectangle = new n(0.0, 0.0, 0.0, 0.0, 0.0, -1.0);
        this.db = this.c();
    }
    
    hg c() {
        return gZ.r;
    }
    
    public void paint(final Graphics2D graphics2D) {
        this.db.a.a(this, graphics2D);
    }
    
    protected void paintBox(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        this.db.a.a(this, graphics2D, n, n2, n3, n4);
    }
    
    public boolean contains(final double n, final double n2) {
        return this.db.c.a(this, n, n2);
    }
    
    protected void paintContent(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        this.db.a.b(this, graphics2D, n, n2, n3, n4);
    }
    
    protected void paintImpl(final Graphics2D graphics2D, final double n, final double n2, final double n3, final double n4) {
        this.paintBox(graphics2D, n, n2, n3, n4);
        this.paintContent(graphics2D, n, n2, n3, n4);
    }
    
    public static void setHTMLRenderingEnabled(final boolean l) {
        gZ.l = l;
    }
    
    static boolean b(final gZ gz, final Graphics2D graphics2D) {
        return gz.isSelected() && hk.b(graphics2D);
    }
    
    public boolean isSizeDirty() {
        return this.sizeDirty;
    }
    
    public boolean isOffsetDirty() {
        return this.offsetDirty;
    }
    
    public void setSizeDirty() {
        this.sizeDirty = true;
        this.offsetDirty = true;
    }
    
    public final void internalSetSizeDirty(final boolean sizeDirty) {
        this.sizeDirty = sizeDirty;
    }
    
    public void setOffsetDirty() {
        this.offsetDirty = true;
    }
    
    public final void internalSetOffsetDirty(final boolean offsetDirty) {
        this.offsetDirty = offsetDirty;
    }
    
    public abstract void calculateOffset();
    
    public void calculateSize() {
        this.calculateSize(d());
    }
    
    public void calculateSize(final FontRenderContext fontRenderContext) {
        this.sizeDirty = false;
        this.db.c.a(this, fontRenderContext);
    }
    
    public final y getBox() {
        return this.getOrientedBox().h();
    }
    
    public abstract n getOrientedBox();
    
    public abstract void repaint();
    
    public void setVerticalTextPosition(final byte t) {
        this.t = t;
        this.setSizeDirty();
    }
    
    public byte getVerticalTextPosition() {
        return this.t;
    }
    
    public void setHorizontalTextPosition(final byte z) {
        this.z = z;
        this.setSizeDirty();
    }
    
    public byte getHorizontalTextPosition() {
        return this.z;
    }
    
    public void setIconTextGap(final byte u) {
        this.u = u;
        this.setSizeDirty();
    }
    
    public byte getIconTextGap() {
        return this.u;
    }
    
    public void setUnderlinedTextEnabled(final boolean cb) {
        this.cb = cb;
    }
    
    public boolean isUnderlinedTextEnabled() {
        return this.cb;
    }
    
    public void setRotationAngle(double n) {
        n %= 360.0;
        if (n < 0.0) {
            n += 360.0;
        }
        if (n != this.s) {
            this.s = (float)n;
            this.setSizeDirty();
        }
    }
    
    public double getRotationAngle() {
        return this.s;
    }
    
    public void setInsets(final Insets x) {
        this.x = x;
        this.setSizeDirty();
    }
    
    public Insets getInsets() {
        return this.x;
    }
    
    public void setIcon(final Icon p) {
        this.p = p;
        this.setSizeDirty();
    }
    
    public Icon getIcon() {
        return this.p;
    }
    
    public void setTextColor(final Color bb) {
        this.bb = bb;
    }
    
    public Color getTextColor() {
        return this.bb;
    }
    
    public boolean isVisible() {
        return this.w;
    }
    
    public void setVisible(final boolean w) {
        this.w = w;
    }
    
    public byte getPosition() {
        return this.placement;
    }
    
    public void setPosition(final byte placement) {
        this.placement = placement;
        this.setOffsetDirty();
    }
    
    public byte getModel() {
        return this.model;
    }
    
    public void setModel(final byte model) {
        this.model = model;
        this.setOffsetDirty();
    }
    
    public void setBackgroundColor(final Color k) {
        this.k = k;
    }
    
    public Color getBackgroundColor() {
        return this.k;
    }
    
    public void setLineColor(final Color gb) {
        this.gb = gb;
    }
    
    public Color getLineColor() {
        return this.gb;
    }
    
    public void setText(final String o) {
        if (o == null) {
            this.o = "";
        }
        else {
            if (o.equals(this.o)) {
                return;
            }
            this.o = o;
        }
        this.setSizeDirty();
    }
    
    public String getText() {
        return this.o;
    }
    
    public void setOffset(final n offsetRectangle) {
        this.offsetRectangle = offsetRectangle;
        this.offsetDirty = this.sizeDirty;
    }
    
    public n getOffset() {
        if (this.offsetDirty) {
            this.calculateOffset();
        }
        return this.offsetRectangle;
    }
    
    public double getOffsetX() {
        return this.getOffset().h().c();
    }
    
    public double getOffsetY() {
        return this.getOffset().h().d();
    }
    
    public void setOffsetX(final double n) {
        this.setOffset(n, this.offsetRectangle.h().d());
    }
    
    public void setOffsetY(final double n) {
        this.setOffset(this.offsetRectangle.h().c(), n);
    }
    
    public void setOffset(final double n, final double n2) {
        this.c(n, n2);
    }
    
    void c(final double n, final double n2) {
        this.setOffset(new n(n, n2 + this.height, this.width, this.height));
    }
    
    public t getLocation() {
        return this.getBox().e();
    }
    
    public void setAlignment(final byte j) {
        this.j = j;
        this.setOffsetDirty();
    }
    
    public byte getAlignment() {
        return this.j;
    }
    
    public t getTextLocation() {
        return this.b(this.getTextBox());
    }
    
    public n getTextBox() {
        return this.db.a.a(this);
    }
    
    public t getIconLocation() {
        return this.b(this.getIconBox());
    }
    
    public n getIconBox() {
        return this.db.a.b(this);
    }
    
    public n transformCTW(final n n) {
        final n contentBox = this.getContentBox();
        final double g = contentBox.g();
        final double i = contentBox.i();
        final double b = n.b();
        final double c = n.c();
        final double g2 = n.g();
        final double j = n.i();
        return new n(contentBox.b() - i * b - g * c, contentBox.c() + g * b - i * c, n.e(), n.f(), -i * g2 - g * j, g * g2 - i * j);
    }
    
    private t b(final n n) {
        return this.transformCTW(n).h().e();
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        final y box = this.getBox();
        return box.c + box.a >= n && box.c <= n + n3 && box.d + box.b >= n2 && box.d <= n2 + n4;
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        if (this.db.d != null) {
            this.db.d.a(this, rectangle2D);
            if (!z) {
                return;
            }
        }
        final y box = this.getBox();
        if (rectangle2D.getWidth() < 0.0 || rectangle2D.getHeight() < 0.0) {
            rectangle2D.setRect(box.c, box.d, box.a, box.b);
            if (!z) {
                return;
            }
        }
        rectangle2D.setFrameFromDiagonal(Math.min(box.c, rectangle2D.getX()), Math.min(box.d, rectangle2D.getY()), Math.max(box.c + box.a, rectangle2D.getX() + rectangle2D.getWidth()), Math.max(box.d + box.b, rectangle2D.getY() + rectangle2D.getWidth()));
    }
    
    public abstract void setModelParameter(final Object p0);
    
    public abstract Object getBestModelParameterForBounds(final n p0);
    
    void b(final double width, final double height) {
        Label_0027: {
            if (this.sizeDirty) {
                this.sizeDirty = false;
                this.calculateSize();
                if (!fj.z) {
                    break Label_0027;
                }
            }
            this.sizeDirty = false;
        }
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        return this.width;
    }
    
    public double getHeight() {
        if (this.isSizeDirty()) {
            this.calculateSize();
        }
        return this.height;
    }
    
    public String toString() {
        return this.o;
    }
    
    public Font getFont() {
        return this.fb;
    }
    
    public void setFont(final Font fb) {
        if (!fb.equals(this.fb)) {
            this.fb = fb;
            this.setSizeDirty();
        }
    }
    
    public String getFontName() {
        return this.fb.getName();
    }
    
    public void setFontName(final String s) {
        this.setFont(new Font(s, this.fb.getStyle(), this.fb.getSize()));
    }
    
    public int getFontSize() {
        return this.fb.getSize();
    }
    
    public void setFontSize(final int n) {
        this.setFont(this.fb.deriveFont((float)n));
    }
    
    public int getFontStyle() {
        return this.fb.getStyle();
    }
    
    public void setFontStyle(final int n) {
        this.setFont(this.fb.deriveFont(n));
    }
    
    public void adoptValues(final gZ gz) {
        this.setText(gz.getText());
        this.setModel(gz.getModel());
        this.setVisible(gz.isVisible());
        this.setPosition(gz.getPosition());
        this.setBackgroundColor(gz.getBackgroundColor());
        this.setAutoSizePolicy(gz.getAutoSizePolicy());
        this.setTextColor(gz.getTextColor());
        this.setAlignment(gz.getAlignment());
        this.setFont(gz.getFont());
        this.offsetRectangle = new n(gz.offsetRectangle);
        this.setLineColor(gz.getLineColor());
        this.setIcon(gz.getIcon());
        this.setSelected(gz.isSelected());
        this.setHorizontalTextPosition(gz.getHorizontalTextPosition());
        this.setVerticalTextPosition(gz.getVerticalTextPosition());
        this.setIconTextGap(gz.getIconTextGap());
        this.setInsets(gz.getInsets());
        this.setRotationAngle(gz.getRotationAngle());
        this.setUnderlinedTextEnabled(gz.isUnderlinedTextEnabled());
        this.db = gz.db;
        Label_0210: {
            if (this.db.e != null) {
                this.m = this.db.e.a(gz, gz.m, this);
                if (!fj.z) {
                    break Label_0210;
                }
            }
            this.m = null;
        }
        this.b(gz.getWidth(), gz.getHeight());
        this.setContentSize(gz.getContentWidth(), gz.getContentHeight());
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final boolean z = fj.z;
        objectOutputStream.writeByte(11);
        objectOutputStream.writeDouble(this.offsetRectangle.b());
        objectOutputStream.writeDouble(this.offsetRectangle.c());
        objectOutputStream.writeDouble(this.offsetRectangle.e());
        objectOutputStream.writeDouble(this.offsetRectangle.f());
        objectOutputStream.writeDouble(this.offsetRectangle.g());
        objectOutputStream.writeDouble(this.offsetRectangle.i());
        objectOutputStream.writeByte(this.getAutoSizePolicy());
        objectOutputStream.writeFloat((float)this.contentWidth);
        objectOutputStream.writeFloat((float)this.contentHeight);
        objectOutputStream.writeFloat(this.s);
        objectOutputStream.writeObject(this.getText());
        objectOutputStream.writeByte(this.getModel());
        objectOutputStream.writeByte(this.getPosition());
        objectOutputStream.writeBoolean(this.w);
        objectOutputStream.writeByte(this.j);
        objectOutputStream.writeObject(this.fb);
        objectOutputStream.writeObject(this.bb);
        objectOutputStream.writeObject(this.getIcon());
        objectOutputStream.writeObject(this.k);
        objectOutputStream.writeObject(this.gb);
        objectOutputStream.writeObject(this.x);
        objectOutputStream.writeByte(this.t);
        objectOutputStream.writeByte(this.z);
        objectOutputStream.writeByte(this.u);
        Label_0288: {
            if (this.getConfiguration() != null) {
                objectOutputStream.writeObject(this.getConfiguration());
                if (this.db.e != null) {
                    objectOutputStream.writeBoolean(true);
                    this.db.e.a(this, this.getUserData(), objectOutputStream);
                    if (!z) {
                        break Label_0288;
                    }
                }
                objectOutputStream.writeBoolean(false);
                if (!z) {
                    break Label_0288;
                }
            }
            objectOutputStream.writeObject(null);
        }
        objectOutputStream.writeBoolean(this.cb);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        Label_1864: {
            switch (objectInputStream.readByte()) {
                case 0: {
                    objectInputStream.readByte();
                    objectInputStream.readObject();
                    this.fb = this.b(objectInputStream);
                    this.j = objectInputStream.readByte();
                    final float float1 = objectInputStream.readFloat();
                    final float float2 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float1, float2);
                    this.b(objectInputStream.readByte(), objectInputStream.readByte());
                    this.w = objectInputStream.readBoolean();
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 1: {
                    final float float3 = objectInputStream.readFloat();
                    final float float4 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float3, float4);
                    final byte byte1 = objectInputStream.readByte();
                    final byte byte2 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.b(byte1, byte2);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 2: {
                    final float float5 = objectInputStream.readFloat();
                    final float float6 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float5, float6);
                    final byte byte3 = objectInputStream.readByte();
                    final byte byte4 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.b(byte3, byte4);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 3: {
                    final float float7 = objectInputStream.readFloat();
                    final float float8 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float7, float8);
                    final byte byte5 = objectInputStream.readByte();
                    final byte byte6 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.setIcon((Icon)objectInputStream.readObject());
                    this.b(byte5, byte6);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 4: {
                    final float float9 = objectInputStream.readFloat();
                    final float float10 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float9, float10);
                    final byte byte7 = objectInputStream.readByte();
                    final byte byte8 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.b(byte7, byte8);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 5: {
                    final float float11 = objectInputStream.readFloat();
                    final float float12 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float11, float12);
                    final byte byte9 = objectInputStream.readByte();
                    final byte byte10 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.b(byte9, byte10);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 6: {
                    final float float13 = objectInputStream.readFloat();
                    final float float14 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.s = objectInputStream.readShort();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float13, float14);
                    final byte byte11 = objectInputStream.readByte();
                    final byte byte12 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.b(byte11, byte12);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 7: {
                    final float float15 = objectInputStream.readFloat();
                    final float float16 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.s = objectInputStream.readShort();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float15, float16);
                    final byte byte13 = objectInputStream.readByte();
                    final byte byte14 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.t = objectInputStream.readByte();
                    this.z = objectInputStream.readByte();
                    this.u = objectInputStream.readByte();
                    this.b(byte13, byte14);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 8: {
                    final float float17 = objectInputStream.readFloat();
                    final float float18 = objectInputStream.readFloat();
                    this.width = objectInputStream.readFloat();
                    this.height = objectInputStream.readFloat();
                    this.s = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    this.c(float17, float18);
                    final byte byte15 = objectInputStream.readByte();
                    final byte byte16 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    if (objectInputStream.readBoolean()) {
                        this.setBackgroundColor(Color.white);
                    }
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.t = objectInputStream.readByte();
                    this.z = objectInputStream.readByte();
                    this.u = objectInputStream.readByte();
                    this.b(byte15, byte16);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 9: {
                    final float float19 = objectInputStream.readFloat();
                    final float float20 = objectInputStream.readFloat();
                    this.v = objectInputStream.readByte();
                    this.contentWidth = objectInputStream.readFloat();
                    this.contentHeight = objectInputStream.readFloat();
                    this.s = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    final byte byte17 = objectInputStream.readByte();
                    final byte byte18 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.t = objectInputStream.readByte();
                    this.z = objectInputStream.readByte();
                    this.u = objectInputStream.readByte();
                    this.c(objectInputStream);
                    this.setContentSize(this.contentWidth, this.contentHeight);
                    this.c(float19, float20);
                    this.b(byte17, byte18);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 10: {
                    final float float21 = objectInputStream.readFloat();
                    final float float22 = objectInputStream.readFloat();
                    this.v = objectInputStream.readByte();
                    this.contentWidth = objectInputStream.readFloat();
                    this.contentHeight = objectInputStream.readFloat();
                    this.s = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    final byte byte19 = objectInputStream.readByte();
                    final byte byte20 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.t = objectInputStream.readByte();
                    this.z = objectInputStream.readByte();
                    this.u = objectInputStream.readByte();
                    this.c(objectInputStream);
                    this.cb = objectInputStream.readBoolean();
                    this.setContentSize(this.contentWidth, this.contentHeight);
                    this.c(float21, float22);
                    this.b(byte19, byte20);
                    if (z) {
                        break Label_1864;
                    }
                    return;
                }
                case 11: {
                    this.offsetRectangle = new n(objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble(), objectInputStream.readDouble());
                    this.v = objectInputStream.readByte();
                    this.contentWidth = objectInputStream.readFloat();
                    this.contentHeight = objectInputStream.readFloat();
                    this.s = objectInputStream.readFloat();
                    this.setText((String)objectInputStream.readObject());
                    final byte byte21 = objectInputStream.readByte();
                    final byte byte22 = objectInputStream.readByte();
                    this.w = objectInputStream.readBoolean();
                    this.j = objectInputStream.readByte();
                    this.fb = this.b(objectInputStream);
                    this.bb = (Color)objectInputStream.readObject();
                    this.p = (Icon)objectInputStream.readObject();
                    this.k = (Color)objectInputStream.readObject();
                    this.gb = (Color)objectInputStream.readObject();
                    this.x = (Insets)objectInputStream.readObject();
                    this.t = objectInputStream.readByte();
                    this.z = objectInputStream.readByte();
                    this.u = objectInputStream.readByte();
                    this.c(objectInputStream);
                    this.cb = objectInputStream.readBoolean();
                    this.setContentSize(this.contentWidth, this.contentHeight);
                    this.b(byte21, byte22);
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a();
    }
    
    private void b(final byte model, final byte position) {
        this.offsetDirty = false;
        this.sizeDirty = false;
        this.setModel(model);
        this.setPosition(position);
        this.sizeDirty = true;
    }
    
    private void c(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final String configuration = (String)objectInputStream.readObject();
        if (configuration == null) {
            this.db = this.c();
            if (!z) {
                return;
            }
        }
        this.setConfiguration(configuration);
        if (objectInputStream.readBoolean()) {
            if (this.db.e == null) {
                throw new IOException("No user data handler found for configuration to read user data.");
            }
            this.m = this.db.e.a(this, objectInputStream);
            if (!z) {
                return;
            }
        }
        this.m = null;
    }
    
    public abstract void setConfiguration(final String p0);
    
    public String getConfiguration() {
        return (this.db != null) ? this.db.b : null;
    }
    
    public void setAutoSizePolicy(final byte v) {
        this.v = v;
        this.setSizeDirty();
    }
    
    public void internalSetAutoSizePolicy(final byte v) {
        this.v = v;
    }
    
    public byte getAutoSizePolicy() {
        return this.v;
    }
    
    private Font b(final ObjectInputStream objectInputStream) {
        Font font = (Font)objectInputStream.readObject();
        if (gZ.n) {
            font = new Font(font.getFontName(), font.getStyle(), Math.round(font.getSize2D()));
        }
        return font;
    }
    
    private static FontRenderContext d() {
        return gZ.eb;
    }
    
    private static void b(final FontRenderContext eb) {
        if (eb == null) {
            throw new IllegalArgumentException("FontRenderContext cannot be null");
        }
        gZ.eb = eb;
    }
    
    public static void setFractionMetricsForSizeCalculationEnabled(final boolean b) {
        gZ.eb = new FontRenderContext(new AffineTransform(), true, b);
    }
    
    public static boolean isFractionMetricsForSizeCalculationEnabled() {
        return gZ.eb.usesFractionalMetrics();
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static FontRenderContext access$000() {
        return d();
    }
    
    static {
        gZ.eb = new FontRenderContext(new AffineTransform(), false, false);
        gZ.l = true;
        ab = new Font("Dialog", 0, 12);
        defaultInsets = new Insets(2, 2, 2, 2);
        final HashMap<Class, hh> hashMap = new HashMap<Class, hh>();
        hashMap.put((gZ.class$y$view$YLabel$Layout == null) ? (gZ.class$y$view$YLabel$Layout = class$("y.h.hc")) : gZ.class$y$view$YLabel$Layout, hh.d);
        hashMap.put((gZ.class$y$view$YLabel$Painter == null) ? (gZ.class$y$view$YLabel$Painter = class$("y.h.hd")) : gZ.class$y$view$YLabel$Painter, hh.d);
        hashMap.put((gZ.class$y$view$YLabel$BoundsProvider == null) ? (gZ.class$y$view$YLabel$BoundsProvider = class$("y.h.ha")) : gZ.class$y$view$YLabel$BoundsProvider, hh.d);
        hashMap.put((gZ.class$y$view$YLabel$UserDataHandler == null) ? (gZ.class$y$view$YLabel$UserDataHandler = class$("y.h.hf")) : gZ.class$y$view$YLabel$UserDataHandler, (hh)new gs((byte)0));
        r = new hg(hashMap, hashMap, "default");
        boolean startsWith = false;
        try {
            startsWith = System.getProperty("os.name").toLowerCase().startsWith("mac");
        }
        catch (Exception ex) {}
        n = startsWith;
    }
}
