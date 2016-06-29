package com.google.security.zynamics.bindiff.project.userview;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ViewManager {
   private final Set views = new HashSet();

   public void addView(ViewData var1) {
      this.views.add(var1);
   }

   public boolean containsView(IAddress var1, IAddress var2) {
      Iterator var3 = this.views.iterator();

      ViewData var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (ViewData)var3.next();
         if(var4.isFlowgraphView()) {
            FlowGraphViewData var5 = (FlowGraphViewData)var4;
            boolean var6 = var1 == null && var5.getRawGraph(ESide.PRIMARY) == null;
            IAddress var7 = null;
            if(var5.getRawGraph(ESide.PRIMARY) != null) {
               var7 = var5.getRawGraph(ESide.PRIMARY).getAddress();
            }

            if(var1 != null && var7 != null) {
               var6 = var1.equals(var7);
            }

            boolean var8 = var2 == null && var5.getRawGraph(ESide.SECONDARY) == null;
            IAddress var9 = null;
            if(var5.getRawGraph(ESide.SECONDARY) != null) {
               var9 = var5.getRawGraph(ESide.SECONDARY).getAddress();
            }

            if(var2 != null && var9 != null) {
               var8 = var2.equals(var9);
            }

            if(var6 && var8) {
               return true;
            }
         }
      } while(!var4.isCallgraphView() || var4.getAddress(ESide.PRIMARY) != null || var1 != null || var4.getAddress(ESide.SECONDARY) != null || var2 != null);

      return true;
   }

   public CallGraphViewData getCallgraphViewData(Diff var1) {
      Iterator var2 = this.getCallgraphViewsData().iterator();

      CallGraphViewData var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (CallGraphViewData)var2.next();
      } while(var3.getGraphs().getDiff() != var1);

      return var3;
   }

   public List getCallgraphViewsData() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.views.iterator();

      while(var2.hasNext()) {
         ViewData var3 = (ViewData)var2.next();
         if(var3 instanceof CallGraphViewData) {
            var1.add((CallGraphViewData)var3);
         }
      }

      return var1;
   }

   public FlowGraphViewData getFlowgraphViewData(IAddress var1, IAddress var2) {
      Iterator var3 = this.views.iterator();

      while(var3.hasNext()) {
         ViewData var4 = (ViewData)var3.next();
         if(var4.isFlowgraphView() && var4.getMatchState() == EMatchState.MATCHED) {
            FlowGraphViewData var5 = (FlowGraphViewData)var4;
            IAddress var6 = var5.getAddress(ESide.PRIMARY);
            IAddress var7 = var5.getAddress(ESide.SECONDARY);
            if(var6.equals(var1) && var7.equals(var2)) {
               return var5;
            }
         }
      }

      return null;
   }

   public List getFlowgraphViewsData() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.views.iterator();

      while(var2.hasNext()) {
         ViewData var3 = (ViewData)var2.next();
         if(var3 instanceof FlowGraphViewData) {
            var1.add((FlowGraphViewData)var3);
         }
      }

      return var1;
   }

   public void removeView(ViewData var1) {
      this.views.remove(var1);
   }
}
