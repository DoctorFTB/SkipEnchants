package ftblag.skipenchants.client;

import ftblag.skipenchants.network.NetworkHandler;
import ftblag.skipenchants.network.PacketSkipEnchants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.EnchantmentScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent.Post;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
    @SubscribeEvent
    public static void onGuiOpen(Post event) {
        if (event.getGui() instanceof EnchantmentScreen) {
            EnchantmentScreen gui = (EnchantmentScreen) event.getGui();
            TranslationTextComponent component = new TranslationTextComponent("button.skip_enchants.skip");
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
