package y.h;

import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.h.aB;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dU;
import y.h.eU;
import y.h.ek;
import y.h.el;
import y.h.em;
import y.h.en;
import y.h.fA;
import y.h.fC;
import y.h.fL;
import y.h.fj;
import y.h.fv;
import y.h.fw;
import y.h.fx;
import y.h.fy;
import y.h.fz;
import y.h.gX;
import y.h.gz;
import y.h.x;
import y.h.y;

public class fu extends gX {
   private aB a;
   private boolean b = true;
   private boolean c = true;
   private List d = new ArrayList(3);
   private dU e;
   private boolean f = true;
   private boolean g = true;
   private boolean h = true;
   private y.d.t i;
   private fz j = new fz();
   private boolean k;
   private double l;
   private double m;
   private y.c.o n;
   private PropertyChangeListener o = new fv(this);
   private int p = 2;

   public int a() {
      return this.p;
   }

   protected boolean a(MouseEvent var1) {
      return var1 != null && (var1.getModifiers() & this.a()) != 0;
   }

   public dU c() {
      if(this.e == null) {
         this.e = this.f();
      }

      return this.e;
   }

   public boolean e() {
      return this.h;
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   protected dU f() {
      dU var1 = new dU(this.view);
      var1.e(false);
      var1.g(true);
      var1.b(false);
      var1.c(true);
      var1.f(false);
      var1.a(false);
      return var1;
   }

   public void mousePressedLeft(double var1, double var3) {
      boolean var17 = fj.z;
      this.l = var1;
      this.m = var3;
      this.i = new y.d.t(var1, var3);
      cW var5 = this.getHitInfo(var1, var3);
      this.a = null;
      x var6 = var5.j();
      if(this.e() && this.c() != null) {
         this.c().a((ch)this.view);
      }

      label134: {
         this.d.clear();
         if(this.f) {
            y var7 = this.getGraph2D().M();

            while(var7.f()) {
               var7.a().a(false);
               var7.g();
               if(var17) {
                  break label134;
               }

               if(var17) {
                  break;
               }
            }
         }

         if(this.g) {
            y.c.x var18 = this.getGraph2D().J();

            while(var18.f()) {
               this.getGraph2D().a(var18.e(), false);
               var18.g();
               if(var17) {
                  break label134;
               }

               if(var17) {
                  break;
               }
            }
         }

         this.j = new fz();
      }

      aB var19 = null;
      if(var6 != null) {
         this.getGraph2D().a((new y.c.f(var6.a())).a());
         this.a(this.j, var19 = this.getGraph2D().i(var6.a()), var6, this.d);
      } else {
         y.c.d var8 = var5.k();
         if(var8 != null) {
            this.getGraph2D().a((new y.c.f(var8)).a());
            this.a(this.j, var19 = this.getGraph2D().i(var8), var1, var3, this.d);
         }
      }

      if(this.d.isEmpty()) {
         this.a = null;
         this.reactivateParent();
         if(!var17) {
            return;
         }
      }

      this.a = var19;
      if(this.c() != null && this.e()) {
         this.c().a((ch)this.view);
         HashSet var20 = new HashSet();
         HashSet var9 = new HashSet();
         Iterator var10 = this.d.iterator();

         while(true) {
            if(var10.hasNext()) {
               en var11;
               label95: {
                  var11 = (en)var10.next();
                  if(var11.a() instanceof ek) {
                     var9.add(var11.a());
                     if(!var17) {
                        break label95;
                     }
                  }

                  if(var11.a() instanceof em) {
                     var20.add(var11.a());
                  }
               }

               if(var11.b() instanceof ek) {
                  var9.add(var11.b());
                  if(!var17) {
                     continue;
                  }
               }

               if(!(var11.b() instanceof em)) {
                  continue;
               }

               var20.add(var11.b());
               if(var17) {
                  break;
               }

               if(!var17) {
                  continue;
               }
            }

            this.c().a(this.i, Collections.EMPTY_SET, var9, var20, y.g.q.a((Object)null));
            break;
         }

         boolean var21 = true;
         Iterator var22 = this.d.iterator();

         boolean var10000;
         while(true) {
            if(var22.hasNext()) {
               en var12 = (en)var22.next();
               this.c().a(var12);
               byte var13 = a(var12);
               el var14 = var12.b();
               if(var14 instanceof fA) {
                  fA var15 = (fA)var14;
                  if(var15.e()) {
                     this.c().a((gz)this.a(var15, var13));
                     var21 = false;
                  }
               }

               el var23 = var12.a();
               if(!(var23 instanceof fA)) {
                  continue;
               }

               fA var16 = (fA)var23;
               var10000 = var16.e();
               if(var17) {
                  break;
               }

               if(!var10000) {
                  continue;
               }

               this.c().a((gz)this.a(var16, var13));
               var21 = false;
               if(!var17) {
                  continue;
               }
            }

            var10000 = var21;
            break;
         }

         if(var10000) {
            this.c().a((gz)(new fw(this, Double.MAX_VALUE)));
         }
      }

      if(this.n == null) {
         this.n = new fx(this);
         this.getGraph2D().a((y.c.o)this.n);
      }

      this.view.addPropertyChangeListener("Graph2D", this.o);
      this.setEditing(true);
   }

   public void cancelEditing() {
      if(this.isEditing()) {
         this.mouseReleasedLeft(this.l, this.m);
      }

   }

   private void g() {
      if(this.c() != null && this.e()) {
         this.c().f();
      }

      this.setEditing(false);
      this.a = null;
      this.d.clear();
      this.reactivateParent();
   }

   public void reactivateParent() {
      if(this.n != null) {
         this.getGraph2D().b((y.c.o)this.n);
         this.n = null;
      }

      this.view.removePropertyChangeListener("Graph2D", this.o);
      super.reactivateParent();
   }

   private gz a(fA var1, byte var2) {
      return new fy(this, Double.MAX_VALUE, var1, var2);
   }

   protected x a(fz var1, aB var2, x var3, Collection var4) {
      boolean var22 = fj.z;
      double var5 = this.view.toWorldCoordX(this.lastPressEvent.getX());
      double var7 = this.view.toWorldCoordY(this.lastPressEvent.getY());
      boolean var9 = a(var2);
      x var10 = var2.firstBend();
      double var11 = Double.MAX_VALUE;
      int var13 = 0;

      x var14;
      int var10000;
      while(true) {
         if(var13 < var2.bendCount()) {
            var14 = var2.getBend(var13);
            double var15 = y.d.t.a(var5, var7, var14.b(), var14.c());
            double var27;
            var10000 = (var27 = var15 - var11) == 0.0D?0:(var27 < 0.0D?-1:1);
            if(var22) {
               break;
            }

            if(var10000 < 0) {
               var10 = var14;
               var11 = var15;
            }

            ++var13;
            if(!var22) {
               continue;
            }
         }

         double var28;
         var10000 = (var28 = var11 - 10.0D) == 0.0D?0:(var28 < 0.0D?-1:1);
         break;
      }

      label106: {
         if(var10000 < 0) {
            var3 = var10;
            if(!var22) {
               break label106;
            }
         }

         var13 = var2.containsSeg(var5, var7);
         if(var13 > 0) {
            label101: {
               if(var13 > var2.bendCount() - 1) {
                  y.d.t var23 = b(var2, var2.bendCount() - 1);
                  var3 = var2.appendBend(var23.a(), var23.b());
                  var2.appendBend(var2.lastBend().b(), var2.lastBend().c());
                  if(!var22) {
                     break label101;
                  }
               }

               var14 = var2.getBend(var13);
               var3 = var2.createBend(var14.b(), var14.c(), var14, 1);
               var2.createBend(var14.b(), var14.c(), var14, 1);
            }
         }
      }

      if(var3 != null && this.b) {
         var3.a(true);
      }

      if(var3 != null) {
         label120: {
            boolean var18;
            ek var19;
            x var20;
            ek var21;
            boolean var25;
            fA var26;
            label121: {
               var13 = this.a(var2, var3);
               boolean var24 = var13 > 0;
               var25 = var13 < var2.bendCount() - 1;
               boolean var16 = var13 % 2 == 1;
               boolean var17 = var9 == var16;
               var18 = !var17;
               var19 = new ek(var3, new y.d.t(var3.b(), var3.c()), (byte)3);
               if(var24) {
                  var20 = var2.getBend(var13 - 1);
                  var21 = new ek(var20, new y.d.t(var20.b(), var20.c()), (byte)(var17?1:2));
                  var4.add(new en(var19, var21));
                  if(!var22) {
                     break label121;
                  }
               }

               var26 = new fA(eU.b(var2), var2.getSourcePort(), b(var2, 0), (byte)(var17?1:2));
               this.a(var1, var5, var7, var2.getSourceRealizer(), var2.getSourcePort(), !var17, var17);
               var4.add(new en(var19, var26));
            }

            if(var25) {
               var20 = var2.getBend(var13 + 1);
               var21 = new ek(var20, new y.d.t(var20.b(), var20.c()), (byte)(var18?1:2));
               var4.add(new en(var19, var21));
               if(!var22) {
                  break label120;
               }
            }

            var26 = new fA(eU.d(var2), var2.getTargetPort(), b(var2, var2.bendCount() + 1), (byte)(var18?1:2));
            this.a(var1, var5, var7, var2.getTargetRealizer(), var2.getTargetPort(), !var18, var18);
            var4.add(new en(var19, var26));
         }
      }

      this.getGraph2D().T();
      return var3;
   }

   protected void a(fz var1, aB var2, double var3, double var5, Collection var7) {
      boolean var19 = fj.z;
      boolean var8 = a(var2);
      if(var2.bendCount() == 0) {
         this.a(var1, var2, var3, var5, var7, var8);
      } else {
         x var10;
         x var11;
         x var12;
         boolean var14;
         int var15;
         ek var20;
         ek var24;
         label150: {
            int var9 = Math.max(1, var2.containsSeg(var3, var5));
            var3 = this.getGridX(var3);
            var5 = this.getGridY(var5);
            boolean var13 = var9 % 2 == 0;
            var14 = var8 == var13;
            var15 = var14?1:2;
            if(var9 >= 1) {
               if(var9 > var2.bendCount()) {
                  if(this.c || this.isModifierPressed(this.lastPressEvent)) {
                     y.d.t var16 = b(var2, var2.bendCount() + 2);
                     if(!var14) {
                        var11 = var2.appendBend(var3, var16.b);
                        var15 = 3;
                        var12 = var2.appendBend(var3, var16.b);
                        var10 = var2.getBend(this.a(var2, var11) - 1);
                        if(!var19) {
                           break label150;
                        }
                     }

                     var11 = var2.appendBend(var16.a, var5);
                     var15 = 3;
                     var12 = var2.appendBend(var16.a, var5);
                     var10 = var2.getBend(this.a(var2, var11) - 1);
                     if(!var19) {
                        break label150;
                     }
                  }

                  var20 = new ek(var2.lastBend(), b(var2, var2.bendCount()), (byte)(var14?1:2));
                  fA var17 = new fA(eU.d(var2), var2.getTargetPort(), b(var2, var2.bendCount() + 1), (byte)(var14?1:2));
                  this.a(var1, var3, var5, var2.getTargetRealizer(), var2.getTargetPort(), !var14, var14);
                  var7.add(new en(var20, var17));
                  var11 = null;
                  var10 = null;
                  var12 = null;
                  if(!var19) {
                     break label150;
                  }
               }

               x var21 = var2.getBend(var9 - 1);
               if(this.isModifierPressed(this.lastPressEvent) || var9 == 1 && this.c) {
                  y.d.t var23;
                  if(var9 == 1) {
                     var23 = b(var2, var9);
                     if(!var14) {
                        var12 = var2.createBend(var3, var23.b, var21, 1);
                        var15 = 3;
                        var11 = var2.createBend(var3, var23.b, var21, 1);
                        var10 = var21;
                        if(!var19) {
                           break label150;
                        }
                     }

                     var12 = var2.createBend(var23.a, var5, var21, 1);
                     var15 = 3;
                     var11 = var2.createBend(var23.a, var5, var21, 1);
                     var10 = var21;
                     if(!var19) {
                        break label150;
                     }
                  }

                  var23 = b(var2, var9);
                  if(!var14) {
                     var11 = var2.createBend(var3, var23.b, var21, 1);
                     var15 = 3;
                     var12 = var2.createBend(var3, var23.b, var21, 1);
                     var10 = var2.getBend(this.a(var2, var11) - 1);
                     if(!var19) {
                        break label150;
                     }
                  }

                  var11 = var2.createBend(var23.a, var5, var21, 1);
                  var15 = 3;
                  var12 = var2.createBend(var23.a, var5, var21, 1);
                  var10 = var2.getBend(this.a(var2, var11) - 1);
                  if(!var19) {
                     break label150;
                  }
               }

               if(var9 > 1) {
                  var11 = var21;
                  var10 = var2.getBend(var9 - 2);
                  var12 = null;
                  if(!var19) {
                     break label150;
                  }
               }

               var24 = new ek(var2.firstBend(), b(var2, 1), (byte)(var14?1:2));
               this.a(var1, var3, var5, var2.getSourceRealizer(), var2.getSourcePort(), !var14, var14);
               fA var18 = new fA(eU.b(var2), var2.getSourcePort(), b(var2, 0), (byte)(var14?1:2));
               var7.add(new en(var24, var18));
               var11 = null;
               var10 = null;
               var12 = null;
               if(!var19) {
                  break label150;
               }
            }

            var10 = null;
            var11 = null;
            var12 = null;
         }

         if(var11 != null) {
            var20 = new ek(var11, new y.d.t(var11.b(), var11.c()), (byte)var15);
            if(var10 != null) {
               var24 = new ek(var10, new y.d.t(var10.b(), var10.c()), (byte)(var14?1:2));
               var7.add(new en(var20, var24));
            }

            if(var12 != null) {
               var24 = new ek(var12, new y.d.t(var12.b(), var12.c()), (byte)(var14?2:1));
               var7.add(new en(var20, var24));
            }
         }

         if(this.b && !var7.isEmpty()) {
            Iterator var22 = this.a(var7).iterator();

            while(var22.hasNext()) {
               x var25 = (x)var22.next();
               var25.a(true);
               if(var19) {
                  return;
               }

               if(var19) {
                  break;
               }
            }
         }

         this.getGraph2D().T();
      }
   }

   private void a(fz var1, aB var2, double var3, double var5, Collection var7, boolean var8) {
      y.d.t var9 = b(var2, 0);
      y.d.t var10 = b(var2, 1);
      double var11 = var9.a - var10.a;
      double var13 = var9.b - var10.b;
      if(!this.c && !this.isModifierPressed(this.lastPressEvent)) {
         fA var21;
         fA var22;
         if(var11 != 0.0D) {
            this.a(var1, var3, var5, var2.getSourceRealizer(), var2.getSourcePort(), true, false);
            this.a(var1, var3, var5, var2.getTargetRealizer(), var2.getTargetPort(), true, false);
            var21 = new fA(eU.b(var2), var2.getSourcePort(), b(var2, 0), (byte)2);
            var22 = new fA(eU.d(var2), var2.getTargetPort(), b(var2, 1), (byte)2);
            var7.add(new en(var21, var22));
         } else if(var13 != 0.0D) {
            this.a(var1, var3, var5, var2.getSourceRealizer(), var2.getSourcePort(), false, true);
            this.a(var1, var3, var5, var2.getTargetRealizer(), var2.getTargetPort(), false, true);
            var21 = new fA(eU.b(var2), var2.getSourcePort(), b(var2, 0), (byte)1);
            var22 = new fA(eU.d(var2), var2.getTargetPort(), b(var2, 1), (byte)1);
            var7.add(new en(var21, var22));
         }
      } else {
         x var15;
         x var16;
         label38: {
            double var17;
            double var19;
            if(Math.abs(var11) > Math.abs(var13)) {
               var17 = (var9.a + var3) * 0.5D;
               var19 = (var10.a + var3) * 0.5D;
               var2.appendBend(var17, var9.b);
               var15 = var2.appendBend(var17, var5);
               var16 = var2.appendBend(var19, var5);
               var2.appendBend(var19, var10.b);
               if(!fj.z) {
                  break label38;
               }
            }

            var17 = (var9.b + var5) * 0.5D;
            var19 = (var10.b + var5) * 0.5D;
            var2.appendBend(var9.a, var17);
            var15 = var2.appendBend(var3, var17);
            var16 = var2.appendBend(var3, var19);
            var2.appendBend(var10.a, var19);
         }

         ek var23 = new ek(var15, new y.d.t(var15.b(), var15.c()), (byte)(var8?2:1));
         ek var18 = new ek(var16, new y.d.t(var16.b(), var16.c()), (byte)(var8?2:1));
         var7.add(new en(var23, var18));
         if(this.b) {
            var15.a(true);
            var16.a(true);
         }

         this.getGraph2D().T();
      }
   }

   private void a(fz var1, double var2, double var4, fj var6, fL var7, boolean var8, boolean var9) {
      double var10;
      if(var8) {
         var10 = var4 - var7.b(var6);
         var1.c(Math.max(var1.c(), var6.getY() + var10));
         var1.d(Math.min(var1.d(), var6.getY() + var6.getHeight() + var10));
      }

      if(var9) {
         var10 = var2 - var7.a(var6);
         var1.a(Math.max(var1.a(), var6.getX() + var10));
         var1.b(Math.min(var1.b(), var6.getX() + var6.getWidth() + var10));
      }

   }

   private Collection a(Collection var1) {
      boolean var5 = fj.z;
      HashSet var2 = new HashSet();
      Iterator var3 = var1.iterator();

      HashSet var10000;
      while(true) {
         if(var3.hasNext()) {
            en var4 = (en)var3.next();
            if(var4.a() instanceof ek) {
               var2.add(((ek)var4.a()).a());
            }

            if(!(var4.b() instanceof ek)) {
               continue;
            }

            var10000 = var2;
            if(var5) {
               break;
            }

            var2.add(((ek)var4.b()).a());
            if(!var5) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private int a(aB var1, x var2) {
      boolean var4 = fj.z;
      int var3 = 0;

      while(var3 < var1.bendCount()) {
         if(var1.getBend(var3) == var2) {
            return var3;
         }

         ++var3;
         if(var4) {
            break;
         }
      }

      return -1;
   }

   public void mouseDraggedLeft(double var1, double var3) {
      this.l = var1;
      this.m = var3;
      this.a(var1, var3, !this.a(this.lastDragEvent));
   }

   private void a(double var1, double var3, boolean var5) {
      boolean var21 = fj.z;
      if(this.d.isEmpty()) {
         if(this.c() != null && this.e()) {
            this.c().h();
         }

      } else {
         double var9;
         boolean var22;
         double var23;
         label105: {
            var1 = this.getGridX(var1);
            var3 = this.getGridY(var3);
            java.awt.geom.Point2D.Double var6 = new java.awt.geom.Point2D.Double(var1, var3);
            this.j.a(var6);
            var1 = var6.x;
            var3 = var6.y;
            var22 = true;
            if(this.c() != null && this.e()) {
               if(var5) {
                  y.d.t var7 = this.c().b(new y.d.t(var1, var3));
                  var1 = var7.a;
                  var3 = var7.b;
                  java.awt.geom.Point2D.Double var8 = new java.awt.geom.Point2D.Double(var1, var3);
                  this.j.a(var8);
                  var1 = var8.x;
                  var3 = var8.y;
                  if(!var21) {
                     break label105;
                  }
               }

               this.c().h();
               if(!var21) {
                  break label105;
               }
            }

            var23 = var1 - this.i.a;
            var9 = var3 - this.i.b;
            fC var11 = new fC(this.i, var1, var3);
            Iterator var12 = this.d.iterator();

            boolean var10000;
            label91: {
               label90:
               while(var12.hasNext()) {
                  en var13 = (en)var12.next();
                  byte var14 = a(var13);
                  y.d.t var15 = null;
                  el var16 = var13.b();
                  y.d.t var17;
                  if(var16 instanceof fA && ((fA)var16).e()) {
                     var15 = ((fA)var16).c(var23, var9);
                     var17 = this.a(var15, var16.b(), var14);
                     if(!this.j.a(var17.a(), var17.b())) {
                        var11.b();
                        if(!var21) {
                           break;
                        }
                     }
                  }

                  var17 = null;
                  el var18 = var13.a();
                  y.d.t var19;
                  if(var18 instanceof fA && ((fA)var18).e()) {
                     var17 = ((fA)var18).c(var23, var9);
                     var19 = this.a(var17, var18.b(), var14);
                     if(!this.j.a(var19.a(), var19.b())) {
                        var11.b();
                        if(!var21) {
                           break;
                        }
                     }
                  }

                  if(var15 != null) {
                     if(var17 != null) {
                        y.d.t var20;
                        switch(var14) {
                        case 0:
                           if(!this.a(var15.b(), var17.b())) {
                              var11.b();
                              if(!var21) {
                                 break label90;
                              }
                           }

                           var19 = var16.b();
                           var20 = var18.b();
                           var11.b.b((var15.b() - var19.b() + var17.b() - var20.b()) * 0.5D);
                           if(!var11.a()) {
                              break label90;
                           }
                           break;
                        case 1:
                           if(!this.a(var15.a(), var17.a())) {
                              var11.b();
                              if(!var21) {
                                 break label90;
                              }
                           }

                           var19 = var16.b();
                           var20 = var18.b();
                           var11.a.b((var15.a() - var19.a() + var17.a() - var20.a()) * 0.5D);
                           if(!var11.a()) {
                              break label90;
                           }
                        }

                        if(!var21) {
                           continue;
                        }
                     }

                     var19 = var16.b();
                     var11.a(var15.a() - var19.a(), var15.b() - var19.b(), var14);
                     if(!var11.a()) {
                        break;
                     }
                  } else if(var17 != null) {
                     var19 = var18.b();
                     var11.a(var17.a() - var19.a(), var17.b() - var19.b(), var14);
                     var10000 = var11.a();
                     if(var21) {
                        break label91;
                     }

                     if(!var10000) {
                        break;
                     }
                  }
               }

               var10000 = var11.a();
            }

            var22 = var10000;
            var1 = var11.a.a();
            var3 = var11.b.a();
         }

         if(var22) {
            var23 = var1 - this.i.a;
            var9 = var3 - this.i.b;
            this.a(var23, var9, this.d);
            this.getGraph2D().T();
         }

      }
   }

   private y.d.t a(y.d.t var1, y.d.t var2, byte var3) {
      switch(var3) {
      case 0:
         return new y.d.t(var1.a(), var1.b() + this.i.b - var2.b());
      case 1:
         return new y.d.t(var1.a() + this.i.a - var2.a(), var1.b());
      default:
         return var1;
      }
   }

   private boolean a(double var1, double var3) {
      return Math.abs(var1 - var3) * Math.max(1.0D, this.view.getZoom()) <= 0.1D;
   }

   private static byte a(en var0) {
      el var1 = var0.b();
      el var2 = var0.a();
      double var3 = var1.b().a - var2.b().a;
      double var5 = var1.b().b - var2.b().b;
      return (byte)(var3 != 0.0D || var5 == 0.0D && var1.c() == var2.c()?(var5 != 0.0D || var3 == 0.0D && var1.d() == var2.d()?-1:0):1);
   }

   private void a(double var1, double var3, List var5) {
      boolean var8 = fj.z;
      int var6 = 0;

      while(var6 < var5.size()) {
         en var7 = (en)var5.get(var6);
         var7.a(var1, var3);
         ++var6;
         if(var8) {
            break;
         }
      }

   }

   public void mouseReleasedLeft(double var1, double var3) {
      boolean var7 = fj.z;
      super.mouseReleasedLeft(var1, var3);
      this.a(var1, var3, !this.a(this.lastReleaseEvent));
      if(this.c() != null && this.e()) {
         this.c().f();
      }

      Iterator var5 = this.a((Collection)this.d).iterator();

      while(true) {
         if(var5.hasNext()) {
            x var6 = (x)var5.next();
            this.a(var6, var6.b(), var6.c());
            if(var7) {
               break;
            }

            if(!var7) {
               continue;
            }
         }

         if(this.a != null) {
            this.b(this.a);
            if(this.k) {
               c(this.a);
            }

            this.a = null;
         }

         this.d.clear();
         this.setEditing(false);
         this.reactivateParent();
         break;
      }

   }

   public void mouseReleasedRight(double var1, double var3) {
      this.mouseReleasedLeft(var1, var3);
   }

   private static y.d.t b(aB var0, int var1) {
      bu var2 = (bu)var0.getEdge().a();
      if(var1 < 1) {
         return var2.p(var0.getEdge());
      } else if(var1 > var0.bendCount()) {
         return var2.q(var0.getEdge());
      } else {
         x var3 = var0.getBend(var1 - 1);
         return new y.d.t(var3.b(), var3.c());
      }
   }

   public static boolean a(aB var0) {
      boolean var11 = fj.z;
      if(var0.getMinBendCount() <= 0 && var0.getEdge() != null && var0.getEdge().a() != null) {
         d(var0);
         int var1 = var0.bendCount() + 2;
         var1 = a(var0, var1);
         y.d.t var2;
         y.d.t var3;
         double var19;
         if(var0.getEdge().e()) {
            if(var1 == 2) {
               var2 = b(var0, 0);
               var3 = b(var0, 1);
               if(a(var2, var3)) {
                  return true;
               }

               if(var2.a == var3.a) {
                  return false;
               }

               if(var2.b == var3.b) {
                  return true;
               }

               var0.insertBend(var2.a, var3.b);
               return false;
            }

            if(var1 == 3) {
               var2 = b(var0, 0);
               var3 = b(var0, 1);
               y.d.t var14 = b(var0, 2);
               double var16 = var3.a - var2.a;
               var19 = var3.b - var2.b;
               if(Math.abs(var16) < Math.abs(var19)) {
                  var0.getBend(0).a(var2.a, var3.b);
                  var0.appendBend(var14.a, var3.b);
                  return false;
               }

               var0.getBend(0).a(var3.a, var2.b);
               var0.appendBend(var3.a, var14.b);
               return true;
            }
         }

         double var4;
         int var10000;
         byte var10001;
         label239: {
            if(var1 > 2) {
               var2 = b(var0, var1 - 1);
               var3 = b(var0, var1 - 2);
               var4 = y.d.t.a(var3, var2);

               while(var4 < 3.0D) {
                  var10000 = var1;
                  var10001 = 2;
                  if(var11) {
                     break label239;
                  }

                  if(var1 <= 2) {
                     break;
                  }

                  var0.removeBend(var0.lastBend());
                  --var1;
                  var3 = b(var0, var1 - 2);
                  var4 = y.d.t.a(var3, var2);
                  if(var11) {
                     break;
                  }
               }
            }

            var10000 = var1;
            var10001 = 2;
         }

         if(var10000 > var10001) {
            var2 = b(var0, 0);
            var3 = b(var0, 1);
            var4 = y.d.t.a(var3, var2);

            while(var4 < 3.0D && var1 > 2) {
               var0.removeBend(var0.firstBend());
               --var1;
               var3 = b(var0, 1);
               var4 = y.d.t.a(var3, var2);
               if(var11) {
                  break;
               }
            }
         }

         var2 = b(var0, 0);
         var3 = b(var0, 1);
         y.d.z var12 = new y.d.z(var3, var2);
         boolean var5 = Math.abs(var12.b()) > Math.abs(var12.a());
         boolean var6 = !var5;
         if(var1 > 2) {
            x var7;
            label212: {
               var7 = var0.firstBend();
               if(var5) {
                  var7.a(var2.a, var7.c());
                  if(!var11) {
                     break label212;
                  }
               }

               var7.a(var7.b(), var2.b);
            }

            var2 = new y.d.t(var7.b(), var7.c());
            var5 = !var5;
         }

         int var13 = 1;

         while(true) {
            if(var13 < var0.bendCount()) {
               x var8 = var0.getBend(var13);
               y.d.t var9 = new y.d.t(var8.b(), var8.c());
               var12 = new y.d.z(var9, var2);
               double var20;
               var10000 = (var20 = var12.b() - 0.0D) == 0.0D?0:(var20 < 0.0D?-1:1);
               if(var11) {
                  break;
               }

               label280: {
                  if(var10000 == 0 && var5 || var12.a() == 0.0D && !var5) {
                     var0.removeBend(var0.getBend(var13 - 1));
                     var2 = var9;
                     --var1;
                     --var13;
                     if(!var11) {
                        break label280;
                     }
                  }

                  if(Math.abs(var12.b()) > Math.abs(var12.a()) != var5) {
                     label187: {
                        x var10 = var0.createBend(0.0D, 0.0D, var8, 1);
                        ++var13;
                        ++var1;
                        if(var5) {
                           var10.a(var2.a, var8.c());
                           if(!var11) {
                              break label187;
                           }
                        }

                        var10.a(var8.b(), var2.b);
                     }

                     var2 = new y.d.t(var8.b(), var8.c());
                     var5 = !var5;
                  }

                  label182: {
                     if(var5) {
                        var8.a(var2.a, var8.c());
                        if(!var11) {
                           break label182;
                        }
                     }

                     var8.a(var8.b(), var2.b);
                  }

                  var2 = new y.d.t(var8.b(), var8.c());
                  var5 = !var5;
               }

               ++var13;
               if(!var11) {
                  continue;
               }
            }

            var2 = b(var0, var1 - 2);
            var3 = b(var0, var1 - 1);
            var12 = new y.d.z(var3, var2);
            double var21;
            var10000 = (var21 = var12.b() - 0.0D) == 0.0D?0:(var21 < 0.0D?-1:1);
            break;
         }

         double var18;
         if(var10000 == 0 && var5 || var12.a() == 0.0D && !var5 && var1 > 2) {
            if(var1 == 3) {
               y.d.t var17 = b(var0, var1 - 3);
               y.d.z var15 = new y.d.z(var17, var2);
               var18 = var15.a() * var12.a() + var15.b() * var12.b();
               if(var18 > 0.0D) {
                  var0.appendBend(var2.a(), var2.b());
                  ++var1;
                  var5 = !var5;
                  return var6;
               }
            }

            var0.removeBend(var0.lastBend());
            --var1;
            var2 = b(var0, var1 - 2);
            var12 = new y.d.z(var3, var2);
         }

         var19 = var12.d();

         while(true) {
            if(var19 < 3.0D) {
               var10000 = var0.bendCount();
               if(var11) {
                  break;
               }

               if(var10000 > 0) {
                  var0.removeBend(var0.lastBend());
                  --var1;
                  var2 = b(var0, var1 - 2);
                  var3 = b(var0, var1 - 1);
                  var12 = new y.d.z(var3, var2);
                  var19 = var12.d();
                  var5 = !var5;
                  if(!var11) {
                     continue;
                  }
               }
            }

            var10000 = var0.bendCount();
            break;
         }

         if(var10000 == 0) {
            if(var2.a != var3.a && var2.b != var3.b) {
               if(Math.abs(var12.a()) < Math.abs(var12.b())) {
                  var18 = (var2.b + var3.b) * 0.5D;
                  var0.appendBend(var2.a, var18);
                  var0.appendBend(var3.a, var18);
                  ++var1;
                  return false;
               } else {
                  var18 = (var2.a + var3.a) * 0.5D;
                  var0.appendBend(var18, var2.b);
                  var0.appendBend(var18, var3.b);
                  ++var1;
                  return true;
               }
            } else {
               return var6;
            }
         } else {
            if(var12.b() != 0.0D && var12.a() != 0.0D) {
               if(!var5) {
                  var0.lastBend().a(var2.a, var3.b());
                  if(!var11) {
                     return var6;
                  }
               }

               var0.lastBend().a(var3.a(), var2.b);
            }

            return var6;
         }
      } else {
         return false;
      }
   }

   private static void d(aB var0) {
      boolean var4 = fj.z;
      y.d.t var1 = var0.getSourcePoint();
      if(Double.isNaN(var1.a()) || Double.isNaN(var1.b())) {
         var0.setSourcePoint(y.d.t.c);
      }

      if(var0.bendCount() > 0) {
         y var2 = var0.bends();

         while(var2.f()) {
            x var3 = var2.a();
            if(Double.isNaN(var3.b()) || Double.isNaN(var3.c())) {
               var0.removeBend(var3);
            }

            var2.g();
            if(var4) {
               break;
            }
         }
      }

      y.d.t var5 = var0.getTargetPoint();
      if(Double.isNaN(var5.a()) || Double.isNaN(var5.b())) {
         var0.setTargetPoint(y.d.t.c);
      }

   }

   public static int a(aB var0, int var1) {
      boolean var5 = fj.z;
      if(var0.getMinBendCount() <= 0 && var0.getEdge() != null && var0.getEdge().a() != null) {
         int var2 = 1;

         int var10000;
         y.d.t var3;
         while(true) {
            if(var2 < var1 - 1) {
               var3 = b(var0, var2);
               y.d.t var4 = b(var0, var2 - 1);
               var10000 = a(var3, var4);
               if(var5) {
                  break;
               }

               if(var10000 != 0) {
                  var0.removeBend(var0.getBend(var2 - 1));
                  --var1;
                  --var2;
               }

               ++var2;
               if(!var5) {
                  continue;
               }
            }

            var10000 = var1;
            break;
         }

         if(var10000 > 2) {
            y.d.t var6 = b(var0, var1 - 1);
            var3 = b(var0, var1 - 2);
            if(a(var6, var3)) {
               var0.removeBend(var0.getBend(var1 - 3));
               --var1;
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   protected void a(x var1, double var2, double var4) {
   }

   protected void b(aB var1) {
      boolean var5 = fj.z;
      if(var1.getMinBendCount() <= 0 && var1.getEdge() != null && var1.getEdge().a() != null) {
         byte var6;
         label55: {
            label54:
            while(true) {
               int var10000;
               if(var1.bendCount() > 0) {
                  var10000 = a(b(var1, 0), b(var1, 1));
                  if(!var5) {
                     if(var10000 != 0) {
                        var1.removeBend(var1.firstBend());
                        if(!var5) {
                           continue;
                        }
                     }

                     var10000 = var1.bendCount();
                  }
               } else {
                  var10000 = var1.bendCount();
               }

               while(true) {
                  if(var10000 <= 0) {
                     break label54;
                  }

                  var6 = a(b(var1, var1.bendCount()), b(var1, var1.bendCount() + 1));
                  if(var5) {
                     break label55;
                  }

                  if(var6 == 0) {
                     break label54;
                  }

                  var1.removeBend(var1.lastBend());
                  if(var5) {
                     break label54;
                  }

                  var10000 = var1.bendCount();
               }
            }

            var6 = 1;
         }

         int var2 = var6;

         while(var2 < var1.bendCount()) {
            y.d.t var3 = b(var1, var2);
            y.d.t var4 = b(var1, var2 + 1);
            if(a(var3, var4)) {
               var1.removeBend(var1.getBend(var2));
               var1.removeBend(var1.getBend(var2 - 1));
               --var2;
            }

            ++var2;
            if(var5) {
               break;
            }
         }

      }
   }

   static void a(bu var0, Collection var1) {
      boolean var4 = fj.z;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         y.c.d var3 = (y.c.d)var2.next();
         c(var0.i(var3));
         if(var4) {
            break;
         }
      }

   }

   static void c(aB var0) {
      bu var1 = var0.i();
      if(var0.bendCount() > 0 && var0.getEdge() != null && var0.getEdge().a() != null) {
         y.c.d var2 = var0.getEdge();
         fj var3 = var0.getSourceRealizer();

         while(var0.bendCount() > var0.getMinBendCount() && var3.contains(var0.firstBend().b(), var0.firstBend().c())) {
            var1.c(var2, var0.firstBend().e());
            if(var0.removeBend(var0.firstBend()) == null) {
               break;
            }
         }

         fj var4 = var0.getTargetRealizer();

         while(var0.bendCount() > var0.getMinBendCount() && var4.contains(var0.lastBend().b(), var0.lastBend().c())) {
            var1.d(var2, var0.lastBend().e());
            if(null == var0.removeBend(var0.lastBend())) {
               break;
            }
         }
      }

   }

   private static boolean a(y.d.t var0, y.d.t var1) {
      return var0 == var1 || Double.compare(var0.a(), var1.a()) == 0 && Double.compare(var0.b(), var1.b()) == 0;
   }

   static y.c.o a(fu var0) {
      return var0.n;
   }

   static y.c.o a(fu var0, y.c.o var1) {
      return var0.n = var1;
   }

   static fz b(fu var0) {
      return var0.j;
   }

   static aB c(fu var0) {
      return var0.a;
   }

   static void d(fu var0) {
      var0.g();
   }

   static y.d.t e(fu var0) {
      return var0.i;
   }
}
