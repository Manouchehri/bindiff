package y.f.i.a;

abstract class Y {
   private long a = 0L;

   public boolean a() {
      ++this.a;
      return this.a(this.a);
   }

   protected abstract boolean a(long var1);
}
