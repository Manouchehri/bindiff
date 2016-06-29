/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedList;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Synchronized$SynchronizedRandomAccessList
extends Synchronized$SynchronizedList
implements RandomAccess {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedRandomAccessList(List list, @Nullable Object object) {
        super(list, object);
    }
}

