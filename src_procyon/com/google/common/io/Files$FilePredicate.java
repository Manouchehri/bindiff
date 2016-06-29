package com.google.common.io;

import com.google.common.base.*;

enum Files$FilePredicate implements Predicate
{
    IS_DIRECTORY("IS_DIRECTORY", 0), 
    IS_FILE("IS_FILE", 1);
    
    private Files$FilePredicate(final String s, final int n) {
    }
}
