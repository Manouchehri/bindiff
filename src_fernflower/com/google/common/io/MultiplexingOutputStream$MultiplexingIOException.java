package com.google.common.io;

import com.google.common.base.Joiner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MultiplexingOutputStream$MultiplexingIOException extends IOException {
   private final List exceptions;

   public MultiplexingOutputStream$MultiplexingIOException(List var1) {
      super(getComponentMessages(var1));
      this.exceptions = Collections.unmodifiableList(var1);
   }

   public List getCauses() {
      return this.exceptions;
   }

   private static String getComponentMessages(List var0) {
      // $FF: Couldn't be decompiled
   }
}
