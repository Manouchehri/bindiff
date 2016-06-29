package y.f.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import y.f.c.a.N;
import y.f.c.a.bh;
import y.f.c.a.bl;
import y.f.c.a.bm;
import y.f.c.a.bt;
import y.f.c.a.l;

public class bk {
   public static final Object a = "y.layout.hierarchic.incremental.PartitionGrid.PARTITION_DPKEY";
   public static final Object b = "y.layout.hierarchic.incremental.PartitionGrid.PARTITION_CELL_DPKEY";
   private y.c.D c;
   private y.c.D d;
   private boolean e;
   private boolean f;

   public bk() {
      this.c = new y.c.D();
      this.d = new y.c.D();
      this.e = true;
      this.f = true;
   }

   public bk(int var1, int var2) {
      this(var1, var2, 0.0D, 0.0D, 0.0D, 0.0D);
   }

   public bk(int var1, int var2, double var3, double var5, double var7, double var9) {
      boolean var13 = N.x;
      super();
      this.c = new y.c.D();
      this.d = new y.c.D();
      this.e = true;
      this.f = true;
      int var11 = 0;

      while(true) {
         if(var11 < var1) {
            bt var12 = this.c();
            var12.a(var7);
            var12.c(var3);
            var12.b(var3);
            ++var11;
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var11 = 0;
         break;
      }

      while(var11 < var2) {
         l var14 = this.d();
         var14.a(var9);
         var14.c(var5);
         var14.b(var5);
         ++var11;
         if(var13) {
            break;
         }
      }

   }

   public boolean a() {
      return this.e;
   }

   public boolean b() {
      return this.f;
   }

   byte a(y.c.i var1) {
      y.c.c var2 = var1.c((Object)"PARTITION_ORIENTATION_DPKEY");
      return var2 != null?((y.f.an)var2.b(var1)).b():0;
   }

   boolean b(y.c.i var1) {
      y.c.c var2 = var1.c((Object)"PARTITION_ORIENTATION_DPKEY");
      if(var2 != null) {
         y.f.an var3 = (y.f.an)var2.b(var1);
         return var3.b(var3.b());
      } else {
         return false;
      }
   }

   public bh a(int var1, int var2, int var3, int var4) {
      boolean var8 = N.x;
      ArrayList var5 = new ArrayList();
      int var6 = var2;

      ArrayList var10000;
      while(true) {
         if(var6 <= var4) {
            var10000 = var5;
            if(var8) {
               break;
            }

            var5.add(this.b(var6));
            ++var6;
            if(!var8) {
               continue;
            }
         }

         var10000 = new ArrayList();
         break;
      }

      ArrayList var9 = var10000;
      int var7 = var1;

      while(var7 <= var3) {
         var9.add(this.a(var7));
         ++var7;
         if(var8) {
            break;
         }
      }

      return new bh(var9, var5);
   }

   public bh a(Collection var1, Collection var2) {
      return new bh(var1, var2);
   }

   public static bk c(y.c.i var0) {
      y.c.c var1 = var0.c(a);
      return var1 != null && var0.c(b) != null?(bk)var1.b(var0):null;
   }

   public bt c() {
      bt var1 = new bt(this.c.size(), this);
      this.c.add(var1);
      return var1;
   }

   public l d() {
      l var1 = new l(this.d.size(), this);
      this.d.add(var1);
      return var1;
   }

   public static boolean d(y.c.i var0) {
      boolean var9 = N.x;
      bk var1 = c(var0);
      if(var1 != null) {
         y.f.b.c var10000;
         label41: {
            y.f.b.c var2 = new y.f.b.c(var0);
            if(var1.e().size() > 1) {
               int var3 = -2;
               y.c.c var4 = var0.c(b);
               y.c.x var5 = var0.o();

               while(var5.f()) {
                  y.c.q var6 = var5.e();
                  var10000 = var2;
                  if(var9) {
                     break label41;
                  }

                  if(var2 == null || !var2.d(var6)) {
                     bh var7 = (bh)var4.b(var6);
                     int var8 = var7 != null?var7.c().a():-1;
                     if(var3 != -2) {
                        if(var3 != var8) {
                           var2.c();
                           return true;
                        }
                     } else {
                        var3 = var8;
                     }
                  }

                  var5.g();
                  if(var9) {
                     break;
                  }
               }
            }

            var10000 = var2;
         }

         var10000.c();
      }

      return false;
   }

   public bt a(int var1) {
      boolean var4 = N.x;
      y.c.C var2 = this.c.m();

      while(var2.f()) {
         bt var3 = (bt)var2.d();
         if(var3.a() == var1) {
            return var3;
         }

         var2.g();
         if(var4) {
            break;
         }
      }

      return null;
   }

   public l b(int var1) {
      boolean var4 = N.x;
      y.c.C var2 = this.d.m();

      while(var2.f()) {
         l var3 = (l)var2.d();
         if(var3.a() == var1) {
            return var3;
         }

         var2.g();
         if(var4) {
            break;
         }
      }

      return null;
   }

   public y.c.D e() {
      return this.c;
   }

   public y.c.D f() {
      return this.d;
   }

   public bh a(bt var1, l var2) {
      return new bh(var1, var2);
   }

   public bh a(int var1, int var2) {
      return new bh(this.a(var1), this.b(var2));
   }

   void e(y.c.i var1) {
      if(this.f) {
         this.a(var1, true);
      }

   }

   void f(y.c.i var1) {
      if(this.e) {
         this.a(var1, false);
      }

   }

   public void a(y.f.an var1, y.f.ao var2) {
      boolean var7 = N.x;
      boolean var3 = var1.d();
      y.c.C var4 = this.f().m();

      y.d.t var6;
      while(true) {
         if(var4.f()) {
            l var5 = (l)var4.d();
            var6 = var2.a(this.a(var5, var3));
            var5.g(var6.a());
            var4.g();
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         var4 = this.e().m();
         break;
      }

      while(var4.f()) {
         bt var8 = (bt)var4.d();
         var6 = var2.a(this.a(var8, var3));
         var8.g(var6.b());
         var4.g();
         if(var7) {
            break;
         }
      }

   }

   public void b(y.f.an var1, y.f.ao var2) {
      boolean var7 = N.x;
      boolean var3 = var1.d();
      y.c.C var4 = this.f().m();

      Object var10000;
      y.d.t var6;
      while(true) {
         if(var4.f()) {
            l var5 = (l)var4.d();
            var6 = var2.b(new y.d.t(var5.h(), 0.0D));
            var10000 = var5;
            if(var7) {
               break;
            }

            var5.g(var3?var6.b():var6.a());
            var4.g();
            if(!var7) {
               continue;
            }

            var4 = this.e().m();
         } else {
            var4 = this.e().m();
         }

         if(!var4.f()) {
            return;
         }

         var10000 = var4.d();
         break;
      }

      while(true) {
         bt var8 = (bt)var10000;
         var6 = var2.b(new y.d.t(0.0D, var8.h()));
         var8.g(var3?var6.a():var6.b());
         var4.g();
         if(var7 || !var4.f()) {
            return;
         }

         var10000 = var4.d();
      }
   }

   private y.d.t a(l var1, boolean var2) {
      return var2?new y.d.t(0.0D, var1.h()):new y.d.t(var1.h(), 0.0D);
   }

   private y.d.t a(bt var1, boolean var2) {
      return var2?new y.d.t(var1.h(), 0.0D):new y.d.t(0.0D, var1.h());
   }

   private void a(y.c.i var1, boolean var2) {
      boolean var13 = N.x;
      y.c.c var3 = var1.c(b);
      if(var3 != null) {
         y.c.A var4 = var1.t();
         HashMap var5 = new HashMap();
         y.c.D var6 = new y.c.D();
         boolean var7 = false;
         y.c.x var8 = var1.o();

         label140:
         while(true) {
            bt var11;
            y.f.aT var12;
            l var21;
            if(var8.f()) {
               y.c.q var9 = var8.e();
               bh var10 = (bh)var3.b(var9);
               if(var13) {
                  break;
               }

               if(var10 != null) {
                  label163: {
                     if(var2) {
                        label131: {
                           var11 = var10.c();
                           if(!var5.containsKey(var11)) {
                              var6.add(var11);
                              var12 = new y.f.aT(0, !var11.j());
                              var4.a(var9, var12);
                              var5.put(var11, var12);
                              if(!var13) {
                                 break label131;
                              }
                           }

                           var12 = (y.f.aT)var5.get(var11);
                           var4.a(var9, var12);
                        }

                        var7 = var7 || !var11.j();
                        if(!var13) {
                           break label163;
                        }
                     }

                     label120: {
                        var21 = var10.d();
                        if(!var5.containsKey(var21)) {
                           var6.add(var21);
                           var12 = new y.f.aT(0, !var21.j());
                           var4.a(var9, var12);
                           var5.put(var21, var12);
                           if(!var13) {
                              break label120;
                           }
                        }

                        var12 = (y.f.aT)var5.get(var21);
                        var4.a(var9, var12);
                     }

                     var7 = var7 || !var21.j();
                  }
               }

               var8.g();
               if(!var13) {
                  continue;
               }
            }

            if(var7) {
               if(var2) {
                  bl var14 = new bl(this);
                  var6.sort(var14);
               } else {
                  bm var15 = new bm(this);
                  var6.sort(var15);
               }

               int var16 = 0;
               y.c.C var17 = var6.m();

               label101: {
                  while(var17.f()) {
                     y.f.aT var19 = (y.f.aT)var5.get(var17.d());
                     var19.a(var16++);
                     var17.g();
                     if(var13) {
                        break label101;
                     }

                     if(var13) {
                        break;
                     }
                  }

                  y.f.aR.a(var1, var4, 5, 2);
               }

               int var18 = var6.size();
               y.c.C var20;
               if(var2) {
                  var20 = this.e().m();

                  do {
                     if(!var20.f()) {
                        break label140;
                     }

                     var11 = (bt)var20.d();
                     var12 = (y.f.aT)var5.get(var11);
                     if(var13) {
                        return;
                     }

                     label86: {
                        if(var12 != null) {
                           var11.a(var12.a());
                           if(!var13) {
                              break label86;
                           }
                        }

                        var11.a(var18++);
                     }

                     var20.g();
                  } while(!var13);
               }

               var20 = this.f().m();

               while(var20.f()) {
                  var21 = (l)var20.d();
                  var12 = (y.f.aT)var5.get(var21);
                  if(var13) {
                     return;
                  }

                  label73: {
                     if(var12 != null) {
                        var21.a(var12.a());
                        if(!var13) {
                           break label73;
                        }
                     }

                     var21.a(var18++);
                  }

                  var20.g();
                  if(var13) {
                     break label140;
                  }
               }
            }
            break;
         }

         var1.a(var4);
      }

   }
}
