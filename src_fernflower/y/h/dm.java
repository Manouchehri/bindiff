package y.h;

import java.awt.Rectangle;
import java.util.Map;
import java.util.WeakHashMap;
import y.h.bu;
import y.h.fj;

final class dm implements y.f.O {
   private final Map a;
   private final Map b;
   private final bu c;
   private final y.f.O d;

   dm(bu var1, y.f.O var2) {
      boolean var4 = fj.z;
      super();
      this.c = var1;
      this.d = var2;
      this.a = new WeakHashMap();
      y.c.x var3 = var1.o();

      while(true) {
         if(var3.f()) {
            this.a.put(var3.e(), (Object)null);
            var3.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         this.b = new WeakHashMap();
         break;
      }

      y.c.e var5 = var1.p();

      while(var5.f()) {
         this.b.put(var5.a(), (Object)null);
         var5.g();
         if(var4) {
            break;
         }
      }

   }

   public y.f.am a(Object var1) {
      if(this.a.containsKey(var1)) {
         try {
            return this.d.a(var1);
         } catch (NullPointerException var3) {
            return this.c.a((Object)var1);
         }
      } else {
         return this.c.a((Object)var1);
      }
   }

   public y.f.I b(Object var1) {
      if(this.b.containsKey(var1)) {
         try {
            return this.d.b(var1);
         } catch (NullPointerException var3) {
            return this.c.b((Object)var1);
         }
      } else {
         return this.c.b((Object)var1);
      }
   }

   public y.f.aj[] a_(Object var1) {
      if(this.a.containsKey(var1)) {
         try {
            return this.d.a_(var1);
         } catch (NullPointerException var3) {
            return this.c.a_(var1);
         }
      } else {
         return this.c.a_(var1);
      }
   }

   public y.f.C[] d(Object var1) {
      if(this.b.containsKey(var1)) {
         try {
            return this.d.d(var1);
         } catch (NullPointerException var3) {
            return this.c.d(var1);
         }
      } else {
         return this.c.d(var1);
      }
   }

   public Rectangle a() {
      boolean var3 = fj.z;
      Rectangle var1 = this.d.a();
      y.c.x var2 = this.c.o();

      dm var10000;
      while(true) {
         if(var2.f()) {
            var10000 = this;
            if(var3) {
               break;
            }

            if(!this.a.containsKey(var2.e())) {
               this.c.t(var2.e()).calcUnionRect(var1);
            }

            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var4 = var10000.c.p();

      while(var4.f()) {
         if(!this.b.containsKey(var4.a())) {
            this.c.i(var4.a()).calcUnionRect(var1);
         }

         var4.g();
         if(var3) {
            break;
         }
      }

      return var1;
   }
}
