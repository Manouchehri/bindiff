package y.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import y.c.A;
import y.c.q;
import y.c.x;
import y.d.a.c;
import y.d.a.e;
import y.d.a.g;
import y.d.a.h;
import y.d.a.i;
import y.d.a.j;
import y.d.a.k;
import y.d.b.v;
import y.f.h.N;
import y.g.o;

public class b {
   protected int a;
   private y.d.b.l c;
   private k d;
   private y.c.i e;
   private y.c.h f;
   private A g;
   private i h;
   public static int b;

   public void a(k var1) {
      this.d = var1;
   }

   public void a(y.d.b.l var1, Collection var2, N var3, A var4, y.c.h var5) {
      int var11 = b;
      this.e = var3.g();
      this.e.j();
      this.g = var4;
      this.f = var5;
      this.a = 0;
      this.a(var1, var2);
      ArrayList var6 = new ArrayList(this.e.h());
      y.c.e var7 = this.e.p();

      while(true) {
         if(var7.f()) {
            var6.add(var7.a());
            var7.g();
            if(var11 != 0) {
               break;
            }

            if(var11 == 0) {
               continue;
            }
         }

         y.g.e.a((List)var6, new g(this, var5));
         break;
      }

      int var12 = 0;

      while(var12 < var6.size()) {
         y.c.d var8;
         y.c.d var9;
         e var10;
         label26: {
            var8 = (y.c.d)var6.get(var12);
            var9 = this.e.a(var8.d(), var8.d().f(), var8.c(), (y.c.d)null, 1, 1);
            var3.b(var8, var9);
            var10 = (e)var5.b(var8);
            if(var10.a()) {
               var3.m(var8);
               if(var11 == 0) {
                  break label26;
               }
            }

            var3.m(var9);
         }

         var5.a(var8, var10.e);
         var5.a(var9, var10.e);
         ++var12;
         if(var11 != 0) {
            break;
         }
      }

      if(y.c.i.g) {
         ++var11;
         b = var11;
      }

   }

   public void a(y.d.b.l var1, Collection var2, y.c.i var3, A var4, y.c.h var5) {
      int var9 = b;
      this.e = var3;
      var3.j();
      this.g = var4;
      this.f = var5;
      this.a = 0;
      this.a(var1, var2);
      y.c.e var6 = var3.p();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         Object var8 = ((e)var5.b(var7)).e;
         var5.a(var7, var8);
         var6.g();
         if(var9 != 0) {
            break;
         }
      }

   }

   public void a(y.d.b.l var1, Collection var2) {
      int var15 = b;
      this.c = var1;
      TreeMap var3 = new TreeMap(var1.c());
      h var4 = new h(this, (c)null);
      this.a(var2, var3, var4);
      e[] var5 = new e[2];
      ArrayList var6 = new ArrayList();
      q var7 = null;

      do {
         boolean var10000 = var3.isEmpty();

         Object var10;
         e var12;
         label93:
         while(true) {
            if(var10000) {
               return;
            }

            Object var8 = var3.firstKey();
            j var9 = (j)var3.get(var8);
            var10 = var9.c;
            var3.remove(var8);
            if(this.d != null) {
               this.d.a(var9);
            }

            int var11;
            label50: {
               var4.a(var10, var6, var5);
               if(this.a == 0) {
                  var7 = this.e.d();
                  this.g.a(var7, var10);
                  var11 = 0;

                  while(var11 < var6.size()) {
                     var12 = (e)var6.get(var11);
                     y.c.d var13 = this.e.a(var7, var7.f(), var12.a, (y.c.d)null, 1, 1);
                     this.f.a(var13, var12);
                     var12.a = var7;
                     ++var11;
                     if(var15 != 0) {
                        break label50;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }
               }

               var11 = 0;
            }

            label60: {
               while(var11 < var9.b.size()) {
                  var12 = (e)var9.b.get(var11);
                  var4.a(var12);
                  ++var11;
                  if(var15 != 0) {
                     break label60;
                  }

                  if(var15 != 0) {
                     break;
                  }
               }

               var4.a(var10);
            }

            var11 = 0;

            while(var11 < var9.a.size()) {
               var12 = (e)var9.a.get(var11);
               var12.a = var7;
               var4.a(var10, var12);
               ++var11;
               if(var15 != 0) {
                  break label93;
               }

               if(var15 != 0) {
                  break;
               }
            }

            if(this.a != 1) {
               break;
            }

            var6.addAll(var9.a);
            var11 = 0;

            while(true) {
               if(var11 >= var6.size()) {
                  break label93;
               }

               Object var16 = var6.get(var11);
               var10000 = false;
               if(var15 != 0) {
                  break;
               }

               int var17 = 0;

               label80: {
                  while(var17 < var6.size()) {
                     Object var14 = var6.get(var17);
                     this.h.a(var16, var14);
                     ++var17;
                     if(var15 != 0) {
                        break label80;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  ++var11;
               }

               if(var15 != 0) {
                  break label93;
               }
            }
         }

         e var18 = var4.b(var5[0]);
         this.a(var10, var3, var5[0], var18);
         var12 = var4.c(var5[1]);
         this.a(var10, var3, var12, var5[1]);
      } while(var15 == 0);

   }

   private void a(Collection var1, TreeMap var2, h var3) {
      int var23 = b;
      int var4 = 0;
      Comparator var5 = this.c.c();
      double var6 = 1.0D;
      Object var8 = var1.iterator();

      Object var9;
      Object var10;
      Object var11;
      Object var12;
      Object var10000;
      while(true) {
         if(((Iterator)var8).hasNext()) {
            var9 = ((Iterator)var8).next();
            var10 = this.c.c(var9);
            var11 = this.c.d(var9);
            var10000 = var5;
            if(var23 != 0) {
               break;
            }

            if(var5.compare(var10, var11) > 0) {
               var12 = var11;
               var11 = var10;
               var10 = var12;
            }

            double var24 = this.c.k(var10).e();
            double var14 = this.c.l(var10).e();
            double var16 = this.c.k(var11).e();
            double var18 = this.c.l(var11).e();
            if(var24 < 0.0D) {
               var24 = -var24;
            }

            if(var14 < 0.0D) {
               var14 = -var14;
            }

            if(var16 < 0.0D) {
               var16 = -var16;
            }

            if(var18 < 0.0D) {
               var18 = -var18;
            }

            do {
               double var10001;
               double var26;
               label61: {
                  if(var24 < var6) {
                     var26 = var14;
                     var10001 = var6;
                     if(var23 != 0) {
                        break label61;
                     }

                     if(var14 < var6 && var16 < var6 && var18 < var6) {
                        break;
                     }
                  }

                  var26 = var6;
                  var10001 = 2.0D;
               }

               var6 = var26 * var10001;
            } while(var23 == 0);

            j var20 = (j)var2.get(var10);
            if(var20 == null) {
               var20 = new j(var10);
               var2.put(var10, var20);
            }

            j var21 = (j)var2.get(var11);
            if(var21 == null) {
               var21 = new j(var11);
               var2.put(var11, var21);
            }

            if(var10.equals(var11)) {
               continue;
            }

            e var22 = new e(this, var10, var11, var9, var4++);
            var20.a.add(var22);
            var21.b.add(var22);
            if(var23 == 0) {
               continue;
            }
         }

         var8 = this.c.a(-var6, var6);
         var9 = this.c.a(var6, var6);
         var10 = this.c.a(-var6, -var6);
         var11 = this.c.a(var6, -var6);
         var10000 = this.c.c(var8, var9);
         break;
      }

      var12 = var10000;
      Object var13 = this.c.c(var10, var11);
      e var25 = new e(this, var8, var9, var12, var4++);
      e var15 = new e(this, var10, var11, var13, var4++);
      var3.a(var8, var25);
      var3.a(var10, var15);
   }

   protected void a(Object var1, TreeMap var2, e var3, e var4) {
      int var9 = b;
      Object var5 = this.c.f(var3.g, var4.g);
      if(var5 != null) {
         if(this.c.c().compare(var1, var5) < 0) {
            boolean var6 = false;

            label63:
            while(true) {
               if(this.c.c().compare(var5, var3.d) < 0) {
                  var6 = true;
               }

               var3 = var3.h;
               if(var3 == null || var6) {
                  while(var9 != 0) {
                     if(true) {
                        continue label63;
                     }
                  }

                  boolean var7 = false;

                  label46:
                  while(true) {
                     if(this.c.c().compare(var5, var4.d) < 0) {
                        var7 = true;
                     }

                     var4 = var4.h;
                     if(var4 == null || var7) {
                        while(var9 != 0) {
                           if(!var6) {
                              continue label46;
                           }
                        }

                        if(var6 && var7 && !var2.containsKey(var5)) {
                           j var8 = new j(var5);
                           var2.put(var5, var8);
                        }

                        return;
                     }
                  }
               }
            }
         }
      }
   }

   public void a(y.d.b.l var1, Collection var2, y.c.i var3, A var4, y.c.h var5, boolean var6) {
      int var24 = b;
      Object var7 = var1.i(var1.a(new v(0L), new v(0L)), var1.a(new v(0L), new v(-1L)));
      Comparator var8 = var1.c();
      x var9 = var3.o();

      int var10000;
      Object var18;
      Object var19;
      byte var35;
      label164:
      while(true) {
         var10000 = var9.f();

         label161:
         while(true) {
            if(var10000 != 0) {
               q var10 = var9.e();
               Object var11 = var4.b(var10);
               double var12 = -1.7976931348623157E308D;
               e var14 = null;
               if(var24 != 0) {
                  break;
               }

               y.c.e var15 = var10.l();

               while(var15.f()) {
                  y.c.d var16 = var15.a();
                  e var17 = (e)var5.b(var16);
                  var18 = var4.b(var16.d());
                  var19 = var1.i(var11, var18);
                  double var20 = var1.h(var7, var19);
                  double var38;
                  var10000 = (var38 = var20 - 0.0D) == 0.0D?0:(var38 < 0.0D?-1:1);
                  if(var24 != 0) {
                     continue label161;
                  }

                  if(var10000 == 0) {
                     var20 = 6.283185307179586D;
                  }

                  if(var20 < var12) {
                     o.a((Object)("Error: Edge: " + var16 + " Angle: " + var20 / 3.141592653589793D * 2.0D + " !!"));
                  }

                  if(var20 == var12) {
                     label178: {
                        if(var8.compare(var11, var18) > 0) {
                           if(var17.b() <= var14.b()) {
                              break label178;
                           }

                           o.a((Object)"Error  ....>");
                           if(var24 == 0) {
                              break label178;
                           }

                           y.c.i.g = !y.c.i.g;
                        }

                        if(var17.b() < var14.b()) {
                           o.a((Object)"Error  ....>");
                        }
                     }
                  }

                  var12 = var20;
                  var14 = var17;
                  var15.g();
                  if(var24 != 0) {
                     break;
                  }
               }

               var9.g();
               if(var24 == 0) {
                  continue label164;
               }
            }

            if(var6) {
               var35 = 2;
               break label164;
            }
            break;
         }

         var35 = 1;
         break;
      }

      byte var25 = var35;
      TreeMap var26 = new TreeMap(var1.c());
      x var27 = var3.o();

      Object var13;
      while(var27.f()) {
         q var29 = var27.e();
         var13 = var4.b(var29);
         Object var31 = var26.put(var13, var29);
         if(var31 != null) {
            o.a((Object)("Points is double mentioned :" + var13));
         }

         var27.g();
         if(var24 != 0) {
            break;
         }
      }

      Object[] var28 = var2.toArray();
      int var30 = 0;

      do {
         var10000 = var30;

         label115:
         while(true) {
            if(var10000 >= var28.length - 1) {
               return;
            }

            var13 = var28[var30];
            int var32 = var30 + 1;

            while(true) {
               if(var32 >= var28.length) {
                  break label115;
               }

               Object var33 = var28[var32];
               Object var34 = var1.c(var13);
               Object var36 = var1.c(var33);
               var18 = var1.d(var13);
               var19 = var1.d(var33);
               var10000 = var1.a(var13);
               if(var24 != 0) {
                  break;
               }

               int var37 = var10000 != 0?0:1;
               int var21 = var1.a(var33)?0:1;
               boolean var22 = false;
               if(var1.b(var13, var36)) {
                  var22 = true;
                  this.a(var26, var5, var36, var13, var33, 2, var21, var25);
               }

               if(var1.b(var13, var19)) {
                  var22 = true;
                  this.a(var26, var5, var19, var13, var33, 2, var21, var25);
               }

               if(var1.b(var33, var34)) {
                  var22 = true;
                  this.a(var26, var5, var34, var13, var33, var37, 2, var25);
               }

               if(var1.b(var33, var18)) {
                  var22 = true;
                  this.a(var26, var5, var18, var13, var33, var37, 2, var25);
               }

               if(!var22) {
                  Object var23 = var1.g(var13, var33);
                  if(var23 != null && (!var34.equals(var23) && !var18.equals(var23) || !var36.equals(var23) && !var19.equals(var23))) {
                     this.a(var26, var5, var23, var13, var33, 2, 2, var25);
                  }
               }

               ++var32;
               if(var24 != 0) {
                  break label115;
               }
            }
         }

         ++var30;
      } while(var24 == 0);

   }

   protected boolean a(TreeMap var1, y.c.h var2, Object var3, Object var4, Object var5, int var6, int var7, int var8) {
      int var15 = b;
      q var9 = (q)var1.get(var3);
      if(var9 == null) {
         o.a((Object)"Crossing not found: ");
         o.a(var4);
         o.a(var5);
         o.a(var3);
         return false;
      } else {
         int var10 = 0;
         int var11 = 0;
         y.c.e var12 = var9.j();

         while(true) {
            if(var12.f()) {
               y.c.d var13 = var12.a();
               Object var14 = var2.b(var13);
               if(var15 != 0) {
                  break;
               }

               if(var14 == var4) {
                  ++var10;
               }

               if(var14 == var5) {
                  ++var11;
               }

               var12.g();
               if(var15 == 0) {
                  continue;
               }
            }

            if(var10 == var6 * var8 && var11 == var7 * var8) {
               return true;
            }

            o.a((Object)"Crossing found, but not for this segments:");
            o.a((Object)("at " + var3));
            break;
         }

         if(var10 != var6 * var8) {
            o.a((Object)("Is: " + var10 + " Should: " + var6 + " Seg: " + var4));
         }

         if(var11 != var7 * var8) {
            o.a((Object)("Is: " + var11 + " Should: " + var7 + " Seg: " + var5));
         }

         return false;
      }
   }

   static y.d.b.l a(b var0) {
      return var0.c;
   }
}
