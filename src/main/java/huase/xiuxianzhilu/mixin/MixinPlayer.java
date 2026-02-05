package huase.xiuxianzhilu.mixin;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class MixinPlayer {
    @Redirect(
            method = "attack", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;sendParticles(Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I"
    )
    )
    public int sendParticles(ServerLevel instance, ParticleOptions particleOptions, double pPosX, double pPosY, double pPosZ, int pParticleCount, double pXOffset, double pYOffset, double pZOffset, double pSpeed) {
        instance.sendParticles(ParticleTypes.DAMAGE_INDICATOR, pPosX, pPosY, pPosZ, Math.min(5,pParticleCount), 0.1D, 0.0D, 0.1D, 0.2D);
        return 0;
    }

}
