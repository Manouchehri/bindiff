package y.c;

class I {
   I i;
   I j;
   Object[] k;

   void a(int var1) {
      this.k = new Object[var1];
   }

   I q() {
      return this.i;
   }

   I r() {
      return this.j;
   }

   void a(I var1) {
      this.i = var1;
   }

   void b(I var1) {
      this.j = var1;
   }
}
