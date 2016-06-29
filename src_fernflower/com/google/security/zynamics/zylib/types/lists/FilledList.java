package com.google.security.zynamics.zylib.types.lists;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.lists.IFilledList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilledList extends ArrayList implements IFilledList {
   public FilledList() {
   }

   public FilledList(Collection var1) {
      super(var1);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         Preconditions.checkNotNull(var3, "Error: Can not add null-elements to filled lists");
      }

   }

   public void add(int var1, Object var2) {
      Preconditions.checkNotNull(var2, "Error: Can not add null-elements to filled lists");
      super.add(var1, var2);
   }

   public boolean add(Object var1) {
      Preconditions.checkNotNull(var1, "Error: Can not add null-elements to filled lists");
      return super.add(var1);
   }

   public boolean addAll(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         Preconditions.checkNotNull(var3, "Error: Can not add null-elements to filled lists");
      }

      return super.addAll(var1);
   }

   public boolean addAll(int var1, Collection var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         Preconditions.checkNotNull(var4, "Error: Can not add null-elements to filled lists");
      }

      return super.addAll(var1, var2);
   }
}
