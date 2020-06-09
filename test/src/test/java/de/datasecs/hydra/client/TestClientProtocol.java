package de.datasecs.hydra.client;

import de.datasecs.hydra.shared.ArrayPacket;
import de.datasecs.hydra.shared.FinishedPacket;
import de.datasecs.hydra.shared.TestPacket;
import de.datasecs.hydra.shared.protocol.impl.HydraProtocol;

/**
 * Created by DataSec on 07.02.2019.
 */
public class TestClientProtocol extends HydraProtocol {

    public TestClientProtocol() {
        registerPacket(TestPacket.class);
        registerPacket(ArrayPacket.class);
        registerPacket(FinishedPacket.class);
        registerListener(new TestClientPacketListener());
    }
}