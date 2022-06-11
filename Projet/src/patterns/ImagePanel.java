package patterns;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel() {
        super(new FlowLayout(0, 0, 0));
    }

    public ImagePanel(String pathname) throws IOException {
        super(new FlowLayout(0, 0, 0));
        image = ImageIO.read(new File(pathname));
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    public ImagePanel(BufferedImage image) throws IOException {
        super(new FlowLayout(0, 0, 0));
        this.image = image;
        this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
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