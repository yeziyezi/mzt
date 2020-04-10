package one.yezii.mzt.bean;


import one.yezii.mzt.data.entity.MztCollection;

public class MztCover implements PathAccessorOwner<MztCover> {
    private String path;//访问路径
    private MztCollection collectionEntity;

    public static MztCover of(String coverUrl, MztCollection collectionEntity) {
        return new MztCover().setCollectionEntity(collectionEntity).setPath(coverUrl);
    }

    public String getPath() {
        return path;
    }

    public MztCover setPath(String path) {
        this.path = path;
        return this;
    }

    public MztCollection getCollectionEntity() {
        return collectionEntity;
    }

    public MztCover setCollectionEntity(MztCollection collectionEntity) {
        this.collectionEntity = collectionEntity;
        return this;
    }

}
