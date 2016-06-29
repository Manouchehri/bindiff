package y.g;

public class d {
   private Object[] a;
   private int b;

   public d(int var1) {
      this.a = new Object[var1];
      this.b = -1;
   }

   public Object a() {
      return this.a[this.b];
   }

   public Object b() {
      return this.a[this.b--];
   }

   public void a(Object var1) {
      this.a[++this.b] = var1;
   }

   public boolean c() {
      return this.b < 0;
   }
}
