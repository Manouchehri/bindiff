package y.h;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import y.h.bI;
import y.h.bK;
import y.h.bL;
import y.h.bM;
import y.h.bR;
import y.h.bT;
import y.h.bu;
import y.h.ch;
import y.h.fj;

abstract class bS implements Runnable {
   private y.f.aw i;
   volatile y.f.l a;
   volatile Throwable b;
   volatile y.f.ah c;
   final ch d;
   final bu e;
   final y.f.ah f;
   final boolean g;
   final Map h;
   private volatile Map j;
   private volatile boolean k;
   private volatile boolean l;
   private volatile Thread m;
   private final bI n;

   bS(bI var1, ch var2, bu var3, y.f.ah var4, boolean var5) {
      this.n = var1;
      this.h = new HashMap();
      this.e = var3;
      this.f = var4;
      this.d = var2;
      this.g = var5;
   }

   bR b() {
      return new bT(this);
   }

   protected void c() {
      label11: {
         this.j = bI.a(this.n, this.d);
         bI.a(this.n, this.d, this.e, this.f, this.h);
         this.c = bI.a(this.n, this.d, this.f);
         if(this.n.m()) {
            this.i = bI.a(this.n, this.e, this.h);
            if(!fj.z) {
               break label11;
            }
         }

         this.i = null;
      }

      this.a = new y.f.l(this.e);
   }

   protected void d() {
   }

   protected abstract void a(y.f.l var1);

   protected void b(y.f.l var1) {
   }

   protected void a() {
      try {
         bI.b(this.n, this.e, this.h);
      } finally {
         if(this.j != null) {
            this.n.b(this.d, this.j);
         }

      }

   }

   public void run() {
      try {
         this.m = Thread.currentThread();
         if(!this.k) {
            this.a((Runnable)(new bK(this)));
            if(this.b != null) {
               this.d();
            }

            try {
               if(!this.k && this.b == null && this.a != null && this.c != null) {
                  try {
                     this.c.c(this.a);
                  } catch (RuntimeException var12) {
                     this.b = var12;
                  } catch (Error var13) {
                     this.b = var13;
                  }
               }

               if(!this.k && this.b == null && this.a != null) {
                  this.a((Runnable)(new bL(this)));
               }

               if(!this.k && this.b == null && this.a != null) {
                  this.b(this.a);
               }
            } finally {
               this.a((Runnable)(new bM(this)));
            }
         }
      } finally {
         this.l = true;
      }

   }

   void a(Runnable var1) {
      if(this.g && !SwingUtilities.isEventDispatchThread()) {
         try {
            SwingUtilities.invokeAndWait(var1);
            return;
         } catch (InterruptedException var3) {
            this.b = var3;
            return;
         } catch (InvocationTargetException var4) {
            this.b = var4.getTargetException();
            if(!fj.z) {
               return;
            }
         }
      }

      var1.run();
   }

   static y.f.aw a(bS var0) {
      return var0.i;
   }

   static bI b(bS var0) {
      return var0.n;
   }
}
