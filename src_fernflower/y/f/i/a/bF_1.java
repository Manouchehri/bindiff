package y.f.i.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.bG;
import y.f.i.a.bH;
import y.f.i.a.bI;
import y.f.i.a.bJ;
import y.f.i.a.bK;
import y.f.i.a.bL;
import y.f.i.a.bN;
import y.f.i.a.bP;
import y.f.i.a.bQ;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.i.a.y;

class bF extends ab {
   private final List b = new y.c.D();
   private final Set c = new HashSet();
   private final HashMap d = new HashMap();
   private final HashMap e = new HashMap();
   private final HashMap f = new HashMap();
   private y.c.b g;
   private y.c.b h;
   private y.c.b i;
   private y.c.h j;
   private Object k;
   private Object l;
   private boolean m;
   private y.c.c n;
   private y.c.c o;
   private y.c.c p;
   private y.c.c q;
   private y.c.c r;
   private y.c.c s;
   private y.c.c t;

   protected void a(Z var1) {
      super.a(var1);
      y.f.X var2 = var1.a();
      this.m = var2.c(y.f.aF.c) != null || var2.c(y.f.aF.d) != null;
      if(this.m) {
         this.d();
      }

   }

   protected void c() {
      if(this.m) {
         this.e();
         this.f();
         this.l = null;
         this.k = null;
         this.d.clear();
      }

      super.c();
   }

   private void d() {
      int var8 = ab.a;
      y.f.X var1 = this.a().a();
      y.c.c var2 = var1.c(y.f.aF.c);
      y.c.c var3 = var1.c(y.f.aF.d);
      y.c.h var4 = y.g.M.b();
      var1.a((Object)y.a, (y.c.c)var4);
      this.j = y.g.M.b();
      y.c.e var5 = var1.p();

      y.c.c var10000;
      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            var10000 = var2;
            if(var8 != 0) {
               break;
            }

            label61: {
               Object var7;
               if(var2 != null && var2.b(var6) != null) {
                  var7 = var2.b(var6);
                  var4.a(var6, new bQ(var6.c(), var7));
                  if(var8 == 0) {
                     break label61;
                  }
               }

               if(var3 != null && var3.b(var6) != null) {
                  var7 = var3.b(var6);
                  var4.a(var6, new bQ(var6.d(), var7));
                  var1.c(var6);
                  y.f.ae.a(var1.b(var6));
                  this.j.a(var6, true);
               }
            }

            var5.g();
            if(var8 == 0) {
               continue;
            }
         }

         this.p = var1.c(y.f.aF.a);
         this.q = var1.c(y.f.aF.b);
         this.r = var1.c(y.f.ax.a);
         this.s = var1.c(y.f.ax.b);
         this.n = var2;
         this.o = var3;
         var1.a((Object)y.f.aF.a, (y.c.c)(new bG(this)));
         var1.a((Object)y.f.aF.b, (y.c.c)(new bH(this)));
         var1.a((Object)y.f.ax.a, (y.c.c)(new bI(this)));
         var1.a((Object)y.f.ax.b, (y.c.c)(new bJ(this)));
         var1.a((Object)y.f.aF.c, (y.c.c)(new bK(this)));
         var1.a((Object)y.f.aF.d, (y.c.c)(new bL(this)));
         this.t = var1.c("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
         var10000 = this.t;
         break;
      }

      bF var12;
      label52: {
         if(var10000 != null) {
            y.c.h var9 = y.g.M.b();
            y.c.e var10 = var1.p();

            while(var10.f()) {
               y.c.d var11 = var10.a();
               var12 = this;
               if(var8 != 0) {
                  break label52;
               }

               if(this.t.b(var11) != null) {
                  label74: {
                     if(var4.b(var11) != null) {
                        if(this.j.d(var11)) {
                           var9.a(var11, new bP(this, (x)this.t.b(var11), var11, true));
                           if(var8 == 0) {
                              break label74;
                           }
                        }

                        var9.a(var11, new bP(this, (x)this.t.b(var11), var11, false));
                        if(var8 == 0) {
                           break label74;
                        }
                     }

                     var9.a(var11, this.t.b(var11));
                  }
               }

               var10.g();
               if(var8 != 0) {
                  break;
               }
            }

            var1.a((Object)"y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", (y.c.c)var9);
         }

         this.h = y.g.M.c();
         this.g = y.g.M.c();
         var12 = this;
      }

      var12.i = y.g.M.c();
   }

   private void e() {
      y.f.X var1;
      int var4;
      label77: {
         var4 = ab.a;
         var1 = this.a().a();
         if(this.p != null) {
            var1.a((Object)y.f.aF.a, (y.c.c)this.p);
            this.p = null;
            if(var4 == 0) {
               break label77;
            }
         }

         var1.d_(y.f.aF.a);
      }

      label72: {
         if(this.q != null) {
            var1.a((Object)y.f.aF.b, (y.c.c)this.q);
            this.q = null;
            if(var4 == 0) {
               break label72;
            }
         }

         var1.d_(y.f.aF.b);
      }

      label67: {
         if(this.r != null) {
            var1.a((Object)y.f.ax.a, (y.c.c)this.r);
            this.r = null;
            if(var4 == 0) {
               break label67;
            }
         }

         var1.d_(y.f.ax.a);
      }

      label62: {
         if(this.s != null) {
            var1.a((Object)y.f.ax.b, (y.c.c)this.s);
            this.s = null;
            if(var4 == 0) {
               break label62;
            }
         }

         var1.d_(y.f.ax.b);
      }

      label57: {
         if(this.n != null) {
            var1.a((Object)y.f.aF.c, (y.c.c)this.n);
            this.n = null;
            if(var4 == 0) {
               break label57;
            }
         }

         var1.d_(y.f.aF.c);
      }

      label52: {
         if(this.o != null) {
            var1.a((Object)y.f.aF.d, (y.c.c)this.o);
            this.o = null;
            if(var4 == 0) {
               break label52;
            }
         }

         var1.d_(y.f.aF.d);
      }

      label47: {
         if(this.t != null) {
            var1.a((Object)"y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY", (y.c.c)this.t);
            this.t = null;
            if(var4 == 0) {
               break label47;
            }
         }

         var1.d_("y.layout.router.polyline.EdgeRouter.EDGE_LAYOUT_DESCRIPTOR_DPKEY");
      }

      y.c.e var2 = var1.p();

      bF var10000;
      while(true) {
         if(var2.f()) {
            y.c.d var3 = var2.a();
            var10000 = this;
            if(var4 != 0) {
               break;
            }

            if(this.j.d(var3)) {
               var1.c(var3);
               y.f.ae.a(var1.b(var3));
            }

            var2.g();
            if(var4 == 0) {
               continue;
            }
         }

         var1.d_(y.a);
         this.h = null;
         this.g = null;
         this.i = null;
         var10000 = this;
         break;
      }

      var10000.j = null;
   }

   protected void a(aa var1) {
      int var10 = ab.a;
      super.a(var1);
      if(this.m) {
         this.d.clear();
         y.c.c var2 = this.a().a().c(y.a);
         if(var2 != null) {
            y.c.e var3 = var1.b();

            while(var3.f()) {
               y.c.d var4 = var3.a();
               boolean var5 = this.j.d(var4);
               Object var6 = var2.b(var4);
               if(var6 != null) {
                  x var7 = this.a().c().a(var4);
                  double var8 = var5?var7.b():var7.a();
                  if(!this.d.containsKey(var6) || ((Double)this.d.get(var6)).doubleValue() < var8) {
                     this.d.put(var6, new Double(var8));
                  }
               }

               var3.g();
               if(var10 != 0) {
                  break;
               }
            }
         }

      }
   }

   protected void b(aa var1) {
      super.b(var1);
      if(this.m) {
         y.f.X var2 = this.a().a();
         y.c.d var3 = var1.c();
         y.c.c var4 = var2.c(y.a);
         this.k = var4.b(var3);
         Object var5 = (List)this.g.b(this.k);
         if(this.k == null || this.l == null || !this.l.equals(this.k)) {
            this.f();
            if(var5 == null) {
               var5 = new y.c.D();
               this.g.a(this.k, var5);
            }
         }

         this.l = this.k;
         ((List)var5).add(var3);
      }
   }

   protected void c(aa var1) {
      int var8 = ab.a;
      super.c(var1);
      if(this.m) {
         List var2 = (List)this.g.b(this.k);
         if(var2 != null) {
            var2.remove(this.b().c());
         }

         U var3 = var1.a().a(this.b().c());
         if(var3 != null) {
            int var4 = 0;
            int var5 = var3.b();

            while(var4 < var5) {
               f var6 = var3.a(var4);
               List var7 = (List)this.h.b(var6);
               if(var7 != null) {
                  var7.remove(var3);
               }

               ++var4;
               if(var8 != 0) {
                  break;
               }
            }
         }

      }
   }

   private void f() {
      this.c.clear();
      this.b.clear();
      this.e.clear();
      this.f.clear();
   }

   protected void d(aa var1) {
      if(this.m) {
         this.g(var1);
         this.i.a(this.k, this.b);
      }
   }

   protected void e(aa var1) {
      if(this.m) {
         List var2 = this.f(var1);
         this.b(var2);
         this.c(var2);
         this.a(var1, var2);
      }
   }

   private List f(aa var1) {
      int var7 = ab.a;
      HashSet var2 = new HashSet();
      y.c.D var3 = new y.c.D();
      y.c.c var4 = this.a().a().c(y.a);
      y.c.e var5 = var1.b();

      while(var5.f()) {
         y.c.d var6 = var5.a();
         if(var4 != null && var4.b(var6) != null && var2.add(var4.b(var6))) {
            var3.add(var4.b(var6));
         }

         var5.g();
         if(var7 != 0) {
            break;
         }
      }

      return var3;
   }

   private void b(List var1) {
      int var11 = ab.a;
      Iterator var2 = var1.iterator();

      label29:
      while(true) {
         int var10000 = var2.hasNext();

         while(var10000 != 0) {
            List var3 = (List)this.g.b(var2.next());
            Iterator var4 = var3.iterator();

            while(true) {
               if(!var4.hasNext()) {
                  continue label29;
               }

               y.c.d var5 = (y.c.d)var4.next();
               U var6 = this.b().a().a(var5);
               if(this.f.containsKey(var6)) {
                  f var7 = (f)this.f.get(var6);
                  f var8 = (f)this.e.get(var7);
                  int var9 = var6.a(var7);
                  var6.a(var9, var8);
                  var10000 = var6.b();
                  if(var11 != 0) {
                     break;
                  }

                  if(var10000 > var9 + 1) {
                     f var10 = var6.a(var9 + 1);
                     var10.a(var8);
                     if(var11 != 0) {
                        return;
                     }
                  }
               }
            }
         }

         return;
      }
   }

   private void c(List var1) {
      int var7 = ab.a;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         List var3 = (List)this.i.b(var2.next());
         if(var3 != null && !var3.isEmpty()) {
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               f var5 = (f)var4.next();
               if(this.e.containsKey(var5)) {
                  f var6 = (f)this.e.get(var5);
                  var6.a(var5.c());
                  if(var7 != 0 || var7 != 0) {
                     return;
                  }
               }
            }
         }
      }

   }

   private void a(aa var1, List var2) {
      int var12 = ab.a;
      Iterator var3 = var2.iterator();

      label84:
      while(true) {
         Iterator var10000 = var3;

         label82:
         while(var10000.hasNext()) {
            List var4 = (List)this.g.b(var3.next());
            y.c.D var5 = new y.c.D();
            Iterator var6 = var4.iterator();

            while(var6.hasNext()) {
               y.c.d var7 = (y.c.d)var6.next();
               U var8 = var1.a().a(var7);
               if(var8 != null) {
                  var5.add(var8);
                  if(var12 != 0) {
                     continue label84;
                  }

                  if(var12 != 0) {
                     break;
                  }
               }
            }

            label80:
            do {
               while(true) {
                  if(var5.isEmpty()) {
                     continue label84;
                  }

                  f var13 = null;
                  y.c.D var14 = new y.c.D();
                  y.c.D var15 = new y.c.D();
                  var10000 = var5.iterator();
                  if(var12 != 0) {
                     continue label82;
                  }

                  Iterator var9 = var10000;

                  label75:
                  while(true) {
                     if(var9.hasNext()) {
                        U var10 = (U)var9.next();
                        f var11 = var10.a(0);
                        if(var13 == null) {
                           var13 = var11;
                           var15.add(var10);
                           var14.add(var1.i().a(var10));
                           if(var12 == 0) {
                              continue;
                           }
                        }

                        if(!var13.equals(var11)) {
                           continue;
                        }

                        var14.add(var1.i().a(var10));
                        var15.add(var10);
                        if(var12 != 0) {
                           break;
                        }

                        if(var12 == 0) {
                           continue;
                        }
                     }

                     if(var14.size() > 1) {
                        y.c.D var16 = new y.c.D();
                        var16.add(new bN(this, var14, 0));

                        while(!var16.isEmpty()) {
                           bN var17 = (bN)var16.remove(0);
                           y.c.D var18 = var17.a();
                           if(var18.size() > 0) {
                              var16.a(var18);
                              if(var12 != 0) {
                                 continue label80;
                              }

                              if(var12 != 0) {
                                 break label75;
                              }
                           }
                        }
                     }
                     break;
                  }

                  if(var5.size() == var15.size()) {
                     var5.clear();
                     if(var12 == 0) {
                        continue;
                     }
                  }

                  var5.removeAll(var15);
                  break;
               }
            } while(var12 == 0);

            return;
         }

         return;
      }
   }

   protected double a(f var1) {
      return !this.c.isEmpty() && !this.c.contains(var1)?(double)this.b().d().f().p():0.0D;
   }

   protected void a(List var1) {
      if(this.m) {
         var1.addAll(this.b);
      }

   }

   private void g(aa var1) {
      int var17 = ab.a;
      U var2 = var1.a().a(var1.c());
      if(var2 != null) {
         y.c.D var3 = new y.c.D();
         HashMap var4 = new HashMap();
         this.a(var1, var3, var4);
         this.b.clear();
         this.c.clear();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            f var6 = (f)var5.next();
            f var7 = (f)var4.get(var6);
            v var8 = this.a(var2, var6);
            P var9 = var8.i();
            if(var9.d(var7.c())) {
               this.c.add(var7);
               this.b.add(var7);
               if(var17 == 0) {
                  continue;
               }
            }

            f var10 = new f(var6);
            var10.a(var9);
            this.e.put(var10, var6);
            y.c.D var11 = new y.c.D();
            List var12 = (List)this.h.b(var7);
            Iterator var13 = var12.iterator();

            while(true) {
               if(var13.hasNext()) {
                  U var14 = (U)var13.next();
                  v var15 = this.a(var14, var6);
                  P var16 = var15.i();
                  if(!var9.c(var16)) {
                     continue;
                  }

                  var11.add(var14);
                  if(var17 != 0) {
                     break;
                  }

                  if(var17 == 0) {
                     continue;
                  }
               }

               this.h.a(var10, var11);
               break;
            }

            if(var11.size() > 0) {
               this.c.add(var10);
               this.b.add(var10);
               if(var17 != 0) {
                  break;
               }
            }
         }

      }
   }

   private v a(U var1, f var2) {
      w var3 = this.b().i().a(var1);
      v var4 = var3.a(var2);
      if(var4 != null) {
         return var4;
      } else {
         f var5 = (f)this.f.get(var1);
         return var3.a(var5);
      }
   }

   private void a(aa var1, y.c.D var2, HashMap var3) {
      int var10 = ab.a;
      U var4 = var1.a().a(var1.c());
      if(var4 != null) {
         int var5 = 0;
         int var6 = var4.b();

         while(var5 < var6) {
            f var7 = var4.a(var5);
            R var8 = var7.a();
            if((this.b.size() == 0 || this.c.contains(var7)) && !var1.b(var8) && !var1.d(var8)) {
               f var9 = this.e.containsKey(var7)?(f)this.e.get(var7):var7;
               if(var7 != var9) {
                  this.f.put(var4, var7);
               }

               var3.put(var9, var7);
               var2.add(var9);
            }

            ++var5;
            if(var10 != 0) {
               break;
            }
         }

      }
   }

   protected void a(U var1) {
      int var6 = ab.a;
      if(this.m) {
         int var2 = 0;
         int var3 = var1.b();

         while(var2 < var3) {
            f var4 = var1.a(var2);
            Object var5 = (List)this.h.b(var4);
            if(var5 == null) {
               var5 = new y.c.D();
               this.h.a(var4, var5);
            }

            ((List)var5).add(var1);
            ++var2;
            if(var6 != 0) {
               break;
            }
         }
      }

   }

   static y.c.h a(bF var0) {
      return var0.j;
   }

   static y.c.c b(bF var0) {
      return var0.q;
   }

   static y.c.c c(bF var0) {
      return var0.p;
   }

   static y.c.c d(bF var0) {
      return var0.s;
   }

   static y.c.c e(bF var0) {
      return var0.r;
   }

   static y.c.c f(bF var0) {
      return var0.o;
   }

   static y.c.c g(bF var0) {
      return var0.n;
   }

   static HashMap h(bF var0) {
      return var0.d;
   }
}
