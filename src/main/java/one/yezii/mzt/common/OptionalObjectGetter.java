package one.yezii.mzt.common;

import java.util.Optional;

@FunctionalInterface
public interface OptionalObjectGetter {
    Optional<Object> get();
}
