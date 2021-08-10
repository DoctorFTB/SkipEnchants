package ftblag.skipenchants.network;

import ftblag.skipenchants.SkipEnchants;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry.ChannelBuilder;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel network;

    public static void init() {
        String version = "1";
        network = ChannelBuilder.named(new ResourceLocation(SkipEnchants.MODID, SkipEnchants.MODID))
                .clientAcceptedVersions(version::equals)
                .serverAcceptedVersions(version::equals)
                .networkProtocolVersion(() -> version)
                .simpleChannel();
        network.registerMessage(0, PacketSkipEnchants.class, PacketSkipEnchants::encode, PacketSkipEnchants::decode, PacketSkipEnchants::handle);
    }
}
