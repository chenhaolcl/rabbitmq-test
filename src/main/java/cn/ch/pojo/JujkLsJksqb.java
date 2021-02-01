package cn.ch.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据接口申请表
 * </p>
 *
 * @author gaowj@asp.citic.com
 * @since Thu Jul 02 14:18:09 CST 2020
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

	public static final String ACTUALIP = "actualip";

	public static final String ID = "id";

	public static final String JKID = "jkid";

	public static final String MAC = "mac";

	public static final String ORGNCODE = "orgncode";

	public static final String QTZT = "qtzt";

	public static final String QYSJ = "qysj";

	public static final String RKRQ = "rkrq";

	public static final String SM2GY = "sm2gy";

	public static final String SM2MY = "sm2my";

	public static final String SM4GXRQ = "sm4gxrq";

	public static final String SM4MY = "sm4my";

	public static final String TZSJ = "tzsj";

	public static final String USERID = "userid";

	public static final String VISITIP = "visitip";

	public static final String XGRQ = "xgrq";


}
