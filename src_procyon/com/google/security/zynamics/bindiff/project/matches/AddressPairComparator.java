package com.google.security.zynamics.bindiff.project.matches;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class AddressPairComparator implements Comparator
{
    final ESide sortBySide;
    
    public AddressPairComparator(final ESide sortBySide) {
        this.sortBySide = sortBySide;
    }
    
    public int compare(final IAddressPair addressPair, final IAddressPair addressPair2) {
        return CAddress.compare(addressPair.getAddress(this.sortBySide), addressPair2.getAddress(this.sortBySide));
    }
}
