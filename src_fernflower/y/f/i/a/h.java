package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import y.f.i.a.M;
import y.f.i.a.ab;
import y.f.i.a.ah;
import y.f.i.a.ai;

public class h {
   private final boolean a;
   private final ArrayList b = new ArrayList();
   private final HashMap c = new HashMap();
   private M d;
   private M e;
   private List f;

   public h(ai var1) {
      this.a = var1.g();
      this.a(var1);
      this.f = new ArrayList();
   }

   public void a(ai var1) {
      if(var1.g() != this.a) {
         throw new IllegalArgumentException("segment is not " + (this.a?"vertical!":"horizontal!"));
      } else {
         this.b.add(var1);
         if(this.d != null) {
            this.d = M.b(this.d, var1.c());
            this.e = M.b(this.e, var1.b());
            if(ab.a == 0) {
               return;
            }
         }

         this.d = var1.c();
         this.e = var1.b();
      }
   }

   public M a() {
      return this.d;
   }

   public int b() {
      return this.b.size();
   }

   public boolean c() {
      return this.a;
   }

   List d() {
      return this.b;
   }

   public ai a(int var1) {
      return (ai)this.b.get(var1);
   }

   public int e() {
      return this.f.size();
   }

   public void a(ah var1) {
      this.f.add(var1);
   }

   public ah b(int var1) {
      return (ah)this.f.get(var1);
   }

   public double b(ai var1) {
      Double var2 = (Double)this.c.get(var1);
      return var2 == null?Double.NaN:var2.doubleValue();
   }

   public void a(ai var1, double var2) {
      this.c.put(var1, new Double(var2));
   }

   void a(h var1) {
      if(var1 != this) {
         if(this.a != var1.a) {
            throw new IllegalStateException("cannot splice channels!");
         } else {
            this.b.addAll(var1.b);
            this.d = M.b(this.d, var1.d);
            this.e = M.b(this.e, var1.e);
         }
      }
   }

   public String toString() {
      int var4 = ab.a;
      StringBuffer var1 = new StringBuffer();
      int var2 = 0;

      StringBuffer var10000;
      while(true) {
         if(var2 < this.b.size()) {
            ai var3 = (ai)this.b.get(var2);
            var1.append('\n');
            var1.append('\t');
            var10000 = var1.append(var3);
            if(var4 != 0) {
               break;
            }

            ++var2;
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = (new StringBuffer()).append("Channel{isVertical=").append(this.a).append(", width=").append(this.d).append(", length=").append(this.e).append(", segments=").append(var1.toString()).append('}');
         break;
      }

      return var10000.toString();
   }
}
