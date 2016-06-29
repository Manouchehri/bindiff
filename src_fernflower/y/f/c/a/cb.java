package y.f.c.a;

import y.f.c.a.bO;
import y.f.c.a.cE;
import y.f.c.a.df;

class cb implements bO {
   private y.f.am a;
   private df[] b;
   private y.c.f c;

   public cb(y.f.am var1) {
      this.a = var1;
      this.b = new df[12];
      this.b[0] = new cE(var1, 0, false);
      this.b[1] = new cE(var1, 0, false);
      this.b[2] = new cE(var1, 0, true);
      this.b[3] = new cE(var1, 1, false);
      this.b[4] = new cE(var1, 1, false);
      this.b[5] = new cE(var1, 1, true);
      this.b[6] = new cE(var1, 2, false);
      this.b[7] = new cE(var1, 2, false);
      this.b[8] = new cE(var1, 2, true);
      this.b[9] = new cE(var1, 3, false);
      this.b[10] = new cE(var1, 3, false);
      this.b[11] = new cE(var1, 3, true);
   }

   public df a(int var1) {
      return this.b[(4 + var1 & 3) * 3];
   }

   public df c(int var1) {
      return this.b[2 + (4 + var1 & 3) * 3];
   }

   public df b(int var1) {
      return this.b[1 + (4 + var1 & 3) * 3];
   }

   public double d(int var1) {
      var1 = 4 + var1 & 3;
      return (var1 & 1) == 1?this.a.getHeight():this.a.getWidth();
   }

   public y.c.f a() {
      return this.c;
   }

   public y.c.p b() {
      return this.c == null?null:this.c.k();
   }

   public void a(y.c.d var1) {
      if(this.c == null) {
         this.c = new y.c.f();
      }

      this.c.add(var1);
   }
}
