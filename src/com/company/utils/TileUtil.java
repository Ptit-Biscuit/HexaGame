package com.company.utils;

import com.company.controller.manager.TileManager;
import com.company.model.enums.Facing;
import com.company.model.enums.TileType;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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

    public static BufferedImage compose(Facing[] orientation, TileType tile, BufferedImage composite) {


        for (Facing facing : orientation) {
            BufferedImage backTile = TileManager.getInstance().getTile(tile);
            AffineTransform tx = new AffineTransform();
            tx.rotate(
                    facing.ordinal() * (Math.PI / 3),
                    backTile.getWidth() / 2,
                    backTile.getHeight() / 2);

            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
            backTile = op.filter(backTile, null);

            composite = TileUtil.createComposite(
                    composite,
                    backTile,
                    1f);
        }
        return composite;
    }
}
