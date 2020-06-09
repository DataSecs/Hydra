package de.datasecs.hydra.server;

import de.datasecs.hydra.shared.ArrayPacket;
import de.datasecs.hydra.shared.FinishedPacket;
import de.datasecs.hydra.shared.TestPacket;
import de.datasecs.hydra.shared.protocol.impl.HydraProtocol;

/**
 * Created by DataSec on 28.03.2019.
 */
public class TestServerProtocol extends HydraProtocol {

    public TestServerProtocol() {
        registerPacket(TestPacket.class);
        registerPacket(ArrayPacket.class);
        registerPacket(FinishedPacket.class);
        registerListener(new TestServerPacketListener());
    }
}