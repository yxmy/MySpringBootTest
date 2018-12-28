package cn.gov.sapprft.mtms.ftqrs.service.impl;

import cn.gov.sapprft.mtms.external.hbase.bean.FilmTicketQrcodeScanBean;
import cn.gov.sapprft.mtms.external.hbase.repository.FilmTicketQrcodeScanRepository;
import cn.gov.sapprft.mtms.ftqrs.bean.TicketEntryQueryRequestBean;
import cn.gov.sapprft.mtms.ftqrs.service.TicketCheckService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@Transactional
public class TicketCheckServiceImpl implements TicketCheckService {
	
	@Autowired
	private FilmTicketQrcodeScanRepository filmTicketQrcodeScanRepository;

	@Override
	public void getTicketInfoByQCode(TicketEntryQueryRequestBean bean) {

        FilmTicketQrcodeScanBean ticketBean = new FilmTicketQrcodeScanBean();
        ticketBean.setSeqId(bean.getSeqId());
        ticketBean.setOpenId(bean.getOpenId());
        ticketBean.setNickname(bean.getNickname());
        ticketBean.setMobile(bean.getMobile());
        ticketBean.setTime(formatOfBusinessTime(bean.getTime()));
        ticketBean.setSourceChannel(bean.getSourceChannel().toString());
        ticketBean.setSex(bean.getSex());
        ticketBean.setClientIp(bean.getClientIP());
        ticketBean.setCountry(bean.getCountry());
        ticketBean.setProvince(bean.getProvince());
        ticketBean.setCity(bean.getCity());
        ticketBean.setQrcode(bean.getQrcode());
        ticketBean.setClientNo(bean.getClientNo());
        ticketBean.setCinemaCode(bean.getCinemaCode());
        ticketBean.setFilmCode(bean.getFilmCode());
        ticketBean.setScreenCode(bean.getScreenCode());
        ticketBean.setSessionCode(bean.getSessionCode());
        ticketBean.setSeatCode(bean.getSeatCode());
        ticketBean.setSystemCode(bean.getSystemCode());
        ticketBean.setSellerCode(bean.getSellerCode());
        ticketBean.setPrinterCode(bean.getPrinterCode());
        ticketBean.setMachineCode(bean.getMachineCode());
        ticketBean.setSuccessed(bean.getSuccessed());
        List<FilmTicketQrcodeScanBean> ticketBeans = new ArrayList<>();
        ticketBeans.add(ticketBean);
        try {
            boolean flag = filmTicketQrcodeScanRepository.save(ticketBeans);
            if(flag) {
                TicketCheckServiceImpl.log.info("保存大数据库成功");
            }else {
                TicketCheckServiceImpl.log.info("保存大数据库失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            TicketCheckServiceImpl.log.info("保存大数据库失败。异常信息：" + e1.getMessage());
        }

	}

    private String formatOfBusinessTime(final Date dateTime) {
        return DateFormatUtils.format(dateTime, "yyyy-MM-dd'T'HH:mm:ss", Locale.CHINA);
    }

}
