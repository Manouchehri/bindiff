package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Functions$FunctionComposition implements Function, Serializable
{
    private final Function g;
    private final Function f;
    private static final long serialVersionUID = 0L;
    
    public Functions$FunctionComposition(final Function function, final Function function2) {
        this.g = (Function)Preconditions.checkNotNull(function);
        this.f = (Function)Preconditions.checkNotNull(function2);
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        return this.g.apply(this.f.apply(o));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Functions$FunctionComposition) {
            final Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition)o;
            return this.f.equals(functions$FunctionComposition.f) && this.g.equals(functions$FunctionComposition.g);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.f.hashCode() ^ this.g.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.g);
        final String value2 = String.valueOf(this.f);
        return new StringBuilder(2 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append("(").append(value2).append(")").toString();
    }
}
