package com.google.security.zynamics.bindiff.graph.layout.util;

import y.c.D;
import y.c.q;
import y.f.ax;
import y.f.ay;
import y.h.bu;

public class NodePorts {
   private final D topLeftPorts = new D();
   private final D topMiddlePorts = new D();
   private final D topRightPorts = new D();
   private final D bottomLeftPorts = new D();
   private final D bottomMiddlePorts = new D();
   private final D bottomRightPorts = new D();
   private final ay candidateSet = new ay();

   public NodePorts(q var1, bu var2) {
      double var3 = var2.p(var1);
      double var5 = var3 * 0.5D;
      double var7 = var2.p(var1) / 3.0D;
      double var9 = var2.q(var1) * 0.5D;
      double var11 = var7 / (double)(var1.b() + 1);
      double var13 = 0.0D;

      ax var16;
      int var15;
      for(var15 = 0; var15 < var1.b(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, -var9, 1);
         this.topLeftPorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

      var13 += var11;

      for(var15 = 0; var15 < var1.b(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, -var9, 1);
         this.topMiddlePorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

      var13 += var11;

      for(var15 = 0; var15 < var1.b(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, -var9, 1);
         this.topRightPorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

      var11 = var7 / (double)(var1.c() + 1);
      var13 = 0.0D;

      for(var15 = 0; var15 < var1.c(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, var9, 2);
         this.bottomLeftPorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

      var13 += var11;

      for(var15 = 0; var15 < var1.c(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, var9, 2);
         this.bottomMiddlePorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

      var13 += var11;

      for(var15 = 0; var15 < var1.c(); ++var15) {
         var13 += var11;
         var16 = ax.a(var13 - var5, var9, 2);
         this.bottomRightPorts.add(var16);
         this.candidateSet.a(var16, 1);
      }

   }

   public D getBottomLeftPorts() {
      return this.bottomLeftPorts;
   }

   public D getBottomMiddlePorts() {
      return this.bottomMiddlePorts;
   }

   public D getBottomRightPorts() {
      return this.bottomRightPorts;
   }

   public ay getCandideSet() {
      return this.candidateSet;
   }

   public D getTopLeftPorts() {
      return this.topLeftPorts;
   }

   public D getTopMiddlePorts() {
      return this.topMiddlePorts;
   }

   public D getTopRightPorts() {
      return this.topRightPorts;
   }
}
