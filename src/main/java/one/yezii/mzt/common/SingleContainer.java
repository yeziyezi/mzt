package one.yezii.mzt.common;

public class SingleContainer<T> {
    private T data;

    public void put(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}
