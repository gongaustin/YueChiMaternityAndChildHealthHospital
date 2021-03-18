package com.austin.common.core.enums;

/**
 * @Description:网站首页模块
 * @Author: GongJun
 * @Date: Created in 12:16 2021/3/18
 */
public enum WangZhanShouYeModule {

    YILIAOJIGOUGAIKUANG("医疗机构概况",11),

    YILIAOFUWUGAIKUANG("医疗服务概况",12),

    YILIAOJIGOUHUANGJING("医疗机构环境",13),

    HANGFENGLIANZHENGJIANSHE("行风廉政建设",14),


    ;
    private String name; private int index;
    WangZhanShouYeModule(String name, int i) {
        this.name = name; this.index = index;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

}
