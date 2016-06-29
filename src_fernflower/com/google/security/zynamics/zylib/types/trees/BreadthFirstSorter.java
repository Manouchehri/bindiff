package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.BreadthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;

public class BreadthFirstSorter {
   public static ArrayList getSortedList(ITreeNode var0) {
      BreadthFirstIterator var1 = new BreadthFirstIterator(var0);
      ArrayList var2 = new ArrayList();

      while(var1.hasNext()) {
         var2.add(var1.next());
      }

      return var2;
   }
}
