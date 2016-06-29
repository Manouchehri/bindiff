package com.google.common.base;

enum AbstractIterator$State
{
    READY("READY", 0), 
    NOT_READY("NOT_READY", 1), 
    DONE("DONE", 2), 
    FAILED("FAILED", 3);
    
    private AbstractIterator$State(final String s, final int n) {
    }
}
