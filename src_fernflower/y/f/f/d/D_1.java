package y.f.f.d;

import y.f.f.d.o;

public class D {
   private y.c.f a = new y.c.f();
   private int b;
   private Integer c = new Integer(10);

   public void a(Integer var1) {
      this.c = var1;
   }

   public Integer a() {
      return this.c;
   }

   public void a(int var1) {
      this.b = var1;
   }

   public int b() {
      return this.b;
   }

   public void a(y.c.d var1) {
      this.a.add(var1);
   }

   public y.c.e c() {
      return this.a.a();
   }

   public int d() {
      return this.a.size() - 2;
   }

   public String toString() {
      boolean var3 = o.p;
      String var1 = "";
      y.c.e var2 = this.c();

      while(true) {
         if(var2.f()) {
            var1 = var1 + var2.a() + " ";
            var2.g();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         var1 = var1 + "=" + this.b + "[" + this.c + "]";
         break;
      }

      return var1;
   }
}
