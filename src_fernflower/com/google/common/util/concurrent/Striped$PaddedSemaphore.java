package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;

class Striped$PaddedSemaphore extends Semaphore {
   long q1;
   long q2;
   long q3;

   Striped$PaddedSemaphore(int var1) {
      super(var1, false);
   }
}
