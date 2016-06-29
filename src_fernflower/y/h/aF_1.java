package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import y.h.C;
import y.h.aA;
import y.h.aB;
import y.h.aG;
import y.h.aH;
import y.h.aI;
import y.h.aJ;
import y.h.aK;
import y.h.aL;
import y.h.aM;
import y.h.aP;
import y.h.aQ;
import y.h.aR;
import y.h.aS;
import y.h.aT;
import y.h.aU;
import y.h.aV;
import y.h.aW;
import y.h.aX;
import y.h.aY;
import y.h.cW;
import y.h.ch;
import y.h.dx;
import y.h.dy;
import y.h.fj;
import y.h.x;

public class aF extends aB implements dy {
   private aY b;
   private Object c;
   private Map d;
   static final aM a = new aM((aG)null);

   public static aM a() {
      return a;
   }

   public aF() {
      this.b = a().a();
   }

   public aF(aB var1) {
      label11: {
         super();
         if(var1 instanceof aF) {
            this.b((aF)var1);
            if(!fj.z) {
               break label11;
            }
         }

         this.b = a().a();
      }

      super.b(var1);
   }

   public dy getMouseInputEditorProvider() {
      return this.b.b != null?this:null;
   }

   public dx a(ch var1, double var2, double var4, cW var6) {
      return this.b.b != null?this.b.b.a(this, var1, var2, var4, var6):null;
   }

   private void b(aF var1) {
      this.b = var1.b;
      if(this.d != null) {
         this.d.clear();
      }

      if(this.b.o != null) {
         this.b.o.a(this);
      }

      if(var1.d != null && var1.d.size() > 0) {
         if(this.d == null) {
            this.d = new HashMap();
         }

         this.d.putAll(var1.d);
      }

      if(this.o() != null) {
         this.c = this.o().a(var1, var1.c, (aB)this);
         if(!fj.z) {
            return;
         }
      }

      this.c = var1.c;
   }

   public void calcUnionRect(Rectangle2D var1) {
      boolean var5 = fj.z;
      aW var2 = this.m();
      if(var2 != null) {
         var2.a(this, this.bends, this.path, var1);
         if(!var5) {
            return;
         }
      }

      super.calcUnionRect(var1);
      y.c.p var3;
      x var4;
      if(this.isSelected()) {
         var3 = this.bends.k();

         do {
            if(var3 == null) {
               return;
            }

            var4 = (x)var3.c();
            var1.add(var4.b(), var4.c());
            var3 = var3.a();
         } while(!var5);
      }

      var3 = this.bends.k();

      while(var3 != null) {
         var4 = (x)var3.c();
         if(var4.d()) {
            var1.add(var4.b(), var4.c());
         }

         var3 = var3.a();
         if(var5) {
            break;
         }
      }

   }

   public void reInsertBend(x var1, x var2, int var3) {
      this.k().a(this, this.bends, var1, var2, var3);
   }

   public x removeBend(x var1) {
      return this.k().a(this, this.bends, var1);
   }

   public aB createCopy(aB var1) {
      return new aF(var1);
   }

   public x createBend(double var1, double var3, x var5, int var6) {
      return this.k().a(this, this.bends, var1, var3, var5, var6);
   }

   protected void paintArrows(Graphics2D var1) {
      aH var2 = this.e();
      if(var2 != null) {
         var2.a(this, this.bends, this.path, var1);
         if(!fj.z) {
            return;
         }
      }

      super.paintArrows(var1);
   }

   protected void paintLabels(Graphics2D var1) {
      aR var2 = this.d();
      if(var2 != null) {
         var2.a(this, var1);
         if(!fj.z) {
            return;
         }
      }

      super.paintLabels(var1);
   }

   public void bendChanged(x var1, double var2, double var4) {
      this.k().a(this, this.bends, var1, var2, var4);
   }

   public x insertBend(double var1, double var3) {
      return this.k().a(this, this.bends, var1, var3);
   }

   public void registerObstacles(C var1) {
      aK var2 = this.b();
      if(var2 != null) {
         if(this.isDirty()) {
            this.recalculateFeatures();
         }

         var2.a(this, this.bends, this.path, var1);
         if(!fj.z) {
            return;
         }
      }

      super.registerObstacles(var1);
   }

   private final aK b() {
      return this.b.d;
   }

   private aS c() {
      return this.b.g;
   }

   private aR d() {
      return this.b.c;
   }

   private aH e() {
      return this.b.e;
   }

   private aL g() {
      return this.b.j;
   }

   private aP j() {
      return this.b.l;
   }

   private aI k() {
      return this.b.k;
   }

   private aT l() {
      return this.b.i;
   }

   private aW m() {
      return this.b.f;
   }

   private aU n() {
      return this.b.h;
   }

   private aX o() {
      return this.b.m;
   }

   private aJ p() {
      return this.b.n;
   }

   protected byte calculatePath(Point2D var1, Point2D var2) {
      return this.l().a(this, this.bends, this.path, var1, var2);
   }

   public void paint(Graphics2D var1) {
      if((this.pb & 1) != 0) {
         if(this.isDirty()) {
            this.recalculateFeatures();
         }

         if((this.pb & 2) != 0) {
            aS var2 = this.c();
            if(var2 != null) {
               boolean var3 = b(this, var1);
               var2.a(this, this.bends, this.path, var1, var3);
               if(!fj.z) {
                  return;
               }
            }

            super.paint(var1);
         }
      }
   }

   protected void paintPorts(Graphics2D var1) {
      aU var2 = this.n();
      if(var2 != null) {
         var2.a(this, this.bends, this.path, var1);
         if(!fj.z) {
            return;
         }
      }

      super.paintPorts(var1);
   }

   protected void paintHighlightedBends(Graphics2D var1) {
      aJ var2 = this.p();
      if(var2 != null) {
         var2.a(this, this.bends, this.path, var1, true);
         if(!fj.z) {
            return;
         }
      }

      super.paintHighlightedBends(var1);
   }

   protected void paintBends(Graphics2D var1) {
      aJ var2 = this.p();
      if(var2 != null) {
         var2.a(this, this.bends, this.path, var1, false);
         if(!fj.z) {
            return;
         }
      }

      super.paintBends(var1);
   }

   public void paintSloppy(Graphics2D var1) {
      if((this.pb & 1) != 0) {
         aS var2 = this.c();
         if(var2 != null) {
            if(this.isDirty()) {
               this.recalculateFeatures();
            }

            if((this.pb & 2) == 0) {
               return;
            }

            boolean var3 = b(this, var1);
            var2.b(this, this.bends, this.path, var1, var3);
            if(!fj.z) {
               return;
            }
         }

         super.paintSloppy(var1);
      }
   }

   public int getMinBendCount() {
      return this.k().a(this);
   }

   public void clearBends() {
      while(this.bendCount() > this.getMinBendCount() && this.k().a(this, this.bends, this.firstBend()) != null) {
         ;
      }

   }

   public boolean contains(double var1, double var3) {
      aL var5 = this.g();
      return var5 != null?var5.a(this, this.bends, this.path, var1, var3):super.contains(var1, var3);
   }

   public int containsSeg(double var1, double var3) {
      aL var5 = this.g();
      return var5 != null?var5.b(this, this.bends, this.path, var1, var3):super.containsSeg(var1, var3);
   }

   public boolean pathIntersects(Rectangle2D var1, boolean var2) {
      aP var3 = this.j();
      return var3 != null?var3.a(this, this.bends, this.path, var1, var2):super.pathIntersects(var1, var2);
   }

   public aA createEdgeLabel() {
      aQ var1 = this.b.q;
      return var1 != null?var1.a(this):super.createEdgeLabel();
   }

   void f() {
      aV var1 = this.b.p;
      if(var1 != null) {
         var1.a(this);
      }

   }

   public void read(ObjectInputStream var1) {
      boolean var5 = fj.z;
      boolean var2;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         a().a(this, (String)var1.readObject());
         var2 = var1.readBoolean();
         if(!var2) {
            break;
         }

         if(this.o() != null) {
            this.c = this.o().a(this, var1);
            if(!var5) {
               break;
            }
         }

         throw new y.e.a("No UserDataHandler registered to read userData!");
      case 1:
         super.read(var1);
         a().a(this, (String)var1.readObject());
         var2 = var1.readBoolean();
         if(var2) {
            if(this.o() == null) {
               throw new y.e.a("No UserDataHandler registered to read userData!");
            }

            this.c = this.o().a(this, var1);
            if(var5) {
               throw new y.e.a("No UserDataHandler registered to read userData!");
            }
         }

         int var3;
         label42: {
            var3 = var1.readInt();
            if(this.d == null) {
               this.d = new HashMap();
               if(!var5) {
                  break label42;
               }
            }

            this.d.clear();
         }

         int var4 = 0;

         do {
            if(var4 >= var3) {
               return;
            }

            this.d.put(var1.readObject(), var1.readObject());
            ++var4;
         } while(!var5);

         throw new y.e.a();
      default:
         throw new y.e.a();
      }

   }

   public void write(ObjectOutputStream var1) {
      boolean var4 = fj.z;
      if(this.d == null || this.d.size() == 0) {
         var1.writeByte(0);
         super.write(var1);
         var1.writeObject(this.b.a);
         if(this.o() != null) {
            var1.writeBoolean(true);
            this.o().a(this, this.c, (ObjectOutputStream)var1);
            if(!var4) {
               return;
            }
         }

         var1.writeBoolean(false);
         if(!var4) {
            return;
         }
      }

      label25: {
         var1.writeByte(1);
         super.write(var1);
         var1.writeObject(this.b.a);
         if(this.o() != null) {
            var1.writeBoolean(true);
            this.o().a(this, this.c, (ObjectOutputStream)var1);
            if(!var4) {
               break label25;
            }
         }

         var1.writeBoolean(false);
      }

      var1.writeInt(this.d.size());
      Iterator var2 = this.d.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.writeObject(var3.getKey());
         var1.writeObject(var3.getValue());
         if(var4) {
            break;
         }
      }

   }

   static aY a(aF var0) {
      return var0.b;
   }

   static aY a(aF var0, aY var1) {
      return var0.b = var1;
   }
}
