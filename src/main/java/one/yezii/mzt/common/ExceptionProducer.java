package one.yezii.mzt.common;

@FunctionalInterface
public interface ExceptionProducer {
    void doIt() throws Exception;
}
