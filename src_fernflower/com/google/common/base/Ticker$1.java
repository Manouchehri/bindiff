package com.google.common.base;

import com.google.common.base.Platform;
import com.google.common.base.Ticker;

final class Ticker$1 extends Ticker {
   public long read() {
      return Platform.systemNanoTime();
   }
}
