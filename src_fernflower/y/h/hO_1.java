package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.h.aB;
import y.h.bu;
import y.h.fj;
import y.h.y;

abstract class hO implements Iterator {
   final bu d;
   final int e;
   ArrayList f;
   int g;

   protected hO(bu var1, int var2) {
      this.d = var1;
      this.e = var2;
   }

   public boolean hasNext() {
      if(this.f == null) {
         this.c();
      }

      if(this.g > this.f.size() - 1) {
         this.g = 0;
         this.f.clear();
         this.a();
      }

      return !this.f.isEmpty();
   }

   public Object next() {
      if(this.hasNext()) {
         return this.f.get(this.g++);
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   void c() {
      this.f = new ArrayList();
   }

   abstract void a();

   void a(y.c.d var1) {
      boolean var5 = fj.z;
      if((this.e & 2) != 0) {
         this.f.add(var1);
      }

      aB var2 = this.d.i(var1);
      if((this.e & 4) != 0) {
         this.f.add(var2.getSourcePort());
         this.f.add(var2.getTargetPort());
      }

      if((this.e & 8) != 0) {
         y var3 = var2.bends();

         while(var3.f()) {
            this.f.add(var3.a());
            var3.g();
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }
      }

      if((this.e & 32) != 0) {
         int var6 = 0;
         int var4 = var2.labelCount();

         while(var6 < var4) {
            this.f.add(var2.getLabel(var6));
            ++var6;
            if(var5) {
               break;
            }
         }
      }

   }

   void a(y.c.q var1) {
      boolean var5 = fj.z;
      if((this.e & 1) != 0) {
         this.f.add(var1);
      }

      fj var2 = this.d.t(var1);
      int var3;
      int var4;
      if((this.e & 64) != 0) {
         var3 = 0;
         var4 = var2.portCount();

         while(var3 < var4) {
            this.f.add(var2.getPort(var3));
            ++var3;
            if(var5) {
               return;
            }

            if(var5) {
               break;
            }
         }
      }

      if((this.e & 16) != 0) {
         var3 = 0;
         var4 = var2.labelCount();

         while(var3 < var4) {
            this.f.add(var2.getLabel(var3));
            ++var3;
            if(var5) {
               break;
            }
         }
      }

   }

   void b(y.c.d var1) {
      label43: {
         aB var2;
         label42: {
            boolean var4 = fj.z;
            var2 = this.d.i(var1);
            if((this.e & 32) != 0) {
               int var3 = var2.labelCount();

               while(var3-- > 0) {
                  this.f.add(var2.getLabel(var3));
                  if(var4) {
                     break label42;
                  }

                  if(var4) {
                     break;
                  }
               }
            }

            if((this.e & 8) != 0) {
               y var5 = var2.bends();
               var5.j();

               while(var5.f()) {
                  this.f.add(var5.a());
                  var5.h();
                  if(var4) {
                     break label43;
                  }

                  if(var4) {
                     break;
                  }
               }
            }
         }

         if((this.e & 4) != 0) {
            this.f.add(var2.getTargetPort());
            this.f.add(var2.getSourcePort());
         }
      }

      if((this.e & 2) != 0) {
         this.f.add(var1);
      }

   }

   void b(y.c.q var1) {
      label38: {
         boolean var4 = fj.z;
         fj var2 = this.d.t(var1);
         int var3;
         if((this.e & 16) != 0) {
            var3 = var2.labelCount();

            while(var3-- > 0) {
               this.f.add(var2.getLabel(var3));
               if(var4) {
                  break label38;
               }

               if(var4) {
                  break;
               }
            }
         }

         if((this.e & 64) != 0) {
            var3 = var2.portCount();

            while(var3-- > 0) {
               this.f.add(var2.getPort(var3));
               if(var4) {
                  return;
               }

               if(var4) {
                  break;
               }
            }
         }
      }

      if((this.e & 1) != 0) {
         this.f.add(var1);
      }

   }
}
