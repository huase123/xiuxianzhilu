package huase.xiuxianzhilu.entity.moster.xvanbingjvxiong;// Made with Blockbench 5.0.7
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

public class XvanbingjvxiongModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xvanbingjvxiong"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/xvanbingjvxiong.png"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart bone;

	public XvanbingjvxiongModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5F, -0.75F, -8.0F, 21.0F, 21.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-9.0F, -18.75F, -8.0F, 18.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.5F, 3.25F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 70).addBox(-5.625F, -3.75F, -2.875F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(76, 14).addBox(-4.125F, 2.25F, -7.375F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(76, 24).addBox(-6.625F, -4.75F, 0.125F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 24).mirror().addBox(3.875F, -4.75F, 0.125F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.875F, 1.25F, -21.625F));

		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 71).addBox(-3.0F, -7.5F, -6.0F, 6.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.75F, 16.0F, 16.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 71).addBox(-3.0F, -7.5F, -6.0F, 6.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(7.75F, 16.0F, 16.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(36, 71).addBox(-3.0F, -7.5F, -4.5F, 6.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.25F, 16.0F, -6.5F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(36, 71).addBox(-3.0F, -7.5F, -4.5F, 6.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.25F, 16.0F, -6.5F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(66, 38).addBox(-15.0F, -34.0F, -10.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(76, 0).addBox(-8.0F, -29.0F, -17.0F, 18.0F, 14.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 38).addBox(-15.0F, -34.0F, -7.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 38).addBox(-15.0F, -34.0F, -4.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 38).addBox(-15.0F, -35.0F, 18.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 38).addBox(-15.0F, -35.0F, 12.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 38).addBox(-15.0F, -35.0F, 15.0F, 32.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}