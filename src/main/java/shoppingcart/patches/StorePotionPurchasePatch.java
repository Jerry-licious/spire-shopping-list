package shoppingcart.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePrefixPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.shop.StorePotion;
import shoppingcart.ShoppingListPanel;
import shoppingcart.util.KeyHelper;

// Add the potion that the player intends to purchase to the shopping list instead of buying it directly when the Alt
// key is pressed.
@SpirePatch(clz = StorePotion.class, method = "purchasePotion")
public class StorePotionPurchasePatch {
    @SpirePrefixPatch
    public static SpireReturn addStorePotionToList(StorePotion storePotion) {
        // Block all purchases that click through the panel.
        ShoppingListPanel panel = ShoppingListPanelField.shoppingList.get(AbstractDungeon.shopScreen);
        if (panel.hitbox.hovered) {
            return SpireReturn.Return(null);
        }

        // Intercept the interaction if the item is intended to be added to the list.
        if (KeyHelper.isAltPressed()) {
            // Add the item to the list.
            ShoppingListPanelField.shoppingList.get(AbstractDungeon.shopScreen).addItem(storePotion);

            return SpireReturn.Return(null);
        }

        return SpireReturn.Continue();
    }
}
