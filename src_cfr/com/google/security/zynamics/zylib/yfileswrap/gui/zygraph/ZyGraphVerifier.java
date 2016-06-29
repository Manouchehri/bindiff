/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import y.c.q;
import y.h.bu;

public class ZyGraphVerifier {
    public static void verifyMap(bu bu2, HashMap hashMap) {
        int n2 = bu2.f();
        int n3 = hashMap.size();
        Preconditions.checkArgument(bu2.f() <= hashMap.size(), new StringBuilder(98).append("Error: Invalid node map (Graph contains ").append(n2).append(" nodes while nodeMap contains ").append(n3).append(" nodes").toString());
        HashSet<q> hashSet = new HashSet<q>();
        HashSet hashSet2 = new HashSet();
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            q q2 = (q)entry.getKey();
            Object v2 = entry.getValue();
            Preconditions.checkArgument(q2 != null && v2 != null, "Error: Invalid node map");
            Preconditions.checkArgument(!hashSet.contains(q2), "Error: Invalid node map");
            Preconditions.checkArgument(!hashSet2.contains(v2), "Error: Invalid node map");
            hashSet.add(q2);
            hashSet2.add(v2);
        }
    }
}

