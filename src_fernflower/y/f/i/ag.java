package y.f.i;

import y.f.i.ao;
import y.f.i.v;

class ag {
   private double c;
   private double d;
   private double e;
   private byte f;
   private long g;
   private Object h;
   public y.c.D a;
   public y.c.D b;

   public ag(double var1, double var3, double var5, byte var7, long var8) {
      this.c = var1;
      this.d = var3;
      this.e = var5;
      this.f = var7;
      this.g = var8;
      this.a = new y.c.D();
      this.b = new y.c.D();
   }

   public boolean equals(Object var1) {
      return var1 instanceof ag?((ag)var1).g == this.g:false;
   }

   public int hashCode() {
      return (int)(this.g ^ this.g >>> 32);
   }

   public void a(boolean var1, ao var2) {
      if(var1) {
         this.a.add(var2);
         if(v.f == 0) {
            return;
         }
      }

      this.b.add(var2);
   }

   public void a(Object var1) {
      this.h = var1;
   }

   public double a() {
      return this.c;
   }

   public double b() {
      return this.d;
   }

   public double c() {
      return this.e;
   }

   public byte d() {
      return this.f;
   }

   public long e() {
      return this.g;
   }

   public Object f() {
      return this.h;
   }

   public String toString() {
      return (this.f == 8?"OPEN;":"CLOSE;") + this.c + ";[" + this.d + ".." + this.e + "]" + ";#" + this.g;
   }
}
