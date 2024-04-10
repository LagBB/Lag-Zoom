package lagbb.lag_things.common.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public class CustomLaunchEntity {
	public static void launchEntity(BlockPos pos, Entity entity, double speed){
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

		entity.setVelocity(directionX * speed, directionY * speed, directionZ * speed);
	}

}
