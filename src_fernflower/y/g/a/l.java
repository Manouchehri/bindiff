package y.g.a;

class l {
   l a;
   l b;
   l c;
   Object d;
   byte e;

   public l(Object var1) {
      this.d = var1;
   }

   void a(l var1) {
      this.b = var1;
      if(var1 != null) {
         var1.a = this;
      }

   }

   void b(l var1) {
      this.c = var1;
      if(var1 != null) {
         var1.a = this;
      }

   }

   public String toString() {
      return this.d.toString() + " / " + this.e;
   }
}
