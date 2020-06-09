package de.datasecs.hydra.example.client.udp;

import de.datasecs.hydra.example.shared.udp.ExampleUDPPacket;
import de.datasecs.hydra.shared.protocol.impl.HydraProtocol;

/*
 * Created with love by DataSecs on 17.12.19
 */
public class UdpClientProtocol extends HydraProtocol {

    public UdpClientProtocol() {
        registerPacket(ExampleUDPPacket.class);
        registerListener(new UdpClientPacketListener());
    }
}