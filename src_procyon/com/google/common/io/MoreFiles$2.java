package com.google.common.io;

import com.google.common.base.*;
import java.nio.file.*;
import java.util.*;

final class MoreFiles$2 implements Predicate
{
    final /* synthetic */ LinkOption[] val$optionsCopy;
    
    MoreFiles$2(final LinkOption[] val$optionsCopy) {
        this.val$optionsCopy = val$optionsCopy;
    }
    
    public boolean apply(final Path path) {
        return Files.isRegularFile(path, this.val$optionsCopy);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(Arrays.toString(this.val$optionsCopy));
        return new StringBuilder(25 + String.valueOf(value).length()).append("MoreFiles.isRegularFile(").append(value).append(")").toString();
    }
}
