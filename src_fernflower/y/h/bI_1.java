package y.h;

import java.awt.Cursor;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import y.h.bJ;
import y.h.bO;
import y.h.bP;
import y.h.bQ;
import y.h.bR;
import y.h.bS;
import y.h.bu;
import y.h.ch;
import y.h.dj;
import y.h.dm;
import y.h.ff;
import y.h.fj;
import y.h.fk;
import y.h.gg;

public class bI {
   private byte d;
   private boolean e;
   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean j;
   private y.h.b.v k;
   private ff l;
   private boolean m;
   private dj n;
   private boolean o;
   static Class a;
   static Class b;
   static Class c;

   public bI() {
      this((byte)3);
   }

   public bI(byte var1) {
      this.f = true;
      this.g = true;
      this.h = true;
      this.j = true;
      this.o = true;
      this.a(var1);
   }

   public byte a() {
      return this.d;
   }

   public void a(byte var1) {
      switch(var1) {
      case 0:
      case 1:
      case 3:
      case 5:
      case 7:
         if(!fj.z) {
            this.d = var1;
            return;
         }
      case 2:
      case 4:
      case 6:
      default:
         throw new IllegalArgumentException("illegal mode");
      }
   }

   public boolean b() {
      return this.e;
   }

   public y.h.b.v c() {
      if(this.k == null) {
         this.k = new y.h.b.v();
      }

      return this.k;
   }

   public ff d() {
      if(this.l == null) {
         this.l = new ff();
      }

      return this.l;
   }

   public dj e() {
      if(this.n == null) {
         this.n = this.l();
      }

      return this.n;
   }

   public boolean f() {
      return this.g;
   }

   public boolean g() {
      return this.h;
   }

   public boolean h() {
      return this.i;
   }

   public boolean i() {
      return this.j;
   }

   public boolean j() {
      return this.f;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   private void a(ch var1, bu var2, y.f.ah var3, Map var4) {
      var2.r();
      if(this.j()) {
         var2.V();
      }

      y.c.A var5 = null;
      y.c.h var6 = null;
      y.h.a.i var7 = null;
      y.h.b.v var8 = null;
      ff var9 = null;
      if(this.o) {
         if(var2.c(y.f.ah.g_) == null) {
            var5 = gg.a(var2);
            var2.a((Object)y.f.ah.g_, (y.c.c)var5);
         }

         if(var2.c(y.f.ah.h_) == null) {
            var6 = gg.b(var2);
            var2.a((Object)y.f.ah.h_, (y.c.c)var6);
         }
      }

      if(this.i()) {
         var9 = this.c(var1, var2, var3);
      }

      if(var2.C() != null) {
         if(this.h()) {
            var7 = this.a(var1, var2, var3);
            var8 = this.b(var1, var2, var3);
         } else if(this.f()) {
            var7 = this.a(var1, var2, var3);
         }
      }

      var4.put("nodeSelection", var5);
      var4.put("edgeSelection", var6);
      var4.put(a == null?(a = a("y.h.a.i")):a, var7);
      var4.put(b == null?(b = a("y.h.b.v")):b, var8);
      var4.put(c == null?(c = a("y.h.ff")):c, var9);
   }

   protected y.h.a.i a(ch var1, bu var2, y.f.ah var3) {
      y.h.a.i var4 = new y.h.a.i(var2);
      var4.k();
      return var4;
   }

   protected y.h.b.v b(ch var1, bu var2, y.f.ah var3) {
      y.h.b.v var4 = this.c();
      if(var3 instanceof y.f.c) {
         y.f.c var5 = (y.f.c)var3;
         if(var5.g() instanceof y.f.an && var5.i()) {
            var4.a(((y.f.an)var5.g()).d());
         }
      }

      var4.a(var2);
      return var4;
   }

   protected ff c(ch var1, bu var2, y.f.ah var3) {
      ff var4 = this.d();
      var4.a(var2);
      return var4;
   }

   private void a(bu var1, Map var2) {
      y.c.A var3 = (y.c.A)var2.get("nodeSelection");
      y.c.h var4 = (y.c.h)var2.get("edgeSelection");
      y.h.a.i var5 = (y.h.a.i)var2.get(a == null?(a = a("y.h.a.i")):a);
      this.b(var1, var2);
      this.c(var1, var2);
      Object var6 = var2.get("nrics");
      if(var6 instanceof y.c.c) {
         var1.d_(y.f.P.a);
      }

      Object var7 = var2.get("nrict");
      if(var7 instanceof y.c.c) {
         var1.d_(y.f.P.b);
      }

      if(var5 != null) {
         this.a(var1, var5);
      }

      if(var3 != null) {
         var1.d_(y.f.ah.g_);
      }

      if(var4 != null) {
         var1.d_(y.f.ah.h_);
      }

      var1.s();
   }

   private void b(bu var1, Map var2) {
      y.h.b.v var3 = (y.h.b.v)var2.get(b == null?(b = a("y.h.b.v")):b);
      if(var3 != null) {
         this.a(var1, var3);
         var2.remove(b == null?(b = a("y.h.b.v")):b);
      }

   }

   private void c(bu var1, Map var2) {
      Class var3 = c == null?(c = a("y.h.ff")):c;
      ff var4 = (ff)var2.get(var3);
      if(var4 != null) {
         this.a(var1, var4);
         var2.remove(var3);
      }

   }

   protected void a(bu var1, y.h.a.i var2) {
      var2.l();
   }

   protected void a(bu var1, y.h.b.v var2) {
      var2.d(var1);
   }

   protected void a(bu var1, ff var2) {
      var2.d(var1);
   }

   private y.f.ah a(ch var1, y.f.ah var2) {
      if(this.g() && var1 != null && var2 instanceof y.f.c) {
         y.f.c var3 = (y.f.c)var2;
         if(var3.e() instanceof y.f.e) {
            y.f.e var4 = (y.f.e)var3.e();
            this.a(var1, var4);
         }
      }

      ff var5 = this.d();
      y.f.ad var6 = var5.d();
      if(var6 != null) {
         var6.a((y.f.ah)var2);
         var2 = var6;
      }

      return (y.f.ah)var2;
   }

   final void a(y.f.X var1, y.f.aw var2) {
      if(this.m()) {
         var2.c(var1);
      }

   }

   private y.f.aw d(bu var1, Map var2) {
      y.f.aw var3 = new y.f.aw();
      fk var4;
      if(var1.c(y.f.P.a) == null) {
         var4 = new fk(var1, true);
         var2.put("nrics", var4);
         var1.a((Object)y.f.P.a, (y.c.c)var4);
      }

      if(var1.c(y.f.P.b) == null) {
         var4 = new fk(var1, false);
         var2.put("nrict", var4);
         var1.a((Object)y.f.P.b, (y.c.c)var4);
      }

      return var3;
   }

   private bS a(ch var1, bu var2, y.f.ah var3, Runnable var4, bQ var5, boolean var6) {
      return new bJ(this, var1, var2, var3, var6, var5, var4);
   }

   private bS b(ch var1, bu var2, y.f.ah var3, Runnable var4, bQ var5, boolean var6) {
      return new bO(this, var1, var2, var3, var6, var5, var4);
   }

   public void a(bu var1, y.f.ah var2) {
      this.a((ch)null, (bu)var1, (y.f.ah)var2, (Runnable)null, (bQ)null);
   }

   public void d(ch var1, bu var2, y.f.ah var3) {
      this.a((ch)var1, (bu)var2, (y.f.ah)var3, (Runnable)null, (bQ)null);
   }

   public bR a(ch var1, bu var2, y.f.ah var3, Runnable var4, bQ var5) {
      boolean var15 = fj.z;
      if(var2 == null) {
         throw new IllegalArgumentException("graph may not be null.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("layouter may not be null.");
      } else {
         boolean var6 = (this.a() & 4) == 4;
         boolean var7 = var6 || this.a(var1);
         boolean var8 = var1 != null && (this.a() & 2) == 2 && this.e().preferredDuration() > 0L;
         boolean var9 = (this.a() & 1) == 1;
         if(!var9) {
            HashMap var20 = new HashMap();
            this.a(var1, var2, var3, var20);
            y.f.ah var21 = this.a(var1, var3);

            try {
               var21.c(var2);
               if(this.m()) {
                  this.a((y.f.X)var2, (y.f.aw)this.d(var2, var20));
               }

               var2.T();
            } catch (RuntimeException var18) {
               if(var5 != null) {
                  ((bQ)var5).a(var18);
                  if(!var15) {
                     return null;
                  }
               }

               throw var18;
            } finally {
               this.a((bu)var2, (Map)var20);
               if(var4 != null) {
                  var4.run();
               }

            }

            return null;
         } else {
            Throwable[] var10 = new Throwable[1];
            if(!var6 && var5 == null) {
               var5 = new bP(this, var10);
            }

            bS var11;
            label210: {
               if(var8) {
                  var11 = this.a(var1, var2, var3, var4, (bQ)var5, var7);
                  if(!var15) {
                     break label210;
                  }
               }

               var11 = this.b(var1, var2, var3, var4, (bQ)var5, var7);
            }

            if(var6) {
               this.a((Runnable)var11);
               if(!var15) {
                  return var11.b();
               }
            }

            var11.run();
            if(var10[0] != null) {
               if(var10[0] instanceof RuntimeException) {
                  throw (RuntimeException)var10[0];
               }

               if(var10[0] instanceof Error) {
                  throw (Error)var10[0];
               }
            }

            return var11.b();
         }
      }
   }

   protected void a(Runnable var1) {
      Thread var2 = new Thread(var1);
      var2.setDaemon(true);
      var2.start();
   }

   private Map b(ch var1) {
      if(var1 != null && this.b()) {
         HashMap var2 = new HashMap();
         this.a((ch)var1, (Map)var2);
         return var2;
      } else {
         return null;
      }
   }

   protected void a(ch var1, Map var2) {
      boolean var3 = var1.isInputSuppressed();
      var2.put("wasInputSuppressed", var3?Boolean.TRUE:Boolean.FALSE);
      var1.setInputSuppressed(true);
      var2.put("oldCursor", var1.getViewCursor());
      var1.setViewCursor(Cursor.getPredefinedCursor(3));
   }

   protected void b(ch var1, Map var2) {
      if(var2.get("wasInputSuppressed") == Boolean.FALSE) {
         var1.setInputSuppressed(false);
      }

      Object var3 = var2.get("oldCursor");
      if(var3 instanceof Cursor) {
         var1.setViewCursor((Cursor)var3);
      }

   }

   protected void a(ch var1, y.f.e var2) {
      Dimension var3 = var1.getSize();
      var2.a(var3.getWidth(), var3.getHeight());
      double var4 = var1.getGridMode()?var1.getGridResolution():0.0D;
      var2.a(0.0D);
      if(var4 > 0.0D) {
         var2.b(var4);
         if(!fj.z) {
            return;
         }
      }

      var2.b(45.0D);
   }

   protected y.b.e k() {
      return new y.b.e();
   }

   protected dj l() {
      dj var1 = new dj();
      var1.setPreferredDuration(300L);
      var1.setEasedExecution(true);
      return var1;
   }

   protected y.b.d a(ch var1, bu var2, y.f.O var3) {
      dj var4 = this.e();
      var4.initialize(var1, var3);
      return var4;
   }

   protected boolean a(ch var1) {
      return !SwingUtilities.isEventDispatchThread() && var1 != null && var1.isShowing();
   }

   protected void a(bu var1, y.f.O var2) {
      y.f.ae.a((y.f.X)var1, (y.f.O)(new dm(var1, var2)));
   }

   public boolean m() {
      return this.m;
   }

   public void b(boolean var1) {
      this.m = var1;
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static Map a(bI var0, ch var1) {
      return var0.b(var1);
   }

   static void a(bI var0, ch var1, bu var2, y.f.ah var3, Map var4) {
      var0.a(var1, var2, var3, var4);
   }

   static y.f.ah a(bI var0, ch var1, y.f.ah var2) {
      return var0.a(var1, var2);
   }

   static y.f.aw a(bI var0, bu var1, Map var2) {
      return var0.d(var1, var2);
   }

   static void b(bI var0, bu var1, Map var2) {
      var0.a(var1, var2);
   }
}
