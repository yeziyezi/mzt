package one.yezii.mzt.data;


import one.yezii.mzt.bean.MztCover;
import one.yezii.mzt.data.entity.Mzt;
import one.yezii.mzt.data.entity.MztCollection;
import one.yezii.mzt.data.entity.MztCollectionImageRel;
import one.yezii.mzt.data.repository.MztCollectionImageRelRepository;
import one.yezii.mzt.data.repository.MztCollectionRepository;
import one.yezii.mzt.data.repository.MztRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class MztDao {
    private final MztCollectionRepository collectionRepository;
    private final MztRepository mztRepository;
    private final MztCollectionImageRelRepository relRepository;

    public MztDao(MztCollectionRepository cr, MztRepository mr, MztCollectionImageRelRepository rr) {
        this.collectionRepository = cr;
        this.mztRepository = mr;
        this.relRepository = rr;
    }

    //查询图集总数
    public Integer collectionAmount() {
        return Long.valueOf(collectionRepository.count()).intValue();
    }

    //分页查询图集列表
    //按score字段降序排列
    //由于PageRequest的页码从0开始，传入参数是按从1开始，因此page-1
    public List<MztCover> getCovers(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.Direction.DESC, "score");
        return collectionRepository.findAll(pageRequest)
                .get()
                .map(this::getCoverByCollection)
                .collect(Collectors.toList());
    }

    //查询图集中的所有图
    public List<Mzt> getMztEntitiesOfCollection(String collectionId) {
        return mztRepository.findAllById(relRepository
                .findByCollectionId(collectionId).stream()
                .map(MztCollectionImageRel::getImageId)
                .collect(Collectors.toList()));
    }

    //分页查询单图
    public List<Mzt> getSingles(Integer page, Integer pageSize) {
        return mztRepository.findAllSingleByPage(page, pageSize);
    }

    //查询单图总数
    public Integer singleAmount() {
        return Long.valueOf(collectionRepository.count()).intValue();
    }

    //根据图集获取封面
    private MztCover getCoverByCollection(MztCollection collection) {
        return MztCover.of(mztRepository.findById(collection.getCoverId()).orElseThrow().getPath(), collection);
    }
}
