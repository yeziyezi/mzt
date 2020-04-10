package one.yezii.mzt.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "mzt_collection_image_rel")
public class MztCollectionImageRel implements Serializable {
    private Integer id;
    private String collectionId;
    private String imageId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public MztCollectionImageRel setId(Integer id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "collection_id")
    public String getCollectionId() {
        return collectionId;
    }

    public MztCollectionImageRel setCollectionId(String collectionId) {
        this.collectionId = collectionId;
        return this;
    }

    @Basic
    @Column(name = "image_id")
    public String getImageId() {
        return imageId;
    }

    public MztCollectionImageRel setImageId(String imageId) {
        this.imageId = imageId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MztCollectionImageRel that = (MztCollectionImageRel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(collectionId, that.collectionId) &&
                Objects.equals(imageId, that.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionId, imageId);
    }
}
