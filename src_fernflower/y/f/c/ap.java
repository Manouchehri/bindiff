package y.f.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import y.f.c.C;
import y.f.c.K;
import y.f.c.a;
import y.f.c.aq;
import y.f.c.ar;
import y.f.c.as;
import y.f.c.x;
import y.f.c.z;

class ap {
   private Map b = new HashMap();
   private y.c.f c;
   private y.c.y d;
   private y.f.X e;
   private y.c.A f;
   private y.c.A g;
   private y.c.A h;
   private y.c.A i;
   private y.c.A j;
   private Map k;
   private as l;
   private y.c.D m;
   double a = 20.0D;
   private y.c.A n;
   private y.c.h o;
   private y.c.c p;
   private y.c.c q;
   private double r;
   private y.c.h s;
   private y.c.h t;
   private boolean u = false;

   ap(y.f.X var1, y.c.A var2, y.c.A var3, y.c.D var4, y.c.A var5, y.c.h var6, y.c.h var7, y.c.h var8) {
      this.j = var2;
      this.e = var1;
      this.m = var4;
      this.f = var3;
      this.g = var5;
      this.s = var7;
      this.t = var8;
   }

   public void a(boolean var1) {
      this.u = var1;
   }

   public void a(y.c.A var1, y.c.c var2, y.c.h var3, y.c.c var4) {
      this.n = var1;
      this.o = var3;
      this.p = var2;
      this.q = var4;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public boolean a() {
      return this.c != null && this.c.size() > 0;
   }

   public void b() {
      boolean var3 = a.i;
      this.c = new y.c.f();
      y.c.e var1 = this.e.p();

      while(var1.f()) {
         y.c.d var2 = var1.a();
         if(this.f.a(var2.c()) == this.f.a(var2.d())) {
            this.c.c(var2);
            this.e.d(var2);
         }

         var1.g();
         if(var3) {
            break;
         }
      }

   }

   public void c() {
      boolean var2 = a.i;
      if(this.a()) {
         y.c.p var1 = this.c.k();

         while(var1 != null) {
            this.e.e((y.c.d)var1.c());
            this.e.b(var1.c()).clearPoints();
            var1 = var1.a();
            if(var2) {
               break;
            }
         }

      }
   }

   public y.c.f d() {
      return this.c;
   }

   public int a(int var1) {
      boolean var16 = a.i;
      if(!this.a()) {
         return var1;
      } else {
         this.d = new y.c.y();
         int var2 = 0;
         int var3 = var1 - 1;
         y.c.p var4 = this.c.k();

         int var17;
         label70: {
            label69:
            while(true) {
               if(var4 != null) {
                  y.c.d var5 = (y.c.d)var4.c();
                  y.f.aE var6 = this.a(var5);
                  y.f.aE var7 = this.b(var5);
                  y.c.q var8 = var5.c();
                  y.c.q var9 = var5.d();
                  this.a(var6, var7);
                  y.c.q var11 = this.e.d();
                  if(var16) {
                     break;
                  }

                  if(this.n != null) {
                     this.n.a(var11, y.g.am.a("LowerSameLayerEdgeSupport", this.q.b(var5)));
                  }

                  this.j.a(var11, K.t);
                  this.e.b(var11, 1.0D, 1.0D);
                  int var12 = this.f.a(var8);
                  this.f.a(var11, var12 + 1);
                  this.e.a((y.c.q)var8, (y.c.q)var11);
                  this.e.a((y.c.q)var9, (y.c.q)var11);
                  this.d.add(var11);
                  y.c.q var15 = this.e.d();
                  this.j.a(var15, K.t);
                  if(this.n != null) {
                     this.n.a(var15, y.g.am.a("UpperSameLayerEdgeSupport", this.q.b(var5)));
                  }

                  this.e.b(var15, 1.0D, 1.0D);
                  this.f.a(var15, var12 - 1);
                  this.e.a((y.c.q)var15, (y.c.q)var8);
                  this.e.a((y.c.q)var15, (y.c.q)var9);
                  this.d.add(var15);
                  var2 = Math.min(var2, var12 - 1);
                  var3 = Math.max(var3, var12 + 1);
                  var4 = var4.a();
                  if(!var16) {
                     continue;
                  }
               }

               if(var2 < 0) {
                  var17 = -1;

                  while(var17 >= var2) {
                     this.m.a(y.g.am.a("UpperSameLayerEdgeLayer", new Integer(-var17)));
                     --var17;
                     if(var16) {
                        break label70;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  y.c.x var18 = this.e.o();

                  while(var18.f()) {
                     int var19 = this.f.a(var18.e()) - var2;
                     this.f.a(var18.e(), var19);
                     var18.g();
                     if(var16) {
                        break label69;
                     }

                     if(var16) {
                        break;
                     }
                  }

                  var3 -= var2;
               }

               var1 = var3 + 1;
               break;
            }

            var17 = 1;
         }

         while(this.m.size() < var1) {
            this.m.b(y.g.am.a("LowerSameLayerEdgeLayer", new Integer(var17++)));
            if(var16) {
               break;
            }
         }

         return var1;
      }
   }

   private boolean a(y.f.aE var1, y.f.aE var2) {
      return var1.d() || (var1.e() || var1.f() || var1.g()) && var2.d();
   }

   y.f.aE a(y.c.d var1) {
      if(this.s != null) {
         y.f.aE var4 = (y.f.aE)this.s.b(var1);
         return var4 == null?y.f.aE.a((byte)0, false):var4;
      } else {
         y.c.c var2 = this.e.c(y.f.aF.a);
         if(var2 == null) {
            return y.f.aE.a((byte)0, false);
         } else {
            y.f.aE var3 = (y.f.aE)var2.b(var1);
            return var3 == null?y.f.aE.a((byte)0, false):var3;
         }
      }
   }

   y.f.aE b(y.c.d var1) {
      if(this.t != null) {
         y.f.aE var4 = (y.f.aE)this.t.b(var1);
         return var4 == null?y.f.aE.a((byte)0, false):var4;
      } else {
         y.c.c var2 = this.e.c(y.f.aF.b);
         if(var2 == null) {
            return y.f.aE.a((byte)0, false);
         } else {
            y.f.aE var3 = (y.f.aE)var2.b(var1);
            return var3 == null?y.f.aE.a((byte)0, false):var3;
         }
      }
   }

   public void a(y.c.D var1) {
      boolean var7 = a.i;
      if(this.a()) {
         if(this.d != null && !this.d.isEmpty()) {
            y.c.p var2 = this.d.k();

            label66: {
               while(var2 != null) {
                  this.e.a((y.c.q)((y.c.q)var2.c()));
                  var2 = var2.a();
                  if(var7) {
                     break label66;
                  }

                  if(var7) {
                     break;
                  }
               }

               var2 = var1.k();
            }

            boolean var11;
            label86: {
               Object var10000;
               while(true) {
                  if(var2 != null) {
                     y.c.y var3 = (y.c.y)var2.c();
                     var10000 = var3.k();
                     if(var7) {
                        break;
                     }

                     Object var4 = var10000;

                     while(var4 != null) {
                        var11 = this.e.f((y.c.q)((y.c.p)var4).c());
                        if(var7) {
                           break label86;
                        }

                        if(!var11) {
                           var3.h((y.c.p)var4);
                        }

                        var4 = ((y.c.p)var4).a();
                        if(var7) {
                           break;
                        }
                     }

                     var2 = var2.a();
                     if(!var7) {
                        continue;
                     }
                  }

                  var10000 = var1.i();
                  break;
               }

               var11 = ((y.c.D)var10000).isEmpty();
            }

            if(var11) {
               var1.h(var1.l());
               this.m.h(this.m.l());
            }

            if(((y.c.D)var1.f()).isEmpty()) {
               var1.h(var1.k());
               this.m.h(this.m.k());
               int var9 = 0;
               y.c.p var8 = var1.k();

               while(var8 != null) {
                  y.c.y var10 = (y.c.y)var8.c();
                  Integer var5 = new Integer(var9);
                  y.c.p var6 = var10.k();

                  label51: {
                     while(var6 != null) {
                        this.f.a(var6.c(), var5);
                        var6 = var6.a();
                        if(var7) {
                           break label51;
                        }

                        if(var7) {
                           break;
                        }
                     }

                     var8 = var8.a();
                     ++var9;
                  }

                  if(var7) {
                     break;
                  }
               }
            }
         }

      }
   }

   void b(y.c.D var1) {
      boolean var20 = a.i;
      if(this.a()) {
         this.i = this.e.t();
         y.c.A var2 = y.g.M.a((Object[])(new y.c.q[this.e.e()]));
         y.c.A var3 = y.g.M.a(new int[this.e.e()]);
         y.c.p var4 = var1.k();

         y.c.y var5;
         y.c.p var7;
         y.c.p var10000;
         while(true) {
            if(var4 != null) {
               var5 = (y.c.y)var4.c();
               int var6 = 0;
               var10000 = var5.k();
               if(var20) {
                  break;
               }

               var7 = var10000;

               label976: {
                  while(var7 != null) {
                     var3.a(var7.c(), var6);
                     var7 = var7.a();
                     ++var6;
                     if(var20) {
                        break label976;
                     }

                     if(var20) {
                        break;
                     }
                  }

                  var4 = var4.a();
               }

               if(!var20) {
                  continue;
               }
            }

            var10000 = var1.k();
            break;
         }

         var4 = var10000;

         y.c.q var8;
         ar var10;
         int var14;
         y.c.q var28;
         byte var34;
         Object var35;
         label961: {
            label960:
            while(true) {
               ar var9;
               y.c.d var21;
               y.f.aE var23;
               y.f.aE var25;
               boolean var26;
               if(var4 != null) {
                  label987: {
                     var5 = (y.c.y)var4.c();
                     boolean var22 = false;
                     y.c.x var24 = var5.a();
                     var34 = var24.f();
                     if(var20) {
                        break label961;
                     }

                     if(var34 == 0) {
                        var4 = var4.a();
                        if(!var20) {
                           continue;
                        }

                        var4 = this.c.k();
                     } else {
                        var8 = var24.e();

                        while(var24.f()) {
                           var8 = var24.e();
                           var35 = this.g.b(var8);
                           if(var20) {
                              var21 = (y.c.d)var35;
                              var23 = this.a(var21);
                              var25 = this.b(var21);
                              var26 = this.a(var23, var25);
                              var9 = (ar)this.i.b(var21.c());
                              if(var20) {
                                 break label960;
                              }
                              break label987;
                           }

                           if(var35 == null) {
                              break;
                           }

                           var24.g();
                           if(var20) {
                              break;
                           }
                        }

                        if(!var24.f()) {
                           var4 = var4.a();
                           if(!var20) {
                              continue;
                           }

                           var4 = this.c.k();
                        } else {
                           var24.g();

                           while(var24.f()) {
                              var28 = var24.e();
                              var35 = this.g.b(var28);
                              if(var20) {
                                 var21 = (y.c.d)var35;
                                 var23 = this.a(var21);
                                 var25 = this.b(var21);
                                 var26 = this.a(var23, var25);
                                 var9 = (ar)this.i.b(var21.c());
                                 if(var20) {
                                    break label960;
                                 }
                                 break label987;
                              }

                              if(var35 == null) {
                                 var2.a(var28, var8);
                                 var8 = var28;
                              }

                              var24.g();
                              if(var20) {
                                 var4 = var4.a();
                                 if(!var20) {
                                    continue label960;
                                 }

                                 var4 = this.c.k();
                                 if(var4 == null) {
                                    this.l = new as(this, var3);
                                    this.h = this.e.t();
                                    break label960;
                                 }

                                 var21 = (y.c.d)var4.c();
                                 var23 = this.a(var21);
                                 var25 = this.b(var21);
                                 var26 = this.a(var23, var25);
                                 var9 = (ar)this.i.b(var21.c());
                                 if(var20) {
                                    break label960;
                                 }
                                 break label987;
                              }
                           }

                           var4 = var4.a();
                           if(!var20) {
                              continue;
                           }

                           var4 = this.c.k();
                        }
                     }

                     if(var4 == null) {
                        this.l = new as(this, var3);
                        this.h = this.e.t();
                        break;
                     }

                     var21 = (y.c.d)var4.c();
                     var23 = this.a(var21);
                     var25 = this.b(var21);
                     var26 = this.a(var23, var25);
                     var9 = (ar)this.i.b(var21.c());
                     if(var20) {
                        break;
                     }
                  }
               } else {
                  var4 = this.c.k();
                  if(var4 == null) {
                     this.l = new as(this, var3);
                     this.h = this.e.t();
                     break;
                  }

                  var21 = (y.c.d)var4.c();
                  var23 = this.a(var21);
                  var25 = this.b(var21);
                  var26 = this.a(var23, var25);
                  var9 = (ar)this.i.b(var21.c());
                  if(var20) {
                     break;
                  }
               }

               while(true) {
                  boolean var11;
                  boolean var12;
                  boolean var13;
                  if(var9 == null) {
                     var9 = new ar(this.e.a((Object)var21.c()));
                     this.i.a(var21.c(), var9);
                     var10 = (ar)this.i.b(var21.d());
                     if(var10 == null) {
                        var10 = new ar(this.e.a((Object)var21.d()));
                        this.i.a(var21.d(), var10);
                     }

                     var11 = var2.b(var21.c()) != var21.d()?var2.b(var21.d()) == var21.c():true;
                     var12 = var3.a(var21.c()) < var3.a(var21.d());
                     if(var12) {
                        var13 = var11?(var23.b() != 0?(var23.b() == 4?(var25.b() != 0?var25.b() == 8:true):false):(var25.b() != 0?var25.b() == 8:true)):false;
                        if(var20) {
                           if(var11) {
                              if(var23.b() != 0) {
                                 if(var23.b() == 8) {
                                    var13 = var25.b() != 0?var25.b() == 4:true;
                                 } else {
                                    var13 = false;
                                 }
                              } else {
                                 var13 = var25.b() != 0?var25.b() == 4:true;
                              }
                           } else {
                              var13 = false;
                           }
                        }
                     } else if(var11) {
                        if(var23.b() != 0) {
                           if(var23.b() == 8) {
                              var13 = var25.b() != 0?var25.b() == 4:true;
                           } else {
                              var13 = false;
                           }
                        } else {
                           var13 = var25.b() != 0?var25.b() == 4:true;
                        }
                     } else {
                        var13 = false;
                     }
                  } else {
                     var10 = (ar)this.i.b(var21.d());
                     if(var10 == null) {
                        var10 = new ar(this.e.a((Object)var21.d()));
                        this.i.a(var21.d(), var10);
                     }

                     var11 = var2.b(var21.c()) != var21.d()?var2.b(var21.d()) == var21.c():true;
                     var12 = var3.a(var21.c()) < var3.a(var21.d());
                     if(var12) {
                        var13 = var11?(var23.b() != 0?(var23.b() == 4?(var25.b() != 0?var25.b() == 8:true):false):(var25.b() != 0?var25.b() == 8:true)):false;
                        if(var20) {
                           if(var11) {
                              if(var23.b() != 0) {
                                 if(var23.b() == 8) {
                                    var13 = var25.b() != 0?var25.b() == 4:true;
                                 } else {
                                    var13 = false;
                                 }
                              } else {
                                 var13 = var25.b() != 0?var25.b() == 4:true;
                              }
                           } else {
                              var13 = false;
                           }
                        }
                     } else if(var11) {
                        if(var23.b() != 0) {
                           if(var23.b() == 8) {
                              var13 = var25.b() != 0?var25.b() == 4:true;
                           } else {
                              var13 = false;
                           }
                        } else {
                           var13 = var25.b() != 0?var25.b() == 4:true;
                        }
                     } else {
                        var13 = false;
                     }
                  }

                  int var15;
                  label1191: {
                     if(!this.u || var11 || this.s == null || this.t == null || var23.b() != 0 && var25.b() != 0) {
                        if(var23.b() != 4 && var23.b() != 8) {
                           var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                           var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                           break label1191;
                        }

                        if(var25.b() != 4 && var25.b() != 8) {
                           var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                           var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                           break label1191;
                        }
                     }

                     int var16 = 0;
                     int var17 = 0;
                     y.c.q var18;
                     y.c.q var19;
                     if(var12) {
                        if(var25.b() == 4) {
                           var18 = var21.d();
                           if(var20) {
                              var18 = (y.c.q)var2.b(var21.d());
                           }
                        } else {
                           var18 = (y.c.q)var2.b(var21.d());
                        }

                        if(var23.b() == 8) {
                           var19 = (y.c.q)var2.b(var21.c());
                           if(var20) {
                              var19 = var21.c();
                              if(var20) {
                                 if(var23.b() == 4) {
                                    var18 = var21.c();
                                    if(var20) {
                                       var18 = (y.c.q)var2.b(var21.c());
                                    }
                                 } else {
                                    var18 = (y.c.q)var2.b(var21.c());
                                 }

                                 if(var25.b() == 8) {
                                    var19 = (y.c.q)var2.b(var21.d());
                                    if(var20) {
                                       var19 = var21.d();
                                    }
                                 } else {
                                    var19 = var21.d();
                                 }
                              }
                           }
                        } else {
                           var19 = var21.c();
                           if(var20) {
                              if(var23.b() == 4) {
                                 var18 = var21.c();
                                 if(var20) {
                                    var18 = (y.c.q)var2.b(var21.c());
                                 }
                              } else {
                                 var18 = (y.c.q)var2.b(var21.c());
                              }

                              if(var25.b() == 8) {
                                 var19 = (y.c.q)var2.b(var21.d());
                                 if(var20) {
                                    var19 = var21.d();
                                 }
                              } else {
                                 var19 = var21.d();
                              }
                           }
                        }
                     } else {
                        if(var23.b() == 4) {
                           var18 = var21.c();
                           if(var20) {
                              var18 = (y.c.q)var2.b(var21.c());
                           }
                        } else {
                           var18 = (y.c.q)var2.b(var21.c());
                        }

                        if(var25.b() == 8) {
                           var19 = (y.c.q)var2.b(var21.d());
                           if(var20) {
                              var19 = var21.d();
                           }
                        } else {
                           var19 = var21.d();
                        }
                     }

                     boolean var36;
                     while(true) {
                        if(var18 != var19) {
                           var16 += var18.b();
                           var17 += var18.c();
                           var18 = (y.c.q)var2.b(var18);
                           if(!var20) {
                              if(!var20) {
                                 continue;
                              }

                              var36 = var17 < var16;
                              break;
                           }

                           var36 = false;
                           break;
                        }

                        var36 = var17 < var16;
                        break;
                     }

                     var26 = var36;
                     if(var23.b() == 0) {
                        y.c.d var10001;
                        int var10002;
                        y.c.h var37;
                        if(var17 == var16) {
                           var26 = var25.b() == 2;
                           var14 = var26?2:0;
                           var37 = this.s;
                           var10001 = var21;
                           var10002 = var26?2:1;
                        } else {
                           var14 = var26?2:0;
                           var37 = this.s;
                           var10001 = var21;
                           var10002 = var26?2:1;
                        }

                        var37.a(var10001, y.f.aE.a((byte)var10002));
                        if(var20) {
                           var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                        }
                     } else {
                        var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                     }

                     if(var25.b() == 0) {
                        if(var23.b() == 1) {
                           var26 = false;
                           if(var20 && var23.b() == 2) {
                              var26 = true;
                           }
                        } else if(var23.b() == 2) {
                           var26 = true;
                        }

                        var15 = var26?2:0;
                        this.t.a(var21, y.f.aE.a((byte)(var26?2:1)));
                        if(var20) {
                           var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                           if(var20) {
                              var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                              var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                           }
                        }
                     } else {
                        var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                        if(var20) {
                           var14 = x.a(var23.b(), var13?(var12?1:3):(var26?2:0));
                           var15 = x.a(var25.b(), var13?(var12?3:1):(var26?2:0));
                        }
                     }
                  }

                  boolean var32 = (var14 ^ var15) == 2?(var14 | var15) == 2:false;
                  if(var32) {
                     if(var12) {
                        ++var10.c[1];
                        ++var10.d[var15 == 0?0:3];
                        if(var20) {
                           ++var10.c[0];
                           ++var10.d[var15 == 0?1:2];
                        }
                     } else {
                        ++var10.c[0];
                        ++var10.d[var15 == 0?1:2];
                     }
                  }

                  this.a(var9, var21, var14, var13?(var14 & 1) == 1:false, var26, !var12);
                  this.a(var10, var21, var15, var13?(var15 & 1) == 1:false, var26, var12);
                  var4 = var4.a();
                  if(var20) {
                     this.l = new as(this, var3);
                     this.h = this.e.t();
                     break label960;
                  }

                  if(var4 == null) {
                     this.l = new as(this, var3);
                     this.h = this.e.t();
                     break label960;
                  }

                  var21 = (y.c.d)var4.c();
                  var23 = this.a(var21);
                  var25 = this.b(var21);
                  var26 = this.a(var23, var25);
                  var9 = (ar)this.i.b(var21.c());
                  if(var20) {
                     break label960;
                  }
               }
            }

            var34 = 0;
         }

         int var27 = var34;
         y.c.p var29 = var1.k();

         while(var29 != null) {
            var35 = var29.c();

            label241:
            while(true) {
               y.c.y var30 = (y.c.y)var35;
               var7 = var30.k().a();

               while(true) {
                  if(var7 == null) {
                     break label241;
                  }

                  var8 = (y.c.q)var7.c();
                  var28 = (y.c.q)var7.b().c();
                  var10 = this.b(var8);
                  this.b(var28);
                  var35 = var10;
                  if(var20) {
                     break;
                  }

                  if(var10 != null) {
                     y.c.f var31 = var10.c(3).l;
                     if(var31.size() > 0) {
                        y.c.q var33 = this.e.d();
                        var10.e[1] = var33;
                        var14 = var31.size();
                        this.f.a(var33, var27);
                        var30.a(var33, var7);
                        this.e.b(var33, 2.0D * this.a + this.a * (double)(var14 - 1) + this.a(var31), 0.5D);
                        this.h.a(var33, true);
                     }
                  }

                  var7 = var7.a();
                  if(var20) {
                     break label241;
                  }
               }
            }

            var29 = var29.a();
            ++var27;
            if(var20) {
               break;
            }
         }

      }
   }

   void a(y.c.q var1, ar var2) {
      this.l.a(var1, 0);
      var2.a(0).l.sort(this.l);
      this.l.a(var1, 2);
      var2.b(0).l.sort(this.l);
      this.l.a(var1, 3);
      var2.a(1).l.sort(this.l);
      this.l.a(var1, 5);
      var2.b(1).l.sort(this.l);
      this.l.a(var1, 6);
      var2.a(2).l.sort(this.l);
      this.l.a(var1, 8);
      var2.b(2).l.sort(this.l);
      this.l.a(var1, 9);
      var2.a(3).l.sort(this.l);
      this.l.a(var1, 11);
      var2.b(3).l.sort(this.l);
      var2.c(3).l.n();
   }

   private void a(ar var1, y.c.d var2, int var3, boolean var4, boolean var5, boolean var6) {
      boolean var7 = a.i;
      if(var4) {
         var1.c(var3).l.add(var2);
         if(!var7) {
            return;
         }
      }

      switch(var3) {
      case 0:
         if(var6) {
            var1.a(0).l.add(var2);
            if(!var7) {
               break;
            }
         }

         var1.b(0).l.add(var2);
         if(!var7) {
            break;
         }
      case 1:
         if(var5) {
            var1.b(1).l.add(var2);
            if(!var7) {
               break;
            }
         }

         var1.a(1).l.add(var2);
         if(!var7) {
            break;
         }
      case 2:
         if(var6) {
            var1.b(2).l.add(var2);
            if(!var7) {
               break;
            }
         }

         var1.a(2).l.add(var2);
         if(!var7) {
            break;
         }
      case 3:
         if(var5) {
            var1.a(3).l.add(var2);
            if(!var7) {
               return;
            }
         }

         var1.b(3).l.add(var2);
      }

   }

   private double a(y.c.f var1) {
      boolean var5 = a.i;
      double var2 = 0.0D;
      y.c.e var4 = var1.a();

      double var10000;
      while(true) {
         if(var4.f()) {
            var10000 = Math.max(var2, this.c(var4.a()));
            if(var5) {
               break;
            }

            var2 = var10000;
            var4.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private double c(y.c.d var1) {
      boolean var6 = a.i;
      y.f.S[] var2 = this.d(var1);
      if(var2 != null && var2.length != 0) {
         double var3 = 0.0D;
         int var5 = 0;

         while(true) {
            if(var5 < var2.length) {
               var3 += var2[var5].a().e();
               ++var5;
               if(var6) {
                  break;
               }

               if(!var6) {
                  continue;
               }
            }

            var3 += (double)(10 * (var2.length - 1));
            break;
         }

         return var3;
      } else {
         return 0.0D;
      }
   }

   private y.f.S[] d(y.c.d var1) {
      y.c.c var2 = this.e.c(y.f.U.a);
      return var2 == null?null:(y.f.S[])var2.b(var1);
   }

   boolean a(y.c.q var1) {
      return this.i != null && this.i.b(var1) != null;
   }

   ar b(y.c.q var1) {
      return this.i != null?(ar)this.i.b(var1):null;
   }

   private aq e(y.c.d var1) {
      aq var2 = (aq)this.k.get(var1);
      if(var2 == null) {
         var2 = new aq();
         this.k.put(var1, var2);
      }

      return var2;
   }

   public void c(y.c.D var1) {
      boolean var12 = a.i;
      if(this.a()) {
         this.k = new HashMap();
         y.f.i.b var2 = new y.f.i.b(0.0D, 0.0D);
         y.f.i.b var3 = new y.f.i.b(0.0D, 0.0D);
         y.c.p var4 = var1.k();

         while(var4 != null) {
            Object var10000 = var4.c();

            C var5;
            label85:
            while(true) {
               y.c.y var6;
               HashMap var7;
               y.c.p var8;
               y.c.q var9;
               ar var10;
               label74:
               while(true) {
                  var5 = (C)var10000;
                  var6 = var5.a;
                  var2.a(var5.b - 100000.0D, var5.b - 90000.0D, (byte)1);
                  var3.a(var5.c + 90000.0D, var5.c + 100000.0D, (byte)1);
                  var7 = new HashMap();
                  var8 = var6.k();

                  while(true) {
                     if(var8 == null) {
                        break label74;
                     }

                     var9 = (y.c.q)var8.c();
                     var10 = this.b(var9);
                     var10000 = var10;
                     if(var12) {
                        break;
                     }

                     if(var10 != null) {
                        var10.a(this.e.a((Object)var9));
                        this.b(var9, var10.a(1), var7);
                        this.b(var9, var10.b(1), var7);
                        this.b(var9, var10.a(3), var7);
                        this.b(var9, var10.b(3), var7);
                        this.a(var9, var10.a(0), var7);
                        this.a(var9, var10.c(0), var7);
                        this.a(var9, var10.b(0), var7);
                        this.a(var9, var10.a(2), var7);
                        this.a(var9, var10.c(2), var7);
                        this.a(var9, var10.b(2), var7);
                     }

                     var8 = var8.a();
                     if(var12) {
                        break label74;
                     }
                  }
               }

               var8 = var6.k();

               while(true) {
                  if(var8 == null) {
                     break label85;
                  }

                  var9 = (y.c.q)var8.c();
                  var10 = this.b(var9);
                  var10000 = var10;
                  if(var12) {
                     break;
                  }

                  if(var10 != null) {
                     y.f.am var11 = this.e.a((Object)var9);
                     this.a((y.c.q)var9, (z)var10.a(1), (Map)var7, (y.f.i.b)var2);
                     this.a((y.c.q)var9, (z)var10.b(1), (Map)var7, (y.f.i.b)var3);
                     this.a((y.c.q)var9, (z)var10.a(3), (Map)var7, (y.f.i.b)var3);
                     this.a((y.c.q)var9, (z)var10.b(3), (Map)var7, (y.f.i.b)var2);
                     this.a(var9, var10, var10.a(0), var7, var2, var3, (byte)2, 3, var11);
                     this.a(var9, var10, var10.c(0), var7, var2, var3, (byte)2, 1, var11);
                     this.a(var9, var10, var10.b(0), var7, var2, var3, (byte)2, 1, var11);
                     this.a(var9, var10, var10.a(2), var7, var3, var2, (byte)1, 1, var11);
                     this.a(var9, var10, var10.c(2), var7, var3, var2, (byte)1, 1, var11);
                     this.a(var9, var10, var10.b(2), var7, var3, var2, (byte)1, 3, var11);
                  }

                  var8 = var8.a();
                  if(var12) {
                     break label85;
                  }
               }
            }

            var2.b();
            var3.b();
            if(var2.c() > 0) {
               var5.d = this.a * (double)var2.c();
            }

            if(var3.c() > 0) {
               var5.e = this.a * (double)var3.c();
            }

            Iterator var13 = var2.a();

            y.c.d var14;
            aq var15;
            while(true) {
               if(var13.hasNext()) {
                  var14 = (y.c.d)var13.next();
                  var15 = (aq)this.k.get(var14);
                  var15.a[0] = var2.c(var14);
                  if(var12) {
                     break;
                  }

                  if(!var12) {
                     continue;
                  }
               }

               var13 = var3.a();
               break;
            }

            while(true) {
               if(var13.hasNext()) {
                  var14 = (y.c.d)var13.next();
                  var15 = (aq)this.k.get(var14);
                  var15.a[1] = var3.c(var14);
                  if(var12) {
                     break;
                  }

                  if(!var12) {
                     continue;
                  }
               }

               var4 = var4.a();
               break;
            }

            if(var12) {
               break;
            }
         }

      }
   }

   private void a(y.c.q var1, z var2, Map var3) {
      boolean var7 = a.i;
      y.c.p var4 = var2.l.k();

      while(var4 != null) {
         y.c.d var5 = (y.c.d)var4.c();
         this.e(var5);
         if(var1 != var5.d()) {
            var3.put(var5, this.e.p(var5));
         }

         var4 = var4.a();
         if(var7) {
            break;
         }
      }

   }

   private void b(y.c.q var1, z var2, Map var3) {
      boolean var10 = a.i;
      y.c.p var4 = var2.l.k();

      while(var4 != null) {
         label17: {
            y.c.d var5 = (y.c.d)var4.c();
            aq var6 = this.e(var5);
            if(var1 == var5.d()) {
               var6.c = var2.b();
               if(!var10) {
                  break label17;
               }
            }

            double var7 = var2.f(0.0D, var6.b = var2.b());
            y.d.t var9 = this.e.p(var5);
            var3.put(var5, new y.d.t(var7, var9.b));
         }

         var4 = var4.a();
         if(var10) {
            break;
         }
      }

   }

   private void a(y.c.q var1, z var2, Map var3, y.f.i.b var4) {
      boolean var13 = a.i;
      y.c.p var5 = var2.l.k();

      while(var5 != null) {
         y.c.d var6 = (y.c.d)var5.c();
         if(var1 != var6.c()) {
            aq var7 = (aq)this.k.get(var6);
            this.e.q(var6);
            y.d.t var9 = (y.d.t)var3.get(var6);
            this.a(var6);
            y.f.am var11 = this.e.a((Object)var6.d());
            y.d.t var12 = new y.d.t(var2.f(0.0D, var7.c), var11.getY());
            var4.a(var6, var9, var12);
         }

         var5 = var5.a();
         if(var13) {
            break;
         }
      }

   }

   private void a(y.c.q var1, ar var2, z var3, Map var4, y.f.i.b var5, y.f.i.b var6, byte var7, int var8, y.f.am var9) {
      boolean var17 = a.i;
      y.c.p var10 = var3.l.k();

      while(var10 != null) {
         y.c.d var11 = (y.c.d)var10.c();
         if(var1 != var11.c()) {
            label19: {
               aq var12 = (aq)this.k.get(var11);
               y.d.t var13 = this.e.q(var11);
               y.d.t var14 = (y.d.t)var4.get(var11);
               y.f.aE var15 = this.a(var11);
               if(var15.b() == var7) {
                  y.d.t var16 = new y.d.t(var2.c(var8).f(0.0D, var2.g(var8)), var9.getY());
                  var12.d = var16.a - var9.getX();
                  var12.c = var3.b();
                  var6.a(var11, var14, var16);
                  if(!var17) {
                     break label19;
                  }
               }

               var5.a(var11, var14, var13);
            }
         }

         var10 = var10.a();
         if(var17) {
            break;
         }
      }

   }

   private y.c.D f(y.c.d var1) {
      y.c.D var2 = (y.c.D)this.b.get(var1);
      if(var2 == null) {
         var2 = new y.c.D();
         this.b.put(var1, var2);
      }

      return var2;
   }

   void d(y.c.D var1) {
      boolean var24 = a.i;
      if(this.a()) {
         y.f.i.b var2 = new y.f.i.b(0.0D, 0.0D);
         boolean var3 = false;
         y.c.p var4 = var1.k();

         label147:
         while(true) {
            if(var4 != null) {
               Object var10000 = var4.c();

               label142:
               while(true) {
                  y.c.y var6;
                  y.c.p var11;
                  y.c.q var12;
                  ar var13;
                  label68:
                  while(true) {
                     C var5 = (C)var10000;
                     var6 = var5.a;
                     double var7 = var5.b - var5.d;
                     double var9 = var5.c + this.a;
                     this.b.clear();
                     if(var24) {
                        return;
                     }

                     var11 = var6.k();

                     while(true) {
                        if(var11 == null) {
                           break label68;
                        }

                        var12 = (y.c.q)var11.c();
                        var13 = this.b(var12);
                        var10000 = var13;
                        if(var24) {
                           break;
                        }

                        if(var13 != null) {
                           var13.a(this.e.a((Object)var12));
                           this.a(var12, var13.a(1), var7, 0);
                           this.a(var12, var13.b(1), var9, 1);
                           this.a(var12, var13.a(3), var9, 1);
                           this.a(var12, var13.b(3), var7, 0);
                           this.a(var12, var13.a(0), (byte)2, var7, 0);
                           this.a(var12, var13.c(0), (byte)2, var7, 0);
                           this.a(var12, var13.b(0), (byte)2, var7, 0);
                           this.a(var12, var13.a(2), (byte)1, var9, 1);
                           this.a(var12, var13.c(2), (byte)1, var9, 1);
                           this.a(var12, var13.b(2), (byte)1, var9, 1);
                        }

                        var11 = var11.a();
                        if(var24) {
                           break label68;
                        }
                     }
                  }

                  Iterator var25 = this.b.entrySet().iterator();

                  label82:
                  while(var25.hasNext()) {
                     Entry var26 = (Entry)var25.next();
                     y.f.I var27 = this.e.b(var26.getKey());
                     var27.clearPoints();
                     y.c.p var14 = ((y.c.D)var26.getValue()).k();

                     while(var14 != null) {
                        y.d.t var15 = (y.d.t)var14.c();
                        var27.addPoint(var15.a, var15.b);
                        var14 = var14.a();
                        if(var24) {
                           break label82;
                        }

                        if(var24) {
                           continue label147;
                        }

                        if(var24) {
                           break label82;
                        }
                     }
                  }

                  var11 = var6.k();

                  while(true) {
                     if(var11 == null) {
                        break label142;
                     }

                     var12 = (y.c.q)var11.c();
                     var13 = this.b(var12);
                     var10000 = var13;
                     if(var24) {
                        break;
                     }

                     if(var13 != null && var13.e[1] != null) {
                        double var28 = this.e.m(var13.e[1]) + this.a;
                        double var16 = this.e.p(var13.e[1]) - 2.0D * this.a;
                        var2.a(var28, var28 + var16, (byte)0);
                        y.c.p var18 = var13.c(3).l.k();

                        label136:
                        while(true) {
                           y.c.d var19;
                           y.d.t var20;
                           y.d.t var21;
                           int var29;
                           if(var18 != null) {
                              var19 = (y.c.d)var18.c();
                              var20 = this.e.p(var19);
                              var21 = this.e.q(var19);
                              double var30;
                              var29 = (var30 = var20.b() - var21.b()) == 0.0D?0:(var30 < 0.0D?-1:1);
                              if(!var24) {
                                 if(var29 != 0) {
                                    var2.a(var19, var20, var21);
                                 }

                                 var18 = var18.a();
                                 if(!var24) {
                                    continue;
                                 }

                                 var2.b();
                                 var18 = var13.c(3).l.k();
                                 if(var18 == null) {
                                    break;
                                 }

                                 var19 = (y.c.d)var18.c();
                                 var20 = this.e.p(var19);
                                 var21 = this.e.q(var19);
                                 double var31;
                                 var29 = (var31 = var20.b() - var21.b()) == 0.0D?0:(var31 < 0.0D?-1:1);
                              }
                           } else {
                              var2.b();
                              var18 = var13.c(3).l.k();
                              if(var18 == null) {
                                 break;
                              }

                              var19 = (y.c.d)var18.c();
                              var20 = this.e.p(var19);
                              var21 = this.e.q(var19);
                              double var32;
                              var29 = (var32 = var20.b() - var21.b()) == 0.0D?0:(var32 < 0.0D?-1:1);
                           }

                           while(true) {
                              if(!var24) {
                                 if(var29 != 0) {
                                    double var22 = var2.b(var19);
                                    this.e.b(var19).addPoint(var22, var20.b());
                                    this.e.b(var19).addPoint(var22, var21.b());
                                 }

                                 var18 = var18.a();
                                 if(var24) {
                                    break label136;
                                 }
                              } else {
                                 if(var29 != 0) {
                                    var2.a(var19, var20, var21);
                                 }

                                 var18 = var18.a();
                                 if(!var24) {
                                    break;
                                 }

                                 var2.b();
                                 var18 = var13.c(3).l.k();
                              }

                              if(var18 == null) {
                                 break label136;
                              }

                              var19 = (y.c.d)var18.c();
                              var20 = this.e.p(var19);
                              var21 = this.e.q(var19);
                              double var33;
                              var29 = (var33 = var20.b() - var21.b()) == 0.0D?0:(var33 < 0.0D?-1:1);
                           }
                        }

                        this.e.a((y.c.q)var13.e[1]);
                        var6.h(var11.b());
                     }

                     var11 = var11.a();
                     if(var24) {
                        break label142;
                     }
                  }
               }

               var4 = var4.a();
               if(!var24) {
                  continue;
               }
            }

            this.b.clear();
            return;
         }
      }
   }

   private void a(y.c.q var1, z var2, byte var3, double var4, int var6) {
      boolean var16 = a.i;
      y.c.p var7 = var2.l.k();

      while(var7 != null) {
         label33: {
            y.c.d var8 = (y.c.d)var7.c();
            aq var9 = (aq)this.k.get(var8);
            y.c.D var10 = this.f(var8);
            double var11 = var4 + (double)var9.a[var6] * this.a;
            y.d.t var13;
            double var14;
            if(var8.c() == var1) {
               var13 = this.e.p(var8);
               if(!Double.isNaN(var9.d)) {
                  var14 = this.e.a((Object)var8.d()).getX() + var9.d;
                  var10.a((Object)(new y.d.t(var14, var11)));
               }

               var10.a((Object)(new y.d.t(var13.a, var11)));
               if(!var16) {
                  break label33;
               }
            }

            var13 = this.e.q(var8);
            if(!Double.isNaN(var9.d)) {
               var14 = this.e.a((Object)var8.d()).getX() + var9.d;
               var11 = var2.e(0.0D, var9.c);
               var10.add(new y.d.t(var14, var11));
            }

            var10.add(new y.d.t(var13.a, var11));
         }

         var7 = var7.a();
         if(var16) {
            break;
         }
      }

   }

   private void a(y.c.q var1, z var2, double var3, int var5) {
      boolean var15 = a.i;
      y.c.p var6 = var2.l.k();

      while(var6 != null) {
         label17: {
            y.c.d var7 = (y.c.d)var6.c();
            aq var8 = (aq)this.k.get(var7);
            y.c.D var9 = this.f(var7);
            double var10 = var3 + (double)var8.a[var5] * this.a;
            double var12;
            y.d.t var14;
            if(var7.c() == var1) {
               var12 = var2.f(0.0D, var8.b);
               var14 = this.e.p(var7);
               var9.a((Object)(new y.d.t(var12, var10)));
               var9.a((Object)(new y.d.t(var12, var14.b)));
               if(!var15) {
                  break label17;
               }
            }

            var12 = var2.f(0.0D, var8.c);
            var14 = this.e.q(var7);
            var9.b((Object)(new y.d.t(var12, var10)));
            var9.b((Object)(new y.d.t(var12, var14.b)));
         }

         var6 = var6.a();
         if(var15) {
            break;
         }
      }

   }

   void e() {
      this.l = null;
      this.k = null;
      this.q = null;
      this.p = null;
      this.n = null;
      this.o = null;
      this.s = null;
      this.t = null;
      if(this.i != null) {
         this.e.a((y.c.A)this.i);
         this.i = null;
      }

      if(this.h != null) {
         this.e.a((y.c.A)this.h);
         this.h = null;
      }

   }

   public void b(double var1) {
      this.r = var1;
   }

   static y.f.X a(ap var0) {
      return var0.e;
   }
}
