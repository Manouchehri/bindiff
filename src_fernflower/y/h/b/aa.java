package y.h.b;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.gd;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.f;
import y.h.b.g;
import y.h.b.i;

public class aa {
   private boolean a = true;

   private bu a(a var1) {
      y.c.q var2 = var1.getNode();
      return var2 == null?null:(bu)var2.e();
   }

   private boolean b(a var1) {
      y.h.a.a var2 = var1.getAutoBoundsFeature();
      return var2 != null && var2.isAutoBoundsEnabled();
   }

   private void a(a var1, boolean var2) {
      y.h.a.a var3 = var1.getAutoBoundsFeature();
      if(var3 != null) {
         var3.setAutoBoundsEnabled(var2);
      }

   }

   public void a(bu var1, y.c.y var2, y.h.z var3, double var4, double var6) {
      int var10 = a.H;
      if(!var2.isEmpty()) {
         y.c.x var8 = var2.a();

         while(var8.f()) {
            var1.t(var8.e()).moveBy(var4, var6);
            var8.g();
            if(var10 != 0) {
               return;
            }

            if(var10 != 0) {
               break;
            }
         }
      }

      if(!var3.isEmpty()) {
         y.h.y var11 = var3.b();

         while(var11.f()) {
            y.h.x var9 = var11.a();
            var9.a(var9.b() + var4, var9.c() + var6);
            var11.g();
            if(var10 != 0) {
               break;
            }
         }
      }

   }

   public void a(y.c.q var1, Rectangle2D var2, Collection var3) {
      bu var4 = var1 == null?null:(bu)var1.e();
      y.h.a.v var5 = var4 == null?null:y.h.a.v.a((y.c.i)var4);
      if(var5 != null && var2 != null && var3 != null) {
         this.a(var5, var1, var2, var3);
      }

   }

   public void a(bu var1, Rectangle2D var2, Collection var3) {
      int var8 = a.H;
      if(var1 != null && var2 != null && var3 != null) {
         y.c.e var4 = var1.p();

         do {
            boolean var10000 = var4.f();

            label33:
            while(true) {
               if(!var10000) {
                  return;
               }

               y.c.d var5 = var4.a();
               y.h.y var6 = var1.i(var5).bends();

               while(true) {
                  if(!var6.f()) {
                     break label33;
                  }

                  y.h.x var7 = var6.a();
                  var10000 = var2.contains(var7.b(), var7.c());
                  if(var8 != 0) {
                     break;
                  }

                  if(var10000) {
                     var3.add(var7);
                  }

                  var6.g();
                  if(var8 != 0) {
                     break label33;
                  }
               }
            }

            var4.g();
         } while(var8 == 0);
      }

   }

   private void a(y.c.q var1, Rectangle2D var2, Collection var3, Collection var4) {
      int var11 = a.H;
      this.a(var1, var2, var3);
      bu var5 = var1 == null?null:(bu)var1.e();
      if(this.a()) {
         this.a(var5, var2, var4);
         if(var11 == 0) {
            return;
         }
      }

      if(var5 != null && var2 != null && var3 != null && var4 != null) {
         HashSet var6 = new HashSet(var3);
         y.c.e var7 = var5.p();

         do {
            boolean var10000 = var7.f();

            label46:
            while(true) {
               if(!var10000) {
                  return;
               }

               y.c.d var8 = var7.a();
               if(!var6.contains(var8.c()) || !var6.contains(var8.d())) {
                  break;
               }

               y.h.y var9 = var5.i(var8).bends();

               while(true) {
                  if(!var9.f()) {
                     break label46;
                  }

                  y.h.x var10 = var9.a();
                  var10000 = var2.contains(var10.b(), var10.c());
                  if(var11 != 0) {
                     break;
                  }

                  if(var10000) {
                     var4.add(var10);
                  }

                  var9.g();
                  if(var11 != 0) {
                     break label46;
                  }
               }
            }

            var7.g();
         } while(var11 == 0);
      }

   }

   private void a(y.h.a.v var1, y.c.q var2, Rectangle2D var3, Collection var4) {
      int var11 = a.H;
      bu var5 = (bu)var2.e();
      y.c.x var6 = var1.p(var2);

      while(var6.f()) {
         label53: {
            y.c.q var7 = var6.e();
            if(var1.k(var7)) {
               y.c.x var8 = var1.p(var7);
               if(var8.f()) {
                  LinkedHashSet var9 = new LinkedHashSet();
                  this.a((y.h.a.v)var1, (y.c.q)var7, (Rectangle2D)var3, var9);
                  boolean var10 = true;

                  boolean var10000;
                  while(true) {
                     if(var8.f()) {
                        label63: {
                           var10000 = var9.contains(var6.e());
                           if(var11 != 0) {
                              break;
                           }

                           if(!var10000) {
                              var10 = false;
                              if(var11 == 0) {
                                 break label63;
                              }
                           }

                           var8.g();
                           if(var11 == 0) {
                              continue;
                           }
                        }
                     }

                     var10000 = var10;
                     break;
                  }

                  if(var10000) {
                     var4.add(var7);
                  }

                  var4.addAll(var9);
                  if(var11 == 0) {
                     break label53;
                  }
               }

               fj var13 = var5.t(var7);
               if(!var3.contains(var13.getCenterX(), var13.getCenterY())) {
                  break label53;
               }

               var4.add(var7);
               if(var11 == 0) {
                  break label53;
               }
            }

            fj var12 = var5.t(var7);
            if(var3.contains(var12.getCenterX(), var12.getCenterY())) {
               var4.add(var7);
            }
         }

         var6.g();
         if(var11 != 0) {
            break;
         }
      }

   }

   public void a(c var1, d var2) {
      a var3 = a.a(var1);
      bu var4 = this.a(var3);
      if(var4 == null) {
         boolean var5 = this.b(var3);
         if(var5) {
            this.a(var3, false);
         }

         try {
            var1.a(var2);
         } finally {
            if(var5) {
               this.a(var3, true);
            }

         }
      } else {
         var4.r();

         try {
            y.c.q var16 = var3.getNode();
            var4.a((new y.c.y(var16)).a());
            fj var6 = a(var4, var16);
            if(var6 == var3) {
               this.a(var3, var1, var2);
               if(a.H == 0) {
                  return;
               }
            }

            if(var6 instanceof a) {
               a var7 = (a)var6;
               ArrayList var8 = new ArrayList();
               this.a(var7, a((c)var1, (a)var7, (List)var8), a((d)var2, (a)var7, (List)var8));
            }
         } finally {
            var4.s();
         }
      }

   }

   private void a(a var1, c var2, d var3) {
      int var32 = a.H;
      boolean var4 = this.b(var1);
      if(var4) {
         this.a(var1, false);
      }

      try {
         y.c.y var5 = new y.c.y();
         y.h.z var6 = new y.h.z();
         Rectangle2D var7 = var2.h();
         this.a((y.c.q)var1.getNode(), (Rectangle2D)var7, (Collection)var5, var6);
         double var8 = var1.t();
         y.c.y var10 = new y.c.y();
         y.h.z var11 = new y.h.z();
         this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var1.getX(), var1.getY() + var8, var1.getWidth(), var1.getHeight() - var8)), (Collection)var10, var11);
         d var12 = var2.a();
         double var13 = 0.0D;
         boolean var15 = false;
         double var16 = 0.0D;
         if(var12 instanceof c) {
            c var18 = (c)var12;
            var13 = var18.g();
            var15 = var18.k() == 1;
         }

         double var19 = 0.0D;
         if(var3 instanceof c) {
            var19 = ((c)var3).g();
         }

         double var23;
         label121: {
            double var21 = var2.g();
            var2.a(var3);
            var23 = var2.g();
            if(var12 instanceof i) {
               var16 = var21;
               if(var32 == 0) {
                  break label121;
               }
            }

            if(var12 instanceof c) {
               var16 = var13 - ((c)var12).g();
            }
         }

         boolean var25;
         double var26;
         label126: {
            var25 = false;
            var26 = 0.0D;
            if(var3 instanceof i) {
               var26 = var23;
               if(var32 == 0) {
                  break label126;
               }
            }

            if(var3 instanceof c) {
               c var28 = (c)var3;
               var26 = var28.g() - var19;
               var25 = var28.k() == 1;
            }
         }

         Rectangle2D var35 = var2.h();
         this.a(var1, var5, var6, var3, var23, var15, var25, var16, var26, var35, var7, true);
         double var29 = var1.t();
         if(var29 != var8) {
            this.a(var1, var10, var11, var29 - var8, false);
         }
      } finally {
         if(var4) {
            this.a(var1, true);
         }

      }

   }

   public void a(f var1, g var2) {
      a var3 = a.a(var1);
      bu var4 = this.a(var3);
      if(var4 == null) {
         boolean var5 = this.b(var3);
         if(var5) {
            this.a(var3, false);
         }

         try {
            var1.a(var2);
         } finally {
            if(var5) {
               this.a(var3, true);
            }

         }
      } else {
         var4.r();

         try {
            y.c.q var16 = var3.getNode();
            var4.a((new y.c.y(var16)).a());
            fj var6 = a(var4, var16);
            if(var6 == var3) {
               this.a(var3, var1, var2);
               if(a.H == 0) {
                  return;
               }
            }

            if(var6 instanceof a) {
               a var7 = (a)var6;
               ArrayList var8 = new ArrayList();
               this.a(var7, a((f)var1, (a)var7, (List)var8), a((g)var2, (a)var7, (List)var8));
            }
         } finally {
            var4.s();
         }
      }

   }

   private void a(a var1, f var2, g var3) {
      int var32 = a.H;
      boolean var4 = this.b(var1);
      if(var4) {
         this.a(var1, false);
      }

      try {
         y.c.y var5 = new y.c.y();
         y.h.z var6 = new y.h.z();
         Rectangle2D var7 = var2.h();
         this.a((y.c.q)var1.getNode(), (Rectangle2D)var7, (Collection)var5, var6);
         double var8 = var1.v();
         y.c.y var10 = new y.c.y();
         y.h.z var11 = new y.h.z();
         this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var1.getX() + var8, var1.getY(), var1.getWidth() - var8, var1.getHeight())), (Collection)var10, var11);
         g var12 = var2.a();
         double var13 = 0.0D;
         boolean var15 = false;
         double var16 = 0.0D;
         if(var12 instanceof f) {
            f var18 = (f)var12;
            var13 = var18.g();
            var15 = var18.n() == 1;
         }

         double var19 = 0.0D;
         if(var3 instanceof f) {
            var19 = ((f)var3).g();
         }

         double var23;
         label121: {
            double var21 = var2.g();
            var2.a(var3);
            var23 = var2.g();
            if(var12 instanceof i) {
               var16 = var21;
               if(var32 == 0) {
                  break label121;
               }
            }

            if(var12 instanceof f) {
               var16 = var13 - ((f)var12).g();
            }
         }

         boolean var25;
         double var26;
         label126: {
            var25 = false;
            var26 = 0.0D;
            if(var3 instanceof i) {
               var26 = var23;
               if(var32 == 0) {
                  break label126;
               }
            }

            if(var3 instanceof f) {
               f var28 = (f)var3;
               var26 = var28.g() - var19;
               var25 = var28.n() == 1;
            }
         }

         Rectangle2D var35 = var2.h();
         this.a(var1, var5, var6, var3, var23, var15, var25, var16, var26, var35, var7, false);
         double var29 = var1.v();
         if(var29 != var8) {
            this.a(var1, var10, var11, var29 - var8, true);
         }
      } finally {
         if(var4) {
            this.a(var1, true);
         }

      }

   }

   private void a(a var1, y.c.y var2, y.h.z var3, Object var4, double var5, boolean var7, boolean var8, double var9, double var11, Rectangle2D var13, Rectangle2D var14, boolean var15) {
      int var30 = a.H;
      double var16 = a(var13, var15);
      double var18 = a(var14, var15);
      double var20 = b(var13, var15);
      double var22 = b(var14, var15);
      double var24 = a((fj)var1, var15);
      double var26;
      y.h.z var27;
      y.c.y var28;
      y.h.z var29;
      y.c.y var31;
      if(var7) {
         if(var8) {
            var26 = b(a(var4, var15), var15) - var11;
            if(var16 > var18) {
               var28 = new y.c.y();
               var29 = new y.h.z();
               this.a(var1, var26, var24 - var26, var28, var29, var15);
               this.a(var1, var28, var29, var11, var15);
               this.a(var1, var2, var3, var16 - var18, var15);
               if(var30 == 0) {
                  return;
               }
            }

            this.a(var1, var2, var3, var16 - var18, var15);
            var28 = new y.c.y();
            var29 = new y.h.z();
            this.a(var1, var26, var24 - var26, var28, var29, var15);
            this.a(var1, var28, var29, var11, var15);
            if(var30 == 0) {
               return;
            }
         }

         if(var16 > var18) {
            var31 = new y.c.y();
            var27 = new y.h.z();
            this.a(var1, var16, var24 - var16, var31, var27, var15);
            this.a(var1, var31, var27, var5, var15);
            this.a(var1, var2, var3, var16 - var18, var15);
            if(var30 == 0) {
               return;
            }
         }

         var31 = new y.c.y();
         var27 = new y.h.z();
         this.a(var1, var16, var18 - var16, var31, var27, var15);
         this.a(var1, var2, var3, var16 - var18, var15);
         this.a(var1, var20, var24 - var20, var31, var27, var15);
         this.a(var1, var31, var27, var5, var15);
         if(var30 == 0) {
            return;
         }
      }

      if(var8) {
         var26 = b(a(var4, var15), var15) - var11;
         if(var16 > var18) {
            var28 = new y.c.y();
            var29 = new y.h.z();
            this.a(var1, var22, var26 - var22 + var9, var28, var29, var15);
            this.a(var1, var28, var29, -var9, var15);
            var28.clear();
            this.a(var1, var26 + var9, var24 - var26, var28, var29, var15);
            this.a(var1, var28, var29, var11 - var9, var15);
            this.a(var1, var2, var3, var16 - var18, var15);
            if(var30 == 0) {
               return;
            }
         }

         var28 = new y.c.y();
         var29 = new y.h.z();
         this.a(var1, var26, var18 - var26, var28, var29, var15);
         this.a(var1, var28, var29, var11, var15);
         this.a(var1, var2, var3, var16 - var18, var15);
         var28.clear();
         this.a(var1, var22, var24 + var9 - var11 - var22, var28, var29, var15);
         this.a(var1, var28, var29, var11 - var9, var15);
         if(var30 == 0) {
            return;
         }
      }

      if(var16 > var18) {
         var31 = new y.c.y();
         var27 = new y.h.z();
         this.a(var1, var22, var20 - var22, var31, var27, var15);
         this.a(var1, var2, var3, var16 - var18, var15);
         this.a(var1, var31, var27, -var5, var15);
         if(var30 == 0) {
            return;
         }
      }

      var31 = new y.c.y();
      var27 = new y.h.z();
      this.a(var1, var16, var18 - var16, var31, var27, var15);
      this.a(var1, var31, var27, var5, var15);
      this.a(var1, var2, var3, var16 - var18, var15);
   }

   private static double a(Rectangle2D var0, boolean var1) {
      return var1?var0.getX():var0.getY();
   }

   private static double b(Rectangle2D var0, boolean var1) {
      return var1?var0.getMaxX():var0.getMaxY();
   }

   private static double a(fj var0, boolean var1) {
      return var1?var0.getX() + var0.getWidth():var0.getY() + var0.getHeight();
   }

   private static Rectangle2D a(Object var0, boolean var1) {
      return var1?((c)var0).h():((f)var0).h();
   }

   private void a(a var1, double var2, double var4, y.c.y var6, y.h.z var7, boolean var8) {
      if(var8) {
         this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var2, var1.getY(), var4, var1.getHeight())), (Collection)var6, var7);
         if(a.H == 0) {
            return;
         }
      }

      this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var1.getX(), var2, var1.getWidth(), var4)), (Collection)var6, var7);
   }

   private void a(a var1, y.c.y var2, y.h.z var3, double var4, boolean var6) {
      int var17 = a.H;
      y.h.z var7 = new y.h.z();
      bu var8 = this.a(var1);
      var8.r();
      boolean var19 = false;

      label163: {
         try {
            var19 = true;
            var8.a(var2.a());
            HashSet var9 = new HashSet();
            y.c.f var10 = new y.c.f();
            HashMap var11 = new HashMap();
            var11.put((Object)null, (Object)null);
            y.h.y var12 = var3.b();

            label135: {
               while(var12.f()) {
                  y.h.x var13 = var12.a();
                  var9.add(var13);
                  y.c.d var14 = var13.a();
                  if(var17 != 0) {
                     break label135;
                  }

                  if(!var11.containsKey(var14)) {
                     var11.put(var14, var8.i(var14));
                     var10.add(var14);
                  }

                  var12.g();
                  if(var17 != 0) {
                     break;
                  }
               }

               var8.a(var10.a());
            }

            y.c.e var21 = var10.a();

            label160:
            while(true) {
               boolean var10000 = var21.f();

               label157:
               while(true) {
                  if(!var10000) {
                     var19 = false;
                     break label160;
                  }

                  y.c.d var22 = var21.a();
                  y.h.y var23 = var8.i(var22).bends();
                  if(var17 != 0) {
                     var19 = false;
                     break label163;
                  }

                  y.h.y var15 = ((aB)var11.get(var22)).bends();

                  while(true) {
                     if(!var15.f()) {
                        break label157;
                     }

                     var10000 = var23.f();
                     if(var17 != 0) {
                        break;
                     }

                     if(!var10000) {
                        break label157;
                     }

                     if(var9.contains(var15.a())) {
                        var7.add(var23.a());
                     }

                     var15.g();
                     var23.g();
                     if(var17 != 0) {
                        break label157;
                     }
                  }
               }

               var21.g();
               if(var17 != 0) {
                  var19 = false;
                  break;
               }
            }
         } finally {
            if(var19) {
               var8.s();
            }
         }

         var8.s();
      }

      if(var6) {
         this.a(var8, var2, var7, var4, 0.0D);
         if(var17 == 0) {
            return;
         }
      }

      this.a(var8, var2, var7, 0.0D, var4);
   }

   public void a(c var1, int var2) {
      int var10 = a.H;
      a var3 = a.a(var1);
      bu var4 = this.a(var3);
      int var5 = var1.b();
      if(var5 != var2) {
         if(var4 == null) {
            var1.a(var2);
            if(var10 == 0) {
               return;
            }
         }

         var4.r();

         try {
            y.c.q var6 = var3.getNode();
            var4.a((new y.c.y(var6)).a());
            fj var7 = a(var4, var6);
            if(var7 == var3) {
               this.a(var3, var1, var5, var2);
               if(var10 == 0) {
                  return;
               }
            }

            if(var7 instanceof a) {
               a var8 = (a)var7;
               this.a(var8, a(var1, var8), var5, var2);
            }
         } finally {
            var4.s();
         }
      }

   }

   private void a(a var1, c var2, int var3, int var4) {
      boolean var5 = this.b(var1);
      if(var5) {
         this.a(var1, false);
      }

      try {
         Rectangle2D var6 = var2.h();
         var2.a(var4);
         this.a(var1, var2.g(), var3, var4, var6, var2.h(), true);
      } finally {
         if(var5) {
            this.a(var1, var5);
         }

      }

   }

   public void a(f var1, int var2) {
      int var10 = a.H;
      a var3 = a.a(var1);
      bu var4 = this.a(var3);
      int var5 = var1.b();
      if(var5 != var2) {
         if(var4 == null) {
            var1.a(var2);
            if(var10 == 0) {
               return;
            }
         }

         var4.r();

         try {
            y.c.q var6 = var3.getNode();
            var4.a((new y.c.y(var6)).a());
            fj var7 = a(var4, var6);
            if(var7 == var3) {
               this.a(var3, var1, var5, var2);
               if(var10 == 0) {
                  return;
               }
            }

            if(var7 instanceof a) {
               a var8 = (a)var7;
               this.a(var8, a(var1, var8), var5, var2);
            }
         } finally {
            var4.s();
         }
      }

   }

   private void a(a var1, f var2, int var3, int var4) {
      boolean var5 = this.b(var1);
      if(var5) {
         this.a(var1, false);
      }

      try {
         Rectangle2D var6 = var2.h();
         var2.a(var4);
         this.a(var1, var2.g(), var3, var4, var6, var2.h(), false);
      } finally {
         if(var5) {
            this.a(var1, var5);
         }

      }

   }

   private void a(a var1, double var2, int var4, int var5, Rectangle2D var6, Rectangle2D var7, boolean var8) {
      double var9;
      double var11;
      y.c.y var17;
      y.h.z var18;
      label13: {
         var9 = a(var7, var8);
         var11 = a(var6, var8);
         double var13 = b(var6, var8);
         double var15 = b(var7, var8);
         var17 = new y.c.y();
         var18 = new y.h.z();
         this.a((y.c.q)var1.getNode(), (Rectangle2D)var6, (Collection)var17, var18);
         y.c.y var19;
         y.h.z var20;
         if(var5 > var4) {
            var19 = new y.c.y();
            var20 = new y.h.z();
            this.a((y.c.q)var1.getNode(), (Rectangle2D)a(var6, var13, var15 - var13, var8), (Collection)var19, var20);
            this.a(var1, var19, var20, -var2, var8);
            if(a.H == 0) {
               break label13;
            }
         }

         if(var5 < var4) {
            var19 = new y.c.y();
            var20 = new y.h.z();
            this.a((y.c.q)var1.getNode(), (Rectangle2D)a(var6, var9, var11 - var9, var8), (Collection)var19, var20);
            this.a(var1, var19, var20, var2, var8);
         }
      }

      this.a(var1, var17, var18, var9 - var11, var8);
   }

   private static Rectangle2D a(Rectangle2D var0, double var1, double var3, boolean var5) {
      return var5?new Double(var1, var0.getY(), var3, var0.getHeight()):new Double(var0.getX(), var1, var0.getWidth(), var3);
   }

   public boolean a(f var1, double var2, boolean var4) {
      int var13 = a.H;
      a var5 = a.a(var1);
      double var6 = this.a(var1);
      if(var6 > var2) {
         return false;
      } else {
         bu var8 = this.a(var5);
         if(var8 == null) {
            this.a(var5, var1, var2, var4);
            if(var13 == 0) {
               return true;
            }
         }

         var8.r();

         try {
            y.c.q var9 = var5.getNode();
            var8.a((new y.c.y(var9)).a());
            fj var10 = a(var8, var9);
            if(var10 == var5) {
               this.a(var5, var1, var2, var4);
               if(var13 == 0) {
                  return true;
               }
            }

            if(var10 instanceof a) {
               a var11 = (a)var10;
               this.a(var11, a(var1, var11), var2, var4);
               if(var13 == 0) {
                  return true;
               }
            }

            throw new IllegalStateException();
         } finally {
            var8.s();
         }
      }
   }

   private void a(a var1, f var2, double var3, boolean var5) {
      int var17 = a.H;
      boolean var6 = this.b(var1);
      if(var6) {
         this.a(var1, false);
      }

      try {
         double var7 = var3 - var2.g();
         Rectangle2D var9 = var2.h();
         Object var10 = var2;

         while(true) {
            if(var10 instanceof f) {
               f var11 = (f)var10;
               var11.b(var11.g() + var7);
               var10 = var11.a();
               if(var17 == 0) {
                  continue;
               }
            }

            y.c.y var20 = new y.c.y();
            double var12 = var5?var9.getY():var9.getY() + var9.getHeight();
            y.h.z var14 = new y.h.z();
            this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var1.getX(), var12, var1.getWidth(), var1.getHeight() - var12 + var1.getY())), (Collection)var20, var14);
            this.a(var1, var20, var14, var7, false);
            boolean var15 = var1.k();
            var1.c(false);
            var1.setFrame(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight() + var7);
            var1.c(var15);
            return;
         }
      } finally {
         if(var6) {
            this.a(var1, var6);
         }

      }
   }

   double a(f var1) {
      int var11 = a.H;
      double var2 = var1.g() - var1.f();
      Object var4 = var1;

      double var10000;
      while(true) {
         if(var4 instanceof f) {
            f var5 = (f)var4;
            y.d.r var6 = var5.i();
            Iterator var7 = var5.o().iterator();
            var10000 = 0.0D;
            if(var11 != 0) {
               break;
            }

            double var8 = 0.0D;

            label33: {
               while(var7.hasNext()) {
                  f var10 = (f)var7.next();
                  var8 += var10.g();
                  if(var11 != 0) {
                     break label33;
                  }

                  if(var11 != 0) {
                     break;
                  }
               }

               if(var6 != null) {
                  var8 += var6.a + var6.c;
               }
            }

            if(var5 != var1) {
               var8 -= var2;
            }

            var8 = Math.max(var5.f(), var8);
            var2 = Math.max(0.0D, Math.min(var2, var5.g() - var8));
            var4 = var5.a();
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = var1.g() - var2;
         break;
      }

      return var10000;
   }

   public boolean a(c var1, double var2, boolean var4) {
      int var13 = a.H;
      a var5 = a.a(var1);
      double var6 = this.a(var1);
      if(var6 > var2) {
         return false;
      } else {
         bu var8 = this.a(var5);
         if(var8 == null) {
            this.a(var5, var1, var2, var4);
            if(var13 == 0) {
               return true;
            }
         }

         var8.r();

         try {
            y.c.q var9 = var5.getNode();
            var8.a((new y.c.y(var9)).a());
            fj var10 = a(var8, var9);
            if(var10 == var5) {
               this.a(var5, var1, var2, var4);
               if(var13 == 0) {
                  return true;
               }
            }

            if(var10 instanceof a) {
               a var11 = (a)var10;
               this.a(var11, a(var1, var11), var2, var4);
               if(var13 == 0) {
                  return true;
               }
            }

            throw new IllegalStateException();
         } finally {
            var8.s();
         }
      }
   }

   private void a(a var1, c var2, double var3, boolean var5) {
      int var17 = a.H;
      boolean var6 = this.b(var1);
      if(var6) {
         this.a(var1, false);
      }

      try {
         double var7 = var3 - var2.g();
         Rectangle2D var9 = var2.h();
         Object var10 = var2;

         while(true) {
            if(var10 instanceof c) {
               c var11 = (c)var10;
               var11.b(var11.g() + var7);
               var10 = var11.a();
               if(var17 == 0) {
                  continue;
               }
            }

            y.c.y var20 = new y.c.y();
            double var12 = var5?var9.getX():var9.getX() + var9.getWidth();
            y.h.z var14 = new y.h.z();
            this.a((y.c.q)var1.getNode(), (Rectangle2D)(new Double(var12, var1.getY(), var1.getWidth() - var12 + var1.getX(), var1.getHeight())), (Collection)var20, var14);
            this.a(var1, var20, var14, var7, true);
            boolean var15 = var1.k();
            var1.c(false);
            var1.setFrame(var1.getX(), var1.getY(), var1.getWidth() + var7, var1.getHeight());
            var1.c(var15);
            return;
         }
      } finally {
         if(var6) {
            this.a(var1, var6);
         }

      }
   }

   double a(c var1) {
      int var11 = a.H;
      double var2 = var1.g() - var1.f();
      Object var4 = var1;

      double var10000;
      while(true) {
         if(var4 instanceof c) {
            c var5 = (c)var4;
            y.d.r var6 = var5.i();
            Iterator var7 = var5.l().iterator();
            var10000 = 0.0D;
            if(var11 != 0) {
               break;
            }

            double var8 = 0.0D;

            label33: {
               while(var7.hasNext()) {
                  c var10 = (c)var7.next();
                  var8 += var10.g();
                  if(var11 != 0) {
                     break label33;
                  }

                  if(var11 != 0) {
                     break;
                  }
               }

               if(var6 != null) {
                  var8 += var6.b + var6.d;
               }
            }

            if(var5 != var1) {
               var8 -= var2;
            }

            var8 = Math.max(var5.f(), var8);
            var2 = Math.max(0.0D, Math.min(var2, var5.g() - var8));
            var4 = var5.a();
            if(var11 == 0) {
               continue;
            }
         }

         var10000 = var1.g() - var2;
         break;
      }

      return var10000;
   }

   public boolean a() {
      return this.a;
   }

   static c a(c var0, a var1) {
      return a((c)var0, (a)var1, (List)(new ArrayList()));
   }

   static c a(c var0, a var1, List var2) {
      int var7 = a.H;
      var2.clear();
      var2.add(var0);
      d var3 = var0.a();

      while(var3 instanceof c) {
         var2.add(var3);
         var3 = ((c)var3).a();
         if(var7 != 0) {
            break;
         }
      }

      Object var4 = var1.l();
      ListIterator var5 = var2.listIterator(var2.size());

      c var10000;
      while(true) {
         if(var5.hasPrevious()) {
            c var6 = (c)var5.previous();
            var10000 = ((d)var4).b(var6.b());
            if(var7 != 0) {
               break;
            }

            var4 = var10000;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = (c)var4;
         break;
      }

      return var10000;
   }

   static d a(d var0, a var1, List var2) {
      return (d)(var0 instanceof i?var1.l():a((c)var0, var1, var2));
   }

   static f a(f var0, a var1) {
      return a((f)var0, (a)var1, (List)(new ArrayList()));
   }

   static f a(f var0, a var1, List var2) {
      int var7 = a.H;
      var2.clear();
      var2.add(var0);
      g var3 = var0.a();

      while(var3 instanceof f) {
         var2.add(var3);
         var3 = ((f)var3).a();
         if(var7 != 0) {
            break;
         }
      }

      Object var4 = var1.l();
      ListIterator var5 = var2.listIterator(var2.size());

      f var10000;
      while(true) {
         if(var5.hasPrevious()) {
            f var6 = (f)var5.previous();
            var10000 = ((g)var4).c(var6.b());
            if(var7 != 0) {
               break;
            }

            var4 = var10000;
            if(var7 == 0) {
               continue;
            }
         }

         var10000 = (f)var4;
         break;
      }

      return var10000;
   }

   static g a(g var0, a var1, List var2) {
      return (g)(var0 instanceof i?var1.l():a((f)var0, var1, var2));
   }

   static fj a(bu var0, y.c.q var1) {
      fj var2 = var0.t(var1);
      return var2 instanceof gd?((gd)var2).e():var2;
   }
}
