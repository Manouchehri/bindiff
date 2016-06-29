package y.h;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import y.h.az;
import y.h.ep;
import y.h.ew;
import y.h.fj;

class eb implements az {
   private int a;
   private int b;
   private float c;
   private final y.d.t d;
   private final ep e;

   eb(ep var1, y.d.t var2) {
      this.e = var1;
      this.d = var2;
      this.a = 1;
      this.b = 3;
      this.c = 2.0F;
   }

   public void a(Graphics2D var1) {
      boolean var18 = fj.z;
      Stroke var2 = var1.getStroke();
      var1.setStroke(new BasicStroke(this.c));
      int var3 = 0;

      label48:
      while(true) {
         int var10000 = var3;

         label45:
         while(var10000 < ep.a(this.e).size()) {
            ew var4 = (ew)ep.a(this.e).get(var3);
            y.d.t var5 = var4.a(this.d.a - ep.b(this.e).a, this.d.b - ep.b(this.e).b);
            double var6 = var5.a();
            double var8 = var5.b();
            double var10 = var4.c() / 2.0D + 15.0D;
            double var12 = var4.d() / 2.0D + 15.0D;
            if(var18) {
               return;
            }

            int var14 = -this.a;

            while(var14 <= this.a) {
               int var15 = (int)(var6 + (double)var14 * var10);
               var10000 = -this.a;
               if(var18) {
                  continue label45;
               }

               int var16 = var10000;

               while(true) {
                  if(var16 <= this.a) {
                     int var17 = (int)(var8 + (double)var16 * var12);
                     var1.drawLine(var15, var17 - this.b, var15, var17 + this.b);
                     var1.drawLine(var15 - this.b, var17, var15 + this.b, var17);
                     ++var16;
                     if(var18) {
                        break;
                     }

                     if(!var18) {
                        continue;
                     }
                  }

                  ++var14;
                  break;
               }

               if(var18) {
                  break;
               }
            }

            ++var3;
            if(!var18) {
               continue label48;
            }
            break;
         }

         var1.setStroke(var2);
         return;
      }
   }

   public Rectangle getBounds() {
      boolean var10 = fj.z;
      Rectangle var1 = new Rectangle();
      int var2 = 0;

      Rectangle var10000;
      while(true) {
         if(var2 < ep.a(this.e).size()) {
            ew var3 = (ew)ep.a(this.e).get(var2);
            y.d.t var4 = var3.a(this.d.a - ep.b(this.e).a, this.d.b - ep.b(this.e).b);
            int var5 = (int)(var4.a() - (double)this.a * var3.c() / 2.0D - 15.0D);
            int var6 = (int)(var4.b() - (double)this.a * var3.d() / 2.0D - 15.0D);
            int var7 = (int)((double)(this.a + 1) * var3.c() + (double)(2 * this.b));
            int var8 = (int)((double)(this.a + 1) * var3.d() + (double)(2 * this.b));
            Rectangle var9 = new Rectangle(var5 - this.b, var6 - this.b, var7, var8);
            var9.grow(this.b, this.b);
            var10000 = var1;
            if(var10) {
               break;
            }

            label19: {
               if(var1.getWidth() < 0.0D) {
                  var1 = var9;
                  if(!var10) {
                     break label19;
                  }
               }

               var1 = var1.union(var9);
            }

            ++var2;
            if(!var10) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }
}
