package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class Funnels$SequentialFunnel implements Funnel, Serializable
{
    private final Funnel elementFunnel;
    
    Funnels$SequentialFunnel(final Funnel funnel) {
        this.elementFunnel = (Funnel)Preconditions.checkNotNull(funnel);
    }
    
    public void funnel(final Iterable iterable, final PrimitiveSink primitiveSink) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.elementFunnel.funnel(iterator.next(), primitiveSink);
        }
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.elementFunnel);
        return new StringBuilder(26 + String.valueOf(value).length()).append("Funnels.sequentialFunnel(").append(value).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Funnels$SequentialFunnel && this.elementFunnel.equals(((Funnels$SequentialFunnel)o).elementFunnel);
    }
    
    @Override
    public int hashCode() {
        return Funnels$SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }
}
