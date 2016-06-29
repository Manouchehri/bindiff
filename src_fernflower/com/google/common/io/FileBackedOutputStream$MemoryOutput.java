package com.google.common.io;

import com.google.common.io.FileBackedOutputStream$1;
import java.io.ByteArrayOutputStream;

class FileBackedOutputStream$MemoryOutput extends ByteArrayOutputStream {
   private FileBackedOutputStream$MemoryOutput() {
   }

   byte[] getBuffer() {
      return this.buf;
   }

   int getCount() {
      return this.count;
   }

   // $FF: synthetic method
   FileBackedOutputStream$MemoryOutput(FileBackedOutputStream$1 var1) {
      this();
   }
}
