package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javax.swing.Icon;
import y.h.fj;
import y.h.gs;
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
   protected y.d.n offsetRectangle;
   protected double width;
   protected double height;
   protected double contentWidth;
   protected double contentHeight;
   String o;
   boolean w = true;
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

   public void setUserData(Object var1) {
      this.m = var1;
   }

   public double getContentWidth() {
      return this.contentWidth;
   }

   public void setContentWidth(double var1) {
      this.contentWidth = var1;
      this.setSizeDirty();
   }

   public y.d.n getContentBox() {
      y.d.n var1 = this.getOrientedBox();
      y.d.n var2 = var1.g(this.contentWidth, this.contentHeight);
      float var3 = this.s;
      if(var3 != 0.0F) {
         double var4 = Math.toRadians((double)var3);
         double var6 = Math.sin(var4);
         double var8 = Math.cos(var4);
         double var10 = var2.g();
         double var12 = var2.i();
         var2.c(var8 * var10 - var6 * var12, var6 * var10 + var8 * var12);
      }

      y.d.t var14 = var1.k();
      var2.e(var14.a(), var14.b());
      return var2;
   }

   public boolean isSelected() {
      return this.y;
   }

   public void setSelected(boolean var1) {
      if(var1 != this.y) {
         this.y = var1;
         this.b();
         if(this.db.f != null) {
            this.db.f.a(this);
         }
      }

   }

   void b() {
   }

   public double getContentHeight() {
      return this.contentHeight;
   }

   public void setContentHeight(double var1) {
      this.contentHeight = var1;
      this.setSizeDirty();
   }

   public void setContentSize(double var1, double var3) {
      label11: {
         this.contentWidth = var1;
         this.contentHeight = var3;
         if(this.s != 0.0F) {
            double var5 = 0.0D;
            double var7 = 0.0D;
            double var9 = 0.0D;
            double var11 = 0.0D;
            Double var13 = new Double();
            AffineTransform var14 = AffineTransform.getRotateInstance(Math.toRadians((double)this.s));
            var13.x = -0.5D * var1;
            var13.y = -0.5D * var3;
            var14.transform(var13, var13);
            var5 = Math.max(var5, var13.x);
            var7 = Math.max(var7, var13.y);
            var9 = Math.min(var9, var13.x);
            var11 = Math.min(var11, var13.y);
            var13.x = 0.5D * var1;
            var13.y = 0.5D * var3;
            var14.transform(var13, var13);
            var5 = Math.max(var5, var13.x);
            var7 = Math.max(var7, var13.y);
            var9 = Math.min(var9, var13.x);
            var11 = Math.min(var11, var13.y);
            var13.x = -0.5D * var1;
            var13.y = 0.5D * var3;
            var14.transform(var13, var13);
            var5 = Math.max(var5, var13.x);
            var7 = Math.max(var7, var13.y);
            var9 = Math.min(var9, var13.x);
            var11 = Math.min(var11, var13.y);
            var13.x = 0.5D * var1;
            var13.y = -0.5D * var3;
            var14.transform(var13, var13);
            var5 = Math.max(var5, var13.x);
            var7 = Math.max(var7, var13.y);
            var9 = Math.min(var9, var13.x);
            var11 = Math.min(var11, var13.y);
            this.width = var5 - var9;
            this.height = var7 - var11;
            if(!fj.z) {
               break label11;
            }
         }

         this.width = this.contentWidth;
         this.height = this.contentHeight;
      }

      this.offsetDirty = true;
   }

   protected gZ() {
      this.fb = ab;
      this.j = 1;
      this.bb = Color.black;
      this.sizeDirty = true;
      this.offsetDirty = true;
      this.offsetRectangle = new y.d.n(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -1.0D);
      this.db = this.c();
   }

   hg c() {
      return r;
   }

   public void paint(Graphics2D var1) {
      this.db.a.a(this, var1);
   }

   protected void paintBox(Graphics2D var1, double var2, double var4, double var6, double var8) {
      this.db.a.a(this, var1, var2, var4, var6, var8);
   }

   public boolean contains(double var1, double var3) {
      return this.db.c.a(this, var1, var3);
   }

   protected void paintContent(Graphics2D var1, double var2, double var4, double var6, double var8) {
      this.db.a.b(this, var1, var2, var4, var6, var8);
   }

   protected void paintImpl(Graphics2D var1, double var2, double var4, double var6, double var8) {
      this.paintBox(var1, var2, var4, var6, var8);
      this.paintContent(var1, var2, var4, var6, var8);
   }

   public static void setHTMLRenderingEnabled(boolean var0) {
      l = var0;
   }

   static boolean b(gZ var0, Graphics2D var1) {
      return var0.isSelected() && hk.b(var1);
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

   public final void internalSetSizeDirty(boolean var1) {
      this.sizeDirty = var1;
   }

   public void setOffsetDirty() {
      this.offsetDirty = true;
   }

   public final void internalSetOffsetDirty(boolean var1) {
      this.offsetDirty = var1;
   }

   public abstract void calculateOffset();

   public void calculateSize() {
      this.calculateSize(d());
   }

   public void calculateSize(FontRenderContext var1) {
      this.sizeDirty = false;
      this.db.c.a(this, var1);
   }

   public final y.d.y getBox() {
      return this.getOrientedBox().h();
   }

   public abstract y.d.n getOrientedBox();

   public abstract void repaint();

   public void setVerticalTextPosition(byte var1) {
      this.t = var1;
      this.setSizeDirty();
   }

   public byte getVerticalTextPosition() {
      return this.t;
   }

   public void setHorizontalTextPosition(byte var1) {
      this.z = var1;
      this.setSizeDirty();
   }

   public byte getHorizontalTextPosition() {
      return this.z;
   }

   public void setIconTextGap(byte var1) {
      this.u = var1;
      this.setSizeDirty();
   }

   public byte getIconTextGap() {
      return this.u;
   }

   public void setUnderlinedTextEnabled(boolean var1) {
      this.cb = var1;
   }

   public boolean isUnderlinedTextEnabled() {
      return this.cb;
   }

   public void setRotationAngle(double var1) {
      var1 %= 360.0D;
      if(var1 < 0.0D) {
         var1 += 360.0D;
      }

      if(var1 != (double)this.s) {
         this.s = (float)var1;
         this.setSizeDirty();
      }

   }

   public double getRotationAngle() {
      return (double)this.s;
   }

   public void setInsets(Insets var1) {
      this.x = var1;
      this.setSizeDirty();
   }

   public Insets getInsets() {
      return this.x;
   }

   public void setIcon(Icon var1) {
      this.p = var1;
      this.setSizeDirty();
   }

   public Icon getIcon() {
      return this.p;
   }

   public void setTextColor(Color var1) {
      this.bb = var1;
   }

   public Color getTextColor() {
      return this.bb;
   }

   public boolean isVisible() {
      return this.w;
   }

   public void setVisible(boolean var1) {
      this.w = var1;
   }

   public byte getPosition() {
      return this.placement;
   }

   public void setPosition(byte var1) {
      this.placement = var1;
      this.setOffsetDirty();
   }

   public byte getModel() {
      return this.model;
   }

   public void setModel(byte var1) {
      this.model = var1;
      this.setOffsetDirty();
   }

   public void setBackgroundColor(Color var1) {
      this.k = var1;
   }

   public Color getBackgroundColor() {
      return this.k;
   }

   public void setLineColor(Color var1) {
      this.gb = var1;
   }

   public Color getLineColor() {
      return this.gb;
   }

   public void setText(String var1) {
      if(var1 == null) {
         this.o = "";
      } else {
         if(var1.equals(this.o)) {
            return;
         }

         this.o = var1;
      }

      this.setSizeDirty();
   }

   public String getText() {
      return this.o;
   }

   public void setOffset(y.d.n var1) {
      this.offsetRectangle = var1;
      this.offsetDirty = this.sizeDirty;
   }

   public y.d.n getOffset() {
      if(this.offsetDirty) {
         this.calculateOffset();
      }

      return this.offsetRectangle;
   }

   public double getOffsetX() {
      y.d.n var1 = this.getOffset();
      return var1.h().c();
   }

   public double getOffsetY() {
      y.d.n var1 = this.getOffset();
      return var1.h().d();
   }

   public void setOffsetX(double var1) {
      this.setOffset(var1, this.offsetRectangle.h().d());
   }

   public void setOffsetY(double var1) {
      this.setOffset(this.offsetRectangle.h().c(), var1);
   }

   public void setOffset(double var1, double var3) {
      this.c(var1, var3);
   }

   void c(double var1, double var3) {
      this.setOffset(new y.d.n(var1, var3 + this.height, this.width, this.height));
   }

   public y.d.t getLocation() {
      return this.getBox().e();
   }

   public void setAlignment(byte var1) {
      this.j = var1;
      this.setOffsetDirty();
   }

   public byte getAlignment() {
      return this.j;
   }

   public y.d.t getTextLocation() {
      return this.b(this.getTextBox());
   }

   public y.d.n getTextBox() {
      return this.db.a.a(this);
   }

   public y.d.t getIconLocation() {
      return this.b(this.getIconBox());
   }

   public y.d.n getIconBox() {
      return this.db.a.b(this);
   }

   public y.d.n transformCTW(y.d.n var1) {
      y.d.n var2 = this.getContentBox();
      double var3 = var2.g();
      double var5 = var2.i();
      double var7 = var1.b();
      double var9 = var1.c();
      double var11 = var1.g();
      double var13 = var1.i();
      return new y.d.n(var2.b() - var5 * var7 - var3 * var9, var2.c() + var3 * var7 - var5 * var9, var1.e(), var1.f(), -var5 * var11 - var3 * var13, var3 * var11 - var5 * var13);
   }

   private y.d.t b(y.d.n var1) {
      return this.transformCTW(var1).h().e();
   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      y.d.y var9 = this.getBox();
      return var9.c + var9.a >= var1 && var9.c <= var1 + var5 && var9.d + var9.b >= var3 && var9.d <= var3 + var7;
   }

   public void calcUnionRect(Rectangle2D var1) {
      boolean var3 = fj.z;
      if(this.db.d != null) {
         this.db.d.a(this, var1);
         if(!var3) {
            return;
         }
      }

      y.d.y var2 = this.getBox();
      if(var1.getWidth() < 0.0D || var1.getHeight() < 0.0D) {
         var1.setRect(var2.c, var2.d, var2.a, var2.b);
         if(!var3) {
            return;
         }
      }

      var1.setFrameFromDiagonal(Math.min(var2.c, var1.getX()), Math.min(var2.d, var1.getY()), Math.max(var2.c + var2.a, var1.getX() + var1.getWidth()), Math.max(var2.d + var2.b, var1.getY() + var1.getWidth()));
   }

   public abstract void setModelParameter(Object var1);

   public abstract Object getBestModelParameterForBounds(y.d.n var1);

   void b(double var1, double var3) {
      label11: {
         if(this.sizeDirty) {
            this.sizeDirty = false;
            this.calculateSize();
            if(!fj.z) {
               break label11;
            }
         }

         this.sizeDirty = false;
      }

      this.width = var1;
      this.height = var3;
   }

   public double getWidth() {
      if(this.isSizeDirty()) {
         this.calculateSize();
      }

      return this.width;
   }

   public double getHeight() {
      if(this.isSizeDirty()) {
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

   public void setFont(Font var1) {
      if(!var1.equals(this.fb)) {
         this.fb = var1;
         this.setSizeDirty();
      }

   }

   public String getFontName() {
      return this.fb.getName();
   }

   public void setFontName(String var1) {
      this.setFont(new Font(var1, this.fb.getStyle(), this.fb.getSize()));
   }

   public int getFontSize() {
      return this.fb.getSize();
   }

   public void setFontSize(int var1) {
      this.setFont(this.fb.deriveFont((float)var1));
   }

   public int getFontStyle() {
      return this.fb.getStyle();
   }

   public void setFontStyle(int var1) {
      this.setFont(this.fb.deriveFont(var1));
   }

   public void adoptValues(gZ var1) {
      label11: {
         this.setText(var1.getText());
         this.setModel(var1.getModel());
         this.setVisible(var1.isVisible());
         this.setPosition(var1.getPosition());
         this.setBackgroundColor(var1.getBackgroundColor());
         this.setAutoSizePolicy(var1.getAutoSizePolicy());
         this.setTextColor(var1.getTextColor());
         this.setAlignment(var1.getAlignment());
         this.setFont(var1.getFont());
         this.offsetRectangle = new y.d.n(var1.offsetRectangle);
         this.setLineColor(var1.getLineColor());
         this.setIcon(var1.getIcon());
         this.setSelected(var1.isSelected());
         this.setHorizontalTextPosition(var1.getHorizontalTextPosition());
         this.setVerticalTextPosition(var1.getVerticalTextPosition());
         this.setIconTextGap(var1.getIconTextGap());
         this.setInsets(var1.getInsets());
         this.setRotationAngle(var1.getRotationAngle());
         this.setUnderlinedTextEnabled(var1.isUnderlinedTextEnabled());
         this.db = var1.db;
         if(this.db.e != null) {
            this.m = this.db.e.a(var1, var1.m, this);
            if(!fj.z) {
               break label11;
            }
         }

         this.m = null;
      }

      this.b(var1.getWidth(), var1.getHeight());
      this.setContentSize(var1.getContentWidth(), var1.getContentHeight());
   }

   public void write(ObjectOutputStream var1) {
      label16: {
         boolean var2 = fj.z;
         var1.writeByte(11);
         var1.writeDouble(this.offsetRectangle.b());
         var1.writeDouble(this.offsetRectangle.c());
         var1.writeDouble(this.offsetRectangle.e());
         var1.writeDouble(this.offsetRectangle.f());
         var1.writeDouble(this.offsetRectangle.g());
         var1.writeDouble(this.offsetRectangle.i());
         var1.writeByte(this.getAutoSizePolicy());
         var1.writeFloat((float)this.contentWidth);
         var1.writeFloat((float)this.contentHeight);
         var1.writeFloat(this.s);
         var1.writeObject(this.getText());
         var1.writeByte(this.getModel());
         var1.writeByte(this.getPosition());
         var1.writeBoolean(this.w);
         var1.writeByte(this.j);
         var1.writeObject(this.fb);
         var1.writeObject(this.bb);
         var1.writeObject(this.getIcon());
         var1.writeObject(this.k);
         var1.writeObject(this.gb);
         var1.writeObject(this.x);
         var1.writeByte(this.t);
         var1.writeByte(this.z);
         var1.writeByte(this.u);
         if(this.getConfiguration() != null) {
            var1.writeObject(this.getConfiguration());
            if(this.db.e != null) {
               var1.writeBoolean(true);
               this.db.e.a(this, this.getUserData(), var1);
               if(!var2) {
                  break label16;
               }
            }

            var1.writeBoolean(false);
            if(!var2) {
               break label16;
            }
         }

         var1.writeObject((Object)null);
      }

      var1.writeBoolean(this.cb);
   }

   public void read(ObjectInputStream var1) {
      boolean var18 = fj.z;
      float var2;
      float var3;
      byte var4;
      byte var5;
      switch(var1.readByte()) {
      case 0:
         var1.readByte();
         var1.readObject();
         this.fb = this.b(var1);
         this.j = var1.readByte();
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.b(var4, var5);
         this.w = var1.readBoolean();
         if(!var18) {
            break;
         }
      case 1:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 2:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 3:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.setIcon((Icon)var1.readObject());
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 4:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 5:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 6:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.s = (float)var1.readShort();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 7:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.s = (float)var1.readShort();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.t = var1.readByte();
         this.z = var1.readByte();
         this.u = var1.readByte();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 8:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.width = (double)var1.readFloat();
         this.height = (double)var1.readFloat();
         this.s = var1.readFloat();
         this.setText((String)var1.readObject());
         this.c((double)var2, (double)var3);
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.t = var1.readByte();
         this.z = var1.readByte();
         this.u = var1.readByte();
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 9:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.v = var1.readByte();
         this.contentWidth = (double)var1.readFloat();
         this.contentHeight = (double)var1.readFloat();
         this.s = var1.readFloat();
         this.setText((String)var1.readObject());
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.t = var1.readByte();
         this.z = var1.readByte();
         this.u = var1.readByte();
         this.c(var1);
         this.setContentSize(this.contentWidth, this.contentHeight);
         this.c((double)var2, (double)var3);
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 10:
         var2 = var1.readFloat();
         var3 = var1.readFloat();
         this.v = var1.readByte();
         this.contentWidth = (double)var1.readFloat();
         this.contentHeight = (double)var1.readFloat();
         this.s = var1.readFloat();
         this.setText((String)var1.readObject());
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.t = var1.readByte();
         this.z = var1.readByte();
         this.u = var1.readByte();
         this.c(var1);
         this.cb = var1.readBoolean();
         this.setContentSize(this.contentWidth, this.contentHeight);
         this.c((double)var2, (double)var3);
         this.b(var4, var5);
         if(!var18) {
            break;
         }
      case 11:
         double var6 = var1.readDouble();
         double var8 = var1.readDouble();
         double var10 = var1.readDouble();
         double var12 = var1.readDouble();
         double var14 = var1.readDouble();
         double var16 = var1.readDouble();
         this.offsetRectangle = new y.d.n(var6, var8, var10, var12, var14, var16);
         this.v = var1.readByte();
         this.contentWidth = (double)var1.readFloat();
         this.contentHeight = (double)var1.readFloat();
         this.s = var1.readFloat();
         this.setText((String)var1.readObject());
         var4 = var1.readByte();
         var5 = var1.readByte();
         this.w = var1.readBoolean();
         this.j = var1.readByte();
         this.fb = this.b(var1);
         this.bb = (Color)var1.readObject();
         this.p = (Icon)var1.readObject();
         this.k = (Color)var1.readObject();
         this.gb = (Color)var1.readObject();
         this.x = (Insets)var1.readObject();
         this.t = var1.readByte();
         this.z = var1.readByte();
         this.u = var1.readByte();
         this.c(var1);
         this.cb = var1.readBoolean();
         this.setContentSize(this.contentWidth, this.contentHeight);
         this.b(var4, var5);
         if(var18) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

   }

   private void b(byte var1, byte var2) {
      this.offsetDirty = false;
      this.sizeDirty = false;
      this.setModel(var1);
      this.setPosition(var2);
      this.sizeDirty = true;
   }

   private void c(ObjectInputStream var1) {
      boolean var3 = fj.z;
      String var2 = (String)var1.readObject();
      if(var2 == null) {
         this.db = this.c();
         if(!var3) {
            return;
         }
      }

      this.setConfiguration(var2);
      if(var1.readBoolean()) {
         if(this.db.e == null) {
            throw new IOException("No user data handler found for configuration to read user data.");
         }

         this.m = this.db.e.a(this, var1);
         if(!var3) {
            return;
         }
      }

      this.m = null;
   }

   public abstract void setConfiguration(String var1);

   public String getConfiguration() {
      return this.db != null?this.db.b:null;
   }

   public void setAutoSizePolicy(byte var1) {
      this.v = var1;
      this.setSizeDirty();
   }

   public void internalSetAutoSizePolicy(byte var1) {
      this.v = var1;
   }

   public byte getAutoSizePolicy() {
      return this.v;
   }

   private Font b(ObjectInputStream var1) {
      Font var2 = (Font)var1.readObject();
      if(n) {
         var2 = new Font(var2.getFontName(), var2.getStyle(), Math.round(var2.getSize2D()));
      }

      return var2;
   }

   private static FontRenderContext d() {
      return eb;
   }

   private static void b(FontRenderContext var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("FontRenderContext cannot be null");
      } else {
         eb = var0;
      }
   }

   public static void setFractionMetricsForSizeCalculationEnabled(boolean var0) {
      eb = new FontRenderContext(new AffineTransform(), true, var0);
   }

   public static boolean isFractionMetricsForSizeCalculationEnabled() {
      return eb.usesFractionalMetrics();
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static FontRenderContext access$000() {
      return d();
   }

   static {
      HashMap var0 = new HashMap();
      var0.put(class$y$view$YLabel$Layout == null?(class$y$view$YLabel$Layout = class$("y.h.hc")):class$y$view$YLabel$Layout, hh.d);
      var0.put(class$y$view$YLabel$Painter == null?(class$y$view$YLabel$Painter = class$("y.h.hd")):class$y$view$YLabel$Painter, hh.d);
      var0.put(class$y$view$YLabel$BoundsProvider == null?(class$y$view$YLabel$BoundsProvider = class$("y.h.ha")):class$y$view$YLabel$BoundsProvider, hh.d);
      var0.put(class$y$view$YLabel$UserDataHandler == null?(class$y$view$YLabel$UserDataHandler = class$("y.h.hf")):class$y$view$YLabel$UserDataHandler, new gs((byte)0));
      r = new hg(var0, var0, "default");
      boolean var3 = false;

      try {
         String var1 = System.getProperty("os.name").toLowerCase();
         var3 = var1.startsWith("mac");
      } catch (Exception var2) {
         ;
      }

      n = var3;
   }
}
