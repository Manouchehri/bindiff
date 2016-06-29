package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Arc2D.Float;
import java.awt.geom.Point2D.Double;
import y.h.aB;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.hC;
import y.h.x;
import y.h.z;

class ij {
   public static byte a(aB var0, GeneralPath var1, GeneralPath var2, Point2D var3, Point2D var4) {
      boolean var48 = fj.z;
      byte var5 = 0;
      float var6 = var0.getLineType().getLineWidth();
      if((double)var6 != 1.0D) {
         var6 = 1.0F + (var6 - 1.0F) / 8.0F;
      }

      PathIterator var7;
      fj var8;
      fj var9;
      eU var10;
      eU var11;
      boolean var12;
      y.d.t var14;
      label280: {
         var7 = var1.getPathIterator((AffineTransform)null, 0.5D);
         var8 = var0.getSourceRealizer();
         var9 = var0.getTargetRealizer();
         var10 = var8.b(var0.vb);
         var11 = var9.b(var0.zb);
         if(var10 != null) {
            y.d.t var13 = eU.b((eU)var10);
            var14 = var0.getSourcePoint();
            var12 = y.d.t.a(var13, var14) < 1.0E-12D;
            if(!var48) {
               break label280;
            }
         }

         var12 = false;
      }

      int var49;
      label274: {
         if(var11 != null) {
            var14 = eU.b((eU)var11);
            y.d.t var15 = var0.getTargetPoint();
            var49 = y.d.t.a(var14, var15) < 1.0E-12D?1:0;
            if(!var48) {
               break label274;
            }
         }

         var49 = 0;
      }

      var14 = a(var12, var12?var10:var0.getSourcePort(), var8);
      float var50 = (float)var14.a();
      float var16 = (float)var14.b();
      float[] var17 = new float[2];
      if(!var7.isDone()) {
         var7.currentSegment(var17);
         var50 = var17[0];
         var16 = var17[1];
      }

      Double var18 = new Double();
      int var19 = var12?1:3;
      Object var20 = var12?var10:var8;

      byte var10000;
      while(true) {
         if(!var7.isDone()) {
            var7.currentSegment(var17);
            var7.next();
            var10000 = a(var12, var20, (double)var17[0], (double)var17[1]);
            if(var48) {
               break;
            }

            if(var10000 != 0) {
               var50 = var17[0];
               var16 = var17[1];
               if(!var48) {
                  continue;
               }
            }
         }

         var10000 = 32;
         break;
      }

      float[] var21;
      int var22;
      label258: {
         var21 = new float[var10000];
         var22 = 0;
         if(a((byte)var19, var20, var8, (double)var50, (double)var16, (double)var17[0], (double)var17[1], var18)) {
            var21[var22++] = (float)var18.getX();
            var21[var22++] = (float)var18.getY();
            var3.setLocation(var18);
            var21[var22++] = var17[0];
            var21[var22++] = var17[1];
            if(!var48) {
               break label258;
            }
         }

         var21[var22++] = var17[0];
         var21[var22++] = var17[1];
         var3.setLocation((double)var17[0], (double)var17[1]);
      }

      y.d.t var23 = a((boolean)var49, var49 != 0?var11:var0.getTargetPort(), var9);
      var17[0] = (float)var23.a();
      var17[1] = (float)var23.b();

      int var54;
      while(true) {
         if(!var7.isDone()) {
            var7.currentSegment(var17);
            var7.next();
            var54 = var22;
            if(var48) {
               break;
            }

            if(var22 == var21.length) {
               float[] var24 = new float[var21.length * 2];
               System.arraycopy(var21, 0, var24, 0, var21.length);
               var21 = var24;
            }

            var21[var22++] = var17[0];
            var21[var22++] = var17[1];
            if(!var48) {
               continue;
            }
         }

         var50 = var17[0];
         var16 = var17[1];
         var54 = var49;
         break;
      }

      int var51 = var54 != 0?1:3;
      Object var25 = var49 != 0?var11:var9;
      int var26 = var22;

      while(true) {
         if(var26 > 1) {
            label285: {
               --var26;
               var17[1] = var21[var26];
               --var26;
               var17[0] = var21[var26];
               var10000 = a((boolean)var49, var25, (double)var17[0], (double)var17[1]);
               if(var48) {
                  break;
               }

               if(var10000 == 0) {
                  if(a((byte)var51, var25, var9, (double)var50, (double)var16, (double)var17[0], (double)var17[1], var18)) {
                     ++var26;
                     if(var26 + 2 > var21.length) {
                        float[] var27 = new float[var26 + 4];
                        System.arraycopy(var21, 0, var27, 0, var21.length);
                        var21 = var27;
                     }

                     ++var26;
                     var21[var26] = (float)var18.x;
                     ++var26;
                     var21[var26] = (float)var18.y;
                     var4.setLocation(var18);
                     if(!var48) {
                        break label285;
                     }
                  }

                  ++var26;
                  var4.setLocation((double)var50, (double)var16);
                  if(!var48) {
                     break label285;
                  }
               }

               var50 = var17[0];
               var16 = var17[1];
               if(!var48) {
                  continue;
               }
            }
         }

         var10000 = 0;
         break;
      }

      int var28;
      float var29;
      float var30;
      float var31;
      float var32;
      float var33;
      int var52;
      label226: {
         var52 = var10000;
         var28 = var26 - 1;
         if(var52 < var28) {
            var29 = (float)var0.getSourceArrow().d();
            if(var29 > 0.0F) {
               var30 = 0.0F;

               while(var52 < var28) {
                  float var56;
                  var54 = (var56 = var30 - var29) == 0.0F?0:(var56 < 0.0F?-1:1);
                  if(var48) {
                     break label226;
                  }

                  if(var54 >= 0) {
                     break;
                  }

                  var31 = var21[var52 + 2] - var21[var52];
                  var32 = var21[var52 + 3] - var21[var52 + 1];
                  var33 = (float)Math.sqrt((double)(var31 * var31 + var32 * var32));
                  var30 += var33;
                  if(var30 > var29) {
                     var21[var52] = var21[var52 + 2] - (var30 - var29) * var31 / var33;
                     var21[var52 + 1] = var21[var52 + 3] - (var30 - var29) * var32 / var33;
                     if(!var48) {
                        break;
                     }
                  }

                  var52 += 2;
                  if(var48) {
                     break;
                  }
               }
            }
         }

         var54 = var52;
      }

      label208: {
         if(var54 < var28) {
            var29 = (float)var0.getTargetArrow().d();
            if(var29 > 0.0F) {
               var30 = 0.0F;

               while(var52 < var28) {
                  float var57;
                  var54 = (var57 = var30 - var29) == 0.0F?0:(var57 < 0.0F?-1:1);
                  if(var48) {
                     break label208;
                  }

                  if(var54 >= 0) {
                     break;
                  }

                  var31 = var21[var28 - 2] - var21[var28];
                  var32 = var21[var28 - 1] - var21[var28 + 1];
                  var33 = (float)Math.sqrt((double)(var31 * var31 + var32 * var32));
                  var30 += var33;
                  if(var30 > var29) {
                     var21[var28] = var21[var28 - 2] - (var30 - var29) * var31 / var33;
                     var21[var28 + 1] = var21[var28 - 1] - (var30 - var29) * var32 / var33;
                     if(!var48) {
                        break;
                     }
                  }

                  var28 -= 2;
                  if(var48) {
                     break;
                  }
               }
            }
         }

         var54 = var52;
      }

      float var34;
      float var35;
      float var36;
      float var37;
      float var38;
      float var39;
      float var40;
      float var41;
      float var42;
      float var43;
      float var44;
      float var45;
      float var46;
      float var47;
      label190: {
         if(var54 < var28) {
            var29 = (float)var0.getSourceArrow().c() * var6;
            if(var29 > 0.0F) {
               var30 = var21[var52];
               var31 = var21[var52 + 1];
               var32 = var29 * var29;

               while(var52 < var28) {
                  var33 = var21[var52] - var30;
                  var34 = var21[var52 + 1] - var31;
                  var35 = var33 * var33 + var34 * var34;
                  var36 = var21[var52 + 2] - var30;
                  var37 = var21[var52 + 3] - var31;
                  var38 = var36 * var36 + var37 * var37;
                  float var58;
                  var54 = (var58 = var38 - var32) == 0.0F?0:(var58 < 0.0F?-1:1);
                  if(var48) {
                     break label190;
                  }

                  if(var54 >= 0) {
                     var39 = var21[var52 + 2] - var21[var52];
                     var40 = var21[var52 + 3] - var21[var52 + 1];
                     var41 = var39 * var39 + var40 * var40;
                     var42 = 2.0F * (var33 * var39 + var34 * var40);
                     var43 = var33 * var33 + var34 * var34 - var32;
                     var44 = var42 * var42 - 4.0F * var41 * var43;
                     if(var44 >= 0.0F) {
                        var45 = (float)Math.sqrt((double)var44);
                        var46 = (-var42 + var45) / (2.0F * var41);
                        if(var46 >= 0.0F && var46 <= 1.0F) {
                           var21[var52] += var39 * var46;
                           var21[var52 + 1] += var40 * var46;
                           if(var35 > 0.0F && var52 >= 2) {
                              var47 = (float)Math.sqrt((double)var35);
                              var21[var52 - 2] = var21[var52] - var33 * 0.1F / var47;
                              var21[var52 - 1] = var21[var52 + 1] - var34 * 0.1F / var47;
                              var52 -= 2;
                           }
                        }
                     }

                     var5 = (byte)(var5 | 4);
                     if(!var48) {
                        break;
                     }
                  }

                  var52 += 2;
                  if(var48) {
                     break;
                  }
               }
            }
         }

         var54 = var52;
      }

      label173: {
         if(var54 < var28) {
            var29 = (float)var0.getTargetArrow().c() * var6;
            if(var29 > 0.0F) {
               var30 = var21[var28];
               var31 = var21[var28 + 1];
               var32 = var29 * var29;

               while(var52 < var28) {
                  var33 = var21[var28] - var30;
                  var34 = var21[var28 + 1] - var31;
                  var35 = var33 * var33 + var34 * var34;
                  var36 = var21[var28 - 2] - var30;
                  var37 = var21[var28 - 1] - var31;
                  var38 = var36 * var36 + var37 * var37;
                  float var59;
                  var54 = (var59 = var38 - var32) == 0.0F?0:(var59 < 0.0F?-1:1);
                  if(var48) {
                     break label173;
                  }

                  if(var54 >= 0) {
                     var39 = var21[var28 - 2] - var21[var28];
                     var40 = var21[var28 - 1] - var21[var28 + 1];
                     var41 = var39 * var39 + var40 * var40;
                     var42 = 2.0F * (var33 * var39 + var34 * var40);
                     var43 = var33 * var33 + var34 * var34 - var32;
                     var44 = var42 * var42 - 4.0F * var41 * var43;
                     if(var44 >= 0.0F) {
                        var45 = (float)Math.sqrt((double)var44);
                        var46 = (-var42 + var45) / (2.0F * var41);
                        if(var46 >= 0.0F && var46 <= 1.0F) {
                           var21[var28] += var39 * var46;
                           var21[var28 + 1] += var40 * var46;
                           if(var35 > 0.0F && var28 < var21.length + 3) {
                              var47 = (float)Math.sqrt((double)var35);
                              var21[var28 + 2] = var21[var28] - var33 * 0.1F / var47;
                              var21[var28 + 3] = var21[var28 + 1] - var34 * 0.1F / var47;
                              var28 += 2;
                           }
                        }
                     }

                     var5 = (byte)(var5 | 8);
                     if(!var48) {
                        break;
                     }
                  }

                  var28 -= 2;
                  if(var48) {
                     break;
                  }
               }
            }
         }

         var2.reset();
         var54 = var52;
      }

      if(var54 < var28) {
         var2.moveTo(var21[var52++], var21[var52++]);
         int var53 = var52;

         while(var53 <= var28) {
            var2.lineTo(var21[var53++], var21[var53++]);
            if(var48) {
               break;
            }
         }
      }

      return var5;
   }

   public static byte a(aB var0, GeneralPath var1, Point2D var2, Point2D var3) {
      byte var4;
      z var5;
      Double var6;
      fj var7;
      fj var8;
      fL var9;
      fL var10;
      boolean var11;
      eU var12;
      eU var13;
      boolean var14;
      y.d.t var16;
      boolean var50;
      label323: {
         var50 = fj.z;
         var4 = 0;
         var5 = var0.bends;
         var6 = hC.a().i;
         var6.x = var6.y = 0.0D;
         var7 = var0.getSourceRealizer();
         var8 = var0.getTargetRealizer();
         var9 = var0.getSourcePort();
         var10 = var0.getTargetPort();
         var11 = false;
         var1.reset();
         var12 = var7.b(var0.vb);
         var13 = var8.b(var0.zb);
         if(var12 != null) {
            y.d.t var15 = eU.b((eU)var12);
            var16 = var0.getSourcePoint();
            var14 = y.d.t.a(var15, var16) < 1.0E-12D;
            if(!var50) {
               break label323;
            }
         }

         var14 = false;
      }

      boolean var51;
      label317: {
         if(var13 != null) {
            var16 = eU.b((eU)var13);
            y.d.t var17 = var0.getTargetPoint();
            var51 = y.d.t.a(var16, var17) < 1.0E-12D;
            if(!var50) {
               break label317;
            }
         }

         var51 = false;
      }

      Object var52 = var14?var12:var9;
      Object var54 = var51?var13:var10;
      int var18 = 0;
      y.d.t var19 = a(var14, var52, var7);
      double var20 = var19.a();
      double var22 = var19.b();
      y.d.t var24 = a(var51, var54, var8);
      double var25 = var24.a();
      double var27 = var24.b();
      y.c.p var29 = var5.k();
      double var32;
      if(a(var14, var14?var12:var7, var20, var22)) {
         double var30 = var20;
         var32 = var22;
         int var34 = var14?1:2;

         boolean var10000;
         label307: {
            while(var29 != null) {
               x var35 = (x)var29.c();
               var11 = a((byte)var34, var52, var7, var30, var32, var35.b(), var35.c(), var6);
               var10000 = var11;
               if(var50) {
                  break label307;
               }

               if(var11) {
                  var20 = var6.x;
                  var22 = var6.y;
                  if(!var50) {
                     break;
                  }
               }

               var30 = var35.b();
               var32 = var35.c();
               var29 = var29.a();
               ++var18;
               if(var50) {
                  break;
               }
            }

            var10000 = var11;
         }

         if(!var10000 && var29 == null) {
            var11 = a((byte)var34, var52, var7, var30, var32, var25, var27, var6);
            if(var11) {
               var20 = var6.x;
               var22 = var6.y;
            }
         }

         if(!var11) {
            return var4;
         }
      }

      label375: {
         label289: {
            int var10001;
            y.c.p var31;
            int var53;
            label361: {
               var2.setLocation(var20, var22);
               var11 = false;
               int var55 = var5.size();
               var31 = var5.l();
               double var56;
               if(a(var51, var51?var13:var8, var25, var27)) {
                  var32 = var25;
                  var56 = var27;
                  int var36 = var51?1:2;

                  while(var31 != null) {
                     var53 = var18;
                     var10001 = var55;
                     if(var50) {
                        break label361;
                     }

                     if(var18 == var55) {
                        var11 = a((byte)var36, var54, var8, var32, var56, var20, var22, var6);
                        if(!var11) {
                           break label375;
                        }

                        var25 = var6.x;
                        var27 = var6.y;
                        if(var50) {
                           break label375;
                        }
                        break;
                     }

                     x var41 = (x)var31.c();
                     double var37 = var41.b();
                     double var39 = var41.c();
                     var11 = a((byte)var36, var54, var8, var32, var56, var37, var39, var6);
                     if(var11) {
                        var25 = var6.x;
                        var27 = var6.y;
                        if(!var50) {
                           break;
                        }
                     }

                     var32 = var37;
                     var56 = var39;
                     var31 = var31.b();
                     --var55;
                     if(var50) {
                        break;
                     }
                  }

                  if(!var11) {
                     var11 = a((byte)var36, var54, var8, var32, var56, var20, var22, var6);
                     if(var11) {
                        if(a(var14, var14?var12:var7, var6.x, var6.y)) {
                           var11 = false;
                        }

                        var25 = var6.x;
                        var27 = var6.y;
                     }
                  }

                  if(!var11) {
                     return var4;
                  }
               }

               var3.setLocation(var25, var27);
               var32 = var0.getArrowScaleFactor();
               var56 = var0.getSourceArrow().d();
               double var38;
               x var40;
               double var42;
               double var44;
               double var46;
               x var48;
               double var57;
               double var59;
               if(var56 > 0.0D) {
                  label355: {
                     label268: {
                        if(var18 == var55) {
                           var57 = var25;
                           var38 = var27;
                           if(!var50) {
                              break label268;
                           }
                        }

                        var40 = (x)var29.c();
                        var57 = var40.b();
                        var38 = var40.c();
                     }

                     var59 = var57 - var20;
                     var42 = var38 - var22;
                     var44 = Math.sqrt(var59 * var59 + var42 * var42);
                     if(var44 > var56) {
                        var46 = var56 / var44;
                        var20 += var59 * var46;
                        var22 += var42 * var46;
                        if(!var50) {
                           break label355;
                        }
                     }

                     if(var18 >= var55) {
                        return var4;
                     }

                     if(var18 <= var55) {
                        var57 = var20;
                        var38 = var22;
                        var46 = 0.0D;

                        while(true) {
                           if(var18 < var55) {
                              double var62;
                              var53 = (var62 = var46 - var56) == 0.0D?0:(var62 < 0.0D?-1:1);
                              if(var50) {
                                 break;
                              }

                              if(var53 < 0) {
                                 label257: {
                                    var48 = (x)var29.c();
                                    var59 = var48.b() - var57;
                                    var42 = var48.c() - var38;
                                    var44 = Math.sqrt(var59 * var59 + var42 * var42);
                                    var46 += var44;
                                    if(var46 >= var56) {
                                       var20 = var48.b() - var59 * (var46 - var56) / var44;
                                       var22 = var48.c() - var42 * (var46 - var56) / var44;
                                       if(!var50) {
                                          break label257;
                                       }
                                    }

                                    var57 = var48.b();
                                    var38 = var48.c();
                                    var29 = var29.a();
                                    ++var18;
                                    if(!var50) {
                                       continue;
                                    }
                                 }
                              }
                           }

                           var53 = var18;
                           break;
                        }

                        if(var53 == var55 && var46 < var56) {
                           var59 = var25 - var57;
                           var42 = var27 - var38;
                           var44 = Math.sqrt(var59 * var59 + var42 * var42);
                           var46 += var44;
                           if(var46 < var56) {
                              return var4;
                           }

                           var20 = var25 - var59 * (var46 - var56) / var44;
                           var22 = var27 - var42 * (var46 - var56) / var44;
                           if(var50) {
                              return var4;
                           }
                        }
                     }
                  }
               }

               var56 = var0.getTargetArrow().d();
               if(var56 > 0.0D) {
                  label357: {
                     label239: {
                        if(var18 == var55) {
                           var57 = var20;
                           var38 = var22;
                           if(!var50) {
                              break label239;
                           }
                        }

                        var40 = (x)var31.c();
                        var57 = var40.b();
                        var38 = var40.c();
                     }

                     var59 = var57 - var25;
                     var42 = var38 - var27;
                     var44 = Math.sqrt(var59 * var59 + var42 * var42);
                     if(var44 > var56) {
                        var46 = var56 / var44;
                        var25 += var59 * var46;
                        var27 += var42 * var46;
                        if(!var50) {
                           break label357;
                        }
                     }

                     if(var18 >= var55) {
                        return var4;
                     }

                     if(var18 != var55) {
                        var57 = var25;
                        var38 = var27;
                        var46 = 0.0D;

                        while(true) {
                           if(var18 < var55) {
                              double var63;
                              var53 = (var63 = var46 - var56) == 0.0D?0:(var63 < 0.0D?-1:1);
                              if(var50) {
                                 break;
                              }

                              if(var53 < 0) {
                                 label228: {
                                    var48 = (x)var31.c();
                                    var59 = var48.b() - var57;
                                    var42 = var48.c() - var38;
                                    var44 = Math.sqrt(var59 * var59 + var42 * var42);
                                    var46 += var44;
                                    if(var46 >= var56) {
                                       var25 = var48.b() - var59 * (var46 - var56) / var44;
                                       var27 = var48.c() - var42 * (var46 - var56) / var44;
                                       if(!var50) {
                                          break label228;
                                       }
                                    }

                                    var57 = var48.b();
                                    var38 = var48.c();
                                    --var55;
                                    var31 = var31.b();
                                    if(!var50) {
                                       continue;
                                    }
                                 }
                              }
                           }

                           var53 = var18;
                           break;
                        }

                        if(var53 == var55 && var46 < var56) {
                           var59 = var20 - var57;
                           var42 = var22 - var38;
                           var44 = Math.sqrt(var59 * var59 + var42 * var42);
                           var46 += var44;
                           if(var46 < var56) {
                              return var4;
                           }

                           var25 = var20 - (var46 - var56) * var59 / var44;
                           var27 = var22 - (var46 - var56) * var42 / var44;
                           if(var50) {
                              return var4;
                           }
                        }
                     }
                  }
               }

               var56 = var0.getSourceArrow().c() * var32;
               x var60;
               double var61;
               if(var56 > 0.0D) {
                  label210: {
                     if(var29 == null) {
                        var59 = var25;
                        var42 = var27;
                        if(!var50) {
                           break label210;
                        }
                     }

                     var60 = (x)var29.c();
                     var59 = var60.b();
                     var42 = var60.c();
                  }

                  var44 = var59 - var20;
                  var46 = var42 - var22;
                  var61 = Math.sqrt(var44 * var44 + var46 * var46);
                  if(var61 > var56) {
                     var20 += var44 * var56 / var61;
                     var22 += var46 * var56 / var61;
                     var4 = (byte)(var4 | 4);
                  }
               }

               var56 = var0.getTargetArrow().c() * var32;
               if(var56 > 0.0D) {
                  label201: {
                     if(var31 == null) {
                        var59 = var20;
                        var42 = var22;
                        if(!var50) {
                           break label201;
                        }
                     }

                     var60 = (x)var31.c();
                     var59 = var60.b();
                     var42 = var60.c();
                  }

                  var44 = var59 - var25;
                  var46 = var42 - var27;
                  var61 = Math.sqrt(var44 * var44 + var46 * var46);
                  if(var61 > var56) {
                     var25 += var44 * var56 / var61;
                     var27 += var46 * var56 / var61;
                     var4 = (byte)(var4 | 8);
                  }
               }

               var1.moveTo((float)var20, (float)var22);
               if(var31 == null || var29 == null) {
                  break label289;
               }

               var53 = var18;
               var10001 = var55;
            }

            if(var53 < var10001) {
               var31 = var31.a();

               while(var29 != var31) {
                  x var58 = (x)var29.c();
                  var1.lineTo((float)var58.b(), (float)var58.c());
                  var29 = var29.a();
                  if(var50) {
                     return var4;
                  }

                  if(var50) {
                     break;
                  }
               }
            }
         }

         var1.lineTo((float)var25, (float)var27);
         return var4;
      }

      var1.reset();
      return var4;
   }

   private static boolean a(byte var0, Object var1, fj var2, double var3, double var5, double var7, double var9, Double var11) {
      switch(var0) {
      case 1:
         return ((eU)var1).a(var3, var5, var7, var9, var11);
      case 2:
         return ((fL)var1).a(var2, var3, var5, var7, var9, var11);
      case 3:
         return ((fj)var1).findIntersection(var3, var5, var7, var9, var11);
      default:
         throw new IllegalArgumentException("Invalid type: " + var0);
      }
   }

   private static boolean a(boolean var0, Object var1, double var2, double var4) {
      return var0?((eU)var1).a(var2, var4):((fj)var1).contains(var2, var4);
   }

   private static y.d.t a(boolean var0, Object var1, fj var2) {
      if(var0) {
         return ((eU)var1).h();
      } else {
         fL var3 = (fL)var1;
         return new y.d.t(var3.a(var2), var3.b(var2));
      }
   }

   public static byte b(aB var0, GeneralPath var1, Point2D var2, Point2D var3) {
      double var7;
      double var9;
      double var11;
      double var13;
      double var15;
      double var17;
      label44: {
         boolean var40 = fj.z;
         fj var5 = var0.getSourceRealizer();
         x var6 = var0.getBend(0);
         if(var5.b(var0.vb) != null || var5.b(var0.zb) != null) {
            fL var19 = var0.getSourcePort();
            y.d.t var20 = new y.d.t(var19.a(var5), var19.b(var5));
            fL var21 = var0.getTargetPort();
            y.d.t var22 = new y.d.t(var21.a(var5), var21.b(var5));
            y.d.t var23 = new y.d.t(var6.b(), var6.c());
            if(y.d.e.d(var20, var22, var23)) {
               var7 = var20.a();
               var9 = var20.b();
               var11 = (var23.a() + var7) * 0.5D;
               var13 = (var23.b() + var9) * 0.5D;
               var15 = Point2D.distance(var11, var13, var7, var9);
               var17 = 360.0D;
               double var45 = var22.a() - var7;
               double var46 = var22.b() - var9;
               if(var45 * var45 + var46 * var46 > 1.0E-12D) {
                  var1.reset();
                  var1.moveTo((float)var7, (float)var9);
                  var1.lineTo((float)var23.a(), (float)var23.b());
                  var1.lineTo((float)var22.a(), (float)var22.b());
                  return a(var0, var1, var1, var2, var3);
               }
               break label44;
            }

            y.d.p var24 = new y.d.p(var20, var22, var23);
            y.d.t var25 = var24.a();
            var11 = var25.a();
            var13 = var25.b();
            var15 = var24.b();
            var7 = var20.a();
            var9 = var20.b();
            int var26 = y.d.e.a(var20, var23, var22);
            if(var26 == 0) {
               var17 = 360.0D;
               if(!var40) {
                  break label44;
               }
            }

            double var28;
            label42: {
               int var27 = y.d.e.a(var20, var25, var22);
               if(var27 == 0) {
                  var28 = 180.0D;
                  if(!var40) {
                     break label42;
                  }
               }

               double var30 = var20.a() - var11;
               double var32 = var20.b() - var13;
               double var34 = var22.a() - var11;
               double var36 = var22.b() - var13;
               double var38 = y.d.e.b(Math.acos((var30 * var34 + var32 * var36) / (Math.sqrt(var30 * var30 + var32 * var32) * Math.sqrt(var34 * var34 + var36 * var36))));
               if(var27 == var26) {
                  var28 = 360.0D - var38;
                  if(!var40) {
                     break label42;
                  }
               }

               var28 = var38;
            }

            var17 = (double)(-var26) * var28;
            if(!var40) {
               break label44;
            }
         }

         var7 = var0.getSourcePort().a(var5);
         var9 = var0.getSourcePort().b(var5);
         var11 = (var6.b() + var7) / 2.0D;
         var13 = (var6.c() + var9) / 2.0D;
         var15 = Point2D.distance(var11, var13, var7, var9);
         var17 = 360.0D;
      }

      Float var41 = new Float(0);
      var41.setFrameFromCenter(var11, var13, var11 - var15, var13 - var15);
      var41.setAngleStart(new Double(var7, var9));
      var41.setAngleExtent(var17);
      PathIterator var42 = var41.getPathIterator((AffineTransform)null, 0.20000000298023224D);
      GeneralPath var43 = new GeneralPath(1, 2);
      var43.append(var42, false);
      byte var44 = a(var0, var43, var43 = new GeneralPath(1, var0.bendCount() + 4), var2, var3);
      var42 = var43.getPathIterator((AffineTransform)null);
      var1.reset();
      var1.append(var42, false);
      return var44;
   }

   public static byte c(aB var0, GeneralPath var1, Point2D var2, Point2D var3) {
      byte var4 = a(var0, var1, var2, var3);
      a(var0, var1);
      return var4;
   }

   public static void a(aB var0, GeneralPath var1) {
      boolean var10 = fj.z;
      int var2 = var0.bendCount();
      if(var2 > 0) {
         PathIterator var3 = var1.getPathIterator((AffineTransform)null);
         if(var3.isDone()) {
            return;
         }

         GeneralPath var4 = new GeneralPath(1, var0.bendCount() + 2);
         float[] var5 = new float[2];
         float[] var6 = new float[2];
         float[] var7 = new float[2];
         float[] var8 = new float[2];
         float[] var9 = new float[2];
         var3.currentSegment(var6);
         var3.next();
         var4.moveTo(var6[0], var6[1]);
         var3.currentSegment(var7);
         var3.next();
         a(var6, var7, var9);

         label38: {
            while(!var3.isDone()) {
               var3.currentSegment(var8);
               var3.next();
               if(var10) {
                  break label38;
               }

               if(var8[0] != var7[0] || var8[1] != var7[1]) {
                  var5[0] = var6[0];
                  var5[1] = var6[1];
                  var6[0] = var7[0];
                  var6[1] = var7[1];
                  var7[0] = var8[0];
                  var7[1] = var8[1];
                  if(y.d.e.a((double)var5[0], (double)var5[1], (double)var7[0], (double)var7[1], (double)var6[0], (double)var6[1]) != 0) {
                     var4.lineTo(var6[0] - var9[0], var6[1] - var9[1]);
                     a(var6, var7, var9);
                     var4.quadTo(var6[0], var6[1], var6[0] + var9[0], var6[1] + var9[1]);
                     if(!var10) {
                        continue;
                     }
                  }

                  a(var6, var7, var9);
                  if(!var10) {
                     continue;
                  }
               }

               var9[0] = 0.0F;
               var9[1] = 0.0F;
               if(var10) {
                  break;
               }
            }

            var4.lineTo(var7[0], var7[1]);
            var1.reset();
            var3 = var4.getPathIterator((AffineTransform)null, 1.0D);
         }

         var1.append(var3, false);
      }

   }

   private static void a(float[] var0, float[] var1, float[] var2) {
      var2[0] = var1[0] - var0[0];
      var2[1] = var1[1] - var0[1];
      float var3 = (float)Math.sqrt((double)(var2[0] * var2[0] + var2[1] * var2[1]));
      float var4 = var3 < 20.0F?0.5F:10.0F / var3;
      var2[0] = var4 * var2[0];
      var2[1] = var4 * var2[1];
   }

   public static GeneralPath a(GeneralPath var0) {
      boolean var9 = fj.z;
      PathIterator var1 = var0.getPathIterator((AffineTransform)null, 0.1D);
      float[] var2 = new float[60];
      int var3 = 0;
      float[] var4 = new float[2];

      while(!var1.isDone()) {
         var1.currentSegment(var4);
         var2[var3++] = var4[0];
         var2[var3++] = var4[1];
         if(var3 == var2.length) {
            float[] var5 = new float[Math.min(var2.length * 2, var2.length + 300)];
            System.arraycopy(var2, 0, var5, 0, var2.length);
            var2 = var5;
         }

         var1.next();
         if(var9) {
            break;
         }
      }

      GeneralPath var10 = new GeneralPath(1, var3 / 2 + 5);
      var10.moveTo(var4[0], var4[1]);
      int var6 = var3 - 3;

      GeneralPath var10000;
      while(true) {
         if(var6 >= 0) {
            float var7 = var2[var6--];
            float var8 = var2[var6--];
            var10000 = var10;
            if(var9) {
               break;
            }

            var10.lineTo(var8, var7);
            if(!var9) {
               continue;
            }
         }

         var10000 = var10;
         break;
      }

      return var10000;
   }
}
