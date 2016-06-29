package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.misc.EPercentageBarSortType;
import com.google.security.zynamics.zylib.general.Quad;

public class PercentageThreeBarExtendedCellData {
   private final Quad data;
   private final EPercentageBarSortType sortRelevance;

   public PercentageThreeBarExtendedCellData(int var1, int var2, int var3, int var4) {
      this(var1, var2, var3, var4, EPercentageBarSortType.SORT_BY_CENTER_VALUE);
   }

   public PercentageThreeBarExtendedCellData(int var1, int var2, int var3, int var4, EPercentageBarSortType var5) {
      this.data = new Quad(Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3), Integer.valueOf(var4));
      this.sortRelevance = var5 == null?EPercentageBarSortType.SORT_BY_CENTER_VALUE:var5;
   }

   public double getCenterBarPercent() {
      return (double)(((Integer)this.data.second()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public String getCenterBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.getCenterBarValue())});
      if(var1) {
         var2 = String.valueOf(var2).concat("%s(%.1f)");
         var2 = String.format(var2, new Object[]{Double.valueOf(this.getCenterBarPercent())});
      }

      return var2;
   }

   public int getCenterBarValue() {
      return ((Integer)this.data.second()).intValue();
   }

   public double getInnerCenterBarPercent() {
      return (double)(((Integer)this.data.third()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public int getInnerCenterBarValue() {
      return ((Integer)this.data.third()).intValue();
   }

   public double getLeftBarPercent() {
      return (double)(((Integer)this.data.first()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public String getLeftBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.getLeftBarValue())});
      if(var1) {
         var2 = String.valueOf(var2).concat("%s(%.1f)");
         var2 = String.format(var2, new Object[]{Double.valueOf(this.getLeftBarPercent())});
      }

      return var2;
   }

   public int getLeftBarValue() {
      return ((Integer)this.data.first()).intValue();
   }

   public double getRightBarPercent() {
      return (double)(((Integer)this.data.fourth()).intValue() / this.getTotalBarValue()) * 100.0D;
   }

   public String getRightBarString(boolean var1) {
      String var2 = "%d";
      var2 = String.format(var2, new Object[]{Integer.valueOf(this.getRightBarValue())});
      if(var1) {
         var2 = String.valueOf(var2).concat("%s(%.1f)");
         var2 = String.format(var2, new Object[]{Double.valueOf(this.getRightBarPercent())});
      }

      return var2;
   }

   public int getRightBarValue() {
      return ((Integer)this.data.fourth()).intValue();
   }

   public double getSortByValue() {
      return this.sortRelevance == EPercentageBarSortType.SORT_BY_TOTAL_SUM?(double)(((Integer)this.data.first()).intValue() + ((Integer)this.data.second()).intValue() + ((Integer)this.data.fourth()).intValue()):(this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_AND_CENTER_SUM?(double)(((Integer)this.data.first()).intValue() + ((Integer)this.data.second()).intValue()):(this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_AND_CENTER_SUM?(double)(((Integer)this.data.second()).intValue() + ((Integer)this.data.fourth()).intValue()):(this.sortRelevance == EPercentageBarSortType.SORT_BY_LEFT_VALUE?(double)((Integer)this.data.first()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_CENTER_VALUE?(double)((Integer)this.data.second()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_RIGHT_VALUE?(double)((Integer)this.data.fourth()).intValue():(this.sortRelevance == EPercentageBarSortType.SORT_BY_INNERCENTER?(double)((Integer)this.data.third()).intValue():(double)this.getTotalBarValue()))))));
   }

   public int getTotalBarValue() {
      return ((Integer)this.data.first()).intValue() + ((Integer)this.data.second()).intValue() + ((Integer)this.data.fourth()).intValue();
   }
}
