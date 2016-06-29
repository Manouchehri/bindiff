package y.e;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import y.e.c;
import y.h.bu;
import y.h.ch;

public class g {
   public static byte a = 0;
   public static byte b = 1;
   public static byte c = 0;
   public static byte d = 1;
   public static byte e = 2;
   private byte f;
   private byte g;
   private int h;
   private int i;
   private int j;
   private bu k;
   private ch l;
   private double m;

   public g() {
      this.f = a;
      this.g = c;
      this.h = 500;
      this.i = 500;
      this.j = 15;
      this.m = 1.0D;
   }

   public void a(ch var1) {
      double var2;
      double var4;
      Point var6;
      double var7;
      label39: {
         int var13 = c.a;
         var2 = (double)this.d();
         var4 = (double)this.e();
         var6 = var1.getViewPoint();
         var7 = 1.0D;
         if(this.b() == a) {
            Rectangle2D var10;
            label41: {
               bu var9 = this.f();
               var10 = var9.a().getBounds2D();
               double var11 = (double)this.a() / this.m;
               var10.setFrame(var10.getX() - var11, var10.getY() - var11, var10.getWidth() + 2.0D * var11, var10.getHeight() + 2.0D * var11);
               if(this.c() == e) {
                  var2 = var4 * var10.getWidth() / var10.getHeight();
                  if(var13 == 0) {
                     break label41;
                  }
               }

               if(this.c() == d) {
                  var4 = var2 * var10.getHeight() / var10.getWidth();
                  if(var13 == 0) {
                     break label41;
                  }
               }

               var2 = var10.getWidth();
               var4 = var10.getHeight();
            }

            var7 = var2 / var10.getWidth();
            var6 = new Point((int)var10.getX(), (int)var10.getY());
            if(var13 == 0) {
               break label39;
            }
         }

         if(this.b() == b) {
            Dimension var14;
            ch var15;
            label42: {
               var15 = this.g();
               var14 = var15.getCanvasSize();
               if(this.c() == e) {
                  var2 = var4 * var14.getWidth() / var14.getHeight();
                  if(var13 == 0) {
                     break label42;
                  }
               }

               if(this.c() == d) {
                  var4 = var2 * var14.getHeight() / var14.getWidth();
                  if(var13 == 0) {
                     break label42;
                  }
               }

               var2 = var14.getWidth();
               var4 = var14.getHeight();
            }

            var6 = var15.getViewPoint();
            var7 = var15.getZoom() * var2 / var14.getWidth();
         }
      }

      var2 *= this.m;
      var4 *= this.m;
      var7 *= this.m;
      var1.setZoom(var7);
      var1.setSize((int)var2, (int)var4);
      var1.setViewPoint(var6.x, var6.y);
   }

   public int a() {
      return this.j;
   }

   public void a(byte var1) {
      this.f = var1;
   }

   public byte b() {
      return this.f;
   }

   public void b(byte var1) {
      this.g = var1;
   }

   public byte c() {
      return this.g;
   }

   public int d() {
      return this.h;
   }

   public int e() {
      return this.i;
   }

   public void a(bu var1) {
      this.k = var1;
   }

   public bu f() {
      return this.k;
   }

   public ch g() {
      return this.l;
   }
}
