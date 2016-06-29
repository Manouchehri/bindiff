package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;
import y.h.cV;
import y.h.ch;
import y.h.fj;
import y.h.hk;
import y.h.w;

public class M implements w {
   public static final byte FULLSCREEN = 0;
   public static final byte TILED = 1;
   public static final byte BRICKED = 2;
   public static final byte CENTERED = 3;
   public static final byte PLAIN = 4;
   public static final byte DYNAMIC = 5;
   protected ch view;
   private Image f;
   private Color g;
   private Point h;
   private URL c;
   private byte d = 4;
   private AffineTransform b;
   private Graphics2D e;

   public M(ch var1) {
      this.view = var1;
      this.g = Color.white;
      this.h = new Point(0, 0);
   }

   public URL getImageResource() {
      return this.c;
   }

   public ch getView() {
      return this.view;
   }

   public void setGraph2DView(ch var1) {
      this.view = var1;
   }

   public void setImageResource(URL var1) {
      if(var1 == null) {
         throw new NullPointerException("Specified image url is null.");
      } else {
         if(this.c == null || !var1.toExternalForm().equals(this.c.toExternalForm())) {
            this.c = var1;
            this.f = (new ImageIcon(var1)).getImage();
         }

      }
   }

   public void setImage(Image var1) {
      this.f = var1;
      this.c = null;
   }

   public Image getImage() {
      return this.f;
   }

   public void setColor(Color var1) {
      this.g = var1;
   }

   public Color getColor() {
      return this.g;
   }

   public void setImageOrigin(double var1, double var3) {
      this.h = new Point((int)var1, (int)var3);
   }

   public Point getImageOrigin() {
      return this.h;
   }

   public void setMode(byte var1) {
      this.d = var1;
   }

   public byte getMode() {
      return this.d;
   }

   public void paint(Graphics2D var1, int var2, int var3, int var4, int var5) {
      boolean var8 = fj.z;
      Color var6 = var1.getColor();
      AffineTransform var7 = var1.getTransform();
      this.h(var1);
      if(this.f != null) {
         switch(this.d) {
         case 4:
            this.b(var1);
            if(!var8) {
               break;
            }
         case 3:
            this.c(var1);
            if(!var8) {
               break;
            }
         case 1:
            this.d(var1);
            if(!var8) {
               break;
            }
         case 2:
            this.e(var1);
            if(!var8) {
               break;
            }
         case 0:
            this.f(var1);
            if(!var8) {
               break;
            }
         case 5:
            this.g(var1);
            if(!var8) {
               break;
            }
         default:
            y.g.o.a((Object)("Unknown background rendering mode: " + this.d));
         }
      }

      var1.setColor(var6);
      var1.setTransform(var7);
   }

   void h(Graphics2D var1) {
      if(this.g != null) {
         Rectangle var2 = var1.getClipBounds();
         var1.setColor(this.g);
         var1.fillRect(var2.x, var2.y, var2.width, var2.height);
      }

   }

   void g(Graphics2D var1) {
      int var2 = this.f.getWidth((ImageObserver)null);
      int var3 = this.f.getHeight((ImageObserver)null);
      var1.drawImage(this.f, this.h.x, this.h.y, (ImageObserver)null);
   }

   void b(Graphics2D var1) {
      this.undoWorldTransform(var1);
      int var2 = this.f.getWidth((ImageObserver)null);
      int var3 = this.f.getHeight((ImageObserver)null);
      var1.drawImage(this.f, this.h.x, this.h.y, (ImageObserver)null);
   }

   void c(Graphics2D var1) {
      this.undoWorldTransform(var1);
      int var2 = this.f.getWidth((ImageObserver)null);
      int var3 = this.f.getHeight((ImageObserver)null);
      int var4 = this.view.getWidth();
      int var5 = this.view.getHeight();
      var1.drawImage(this.f, (var4 - var2) / 2, (var5 - var3) / 2, (ImageObserver)null);
   }

   void d(Graphics2D var1) {
      boolean var10 = fj.z;
      this.undoWorldTransform(var1);
      Rectangle var2 = var1.getClipBounds();
      int var3 = this.f.getWidth((ImageObserver)null);
      int var4 = this.f.getHeight((ImageObserver)null);
      int var5 = -this.h.x + var2.x;
      int var6 = -this.h.y + var2.y;
      int var7 = var5 % var3;
      var5 = var2.x - var7;
      if(var7 != 0) {
         var5 -= var3;
      }

      var7 = var6 % var4;
      var6 = var2.y - var7;
      if(var7 != 0) {
         var6 -= var4;
      }

      int var8 = var6;

      while(var8 < var2.y + var2.height) {
         int var9 = var5;

         while(true) {
            if(var9 < var2.x + var2.width) {
               var1.drawImage(this.f, var9, var8, (ImageObserver)null);
               var9 += var3;
               if(var10) {
                  break;
               }

               if(!var10) {
                  continue;
               }
            }

            var8 += var4;
            break;
         }

         if(var10) {
            break;
         }
      }

   }

   void e(Graphics2D var1) {
      boolean var8 = fj.z;
      this.undoWorldTransform(var1);
      Rectangle var2 = var1.getClipBounds();
      int var3 = this.f.getWidth((ImageObserver)null);
      int var4 = this.f.getHeight((ImageObserver)null);
      boolean var5 = true;
      int var6 = 0;

      while(var6 < var2.y + var2.height) {
         int var7 = var5?0:-var3 / 2;

         boolean var10000;
         label33: {
            while(true) {
               if(var7 < var2.x + var2.width) {
                  var1.drawImage(this.f, var7, var6, (ImageObserver)null);
                  var7 += var3;
                  if(var8) {
                     break;
                  }

                  if(!var8) {
                     continue;
                  }
               }

               if(!var5) {
                  var10000 = true;
                  break label33;
               }
               break;
            }

            var10000 = false;
         }

         var5 = var10000;
         var6 += var4;
         if(var8) {
            break;
         }
      }

   }

   void f(Graphics2D var1) {
      this.undoWorldTransform(var1);
      int var2 = this.view.getWidth();
      int var3 = this.view.getHeight();
      var1.drawImage(this.f, 0, 0, var2, var3, (ImageObserver)null);
   }

   protected void undoWorldTransform(Graphics2D var1) {
      this.b = var1.getTransform();
      this.e = var1;
      cV var2 = hk.a(var1);
      if(var2 != null && var2.a() != null) {
         var1.setTransform(var2.a());
         if(!fj.z) {
            return;
         }
      }

      Point2D var3 = this.view.getViewPoint2D();
      double var4 = 1.0D / this.view.getZoom();
      var1.translate(var3.getX(), var3.getY());
      var1.scale(var4, var4);
   }

   protected void redoWorldTransform(Graphics2D var1) {
      if(this.b != null && var1 == this.e) {
         var1.setTransform(this.b);
         if(!fj.z) {
            return;
         }
      }

      Point var2 = this.view.getViewPoint();
      double var3 = this.view.getZoom();
      var1.scale(var3, var3);
      var1.translate(-var2.getX(), -var2.getY());
   }
}
