package github.com.dmcclung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import github.com.dmcclung.messaging.MessageNotFoundException;
import github.com.dmcclung.messaging.MessengerService;

@RestController
public class MessengerController {
	@Autowired
	MessengerService messengerService;	

	@GetMapping("/message")
	public long message(@RequestParam(value = "msg") String msg) throws MessageNotFoundException {
		if (msg != null) {
			return messengerService.publishMessage(msg);			
		}

		throw new MessageNotFoundException();
	}

	@GetMapping("/count")
	public long messageCount() {
		return messengerService.getCount();
	}

	@GetMapping("/receiver")
	public boolean receiverActive() {
		return messengerService.isReceiverActive();
	}

}
