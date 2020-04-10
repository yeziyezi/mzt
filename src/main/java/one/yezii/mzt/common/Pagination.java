package one.yezii.mzt.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pagination {
    public static final int DEFAULT_NEED = 5;//分页组件显示页码的格子数
    public static final int DEFAULT_PAGE_SIZE = 16;//默认页数
    private Page prev = new Page().setExist(false);
    private Page next = new Page().setExist(false);
    private List<Page> list;

    public static Optional<Pagination> defaultPagination(Integer currentPage, Integer amount, IntegerStringConverter converter) {


        return Pagination.build(currentPage, amount, DEFAULT_PAGE_SIZE, DEFAULT_NEED, converter);
    }

    private static int totalPage(int total, int pageSize) {
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    //返回一个指定长度的Pagination，用于页面上分页组件赋值
    public static Optional<Pagination> build(int currentPage, int total, int pageSize, int need, IntegerStringConverter pageNumToUrl) {
        int totalPage = totalPage(total, pageSize);
        if (currentPage > totalPage || currentPage < 1) {
            return Optional.empty();
        }
        Map<String, Integer> minAndMax = minAndMax(need, currentPage, totalPage);
        Pagination pagination = new Pagination().setList(new ArrayList<>() {
        });
        IntStream.range(minAndMax.get("min"), minAndMax.get("max"))
                .mapToObj(pageNum -> new Page().setNum(pageNum).setUrl(pageNumToUrl.convert(pageNum)))
                .collect(Collectors.toList())
                .forEach(page -> {
                    int pageNum = page.getNum();
                    page.setCurrent(currentPage == pageNum).setExist(true);
                    if (currentPage - 1 == pageNum) {
                        pagination.setPrev(page.setExist(currentPage > 1));
                    } else if (currentPage + 1 == pageNum) {
                        pagination.setNext(page.setExist(currentPage < totalPage));
                    }
                    pagination.getList().add(page);
                });
        return Optional.of(pagination);
    }

    private static Map<String, Integer> minAndMax(int need, int currentPage, int maxLimit) {
        //假设当前页是5
        //理想情况，如果是need是奇数5，在当前页左边放一半右边放一半，保持对称 3 4 5 6 7 min=3 max=7
        //如果need是偶数4，左边放一半-1，右边放一半  4 5 6 7 min=4 max=7
        int minTemp = need % 2 == 0 ? currentPage - need / 2 + 1 : currentPage - need / 2;
        int maxTemp = currentPage + need / 2;
        //处理最小页码数小于1和最大页码数大于上限的情况，尽可能保证取得指定数量的页码
        //如果发现最大页数将会超过上限，在左边补上超过的数量；如果发现最小页数小于1，在右边补上
        //以上过程效果上是并行的，所以用两个temp变量保存初始值（要是有多返回值就好了）
        //补完后判断是不是又超上下限了，如果是截取之
        int min = Math.max(1, minTemp - Math.max(0, maxTemp - maxLimit));
        int max = Math.min(maxLimit, maxTemp + Math.max(0, 1 - minTemp));
        return new ChainedMap<String, Integer>().set("min", min).set("max", max);
    }


    public Page getPrev() {
        return prev;
    }

    public Pagination setPrev(Page prev) {
        this.prev = prev;
        return this;
    }

    public Page getNext() {
        return next;
    }

    public Pagination setNext(Page next) {
        this.next = next;
        return this;
    }

    public List<Page> getList() {
        return list;
    }

    public Pagination setList(List<Page> list) {
        this.list = list;
        return this;
    }
}
