package y.f.h;

class f {
   private final Object a;

   private f(Object var1) {
      this.a = var1;
   }

   public static f a(Object var0) {
      return new f(var0);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         f var2 = (f)var1;
         return this.a == var2.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.a.hashCode();
   }
}
