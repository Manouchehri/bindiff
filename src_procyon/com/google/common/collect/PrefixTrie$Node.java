package com.google.common.collect;

class PrefixTrie$Node
{
    Object value;
    final PrefixTrie$Node[] next;
    
    PrefixTrie$Node(final int n) {
        this.next = new PrefixTrie$Node[n];
    }
}
