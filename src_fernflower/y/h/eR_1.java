package y.h;

import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import y.h.bu;
import y.h.eS;
import y.h.eT;
import y.h.fj;
import y.h.gZ;
import y.h.gs;
import y.h.hb;
import y.h.hg;
import y.h.hh;
import y.h.hj;

public class eR extends gZ implements y.f.aj {
   private static final byte[][] i = new byte[][]{{(byte)104, (byte)105, (byte)106, (byte)107}, {(byte)100, (byte)102, (byte)101, (byte)115, (byte)116, (byte)117, (byte)118, (byte)119, (byte)120}, {(byte)108, (byte)109}, {(byte)108, (byte)109, (byte)111, (byte)110}, {(byte)114}, {(byte)108, (byte)109, (byte)110, (byte)111, (byte)104, (byte)105, (byte)107, (byte)106}, {(byte)112}};
   fj a;
   private y.f.al r;
   private Object A;
   private double B;
   private static final hg C;
   private static final hb D;
   static Class b;
   static Class c;
   static Class d;
   static Class e;
   static Class f;
   static Class g;
   static Class h;

   public void setAutoSizePolicy(byte var1) {
      super.setAutoSizePolicy(var1);
   }

   public void setConfiguration(String var1) {
      d().a((gZ)this, (String)var1);
   }

   public static hb d() {
      return D;
   }

   public eR(String var1, byte var2) {
      this.A = new Integer(1);
      this.B = 4.0D;
      this.r = new y.f.A(130816, this.B);
      this.A = this.r.c();
      this.setModel(var2);
      this.setText(var1);
   }

   public eR(String var1) {
      this(var1, (byte)1);
   }

   void b() {
      if(this.a != null && this.a.getNode() != null) {
         y.c.i var1 = this.a.getNode().e();
         if(var1 instanceof bu) {
            bu var2 = (bu)var1;
            var2.e(this);
         }
      }

   }

   public eR() {
      this("");
   }

   public Object clone() {
      eR var1 = new eR();
      var1.adoptValues(this);
      return var1;
   }

   public void adoptValues(gZ var1) {
      super.adoptValues(var1);
      if(var1 instanceof eR) {
         eR var2 = (eR)var1;
         this.a(var2.e());
         if(this.getModel() == 127 || this.a() == null) {
            this.a(var2.a(), var2.getModelParameter());
            if(!fj.z) {
               return;
            }
         }

         this.setModelParameter(var2.getModelParameter());
      }

   }

   public void setOffset(double var1, double var3) {
      super.setOffset(var1, var3);
      if(this.r instanceof y.f.M) {
         this.A = new y.f.N(var1, var3);
      }

   }

   public void setOffsetDirty() {
      if(this.v == 2 || this.v == 1 || this.v == 3) {
         this.setSizeDirty();
      }

      super.setOffsetDirty();
   }

   public void setSizeDirty() {
      super.setSizeDirty();
      if(this.a != null) {
         this.a.labelBoundsChanged(this);
      }

   }

   hg c() {
      return C;
   }

   public void setText(String var1) {
      String var2 = this.getText();
      if(!var1.equals(var2)) {
         super.setText(var1);
         bu var3 = this.h();
         if(var3 != null) {
            var3.a(this, "text", var2, this.getText());
         }

      }
   }

   public void a(double var1) {
      this.B = var1;
      if(this.r instanceof y.f.A) {
         ((y.f.A)this.r).a(this.B);
      }

      this.setOffsetDirty();
   }

   public double e() {
      return this.B;
   }

   public y.f.al a() {
      return this.r;
   }

   public void a(y.f.al var1, Object var2) {
      this.a(var1);
      this.a(var2);
      this.setOffsetDirty();
   }

   private void a(y.f.al var1) {
      boolean var3 = fj.z;
      this.r = var1;
      if(var1 == null) {
         this.model = 127;
         if(!var3) {
            return;
         }
      }

      if(var1.getClass() == (f == null?(f = a("y.f.A")):f)) {
         int var2 = ((y.f.A)var1).a();
         switch(var2) {
         case 57:
            this.model = 3;
            if(!var3) {
               return;
            }
         case 198:
            this.model = 0;
            if(!var3) {
               return;
            }
         case 130816:
            this.model = 1;
            if(!var3) {
               return;
            }
         case 33:
            this.model = 2;
            if(!var3) {
               return;
            }
         case 255:
            this.model = 5;
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

      if(var1.getClass() == (g == null?(g = a("y.f.M")):g)) {
         this.model = 4;
         if(!var3) {
            return;
         }
      }

      if(var1.getClass() == (h == null?(h = a("y.f.J")):h)) {
         this.model = 6;
         if(!var3) {
            return;
         }
      }

      this.model = 127;
   }

   public Object getModelParameter() {
      return this.A;
   }

   public void setModelParameter(Object var1) {
      this.a(var1);
      this.setOffsetDirty();
   }

   private void a(Object var1) {
      this.A = var1;
      this.placement = this.getPosition();
   }

   public Object getBestModelParameterForBounds(y.d.n var1) {
      if(this.r != null) {
         fj var2 = this.g();
         if(var2 != null) {
            return this.r.a((y.d.n)var1, var2);
         }
      }

      return null;
   }

   public void setModel(byte var1) {
      if(var1 >= 0 && var1 <= 6) {
         fj var2 = this.a;
         this.model = var1;
         y.f.al var3 = this.r;
         switch(this.model) {
         case 0:
            this.r = new y.f.A(198, this.B);
            break;
         case 1:
            this.r = new y.f.A(130816, this.B);
            break;
         case 2:
            this.r = new y.f.A(33, this.B);
            break;
         case 3:
            this.r = new y.f.A(57, this.B);
            break;
         case 4:
            this.r = new y.f.M();
            break;
         case 5:
            this.r = new y.f.A(255, this.B);
            break;
         case 6:
            this.r = new y.f.J(this.h(), this.f());
         }

         if(var3 instanceof y.f.A && this.r instanceof y.f.A) {
            y.f.A var4 = (y.f.A)this.r;
            if(var4.a(this.A)) {
               if(this.B != ((y.f.A)var3).b()) {
                  this.setOffsetDirty();
               }

               return;
            }
         }

         this.A = this.r.c();
         if(this.r instanceof y.f.M && var2 != null) {
            double var17 = this.offsetRectangle.f();
            double var6 = this.offsetRectangle.g();
            double var8 = this.offsetRectangle.i();
            double var10 = this.offsetRectangle.b() + var17 * var6;
            double var12 = this.offsetRectangle.c() + var17 * var8;
            double var14 = this.height;
            y.d.n var16 = new y.d.n(var10 - var14 * var6 + this.a.getX(), var12 - var14 * var8 + this.a.getY(), this.width, var14, var6, var8);
            this.A = this.r.a((y.d.n)var16, var2);
         }

         this.placement = this.getPosition();
         this.setOffsetDirty();
      } else if(127 == var1) {
         this.model = 127;
         this.r = null;
      }

   }

   public void setPosition(byte var1) {
      if(this.r instanceof y.f.A) {
         y.f.A var2 = (y.f.A)this.r;
         int var3 = 0;
         switch(var1) {
         case 100:
            var3 = 256;
            break;
         case 101:
            var3 = 512;
            break;
         case 102:
            var3 = 1024;
         case 103:
         case 112:
         case 113:
         case 114:
         default:
            break;
         case 104:
            var3 = 2;
            break;
         case 105:
            var3 = 4;
            break;
         case 106:
            var3 = 128;
            break;
         case 107:
            var3 = 64;
            break;
         case 108:
            var3 = 1;
            break;
         case 109:
            var3 = 32;
            break;
         case 110:
            var3 = 8;
            break;
         case 111:
            var3 = 16;
            break;
         case 115:
            var3 = 2048;
            break;
         case 116:
            var3 = 4096;
            break;
         case 117:
            var3 = 8192;
            break;
         case 118:
            var3 = 16384;
            break;
         case 119:
            var3 = '耀';
            break;
         case 120:
            var3 = 65536;
         }

         Integer var4 = new Integer(var3);
         if(var2.a(var4)) {
            this.A = var4;
            this.setOffsetDirty();
         } else {
            System.err.println("NLabel::setPos: ERROR: pos " + var1 + " not valid for model " + this.model);
         }
      }
   }

   public byte getPosition() {
      if(this.r instanceof y.f.A) {
         int var1 = ((Integer)this.A).intValue();
         switch(var1) {
         case 1:
            return (byte)108;
         case 2:
            return (byte)104;
         case 4:
            return (byte)105;
         case 8:
            return (byte)110;
         case 16:
            return (byte)111;
         case 32:
            return (byte)109;
         case 64:
            return (byte)107;
         case 128:
            return (byte)106;
         case 256:
            return (byte)100;
         case 512:
            return (byte)101;
         case 1024:
            return (byte)102;
         case 2048:
            return (byte)115;
         case 4096:
            return (byte)116;
         case 8192:
            return (byte)117;
         case 16384:
            return (byte)118;
         case 32768:
            return (byte)119;
         case 65536:
            return (byte)120;
         }
      }

      return (byte)(this.r instanceof y.f.M?114:(this.r instanceof y.f.J?112:113));
   }

   public boolean isOffsetDirty() {
      return this.model == 6?true:super.isOffsetDirty();
   }

   public void calculateOffset() {
      fj var1 = this.a;
      y.d.n var2 = this.a().a(new y.d.q(this.getWidth(), this.getHeight()), var1, this.getModelParameter());
      var2.d(-var1.getX(), -var1.getY());
      super.setOffset(var2);
   }

   public y.c.q f() {
      return this.a != null?this.a.getNode():null;
   }

   public fj g() {
      return this.a;
   }

   public bu h() {
      y.c.q var1 = this.f();
      return var1 != null?(bu)var1.e():null;
   }

   public void a(fj var1) {
      this.a = var1;
      this.setOffsetDirty();
   }

   public y.d.n getOrientedBox() {
      y.d.n var1 = this.getOffset();
      return var1.f(this.a.getX(), this.a.getY());
   }

   public void repaint() {
      if(this.a != null && this.a.d() != null) {
         y.d.y var1 = this.getBox();
         this.a.d().a(var1.c(), var1.d(), var1.a(), var1.b());
      }

   }

   public boolean intersects(double var1, double var3, double var5, double var7) {
      if(this.isSizeDirty()) {
         this.calculateSize();
      }

      if(this.isOffsetDirty()) {
         this.calculateOffset();
      }

      return y.d.n.a(this.getOrientedBox(), new y.d.y(var1, var3, var5, var7), 0.0D);
   }

   public void calcUnionRect(Rectangle2D var1) {
      if(this.isSizeDirty()) {
         this.calculateSize();
      }

      if(this.isOffsetDirty()) {
         this.calculateOffset();
      }

      y.d.y var2;
      if(var1.getWidth() < 0.0D) {
         var2 = this.getBox();
         var1.setFrame(var2.c, var2.d, var2.a, var2.b);
         if(!fj.z) {
            return;
         }
      }

      var2 = this.getBox();
      var1.setFrameFromDiagonal(Math.min(var2.c, var1.getX()), Math.min(var2.d, var1.getY()), Math.max(var2.c + var2.a, var1.getX() + var1.getWidth()), Math.max(var2.d + var2.b, var1.getY() + var1.getHeight()));
   }

   public void write(ObjectOutputStream var1) {
      var1.writeByte(2);
      super.write(var1);
      var1.writeDouble(this.e());
   }

   public void read(ObjectInputStream var1) {
      boolean var2 = fj.z;
      switch(var1.readByte()) {
      case 0:
         super.read(var1);
         if(!var2) {
            break;
         }
      case 1:
         super.read(var1);
         this.a(var1.readDouble());
         this.setAutoSizePolicy(var1.readByte());
         if(!var2) {
            break;
         }
      case 2:
         super.read(var1);
         this.a(var1.readDouble());
         if(var2) {
            throw new y.e.a();
         }
         break;
      default:
         throw new y.e.a();
      }

   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      HashMap var0 = new HashMap();
      var0.put(b == null?(b = a("y.h.hd")):b, hh.d);
      var0.put(c == null?(c = a("y.h.ha")):c, hh.d);
      var0.put(d == null?(d = a("y.h.hc")):d, new eS());
      var0.put(e == null?(e = a("y.h.hf")):e, new gs((byte)0));
      C = new hg(var0, var0, (String)null);
      D = new hb(var0);
      var0 = new HashMap();
      var0.put(d == null?(d = a("y.h.hc")):d, new eT());
      var0.put(b == null?(b = a("y.h.hd")):b, new hj());
      D.a((String)"CroppingLabel", (Map)var0);
   }
}
