package y.a;

import y.a.e;
import y.a.h;

class d extends e {
   boolean a;
   private final y.c.f f;

   d(y.c.f var1) {
      this.f = var1;
      this.a = false;
   }

   protected void a(y.c.d var1, y.c.q var2, boolean var3) {
      boolean var6 = h.a;
      if(!this.a) {
         if(this.b.b(var2) == d) {
            this.a = true;
            int var4 = this.f.size();
            y.c.e var5 = this.f.a();
            var5.j();

            label55: {
               label54: {
                  while(true) {
                     if(var5.f()) {
                        y.c.q var10000 = var5.a().c();
                        if(var6) {
                           if(var6) {
                              break label55;
                           }

                           if(var6) {
                              break label54;
                           }
                           break;
                        }

                        if(var10000 != var2 && var5.a().d() != var2) {
                           var5.h();
                           --var4;
                           if(!var6) {
                              continue;
                           }
                        }
                     }

                     if(var1.e()) {
                        this.f.clear();
                        if(!var6) {
                           break label54;
                        }
                     }
                     break;
                  }

                  do {
                     --var4;
                     if(var4 <= 0) {
                        break;
                     }

                     this.f.g();
                     if(var6) {
                        break label55;
                     }
                  } while(!var6);
               }

               this.f.b(var1);
            }

            if(!var6) {
               return;
            }
         }

         if(var3) {
            this.f.b(var1);
         }
      }

   }

   protected void a(y.c.d var1, y.c.q var2) {
      if(!this.a) {
         this.f.h(this.f.l());
      }

   }
}
