package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.locks.*;

final class Striped$1 implements Supplier
{
    @Override
    public Lock get() {
        return new Striped$PaddedLock();
    }
}
