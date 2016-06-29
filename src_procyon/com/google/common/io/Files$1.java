package com.google.common.io;

import java.util.*;
import com.google.common.collect.*;

final class Files$1 implements LineProcessor
{
    final List result;
    
    Files$1() {
        this.result = Lists.newArrayList();
    }
    
    @Override
    public boolean processLine(final String s) {
        this.result.add(s);
        return true;
    }
    
    @Override
    public List getResult() {
        return this.result;
    }
}
