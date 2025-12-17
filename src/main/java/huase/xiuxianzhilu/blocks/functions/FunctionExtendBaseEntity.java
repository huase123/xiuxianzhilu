package huase.xiuxianzhilu.blocks.functions;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * - @description:FunctionExtendBaseEntity类
 */
public abstract class FunctionExtendBaseEntity extends Entity implements ChildFunction,PrentFunction{
    private ChildFunction childFunction;
    private PrentFunction prentFunction;
    public FunctionExtendBaseEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

}
