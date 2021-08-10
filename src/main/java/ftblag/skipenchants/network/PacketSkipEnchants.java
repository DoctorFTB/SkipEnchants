//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ftblag.skipenchants.network;

import java.util.function.Supplier;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.EnchantmentContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class PacketSkipEnchants {
    public PacketSkipEnchants() {
    }

    public static void encode(PacketSkipEnchants msg, PacketBuffer buffer) {
    }

    public static PacketSkipEnchants decode(PacketBuffer buffer) {
        return new PacketSkipEnchants();
    }

    public static void handle(PacketSkipEnchants msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (player != null && player.containerMenu instanceof EnchantmentContainer) {
                EnchantmentContainer container = (EnchantmentContainer) player.containerMenu;
                player.enchantmentSeed = player.getRandom().nextInt();
                container.enchantmentSeed.set(player.enchantmentSeed);
                container.slotsChanged(container.enchantSlots);
            }

        });
        ctx.get().setPacketHandled(true);
    }
}
