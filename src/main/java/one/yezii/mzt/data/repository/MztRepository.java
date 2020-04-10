package one.yezii.mzt.data.repository;

import one.yezii.mzt.data.entity.Mzt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MztRepository extends JpaRepository<Mzt, String> {
    @Query(value = "select * from mzt where type='single' limit ?1,?2", nativeQuery = true)
    List<Mzt> findAllSingleByLimit(int start, int offset);

    int countAllByTypeEquals(String type);

    default List<Mzt> findAllSingleByPage(int page, int pageSize) {
        return findAllSingleByLimit((page - 1) * pageSize, pageSize);
    }

    default int getSingleAmount() {
        return countAllByTypeEquals("single");
    }
}
