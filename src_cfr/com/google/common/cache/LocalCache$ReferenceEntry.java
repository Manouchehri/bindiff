/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import javax.annotation.Nullable;

interface LocalCache$ReferenceEntry {
    public LocalCache$ValueReference getValueReference();

    public void setValueReference(LocalCache$ValueReference var1);

    @Nullable
    public LocalCache$ReferenceEntry getNext();

    public int getHash();

    @Nullable
    public Object getKey();

    public long getAccessTime();

    public void setAccessTime(long var1);

    public LocalCache$ReferenceEntry getNextInAccessQueue();

    public void setNextInAccessQueue(LocalCache$ReferenceEntry var1);

    public LocalCache$ReferenceEntry getPreviousInAccessQueue();

    public void setPreviousInAccessQueue(LocalCache$ReferenceEntry var1);

    public long getWriteTime();

    public void setWriteTime(long var1);

    public LocalCache$ReferenceEntry getNextInWriteQueue();

    public void setNextInWriteQueue(LocalCache$ReferenceEntry var1);

    public LocalCache$ReferenceEntry getPreviousInWriteQueue();

    public void setPreviousInWriteQueue(LocalCache$ReferenceEntry var1);
}

