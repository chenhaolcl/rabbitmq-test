package cn.ch.pojo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据接口申请表
 * </p>
 *
 * @author lichao@asp.citic.com
 * @since Wed Jul 01 09:55:32 CST 2020
 */
@Data
@Accessors(chain = true)
public class JujkLsJksqb implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实际地址
     */
	private String actualip;
    /**
     * 主键ID
     */
	private String id;
    /**
     * 接口ID
     */
	private String jkid;
    /**
     * MAC地址
     */
	private String mac;
    /**
     * 金融机构编码
     */
	private String orgncode;
    /**
     * 启停状态
     */
	private String qtzt;
    /**
     * 启用时间
     */
	private Date qysj;
    /**
     * 入库日期
     */
	private Date rkrq;
    /**
     * SM2公钥
     */
	private String sm2gy;
    /**
     * SM2密钥
     */
	private String sm2my;
    /**
     * SM4密钥更新日期
     */
	private Date sm4gxrq;
    /**
     * SM4密钥
     */
	private String sm4my;
    /**
     * 停用时间
     */
	private Date tzsj;
    /**
     * 操作人ID
     */
	private String userid;
    /**
     * 访问IP地址
     */
	private String visitip;
    /**
     * 更新日期
     */
	private Date xgrq;


}
