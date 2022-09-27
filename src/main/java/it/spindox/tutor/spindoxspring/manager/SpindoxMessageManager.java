package it.spindox.tutor.spindoxspring.manager;

import it.spindox.tutor.spindoxspring.model.SpindoxMessage;

public interface SpindoxMessageManager {

    SpindoxMessage serialize(String payload);

    String deSerialize(SpindoxMessage message);

}
