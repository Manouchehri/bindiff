package y.f.i.a;

abstract class aT implements y.d.o {
   protected final y.d.m a;
   protected final y.d.m b;
   protected final byte c;
   protected final y.c.d d;
   y.c.q e;
   y.c.q f;

   protected aT(y.c.d var1, y.d.m var2, y.d.m var3) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = this.g();
   }

   public byte i() {
      return this.c;
   }

   public y.c.d j() {
      return this.d;
   }

   public abstract double b();

   public abstract double c();

   public abstract double d();

   public abstract double e();

   public abstract void a(double var1);

   public Object f() {
      return null;
   }

   public abstract boolean a();

   public boolean k() {
      return this.c == 1 || this.c == 2;
   }

   private byte g() {
      boolean var1 = Math.min(this.b.c().b, this.b.d().b) + 1.0E-6D < this.a.c().b;
      boolean var2 = Math.min(this.a.c().a, this.a.d().a) + 1.0E-6D < this.b.c().a;
      return (byte)(var1 && !var2?0:(var1 && var2?1:(!var2?2:3)));
   }
}
