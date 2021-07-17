package com.austin.common.core.constant;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: GongJun
 * @Date: Created in 20:42 2021/7/17
 */
public class IconConstant {
    public static List<Map<String,String>> getIcons(){
        Map<String,String> icons = Maps.newConcurrentMap();
        icons.put("yc01","病理科");
        icons.put("yc02","产科");
        icons.put("yc03","超声科");
        icons.put("yc04","儿科");
        icons.put("yc05","儿童健康科");
        icons.put("yc06","儿童心理与康复科");
        icons.put("yc07","儿外科");
        icons.put("yc08","放射科");
        icons.put("yc09","妇科");
        icons.put("yc10","妇女健康中心");
        icons.put("yc11","检验科");
        icons.put("yc12","口腔科");
        icons.put("yc13","麻醉科");
        icons.put("yc14","内科");
        icons.put("yc15","皮肤科");
        icons.put("yc16","乳腺科");
        icons.put("yc17","生殖免疫中心");
        icons.put("yc18","生殖医学中心");
        icons.put("yc19","体检科");
        icons.put("yc20","新生儿疾病筛查中心");
        icons.put("yc21","新生儿科");
        icons.put("yc22","眼科");
        icons.put("yc23","药剂科");
        icons.put("yc24","医学遗传中心");
        icons.put("yc25","针灸推拿科");
        icons.put("yc26","中医科");
        icons.put("yc27","综合门诊");
        List<Map<String,String>> iconsList = Lists.newArrayList();
        for (Map.Entry<String, String> map : icons.entrySet()){
            Map<String,String> iconMap = Maps.newConcurrentMap();
            iconMap.put("identifier",map.getKey());
            iconMap.put("name",map.getValue());
            iconsList.add(iconMap);
        }
        return iconsList;
    }
}
