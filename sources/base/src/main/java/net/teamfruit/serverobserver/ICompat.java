package net.teamfruit.serverobserver;

import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;

public interface ICompat {

	void color(float colorRed, float colorGreen, float colorBlue, float colorAlpha);

	List<GuiButton> getButtonList(InitGuiEvent e);

	FontRenderer font(Minecraft mc);

	int getHeight(GuiDisconnected dcgui);

	GuiScreen getParentScreen(GuiDisconnected dcgui);

	GuiButton getButton(ActionPerformedEvent e);

	int getSelected(GuiMultiplayer mpgui);

	void connectToServer(GuiScreen mpgui, @Nonnull ServerData serverData);

	boolean getPinged(@Nonnull ServerData serverData);

	void setPinged(@Nonnull ServerData serverData, boolean pinged);

	void ping(GuiMultiplayer mpgui, @Nonnull ServerData serverData) throws Exception;

	String getDefaultSound();

	void playSound(Minecraft mc, ResourceLocation sound, float pitch);

	void selectServer(GuiMultiplayer mpgui, int index);

	@Deprecated
	ServerData getServerData(GuiMultiplayer mpgui, int index);

	ServerList getServerList(GuiMultiplayer mpgui);

	GuiButton createSkeletonButton(final int buttonId, final int x, final int y, final int widthIn, final int heightIn, final String buttonText, final SkeletonButtonDrawInside inside);

	ThreadPoolExecutor getThreadPool();

	NetworkManager getClientToServerNetworkManager();

	SocketAddress getSocketAddress(NetworkManager netManager);

}