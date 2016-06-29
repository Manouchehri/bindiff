package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import y.h.*;
import com.google.common.base.*;
import y.c.*;
import java.util.*;

public class ZyGraphVerifier
{
    public static void verifyMap(final bu bu, final HashMap hashMap) {
        Preconditions.checkArgument(bu.f() <= hashMap.size(), (Object)new StringBuilder(98).append("Error: Invalid node map (Graph contains ").append(bu.f()).append(" nodes while nodeMap contains ").append(hashMap.size()).append(" nodes").toString());
        final HashSet<q> set = new HashSet<q>();
        final HashSet<Object> set2 = new HashSet<Object>();
        for (final Map.Entry<q, V> entry : hashMap.entrySet()) {
            final q q = entry.getKey();
            final V value = entry.getValue();
            Preconditions.checkArgument(q != null && value != null, (Object)"Error: Invalid node map");
            Preconditions.checkArgument(!set.contains(q), (Object)"Error: Invalid node map");
            Preconditions.checkArgument(!set2.contains(value), (Object)"Error: Invalid node map");
            set.add(q);
            set2.add(value);
        }
    }
}
