package y.f.i.a;

import java.util.Iterator;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.a;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.g;

public class ai extends a {
   private List a;
   private double b;
   private boolean c;

   public ai(y.c.d var1, int var2, y.f.y var3, M var4, M var5, M var6, List var7) {
      super(var1, var2, var3, var4, var5, var6);
      this.a = var7;
   }

   public ai(y.c.d var1, int var2, y.d.m var3) {
      super(var1, var2, var3);
   }

   public int l() {
      return this.a.size();
   }

   public g b(int var1) {
      return (g)this.a.get(var1);
   }

   public void a(ah var1) {
      int var4 = ab.a;
      super.a(var1);
      if(this.a != null) {
         Iterator var2 = this.a.iterator();

         while(var2.hasNext()) {
            g var3 = (g)var2.next();
            var3.a(var1);
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   double m() {
      return this.b;
   }

   void b(double var1) {
      this.b = var1;
   }

   public boolean n() {
      return this.c;
   }

   public void a(boolean var1) {
      this.c = var1;
   }
}
