package y.f.h;

import java.util.ArrayList;
import y.f.h.N;
import y.g.ar;

public class R {
   protected y.c.i a;
   protected boolean b;
   protected int[] c;
   protected boolean[] d;
   protected ArrayList e;
   protected ArrayList f;
   protected ArrayList g;
   protected ar h;
   protected long i = 1306737L;

   public void a(y.c.i var1) {
      this.a = var1;
      this.c = new int[var1.f()];
      this.d = new boolean[var1.f()];
      this.e = new ArrayList(var1.f());
      this.f = new ArrayList(var1.f());
      this.g = new ArrayList(var1.f());
      this.h = new ar(this.i);
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public void a(y.c.y var1) {
      boolean var3 = N.d;
      this.a();
      var1.clear();
      this.e.clear();
      y.c.x var2 = this.a.o();

      while(true) {
         if(var2.f()) {
            this.e.add(var2.e());
            var2.g();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.a(this.e, this.g);
         break;
      }

      if(this.g.isEmpty()) {
         throw new RuntimeException("Graph consists only of directed circles");
      } else {
         this.a(this.e, this.g, this.f, var1);

         while(!this.e.isEmpty()) {
            this.a(this.f, this.g);
            if(this.g.isEmpty()) {
               this.a(this.e, this.g);
            }

            if(this.g.isEmpty()) {
               throw new RuntimeException("Graph contains a directed circle");
            }

            this.a(this.e, this.g, this.f, var1);
            if(var3) {
               break;
            }
         }

      }
   }

   protected void a() {
      boolean var3 = N.d;
      int var1 = 0;

      R var10000;
      while(true) {
         if(var1 < this.a.e()) {
            this.c[var1] = 0;
            var10000 = this;
            if(var3) {
               break;
            }

            this.d[var1] = false;
            ++var1;
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.c.e var4 = var10000.a.p();

      while(var4.f()) {
         y.c.d var2 = var4.a();
         ++this.c[var2.d().d()];
         ++this.c[var2.c().d()];
         var4.g();
         if(var3) {
            break;
         }
      }

   }

   protected void a(ArrayList var1, ArrayList var2) {
      boolean var7 = N.d;
      var2.clear();
      int var3 = Integer.MAX_VALUE;
      int var4 = 0;

      while(var4 < var1.size()) {
         y.c.q var5 = (y.c.q)var1.get(var4);
         int var6 = this.c[var5.d()];
         if(var6 < var3) {
            var3 = var6;
            var2.clear();
         }

         if(var6 == var3) {
            var2.add(var5);
         }

         ++var4;
         if(var7) {
            break;
         }
      }

   }

   public void a(ArrayList var1, ArrayList var2, ArrayList var3, y.c.y var4) {
      boolean var11 = N.d;
      y.c.q var5 = this.b?this.a(var2):(y.c.q)var2.get(0);
      int var6 = var1.indexOf(var5);
      if(var6 >= 0) {
         var1.remove(var6);
      }

      var4.add(var5);
      var3.clear();
      this.d[var5.d()] = true;
      y.c.e var7 = var5.j();

      while(var7.f()) {
         y.c.d var8 = var7.a();
         y.c.q var9 = var8.a(var5);
         int var10 = var9.d();
         if(!this.d[var10]) {
            --this.c[var10];
            var3.add(var9);
         }

         var7.g();
         if(var11) {
            break;
         }
      }

   }

   protected y.c.q a(ArrayList var1) {
      if(var1.size() == 0) {
         throw new RuntimeException("Given an empty list!");
      } else {
         int var2 = this.h.nextInt(var1.size());
         return (y.c.q)var1.get(var2);
      }
   }
}
