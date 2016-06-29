package y.f.i;

class aJ {
   public y.c.D a = new y.c.D();
   public y.c.D b = new y.c.D();
   public y.c.D c = new y.c.D();
   public y.c.D d = new y.c.D();
   public y.c.D e = new y.c.D();
   public y.c.D f = new y.c.D();
   public y.c.D g = new y.c.D();
   public y.c.D h = new y.c.D();

   public void a(Object var1) {
      this.a.add(var1);
   }

   public void b(Object var1) {
      this.b.add(var1);
   }

   public void c(Object var1) {
      this.c.add(var1);
   }

   public void d(Object var1) {
      this.d.add(var1);
   }

   public void e(Object var1) {
      this.e.add(var1);
   }

   public void f(Object var1) {
      this.f.add(var1);
   }

   public void g(Object var1) {
      this.g.add(var1);
   }

   public void h(Object var1) {
      this.h.add(var1);
   }

   public Object a() {
      return this.a.isEmpty()?null:this.a.i();
   }

   public Object b() {
      return this.c.isEmpty()?null:this.c.i();
   }

   public Object c() {
      return this.e.isEmpty()?null:this.e.i();
   }

   public Object d() {
      return this.g.isEmpty()?null:this.g.i();
   }

   public String toString() {
      return "[north=" + this.a.size() + ";northDistant=" + this.b.size() + ";south=" + this.c.size() + ";southDistant=" + this.d.size() + ";west=" + this.e.size() + ";westDistant=" + this.f.size() + ";east=" + this.g.size() + ";eastDistant=" + this.h.size() + "]";
   }
}
