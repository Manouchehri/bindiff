/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;

class Striped$PaddedLock
extends ReentrantLock {
    long q1;
    long q2;
    long q3;

    Striped$PaddedLock() {
        super(false);
    }
}

