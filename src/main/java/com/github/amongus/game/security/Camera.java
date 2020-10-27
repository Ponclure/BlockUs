package com.github.amongus.game.security;

import java.nio.ByteBuffer;

import org.bukkit.entity.ItemFrame;

import com.github.amongus.AmongUs;
import com.github.amongus.map.ImageDither;
import com.github.amongus.map.ItemFrameCallback;

public class Camera {
	// In Progress -PulseBeat_02
	private ItemFrame frame;
	
	public Camera(ItemFrame f) {
		this.frame = f;
		ItemFrameCallback callback = new ItemFrameCallback(null, 0, 1, 1, 320, 0);
		// VideoPlayer player = new VideoPlayer(url, 640, 480, callback::send);

	}

	public void display(int[] data) {
		ByteBuffer dithered = ImageDither.ditherIntoMinecraft(data, 480);
		AmongUs.getHandler().display(null, 0, 5, 5, dithered, 0);
	}

}
