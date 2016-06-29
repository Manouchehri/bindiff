package org.jfree.base.modules;

import java.util.ArrayList;
import org.jfree.base.modules.PackageState;

class PackageSorter$SortModule implements Comparable {
   private int position = -1;
   private final PackageState state;
   private ArrayList dependSubsystems;

   public PackageSorter$SortModule(PackageState var1) {
      this.state = var1;
   }

   public ArrayList getDependSubsystems() {
      return this.dependSubsystems;
   }

   public void setDependSubsystems(ArrayList var1) {
      this.dependSubsystems = var1;
   }

   public int getPosition() {
      return this.position;
   }

   public void setPosition(int var1) {
      this.position = var1;
   }

   public PackageState getState() {
      return this.state;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append("SortModule: ");
      var1.append(this.position);
      var1.append(" ");
      var1.append(this.state.getModule().getName());
      var1.append(" ");
      var1.append(this.state.getModule().getModuleClass());
      return var1.toString();
   }

   public int compareTo(Object var1) {
      PackageSorter$SortModule var2 = (PackageSorter$SortModule)var1;
      return this.position > var2.position?1:(this.position < var2.position?-1:0);
   }
}
