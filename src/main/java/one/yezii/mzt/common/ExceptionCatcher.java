package one.yezii.mzt.common;

public class ExceptionCatcher {
    public static void catchIt(ExceptionProducer exceptionProducer) {
        try {
            exceptionProducer.doIt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
