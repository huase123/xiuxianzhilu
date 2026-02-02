package huase.xiuxianzhilu.entity.moster.chilingshuishe;// Made with Blockbench 5.0.7
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

public class ChilingshuisheModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/chilingshuishe.png"), "main");
	private final ModelPart bone;

	public ChilingshuisheModel(ModelPart root) {
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 34).addBox(-5.0F, -43.0F, -9.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(28, 51).addBox(-4.0F, -46.0F, -4.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 34).addBox(-3.0F, -42.0F, 2.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(72, 78).addBox(-2.0F, -36.0F, 6.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 63).addBox(-3.0F, -31.0F, 5.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 34).addBox(-4.0F, -27.0F, 2.0F, 8.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 0).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-5.0F, -23.0F, -8.0F, 10.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -20.0F, -12.0F, 14.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 17).addBox(-5.0F, -15.0F, -10.0F, 10.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-4.0F, -13.0F, -5.0F, 8.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(56, 51).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 64).addBox(0.0F, -6.0F, 5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 17).addBox(5.0F, -6.0F, 10.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 66).addBox(2.0F, -6.0F, 16.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-3.0F, -6.0F, 17.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 76).addBox(-8.0F, -6.0F, 21.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 78).addBox(-11.0F, -6.0F, 25.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 78).addBox(-7.0F, -6.0F, 30.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(80, 63).addBox(-2.0F, -6.0F, 34.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(84, 29).addBox(-1.0F, -6.0F, 40.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(84, 41).addBox(0.0F, -6.0F, 46.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}