package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import y.h.O;
import y.h.P;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.hL;
import y.h.hM;
import y.h.hQ;

final class Q implements cg {
   boolean a;
   private final O b;

   private Q(O var1) {
      this.b = var1;
   }

   public Iterator a(bu var1, int var2) {
      hM var3 = new hM(this.a((y.c.i)var1, var2));
      return (Iterator)((var2 & 124) != 0?new hQ(var1, var3, var2, true):var3);
   }

   public Iterator b(bu var1, int var2) {
      hL var3 = new hL(this.a((y.c.i)var1, var2));
      return (Iterator)((var2 & 124) != 0?new hQ(var1, var3, var2, false):var3);
   }

   private ArrayList a(y.c.i var1, int var2) {
      return this.a(var1, (var2 & 81) != 0, (var2 & 46) != 0);
   }

   private ArrayList a(y.c.i var1, boolean var2, boolean var3) {
      ArrayList var4;
      boolean var11;
      ArrayList var10000;
      label101: {
         label100: {
            y.c.e var5;
            label99: {
               var11 = fj.z;
               var4 = new ArrayList(Math.min(250, var1.g() + var1.e()));
               if(var3 && this.a) {
                  var5 = var1.p();

                  while(var5.f()) {
                     var4.add(var5.a());
                     var5.g();
                     if(var11) {
                        break label99;
                     }

                     if(var11) {
                        break;
                     }
                  }
               }

               if(var2) {
                  label105: {
                     y.h.a.v var12 = y.h.a.v.a(var1);
                     if(var12 != null) {
                        var12.a((y.c.q)var12.e(var1), (y.h.a.y)(new P(this, var4)));
                        if(!var11) {
                           break label105;
                        }
                     }

                     y.c.x var6 = var1.o();

                     while(var6.f()) {
                        var4.add(var6.e());
                        var6.g();
                        if(var11) {
                           break label100;
                        }

                        if(var11) {
                           break;
                        }
                     }
                  }
               }
            }

            if(var3 && !this.a) {
               var5 = var1.p();

               while(var5.f()) {
                  var10000 = var4;
                  if(var11) {
                     break label101;
                  }

                  var4.add(var5.a());
                  var5.g();
                  if(var11) {
                     break;
                  }
               }
            }
         }

         var10000 = new ArrayList(var4.size());
      }

      ArrayList var13 = var10000;
      if(!var4.isEmpty() && var1 instanceof bu) {
         ArrayList[] var14 = this.a(var4, (bu)var1);
         int var7 = 0;

         while(var7 < var14.length) {
            ArrayList var8 = var14[var7];
            var10000 = var8;
            if(var11) {
               return var10000;
            }

            label54: {
               if(var8 != null) {
                  int var9 = 0;
                  int var10 = var8.size();

                  while(var9 < var10) {
                     var13.add(var8.get(var9));
                     ++var9;
                     if(var11) {
                        break label54;
                     }

                     if(var11) {
                        break;
                     }
                  }
               }

               ++var7;
            }

            if(var11) {
               break;
            }
         }
      }

      var10000 = var13;
      return var10000;
   }

   private ArrayList[] a(ArrayList var1, bu var2) {
      boolean var10 = fj.z;
      int var3 = 0;
      ArrayList[] var4 = new ArrayList[10];
      int var5 = 0;
      int var6 = var1.size();

      int var10000;
      while(true) {
         if(var5 < var6) {
            Object var7 = var1.get(var5);
            var10000 = var7 instanceof y.c.q;
            if(var10) {
               break;
            }

            int var8;
            label31: {
               if(var10000 != 0) {
                  var8 = this.b.getLayer(var2, (y.c.q)var7);
                  if(!var10) {
                     break label31;
                  }
               }

               var8 = this.b.getLayer(var2, (y.c.d)var7);
            }

            var3 = Math.max(var8, var3);
            if(var8 >= var4.length) {
               ArrayList[] var9 = new ArrayList[var8 + 5];
               System.arraycopy(var4, 0, var9, 0, var4.length);
               var4 = var9;
            }

            if(var4[var8] == null) {
               var4[var8] = new ArrayList(64);
            }

            var4[var8].add(var7);
            ++var5;
            if(!var10) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      if(var10000 < var4.length - 1) {
         ArrayList[] var11 = new ArrayList[var3 + 1];
         System.arraycopy(var4, 0, var11, 0, var3 + 1);
         return var11;
      } else {
         return var4;
      }
   }

   Q(O var1, P var2) {
      this(var1);
   }
}
