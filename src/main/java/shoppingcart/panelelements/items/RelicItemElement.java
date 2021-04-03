package shoppingcart.panelelements.items;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.shop.StoreRelic;
import shoppingcart.ShoppingListPanel;
import shoppingcart.panelelements.PanelElement;

public class RelicItemElement extends ShopItemElement {
    public AbstractRelic relic;

    public RelicItemElement(ShoppingListPanel panel, AbstractRelic relic, int cost) {
        super(panel, cost);

        this.relic = relic;
    }

    public RelicItemElement(ShoppingListPanel panel, StoreRelic relic) {
        this(panel, relic.relic, relic.price);
    }

    private static float relicImageSize = PanelElement.HEIGHT * Settings.scale * 1.6f;

    @Override
    public void renderItem(SpriteBatch spriteBatch) {
        spriteBatch.setColor(Color.WHITE);
        spriteBatch.draw(relic.outlineImg, x + width * 0.3f - relicImageSize / 2, y - height * 0.5f - relicImageSize / 2,
                relicImageSize, relicImageSize);
        spriteBatch.draw(relic.img, x + width * 0.3f - relicImageSize / 2, y - height * 0.5f - relicImageSize / 2,
                relicImageSize, relicImageSize);
    }
}
