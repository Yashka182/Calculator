package com.netcracker.gurev.calculator;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;


public class Handler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            ByteBuf in = (ByteBuf) msg;
            Calculator deepThought = new Calculator();
            float result = deepThought.countServer(in.toString(CharsetUtil.US_ASCII));
            ctx.writeAndFlush(result);
            System.out.println(result);
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }


}


