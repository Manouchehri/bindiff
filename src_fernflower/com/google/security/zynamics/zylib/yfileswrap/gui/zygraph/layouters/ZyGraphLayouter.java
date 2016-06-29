package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.CircularStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicOrientation;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.OrthogonalStyle;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters.ZyGraphLayouter$1;
import y.f.aN;
import y.f.an;
import y.f.c;
import y.f.a.a;
import y.f.a.f;
import y.f.c.K;
import y.f.c.M;
import y.f.c.b;
import y.f.c.d;
import y.f.c.v;
import y.f.c.a.B;
import y.f.c.a.aY;
import y.f.c.a.bs;
import y.f.k.o;
import y.h.bu;

public class ZyGraphLayouter {
   public static void alignNodesToTopLayer(bu var0, c var1) {
      if(var1 instanceof K) {
         K var2 = (K)var1;
         var2.c((byte)1);
         an var3 = (an)var2.g();
         var2.a((v)(new b(var2.o())));
         var0.a((Object)b.a, (y.c.c)(var3.b() == 0?new d():new y.f.c.c()));
      } else if(var1 instanceof M) {
         M var4 = (M)var1;
         var4.b((byte)1);
         var4.E().a(0.0D);
      }

   }

   public static c createCircularLayouter(CircularStyle var0, long var1) {
      Preconditions.checkNotNull(var0, "Internal Error: Layout style can\'t be null");
      Preconditions.checkArgument(var1 >= 0L, "Internal Error: Minimum node distance can\'t be negative");
      a var3 = new a();
      switch(ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[var0.ordinal()]) {
      case 1:
         var3.b((byte)0);
         break;
      case 2:
         var3.b((byte)1);
         break;
      case 3:
         var3.b((byte)3);
         break;
      default:
         throw new IllegalStateException("Internal Error: Unknown layout style");
      }

      var3.c((byte)0);
      f var4 = var3.n();
      var4.h(true);
      var4.a((int)var1);
      o var5 = var3.o();
      var5.b((int)var1);
      var5.h(false);
      return var3;
   }

   public static c createHierarchicalLayouter(HierarchicStyle var0, long var1, long var3, long var5, long var7, HierarchicOrientation var9) {
      Preconditions.checkNotNull(var0, "Internal Error: Layout style can\'t be null");
      Preconditions.checkArgument(var1 >= 0L, "Internal Error: Minimum layer distance can\'t be negative");
      Preconditions.checkArgument(var3 >= 0L, "Internal Error: Minimum node distance can\'t be negative");
      Preconditions.checkArgument(var5 >= 0L, "Internal Error: Minimum edge distance can\'t be negative");
      M var10 = new M();
      var10.c((byte)1);
      var10.k(true);
      var10.g(true);
      var10.a((byte)(var9 == HierarchicOrientation.HORIZONTAL?0:1));
      var10.h(true);
      B var11 = var10.C();
      var11.a(true);
      var11.b(true);
      var11.a(25.0D);
      var11.b(25.0D);
      aY var12 = var10.E();
      var12.a(0.0D);
      aN var13 = new aN(var10);
      var13.a(true);
      switch(ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[var0.ordinal()]) {
      case 1:
         setStyle((byte)1, (byte)1, true, var10, var11);
         break;
      case 2:
         setStyle((byte)1, (byte)0, true, var10, var11);
         break;
      case 3:
         setStyle((byte)1, (byte)2, false, var10, var11);
         break;
      case 4:
         setStyle((byte)0, (byte)1, true, var10, var11);
         break;
      case 5:
         setStyle((byte)0, (byte)0, true, var10, var11);
         break;
      case 6:
         setStyle((byte)0, (byte)2, true, var10, var11);
         break;
      case 7:
         setStyle((byte)2, (byte)1, true, var10, var11);
         break;
      case 8:
         setStyle((byte)2, (byte)0, true, var10, var11);
         break;
      case 9:
         setStyle((byte)2, (byte)2, true, var10, var11);
         break;
      case 10:
         setStyle((byte)4, (byte)1, true, var10, var11);
         break;
      case 11:
         setStyle((byte)4, (byte)0, true, var10, var11);
         break;
      case 12:
         setStyle((byte)4, (byte)2, false, var10, var11);
         break;
      default:
         throw new IllegalStateException("Internal Error: Unknown layout style");
      }

      var10.a((double)var1);
      var10.b((double)var3);
      var10.c((double)var5);
      var10.d((double)var7);
      return var10;
   }

   private static void setStyle(byte var0, byte var1, boolean var2, M var3, B var4) {
      var3.b(var0);
      var3.i(var2);
      var4.a(new bs(var1));
   }

   public static c createIncrementalHierarchicalLayouter(boolean var0, long var1, long var3, HierarchicOrientation var5) {
      M var6 = new M();
      an var7 = (an)var6.g();
      var7.a((byte)(var5 == HierarchicOrientation.HORIZONTAL?0:1));
      var6.a((double)var1);
      var6.b((double)var3);
      var6.d(25.0D);
      var6.c(25.0D);
      var6.h(true);
      var6.b(true);
      var6.i(var0);
      return var6;
   }

   public static c createOrthoLayouter(OrthogonalStyle var0, long var1, boolean var3) {
      Preconditions.checkArgument(var1 > 0L, "Internal Error: Grid size can not be 0 or lower.");
      Preconditions.checkNotNull(var0, "Internal Error: Layout style can\'t be null");
      y.f.f.c var4 = new y.f.f.c();
      var4.b(var0 == OrthogonalStyle.NORMAL?0:4);
      an var5 = (an)var4.g();
      var5.a((byte)(var3?0:1));
      var4.a((int)var1);
      return var4;
   }
}
