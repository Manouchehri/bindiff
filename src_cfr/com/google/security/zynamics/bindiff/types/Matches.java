/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.types;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Matches {
    private final Table store = HashBasedTable.create();

    public Matches(List list) {
        Iterator iterator = ((List)Preconditions.checkNotNull(list)).iterator();
        while (iterator.hasNext()) {
            IAddressPair iAddressPair = (IAddressPair)iterator.next();
            this.put(iAddressPair);
        }
    }

    public void put(IAddressPair iAddressPair) {
        if (this.store.put(iAddressPair.getAddress(ESide.PRIMARY), iAddressPair.getAddress(ESide.SECONDARY), iAddressPair) == null) return;
        throw new IllegalArgumentException("Attempt to insert duplicate basic block match");
    }

    public IAddressPair remove(IAddress iAddress, IAddress iAddress2) {
        return (IAddressPair)this.store.remove(iAddress.toLong(), iAddress2.toLong());
    }

    public void clear() {
        this.store.clear();
    }

    public int size() {
        return this.store.size();
    }

    public IAddressPair get(IAddress iAddress, ESide eSide) {
        long l2 = iAddress.toLong();
        Map map = ESide.PRIMARY.equals((Object)eSide) ? this.store.row(l2) : this.store.column(l2);
        Collection collection = map.values();
        if (collection.isEmpty()) return null;
        IAddressPair iAddressPair = (IAddressPair)collection.iterator().next();
        return iAddressPair;
    }

    public Collection getMatches() {
        return Collections.unmodifiableCollection(this.store.values());
    }
}

