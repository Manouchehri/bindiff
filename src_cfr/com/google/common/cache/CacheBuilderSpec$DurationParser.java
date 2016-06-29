/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.cache.CacheBuilderSpec$ValueParser;
import java.util.concurrent.TimeUnit;

abstract class CacheBuilderSpec$DurationParser
implements CacheBuilderSpec$ValueParser {
    CacheBuilderSpec$DurationParser() {
    }

    protected abstract void parseDuration(CacheBuilderSpec var1, long var2, TimeUnit var4);

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void parse(CacheBuilderSpec var1_1, String var2_2, String var3_3) {
        Preconditions.checkArgument(var3_3 != null && var3_3.isEmpty() == false, "value of key %s omitted", new Object[]{var2_2});
        try {
            var4_4 = var3_3.charAt(var3_3.length() - 1);
            switch (var4_4) {
                case 'd': {
                    var5_6 = TimeUnit.DAYS;
                    ** break;
                }
                case 'h': {
                    var5_6 = TimeUnit.HOURS;
                    ** break;
                }
                case 'm': {
                    var5_6 = TimeUnit.MINUTES;
                    ** break;
                }
                case 's': {
                    var5_6 = TimeUnit.SECONDS;
                    ** break;
                }
            }
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[]{var2_2, var3_3}));
lbl18: // 4 sources:
            var6_7 = Long.parseLong(var3_3.substring(0, var3_3.length() - 1));
            this.parseDuration(var1_1, var6_7, var5_6);
            return;
        }
        catch (NumberFormatException var4_5) {
            throw new IllegalArgumentException(CacheBuilderSpec.access$000("key %s value set to %s, must be integer", new Object[]{var2_2, var3_3}));
        }
    }
}

