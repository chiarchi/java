package it.spindox.tutor.spindoxspring.adapter;

import it.spindox.tutor.spindoxspring.manager.ChannelManager;
import it.spindox.tutor.spindoxspring.manager.SpindoxMessageManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelAdapter {

    private final ChannelManager manager;


    public void onMessageReceived() {

        log.info("do something");
    }

    //sottoscritto al topic di rabbit
    //ricevo messaggi
        // do somethings --> save db


}
