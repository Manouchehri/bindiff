package y.f.c;

final class P extends y.g.p {
   private final y.c.c a;
   private final Object b;

   public P(y.c.c var1, Object var2) {
      this.a = var1;
      this.b = var2;
   }

   public Object b(Object var1) {
      Object var2 = this.a.b(var1);
      return var2 == null?this.b:var2;
   }
}
