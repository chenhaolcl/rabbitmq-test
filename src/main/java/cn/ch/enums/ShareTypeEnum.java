package cn.ch.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 数据目录共享 共享类型
 * @Author: zsw
 * @CreateDate: 2020/8/10 11:02
 * @UpdateUser: zsw
 * @UpdateDate: 2020/8/10 11:02
 * @UpdateRemark: 修改内容-无
 * @Version: 1.0
 */
public enum ShareTypeEnum {
    LIMITED("1", "受限共享"),
    UNCONDITIONAL("2", "无条件共享"),
    PART("3", "无条件共享（部分字段受限）");

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    ShareTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static ShareTypeEnum getValue(String key) {
        ShareTypeEnum[] values = ShareTypeEnum.values();
        List<ShareTypeEnum> cycleEnums = Arrays.asList(values);
        Optional<ShareTypeEnum> first = cycleEnums.stream()
                .filter(e -> e.getKey().equals(key))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }


    public static ShareTypeEnum getKey(String value) {
        ShareTypeEnum[] values = ShareTypeEnum.values();
        List<ShareTypeEnum> cycleEnums = Arrays.asList(values);
        Optional<ShareTypeEnum> first = cycleEnums.stream()
                .filter(e -> e.getValue().equals(value))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

}
