package cn.gov.sapprft.mtms.ftqrs.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketEntryQueryRequestBean {

    private String seqId;
    
    private Date time;
    
    private String qrcode;
    
    private SourceChannel sourceChannel;
    
    private String openId;
    
    private String nickname;
    
    private String mobile;
    
    private int sex;
    
    private Double latitude;

    private Double longitude;

    private String clientIP;

    private String clientNo;
    
    private String country;
    
    private String province;
    
    private String city;
    
    private String systemCode;
    
    private String sellerCode;
    
    private String printerCode;
    
    private String machineCode;

    private String cinemaCode;

    private String filmCode;

    private String sessionCode;

    private String screenCode;

    private String seatCode;

    private int successed;
    
    public enum SourceChannel {
    	wechat, // 微信
        qq, // QQ
        alipay // 支付宝
    }

}
