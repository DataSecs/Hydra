package de.datasecs.hydra.example.client.udp;

import de.datasecs.hydra.example.shared.udp.ExampleUDPPacket;
import de.datasecs.hydra.shared.handler.impl.UDPSession;
import de.datasecs.hydra.shared.protocol.packets.listener.HydraPacketListener;
import de.datasecs.hydra.shared.protocol.packets.listener.PacketHandler;

/*
 * Created with love by DataSecs on 17.12.19
 */
public class UdpClientPacketListener implements HydraPacketListener {

    @PacketHandler
    public void onExampleUDPPacket(ExampleUDPPacket exampleUDPPacket, UDPSession session) {
        System.out.println("\n---PACKET-LISTENER OUTPUT---");

        System.out.printf("Received from server using the ExampleUDPPacket: %s%nSession: %s", exampleUDPPacket, session);

        //session.close();
        //System.out.println("\nSession closed!");
    }
}