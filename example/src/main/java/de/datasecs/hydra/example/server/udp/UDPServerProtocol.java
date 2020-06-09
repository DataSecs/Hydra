package de.datasecs.hydra.example.server.udp;

import de.datasecs.hydra.example.shared.udp.ExampleUDPPacket;
import de.datasecs.hydra.shared.protocol.impl.HydraProtocol;

/*
 * Created with love by DataSecs on 17.12.19
 */
public class UdpServerProtocol extends HydraProtocol {

    public UdpServerProtocol() {
        registerPacket(ExampleUDPPacket.class);

        // Register packet listener
        registerListener(new UdpServerPacketListener());
    }
}