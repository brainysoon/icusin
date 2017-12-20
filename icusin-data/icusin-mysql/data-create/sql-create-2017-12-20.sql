-- 表亲数据库 修改日期：2017-12-20 11:23 修改人：brainy 审阅人：brainy

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
  user_email    VARCHAR(64)
  COMMENT '邮箱',
  user_mobile   CHAR(16)
  COMMENT '手机号(第一位为+,后4位为国家代码,后11位为手机号码)',
  user_nickname VARCHAR(32)              NOT NULL
  COMMENT '昵称(没有设置为默认昵称)',
  user_avatar   CHAR(16)                 NOT NULL
  COMMENT '头像(没有设置为默认头像)',
  user_level    TINYINT UNSIGNED         NOT NULL
  COMMENT '用户等级(默认为0级,最高256级)',
  user_integral SMALLINT UNSIGNED        NOT NULL
  COMMENT '用户积分(默认为0分,最多65536分)',
  gmt_modified  DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(第一次为创建时间)',
  gmt_create    DATETIME                 NOT NULL
  COMMENT '创建日期',
  mark_status   TINYINT UNSIGNED         NOT NULL
  COMMENT '标记状态(0:无效 1:激活)'
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
  id               INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_user_info_id INT UNSIGNED             NOT NULL
  COMMENT '参照的用户信息表记录',
  cusin_name       VARCHAR(16)              NOT NULL
  COMMENT '表亲名',
  cusin_sex        TINYINT UNSIGNED         NOT NULL
  COMMENT '性别 (0.男 1.女)',
  cusin_birthday   DATE                     NOT NULL
  COMMENT '生日',
  cusin_career     VARCHAR(16)
  COMMENT '职业',
  cusin_photo      CHAR(16)
  COMMENT '照片',
  cusin_add        VARCHAR(64)
  COMMENT '详细地址(可以详细点)',
  ref_area_info_id INT UNSIGNED
  COMMENT '区域参照',
  gmt_create       DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified     DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  cusin_perms      TINYINT UNSIGNED         NOT NULL
  COMMENT '权限 0.自己可见 1.表亲可见 2.所有人可见',
  mark_status      TINYINT UNSIGNED COMMENT '状态 (0.无效 1.普通表亲 2.自己)'
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
  id                    INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_cusin_info_id     INT UNSIGNED             NOT NULL
  COMMENT '参照表亲表记录',
  ref_user_info_id      INT UNSIGNED             NOT NULL
  COMMENT '用户参照（冗余）',
  memoir_title          VARCHAR(32)              NOT NULL
  COMMENT '回忆录标题',
  memoir_digest         VARCHAR(256)             NOT NULL
  COMMENT '摘要',
  ref_memoir_catg_id    INT UNSIGNED             NOT NULL
  COMMENT '分类参照',
  ref_memoir_content_id INT UNSIGNED             NOT NULL
  COMMENT '内容参照',
  gmt_create            DATETIME                 NOT NULL
  COMMENT '创建时间',
  gmt_modified          DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status           TINYINT UNSIGNED         NOT NULL
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
  mark_status    TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录内容';
CREATE UNIQUE INDEX pk_memoir_content_id
  ON memoir_content (id);

-- 区域信息表
DROP TABLE IF EXISTS area_info;
CREATE TABLE area_info
(
  id            INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_parent_id INT UNSIGNED
  COMMENT '父区域参照',
  area_name     VARCHAR(16)              NOT NULL
  COMMENT '区域名称',
  gmt_create    DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified  DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status   TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='区域信息';
CREATE UNIQUE INDEX pk_area_info_id
  ON area_info (id);

-- 表亲关系表
DROP TABLE IF EXISTS cusin_rel;
CREATE TABLE cusin_rel
(
  id               INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_user_info_id INT UNSIGNED             NOT NULL
  COMMENT '用户参照',
  rel_name         VARCHAR(16)              NOT NULL
  COMMENT '关系名称',
  gmt_create       DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified     DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status      TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='表亲关系';
CREATE UNIQUE INDEX pk_cusin_rel_id
  ON cusin_rel (id);

-- 回忆录分类表
DROP TABLE IF EXISTS memoir_catg;
CREATE TABLE memoir_catg
(
  id               INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  catg_name        VARCHAR(16)              NOT NULL
  COMMENT '分类名称',
  ref_user_info_id INT UNSIGNED             NOT NULL
  COMMENT '用户参照',
  gmt_create       DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified     DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status      TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录分类';
CREATE UNIQUE INDEX pk_memoir_catg_id
  ON memoir_catg (id);

-- 回忆录评论表
DROP TABLE IF EXISTS memoir_cmt;
CREATE TABLE memoir_cmt
(
  id                 INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  cmt_content        VARCHAR(256)             NOT NULL
  COMMENT '评论内容',
  ref_user_info_id   INT UNSIGNED             NOT NULL
  COMMENT '用户参照',
  ref_memoir_info_id INT UNSIGNED             NOT NULL
  COMMENT '回忆录参照',
  gmt_create         DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified       DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status        TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='回忆录评论';
CREATE UNIQUE INDEX pk_memoir_cmt_id
  ON memoir_cmt (id);

-- 用户表亲关系表
DROP TABLE IF EXISTS user_cusin_rel;
CREATE TABLE user_cusin_rel
(
  id                INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_user_info_id  INT UNSIGNED             NOT NULL
  COMMENT '用户参照',
  ref_cusin_info_id INT UNSIGNED             NOT NULL
  COMMENT '表亲参照',
  gmt_create        DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified      DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status       TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户表亲关系';
CREATE UNIQUE INDEX pk_user_cusin_rel_id
  ON user_cusin_rel (id);

-- 用户业务日志表
DROP TABLE IF EXISTS user_log;
CREATE TABLE user_log
(
  id               INT UNSIGNED PRIMARY KEY NOT NULL
  COMMENT '记录标识' AUTO_INCREMENT,
  ref_user_info_id INT UNSIGNED             NOT NULL
  COMMENT '用户参照(0:匿名用户 >0:普通用户)',
  ref_id           INT UNSIGNED             NOT NULL
  COMMENT '日志对象参照',
  log_content      VARCHAR(32)              NOT NULL
  COMMENT '日志内容',
  log_type         TINYINT UNSIGNED         NOT NULL
  COMMENT '日志类型（0:普通日志 1:表亲日志 2:回忆录日志）',
  gmt_create       DATETIME                 NOT NULL
  COMMENT '创建日期',
  gmt_modified     DATETIME                 NOT NULL
  COMMENT '最后一次修改时间(默认创建时间)',
  mark_status      TINYINT UNSIGNED         NOT NULL
  COMMENT '状态 (0.无效 1.有效)'
)
  ENGINE = innodb
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户业务日志';
CREATE UNIQUE INDEX pk_user_log_id
  ON user_log (id);