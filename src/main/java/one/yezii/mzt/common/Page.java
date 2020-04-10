package one.yezii.mzt.common;

public class Page {
    private boolean current;
    private boolean exist;
    private int num;
    private String url;

    public boolean isCurrent() {
        return current;
    }

    public Page setCurrent(boolean current) {
        this.current = current;
        return this;
    }

    public boolean isExist() {
        return exist;
    }

    public Page setExist(boolean exist) {
        this.exist = exist;
        return this;
    }

    public int getNum() {
        return num;
    }

    public Page setNum(int num) {
        this.num = num;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Page setUrl(String url) {
        this.url = url;
        return this;
    }
}
