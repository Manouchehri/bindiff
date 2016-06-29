package com.google.security.zynamics.zylib.general;

import java.lang.ref.*;

public class ListenerProvider$ComparableReference extends WeakReference
{
    final /* synthetic */ ListenerProvider this$0;
    
    public ListenerProvider$ComparableReference(final ListenerProvider this$0, final Object o) {
        this.this$0 = this$0;
        super(o);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        final ListenerProvider$ComparableReference listenerProvider$ComparableReference = (ListenerProvider$ComparableReference)o;
        final Object value = this.get();
        final Object value2 = listenerProvider$ComparableReference.get();
        return (value == null && value2 == null) || (value != null && value2 != null && value.equals(value2));
    }
    
    @Override
    public int hashCode() {
        final Object value = this.get();
        return (value == null) ? 0 : value.hashCode();
    }
}
