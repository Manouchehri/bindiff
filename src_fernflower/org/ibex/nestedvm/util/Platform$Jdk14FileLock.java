package org.ibex.nestedvm.util;

import java.nio.channels.FileLock;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

final class Platform$Jdk14FileLock extends Seekable$Lock {
   private final Seekable s;
   private final FileLock l;

   Platform$Jdk14FileLock(Seekable var1, FileLock var2) {
      this.s = var1;
      this.l = var2;
   }

   public Seekable seekable() {
      return this.s;
   }

   public boolean isShared() {
      return this.l.isShared();
   }

   public boolean isValid() {
      return this.l.isValid();
   }

   public void release() {
      this.l.release();
   }

   public long position() {
      return this.l.position();
   }

   public long size() {
      return this.l.size();
   }

   public String toString() {
      return this.l.toString();
   }
}
