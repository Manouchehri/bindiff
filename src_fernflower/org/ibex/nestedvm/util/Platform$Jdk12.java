package org.ibex.nestedvm.util;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Platform$Jdk11;

class Platform$Jdk12 extends Platform$Jdk11 {
   boolean _atomicCreateFile(File var1) {
      return var1.createNewFile();
   }

   String _timeZoneGetDisplayName(TimeZone var1, boolean var2, boolean var3, Locale var4) {
      return var1.getDisplayName(var2, var3?1:0, var4);
   }

   void _setFileLength(RandomAccessFile var1, int var2) {
      var1.setLength((long)var2);
   }

   File[] _listRoots() {
      return File.listRoots();
   }
}
