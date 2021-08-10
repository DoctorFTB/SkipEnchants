package ftblag.skipenchants.network;

import ftblag.skipenchants.SkipEnchants;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel network;

    public static void init() {
        String version = "1";
        network = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(SkipEnchants.MODID, SkipEnchants.MODID))
                .clientAcceptedVersions(version::equals)
                .serverAcceptedVersions(version::equals)
                .networkProtocolVersion(() -> version)
                .simpleChannel();
        network.registerMessage(0, PacketSkipEnchants.class, PacketSkipEnchants::encode, PacketSkipEnchants::decode, PacketSkipEnchants::handle);
    }
}
