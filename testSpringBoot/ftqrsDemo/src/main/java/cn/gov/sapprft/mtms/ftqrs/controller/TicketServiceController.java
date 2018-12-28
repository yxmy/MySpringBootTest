package cn.gov.sapprft.mtms.ftqrs.controller;

import javax.validation.Valid;

import com.leadingsoft.bizfuse.common.web.dto.result.ResultDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.gov.sapprft.mtms.ftqrs.bean.TicketEntryQueryRequestBean;
import cn.gov.sapprft.mtms.ftqrs.service.TicketService;

import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/data/hbase")
public class TicketServiceController {
	
	@Autowired
	private TicketService ticketService;
	
	@Timed
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDTO<Void> query(@RequestBody @Valid final TicketEntryQueryRequestBean ticketEntryQueryRequestBean) {

		this.ticketService.checkTicketInfo(ticketEntryQueryRequestBean);
		return ResultDTO.success();

	}

}
