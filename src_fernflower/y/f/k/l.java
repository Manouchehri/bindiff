package y.f.k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y.f.k.d;
import y.f.k.n;

public class l {
   public static final l a = new l(1.0D, 0.0D, 0.0D, 1.0D);
   public static final l b = new l(0.0D, -1.0D, 1.0D, 0.0D);
   public static final l c = new l(-1.0D, 0.0D, 0.0D, -1.0D);
   public static final l d = new l(0.0D, 1.0D, -1.0D, 0.0D);
   public static final l e = new l(1.0D, 0.0D, 0.0D, -1.0D);
   public static final l f = new l(-1.0D, 0.0D, 0.0D, 1.0D);
   public static final l g = new l(0.0D, -1.0D, -1.0D, 0.0D);
   public static final l h = new l(0.0D, 1.0D, 1.0D, 0.0D);
   public static final List i;
   private final double[][] j = new double[2][2];
   private l k;
   private n[] l;
   private n[] m;

   l(double var1, double var3, double var5, double var7) {
      this.j[0][0] = var1;
      this.j[0][1] = var3;
      this.j[1][0] = var5;
      this.j[1][1] = var7;
      this.l = new n[]{n.a(new double[]{this.j[0][0], this.j[1][0]}), n.a(new double[]{this.j[0][1], this.j[1][1]})};
      this.m = new n[]{n.a(this.j[0]), n.a(this.j[1])};
   }

   n a(int var1) {
      return this.l[var1];
   }

   public String toString() {
      int var7 = d.g;
      StringBuffer var1 = new StringBuffer("Matrix:\n");
      int var2 = 0;

      StringBuffer var10000;
      while(true) {
         if(var2 < this.j.length) {
            double[] var3 = this.j[var2];
            var10000 = var1.append(var2).append(": ");
            if(var7 != 0) {
               break;
            }

            int var4 = 0;

            label27: {
               while(var4 < var3.length) {
                  double var5 = var3[var4];
                  var1.append(var5);
                  var1.append(' ');
                  ++var4;
                  if(var7 != 0) {
                     break label27;
                  }

                  if(var7 != 0) {
                     break;
                  }
               }

               var1.append('\n');
               ++var2;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000.toString();
   }

   l a() {
      return this.k;
   }

   static l a(l var0) {
      return var0.k;
   }

   static {
      ArrayList var0 = new ArrayList(10);
      var0.add(a);
      var0.add(b);
      var0.add(c);
      var0.add(d);
      var0.add(e);
      var0.add(f);
      var0.add(g);
      var0.add(h);
      i = Collections.unmodifiableList(var0);
      a.k = a;
      b.k = d;
      d.k = b;
      c.k = c;
      e.k = e;
      f.k = f;
      g.k = g;
      h.k = h;
   }
}
