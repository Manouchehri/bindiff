package org.ibex.nestedvm.util;

import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import org.ibex.nestedvm.util.Platform$Jdk13;
import org.ibex.nestedvm.util.Platform$Jdk14FileLock;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

class Platform$Jdk14 extends Platform$Jdk13 {
   InetAddress _inetAddressFromBytes(byte[] var1) {
      return InetAddress.getByAddress(var1);
   }

   Seekable$Lock _lockFile(Seekable var1, RandomAccessFile var2, long var3, long var5, boolean var7) {
      FileLock var8;
      try {
         var8 = var3 == 0L && var5 == 0L?var2.getChannel().lock():var2.getChannel().tryLock(var3, var5, var7);
      } catch (OverlappingFileLockException var10) {
         var8 = null;
      }

      return var8 == null?null:new Platform$Jdk14FileLock(var1, var8);
   }
}
