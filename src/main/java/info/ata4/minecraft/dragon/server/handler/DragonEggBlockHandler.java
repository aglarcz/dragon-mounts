/*
 ** 2014 January 31
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */

package info.ata4.minecraft.dragon.server.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import info.ata4.minecraft.dragon.server.entity.EntityTameableDragon;
import info.ata4.minecraft.dragon.server.entity.helper.DragonLifeStage;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * Non-invasive dragon egg block override handler.
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DragonEggBlockHandler {

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent evt) {
        // only handle right clicks on blocks
        if (evt.action != PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        
        World world = evt.entity.worldObj;
        Block block = world.getBlock(evt.x, evt.y, evt.z);
        
        // ignore non-egg blocks
        if (block != Blocks.dragon_egg) {
            return;
        }
        
        // deny action
        evt.useBlock = PlayerInteractEvent.Result.DENY;
        evt.useItem = PlayerInteractEvent.Result.DENY;
        
        // clear dragon egg block
        world.setBlockToAir(pos);
        
        // create dragon egg entity on server
 +        if (evt.world.isRemote) {
 +            EntityTameableDragon dragon = new EntityTameableDragon(world);
 +            dragon.setPosition(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
 +            dragon.getReproductionHelper().setBreederName(evt.entityPlayer.getName());
 +            dragon.getLifeStageHelper().setLifeStage(DragonLifeStage.EGG);
 +            world.spawnEntityInWorld(dragon);
 +        }
    }
}
