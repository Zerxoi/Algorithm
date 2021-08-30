package ot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CTripSolution2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.trim().equals("")) {
                break;
            }
            System.out.println(line);
            list.add(line);
        }
        for (int i = 0; i < list.size() - 1; i++) {
            String line = list.get(i);
            int index = line.indexOf(':');
            line = line.substring(index + 1);
            index = line.indexOf(':');
            String val = line.substring(0, index);
            String s = line.substring(index + 1);
            System.out.println(s);
            String[] keys = s.split(",");
            for (int j = 0; j < keys.length; j++) {
                List<String> l = map.get(keys[j]);
                if (l != null) {
                    l.add(val);
                    map.put(keys[j], l);
                } else {
                    List<String> tmpList = new ArrayList<>();
                    tmpList.add(val);
                    map.put(keys[j], tmpList);
                }
            }
        }
        String line = list.get(list.size() - 1);
        int index = line.indexOf(":");
        line = line.substring(index);
        for (int i = 0; i < line.length();) {
            int tmp = i;
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                int j = 0;
                while (j < s.length() && i + j < line.length()) {
                    if (s.charAt(j) != line.charAt(i + j)) {
                        break;
                    }
                    j++;
                }
                if (j == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s + ":[");
                    List<String> l = map.get(s);
                    for (String string : l) {
                        sb.append(string + ",");
                    }
                    sb.setCharAt(sb.length() - 1, ']');
                    System.out.println(sb.toString());
                    i += j;
                    break;
                }
            }
            if (tmp == i) {
                i++;
            }
        }
        input.close();
    }
}

// dict:目的地:三亚,北京,上海
// dict:出发地:南京,苏州
// dict:出游类型:跟团游,自由行
// dict:供应商:携程自营
// dict:节假日:春节
// query:​我想春节从南京去三亚和海口潜水跟团游5天5钻携程自营

// dict:tingci:woxiang,de,cong,qu
// dict:mudidi:sanya,beijing,shanghai,woxiang
// dict:chufadi:nanjing,jiangsu
// dict:chuyouleixing:gentuanyou,ziyouxing
// dict:gongyingshang:xiechengziying
// dict:jiejiari:chunjie
// query:woxiangchunjiecongnanjingqusanyahehaikouqianshuigentuanyou5tian5zuoxiechengziying
// 样例输出
// 我想:[停词]
// 春节:[节假日]
// 从:[停词]
// 南京:[出发地]
// 去:[停词]
// 三亚:[目的地]
// 跟团游:[出游类型]
// 携程自营:[供应商]

// 背景介绍：搜索引擎中用户的录入可能五花八门，要精确进行query识别，其中比较简单处理方式就是进行词库规则匹配

// 样例解释：比如“我想春节从南京去三亚潜水跟团游5天5钻携程自营”，可以解析为：“我想->停词，春节->节假日，南京->出发地，三亚->目的地，潜水->关键词，跟团游->出游类型，携程自营->供应商”。要求给出输入词库及匹配字符串，把尽可能多的模式串匹配出来，词库里没有的做为关键词

// 数据范围：

// 输入字符串长度：0到7168

// 输出字符串大小: 最大1024