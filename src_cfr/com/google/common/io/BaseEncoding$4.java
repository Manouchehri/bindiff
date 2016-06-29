/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

final class BaseEncoding$4
implements Appendable {
    int charsUntilSeparator;
    final /* synthetic */ int val$afterEveryChars;
    final /* synthetic */ Appendable val$delegate;
    final /* synthetic */ String val$separator;

    BaseEncoding$4(int n2, Appendable appendable, String string) {
        this.val$afterEveryChars = n2;
        this.val$delegate = appendable;
        this.val$separator = string;
        this.charsUntilSeparator = this.val$afterEveryChars;
    }

    @Override
    public Appendable append(char c2) {
        if (this.charsUntilSeparator == 0) {
            this.val$delegate.append(this.val$separator);
            this.charsUntilSeparator = this.val$afterEveryChars;
        }
        this.val$delegate.append(c2);
        --this.charsUntilSeparator;
        return this;
    }

    @Override
    public Appendable append(CharSequence charSequence, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Appendable append(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }
}

