package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public class LinkedListMultimap extends AbstractMultimap implements ListMultimap, Serializable
{
    private transient LinkedListMultimap$Node head;
    private transient LinkedListMultimap$Node tail;
    private transient Map keyToKeyList;
    private transient int size;
    private transient int modCount;
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    
    public static LinkedListMultimap create() {
        return new LinkedListMultimap();
    }
    
    public static LinkedListMultimap create(final int n) {
        return new LinkedListMultimap(n);
    }
    
    public static LinkedListMultimap create(final Multimap multimap) {
        return new LinkedListMultimap(multimap);
    }
    
    LinkedListMultimap() {
        this.keyToKeyList = Maps.newHashMap();
    }
    
    private LinkedListMultimap(final int n) {
        this.keyToKeyList = new HashMap(n);
    }
    
    private LinkedListMultimap(final Multimap multimap) {
        this(multimap.keySet().size());
        this.putAll(multimap);
    }
    
    private LinkedListMultimap$Node addNode(@Nullable final Object o, @Nullable final Object o2, @Nullable final LinkedListMultimap$Node linkedListMultimap$Node) {
        final LinkedListMultimap$Node linkedListMultimap$Node2 = new LinkedListMultimap$Node(o, o2);
        if (this.head == null) {
            final LinkedListMultimap$Node linkedListMultimap$Node3 = linkedListMultimap$Node2;
            this.tail = linkedListMultimap$Node3;
            this.head = linkedListMultimap$Node3;
            this.keyToKeyList.put(o, new LinkedListMultimap$KeyList(linkedListMultimap$Node2));
            ++this.modCount;
        }
        else if (linkedListMultimap$Node == null) {
            this.tail.next = linkedListMultimap$Node2;
            linkedListMultimap$Node2.previous = this.tail;
            this.tail = linkedListMultimap$Node2;
            final LinkedListMultimap$KeyList list = this.keyToKeyList.get(o);
            if (list == null) {
                this.keyToKeyList.put(o, new LinkedListMultimap$KeyList(linkedListMultimap$Node2));
                ++this.modCount;
            }
            else {
                final LinkedListMultimap$KeyList list2 = list;
                ++list2.count;
                final LinkedListMultimap$Node tail = list.tail;
                tail.nextSibling = linkedListMultimap$Node2;
                linkedListMultimap$Node2.previousSibling = tail;
                list.tail = linkedListMultimap$Node2;
            }
        }
        else {
            final LinkedListMultimap$KeyList list3 = this.keyToKeyList.get(o);
            ++list3.count;
            linkedListMultimap$Node2.previous = linkedListMultimap$Node.previous;
            linkedListMultimap$Node2.previousSibling = linkedListMultimap$Node.previousSibling;
            linkedListMultimap$Node2.next = linkedListMultimap$Node;
            linkedListMultimap$Node2.nextSibling = linkedListMultimap$Node;
            if (linkedListMultimap$Node.previousSibling == null) {
                this.keyToKeyList.get(o).head = linkedListMultimap$Node2;
            }
            else {
                linkedListMultimap$Node.previousSibling.nextSibling = linkedListMultimap$Node2;
            }
            if (linkedListMultimap$Node.previous == null) {
                this.head = linkedListMultimap$Node2;
            }
            else {
                linkedListMultimap$Node.previous.next = linkedListMultimap$Node2;
            }
            linkedListMultimap$Node.previous = linkedListMultimap$Node2;
            linkedListMultimap$Node.previousSibling = linkedListMultimap$Node2;
        }
        ++this.size;
        return linkedListMultimap$Node2;
    }
    
    private void removeNode(final LinkedListMultimap$Node linkedListMultimap$Node) {
        if (linkedListMultimap$Node.previous != null) {
            linkedListMultimap$Node.previous.next = linkedListMultimap$Node.next;
        }
        else {
            this.head = linkedListMultimap$Node.next;
        }
        if (linkedListMultimap$Node.next != null) {
            linkedListMultimap$Node.next.previous = linkedListMultimap$Node.previous;
        }
        else {
            this.tail = linkedListMultimap$Node.previous;
        }
        if (linkedListMultimap$Node.previousSibling == null && linkedListMultimap$Node.nextSibling == null) {
            this.keyToKeyList.remove(linkedListMultimap$Node.key).count = 0;
            ++this.modCount;
        }
        else {
            final LinkedListMultimap$KeyList list2;
            final LinkedListMultimap$KeyList list = list2 = this.keyToKeyList.get(linkedListMultimap$Node.key);
            --list2.count;
            if (linkedListMultimap$Node.previousSibling == null) {
                list.head = linkedListMultimap$Node.nextSibling;
            }
            else {
                linkedListMultimap$Node.previousSibling.nextSibling = linkedListMultimap$Node.nextSibling;
            }
            if (linkedListMultimap$Node.nextSibling == null) {
                list.tail = linkedListMultimap$Node.previousSibling;
            }
            else {
                linkedListMultimap$Node.nextSibling.previousSibling = linkedListMultimap$Node.previousSibling;
            }
        }
        --this.size;
    }
    
    private void removeAllNodes(@Nullable final Object o) {
        Iterators.clear(new LinkedListMultimap$ValueForKeyIterator(this, o));
    }
    
    private static void checkElement(@Nullable final Object o) {
        if (o == null) {
            throw new NoSuchElementException();
        }
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.keyToKeyList.containsKey(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.values().contains(o);
    }
    
    @Override
    public boolean put(@Nullable final Object o, @Nullable final Object o2) {
        this.addNode(o, o2, null);
        return true;
    }
    
    @Override
    public List replaceValues(@Nullable final Object o, final Iterable iterable) {
        final List copy = this.getCopy(o);
        final LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(this, o);
        final Iterator<Object> iterator = iterable.iterator();
        while (linkedListMultimap$ValueForKeyIterator.hasNext() && iterator.hasNext()) {
            linkedListMultimap$ValueForKeyIterator.next();
            linkedListMultimap$ValueForKeyIterator.set(iterator.next());
        }
        while (linkedListMultimap$ValueForKeyIterator.hasNext()) {
            linkedListMultimap$ValueForKeyIterator.next();
            linkedListMultimap$ValueForKeyIterator.remove();
        }
        while (iterator.hasNext()) {
            linkedListMultimap$ValueForKeyIterator.add(iterator.next());
        }
        return copy;
    }
    
    private List getCopy(@Nullable final Object o) {
        return Collections.unmodifiableList((List<?>)Lists.newArrayList(new LinkedListMultimap$ValueForKeyIterator(this, o)));
    }
    
    @Override
    public List removeAll(@Nullable final Object o) {
        final List copy = this.getCopy(o);
        this.removeAllNodes(o);
        return copy;
    }
    
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        ++this.modCount;
    }
    
    @Override
    public List get(@Nullable final Object o) {
        return new LinkedListMultimap$1(this, o);
    }
    
    @Override
    Set createKeySet() {
        return new LinkedListMultimap$1KeySetImpl(this);
    }
    
    @Override
    public List values() {
        return (List)super.values();
    }
    
    @Override
    List createValues() {
        return new LinkedListMultimap$1ValuesImpl(this);
    }
    
    @Override
    public List entries() {
        return (List)super.entries();
    }
    
    @Override
    List createEntries() {
        return new LinkedListMultimap$1EntriesImpl(this);
    }
    
    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }
    
    @Override
    Map createAsMap() {
        return new Multimaps$AsMap(this);
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        for (final Map.Entry<Object, V> entry : this.entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = Maps.newLinkedHashMap();
        for (int int1 = objectInputStream.readInt(), i = 0; i < int1; ++i) {
            this.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
}
