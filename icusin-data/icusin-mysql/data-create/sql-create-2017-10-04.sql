-- 表亲数据库

-- 用户信息表
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info
(
  id            INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  user_account  VARCHAR(16)              NOT NULL
  COMMENT '用户账号(数字,英文,下划线,不能以数字开头)',
  user_shadow   CHAR(64)                 NOT NULL
  COMMENT '加密过后的密码',
  user_email    VARCHAR(64)              NULL
  COMMENT '邮箱',
  user_mobile   CHAR(11)                 NULL
  COMMENT '手机号',
  user_nickname VARCHAR(32)              NOT NULL
  COMMENT '昵称(没有设置为默认昵称)',
  user_avatar   CHAR(16)                 NOT NULL
  COMMENT '头像(没有设置为默认头像)',
  user_level    TINYINT UNSIGNED         NOT NULL
  COMMENT '用户等级(默认为1级,最高256级)',
  user_integral SMALLINT UNSIGNED        NOT NULL
  COMMENT '用户积分(默认为0分,最多65536分)',
  gmt_modified  DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(第一次为创建时间)',
  gmt_create    DATETIME                 NOT NULL
  COMMENT '创建日期',
  status        TINYINT UNSIGNED         NOT NULL
  COMMENT '状态'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户信息表';
CREATE UNIQUE INDEX pk_user_info_id
  ON user_info (id);
CREATE UNIQUE INDEX uk_user_account
  ON user_info (user_account);
CREATE UNIQUE INDEX uk_user_email
  ON user_info (user_email);
CREATE UNIQUE INDEX uk_user_mobile
  ON user_info (user_mobile);

-- 表亲信息表
DROP TABLE IF EXISTS cusin_info;
CREATE TABLE cusin_info
(
  id             INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  user_ref_id    INT UNSIGNED             NOT NULL
  COMMENT '参照的用户信息表记录[那个用户添加的]',
  cusin_name     VARCHAR(16)              NOT NULL
  COMMENT '表亲名',
  cusin_sex      TINYINT UNSIGNED         NOT NULL
  COMMENT '性别 (0.男 1.女)',
  cusin_birthday DATE                     NOT NULL
  COMMENT '生日',
  cusin_career   VARCHAR(16)              NULL
  COMMENT '职业',
  cusin_photo    CHAR(16)                 NULL
  COMMENT '照片',
  cusin_add      VARCHAR(64)              NULL
  COMMENT '详细地址(可以详细点)',
  area_ref_id    INT UNSIGNED             NULL
  COMMENT '区域参照',
  gmt_create     DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified   DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  cusin_perms    TINYINT UNSIGNED         NOT NULL
  COMMENT '权限 0.自己可见 1.表亲可见 2.所有人可见',
  status         TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.普通表亲 2.自己)',
  rel_ref_id     INT UNSIGNED             NOT NULL
  COMMENT '与用户关系的参照'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='表亲信息表';
CREATE UNIQUE INDEX pk_cusin_info_id
  ON cusin_info (id);

-- 回忆录信息表
DROP TABLE IF EXISTS memoir_info;
CREATE TABLE memoir_info
(
  id             INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  cusin_ref_id   INT UNSIGNED             NOT NULL
  COMMENT '参照表亲表记录',
  memoir_title   VARCHAR(32)              NOT NULL
  COMMENT '回忆录标题',
  memoir_digest  VARCHAR(256)             NOT NULL
  COMMENT '摘要',
  catg_ref_id    INT UNSIGNED             NOT NULL
  COMMENT '分类参照',
  content_ref_id INT UNSIGNED             NOT NULL
  COMMENT '内容参照',
  gmt_create     DATETIME                 NOT NULL
  COMMENT '创建时间',
  gmt_modified   DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  status         TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录信息表';
CREATE UNIQUE INDEX pk_memoir_info_id
  ON memoir_info (id);

-- 回忆录内容
DROP TABLE IF EXISTS memoir_content;
CREATE TABLE memoir_content
(
  id             INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  memoir_content TEXT                     NOT NULL
  COMMENT '内容',
  gmt_create     DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified   DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  status         TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录内容';
CREATE UNIQUE INDEX pk_memoir_content_id
  ON memoir_content (id);

-- 表亲之间的关系表
DROP TABLE IF EXISTS cusin_rel;
CREATE TABLE cusin_rel (
  id           INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  rel_name     VARCHAR(16)              NOT NULL
  COMMENT '关系名称',
  user_ref_id  INT UNSIGNED             NOT NULL
  COMMENT '关系所属的用户及自定义关系，默认关系ｉｄ位０',
  gmt_modified DATETIME                 NOT NULL
  COMMENT '最后一次修改时间[默认为创建时间]',
  gmt_create   DATETIME                 NOT NULL
  COMMENT '创建时间',
  status       TINYINT                  NOT NULL
  COMMENT '状态[０．无效　１．有效]'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='表亲关系表';
CREATE UNIQUE INDEX pk_cusin_rel_id
  ON cusin_rel (id);

-- 回忆录评论表
DROP TABLE IF EXISTS memoir_cmt;
CREATE TABLE memoir_cmt (
  id            INT UNSIGNED PRIMARY KEY  NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  cmt_content   VARCHAR(256)              NOT NULL
  COMMENT '评论内容',
  user_ref_id   INT UNSIGNED              NOT NULL
  COMMENT '用户参照',
  memoir_ref_id INT UNSIGNED              NOT NULL
  COMMENT '回忆录参照',
  gmt_modified  DATETIME                  NOT NULL
  COMMENT '最后一次修改时间[默认创建时间]',
  gmt_create    DATETIME                  NOT NULL
  COMMENT '创建时间',
  status        TINYINT UNSIGNED          NOT NULL
  COMMENT '状态[0.无效　１．有效]'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录评论表';
CREATE UNIQUE INDEX pk_memori_cmt_id
  ON memoir_cmt (id);

-- 回忆录分类表
DROP TABLE IF EXISTS memoir_catg;
CREATE TABLE memoir_catg (
  id           INT UNSIGNED PRIMARY KEY  NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  catg_name    VARCHAR(16)               NOT NULL
  COMMENT '分类名称',
  user_ref_id  INT UNSIGNED              NOT NULL
  COMMENT '自定义分类参照的用户ｉｄ[默认分类参照０]',
  gmt_modified DATETIME                  NOT NULL
  COMMENT '最后一次修改时间',
  gmt_create   DATETIME                  NOT NULL
  COMMENT '创建时间',
  status       TINYINT UNSIGNED          NOT NULL
  COMMENT '状态[0.无效　１．有效]'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录分类表';

-- 区域参照
DROP TABLE IF EXISTS area_info;
CREATE TABLE area_info (
  id           INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  area_name    VARCHAR(16)              NOT NULL
  COMMENT '区域名称',
  gmt_modified DATETIME                 NOT NULL
  COMMENT '最后一次修改时间［默认创建时间］',
  gmt_create   DATETIME                 NOT NULL
  COMMENT '创建时间',
  status       TINYINT UNSIGNED         NOT NULL
  COMMENT '状态[0.无效　1.有效]',
  par_ref_id   INT UNSIGNED             NOT NULL
  COMMENT '父区域参照'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='区域参照表';
CREATE UNIQUE INDEX pk_area_info_id
  ON area_info (id);

-- 表亲被查看记录
DROP TABLE IF EXISTS cusin_view_log;
CREATE TABLE cusin_view_log (
  id           INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  user_ref_id  INT UNSIGNED             NOT NULL
  COMMENT '查看表亲的用户参照',
  gmt_modified DATETIME                 NOT NULL
  COMMENT '最后一次修改时间[默认创建时间]',
  gmt_create   DATETIME                 NOT NULL
  COMMENT '创建时间',
  status       TINYINT UNSIGNED         NOT NULL
  COMMENT '状态［０．无效　１．有效］',
  cusin_ref_id INT UNSIGNED             NOT NULL
  COMMENT '被查看的表亲'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT = '表亲被查看记录';
CREATE UNIQUE INDEX pk_cusin_view_log_id
  ON cusin_view_log (id);

-- 回忆录被查看记录
DROP TABLE IF EXISTS memoir_view_log;
CREATE TABLE memoir_view_log (
  id            INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  user_ref_id   INT UNSIGNED             NOT NULL
  COMMENT '查看用户参照',
  memoir_ref_id INT UNSIGNED             NOT NULL
  COMMENT '被查看的回忆录参照',
  gmt_modified  DATETIME                 NOT NULL
  COMMENT '最后一次修改时间[默认创建时间]',
  gmt_create    DATETIME                 NOT NULL
  COMMENT '创建时间',
  status        TINYINT UNSIGNED         NOT NULL
  COMMENT '状态［０．无效　１．有效］'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录查看记录';
CREATE UNIQUE INDEX pk_memoir_view_log_id
  ON memoir_view_log (id);