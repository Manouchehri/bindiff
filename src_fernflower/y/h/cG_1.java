package y.h;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import javax.swing.AbstractAction;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cO;
import y.h.cP;
import y.h.ch;
import y.h.cm;
import y.h.eR;
import y.h.fj;
import y.h.gZ;

public class cG extends AbstractAction {
   private final ch a;

   public cG() {
      this((ch)null);
   }

   public cG(ch var1) {
      super(cm.B.toString());
      this.a = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      ch var2 = this.a(var1);
      if(var2 != null) {
         this.a(var2);
      }

   }

   public void a(ch var1) {
      gZ var2 = this.b(var1);
      if(var2 != null && a(var1, var2)) {
         Object var5;
         label14: {
            PropertyChangeListener var3 = this.a();
            cO var4 = new cO(this, var1.getGraph2D(), var2);
            if(var3 != null) {
               cP var6 = new cP();
               var6.add(var4);
               var6.add(var3);
               var5 = var6;
               if(!fj.z) {
                  break label14;
               }
            }

            var5 = var4;
         }

         this.a(var1, var2, (PropertyChangeListener)var5, this.b());
      }
   }

   protected PropertyChangeListener a() {
      Object var1 = this.getValue("PROPERTY_CHANGE_LISTENER");
      return var1 instanceof PropertyChangeListener?(PropertyChangeListener)var1:null;
   }

   protected boolean b() {
      Object var1 = this.getValue("SINGLE_LINE_MODE");
      return var1 instanceof Boolean?((Boolean)var1).booleanValue():true;
   }

   protected void a(ch var1, gZ var2, PropertyChangeListener var3, boolean var4) {
      y.d.t var5 = var2.transformCTW(var2.getTextBox()).k();
      var1.openLabelEditorCentered(var2, var5.a, var5.b, var3, var4);
   }

   protected ch a(ActionEvent var1) {
      return cm.a(var1, this.a);
   }

   protected gZ b(ch var1) {
      return this.a(var1.getGraph2D());
   }

   gZ a(bu var1) {
      boolean var7 = fj.z;
      Object var2 = null;
      if(!var1.H()) {
         y.c.C var3 = var1.L();
         if(var3.f()) {
            var2 = (gZ)var3.d();
         } else {
            y.c.x var4 = var1.J();
            if(var4.f()) {
               y.c.q var5 = var4.e();
               fj var6 = cm.a(var1, var5);
               if(var6 instanceof y.h.b.a) {
                  var2 = this.a((y.h.b.a)var6);
               }

               if(var2 == null) {
                  label43: {
                     if(var6.labelCount() > 0) {
                        var2 = var6.getLabel();
                        if(!var7) {
                           break label43;
                        }
                     }

                     var2 = this.a(var6);
                  }
               }
            } else {
               y.c.e var10 = var1.K();
               if(var10.f()) {
                  aB var12 = var1.i(var10.a());
                  if(var12.labelCount() > 0) {
                     var2 = var12.getLabel();
                  } else {
                     var2 = this.a(var12);
                  }
               }
            }
         }
      }

      if(var2 == null) {
         y.c.x var8 = var1.o();

         while(var8.f()) {
            y.c.q var9 = var8.e();
            fj var11 = cm.a(var1, var9);
            if(var11 instanceof y.h.b.a) {
               var2 = this.a((y.h.b.a)var11);
               if(var2 != null) {
                  break;
               }
            }

            var8.g();
            if(var7) {
               break;
            }
         }
      }

      return (gZ)var2;
   }

   protected aA a(aB var1) {
      return var1.getLabel();
   }

   protected eR a(fj var1) {
      return var1.getLabel();
   }

   protected eR a(y.h.b.a var1, y.h.b.c var2) {
      eR var3 = var1.createNodeLabel();
      var1.addLabel(var3);
      var1.a(var3, var2, true, 0.0D);
      return var3;
   }

   protected eR a(y.h.b.a var1, y.h.b.f var2) {
      eR var3 = var1.createNodeLabel();
      var1.addLabel(var3);
      var1.a(var3, var2, true, 0.0D);
      return var3;
   }

   eR a(y.h.b.a var1) {
      boolean var7 = fj.z;
      Collection var2 = var1.l().b();
      Collection var3 = var1.l().c();
      if(var2.size() + var3.size() > 0) {
         int var4 = 0;

         do {
            int var10000;
            if(var4 >= var1.labelCount()) {
               var10000 = var2.size();
               return var10000 > 0?this.a(var1, (y.h.b.f)var2.iterator().next()):(var3.size() > 0?this.a(var1, (y.h.b.c)var3.iterator().next()):null);
            }

            eR var5 = var1.getLabel(var4);
            var10000 = var5.a() instanceof y.h.b.h;
            if(var7) {
               return var10000 > 0?this.a(var1, (y.h.b.f)var2.iterator().next()):(var3.size() > 0?this.a(var1, (y.h.b.c)var3.iterator().next()):null);
            }

            if(var10000 != 0) {
               y.h.b.f var6 = y.h.b.h.a(var5);
               if(var2.contains(var6)) {
                  return var5;
               }
            } else if(var5.a() instanceof y.h.b.e) {
               y.h.b.c var8 = y.h.b.e.a(var5);
               if(var3.contains(var8)) {
                  return var5;
               }
            }

            ++var4;
         } while(!var7);
      }

      return null;
   }

   protected void a(gZ var1, String var2) {
      var1.setText(var2);
   }

   private static boolean a(ch var0, gZ var1) {
      Rectangle var2 = var0.getVisibleRect();
      return y.d.y.a(var1.getBox(), new y.d.y((double)var2.x, (double)var2.y, (double)var2.width, (double)var2.height));
   }
}
