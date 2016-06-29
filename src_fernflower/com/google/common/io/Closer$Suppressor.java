package com.google.common.io;

import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;

@VisibleForTesting
interface Closer$Suppressor {
   void suppress(Closeable var1, Throwable var2, Throwable var3);
}
