package cn.ch.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Classname UploadFinanceDataReq
 * @Description
 * @create 2021/3/3
 * @Author chenhao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFinanceDataReq {

    /**
     * 开始日期 年月日
     */
    private LocalDate beginTime;

    /**
     * 截止日期 年月日
     */
    private LocalDate endTime;

    /**
     * 融资需求发布方式
     */
    private Integer financingNeedsType;

}
