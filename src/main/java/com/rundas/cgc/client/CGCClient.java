package com.rundas.cgc.client;

import net.minecraftforge.eventbus.api.IEventBus;

public class CGCClient {
    public static void init(IEventBus modEventBus) {
        modEventBus.register(CGCClient.class);
    }
}
