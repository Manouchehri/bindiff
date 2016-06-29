package com.google.common.io;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream;
import java.io.InputStream;

class FileBackedOutputStream$1 extends ByteSource {
   // $FF: synthetic field
   final FileBackedOutputStream this$0;

   FileBackedOutputStream$1(FileBackedOutputStream var1) {
      this.this$0 = var1;
   }

   public InputStream openStream() {
      return FileBackedOutputStream.access$100(this.this$0);
   }

   protected void finalize() {
      try {
         this.this$0.reset();
      } catch (Throwable var2) {
         var2.printStackTrace(System.err);
      }

   }
}
