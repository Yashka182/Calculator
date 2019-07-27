package com.netcracker.gurev.calculator;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
    String server;
    int port;
    int selfPort;

    public Client(String server, int port, int selfPort){
        this.server = server;
        this.port = port;
        this.selfPort = selfPort;
    }

    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();

        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.SO_KEEPALIVE, true)
             .handler(new ChannelInitializer<SocketChannel>(){
                 @Override
                 public void initChannel(SocketChannel socketChannel) throws Exception {
                     socketChannel.pipeline().addLast(new ClientHandler());
                 }
             });
            System.out.println("Client started");
            Channel channel = b.connect(server, port).sync().channel();

            channel.write("1 2 +");
            channel.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args){
        String server = "localhost";
        int port = 8080;
        int selfPort = 1111;
        new Client(server, port, selfPort).run();
    }
}
