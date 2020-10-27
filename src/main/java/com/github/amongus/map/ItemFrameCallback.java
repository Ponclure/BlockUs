<<<<<<< HEAD
package com.github.amongus.map;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.github.amongus.AmongUs;

public class ItemFrameCallback {

	UUID[] viewers;

	int map;
	int width;
	int height;
	int videoWidth;
	int delay;
	int iterations;

	long sum;
	long lastUpdated;

	public ItemFrameCallback(UUID[] viewers, int map, int width, int height, int videoWidth, int delay) {
		this.viewers = viewers;
		this.map = map;
		this.width = width;
		this.height = height;
		this.videoWidth = videoWidth;
		this.delay = delay;
		this.iterations = 0;
		this.sum = 0;
	}

	public UUID[] getViewers() {
		return viewers;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMap() {
		return map;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDelay() {
		return delay;
	}

	public void send(int[] data) {
		long time = System.currentTimeMillis();
		long difference = time - lastUpdated;

		iterations++;
		sum += difference;

		if (iterations == 10) {
			System.out.println("Average Time Space (10 Iterations): " + sum / 10);
			iterations = 0;
			sum = 0;
		}

		if (difference >= delay) {
			lastUpdated = time;
			ByteBuffer dithered = ImageDither.ditherIntoMinecraft(data, videoWidth);
			AmongUs.getHandler().display(viewers, map, width, height, dithered, videoWidth);
		}
	}

}
=======
package com.github.amongus.map;

import java.nio.ByteBuffer;
import java.util.UUID;

import com.github.amongus.AmongUs;

public class ItemFrameCallback {

	UUID[] viewers;

	int map;
	int width;
	int height;
	int videoWidth;
	int delay;
	int iterations;

	long sum;
	long lastUpdated;

	public ItemFrameCallback(UUID[] viewers, int map, int width, int height, int videoWidth, int delay) {
		this.viewers = viewers;
		this.map = map;
		this.width = width;
		this.height = height;
		this.videoWidth = videoWidth;
		this.delay = delay;
		this.iterations = 0;
		this.sum = 0;
	}

	public UUID[] getViewers() {
		return viewers;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMap() {
		return map;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getDelay() {
		return delay;
	}

	public void send(int[] data) {
		long time = System.currentTimeMillis();
		long difference = time - lastUpdated;

		iterations++;
		sum += difference;

		if (iterations == 10) {
			System.out.println("Average Time Space (10 Iterations): " + sum / 10);
			iterations = 0;
			sum = 0;
		}

		if (difference >= delay) {
			lastUpdated = time;
			ByteBuffer dithered = ImageDither.ditherIntoMinecraft(data, videoWidth);
			AmongUs.getHandler().display(viewers, map, width, height, dithered, videoWidth);
		}
	}

}
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
