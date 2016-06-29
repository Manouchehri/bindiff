/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator$1;
import com.google.common.collect.AbstractIterator$State;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class AbstractIterator
extends UnmodifiableIterator {
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
        switch (AbstractIterator$1.$SwitchMap$com$google$common$collect$AbstractIterator$State[this.state.ordinal()]) {
            case 1: {
                return false;
            }
            case 2: {
                return true;
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

    public final Object peek() {
        if (this.hasNext()) return this.next;
        throw new NoSuchElementException();
    }
}

