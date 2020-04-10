package one.yezii.mzt.bean;

//拥有path的getter和setter方法
public interface PathAccessorOwner<T> {
    String getPath();

    T setPath(String path);
}
