/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

final class CharMatcher$ForPredicate
extends CharMatcher {
    private final Predicate predicate;

    CharMatcher$ForPredicate(Predicate predicate) {
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public boolean matches(char c2) {
        return this.predicate.apply(Character.valueOf(c2));
    }

    @Override
    public boolean apply(Character c2) {
        return this.predicate.apply(Preconditions.checkNotNull(c2));
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.predicate);
        return new StringBuilder(26 + String.valueOf(string).length()).append("CharMatcher.forPredicate(").append(string).append(")").toString();
    }
}

