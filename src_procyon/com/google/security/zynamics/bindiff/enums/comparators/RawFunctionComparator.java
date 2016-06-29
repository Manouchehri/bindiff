package com.google.security.zynamics.bindiff.enums.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;

public class RawFunctionComparator implements Comparator
{
    public int compare(final RawFunction rawFunction, final RawFunction rawFunction2) {
        return rawFunction.getAddress().compareTo(rawFunction2.getAddress());
    }
}
