package lagbb.lag_things.common.blocks.custom;

import com.mojang.serialization.MapCodec;
import lagbb.lag_things.common.utils.CustomLaunchEntity;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class StripMiningMinaBlock extends Block {

	public StripMiningMinaBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
		return null;
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.FACING);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		if(ctx.getPlayerLookDirection().getAxis().isVertical()){
			return super.getPlacementState(ctx)
				.with(Properties.FACING, ctx.getPlayerLookDirection().getOpposite());
		}
		return super.getPlacementState(ctx)
			.with(Properties.FACING, ctx.getPlayerLookDirection());
	}

	static float explosionRadius = 2.0f;
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (!itemStack.isOf(Items.FLINT_AND_STEEL) && !itemStack.isOf(Items.FIRE_CHARGE)) {
			return super.onUse(state, world, pos, player, hand, hit);
		} else {

			Direction direction = state.get(Properties.FACING);

			Item item = itemStack.getItem();
			for (int i = 1; i <= 6; i++){

				BlockPos explosionPos = pos.offset(direction, i);

				world.createExplosion(player, explosionPos.getX(), explosionPos.getY(), explosionPos.getZ(),
					explosionRadius, World.ExplosionSourceType.TNT);

				Vec3d explosionCenter = new Vec3d(explosionPos.getX(), explosionPos.getY(), explosionPos.getZ());

				double distance = player.getPos().distanceTo(explosionCenter);
				if (distance <= explosionRadius){
					System.out.println("Afectado por Explosion " + i);
					player.damage(world.getDamageSources().explosion(player, player), 10.0f);
					CustomLaunchEntity.launchEntity(pos, player, 5);
				}
			}

			if (!player.isCreative()) {
				if (itemStack.isOf(Items.FLINT_AND_STEEL)) {
					itemStack.damage(1, player, playerx -> playerx.sendToolBreakStatus(hand));
				} else {
					itemStack.decrement(1);
				}
			}

			player.incrementStat(Stats.USED.getOrCreateStat(item));
			return ActionResult.success(world.isClient);
		}
	}

}
