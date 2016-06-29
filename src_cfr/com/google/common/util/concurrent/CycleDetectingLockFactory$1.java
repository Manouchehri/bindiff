/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Lists;
import java.util.ArrayList;

final class CycleDetectingLockFactory$1
extends ThreadLocal {
    CycleDetectingLockFactory$1() {
    }

    protected ArrayList initialValue() {
        return Lists.newArrayListWithCapacity(3);
    }
}

