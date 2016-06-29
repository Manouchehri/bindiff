package y.f.f.a.a;

import java.util.HashMap;
import java.util.Map;
import y.c.D;
import y.c.q;
import y.f.f.a.a.a;
import y.f.f.a.a.b;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.n;

public class p extends a {
   protected y.c.i b;
   protected Map c;

   public p() {
      this.c = new HashMap();
   }

   public p(y.c.i var1) {
      this();
      this.a(var1);
   }

   public b a(b var1, q var2) {
      return this.a(var1, (D)null, var2);
   }

   public b a(b var1, D var2, q var3) {
      b var4 = new b(var1, var2, var3);
      if(var3 != null) {
         this.a(var3, var4);
      }

      return var4;
   }

   public void a(y.c.i var1) {
      this.b = var1;
   }

   public void a(b var1) {
      if(var1 == null) {
         this.a = this.a((b)null, (D)null, (q)null);
         if(!f.e) {
            return;
         }
      }

      this.a = var1;
   }

   public void a(q var1, b var2) {
      this.c.put(var1, var2);
   }

   public b a(q var1) {
      return (b)this.c.get(var1);
   }

   public String toString() {
      return n.a((g)this);
   }
}
