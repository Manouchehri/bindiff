package com.google.common.collect;

import com.google.common.base.*;

class MapConstraints$InverseConstraint implements MapConstraint
{
    final MapConstraint constraint;
    
    public MapConstraints$InverseConstraint(final MapConstraint mapConstraint) {
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }
    
    @Override
    public void checkKeyValue(final Object o, final Object o2) {
        this.constraint.checkKeyValue(o2, o);
    }
}
