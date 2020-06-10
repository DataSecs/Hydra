package de.datasecs.hydra.client;

import de.datasecs.hydra.HydraBasicTest;
import de.datasecs.hydra.shared.FinishedPacket;
import de.datasecs.hydra.shared.Logger;
import de.datasecs.hydra.shared.handler.Session;
import de.datasecs.hydra.shared.protocol.packets.StandardPacket;
import de.datasecs.hydra.shared.protocol.packets.listener.HydraPacketListener;
import de.datasecs.hydra.shared.protocol.packets.listener.PacketHandler;
import org.junit.jupiter.api.Assertions;

/**
 * Created by DataSec on 28.03.2019.
 */
public class TestClientPacketListener implements HydraPacketListener {

    public TestClientPacketListener() {}

    @PacketHandler
    public void onFinishedPacket(FinishedPacket finishedPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        Logger.logSuccess(String.format("Phase %d done!", finishedPacket.getNumber()));

        synchronized (HydraBasicTest.LOCK) {
            HydraBasicTest.phaseFinished = true;
            HydraBasicTest.LOCK.notify();
        }
    }

    @PacketHandler
    public void onStandardPacket(StandardPacket standardPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        Assertions.assertEquals("#Received!", standardPacket.toString());
    }
}