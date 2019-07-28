package com.netcracker.gurev.calculator;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;


public class Handler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{

            //ByteBuf in = (ByteBuf) msg;
            //String input = in.toString(CharsetUtil.US_ASCII);
            Calculator deepThought = new Calculator();
            String result = deepThought.countServer((String)msg);
            Channel channel = ctx.channel();

            channel.write("Answer: " + result + "\n");
            channel.flush();
            //System.out.println(result);
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel active");
        super.channelActive(ctx);
    }
}


