package com.google.common.base;

import javax.annotation.*;
import java.util.*;

final class Receivers$CompositeReceiver implements Receiver
{
    private final List receivers;
    
    Receivers$CompositeReceiver(final Iterable iterable) {
        this.receivers = copy(iterable);
    }
    
    @Override
    public void accept(@Nullable final Object o) {
        final Iterator<Receiver> iterator = this.receivers.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(o);
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Receivers$CompositeReceiver && this.receivers.equals(((Receivers$CompositeReceiver)o).receivers);
    }
    
    @Override
    public int hashCode() {
        return this.receivers.hashCode();
    }
    
    @Override
    public String toString() {
        final String join = Joiner.on(", ").join(this.receivers);
        return new StringBuilder(19 + String.valueOf(join).length()).append("Receivers.compose(").append(join).append(")").toString();
    }
    
    private static List copy(final Iterable iterable) {
        final ArrayList<Object> list = new ArrayList<Object>();
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(Preconditions.checkNotNull(iterator.next()));
        }
        return list;
    }
}
