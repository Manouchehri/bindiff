package com.google.security.zynamics.bindiff.graph.layout.util;

import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$1;
import com.google.security.zynamics.bindiff.graph.layout.util.CustomizedPCListOptimizer$EdgeOrderComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.aE;
import y.f.ax;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.br;
import y.g.M;

public class CustomizedPCListOptimizer implements br {
   private boolean backloopRouting = false;

   private static boolean isBackwardEdge(d var0, A var1) {
      return var1.a(var0.c()) > var1.a(var0.d());
   }

   private void assignEdgePorts(q var1, f var2, X var3, boolean var4, aP var5) {
      f var6 = new f();
      f var7 = new f();
      f var8 = new f();

      double var11;
      for(e var9 = var2.a(); var9.f(); var9.g()) {
         d var10 = var9.a();
         var11 = var4?var3.n(var10).a():var3.o(var10).a();
         if(var11 < 0.0D) {
            var6.add(var10);
         } else if(var11 > 0.0D) {
            var8.add(var10);
         } else {
            var7.add(var10);
         }
      }

      double var13 = var3.p(var1) * 0.5D;
      var11 = var13 / 3.0D;
      this.distributeEdges(var6, -var13, -var11, var1, var3, var5, var4);
      this.distributeEdges(var7, -var11, var11, var1, var3, var5, var4);
      this.distributeEdges(var8, var11, var13, var1, var3, var5, var4);
   }

   private void distributeEdges(f var1, double var2, double var4, q var6, X var7, aP var8, boolean var9) {
      double var10 = var7.q(var6) * 0.5D;
      double var12 = (var4 - var2) / (double)(var1.size() + 1);
      double var14 = var2 + var12;

      for(e var16 = var1.a(); var16.f(); var14 += var12) {
         d var17 = var16.a();
         if(var9) {
            var7.a(var17, new t(var14, var10));
         } else {
            var7.b(var17, new t(var14, -var10));
         }

         int var18 = var9?2:1;
         var8.a(var17, var9, aE.a((byte)var18, true));
         var16.g();
      }

   }

   private ax getCandidateWithDirection(Collection var1, byte var2) {
      if(var1 == null) {
         return null;
      } else {
         Iterator var3 = var1.iterator();

         ax var4;
         do {
            if(!var3.hasNext()) {
               return null;
            }

            var4 = (ax)var3.next();
         } while(var4.a() != var2);

         return var4;
      }
   }

   private aE transformToPortConstraint(ax var1, d var2, boolean var3, X var4) {
      if(var1.b()) {
         t var5 = new t(var1.c(), var1.d());
         if(var3) {
            var4.a(var2, var5);
         } else {
            var4.b(var2, var5);
         }
      }

      return var1.e();
   }

   public boolean isBackloopRouting() {
      return this.backloopRouting;
   }

   public void optimizeAfterLayering(X var1, aU var2, aV var3, aP var4) {
      A var5 = M.a();

      for(int var6 = 0; var6 < var2.b(); ++var6) {
         aQ var7 = var2.a(var6);
         x var8 = var7.d().a();

         while(var8.f()) {
            var5.a(var8.e(), var6);
            var8.g();
         }
      }

      for(e var13 = var1.p(); var13.f(); var13.g()) {
         d var14 = var13.a();
         if(!var14.e()) {
            y.f.c.a.A var15 = var3.a(var14);
            int var9 = !this.backloopRouting && isBackwardEdge(var14, var5)?1:2;
            ax var10 = this.getCandidateWithDirection(var15.d(), (byte)var9);
            if(var10 != null) {
               var4.a(var14, true, this.transformToPortConstraint(var10, var14, true, var1));
            } else {
               var4.a(var14, true, aE.a((byte)var9));
            }

            int var11 = !this.backloopRouting && isBackwardEdge(var14, var5)?2:1;
            ax var12 = this.getCandidateWithDirection(var15.f(), (byte)var11);
            if(var12 != null) {
               var4.a(var14, false, this.transformToPortConstraint(var12, var14, false, var1));
            } else {
               var4.a(var14, false, aE.a((byte)var11));
            }
         }
      }

   }

   public void optimizeAfterSequencing(X var1, aU var2, aV var3, aP var4) {
      ArrayList var5 = new ArrayList(64);
      A var6 = M.a();
      int var7 = 0;
      x var8 = var1.o();

      while(var8.f()) {
         aX var9 = var3.a(var8.e());
         var7 += var9.e();
         var8.g();
      }

      int var20 = var1.e();
      d[] var21 = new d[var7 / 2];
      int var10 = 2;

      int var11;
      for(var11 = 0; var11 < var2.b(); ++var11) {
         aQ var12 = var2.a(var11);

         for(p var13 = var12.d().k(); var13 != null; var13 = var13.a()) {
            q var14 = (q)var13.c();
            aX var15 = var3.a(var14);
            if(var15.e() > 0) {
               for(p var16 = var15.d(); var16 != null; var16 = var16.a()) {
                  d var17 = (d)var16.c();
                  if(var17.c() == var14) {
                     q var18 = var1.d();
                     var6.a(var18, true);
                     y.f.c.a.A var19 = var3.a(var17);
                     var5.add(var18);
                     if(var19.j()) {
                        var4.b(var18, var14, var17, false, true);
                        var4.a(var18, var17.d(), var17, false, true);
                        var10 = Math.max(var10, var17.d().b());
                     } else {
                        var4.a(var14, var18, var17, true, false);
                        var4.b(var17.d(), var18, var17, true, false);
                        var10 = Math.max(var10, var17.d().c());
                     }

                     var10 = Math.max(2, var10);
                     var21[var18.d() - var20] = var17;
                  }
               }
            }

            var10 = Math.max(var10, Math.max(var14.b(), var14.c()));
         }
      }

      q var23;
      for(x var22 = var1.o(); var22.f(); var22.g()) {
         var23 = var22.e();
         if(!var6.d(var23) && var3.a(var23).b() == 0) {
            f var24 = new f(var23.k());
            var24.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, var6, var23, var3, (CustomizedPCListOptimizer$1)null));
            this.assignEdgePorts(var23, var24, var1, false, var4);
            f var26 = new f(var23.l());
            var26.sort(new CustomizedPCListOptimizer$EdgeOrderComparator(this, var6, var23, var3, (CustomizedPCListOptimizer$1)null));
            this.assignEdgePorts(var23, var26, var1, true, var4);
         }
      }

      for(var11 = 0; var11 < var5.size(); ++var11) {
         var23 = (q)var5.get(var11);
         d var25 = var21[var23.d() - var20];
         var1.e(var25);
         y.f.c.a.A var27 = var3.a(var25);
         d var28;
         d var29;
         y.f.c.a.A var30;
         y.f.c.a.A var31;
         if(var23.c() > 0) {
            var28 = var23.f();
            var29 = var23.h();
            var30 = var3.a(var28);
            var31 = var3.a(var29);
            if(var28.d() == var25.c()) {
               if(var30.e() != var27.c()) {
                  var27 = var4.a(var25, true, var30.e());
               }

               if(var31.e() != var27.e()) {
                  var4.a(var25, false, var31.e());
               }

               var1.a(var25, var1.o(var28));
               var1.b(var25, var1.o(var29));
            } else {
               if(var31.e() != var27.c()) {
                  var27 = var4.a(var25, true, var31.e());
               }

               if(var30.e() != var27.e()) {
                  var4.a(var25, false, var30.e());
               }

               var1.a(var25, var1.o(var29));
               var1.b(var25, var1.o(var28));
            }
         } else {
            var28 = var23.g();
            var29 = var23.i();
            var30 = var3.a(var28);
            var31 = var3.a(var29);
            if(var28.c() == var25.c()) {
               if(var30.c() != var27.c()) {
                  var27 = var4.a(var25, true, var30.c());
               }

               if(var31.c() != var27.e()) {
                  var4.a(var25, false, var31.c());
               }

               var1.a(var25, var1.n(var28));
               var1.b(var25, var1.n(var29));
            } else {
               if(var31.c() != var27.c()) {
                  var27 = var4.a(var25, true, var31.c());
               }

               if(var30.c() != var27.e()) {
                  var4.a(var25, false, var30.c());
               }

               var1.a(var25, var1.n(var29));
               var1.b(var25, var1.n(var28));
            }
         }

         var1.d(var25);
      }

      for(var11 = 0; var11 < var5.size(); ++var11) {
         var23 = (q)var5.get(var11);
         var1.a((q)var23);
      }

   }

   public void setBackloopRouting(boolean var1) {
      this.backloopRouting = var1;
   }
}
