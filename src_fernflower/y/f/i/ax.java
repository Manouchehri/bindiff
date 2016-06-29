package y.f.i;

import y.f.i.av;
import y.f.i.ay;
import y.f.i.az;
import y.f.i.v;

class ax {
   private az a;
   private int b;
   private ay c;
   private final av d;

   public ax(av var1, ay var2) {
      this.d = var1;
      this.c = var2;
      this.a = null;
      this.b = 0;
   }

   public boolean a(double var1, Object var3) {
      int var8 = v.f;
      boolean var4 = false;
      if(this.b == 0) {
         this.a = new az(this.d, var1, var3);
         if(this.a != null) {
            var4 = true;
            ++this.b;
         }

         return var4;
      } else {
         az var5 = this.a;
         az var6 = this.a;

         az var10000;
         while(true) {
            if(var6 != null) {
               var10000 = var6;
               if(var8 != 0) {
                  break;
               }

               var5 = var6;
               if(var1 < az.a(var6)) {
                  var6 = az.b(var6);
                  if(var8 == 0) {
                     continue;
                  }
               }

               var6 = az.c(var6);
               if(var8 == 0) {
                  continue;
               }
            }

            var10000 = new az(this.d, var1, var3);
            break;
         }

         az var7 = var10000;
         if(var7 != null) {
            label27: {
               var4 = true;
               if(var1 < az.a(var5)) {
                  az.a(var5, var7);
                  if(var8 == 0) {
                     break label27;
                  }
               }

               az.b(var5, var7);
            }
         }

         ++this.b;
         return var4;
      }
   }

   private az[] a(az var1, double var2) {
      int var8 = v.f;
      az[] var4 = new az[2];
      az var5 = var1;
      az var6 = var1;
      boolean var7 = false;

      boolean var10000;
      while(true) {
         if(var6 != null) {
            var10000 = var7;
            if(var8 != 0) {
               break;
            }

            if(!var7) {
               if(var2 == az.a(var6)) {
                  var7 = true;
                  if(var8 == 0) {
                     continue;
                  }
               }

               var5 = var6;
               if(var2 < az.a(var6)) {
                  var6 = az.b(var6);
                  if(var8 == 0) {
                     continue;
                  }
               }

               var6 = az.c(var6);
               if(var8 == 0) {
                  continue;
               }
            }
         }

         var10000 = var7;
         break;
      }

      if(!var10000) {
         var4[0] = null;
         var4[1] = null;
         if(var8 == 0) {
            return var4;
         }
      }

      var4[0] = var5;
      var4[1] = var6;
      return var4;
   }

   public Object b(double var1, Object var3) {
      int var10 = v.f;
      if(this.b == 0) {
         return null;
      } else {
         boolean var4 = false;
         az var6 = this.a;
         az var7 = this.a;

         boolean var10000;
         while(true) {
            if(var7 != null) {
               var10000 = var4;
               if(var10 != 0) {
                  break;
               }

               if(!var4) {
                  az[] var5 = this.a(var7, var1);
                  if(var5[0] != null || var5[1] != null) {
                     if(var5[0] != var5[1]) {
                        var6 = var5[0];
                     }

                     var7 = var5[1];
                     if(this.c.a(var3, az.d(var7))) {
                        var4 = true;
                        if(var10 == 0) {
                           continue;
                        }
                     }

                     var6 = var7;
                     var7 = az.c(var7);
                     if(var10 == 0) {
                        continue;
                     }
                  }
               }
            }

            var10000 = var4;
            break;
         }

         if(!var10000) {
            return null;
         } else {
            az var9;
            label91: {
               var9 = var7;
               if(az.c(var7) == null) {
                  var7 = az.b(var7);
                  if(var10 == 0) {
                     break label91;
                  }
               }

               if(az.b(az.c(var7)) == null) {
                  var7 = az.c(var7);
                  az.a(var7, az.b(var9));
                  if(var10 == 0) {
                     break label91;
                  }
               }

               az var8 = az.c(var7);

               label58: {
                  while(az.b(az.b(var8)) != null) {
                     var8 = az.b(var8);
                     if(var10 != 0) {
                        break label58;
                     }

                     if(var10 != 0) {
                        break;
                     }
                  }

                  var7 = az.b(var8);
                  az.a(var8, az.c(var7));
                  az.a(var7, az.b(var9));
               }

               az.b(var7, az.c(var9));
            }

            label93: {
               if(var6 == var9) {
                  this.a = var7;
                  if(var10 == 0) {
                     break label93;
                  }
               }

               if(az.a(var9) < az.a(var6)) {
                  az.a(var6, var7);
                  if(var10 == 0) {
                     break label93;
                  }
               }

               az.b(var6, var7);
            }

            --this.b;
            return az.d(var9);
         }
      }
   }

   public y.c.D a() {
      int var4 = v.f;
      y.c.D var1 = new y.c.D();
      y.g.d var2 = new y.g.d(this.b);
      az var3 = this.a;

      do {
         while(true) {
            if(var3 != null) {
               var2.a(var3);
               var3 = az.b(var3);
               if(var4 != 0) {
                  break;
               }

               if(var4 == 0) {
                  continue;
               }
            }

            if(var2.c()) {
               return var1;
            }

            var3 = (az)var2.b();
            var1.add(az.d(var3));
            var3 = az.c(var3);
            break;
         }
      } while(var4 == 0);

      return var1;
   }
}
