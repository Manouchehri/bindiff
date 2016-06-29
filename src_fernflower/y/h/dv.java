package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Collection;
import java.util.Iterator;
import y.h.az;
import y.h.ch;
import y.h.ds;
import y.h.fj;

class dv implements az {
   private y.d.t b;
   private int c;
   private double d;
   private ch e;
   private BufferedImage f;
   private boolean g;
   y.c.D a;
   private final ds h;

   dv(ds var1, ch var2) {
      this.h = var1;
      this.g = true;
      this.a = new y.c.D();
      this.d = 2.0D;
      this.c = 100;
      this.b = y.d.t.c;
      this.e = var2;
   }

   public void a(Graphics2D var1) {
      if(this.g) {
         this.h.view.addDrawable(this);
         this.h.view.removeDrawable(this);
         this.g = false;
      } else {
         this.g = true;
         Graphics2D var2 = (Graphics2D)var1.create();
         Rectangle2D var3 = this.a();
         Double var4 = new Double();
         var4.setFrame(var3);
         if(this.d != 1.0D) {
            Shape var5;
            AffineTransform var6;
            label26: {
               var5 = var2.getClip();
               var6 = var2.getTransform();
               var2.clip(var4);
               var2.translate(var3.getX(), var3.getY());
               if(this.h.view.getClientProperty("MagnifierViewMode.noDoubleBuffering") == null) {
                  int var7 = (int)Math.ceil(var3.getWidth());
                  int var8 = (int)Math.ceil(var3.getHeight());
                  if(this.f == null || this.f.getWidth() < var7 || this.f.getHeight() < var8) {
                     this.f = this.a(var2, var7, var8);
                  }

                  Graphics2D var9 = this.f.createGraphics();
                  var9.addRenderingHints(var2.getRenderingHints());
                  var9.setClip(0, 0, var7, var8);
                  this.b(var9);
                  var9.dispose();
                  var2.drawImage(this.f, 0, 0, (ImageObserver)null);
                  if(!fj.z) {
                     break label26;
                  }
               }

               this.b(var2);
            }

            var2.setTransform(var6);
            var2.setClip(var5);
         }

         var2.setColor(Color.BLACK);
         var2.setStroke(new BasicStroke(1.5F / (float)this.h.view.getZoom()));
         var2.draw(var4);
         var2.dispose();
      }
   }

   private void b(Graphics2D var1) {
      this.b();
      this.e.setGraph2D(this.h.getGraph2D());
      double var2 = 20.0D / this.h.view.getZoom();
      this.e.setSize((int)((double)(2 * this.c) / this.h.view.getZoom()), (int)((double)(2 * this.c) / this.h.view.getZoom()));
      this.e.setZoom(this.d);
      this.e.setCenter(this.b.a, this.b.b);
      this.e.setSize((int)((double)(2 * this.c) / this.h.view.getZoom()), (int)((double)(2 * this.c) / this.h.view.getZoom() + var2));
      this.e.paintVisibleContent(var1);
      this.h.getGraph2D().c(this.e);
      this.c();
   }

   public Rectangle2D a() {
      java.awt.geom.Rectangle2D.Double var1 = new java.awt.geom.Rectangle2D.Double();
      double var2 = (double)this.c / this.h.view.getZoom();
      var1.setFrame(this.b.a - var2, this.b.b - var2, 2.0D * var2, 2.0D * var2);
      return var1;
   }

   public void b() {
      boolean var4 = fj.z;
      Collection var1 = this.h.view.getDrawables();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         az var3 = (az)var2.next();
         if(var3 != ds.a(this.h)) {
            this.a.c((Object)var3);
            this.e.addDrawable(var3);
            if(var4) {
               break;
            }
         }
      }

   }

   public void c() {
      boolean var2 = fj.z;

      while(!this.a.isEmpty()) {
         az var1 = (az)this.a.g();
         this.e.removeDrawable(var1);
         if(var2) {
            break;
         }
      }

   }

   public Rectangle getBounds() {
      Rectangle var1 = new Rectangle();
      var1.setFrame(this.a());
      return var1;
   }

   public void a(y.d.t var1) {
      this.b = var1;
   }

   public void a(int var1) {
      this.c = var1;
   }

   public void a(double var1) {
      this.d = var1;
   }

   private BufferedImage a(Graphics2D var1, int var2, int var3) {
      GraphicsConfiguration var4 = var1.getDeviceConfiguration();
      return var4 != null?var4.createCompatibleImage(var2, var3, 3):new BufferedImage(var2, var3, 2);
   }
}
