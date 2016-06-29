package com.google.common.math;

import com.google.common.primitives.*;
import com.google.common.base.*;
import java.math.*;
import java.util.*;
import com.google.common.annotations.*;

public final class Quantiles$ScaleAndIndexes
{
    private final int scale;
    private final int[] indexes;
    
    private Quantiles$ScaleAndIndexes(final int scale, final int[] indexes) {
        for (int length = indexes.length, i = 0; i < length; ++i) {
            checkIndex(indexes[i], scale);
        }
        this.scale = scale;
        this.indexes = indexes;
    }
    
    public Map compute(final Collection collection) {
        return this.computeInPlace(Doubles.toArray(collection));
    }
    
    public Map compute(final double... array) {
        return this.computeInPlace((double[])array.clone());
    }
    
    public Map compute(final long... array) {
        return this.computeInPlace(longsToDoubles(array));
    }
    
    public Map compute(final int... array) {
        return this.computeInPlace(intsToDoubles(array));
    }
    
    public Map computeInPlace(final double... array) {
        Preconditions.checkArgument(array.length > 0, (Object)"Cannot calculate quantiles of an empty dataset");
        final int[] array2 = new int[this.indexes.length];
        final int[] array3 = new int[this.indexes.length];
        final int[] array4 = new int[this.indexes.length * 2];
        int n = 0;
        for (int i = 0; i < this.indexes.length; ++i) {
            final long n2 = this.indexes[i] * (array.length - 1);
            final int n3 = (int)LongMath.divide(n2, this.scale, RoundingMode.DOWN);
            final int n4 = (int)(n2 - n3 * this.scale);
            array2[i] = n3;
            array3[i] = n4;
            array4[n] = n3;
            ++n;
            if (n4 != 0) {
                array4[n] = n3 + 1;
                ++n;
            }
        }
        Arrays.sort(array4, 0, n);
        selectAllInPlace(array4, 0, n - 1, array, 0, array.length - 1);
        final HashMap<Integer, Double> hashMap = new HashMap<Integer, Double>();
        for (int j = 0; j < this.indexes.length; ++j) {
            final int n5 = array2[j];
            final int n6 = array3[j];
            if (n6 == 0) {
                hashMap.put(this.indexes[j], array[n5]);
            }
            else {
                hashMap.put(this.indexes[j], array[n5] + n6 / this.scale * (array[n5 + 1] - array[n5]));
            }
        }
        return Collections.unmodifiableMap((Map<?, ?>)hashMap);
    }
}
