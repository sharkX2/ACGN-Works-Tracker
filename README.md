# ACGN作品记录管理系统

这是一个基于 Java Servlet、MySQL、jQuery 和 ECharts 的轻量级 ACGN 作品记录管理系统。

项目主要用于记录和管理动画、漫画、游戏、小说四类作品，支持用户注册登录、作品增删改查、统计图表、TOP 展示、CSV 导入导出，以及多条件搜索。

## 项目特点

- 支持用户注册、登录、退出登录、密码重置
- 支持不同用户的数据隔离
- 支持作品新增、编辑、删除、浏览与搜索
- 支持统计分析与图表展示
- 支持按评分展示 TOP 作品
- 支持 CSV 导入导出
- 支持基于 Session 的访问控制

## 技术栈

- 后端：Java 8、Servlet 4、JDBC、Jackson、OpenCSV
- 前端：HTML、CSS、JavaScript、jQuery、Bootstrap、ECharts
- 数据库：MySQL 8
- 构建工具：Maven

## 本次整理与优化

在发布到 GitHub 前，项目已经完成了一轮工程化整理和基础优化：

- 初始化 Git 仓库并补充 `.gitignore`
- 补充 README 文档
- 将数据库配置改为可外置覆盖
- 增加密码哈希支持，并兼容旧的明文密码数据
- 增加用户名格式校验，降低动态建表风险
- 移除前端页面和脚本中写死的部署上下文路径
- 增加统一的 Session 登录校验过滤器
- 更新 Maven 插件版本，使项目能在当前环境正确打包
- 精简并整理初始化 SQL 脚本

## 目录结构

```text
src/main/java         Java 源码
src/main/resources    数据库配置与初始化 SQL
src/main/webapp       页面、脚本、样式和静态资源
src/test/java         测试代码
pom.xml               Maven 配置
```

## 运行方式

### 1. 准备数据库

创建名为 `acgn` 的 MySQL 数据库，然后执行初始化脚本：

[`src/main/resources/init_work_admin.sql`](/E:/CS/Git/ACGN-FF/src/main/resources/init_work_admin.sql)

### 2. 配置数据库连接

你可以直接修改 [`src/main/resources/db.properties`](/E:/CS/Git/ACGN-FF/src/main/resources/db.properties)，也可以参考 [`src/main/resources/db.properties.example`](/E:/CS/Git/ACGN-FF/src/main/resources/db.properties.example)。

也可以通过环境变量覆盖数据库配置：

```powershell
$env:ACGN_DB_URL="jdbc:mysql://localhost:3306/acgn?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai"
$env:ACGN_DB_USERNAME="root"
$env:ACGN_DB_PASSWORD="your_password"
```

### 3. 构建项目

```powershell
mvn clean package
```

如果你的本地 Maven 路径是 `E:\CS\apache-maven-3.8.8`，也可以直接使用该版本构建。

### 4. 部署运行

将生成的 WAR 包部署到 Tomcat 后，打开登录页面即可使用。

## 说明

- 课程文档中有些目标属于完整规划，如果需要较大改动，本次没有强行补进代码。
- 这次优先补齐了简单且高价值的部分，复杂改动保留到后续优化。
- 根目录中的部分课程材料文档（`doc/docx/pptx`）默认未推送到仓库。

## 后续可优化方向

- 将“每用户一张表”重构为“单表 + user_id”模式
- 为 DAO 层和 Servlet 层补充更完整的测试
- 完善统一异常处理与接口响应规范
- 继续清理旧源码中历史遗留的乱码注释和文本编码问题
