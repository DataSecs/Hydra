package de.datasecs.hydra.shared.initializer;

import de.datasecs.hydra.shared.handler.impl.HydraSession;
import de.datasecs.hydra.shared.protocol.Protocol;
import de.datasecs.hydra.shared.protocol.packets.serialization.PacketDecoder;
import de.datasecs.hydra.shared.protocol.packets.serialization.PacketEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * Created with love by DataSecs on 29.09.2017.
 */
public class HydraChannelInitializer<C extends Channel> extends ChannelInitializer<C> {

    private Protocol protocol;

    private boolean isServer;

    public HydraChannelInitializer(Protocol protocol, boolean isServer) {
        this.protocol = protocol;
        this.isServer = isServer;
    }

    @Override
    protected void initChannel(C channel) {
        ChannelPipeline pipeline = channel.pipeline();

        // In
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4));
        pipeline.addLast(new PacketDecoder(protocol));

        // Out
        pipeline.addLast(new LengthFieldPrepender(4));
        pipeline.addLast(new PacketEncoder(protocol));

        // Create a SimpleChannelInboundHandler in form of a hydra session
        HydraSession session = new HydraSession(channel, protocol);
        pipeline.addLast(session);

        // Add sessions to protocol, to keep track of them
        if (isServer) {
            protocol.addSession(session);
        } else {
            protocol.setClientSession(session);
        }

        // Inform about new session
        if (protocol.getSessionListener() != null) {
            protocol.callSessionListener(true, session);
        } else if (protocol.getSessionConsumer() != null) {
            protocol.callSessionConsumer(true, session);
        }
    }
}