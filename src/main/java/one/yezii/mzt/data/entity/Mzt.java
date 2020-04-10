package one.yezii.mzt.data.entity;


import one.yezii.mzt.bean.PathAccessorOwner;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "mzt")
public class Mzt implements Serializable, PathAccessorOwner<Mzt> {
    private String id;
    private String path;
    private int likeCount;
    private int dislikeCount;
    private String type;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public Mzt setId(String id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public Mzt setPath(String path) {
        this.path = path;
        return this;
    }

    @Basic
    @Column(name = "like_count")
    public int getLikeCount() {
        return likeCount;
    }

    public Mzt setLikeCount(int likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    @Basic
    @Column(name = "dislike_count")
    public int getDislikeCount() {
        return dislikeCount;
    }

    public Mzt setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
        return this;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public Mzt setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mzt mzt = (Mzt) o;
        return likeCount == mzt.likeCount &&
                dislikeCount == mzt.dislikeCount &&
                Objects.equals(id, mzt.id) &&
                Objects.equals(path, mzt.path) &&
                Objects.equals(type, mzt.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, likeCount, dislikeCount, type);
    }
}
