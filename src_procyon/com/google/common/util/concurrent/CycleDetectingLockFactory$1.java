package com.google.common.util.concurrent;

import java.util.*;
import com.google.common.collect.*;

final class CycleDetectingLockFactory$1 extends ThreadLocal
{
    @Override
    protected ArrayList initialValue() {
        return Lists.newArrayListWithCapacity(3);
    }
}
