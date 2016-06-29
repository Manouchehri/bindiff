package com.google.security.zynamics.zylib.types.trees;

import com.google.common.collect.Sets;
import com.google.security.zynamics.zylib.types.trees.DepthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TreeAlgorithms {
   public static boolean dominates(ITreeNode var0, ITreeNode var1, ITreeNode var2) {
      if(var0.getObject() == var2) {
         return false;
      } else if(var0.getObject() == var1) {
         return true;
      } else {
         Iterator var3 = var0.getChildren().iterator();

         ITreeNode var4;
         do {
            if(!var3.hasNext()) {
               return true;
            }

            var4 = (ITreeNode)var3.next();
         } while(dominates(var4, var1, var2));

         return false;
      }
   }

   public static HashMap getDominateRelation(ITreeNode var0) {
      HashMap var1 = new HashMap();
      HashSet var2 = new HashSet();
      var2.add(var0);
      var1.put(var0, var2);
      DepthFirstIterator var3 = new DepthFirstIterator(var0);

      while(var3.hasNext()) {
         ITreeNode var4 = var3.next();
         ITreeNode var5 = var4.getParent();
         HashSet var6 = Sets.newHashSet((Iterable)var1.get(var5));
         var6.add(var5);
         var6.add(var4);
         var1.put(var4, var6);
      }

      return var1;
   }
}
