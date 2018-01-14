package baseball.ticket;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.controller.SubControll;
import baseball.model.PathData;
import baseball.ticket.model.TicketVo;

@Service
public class Ticket implements SubControll{

	/**
	 * @uml.property  name="data"
	 * @uml.associationEnd  readOnly="true"
	 */
	@Resource
	PathData data;
	
	/**
	 * @uml.property  name="vo"
	 * @uml.associationEnd  readOnly="true"
	 */
	TicketVo vo;

	@Override
	public void execute() {
		
	}

}
