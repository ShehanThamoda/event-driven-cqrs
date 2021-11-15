package lk.dialog.eventdriven.orderservice.command.listner;

import com.fasterxml.jackson.core.JsonProcessingException;
import lk.dialog.eventdriven.orderservice.command.dto.AuditDto;
import lk.dialog.eventdriven.orderservice.command.service.OrderCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageProduceEventListener {

    private final OrderCommandService orderCommandService;

    @Async
    @EventListener
    public void OnProduceMessageEvent(AuditDto auditDto) throws JsonProcessingException {
        log.info("Successfully listen");
        orderCommandService.sendAuditEvent(auditDto);
    }


}
