package com.company.model;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TileManager <T> {
    private static TileManager ourInstance = new TileManager();

    public static TileManager getInstance() {
        return ourInstance;
    }

    private TileManager() {  }

    private Image picture;
    private HashMap<T, Tile> tileset = new HashMap<>(); // (Tilename, Tile)

    public void addTile(T name, Tile tile){
        tileset.put(name, tile);
    }

    public void parsePicture(File tilesetFile, int width, ArrayList<T> names){ parsePicture(tilesetFile, width, width, names); }
    public void parsePicture(File tilesetFile, int width, int height, ArrayList<T> names){
        try {
            BufferedImage tilemap = ImageIO.read(tilesetFile);
            int xmax = tilemap.getWidth() / width;
            int ymax = tilemap.getHeight() / height;

            for (int x = 0; x < xmax; ++x) for (int y = 0; y < ymax; ++y) {
                T name = names.get(x + y * xmax);
                if(name != null)
                    tileset.put(name, new Tile(tilemap.getSubimage(x * width, y * height, width, height)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tile getTile(T name){ return tileset.get(name); }
}
