package com.google.security.zynamics.zylib.yfileswrap.yfiles;

import com.google.common.base.Preconditions;
import java.awt.geom.Rectangle2D.Double;
import y.c.d;
import y.c.e;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.ae;
import y.h.bu;
import y.h.a.v;

public final class YHelpers {
   public static void closeGroup(bu var0, q var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Group node argument can not be null");
      v var2 = var0.C();
      double var3 = var0.p(var1);
      double var5 = var0.q(var1);
      y var7 = new y();
      var7.add(var1);
      var0.r();
      x var8 = var7.a();

      while(var8.f()) {
         var2.e(var8.e());
         var8.g();
      }

      var0.s();
      if(var3 != var0.p(var1) || var5 != var0.q(var1)) {
         e var9 = var1.l();

         while(var9.f()) {
            var0.a((d)var9.a(), (t)t.c);
            var9.g();
         }

         var9 = var1.k();

         while(var9.f()) {
            var0.b(var9.a(), t.c);
            var9.g();
         }
      }

      var0.T();
   }

   public static void openFolder(bu var0, q var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Error: Folder node argument can not be null");
      v var2 = var0.C();
      double var3 = var0.p(var1);
      double var5 = var0.q(var1);
      y var7 = new y();
      var7.add(var1);
      var0.r();
      x var8 = var7.a();

      while(var8.f()) {
         bu var9 = (bu)var2.m(var8.e());
         t var10 = var0.o(var8.e());
         y var11 = new y(var9.o());
         var2.f(var8.e());
         Double var12 = var0.t(var8.e()).getBoundingBox();
         ae.a(var0, (x)var11.a(), var10.a - var12.x, var10.b - var12.y);
         var8.g();
      }

      var0.s();
      var0.N();
      var8 = var7.a();

      while(var8.f()) {
         var0.a(var8.e(), true);
         var8.g();
      }

      if(var3 != var0.p(var1) || var5 != var0.q(var1)) {
         e var13 = var1.l();

         while(var13.f()) {
            var0.a((d)var13.a(), (t)t.c);
            var13.g();
         }

         var13 = var1.k();

         while(var13.f()) {
            var0.b(var13.a(), t.c);
            var13.g();
         }
      }

      var0.T();
   }
}
