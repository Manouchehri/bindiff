/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class BackDoorsForLabs$BadAbstractMultiset
extends AbstractMultiset {
    @Override
    protected abstract Iterator entryIterator();

    @Override
    protected abstract int distinctElements();
}

