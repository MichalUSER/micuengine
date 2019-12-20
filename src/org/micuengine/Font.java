package org.micuengine;

public class Font {
    java.awt.Font font;

    public Font(String name, String weight, int size) {
        switch (weight) {
            case "bold":
                font = new java.awt.Font(name, java.awt.Font.BOLD, size);
                break;
            case "italic":
                font = new java.awt.Font(name, java.awt.Font.ITALIC, size);
                break;
            case "plain":
                font = new java.awt.Font(name, java.awt.Font.PLAIN, size);
                break;
        }
    }
}
