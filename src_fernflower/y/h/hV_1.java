package y.h;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.h.aA;
import y.h.aB;
import y.h.bF;
import y.h.bI;
import y.h.bu;
import y.h.cF;
import y.h.eR;
import y.h.eU;
import y.h.fM;
import y.h.fN;
import y.h.fj;
import y.h.gZ;
import y.h.gu;
import y.h.gv;
import y.h.gw;
import y.h.gx;
import y.h.hW;
import y.h.hX;
import y.h.hZ;
import y.h.y;

class hV {
   private cF f;
   static final Object a = "STRAIGHT_LINE";
   static final Object b = "ORTHOGONAL";
   static final Object c = "PARAXIAL";
   static final Object d = "MARKED_INTER_EDGES";
   static final Object e = "ORTHOGONAL_INTER_EDGES";

   hV(cF var1) {
      this.f = var1;
   }

   void a(bu var1) {
      y.c.y var2 = new y.c.y();
      y.c.f var3 = new y.c.f();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();
      this.f.a(var1, (y.c.y)var2, (y.c.f)var3, var4, var5);
      if(var2.isEmpty() && var3.isEmpty()) {
         y.c.D var6 = new y.c.D();
         y.c.D var7 = new y.c.D();
         HashMap var8 = new HashMap();
         HashMap var9 = new HashMap();
         this.f.a(var1, (List)var6, (List)var7, var8, var9);
         this.f.b(var1, (List)var6, (List)var7, var8, var9);
         this.f.c(var1, (List)var6, (List)var7, var8, var9);
         if(!fj.z) {
            return;
         }
      }

      this.f.b(var1, (y.c.y)var2, (y.c.f)var3, var4, var5);
      this.f.c(var1, (y.c.y)var2, (y.c.f)var3, var4, var5);
   }

   void a(bu var1, y.c.y var2, y.c.f var3, Map var4, Map var5) {
      boolean var11 = fj.z;
      y.c.y var6 = this.f.a(var1);
      if(!var6.isEmpty()) {
         y.c.y var9;
         label30: {
            y.c.A var7 = var1.t();
            y.c.y[] var8 = y.a.b.a(var1, var6, false, var7, 2);
            if(var8.length > 1) {
               var9 = var8[1];
               if(!var11) {
                  break label30;
               }
            }

            var9 = new y.c.y();
         }

         this.a(var1, var6, var9, new y.c.f(var1.p()), false, var2, var3, var4, var5);
         if(!var11) {
            return;
         }
      }

      y.c.y var12 = new y.c.y();
      y.c.f var13 = this.f.b(var1);
      y.c.e var14 = var13.a();

      while(var14.f()) {
         y.c.d var10 = var14.a();
         var12.add(var10.c());
         var12.add(var10.d());
         var14.g();
         if(var11) {
            return;
         }

         if(var11) {
            break;
         }
      }

      this.a(var1, new y.c.y(), var12, var13, true, new y.c.y(), var3, var4, var5);
   }

   y.c.y b(bu var1) {
      boolean var5 = fj.z;
      y.c.y var2 = new y.c.y();
      y.c.x var3 = var1.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         if(var1.v(var4)) {
            var2.add(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   y.c.f c(bu var1) {
      boolean var5 = fj.z;
      y.c.f var2 = new y.c.f();
      y.c.e var3 = var1.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(var1.r(var4)) {
            var2.add(var4);
         }

         var3.g();
         if(var5) {
            break;
         }
      }

      return var2;
   }

   void b(bu var1, y.c.y var2, y.c.f var3, Map var4, Map var5) {
      if(var2.isEmpty()) {
         this.a(var1, var3, var5, 20.0D, 20.0D);
         if(!fj.z) {
            return;
         }
      }

      this.a(var1, var2, var3, var5);
      a(var1, var2);
      var1.d_(d);
   }

   void a(bu var1, y.c.y var2, y.c.f var3, Map var4) {
      boolean var11 = fj.z;
      HashSet var5 = new HashSet(var2);
      y.c.h var6 = y.g.M.b();
      y.c.f var7 = new y.c.f();
      y.c.e var8 = var3.a();

      boolean var10000;
      while(true) {
         if(var8.f()) {
            y.c.d var9 = var8.a();
            var10000 = var5.contains(var9.c());
            if(var11) {
               break;
            }

            if(var10000 && !var5.contains(var9.d()) || !var5.contains(var9.c()) && var5.contains(var9.d())) {
               Object var10 = a(var1, (y.c.d)var4.get(var9));
               var6.a(var9, var10);
               if(var10 == c) {
                  var7.add(var9);
               }
            }

            var8.g();
            if(!var11) {
               continue;
            }
         }

         var10000 = var7.isEmpty();
         break;
      }

      if(!var10000) {
         boolean var12 = y.f.ae.b(var1, (y.c.c)(new hW(this, var5)));
         Object var13 = var12?b:a;
         y.c.e var14 = var7.a();

         while(var14.f()) {
            var6.a(var14.a(), var13);
            var14.g();
            if(var11) {
               return;
            }

            if(var11) {
               break;
            }
         }
      }

      var1.a((Object)d, (y.c.c)var6);
   }

   static Object a(bu var0, y.c.d var1) {
      boolean var8 = fj.z;
      byte var2 = 0;
      boolean var3 = false;
      y.d.s var4 = var0.l(var1).j();

      while(true) {
         int var10000;
         if(var4.f()) {
            y.d.m var5 = var4.a();
            y.d.t var6 = var5.c();
            y.d.t var7 = var5.d();
            double var9;
            var10000 = (var9 = Math.abs(var6.a() - var7.a()) - 1.0E-12D) == 0.0D?0:(var9 < 0.0D?-1:1);
            if(var8) {
               return var10000 != 0 && var3?b:c;
            }

            label46: {
               if(var10000 < 0) {
                  var3 = true;
                  if(!var8) {
                     break label46;
                  }
               }

               if(Math.abs(var6.b() - var7.b()) >= 1.0E-12D) {
                  break;
               }

               var2 = 1;
               if(var8) {
                  break;
               }
            }

            var4.g();
            if(!var8) {
               continue;
            }
         }

         var10000 = var2;
         return var10000 != 0 && var3?b:c;
      }

      return a;
   }

   void a(bu var1, y.c.y var2, y.c.f var3) {
      var1.N();
      if(var2.isEmpty()) {
         if(var3.isEmpty()) {
            return;
         }

         var1.a(var3.a(), true);
         if(!fj.z) {
            return;
         }
      }

      var1.a(var2.a(), true);
   }

   private void a(bu var1, y.c.y var2, y.c.y var3, y.c.f var4, boolean var5, y.c.y var6, y.c.f var7, Map var8, Map var9) {
      boolean var29 = fj.z;
      HashSet var10 = new HashSet(var2);
      y.c.y var11 = new y.c.y(var2);
      var11.addAll(var3);
      HashMap var12 = new HashMap();
      y.c.f var13 = new y.c.f();
      y.g.C var14 = var1.a_();
      hZ var30 = new hZ(var14, var13, var8, var12, var9);
      bF var15 = new bF(var30);
      y.g.B var16 = new y.g.B();
      var16.a((y.g.C)var15);
      var15.a(var16);
      y.c.y var17 = var16.a(var1, var11.a(), var4.a(), var1);
      y.c.x var18 = var17.a();

      label73:
      while(true) {
         boolean var10000 = var18.f();

         label70:
         while(var10000) {
            y.c.q var19 = var18.e();
            y.c.q var20 = (y.c.q)var8.get(var19);
            var10000 = var10.contains(var20);
            if(var29) {
               return;
            }

            label67: {
               y.c.q var23;
               if(!var10000) {
                  y.c.q var21 = (y.c.q)var8.get(var19);
                  y.c.e var22 = (new y.c.f(var19.j())).a();

                  while(var22.f()) {
                     var23 = var22.a().a(var19);
                     y.c.q var24 = (y.c.q)var8.get(var23);
                     var10000 = var5;
                     if(var29) {
                        continue label70;
                     }

                     if(var5 || var10.contains(var24)) {
                        label83: {
                           y.c.d var25 = var22.a();
                           y.h.a.v var26;
                           y.c.q var27;
                           y.c.q var28;
                           if(var25.c() == var23) {
                              var1.a(var25, var23, var21);
                              var26 = var1.C();
                              if(var26 == null || !var1.C().e(var25)) {
                                 break label83;
                              }

                              var27 = var26.c(var25);
                              var28 = var26.b(var25);
                              var26.a(var25);
                              var26.b(var25, var28, (y.c.q)var8.get(var27));
                              if(!var29) {
                                 break label83;
                              }
                           }

                           var1.a(var25, var21, var23);
                           var26 = var1.C();
                           if(var26 != null && var1.C().e(var25)) {
                              var27 = var26.c(var25);
                              var28 = var26.b(var25);
                              var26.a(var25);
                              var26.b(var25, (y.c.q)var8.get(var28), var27);
                           }
                        }
                     }

                     var22.g();
                     if(var29) {
                        break;
                     }
                  }

                  var19.e().a(var19);
                  if(!var29) {
                     break label67;
                  }
               }

               var6.add(var19);
               y.h.a.v var31 = var1.C();
               if(var31 != null) {
                  label42: {
                     y.c.q var32 = var31.n(var20);
                     if(var10.contains(var32)) {
                        var23 = (y.c.q)var12.get(var32);
                        var31.c(var19, var23);
                        if(!var29) {
                           break label42;
                        }
                     }

                     var31.c(var19, var32);
                  }
               }
            }

            var18.g();
            if(!var29) {
               continue label73;
            }
            break;
         }

         var7.addAll(var13);
         return;
      }
   }

   void a(bu var1, y.c.f var2, Map var3, double var4, double var6) {
      boolean var14 = fj.z;
      y.c.h var8 = y.g.M.b();
      y.c.e var9 = var2.a();

      while(true) {
         if(var9.f()) {
            y.c.d var10 = var9.a();
            if(var14) {
               break;
            }

            label75: {
               if(var10.e() && var1.i(var10).bendCount() <= 1) {
                  aB var11 = var1.i(var10);
                  fj var12 = var11.getSourceRealizer();
                  if(var1.i(var10).bendCount() == 0) {
                     var11.appendBend(var11.getSourcePort().a(var12), var11.getSourcePort().b(var12) - 20.0D - var12.getHeight());
                  }

                  this.a(var1, var4, var6, var10, true, false, false, var10.c());
                  if(!var14) {
                     break label75;
                  }
               }

               var8.a(var10, true);
               var8.a(var3.get(var10), true);
            }

            var9.g();
            if(!var14) {
               continue;
            }
         }

         var1.a((Object)y.f.as.a, (y.c.c)var8);
         break;
      }

      y.f.as var17 = new y.f.as();
      var17.a(5.0D);
      var17.b(false);
      var17.a(true);

      try {
         bI var18 = new bI((byte)1);
         var18.a(false);
         var18.b(true);
         var18.d().a(true);
         var18.a((bu)var1, (y.f.ah)var17);
      } finally {
         var1.d_(y.f.as.a);
      }

   }

   static void a(bu var0, y.c.y var1) {
      boolean var8 = fj.z;
      y.c.A var2 = var0.t();
      y.c.x var3 = var1.a();

      while(true) {
         if(var3.f()) {
            y.c.q var4 = var3.e();
            var2.a(var4, true);
            var3.g();
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         var0.a((Object)y.f.g.d.a, (y.c.c)var2);
         break;
      }

      y.f.g.d var12;
      label68: {
         boolean var11 = var0.c(d) != null;
         var12 = new y.f.g.d();
         var12.b((byte)3);
         var12.a((byte)2);
         if(var11) {
            y.f.i.v var5 = new y.f.i.v();
            var5.b((byte)2);
            var5.a(e);
            var5.f(true);
            var5.d(4);
            var5.e(false);
            var5.c((int)5);
            var5.c(true);
            var5.a((byte)1);
            var5.b(true);
            var5.c((byte)1);
            var5.a((String)"routingPreferMiddleOfNode", (Object)Boolean.TRUE);
            y.f.i.i var6 = new y.f.i.i(new y.f.i.n(new y.f.i.ab(new y.f.i.X(var5))));
            var12.b((y.f.ah)(new hX(var6)));
            if(!var8) {
               break label68;
            }
         }

         var12.c((byte)2);
      }

      var12.d((byte)5);
      var12.a(true);
      var12.b(false);

      try {
         bI var13 = new bI((byte)1);
         var13.a(false);
         var13.b(true);
         var13.d().a(true);
         var13.a((bu)var0, (y.f.ah)var12);
      } finally {
         var0.d_(y.f.g.d.a);
         var0.a((y.c.A)var2);
      }

   }

   void a(bu var1, double var2, double var4, y.c.d var6, boolean var7, boolean var8, boolean var9, y.c.q var10) {
      boolean var14 = fj.z;
      aB var11 = var1.i(var6);
      if(var11.bendCount() > 0) {
         int var12 = 0;
         y var13 = var11.bends();

         while(var13.f()) {
            label67: {
               if(var6.c() == var10 && var12 == 0 && (var8 || var9)) {
                  if(var8) {
                     var13.a().b(0.0D, var4);
                     if(!var14) {
                        break label67;
                     }
                  }

                  if(!var9) {
                     break label67;
                  }

                  var13.a().b(var2, 0.0D);
                  if(!var14) {
                     break label67;
                  }
               }

               if(var6.d() == var10 && var12 == var11.bendCount() - 1 && (var8 || var9)) {
                  if(var8) {
                     var13.a().b(0.0D, var4);
                     if(!var14) {
                        break label67;
                     }
                  }

                  if(!var9) {
                     break label67;
                  }

                  var13.a().b(var2, 0.0D);
                  if(!var14) {
                     break label67;
                  }
               }

               var13.a().b(var2, var4);
            }

            if(var7) {
               var13.a().a(true);
            }

            var13.g();
            ++var12;
            if(var14) {
               break;
            }
         }
      }

   }

   void a(bu var1, List var2, List var3, Map var4, Map var5) {
      boolean var13 = fj.z;
      List var6 = this.f.c(var1);
      if(!var6.isEmpty()) {
         HashSet var7 = new HashSet();
         y.c.y var8 = new y.c.y();
         Iterator var9 = var6.iterator();

         label62: {
            while(var9.hasNext()) {
               y.c.q var10 = ((eR)var9.next()).f();
               if(var7.add(var10)) {
                  var8.add(var10);
                  if(var13) {
                     break label62;
                  }

                  if(var13) {
                     break;
                  }
               }
            }

            var1.a(var8.a());
         }

         var9 = var6.iterator();

         do {
            if(!var9.hasNext()) {
               return;
            }

            eR var17 = (eR)var9.next();
            eR var11 = (eR)var17.clone();
            var17.g().addLabel(var11);
            var2.add(var11);
            var4.put(var11, var17);
         } while(!var13);
      }

      List var14 = this.f.d(var1);
      if(!var14.isEmpty()) {
         HashSet var15 = new HashSet();
         y.c.f var16 = new y.c.f();
         Iterator var18 = var14.iterator();

         label41: {
            while(var18.hasNext()) {
               y.c.d var19 = ((aA)var18.next()).getEdge();
               if(!var15.contains(var19)) {
                  var15.add(var19);
                  var16.add(var19);
                  if(var13) {
                     break label41;
                  }

                  if(var13) {
                     break;
                  }
               }
            }

            var1.a(var16.a());
         }

         var18 = var14.iterator();

         while(var18.hasNext()) {
            aA var20 = (aA)var18.next();
            aA var12 = (aA)var20.clone();
            var20.getRealizer().addLabel(var12);
            var3.add(var12);
            var5.put(var12, var20);
            if(var13) {
               break;
            }
         }
      }

   }

   List d(bu var1) {
      boolean var8 = fj.z;
      y.c.D var2 = new y.c.D();
      y.c.x var3 = var1.o();

      do {
         boolean var10000 = var3.f();

         label29:
         while(true) {
            if(!var10000) {
               return var2;
            }

            y.c.q var4 = var3.e();
            fj var5 = var1.t(var4);
            int var6 = 0;

            while(true) {
               if(var6 >= var5.labelCount()) {
                  break label29;
               }

               eR var7 = var5.getLabel(var6);
               var10000 = var1.a((gZ)var7);
               if(var8) {
                  break;
               }

               if(var10000) {
                  var2.add(var7);
               }

               ++var6;
               if(var8) {
                  break label29;
               }
            }
         }

         var3.g();
      } while(!var8);

      return var2;
   }

   List e(bu var1) {
      boolean var8 = fj.z;
      y.c.D var2 = new y.c.D();
      y.c.e var3 = var1.p();

      do {
         boolean var10000 = var3.f();

         label29:
         while(true) {
            if(!var10000) {
               return var2;
            }

            y.c.d var4 = var3.a();
            aB var5 = var1.i(var4);
            int var6 = 0;

            while(true) {
               if(var6 >= var5.labelCount()) {
                  break label29;
               }

               aA var7 = var5.getLabel(var6);
               var10000 = var1.a((gZ)var7);
               if(var8) {
                  break;
               }

               if(var10000) {
                  var2.add(var7);
               }

               ++var6;
               if(var8) {
                  break label29;
               }
            }
         }

         var3.g();
      } while(!var8);

      return var2;
   }

   void a(List var1, List var2) {
      boolean var9 = fj.z;
      Iterator var3 = var1.iterator();

      while(true) {
         y.c.D var6;
         int var8;
         boolean var10000;
         if(var3.hasNext()) {
            eR var4 = (eR)var3.next();
            y.f.al var5 = var4.a();
            var6 = new y.c.D();
            fj var7 = var4.g();
            var10000 = false;
            if(!var9) {
               var8 = 0;

               label60: {
                  while(var8 < var7.labelCount()) {
                     var6.add(var7.getLabel(var8).getOrientedBox());
                     ++var8;
                     if(var9) {
                        break label60;
                     }

                     if(var9) {
                        break;
                     }
                  }

                  if(var5 instanceof y.f.A) {
                     a(var4, var6);
                     if(!var9) {
                        continue;
                     }
                  }
               }

               if(var5 instanceof gw) {
                  c(var4, var6);
                  if(!var9) {
                     continue;
                  }
               }

               if(var5 instanceof fM) {
                  b(var4, var6);
                  if(!var9) {
                     continue;
                  }
               }

               if(var5 instanceof y.h.b.h) {
                  d(var4, var6);
                  if(!var9) {
                     continue;
                  }
               }

               e(var4, var6);
               if(!var9) {
                  continue;
               }

               var3 = var2.iterator();
               var10000 = var3.hasNext();
            }
         } else {
            var3 = var2.iterator();
            var10000 = var3.hasNext();
         }

         while(true) {
            label91:
            while(var10000) {
               aA var10 = (aA)var3.next();
               y.f.E var11 = var10.getLabelModel();
               var6 = new y.c.D();
               aB var12 = var10.getRealizer();
               var8 = 0;

               while(true) {
                  if(var8 < var12.labelCount()) {
                     var6.add(var12.getLabel(var8).getOrientedBox());
                     ++var8;
                     if(var9) {
                        break;
                     }

                     if(!var9) {
                        continue;
                     }
                  }

                  if(var11 instanceof y.f.K) {
                     a(var10, var6);
                     if(!var9) {
                        var10000 = var3.hasNext();
                        continue label91;
                     }
                  }
                  break;
               }

               if(var11 instanceof gu) {
                  b(var10, var6);
                  if(var9) {
                     c(var10, var6);
                     if(var9) {
                        return;
                     }
                  }
               } else {
                  c(var10, var6);
                  if(var9) {
                     return;
                  }
               }

               var10000 = var3.hasNext();
            }

            return;
         }
      }
   }

   void a(bu var1, List var2, List var3) {
      boolean var5 = fj.z;
      var1.N();
      Iterator var4 = var2.iterator();

      while(true) {
         if(var4.hasNext()) {
            var1.a((gZ)var4.next(), true);
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         var4 = var3.iterator();
         break;
      }

      while(var4.hasNext()) {
         var1.a((gZ)var4.next(), true);
         if(var5) {
            break;
         }
      }

   }

   private static void a(eR var0, y.c.D var1) {
      boolean var9 = fj.z;
      fj var2 = var0.g();
      y.f.A var3 = (y.f.A)var0.a();
      HashSet var4 = new HashSet(17);
      int var5 = 0;

      while(var5 < var2.labelCount()) {
         eR var6 = var2.getLabel(var5);
         if(var6.getModelParameter() instanceof Integer) {
            var4.add(var6.getModelParameter());
         }

         ++var5;
         if(var9) {
            break;
         }
      }

      y.c.D var10 = var3.a((y.f.aj)var0, var2);
      y.c.C var11 = var10.m();

      while(var11.f()) {
         y.f.Q var7 = (y.f.Q)var11.d();
         Object var8 = var7.b();
         if(!var4.contains(var8) && b(var7.d(), var1)) {
            var0.setModelParameter(var8);
            return;
         }

         var11.g();
         if(var9) {
            break;
         }
      }

   }

   private static void b(eR var0, y.c.D var1) {
      boolean var10 = fj.z;
      fj var2 = var0.g();
      fM var3 = (fM)var0.a();
      boolean[] var4 = new boolean[5];
      eU var5 = fM.a(var0);
      int var6 = 0;

      while(var6 < var2.labelCount()) {
         eR var7 = var2.getLabel(var6);
         if(var5 == fM.a(var7) && var7.getModelParameter() instanceof fN) {
            var4[fM.b(var7.getModelParameter())] = true;
         }

         ++var6;
         if(var10) {
            break;
         }
      }

      y.c.D var11 = var3.a((y.f.aj)var0, (y.f.am)var2);
      y.c.C var12 = var11.m();

      while(var12.f()) {
         y.f.Q var8 = (y.f.Q)var12.d();
         Object var9 = var8.b();
         if(!var4[fM.b(var9)] && b(var8.d(), var1)) {
            var0.setModelParameter(var9);
            return;
         }

         var12.g();
         if(var10) {
            break;
         }
      }

   }

   private static void c(eR var0, y.c.D var1) {
      boolean var7 = fj.z;
      gx var2 = (gx)var0.getModelParameter();
      y.d.n var3 = new y.d.n(var0.getOrientedBox());

      while(!a(var3, var1)) {
         var3.e(var3.k().a(), var3.k().b() + var3.f() + 5.0D);
         gx var4 = (gx)var0.getBestModelParameterForBounds(var3);
         gx var5 = (gx)var0.getModelParameter();
         var0.setModelParameter(var4);
         Object var6;
         if(var5.e() != 0.0D) {
            var6 = ((gw)var0.a()).a(var2.a(), var4.b(), var2.c(), var4.d(), var2.e(), var4.f(), var4.g(), var4.h());
            var0.setModelParameter(var6);
            var4 = (gx)var6;
         }

         if(var5.f() != 0.0D) {
            var6 = ((gw)var0.a()).a(var4.a(), var2.b(), var4.c(), var2.d(), var4.e(), var2.f() + var3.f() + 5.0D, var4.g(), var4.h());
            var0.setModelParameter(var6);
            var4 = (gx)var6;
         }

         var2 = var4;
         if(var7) {
            break;
         }
      }

   }

   private static void d(eR var0, y.c.D var1) {
      boolean var3 = fj.z;
      y.d.n var2 = new y.d.n(var0.getOrientedBox());

      while(!a(var2, var1)) {
         var2.e(var2.k().a() + var2.e() + 5.0D, var2.k().b());
         var0.setModelParameter(var0.getBestModelParameterForBounds(var2));
         if(var3) {
            break;
         }
      }

   }

   private static void e(eR var0, y.c.D var1) {
      boolean var3 = fj.z;
      y.d.n var2 = new y.d.n(var0.getOrientedBox());

      while(!a(var2, var1)) {
         var2.e(var2.k().a(), var2.k().b() + var2.f() + 5.0D);
         var0.setModelParameter(var0.getBestModelParameterForBounds(var2));
         if(var3) {
            break;
         }
      }

   }

   private static void a(aA var0, y.c.D var1) {
      boolean var3 = fj.z;
      y.d.n var2 = new y.d.n(var0.getOrientedBox());

      while(!a(var2, var1)) {
         var2.e(var2.k().a(), var2.k().b() + var2.f() + 5.0D);
         var0.setModelParameter(var0.getBestModelParameterForBounds(var2));
         if(var3) {
            break;
         }
      }

   }

   private static void b(aA var0, y.c.D var1) {
      boolean var15 = fj.z;
      aB var2 = var0.getRealizer();
      gu var3 = (gu)var0.getLabelModel();
      gv var4 = (gv)var0.getModelParameter();
      int var5 = var2.pointCount() + 1;
      gv var6 = var4;
      boolean var8 = false;
      boolean var9 = true;

      while(!var8) {
         double var10;
         int var12;
         label54: {
            int var13 = var6.a();
            aA var14;
            if(var9) {
               if(var6.b() + 0.1D > b(var0)) {
                  var12 = var13 + 1;
                  if(var12 < var5 && var12 != 0) {
                     var14 = (aA)var0.clone();
                     var14.setLabelModel(new gu(), new gv(var12, var6.b(), var6.c(), var6.d(), var6.e(), var6.f()));
                     var2.addLabel(var14);
                     var10 = a(var14);
                     var2.removeLabel(var14);
                     if(!var15) {
                        break label54;
                     }
                  }

                  var10 = var4.b();
                  var12 = var4.a();
                  var9 = false;
                  if(!var15) {
                     break label54;
                  }
               }

               var12 = var13;
               var10 = var6.b() + 0.1D;
               if(!var15) {
                  break label54;
               }
            }

            if(var6.b() - 0.1D < a(var0)) {
               var12 = var13 - 1;
               if(var12 >= -var5 && var12 != -1) {
                  var14 = (aA)var0.clone();
                  var14.setLabelModel(new gu(), new gv(var12, var6.b(), var6.c(), var6.d(), var6.e(), var6.f()));
                  var2.addLabel(var14);
                  var10 = b(var14);
                  var2.removeLabel(var14);
                  if(!var15) {
                     break label54;
                  }
               }

               var10 = var4.b();
               var12 = var4.a();
               var8 = true;
               if(!var15) {
                  break label54;
               }
            }

            var12 = var13;
            var10 = var6.b() - 0.1D;
         }

         gv var7 = new gv(var12, var10, var6.c(), var6.d(), var6.e(), var6.f());
         y.d.n var16 = var3.a(var0.getOrientedBox().d(), var2, var2.getSourceRealizer(), var2.getTargetRealizer(), var7);
         var0.setModelParameter(var7);
         if(a(var16, var1)) {
            var8 = true;
         }

         var6 = var7;
         if(var15) {
            break;
         }
      }

   }

   private static void c(aA var0, y.c.D var1) {
      boolean var14 = fj.z;
      aB var2 = var0.getRealizer();
      y.f.E var3 = var0.getLabelModel();
      y.d.t var4 = var0.getOrientedBox().k();
      double var5 = Double.MAX_VALUE;
      y.f.Q var7 = null;
      y.c.D var8 = var3.a((y.f.C)var0, var2, var2.getSourceRealizer(), var2.getTargetRealizer());
      y.c.C var9 = var8.m();

      while(true) {
         if(var9.f()) {
            y.f.Q var10 = (y.f.Q)var9.d();
            y.d.n var11 = var10.d();
            if(var14) {
               break;
            }

            if(a(var11, var1)) {
               double var12 = y.d.t.a(var4, var10.d().k());
               if(var12 < var5) {
                  var5 = var12;
                  var7 = var10;
               }
            }

            var9.g();
            if(!var14) {
               continue;
            }
         }

         if(var7 != null) {
            var0.setModelParameter(var7.b());
         }
         break;
      }

   }

   private static double a(aA var0) {
      boolean var12 = fj.z;
      double var1 = 1.0D;
      y.d.v var3 = var0.getGraph2D().l(var0.getEdge());
      gv var4 = (gv)var0.getModelParameter();
      int var5 = var4.a();
      var5 = var5 < 0?var3.h() - 1 + var5:var5;
      y.f.E var6 = var0.getLabelModel();
      aB var7 = var0.getRealizer();
      y.c.D var8 = var6.a((y.f.C)var0, var7, var7.getSourceRealizer(), var7.getTargetRealizer());
      y.c.C var9 = var8.m();

      while(var9.f()) {
         gv var10 = (gv)((y.f.Q)var9.d()).b();
         int var11 = var10.a() < 0?var3.h() - 1 + var10.a():var10.a();
         if(var11 == var5 && var10.e() == var4.e()) {
            var1 = Math.min(var1, var10.b());
         }

         var9.g();
         if(var12) {
            break;
         }
      }

      return Math.max(var1, 0.0D);
   }

   private static double b(aA var0) {
      boolean var12 = fj.z;
      double var1 = 0.0D;
      y.d.v var3 = var0.getGraph2D().l(var0.getEdge());
      y.f.E var4 = var0.getLabelModel();
      gv var5 = (gv)var0.getModelParameter();
      int var6 = var5.a();
      var6 = var6 < 0?var3.h() - 1 + var6:var6;
      aB var7 = var0.getRealizer();
      y.c.D var8 = var4.a((y.f.C)var0, var7, var7.getSourceRealizer(), var7.getTargetRealizer());
      y.c.C var9 = var8.m();

      while(var9.f()) {
         gv var10 = (gv)((y.f.Q)var9.d()).b();
         int var11 = var10.a() < 0?var3.h() - 1 + var10.a():var10.a();
         if(var11 == var6 && var10.e() == var5.e()) {
            var1 = Math.max(var1, var10.b());
         }

         var9.g();
         if(var12) {
            break;
         }
      }

      return Math.min(var1, 1.0D);
   }

   private static boolean a(y.d.n var0, y.c.D var1) {
      boolean var4 = fj.z;
      boolean var2 = true;
      y.c.C var3 = var1.m();

      boolean var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            if(var2) {
               var2 = !a(var0, (y.d.n)var3.d(), 0.0D);
               var3.g();
               if(!var4) {
                  continue;
               }
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private static boolean b(y.d.n var0, y.c.D var1) {
      boolean var4 = fj.z;
      boolean var2 = true;
      y.c.C var3 = var1.m();

      boolean var10000;
      while(true) {
         if(var3.f()) {
            var10000 = var2;
            if(var4) {
               break;
            }

            if(var2) {
               var2 = !y.d.n.a((y.d.n)var3.d(), var0, 0.0D);
               var3.g();
               if(!var4) {
                  continue;
               }
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private static boolean a(y.d.n var0, y.d.n var1, double var2) {
      y.d.t[] var4 = y.d.n.a(var1);
      return y.d.n.a(var0, new y.d.m(var4[0], var4[1]), var2) || y.d.n.a(var0, new y.d.m(var4[1], var4[2]), var2) || y.d.n.a(var0, new y.d.m(var4[2], var4[3]), var2) || y.d.n.a(var0, new y.d.m(var4[3], var4[0]), var2);
   }
}
