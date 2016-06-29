package com.google.common.io;

import com.google.common.annotations.GoogleInternal;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GoogleInternal
public final class LegacyCloseables {
   private static final Logger logger = Logger.getLogger(LegacyCloseables.class.getName());

   @Deprecated
   public static void closeQuietly(@Nullable Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            logger.log(Level.WARNING, "IOException thrown while closing Closeable.", var2);
         }

      }
   }
}
