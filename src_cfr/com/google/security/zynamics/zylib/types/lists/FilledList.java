/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.lists;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.lists.IFilledList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilledList
extends ArrayList
implements IFilledList {
    public FilledList() {
    }

    public FilledList(Collection collection) {
        super(collection);
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            Preconditions.checkNotNull(e2, "Error: Can not add null-elements to filled lists");
        }
    }

    @Override
    public void add(int n2, Object object) {
        Preconditions.checkNotNull(object, "Error: Can not add null-elements to filled lists");
        super.add(n2, object);
    }

    @Override
    public boolean add(Object object) {
        Preconditions.checkNotNull(object, "Error: Can not add null-elements to filled lists");
        return super.add(object);
    }

    @Override
    public boolean addAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            Preconditions.checkNotNull(e2, "Error: Can not add null-elements to filled lists");
        }
        return super.addAll(collection);
    }

    @Override
    public boolean addAll(int n2, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            Preconditions.checkNotNull(e2, "Error: Can not add null-elements to filled lists");
        }
        return super.addAll(n2, collection);
    }
}

