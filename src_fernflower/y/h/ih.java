package y.h;

import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import y.h.aA;
import y.h.bu;
import y.h.ch;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

class ih {
   private Map a;

   void a(bu var1, y.c.q var2) {
      boolean var5 = fj.z;
      this.a = null;
      y.h.a.v var3 = var1.C();
      if(var3 != null) {
         y.c.q var4 = var3.n(var2);

         while(var4 != null) {
            if(this.a == null) {
               this.a = new LinkedHashMap();
            }

            this.a.put(var4, var1.t(var4).getBoundingBox());
            var4 = var3.n(var4);
            if(var5) {
               break;
            }
         }
      }

   }

   void a(bu var1) {
      boolean var16 = fj.z;
      if(this.a != null) {
         Iterator var2 = this.a.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            fj var4 = var1.t((y.c.q)var3.getKey());
            y.h.a.a var5 = var4.getAutoBoundsFeature();
            if(var5 != null) {
               Rectangle2D var6 = (Rectangle2D)var3.getValue();
               Rectangle2D var7 = var5.getMinimalAutoBounds();
               double var8 = Math.max(0.0D, var7.getX() - var6.getX());
               double var10 = Math.max(0.0D, var7.getY() - var6.getY());
               double var12 = Math.max(0.0D, var6.getMaxX() - var7.getMaxX());
               double var14 = Math.max(0.0D, var6.getMaxY() - var7.getMaxY());
               var5.setAutoBoundsInsets(new y.d.r(var10, var8, var14, var12));
               if(var16) {
                  break;
               }
            }
         }
      }

   }

   void a() {
      this.a = null;
   }

   void b(bu var1, y.c.q var2) {
      boolean var6 = fj.z;
      y.c.y var3 = new y.c.y(var2);
      y.h.a.v var4 = var1.C();
      if(var4 != null) {
         y.c.q var5 = var4.n(var2);

         while(var5 != null) {
            var3.add(var5);
            var5 = var4.n(var5);
            if(var6) {
               return;
            }

            if(var6) {
               break;
            }
         }
      }

      var1.a(var3.a());
   }

   void a(bu var1, y.c.d var2) {
      var1.a((new y.c.f(var2)).a());
   }

   void a(ch var1, gZ var2) {
      if(var2 instanceof eR) {
         this.a(var1, ((eR)var2).f());
         if(!fj.z) {
            return;
         }
      }

      if(var2 instanceof aA) {
         this.a(var1, ((aA)var2).getEdge());
      }

   }

   void a(ch var1, y.c.q var2) {
      this.a(var1, (new y.c.y(var2)).a(), (y.c.e)null);
   }

   void a(ch var1, y.c.d var2) {
      this.a(var1, (y.c.x)null, (new y.c.f(var2)).a());
   }

   void a(ch var1, y.c.x var2, y.c.e var3) {
      boolean var8 = fj.z;
      bu var4 = var1.getGraph2D();
      var4.b((byte)1);
      if(var2 != null && var2.f()) {
         label70: {
            y.h.a.v var5 = var4.C();
            if(var5 == null) {
               do {
                  if(!var2.f()) {
                     break label70;
                  }

                  var4.t(var2.e()).setLayer((byte)0);
                  var2.g();
                  if(var8) {
                     return;
                  }
               } while(!var8);
            }

            HashSet var6 = new HashSet();
            var6.add((Object)null);

            while(var2.f()) {
               y.c.q var7 = var2.e();

               label51: {
                  while(var6.add(var7)) {
                     var4.t(var7).setLayer((byte)0);
                     var7 = var5.n(var7);
                     if(var8) {
                        break label51;
                     }

                     if(var8) {
                        break;
                     }
                  }

                  var2.g();
               }

               if(var8) {
                  break;
               }
            }
         }
      }

      if(var3 != null && var3.f()) {
         while(var3.f()) {
            var4.i(var3.a()).setLayer((byte)0);
            var3.g();
            if(var8) {
               return;
            }

            if(var8) {
               break;
            }
         }
      }

      var1.setDrawingMode(3);
   }
}
