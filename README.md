# 第一个Android项目
## GreenDao的使用

1. 在Gradle添加GreenDao依赖
```groovy
implementation 'de.greenrobot:greendao:2.1.0'
implementation 'de.greenrobot:greendao-generator:2.1.0'
```
设置主文件夹
```groovy
sourceSets{
    main{
        java.srcDirs = ['src/main/java', 'src/main/java-gen']
    }
}
```
   将Project目录模式显示换为Android，

   ![在Android结构模式下寻找build.gradle文件](image/1.Gradle添加依赖.png)
2. 将项目目录结构切换为Project模式，新建module
   ![在Project结构模式下新建Module](image/2.新建module.png)
3. 选择新建Java Library
   ![新建Java Library Module](image/3.创建JavaLibraryModule.png)
4. 设置Module的名称和类名
   ![设置Module的名称和类名](image/4.创建daogenerator模块.png)
5. DaoGenerator模块创建成功
   ![DaoGenerator模块创建成功](image/5.daogenertor创建成功.png)
6. 在DaoGenerator模块的build.gradle添加greendao依赖项
```groovy
implementation 'de.greenrobot:greendao-generator:2.1.0'
```
   ![在DaoGenerator模块的build.gradle添加greendao依赖项](image/6.DaoGenertor模块添加依赖.png)
7. 编写DaoMaker.java文件运行main方法生成Dao映射文件
```java
package com.fcant.daogenerator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * DaoMaker
 *
 * @author Fcscanf
 * @date 2019-03-12/0012 下午 15:47
 */
public class DaoMaker {
    public static void main(String[] args) {

        // 生成数据库的实体类XXentity，对应的是数据库的表
        Schema schema = new Schema(1, "com.student.entity");
        addStudent(schema);
        schema.setDefaultJavaPackageDao("com.student.dao");
        try {
            new DaoGenerator().generateAll(schema, "D:\\fcofficework\\Dome\\AndroidStdio\\Pro1\\app\\src\\main\\java_gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addStudent(Schema schema) {
//        创建数据库的表
        Entity entity = schema.addEntity("Studnet");
//        主键是int类型
        entity.addIdProperty();
        entity.addStringProperty("name");
        entity.addStringProperty("address");
        entity.addIntProperty("age");
    }
}
```
   ![编写DaoMaker.java文件运行main方法生成Dao映射文件](image/7.运行并生成实体类和Dao.png)
   ![]()
   ![]()
   ![]()
   ![]()