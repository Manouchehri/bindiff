package y.h;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import y.h.aB;
import y.h.ay;
import y.h.bu;
import y.h.fj;
import y.h.gZ;
import y.h.gs;
import y.h.hb;
import y.h.hg;
import y.h.hh;
import y.h.hj;
import y.h.s;
import y.h.u;

public class aA extends gZ implements y.f.C {
   static final byte lb = 7;
   public static final byte HEAD = 10;
   public static final byte TAIL = 11;
   public static final byte CENTER = 12;
   public static final byte SHEAD = 13;
   public static final byte THEAD = 14;
   public static final byte STAIL = 15;
   public static final byte TTAIL = 16;
   public static final byte SCENTR = 17;
   public static final byte TCENTR = 18;
   public static final byte ANYWHERE = 99;
   public static final byte CENTER_RATIO = 19;
   public static final byte TAIL_RATIO = 20;
   public static final byte HEAD_RATIO = 21;
   public static final byte DYNAMIC = 24;
   public static final byte UNDEFINED = 127;
   public static final byte TWO_POS = 0;
   public static final byte CENTERED = 1;
   public static final byte SIX_POS = 2;
   public static final byte THREE_CENTER = 3;
   public static final byte FREE = 4;
   public static final byte CENTER_SLIDER = 5;
   public static final byte SIDE_SLIDER = 6;
   public static final byte CUSTOM_LABEL_MODEL = 127;
   private static final byte[][] jb = new byte[][]{{(byte)10, (byte)11}, {(byte)12}, {(byte)10, (byte)13, (byte)14, (byte)11, (byte)15, (byte)16}, {(byte)12, (byte)17, (byte)18}, {(byte)99}, {(byte)24}, {(byte)24}};
   private double rb;
   private y.f.E kb;
   private Object sb;
   private aB pb;
   private double nb;
   private y.f.aG mb;
   private static final hb ob;
   private static final hg qb;
   static Class class$y$view$YLabel$BoundsProvider;
   static Class class$y$view$YLabel$Layout;
   static Class class$y$view$YLabel$Painter;
   static Class class$y$view$YLabel$UserDataHandler;
   static Class class$y$layout$DiscreteEdgeLabelModel;
   static Class class$y$layout$FreeEdgeLabelModel;
   static Class class$y$layout$SliderEdgeLabelModel;

   public aA(String var1, byte var2) {
      this.rb = 0.5D;
      this.nb = 2.0D;
      this.mb = y.f.aG.g((byte)0);
      this.kb = new y.f.z(63);
      this.sb = this.kb.c();
      this.setModel(var2);
      this.setText(var1);
   }

   hg c() {
      return qb;
   }

   public aA(String var1) {
      this(var1, (byte)2);
   }

   void b() {
      if(this.pb != null && this.pb.getEdge() != null) {
         y.c.i var1 = this.pb.getEdge().a();
         if(var1 instanceof bu) {
            bu var2 = (bu)var1;
            var2.e(this);
         }
      }

   }

   public aA() {
      this("");
   }

   public Object clone() {
      aA var1 = new aA();
      var1.adoptValues(this);
      return var1;
   }

   public void adoptValues(gZ var1) {
      super.adoptValues(var1);
      if(var1 instanceof aA) {
         aA var2 = (aA)var1;
         this.sb = var2.sb;
         this.kb = var2.kb;
         this.nb = var2.nb;
         this.mb = var2.mb;
      }

   }

   public void calculateOffset() {
      try {
         bu var1 = this.getGraph2D();
         Point2D var2 = this.pb.getSourceIntersection();
         fj var3 = var1.t(this.getEdge().c());
         fj var4 = var1.t(this.getEdge().d());
         y.d.n var5 = this.getLabelModel().a(new y.d.q(this.getWidth(), this.getHeight()), this.pb, var3, var4, this.getModelParameter());
         var5.a(var5.a().b(-var2.getX(), -var2.getY()));
         super.setOffset(var5);
      } catch (Exception var6) {
         this.offsetRectangle.b(this.getWidth(), this.getHeight());
      }

   }

   public void setText(String var1) {
      String var2 = this.getText();
      super.setText(var1);
      bu var3 = this.getGraph2D();
      if(var3 != null) {
         var3.a(this, "text", var2, this.getText());
      }

   }

   public void setDistance(double var1) {
      this.nb = var1;
      if(this.kb instanceof y.f.aO) {
         ((y.f.aO)this.kb).a(this.nb, this.nb);
      }

      if(this.kb instanceof y.f.z) {
         ((y.f.z)this.kb).a(this.nb);
      }

      if(this.kb instanceof y.f.aJ) {
         ((y.f.aJ)this.kb).a(var1);
      }

      if(this.kb instanceof y.f.aL) {
         ((y.f.aL)this.kb).a(var1);
      }

      if(this.kb instanceof s) {
         ((s)this.kb).a(var1);
      }

      this.setOffsetDirty();
   }

   public void setOffset(double var1, double var3) {
      super.setOffset(var1, var3);
      if(this.kb instanceof y.f.K) {
         Object var5 = this.getBestModelParameterForOffset(var1, var3);
         if(var5 != null) {
            this.sb = var5;
            this.pb.h();
         }
      }

   }

   public double getDistance() {
      return this.nb;
   }

   public void setPreferredPlacement(byte var1) {
      this.mb = y.f.aG.g(var1);
   }

   public byte getPreferredPlacement() {
      byte var1 = this.mb.a();
      byte var2 = this.mb.b();
      return (byte)(var1 | var2);
   }

   public y.f.aG getPreferredPlacementDescriptor() {
      return this.mb;
   }

   public void setPreferredPlacementDescriptor(y.f.aG var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("null");
      } else {
         this.mb = var1;
      }
   }

   public double getRatio() {
      if(this.kb instanceof y.f.aO) {
         aB var3 = this.getOwner();
         y.f.aP var2 = (y.f.aP)this.b(this.getOrientedBox(), var3);
         return var2.e();
      } else {
         if(this.sb instanceof u) {
            u var1 = (u)this.sb;
            if(var1.b() < 0) {
               return var1.a();
            }
         }

         return 0.5D;
      }
   }

   public void setRatio(double var1) {
      boolean var13 = fj.z;
      if(this.kb instanceof s) {
         this.setModelParameter(new u(var1, -1));
      }

      if(this.kb instanceof y.f.aO) {
         y.f.aO var3 = (y.f.aO)this.kb;
         aB var4 = this.getOwner();
         if(var4 != null) {
            y.f.aP var5 = (y.f.aP)this.b(this.getOrientedBox(), var4);
            y.f.aP var6 = null;
            double var7 = Double.MAX_VALUE;
            y.c.D var9 = var3.a((y.f.C)this, var4, var4.getSourceRealizer(), var4.getTargetRealizer());
            y.c.C var10 = var9.m();

            y.f.aP var10000;
            label32: {
               while(var10.f()) {
                  y.f.B var11 = (y.f.B)var10.d();
                  y.f.aP var12 = (y.f.aP)var11.b();
                  var10000 = var12;
                  if(var13) {
                     break label32;
                  }

                  if(Math.abs(var12.e() - var1) < var7 && var12.d() == var5.d()) {
                     var7 = Math.abs(var12.e() - var1);
                     var6 = var12;
                  }

                  var10.g();
                  if(var13) {
                     break;
                  }
               }

               var10000 = var6;
            }

            if(var10000 != null) {
               this.setModelParameter(var6);
            }
         }
      }

   }

   public Object getBestModelParameterForBounds(y.d.n var1) {
      if(this.kb != null) {
         aB var2 = this.getOwner();
         if(var2 != null && var2.getEdge() != null && var2.getEdge().a() != null) {
            return this.b(var1, var2);
         }
      }

      return null;
   }

   public Object getBestModelParameterForOffset(double var1, double var3) {
      aB var5 = this.getOwner();
      if(var5 != null) {
         Point2D var6 = var5.getSourceIntersection();
         return this.b(this.d(var6.getX() + var1, var6.getY() + var3), var5);
      } else {
         return null;
      }
   }

   public Object getBestModelParameterForLocation(double var1, double var3) {
      aB var5 = this.getOwner();
      return var5 != null?this.b(this.d(var1, var3), var5):null;
   }

   private y.d.n d(double var1, double var3) {
      double var5 = this.getHeight();
      return new y.d.n(var1, var3 + var5, this.getWidth(), var5, 0.0D, -1.0D);
   }

   public boolean hasFreePositioning() {
      return this.model == 4;
   }

   public boolean hasSliderPositioning() {
      return this.model == 5 || this.model == 6;
   }

   public void setModel(byte var1) {
      boolean var19 = fj.z;
      if(var1 != this.model) {
         if(var1 >= 0 && var1 <= 7) {
            aB var2 = this.pb;
            boolean var3 = var2 != null && var2.getEdge() != null && var2.getEdge().a() != null;
            this.model = var1;
            y.f.E var4 = this.kb;
            switch(this.model) {
            case 0:
               this.kb = b((int)18, this.nb);
               if(!var19) {
                  break;
               }
            case 1:
               this.kb = b((int)128, this.nb);
               if(!var19) {
                  break;
               }
            case 2:
               this.kb = b((int)63, this.nb);
               if(!var19) {
                  break;
               }
            case 3:
               this.kb = b((int)448, this.nb);
               if(!var19) {
                  break;
               }
            case 4:
               this.kb = new y.f.K();
               if(!var19) {
                  break;
               }
            case 5:
               this.kb = b((byte)0, this.nb);
               if(!var19) {
                  break;
               }
            case 6:
               this.kb = b((byte)1, this.nb);
            }

            if(var4 instanceof y.f.z && this.kb instanceof y.f.z) {
               y.f.z var5 = (y.f.z)this.kb;
               if(var5.a(this.sb)) {
                  if(this.nb != ((y.f.z)var4).b()) {
                     this.setOffsetDirty();
                  }

                  return;
               }
            }

            this.sb = this.kb.c();
            if(this.kb instanceof y.f.K && var3) {
               Point2D var20 = this.pb.getSourceIntersection();
               double var6 = this.offsetRectangle.f();
               double var8 = this.offsetRectangle.g();
               double var10 = this.offsetRectangle.i();
               double var12 = this.offsetRectangle.b() + var6 * var8;
               double var14 = this.offsetRectangle.c() + var6 * var10;
               double var16 = this.height;
               y.d.n var18 = new y.d.n(var12 - var16 * var8 + var20.getX(), var14 - var16 * var10 + var20.getY(), this.width, var16, var8, var10);
               this.sb = this.b(var18, var2);
            }

            this.placement = this.getPosition();
            this.setOffsetDirty();
            if(!var19) {
               return;
            }
         }

         if(127 == var1) {
            this.model = 127;
            this.kb = null;
         }

      }
   }

   private static y.f.E b(int var0, double var1) {
      y.f.z var3 = new y.f.z(var0);
      var3.a(var1);
      return var3;
   }

   private static y.f.aO b(byte var0, double var1) {
      y.f.aO var3 = new y.f.aO(var0);
      var3.a(var1, var1);
      return var3;
   }

   public byte getPosition() {
      int var1;
      if(this.kb instanceof y.f.z) {
         var1 = ((Integer)this.sb).intValue();
         switch(var1) {
         case 1:
            return (byte)13;
         case 2:
            return (byte)10;
         case 4:
            return (byte)14;
         case 8:
            return (byte)15;
         case 16:
            return (byte)11;
         case 32:
            return (byte)16;
         case 64:
            return (byte)17;
         case 128:
            return (byte)12;
         case 256:
            return (byte)18;
         }
      }

      if(this.kb instanceof y.f.aJ) {
         var1 = y.f.aJ.a(this.sb);
         switch(var1) {
         case 1:
            return (byte)13;
         case 2:
            return (byte)10;
         case 4:
            return (byte)14;
         case 8:
            return (byte)15;
         case 16:
            return (byte)11;
         case 32:
            return (byte)16;
         case 64:
            return (byte)17;
         case 128:
            return (byte)12;
         case 256:
            return (byte)18;
         }
      }

      return (byte)(this.kb instanceof y.f.K?99:(this.kb instanceof y.f.aO?24:(this.kb instanceof y.f.aL?24:127)));
   }

   public void setPosition(byte var1) {
      if(this.kb instanceof y.f.z) {
         this.b(var1);
         if(!fj.z) {
            return;
         }
      }

      if(this.kb instanceof y.f.aJ) {
         this.c(var1);
      }

   }

   private void b(byte var1) {
      boolean var5 = fj.z;
      y.f.z var2 = (y.f.z)this.kb;
      short var3 = 0;
      switch(var1) {
      case 13:
         var3 = 1;
         if(!var5) {
            break;
         }
      case 10:
         var3 = 2;
         if(!var5) {
            break;
         }
      case 14:
         var3 = 4;
         if(!var5) {
            break;
         }
      case 17:
         var3 = 64;
         if(!var5) {
            break;
         }
      case 12:
         var3 = 128;
         if(!var5) {
            break;
         }
      case 18:
         var3 = 256;
         if(!var5) {
            break;
         }
      case 15:
         var3 = 8;
         if(!var5) {
            break;
         }
      case 11:
         var3 = 16;
         if(!var5) {
            break;
         }
      case 16:
         var3 = 32;
      }

      Object var4 = y.f.z.a(var3);
      if(var2.a(var4)) {
         this.sb = var4;
      }

      this.setOffsetDirty();
   }

   private void c(byte var1) {
      boolean var5 = fj.z;
      y.f.aJ var2 = (y.f.aJ)this.kb;
      short var3 = 0;
      switch(var1) {
      case 13:
         var3 = 1;
         if(!var5) {
            break;
         }
      case 10:
         var3 = 2;
         if(!var5) {
            break;
         }
      case 14:
         var3 = 4;
         if(!var5) {
            break;
         }
      case 17:
         var3 = 64;
         if(!var5) {
            break;
         }
      case 12:
         var3 = 128;
         if(!var5) {
            break;
         }
      case 18:
         var3 = 256;
         if(!var5) {
            break;
         }
      case 15:
         var3 = 8;
         if(!var5) {
            break;
         }
      case 11:
         var3 = 16;
         if(!var5) {
            break;
         }
      case 16:
         var3 = 32;
      }

      Object var4 = y.f.aJ.a(var3);
      if(var2.b(var4)) {
         this.sb = var4;
      }

      this.setOffsetDirty();
   }

   public static Map modelToStringMap() {
      LinkedHashMap var0 = new LinkedHashMap(11);
      var0.put(new Byte((byte)1), "Centered");
      var0.put(new Byte((byte)0), "2 Pos");
      var0.put(new Byte((byte)2), "6 Pos");
      var0.put(new Byte((byte)3), "3 Pos Center");
      var0.put(new Byte((byte)4), "Free");
      var0.put(new Byte((byte)5), "Center Slider");
      var0.put(new Byte((byte)6), "Side Slider");
      return var0;
   }

   public static Map positionToStringMap() {
      LinkedHashMap var0 = new LinkedHashMap(21);
      var0.put(new Byte((byte)10), "Head");
      var0.put(new Byte((byte)11), "Tail");
      var0.put(new Byte((byte)12), "Center");
      var0.put(new Byte((byte)13), "Source Head");
      var0.put(new Byte((byte)14), "Target Head");
      var0.put(new Byte((byte)15), "Source Tail");
      var0.put(new Byte((byte)16), "Target Tail");
      var0.put(new Byte((byte)99), "Anywhere");
      var0.put(new Byte((byte)19), "Center");
      var0.put(new Byte((byte)20), "Tail");
      var0.put(new Byte((byte)21), "Head");
      var0.put(new Byte((byte)24), "Dynamic");
      var0.put(new Byte((byte)17), "Source Center");
      var0.put(new Byte((byte)18), "Target Center");
      var0.put(new Byte((byte)127), "Undefined");
      return var0;
   }

   public static Map preferredPlacementsToStringMap() {
      LinkedHashMap var0 = new LinkedHashMap(3);
      var0.put(new Byte((byte)34), "At Target (right)");
      var0.put(new Byte((byte)2), "At Target");
      var0.put(new Byte((byte)18), "At Target (left)");
      var0.put(new Byte((byte)33), "At Source (right)");
      var0.put(new Byte((byte)1), "At Source");
      var0.put(new Byte((byte)17), "At Source (left)");
      var0.put(new Byte((byte)36), "At Center (right)");
      var0.put(new Byte((byte)4), "At Center");
      var0.put(new Byte((byte)20), "At Center (left)");
      var0.put(new Byte((byte)4), "At Center");
      var0.put(new Byte((byte)0), "Anywhere");
      return var0;
   }

   public static final byte[] getModelPositions(byte var0) {
      return jb[var0];
   }

   public byte[] getModelPositions() {
      return getModelPositions(this.getModel());
   }

   public static Vector availablePositions(Byte var0) {
      Vector var10000;
      Vector var1;
      label23: {
         boolean var4 = fj.z;
         var1 = new Vector(10);
         if(var0 != null) {
            byte[] var2 = getModelPositions(var0.byteValue());
            int var3 = 0;

            do {
               if(var3 >= var2.length) {
                  break label23;
               }

               var10000 = var1;
               if(var4) {
                  return var10000;
               }

               var1.add(new Byte(var2[var3]));
               ++var3;
            } while(!var4);
         }

         var1.add(new Byte((byte)127));
      }

      var10000 = var1;
      return var10000;
   }

   public y.c.d getEdge() {
      return this.pb != null?this.pb.getEdge():null;
   }

   protected bu getGraph2D() {
      y.c.d var1 = this.getEdge();
      return var1 == null?null:(bu)var1.a();
   }

   public aB getRealizer() {
      return this.getOwner();
   }

   public aB getOwner() {
      return this.pb;
   }

   public void bindRealizer(aB var1) {
      this.pb = var1;
      this.setOffsetDirty();
   }

   public y.f.E getLabelModel() {
      return this.kb;
   }

   public Object getModelParameter() {
      return this.sb;
   }

   public void setModelParameter(Object var1) {
      this.b(var1);
      this.setOffsetDirty();
   }

   private void b(Object var1) {
      this.sb = var1;
      this.placement = this.getPosition();
   }

   public void setLabelModel(y.f.E var1) {
      this.b(var1);
      this.setOffsetDirty();
   }

   public void setLabelModel(y.f.E var1, Object var2) {
      this.b(var1);
      this.b(var2);
      this.setOffsetDirty();
   }

   private void b(y.f.E var1) {
      boolean var3 = fj.z;
      this.kb = var1;
      if(var1 == null) {
         this.model = 127;
         if(!var3) {
            return;
         }
      }

      if(var1.getClass() == (class$y$layout$DiscreteEdgeLabelModel == null?(class$y$layout$DiscreteEdgeLabelModel = class$("y.f.z")):class$y$layout$DiscreteEdgeLabelModel)) {
         int var2 = ((y.f.z)var1).a();
         switch(var2) {
         case 18:
            this.model = 0;
            if(!var3) {
               return;
            }
         case 128:
            this.model = 1;
            if(!var3) {
               return;
            }
         case 63:
            this.model = 2;
            if(!var3) {
               return;
            }
         case 448:
            this.model = 3;
            if(!var3) {
               return;
            }
         default:
            this.model = 127;
            if(!var3) {
               return;
            }
         }
      }

      if(var1.getClass() == (class$y$layout$FreeEdgeLabelModel == null?(class$y$layout$FreeEdgeLabelModel = class$("y.f.K")):class$y$layout$FreeEdgeLabelModel)) {
         this.model = 4;
         if(!var3) {
            return;
         }
      }

      if(var1.getClass() == (class$y$layout$SliderEdgeLabelModel == null?(class$y$layout$SliderEdgeLabelModel = class$("y.f.aO")):class$y$layout$SliderEdgeLabelModel)) {
         byte var4 = ((y.f.aO)var1).a();
         switch(var4) {
         case 0:
            this.model = 5;
            if(!var3) {
               return;
            }
         case 1:
            this.model = 6;
            if(!var3) {
               return;
            }
         default:
            this.model = 127;
            if(!var3) {
               return;
            }
         }
      }

      this.model = 127;
   }

   public void setOffsetDirty() {
      super.setOffsetDirty();
      if(this.pb != null) {
         this.pb.h();
      }

   }

   public void setSizeDirty() {
      super.setSizeDirty();
      if(this.pb != null) {
         this.pb.h();
         this.pb.labelBoundsChanged();
      }

   }

   public y.d.n getOrientedBox() {
      Point2D var1 = this.pb.getSourceIntersection();
      y.d.n var2 = this.getOffset();
      return var2.f(var1.getX(), var1.getY());
   }

   public void repaint() {
      if(this.pb != null && this.pb.i() != null) {
         y.d.y var1 = this.getBox();
         this.pb.i().a(var1.c(), var1.d(), var1.a(), var1.b());
      }

   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(2);
      super.write(var1);
      var1.writeFloat((float)this.rb);
      var1.writeFloat((float)this.getDistance());
   }

   public void read(ObjectInputStream var1) {
      boolean var4 = fj.z;
      aB var2;
      Point2D var3;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         if(var1.readBoolean()) {
            this.setBackgroundColor(Color.white);
         }

         this.rb = (double)var1.readFloat();
         if(!var4) {
            return;
         }
      case 1:
         super.read(var1);
         this.rb = (double)var1.readFloat();
         if(this.model != 5 && this.model != 6) {
            return;
         }

         var2 = this.getOwner();
         if(var2 == null) {
            return;
         }

         var3 = var2.getSourceIntersection();
         this.setModelParameter(this.b(this.offsetRectangle.f(var3.getX(), var3.getY()), var2));
         if(!var4) {
            return;
         }
      case 2:
         break;
      default:
         throw new y.e.a();
      }

      super.read(var1);
      this.rb = (double)var1.readFloat();
      if(this.model == 5 || this.model == 6) {
         var2 = this.getOwner();
         if(var2 != null) {
            var3 = var2.getSourceIntersection();
            this.setModelParameter(this.b(this.offsetRectangle.f(var3.getX(), var3.getY()), var2));
         }
      }

      this.setDistance((double)var1.readFloat());
      if(var4) {
         throw new y.e.a();
      }
   }

   private Object b(y.d.n var1, aB var2) {
      return this.kb.a((y.d.n)var1, var2, var2.getSourceRealizer(), var2.getTargetRealizer());
   }

   public void setConfiguration(String var1) {
      getFactory().a((gZ)this, (String)var1);
   }

   public static hb getFactory() {
      return ob;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      HashMap var0 = new HashMap();
      var0.put(class$y$view$YLabel$BoundsProvider == null?(class$y$view$YLabel$BoundsProvider = class$("y.h.ha")):class$y$view$YLabel$BoundsProvider, hh.d);
      var0.put(class$y$view$YLabel$Layout == null?(class$y$view$YLabel$Layout = class$("y.h.hc")):class$y$view$YLabel$Layout, hh.d);
      var0.put(class$y$view$YLabel$Painter == null?(class$y$view$YLabel$Painter = class$("y.h.hd")):class$y$view$YLabel$Painter, hh.d);
      var0.put(class$y$view$YLabel$UserDataHandler == null?(class$y$view$YLabel$UserDataHandler = class$("y.h.hf")):class$y$view$YLabel$UserDataHandler, new gs((byte)0));
      qb = new hg(var0, var0, (String)null);
      ob = new hb(var0);
      var0 = new HashMap();
      var0.put(class$y$view$YLabel$Painter == null?(class$y$view$YLabel$Painter = class$("y.h.hd")):class$y$view$YLabel$Painter, new hj());
      ob.a((String)"CroppingLabel", (Map)var0);
      var0 = new HashMap();
      ay var1 = new ay();
      var1.a(true);
      var0.put(class$y$view$YLabel$Painter == null?(class$y$view$YLabel$Painter = class$("y.h.hd")):class$y$view$YLabel$Painter, var1);
      ob.a((String)"AutoFlippingLabel", (Map)var0);
   }
}
