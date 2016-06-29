package com.google.common.collect;

class LinkedListMultimap$KeyList
{
    LinkedListMultimap$Node head;
    LinkedListMultimap$Node tail;
    int count;
    
    LinkedListMultimap$KeyList(final LinkedListMultimap$Node linkedListMultimap$Node) {
        this.head = linkedListMultimap$Node;
        this.tail = linkedListMultimap$Node;
        linkedListMultimap$Node.previousSibling = null;
        linkedListMultimap$Node.nextSibling = null;
        this.count = 1;
    }
}
