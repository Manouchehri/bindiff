package com.google.common.collect;

import java.util.*;

class Constraints$ConstrainedRandomAccessList extends Constraints$ConstrainedList implements RandomAccess
{
    Constraints$ConstrainedRandomAccessList(final List list, final Constraint constraint) {
        super(list, constraint);
    }
}
