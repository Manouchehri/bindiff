/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$1EntriesImpl;
import com.google.common.collect.LinkedListMultimap$1KeySetImpl;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$Node;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multiset;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public class LinkedListMultimap
extends AbstractMultimap
implements ListMultimap,
Serializable {
    private transient LinkedListMultimap$Node head;
    private transient LinkedListMultimap$Node tail;
    private transient Map keyToKeyList;
    private transient int size;
    private transient int modCount;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 0;

    public static LinkedListMultimap create() {
        return new LinkedListMultimap();
    }

    public static LinkedListMultimap create(int n2) {
        return new LinkedListMultimap(n2);
    }

    public static LinkedListMultimap create(Multimap multimap) {
        return new LinkedListMultimap(multimap);
    }

    LinkedListMultimap() {
        this.keyToKeyList = Maps.newHashMap();
    }

    private LinkedListMultimap(int n2) {
        this.keyToKeyList = new HashMap(n2);
    }

    private LinkedListMultimap(Multimap multimap) {
        this(multimap.keySet().size());
        this.putAll(multimap);
    }

    private LinkedListMultimap$Node addNode(@Nullable Object object, @Nullable Object object2, @Nullable LinkedListMultimap$Node linkedListMultimap$Node) {
        LinkedListMultimap$Node linkedListMultimap$Node2 = new LinkedListMultimap$Node(object, object2);
        if (this.head == null) {
            this.head = this.tail = linkedListMultimap$Node2;
            this.keyToKeyList.put(object, new LinkedListMultimap$KeyList(linkedListMultimap$Node2));
            ++this.modCount;
        } else if (linkedListMultimap$Node == null) {
            this.tail.next = linkedListMultimap$Node2;
            linkedListMultimap$Node2.previous = this.tail;
            this.tail = linkedListMultimap$Node2;
            LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)this.keyToKeyList.get(object);
            if (linkedListMultimap$KeyList == null) {
                linkedListMultimap$KeyList = new LinkedListMultimap$KeyList(linkedListMultimap$Node2);
                this.keyToKeyList.put(object, linkedListMultimap$KeyList);
                ++this.modCount;
            } else {
                ++linkedListMultimap$KeyList.count;
                LinkedListMultimap$Node linkedListMultimap$Node3 = linkedListMultimap$KeyList.tail;
                linkedListMultimap$Node3.nextSibling = linkedListMultimap$Node2;
                linkedListMultimap$Node2.previousSibling = linkedListMultimap$Node3;
                linkedListMultimap$KeyList.tail = linkedListMultimap$Node2;
            }
        } else {
            LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)this.keyToKeyList.get(object);
            ++linkedListMultimap$KeyList.count;
            linkedListMultimap$Node2.previous = linkedListMultimap$Node.previous;
            linkedListMultimap$Node2.previousSibling = linkedListMultimap$Node.previousSibling;
            linkedListMultimap$Node2.next = linkedListMultimap$Node;
            linkedListMultimap$Node2.nextSibling = linkedListMultimap$Node;
            if (linkedListMultimap$Node.previousSibling == null) {
                ((LinkedListMultimap$KeyList)this.keyToKeyList.get((Object)object)).head = linkedListMultimap$Node2;
            } else {
                linkedListMultimap$Node.previousSibling.nextSibling = linkedListMultimap$Node2;
            }
            if (linkedListMultimap$Node.previous == null) {
                this.head = linkedListMultimap$Node2;
            } else {
                linkedListMultimap$Node.previous.next = linkedListMultimap$Node2;
            }
            linkedListMultimap$Node.previous = linkedListMultimap$Node2;
            linkedListMultimap$Node.previousSibling = linkedListMultimap$Node2;
        }
        ++this.size;
        return linkedListMultimap$Node2;
    }

    private void removeNode(LinkedListMultimap$Node linkedListMultimap$Node) {
        if (linkedListMultimap$Node.previous != null) {
            linkedListMultimap$Node.previous.next = linkedListMultimap$Node.next;
        } else {
            this.head = linkedListMultimap$Node.next;
        }
        if (linkedListMultimap$Node.next != null) {
            linkedListMultimap$Node.next.previous = linkedListMultimap$Node.previous;
        } else {
            this.tail = linkedListMultimap$Node.previous;
        }
        if (linkedListMultimap$Node.previousSibling == null && linkedListMultimap$Node.nextSibling == null) {
            LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)this.keyToKeyList.remove(linkedListMultimap$Node.key);
            linkedListMultimap$KeyList.count = 0;
            ++this.modCount;
        } else {
            LinkedListMultimap$KeyList linkedListMultimap$KeyList = (LinkedListMultimap$KeyList)this.keyToKeyList.get(linkedListMultimap$Node.key);
            --linkedListMultimap$KeyList.count;
            if (linkedListMultimap$Node.previousSibling == null) {
                linkedListMultimap$KeyList.head = linkedListMultimap$Node.nextSibling;
            } else {
                linkedListMultimap$Node.previousSibling.nextSibling = linkedListMultimap$Node.nextSibling;
            }
            if (linkedListMultimap$Node.nextSibling == null) {
                linkedListMultimap$KeyList.tail = linkedListMultimap$Node.previousSibling;
            } else {
                linkedListMultimap$Node.nextSibling.previousSibling = linkedListMultimap$Node.previousSibling;
            }
        }
        --this.size;
    }

    private void removeAllNodes(@Nullable Object object) {
        Iterators.clear(new LinkedListMultimap$ValueForKeyIterator(this, object));
    }

    private static void checkElement(@Nullable Object object) {
        if (object != null) return;
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (this.head != null) return false;
        return true;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.keyToKeyList.containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.values().contains(object);
    }

    @Override
    public boolean put(@Nullable Object object, @Nullable Object object2) {
        this.addNode(object, object2, null);
        return true;
    }

    @Override
    public List replaceValues(@Nullable Object object, Iterable iterable) {
        List list = this.getCopy(object);
        LinkedListMultimap$ValueForKeyIterator linkedListMultimap$ValueForKeyIterator = new LinkedListMultimap$ValueForKeyIterator(this, object);
        Iterator iterator = iterable.iterator();
        while (linkedListMultimap$ValueForKeyIterator.hasNext() && iterator.hasNext()) {
            linkedListMultimap$ValueForKeyIterator.next();
            linkedListMultimap$ValueForKeyIterator.set(iterator.next());
        }
        do {
            if (!linkedListMultimap$ValueForKeyIterator.hasNext()) {
                while (iterator.hasNext()) {
                    linkedListMultimap$ValueForKeyIterator.add(iterator.next());
                }
                return list;
            }
            linkedListMultimap$ValueForKeyIterator.next();
            linkedListMultimap$ValueForKeyIterator.remove();
        } while (true);
    }

    private List getCopy(@Nullable Object object) {
        return Collections.unmodifiableList(Lists.newArrayList(new LinkedListMultimap$ValueForKeyIterator(this, object)));
    }

    @Override
    public List removeAll(@Nullable Object object) {
        List list = this.getCopy(object);
        this.removeAllNodes(object);
        return list;
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
    public List get(@Nullable Object object) {
        return new LinkedListMultimap$1(this, object);
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

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size());
        Iterator iterator = this.entries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = Maps.newLinkedHashMap();
        int n2 = objectInputStream.readInt();
        int n3 = 0;
        while (n3 < n2) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            this.put(object, object2);
            ++n3;
        }
    }

    static /* synthetic */ int access$000(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.modCount;
    }

    static /* synthetic */ LinkedListMultimap$Node access$100(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.tail;
    }

    static /* synthetic */ LinkedListMultimap$Node access$200(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.head;
    }

    static /* synthetic */ void access$300(Object object) {
        LinkedListMultimap.checkElement(object);
    }

    static /* synthetic */ void access$400(LinkedListMultimap linkedListMultimap, LinkedListMultimap$Node linkedListMultimap$Node) {
        linkedListMultimap.removeNode(linkedListMultimap$Node);
    }

    static /* synthetic */ void access$500(LinkedListMultimap linkedListMultimap, Object object) {
        linkedListMultimap.removeAllNodes(object);
    }

    static /* synthetic */ Map access$600(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.keyToKeyList;
    }

    static /* synthetic */ LinkedListMultimap$Node access$700(LinkedListMultimap linkedListMultimap, Object object, Object object2, LinkedListMultimap$Node linkedListMultimap$Node) {
        return linkedListMultimap.addNode(object, object2, linkedListMultimap$Node);
    }

    static /* synthetic */ int access$900(LinkedListMultimap linkedListMultimap) {
        return linkedListMultimap.size;
    }
}

