package y.h;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.eU;
import y.h.fj;
import y.h.gZ;
import y.h.gd;
import y.h.x;
import y.h.y;

public class cK extends AbstractAction {
   private final ch a;
   private int b;
   private int c;
   private boolean d;

   public cK() {
      this((ch)null);
   }

   public cK(ch var1) {
      super(cm.h.toString());
      this.a = var1;
      this.b = 123;
      this.c = 9;
   }

   public int a() {
      return this.c;
   }

   public int b() {
      return this.b;
   }

   public boolean c() {
      return this.d;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      bu var2 = var1.getGraph2D();
      var2.r();

      try {
         this.b(var2);
      } finally {
         var2.s();
      }

   }

   private void b(bu var1) {
      this.a(var1, this.a(this.a(var1)));
   }

   protected int a(int var1) {
      boolean var3 = fj.z;
      int var2;
      if(this.c()) {
         var2 = var1;
         if(var1 == 0) {
            var2 = this.a();
            if(!var3) {
               return var2 & this.b();
            }
         }

         if((var2 & 9) == var2) {
            var2 = 9;
         }

         return var2 & this.b();
      } else {
         var2 = var1;
         if(var1 == 0) {
            var2 = this.a();
         }

         label42: {
            if((var2 & 2) == 2) {
               var2 = 2;
               if(!var3) {
                  break label42;
               }
            }

            if((var2 & 9) != 0) {
               var2 = 9;
               if(!var3) {
                  break label42;
               }
            }

            var2 = b(var2);
         }

         if((var2 & 48) != 0) {
            var2 = 48;
         }

         return var2 & this.b();
      }
   }

   private static int b(int var0) {
      return var0 & -var0;
   }

   protected void a(bu var1, int var2) {
      boolean var4 = fj.z;
      y.c.x var3 = var1.o();

      while(var3.f()) {
         this.a(var1, var3.e(), var2);
         var3.g();
         if(var4) {
            break;
         }
      }

      y.c.e var5 = var1.p();

      while(var5.f()) {
         this.a(var1, var5.a(), var2);
         var5.g();
         if(var4) {
            break;
         }
      }

   }

   protected void a(bu var1, y.c.d var2, int var3) {
      boolean var10 = fj.z;
      boolean var4 = (var3 & 2) == 2;
      boolean var5 = (var3 & 32) == 32;
      boolean var6 = (var3 & 8) == 8;
      this.a(var1, var2, var4);
      aB var7 = var1.i(var2);
      if(var7.labelCount() > 0) {
         int var8 = 0;
         int var9 = var7.labelCount();

         while(var8 < var9) {
            this.a(var1, (gZ)var7.getLabel(var8), var5);
            ++var8;
            if(var10) {
               return;
            }

            if(var10) {
               break;
            }
         }
      }

      if(var7.bendCount() > 0) {
         y var11 = var7.bends();

         while(var11.f()) {
            this.a(var1, var11.a(), var6);
            var11.g();
            if(var10) {
               break;
            }
         }
      }

   }

   protected void a(bu var1, y.c.q var2, int var3) {
      boolean var7;
      boolean var8;
      fj var10000;
      label70: {
         fj var9;
         label69: {
            label68: {
               boolean var12 = fj.z;
               boolean var4 = (var3 & 1) == 1;
               boolean var5 = (var3 & 16) == 16;
               boolean var6 = (var3 & 64) == 64;
               var7 = (var3 & 16384) == 16384;
               var8 = (var3 & '耀') == '耀';
               this.a(var1, var2, var4);
               var9 = var1.t(var2);
               if(var9.labelCount() > 0) {
                  int var10 = 0;
                  int var11 = var9.labelCount();

                  while(var10 < var11) {
                     this.a(var1, (gZ)var9.getLabel(var10), var5);
                     ++var10;
                     if(var12) {
                        break label68;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               if(var9.portCount() > 0) {
                  Iterator var13 = var9.ports();

                  while(var13.hasNext()) {
                     this.a(var1, (eU)var13.next(), var6);
                     if(var12) {
                        break label69;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }
            }

            if(var9 instanceof gd) {
               var10000 = ((gd)var9).e();
               break label70;
            }
         }

         var10000 = var9;
      }

      fj var14 = var10000;
      if(var14 instanceof y.h.b.a) {
         y.h.b.i var15 = ((y.h.b.a)var14).l();
         this.a(var1, (y.h.b.d)var15, var7);
         this.a(var1, (y.h.b.g)var15, var8);
      }

   }

   private void a(bu var1, y.h.b.d var2, boolean var3) {
      boolean var7 = fj.z;
      int var4 = 0;
      int var5 = var2.k();

      while(var4 < var5) {
         y.h.b.c var6 = var2.b(var4);
         this.a(var1, var6, var3);
         if(var6.k() > 0) {
            this.a(var1, (y.h.b.d)var6, var3);
         }

         ++var4;
         if(var7) {
            break;
         }
      }

   }

   private void a(bu var1, y.h.b.g var2, boolean var3) {
      boolean var7 = fj.z;
      int var4 = 0;
      int var5 = var2.n();

      while(var4 < var5) {
         y.h.b.f var6 = var2.c(var4);
         this.a(var1, var6, var3);
         if(var6.n() > 0) {
            this.a(var1, (y.h.b.g)var6, var3);
         }

         ++var4;
         if(var7) {
            break;
         }
      }

   }

   protected int a(bu var1) {
      int var10000;
      int var2;
      int var3;
      label36: {
         boolean var5 = fj.z;
         var2 = 0;
         var3 = this.b();
         if((var3 & '쁑') != 0) {
            y.c.x var4 = var1.o();

            while(var4.f()) {
               var2 |= this.a(var1, var4.e());
               var4.g();
               if(var5) {
                  break label36;
               }

               if(var5) {
                  break;
               }
            }
         }

         if((var3 & 42) != 0) {
            y.c.e var6 = var1.p();

            while(var6.f()) {
               var10000 = var2 | this.a(var1, var6.a());
               if(var5) {
                  return var10000;
               }

               var2 = var10000;
               var6.g();
               if(var5) {
                  break;
               }
            }
         }
      }

      var10000 = var2 & var3;
      return var10000;
   }

   protected int a(bu var1, y.c.d var2) {
      boolean var7 = fj.z;
      int var3 = 0;
      if(this.b(var1, var2)) {
         var3 |= 2;
      }

      int var10000;
      aB var4;
      label56: {
         var4 = var1.i(var2);
         if((var3 & 32) != 32 && var4.labelCount() > 0) {
            int var5 = 0;
            int var6 = var4.labelCount();

            while(var5 < var6) {
               var10000 = this.a(var1, (gZ)var4.getLabel(var5));
               if(var7) {
                  break label56;
               }

               if(var10000 != 0) {
                  var3 |= 32;
                  if(!var7) {
                     break;
                  }
               }

               ++var5;
               if(var7) {
                  break;
               }
            }
         }

         var10000 = var3 & 8;
      }

      if(var10000 != 8 && var4.bendCount() > 0) {
         y var8 = var4.bends();

         while(var8.f()) {
            var10000 = this.a(var1, var8.a());
            if(var7) {
               return var10000;
            }

            if(var10000 != 0) {
               var3 |= 8;
               if(!var7) {
                  break;
               }
            }

            var8.g();
            if(var7) {
               break;
            }
         }
      }

      var10000 = var3;
      return var10000;
   }

   protected int a(bu var1, y.c.q var2) {
      boolean var7 = fj.z;
      int var3 = 0;
      if(this.b(var1, var2)) {
         var3 |= 1;
      }

      int var10000;
      fj var4;
      label70: {
         var4 = var1.t(var2);
         if((var3 & 16) != 16 && var4.labelCount() > 0) {
            int var5 = 0;
            int var6 = var4.labelCount();

            while(var5 < var6) {
               var10000 = this.a(var1, (gZ)var4.getLabel(var5));
               if(var7) {
                  break label70;
               }

               if(var10000 != 0) {
                  var3 |= 16;
                  if(!var7) {
                     break;
                  }
               }

               ++var5;
               if(var7) {
                  break;
               }
            }
         }

         var10000 = var3 & 64;
      }

      if(var10000 != 64 && var4.portCount() > 0) {
         Iterator var8 = var4.ports();

         while(var8.hasNext()) {
            if(this.a(var1, (eU)var8.next())) {
               var3 |= 64;
               if(var7) {
                  return var3;
               }
               break;
            }
         }
      }

      if((this.b() & '쀀') != 0) {
         fj var9 = var4 instanceof gd?((gd)var4).e():var4;
         if(var9 instanceof y.h.b.a) {
            y.h.b.i var10 = ((y.h.b.a)var9).l();
            if((var3 & 16384) != 16384 && this.a(var1, (y.h.b.d)var10)) {
               var3 |= 16384;
            }

            if((var3 & '耀') != '耀' && this.a(var1, (y.h.b.g)var10)) {
               var3 |= '耀';
            }
         }
      }

      return var3;
   }

   private boolean a(bu var1, y.h.b.d var2) {
      boolean var6 = fj.z;
      int var3 = 0;
      int var4 = var2.k();

      boolean var10000;
      while(true) {
         if(var3 < var4) {
            y.h.b.c var5 = var2.b(var3);
            var10000 = this.a(var1, var5);
            if(var6) {
               break;
            }

            if(var10000) {
               return true;
            }

            if(var5.k() > 0 && this.a(var1, (y.h.b.d)var5)) {
               return true;
            }

            ++var3;
            if(!var6) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private boolean a(bu var1, y.h.b.g var2) {
      boolean var6 = fj.z;
      int var3 = 0;
      int var4 = var2.n();

      boolean var10000;
      while(true) {
         if(var3 < var4) {
            y.h.b.f var5 = var2.c(var3);
            var10000 = this.a(var1, var5);
            if(var6) {
               break;
            }

            if(var10000) {
               return true;
            }

            if(var5.n() > 0 && this.a(var1, (y.h.b.g)var5)) {
               return true;
            }

            ++var3;
            if(!var6) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   protected void a(bu var1, eU var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, y.c.q var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, y.c.d var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, gZ var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, x var2, boolean var3) {
      var1.a(var2, var3);
   }

   protected void a(bu var1, y.h.b.c var2, boolean var3) {
      var2.a(var3);
   }

   protected void a(bu var1, y.h.b.f var2, boolean var3) {
      var2.a(var3);
   }

   protected boolean a(bu var1, x var2) {
      return var1.a(var2);
   }

   protected boolean a(bu var1, gZ var2) {
      return var1.a(var2);
   }

   protected boolean b(bu var1, y.c.d var2) {
      return var1.r(var2);
   }

   protected boolean b(bu var1, y.c.q var2) {
      return var1.v(var2);
   }

   protected boolean a(bu var1, eU var2) {
      return var1.a(var2);
   }

   protected boolean a(bu var1, y.h.b.c var2) {
      return var2.e();
   }

   protected boolean a(bu var1, y.h.b.f var2) {
      return var2.e();
   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }
}
