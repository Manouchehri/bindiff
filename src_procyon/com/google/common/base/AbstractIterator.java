package com.google.common.base;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
abstract class AbstractIterator implements Iterator
{
    private AbstractIterator$State state;
    private Object next;
    
    protected AbstractIterator() {
        this.state = AbstractIterator$State.NOT_READY;
    }
    
    protected abstract Object computeNext();
    
    protected final Object endOfData() {
        this.state = AbstractIterator$State.DONE;
        return null;
    }
    
    @Override
    public final boolean hasNext() {
        Preconditions.checkState(this.state != AbstractIterator$State.FAILED);
        switch (AbstractIterator$1.$SwitchMap$com$google$common$base$AbstractIterator$State[this.state.ordinal()]) {
            case 1: {
                return true;
            }
            case 2: {
                return false;
            }
            default: {
                return this.tryToComputeNext();
            }
        }
    }
    
    private boolean tryToComputeNext() {
        this.state = AbstractIterator$State.FAILED;
        this.next = this.computeNext();
        if (this.state != AbstractIterator$State.DONE) {
            this.state = AbstractIterator$State.READY;
            return true;
        }
        return false;
    }
    
    @Override
    public final Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = AbstractIterator$State.NOT_READY;
        final Object next = this.next;
        this.next = null;
        return next;
    }
    
    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
