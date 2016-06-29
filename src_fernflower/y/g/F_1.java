package y.g;

import java.util.Map;
import y.g.C;

public abstract class F implements C {
   private final C a;

   protected F(C var1) {
      if(var1 == null) {
         throw new NullPointerException("delegatingFactory");
      } else {
         this.a = var1;
      }
   }

   public void a(y.c.i var1, y.c.i var2) {
      this.b(var1, var2);
      this.a.a(var1, var2);
   }

   public void a(y.c.i var1, y.c.i var2, Map var3, Map var4) {
      this.a.a(var1, var2, var3, var4);
      this.b(var1, var2, var3, var4);
   }

   public y.c.q a(y.c.i var1, y.c.q var2) {
      y.c.q var3 = this.a.a(var1, var2);
      if(var2 != null) {
         this.a(var2, var3);
      }

      return var3;
   }

   protected void b(y.c.i var1, y.c.i var2) {
   }

   protected void b(y.c.i var1, y.c.i var2, Map var3, Map var4) {
   }

   protected void a(y.c.q var1, y.c.q var2) {
   }

   protected void a(y.c.d var1, y.c.d var2) {
   }

   public y.c.d a(y.c.i var1, y.c.q var2, y.c.q var3, y.c.d var4) {
      y.c.d var5 = this.a.a(var1, var2, var3, var4);
      if(var4 != null) {
         this.a(var4, var5);
      }

      return var5;
   }
}
