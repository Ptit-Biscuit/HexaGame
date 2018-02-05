package com.company.system;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileUtil {
	public static BufferedImage createComposite(BufferedImage tileBase, BufferedImage tileDecoration, float alpha) {
		BufferedImage buffer = new BufferedImage(Math.max(tileBase.getWidth(), tileDecoration.getWidth()),
				Math.max(tileBase.getHeight(), tileDecoration.getHeight()),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = buffer.createGraphics();
		Composite newComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);

		g2.drawImage(tileBase, null, null);
		g2.setComposite(newComposite);
		g2.drawImage(tileDecoration, null, null);
		g2.dispose();

		return buffer;
	}
}
