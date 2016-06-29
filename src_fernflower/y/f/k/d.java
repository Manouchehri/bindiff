package y.f.k;

import java.util.ArrayList;
import java.util.List;
import y.f.aE;
import y.f.k.A;
import y.f.k.K;
import y.f.k.P;
import y.f.k.W;
import y.f.k.X;
import y.f.k.l;
import y.f.k.n;
import y.f.k.w;
import y.f.k.x;

public abstract class d implements w {
   protected double a = 20.0D;
   protected y.f.X b;
   protected final l c;
   protected y.c.c d;
   protected y.c.c e;
   protected List f;
   public static int g;

   protected d(l var1) {
      this.c = var1;
   }

   public K a(x var1, y.f.X var2, y.c.q var3) {
      return null;
   }

   W a(y.c.d var1, P var2) {
      return new W(this.c, this.b, var1, var2);
   }

   X a(y.c.q var1, P var2) {
      return new X(this.a(var1), var2);
   }

   protected abstract P a(y.c.q var1, byte var2);

   protected P a(y.c.q var1) {
      return new P(this.c, (A)this.e.b(var1));
   }

   protected P b(y.c.q var1) {
      P var2 = new P(this.c, (A)this.d.b(var1));
      this.f.add(var2);
      return var2;
   }

   public void a(y.c.q var1, y.c.b var2) {
      int var8 = g;
      this.b = (y.f.X)var1.e();
      boolean var10 = false;

      try {
         var10 = true;
         y.c.d var3 = var1.f();

         while(true) {
            if(var3 == null) {
               var10 = false;
               break;
            }

            y.c.q var4 = var3.d();
            byte var5 = this.d(var4);
            byte var6 = this.a(var5);
            var2.a(var4, var6);
            var3 = var3.g();
            if(var8 != 0) {
               var10 = false;
               return;
            }

            if(var8 != 0) {
               var10 = false;
               break;
            }
         }
      } finally {
         if(var10) {
            this.b = null;
         }
      }

      this.b = null;
   }

   protected aE c(y.c.q var1) {
      y.c.d var2 = var1.g();
      aE var3;
      if(var2 == null) {
         var3 = aE.a((byte)0);
         if(g == 0) {
            return this.a(var3);
         }
      }

      var3 = aE.e(this.b, var2);
      if(var3 == null) {
         var3 = aE.a((byte)0);
      }

      return this.a(var3);
   }

   private aE a(aE var1) {
      n var2;
      label47: {
         int var4 = g;
         if(var1.c()) {
            var2 = n.a;
            if(var4 == 0) {
               break label47;
            }
         }

         if(var1.e()) {
            var2 = n.b;
            if(var4 == 0) {
               break label47;
            }
         }

         if(var1.d()) {
            var2 = n.c;
            if(var4 == 0) {
               break label47;
            }
         }

         if(!var1.f()) {
            return var1;
         }

         var2 = n.d;
         if(var4 != 0) {
            return var1;
         }
      }

      n var3 = var2.a(this.c.a());
      if(var3.equals(n.a)) {
         return aE.a((byte)1);
      } else if(var3.equals(n.b)) {
         return aE.a((byte)4);
      } else if(var3.equals(n.c)) {
         return aE.a((byte)2);
      } else if(var3.equals(n.d)) {
         return aE.a((byte)8);
      } else {
         throw new RuntimeException("Should not reach... " + var1);
      }
   }

   protected byte a(byte var1) {
      int var4 = g;
      n var2;
      switch(var1) {
      case -2:
         return (byte)-2;
      case -1:
         return (byte)-1;
      case 0:
         var2 = n.a;
         if(var4 == 0) {
            break;
         }
      case 1:
         var2 = n.b;
         if(var4 == 0) {
            break;
         }
      case 2:
         var2 = n.c;
         if(var4 == 0) {
            break;
         }
      case 3:
         var2 = n.d;
         if(var4 != 0) {
            return (byte)-1;
         }
         break;
      default:
         throw new IllegalArgumentException("Not implemented for " + var1);
      }

      n var3 = var2.a(this.c);
      if(var3.equals(n.a)) {
         return (byte)0;
      } else if(var3.equals(n.b)) {
         return (byte)1;
      } else if(var3.equals(n.c)) {
         return (byte)2;
      } else if(var3.equals(n.d)) {
         return (byte)3;
      } else {
         throw new RuntimeException("Should not reach... " + var1);
      }
   }

   protected byte b(byte var1) {
      int var4 = g;
      n var2;
      switch(var1) {
      case -2:
         return (byte)-2;
      case -1:
         return (byte)-1;
      case 0:
         var2 = n.a;
         if(var4 == 0) {
            break;
         }
      case 1:
         var2 = n.b;
         if(var4 == 0) {
            break;
         }
      case 2:
         var2 = n.c;
         if(var4 == 0) {
            break;
         }
      case 3:
         var2 = n.d;
         if(var4 != 0) {
            return (byte)-1;
         }
         break;
      default:
         throw new IllegalArgumentException("Not implemented for " + var1);
      }

      n var3 = var2.a(this.c.a());
      if(var3.equals(n.a)) {
         return (byte)0;
      } else if(var3.equals(n.b)) {
         return (byte)1;
      } else if(var3.equals(n.c)) {
         return (byte)2;
      } else if(var3.equals(n.d)) {
         return (byte)3;
      } else {
         throw new RuntimeException("Should not reach... " + var1);
      }
   }

   protected abstract byte d(y.c.q var1);

   public A a(y.c.c var1, y.c.c var2, y.f.X var3, y.c.q var4, byte var5) {
      this.d = var2;
      this.e = var1;
      this.b = var3;

      A var7;
      try {
         this.f = new ArrayList();
         P var6 = this.a(var4, this.b(var5));
         var6.j();
         var7 = var6.i();
      } finally {
         var2 = null;
         var1 = null;
         var3 = null;
      }

      return var7;
   }

   public l a() {
      return this.c;
   }

   public static y.d.t a(l var0, y.d.t var1) {
      if(var1 == null) {
         return null;
      } else {
         n var2 = n.a(var1.a(), var1.b());
         n var3 = var2.a(var0.a());
         return new y.d.t(var3.a(0), var3.a(1));
      }
   }
}
