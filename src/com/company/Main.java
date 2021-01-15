package com.company;

import dev.jabo.kree.*;
import dev.jabo.kree.Component;
import dev.jabo.kree.Window;
import dev.jabo.kree.components.BoxCollider;
import dev.jabo.kree.components.PlayerMovement;
import dev.jabo.kree.components.SpriteRenderer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new Window("The Secret On The Lab", 1280, 720));

        SceneManager.setScene(new MyScene(game));
        game.start();
    }
}


class MyScene extends Scene {


    GameObject stopping = new GameObject(this, "Stopping");
    GameObject threes = new GameObject(this, "Threes");
    GameObject gg = new GameObject(this, "Gamer");
    GameObject girl = new GameObject(this, "Сharacter");
    GameObject damb = new GameObject(this, "Guy");
    GameObject dark = new GameObject(this, "Dark");

    public MyScene(Game game) {
        super(game);
    }


    @Override
    public void Initialize() {
        gg.addComponent(new BoxCollider());
        gg.getTransform().setScale(new Vector2(128, 128));
        gg.getTransform().setPosition(new Vector2(200, 500));
        Sprite gg1 = new Sprite("/Гг.png");
        gg.addComponent(new PlayerMovement(2f, PlayerMovement.WASD));
        gg.addComponent(new SpriteRenderer(gg1));

        girl.addComponent(new BoxCollider());
        girl.getTransform().setScale(new Vector2(128, 128));
        girl.getTransform().setPosition(new Vector2(200, 370));
        Sprite girl1 = new Sprite("/Д.png");
        girl.addComponent(new SpriteRenderer(girl1));

        stopping.addComponent(new BoxCollider());
        stopping.getTransform().setScale(new Vector2(188, 548));
        stopping.getTransform().setPosition(new Vector2(270, 50));
        Sprite stopping1 = new Sprite("/остановка.png");
        stopping.addComponent(new SpriteRenderer(stopping1));

        damb.addComponent(new BoxCollider());
        damb.getTransform().setScale(new Vector2(128, 128));
        damb.getTransform().setPosition(new Vector2(300, 370));
        Sprite damb1 = new Sprite("/Поц.png");
        damb.addComponent(new SpriteRenderer(damb1));

        threes.addComponent(new BoxCollider());
        threes.getTransform().setScale(new Vector2(888, 282));
        threes.getTransform().setPosition(new Vector2(836, 141));
        Sprite threes1 = new Sprite("/Деревья.png") ;
        threes.addComponent(new SpriteRenderer(threes1));

        dark.addComponent(new BoxCollider());
        dark.getTransform().setScale(new Vector2(1280, 730));
        dark.getTransform().setPosition(new Vector2(640, 365));
        Sprite dark1 = new Sprite("/темно.png");
        dark.addComponent(new SpriteRenderer(dark1));


    }

    @Override
    public void Update() {

        if (Input.isKeyPressed(KeyEvent.VK_E)) {
            SceneManager.setScene(new TwoScene(game));
        }
        Vector2 xy = gg.getTransform().getPosition();
        Vector2 xy1 = gg.getTransform().getPosition();
        Vector2 xy2 = gg.getTransform().getPosition();
        Vector2 xy3 = gg.getTransform().getPosition();

        if (xy.getX() >= 1250) {
            xy.setX(1250);
        }
        if (xy1.getX()<= 160){
            xy1.setX(160);
        }
        if (xy2.getY()>= 655){
            xy2.setY(655);
        }
        if (xy3.getY()<=250){
            xy3.setY(250);
        }



    }

    @Override
    public void Render(Graphics graphics) {
        BufferedImage background = ImageLoader.loadImage("/Фонн.png");
        graphics.drawImage(background, 0, 0, null);



    }

}
class TwoScene extends Scene {
    GameObject house = new GameObject(this, "House");
    GameObject gg = new GameObject(this, "Gamer");
    GameObject dark = new GameObject(this, "Dark");
    public TwoScene(Game game) {
        super(game);

    }

    @Override
    public void Initialize() {
        gg.addComponent(new BoxCollider());
        gg.getTransform().setScale(new Vector2(128, 128));
        gg.getTransform().setPosition(new Vector2(70, 360));
        Sprite ggg = new Sprite("/Гг.png");
        gg.addComponent(new PlayerMovement(2.3f, PlayerMovement.WASD));
        gg.addComponent(new SpriteRenderer(ggg));
        gg.addComponent(new MyComp());


        house.getTransform().setScale(new Vector2(1084, 830));
        house.addComponent(new BoxCollider());
        house.getTransform().setPosition(new Vector2(800, -100));
        Sprite house1 = new Sprite("/Гостиница1.png");
        house.addComponent(new SpriteRenderer(house1));

        dark.addComponent(new BoxCollider());
        dark.getTransform().setScale(new Vector2(1280, 730));
        dark.getTransform().setPosition(new Vector2(640, 365));
        Sprite dark1 = new Sprite("/темно.png");
        dark.addComponent(new SpriteRenderer(dark1));

    }

    @Override
    public void Update() {
        if

        (Input.isKeyPressed(KeyEvent.VK_E)) {
            SceneManager.setScene(new MyScene(game));

        }



    }

    @Override
    public void Render(Graphics graphics) {
        BufferedImage background = ImageLoader.loadImage("/Фон1.png");
        graphics.drawImage(background, 0, 0, null);

    }


    class MyComp extends Component {

        @Override
        public void Update() {
            Vector2 xy = gameObject.getTransform().getPosition();
            Vector2 xy1 = gameObject.getTransform().getPosition();
            Vector2 xy2 = gameObject.getTransform().getPosition();
            Vector2 xy3 = gameObject.getTransform().getPosition();

            if (xy.getX() >= 1250) {
                xy.setX(1250);
            }
            if (xy1.getX()<= 30){
                xy1.setX(30);
            }
            if (xy2.getY()>= 700){
                xy2.setY(700);
            }
            if (xy3.getY()<=50){
                xy3.setY(50);
            }

        }

        @Override
        public void Render(Graphics graphics) {

        }
    }
}
