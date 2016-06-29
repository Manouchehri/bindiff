package y.f;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y.f.C;
import y.f.I;
import y.f.O;
import y.f.X;
import y.f.aj;
import y.f.am;

public class v implements O {
   Map a = new HashMap();
   Map b = new HashMap();
   Map c = new HashMap();

   public void a(Object var1, am var2) {
      this.a.put(var1, var2);
   }

   public void a(Object var1, I var2) {
      this.b.put(var1, var2);
   }

   public I b(Object var1) {
      return (I)this.b.get(var1);
   }

   public am a(Object var1) {
      return (am)this.a.get(var1);
   }

   public aj[] a_(Object var1) {
      return (aj[])this.c.get(var1);
   }

   public C[] d(Object var1) {
      return (C[])this.c.get(var1);
   }

   public Rectangle a() {
      boolean var19 = X.j;
      double var3 = Double.MAX_VALUE;
      double var1 = Double.MAX_VALUE;
      double var7 = -1.7976931348623157E308D;
      double var5 = -1.7976931348623157E308D;
      Iterator var9 = this.a.values().iterator();

      while(true) {
         if(var9.hasNext()) {
            am var10 = (am)var9.next();
            double var11 = var10.getX();
            double var13 = var10.getY();
            double var15 = var10.getWidth();
            double var17 = var10.getHeight();
            var1 = Math.min(var11, var1);
            var3 = Math.min(var13, var3);
            var5 = Math.max(var11 + var15, var5);
            var7 = Math.max(var13 + var17, var7);
            if(var19) {
               break;
            }

            if(!var19) {
               continue;
            }
         }

         var9 = this.b.values().iterator();
         break;
      }

      label36:
      while(true) {
         if(var9.hasNext()) {
            I var20 = (I)var9.next();
            int var21 = 0;

            do {
               if(var21 >= var20.pointCount()) {
                  continue label36;
               }

               y.d.t var12 = var20.getPoint(var21);
               var1 = Math.min(var12.a(), var1);
               var3 = Math.min(var12.b(), var3);
               var5 = Math.max(var12.a(), var5);
               var7 = Math.max(var12.b(), var7);
               ++var21;
               if(var19) {
                  break;
               }

               if(var19) {
                  return new Rectangle((int)var1, (int)var3, (int)(var5 - var1), (int)(var7 - var3));
               }
            } while(!var19);
         }

         if(var1 == Double.MAX_VALUE && var3 == Double.MAX_VALUE) {
            return new Rectangle(0, 0, -1, -1);
         }

         var1 = Math.floor(var1);
         var3 = Math.floor(var3);
         var5 = Math.ceil(var5);
         var7 = Math.ceil(var7);
         return new Rectangle((int)var1, (int)var3, (int)(var5 - var1), (int)(var7 - var3));
      }
   }
}
