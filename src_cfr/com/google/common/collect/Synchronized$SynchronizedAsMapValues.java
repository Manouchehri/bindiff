/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapValues
extends Synchronized$SynchronizedCollection {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedAsMapValues(Collection collection, @Nullable Object object) {
        super(collection, object, null);
    }

    @Override
    public Iterator iterator() {
        return new Synchronized$SynchronizedAsMapValues$1(this, super.iterator());
    }
}

