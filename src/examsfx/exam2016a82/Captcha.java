package examsfx.exam2016a82;

import javafx.scene.image.Image;

public class Captcha {
    private Image image;
    private String text;

    public Captcha(Image image, String text) {
        this.image = image;
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
