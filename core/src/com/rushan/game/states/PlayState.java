package com.rushan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rushan.game.Main;
import com.rushan.game.sprites.Bird;
import com.rushan.game.sprites.Tube;

/**
 * @author rushan
 * @since 23.04.2018
 */
public class PlayState extends State {
    private Bird bird;
    private Tube tube;
    private Texture background;

    protected PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        background = new Texture("bg.png");
        tube = new Tube(100);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
            Gdx.app.log("X", String.valueOf(Gdx.input.getX()));
            Gdx.app.log("Y", String.valueOf(Gdx.input.getY()));
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        bird.update(delta);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.projection);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0);
        /*spriteBatch.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x , tube.getPosTopTube().y);
        spriteBatch.draw(tube.getBottomTube(), tube.getPosBottomTube().x , tube.getPosBottomTube().y);*/
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
