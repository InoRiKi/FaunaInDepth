package net.inorecon.faunaindepth.item;

import net.inorecon.faunaindepth.FaunaInDepth;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FaunaInDepth.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
