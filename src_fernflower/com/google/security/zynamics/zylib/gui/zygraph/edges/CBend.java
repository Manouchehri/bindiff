package com.google.security.zynamics.zylib.gui.zygraph.edges;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.edges.IBendListener;
import java.util.Iterator;

public class CBend {
   private double m_x;
   private double m_y;
   private final ListenerProvider m_listeners = new ListenerProvider();

   public CBend(double var1, double var3) {
      this.m_x = var1;
      this.m_y = var3;
   }

   public void addListener(IBendListener var1) {
      this.m_listeners.addListener(var1);
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof CBend)) {
         return false;
      } else {
         CBend var2 = (CBend)var1;
         return Double.compare(var2.m_x, this.m_x) == 0 && Double.compare(var2.m_y, this.m_y) == 0;
      }
   }

   public double getX() {
      return this.m_x;
   }

   public double getY() {
      return this.m_y;
   }

   public void removeListener(IBendListener var1) {
      this.m_listeners.removeListener(var1);
   }

   public void setX(double var1) {
      if(Double.compare(this.m_x, var1) != 0) {
         this.m_x = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IBendListener var4 = (IBendListener)var3.next();
            var4.changedX(this, var1);
         }

      }
   }

   public void setY(double var1) {
      if(Double.compare(this.m_y, var1) != 0) {
         this.m_y = var1;
         Iterator var3 = this.m_listeners.iterator();

         while(var3.hasNext()) {
            IBendListener var4 = (IBendListener)var3.next();
            var4.changedY(this, var1);
         }

      }
   }
}
