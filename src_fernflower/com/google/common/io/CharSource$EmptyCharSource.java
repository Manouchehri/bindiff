package com.google.common.io;

import com.google.common.io.CharSource$CharSequenceCharSource;

final class CharSource$EmptyCharSource extends CharSource$CharSequenceCharSource {
   private static final CharSource$EmptyCharSource INSTANCE = new CharSource$EmptyCharSource();

   private CharSource$EmptyCharSource() {
      super("");
   }

   public String toString() {
      return "CharSource.empty()";
   }

   // $FF: synthetic method
   static CharSource$EmptyCharSource access$000() {
      return INSTANCE;
   }
}
