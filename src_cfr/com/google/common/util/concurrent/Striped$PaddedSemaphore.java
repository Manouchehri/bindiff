/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Semaphore;

class Striped$PaddedSemaphore
extends Semaphore {
    long q1;
    long q2;
    long q3;

    Striped$PaddedSemaphore(int n2) {
        super(n2, false);
    }
}

