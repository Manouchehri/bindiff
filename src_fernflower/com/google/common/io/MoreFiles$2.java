package com.google.common.io;

import com.google.common.base.Predicate;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;

final class MoreFiles$2 implements Predicate {
   // $FF: synthetic field
   final LinkOption[] val$optionsCopy;

   MoreFiles$2(LinkOption[] var1) {
      this.val$optionsCopy = var1;
   }

   public boolean apply(Path var1) {
      return java.nio.file.Files.isRegularFile(var1, this.val$optionsCopy);
   }

   public String toString() {
      String var1 = String.valueOf(Arrays.toString(this.val$optionsCopy));
      return (new StringBuilder(25 + String.valueOf(var1).length())).append("MoreFiles.isRegularFile(").append(var1).append(")").toString();
   }
}
