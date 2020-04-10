package one.yezii.mzt.service;


import one.yezii.mzt.bean.MztCover;
import one.yezii.mzt.bean.PathAccessorOwner;
import one.yezii.mzt.data.MztDao;
import one.yezii.mzt.data.entity.Mzt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MztService {
    private final MztDao mztDao;
    @Value("${mzt.url-prefix}")
    private String urlPrefix;

    public MztService(MztDao mztDao) {
        this.mztDao = mztDao;
    }

    //查询图集下的图片
    public List<Mzt> getMztOfCollection(String collectionId) {
        return addUrlPrefix(mztDao.getMztEntitiesOfCollection(collectionId));
    }

    //分页查询图集封面列表
    public List<MztCover> getCovers(int page, int pageSize) {
        return addUrlPrefix(mztDao.getCovers(page, pageSize));
    }

    //查询一共有多少图集
    public Integer collectionAmount() {
        return mztDao.collectionAmount();
    }

    //查询一共有多少单图
    public Integer singleAmount() {
        return mztDao.singleAmount();
    }

    //分页查询单图
    public List<Mzt> getSingles(int page, int pageSize) {
        return addUrlPrefix(mztDao.getSingles(page, pageSize));
    }

    //给列表中的图增加url前缀用于访问
    private <T extends PathAccessorOwner<T>> List<T> addUrlPrefix(List<T> list) {
        return list.stream().map(item -> item.setPath(urlPrefix + "/" + item.getPath()))
                .collect(Collectors.toList());
    }
}
