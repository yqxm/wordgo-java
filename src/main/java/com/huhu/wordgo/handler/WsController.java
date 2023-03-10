package com.huhu.wordgo.handler;

import com.huhu.wordgo.model.WsInput;
import com.huhu.wordgo.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WsController {

    WsService wsService;

    @Autowired
    public void setWsService(WsService wsService) {
        this.wsService = wsService;
    }

    @PostMapping("/word_sentence")
    public void receiveInput(@RequestBody WsInput wsInput) {
        wsService.processWsInput(wsInput);
    }
}
