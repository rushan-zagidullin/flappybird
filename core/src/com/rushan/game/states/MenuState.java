package com.rushan.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rushan.game.Main;

/**
 * @author rushan
 * @since 16.04.2018
 */
public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gameStateManager.set(new PlayState(gameStateManager));
            dispose();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Main.WIDTH, Main.HEIGHT);
        spriteBatch.draw(playBtn, Main.WIDTH / 2 - playBtn.getWidth() / 2, Main.HEIGHT / 2 - playBtn.getHeight() / 2);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
