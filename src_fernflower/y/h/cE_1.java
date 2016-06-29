package y.h;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.AbstractAction;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.ch;
import y.h.cm;
import y.h.cp;
import y.h.eR;
import y.h.eU;
import y.h.fM;
import y.h.fj;
import y.h.x;
import y.h.y;

public class cE extends AbstractAction {
   private final ch a;
   private int b;
   private boolean c;
   private boolean d;
   private Map e;
   private Map f;
   private Map g;
   private Set h;
   private boolean i;

   public cE() {
      this((ch)null);
   }

   public cE(ch var1) {
      super(cm.u.toString());
      this.a = var1;
      this.b = 639;
   }

   public int a() {
      return this.b;
   }

   public boolean b() {
      return this.c;
   }

   public boolean c() {
      return this.i;
   }

   protected boolean a(y.c.d var1, aA var2) {
      return (this.a() & 4) == 4 && var2.isSelected();
   }

   protected boolean a(y.c.d var1, x var2) {
      return (this.a() & 1) == 1 && var2.d();
   }

   protected boolean a(bu var1, y.c.d var2) {
      return (this.a() & 2) == 2 && var1.r(var2) || this.a(var1, var2, true) || this.a(var1, var2, false);
   }

   private boolean a(bu var1, y.c.d var2, boolean var3) {
      eU var4 = eU.a(var1, var2, var3);
      return var4 != null && this.a(var3?var2.c():var2.d(), var4);
   }

   protected boolean a(y.c.q var1, eR var2) {
      return (this.a() & 64) == 64 && (var2.isSelected() || this.e.containsKey(var2) && this.a(var1, (y.h.b.c)this.e.get(var2)) || this.f.containsKey(var2) && this.a(var1, (y.h.b.f)this.f.get(var2)) || this.g.containsKey(var2) && this.a(var1, (eU)this.g.get(var2)));
   }

   protected boolean a(y.c.q var1, y.h.b.c var2) {
      boolean var3 = (this.a() & 128) == 128 && var2.e();
      this.d |= var3;
      return var3;
   }

   protected boolean a(y.c.q var1, y.h.b.f var2) {
      boolean var3 = (this.a() & 256) == 256 && var2.e();
      this.d |= var3;
      return var3;
   }

   protected boolean a(bu var1, y.c.q var2) {
      int var3 = this.a();
      if(var1.v(var2)) {
         if(!(cm.a(var1, var2) instanceof y.h.b.a)) {
            y.h.a.v var4 = y.h.a.v.a((y.c.i)var1);
            return var4 != null && var4.k(var2)?(var3 & 16) == 16:(var3 & 8) == 8;
         } else {
            return (var3 & 32) == 32 && (!this.b() || !this.d);
         }
      } else {
         return false;
      }
   }

   protected boolean a(y.c.q var1, eU var2) {
      return (this.a() & 512) == 512 && var2.f();
   }

   protected void b(bu var1, y.c.q var2) {
      this.e(var1, var2);
      this.d(var1, var2);
      this.f(var1, var2);
   }

   private void d(bu var1, y.c.q var2) {
      boolean var10 = fj.z;
      y.h.a.a var3 = null;
      fj var4 = cm.a(var1, var2);
      boolean var5 = this.a(var4, var2);
      boolean var6 = this.a(var1, var2);
      if((var5 || var6) && this.c() && var1.C() != null) {
         y.c.q var7 = var1.C().n(var2);
         if(var7 != null) {
            if(this.h.add(var7)) {
               var1.a((new y.c.y(var7)).a());
            }

            y.h.a.a var8 = var1.t(var7).getAutoBoundsFeature();
            if(var8 != null && var8.isAutoBoundsEnabled()) {
               var8.setAutoBoundsEnabled(false);
               var3 = var8;
            }
         }
      }

      if(var5) {
         if(this.h.add(var2)) {
            var1.a((new y.c.y(var2)).a());
         }

         if(var2.a() > 0) {
            var1.a(var2.j());
         }
      }

      if(var4 instanceof y.h.b.a) {
         label153: {
            y.h.b.i var11 = ((y.h.b.a)var4).l();
            int var13 = var11.k();

            int var9;
            label154: {
               while(true) {
                  if(var13-- > 1) {
                     this.b(var2, var11.b(var13));
                     if(var10) {
                        break;
                     }

                     if(!var10) {
                        continue;
                     }
                  }

                  if(var11.k() > 1) {
                     this.b(var2, var11.b(0));
                     if(!var10) {
                        break label154;
                     }
                  }
                  break;
               }

               y.h.b.c var14 = var11.b(0);
               var9 = var14.k();

               while(var9-- > 0) {
                  this.b(var2, var14.b(var9));
                  if(var10) {
                     break label154;
                  }

                  if(var10) {
                     break;
                  }
               }

               if(this.a(var2, var14) && var14.k() > 0) {
                  this.c(var2, var14);
               }
            }

            var13 = var11.n();

            while(true) {
               if(var13-- > 1) {
                  this.b(var2, var11.c(var13));
                  if(var10) {
                     break;
                  }

                  if(!var10) {
                     continue;
                  }
               }

               if(var11.n() > 1) {
                  this.b(var2, var11.c(0));
                  if(!var10) {
                     break label153;
                  }
               }
               break;
            }

            y.h.b.f var15 = var11.c(0);
            var9 = var15.n();

            while(var9-- > 0) {
               this.b(var2, var15.c(var9));
               if(var10) {
                  break label153;
               }

               if(var10) {
                  break;
               }
            }

            if(this.a(var2, var15) && var15.n() > 0) {
               this.c(var2, var15);
            }
         }
      }

      int var12 = var4.portCount();

      while(true) {
         if(var12-- > 0) {
            eU var16 = var4.getPort(var12);
            if(!this.a(var2, var16)) {
               continue;
            }

            this.a(var4, var16, var12);
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         var12 = var4.labelCount();
         break;
      }

      while(true) {
         if(var12-- > 0) {
            eR var17 = var4.getLabel(var12);
            if(!this.a(var2, var17)) {
               continue;
            }

            this.a(var4, var17, var12);
            if(var10) {
               break;
            }

            if(!var10) {
               continue;
            }
         }

         if(var6) {
            this.c(var1, var2);
         }
         break;
      }

      if(var3 != null) {
         var3.setAutoBoundsEnabled(true);
      }

   }

   private void e(bu var1, y.c.q var2) {
      boolean var11 = fj.z;
      this.d = false;
      this.e = new HashMap();
      this.f = new HashMap();
      this.g = new HashMap();
      fj var3 = cm.a(var1, var2);
      if(var3.labelCount() > 0) {
         boolean var4 = var3 instanceof y.h.b.a;
         y.h.b.a var5 = var4?(y.h.b.a)var3:null;
         int var6 = 0;
         int var7 = var3.labelCount();

         while(var6 < var7) {
            label50: {
               eR var8 = var3.getLabel(var6);
               y.f.al var9 = var8.a();
               if(var9 instanceof fM) {
                  eU var10 = fM.a(var3, var8.getModelParameter());
                  if(var10 == null) {
                     break label50;
                  }

                  this.g.put(var8, var10);
                  if(!var11) {
                     break label50;
                  }
               }

               if(var4) {
                  label51: {
                     if(var9 instanceof y.h.b.e) {
                        y.h.b.c var12 = y.h.b.e.a(var5, var8.getModelParameter());
                        if(var12 == null) {
                           break label51;
                        }

                        this.e.put(var8, var12);
                        if(!var11) {
                           break label51;
                        }
                     }

                     if(var9 instanceof y.h.b.h) {
                        y.h.b.f var13 = y.h.b.h.a(var5, var8.getModelParameter());
                        if(var13 != null) {
                           this.f.put(var8, var13);
                        }
                     }
                  }
               }
            }

            ++var6;
            if(var11) {
               break;
            }
         }
      }

   }

   private void f(bu var1, y.c.q var2) {
      this.g = null;
      this.f = null;
      this.e = null;
      this.d = false;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
         var2.getGraph2D().T();
      }

   }

   public void a(ch var1) {
      boolean var7 = fj.z;
      bu var2 = var1.getGraph2D();
      var2.r();
      boolean var9 = false;

      try {
         var9 = true;
         y.c.e var3 = var2.p();

         label101: {
            while(var3.f()) {
               this.b(var2, var3.a());
               var3.g();
               if(var7) {
                  break label101;
               }

               if(var7) {
                  break;
               }
            }

            this.h = new HashSet();
         }

         label132: {
            y.h.a.v var11 = var2.C();
            if(var11 == null) {
               y.c.x var4 = var2.o();

               do {
                  if(!var4.f()) {
                     break label132;
                  }

                  this.b(var2, var4.e());
                  var4.g();
                  if(var7) {
                     var9 = false;
                     return;
                  }
               } while(!var7);
            }

            ArrayList var12 = new ArrayList(var2.f());
            var11.a((y.c.q)var11.e((y.c.i)var2), (y.h.a.y)(new cp(this, var12)));
            Iterator var5 = var12.iterator();

            while(var5.hasNext()) {
               this.b(var2, (y.c.q)var5.next());
               if(var7) {
                  var9 = false;
                  return;
               }

               if(var7) {
                  break;
               }
            }
         }

         this.h = null;
         var9 = false;
      } finally {
         if(var9) {
            var2.s();
         }
      }

      var2.s();
   }

   protected void b(bu var1, y.c.d var2) {
      boolean var6 = fj.z;
      aB var3 = var1.i(var2);
      if(this.a(var3, var2)) {
         var1.a((new y.c.f(var2)).a());
         var3 = var1.i(var2);
      }

      y var4 = var3.bends();

      int var10000;
      while(true) {
         if(var4.f()) {
            var10000 = this.a(var2, var4.a());
            if(var6) {
               break;
            }

            if(var10000 != 0) {
               this.a(var3, var4.a());
            }

            var4.g();
            if(!var6) {
               continue;
            }
         }

         var10000 = var3.labelCount();
         break;
      }

      int var7 = var10000;

      while(true) {
         if(var7-- > 0) {
            aA var5 = var3.getLabel(var7);
            if(!this.a(var2, var5)) {
               continue;
            }

            this.a(var3, var5, var7);
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         if(this.a(var1, var2)) {
            this.c(var1, var2);
         }
         break;
      }

   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }

   boolean a(aB var1, y.c.d var2) {
      boolean var4 = fj.z;
      y var3 = var1.bends();

      int var10000;
      while(true) {
         if(var3.f()) {
            var10000 = this.a(var2, var3.a());
            if(var4) {
               break;
            }

            if(var10000 != 0) {
               return true;
            }

            var3.g();
            if(!var4) {
               continue;
            }
         }

         var10000 = var1.labelCount();
         break;
      }

      boolean var6;
      if(var10000 > 0) {
         int var5 = 0;

         while(var5 < var1.labelCount()) {
            var6 = this.a(var2, var1.getLabel(var5));
            if(var4) {
               return var6;
            }

            if(var6) {
               return true;
            }

            ++var5;
            if(var4) {
               break;
            }
         }
      }

      var6 = false;
      return var6;
   }

   boolean a(fj var1, y.c.q var2) {
      boolean var10000;
      boolean var6;
      int var10;
      label85: {
         var6 = fj.z;
         if(var1 instanceof y.h.b.a) {
            y.h.b.i var3 = ((y.h.b.a)var1).l();
            ArrayList var4 = new ArrayList();
            var4.addAll(var3.l());

            label81: {
               while(!var4.isEmpty()) {
                  y.h.b.c var5 = (y.h.b.c)var4.remove(var4.size() - 1);
                  var10000 = this.a(var2, var5);
                  if(var6) {
                     break label81;
                  }

                  if(var10000) {
                     return true;
                  }

                  var4.addAll(var5.l());
                  if(var6) {
                     break;
                  }
               }

               var4.clear();
               var4.addAll(var3.o());
            }

            while(!var4.isEmpty()) {
               y.h.b.f var9 = (y.h.b.f)var4.remove(var4.size() - 1);
               var10 = this.a(var2, var9);
               if(var6) {
                  break label85;
               }

               if(var10 != 0) {
                  return true;
               }

               var4.addAll(var9.o());
               if(var6) {
                  break;
               }
            }
         }

         var10 = var1.portCount();
      }

      label60: {
         if(var10 > 0) {
            Iterator var7 = var1.ports();

            while(var7.hasNext()) {
               if(this.a(var2, (eU)var7.next())) {
                  var10 = 1;
                  if(!var6) {
                     return true;
                  }
                  break label60;
               }
            }
         }

         var10 = var1.labelCount();
      }

      if(var10 > 0) {
         int var8 = 0;

         while(var8 < var1.labelCount()) {
            var10000 = this.a(var2, var1.getLabel(var8));
            if(var6) {
               return var10000;
            }

            if(var10000) {
               return true;
            }

            ++var8;
            if(var6) {
               break;
            }
         }
      }

      var10000 = false;
      return var10000;
   }

   boolean b(y.c.q var1, y.h.b.c var2) {
      boolean var5 = fj.z;
      boolean var3 = false;
      int var4 = var2.k();

      while(true) {
         if(var4-- > 0) {
            var3 |= this.b(var1, var2.b(var4));
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         if(this.a(var1, var2)) {
            this.c(var1, var2);
            return true;
         }
         break;
      }

      return var3;
   }

   boolean b(y.c.q var1, y.h.b.f var2) {
      boolean var5 = fj.z;
      boolean var3 = false;
      int var4 = var2.n();

      while(true) {
         if(var4-- > 0) {
            var3 |= this.b(var1, var2.c(var4));
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         if(this.a(var1, var2)) {
            this.c(var1, var2);
            return true;
         }
         break;
      }

      return var3;
   }

   protected void c(bu var1, y.c.d var2) {
      var1.a((y.c.d)var2);
   }

   protected void a(aB var1, aA var2, int var3) {
      var1.removeLabel(var2);
   }

   protected void a(aB var1, x var2) {
      var1.removeBend(var2);
   }

   protected void c(bu var1, y.c.q var2) {
      var1.a((y.c.q)var2);
   }

   protected void a(fj var1, eR var2, int var3) {
      var1.removeLabel(var2);
   }

   protected void a(fj var1, eU var2, int var3) {
      var1.removePort(var3);
   }

   protected void c(y.c.q var1, y.h.b.c var2) {
      var2.c();
   }

   protected void c(y.c.q var1, y.h.b.f var2) {
      var2.c();
   }
}
