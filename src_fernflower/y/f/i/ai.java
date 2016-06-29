package y.f.i;

import y.f.i.aj;
import y.f.i.ak;
import y.f.i.al;
import y.f.i.v;

class ai extends al {
   private y.c.D q;
   private y.c.D[] r = new y.c.D[2];
   private boolean s;
   private y.c.D t;
   private boolean u = false;
   private int v = -1;

   public ai(double var1, double var3, double var5, double var7, boolean var9) {
      super(var1, var3, var5, var7, var9);
   }

   public void a(y.c.d var1, double var2, double var4, double var6) {
      int var16 = v.f;
      if(var2 >= this.t() && var2 <= this.u()) {
         double var8 = Math.min(var4, var6);
         var6 = Math.max(var4, var6);
         var4 = var8;
         if(var8 < this.v()) {
            var4 = this.v();
         }

         if(var6 > this.w()) {
            var6 = this.w();
         }

         aj var10 = null;
         if(this.q == null) {
            this.q = new y.c.D();
            var10 = new aj(var1, var2, var4, var6);
            this.q.add(var10);
         } else {
            boolean var11 = false;
            y.c.p var12 = this.q.k();

            boolean var10000;
            label49: {
               while(var12 != null) {
                  var10000 = var11;
                  if(var16 != 0) {
                     break label49;
                  }

                  if(var11) {
                     break;
                  }

                  double var13 = ((aj)var12.c()).b;
                  if(var13 < var2) {
                     var12 = this.q.c(var12);
                     if(var16 == 0) {
                        continue;
                     }
                  }

                  if(var13 == var2) {
                     y.c.d var15 = ((aj)var12.c()).a;
                     if(var15 != var1) {
                        var12 = this.q.c(var12);
                        if(var16 == 0) {
                           continue;
                        }
                     }

                     var11 = true;
                     if(var16 == 0) {
                        continue;
                     }
                  }

                  var10 = new aj(var1, var2, var4, var6);
                  var12 = this.q.a((Object)var10, (y.c.p)var12);
                  var11 = true;
                  if(var16 != 0) {
                     break;
                  }
               }

               var10000 = var11;
            }

            if(!var10000) {
               var10 = new aj(var1, var2, var4, var6);
               this.q.add(var10);
            }
         }

      }
   }

   public y.c.C a() {
      return this.q != null?this.q.m():null;
   }

   public void a(aj var1) {
      int var5 = v.f;
      if(this.q != null) {
         boolean var2 = false;
         y.c.C var3 = this.q.m();

         while(var3.f() && !var2) {
            aj var4 = (aj)var3.d();
            if(var4 == var1) {
               this.q.b(var3);
               var2 = true;
            }

            var3.g();
            if(var5 != 0) {
               break;
            }
         }

      }
   }

   public aj a(y.c.d var1, boolean var2) {
      int var12 = v.f;
      if(this.q == null) {
         return null;
      } else {
         aj var3 = null;
         double var5 = this.v();
         double var7 = this.w();
         boolean var9 = false;
         y.c.C var10 = this.q.m();

         while(var10.f() && !var9) {
            aj var11 = (aj)var10.d();
            boolean var4 = var2?var11.c == var5:var11.d == var7;
            if(var4 && var1 == var11.a) {
               var3 = var11;
               var9 = true;
            }

            var10.g();
            if(var12 != 0) {
               break;
            }
         }

         return var3;
      }
   }

   public aj a(y.c.d var1) {
      int var11 = v.f;
      if(this.q == null) {
         return null;
      } else {
         aj var2 = null;
         double var4 = this.v();
         double var6 = this.w();
         boolean var8 = false;
         y.c.C var9 = this.q.m();

         aj var10000;
         while(true) {
            if(var9.f()) {
               var10000 = (aj)var9.d();
               if(var11 != 0) {
                  break;
               }

               aj var10 = var10000;
               if(var1 == var10.a) {
                  var2 = var10;
                  var8 = true;
               }

               var9.g();
               if(var11 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }

   public void a(aj var1, y.d.t var2, y.d.t var3) {
      int var11 = v.f;
      if(this.q != null) {
         double var4;
         double var6;
         label32: {
            if(this.m) {
               var4 = Math.min(var2.b, var3.b);
               var6 = Math.max(var2.b, var3.b);
               if(var11 == 0) {
                  break label32;
               }
            }

            var4 = Math.min(var2.a, var3.a);
            var6 = Math.max(var2.a, var3.a);
         }

         var4 = Math.max(var4, this.v());
         var6 = Math.min(var6, this.w());
         aj var8 = new aj(var1.a, var1.b, var4, var6);
         boolean var9 = false;
         y.c.p var10 = this.q.k();

         while(var10 != null && !var9) {
            if(var10.c() == var1) {
               var10.a(var8);
               var9 = true;
               if(var11 == 0) {
                  continue;
               }
            }

            var10 = this.q.c(var10);
            if(var11 != 0) {
               break;
            }
         }

      }
   }

   public void a(aj var1, double var2) {
      int var10 = v.f;
      if(this.q != null) {
         if(var2 >= this.t() && var2 <= this.u()) {
            if(var2 != var1.b) {
               boolean var4 = false;
               y.c.p var5;
               boolean var10000;
               if(var2 < var1.b) {
                  var5 = this.q.k();

                  label128: {
                     while(var5 != null) {
                        var10000 = var4;
                        if(var10 != 0) {
                           break label128;
                        }

                        if(var4) {
                           break;
                        }

                        double var7 = ((aj)var5.c()).b;
                        if(var7 < var2) {
                           var5 = this.q.c(var5);
                           if(var10 == 0) {
                              continue;
                           }
                        }

                        if(var7 == var2) {
                           y.c.d var9 = ((aj)var5.c()).a;
                           if(var9 != var1.a) {
                              var5 = this.q.c(var5);
                              if(var10 == 0) {
                                 continue;
                              }
                           }

                           var4 = true;
                           if(var10 == 0) {
                              continue;
                           }
                        }

                        aj.a(var1, var2);
                        this.q.a((Object)var1, (y.c.p)var5);
                        var5 = var5;
                        var4 = true;
                        if(var10 != 0) {
                           break;
                        }
                     }

                     var10000 = false;
                  }

                  var4 = var10000;

                  do {
                     do {
                        if(var5 == null || var4) {
                           return;
                        }

                        aj var12 = (aj)var5.c();
                        if(var12.a != var1.a) {
                           break;
                        }

                        this.q.h(var5);
                        var4 = true;
                     } while(var10 == 0);

                     var5 = this.q.c(var5);
                  } while(var10 == 0);
               }

               var5 = this.q.k();

               label91: {
                  while(var5 != null) {
                     var10000 = var4;
                     if(var10 != 0) {
                        break label91;
                     }

                     if(var4) {
                        break;
                     }

                     aj var6 = (aj)var5.c();
                     if(var6 == var1) {
                        this.q.h(var5);
                        var4 = true;
                        if(var10 == 0) {
                           continue;
                        }
                     }

                     var5 = this.q.c(var5);
                     if(var10 != 0) {
                        break;
                     }
                  }

                  var10000 = false;
               }

               var4 = var10000;

               label75: {
                  while(var5 != null) {
                     var10000 = var4;
                     if(var10 != 0) {
                        break label75;
                     }

                     if(var4) {
                        break;
                     }

                     double var11 = ((aj)var5.c()).b;
                     if(var11 < var2) {
                        var5 = this.q.c(var5);
                        if(var10 == 0) {
                           continue;
                        }
                     }

                     if(var11 == var2) {
                        y.c.d var8 = ((aj)var5.c()).a;
                        if(var8 != var1.a) {
                           var5 = this.q.c(var5);
                           if(var10 == 0) {
                              continue;
                           }
                        }

                        var4 = true;
                        if(var10 == 0) {
                           continue;
                        }
                     }

                     aj.a(var1, var2);
                     var5 = this.q.a((Object)var1, (y.c.p)var5);
                     var4 = true;
                     if(var10 != 0) {
                        break;
                     }
                  }

                  var10000 = var4;
               }

               if(!var10000) {
                  aj.a(var1, var2);
                  this.q.add(var1);
               }

            }
         }
      }
   }

   public double b() {
      if(this.q != null && !this.q.isEmpty()) {
         aj var1 = (aj)this.q.i();
         return var1.b;
      } else {
         return Double.NaN;
      }
   }

   public double c() {
      if(this.q != null && !this.q.isEmpty()) {
         aj var1 = (aj)this.q.f();
         return var1.b;
      } else {
         return Double.NaN;
      }
   }

   public ak a(double var1, double var3, boolean var5) {
      int var6 = var5?0:1;
      if(this.r[var6] == null) {
         this.r[var6] = new y.c.D();
      }

      ak var7 = new ak(var1, var3);
      this.r[var6].add(var7);
      return var7;
   }

   public y.c.D a(boolean var1) {
      int var2 = var1?0:1;
      return this.r[var2];
   }

   public void b(boolean var1) {
      this.s = var1;
   }

   public boolean d() {
      return this.s;
   }

   public void c(boolean var1) {
      int var2 = var1?0:1;
      if(this.r[var2] != null) {
         this.r[var2].clear();
      }

   }

   public void b(aj var1) {
      int var12 = v.f;
      if(var1.b >= this.v() && var1.b <= this.w()) {
         if(var1.d > this.t() && var1.c < this.u()) {
            double var2 = Math.max(this.t(), var1.c);
            double var4 = Math.min(this.u(), var1.d);
            aj var6 = null;
            if(this.t == null) {
               this.t = new y.c.D();
               var6 = new aj(var1.a, var1.b, var2, var4);
               this.t.add(var6);
               this.u = true;
            } else {
               boolean var7 = false;
               y.c.p var8 = this.t.k();

               boolean var10000;
               label47: {
                  while(var8 != null) {
                     var10000 = var7;
                     if(var12 != 0) {
                        break label47;
                     }

                     if(var7) {
                        break;
                     }

                     double var9 = ((aj)var8.c()).b;
                     if(var9 < var1.b) {
                        var8 = this.t.c(var8);
                        if(var12 == 0) {
                           continue;
                        }
                     }

                     if(var9 == var1.b) {
                        y.c.d var11 = ((aj)var8.c()).a;
                        if(var11 != var1.a) {
                           var8 = this.t.c(var8);
                           if(var12 == 0) {
                              continue;
                           }
                        }

                        var7 = true;
                        if(var12 == 0) {
                           continue;
                        }
                     }

                     var6 = new aj(var1.a, var1.b, var2, var4);
                     var8 = this.t.a((Object)var6, (y.c.p)var8);
                     var7 = true;
                     if(var12 != 0) {
                        break;
                     }
                  }

                  var10000 = var7;
               }

               if(!var10000) {
                  var6 = new aj(var1.a, var1.b, var2, var4);
                  this.t.add(var6);
               }
            }

         }
      }
   }

   public boolean a(double var1, double var3, y.c.d var5) {
      int var10 = v.f;
      if(this.t == null) {
         return false;
      } else {
         boolean var6 = false;
         boolean var7 = false;
         y.c.C var8 = this.t.m();

         boolean var10000;
         while(true) {
            if(var8.f()) {
               var10000 = var6;
               if(var10 != 0) {
                  break;
               }

               if(!var6) {
                  label34: {
                     aj var9 = (aj)var8.d();
                     if(var9.b == var3 && var9.a != var5) {
                        if(var1 < var9.c || var1 > var9.d) {
                           break label34;
                        }

                        var6 = true;
                        var7 = true;
                        if(var10 == 0) {
                           break label34;
                        }
                     }

                     if(var9.b > var3) {
                        var6 = true;
                     }
                  }

                  var8.g();
                  if(var10 == 0) {
                     continue;
                  }
               }
            }

            var10000 = var7;
            break;
         }

         return var10000;
      }
   }

   public void e() {
      if(this.t != null && this.u) {
         this.t.clear();
      }

   }
}
