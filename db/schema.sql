DROP TABLE IF EXISTS oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY COMMENT '用于唯一标识每一个客户端(client)；注册时必须填写(也可以服务端自动生成)，这个字段是必须的，实际应用也有叫app_key',
  resource_ids VARCHAR(255) COMMENT '客户端能访问的资源id集合，注册客户端时，根据实际需要可选择资源id，也可以根据不同的注册流程，赋予对应的额资源id',
  client_secret VARCHAR(255) COMMENT '注册填写或者服务端自动生成，实际应用也有叫app_secret, 必须要有前缀代表加密方式',
  scope VARCHAR(255) COMMENT '指定client的权限范围，比如读写权限，比如移动端还是web端权限',
  authorized_grant_types VARCHAR(255) COMMENT '可选值 授权码模式:authorization_code,密码模式:password,刷新token: refresh_token, 隐式模式: implicit: 客户端模式: client_credentials。支持多个用逗号分隔',
  web_server_redirect_uri VARCHAR(255) COMMENT '客户端重定向uri，authorization_code和implicit需要该值进行校验，注册时填写',
  authorities VARCHAR(255) COMMENT '指定用户的权限范围，如果授权的过程需要用户登陆，该字段不生效，implicit和client_credentials需要',
  access_token_validity INTEGER COMMENT '设置access_token的有效时间(秒),默认(606012,12小时)',
  refresh_token_validity INTEGER COMMENT '设置refresh_token有效期(秒)，默认(606024*30, 30填)',
  additional_information VARCHAR(4096) COMMENT '值必须是json格式',
  autoapprove VARCHAR(255) COMMENT '默认false,适用于authorization_code模式,设置用户是否自动approval操作,设置true跳过用户确认授权操作页面，直接跳到redirect_uri'
);
insert into oauth_client_details (
client_id,client_secret, resource_ids, scope, authorized_grant_types, web_server_redirect_uri,
authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
values('04e6337ae6c7435d8b2eda995878fe0e','$2a$10$Nw/B4/m9kuxA6uYjK6bNtecKXh3IgW1lWRRvUn74zKJseV4dHydsq','admin,gateway,goods,order','admin','authorization_code','http://admin.ouyangfan.cn:9090/oauth/callback',
null,60,129600,null,'true')




create table oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(255), authentication BLOB
);

create table oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt DATETIME,
	lastModifiedAt DATETIME
);


CREATE TABLE SPRING_SESSION (
   PRIMARY_ID CHAR(36) NOT NULL,
   SESSION_ID CHAR(36) NOT NULL,
   CREATION_TIME BIGINT NOT NULL,
   LAST_ACCESS_TIME BIGINT NOT NULL,
   MAX_INACTIVE_INTERVAL INT NOT NULL,
   EXPIRY_TIME BIGINT NOT NULL,
   PRINCIPAL_NAME VARCHAR(100),
   CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
 );

 CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
 CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
 CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

 CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID CHAR(36) NOT NULL,
  ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
  ATTRIBUTE_BYTES BLOB NOT NULL,
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
 );

 CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1 ON SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID);