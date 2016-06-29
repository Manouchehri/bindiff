package y.f.i.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ai;

public class ah {
   private List a;
   private M b;
   private ai c;
   private int d;

   public ah(M var1, List var2) {
      this.b = var1;
      this.a = var2;
   }

   public M a() {
      return this.b;
   }

   void a(M var1) {
      this.b = var1;
   }

   public List b() {
      return this.a;
   }

   public ai c() {
      return this.c;
   }

   void d() {
      int var18 = ab.a;
      ai var1 = (ai)this.a.get(0);
      int var2 = var1.j();
      y.f.y var3 = var1.h();
      byte var4 = var1.d();
      boolean var5 = true;
      double var6 = Double.MAX_VALUE;
      double var8 = -1.7976931348623157E308D;
      double var10 = Double.MAX_VALUE;
      double var12 = -1.7976931348623157E308D;
      Iterator var14 = this.a.iterator();

      while(true) {
         if(var14.hasNext()) {
            ai var15 = (ai)var14.next();
            var5 &= var4 == var15.d();
            M var16 = var15.a();
            if(var16 != null && var6 > var16.a()) {
               var6 = var16.a();
            }

            if(var16 != null && var8 < var16.b()) {
               var8 = var16.b();
            }

            M var17 = var15.b();
            if(var10 > var17.a()) {
               var10 = var17.a();
            }

            if(var12 >= var17.b()) {
               continue;
            }

            var12 = var17.b();
            if(var18 != 0) {
               break;
            }

            if(var18 == 0) {
               continue;
            }
         }

         this.c = new ai((y.c.d)null, var2, var3, this.b, var6 < var8?new M(var6, var8):null, new M(var10, var12), Collections.EMPTY_LIST);
         this.c.a(var1.k());
         break;
      }

      if(var5) {
         this.c.a(var4);
      }

      this.d = super.hashCode();
   }

   public int hashCode() {
      return this.d;
   }
}
