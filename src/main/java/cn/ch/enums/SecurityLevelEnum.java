package cn.ch.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: zsw
 * @CreateDate: 2020/8/25 15:27
 * @UpdateUser: zsw
 * @UpdateDate: 2020/8/25 15:27
 * @UpdateRemark: 修改内容-无
 * @Version: 1.0
 */
public enum SecurityLevelEnum {
    A("A", "A级"),
    B("B", "B级"),
    C("C", "C级"),
    D("D", "D级"),
    E("E", "E级");
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    SecurityLevelEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static SecurityLevelEnum getValue(String key) {
        SecurityLevelEnum[] values = SecurityLevelEnum.values();
        List<SecurityLevelEnum> cycleEnums = Arrays.asList(values);
        Optional<SecurityLevelEnum> first = cycleEnums.stream()
                .filter(e -> e.getKey().equals(key))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }


    public static SecurityLevelEnum getKey(String value) {
        SecurityLevelEnum[] values = SecurityLevelEnum.values();
        List<SecurityLevelEnum> cycleEnums = Arrays.asList(values);
        Optional<SecurityLevelEnum> first = cycleEnums.stream()
                .filter(e -> e.getValue().equals(value))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
}
