package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
public abstract class AbstractIterator extends UnmodifiableIterator
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
        switch (AbstractIterator$1.$SwitchMap$com$google$common$collect$AbstractIterator$State[this.state.ordinal()]) {
            case 1: {
                return false;
            }
            case 2: {
                return true;
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
    
    public final Object peek() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.next;
    }
}
