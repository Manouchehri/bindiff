package y.c;

import y.c.D;
import y.c.I;
import y.c.K;
import y.c.h;

final class N implements h {
   int a;
   String b;
   boolean c = false;
   K d;
   static final Integer[] e = new Integer[127];
   static final Integer[] f = new Integer[127];

   N(int var1, String var2, K var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
   }

   public void a(Object var1, Object var2) {
      try {
         if(((I)var1).k.length > this.a) {
            ((I)var1).k[this.a] = var2;
            if(!D.e) {
               return;
            }
         }

         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         this.a(var1, var2);
      } catch (IndexOutOfBoundsException var5) {
         I var4 = (I)var1;
         this.d.a(var4, var4.k.length, this.d.a);
         this.a(var1, var2);
      }

   }

   public Object b(Object var1) {
      try {
         return ((I)var1).k.length > this.a?((I)var1).k[this.a]:null;
      } catch (IndexOutOfBoundsException var4) {
         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         return null;
      }
   }

   public void a(Object var1, boolean var2) {
      try {
         if(((I)var1).k.length > this.a) {
            ((I)var1).k[this.a] = var2?Boolean.TRUE:Boolean.FALSE;
            if(!D.e) {
               return;
            }
         }

         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         this.a(var1, var2);
      } catch (IndexOutOfBoundsException var5) {
         I var4 = (I)var1;
         this.d.a(var4, var4.k.length, this.d.a);
         this.a(var1, var2);
      }

   }

   public boolean d(Object var1) {
      try {
         if(((I)var1).k.length > this.a) {
            Object var2 = ((I)var1).k[this.a];
            return var2 == null?false:((Boolean)var2).booleanValue();
         } else {
            return false;
         }
      } catch (IndexOutOfBoundsException var4) {
         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         return this.d(var1);
      }
   }

   public void a(Object var1, int var2) {
      boolean var5 = D.e;

      try {
         if(((I)var1).k.length > this.a) {
            if(var2 >= 0) {
               if(var2 < e.length) {
                  ((I)var1).k[this.a] = e[var2];
                  if(!var5) {
                     return;
                  }
               }

               ((I)var1).k[this.a] = new Integer(var2);
               if(!var5) {
                  return;
               }
            }

            if(var2 > -f.length) {
               ((I)var1).k[this.a] = f[-var2];
               if(!var5) {
                  return;
               }
            }

            ((I)var1).k[this.a] = new Integer(var2);
            if(!var5) {
               return;
            }
         }

         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         this.a(var1, var2);
      } catch (IndexOutOfBoundsException var6) {
         I var4 = (I)var1;
         this.d.a(var4, var4.k.length, this.d.a);
         this.a(var1, var2);
      }

   }

   public int a(Object var1) {
      try {
         if(((I)var1).k.length > this.a) {
            Object var2 = ((I)var1).k[this.a];
            return var2 == null?0:((Number)var2).intValue();
         } else {
            return 0;
         }
      } catch (IndexOutOfBoundsException var4) {
         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         return this.a(var1);
      }
   }

   public void a(Object var1, double var2) {
      try {
         if(((I)var1).k.length > this.a) {
            ((I)var1).k[this.a] = new Double(var2);
            if(!D.e) {
               return;
            }
         }

         I var4 = (I)var1;
         this.d.a(var4, var4.k.length, this.d.a);
         this.a(var1, var2);
      } catch (IndexOutOfBoundsException var6) {
         I var5 = (I)var1;
         this.d.a(var5, var5.k.length, this.d.a);
         this.a(var1, var2);
      }

   }

   public double c(Object var1) {
      try {
         if(((I)var1).k.length > this.a) {
            Object var2 = ((I)var1).k[this.a];
            return var2 == null?0.0D:((Number)var2).doubleValue();
         } else {
            return 0.0D;
         }
      } catch (IndexOutOfBoundsException var4) {
         I var3 = (I)var1;
         this.d.a(var3, var3.k.length, this.d.a);
         return this.c(var1);
      }
   }

   public String toString() {
      return this.getClass() + " : " + this.b + " : " + this.a;
   }

   public boolean a() {
      return this.c;
   }

   public void b() {
      this.c = true;
   }

   static {
      int var0;
      for(var0 = e.length - 1; var0 >= 0; --var0) {
         e[var0] = new Integer(var0);
      }

      for(var0 = f.length - 1; var0 >= 0; --var0) {
         f[var0] = new Integer(-var0);
      }

   }
}
