# 关于本项目（laptop）

本项目旨在通过一个实际的案例介绍六边形架构（Hexagonal architecture，也叫做Ports and Adapters architecture）的思想。

## 项目结构

<pre>
Root project 'laptop'
+--- Project ':laptop-domain'
\--- Project ':laptop-infra'
     +--- Project ':laptop-infra:laptop-infra-application'
     |    +--- Project ':laptop-infra:laptop-infra-application:laptop-infra-application-athome'（在家工作模式）
     |    \--- Project ':laptop-infra:laptop-infra-application:laptop-infra-application-intheoffice'（在办公室工作模式）
     +--- Project ':laptop-infra:laptop-infra-display'
     |    +--- Project ':laptop-infra:laptop-infra-display:laptop-infra-display-samsungdisplay'（三星显示器）
     |    \--- Project ':laptop-infra:laptop-infra-display:laptop-infra-display-xiaomitv'（小米电视）
     \--- Project ':laptop-infra:laptop-infra-storage'
          +--- Project ':laptop-infra:laptop-infra-storage:laptop-infra-storage-kingstonusbflashdisk'（金士顿U盘）
          \--- Project ':laptop-infra:laptop-infra-storage:laptop-infra-storage-wdmobilehdd'（西部数据移动硬盘）
</pre>       
          
### 在家工作模式

laptop-infra-application-athome，依赖于
 - laptop-domain
 - laptop-infra:laptop-infra-storage:laptop-infra-storage-wdmobilehdd
 - laptop-infra:laptop-infra-display:laptop-infra-display-xiaomitv

>本模式将会从西部数据移动硬盘读取电影，并使用小米电视来观看。

#### build & deploy
```Bash
 cd laptop
 gradle clean build
 java -jar laptop-infra/laptop-infra-application/laptop-infra-application-athome/build/libs/laptop-infra-application-athome-0.0.1-Snapshot.jar

### 在办公室工作模式

laptop-infra-application-intheoffice，依赖于
 - laptop-domain
 - laptop-infra:laptop-infra-storage:laptop-infra-storage-kingstonusbflashdisk
 - laptop-infra:laptop-infra-display:laptop-infra-display-samsungdisplay

>本模式将会从金士顿U盘读取电影，并使用三星显示器来观看。

#### build & deploy
```Bash
 cd laptop
 gradle clean build
 java -jar laptop-infra/laptop-infra-application/laptop-infra-application-intheoffice/build/libs/laptop-infra-application-intheoffice-0.0.1-Snapshot.jar
 
 
Email: jay@yunbban.com
