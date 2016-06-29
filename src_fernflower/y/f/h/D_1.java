package y.f.h;

import java.util.ArrayList;
import y.f.X;
import y.f.h.E;
import y.f.h.F;
import y.f.h.N;
import y.f.h.P;
import y.f.h.Q;
import y.f.h.p;

public class D extends N {
   private y.c.h e;
   private y.c.h f;
   private y.c.f g;
   private y.c.A h;
   private ArrayList i;

   public D(y.c.i var1) {
      boolean var3 = N.d;
      super(var1);
      this.h = var1.t();
      this.e = var1.u();
      this.f = var1.u();
      this.i = new ArrayList();
      this.g = new y.c.f();
      y.c.e var2 = var1.p();

      while(var2.f()) {
         this.f(var2.a()).b(true);
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public void e() {
      super.e();
      this.a.a(this.e);
      this.a.a(this.f);
      this.a.a(this.h);
      this.g.clear();
   }

   public void a(y.c.q var1, int var2) {
      this.i(var1).a(var2);
   }

   public int a(y.c.q var1) {
      return this.i(var1).a();
   }

   public boolean b(y.c.q var1) {
      return this.a(var1) == 1;
   }

   public void c(y.c.q var1) {
      this.a((y.c.q)var1, 1);
   }

   public void d(y.c.q var1) {
      this.a((y.c.q)var1, 2);
   }

   public boolean e(y.c.q var1) {
      return this.a(var1) == 2;
   }

   public boolean f(y.c.q var1) {
      return this.a(var1) == 0;
   }

   public void g(y.c.q var1) {
      this.a((y.c.q)var1, 0);
   }

   public int a() {
      boolean var3 = N.d;
      int var1 = 0;
      y.c.x var2 = this.a.o();

      int var10000;
      while(true) {
         if(var2.f()) {
            var10000 = this.b(var2.e());
            if(var3) {
               break;
            }

            if(var10000 != 0) {
               ++var1;
            }

            var2.g();
            if(!var3) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public p[] a(p var1, y.c.d var2) {
      p[] var3 = this.a(var1, var2, (y.c.d)null, (y.c.d)null);
      return var3;
   }

   public p[] a(p var1, y.c.d var2, y.c.d var3, y.c.d var4) {
      boolean var15 = N.d;
      if(var3 != null && this.i(var3) != var1) {
         throw new RuntimeException("Fatal Error in edge to face assignment!");
      } else if(var4 != null && this.i(var4) != var1) {
         throw new RuntimeException("Fatal Error in edge to face assignment!");
      } else {
         if(this.e(var2.c())) {
            this.c(var2.c());
         }

         if(this.e(var2.d())) {
            this.c(var2.d());
         }

         y.c.e var5;
         y.c.d var16;
         label151: {
            label150: {
               label167: {
                  this.b.remove(var1);
                  var5 = var1.a();
                  if(var3 != null) {
                     if(var4 != null) {
                        break label151;
                     }
                  } else {
                     while(true) {
                        if(var5.f()) {
                           y.c.q var10000 = var5.a().d();
                           y.c.q var10001 = var2.c();
                           if(var15) {
                              if(var10000 == var10001) {
                                 break label167;
                              }

                              var5.b();
                              if(var15) {
                                 break label167;
                              }
                              break;
                           }

                           if(var10000 != var10001) {
                              var5.b();
                              if(!var15) {
                                 continue;
                              }
                           }
                        }

                        var3 = var5.a();
                        if(var4 != null) {
                           break label151;
                        }
                        break;
                     }
                  }

                  do {
                     if(!var5.f()) {
                        var16 = var5.a();
                        break label150;
                     }

                     var16 = var5.a();
                     if(var15) {
                        break label150;
                     }

                     if(var16.d() == var2.d()) {
                        break;
                     }

                     var5.b();
                  } while(!var15);
               }

               var16 = var5.a();
            }

            var4 = var16;
         }

         p[] var7;
         p var8;
         p var9;
         y.c.d var10;
         y.c.d var11;
         label110: {
            y.c.d var6 = this.g(var2);
            var7 = new p[2];
            var8 = new p();
            var9 = new p();
            if(var3.d() == var2.d()) {
               var10 = var2;
               var11 = var6;
               if(!var15) {
                  break label110;
               }
            }

            var10 = var6;
            var11 = var2;
         }

         this.f(var10).a(var8);
         this.f(var11).a(var9);
         var5.i();

         label104: {
            y.c.d var17;
            label103:
            while(true) {
               if(var5.f()) {
                  var16 = var5.a();
                  var17 = var3;
                  if(var15) {
                     break;
                  }

                  if(var16 != var3) {
                     var5.b();
                     if(!var15) {
                        continue;
                     }
                  }

                  var5.b();
               } else {
                  var5.b();
               }

               while(true) {
                  if(var5.f()) {
                     var16 = var5.a();
                     var17 = var4;
                     if(var15) {
                        break label103;
                     }

                     if(var16 != var4) {
                        this.f(var5.a()).a(var8);
                        var8.a(var5.a());
                        var5.b();
                        if(!var15) {
                           continue;
                        }
                     }
                  }

                  this.f(var4).a(var8);
                  var8.a(var4);
                  var8.a(var10);
                  this.b.add(var8);
                  var7[0] = var8;
                  var5.b();
                  if(!var5.f()) {
                     break label104;
                  }

                  var16 = var5.a();
                  var17 = var3;
                  break label103;
               }
            }

            while(var16 != var17) {
               this.f(var5.a()).a(var9);
               var9.a(var5.a());
               var5.b();
               if(var15 || !var5.f()) {
                  break;
               }

               var16 = var5.a();
               var17 = var3;
            }
         }

         this.f(var3).a(var9);
         var9.a(var3);
         var9.a(var11);
         this.b.add(var9);
         var7[1] = var9;
         if(this.i() == var1) {
            this.b((p)a(var8, var9));
         }

         this.a.a(var10, this.h(var4), (y.c.d)null, 0, 1);
         this.a.a(var11, this.h(var3), (y.c.d)null, 0, 1);
         p[] var12 = new p[]{var1};
         p[] var13 = new p[]{var8, var9};
         if(this.f(var2).f()) {
            y.c.p var14 = this.g.d(var2);
            if(var14 != null) {
               this.g.h(var14);
            }
         }

         this.a(var2, var12, var13);
         if(y.c.i.g) {
            N.d = !var15;
         }

         return var7;
      }
   }

   private static p a(p var0, p var1) {
      p var2 = var0.a().k() > var1.a().k()?var0:var1;
      return var2;
   }

   public void a(y.c.d var1, y.c.d var2) {
      boolean var8 = N.d;
      if(var1 == null && var2.c().a() > 2) {
         y.c.d var9 = null;
         y.c.e var10 = var2.c().l();

         while(true) {
            if(var10.f()) {
               y.c.d var11 = var10.a();
               if(var8) {
                  break;
               }

               if(var2 != var11) {
                  if(var9 == null) {
                     var9 = var11;
                  }

                  if(this.i(var11).a().k() == 1) {
                     var9 = var11;
                  }
               }

               var10.g();
               if(!var8) {
                  continue;
               }
            }

            this.a(var9, var2);
            break;
         }

      } else {
         p var3 = new p();
         y.c.d var4 = this.g(var2);
         var3.a(var4);
         this.b.add(var3);
         this.f(var4).a(var3);
         p var5;
         p[] var6;
         p[] var7;
         if(var1 != null) {
            var5 = this.i(var1);
            var5.a(var1, var2, var1);
            this.f(var2).a(var5);
            var6 = new p[]{var5};
            var7 = new p[]{var3, var5};
            this.a(var2, var6, var7);
            if(!var8) {
               return;
            }
         }

         var5 = new p();
         this.b.add(var5);
         this.f(var2).a(var5);
         var5.a(var2);
         var6 = new p[0];
         var7 = new p[]{var3, var5};
         this.a(var2, var6, var7);
      }
   }

   public p a(y.c.d var1, y.c.d var2, y.c.d var3) {
      p var4;
      p var5;
      p var6;
      y.c.d var10000;
      label353: {
         label354: {
            y.c.e var8;
            y.c.d var11;
            y.c.d var13;
            y.c.d var10001;
            boolean var18;
            label355: {
               var18 = N.d;
               var4 = new p();
               var5 = null;
               var6 = null;
               y.c.e var7 = null;
               var8 = null;
               y.c.q var9 = var1.c();
               y.c.q var10 = var1.d();
               y.c.d var12 = this.g(var1);
               y.c.d var14;
               if(var2 == null) {
                  label356: {
                     if(var9.a() == 2) {
                        var4.a(var12);
                        this.f(var12).a(var4);
                        var4.a(var1);
                        this.f(var1).a(var4);
                        if(!var18) {
                           break label356;
                        }
                     }

                     var4.a(var12);
                     this.f(var12).a(var4);
                     var13 = var9.f();
                     if(var13 == var1) {
                        throw new RuntimeException("Bridge Face failed !");
                     }

                     var5 = this.i(var13);
                     this.b.remove(var5);
                     var7 = var5.a();

                     while(var7.f()) {
                        var10000 = var7.a();
                        if(var18) {
                           if(var10000 == var13) {
                              throw new RuntimeException("Error in bridge Face !");
                           }

                           var6 = this.i(var13);
                           this.b.remove(var6);
                           var8 = var6.a();

                           label171: {
                              while(var8.f()) {
                                 var10000 = var8.a();
                                 if(var18) {
                                    break label171;
                                 }

                                 if(var10000 == var13) {
                                    break;
                                 }

                                 var8.b();
                                 if(var18) {
                                    break;
                                 }
                              }

                              var10000 = var8.a();
                           }

                           var11 = var10000;
                           var4.a(var11);
                           this.f(var11).a(var4);
                           var8.b();

                           while(var8.f()) {
                              var10000 = var8.a();
                              if(var18) {
                                 break label353;
                              }

                              if(var10000 == var11) {
                                 break;
                              }

                              var4.a(var8.a());
                              this.f(var8.a()).a(var4);
                              var8.b();
                              if(var18) {
                                 break;
                              }
                           }

                           if(this.i() == var6) {
                              this.b((p)var4);
                           }
                           break label354;
                        }

                        if(var10000 == var13) {
                           break;
                        }

                        var7.b();
                        if(var18) {
                           break;
                        }
                     }

                     var11 = var7.a();
                     var4.a(var11);
                     this.f(var11).a(var4);
                     var7.b();

                     while(var7.f()) {
                        var10000 = var7.a();
                        var10001 = var11;
                        if(var18) {
                           break label355;
                        }

                        if(var10000 == var11) {
                           break;
                        }

                        var4.a(var7.a());
                        this.f(var7.a()).a(var4);
                        var7.b();
                        if(var18) {
                           break;
                        }
                     }

                     var4.a(var1);
                     this.f(var1).a(var4);
                     if(this.i() == var5) {
                        this.b((p)var4);
                     }
                  }
               } else {
                  var4.a(var12);
                  this.f(var12).a(var4);
                  var5 = this.i(var2);
                  this.b.remove(var5);
                  var7 = var5.a();

                  label340:
                  while(true) {
                     if(var7.f()) {
                        var10000 = var7.a();
                        if(!var18) {
                           if(var10000 != var2) {
                              var7.b();
                              if(!var18) {
                                 continue;
                              }
                           }

                           var7.b();
                        } else {
                           if(var10000 == var2) {
                              break;
                           }

                           var14 = var7.a();
                           var4.a(var14);
                           this.f(var14).a(var4);
                           var7.b();
                           if(var18) {
                              break;
                           }
                        }
                     } else {
                        var7.b();
                     }

                     while(true) {
                        if(!var7.f()) {
                           break label340;
                        }

                        var10000 = var7.a();
                        if(var18) {
                           if(var10000 != null) {
                              var6 = this.i(var3);
                              this.b.remove(var6);
                              var8 = var6.a();

                              label235:
                              while(true) {
                                 if(var8.f()) {
                                    var10000 = var8.a();
                                    if(!var18) {
                                       if(var10000 != var3) {
                                          var8.b();
                                          if(!var18) {
                                             continue;
                                          }
                                       }

                                       var8.b();
                                    } else {
                                       if(var10000 == var3) {
                                          break;
                                       }

                                       var14 = var8.a();
                                       var4.a(var14);
                                       this.f(var14).a(var4);
                                       var8.b();
                                       if(var18) {
                                          break;
                                       }
                                    }
                                 } else {
                                    var8.b();
                                 }

                                 while(true) {
                                    if(!var8.f()) {
                                       break label235;
                                    }

                                    var10000 = var8.a();
                                    if(var18) {
                                       break label353;
                                    }

                                    if(var10000 == var3) {
                                       break label235;
                                    }

                                    var14 = var8.a();
                                    var4.a(var14);
                                    this.f(var14).a(var4);
                                    var8.b();
                                    if(var18) {
                                       break label235;
                                    }
                                 }
                              }

                              var4.a(var3);
                              this.f(var3).a(var4);
                              break label354;
                           }

                           if(var10.a() == 2) {
                              this.b.add(var4);
                              if(this.i() == var6) {
                                 this.b((p)var4);
                              }

                              var10000 = var2;
                              break label353;
                           }

                           var13 = var10.f();
                           var10000 = var13;
                           var10001 = var12;
                           break label355;
                        }

                        if(var10000 == var2) {
                           break label340;
                        }

                        var14 = var7.a();
                        var4.a(var14);
                        this.f(var14).a(var4);
                        var7.b();
                        if(var18) {
                           break label340;
                        }
                     }
                  }

                  var4.a(var2);
                  this.f(var2).a(var4);
                  var4.a(var1);
                  this.f(var1).a(var4);
                  if(this.i() == var5) {
                     this.b((p)var4);
                  }
               }

               if(var3 != null) {
                  var6 = this.i(var3);
                  this.b.remove(var6);
                  var8 = var6.a();

                  label161:
                  while(true) {
                     if(var8.f()) {
                        var10000 = var8.a();
                        if(!var18) {
                           if(var10000 != var3) {
                              var8.b();
                              if(!var18) {
                                 continue;
                              }
                           }

                           var8.b();
                        } else {
                           if(var10000 == var3) {
                              break;
                           }

                           var14 = var8.a();
                           var4.a(var14);
                           this.f(var14).a(var4);
                           var8.b();
                           if(var18) {
                              break;
                           }
                        }
                     } else {
                        var8.b();
                     }

                     while(true) {
                        if(!var8.f()) {
                           break label161;
                        }

                        var10000 = var8.a();
                        if(var18) {
                           break label353;
                        }

                        if(var10000 == var3) {
                           break label161;
                        }

                        var14 = var8.a();
                        var4.a(var14);
                        this.f(var14).a(var4);
                        var8.b();
                        if(var18) {
                           break label161;
                        }
                     }
                  }

                  var4.a(var3);
                  this.f(var3).a(var4);
                  break label354;
               }

               if(var10.a() == 2) {
                  this.b.add(var4);
                  if(this.i() == var6) {
                     this.b((p)var4);
                  }

                  var10000 = var2;
                  break label353;
               }

               var13 = var10.f();
               var10000 = var13;
               var10001 = var12;
            }

            if(var10000 == var10001) {
               throw new RuntimeException("Error in bridge Face !");
            }

            var6 = this.i(var13);
            this.b.remove(var6);
            var8 = var6.a();

            label134: {
               while(var8.f()) {
                  var10000 = var8.a();
                  if(var18) {
                     break label134;
                  }

                  if(var10000 == var13) {
                     break;
                  }

                  var8.b();
                  if(var18) {
                     break;
                  }
               }

               var10000 = var8.a();
            }

            var11 = var10000;
            var4.a(var11);
            this.f(var11).a(var4);
            var8.b();

            while(var8.f()) {
               var10000 = var8.a();
               if(var18) {
                  break label353;
               }

               if(var10000 == var11) {
                  break;
               }

               var4.a(var8.a());
               this.f(var8.a()).a(var4);
               var8.b();
               if(var18) {
                  break;
               }
            }

            if(this.i() == var6) {
               this.b((p)var4);
            }
         }

         this.b.add(var4);
         if(this.i() == var6) {
            this.b((p)var4);
         }

         var10000 = var2;
      }

      if(var10000 != null) {
         this.a.a(var1, this.h(var2), (y.c.d)null, 0, 1);
      }

      if(var3 != null) {
         this.a.a(this.h(var1), this.h(var3), (y.c.d)null, 0, 1);
      }

      p[] var19 = new p[]{var4};
      ArrayList var15 = new ArrayList(2);
      if(var5 != null) {
         var15.add(var5);
      }

      if(var6 != null) {
         var15.add(var6);
      }

      p[] var16 = new p[var15.size()];
      var15.toArray(var16);
      if(this.f(var1).f()) {
         y.c.p var17 = this.g.d(var1);
         if(var17 != null) {
            this.g.h(var17);
         }
      }

      this.a(var1, var16, var19);
      return var4;
   }

   public void a(y.c.d var1) {
      p[] var3;
      p[] var4;
      label130: {
         boolean var11 = N.d;
         y.c.d var2 = this.h(var1);
         p var5;
         p var6;
         p var7;
         y.c.e var8;
         if(this.i(var1) != this.i(var2)) {
            var5 = this.i(var1);
            var6 = this.i(var2);
            var7 = new p();
            var3 = new p[2];
            var4 = new p[1];
            var3[0] = var5;
            var3[1] = var6;
            var4[0] = var7;
            var8 = var5.a();
            y.c.e var9 = var6.a();
            this.b.remove(var5);
            this.b.remove(var6);

            label124: {
               while(var8.f()) {
                  y.c.d var10 = var8.a();
                  if(var11) {
                     break label124;
                  }

                  label120: {
                     label133: {
                        if(var10 != var1) {
                           var7.a(var10);
                           this.f(var10).a(var7);
                           if(!var11) {
                              break label133;
                           }
                        }

                        while(true) {
                           if(var9.a() != var2) {
                              var9.b();
                              if(var11) {
                                 break;
                              }

                              if(!var11) {
                                 continue;
                              }
                           }

                           var9.b();
                           break;
                        }

                        while(var9.a() != var2) {
                           var7.a(var9.a());
                           this.f(var9.a()).a(var7);
                           var9.b();
                           if(var11) {
                              break label120;
                           }

                           if(var11) {
                              break;
                           }
                        }
                     }

                     var8.g();
                  }

                  if(var11) {
                     break;
                  }
               }

               this.p(var1);
               this.p(var2);
               this.b.add(var7);
            }

            if(var5 != this.i() && var6 != this.i()) {
               break label130;
            }

            this.b((p)var7);
            if(!var11) {
               break label130;
            }
         }

         var5 = this.i(var1);
         var6 = new p();
         var7 = new p();
         var3 = new p[1];
         var4 = new p[]{var6, var7};
         var3[0] = var5;
         this.b.remove(var5);
         var8 = var5.a();

         label66: {
            while(var8.a() != var1) {
               var8.b();
               if(var11) {
                  break label66;
               }

               if(var11) {
                  break;
               }
            }

            var8.b();
         }

         label76: {
            while(var8.a() != var2) {
               var6.a(var8.a());
               this.f(var8.a()).a(var6);
               var8.b();
               if(var11) {
                  break label76;
               }

               if(var11) {
                  break;
               }
            }

            var8.b();
         }

         label86: {
            while(var8.a() != var1) {
               var7.a(var8.a());
               this.f(var8.a()).a(var7);
               var8.b();
               if(var11) {
                  break label86;
               }

               if(var11) {
                  break;
               }
            }

            if(var6.a().k() > 0) {
               if(var5 == this.i()) {
                  this.b((p)var6);
               }

               this.b.add(var6);
            }
         }

         if(var7.a().k() > 0) {
            if(var5 == this.i()) {
               this.b((p)var7);
            }

            this.b.add(var7);
         }

         if(var6.a().k() == 0 && var7.a().k() == 0) {
            this.b((p)this.h().a());
         }

         this.p(var1);
         this.p(var2);
      }

      this.b(var1, var3, var4);
   }

   public void a(y.c.d var1, y.c.q var2, p var3) {
      y.c.d var4;
      label11: {
         var4 = this.g(var1);
         if(var1.d().equals(var2)) {
            var3.a(var1, var4);
            if(!N.d) {
               break label11;
            }
         }

         var3.a(var4, var1);
      }

      this.f(var1).a(var3);
      this.f(var4).a(var3);
   }

   public y.c.q b(y.c.d var1) {
      y.c.d var2 = this.h(var1);
      y.c.q var3 = var1.c();
      y.c.q var4 = var1.d();
      y.c.q var5 = this.a.d();
      this.d(var5);
      y.c.d var6 = this.a.a(var3, var1, var5, (y.c.d)null, 1, 0);
      this.f(var6).c(false);
      y.c.d var7 = this.a.a(var5, (y.c.d)null, var4, var1, 0, 1);
      this.f(var7).c(false);
      y.c.d var8 = this.a.a(var4, var2, var5, (y.c.d)null, 1, 0);
      this.f(var8).c(true);
      y.c.d var9 = this.a.a(var5, (y.c.d)null, var3, var2, 0, 1);
      this.f(var9).c(true);
      y.c.f var10 = new y.c.f();
      var10.add(var6);
      var10.add(var7);
      this.a(var1, var10, 0);
      p var11 = this.i(var1);
      p var12 = this.i(var2);
      this.f(var6).a(var11);
      this.f(var7).a(var11);
      this.f(var8).a(var12);
      this.f(var9).a(var12);
      var11.a(var1, var6, var7);
      var12.a(var2, var8, var9);
      this.b(var6, var9);
      this.b(var7, var8);
      this.a(var1, var10.e());
      this.p(var1);
      this.p(var2);
      return var5;
   }

   public y.c.f a(y.c.d var1, int var2) {
      boolean var19 = N.d;
      y.c.d var3 = this.h(var1);
      y.c.q var4 = var1.c();
      y.c.q var5 = var1.d();
      p var6 = this.i(var1);
      p var7 = this.i(var3);
      y.c.q[] var8 = new y.c.q[var2];
      y.c.q[] var9 = new y.c.q[var2 + 2];
      boolean var10 = this.n(var1);
      var9[0] = var4;
      var9[var2 + 1] = var5;
      int var11 = 0;

      while(var11 < var2) {
         var8[var11] = this.a.d();
         var9[var11 + 1] = var8[var11];
         this.d(var8[var11]);
         ++var11;
         if(var19) {
            break;
         }
      }

      y.c.f var20 = new y.c.f();
      y.c.f var12 = new y.c.f();
      y.c.d var13 = this.a.a(var4, var1, var8[0], (y.c.d)null, 1, 0);
      var20.b(var13);
      y.c.d var14 = this.a.a(var8[0], (y.c.d)null, var4, var3, 0, 1);
      var12.a(var14);
      this.b(var13, var14);
      int var15 = 1;

      y.c.d var16;
      D var10000;
      while(true) {
         if(var15 < var2) {
            var16 = this.a.a(var9[var15], var9[var15 + 1]);
            y.c.d var17 = this.a.a(var9[var15 + 1], var9[var15]);
            var20.b(var16);
            var12.a(var17);
            var10000 = this;
            if(var19) {
               break;
            }

            this.b(var16, var17);
            ++var15;
            if(!var19) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      label50: {
         y.c.d var21 = var10000.a.a(var8[var2 - 1], (y.c.d)null, var5, var1, 0, 1);
         var20.b(var21);
         var16 = this.a.a(var5, var3, var8[var2 - 1], (y.c.d)null, 1, 0);
         var12.a(var16);
         this.b(var21, var16);
         if(var10) {
            this.a(var3, var12, 0);
            if(!var19) {
               break label50;
            }
         }

         this.a(var1, var20, 0);
      }

      this.a(var1, var20.e());
      this.p(var1);
      this.p(var3);
      y.c.e var22 = var20.a();

      y.c.d var18;
      while(true) {
         if(var22.f()) {
            var18 = var22.a();
            this.f(var18).a(var6);
            this.f(var18).c(var10);
            var22.g();
            if(var19) {
               break;
            }

            if(!var19) {
               continue;
            }
         }

         var22 = var12.a();
         break;
      }

      while(true) {
         if(var22.f()) {
            var18 = var22.a();
            this.f(var18).a(var7);
            if(var19) {
               break;
            }

            this.f(var18).c(!var10);
            var22.g();
            if(!var19) {
               continue;
            }
         }

         var6.a(var1, var20);
         var7.a(var3, var12);
         break;
      }

      return var20;
   }

   public y.c.d h(y.c.q var1) {
      boolean var17 = N.d;
      y.c.f var12 = new y.c.f();
      if(var1.b() == 2 && var1.c() == 2) {
         y.c.d var2;
         y.c.d var3;
         y.c.d var6;
         y.c.d var8;
         label38: {
            y.c.e var13 = var1.k();
            y.c.d var4 = var13.a();
            var13.g();
            y.c.d var5 = var13.a();
            var13 = var1.l();
            var2 = var13.a();
            var13.g();
            var3 = var13.a();
            if(this.n(var4)) {
               var6 = var5;
               var8 = var4;
               if(!var17) {
                  break label38;
               }
            }

            var6 = var4;
            var8 = var5;
         }

         y.c.d var7;
         y.c.d var9;
         label33: {
            if(var2 == this.h(var6)) {
               var7 = var3;
               var9 = var2;
               if(!var17) {
                  break label33;
               }
            }

            var7 = var2;
            var9 = var3;
         }

         y.c.d var11;
         label28: {
            y.c.d var14 = (y.c.d)this.f.b(var6);
            if(var6.c() == var14.c() && var7.d() == var14.d()) {
               this.q(var14);
               var11 = var14;
               if(!var17) {
                  break label28;
               }
            }

            var11 = this.a.a(var6.c(), var7.d());
         }

         y.c.d var10 = this.g(var11);
         if(var8.c() == var10.c() && var9.d() == var10.d()) {
            p var15 = this.i(var6);
            var15.b(var6, var7, var11);
            this.f(var11).a(var15);
            p var16 = this.i(var8);
            var16.b(var8, var9, var10);
            this.f(var10).a(var16);
            this.j(var1);
            var12.a(var7);
            var12.a(var6);
            this.a(var11, var12, 1);
            this.a(var12.e(), var11);
            return var11;
         } else {
            throw new RuntimeException("Reverse Edge Restauration failed!");
         }
      } else {
         throw new RuntimeException("Node is not a crossing");
      }
   }

   public void a(Q var1) {
      this.i.add(var1);
   }

   public void b(Q var1) {
      int var2 = this.i.indexOf(var1);
      if(var2 >= 0) {
         this.i.remove(var2);
      }

   }

   protected void a(y.c.d var1, y.c.d[] var2) {
      boolean var5 = N.d;
      int var3 = 0;

      while(var3 < this.i.size()) {
         Q var4 = (Q)this.i.get(var3);
         var4.a(var1, var2);
         ++var3;
         if(var5) {
            break;
         }
      }

   }

   protected void a(y.c.d[] var1, y.c.d var2) {
      boolean var5 = N.d;
      int var3 = 0;

      while(var3 < this.i.size()) {
         Q var4 = (Q)this.i.get(var3);
         var4.a(var1, var2);
         ++var3;
         if(var5) {
            break;
         }
      }

   }

   protected void a(y.c.d var1, p[] var2, p[] var3) {
      boolean var6 = N.d;
      int var4 = 0;

      while(var4 < this.i.size()) {
         Q var5 = (Q)this.i.get(var4);
         var5.a(var1, var2, var3);
         ++var4;
         if(var6) {
            break;
         }
      }

   }

   protected void b(y.c.d var1, p[] var2, p[] var3) {
      boolean var6 = N.d;
      int var4 = 0;

      while(var4 < this.i.size()) {
         Q var5 = (Q)this.i.get(var4);
         var5.b(var1, var2, var3);
         ++var4;
         if(var6) {
            break;
         }
      }

   }

   public y.c.e c(y.c.d var1) {
      y.c.p var2 = this.g.d(var1);
      y.c.f var3;
      if(var2 == null) {
         var3 = new y.c.f();
         var3.add(var1);
         return var3.a();
      } else {
         var3 = (y.c.f)this.e.b(var1);
         return var3.a();
      }
   }

   public y.c.d d(y.c.d var1) {
      y.c.d var2 = (y.c.d)this.f.b(var1);
      if(var2 == null) {
         var2 = var1;
      }

      return var2;
   }

   public void a(y.c.d var1, y.c.f var2, int var3) {
      boolean var10 = N.d;
      y.c.p var7;
      if(var3 == 0) {
         y.c.d var6;
         if(this.f(var1).f()) {
            y.c.p var4 = this.g.d(var1);
            if(var4 == null) {
               this.g.add(var1);
            }

            this.e.a(var1, var2);
            y.c.e var5 = var2.a();

            do {
               if(!var5.f()) {
                  return;
               }

               var6 = var5.a();
               this.f.a(var6, var1);
               this.e.a(var6, var2);
               var5.g();
            } while(!var10);
         }

         y.c.f var11 = (y.c.f)this.e.b(var1);
         y.c.p var13 = var11.d(var1);
         var6 = (y.c.d)this.f.b(var13.c());
         var7 = var13;
         y.c.e var8 = var2.a();

         label64: {
            while(var8.f()) {
               y.c.d var9 = var8.a();
               this.f.a(var9, var6);
               var11.b(var9, var7);
               var7 = var11.c(var7);
               var8.g();
               if(var10) {
                  break label64;
               }

               if(var10) {
                  break;
               }
            }

            var11.h(var13);
         }

         var8 = var11.a();

         do {
            if(!var8.f()) {
               return;
            }

            this.e.a(var8.a(), var11);
            var8.g();
         } while(!var10);
      }

      if(var3 != 1) {
         throw new RuntimeException("UNSPECIFIED EDGE RECOVERY");
      } else {
         y.c.e var12 = var2.a();
         this.e.a(var1, this.e.b(var12.a()));
         this.f.a(var1, this.f.b(var12.a()));
         y.c.f var14 = (y.c.f)this.e.b(var1);
         y.c.p var15 = var14.d(var12.a());
         var14.a(var1, var15);

         while(true) {
            if(var12.f()) {
               if(var12.a() != var14.g(var15)) {
                  throw new RuntimeException("WRONG SEGMENTS IN EDGE RECOVERY");
               }

               var7 = var14.c(var15);
               var14.h(var15);
               var15 = var7;
               if(var10) {
                  throw new RuntimeException("WRONG SEGMENTS IN EDGE RECOVERY");
               }

               var12.g();
               if(!var10) {
                  continue;
               }
            }

            if(var14.size() == 1) {
               this.g.remove(var1);
               this.e(var1);
               if(var10) {
                  throw new RuntimeException("UNSPECIFIED EDGE RECOVERY");
               }
            }
            break;
         }

      }
   }

   public void b() {
      boolean var7 = N.d;
      X var1 = (X)this.a;
      y.c.D var2 = new y.c.D();
      y.c.e var3 = this.g.a();

      label62:
      while(true) {
         boolean var10000 = var3.f();

         label59:
         while(var10000) {
            var2.clear();
            y.c.d var4 = var3.a();
            this.q(var4);
            y.c.e var5 = ((y.c.f)this.e.b(var4)).a();
            if(var7) {
               break label62;
            }

            if(var5 != null && var5.f()) {
               while(var5.f()) {
                  y.c.D var6 = var1.k(var5.a());
                  var2.a(var6);
                  var10000 = this.e(var5.a().d());
                  if(var7) {
                     continue label59;
                  }

                  if(var10000) {
                     var2.add(var1.l(var5.a().d()));
                  }

                  var5.g();
                  if(var7) {
                     break;
                  }
               }

               var1.b(var4, var2);
               var5.i();
               var1.a(var4, var1.n(var5.a()));
               var5.j();
               var1.b(var4, var1.o(var5.a()));
            }

            this.e.a(var3.a(), (Object)null);
            var3.g();
            if(!var7) {
               continue label62;
            }
            break;
         }

         this.g.clear();
         break;
      }

      y.c.x var8 = this.a.o();

      while(var8.f()) {
         if(this.b(var8.e()) || this.e(var8.e())) {
            this.j(var8.e());
         }

         var8.g();
         if(var7) {
            break;
         }
      }

   }

   public void e(y.c.d var1) {
      this.f(var1).b(true);
   }

   protected F i(y.c.q var1) {
      F var2 = (F)this.h.b(var1);
      if(var2 == null) {
         var2 = this.c();
         this.h.a(var1, var2);
      }

      return var2;
   }

   protected F c() {
      return new F();
   }

   protected E f(y.c.d var1) {
      return (E)this.o(var1);
   }

   protected E d() {
      return new E();
   }

   protected P d_() {
      return this.d();
   }

   private void p(y.c.d var1) {
      if(this.f(var1).f()) {
         this.a.d(var1);
         if(!N.d) {
            return;
         }
      }

      this.a.a(var1);
   }

   private void q(y.c.d var1) {
      if(this.f(var1).f()) {
         this.a.e(var1);
         if(!N.d) {
            return;
         }
      }

      throw new RuntimeException("Tried to reinsert non-original edge !");
   }

   private void j(y.c.q var1) {
      boolean var3 = N.d;
      y.c.e var2 = var1.j();

      while(true) {
         if(var2.f()) {
            this.p(var2.a());
            var2.g();
            if(var3) {
               break;
            }

            if(!var3) {
               continue;
            }
         }

         this.a.a(var1);
         break;
      }

   }
}
