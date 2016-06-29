package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.h.b.a;

abstract class q {
   final Object a;
   final List b;
   final List c;
   private boolean d;
   private double e;
   private double f;
   private y.d.r g;

   q(double var1, double var3, y.d.r var5) {
      this.a = new Object();
      this.b = new ArrayList();
      this.c = Collections.unmodifiableList(this.b);
      this.g = var5 == null?a.x():var5;
      this.e = var3;
      this.f = Math.max(Math.max(var1, var3), this.b(this.g));
   }

   q(q var1) {
      this.a = var1.a;
      this.b = new ArrayList(var1.b.size());
      this.c = Collections.unmodifiableList(this.b);
      this.e = var1.e;
      this.f = var1.f;
      this.d = var1.d;
      this.g = var1.g;
   }

   void c(double var1) {
      if(var1 > 0.0D) {
         this.e = var1;
         if(this.f < var1) {
            this.f = var1;
            a.d(this.r());
         }
      }

   }

   double p() {
      return this.e;
   }

   void d(double var1) {
      double var3 = Math.max(var1, Math.max(this.b(this.g), this.e));
      if(this.f != var3) {
         this.f = var3;
         a.d(this.r());
      }

   }

   double q() {
      return this.f;
   }

   public void a(y.d.r var1) {
      label15: {
         if(var1 == null) {
            this.g = a.x();
            if(a.H == 0) {
               break label15;
            }
         }

         this.g = var1;
      }

      if(this.f < this.b(var1)) {
         this.f = this.b(var1);
      }

   }

   public y.d.r i() {
      return this.g;
   }

   abstract double b(y.d.r var1);

   public boolean e() {
      return this.d;
   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public abstract Rectangle2D h();

   abstract a r();
}
