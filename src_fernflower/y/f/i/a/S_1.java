package y.f.i.a;

public class S {
   public static final S a = new S();
   public static final S b = new S();
   public static final S c = new S();
   public static final S d = new S();

   public static S a(y.f.y var0) {
      return y.f.y.a == var0?a:(y.f.y.c == var0?b:(y.f.y.d == var0?d:(y.f.y.b == var0?c:null)));
   }

   public static S a(y.f.aE var0) {
      return var0.c()?a:(var0.d()?b:(var0.e()?c:(var0.f()?d:null)));
   }

   public static S a(y.f.ax var0) {
      return a(var0.e());
   }
}
