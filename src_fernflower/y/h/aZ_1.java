package y.h;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Externalizable;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import y.h.ba;
import y.h.bb;
import y.h.bc;
import y.h.bd;
import y.h.be;
import y.h.bf;
import y.h.bh;
import y.h.bi;
import y.h.bk;
import y.h.bl;
import y.h.bm;
import y.h.bn;
import y.h.bo;
import y.h.bp;
import y.h.bq;
import y.h.br;
import y.h.bs;
import y.h.bt;
import y.h.cW;
import y.h.ch;
import y.h.dx;
import y.h.dy;
import y.h.eR;
import y.h.fj;
import y.h.gt;

public class aZ extends fj implements dy {
   protected bc a;
   Object b;
   private bt w;
   private Map A;
   static be c = new be((ba)null);
   static Class d;
   static Class e;
   static Class f;
   static Class g;
   static Class h;
   static Class i;
   static Class k;
   static Class l;
   static Class m;
   static Class n;
   static Class o;
   static Class p;
   static Class q;
   static Class r;
   static Class s;
   static Class t;
   static Class u;
   static Class v;

   public static be a() {
      return c;
   }

   public aZ() {
      this(a().b());
   }

   private aZ(bc var1) {
      this.a = var1;
      super.b("");
      be.a(this);
   }

   void b(String var1) {
   }

   public void a(String var1, Object var2) {
      if(this.A == null) {
         this.A = new HashMap();
      }

      this.A.put(var1, var2);
   }

   public Object a(String var1) {
      return this.A == null?null:this.A.get(var1);
   }

   public Set e() {
      return this.A == null?Collections.EMPTY_SET:Collections.unmodifiableSet(this.A.entrySet());
   }

   public void c(String var1) {
      if(this.A != null) {
         this.A.remove(var1);
         if(this.A.size() == 0) {
            this.A = null;
         }
      }

   }

   public aZ(fj var1) {
      super(var1);
      if(var1 instanceof aZ) {
         this.a((aZ)var1);
         if(!fj.z) {
            return;
         }
      }

      this.a = a().b();
   }

   public String f() {
      return this.a.a;
   }

   public void d(String var1) {
      a().a(this, var1);
   }

   protected void a(aZ var1) {
      this.a = var1.a;
      if(this.A != null) {
         this.A.clear();
      }

      if(this.a.o != null) {
         this.a.o.a(this);
      }

      if(var1.A != null && var1.A.size() > 0) {
         if(this.A == null) {
            this.A = new HashMap();
         }

         this.A.putAll(var1.A);
      }

      if(this.a.j != null) {
         this.b = this.a.j.a(var1, var1.b, (fj)this);
         if(!fj.z) {
            return;
         }
      }

      this.b = var1.b;
   }

   public fj createCopy(fj var1) {
      return new aZ(var1);
   }

   public void paintNode(Graphics2D var1) {
      if(b(this, var1)) {
         this.paintHotSpots(var1);
      }

      this.b(var1);
      if(b(var1, false)) {
         this.paintPorts(var1);
      }

      if(c(var1, false)) {
         this.paintText(var1);
      }

   }

   protected void boundsChanged() {
      bb var1 = this.a.k;
      if(var1 != null) {
         var1.a(this);
      }

   }

   protected void labelBoundsChanged(eR var1) {
      if(this.a != null) {
         bl var2 = this.a.l;
         if(var2 != null) {
            var2.a(this, var1);
         }
      }

   }

   public y.c.D getPortCandidates(double var1) {
      bp var3 = this.a.c;
      return var3 != null?var3.a(this, var1):super.getPortCandidates(var1);
   }

   public byte getLayer() {
      bn var1 = this.a.q;
      return var1 != null?var1.a(this):super.getLayer();
   }

   public void setLayer(byte var1) {
      bn var2 = this.a.q;
      if(var2 != null) {
         var2.a(this, var1);
         if(!fj.z) {
            return;
         }
      }

      super.setLayer(var1);
   }

   public void paint(Graphics2D var1) {
      bo var2 = this.a.e;
      if(var2 != null) {
         Graphics2D var3 = (Graphics2D)var1.create();

         try {
            var2.a(this, var3);
         } finally {
            var3.dispose();
         }
      } else {
         super.paint(var1);
      }

   }

   public void paintSloppy(Graphics2D var1) {
      bo var2 = this.a.e;
      if(var2 != null) {
         Graphics2D var3 = (Graphics2D)var1.create();

         try {
            var2.e(this, var3);
         } finally {
            var3.dispose();
         }
      } else {
         super.paintSloppy(var1);
      }

   }

   public boolean contains(double var1, double var3) {
      bd var5 = this.a.i;
      return var5 != null?var5.a(this, var1, var3):super.contains(var1, var3);
   }

   public byte hotSpotHit(double var1, double var3) {
      bh var5 = this.a.f;
      return var5 != null?var5.a(this, var1, var3):super.hotSpotHit(var1, var3);
   }

   public boolean findIntersection(double var1, double var3, double var5, double var7, Point2D var9) {
      bk var10 = this.a.h;
      return var10 != null?var10.a(this, var1, var3, var5, var7, var9):super.findIntersection(var1, var3, var5, var7, var9);
   }

   public void paintHotSpots(Graphics2D var1) {
      bi var2 = this.a.g;
      if(var2 != null) {
         Graphics2D var3 = (Graphics2D)var1.create();

         try {
            var2.a(this, var3);
         } finally {
            var3.dispose();
         }
      } else {
         super.paintHotSpots(var1);
      }

   }

   public void calcUnionRect(Rectangle2D var1) {
      br var2 = this.a.d;
      if(var2 != null) {
         var2.a(this, var1);
         if(!fj.z) {
            return;
         }
      }

      super.calcUnionRect(var1);
   }

   public eR createNodeLabel() {
      bm var1 = this.a.r;
      return var1 != null?var1.a(this):super.createNodeLabel();
   }

   void c() {
      bq var1 = this.a.p;
      if(var1 != null) {
         var1.a(this);
      }

   }

   private y.g.ag g() {
      return y.g.X.b();
   }

   public void read(ObjectInputStream var1) {
      boolean var9 = fj.z;
      boolean var2;
      bs var3;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         a().a(this, (String)var1.readObject());
         var2 = var1.readBoolean();
         if(var2) {
            var3 = this.a.j;
            if(var3 == null) {
               throw new y.e.a("No userDataHandler registered to read userData!");
            }

            this.b = var3.a(this, var1);
            if(var9) {
               throw new y.e.a("No userDataHandler registered to read userData!");
            }
         }
         break;
      case 1:
         super.read(var1);
         a().a(this, (String)var1.readObject());
         var2 = var1.readBoolean();
         if(var2) {
            var3 = this.a.j;
            if(var3 == null) {
               throw new y.e.a("No userDataHandler registered to read userData!");
            }

            this.b = var3.a(this, var1);
            if(var9) {
               throw new y.e.a("No userDataHandler registered to read userData!");
            }
         }

         int var12;
         label49: {
            var12 = var1.readInt();
            if(this.A == null) {
               this.A = new HashMap();
               if(!var9) {
                  break label49;
               }
            }

            this.A.clear();
         }

         y.g.ag var4 = this.g();
         int var5 = 0;

         while(var5 < var12) {
            Object var6;
            switch(var1.readByte()) {
            case 1:
               var6 = var1.readObject();

               try {
                  Object var13 = Class.forName(y.e.h.b((String)var1.readObject())).newInstance();
                  ((Externalizable)var13).readExternal(var1);
                  this.A.put(var6, var13);
                  break;
               } catch (InstantiationException var10) {
                  throw new InvalidClassException(var10.getMessage());
               } catch (IllegalAccessException var11) {
                  throw new InvalidClassException(var11.getMessage());
               }
            case 2:
               this.A.put(var1.readObject(), var1.readObject());
               if(!var9) {
                  break;
               }
            case 127:
               label63: {
                  var6 = var1.readObject();
                  Class var7 = Class.forName(y.e.h.b((String)var1.readObject()));
                  String var8 = (String)var1.readObject();
                  if(var8 == null) {
                     this.A.put(var6, var8);
                     if(!var9) {
                        break label63;
                     }
                  }

                  this.A.put(var6, var4.a(var8, var7));
               }
            }

            ++var5;
            if(var9) {
               throw new y.e.a();
            }
         }
         break;
      default:
         throw new y.e.a();
      }

   }

   public void write(ObjectOutputStream var1) {
      boolean var9 = fj.z;
      Map var2 = this.A;
      bs var3;
      if(var2 == null || var2.isEmpty()) {
         var1.writeByte(0);
         super.write(var1);
         var1.writeObject(this.a.a);
         var3 = this.a.j;
         if(var3 != null) {
            var1.writeBoolean(true);
            var3.a(this, this.b, (ObjectOutputStream)var1);
            if(!var9) {
               return;
            }
         }

         var1.writeBoolean(false);
         if(!var9) {
            return;
         }
      }

      label73: {
         var1.writeByte(1);
         super.write(var1);
         var1.writeObject(this.a.a);
         var3 = this.a.j;
         if(var3 != null) {
            var1.writeBoolean(true);
            var3.a(this, this.b, (ObjectOutputStream)var1);
            if(!var9) {
               break label73;
            }
         }

         var1.writeBoolean(false);
      }

      ArrayList var4 = new ArrayList(var2.size());
      Iterator var5 = var2.entrySet().iterator();

      label67: {
         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            if(!"y.view.hierarchy.GroupNodePainter.GROUP_STATE_STYLE".equals(var6.getKey())) {
               var4.add(var6);
               if(var9) {
                  break label67;
               }

               if(var9) {
                  break;
               }
            }
         }

         var1.writeInt(var4.size());
      }

      y.g.ag var10 = this.g();
      Iterator var11 = var4.iterator();

      do {
         Object var8;
         do {
            Entry var7;
            do {
               do {
                  if(!var11.hasNext()) {
                     return;
                  }

                  var7 = (Entry)var11.next();
                  var8 = var7.getValue();
                  if(!(var8 instanceof Externalizable)) {
                     break;
                  }

                  var1.writeByte(1);
                  var1.writeObject(var7.getKey());
                  var1.writeObject(y.e.h.a(var8.getClass().getName()));
                  ((Externalizable)var8).writeExternal(var1);
               } while(!var9);

               if(!(var8 instanceof Serializable)) {
                  break;
               }

               var1.writeByte(2);
               var1.writeObject(var7.getKey());
               var1.writeObject(var7.getValue());
            } while(!var9);

            var1.writeByte(127);
            var1.writeObject(var7.getKey());
            if(var8 != null) {
               break;
            }

            var1.writeObject(d == null?(d = e("java.lang.Object")):d);
            var1.writeObject((Object)null);
         } while(!var9);

         var1.writeObject(y.e.h.a(var8.getClass().getName()));
         var1.writeObject(var10.a(var8, var8.getClass()));
      } while(!var9);

   }

   public dy getMouseInputEditorProvider() {
      return this.a.b != null?this:null;
   }

   public dx a(ch var1, double var2, double var4, cW var6) {
      bf var7 = this.a.b;
      return var7 != null?var7.a(this, var1, var2, var4, var6):null;
   }

   public gt getSizeConstraintProvider() {
      if(this.a.n != null) {
         if(this.w == null) {
            this.w = new bt(this);
         }

         return this.w;
      } else {
         this.w = null;
         return super.getSizeConstraintProvider();
      }
   }

   static Class e(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
