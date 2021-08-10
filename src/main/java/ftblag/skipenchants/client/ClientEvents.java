package ftblag.skipenchants.client;

import ftblag.skipenchants.network.NetworkHandler;
import ftblag.skipenchants.network.PacketSkipEnchants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent.Post;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
    @SubscribeEvent
    public static void onGuiOpen(Post event) {
        if (event.getGui() instanceof EnchantmentScreen) {
            EnchantmentScreen gui = (EnchantmentScreen) event.getGui();
            TranslatableComponent component = new TranslatableComponent("button.skip_enchants.skip");
            int textWidth = Minecraft.getInstance().font.width(component.getVisualOrderText()) + 8;
            event.addWidget(
                    new Button(
                            gui.getGuiLeft() + gui.getXSize() - textWidth,
                            gui.getGuiTop() - 19,
                            textWidth,
                            20,
                            component,
                            (button) -> NetworkHandler.network.sendToServer(new PacketSkipEnchants())
                    )
            );
        }

    }
}
