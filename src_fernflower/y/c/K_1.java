package y.c;

import java.util.ArrayList;
import y.c.A;
import y.c.D;
import y.c.I;
import y.c.J;
import y.c.L;
import y.c.N;
import y.c.d;
import y.c.h;
import y.c.q;

class K {
   int a;
   int b;
   ArrayList c;
   ArrayList d;

   private K() {
   }

   K(int var1, int var2) {
      this.a = var1;
      this.b = var2;
      this.c = new ArrayList();

      for(int var3 = this.a - 1; var3 >= 0; --var3) {
         this.c.add(new Integer(var3));
      }

      this.d = new ArrayList();
   }

   private int a(L var1) {
      int var2;
      if(this.c.isEmpty()) {
         this.a(var1, this.a, this.a + this.b);

         for(int var3 = this.a + this.b - 1; var3 > this.a; --var3) {
            this.c.add(new Integer(var3));
         }

         var2 = this.a;
         this.a += this.b;
      } else {
         var2 = ((Integer)this.c.remove(this.c.size() - 1)).intValue();
      }

      return var2;
   }

   A a(L var1, String var2) {
      int var3 = this.a(var1);
      J var4 = new J(var3, var2, this);
      this.d.add(var4);
      this.a(var1, var3);
      return var4;
   }

   h b(L var1, String var2) {
      int var3 = this.a(var1);
      N var4 = new N(var3, var2, this);
      this.d.add(var4);
      this.a(var1, var3);
      return var4;
   }

   void a(L var1, int var2, int var3) {
      for(I var4 = var1.c(); var4 != null; var4 = var1.a(var4)) {
         Object[] var5 = new Object[var3];
         System.arraycopy(var4.k, 0, var5, 0, var2);
         var4.k = var5;
      }

   }

   void a(I var1, int var2, int var3) {
      Object[] var4 = new Object[var3];
      System.arraycopy(var1.k, 0, var4, 0, var2);
      var1.k = var4;
   }

   void a(L var1, int var2) {
      for(I var3 = var1.c(); var3 != null; var3 = var1.a(var3)) {
         var3.k[var2] = null;
      }

   }

   void a(A var1, L var2) {
      if(var1 instanceof J) {
         J var3 = (J)var1;
         if(var3.d != this) {
            throw new IllegalArgumentException("Map does not belong to this graph!");
         }

         if(var3.a()) {
            throw new IllegalStateException("Map has been already disposed !");
         }

         var3.b();
         int var4 = ((J)var1).a;
         if(!this.c.contains(new Integer(var4))) {
            this.a(var2, var4);
            this.c.add(new Integer(var4));
            this.d.remove(var1);
         }
      }

   }

   void a(h var1, L var2) {
      if(var1 instanceof N) {
         N var3 = (N)var1;
         if(var3.d != this) {
            throw new IllegalArgumentException("Map does not belong to this graph!");
         }

         if(var3.a()) {
            throw new IllegalStateException("Map has been already disposed !");
         }

         var3.b();
         int var4 = var3.a;
         if(!this.c.contains(new Integer(var4))) {
            this.a(var2, var4);
            this.c.add(new Integer(var4));
            this.d.remove(var1);
         }
      }

   }

   A[] a() {
      boolean var3 = D.e;
      A[] var1 = new A[this.d.size()];
      int var2 = 0;

      A[] var10000;
      while(true) {
         if(var2 < this.d.size()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1[var2] = (J)this.d.get(var2);
            ++var2;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   h[] b() {
      boolean var3 = D.e;
      h[] var1 = new h[this.d.size()];
      int var2 = 0;

      h[] var10000;
      while(true) {
         if(var2 < this.d.size()) {
            var10000 = var1;
            if(var3) {
               break;
            }

            var1[var2] = (N)this.d.get(var2);
            ++var2;
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   void a(q var1, q var2) {
      boolean var5 = D.e;
      int var3 = 0;

      while(var3 < this.d.size()) {
         int var4 = ((J)this.d.get(var3)).a;
         var2.k[var4] = var1.k[var4];
         ++var3;
         if(var5) {
            break;
         }
      }

   }

   void a(d var1, d var2) {
      boolean var5 = D.e;
      int var3 = 0;

      while(var3 < this.d.size()) {
         int var4 = ((N)this.d.get(var3)).a;
         var2.k[var4] = var1.k[var4];
         ++var3;
         if(var5) {
            break;
         }
      }

   }

   K c() {
      K var1 = new K();
      var1.a = this.a;
      var1.b = this.b;
      var1.d = (ArrayList)this.d.clone();
      var1.c = (ArrayList)this.c.clone();
      return var1;
   }
}
