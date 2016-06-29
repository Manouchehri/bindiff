package org.ibex.nestedvm;

import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable;

public abstract class Runtime$FD {
   private int refCount = 1;
   private String normalizedPath = null;
   private boolean deleteOnClose = false;
   private Runtime$FStat cachedFStat = null;

   public void setNormalizedPath(String var1) {
      this.normalizedPath = var1;
   }

   public String getNormalizedPath() {
      return this.normalizedPath;
   }

   public void markDeleteOnClose() {
      this.deleteOnClose = true;
   }

   public boolean isMarkedForDeleteOnClose() {
      return this.deleteOnClose;
   }

   public int read(byte[] var1, int var2, int var3) {
      throw new Runtime$ErrnoException(81);
   }

   public int write(byte[] var1, int var2, int var3) {
      throw new Runtime$ErrnoException(81);
   }

   public int seek(int var1, int var2) {
      return -1;
   }

   public int getdents(byte[] var1, int var2, int var3) {
      throw new Runtime$ErrnoException(81);
   }

   Seekable seekable() {
      return null;
   }

   public final Runtime$FStat fstat() {
      if(this.cachedFStat == null) {
         this.cachedFStat = this._fstat();
      }

      return this.cachedFStat;
   }

   protected abstract Runtime$FStat _fstat();

   public abstract int flags();

   public final void close() {
      if(--this.refCount == 0) {
         this._close();
      }

   }

   protected void _close() {
   }

   Runtime$FD dup() {
      ++this.refCount;
      return this;
   }
}
