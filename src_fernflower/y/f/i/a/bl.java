package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import y.f.i.a.ab;

class bl {
   static final Object a = "y.layout.router.polyline.NodePortsInfo.NODE_PORTS_INFO_DPKEY";
   private final Map b;
   private y.f.ay c;

   private bl(y.f.ay var1) {
      this.c = var1;
      this.b = new HashMap();
   }

   public static bl a(y.c.q var0) {
      y.c.b var1 = (y.c.b)var0.e().c(a);
      bl var2 = var1 != null?(bl)var1.b(var0):null;
      if(var2 == null) {
         y.c.c var3 = var0.e().c(y.f.ay.a);
         if(var3 != null) {
            y.f.ay var4 = (y.f.ay)var3.b(var0);
            if(var4 != null) {
               var2 = new bl(var4);
               if(var1 != null) {
                  var1.a(var0, var2);
               }
            }
         }
      }

      return var2;
   }

   public List a() {
      int var6 = ab.a;
      ArrayList var1 = new ArrayList();
      if(this.c != null) {
         Iterator var2 = this.c.a();

         do {
            y.f.aA var3;
            y.f.ax var4;
            Integer var5;
            do {
               if(!var2.hasNext()) {
                  return var1;
               }

               var3 = (y.f.aA)var2.next();
               var4 = var3.a();
               var5 = (Integer)this.b.get(var4);
            } while(var5 != null && var3.b() <= var5.intValue());

            var1.add(var4);
         } while(var6 == 0);
      }

      return var1;
   }

   public List b() {
      int var6 = ab.a;
      ArrayList var1 = new ArrayList();
      if(this.c != null) {
         Iterator var2 = this.c.a();

         while(var2.hasNext()) {
            y.f.aA var3 = (y.f.aA)var2.next();
            y.f.ax var4 = var3.a();
            Integer var5 = (Integer)this.b.get(var4);
            if(var5 != null && var3.b() <= var5.intValue()) {
               var1.add(var4);
               if(var6 != 0) {
                  break;
               }
            }
         }
      }

      return var1;
   }

   public void a(y.f.ax var1) {
      if(this.b.containsKey(var1)) {
         Integer var2 = (Integer)this.b.get(var1);
         this.b.put(var1, new Integer(var2.intValue() + 1));
         if(ab.a == 0) {
            return;
         }
      }

      this.b.put(var1, new Integer(1));
   }
}
