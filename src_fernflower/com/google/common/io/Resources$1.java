package com.google.common.io;

import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import java.util.List;

final class Resources$1 implements LineProcessor {
   final List result = Lists.newArrayList();

   public boolean processLine(String var1) {
      this.result.add(var1);
      return true;
   }

   public List getResult() {
      return this.result;
   }
}
