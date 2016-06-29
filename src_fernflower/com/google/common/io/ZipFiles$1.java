package com.google.common.io;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.zip.ZipFile;

final class ZipFiles$1 extends FluentIterable {
   // $FF: synthetic field
   final ZipFile val$file;

   ZipFiles$1(ZipFile var1) {
      this.val$file = var1;
   }

   public Iterator iterator() {
      return Iterators.forEnumeration(this.val$file.entries());
   }
}
