package lagbb.lag_things.common.blocks.custom;

import lagbb.lag_things.common.utils.CustomLaunchEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuperBomba extends Block {
	public SuperBomba(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(),100.0f, World.ExplosionSourceType.TNT);
			player.damage(world.getDamageSources().explosion(player, player), 10.0f);
			CustomLaunchEntity.launchEntity(pos, player, 5);
		}
		return ActionResult.SUCCESS;
	}

}
