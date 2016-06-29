package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.locks.*;

final class Striped$5 implements Supplier
{
    @Override
    public ReadWriteLock get() {
        return new ReentrantReadWriteLock();
    }
}
