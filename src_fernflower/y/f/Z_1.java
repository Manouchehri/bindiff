package y.f;

import java.util.HashMap;
import java.util.Map;
import y.f.X;
import y.f.Y;

public class Z extends y.g.F {
   private y.c.c a;
   private y.c.c b;
   private y.c.c c;
   private y.c.b d;
   private y.c.b e;
   private y.c.b f;

   public Z() {
      this(new Y());
   }

   public Z(y.g.C var1) {
      super(var1);
   }

   protected void b(y.c.i var1, y.c.i var2) {
      super.b(var1, var2);
      this.a = var1.c(y.f.b.f.d);
      this.b = var1.c(y.f.b.f.b);
      this.c = var1.c(y.f.b.f.c);
      if(this.a != null && this.b != null && this.c != null) {
         this.d = (y.c.b)var2.c(y.f.b.f.d);
         this.e = (y.c.b)var2.c(y.f.b.f.b);
         this.f = (y.c.b)var2.c(y.f.b.f.c);
         if(this.d == null) {
            var2.a((Object)y.f.b.f.d, (y.c.c)(this.d = var2.t()));
         }

         if(this.e == null) {
            var2.a((Object)y.f.b.f.b, (y.c.c)(this.e = var2.t()));
         }

         if(this.f == null) {
            var2.a((Object)y.f.b.f.c, (y.c.c)(this.f = var2.t()));
         }
      }

   }

   protected void b(y.c.i var1, y.c.i var2, Map var3, Map var4) {
      boolean var11 = X.j;
      super.b(var1, var2, var3, var4);
      if(this.e != null) {
         HashMap var5 = new HashMap();
         y.c.x var6 = var1.o();

         y.c.q var7;
         label31: {
            while(var6.f()) {
               var7 = var6.e();
               var5.put(this.b.b(var7), var7);
               var6.g();
               if(var11) {
                  break label31;
               }

               if(var11) {
                  break;
               }
            }

            var6 = var1.o();
         }

         while(var6.f()) {
            var7 = var6.e();
            y.c.q var8 = (y.c.q)var3.get(var7);
            y.c.q var9 = (y.c.q)var5.get(this.c.b(var7));
            y.c.q var10 = (y.c.q)var3.get(var9);
            if(var11) {
               return;
            }

            if(var8 != null && var10 != null) {
               this.f.a(var8, this.e.b(var10));
            }

            var6.g();
            if(var11) {
               break;
            }
         }
      }

      this.d = this.e = this.f = null;
      this.a = this.b = this.c = null;
   }

   protected void a(y.c.q var1, y.c.q var2) {
      super.a(var1, var2);
      if(this.b != null && this.e != null) {
         Object var3 = this.b.b(var1);
         this.e.a(var2, this.a(var3, var2));
         this.d.a(var2, this.a.d(var1));
      }

   }

   protected Object a(Object var1, y.c.q var2) {
      return var2;
   }
}
