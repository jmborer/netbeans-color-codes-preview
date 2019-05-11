/*
 * Copyright 2019 junichi11.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.junichi11.netbeans.modules.color.codes.preview.colors;

import com.junichi11.netbeans.modules.color.codes.preview.colors.spi.AbstractColorValue;
import com.junichi11.netbeans.modules.color.codes.preview.colors.spi.ColorCodeFormatter;
import com.junichi11.netbeans.modules.color.codes.preview.utils.ColorsUtils;
import com.junichi11.netbeans.modules.color.codes.preview.utils.HexCssColorType;
import java.awt.Color;

/**
 *
 * @author junichi11
 */
abstract class HexCssColorValue extends AbstractColorValue {

    public HexCssColorValue(String value, int startOffset, int endOffset, int line) {
        super(value, startOffset, endOffset, line);
    }

    @Override
    public boolean isEditable() {
        return true;
    }

    @Override
    public ColorCodeFormatter getFormatter() {
        return new HexCssColorCodeFormatter(getType());
    }

    public abstract HexCssColorType getType();

    //~ nested classes
    private static final class HexCssColorCodeFormatter implements ColorCodeFormatter {

        private final HexCssColorType type;

        public HexCssColorCodeFormatter(HexCssColorType type) {
            this.type = type;
        }

        @Override
        public String format(Color color) {
            return ColorsUtils.toFormattedString(color, type);
        }

    }
}