/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

class PrefixTrie$Node {
    Object value;
    final PrefixTrie$Node[] next;

    PrefixTrie$Node(int n2) {
        this.next = new PrefixTrie$Node[n2];
    }
}

