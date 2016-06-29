package y.b;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import y.b.a;
import y.b.c;
import y.b.d;
import y.b.f;
import y.b.g;
import y.b.h;
import y.b.i;
import y.b.j;
import y.b.k;
import y.c.D;

public class e {
   private static final c[] b = new c[0];
   private final a c;
   private final a d;
   private final a e;
   private int f;
   private double g;
   private final D h;
   private final List i;
   private Timer j;
   private boolean k;
   private boolean l;
   private boolean m;
   private volatile boolean n;
   public static int a;

   public e() {
      this(1.0D, true);
   }

   public e(double var1, boolean var3) {
      int var4 = a;
      super();
      this.c = new a(this, 3);
      this.d = new a(this, 0);
      this.e = new a(this, 4);
      this.f = 120;
      this.g = var1;
      this.h = new D();
      this.i = new ArrayList(2);
      this.j = null;
      this.k = var3;
      this.l = true;
      this.m = true;
      if(var4 != 0) {
         y.c.i.g = !y.c.i.g;
      }

   }

   public e(boolean var1) {
      this(1.0D, var1);
   }

   public void a(c var1) {
      if(var1 != null) {
         List var2 = this.i;
         synchronized(this.i) {
            this.i.add(var1);
         }
      }
   }

   public void a(boolean var1) {
      this.l = var1;
   }

   public boolean a() {
      return this.m;
   }

   public boolean b() {
      return this.k;
   }

   public void b(boolean var1) {
      this.k = var1;
   }

   public void a(d var1) {
      this.m = EventQueue.isDispatchThread();
      if(this.k) {
         this.c(var1);
         if(a == 0) {
            return;
         }
      }

      this.b(var1);
   }

   private void b(d var1) {
      if(this.j == null) {
         this.b(this.c);
      }

      this.a((Runnable)(new k(var1)));
      D var2 = this.h;
      synchronized(this.h) {
         this.h.add(new h(this, var1));
      }

      this.c();
   }

   private void c(d var1) {
      int var19 = a;
      this.n = true;
      boolean var22 = false;

      e var10000;
      label94: {
         try {
            var22 = true;
            this.a(this.c);
            this.a((Runnable)(new k(var1)));
            j var2 = new j(var1);
            long var3 = var1.preferredDuration();
            long var5 = 0L < var3?(long)((double)var3 / this.g):0L;
            if(var5 > 0L) {
               long var7 = Math.max(1L, 1000L / (long)this.f);
               double var9 = 0.0D;
               long var11 = 0L;
               long var13 = System.currentTimeMillis();

               while(var9 < 1.0D) {
                  var10000 = this;
                  if(var19 != 0) {
                     var22 = false;
                     break label94;
                  }

                  if(!this.n) {
                     break;
                  }

                  var2.a(var9);
                  this.a((Runnable)var2);
                  this.a(this.d);
                  var11 += var7;
                  long var15 = var11 - System.currentTimeMillis() + var13;
                  if(var15 > 10L) {
                     try {
                        Thread.sleep(var15);
                     } catch (Exception var23) {
                        ;
                     }
                  }

                  var9 = (double)(System.currentTimeMillis() - var13) / (double)var5;
                  if(var19 != 0) {
                     break;
                  }
               }
            }

            var2.a(1.0D);
            this.a((Runnable)var2);
            this.a(this.d);
            this.a((Runnable)(new i(var1)));
            this.a(this.e);
            var22 = false;
         } finally {
            if(var22) {
               this.n = false;
            }
         }

         var10000 = this;
      }

      var10000.n = false;
   }

   private void c() {
      if(this.j == null) {
         this.j = new Timer(1000 / this.f, new g(this, (f)null));
         this.j.setInitialDelay(0);
         this.j.start();
      }

   }

   private void d() {
      if(this.j != null) {
         this.j.stop();
         this.j = null;
         this.b(this.e);
      }

   }

   private void a(Runnable var1) {
      if(this.l && !EventQueue.isDispatchThread()) {
         try {
            EventQueue.invokeAndWait(var1);
            return;
         } catch (InvocationTargetException var3) {
            if(var3.getTargetException() instanceof RuntimeException) {
               throw (RuntimeException)var3.getTargetException();
            }

            if(var3.getTargetException() instanceof Error) {
               throw (Error)var3.getTargetException();
            }

            throw new RuntimeException(var3.toString());
         } catch (InterruptedException var4) {
            if(a == 0) {
               return;
            }
         }
      }

      var1.run();
   }

   private void a(a var1) {
      int var5 = a;
      if(null != this.i && !this.i.isEmpty()) {
         c[] var2;
         if(this.l && !EventQueue.isDispatchThread()) {
            var2 = (c[])this.i.toArray(b);

            try {
               EventQueue.invokeAndWait(new f(this, var2, var1));
               return;
            } catch (InvocationTargetException var6) {
               if(var6.getTargetException() instanceof RuntimeException) {
                  throw (RuntimeException)var6.getTargetException();
               }

               if(var6.getTargetException() instanceof Error) {
                  throw (Error)var6.getTargetException();
               }

               throw new RuntimeException(var6.toString());
            } catch (InterruptedException var7) {
               if(var5 == 0) {
                  return;
               }
            }
         }

         var2 = (c[])this.i.toArray(b);
         int var3 = 0;
         int var4 = var2.length;

         while(var3 < var4) {
            var2[var3].animationPerformed(var1);
            ++var3;
            if(var5 != 0) {
               break;
            }
         }
      }

   }

   private void b(a var1) {
      int var7 = a;
      List var2 = this.i;
      synchronized(this.i) {
         if(!this.i.isEmpty()) {
            c[] var3 = (c[])this.i.toArray(b);
            int var4 = 0;
            int var5 = var3.length;

            while(var4 < var5) {
               var3[var4].animationPerformed(var1);
               ++var4;
               if(var7 == 0 && var7 == 0) {
                  continue;
               }
            }

         }
      }
   }

   static double a(e var0) {
      return var0.g;
   }

   static D b(e var0) {
      return var0.h;
   }

   static a c(e var0) {
      return var0.d;
   }

   static void a(e var0, a var1) {
      var0.b(var1);
   }

   static void d(e var0) {
      var0.d();
   }
}
