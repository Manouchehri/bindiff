package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import y.f.i.v;

final class ad {
   public static Collection a(y.c.i var0, y.c.d var1, boolean var2) {
      Object var3 = var2?y.f.ax.a:y.f.ax.b;
      y.c.c var4 = var0.c(var3);
      Collection var5 = null;
      if(var4 != null) {
         var5 = (Collection)var4.b(var1);
      }

      return var5;
   }

   public static Collection b(y.c.i var0, y.c.d var1, boolean var2) {
      Object var3 = var2?y.f.ax.a:y.f.ax.b;
      y.c.c var4 = var0.c(var3);
      Object var5 = null;
      if(var4 != null) {
         var5 = (Collection)var4.b(var1);
         if(var5 != null) {
            var5 = new ArrayList((Collection)var5);
         }
      }

      return (Collection)var5;
   }

   public static void a(y.f.X var0, y.c.d var1, Collection var2, Collection var3) {
      int var11 = v.f;
      if(var1.e()) {
         if(var2 == null) {
            var2 = new ArrayList(1);
         }

         y.f.ax var4;
         label121: {
            if(((Collection)var2).isEmpty()) {
               var4 = y.f.ax.b((int)255);
               if(var11 == 0) {
                  break label121;
               }
            }

            var4 = (y.f.ax)((Collection)var2).iterator().next();
         }

         if(var3 == null) {
            var3 = new ArrayList(1);
         }

         y.f.ax var5;
         label115: {
            if(((Collection)var3).isEmpty()) {
               var5 = y.f.ax.b((int)255);
               if(var11 == 0) {
                  break label115;
               }
            }

            var5 = (y.f.ax)((Collection)var3).iterator().next();
         }

         if(a(var4, var5)) {
            boolean[] var6;
            boolean[] var7;
            label127: {
               var6 = a(var4.a());
               var7 = a(var5.a());
               int var10000;
               int var8;
               boolean var9;
               int var10;
               if(b(var6) > b(var7)) {
                  var8 = 0;

                  label103: {
                     while(var8 < var7.length) {
                        var10000 = var6[var8];
                        if(var11 != 0) {
                           break label103;
                        }

                        if(var10000 != 0 && var7[var8]) {
                           var6[var8] = false;
                        }

                        ++var8;
                        if(var11 != 0) {
                           break;
                        }
                     }

                     var10000 = b(var6);
                  }

                  if(var10000 != 0) {
                     break label127;
                  }

                  var8 = 0;

                  do {
                     if(var8 >= var7.length) {
                        break label127;
                     }

                     var9 = var7[var8];
                     if(var11 != 0) {
                        return;
                     }

                     if(var9) {
                        var10 = (var7.length + var8 - 1) % var7.length;
                        var6[var10] = true;
                        var7[var10] = false;
                        if(var11 == 0) {
                           break label127;
                        }
                     }

                     ++var8;
                  } while(var11 == 0);
               }

               var8 = 0;

               while(true) {
                  if(var8 < var6.length) {
                     var10000 = var6[var8];
                     if(var11 != 0) {
                        break;
                     }

                     if(var10000 != 0 && var7[var8]) {
                        var7[var8] = false;
                     }

                     ++var8;
                     if(var11 == 0) {
                        continue;
                     }
                  }

                  var10000 = b(var7);
                  break;
               }

               if(var10000 == 0) {
                  var8 = 0;

                  while(var8 < var6.length) {
                     var9 = var6[var8];
                     if(var11 != 0) {
                        return;
                     }

                     if(var9) {
                        var10 = (var8 + 1) % var6.length;
                        var7[var10] = true;
                        var6[var10] = false;
                        if(var11 == 0) {
                           break;
                        }
                     }

                     ++var8;
                     if(var11 != 0) {
                        break;
                     }
                  }
               }
            }

            var4 = a(var4, a(var6));
            var5 = a(var4, a(var7));
         }

         ((Collection)var2).clear();
         ((Collection)var2).add(var4);
         ((Collection)var3).clear();
         ((Collection)var3).add(var5);
      }
   }

   private static int a(boolean[] var0) {
      int var1 = 0;
      if(var0[0]) {
         var1 |= 1;
      }

      if(var0[1]) {
         var1 |= 4;
      }

      if(var0[2]) {
         var1 |= 2;
      }

      if(var0[3]) {
         var1 |= 8;
      }

      return var1;
   }

   private static boolean[] a(int var0) {
      boolean[] var1 = new boolean[4];
      if((var0 & 1) != 0) {
         var1[0] = true;
      }

      if((var0 & 4) != 0) {
         var1[1] = true;
      }

      if((var0 & 2) != 0) {
         var1[2] = true;
      }

      if((var0 & 8) != 0) {
         var1[3] = true;
      }

      return var1;
   }

   private static int b(boolean[] var0) {
      int var3 = v.f;
      int var1 = 0;
      int var2 = 0;

      int var10000;
      while(true) {
         if(var2 < var0.length) {
            var10000 = var0[var2];
            if(var3 != 0) {
               break;
            }

            if(var10000 != 0) {
               ++var1;
            }

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

   private static boolean a(y.f.ax var0, y.f.ax var1) {
      return var0.a((int)1) && var1.a((int)1) || var0.a((int)2) && var1.a((int)2) || var0.a((int)4) && var1.a((int)4) || var0.a((int)8) && var1.a((int)8);
   }

   private static y.f.ax a(y.f.ax var0, int var1) {
      return var0.b()?y.f.ax.a(var0.c(), var0.d(), var1, var0.f()):y.f.ax.a(var1, var0.f());
   }

   public static Collection a(y.f.X var0, y.c.d var1, Collection var2, boolean var3) {
      y.f.aE var4;
      y.d.t var5;
      label28: {
         if(var3) {
            var4 = y.f.aE.d(var0, var1);
            var5 = var0.b(var1).getSourcePoint();
            if(v.f == 0) {
               break label28;
            }
         }

         var4 = y.f.aE.e(var0, var1);
         var5 = var0.b(var1).getTargetPoint();
      }

      if(var4 != null) {
         y.f.ax var6 = y.f.ax.a(var4);
         if(var4.a()) {
            var5 = var3?var0.b(var1).getSourcePoint():var0.b(var1).getTargetPoint();
            var6 = y.f.ax.a(var5.a, var5.b, var6.a());
         }

         if(var2 == null) {
            var2 = new ArrayList(1);
         }

         ((Collection)var2).add(var6);
      }

      return (Collection)var2;
   }
}
