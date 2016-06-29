package com.google.common.io;

import com.google.common.base.Predicate;
import com.google.common.io.Files$1;

enum Files$FilePredicate implements Predicate {
   IS_DIRECTORY,
   IS_FILE;

   private Files$FilePredicate() {
   }

   // $FF: synthetic method
   Files$FilePredicate(Files$1 var3) {
      this();
   }
}
