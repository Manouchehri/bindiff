/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterators;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class ZipFiles$1
extends FluentIterable {
    final /* synthetic */ ZipFile val$file;

    ZipFiles$1(ZipFile zipFile) {
        this.val$file = zipFile;
    }

    public Iterator iterator() {
        return Iterators.forEnumeration(this.val$file.entries());
    }
}

