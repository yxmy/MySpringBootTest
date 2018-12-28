package cn.gov.sapprft.mtms.external.hbase.bean;


import lombok.Getter;
import lombok.Setter;

/**
 * 影票二维码扫描记录
 */
@Getter
@Setter
public class FilmTicketQrcodeScanBean {

	private String seqId;
	private String openId;
	private String nickname;
	private String mobile;
	private String time;
	private String sourceChannel;
	private int sex; //0:女;1:男；2:未知
	private String clientIp;
	private String country;
	private String province;
	private String city;
	private String qrcode;
	private String clientNo;
    private String cinemaCode;
    private String filmCode;
    private String screenCode;
    private String sessionCode;
    private String seatCode;
    private String systemCode;
    private String sellerCode;
    private String printerCode;
    private String machineCode;
    private int successed; //1成功，0失败
    public String getRowkey() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.seqId);
        sb.append(this.sessionCode);
        sb.append(this.seatCode);
        return sb.toString();
    }

}
