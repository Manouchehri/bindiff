package com.google.security.zynamics.bindiff.io.matches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmNameCache {
   private final List names = new ArrayList();
   private final Map nameToIndexMap = new HashMap();
   private byte lastIndex = 0;

   public String get(String var1) {
      Byte var2 = (Byte)this.nameToIndexMap.get(var1);
      if(var2 == null) {
         this.names.add(var1);
         this.nameToIndexMap.put(var1, Byte.valueOf(this.lastIndex++));
      }

      return (String)this.names.get(var2.byteValue());
   }
}
