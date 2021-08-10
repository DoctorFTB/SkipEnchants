//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ftblag.skipenchants.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraftforge.fmllegacy.network.NetworkEvent.Context;

import java.util.function.Supplier;

public class PacketSkipEnchants {
    public PacketSkipEnchants() {
    }

    public static void encode(PacketSkipEnchants msg, FriendlyByteBuf buffer) {
    }

    public static PacketSkipEnchants decode(FriendlyByteBuf buffer) {
        return new PacketSkipEnchants();
    }

    public static void handle(PacketSkipEnchants msg, Supplier<Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.containerMenu instanceof EnchantmentMenu) {
                EnchantmentMenu container = (EnchantmentMenu) player.containerMenu;
                player.enchantmentSeed = player.getRandom().nextInt();
                container.enchantmentSeed.set(player.enchantmentSeed);
                container.slotsChanged(container.enchantSlots);
            }

        });
        ctx.get().setPacketHandled(true);
    }
}
