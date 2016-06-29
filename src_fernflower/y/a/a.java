package y.a;

public class a extends RuntimeException {
   public a(String var1) {
      super(var1);
   }

   public a() {
      this("");
   }

   public static void a() {
      a("");
   }

   public static void a(String var0) {
      if(Thread.interrupted()) {
         throw new a(var0);
      }
   }
}
