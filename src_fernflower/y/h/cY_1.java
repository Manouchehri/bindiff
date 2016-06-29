package y.h;

import java.util.Iterator;
import y.h.U;
import y.h.bu;
import y.h.cW;
import y.h.cZ;
import y.h.cg;
import y.h.ch;
import y.h.eR;
import y.h.eU;
import y.h.fM;
import y.h.fj;
import y.h.ft;
import y.h.gY;

public class cY implements cZ {
   private ch a;

   public cY(ch var1) {
      this.a = var1;
   }

   public cW a(double var1, double var3, int var5, boolean var6) {
      cW var7 = this.a(this.a(), this.b(), var1, var3, var5, var6);
      if(var6 && (var5 & 16) != 0 && var7.s() && !var7.l().isSelected()) {
         eR var8;
         fj var9;
         eU var10;
         if((var5 & 1) != 0 && (var5 & 64) != 0) {
            var8 = var7.l();
            var9 = var8.g();
            if(var9 != null) {
               if(var8.a() instanceof fM) {
                  var10 = fM.a(var9, var8.getModelParameter());
                  if(var10 != null && var10.f() && var10.a(var1, var3)) {
                     return a(var10);
                  }

                  if(var9.getNode() != null && var9.contains(var1, var3)) {
                     return a(var9.getNode());
                  }
               } else if(var9.getNode() != null && var9.contains(var1, var3)) {
                  return a(var9.getNode());
               }
            }
         } else if((var5 & 1) != 0) {
            var8 = var7.l();
            var9 = var8.g();
            if(var9 != null && var9.getNode() != null && var9.contains(var1, var3)) {
               return a(var9.getNode());
            }
         } else if((var5 & 64) != 0) {
            var8 = var7.l();
            var9 = var8.g();
            if(var9 != null && var8.a() instanceof fM) {
               var10 = fM.a(var9, var8.getModelParameter());
               if(var10 != null && var10.f() && var10.a(var1, var3)) {
                  return a(var10);
               }
            }
         }
      }

      return var7;
   }

   protected cW a(ch var1, bu var2, double var3, double var5, int var7, boolean var8) {
      Iterator var9 = a(var1, var2, var7);
      return new cW(var2, var9, var3, var5, var8);
   }

   protected ch a() {
      return this.a;
   }

   protected bu b() {
      return this.a().getGraph2D();
   }

   private static Iterator a(ch var0, bu var1, int var2) {
      Object var3;
      label20: {
         if(var0.getGraph2DRenderer() instanceof ft) {
            ft var4 = (ft)var0.getGraph2DRenderer();
            var3 = var0.getZoom() >= var0.getPaintDetailThreshold()?var4.getPaintOrder():var4.getSloppyPaintOrder();
            if(!fj.z) {
               break label20;
            }
         }

         var3 = new U();
      }

      if(!Boolean.TRUE.equals(var0.getClientProperty("Graph2DView.hitTestInvisibleElements"))) {
         byte var5 = 1;
         return new y.g.A(((cg)var3).b(var1, var2), new gY(var1, var5, var5, var5, var5));
      } else {
         return ((cg)var3).b(var1, var2);
      }
   }

   private static cW a(y.c.q var0) {
      cW var1 = new cW();
      var1.a(var0);
      return var1;
   }

   private static cW a(eU var0) {
      cW var1 = new cW();
      var1.a(var0);
      return var1;
   }
}
