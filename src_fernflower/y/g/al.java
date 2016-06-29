package y.g;

import y.g.p;

public class al {
   private long a;
   private long b;
   private boolean c;

   public al() {
      this(true);
   }

   public al(boolean var1) {
      this.c = true;
      if(var1) {
         this.a();
      }

   }

   public void a() {
      if(this.c) {
         this.a = this.f();
         this.c = false;
      }

   }

   public void b() {
      if(!this.c) {
         this.b += this.f() - this.a;
         this.c = true;
      }

   }

   public void c() {
      if(this.c) {
         this.a();
         if(!p.c) {
            return;
         }
      }

      this.b();
   }

   public long d() {
      return this.c?this.b:this.b + this.f() - this.a;
   }

   public final void e() {
      this.b = 0L;
      this.a = this.f();
   }

   public final String toString() {
      long var1 = this.d();
      long var3 = var1 / 60000L;
      var1 -= 60000L * var3;
      long var5 = var1 / 1000L;
      var1 -= 1000L * var5;
      String var9 = "";
      var9 = var9 + var3 + " Minutes ";
      var9 = var9 + var5 + " Seconds ";
      var9 = var9 + var1 + " Millisec.";
      return var9;
   }

   private long f() {
      return System.currentTimeMillis();
   }
}
