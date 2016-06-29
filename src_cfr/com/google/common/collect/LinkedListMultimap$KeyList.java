/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap$Node;

class LinkedListMultimap$KeyList {
    LinkedListMultimap$Node head;
    LinkedListMultimap$Node tail;
    int count;

    LinkedListMultimap$KeyList(LinkedListMultimap$Node linkedListMultimap$Node) {
        this.head = linkedListMultimap$Node;
        this.tail = linkedListMultimap$Node;
        linkedListMultimap$Node.previousSibling = null;
        linkedListMultimap$Node.nextSibling = null;
        this.count = 1;
    }
}

