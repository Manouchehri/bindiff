package com.google.common.collect;

class PrefixTrie$Node {
   Object value;
   final PrefixTrie$Node[] next;

   PrefixTrie$Node(int var1) {
      this.next = new PrefixTrie$Node[var1];
   }
}
