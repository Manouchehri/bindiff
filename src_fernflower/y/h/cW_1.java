package y.h;

import java.util.HashSet;
import java.util.Iterator;
import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.cd;
import y.h.cg;
import y.h.ch;
import y.h.eR;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.ft;
import y.h.gY;
import y.h.x;
import y.h.y;

public class cW {
   int[] a;
   private y.c.D b;
   private y.c.D c;
   private y.c.D d;
   private y.c.D e;
   private y.c.D f;
   private y.c.D g;
   private y.c.D h;
   private y.c.D i;

   public cW(bu var1, double var2, double var4, boolean var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      this.a(var7, var8, var9, var10, var11, var12, var13);
      this.a(var1, var2, var4, var6, true, true, true, true);
   }

   public cW(ch var1, double var2, double var4, boolean var6, int var7) {
      this((ch)var1, var2, var4, var6, var7, -1, -1, -1, -1, -1, -1);
   }

   public cW(ch var1, double var2, double var4, boolean var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      boolean var20 = fj.z;
      super();
      this.a(var7, var8, var9, var10, var11, var12, var13);
      if(this.a.length != 0) {
         int var14 = !Boolean.TRUE.equals(var1.getClientProperty("Graph2DView.hitTestInvisibleElements"))?1:0;
         bu var15 = var1.getGraph2D();
         cd var16 = var1.getGraph2DRenderer();
         if(var16 instanceof ft) {
            cg var17;
            label65: {
               if(var1.getZoom() >= var1.getPaintDetailThreshold()) {
                  var17 = ((ft)var16).getPaintOrder();
                  if(!var20) {
                     break label65;
                  }
               }

               var17 = ((ft)var16).getSloppyPaintOrder();
            }

            int var18 = 0;
            int var19 = 0;

            int var10000;
            label59: {
               while(var19 < this.a.length) {
                  var10000 = this.a[var19];
                  if(var20) {
                     break label59;
                  }

                  switch(var10000) {
                  case 0:
                     var18 |= 4;
                     if(!var20) {
                        break;
                     }
                  case 1:
                     var18 |= 8;
                     if(!var20) {
                        break;
                     }
                  case 2:
                     var18 |= 32;
                     if(!var20) {
                        break;
                     }
                  case 3:
                     var18 |= 2;
                     if(!var20) {
                        break;
                     }
                  case 4:
                     var18 |= 1;
                     if(!var20) {
                        break;
                     }
                  case 5:
                     var18 |= 16;
                  }

                  ++var19;
                  if(var20) {
                     break;
                  }
               }

               var10000 = var14;
            }

            var19 = var10000 != 0?1:-1;
            this.a(var15, new y.g.A(var17.b(var15, var18), new gY(var15, var19, var19, var19, var19)), var2, var4, var6, this.a.length == 1);
            if(!var20) {
               return;
            }
         }

         this.a(var15, var2, var4, var6, (boolean)var14, (boolean)var14, (boolean)var14, (boolean)var14);
      }
   }

   public cW(ch var1, double var2, double var4, boolean var6) {
      this.a(-1, -1, -1, -1, -1, -1, -1);
      bu var7 = var1.getGraph2D();
      cd var8 = var1.getGraph2DRenderer();
      if(var8 instanceof ft) {
         cg var9;
         label18: {
            if(var1.getZoom() >= var1.getPaintDetailThreshold()) {
               var9 = ((ft)var8).getPaintOrder();
               if(!fj.z) {
                  break label18;
               }
            }

            var9 = ((ft)var8).getSloppyPaintOrder();
         }

         int var10 = !Boolean.TRUE.equals(var1.getClientProperty("Graph2DView.hitTestInvisibleElements"))?1:-1;
         this.a(var7, new y.g.A(var9.b(var7, -1), new gY(var7, var10, var10, var10, var10)), var2, var4, var6, true);
      }

   }

   public cW(bu var1, Iterator var2, double var3, double var5, boolean var7) {
      this.a(-1, -1, -1, -1, -1, -1, -1);
      this.a(var1, var2, var3, var5, var7, true);
   }

   protected cW() {
      this.a(-1, -1, -1, -1, -1, -1, -1);
   }

   protected void a(x var1) {
      this.d.add(var1);
      this.i.add(var1);
   }

   protected void a(y.c.d var1) {
      this.b.add(var1);
      this.i.add(var1);
   }

   protected void a(aA var1) {
      this.e.add(var1);
      this.i.add(var1);
   }

   protected void a(y.c.q var1) {
      this.c.add(var1);
      this.i.add(var1);
   }

   protected void a(eR var1) {
      this.f.add(var1);
      this.i.add(var1);
   }

   protected void a(fL var1) {
      this.g.add(var1);
      this.i.add(var1);
   }

   protected void a(eU var1) {
      this.h.add(var1);
      this.i.add(var1);
   }

   protected boolean a(fj var1, double var2, double var4) {
      return var1.contains(var2, var4);
   }

   protected boolean a(eR var1, double var2, double var4) {
      return var1.contains(var2, var4);
   }

   protected boolean a(aB var1, double var2, double var4) {
      return var1.contains(var2, var4);
   }

   protected boolean a(aA var1, double var2, double var4) {
      return var1.contains(var2, var4);
   }

   protected boolean a(x var1, double var2, double var4) {
      return var1.c(var2, var4);
   }

   protected boolean a(fL var1, double var2, double var4) {
      return var1.a(var2, var4);
   }

   protected boolean a(eU var1, double var2, double var4) {
      return var1.a(var2, var4);
   }

   private void a(bu var1, double var2, double var4, boolean var6, boolean var7, boolean var8, boolean var9, boolean var10) {
      boolean var22 = fj.z;
      int var11 = 0;

      do {
         int var10000 = var11;

         label278:
         while(true) {
            if(var10000 >= this.a.length) {
               return;
            }

            fj var34;
            label324: {
               label289: {
                  label290: {
                     byte var26;
                     switch(this.a[var11]) {
                     case 0:
                        y.c.e var12 = var1.p();
                        var12.j();

                        do {
                           if(!var12.f()) {
                              break label278;
                           }

                           aB var13 = var1.i(var12.a());
                           var10000 = var9;
                           if(var22) {
                              continue label278;
                           }

                           if(var9 == 0 || var13.isVisible()) {
                              if(this.a(var13.getSourcePort(), var2, var4)) {
                                 this.a(var13.getSourcePort());
                                 if(var6 != 0) {
                                    return;
                                 }
                              }

                              if(this.a(var13.getTargetPort(), var2, var4)) {
                                 this.a(var13.getTargetPort());
                                 if(var6 != 0) {
                                    return;
                                 }
                              }
                           }

                           var12.h();
                        } while(!var22);
                     case 1:
                        y var23 = var1.D();
                        var23.j();

                        do {
                           if(!var23.f()) {
                              break label278;
                           }

                           x var14 = var23.a();
                           var10000 = var9;
                           if(var22) {
                              continue label278;
                           }

                           if((var9 == 0 || var1.i(var14.a()).isVisible()) && this.a(var14, var2, var4)) {
                              this.a(var14);
                              if(var6 != 0) {
                                 return;
                              }
                           }

                           var23.h();
                        } while(!var22);
                     case 2:
                        break;
                     case 3:
                        break label290;
                     case 4:
                        break label289;
                     case 5:
                        y.c.x var17 = var1.o();
                        var17.j();

                        do {
                           var26 = var17.f();

                           label184:
                           while(true) {
                              if(var26 == 0) {
                                 break label324;
                              }

                              fj var18 = var1.t(var17.e());
                              var10000 = var8;
                              if(var22) {
                                 continue label278;
                              }

                              if(var8 != 0 && !var18.isVisible()) {
                                 break;
                              }

                              int var19 = var18.labelCount() - 1;

                              while(true) {
                                 if(var19 < 0) {
                                    break label184;
                                 }

                                 eR var20 = var18.getLabel(var19);
                                 var26 = var8;
                                 if(var22) {
                                    break;
                                 }

                                 if((var8 == 0 || var20.isVisible()) && this.a(var20, var2, var4)) {
                                    this.a(var20);
                                    if(var6 != 0) {
                                       return;
                                    }
                                 }

                                 --var19;
                                 if(var22) {
                                    break label184;
                                 }
                              }
                           }

                           var17.h();
                        } while(!var22);
                     case 6:
                        break label324;
                     default:
                        break label278;
                     }

                     y.c.e var24 = var1.p();
                     var24.j();

                     do {
                        var26 = var24.f();

                        label231:
                        while(true) {
                           if(var26 == 0) {
                              break label278;
                           }

                           aB var15 = var1.i(var24.a());
                           var10000 = var10;
                           if(var22) {
                              continue label278;
                           }

                           if(var10 != 0 && !var15.isVisible()) {
                              break;
                           }

                           int var16 = var15.labelCount() - 1;

                           while(true) {
                              if(var16 < 0) {
                                 break label231;
                              }

                              aA var30 = var15.getLabel(var16);
                              var26 = var10;
                              if(var22) {
                                 break;
                              }

                              if((var10 == 0 || var30.isVisible()) && this.a(var30, var2, var4)) {
                                 this.a(var30);
                                 if(var6 != 0) {
                                    return;
                                 }
                              }

                              --var16;
                              if(var22) {
                                 break label231;
                              }
                           }
                        }

                        var24.h();
                     } while(!var22);
                  }

                  y.c.e var25 = var1.p();
                  var25.j();

                  do {
                     if(!var25.f()) {
                        break label278;
                     }

                     aB var27 = var1.i(var25.a());
                     var10000 = var9;
                     if(var22) {
                        continue label278;
                     }

                     if((var9 == 0 || var27.isVisible()) && this.a(var27, var2, var4)) {
                        this.a(var25.a());
                        if(var6 != 0) {
                           return;
                        }
                     }

                     var25.h();
                  } while(!var22);
               }

               y.h.a.v var28 = y.h.a.v.a((y.c.i)var1);
               Iterator var31 = var28 != null?var28.i(var28.e((y.c.i)var1)):y.g.l.b(var1.o());

               while(true) {
                  y.c.q var33;
                  do {
                     if(!var31.hasNext()) {
                        break label278;
                     }

                     var33 = (y.c.q)var31.next();
                     var34 = var1.t(var33);
                  } while(var7 && !var34.isVisible());

                  if(this.a(var34, var2, var4)) {
                     this.a(var33);
                     var10000 = var6;
                     if(var22) {
                        continue label278;
                     }

                     if(var6 != 0) {
                        return;
                     }
                  }
               }
            }

            y.c.x var32 = var1.o();
            var32.j();

            while(true) {
               boolean var29 = var32.f();

               label157:
               while(true) {
                  if(!var29) {
                     break label278;
                  }

                  var34 = var1.t(var32.e());
                  var10000 = var34.portCount() - 1;
                  if(var22) {
                     continue label278;
                  }

                  int var35 = var10000;

                  while(true) {
                     if(var35 < 0) {
                        break label157;
                     }

                     eU var21 = var34.getPort(var35);
                     var29 = this.a(var21, var2, var4);
                     if(var22) {
                        break;
                     }

                     if(var29) {
                        this.a(var21);
                        if(var6 != 0) {
                           return;
                        }
                     }

                     --var35;
                     if(var22) {
                        break label157;
                     }
                  }
               }

               var32.h();
               if(var22) {
                  break label278;
               }
            }
         }

         ++var11;
      } while(!var22);

   }

   private void a(bu var1, Iterator var2, double var3, double var5, boolean var7, boolean var8) {
      boolean var13 = fj.z;
      Object var9;
      if(!var7) {
         do {
            if(!var2.hasNext()) {
               return;
            }

            var9 = var2.next();
            this.a(var1, var9, var3, var5);
         } while(!var13);
      }

      if(var8) {
         while(var2.hasNext()) {
            var9 = var2.next();
            if(var9 instanceof y.c.d) {
               if(this.a(var1.i((y.c.d)var9), var3, var5)) {
                  this.a((y.c.d)var9);
                  return;
               }
            } else if(var9 instanceof y.c.q) {
               if(this.a(var1.t((y.c.q)var9), var3, var5)) {
                  this.a((y.c.q)var9);
                  return;
               }
            } else if(var9 instanceof fL) {
               if(this.a((fL)var9, var3, var5)) {
                  this.a((fL)var9);
                  return;
               }
            } else if(var9 instanceof x) {
               if(this.a((x)var9, var3, var5)) {
                  this.a((x)var9);
                  return;
               }
            } else if(var9 instanceof aA) {
               if(this.a((aA)var9, var3, var5)) {
                  this.a((aA)var9);
                  return;
               }
            } else if(var9 instanceof eR) {
               if(this.a((eR)var9, var3, var5)) {
                  this.a((eR)var9);
                  return;
               }
            } else if(var9 instanceof eU && this.a((eU)var9, var3, var5)) {
               this.a((eU)var9);
               return;
            }
         }
      } else {
         int var14 = 0;
         int[] var10 = new int[this.a.length];
         int var11 = 0;

         int var10000;
         label201: {
            while(var11 < this.a.length) {
               var10000 = this.a[var11];
               if(var13) {
                  break label201;
               }

               switch(var10000) {
               case 0:
                  var14 |= 4;
                  var10[0] = var11;
                  if(!var13) {
                     break;
                  }
               case 1:
                  var14 |= 8;
                  var10[1] = var11;
                  if(!var13) {
                     break;
                  }
               case 2:
                  var14 |= 32;
                  var10[2] = var11;
                  if(!var13) {
                     break;
                  }
               case 3:
                  var14 |= 2;
                  var10[3] = var11;
                  if(!var13) {
                     break;
                  }
               case 4:
                  var14 |= 1;
                  var10[4] = var11;
                  if(!var13) {
                     break;
                  }
               case 5:
                  var14 |= 16;
                  var10[5] = var11;
                  if(!var13) {
                     break;
                  }
               case 6:
                  var14 |= 64;
                  var10[6] = var11;
               }

               ++var11;
               if(var13) {
                  break;
               }
            }

            var10000 = this.a.length;
         }

         Object[] var15 = new Object[var10000];

         label179:
         while(true) {
            while(true) {
               if(!var2.hasNext()) {
                  break label179;
               }

               Object var12 = var2.next();
               if((var14 & 2) != 0 && var15[var10[3]] == null && var12 instanceof y.c.d) {
                  if(this.a(var1.i((y.c.d)var12), var3, var5)) {
                     var15[var10[3]] = var12;
                     if(var10[3] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 1) != 0 && var15[var10[4]] == null && var12 instanceof y.c.q) {
                  if(this.a(var1.t((y.c.q)var12), var3, var5)) {
                     var15[var10[4]] = var12;
                     if(var10[4] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 4) != 0 && var15[var10[0]] == null && var12 instanceof fL) {
                  if(this.a((fL)var12, var3, var5)) {
                     var15[var10[0]] = var12;
                     if(var10[0] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 8) != 0 && var15[var10[1]] == null && var12 instanceof x) {
                  if(this.a((x)var12, var3, var5)) {
                     var15[var10[1]] = var12;
                     if(var10[1] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 32) != 0 && var15[var10[2]] == null && var12 instanceof aA) {
                  if(this.a((aA)var12, var3, var5)) {
                     var15[var10[2]] = var12;
                     if(var10[2] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 16) != 0 && var15[var10[5]] == null && var12 instanceof eR) {
                  if(this.a((eR)var12, var3, var5)) {
                     var15[var10[5]] = var12;
                     if(var10[5] == 0) {
                        break label179;
                     }
                  }
               } else if((var14 & 64) != 0 && var15[var10[6]] == null && var12 instanceof eU && this.a((eU)var12, var3, var5)) {
                  var15[var10[6]] = var12;
                  if(var10[6] == 0) {
                     break label179;
                  }
               }
            }
         }

         int var16 = 0;

         while(var16 < var15.length) {
            if(var15[var16] != null) {
               switch(this.a[var16]) {
               case 0:
                  this.a((fL)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 1:
                  this.a((x)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 2:
                  this.a((aA)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 3:
                  this.a((y.c.d)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 4:
                  this.a((y.c.q)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 5:
                  this.a((eR)var15[var16]);
                  if(!var13) {
                     return;
                  }
               case 6:
                  this.a((eU)var15[var16]);
                  if(!var13) {
                     return;
                  }
               }
            }

            ++var16;
            if(var13) {
               break;
            }
         }
      }

   }

   private void a(bu var1, Object var2, double var3, double var5) {
      boolean var7 = fj.z;
      if(var2 instanceof y.c.d) {
         if(!this.a(var1.i((y.c.d)var2), var3, var5)) {
            return;
         }

         this.a((y.c.d)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof y.c.q) {
         if(!this.a(var1.t((y.c.q)var2), var3, var5)) {
            return;
         }

         this.a((y.c.q)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof fL) {
         if(!this.a((fL)var2, var3, var5)) {
            return;
         }

         this.a((fL)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof x) {
         if(!this.a((x)var2, var3, var5)) {
            return;
         }

         this.a((x)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof aA) {
         if(!this.a((aA)var2, var3, var5)) {
            return;
         }

         this.a((aA)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof eR) {
         if(!this.a((eR)var2, var3, var5)) {
            return;
         }

         this.a((eR)var2);
         if(!var7) {
            return;
         }
      }

      if(var2 instanceof eU && this.a((eU)var2, var3, var5)) {
         this.a((eU)var2);
      }

   }

   public boolean a() {
      return !this.i.isEmpty();
   }

   public boolean b() {
      return this.c() > 1;
   }

   int c() {
      return this.i.size();
   }

   public y.c.C d() {
      return this.i.m();
   }

   public y.c.C e() {
      return this.c.m();
   }

   public y.c.C f() {
      return this.g.m();
   }

   public y.c.C g() {
      return this.f.m();
   }

   public Object h() {
      return this.i.isEmpty()?null:this.i.f();
   }

   public y.c.q i() {
      return this.c.isEmpty()?null:(y.c.q)this.c.f();
   }

   public x j() {
      return this.d.isEmpty()?null:(x)this.d.f();
   }

   public y.c.d k() {
      return this.b.isEmpty()?null:(y.c.d)this.b.f();
   }

   public eR l() {
      return this.f.isEmpty()?null:(eR)this.f.f();
   }

   public aA m() {
      return this.e.isEmpty()?null:(aA)this.e.f();
   }

   public fL n() {
      return this.g.isEmpty()?null:(fL)this.g.f();
   }

   public eU o() {
      return this.h.isEmpty()?null:(eU)this.h.f();
   }

   public boolean p() {
      return !this.h.isEmpty();
   }

   public boolean q() {
      return !this.g.isEmpty();
   }

   public boolean r() {
      return !this.e.isEmpty();
   }

   public boolean s() {
      return !this.f.isEmpty();
   }

   public boolean t() {
      return !this.c.isEmpty();
   }

   public boolean u() {
      return !this.b.isEmpty();
   }

   public boolean v() {
      return !this.d.isEmpty();
   }

   public cW a(bu var1, double var2, double var4) {
      if(this.c() > 1) {
         Object var6 = this.h();
         Iterator var7 = this.i.iterator();
         var7.next();
         cW var8 = new cW(var1, var7, var2, var4, false);
         var8.a(var1, var6, var2, var4);
         return var8;
      } else {
         return this;
      }
   }

   public boolean a(cW var1) {
      if(var1 == null) {
         return false;
      } else {
         HashSet var2 = new HashSet(this.i);
         var2.removeAll(var1.i);
         if(!var2.isEmpty()) {
            return false;
         } else {
            HashSet var3 = new HashSet(var1.i);
            var3.removeAll(this.i);
            return var3.isEmpty();
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      boolean var11 = fj.z;
      this.g = new y.c.D();
      this.b = new y.c.D();
      this.c = new y.c.D();
      this.d = new y.c.D();
      this.e = new y.c.D();
      this.f = new y.c.D();
      this.h = new y.c.D();
      this.i = new y.c.D();
      int[] var8 = new int[]{var1, var2, var3, var4, var5, var6, var7};
      int var9 = 0;
      int var10 = 0;

      int var10000;
      while(true) {
         if(var10 < var8.length) {
            var10000 = var8[var10];
            if(var11) {
               break;
            }

            switch(var10000) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
               ++var9;
            }

            ++var10;
            if(!var11) {
               continue;
            }
         }

         this.a = new int[var9];
         var9 = 0;
         var10000 = 0;
         break;
      }

      var10 = var10000;

      while(var10 < var8.length) {
         switch(var8[var10]) {
         case 0:
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
            this.a[var9++] = var8[var10];
         }

         ++var10;
         if(var11) {
            break;
         }
      }

   }
}
