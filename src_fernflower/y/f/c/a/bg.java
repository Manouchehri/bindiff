package y.f.c.a;

class bg {
   final y.f.ax a;

   private bg(y.f.ax var1) {
      this.a = var1;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(var1 != null && this.getClass() == var1.getClass()?this.a == ((bg)var1).a:false);
   }

   public int hashCode() {
      return this.a.hashCode();
   }

   static bg a(y.f.ax var0) {
      return new bg(var0);
   }
}
