package lagbb.lag_things.common.blocks.custom;

import lagbb.lag_things.common.utils.CustomLaunchEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;


public class MinaBlock extends Block {

	public MinaBlock(Settings settings) {
		super(settings);
	}
	static Random random = new Random();

	static int randomNumber = random.nextInt(50) + 8;

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(),4.0f, World.ExplosionSourceType.TNT);
			player.damage(world.getDamageSources().explosion(player, player), 10.0f);
			CustomLaunchEntity.launchEntity(pos, player, randomNumber);
		}
		return ActionResult.SUCCESS;
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
		if (!world.isClient) {
			world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(),4.0f, World.ExplosionSourceType.TNT);
			entity.damage(world.getDamageSources().explosion(entity, entity), 10.0f);
			CustomLaunchEntity.launchEntity(pos, entity, randomNumber);
		}
	}

	// Calcula la direccion a volar respecto al centro del bloque
	public void launchEntity(BlockPos pos, Entity entity){
		double blockCenterX = pos.getX() + 0.5;
		double blockCenterY = pos.getY() + 0.5;
		double blockCenterZ = pos.getZ() + 0.5;

		double entityX = entity.getX();
		double entityY = entity.getY();
		double entityZ = entity.getZ();

		double directionX = entityX - blockCenterX;
		double directionY = entityY - blockCenterY;
		double directionZ = entityZ - blockCenterZ;

		double length = Math.sqrt(directionX * directionX + directionY * directionY + directionZ * directionZ);
		directionX /= length;
		directionY /= length;
		directionZ /= length;

		double speed = randomNumber;

		entity.setVelocity(directionX * speed, directionY * speed, directionZ * speed);
	}

}
