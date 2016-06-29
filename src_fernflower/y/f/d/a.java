package y.f.d;

import java.util.Iterator;
import y.f.M;
import y.f.O;
import y.f.Q;
import y.f.W;
import y.f.X;
import y.f.aH;
import y.f.aO;
import y.f.aP;
import y.f.ae;
import y.f.aj;
import y.f.al;
import y.f.am;
import y.f.d.b;
import y.f.d.c;
import y.f.d.d;
import y.f.d.e;
import y.f.d.n;
import y.f.d.q;
import y.f.d.r;
import y.f.d.s;
import y.f.d.t;
import y.f.d.u;

public abstract class a extends y.f.a {
   public static final Object a = "y.layout.labeling.AbstractLabelingAlgorithm.LABEL_MODEL_DPKEY";
   private aH g = null;
   private boolean h = false;
   private boolean i = false;
   private boolean n = false;
   private boolean o = false;
   private boolean p = false;
   private boolean q = true;
   private boolean r = true;
   private boolean s = false;
   private Object t = null;
   protected boolean b = false;
   y.f.b.c c;
   y.c.D d;
   boolean e = false;
   private boolean u = false;
   private static final y.d.n[] v = new y.d.n[]{new y.d.n(15.0D, 5.0D, 30.0D, 10.0D, 1.0D, 0.0D), new y.d.n(-15.0D, -15.0D, 100.0D, 30.0D, 0.5D, 0.5D), new y.d.n(50.0D, 90.0D, 40.0D, 15.0D, 0.0D, -1.0D)};
   private static final am w = new y.f.x(0.0D, 0.0D, 30.0D, 30.0D);
   public static int f;

   protected a() {
      this.g = new W();
   }

   public aH b() {
      return this.g;
   }

   public void c(X var1) {
      if(this.a() != null) {
         this.a().c(var1);
      }

      this.b(var1);
   }

   private void d(X var1) {
      this.a((y.c.n)var1, (O)var1);
   }

   private void a(y.c.n var1, O var2) {
      int var6 = f;
      y.c.c var3 = var1.c(y.f.b.f.d);
      if(var3 == null) {
         var3 = y.g.q.a((Object)Boolean.FALSE);
      }

      Iterator var4 = var1.x();

      while(var4.hasNext()) {
         Object var5 = var4.next();
         if(!var3.d(var5)) {
            this.a(var2, var5);
            if(var6 == 0) {
               continue;
            }
         }

         this.b(var2, var5);
         if(var6 != 0) {
            break;
         }
      }

   }

   protected void a(O var1, Object var2) {
      am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   protected void b(O var1, Object var2) {
      am var3 = var1.a(var2);
      if(var3.getWidth() == 0.0D || var3.getHeight() == 0.0D) {
         throw new IllegalArgumentException("Graph contains group nodes with zero width/height. Please enlarge those nodes manually or by using LayoutStage y.layout.MinNodeSizeStage.");
      }
   }

   public void b(X var1) {
      this.a(var1, this.t);
   }

   public void a(X var1, Object var2) {
      this.a(var1, var1.c(var2));
   }

   private void a(X var1, y.c.c var2) {
      if(var1.c("y.layout.labeling.ABSTRACT_LABELING_ALGORITHM_NODE_SIZE_CHECKED_DPKEY") == null) {
         this.d(var1);
      }

      try {
         if(var1.c(y.f.b.f.d) != null) {
            this.c = new y.f.b.c(var1);
         }

         r[] var3 = this.b(var1, var2);
         this.c(var1, var3);
         this.a(var3);
         if(this.o) {
            this.a(var1, var2, var3.length);
         }
      } finally {
         if(this.c != null) {
            this.c.c();
            this.c = null;
         }

      }

   }

   void a(X var1, y.c.c var2, int var3) {
      u var4;
      label19: {
         int var6 = f;
         var4 = new u();
         int var5 = var1.f() + var1.h() + var3;
         if(var5 > 5000) {
            var4.c(20.0D);
            if(var6 == 0) {
               break label19;
            }
         }

         if(var5 > 1000) {
            var4.c(10.0D);
            if(var6 == 0) {
               break label19;
            }
         }

         var4.c(5.0D);
      }

      var4.b(35.0D);
      var4.a(5.0D);
      var4.b(true);
      var4.c(true);
      var4.a(false);
      var4.a(var1, var2);
   }

   private static boolean a(y.d.y var0, aj var1) {
      return y.d.n.a(new y.d.n(var0), var1.getOrientedBox(), 0.001D) && !a(var1.a());
   }

   private static boolean a(al var0) {
      int var4 = f;
      if(var0 instanceof M) {
         return true;
      } else {
         int var1 = 0;

         boolean var10000;
         while(true) {
            if(var1 < v.length) {
               Object var2 = var0.a(v[var1], w);
               y.d.n var3 = var0.a(v[var1].d(), w, var2);
               var10000 = y.d.n.a(v[var1], var3, 1.0D);
               if(var4 != 0) {
                  break;
               }

               if(!var10000) {
                  return false;
               }

               ++var1;
               if(var4 == 0) {
                  continue;
               }
            }

            var10000 = true;
            break;
         }

         return var10000;
      }
   }

   private r[] b(X var1, y.c.c var2) {
      int var14 = f;
      y.c.c var3 = var1.c(a);
      r[] var4 = new r[e(var1)];
      int var5 = 0;
      y.c.x var6 = var1.o();

      boolean var10000;
      X var22;
      label109:
      while(true) {
         var10000 = var6.f();

         label106:
         while(var10000) {
            y.c.q var7 = var6.e();
            y.d.y var8 = var1.s(var7);
            var22 = var1;
            if(var14 != 0) {
               break label109;
            }

            aj[] var9 = var1.i(var7);
            int var10 = 0;

            while(var10 < var9.length) {
               var4[var5] = new t(var5, var9[var10]);
               var10000 = this.q;
               if(var14 != 0) {
                  continue label106;
               }

               boolean var11 = !var10000 || !this.p && a(var8, var9[var10]) || var2 != null && !var2.d(var9[var10]);
               var4[var5].a(var11);
               al var12 = var3 == null?null:(al)var3.b(var9[var10]);
               y.c.D var13 = s.a(var1, var7, var9[var10], var12, var11);
               var4[var5].a(var13);
               ++var10;
               ++var5;
               if(var14 != 0) {
                  break;
               }
            }

            var6.g();
            if(var14 == 0) {
               continue label109;
            }
            break;
         }

         var22 = var1;
         break;
      }

      y.c.e var15 = var22.p();

      label74:
      while(true) {
         var10000 = var15.f();

         label71:
         while(var10000) {
            y.c.d var16 = var15.a();
            y.f.C[] var17 = var1.h(var16);
            if(var14 != 0) {
               return var4;
            }

            int var18 = 0;

            while(var18 < var17.length) {
               var4[var5] = new q(var5, var17[var18]);
               var10000 = this.r;
               if(var14 != 0) {
                  continue label71;
               }

               boolean var19 = !var10000 || var2 != null && !var2.d(var17[var18]);
               var4[var5].a(var19);
               y.f.E var20 = var3 == null?null:(y.f.E)var3.b(var17[var18]);
               y.c.D var21 = n.a(var1, var16, var17[var18], var20, var19, this.s, this.u);
               var4[var5].a(var21);
               ++var18;
               ++var5;
               if(var14 != 0) {
                  break;
               }
            }

            var15.g();
            if(var14 == 0) {
               continue label74;
            }
            break;
         }

         this.a(var1, var4);
         this.b(var1, var4);
         return var4;
      }
   }

   void a(X var1, r[] var2) {
      int var8 = f;
      y.c.D var3 = new y.c.D();
      y.c.x var4 = var1.o();

      byte var10000;
      while(true) {
         if(var4.f()) {
            var10000 = var3.add(new c(var1.s(var4.e()), var4.e()));
            if(var8 != 0) {
               break;
            }

            var4.g();
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = 0;
         break;
      }

      int var9 = var10000;

      y.c.D var5;
      y.c.D var11;
      while(true) {
         if(var9 < var2.length) {
            var5 = var2[var9].b();
            var11 = var5;
            if(var8 != 0) {
               break;
            }

            y.c.C var6 = var5.m();

            label65: {
               while(var6.f()) {
                  var3.add(var6.d());
                  var6.g();
                  if(var8 != 0) {
                     break label65;
                  }

                  if(var8 != 0) {
                     break;
                  }
               }

               ++var9;
            }

            if(var8 == 0) {
               continue;
            }
         }

         var11 = var3;
         break;
      }

      y.d.f.a(var11, new d(var1, this.c));
      if(this.i) {
         var9 = 0;

         do {
            int var12 = var9;

            label46:
            while(true) {
               if(var12 >= var2.length) {
                  return;
               }

               var5 = var2[var9].b();
               y.c.p var10 = var5.k();

               while(true) {
                  if(var10 == null) {
                     break label46;
                  }

                  Q var7 = (Q)var10.c();
                  double var13;
                  var12 = (var13 = var7.i() - 0.0D) == 0.0D?0:(var13 < 0.0D?-1:1);
                  if(var8 != 0) {
                     break;
                  }

                  if(var12 > 0) {
                     var5.h(var10);
                  }

                  var10 = var10.a();
                  if(var8 != 0) {
                     break label46;
                  }
               }
            }

            ++var9;
         } while(var8 == 0);
      }

   }

   void b(X var1, r[] var2) {
      int var8 = f;
      y.c.D var3 = new y.c.D();
      int var4 = 0;

      y.c.D var5;
      y.c.p var12;
      label139:
      while(true) {
         if(var4 < var2.length) {
            var5 = var2[var4].b();
            if(var8 != 0) {
               var12 = var5.k();
               break;
            }

            y.c.C var6 = var5.m();

            while(true) {
               if(!var6.f()) {
                  ++var4;
                  if(var8 == 0) {
                     continue label139;
                  }
                  break;
               }

               var3.add(var6.d());
               var6.g();
               if(var8 != 0) {
                  if(var8 == 0) {
                     continue label139;
                  }
                  break;
               }

               if(var8 != 0) {
                  ++var4;
                  if(var8 == 0) {
                     continue label139;
                  }
                  break;
               }
            }
         }

         y.c.e var9 = var1.p();

         label61: {
            while(var9.f()) {
               y.d.v var10 = ae.c(var1, var9.a());
               if(var8 != 0) {
                  break label61;
               }

               y.d.s var11 = var10.j();

               while(true) {
                  if(var11.f()) {
                     y.d.m var7 = var11.a();
                     var3.add(new e(var7, var9.a()));
                     var11.g();
                     if(var8 != 0) {
                        break;
                     }

                     if(var8 == 0) {
                        continue;
                     }
                  }

                  var9.g();
                  break;
               }

               if(var8 != 0) {
                  break;
               }
            }

            y.d.f.a(var3, new b(var1, this.n));
         }

         if(!this.h) {
            return;
         }

         var4 = 0;
         if(var4 >= var2.length) {
            return;
         }

         var5 = var2[var4].b();
         var12 = var5.k();
         break;
      }

      while(true) {
         while(var12 == null) {
            ++var4;
            if(var8 != 0 || var4 >= var2.length) {
               return;
            }

            var5 = var2[var4].b();
            var12 = var5.k();
         }

         Q var13 = (Q)var12.c();
         double var14;
         int var10000 = (var14 = var13.j() - 0.0D) == 0.0D?0:(var14 < 0.0D?-1:1);
         if(var8 == 0) {
            if(var10000 > 0) {
               var5.h(var12);
            }

            var12 = var12.a();
            if(var8 != 0) {
               ++var4;
               if(var8 != 0 || var4 >= var2.length) {
                  break;
               }

               var5 = var2[var4].b();
               var12 = var5.k();
            }
         } else {
            if(var10000 >= var2.length) {
               break;
            }

            var5 = var2[var4].b();
            var12 = var5.k();
         }
      }

   }

   private static int e(X var0) {
      int var3 = f;
      int var1 = 0;
      y.c.x var2 = var0.o();

      while(var2.f()) {
         var1 += var0.i(var2.e()).length;
         var2.g();
         if(var3 != 0) {
            break;
         }
      }

      y.c.e var4 = var0.p();

      int var10000;
      while(true) {
         if(var4.f()) {
            var10000 = var1 + var0.h(var4.a()).length;
            if(var3 != 0) {
               break;
            }

            var1 = var10000;
            var4.g();
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public void a(aH var1) {
      this.g = var1;
      if(var1 == null) {
         this.b = false;
         if(f == 0) {
            return;
         }
      }

      this.b = true;
   }

   public double a(Q var1) {
      double var2 = 0.0D;
      if(this.g != null) {
         return this.g.a(var1);
      } else {
         Object var4 = var1.l();
         if(var4 instanceof aO) {
            aP var5 = (aP)var4;
            var2 = 1.0D - Math.abs((0.5D - var5.e()) * 2.0D);
            if(f == 0) {
               return var2;
            }
         }

         var2 = 1.0D;
         return var2;
      }
   }

   abstract void c(X var1, r[] var2);

   private void a(r[] var1) {
      int var5 = f;
      if(this.e) {
         label38: {
            if(this.d == null) {
               this.d = new y.c.D();
               if(var5 == 0) {
                  break label38;
               }
            }

            this.d.clear();
         }

         int var2 = 0;

         while(var2 < var1.length) {
            y.c.D var3 = var1[var2].b();
            y.c.C var4 = var3.m();

            while(true) {
               if(var4.f()) {
                  this.d.add(var4.d());
                  var4.g();
                  if(var5 != 0) {
                     break;
                  }

                  if(var5 == 0) {
                     continue;
                  }
               }

               ++var2;
               break;
            }

            if(var5 != 0) {
               break;
            }
         }

      }
   }
}
