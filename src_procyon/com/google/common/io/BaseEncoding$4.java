package com.google.common.io;

final class BaseEncoding$4 implements Appendable
{
    int charsUntilSeparator;
    final /* synthetic */ int val$afterEveryChars;
    final /* synthetic */ Appendable val$delegate;
    final /* synthetic */ String val$separator;
    
    BaseEncoding$4(final int val$afterEveryChars, final Appendable val$delegate, final String val$separator) {
        this.val$afterEveryChars = val$afterEveryChars;
        this.val$delegate = val$delegate;
        this.val$separator = val$separator;
        this.charsUntilSeparator = this.val$afterEveryChars;
    }
    
    @Override
    public Appendable append(final char c) {
        if (this.charsUntilSeparator == 0) {
            this.val$delegate.append(this.val$separator);
            this.charsUntilSeparator = this.val$afterEveryChars;
        }
        this.val$delegate.append(c);
        --this.charsUntilSeparator;
        return this;
    }
    
    @Override
    public Appendable append(final CharSequence charSequence, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Appendable append(final CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }
}
