package com.google.security.zynamics.bindiff.types;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class AddressPairComparator implements Comparator
{
    final ESide sortBySide;
    
    public AddressPairComparator(final ESide sortBySide) {
        this.sortBySide = sortBySide;
    }
    
    public int compare(final Pair pair, final Pair pair2) {
        return ((Comparable<IAddress>)((this.sortBySide == ESide.PRIMARY) ? pair.first() : ((IAddress)pair.second()))).compareTo((this.sortBySide == ESide.PRIMARY) ? ((IAddress)pair2.first()) : ((IAddress)pair2.second()));
    }
}
