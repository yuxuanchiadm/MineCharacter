package minecharacter.item.grim;

import java.util.Random;

import minecharacter.MineCharacter;
import minecharacter.misc.InitItem;
import minecharacter.misc.Localization;
import minecharacter.network.PacketSetPos;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLucifer extends ItemSword {

	private boolean inGrim = false;
	private Random ran = new Random();

	public ItemLucifer(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setMaxDamage(2341);
		this.setCreativeTab(MineCharacter.tabMineCharacter);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par2EntityLivingBase.setFire(20);
		return super.hitEntity(par1ItemStack, par2EntityLivingBase,
				par3EntityLivingBase);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon("minecharacter:"
				+ this.getUnlocalizedName().replace("item.", ""));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (MineCharacter.proxy.isEquid(par3EntityPlayer, "grim"))
			this.inGrim = true;
		else
			this.inGrim = false;
		if (this.inGrim || par3EntityPlayer.capabilities.isCreativeMode) {
			if (par3EntityPlayer.inventory.hasItem(InitItem.soul)) {
				if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
					MovingObjectPosition movingObjectPostion = par3EntityPlayer
							.rayTrace(75.0D, 1.0F);
					if (movingObjectPostion == null) {
						return par1ItemStack;
					}
					Vec3 vec3 = movingObjectPostion.hitVec;
					int x = MathHelper.floor_double(vec3.xCoord);
					int y = MathHelper.floor_double(vec3.yCoord);
					int z = MathHelper.floor_double(vec3.zCoord);
					for (int i1 = 0; i1 < 32; i1++) {
						par2World.spawnParticle(
								"portal",
								par3EntityPlayer.posX + this.ran.nextDouble()
										- 0.5D,
								par3EntityPlayer.posY - 1.5D
										+ this.ran.nextDouble() * 2.0D,
								par3EntityPlayer.posZ + this.ran.nextDouble()
										- 0.5D, 0.0D, 0.0D, 0.0D);
					}
					while (!par2World.isAirBlock(x, y, z))
						y++;
					par3EntityPlayer
							.setPositionAndUpdate(x + 0.5D, y, z + 0.5D);
					PacketSetPos.setPos(x + 0.5D, y, z + 0.5D);

					for (int i1 = 0; i1 < 32; i1++) {
						par2World.spawnParticle(
								"portal",
								par3EntityPlayer.posX + this.ran.nextDouble()
										- 0.5D,
								par3EntityPlayer.posY - 1.5D
										+ this.ran.nextDouble() * 2.0D,
								par3EntityPlayer.posZ + this.ran.nextDouble()
										- 0.5D, 0.0D, 0.0D, 0.0D);
					}
				}
				par3EntityPlayer.inventory.consumeInventoryItem(InitItem.soul);
				par1ItemStack.damageItem(3, par3EntityPlayer);
				par3EntityPlayer.swingItem();

			}
		}
		return par1ItemStack;

	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack) {
		return Localization.localize(getUnlocalizedName(itemStack));
	}

}
