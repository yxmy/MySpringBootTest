package cn.gov.sapprft.mtms.ftqrs.service;

import cn.gov.sapprft.mtms.ftqrs.bean.TicketEntryQueryRequestBean;

public interface TicketCheckService {
	
	void getTicketInfoByQCode(TicketEntryQueryRequestBean bean);

}
