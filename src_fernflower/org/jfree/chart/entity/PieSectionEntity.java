package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.PieDataset;

public class PieSectionEntity extends ChartEntity implements Serializable {
   private static final long serialVersionUID = 9199892576531984162L;
   private PieDataset dataset;
   private int pieIndex;
   private int sectionIndex;
   private Comparable sectionKey;

   public PieSectionEntity(Shape var1, PieDataset var2, int var3, int var4, Comparable var5, String var6, String var7) {
      super(var1, var6, var7);
      this.dataset = var2;
      this.pieIndex = var3;
      this.sectionIndex = var4;
      this.sectionKey = var5;
   }

   public PieDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(PieDataset var1) {
      this.dataset = var1;
   }

   public int getPieIndex() {
      return this.pieIndex;
   }

   public void setPieIndex(int var1) {
      this.pieIndex = var1;
   }

   public int getSectionIndex() {
      return this.sectionIndex;
   }

   public void setSectionIndex(int var1) {
      this.sectionIndex = var1;
   }

   public Comparable getSectionKey() {
      return this.sectionKey;
   }

   public void setSectionKey(Comparable var1) {
      this.sectionKey = var1;
   }

   public String toString() {
      return "PieSection: " + this.pieIndex + ", " + this.sectionIndex + "(" + this.sectionKey.toString() + ")";
   }
}
