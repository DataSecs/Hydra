package de.datasecs.hydra.example.server.udp;

import de.datasecs.hydra.example.shared.udp.ExampleUDPPacket;
import de.datasecs.hydra.shared.handler.impl.UDPSession;
import de.datasecs.hydra.shared.protocol.packets.listener.HydraPacketListener;
import de.datasecs.hydra.shared.protocol.packets.listener.PacketHandler;
import io.netty.util.internal.SocketUtils;

/*
 * Created with love by DataSecs on 17.12.19
 */
public class UDPServerPacketListener implements HydraPacketListener {

    public UDPServerPacketListener() {
        // Do something
    }

    @PacketHandler
    public void onExampleUDPPacket(ExampleUDPPacket exampleUDPPacket, UDPSession session) {
        System.out.println("\n---PACKET-LISTENER OUTPUT---");
        System.out.printf("Received from client using the ExampleUDPPacket: %s%nSession: %s", exampleUDPPacket, session);

        session.send(new ExampleUDPPacket("Received!", session.getSender()));

        System.out.printf("Session: %s%n", session);
        System.out.printf("Session active: %s%n", session.isActive());
        System.out.printf("Sender address: %s%n", session.getSender());
        System.out.printf("Channel: %s%n%n", session.getChannel());

        //session.close();
        //System.out.println("\nSession closed!");
    }
}