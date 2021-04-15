package cn.ch.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description: 数据目录共享 更新周期
 * @Author: zsw
 * @CreateDate: 2020/8/10 10:19
 * @UpdateUser: zsw
 * @UpdateDate: 2020/8/10 10:19
 * @UpdateRemark: 修改内容-无
 * @Version: 1.0
 */
public enum UpdateCycleEnum {
    REALTIME("1", "实时"),
    DAY("2", "日"),
    MONTH("3", "月"),
    SEASON("4", "季"),
    HALFYEAR("5", "半年"),
    YEAR("6", "年"),
    WEEK("7", "周"),
    CUSTOMIZE("8","自定义"),
    JISHI("9","即时");

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    UpdateCycleEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static UpdateCycleEnum getValue(String key) {
        UpdateCycleEnum[] values = UpdateCycleEnum.values();
        List<UpdateCycleEnum> cycleEnums = Arrays.asList(values);
        Optional<UpdateCycleEnum> first = cycleEnums.stream()
                .filter(cycleEnum -> cycleEnum.getKey().equals(key))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;

    }

    public static UpdateCycleEnum getKey(String value) {
        UpdateCycleEnum[] values = UpdateCycleEnum.values();
        List<UpdateCycleEnum> cycleEnums = Arrays.asList(values);
        Optional<UpdateCycleEnum> first = cycleEnums.stream()
                .filter(cycleEnum -> cycleEnum.getValue().equals(value))
                .findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }
}
