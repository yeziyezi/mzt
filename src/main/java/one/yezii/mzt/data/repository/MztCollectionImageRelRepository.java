package one.yezii.mzt.data.repository;

import one.yezii.mzt.data.entity.MztCollectionImageRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MztCollectionImageRelRepository extends JpaRepository<MztCollectionImageRel, Integer> {
    List<MztCollectionImageRel> findByCollectionId(String collectionId);
}
