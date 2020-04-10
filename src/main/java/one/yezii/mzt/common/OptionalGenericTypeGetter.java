package one.yezii.mzt.common;

import java.util.Optional;

@FunctionalInterface
public interface OptionalGenericTypeGetter<T> {
    Optional<T> get();
}
