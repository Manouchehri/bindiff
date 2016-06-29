package y.h;

import java.awt.BasicStroke;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;
import y.h.fj;

public class dr extends BasicStroke {
   private static dr[][] w = new dr[4][];
   private byte x;
   private static Map y = new HashMap(11);
   public static final dr a = new dr(1.0F);
   public static final dr b = new dr(2.0F);
   public static final dr c = new dr(3.0F);
   public static final dr d = new dr(4.0F);
   public static final dr e = new dr(5.0F);
   public static final dr f = new dr(6.0F);
   public static final dr g = new dr(7.0F);
   public static final dr h = new dr(1.0F, 0, 0, 1.45F, new float[]{6.0F, 2.0F}, 0.0F, (byte)1);
   public static final dr i = new dr(2.0F, 0, 0, 1.45F, new float[]{12.0F, 4.0F}, 0.0F, (byte)1);
   public static final dr j = new dr(3.0F, 0, 0, 1.45F, new float[]{18.0F, 6.0F}, 0.0F, (byte)1);
   public static final dr k = new dr(4.0F, 0, 0, 1.45F, new float[]{24.0F, 8.0F}, 0.0F, (byte)1);
   public static final dr l = new dr(5.0F, 0, 0, 1.45F, new float[]{30.0F, 10.0F}, 0.0F, (byte)1);
   public static final dr m = new dr(1.0F, 1, 0, 1.45F, new float[]{0.0F, 4.0F}, 2.0F, (byte)2);
   public static final dr n = new dr(2.0F, 1, 0, 1.45F, new float[]{0.0F, 8.0F}, 2.0F, (byte)2);
   public static final dr o = new dr(3.0F, 1, 0, 1.45F, new float[]{0.0F, 12.0F}, 2.0F, (byte)2);
   public static final dr p = new dr(4.0F, 1, 0, 1.45F, new float[]{0.0F, 16.0F}, 2.0F, (byte)2);
   public static final dr q = new dr(5.0F, 1, 0, 1.45F, new float[]{0.0F, 20.0F}, 2.0F, (byte)2);
   public static final dr r = new dr(1.0F, 1, 0, 1.45F, new float[]{4.0F, 3.0F, 0.0F, 3.0F}, 0.0F, (byte)3);
   public static final dr s = new dr(2.0F, 1, 0, 1.45F, new float[]{8.0F, 6.0F, 0.0F, 6.0F}, 0.0F, (byte)3);
   public static final dr t = new dr(3.0F, 1, 0, 1.45F, new float[]{12.0F, 9.0F, 0.0F, 9.0F}, 0.0F, (byte)3);
   public static final dr u = new dr(4.0F, 1, 0, 1.45F, new float[]{16.0F, 12.0F, 0.0F, 12.0F}, 0.0F, (byte)3);
   public static final dr v = new dr(5.0F, 1, 0, 1.45F, new float[]{20.0F, 15.0F, 0.0F, 15.0F}, 0.0F, (byte)3);

   private dr(float var1) {
      super(var1, 0, 0, 1.45F);
      this.x = 0;
   }

   private dr(float var1, int var2, int var3, float var4, float[] var5, float var6, byte var7) {
      super(var1, var2, var3, var4, var5, var6);
      this.x = var7;
   }

   public static dr a(float var0, int var1, int var2, float var3, float[] var4, float var5) {
      dr var6 = new dr(var0, var1, var2, var3, var4, var5, (byte)127);
      Map var7 = y;
      synchronized(y) {
         dr var8 = (dr)y.get(var6);
         if(var8 != null) {
            return var8;
         } else {
            y.put(var6, var6);
            return var6;
         }
      }
   }

   public int hashCode() {
      return (int)((float)(5 + this.x) * this.getLineWidth());
   }

   public boolean equals(Object var1) {
      boolean var6 = fj.z;
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof dr)) {
         return false;
      } else {
         dr var2 = (dr)var1;
         float[] var3 = var2.getDashArray();
         float[] var4 = this.getDashArray();
         if(var3 == null ^ var4 == null) {
            return false;
         } else {
            int var10000;
            if(var4 != null) {
               if(var3.length != var4.length) {
                  return false;
               }

               int var5 = 0;

               while(var5 < var4.length) {
                  float var7;
                  var10000 = (var7 = var3[var5] - var4[var5]) == 0.0F?0:(var7 < 0.0F?-1:1);
                  if(var6) {
                     return var10000 == 0 && var2.getEndCap() == this.getEndCap() && var2.getLineJoin() == this.getLineJoin() && var2.getLineWidth() == this.getLineWidth() && var2.getMiterLimit() == this.getMiterLimit() && var2.a() == this.a();
                  }

                  if(var10000 != 0) {
                     return false;
                  }

                  ++var5;
                  if(var6) {
                     break;
                  }
               }
            }

            float var8;
            var10000 = (var8 = var2.getDashPhase() - this.getDashPhase()) == 0.0F?0:(var8 < 0.0F?-1:1);
            return var10000 == 0 && var2.getEndCap() == this.getEndCap() && var2.getLineJoin() == this.getLineJoin() && var2.getLineWidth() == this.getLineWidth() && var2.getMiterLimit() == this.getMiterLimit() && var2.a() == this.a();
         }
      }
   }

   public static dr a(int var0, byte var1) {
      if(var0 <= 0) {
         var0 = 1;
         if(!fj.z) {
            return w[var1][var0 - 1];
         }
      }

      if(var0 > w[var1].length) {
         var0 = w[var1].length;
      }

      return w[var1][var0 - 1];
   }

   public byte a() {
      return this.x;
   }

   public static void a(ObjectOutput var0, dr var1) {
      boolean var5 = fj.z;
      if(var1 == null) {
         var0.writeByte(1);
         if(!var5) {
            return;
         }
      }

      var0.writeByte(0);
      byte var2 = var1.a();
      var0.writeByte(var2);
      if(var2 != 127) {
         var0.writeByte((byte)((int)var1.getLineWidth()));
         if(!var5) {
            return;
         }
      }

      label30: {
         label42: {
            float[] var3 = var1.getDashArray();
            if(var3 == null) {
               var0.writeInt(0);
               if(!var5) {
                  break label42;
               }
            }

            var0.writeInt(var3.length);
            int var4 = 0;

            while(var4 < var3.length) {
               var0.writeFloat(var3[var4]);
               ++var4;
               if(var5) {
                  break label30;
               }

               if(var5) {
                  break;
               }
            }
         }

         var0.writeFloat(var1.getLineWidth());
         var0.writeInt(var1.getEndCap());
         var0.writeInt(var1.getLineJoin());
         var0.writeFloat(var1.getMiterLimit());
      }

      var0.writeFloat(var1.getDashPhase());
   }

   public static dr a(ObjectInput var0) {
      boolean var5 = fj.z;
      switch(var0.readByte()) {
      case 0:
         byte var1 = var0.readByte();
         if(var1 != 127) {
            return a(var0.readByte(), var1);
         }

         int var2 = var0.readInt();
         float[] var3 = null;
         if(var2 > 0) {
            var3 = new float[var2];
            int var4 = 0;

            while(var4 < var2) {
               var3[var4] = var0.readFloat();
               ++var4;
               if(var5) {
                  break;
               }
            }
         }

         return a(var0.readFloat(), var0.readInt(), var0.readInt(), var0.readFloat(), var3, var0.readFloat());
      case 1:
         return null;
      default:
         throw new y.e.a();
      }
   }

   static {
      w[0] = new dr[7];
      w[1] = new dr[5];
      w[2] = new dr[5];
      w[3] = new dr[5];
      w[0][0] = a;
      w[0][1] = b;
      w[0][2] = c;
      w[0][3] = d;
      w[0][4] = e;
      w[0][5] = f;
      w[0][6] = g;
      w[1][0] = h;
      w[1][1] = i;
      w[1][2] = j;
      w[1][3] = k;
      w[1][4] = l;
      w[2][0] = m;
      w[2][1] = n;
      w[2][2] = o;
      w[2][3] = p;
      w[2][4] = q;
      w[3][0] = r;
      w[3][1] = s;
      w[3][2] = t;
      w[3][3] = u;
      w[3][4] = v;
   }
}
