package ftblag.skipenchants;

import ftblag.skipenchants.client.ClientEvents;
import ftblag.skipenchants.network.NetworkHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SkipEnchants.MODID)
public class SkipEnchants {
    public static final String MODID = "skip_enchants";

    public SkipEnchants() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
    }

    private void setup(FMLCommonSetupEvent event) {
        NetworkHandler.init();
    }

    private void setupClient(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(ClientEvents.class);
    }
}
