package y.f.h;

import y.f.h.D;
import y.f.h.H;
import y.f.h.I;
import y.f.h.N;
import y.f.h.V;
import y.f.h.a;
import y.f.h.n;
import y.f.h.o;
import y.f.h.p;
import y.f.h.q;
import y.f.h.s;
import y.f.h.x;
import y.f.h.y;
import y.g.al;

public class c implements o {
   private D a;
   private boolean b = false;
   private boolean c = false;
   private boolean d = false;
   private boolean e = false;
   private int f = -1;
   private int g = 30;
   private al h = new al();
   private int i = 0;
   private int j = 0;
   private int k = 0;

   public void a(D var1) {
      this.a = var1;
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public void b(boolean var1) {
      this.d = var1;
   }

   public void c(boolean var1) {
      this.e = var1;
   }

   public void a(int var1) {
      this.f = var1;
   }

   public void d(boolean var1) {
      this.b = var1;
   }

   public int b() {
      return this.i;
   }

   public int d() {
      return this.j;
   }

   public int e() {
      return this.k;
   }

   public void c() {
      StringBuffer var1;
      boolean var11;
      label65: {
         var11 = N.d;
         var1 = new StringBuffer();
         var1.append("\n***************************************");
         var1.append("********   PLANAR EMBEDDING    ********");
         var1.append("***************************************");
         y.g.o.a(this, 0, var1);
         var1 = new StringBuffer();
         var1.append("\nSETTINGS:");
         var1.append("  use biconnected components: " + this.d);
         var1.append("  edge rerouting enabled    : " + this.c);
         if(this.f == -1) {
            var1.append("  no reroute iterations bound");
            if(!var11) {
               break label65;
            }

            y.c.i.g = !y.c.i.g;
         }

         var1.append("  reroute iterations        : " + this.f);
      }

      var1.append("  allow randomization       : " + this.b + "\n");
      y.g.o.a(this, 3, var1);
      if(this.a == null) {
         throw new RuntimeException("Forgot to set PlanarInformation!");
      } else {
         I var2 = new I(this.a);
         var2.a();
         y.c.f var3 = new y.c.f(this.a.g().p());
         y var4 = new y();
         var4.a(this.a.g());
         this.h.e();
         Object var5 = null;
         if(this.d) {
            var5 = new a(this.a((short)0));
         } else {
            var5 = this.a((short)0);
         }

         ((x)var5).a(this.a);
         this.i = (int)this.h.d();
         if(this.e) {
            y.f.h.a.e var6 = null;
            var6 = new y.f.h.a.e();
            var6.a(this.a);
         }

         n var12 = new n(this.a);
         y.c.f var7 = ((x)var5).c_();
         y.g.o.a(this, 3, "HANDLE MULTIPLE EDGES !");
         var2.b();
         var4.a(this.a, var7);
         var4.a();
         this.h.e();
         y.g.o.a(this, 0, "REINSERTION: " + var7.size() + "  graph edges");
         var12.a(var7);
         if(y.g.o.b(this) && !this.a.n()) {
            throw new RuntimeException("Combinatorial Embedder failed !");
         } else {
            this.j = (int)this.h.d();
            this.h.e();
            if(this.c) {
               y.g.o.a(this, 0, "REROUTE EDGES");
               y.g.o.a(this, 0, "  number of crossings (before rerouting): " + this.a.a());
               var12.a(this.f, var3);
               y.g.o.a(this, 0, "  number of crossings (after rerouting): " + this.a.a());
            }

            this.k = (int)this.h.d();
            p var8 = null;
            q var9 = this.a.h();

            while(true) {
               if(var9.f()) {
                  p var10 = var9.a();
                  if(var11) {
                     break;
                  }

                  label53: {
                     if(var8 == null) {
                        var8 = var10;
                        if(!var11) {
                           break label53;
                        }
                     }

                     if(var8.a().k() < var10.a().k()) {
                        var8 = var10;
                     }
                  }

                  var9.g();
                  if(!var11) {
                     continue;
                  }
               }

               this.a.b((p)var8);
               this.a.k();
               y.g.o.a(this, 0, "\n**********************************");
               y.g.o.a(this, 0, "***** PLANAR EMBEDDING DONE! *****");
               y.g.o.a(this, 0, "**********************************\n");
               break;
            }

         }
      }
   }

   public void a() {
      this.a.b();
      this.a.e();
   }

   protected x a(short var1) {
      switch(var1) {
      case 0:
         s var2 = new s();
         var2.a(this.b);
         var2.a(this.g);
         return new H(var2);
      case 1:
         return new V();
      default:
         return null;
      }
   }
}
