package y.c;

import y.c.D;
import y.c.H;
import y.c.I;
import y.c.M;

class L {
   private I a;
   private I b;
   private int c;

   public int a() {
      return this.c;
   }

   boolean b() {
      return this.c == 0;
   }

   I c() {
      return this.a;
   }

   I a(I var1) {
      return var1.q();
   }

   public void b(I var1) {
      ++this.c;
      var1.b(this.b);
      var1.a((I)null);
      if(this.b != null) {
         this.b.a(var1);
         this.b = var1;
         if(!D.e) {
            return;
         }
      }

      this.b = this.a = var1;
   }

   void a(I var1, I var2, int var3) {
      boolean var5 = D.e;
      if(var2 == null) {
         this.b(var1);
      } else {
         label34: {
            I var4;
            if(var3 == 1) {
               label27: {
                  var4 = var2.r();
                  if(var4 != null) {
                     var4.a(var1);
                     if(!var5) {
                        break label27;
                     }
                  }

                  this.a = var1;
               }

               var1.b(var4);
               var1.a(var2);
               var2.b(var1);
               if(!var5) {
                  break label34;
               }
            }

            label20: {
               var4 = var2.q();
               if(var4 != null) {
                  var4.b(var1);
                  if(!var5) {
                     break label20;
                  }
               }

               this.b = var1;
            }

            var1.a(var4);
            var1.b(var2);
            var2.a(var1);
         }

         ++this.c;
      }
   }

   void c(I var1) {
      I var2;
      I var3;
      boolean var4;
      label19: {
         var4 = D.e;
         var2 = var1.q();
         var3 = var1.r();
         --this.c;
         if(var2 != null) {
            var2.b(var3);
            if(!var4) {
               break label19;
            }
         }

         this.b = var3;
      }

      if(var3 != null) {
         var3.a(var2);
         if(!var4) {
            return;
         }
      }

      this.a = var2;
   }

   I d() {
      return this.a;
   }

   void e() {
      this.a = null;
      this.b = null;
      this.c = 0;
   }

   H f() {
      return new M(this);
   }

   static I a(L var0) {
      return var0.a;
   }

   static I b(L var0) {
      return var0.b;
   }

   static int c(L var0) {
      return var0.c;
   }
}
