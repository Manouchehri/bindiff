package com.google.common.io;

import com.google.common.io.ByteSource;
import com.google.common.io.FileBackedOutputStream;
import java.io.InputStream;

class FileBackedOutputStream$2 extends ByteSource {
   // $FF: synthetic field
   final FileBackedOutputStream this$0;

   FileBackedOutputStream$2(FileBackedOutputStream var1) {
      this.this$0 = var1;
   }

   public InputStream openStream() {
      return FileBackedOutputStream.access$100(this.this$0);
   }
}
