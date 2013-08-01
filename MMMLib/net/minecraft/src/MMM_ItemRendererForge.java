package net.minecraft.src;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraftforge.client.IItemRenderer;

public class MMM_ItemRendererForge implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		if (item == null || MMM_ItemRenderManager.isEXRender(item.getItem())) return false;
		
		MMM_ItemRenderManager lirm = MMM_ItemRenderManager.getEXRender(item.getItem());
		switch (type) {
		case ENTITY:
			return lirm.isRenderItemWorld();
		case EQUIPPED:
			return lirm.isRenderItem();
		case EQUIPPED_FIRST_PERSON:
			return lirm.isRenderItemInFirstPerson();
		case INVENTORY:
		case FIRST_PERSON_MAP:
			break;
		}
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		MMM_ItemRenderManager lirm = MMM_ItemRenderManager.getEXRender(item.getItem());
		switch (type) {
		case ENTITY:
			EntityItem lei = (EntityItem)data[1];
			lirm.renderItemWorld(lei, 0D, 0D, 0D, 0F, 1.0F);
			break;
		case EQUIPPED:
//          GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
			GL11.glScalef(0.625F, -0.625F, 0.625F);
////			GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);

//			GL11.glScalef(0.14F, 0.14F, 0.14F);

			GL11.glTranslatef(1.4F, -0.35F, -0.2F);
			GL11.glRotatef(135.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
//
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(50F, 0F, 1F, 0F);
			GL11.glRotatef(335F, 0F, 0F, 1F);
			
			renderItem(item, (EntityLivingBase)data[1], lirm);
			break;
		case EQUIPPED_FIRST_PERSON:
			MMM_Client.setTexture(lirm.getRenderTexture());
			GL11.glTranslatef(1.5F, 0.1F, 0.3F);
//			GL11.glRotatef(135.0F, 0.0F, 0.0F, 1.0F);
//			GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(5.0F, 1.0F, 0.0F, 0.0F);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			
			renderItem(item, (EntityLivingBase)data[1], lirm);
			break;
		case INVENTORY:
		case FIRST_PERSON_MAP:
			break;
		}
	}

	protected void renderItem(ItemStack item, EntityLivingBase pEntity, MMM_ItemRenderManager pItemRenderManager) {
		if (item.getItem().requiresMultipleRenderPasses()) {
			pItemRenderManager.renderItemLocal(pEntity, item, 0);
			float var9 = 1.0F;
			int var28 = Item.itemsList[item.itemID].getColorFromItemStack(item, 1);
			float lcr = (float)(var28 >> 16 & 255) / 255.0F;
			float lcg = (float)(var28 >> 8 & 255) / 255.0F;
			float lcb = (float)(var28 & 255) / 255.0F;
			GL11.glColor4f(var9 * lcr, var9 * lcg, var9 * lcb, 1.0F);
			pItemRenderManager.renderItemLocal(pEntity, item, 1);
		} else {
			pItemRenderManager.renderItemLocal(pEntity, item, 0);
		}
	}

}