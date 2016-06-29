package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;

final class CycleDetectingLockFactory$1 extends ThreadLocal {
   protected ArrayList initialValue() {
      return Lists.newArrayListWithCapacity(3);
   }
}
