USE spider;

DROP TABLE IF EXISTS job_desc;

CREATE TABLE job_desc (
  id_         INT PRIMARY KEY AUTO_INCREMENT,
  title_      VARCHAR(256),
  location    VARCHAR(256),
  salary      VARCHAR(256),
  salarylo    INT,
  salaryhi    INT,
  companyName VARCHAR(256),
  companyType VARCHAR(256),
  experience  VARCHAR(256),
  degree      VARCHAR(256),
  jobNum      VARCHAR(256),
  releaseTime VARCHAR(256),
  jobMsg      LONGTEXT,
  jobType     VARCHAR(256),
  jobPosition VARCHAR(256),
  part        VARCHAR(256),
  companyMsg  LONGTEXT
);

ALTER TABLE job_desc ADD COLUMN createTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间';
ALTER TABLE job_desc ADD COLUMN updateTime TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
COMMENT '修改时间';