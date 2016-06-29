package y.f.f.c;

import java.util.Iterator;
import y.c.D;

public class g {
   private y.c.q b;
   private int c;
   private short d;
   private g e;
   private g f;
   private D g;
   private int h;
   private int i = 0;
   private int j = 0;
   public static int a;

   public g(y.c.q var1, int var2, short var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.g = new D();
   }

   public void a(y.c.q var1) {
      this.g.add(var1);
   }

   public y.c.q a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public short c() {
      return this.d;
   }

   public void a(g var1, g var2) {
      this.e = var1;
      this.f = var2;
   }

   public g d() {
      return this.e;
   }

   public g e() {
      return this.f;
   }

   public y.c.q f() {
      return (y.c.q)this.g.f();
   }

   public y.c.q g() {
      return (y.c.q)this.g.i();
   }

   public D h() {
      return this.g;
   }

   public void a(int var1) {
      this.h = var1;
   }

   public int i() {
      return this.h;
   }

   public String toString() {
      int var4 = a;
      StringBuffer var1 = new StringBuffer();
      String var2 = "";
      Iterator var3 = this.g.iterator();

      String var10000;
      while(true) {
         if(var3.hasNext()) {
            var1.append(var2);
            var1.append(var3.next());
            var10000 = "-";
            if(var4 != 0) {
               break;
            }

            var2 = "-";
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var1.toString();
         break;
      }

      return var10000;
   }

   public int j() {
      return this.i;
   }

   public int k() {
      return this.j;
   }

   public void b(int var1) {
      this.i = var1;
   }

   public void c(int var1) {
      this.j = var1;
   }
}
