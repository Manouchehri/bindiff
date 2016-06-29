package com.google.common.io;

import java.util.zip.*;
import com.google.common.collect.*;
import java.util.*;

final class ZipFiles$1 extends FluentIterable
{
    final /* synthetic */ ZipFile val$file;
    
    ZipFiles$1(final ZipFile val$file) {
        this.val$file = val$file;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.forEnumeration(this.val$file.entries());
    }
}
