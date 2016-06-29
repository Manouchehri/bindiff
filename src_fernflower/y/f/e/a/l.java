package y.f.e.a;

import y.f.e.a.af;
import y.f.e.a.ay;
import y.f.e.a.w;

public class l {
   private y.g.ar a;
   private long b;
   private af c;
   private ay d;
   private int e;
   private double f;

   l(af var1, ay var2, boolean var3) {
      this.c = var1;
      this.d = var2;
      this.b = System.currentTimeMillis();
      if(var3) {
         this.a = new y.g.ar(1337L);
         if(!af.b) {
            return;
         }
      }

      this.a = new y.g.ar();
   }

   public double a() {
      return this.f;
   }

   void a(double var1) {
      this.f = var1;
   }

   public w b() {
      return this.c;
   }

   public int c() {
      return this.e;
   }

   void a(int var1) {
      this.e = var1;
   }

   public y.g.ar d() {
      return this.a;
   }

   public long e() {
      return System.currentTimeMillis() - this.b;
   }

   af f() {
      return this.c;
   }

   public double g() {
      return this.d.x();
   }

   public double h() {
      return this.d.w();
   }
}
