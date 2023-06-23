package com.tw.minispring.core.convert.converter;

import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/23 2:13 下午
 */
public interface GenericConverter {

    Set<ConvertiblePair> getConvertibleTypes();

    Object convert(Object source, Class sourceType, Class targetType);

    final class ConvertiblePair {

        private final Class<?> sourceType;

        private final Class<?> targetType;

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return this.sourceType;
        }

        public Class<?> getTargetType() {
            return this.targetType;
        }

        @Override
        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || obj.getClass() != ConvertiblePair.class) return false;
            ConvertiblePair that = (ConvertiblePair) obj;
            return this.sourceType.equals(that.sourceType) && this.targetType.equals(that.targetType);
        }
    }
}
