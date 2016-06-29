package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Functions$ConstantFunction implements Function, Serializable
{
    private final Object value;
    private static final long serialVersionUID = 0L;
    
    public Functions$ConstantFunction(@Nullable final Object value) {
        this.value = value;
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        return this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Functions$ConstantFunction && Objects.equal(this.value, ((Functions$ConstantFunction)o).value);
    }
    
    @Override
    public int hashCode() {
        return (this.value == null) ? 0 : this.value.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.value);
        return new StringBuilder(20 + String.valueOf(value).length()).append("Functions.constant(").append(value).append(")").toString();
    }
}
