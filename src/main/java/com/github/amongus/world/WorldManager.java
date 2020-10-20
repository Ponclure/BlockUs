package com.github.amongus.world;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.github.amongus.AmongUs;

public class WorldManager {

	public void worldIntialization() throws URISyntaxException, IOException {

		// Among Us world and texture pack by PheonixSC

		if (!worldExists()) {
			
			File world = new File(getClass().getClassLoader().getResource("skeld").toURI());
			File[] worldContents = world.listFiles();
			File dir = new File(AmongUs.getInstance().getDataFolder(), "skeld");

			Stack<File> files = new Stack<>();
			for (int i = 0; i < worldContents.length; i++) {
				files.add(worldContents[i]);
			}
			while (!files.isEmpty()) {
				File f = files.pop();
				if (f.isDirectory()) {
					File[] children = f.listFiles();
					for (int i = 0; i < children.length; i++) {
						files.add(children[i]);
					}
				} else {
					InputStream in = new FileInputStream(world);
					OutputStream out = new FileOutputStream(f);

					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					in.close();
					out.close();
				}
			}

		} else {

		}

	}

	public boolean worldExists() {
		File dir = new File(AmongUs.getInstance().getDataFolder(), "skeld");
		if (!dir.exists() || dir.listFiles().length == 0) {
			return false;
		}
		return true;
	}

}
