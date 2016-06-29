package y.h;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import y.h.bf;
import y.h.c;
import y.h.cW;
import y.h.ch;
import y.h.dw;
import y.h.dx;
import y.h.eE;
import y.h.eF;
import y.h.eG;
import y.h.fj;

public class eD extends c implements bf {
   private final Collection a = new ArrayList();
   private final Collection b;
   private final eG c;
   private fj d;
   private ch e;
   private eF f;

   public eD() {
      this.b = Collections.unmodifiableCollection(this.a);
      this.c = new eG(this, (eE)null);
   }

   public void a(eF var1) {
      if(var1 != null) {
         this.a.add(var1);
      }

   }

   public dx a(fj var1, ch var2, double var3, double var5, cW var7) {
      if(this.a()) {
         this.e = var2;
         this.d = var1;
         if(this.a(var3, var5) != null) {
            return this;
         } else {
            this.e = null;
            this.d = null;
            return null;
         }
      } else {
         this.e = null;
         this.d = null;
         return null;
      }
   }

   public boolean a(dw var1) {
      boolean var9 = fj.z;
      double var2 = var1.a();
      double var4 = var1.b();
      Iterator var6 = this.a.iterator();

      boolean var10000;
      while(true) {
         if(!var6.hasNext()) {
            var10000 = false;
            break;
         }

         eF var7 = (eF)var6.next();
         var7.a(this.e, this, this.d);
         if(var7.a(var2, var4)) {
            boolean var8 = var7.a(var1);
            var10000 = var8;
            if(var9) {
               break;
            }

            if(var8) {
               return true;
            }
         }
      }

      return var10000;
   }

   public void e() {
      boolean var2 = fj.z;
      if(this.f != null) {
         if(this.f.c()) {
            this.f.e();
         }

         this.f = null;
      }

      if(this.e != null) {
         this.e.setViewCursor(Cursor.getDefaultCursor());
         this.e = null;
      }

      this.d = null;
      Iterator var1 = this.a.iterator();

      while(true) {
         if(var1.hasNext()) {
            ((eF)var1.next()).a((ch)null, (eD)null, (fj)null);
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         super.e();
         break;
      }

   }

   public void b(dw var1) {
      boolean var10 = fj.z;
      if(this.f == null) {
         double var2 = var1.a();
         double var4 = var1.b();
         boolean var6 = false;
         Cursor var7 = null;
         Iterator var8 = this.a.iterator();

         label58: {
            Cursor var10000;
            while(true) {
               if(var8.hasNext()) {
                  label60: {
                     eF var9 = (eF)var8.next();
                     var9.a(this.e, this, this.d);
                     if(var9.a(var1)) {
                        this.f = var9;
                        this.f.a(this.c);
                        this.f.d();
                        this.f.b(var1);
                        if(!var10) {
                           break label60;
                        }
                     }

                     if(!var9.a(var2, var4)) {
                        continue;
                     }

                     var6 = true;
                     var10000 = var7;
                     if(var10) {
                        break;
                     }

                     if(var7 != null) {
                        continue;
                     }

                     var7 = var9.c(var1);
                     if(!var10) {
                        continue;
                     }
                  }
               }

               if(this.f != null) {
                  return;
               }

               if(!var6 || this.e == null) {
                  break label58;
               }

               var10000 = var7;
               break;
            }

            if(var10000 != null) {
               this.e.setViewCursor(var7);
               if(!var10) {
                  return;
               }
            }

            this.e.setViewCursor(Cursor.getDefaultCursor());
            if(!var10) {
               return;
            }
         }

         this.e();
         if(!var10) {
            return;
         }
      }

      this.f.b(var1);
   }

   private eF a(double var1, double var3) {
      if(!this.a.isEmpty()) {
         Iterator var5 = this.a.iterator();

         while(var5.hasNext()) {
            eF var6 = (eF)var5.next();
            var6.a(this.e, this, this.d);
            if(var6.a(var1, var3)) {
               return var6;
            }
         }
      }

      return null;
   }

   static eF a(eD var0, eF var1) {
      return var0.f = var1;
   }
}
