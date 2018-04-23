package com.rushan.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * @author rushan
 * @since 23.04.2018
 */
public class Bird {
    private static final int GRAVITY = - 15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");
    }

    public void update(float delta) {
        if (position.y > 0) {
            velocity.add(0, GRAVITY * delta, 0);
        }
        position.add(0, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }
    }

    public void jump() {
        velocity.y = 15;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }
}
