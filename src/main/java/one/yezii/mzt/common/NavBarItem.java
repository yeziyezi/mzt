package one.yezii.mzt.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum NavBarItem {
    HOME("/", "Home"),
    ABOUT("/", "About"),
    MZT("/mzt", "美图"),
    DIARY("/diary", "日记");

    private String url;
    private String label;
    private boolean isCurrent;

    NavBarItem(String url, String label) {
        this.url = url;
        this.label = label;
    }

    public static List<NavBarItem> listOfCurrent(NavBarItem current) {
        return Arrays.stream(NavBarItem.values())
//                .filter(navBarItem -> !navBarItem.equals(MZT))//这一行用来去掉导航栏显示的MZT
                .map(navBarItem -> navBarItem.setCurrent(navBarItem.equals(current)))
                .collect(Collectors.toList());
    }


    public String getUrl() {
        return url;
    }


    public String getLabel() {
        return label;
    }

    public NavBarItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public NavBarItem setCurrent(boolean current) {
        isCurrent = current;
        return this;
    }
}
