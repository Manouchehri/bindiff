package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(emulated = true)
final class SortedMultisets
{
    private static Object getElementOrThrow(final Multiset$Entry multiset$Entry) {
        if (multiset$Entry == null) {
            throw new NoSuchElementException();
        }
        return multiset$Entry.getElement();
    }
    
    private static Object getElementOrNull(@Nullable final Multiset$Entry multiset$Entry) {
        return (multiset$Entry == null) ? null : multiset$Entry.getElement();
    }
}
