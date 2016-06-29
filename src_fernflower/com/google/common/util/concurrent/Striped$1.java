package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$PaddedLock;
import java.util.concurrent.locks.Lock;

final class Striped$1 implements Supplier {
   public Lock get() {
      return new Striped$PaddedLock();
   }
}
