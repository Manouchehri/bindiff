package y.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y.g.K;
import y.g.p;

public class J {
   private y.c.i a;
   private List b;
   private List c;
   private boolean d = true;
   private y.c.c e;
   private Map f;
   private static final Object g = new Object();

   public J(y.c.i var1, y.c.c var2) {
      this.a = var1;
      this.b = new ArrayList(var1.g());
      this.c = new ArrayList(var1.e());
      this.a(var2);
   }

   public void a(y.c.c var1) {
      boolean var8 = p.c;
      this.f = new HashMap();
      this.e = var1;
      y.c.x var2 = this.a.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         Object var4 = var1.b(var3);
         K var5 = (K)this.f.get(var4 == null?g:var4);
         if(var5 == null) {
            var5 = new K();
            this.f.put(var4 == null?g:var4, var5);
         }

         var5.a.add(var3);
         y.c.d var6 = var3.g();

         label142:
         while(true) {
            Object var10000;
            Object var10001;
            Object var7;
            if(var6 != null) {
               var7 = var1.b(var6.c());
               var10000 = var7;
               var10001 = var4;
               if(!var8) {
                  if(var7 != var4) {
                     if(var7 != null) {
                        if(!var7.equals(var4)) {
                           var5.c.add(var6);
                        }
                     } else {
                        var5.c.add(var6);
                     }
                  }

                  var6 = var6.h();
                  if(!var8) {
                     continue;
                  }

                  var6 = var3.f();
                  if(var6 == null) {
                     break;
                  }

                  var7 = var1.b(var6.d());
                  var10000 = var7;
                  var10001 = var4;
               }
            } else {
               var6 = var3.f();
               if(var6 == null) {
                  break;
               }

               var7 = var1.b(var6.d());
               var10000 = var7;
               var10001 = var4;
            }

            while(true) {
               while(var8) {
                  if(var10000 != var10001) {
                     if(var7 != null) {
                        if(!var7.equals(var4)) {
                           var5.c.add(var6);
                        }
                     } else {
                        var5.c.add(var6);
                     }
                  }

                  var6 = var6.h();
                  if(!var8) {
                     continue label142;
                  }

                  var6 = var3.f();
                  if(var6 == null) {
                     break label142;
                  }

                  var7 = var1.b(var6.d());
                  var10000 = var7;
                  var10001 = var4;
               }

               if(var10000 != var10001) {
                  if(var7 != null) {
                     if(var7.equals(var4)) {
                        var5.b.add(var6);
                        if(var8) {
                           var5.c.add(var6);
                           var6 = var6.g();
                           if(var8) {
                              break label142;
                           }
                        } else {
                           var6 = var6.g();
                           if(var8) {
                              break label142;
                           }
                        }
                     } else {
                        var5.c.add(var6);
                        var6 = var6.g();
                        if(var8) {
                           break label142;
                        }
                     }
                  } else {
                     var5.c.add(var6);
                     var6 = var6.g();
                     if(var8) {
                        break label142;
                     }
                  }
               } else {
                  var5.b.add(var6);
                  if(var8) {
                     var5.c.add(var6);
                     var6 = var6.g();
                     if(var8) {
                        break label142;
                     }
                  } else {
                     var6 = var6.g();
                     if(var8) {
                        break label142;
                     }
                  }
               }

               if(var6 == null) {
                  break label142;
               }

               var7 = var1.b(var6.d());
               var10000 = var7;
               var10001 = var4;
            }
         }

         var2.g();
         if(var8) {
            break;
         }
      }

   }

   public void a(Object var1) {
      boolean var5 = p.c;
      K var2 = (K)this.f.get(var1 == null?g:var1);
      if(var2 != null) {
         int var3 = var2.a.size() - 1;

         while(var3 >= 0) {
            y.c.q var4 = (y.c.q)var2.a.get(var3);
            this.a(var4);
            --var3;
            if(var5) {
               break;
            }
         }
      }

   }

   public void b(Object var1) {
      boolean var5 = p.c;
      K var2 = (K)this.f.get(var1 == null?g:var1);
      if(var2 != null) {
         int var3 = var2.a.size() - 1;

         int var10000;
         label64: {
            while(var3 >= 0) {
               y.c.q var4 = (y.c.q)var2.a.get(var3);
               var10000 = this.a.f(var4);
               if(var5) {
                  break label64;
               }

               if(var10000 == 0) {
                  this.b(var4);
               }

               --var3;
               if(var5) {
                  break;
               }
            }

            var10000 = var2.b.size() - 1;
         }

         var3 = var10000;

         y.c.d var6;
         label52: {
            while(var3 >= 0) {
               var6 = (y.c.d)var2.b.get(var3);
               var10000 = this.a.f(var6);
               if(var5) {
                  break label52;
               }

               if(var10000 == 0) {
                  this.a(var6);
               }

               --var3;
               if(var5) {
                  break;
               }
            }

            var10000 = var2.c.size() - 1;
         }

         var3 = var10000;

         while(var3 >= 0) {
            var6 = (y.c.d)var2.c.get(var3);
            if(this.a.f(var6.c()) && this.a.f(var6.d()) && !this.a.f(var6)) {
               this.a(var6);
            }

            --var3;
            if(var5) {
               break;
            }
         }
      }

   }

   public void c(Object var1) {
      boolean var5 = p.c;
      y.c.x var2 = this.a.o();

      Object var10000;
      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            Object var4 = this.e.b(var3);
            var10000 = var4;
            if(var5) {
               break;
            }

            if(var4 != var1 && (var1 == null || !var1.equals(var4))) {
               this.a(var3);
            }

            var2.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = this.f.get(var1 == null?g:var1);
         break;
      }

      K var6 = (K)var10000;
      if(var6 != null) {
         int var7 = var6.a.size() - 1;

         int var10;
         label50: {
            while(var7 >= 0) {
               y.c.q var8 = (y.c.q)var6.a.get(var7);
               var10 = this.a.f(var8);
               if(var5) {
                  break label50;
               }

               if(var10 == 0) {
                  this.b(var8);
               }

               --var7;
               if(var5) {
                  break;
               }
            }

            var10 = var6.b.size() - 1;
         }

         var7 = var10;

         while(var7 >= 0) {
            y.c.d var9 = (y.c.d)var6.b.get(var7);
            if(!this.a.f(var9)) {
               this.a(var9);
            }

            --var7;
            if(var5) {
               break;
            }
         }
      }

   }

   public void a() {
      boolean var2 = p.c;
      y.c.x var1 = this.a.o();

      while(var1.f()) {
         this.a(var1.e());
         var1.g();
         if(var2) {
            break;
         }
      }

   }

   public void b() {
      this.c();
      this.d();
   }

   public void c() {
      boolean var3 = p.c;
      int var1 = this.c.size() - 1;

      J var10000;
      while(true) {
         if(var1 >= 0) {
            y.c.q var2 = (y.c.q)this.c.get(var1);
            var10000 = this;
            if(var3) {
               break;
            }

            if(!this.a.f(var2)) {
               this.b(var2);
            }

            --var1;
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.c.clear();
   }

   public void d() {
      boolean var3 = p.c;
      int var1 = this.b.size() - 1;

      J var10000;
      while(true) {
         if(var1 >= 0) {
            y.c.d var2 = (y.c.d)this.b.get(var1);
            var10000 = this;
            if(var3) {
               break;
            }

            if(!this.a.f(var2)) {
               this.a(var2);
            }

            --var1;
            if(!var3) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      var10000.b.clear();
   }

   public void a(y.c.q var1) {
      boolean var4 = p.c;
      if(this.a.f(var1)) {
         y.c.d var2 = var1.g();

         boolean var10000;
         label52:
         while(true) {
            y.c.d var3;
            if(var2 != null) {
               var3 = var2;
               var2 = var2.h();
               this.b.add(var3);
               var10000 = this.d;
               if(var4) {
                  break;
               }

               if(var10000) {
                  this.a.d(var3);
                  if(!var4) {
                     continue;
                  }
               }

               this.a.a(var3);
               if(!var4) {
                  continue;
               }
            }

            var2 = var1.f();

            while(var2 != null) {
               var3 = var2;
               var2 = var2.g();
               this.b.add(var3);
               var10000 = this.d;
               if(var4) {
                  break label52;
               }

               if(var10000) {
                  this.a.d(var3);
                  if(!var4) {
                     continue;
                  }
               }

               this.a.a(var3);
               if(var4) {
                  break;
               }
            }

            this.c.add(var1);
            var10000 = this.d;
            break;
         }

         if(var10000) {
            this.a.c(var1);
            if(!var4) {
               return;
            }
         }

         this.a.a(var1);
      }
   }

   protected void a(y.c.d var1) {
      if(this.d) {
         this.a.e(var1);
         if(!p.c) {
            return;
         }
      }

      this.a.b(var1);
   }

   protected void b(y.c.q var1) {
      if(this.d) {
         this.a.d(var1);
         if(!p.c) {
            return;
         }
      }

      this.a.b(var1);
   }
}
