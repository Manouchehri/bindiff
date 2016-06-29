package y.f.f.a.a;

import java.util.HashMap;
import java.util.Map;
import y.f.f.a.a.a;
import y.f.f.a.a.e;
import y.f.f.a.a.f;
import y.f.f.a.a.g;
import y.f.f.a.a.k;
import y.f.f.a.a.l;
import y.f.f.a.a.m;

public class j implements g {
   protected a a;
   private Map b;

   public j(a var1) {
      this.a = var1;
      this.b = new HashMap();
   }

   public void b() {
      this.b.clear();
   }

   public e a() {
      f var1 = (f)this.a.a();
      return (e)this.a(var1);
   }

   public void a(l var1) {
      m.a(new k(this, var1), (g)this.a);
   }

   public void a(f var1, Object var2) {
      this.b.put(var1, var2);
   }

   public Object a(f var1) {
      return this.b.get(var1);
   }
}
