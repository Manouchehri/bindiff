package y.a;

import y.a.R;
import y.a.h;

class ac implements R {
   private int a;
   private int b;
   private y.c.y[] c;

   public ac(int var1) {
      boolean var3 = h.a;
      super();
      this.a = var1;
      this.b = -1;
      this.c = new y.c.y[var1 + 1];
      int var2 = 0;

      while(var2 < var1 + 1) {
         this.c[var2] = new y.c.y();
         ++var2;
         if(var3) {
            break;
         }
      }

   }

   public y.c.q a() {
      boolean var1 = h.a;

      int var10000;
      while(true) {
         if(this.b >= 0) {
            var10000 = this.c[this.b].isEmpty();
            if(var1) {
               break;
            }

            if(var10000 != 0) {
               --this.b;
               if(!var1) {
                  continue;
               }
            }
         }

         var10000 = this.b;
         break;
      }

      return var10000 >= 0?this.c[this.b].d():null;
   }

   public void a(y.c.q var1, int var2) {
      this.c[var2].c(var1);
      if(var2 > this.b) {
         this.b = var2;
      }

   }

   public void b(y.c.q var1, int var2) {
      this.c[var2].add(var1);
   }

   public boolean b() {
      boolean var1 = h.a;

      int var10000;
      while(true) {
         if(this.b >= 0) {
            var10000 = this.c[this.b].isEmpty();
            if(var1) {
               break;
            }

            if(var10000 != 0) {
               --this.b;
               if(!var1) {
                  continue;
               }
            }
         }

         var10000 = this.b;
         break;
      }

      return var10000 < 0;
   }

   public void c() {
      boolean var2 = h.a;
      int var1 = 0;

      while(true) {
         if(var1 <= this.a) {
            this.c[var1].clear();
            ++var1;
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.b = -1;
         break;
      }

   }
}
