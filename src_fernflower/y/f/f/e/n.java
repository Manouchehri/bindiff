package y.f.f.e;

import y.c.A;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.f.b.p;
import y.f.f.c.r;
import y.f.f.e.a;
import y.f.h.q;
import y.g.al;
import y.g.o;

public class n implements p {
   private y.f.f.b.h b;
   private X c;
   private short d = 0;
   private short e = 0;
   private int f = 3;
   public int a;
   private boolean g = false;
   private y.f.f.b.m h;

   public void a(y.f.f.b.h var1) {
      this.b = var1;
      this.c = (X)this.b.a();
   }

   public void a(int var1) {
      this.a = var1;
   }

   public void a(y.f.f.b.m var1) {
      this.h = var1;
   }

   public void a(short var1) {
      this.d = var1;
   }

   public void b(short var1) {
      this.e = var1;
   }

   public void b(int var1) {
      this.f = var1;
   }

   public void a() {
      int var12 = a.a;
      o.a(this, "------->>> Entering Compaction Phase");
      al var1 = new al();
      y.c.d[] var2 = this.c.n();
      int var3 = 0;

      y.f.f.b.h var10000;
      while(true) {
         if(var3 < var2.length) {
            y.c.d var4 = var2[var3];
            var10000 = this.b;
            if(var12 != 0) {
               break;
            }

            if(!var10000.c(var4)) {
               this.b.n(var4);
            }

            ++var3;
            if(var12 == 0) {
               continue;
            }
         }

         var10000 = this.b;
         break;
      }

      y.c.e var13 = var10000.a().p();

      n var23;
      while(true) {
         if(var13.f()) {
            this.b.b(var13.a(), 1);
            var23 = this;
            if(var12 != 0) {
               break;
            }

            this.b.b(var13.a(), 1.0D);
            var13.g();
            if(var12 == 0) {
               continue;
            }
         }

         var23 = this;
         break;
      }

      label85: {
         y.c.c var14 = var23.c.c("y.layout.orthogonal.general.NodeSplitter.NODE_FACES");
         if(this.d == 1) {
            q var15 = this.b.c();

            label82:
            do {
               int var24 = var15.f();

               label79: {
                  y.c.q[] var6;
                  label78:
                  while(true) {
                     if(var24 == 0) {
                        break label82;
                     }

                     y.f.h.p var5 = (y.f.h.p)var15.d();
                     if(var12 != 0) {
                        break label85;
                     }

                     if(!var14.d(var5)) {
                        break label79;
                     }

                     var6 = new y.c.q[4];
                     y.c.e var7 = var5.a();

                     while(true) {
                        if(!var7.f()) {
                           break label78;
                        }

                        y.c.d var8 = var7.a();
                        var24 = this.b.d(var8);
                        if(var12 != 0) {
                           break;
                        }

                        if(var24 == 1) {
                           var6[this.b.h(var8).g()] = var8.c();
                        }

                        var7.g();
                        if(var12 != 0) {
                           break label78;
                        }
                     }
                  }

                  y.f.f.b.n var19 = new y.f.f.b.n(var6[1], var6[0], 2, 1, y.f.f.b.o.b);
                  this.b.a(var19);
                  y.f.f.b.n var21 = new y.f.f.b.n(var6[2], var6[1], 2, 1, y.f.f.b.o.c);
                  this.b.a(var21);
               }

               var15.g();
            } while(var12 == 0);
         }

         this.h.h = (int)var1.d();
         var1.e();
      }

      r var16 = new r();
      var16.a(this.f);
      switch(this.e) {
      case 0:
         var16.a((y.f.f.c.l)(new y.f.f.c.k()));
         var16.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var12 == 0) {
            break;
         }
      case 1:
         var16.a((y.f.f.c.l)(new y.f.f.c.h()));
         var16.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var12 == 0) {
            break;
         }
      case 2:
         var16.a((y.f.f.c.l)(new y.f.f.c.n()));
         var16.a((y.f.f.c.f)(new y.f.f.c.m()));
         if(var12 == 0) {
            break;
         }
      default:
         o.a((Object)"Unknown Compactor !");
      }

      A var17 = this.c.t();
      var16.a(this.b);
      var16.a(this.g);
      var16.a(var17);
      this.h.i = (int)var1.d();
      var1.e();
      int var18 = this.a;
      int var20 = this.a;
      x var22 = this.c.o();

      while(true) {
         if(var22.f()) {
            y.c.q var9 = var22.e();
            t var10 = (t)var17.b(var9);
            t var11 = new t(var10.a() * (double)var18, var10.b() * (double)var20);
            var17.a(var9, var11);
            this.c.a(var9, var11.a(), var11.b());
            var22.g();
            if(var12 != 0) {
               break;
            }

            if(var12 == 0) {
               continue;
            }
         }

         this.c.a((A)var17);
         this.h.j = var16.a();
         this.h.k = var16.b();
         this.h.l = var16.c();
         this.h.m = var16.d();
         o.a(this, "Prof: -> Total running time of compaction Phase: " + var1);
         o.a(this, "<<<------- Leaving Compaction Phase");
         break;
      }

   }
}
