package com.google.common.base;

import java.util.*;

class Randoms$ReadOnlyRandom extends Random
{
    private static final long serialVersionUID = 898001275432099254L;
    private boolean initializationComplete;
    
    private Randoms$ReadOnlyRandom() {
        this.initializationComplete = false;
        this.initializationComplete = true;
    }
    
    @Override
    public void setSeed(final long seed) {
        if (this.initializationComplete) {
            throw new UnsupportedOperationException("Setting the seed on the shared Random object is not permitted");
        }
        super.setSeed(seed);
    }
}
