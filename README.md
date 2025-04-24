# Spring Boot DDD Demo

## 目录
- [项目介绍](#项目介绍)
- [技术栈](#技术栈)
- [项目结构](#项目结构)
- [环境要求](#环境要求)
  - [JDK要求](#jdk要求)
  - [MySQL要求](#mysql要求)
  - [JDK安装配置](#jdk安装配置)
  - [MySQL安装配置](#mysql安装配置)
- [运行项目](#运行项目)
  - [准备数据库](#准备数据库)
  - [配置数据库连接](#配置数据库连接)
  - [运行应用](#运行应用)
- [API文档](#api-文档knife4j)
  - [文档访问地址](#文档访问地址)
- [Druid监控配置](#druid-监控配置)
  - [监控页面访问](#1-监控页面访问)
  - [监控功能介绍](#2-监控功能介绍)
  - [常用监控指标](#3-常用监控指标)
  - [监控页面说明](#4-监控页面说明)
  - [注意事项](#5-注意事项)
  - [常见问题处理](#6-常见问题处理)

## 项目介绍

这是一个使用Spring Boot和MyBatis Plus实现的DDD架构示例项目。

## 技术栈

- Spring Boot 2.7.18
- MyBatis Plus 3.5.11
- MySQL 8.0.33
- Java 11
- Knife4j 4.5.0
- Druid 1.2.20
- Lombok 1.18.30
- Hibernate Validator 6.2.5.Final
- SnakeYAML 2.2

## 项目结构

项目采用DDD（领域驱动设计）架构，主要分为以下几层：

- interfaces：接口层，包含控制器等
- application：应用层，包含应用服务
- domain：领域层，包含领域模型、领域服务和仓储接口
- infrastructure：基础设施层，包含仓储实现等

## API 文档（Knife4j）

项目集成了 Knife4j 增强版接口文档，可通过以下方式访问：

### 文档访问地址
```
http://localhost:8080/doc.html
```

在 Knife4j 文档界面中，您可以：
- 查看所有 API 接口的详细信息
- 在线调试接口
- 查看请求和响应示例
- 导出离线文档（支持 Markdown、HTML、Word 格式）
- 查看接口的 OpenAPI 规范

## 运行项目

### 1. 准备数据库

1. 确保已安装MySQL 8.0
2. 使用 `src/main/resources/db/schema.sql` 创建数据库和表

### 2. 配置数据库连接

修改 `src/main/resources/application.yml` 中的数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ddd_demo
    username: your_username
    password: your_password
```

### 3. 运行应用

```bash
mvn spring-boot:run
```

## 环境要求

### JDK 要求
- JDK 版本：11
- 下载地址：[华为镜像 JDK 下载](https://repo.huaweicloud.com/java/jdk/)
- 推荐版本下载：
  - Windows：[JDK 11.0.2](https://repo.huaweicloud.com/java/jdk/11.0.2+7/)
  - Linux：[JDK 11.0.2](https://repo.huaweicloud.com/java/jdk/11.0.2+7/)

### JDK 安装配置
1. 下载对应操作系统的 JDK 安装包
2. 安装 JDK
3. 配置环境变量：
   ```bash
   # Windows
   JAVA_HOME=JDK安装路径
   Path=%JAVA_HOME%\bin
   
   # Linux
   export JAVA_HOME=JDK安装路径
   export PATH=$JAVA_HOME/bin:$PATH
   ```
4. 验证安装：
   ```bash
   java -version
   ```

### MySQL 要求
- MySQL 版本：8.0.29
- 下载地址：[华为镜像 MySQL 下载](https://mirrors.huaweicloud.com/mysql/Downloads/MySQL-8.0/)
- 推荐版本下载：
  - Windows：mysql-8.0.29-winx64.zip
  - Linux：
    - Ubuntu 20.04: mysql-server_8.0.29-1ubuntu20.04_amd64.deb
    - Ubuntu 18.04: mysql-server_8.0.29-1ubuntu18.04_amd64.deb
    - Debian 10: mysql-server_8.0.29-1debian10_amd64.deb
    - CentOS 7/8: mysql-8.0.29-1.el7.x86_64.rpm-bundle.tar

### MySQL 安装配置
1. 下载对应操作系统的 MySQL 安装包

2. Windows 安装步骤：
   ```bash
   # 1. 解压下载的 zip 文件
   # 2. 配置环境变量，添加 MySQL 的 bin 目录到 Path
   # 3. 初始化 MySQL
   mysqld --initialize-insecure
   # 4. 安装 MySQL 服务
   mysqld --install
   # 5. 启动 MySQL 服务
   net start mysql
   # 6. 设置 root 密码
   mysql -u root
   ALTER USER 'root'@'localhost' IDENTIFIED BY 'your_password';
   ```

3. Linux (Ubuntu) 安装步骤：
   ```bash
   # 安装 MySQL
   sudo dpkg -i mysql-server_8.0.29-1ubuntu20.04_amd64.deb
   sudo apt-get install -f
   
   # 启动 MySQL
   sudo systemctl start mysql
   
   # 设置开机自启
   sudo systemctl enable mysql
   
   # 检查 MySQL 状态
   sudo systemctl status mysql
   ```

4. Linux (CentOS) 安装步骤：
   ```bash
   # 1. 解压 RPM 包
   tar xvf mysql-8.0.29-1.el7.x86_64.rpm-bundle.tar
   
   # 2. 安装依赖
   sudo yum install -y libaio
   
   # 3. 按顺序安装 MySQL RPM 包
   sudo rpm -ivh mysql-community-common-8.0.29-1.el7.x86_64.rpm
   sudo rpm -ivh mysql-community-client-plugins-8.0.29-1.el7.x86_64.rpm
   sudo rpm -ivh mysql-community-libs-8.0.29-1.el7.x86_64.rpm
   sudo rpm -ivh mysql-community-client-8.0.29-1.el7.x86_64.rpm
   sudo rpm -ivh mysql-community-server-8.0.29-1.el7.x86_64.rpm
   
   # 4. 启动 MySQL 服务
   sudo systemctl start mysqld
   
   # 5. 设置开机自启
   sudo systemctl enable mysqld
   
   # 6. 查看初始密码
   sudo grep 'temporary password' /var/log/mysqld.log
   
   # 7. 登录并修改密码
   mysql -uroot -p
   ALTER USER 'root'@'localhost' IDENTIFIED BY 'your_new_password';
   
   # 8. 允许远程访问（可选）
   CREATE USER 'root'@'%' IDENTIFIED BY 'your_password';
   GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
   FLUSH PRIVILEGES;
   
   # 9. 检查 MySQL 状态
   sudo systemctl status mysqld
   ```

5. 验证安装：
   ```bash
   mysql --version
   ```

## Druid 监控配置

### 1. 监控页面访问
- URL：
  - 开发环境：[http://localhost:8080/api/druid/index.html](http://localhost:8080/api/druid/index.html)
  - 测试环境：[http://test-server:8080/api/druid/index.html](http://test-server:8080/api/druid/index.html)
  - 生产环境：[http://your-domain:8080/api/druid/index.html](http://your-domain:8080/api/druid/index.html)
- 默认账号密码：
  - 开发环境：admin/123456
  - 测试环境：admin/test123
  - 生产环境：通过环境变量配置（DRUID_USERNAME/DRUID_PASSWORD）

### 2. 监控功能介绍

#### 2.1 数据源监控
- 数据源的基本信息
- 连接池的实时状态
  - 活跃连接数
  - 连接池使用率
  - 等待连接数
  - 事务数量统计

#### 2.2 SQL监控
- SQL执行统计
  - 执行次数
  - 执行时间分布
  - 读写比例
- 慢SQL分析
  - SQL语句详情
  - 执行时间
  - 影响行数

#### 2.3 SQL防火墙（生产环境）
- SQL注入防御
- 语句黑名单控制
- 恶意操作拦截

### 3. 常用监控指标

1. **连接池指标**
   ```
   活跃连接数 = 当前正在使用的连接数
   连接池使用率 = 活跃连接数 / 最大连接数
   平均连接时间 = 所有连接累计时间 / 连接次数
   ```

2. **SQL性能指标**
   ```
   平均执行时间 = 总执行时间 / 执行次数
   慢SQL标准 = 执行时间 > 3秒
   ```

### 4. 监控页面说明

1. **数据源页面**
   - 基本信息：配置参数、运行参数
   - 连接池：实时状态、使用统计
   - 实时监控：可视化图表展示

2. **SQL监控页面**
   - SQL统计：执行次数、时间统计
   - 执行详情：完整SQL、执行计划
   - 趋势图：性能趋势分析

### 5. 注意事项

1. **安全配置**
   - 生产环境必须配置IP白名单
   - 定期更改监控页面密码
   - 避免暴露监控地址到外网

2. **性能影响**
   - 监控统计会略微影响性能
   - 建议生产环境按需开启功能
   - 可通过配置调整采样率

3. **问题排查**
   - 定期检查慢SQL日志
   - 关注连接池使用率
   - 监控SQL执行异常

### 6. 常见问题处理

1. **连接池满载**
   ```yaml
   # 适当调整连接池配置
   spring:
     datasource:
       druid:
         max-active: 50  # 增加最大连接数
         min-idle: 20    # 增加最小空闲连接
   ```

2. **慢SQL处理**
   - 检查SQL语句是否合理
   - 确认索引使用情况
   - 考虑SQL优化或分页

3. **访问权限问题**
   ```yaml
   # 配置允许访问的IP
   spring:
     datasource:
       druid:
         stat-view-servlet:
           allow: 10.0.0.0/16,192.168.0.0/16
   ```


