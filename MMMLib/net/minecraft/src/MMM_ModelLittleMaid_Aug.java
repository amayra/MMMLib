package net.minecraft.src;

import org.lwjgl.opengl.GL11;

/**
 * �T���v���Ƃ���addParts���g�p���Ă��܂��B
 */
public class MMM_ModelLittleMaid_Aug extends MMM_ModelLittleMaid_SR2 {
	
	public MMM_ModelRenderer shaggyB;
	public MMM_ModelRenderer shaggyR;
	public MMM_ModelRenderer shaggyL;
	
	public MMM_ModelRenderer SideTailR;
	public MMM_ModelRenderer SideTailL;

	public MMM_ModelRenderer sensor1;
	public MMM_ModelRenderer sensor2;
	public MMM_ModelRenderer sensor3;
	public MMM_ModelRenderer sensor4;

	
	public MMM_ModelLittleMaid_Aug() {
		super();
	}
	public MMM_ModelLittleMaid_Aug(float psize) {
		super(psize);
	}
	public MMM_ModelLittleMaid_Aug(float psize, float pyoffset) {
		super(psize, pyoffset);
	}


	@Override
	public void initModel(float psize, float pyoffset) {
		super.initModel(psize, pyoffset);
		
		// �č\���p�[�c
		SideTailR = new MMM_ModelRenderer(this);
		SideTailR.setTextureOffsetMM(46, 20).addParts(MMM_ModelBox.class, -1.5F, -0.5F, -1.0F, 2, 10, 2, psize);
		SideTailR.setRotationPointMM(-5F, -7.8F, 1.9F);
		SideTailL = new MMM_ModelRenderer(this);
		SideTailL.setTextureOffsetMM(54, 20).addParts(MMM_ModelBox.class, 0.5F, -0.5F, -1.0F, 2, 10, 2, psize);
		SideTailL.setRotationPointMM(4F, -7.8F, 1.9F);
		
		
		// �����p�[�c
		shaggyB = new MMM_ModelRenderer(this, 24, 0);
		shaggyB.addParts(MMM_ModelPlate.class, -5.0F, 0.0F, 0.0F, 10, 4, 4, psize);
		shaggyB.setRotationPointMM(0.0F, -1.0F, 4.0F);
		shaggyB.setRotateAngleX(0.4F);
		shaggyR = new MMM_ModelRenderer(this, 34, 4);
		shaggyR.addParts(MMM_ModelPlate.class, 0.0F, 0.0F, -5.0F, 10, 4, 1, psize);
		shaggyR.setRotationPointMM(4.0F, -1.0F, 0.0F);
		shaggyR.setRotateAngleZ(-0.4F);
		shaggyL = new MMM_ModelRenderer(this, 24, 4);
		shaggyL.addParts(MMM_ModelPlate.class, 0.0F, 0.0F, -5.0F, 10, 4, 5, psize);
		shaggyL.setRotationPointMM(-4.0F, -1.0F, 0.0F);
		shaggyL.setRotateAngleZ(0.4F);
		
		sensor1 = new MMM_ModelRenderer(this, 0, 0);
		sensor1.addParts(MMM_ModelPlate.class, -8.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor1.setRotationPointMM(0.0F, -8.0F + pyoffset, 0.0F);
		sensor2 = new MMM_ModelRenderer(this, 0, 4);
		sensor2.addParts(MMM_ModelPlate.class, 0.0F, -4.0F, 0.0F, 8, 4, 0);
		sensor2.setRotationPointMM(0.0F, -8.0F + pyoffset, 0.0F);
		sensor3 = new MMM_ModelRenderer(this, 44, 0);
		sensor3.addParts(MMM_ModelPlate.class, 0.0F, -7.0F, -4.0F, 4, 8, 1);
		sensor3.setRotationPointMM(0.0F, -8.0F + pyoffset, 0.0F);
		sensor4 = new MMM_ModelRenderer(this, 34, 0);
		sensor4.addParts(MMM_ModelPlate.class, 0.0F, -4.0F, -10.0F, 10, 4, 1);
		sensor4.setRotationPointMM(0.0F, -8.0F + pyoffset, 0.0F);
		
		
		// �ύX�p�[�c
		bipedHead.clearCubeList();
		bipedHead.setMirror(false);
		bipedHead.setTextureOffsetMM( 0,  0).addParts(MMM_ModelBox.class, -4F, -8F, -4F, 8, 8, 8, psize);		// Head
		bipedHead.setTextureOffsetMM( 0, 18).addParts(MMM_ModelBox.class, -5F, -8.5F, 0.2F, 1, 3, 3, psize);	// ChignonR
		bipedHead.setTextureOffsetMM(24, 18).addParts(MMM_ModelBox.class, 4F, -8.5F, 0.2F, 1, 3, 3, psize);		// ChignonL
		bipedHead.setTextureOffsetMM(52, 10).addParts(MMM_ModelBox.class, -7.5F, -9.5F, 0.9F, 4, 3, 2, psize);	// sidetailUpperR
		bipedHead.setTextureOffsetMM(52, 15).addParts(MMM_ModelBox.class, 3.5F, -9.5F, 0.9F, 4, 3, 2, psize);	// sidetailUpperL
		bipedHead.setRotationPointMM(0F, 0F, 0F);
		
		bipedHead.addChildMM(HeadMount);
		bipedHead.addChildMM(SideTailR);
		bipedHead.addChildMM(SideTailL);
		bipedHead.addChildMM(shaggyB);
		bipedHead.addChildMM(shaggyR);
		bipedHead.addChildMM(shaggyL);
		bipedHead.addChildMM(sensor1);
		bipedHead.addChildMM(sensor2);
		bipedHead.addChildMM(sensor3);
		bipedHead.addChildMM(sensor4);
		bipedHead.addChildMM(eyeR);
		bipedHead.addChildMM(eyeL);
		
	}

	@Override
	public void setLivingAnimationsMM(float par2, float par3, float pRenderPartialTicks) {
		super.setLivingAnimationsMM(par2, par3, pRenderPartialTicks);
		
		float f3 = (float)entityTicksExisted + pRenderPartialTicks + entityIdFactor;
		float f4;
		if (MMM_ModelCapsHelper.getCapsValueBoolean(entityCaps, caps_isLookSuger)) {
			f3 *= 8.0F;
			f4 = -0.2F;
		} else {
			f4 = (1F - (float)MMM_ModelCapsHelper.getCapsValueInt(entityCaps, caps_health) / 20F) * 0.5F;
		}
		float f5 = mh_sin(f3 * 0.067F) * 0.05F - f4;
		float f6 = 40.0F / 57.29578F;
		sensor1.setRotateAngle(f5, -f6, f5);
		sensor2.setRotateAngle(-f5, f6, -f5);
		sensor3.setRotateAngle(mh_sin(f3 * 0.067F) * 0.05F - 1.2F - f4, mh_sin(f3 * 0.09F) * 0.4F, mh_cos(f3 * 0.09F) * 0.2F);
		sensor4.setRotateAngle(mh_sin(f3 * 0.067F) * 0.05F + f4, mh_cos(f3 * 0.09F) * 0.5F, mh_sin(f3 * 0.09F) * 0.2F);
	}

	@Override
	public void setRotationAnglesMM(float par1, float par2,
			float pTicksExisted, float pHeadYaw, float pHeadPitch, float par6) {
		super.setRotationAnglesMM(par1, par2, pTicksExisted, pHeadYaw, pHeadPitch, par6);
		
		SideTailR.setRotateAngleX(SideTailL.setRotateAngleX(bipedHead.getRotateAngleX() * -0.666666666F));
	}

}