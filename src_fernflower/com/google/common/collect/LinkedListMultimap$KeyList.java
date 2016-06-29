package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap$Node;

class LinkedListMultimap$KeyList {
   LinkedListMultimap$Node head;
   LinkedListMultimap$Node tail;
   int count;

   LinkedListMultimap$KeyList(LinkedListMultimap$Node var1) {
      this.head = var1;
      this.tail = var1;
      var1.previousSibling = null;
      var1.nextSibling = null;
      this.count = 1;
   }
}
