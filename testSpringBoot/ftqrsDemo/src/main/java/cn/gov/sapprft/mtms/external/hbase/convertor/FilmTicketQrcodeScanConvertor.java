package cn.gov.sapprft.mtms.external.hbase.convertor;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Component;

import cn.gov.sapprft.mtms.external.hbase.bean.FilmTicketQrcodeScanBean;

@Component
public class FilmTicketQrcodeScanConvertor implements HBaseConvertor<FilmTicketQrcodeScanBean> {

    public static byte[] b_family = Bytes.toBytes("f");

    public static byte[] b_seq_id = Bytes.toBytes("si");
    public static byte[] b_open_id = Bytes.toBytes("oi");
    public static byte[] b_nickname = Bytes.toBytes("nn");
    public static byte[] b_mobile = Bytes.toBytes("mi");
    public static byte[] b_time = Bytes.toBytes("ti");
    public static byte[] b_source_channel = Bytes.toBytes("scl");
    public static byte[] b_sex = Bytes.toBytes("se");
    public static byte[] b_client_ip = Bytes.toBytes("ci");
    public static byte[] b_country = Bytes.toBytes("cr");
    public static byte[] b_province = Bytes.toBytes("pv");
    public static byte[] b_city = Bytes.toBytes("ct");
    public static byte[] b_qrcode = Bytes.toBytes("qc");
    public static byte[] b_client_no = Bytes.toBytes("cn");
    public static byte[] b_cinema_code = Bytes.toBytes("cc");
    public static byte[] b_film_code = Bytes.toBytes("fc");
    public static byte[] b_screen_code = Bytes.toBytes("src");
    public static byte[] b_session_code = Bytes.toBytes("ssc");
    public static byte[] b_seat_code = Bytes.toBytes("sc");
    public static byte[] b_system_code = Bytes.toBytes("stc");
    public static byte[] b_seller_code = Bytes.toBytes("slc");
    public static byte[] b_printer_code = Bytes.toBytes("pc");
    public static byte[] b_machine_code = Bytes.toBytes("mc");
    public static byte[] b_successed = Bytes.toBytes("sd");

    @Override
    public FilmTicketQrcodeScanBean toBean(final Result result) {
        final FilmTicketQrcodeScanBean bean = new FilmTicketQrcodeScanBean();
        bean.setSeqId(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family, 
        		FilmTicketQrcodeScanConvertor.b_seq_id)));
        bean.setOpenId(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family, 
        		FilmTicketQrcodeScanConvertor.b_open_id)));
        bean.setNickname(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_nickname)));
        bean.setMobile(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_mobile)));
        bean.setTime(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_time)));
        bean.setSourceChannel(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_source_channel)));
        bean.setSex(Bytes.toInt(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_sex)));
        bean.setClientIp(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_client_ip)));
        bean.setCountry(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_country)));
        bean.setProvince(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_province)));
        bean.setCity(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_city)));
        bean.setQrcode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_qrcode)));
        bean.setClientNo(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_client_no)));
        bean.setCinemaCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family, 
        		FilmTicketQrcodeScanConvertor.b_cinema_code)));
        bean.setFilmCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_film_code)));
        bean.setScreenCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_screen_code)));
        bean.setSessionCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_session_code)));
        bean.setSeatCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_seat_code)));
        bean.setSystemCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_system_code)));
        bean.setSellerCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_seller_code)));
        bean.setPrinterCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_printer_code)));
        bean.setMachineCode(Bytes.toString(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_machine_code)));
        bean.setSuccessed(Bytes.toInt(result.getValue(FilmTicketQrcodeScanConvertor.b_family,
        		FilmTicketQrcodeScanConvertor.b_successed)));
        return bean;
    }

    @Override
    public Put toPut(final FilmTicketQrcodeScanBean payload) {
        final Put p = new Put(Bytes.toBytes(payload.getRowkey()));

        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_seq_id,
                Bytes.toBytes((payload.getSeqId() == null)?"":payload.getSeqId()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_open_id,
                Bytes.toBytes((payload.getOpenId() == null)?"":payload.getOpenId()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_nickname,
                Bytes.toBytes((payload.getNickname() == null)?"":payload.getNickname()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_mobile,
                Bytes.toBytes((payload.getMobile() == null)?"":payload.getMobile()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_time,
                Bytes.toBytes((payload.getTime() == null)?"":payload.getTime()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_source_channel,
                Bytes.toBytes((payload.getSourceChannel() == null)?"":payload.getSourceChannel()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_sex,
                Bytes.toBytes(payload.getSex()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_client_ip,
                Bytes.toBytes((payload.getClientIp() == null)?"":payload.getClientIp()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_country,
                Bytes.toBytes((payload.getCountry() == null)?"":payload.getCountry()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_province,
                Bytes.toBytes((payload.getProvince() == null)?"":payload.getProvince()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_city,
                Bytes.toBytes((payload.getCity() == null)?"":payload.getCity()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_qrcode,
                Bytes.toBytes((payload.getQrcode() == null)?"":payload.getQrcode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_client_no,
                Bytes.toBytes((payload.getClientNo() == null)?"":payload.getClientNo()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_cinema_code,
                Bytes.toBytes((payload.getCinemaCode() == null)?"":payload.getCinemaCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_film_code,
                Bytes.toBytes((payload.getFilmCode() == null)?"":payload.getFilmCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_screen_code,
                Bytes.toBytes((payload.getScreenCode() == null)?"":payload.getScreenCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_session_code,
                Bytes.toBytes((payload.getSessionCode() == null)?"":payload.getSessionCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_seat_code,
                Bytes.toBytes((payload.getSeatCode() == null)?"":payload.getSeatCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_system_code,
                Bytes.toBytes((payload.getSystemCode() == null)?"":payload.getSystemCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_seller_code,
                Bytes.toBytes((payload.getSellerCode() == null)?"":payload.getSellerCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_printer_code,
                Bytes.toBytes((payload.getPrinterCode() == null)?"":payload.getPrinterCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_machine_code,
                Bytes.toBytes((payload.getMachineCode() == null)?"":payload.getMachineCode()));
        p.add(FilmTicketQrcodeScanConvertor.b_family, FilmTicketQrcodeScanConvertor.b_successed,
                Bytes.toBytes(payload.getSuccessed()));
        return p;
    }

}
