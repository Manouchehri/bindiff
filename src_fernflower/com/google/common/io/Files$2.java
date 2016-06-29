package com.google.common.io;

import com.google.common.collect.TreeTraverser;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

final class Files$2 extends TreeTraverser {
   public Iterable children(File var1) {
      if(var1.isDirectory()) {
         File[] var2 = var1.listFiles();
         if(var2 != null) {
            return Collections.unmodifiableList(Arrays.asList(var2));
         }
      }

      return Collections.emptyList();
   }

   public String toString() {
      return "Files.fileTreeTraverser()";
   }
}
