package com.github.amongus.game.tasks.misc;

import java.nio.ByteBuffer;

import org.bukkit.entity.ItemFrame;

import com.github.amongus.AmongUs;
import com.github.amongus.map.ImageDither;

public class Camera {
	
	// In Progress -PulseBeat_02
	
	private ItemFrame frame;
	
	public Camera(ItemFrame f) {
		this.setFrame(f);
		// ItemFrameCallback callback = new ItemFrameCallback(null, 0, 1, 1, 320, 0);
		// VideoPlayer player = new VideoPlayer(url, 640, 480, callback::send);
	}

	public void display(int[] data) {
		ByteBuffer dithered = ImageDither.ditherIntoMinecraft(data, 480);
		AmongUs.getHandler().display(null, 0, 5, 5, dithered, 0);
	}

	public ItemFrame getFrame() {
		return frame;
	}

	public void setFrame(ItemFrame frame) {
		this.frame = frame;
	}

}
