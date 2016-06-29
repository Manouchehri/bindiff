package y.f.i;

import java.util.Comparator;
import y.f.i.U;

class V implements Comparator, y.g.g {
   private Comparator a;

   public V(Comparator var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      U var3 = (U)var1;
      U var4 = (U)var2;
      byte var5 = var3.a();
      byte var6 = var4.a();
      if(var5 != var6) {
         return y.g.e.a(var5, var6);
      } else {
         switch(var5) {
         case 0:
            if(U.c(var3) == U.c(var4) && U.b(var3) == U.b(var4)) {
               return this.a != null?this.a.compare(var3.c(), var4.c()):0;
            } else if(U.c(var3) >= U.c(var4) && U.b(var3) <= U.b(var4)) {
               return -1;
            } else if(U.c(var4) >= U.c(var3) && U.b(var4) <= U.b(var3)) {
               return 1;
            } else if(U.c(var3) < U.c(var4)) {
               return -1;
            } else {
               if(U.c(var4) < U.c(var3)) {
                  return 1;
               }

               return 0;
            }
         case 1:
            if(U.c(var3) == U.c(var4) && U.b(var3) == U.b(var4)) {
               return this.a != null?this.a.compare(var3.c(), var4.c()):0;
            } else if(U.c(var3) > U.c(var4) && U.b(var3) < U.b(var4)) {
               return 1;
            } else if(U.c(var4) > U.c(var3) && U.b(var4) < U.b(var3)) {
               return -1;
            } else if(U.c(var4) == U.c(var3)) {
               return U.b(var3) < U.b(var4)?-1:1;
            } else if(U.b(var4) == U.b(var3)) {
               return U.c(var3) < U.c(var4)?-1:1;
            } else if(U.c(var3) < U.c(var4)) {
               return -1;
            } else {
               if(U.c(var4) < U.c(var3)) {
                  return 1;
               }

               return 0;
            }
         case 2:
            if(U.c(var3) == U.c(var4) && U.b(var3) == U.b(var4)) {
               return this.a != null?this.a.compare(var3.c(), var4.c()):0;
            } else if(U.c(var3) > U.c(var4) && U.b(var3) < U.b(var4)) {
               return -1;
            } else if(U.c(var4) > U.c(var3) && U.b(var4) < U.b(var3)) {
               return 1;
            } else if(U.c(var4) == U.c(var3)) {
               return U.b(var3) < U.b(var4)?1:-1;
            } else if(U.b(var4) == U.b(var3)) {
               return U.c(var3) < U.c(var4)?1:-1;
            } else if(U.c(var3) < U.c(var4)) {
               return 1;
            } else {
               if(U.c(var4) < U.c(var3)) {
                  return -1;
               }

               return 0;
            }
         case 3:
            if(U.c(var3) == U.c(var4) && U.b(var3) == U.b(var4)) {
               return this.a != null?this.a.compare(var4.c(), var3.c()):0;
            } else if(U.c(var3) >= U.c(var4) && U.b(var3) <= U.b(var4)) {
               return -1;
            } else if(U.c(var4) >= U.c(var3) && U.b(var4) <= U.b(var3)) {
               return 1;
            } else if(U.c(var3) < U.c(var4)) {
               return -1;
            } else {
               if(U.c(var4) < U.c(var3)) {
                  return 1;
               }

               return 0;
            }
         default:
            return 0;
         }
      }
   }
}
