package com.google.security.zynamics.bindiff.types;

import com.google.common.collect.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import java.util.*;

public class Matches
{
    private final Table store;
    
    public Matches(final List list) {
        this.store = HashBasedTable.create();
        final Iterator<IAddressPair> iterator = ((List)Preconditions.checkNotNull(list)).iterator();
        while (iterator.hasNext()) {
            this.put(iterator.next());
        }
    }
    
    public void put(final IAddressPair addressPair) {
        if (this.store.put(addressPair.getAddress(ESide.PRIMARY), addressPair.getAddress(ESide.SECONDARY), addressPair) != null) {
            throw new IllegalArgumentException("Attempt to insert duplicate basic block match");
        }
    }
    
    public IAddressPair remove(final IAddress address, final IAddress address2) {
        return (IAddressPair)this.store.remove(address.toLong(), address2.toLong());
    }
    
    public void clear() {
        this.store.clear();
    }
    
    public int size() {
        return this.store.size();
    }
    
    public IAddressPair get(final IAddress address, final ESide eSide) {
        final long long1 = address.toLong();
        final Collection values = (ESide.PRIMARY.equals(eSide) ? this.store.row(long1) : this.store.column(long1)).values();
        return values.isEmpty() ? null : values.iterator().next();
    }
    
    public Collection getMatches() {
        return Collections.unmodifiableCollection((Collection<?>)this.store.values());
    }
}
