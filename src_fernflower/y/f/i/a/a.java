package y.f.i.a;

import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.b;
import y.f.i.a.c;

public abstract class a {
   private double a;
   private boolean b;
   private final y.f.y c;
   private final c d;
   private M e;
   private M f;
   private final M g;
   private ah h;
   private byte i = 0;

   protected a(y.c.d var1, int var2, y.f.y var3, M var4, M var5, M var6) {
      this.c = var3;
      this.d = new c(var1, var2, (b)null);
      this.b = false;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   protected a(y.c.d var1, int var2, y.d.m var3) {
      this.c = c(var3);
      this.d = new c(var1, var2, (b)null);
      this.a = a(var3);
      this.e = new M(this.a, this.a);
      this.f = this.g = b(var3);
      this.b = true;
   }

   public String toString() {
      return "SegmentInfo{" + (this.i() != null?"edge=" + this.i().c().d() + "->" + this.i().d().d():"grouped Segment") + ", segmentIndex=" + this.j() + ", direction=" + this.c + ", location range=" + this.e + ", min extension=" + this.f + ", max extension=" + this.g + '}';
   }

   static double a(y.d.m var0) {
      y.d.t var1 = var0.c();
      boolean var2 = Math.abs(var1.a - var0.d().a) < 1.0E-6D;
      return var2?var1.a:var1.b;
   }

   static M b(y.d.m var0) {
      y.d.t var1 = var0.c();
      y.d.t var2 = var0.d();
      boolean var3 = Math.abs(var1.a - var2.a) < 1.0E-6D;
      return var3?new M(var1.b, var2.b):new M(var1.a, var2.a);
   }

   static y.f.y c(y.d.m var0) {
      y.d.t var1 = var0.c();
      y.d.t var2 = var0.d();
      if(var1.a > var2.a + 1.0E-6D) {
         return y.f.y.d;
      } else if(var1.a + 1.0E-6D < var2.a) {
         return y.f.y.b;
      } else if(var1.b > var2.b + 1.0E-6D) {
         return y.f.y.a;
      } else if(var1.b + 1.0E-6D < var2.b) {
         return y.f.y.c;
      } else {
         throw new RuntimeException("could not determine direction for segment " + var0);
      }
   }

   public M a() {
      return this.f;
   }

   void a(M var1) {
      this.f = var1;
   }

   public M b() {
      return this.g;
   }

   public M c() {
      return this.e;
   }

   void b(M var1) {
      this.e = var1;
   }

   public byte d() {
      return this.i;
   }

   public void a(byte var1) {
      switch(var1) {
      case -1:
      case 0:
      case 1:
         this.i = var1;
         if(ab.a == 0) {
            return;
         }
      default:
         throw new IllegalArgumentException("unknown alignment " + var1);
      }
   }

   public void a(double var1) {
      if(this.f()) {
         throw new IllegalStateException("try to change location for a fixed segment");
      } else if(this.e.a() - 1.0E-6D <= var1 && this.e.b() + 1.0E-6D >= var1) {
         this.a = var1;
         this.b = true;
      } else {
         throw new IllegalArgumentException("location " + var1 + " does not lie in location range " + this.e + "!");
      }
   }

   public double e() {
      return this.a;
   }

   public boolean f() {
      return this.b;
   }

   public boolean g() {
      return this.c.e();
   }

   public y.f.y h() {
      return this.c;
   }

   public y.c.d i() {
      return c.a(this.d);
   }

   public int j() {
      return c.b(this.d);
   }

   void a(int var1) {
      c.a(this.d, var1);
   }

   public void a(ah var1) {
      this.h = var1;
      this.e = var1.a();
   }

   public ah k() {
      return this.h;
   }
}
