package patterns;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoxPanel extends JButton {
    private BufferedImage image;

    public BoxPanel() {
        super();
    }

    public BoxPanel(String pathname) throws IOException {
        super();
        image = ImageIO.read(new File(pathname));
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }
}
