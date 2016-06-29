package y.f.i.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.f.i.a.ab;
import y.f.i.a.e;

class d {
   private e[] a;
   private int b;
   private int c;
   private Comparator d;

   public d(int var1, Comparator var2) {
      this.a = new e[var1 + 2];
      this.b = 0;
      this.c = var1;
      this.d = var2;
   }

   public List a() {
      int var3 = ab.a;
      ArrayList var1 = new ArrayList();
      int var2 = 0;

      ArrayList var10000;
      while(true) {
         if(var2 < this.b) {
            var10000 = var1;
            if(var3 != 0) {
               break;
            }

            var1.add(this.a[var2].a);
            ++var2;
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public e a(Object var1, Object var2) {
      if(this.b == this.c) {
         this.c += 1024;
         e[] var3 = new e[this.c + 2];
         System.arraycopy(this.a, 0, var3, 0, this.a.length);
         this.a = var3;
      }

      ++this.b;
      e var4 = new e(var1, var2, this.b);
      this.a(this.b, var4);
      return var4;
   }

   public void b() {
      int var2 = ab.a;
      int var1 = this.a.length - 1;

      while(true) {
         if(var1 >= 0) {
            this.a[var1] = null;
            --var1;
            if(var2 != 0) {
               break;
            }

            if(var2 == 0) {
               continue;
            }
         }

         this.b = 0;
         break;
      }

   }

   void a(int var1, e var2) {
      int var5 = ab.a;
      this.a[0] = var2;
      int var3 = var1 / 2;
      e var4 = this.a[var3];

      while(true) {
         if(this.d.compare(var4.b, var2.b) > 0) {
            this.a[var1] = var4;
            var4.c = var1;
            var1 = var3;
            var3 >>= 1;
            var4 = this.a[var3];
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.a[var1] = var2;
         var2.c = var1;
         break;
      }

   }

   void b(int var1, e var2) {
      int var5 = ab.a;
      int var3 = var1 << 1;
      this.a[this.b + 1] = this.a[this.b];

      while(true) {
         if(var3 <= this.b) {
            e var4 = this.a[var3];
            if(var5 != 0) {
               break;
            }

            if(var3 < this.b && this.d.compare(this.a[var3 + 1].b, var4.b) < 0) {
               ++var3;
               var4 = this.a[var3];
            }

            if(this.d.compare(var2.b, var4.b) > 0) {
               this.a[var1] = var4;
               var4.c = var1;
               var1 = var3;
               var3 <<= 1;
               if(var5 == 0) {
                  continue;
               }
            }
         }

         this.a[var1] = var2;
         var2.c = var1;
         break;
      }

   }

   public void a(e var1) {
      e var2 = this.a[this.b];
      this.a[this.b] = null;
      --this.b;
      if(var1 != var2) {
         if(this.d.compare(var2.b, var1.b) > 0) {
            this.b(var1.c, var2);
            if(ab.a == 0) {
               return;
            }
         }

         this.a(var1.c, var2);
      }

   }

   public void a(e var1, Object var2) {
      var1.b = var2;
      this.a(var1.c, var1);
   }

   public void b(e var1, Object var2) {
      if(this.d.compare(var2, var1.b) < 0) {
         this.a(var1, var2);
         if(ab.a == 0) {
            return;
         }
      }

      this.c(var1, var2);
   }

   public void c(e var1, Object var2) {
      var1.b = var2;
      this.b(var1.c, var1);
   }

   public e c() {
      return this.a[1];
   }

   public boolean d() {
      return this.b == 0;
   }
}
