package com.google.common.collect;

import com.google.common.base.*;

enum MapConstraints$NotNullMapConstraint implements MapConstraint
{
    INSTANCE("INSTANCE", 0);
    
    private MapConstraints$NotNullMapConstraint(final String s, final int n) {
    }
    
    @Override
    public void checkKeyValue(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
    }
    
    @Override
    public String toString() {
        return "Not null";
    }
}
