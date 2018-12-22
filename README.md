# spark项目模板

spark项目可以直接打包成azkaban任务包

## 项目模板说明

### 项目主要文件说明
bin：shell脚本

job：azkaban任务和环境变量

src：scala和java代码

pom.xml：配置文件，需要什么jar包自己配置

assembly.xml：打包配置，一般不需要修改

.gitignore :Git忽略规则文件

### pom.xml文件规范
####  版本号
版本号规则为：大版本.小版本.打包日期

例：1.2.20180731 表示在2018.07.31发布的1.2版，如果同一天发布多个版本在日期后加中划线和版本发布次数，例如 1.2.20180731-1 1.2.20180731-2

####  依赖jar包的版本号

依赖jar包的版本号全部放在 properties里，在dependency，不允许出现版本号

#### 依赖

1. dependency只添加需要的jar包，其他不用的不允许引用
2. 在```<artifactSet>``` 节点，需要手动设置打包时一起打入的jar包，打包成fatjar


## 使用方式


### 本地测试
直接在idea中设置断点，点击DEBUG即可

测试时spark config最好使用本地模式 

例如：setMaster("local[2]")


### spark集群提交任务与一般的
`/bigdata/spark2-client/bin/spark-submit --class tant.spark.template.App /home/hdfs/azkaban-project-1.0.180731.jar`


## 打包命令
### 普通打包
生成 spark可提交的jar包

`mvn clean package`

### azkaban任务包
生成azkaban任务包，可直接上传到azkaban调度

`mvn clean package -Pzip`

