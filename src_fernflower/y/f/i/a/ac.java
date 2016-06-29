package y.f.i.a;

import java.util.HashMap;
import y.f.i.a.U;
import y.f.i.a.Z;
import y.f.i.a.w;

public class ac {
   private final Z a;
   private final y.c.h b;
   private final HashMap c;
   private final y.c.h d;
   private final y.c.h e;
   private boolean f;

   public ac(Z var1) {
      this.a = var1;
      this.b = y.g.M.b();
      this.c = new HashMap();
      this.d = y.g.M.b();
      this.e = y.g.M.b();
   }

   public w a(U var1) {
      w var2 = (w)this.c.get(var1);
      if(var2 == null) {
         var2 = new w(var1, this.a);
         this.c.put(var1, var2);
      }

      return var2;
   }

   public w a(y.c.d var1) {
      U var2 = this.b(var1);
      w var3 = null;
      if(var2 != null) {
         var3 = (w)this.c.get(var2);
         if(var3 == null) {
            var3 = new w(var2, this.a);
            this.c.put(var2, var3);
         }
      } else {
         if(this.d.b(var1) != null) {
            return (w)this.d.b(var1);
         }

         if(!this.a.c().a(var1, var1.a())) {
            var3 = (w)this.e.b(var1);
            if(var3 == null) {
               var3 = new w(var1, this.a);
               this.e.a(var1, var3);
            }
         }
      }

      return var3;
   }

   public void a(y.c.d var1, U var2) {
      this.b.a(var1, var2);
   }

   public U b(y.c.d var1) {
      return (U)this.b.b(var1);
   }

   void a(y.c.d var1, w var2) {
      this.d.a(var1, var2);
   }

   boolean a() {
      return this.f;
   }

   void a(boolean var1) {
      this.f = var1;
   }
}
