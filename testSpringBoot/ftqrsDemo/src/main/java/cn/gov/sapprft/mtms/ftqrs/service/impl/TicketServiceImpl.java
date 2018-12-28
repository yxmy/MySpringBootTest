package cn.gov.sapprft.mtms.ftqrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gov.sapprft.mtms.ftqrs.bean.TicketEntryQueryRequestBean;
import cn.gov.sapprft.mtms.ftqrs.service.TicketCheckService;
import cn.gov.sapprft.mtms.ftqrs.service.TicketService;

/**
 * 
 * 影片二维码校验接口实现类
 *
 */
@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketCheckService ticketCheckService;

	@Override
	public void checkTicketInfo(TicketEntryQueryRequestBean bean) {
		ticketCheckService.getTicketInfoByQCode(bean);
	}

}
