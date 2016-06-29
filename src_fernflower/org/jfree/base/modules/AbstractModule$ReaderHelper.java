package org.jfree.base.modules;

import java.io.BufferedReader;

class AbstractModule$ReaderHelper {
   private String buffer;
   private final BufferedReader reader;

   public AbstractModule$ReaderHelper(BufferedReader var1) {
      this.reader = var1;
   }

   public boolean hasNext() {
      if(this.buffer == null) {
         this.buffer = this.readLine();
      }

      return this.buffer != null;
   }

   public String next() {
      String var1 = this.buffer;
      this.buffer = null;
      return var1;
   }

   public void pushBack(String var1) {
      this.buffer = var1;
   }

   protected String readLine() {
      String var1;
      for(var1 = this.reader.readLine(); var1 != null && (var1.length() == 0 || var1.startsWith("#")); var1 = this.reader.readLine()) {
         ;
      }

      return var1;
   }

   public void close() {
      this.reader.close();
   }
}
