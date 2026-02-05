package huase.xiuxianzhilu.entity.moster.huanlinghu;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import huase.xiuxianzhilu.ModMain;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class HuanlinghuModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "huanlinghumodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/huanlinghu.png"), "main");
	private final ModelPart bone;

	public HuanlinghuModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(24, 13).addBox(-4.0F, -17.0F, -9.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 24).addBox(3.0F, -13.0F, -8.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(10, 51).addBox(3.0F, -9.0F, -7.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(3.0F, -6.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 39).addBox(3.0F, -3.0F, -7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 44).addBox(-5.0F, -13.0F, -8.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 51).addBox(-5.0F, -9.0F, -7.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 29).addBox(-5.0F, -6.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(-5.0F, -3.0F, -7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(50, 33).addBox(-5.0F, -3.0F, 5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 51).addBox(-5.0F, -6.0F, 6.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 13).addBox(-5.0F, -9.0F, 5.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-5.0F, -13.0F, 4.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(20, 34).addBox(3.0F, -13.0F, 4.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(3.0F, -9.0F, 5.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 45).addBox(3.0F, -6.0F, 6.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 48).addBox(3.0F, -3.0F, 5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-3.0F, -21.0F, -12.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 20).addBox(-2.0F, -23.0F, -11.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 53).addBox(1.0F, -23.0F, -11.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 44).addBox(-2.0F, -19.0F, -14.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-3.0F, -16.0F, -5.0F, 6.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(46, 44).addBox(-3.0F, -12.0F, -5.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 24).addBox(-3.0F, -17.0F, 4.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 34).addBox(-1.0F, -18.0F, 7.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -27.0F, 10.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}