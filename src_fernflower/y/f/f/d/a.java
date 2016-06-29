package y.f.f.d;

public class a {
   public y.c.f a = new y.c.f();
   public y.c.d[] b;
   public int c;
   public int d = 0;

   public a(int var1) {
      this.c = var1;
   }

   public a(y.c.d var1, int var2) {
      this.c = var2;
      this.a.add(var1);
      this.b = (y.c.d[])this.a.toArray(new y.c.d[1]);
   }

   public int a() {
      return this.c;
   }

   public void a(y.c.d var1) {
      this.a.add(var1);
      this.b = (y.c.d[])this.a.toArray(new y.c.d[this.a.size()]);
   }

   public y.c.e b() {
      return this.a.a();
   }

   public y.c.d[] c() {
      return this.b;
   }

   public y.c.d b(y.c.d var1) {
      return this.b[0] != var1?this.b[0]:this.b[1];
   }
}
