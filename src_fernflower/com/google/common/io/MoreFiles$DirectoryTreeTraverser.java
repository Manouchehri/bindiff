package com.google.common.io;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.MoreFiles;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.LinkOption;
import java.nio.file.Path;

final class MoreFiles$DirectoryTreeTraverser extends TreeTraverser {
   private static final MoreFiles$DirectoryTreeTraverser INSTANCE = new MoreFiles$DirectoryTreeTraverser();

   public Iterable children(Path var1) {
      if(java.nio.file.Files.isDirectory(var1, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
         try {
            return MoreFiles.listFiles(var1);
         } catch (IOException var3) {
            throw new DirectoryIteratorException(var3);
         }
      } else {
         return ImmutableList.of();
      }
   }

   // $FF: synthetic method
   static MoreFiles$DirectoryTreeTraverser access$200() {
      return INSTANCE;
   }
}
