/*
 ** 2012 October 26
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.minecraft.dragon.server.entity.ai.ground;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;
/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIWatchIdle extends EntityAILookIdle {

    public EntityAIWatchIdle(EntityLiving par1EntityLiving) {
        super(par1EntityLiving);
        this.setMutexBits(2);
    }
}
