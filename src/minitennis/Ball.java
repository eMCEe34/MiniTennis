package minitennis;
import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Main game;

    //Constructor that sets the game variable here to our Main class
    public Ball(Main game){
        this.game=game;
    }

    //move function used for the ball's movement, game over, and collision
    void move(){
        if(x + xa < 0)
            xa = game.speed;
        else if(x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if(y + ya < 0)
            ya = game.speed;
        else if(y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if(collision()){
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            game.speed++;
        }

        x=x+xa;
        y=y+ya;
    }

    private boolean collision(){
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g){
        g.fillOval(x,y,DIAMETER,DIAMETER);
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }
}
