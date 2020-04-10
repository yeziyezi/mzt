package one.yezii.mzt.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "mzt_collection")
public class MztCollection implements Serializable {
    private String id;
    private String coverId;
    private int likeCount;
    private int dislikeCount;
    private int score;
    private int viewCount;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public MztCollection setId(String id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "cover_id")
    public String getCoverId() {
        return coverId;
    }

    public MztCollection setCoverId(String coverId) {
        this.coverId = coverId;
        return this;
    }

    @Basic
    @Column(name = "like_count")
    public int getLikeCount() {
        return likeCount;
    }

    public MztCollection setLikeCount(int likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    @Basic
    @Column(name = "dislike_count")
    public int getDislikeCount() {
        return dislikeCount;
    }

    public MztCollection setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
        return this;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public MztCollection setScore(int score) {
        this.score = score;
        return this;
    }

    @Basic
    @Column(name = "view_count")
    public int getViewCount() {
        return viewCount;
    }

    public MztCollection setViewCount(int viewCount) {
        this.viewCount = viewCount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MztCollection that = (MztCollection) o;
        return likeCount == that.likeCount &&
                dislikeCount == that.dislikeCount &&
                score == that.score &&
                viewCount == that.viewCount &&
                Objects.equals(id, that.id) &&
                Objects.equals(coverId, that.coverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coverId, likeCount, dislikeCount, score, viewCount);
    }
}
