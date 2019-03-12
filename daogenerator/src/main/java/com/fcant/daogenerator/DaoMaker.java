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
