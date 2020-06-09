package de.datasecs.hydra.server;

import de.datasecs.hydra.shared.ArrayPacket;
import de.datasecs.hydra.shared.FinishedPacket;
import de.datasecs.hydra.shared.TestPacket;
import de.datasecs.hydra.shared.handler.Session;
import de.datasecs.hydra.shared.protocol.packets.StandardPacket;
import de.datasecs.hydra.shared.protocol.packets.listener.HydraPacketListener;
import de.datasecs.hydra.shared.protocol.packets.listener.PacketHandler;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DataSec on 28.03.2019.
 */
public class TestServerPacketListener implements HydraPacketListener {

    private String[] testArray = new String[1000];

    private List<String> testList = new ArrayList<>();

    private int packetCounter = 0;

    public TestServerPacketListener() {
        // Create test array
        for (int i = 0; i < 1000; i++) {
            testArray[i] = String.format("test%d", i);
        }

        // Create test list
        for (int i = 0; i < 1000; i++) {
            testList.add(String.format("test%d", i));
        }
    }

    @PacketHandler
    public void onTestPacket(TestPacket testPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        switch (testPacket.getNumber()) {
            case 0:
                Assertions.assertEquals("Test", testPacket.getObject().toString());
                break;
            case 1:
                Assertions.assertEquals("Test" + packetCounter, testPacket.getObject().toString());
                packetCounter++;
                break;
            case 2:
                Assertions.assertIterableEquals(testList, (Iterable<?>) testPacket.getObject());
                break;
        }

        session.send(new StandardPacket("#Received!"));
    }

    @PacketHandler
    public void onArrayPacket(ArrayPacket arrayPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        Assertions.assertArrayEquals(testArray, arrayPacket.getStrings());
    }

    @PacketHandler
    public void onFinishedPacket(FinishedPacket finishedPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        session.send(new FinishedPacket(finishedPacket.getNumber()));
    }

    @PacketHandler
    public void onStandardPacket(StandardPacket standardPacket, Session session) {
        Assertions.assertTrue(session.isConnected());
        session.send(new StandardPacket("#Received!"));
    }
}