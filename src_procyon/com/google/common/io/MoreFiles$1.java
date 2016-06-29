package com.google.common.io;

import com.google.common.base.*;
import java.nio.file.*;
import java.util.*;

final class MoreFiles$1 implements Predicate
{
    final /* synthetic */ LinkOption[] val$optionsCopy;
    
    MoreFiles$1(final LinkOption[] val$optionsCopy) {
        this.val$optionsCopy = val$optionsCopy;
    }
    
    public boolean apply(final Path path) {
        return Files.isDirectory(path, this.val$optionsCopy);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(Arrays.toString(this.val$optionsCopy));
        return new StringBuilder(23 + String.valueOf(value).length()).append("MoreFiles.isDirectory(").append(value).append(")").toString();
    }
}
