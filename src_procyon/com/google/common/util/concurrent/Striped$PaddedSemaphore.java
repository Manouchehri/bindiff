package com.google.common.util.concurrent;

import java.util.concurrent.*;

class Striped$PaddedSemaphore extends Semaphore
{
    long q1;
    long q2;
    long q3;
    
    Striped$PaddedSemaphore(final int n) {
        super(n, false);
    }
}
