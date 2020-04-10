DROP TABLE IF EXISTS `mzt`;
CREATE TABLE `mzt`
(
    id            varchar(36)  NOT NULL,
    path          varchar(200) NOT NULL,
    like_count    int(11)      NOT NULL,
    dislike_count int(11)      NOT NULL,
    type          varchar(10)  NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `mzt_collection`;
CREATE TABLE `mzt_collection`
(
    id            varchar(36) NOT NULL,
    cover_id      varchar(36) NOT NULL,
    like_count    int(11)     NOT NULL,
    dislike_count int(11)     NOT NULL,
    score         int(12)     NOT NULL,
    view_count    int(11)     NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `mzt_collection_image_rel`;
CREATE TABLE `mzt_collection_image_rel`
(
    id            int(11)     NOT NULL AUTO_INCREMENT,
    collection_id varchar(36) NOT NULL,
    image_id      varchar(36) NOT NULL,
    PRIMARY KEY (id)
);