/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.AbstractIterator$1;
import com.google.common.base.AbstractIterator$State;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIterator
implements Iterator {
    private AbstractIterator$State state = AbstractIterator$State.NOT_READY;
    private Object next;

    protected AbstractIterator() {
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
        }
        return this.tryToComputeNext();
    }

    private boolean tryToComputeNext() {
        this.state = AbstractIterator$State.FAILED;
        this.next = this.computeNext();
        if (this.state == AbstractIterator$State.DONE) return false;
        this.state = AbstractIterator$State.READY;
        return true;
    }

    public final Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = AbstractIterator$State.NOT_READY;
        Object object = this.next;
        this.next = null;
        return object;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

