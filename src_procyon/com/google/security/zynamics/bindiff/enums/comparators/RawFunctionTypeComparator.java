package com.google.security.zynamics.bindiff.enums.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;

public class RawFunctionTypeComparator implements Comparator
{
    public int compare(final EFunctionType eFunctionType, final EFunctionType eFunctionType2) {
        return EFunctionType.getOrdinal(eFunctionType) - EFunctionType.getOrdinal(eFunctionType2);
    }
}
