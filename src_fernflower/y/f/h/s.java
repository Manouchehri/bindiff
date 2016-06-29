package y.f.h;

import java.util.Comparator;
import y.f.h.D;
import y.f.h.N;
import y.f.h.R;
import y.f.h.p;
import y.f.h.t;
import y.f.h.u;
import y.f.h.v;
import y.f.h.w;
import y.f.h.x;
import y.f.h.z;

public class s implements x {
   protected u a = new u();
   protected v b = new v();
   protected w c = new w();
   protected D d;
   protected y.c.i e;
   protected boolean f = false;
   protected R g = new R();
   protected y.c.h h = new t(this);
   protected y.c.d i = null;
   protected y.c.q j = null;
   protected y.c.f k;
   protected y.c.q l = null;
   protected y.c.q m = null;
   private int n = 50;
   private boolean o;

   public void a(boolean var1) {
      this.o = var1;
   }

   public void a(int var1) {
      this.n = var1;
   }

   public y.c.f c_() {
      if(this.f) {
         return this.k;
      } else {
         throw new RuntimeException("Invalid Execution Order: call \'createPlanarization\' first!");
      }
   }

   public void a(D var1) {
      this.d = var1;
      this.e = var1.g();
      if(this.e.f() != 0 && this.e.h() != 0) {
         this.g.a(this.e);
         this.g.a(this.o);
         int[] var2 = new int[this.e.e()];
         z var3 = new z(this.e, this.h);
         y.c.y var4 = this.a(var2, var3);
         var3.a(var4, var2);
         this.k = var3.c();
         y.c.A var5 = this.e.t();
         y.c.A var6 = this.e.t();
         this.a(var5, var6, var4);
         y.c.f var7 = new y.c.f(var3.a().iterator());
         y.c.f var8 = new y.c.f(var3.b().iterator());
         this.a(var7, var8, var5, var6, var2);
         this.e.a(var5);
         this.e.a(var6);
         var1.l();
         if(this.i == null) {
            this.i = this.e.l();
         }

         var1.b((p)var1.i(this.i));
         this.f = true;
         this.c();
      } else {
         this.k = new y.c.f();
         this.f = true;
      }
   }

   protected y.c.y a(int[] var1, z var2) {
      y.c.y var3;
      y.c.y var4;
      int var5;
      boolean var9;
      int var10000;
      label105: {
         var9 = N.d;
         var3 = new y.c.y();
         var4 = null;
         if(this.o) {
            var5 = Integer.MAX_VALUE;
            int var6 = 0;

            label101:
            do {
               label88:
               while(true) {
                  if(var6 >= this.n) {
                     break label101;
                  }

                  var10000 = var5;
                  if(var9) {
                     break label105;
                  }

                  if(var5 <= 0) {
                     break label101;
                  }

                  this.g.a(var3);
                  int var7 = 1;
                  y.c.x var8 = var3.a();

                  label75: {
                     while(var8.f()) {
                        var1[var8.e().d()] = var7++;
                        var8.g();
                        if(var9) {
                           break label75;
                        }

                        if(var9) {
                           break;
                        }
                     }

                     var2.a(var3, var1);
                     this.k = var2.c();
                  }

                  if(var5 <= this.k.size()) {
                     break;
                  }

                  var5 = this.k.size();
                  var4 = new y.c.y();
                  var8 = var3.a();

                  while(true) {
                     if(!var8.f()) {
                        break label88;
                     }

                     var4.b(var8.e());
                     var8.g();
                     if(var9) {
                        break;
                     }

                     if(var9) {
                        break label88;
                     }
                  }
               }

               y.c.e var12 = this.k.a();

               while(var12.f()) {
                  this.e.e(var12.a());
                  var12.g();
                  if(var9) {
                     continue label101;
                  }

                  if(var9) {
                     break;
                  }
               }

               ++var6;
            } while(!var9);

            var3 = var4;
         } else {
            this.g.a(var3);
            var4 = var3;
         }

         var10000 = 1;
      }

      var5 = var10000;
      y.c.x var10 = var4.a();

      while(true) {
         if(var10.f()) {
            var1[var10.e().d()] = var5++;
            var10.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var10 = var3.a();
         var10.i();
         this.l = var10.e();
         var10.j();
         this.m = var10.e();
         break;
      }

      var10 = var3.a();

      while(var10.f()) {
         y.c.q var11 = var10.e();
         if(var11.a() != 0) {
            this.j = var11;
            if(!var9) {
               break;
            }
         }

         var10.g();
         if(var9) {
            break;
         }
      }

      return var3;
   }

   protected void a(y.c.A var1, y.c.A var2, y.c.y var3) {
      boolean var9 = N.d;
      y.c.x var4 = var3.a();

      y.c.q var5;
      while(true) {
         if(var4.f()) {
            var5 = var4.e();
            var1.a(var5, (Object)null);
            var2.a(var5, (Object)null);
            var4.g();
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var4 = var3.a();
         break;
      }

      while(var4.f()) {
         var5 = var4.e();
         y.c.p var6 = var3.d(var5);
         y.c.q var10000 = var5;

         label43:
         while(true) {
            y.c.e var7 = var10000.j();

            while(true) {
               if(!var7.f()) {
                  break label43;
               }

               y.c.d var8 = var7.a();
               var10000 = var5;
               if(var9) {
                  break;
               }

               label38: {
                  if(var5 != (y.c.q)var3.f() && var8.a(var5) == (y.c.q)var3.d(var6).c()) {
                     var1.a(var5, var8);
                     if(!var9) {
                        break label38;
                     }
                  }

                  if(var5 != (y.c.q)var3.i() && var8.a(var5) == (y.c.q)var3.c(var6).c()) {
                     var2.a(var5, var8);
                  }
               }

               var7.g();
               if(var9) {
                  break label43;
               }
            }
         }

         var4.g();
         if(var9) {
            break;
         }
      }

   }

   protected void a(y.c.f var1, y.c.A var2) {
      boolean var8 = N.d;
      y.c.e var3 = var1.a();

      while(var3.f()) {
         y.c.d var4;
         y.c.q var6;
         y.c.f var7;
         label25: {
            var4 = var3.a();
            y.c.q var5 = var4.c();
            var6 = var4.d();
            if(var2.b(var5) == null) {
               var7 = new y.c.f();
               var7.add(var4);
               var2.a(var5, var7);
               if(!var8) {
                  break label25;
               }
            }

            ((y.c.f)var2.b(var5)).add(var4);
         }

         label20: {
            if(var2.b(var6) == null) {
               var7 = new y.c.f();
               var7.add(var4);
               var2.a(var6, var7);
               if(!var8) {
                  break label20;
               }
            }

            ((y.c.f)var2.b(var6)).add(var4);
         }

         var3.g();
         if(var8) {
            break;
         }
      }

   }

   protected void a(y.c.f var1, y.c.f var2, y.c.A var3, y.c.A var4, int[] var5) {
      boolean var15 = N.d;
      y.c.A var9 = this.e.t();
      y.c.A var10 = this.e.t();
      this.a(var1, var9);
      this.a(var2, var10);
      this.b();
      this.b.a(var5);
      this.c.a(var5);
      y.c.x var11 = this.e.o();

      while(true) {
         if(var11.f()) {
            y.c.q var12 = var11.e();
            y.c.f var13 = new y.c.f();
            y.c.f var6 = (y.c.f)var9.b(var12);
            if(var15) {
               break;
            }

            if(var6 != null) {
               this.b.a(var12);
               var6.sort(this.b);
            }

            y.c.f var7 = (y.c.f)var10.b(var12);
            if(var7 != null) {
               this.c.a(var12);
               var7.sort(this.c);
            }

            y.c.d var8 = (y.c.d)var3.b(var12);
            if(var8 != null) {
               label204: {
                  if(var8.c() == var12) {
                     var13.add(var8);
                     if(!var15) {
                        break label204;
                     }
                  }

                  var13.add(this.d.h(var8));
               }
            }

            label176: {
               y.c.e var14;
               y.c.q var10000;
               label207: {
                  if(var6 != null) {
                     var14 = var6.a();

                     while(var14.f()) {
                        var8 = var14.a();
                        var10000 = var8.c();
                        if(var15) {
                           if(var10000 == var12) {
                              var13.add(var8);
                              if(var15) {
                                 var13.add(this.d.h(var8));
                              }
                           } else {
                              var13.add(this.d.h(var8));
                           }

                           if(var12 == this.j && this.i == null) {
                              this.i = (y.c.d)var13.i();
                           }

                           if(var7 == null) {
                              break label176;
                           }

                           var14 = var7.a();
                           if(!var14.f()) {
                              break label176;
                           }
                           break label207;
                        }

                        if(var10000 == var12) {
                           var13.add(var8);
                           if(var15) {
                              var13.add(this.d.h(var8));
                           }
                        } else {
                           var13.add(this.d.h(var8));
                        }

                        if(var12 == this.j && this.i == null) {
                           this.i = (y.c.d)var13.i();
                        }

                        var14.g();
                        if(var15) {
                           break;
                        }
                     }
                  }

                  var8 = (y.c.d)var4.b(var12);
                  if(var8 != null) {
                     if(var8.c() == var12) {
                        var13.add(var8);
                        if(var15) {
                           var13.add(this.d.h(var8));
                        }
                     } else {
                        var13.add(this.d.h(var8));
                     }

                     if(var12 == this.j && this.i == null) {
                        this.i = (y.c.d)var13.i();
                     }

                     if(var7 == null) {
                        break label176;
                     }

                     var14 = var7.a();
                     if(!var14.f()) {
                        break label176;
                     }
                  } else {
                     if(var7 == null) {
                        break label176;
                     }

                     var14 = var7.a();
                     if(!var14.f()) {
                        break label176;
                     }
                  }
               }

               label162:
               do {
                  while(true) {
                     var8 = var14.a();
                     var10000 = var8.c();
                     if(!var15) {
                        if(var10000 == var12) {
                           var13.add(var8);
                           if(var15) {
                              var13.add(this.d.h(var8));
                           }
                        } else {
                           var13.add(this.d.h(var8));
                        }

                        if(var12 == this.j && this.i == null) {
                           this.i = (y.c.d)var13.i();
                        }

                        var14.g();
                        break;
                     }

                     if(var10000 == var12) {
                        var13.add(var8);
                        if(var15) {
                           var13.add(this.d.h(var8));
                        }
                     } else {
                        var13.add(this.d.h(var8));
                     }

                     if(var12 == this.j && this.i == null) {
                        this.i = (y.c.d)var13.i();
                     }

                     if(var7 == null) {
                        break label162;
                     }

                     var14 = var7.a();
                     if(!var14.f()) {
                        break label162;
                     }
                  }
               } while(!var15 && var14.f());
            }

            this.a.a(var13);
            var12.b((Comparator)this.a);
            var11.g();
            if(!var15) {
               continue;
            }
         }

         this.e.a(var9);
         this.e.a(var10);
         break;
      }

   }

   protected void b() {
      boolean var3 = N.d;
      y.c.f var1 = new y.c.f(this.e.p());
      y.c.e var2 = var1.a();

      while(var2.f()) {
         this.d.g(var2.a());
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void c() {
   }
}
