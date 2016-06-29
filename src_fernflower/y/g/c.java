package y.g;

import y.g.p;

public class c {
   private Object[] a;
   private int b;
   private int c;
   private int d;
   private int e;

   public c(int var1) {
      this.a = new Object[var1 + 1];
      this.b = 0;
      this.c = this.b + var1 + 1;
      this.d = this.e = this.b;
   }

   public Object a() {
      Object var1 = this.a[this.d++];
      if(this.d == this.c) {
         this.d = this.b;
      }

      return var1;
   }

   public Object b() {
      Object var1 = this.a[this.d++];
      if(this.d == this.c) {
         this.d = this.b;
      }

      return var1;
   }

   public void a(Object var1) {
      this.a[this.e++] = var1;
      if(this.e == this.c) {
         this.e = this.b;
      }

   }

   public void b(Object var1) {
      this.a[this.e++] = var1;
      if(this.e == this.c) {
         this.e = this.b;
      }

   }

   public void c() {
      this.d = this.e = this.b;
   }

   public int d() {
      int var1 = this.e - this.d;
      return var1 < 0?this.c - this.b + var1:var1;
   }

   public boolean e() {
      return this.d == this.e;
   }

   public String toString() {
      boolean var3 = p.c;
      String var1 = "size=[" + this.d() + ']';
      int var2 = this.d;

      int var10000;
      int var10001;
      while(true) {
         if(var2 < this.e) {
            var10000 = var2;
            var10001 = this.c;
            if(var3) {
               break;
            }

            if(var2 < var10001) {
               var1 = var1 + ' ' + this.a[var2].toString();
               ++var2;
               if(!var3) {
                  continue;
               }
            }
         }

         var10000 = this.e;
         var10001 = this.d;
         break;
      }

      String var4;
      if(var10000 < var10001) {
         var2 = this.b;

         while(var2 < this.e) {
            var4 = var1 + ' ' + this.a[var2].toString();
            if(var3) {
               return var4;
            }

            var1 = var4;
            ++var2;
            if(var3) {
               break;
            }
         }
      }

      var4 = var1;
      return var4;
   }
}
