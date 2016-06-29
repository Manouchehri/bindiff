/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import y.d.n;
import y.d.t;
import y.d.y;
import y.e.a;
import y.h.fj;
import y.h.gs;
import y.h.ha;
import y.h.hc;
import y.h.hd;
import y.h.he;
import y.h.hf;
import y.h.hg;
import y.h.hh;
import y.h.hk;

public abstract class gZ {
    private static FontRenderContext eb = new FontRenderContext(new AffineTransform(), false, false);
    static boolean l = true;
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
    byte z = 2;
    byte t = 4;
    byte u = 4;
    boolean cb;
    protected n offsetRectangle = new n(0.0, 0.0, 0.0, 0.0, 0.0, -1.0);
    protected double width;
    protected double height;
    protected double contentWidth;
    protected double contentHeight;
    String o;
    boolean w = true;
    Color k;
    Color gb;
    Font fb = ab;
    byte j = 1;
    protected byte model;
    protected byte placement;
    protected boolean sizeDirty = true;
    protected boolean offsetDirty = true;
    Object q;
    Object m;
    Icon p;
    Insets x;
    hg db;
    float s;
    Color bb = Color.black;
    byte v = 0;
    public static final byte AUTOSIZE_CONTENT = 0;
    public static final byte AUTOSIZE_NONE = 4;
    boolean y;
    private static final Font ab = new Font("Dialog", 0, 12);
    public static final Insets defaultInsets = new Insets(2, 2, 2, 2);
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

    public void setUserData(Object object) {
        this.m = object;
    }

    public double getContentWidth() {
        return this.contentWidth;
    }

    public void setContentWidth(double d2) {
        this.contentWidth = d2;
        this.setSizeDirty();
    }

    public n getContentBox() {
        n n2 = this.getOrientedBox();
        n n3 = n2.g(this.contentWidth, this.contentHeight);
        float f2 = this.s;
        if (f2 != 0.0f) {
            double d2 = Math.toRadians(f2);
            double d3 = Math.sin(d2);
            double d4 = Math.cos(d2);
            double d5 = n3.g();
            double d6 = n3.i();
            n3.c(d4 * d5 - d3 * d6, d3 * d5 + d4 * d6);
        }
        t t2 = n2.k();
        n3.e(t2.a(), t2.b());
        return n3;
    }

    public boolean isSelected() {
        return this.y;
    }

    public void setSelected(boolean bl2) {
        if (bl2 == this.y) return;
        this.y = bl2;
        this.b();
        if (this.db.f == null) return;
        this.db.f.a(this);
    }

    void b() {
    }

    public double getContentHeight() {
        return this.contentHeight;
    }

    public void setContentHeight(double d2) {
        this.contentHeight = d2;
        this.setSizeDirty();
    }

    /*
     * Unable to fully structure code
     */
    public void setContentSize(double var1_1, double var3_2) {
        this.contentWidth = var1_1;
        this.contentHeight = var3_2;
        if (this.s == 0.0f) ** GOTO lbl-1000
        var5_3 = 0.0;
        var7_4 = 0.0;
        var9_5 = 0.0;
        var11_6 = 0.0;
        var13_7 = new Point2D.Double();
        var14_8 = AffineTransform.getRotateInstance(Math.toRadians(this.s));
        var13_7.x = -0.5 * var1_1;
        var13_7.y = -0.5 * var3_2;
        var14_8.transform(var13_7, var13_7);
        var5_3 = Math.max(var5_3, var13_7.x);
        var7_4 = Math.max(var7_4, var13_7.y);
        var9_5 = Math.min(var9_5, var13_7.x);
        var11_6 = Math.min(var11_6, var13_7.y);
        var13_7.x = 0.5 * var1_1;
        var13_7.y = 0.5 * var3_2;
        var14_8.transform(var13_7, var13_7);
        var5_3 = Math.max(var5_3, var13_7.x);
        var7_4 = Math.max(var7_4, var13_7.y);
        var9_5 = Math.min(var9_5, var13_7.x);
        var11_6 = Math.min(var11_6, var13_7.y);
        var13_7.x = -0.5 * var1_1;
        var13_7.y = 0.5 * var3_2;
        var14_8.transform(var13_7, var13_7);
        var5_3 = Math.max(var5_3, var13_7.x);
        var7_4 = Math.max(var7_4, var13_7.y);
        var9_5 = Math.min(var9_5, var13_7.x);
        var11_6 = Math.min(var11_6, var13_7.y);
        var13_7.x = 0.5 * var1_1;
        var13_7.y = -0.5 * var3_2;
        var14_8.transform(var13_7, var13_7);
        var5_3 = Math.max(var5_3, var13_7.x);
        var7_4 = Math.max(var7_4, var13_7.y);
        var9_5 = Math.min(var9_5, var13_7.x);
        var11_6 = Math.min(var11_6, var13_7.y);
        this.width = var5_3 - var9_5;
        this.height = var7_4 - var11_6;
        if (fj.z) lbl-1000: // 2 sources:
        {
            this.width = this.contentWidth;
            this.height = this.contentHeight;
        }
        this.offsetDirty = true;
    }

    protected gZ() {
        this.db = this.c();
    }

    hg c() {
        return r;
    }

    public void paint(Graphics2D graphics2D) {
        this.db.a.a(this, graphics2D);
    }

    protected void paintBox(Graphics2D graphics2D, double d2, double d3, double d4, double d5) {
        this.db.a.a(this, graphics2D, d2, d3, d4, d5);
    }

    public boolean contains(double d2, double d3) {
        return this.db.c.a(this, d2, d3);
    }

    protected void paintContent(Graphics2D graphics2D, double d2, double d3, double d4, double d5) {
        this.db.a.b(this, graphics2D, d2, d3, d4, d5);
    }

    protected void paintImpl(Graphics2D graphics2D, double d2, double d3, double d4, double d5) {
        this.paintBox(graphics2D, d2, d3, d4, d5);
        this.paintContent(graphics2D, d2, d3, d4, d5);
    }

    public static void setHTMLRenderingEnabled(boolean bl2) {
        l = bl2;
    }

    static boolean b(gZ gZ2, Graphics2D graphics2D) {
        if (!gZ2.isSelected()) return false;
        if (!hk.b(graphics2D)) return false;
        return true;
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

    public final void internalSetSizeDirty(boolean bl2) {
        this.sizeDirty = bl2;
    }

    public void setOffsetDirty() {
        this.offsetDirty = true;
    }

    public final void internalSetOffsetDirty(boolean bl2) {
        this.offsetDirty = bl2;
    }

    public abstract void calculateOffset();

    public void calculateSize() {
        this.calculateSize(gZ.d());
    }

    public void calculateSize(FontRenderContext fontRenderContext) {
        this.sizeDirty = false;
        this.db.c.a(this, fontRenderContext);
    }

    public final y getBox() {
        return this.getOrientedBox().h();
    }

    public abstract n getOrientedBox();

    public abstract void repaint();

    public void setVerticalTextPosition(byte by2) {
        this.t = by2;
        this.setSizeDirty();
    }

    public byte getVerticalTextPosition() {
        return this.t;
    }

    public void setHorizontalTextPosition(byte by2) {
        this.z = by2;
        this.setSizeDirty();
    }

    public byte getHorizontalTextPosition() {
        return this.z;
    }

    public void setIconTextGap(byte by2) {
        this.u = by2;
        this.setSizeDirty();
    }

    public byte getIconTextGap() {
        return this.u;
    }

    public void setUnderlinedTextEnabled(boolean bl2) {
        this.cb = bl2;
    }

    public boolean isUnderlinedTextEnabled() {
        return this.cb;
    }

    public void setRotationAngle(double d2) {
        if ((d2 %= 360.0) < 0.0) {
            d2 += 360.0;
        }
        if (d2 == (double)this.s) return;
        this.s = (float)d2;
        this.setSizeDirty();
    }

    public double getRotationAngle() {
        return this.s;
    }

    public void setInsets(Insets insets) {
        this.x = insets;
        this.setSizeDirty();
    }

    public Insets getInsets() {
        return this.x;
    }

    public void setIcon(Icon icon) {
        this.p = icon;
        this.setSizeDirty();
    }

    public Icon getIcon() {
        return this.p;
    }

    public void setTextColor(Color color) {
        this.bb = color;
    }

    public Color getTextColor() {
        return this.bb;
    }

    public boolean isVisible() {
        return this.w;
    }

    public void setVisible(boolean bl2) {
        this.w = bl2;
    }

    public byte getPosition() {
        return this.placement;
    }

    public void setPosition(byte by2) {
        this.placement = by2;
        this.setOffsetDirty();
    }

    public byte getModel() {
        return this.model;
    }

    public void setModel(byte by2) {
        this.model = by2;
        this.setOffsetDirty();
    }

    public void setBackgroundColor(Color color) {
        this.k = color;
    }

    public Color getBackgroundColor() {
        return this.k;
    }

    public void setLineColor(Color color) {
        this.gb = color;
    }

    public Color getLineColor() {
        return this.gb;
    }

    public void setText(String string) {
        if (string == null) {
            this.o = "";
        } else {
            if (string.equals(this.o)) return;
            this.o = string;
        }
        this.setSizeDirty();
    }

    public String getText() {
        return this.o;
    }

    public void setOffset(n n2) {
        this.offsetRectangle = n2;
        this.offsetDirty = this.sizeDirty;
    }

    public n getOffset() {
        if (!this.offsetDirty) return this.offsetRectangle;
        this.calculateOffset();
        return this.offsetRectangle;
    }

    public double getOffsetX() {
        n n2 = this.getOffset();
        return n2.h().c();
    }

    public double getOffsetY() {
        n n2 = this.getOffset();
        return n2.h().d();
    }

    public void setOffsetX(double d2) {
        this.setOffset(d2, this.offsetRectangle.h().d());
    }

    public void setOffsetY(double d2) {
        this.setOffset(this.offsetRectangle.h().c(), d2);
    }

    public void setOffset(double d2, double d3) {
        this.c(d2, d3);
    }

    void c(double d2, double d3) {
        this.setOffset(new n(d2, d3 + this.height, this.width, this.height));
    }

    public t getLocation() {
        return this.getBox().e();
    }

    public void setAlignment(byte by2) {
        this.j = by2;
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

    public n transformCTW(n n2) {
        n n3 = this.getContentBox();
        double d2 = n3.g();
        double d3 = n3.i();
        double d4 = n2.b();
        double d5 = n2.c();
        double d6 = n2.g();
        double d7 = n2.i();
        return new n(n3.b() - d3 * d4 - d2 * d5, n3.c() + d2 * d4 - d3 * d5, n2.e(), n2.f(), (- d3) * d6 - d2 * d7, d2 * d6 - d3 * d7);
    }

    private t b(n n2) {
        return this.transformCTW(n2).h().e();
    }

    public boolean intersects(double d2, double d3, double d4, double d5) {
        y y2 = this.getBox();
        if (y2.c + y2.a < d2) return false;
        if (y2.c > d2 + d4) return false;
        if (y2.d + y2.b < d3) return false;
        if (y2.d > d3 + d5) return false;
        return true;
    }

    public void calcUnionRect(Rectangle2D rectangle2D) {
        boolean bl2 = fj.z;
        if (this.db.d != null) {
            this.db.d.a(this, rectangle2D);
            if (!bl2) return;
        }
        y y2 = this.getBox();
        if (rectangle2D.getWidth() < 0.0 || rectangle2D.getHeight() < 0.0) {
            rectangle2D.setRect(y2.c, y2.d, y2.a, y2.b);
            if (!bl2) return;
        }
        rectangle2D.setFrameFromDiagonal(Math.min(y2.c, rectangle2D.getX()), Math.min(y2.d, rectangle2D.getY()), Math.max(y2.c + y2.a, rectangle2D.getX() + rectangle2D.getWidth()), Math.max(y2.d + y2.b, rectangle2D.getY() + rectangle2D.getWidth()));
    }

    public abstract void setModelParameter(Object var1);

    public abstract Object getBestModelParameterForBounds(n var1);

    void b(double d2, double d3) {
        block2 : {
            if (this.sizeDirty) {
                this.sizeDirty = false;
                this.calculateSize();
                if (!fj.z) break block2;
            }
            this.sizeDirty = false;
        }
        this.width = d2;
        this.height = d3;
    }

    public double getWidth() {
        if (!this.isSizeDirty()) return this.width;
        this.calculateSize();
        return this.width;
    }

    public double getHeight() {
        if (!this.isSizeDirty()) return this.height;
        this.calculateSize();
        return this.height;
    }

    public String toString() {
        return this.o;
    }

    public Font getFont() {
        return this.fb;
    }

    public void setFont(Font font) {
        if (font.equals(this.fb)) return;
        this.fb = font;
        this.setSizeDirty();
    }

    public String getFontName() {
        return this.fb.getName();
    }

    public void setFontName(String string) {
        this.setFont(new Font(string, this.fb.getStyle(), this.fb.getSize()));
    }

    public int getFontSize() {
        return this.fb.getSize();
    }

    public void setFontSize(int n2) {
        this.setFont(this.fb.deriveFont((float)n2));
    }

    public int getFontStyle() {
        return this.fb.getStyle();
    }

    public void setFontStyle(int n2) {
        this.setFont(this.fb.deriveFont(n2));
    }

    public void adoptValues(gZ gZ2) {
        block2 : {
            this.setText(gZ2.getText());
            this.setModel(gZ2.getModel());
            this.setVisible(gZ2.isVisible());
            this.setPosition(gZ2.getPosition());
            this.setBackgroundColor(gZ2.getBackgroundColor());
            this.setAutoSizePolicy(gZ2.getAutoSizePolicy());
            this.setTextColor(gZ2.getTextColor());
            this.setAlignment(gZ2.getAlignment());
            this.setFont(gZ2.getFont());
            this.offsetRectangle = new n(gZ2.offsetRectangle);
            this.setLineColor(gZ2.getLineColor());
            this.setIcon(gZ2.getIcon());
            this.setSelected(gZ2.isSelected());
            this.setHorizontalTextPosition(gZ2.getHorizontalTextPosition());
            this.setVerticalTextPosition(gZ2.getVerticalTextPosition());
            this.setIconTextGap(gZ2.getIconTextGap());
            this.setInsets(gZ2.getInsets());
            this.setRotationAngle(gZ2.getRotationAngle());
            this.setUnderlinedTextEnabled(gZ2.isUnderlinedTextEnabled());
            this.db = gZ2.db;
            if (this.db.e != null) {
                this.m = this.db.e.a(gZ2, gZ2.m, this);
                if (!fj.z) break block2;
            }
            this.m = null;
        }
        this.b(gZ2.getWidth(), gZ2.getHeight());
        this.setContentSize(gZ2.getContentWidth(), gZ2.getContentHeight());
    }

    /*
     * Unable to fully structure code
     */
    public void write(ObjectOutputStream var1_1) {
        var2_2 = fj.z;
        var1_1.writeByte(11);
        var1_1.writeDouble(this.offsetRectangle.b());
        var1_1.writeDouble(this.offsetRectangle.c());
        var1_1.writeDouble(this.offsetRectangle.e());
        var1_1.writeDouble(this.offsetRectangle.f());
        var1_1.writeDouble(this.offsetRectangle.g());
        var1_1.writeDouble(this.offsetRectangle.i());
        var1_1.writeByte(this.getAutoSizePolicy());
        var1_1.writeFloat((float)this.contentWidth);
        var1_1.writeFloat((float)this.contentHeight);
        var1_1.writeFloat(this.s);
        var1_1.writeObject(this.getText());
        var1_1.writeByte(this.getModel());
        var1_1.writeByte(this.getPosition());
        var1_1.writeBoolean(this.w);
        var1_1.writeByte(this.j);
        var1_1.writeObject(this.fb);
        var1_1.writeObject(this.bb);
        var1_1.writeObject(this.getIcon());
        var1_1.writeObject(this.k);
        var1_1.writeObject(this.gb);
        var1_1.writeObject(this.x);
        var1_1.writeByte(this.t);
        var1_1.writeByte(this.z);
        var1_1.writeByte(this.u);
        if (this.getConfiguration() == null) ** GOTO lbl-1000
        var1_1.writeObject(this.getConfiguration());
        if (this.db.e == null) ** GOTO lbl-1000
        var1_1.writeBoolean(true);
        this.db.e.a(this, this.getUserData(), var1_1);
        if (var2_2) lbl-1000: // 2 sources:
        {
            var1_1.writeBoolean(false);
            ** if (!var2_2) goto lbl37
        }
        ** GOTO lbl37
lbl-1000: // 2 sources:
        {
            var1_1.writeObject(null);
        }
lbl37: // 3 sources:
        var1_1.writeBoolean(this.cb);
    }

    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        switch (objectInputStream.readByte()) {
            byte by2;
            float f2;
            byte by3;
            float f3;
            case 0: {
                objectInputStream.readByte();
                objectInputStream.readObject();
                this.fb = this.b(objectInputStream);
                this.j = objectInputStream.readByte();
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
                this.b(by2, by3);
                this.w = objectInputStream.readBoolean();
                if (!bl2) return;
            }
            case 1: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
                this.w = objectInputStream.readBoolean();
                this.j = objectInputStream.readByte();
                this.fb = this.b(objectInputStream);
                if (objectInputStream.readBoolean()) {
                    this.setBackgroundColor(Color.white);
                }
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 2: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
                this.w = objectInputStream.readBoolean();
                this.j = objectInputStream.readByte();
                this.fb = this.b(objectInputStream);
                if (objectInputStream.readBoolean()) {
                    this.setBackgroundColor(Color.white);
                }
                this.bb = (Color)objectInputStream.readObject();
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 3: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
                this.w = objectInputStream.readBoolean();
                this.j = objectInputStream.readByte();
                this.fb = this.b(objectInputStream);
                if (objectInputStream.readBoolean()) {
                    this.setBackgroundColor(Color.white);
                }
                this.bb = (Color)objectInputStream.readObject();
                this.setIcon((Icon)objectInputStream.readObject());
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 4: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 5: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 6: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.s = objectInputStream.readShort();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 7: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.s = objectInputStream.readShort();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 8: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.width = objectInputStream.readFloat();
                this.height = objectInputStream.readFloat();
                this.s = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                this.c(f3, f2);
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 9: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.v = objectInputStream.readByte();
                this.contentWidth = objectInputStream.readFloat();
                this.contentHeight = objectInputStream.readFloat();
                this.s = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.c(f3, f2);
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 10: {
                f3 = objectInputStream.readFloat();
                f2 = objectInputStream.readFloat();
                this.v = objectInputStream.readByte();
                this.contentWidth = objectInputStream.readFloat();
                this.contentHeight = objectInputStream.readFloat();
                this.s = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.c(f3, f2);
                this.b(by2, by3);
                if (!bl2) return;
            }
            case 11: {
                double d2 = objectInputStream.readDouble();
                double d3 = objectInputStream.readDouble();
                double d4 = objectInputStream.readDouble();
                double d5 = objectInputStream.readDouble();
                double d6 = objectInputStream.readDouble();
                double d7 = objectInputStream.readDouble();
                this.offsetRectangle = new n(d2, d3, d4, d5, d6, d7);
                this.v = objectInputStream.readByte();
                this.contentWidth = objectInputStream.readFloat();
                this.contentHeight = objectInputStream.readFloat();
                this.s = objectInputStream.readFloat();
                this.setText((String)objectInputStream.readObject());
                by2 = objectInputStream.readByte();
                by3 = objectInputStream.readByte();
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
                this.b(by2, by3);
                if (!bl2) return;
            }
        }
        throw new a();
    }

    private void b(byte by2, byte by3) {
        this.offsetDirty = false;
        this.sizeDirty = false;
        this.setModel(by2);
        this.setPosition(by3);
        this.sizeDirty = true;
    }

    private void c(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        String string = (String)objectInputStream.readObject();
        if (string == null) {
            this.db = this.c();
            if (!bl2) return;
        }
        this.setConfiguration(string);
        if (objectInputStream.readBoolean()) {
            if (this.db.e == null) {
                throw new IOException("No user data handler found for configuration to read user data.");
            }
            this.m = this.db.e.a(this, objectInputStream);
            if (!bl2) return;
        }
        this.m = null;
    }

    public abstract void setConfiguration(String var1);

    public String getConfiguration() {
        if (this.db == null) return null;
        String string = this.db.b;
        return string;
    }

    public void setAutoSizePolicy(byte by2) {
        this.v = by2;
        this.setSizeDirty();
    }

    public void internalSetAutoSizePolicy(byte by2) {
        this.v = by2;
    }

    public byte getAutoSizePolicy() {
        return this.v;
    }

    private Font b(ObjectInputStream objectInputStream) {
        Font font = (Font)objectInputStream.readObject();
        if (!n) return font;
        return new Font(font.getFontName(), font.getStyle(), Math.round(font.getSize2D()));
    }

    private static FontRenderContext d() {
        return eb;
    }

    private static void b(FontRenderContext fontRenderContext) {
        if (fontRenderContext == null) {
            throw new IllegalArgumentException("FontRenderContext cannot be null");
        }
        eb = fontRenderContext;
    }

    public static void setFractionMetricsForSizeCalculationEnabled(boolean bl2) {
        eb = new FontRenderContext(new AffineTransform(), true, bl2);
    }

    public static boolean isFractionMetricsForSizeCalculationEnabled() {
        return eb.usesFractionalMetrics();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static FontRenderContext access$000() {
        return gZ.d();
    }

    static {
        HashMap<Class, Object> hashMap = new HashMap<Class, Object>();
        Class class_ = class$y$view$YLabel$Layout == null ? (gZ.class$y$view$YLabel$Layout = gZ.class$("y.h.hc")) : class$y$view$YLabel$Layout;
        hashMap.put(class_, hh.d);
        Class class_2 = class$y$view$YLabel$Painter == null ? (gZ.class$y$view$YLabel$Painter = gZ.class$("y.h.hd")) : class$y$view$YLabel$Painter;
        hashMap.put(class_2, hh.d);
        Class class_3 = class$y$view$YLabel$BoundsProvider == null ? (gZ.class$y$view$YLabel$BoundsProvider = gZ.class$("y.h.ha")) : class$y$view$YLabel$BoundsProvider;
        hashMap.put(class_3, hh.d);
        Class class_4 = class$y$view$YLabel$UserDataHandler == null ? (gZ.class$y$view$YLabel$UserDataHandler = gZ.class$("y.h.hf")) : class$y$view$YLabel$UserDataHandler;
        hashMap.put(class_4, new gs(0));
        r = new hg(hashMap, hashMap, "default");
        boolean bl2 = false;
        try {
            String string = System.getProperty("os.name").toLowerCase();
            bl2 = string.startsWith("mac");
        }
        catch (Exception var1_3) {
            // empty catch block
        }
        n = bl2;
    }
}

