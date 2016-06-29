package y.h;

import java.awt.geom.Point2D;
import y.h.cU;
import y.h.ch;
import y.h.fj;

class hT implements y.b.d {
   private static final double a = Math.log(2.0D);
   private final double b;
   private double c;
   private Point2D d;
   private final y.g.an e;
   private final ch f;
   private final long g;
   private final cU h;
   private double i;
   private double j;
   private double k;
   private double l;
   private double m;
   private double n;
   private boolean o;

   public hT(ch var1, double var2, y.g.an var4, long var5, cU var7) {
      this.b = var2;
      this.e = var4;
      this.f = var1;
      this.g = var5;
      this.h = var7;
      this.i = Math.log(var2);
      this.j = this.i / a;
   }

   public long preferredDuration() {
      return this.g;
   }

   public void initAnimation() {
      this.c = this.f.getZoom();
      this.d = this.f.getCenter();
      this.k = Math.log(this.c);
      this.l = this.k / a;
      this.m = this.a(0.0D);
      this.n = this.a(1.0D) - this.m;
      this.o = Math.abs(this.c - this.b) < 1.0E-8D;
   }

   public void calcFrame(double var1) {
      label15: {
         double var3 = 1.0D - var1;
         this.f.setZoom(Math.pow(2.0D, var3 * this.l + var1 * this.j));
         if(this.o) {
            this.f.setCenter(var3 * this.d.getX() + var1 * this.e.a(), var3 * this.d.getY() + var1 * this.e.b());
            if(!fj.z) {
               break label15;
            }
         }

         double var5 = (this.a(var1) - this.m) / this.n;
         double var7 = 1.0D - var5;
         this.f.setCenter(var7 * this.d.getX() + var5 * this.e.a(), var7 * this.d.getY() + var5 * this.e.b());
      }

      if(this.h != null) {
         this.h.a();
      }

   }

   public void disposeAnimation() {
   }

   private double a(double var1) {
      return Math.pow(2.0D, (this.l - this.j) * var1 - this.l) / (this.k - this.i);
   }
}
