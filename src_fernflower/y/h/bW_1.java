package y.h;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.HashMap;
import y.h.bZ;
import y.h.cV;
import y.h.ca;
import y.h.cb;
import y.h.cc;
import y.h.cd;
import y.h.ch;
import y.h.fj;
import y.h.hk;

public class bW implements Printable {
   private ch e;
   private int f = 1;
   private int g = 1;
   private byte h = 1;
   private boolean i = false;
   private double j = 1.0D;
   private byte k = 0;
   private RenderingHints l;
   private boolean m = true;
   cc a;
   ca b;
   byte c;
   Rectangle2D d;

   public bW(ch var1) {
      this.e = var1;
      this.a = new bZ();
      this.l = new RenderingHints(new HashMap());
      this.l.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
      this.c = 0;
   }

   public void a(boolean var1) {
      this.i = var1;
   }

   public boolean a() {
      return this.i;
   }

   public void a(int var1) {
      this.f = var1;
   }

   public void b(int var1) {
      this.g = var1;
   }

   public int b() {
      return this.f;
   }

   public int c() {
      return this.g;
   }

   public void a(byte var1) {
      this.h = var1;
   }

   public byte d() {
      return this.h;
   }

   public byte e() {
      return this.c;
   }

   public int print(Graphics var1, PageFormat var2, int var3) {
      boolean var49 = fj.z;
      Graphics2D var4 = (Graphics2D)var1.create();
      var4.addRenderingHints(this.l);

      byte var56;
      try {
         AffineTransform var5;
         Shape var6;
         double var7;
         double var9;
         double var11;
         double var13;
         Rectangle var15;
         double var16;
         double var18;
         double var20;
         double var22;
         double var24;
         double var26;
         int var30;
         int var31;
         double var32;
         double var34;
         double var57;
         label215: {
            var5 = var4.getTransform();
            var6 = var4.getClip();
            if(var6 == null) {
               throw new IllegalArgumentException("Graphics.getClip() must be non-null!");
            }

            var7 = var2.getImageableX();
            var9 = var2.getImageableY();
            var11 = var2.getImageableWidth();
            var13 = var2.getImageableHeight();
            var15 = this.f();
            var16 = var15.getWidth();
            var18 = var15.getHeight();
            var20 = var15.getX();
            var22 = var15.getY();
            var24 = 0.0D;
            var26 = 0.0D;
            cb var28;
            if(this.a != null) {
               var28 = new cb();
               var28.b = var4;
               var28.c = var3;
               var28.a = var2;
               var28.g = this.g;
               var28.f = this.f;
               var28.d = var3 % this.g;
               var28.e = var3 / this.g;
               this.a.a(var28);
               var24 = this.a.getBounds().getHeight();
            }

            if(this.b != null) {
               var28 = new cb();
               var28.b = var4;
               var28.c = var3;
               var28.a = var2;
               var28.g = this.g;
               var28.f = this.f;
               var28.d = var3 % this.g;
               var28.e = var3 / this.g;
               this.b.a(var28);
               var26 = this.b.getBounds().getHeight();
            }

            switch(this.k) {
            case 0:
               break;
            case 1:
               var32 = var16 * this.j;
               var34 = var18 * this.j;
               var31 = (int)Math.ceil(var32 / var11 - 0.01D);
               var30 = (int)Math.ceil(var34 / var13 - 0.01D);
               var57 = this.j;
               var32 = var11 * (double)var31;
               if(this.e() == 1) {
                  var34 = var13 * (double)var30 - var24 * (double)var30 - var26 * (double)var30;
                  if(!var49) {
                     break label215;
                  }
               }

               var34 = var13 * (double)var30 - var24 - var26;
               if(!var49) {
                  break label215;
               }
               break;
            default:
               throw new RuntimeException("Undefined ScalingType: " + this.k);
            }

            label181: {
               var31 = this.g;
               var30 = this.f;
               var32 = var11 * (double)var31;
               if(this.e() == 1) {
                  var34 = var13 * (double)var30 - var24 * (double)var30 - var26 * (double)var30;
                  if(!var49) {
                     break label181;
                  }
               }

               var34 = var13 * (double)var30 - var24 - var26;
            }

            if(var32 / var34 > var16 / var18) {
               var57 = var34 / var18;
               if(!var49) {
                  break label215;
               }
            }

            var57 = var32 / var16;
            if(var49) {
               throw new RuntimeException("Undefined ScalingType: " + this.k);
            }
         }

         if(var3 >= var30 * var31) {
            byte var58 = 1;
            return var58;
         }

         int var36 = var3 % var31;
         int var37 = var3 / var31;
         double var38 = 0.0D;
         double var40 = 0.0D;
         if(this.m) {
            var38 = Math.max(0.0D, (var32 - var16 * var57) / 2.0D);
            var40 = Math.max(0.0D, (var34 - var18 * var57) / 2.0D);
         }

         label189: {
            if(this.e() == 1) {
               int var42 = (int)Math.ceil(var7);
               int var43 = (int)Math.ceil(var9 + var24);
               int var44 = (int)Math.floor(var7 + var11);
               int var45 = (int)Math.floor(var9 + var13 - var26);
               var4.clipRect(var42, var43, var44 - var42, var45 - var43);
               var4.translate(var7 + var38 - var20 * var57 - var11 * (double)var36, var9 + var40 - var22 * var57 - var13 * (double)var37 + var24 * (double)(var37 + 1) + var26 * (double)var37);
               if(!var49) {
                  break label189;
               }
            }

            var4.translate(var7 + var38 - var20 * var57 - var11 * (double)var36, var9 + var40 - var22 * var57 - var13 * (double)var37 + var24);
         }

         var4.scale(var57, var57);
         Rectangle var52 = new Rectangle(var15);
         Rectangle var53 = var4.getClipBounds();
         Rectangle var54 = var53.intersection(var52);
         var4.clip(var54);
         cV var55 = this.a(this.e, var4);
         if(var55 != null) {
            var4.setRenderingHint(hk.z, var55);
         }

         this.e.getBackgroundRenderer().paint(var4, var54.x, var54.y, var54.width, var54.height);
         this.e.k(var4);
         cd var46 = this.e.getGraph2DRenderer();
         var46.paint(var4, this.e.getGraph2D());
         this.e.j(var4);
         var4.setTransform(var5);
         var4.setClip(var6);
         var4.setColor(Color.black);
         if(this.a()) {
            cb var47 = new cb();
            var47.b = var4;
            var47.c = var3;
            var47.a = var2;
            var47.g = var31;
            var47.f = var30;
            var47.d = var3 % var31;
            var47.e = var3 / var31;
            this.a(var4, var47);
         }

         if(this.a != null) {
            this.a.a(var4);
         }

         if(this.b != null) {
            this.b.a(var4);
         }

         var56 = 0;
      } finally {
         var4.dispose();
      }

      return var56;
   }

   protected void a(Graphics2D var1, cb var2) {
      Color var3 = var1.getColor();
      Font var4 = var1.getFont();
      this.b(var1, var2);
      PageFormat var5 = var2.c();
      int var6 = (int)var5.getImageableX() + 15;
      int var7 = (int)var5.getImageableY() + 15;
      int var8 = var2.a() + 1;
      int var9 = var2.b() + 1;
      TextLayout var10 = new TextLayout("[" + var8 + ',' + var9 + "]", var1.getFont(), var1.getFontRenderContext());
      var1.setColor(Color.white);
      Rectangle2D var11 = var10.getBounds();
      var11.setRect(var11.getX() + (double)var6 - 2.0D, var11.getY() + (double)var7 - 2.0D, var11.getWidth() + 4.0D, var11.getHeight() + 4.0D);
      var1.fill(var11);
      var1.setColor(Color.black);
      var10.draw(var1, (float)var6, (float)var7);
      var1.setFont(var4);
      var1.setColor(var3);
   }

   protected void b(Graphics2D var1, cb var2) {
      Font var3 = var1.getFont();
      if(var3.getSize() != 11) {
         var1.setFont(var3.deriveFont(11.0F));
      }

   }

   Rectangle f() {
      Rectangle var1 = null;
      switch(this.d()) {
      case 0:
         var1 = this.e.getVisibleRect();
         break;
      case 1:
      default:
         var1 = this.e.getGraph2D().a();
         var1.setFrame((double)(var1.x - 2), (double)(var1.y - 2), (double)(var1.width + 4), (double)(var1.height + 4));
         break;
      case 2:
         if(this.d == null) {
            throw new IllegalArgumentException("custom clip not set");
         }

         var1 = this.d.getBounds();
      }

      return var1;
   }

   protected cV a(ch var1, Graphics2D var2) {
      if(var2.getRenderingHint(hk.z) == null) {
         cV var3 = new cV();
         var3.a(true);
         var3.a(var1);
         Point2D var4 = var1.getViewPoint2D();
         AffineTransform var5 = var2.getTransform();
         var5.translate(var4.getX(), var4.getY());
         double var6 = 1.0D / var1.getZoom();
         var5.scale(var6, var6);
         var3.a(var5);
         return var3;
      } else {
         return null;
      }
   }

   public void a(cc var1) {
      this.a = var1;
   }
}
