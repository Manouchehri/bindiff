package com.google.common.collect;

import com.google.common.collect.Lists$Partition;
import java.util.List;
import java.util.RandomAccess;

class Lists$RandomAccessPartition extends Lists$Partition implements RandomAccess {
   Lists$RandomAccessPartition(List var1, int var2) {
      super(var1, var2);
   }
}
