package y.h.b;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.eR;
import y.h.fj;
import y.h.b.a;
import y.h.b.aa;
import y.h.b.ae;
import y.h.b.c;
import y.h.b.e;
import y.h.b.f;
import y.h.b.h;

public class u extends ae {
   private int a = -1;
   private f b;
   private c c;
   private boolean d = true;
   private boolean e = true;

   public boolean a(double var1, double var3) {
      int var11 = a.H;
      this.a = -1;
      this.b = null;
      this.c = null;
      if(this.h != null && this.i != null) {
         cW var5 = new cW(this.h, var1, var3, true);
         y.c.q var6 = this.a((cW)var5);
         if(var6 != null) {
            bu var7 = this.h.getGraph2D();
            if(var7 != null && a((bu)var7, (y.c.q)var6) == this.i) {
               a var10000;
               label41: {
                  if(var5.s()) {
                     eR var8 = var5.l();
                     int var9 = 0;
                     int var10 = this.i.labelCount();

                     while(var9 < var10) {
                        var10000 = this.i;
                        if(var11 != 0) {
                           break label41;
                        }

                        if(var10000.getLabel(var9) == var8) {
                           this.a = var9;
                           return true;
                        }

                        ++var9;
                        if(var11 != 0) {
                           break;
                        }
                     }
                  }

                  var10000 = this.i;
               }

               f var12 = var10000.l().a(var1, var3);
               if(var12 != null && this.a(var12, var1, var3)) {
                  this.b = var12;
                  return true;
               }

               c var13 = this.i.l().b(var1, var3);
               if(var13 != null && this.a(var13, var1, var3)) {
                  this.c = var13;
                  return true;
               }
            }
         }
      }

      this.i();
      return false;
   }

   protected boolean a(c var1, double var2, double var4) {
      return this.a(this.i, var1, var2, var4, this.h());
   }

   protected boolean a(f var1, double var2, double var4) {
      return this.a(this.i, var1, var2, var4, this.h());
   }

   protected eR a(f var1) {
      Collection var2 = h.a(var1);
      return var2.isEmpty()?(this.g()?this.b(var1):null):(eR)var2.iterator().next();
   }

   protected eR a(c var1) {
      Collection var2 = e.a(var1);
      return var2.isEmpty()?(this.g()?this.b(var1):null):(eR)var2.iterator().next();
   }

   protected eR b(f var1) {
      a var2 = a.a(var1);
      eR var3 = var2.createNodeLabel();
      var2.a(var3, var1, true, 0.0D);
      var2.addLabel(var3);
      return var3;
   }

   protected eR b(c var1) {
      a var2 = a.a(var1);
      eR var3 = var2.createNodeLabel();
      var2.a(var3, var1, true, 0.0D);
      var2.addLabel(var3);
      return var3;
   }

   public boolean g() {
      return this.d;
   }

   public boolean h() {
      return this.e;
   }

   public boolean a(dw var1) {
      return this.d(var1);
   }

   private boolean d(dw var1) {
      return this.h(var1) && this.a(var1.a(), var1.b());
   }

   public void b(dw var1) {
      int var6 = a.H;
      if(this.d(var1)) {
         y.c.q var2 = this.i.getNode();
         bu var3 = this.h.getGraph2D();
         var3.r();

         try {
            label97: {
               var3.a((new y.c.y(var2)).a());
               fj var4 = a((bu)var3, (y.c.q)var2);
               if(var4 == this.i) {
                  if(this.a > -1) {
                     a(this.h, this.i.getLabel(this.a));
                     if(var6 == 0) {
                        break label97;
                     }
                  }

                  if(this.b != null) {
                     this.a(this.h, this.b);
                     if(var6 == 0) {
                        break label97;
                     }
                  }

                  if(this.c == null) {
                     break label97;
                  }

                  this.a(this.h, this.c);
                  if(var6 == 0) {
                     break label97;
                  }
               }

               if(var4 instanceof a) {
                  label103: {
                     if(this.a > -1) {
                        a(this.h, var4.getLabel(this.a));
                        if(var6 == 0) {
                           break label103;
                        }
                     }

                     if(this.b != null) {
                        this.a(this.h, aa.a(this.b, (a)var4));
                        if(var6 == 0) {
                           break label103;
                        }
                     }

                     if(this.c != null) {
                        this.a(this.h, aa.a(this.c, (a)var4));
                     }
                  }
               }
            }
         } finally {
            var3.s();
         }
      }

      this.e();
   }

   void i() {
      super.i();
      this.b = null;
      this.c = null;
   }

   private void a(ch var1, f var2) {
      a(var1, this.a(var2));
   }

   private void a(ch var1, c var2) {
      a(var1, this.a(var2));
   }

   private static void a(ch var0, eR var1) {
      if(var1 != null) {
         y.d.t var2 = var1.transformCTW(var1.getTextBox()).k();
         var0.openLabelEditorCentered(var1, var2.a, var2.b, (PropertyChangeListener)null, true);
      }

   }
}
