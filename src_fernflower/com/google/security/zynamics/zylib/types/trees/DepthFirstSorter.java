package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.DepthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;

public final class DepthFirstSorter {
   public static ArrayList getSortedList(ITreeNode var0) {
      DepthFirstIterator var1 = new DepthFirstIterator(var0);
      ArrayList var2 = new ArrayList();

      while(var1.hasNext()) {
         var2.add(var1.next());
      }

      return var2;
   }
}
