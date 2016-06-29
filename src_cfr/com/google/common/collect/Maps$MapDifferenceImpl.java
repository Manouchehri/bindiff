/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import java.util.Map;

class Maps$MapDifferenceImpl
implements MapDifference {
    final Map onlyOnLeft;
    final Map onlyOnRight;
    final Map onBoth;
    final Map differences;

    Maps$MapDifferenceImpl(Map map, Map map2, Map map3, Map map4) {
        this.onlyOnLeft = Maps.access$100(map);
        this.onlyOnRight = Maps.access$100(map2);
        this.onBoth = Maps.access$100(map3);
        this.differences = Maps.access$100(map4);
    }

    @Override
    public boolean areEqual() {
        if (!this.onlyOnLeft.isEmpty()) return false;
        if (!this.onlyOnRight.isEmpty()) return false;
        if (!this.differences.isEmpty()) return false;
        return true;
    }

    @Override
    public Map entriesOnlyOnLeft() {
        return this.onlyOnLeft;
    }

    @Override
    public Map entriesOnlyOnRight() {
        return this.onlyOnRight;
    }

    @Override
    public Map entriesInCommon() {
        return this.onBoth;
    }

    @Override
    public Map entriesDiffering() {
        return this.differences;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MapDifference)) return false;
        MapDifference mapDifference = (MapDifference)object;
        if (!this.entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft())) return false;
        if (!this.entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight())) return false;
        if (!this.entriesInCommon().equals(mapDifference.entriesInCommon())) return false;
        if (!this.entriesDiffering().equals(mapDifference.entriesDiffering())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.entriesOnlyOnLeft(), this.entriesOnlyOnRight(), this.entriesInCommon(), this.entriesDiffering());
    }

    public String toString() {
        if (this.areEqual()) {
            return "equal";
        }
        StringBuilder stringBuilder = new StringBuilder("not equal");
        if (!this.onlyOnLeft.isEmpty()) {
            stringBuilder.append(": only on left=").append(this.onlyOnLeft);
        }
        if (!this.onlyOnRight.isEmpty()) {
            stringBuilder.append(": only on right=").append(this.onlyOnRight);
        }
        if (this.differences.isEmpty()) return stringBuilder.toString();
        stringBuilder.append(": value differences=").append(this.differences);
        return stringBuilder.toString();
    }
}

