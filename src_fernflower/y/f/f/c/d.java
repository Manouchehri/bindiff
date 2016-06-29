package y.f.f.c;

import y.f.f.c.g;

class d {
   private double a;
   private int b;
   private g c;

   public d(double var1, int var3, g var4) {
      this.c = var4;
      this.a = var1;
      this.b = var3;
   }

   public double a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public g c() {
      return this.c;
   }

   public String toString() {
      return this.b == 0?"S: " + this.a + " " + this.c:(this.b == 1?"E: " + this.a + " " + this.c:null);
   }
}
