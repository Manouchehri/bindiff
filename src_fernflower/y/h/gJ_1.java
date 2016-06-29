package y.h;

import y.h.cU;
import y.h.ch;
import y.h.gK;
import y.h.gL;
import y.h.gM;
import y.h.gN;
import y.h.gO;
import y.h.gP;
import y.h.gQ;
import y.h.gR;
import y.h.gS;
import y.h.hT;

public class gJ {
   gO a;
   ch b;
   cU c;
   public static final gP d = new gS();
   public static final gP e = new gS(true);
   public static final gP f = new gR();
   public static final gP g = new gR(true);
   public static final gO h = new gO((gK)null);
   public static final gO i = new gO((gK)null);
   public static final gO j = new gO((gK)null);
   public static final gQ k = new gM();
   public static final gQ l = new gN();
   public static final gQ m = new gL();

   public gJ(ch var1) {
      this.b = var1;
      this.c = null;
      this.a = i;
   }

   public y.b.d a(double var1, y.g.an var3, long var4) {
      if(var4 < 0L) {
         String var6 = "preferredDuration  = " + var4 + " < 0";
         throw new IllegalArgumentException(var6);
      } else if(var1 <= 0.0D) {
         throw new IllegalArgumentException("specified zoom factor <= 0: " + var1);
      } else {
         return new hT(this.b, var1, var3, var4, this.c);
      }
   }
}
