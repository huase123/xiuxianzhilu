package huase.xiuxianzhilu.entity.moster.huoqiling;// Made with Blockbench 5.0.7
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

public class HuoqilingModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "huoqiling"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/huoqiling.png"), "main");
	private final ModelPart head;
	private final ModelPart bone12;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart bone15;
	private final ModelPart bone16;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone9;
	private final ModelPart bone7;
	private final ModelPart bone8;

	public HuoqilingModel(ModelPart root) {
		this.head = root.getChild("head");
		this.bone12 = this.head.getChild("bone12");
		this.bone13 = this.head.getChild("bone13");
		this.bone14 = this.head.getChild("bone14");
		this.bone15 = this.head.getChild("bone15");
		this.bone16 = this.head.getChild("bone16");
		this.bone10 = this.head.getChild("bone10");
		this.bone11 = this.head.getChild("bone11");
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
		this.bone4 = root.getChild("bone4");
		this.bone5 = root.getChild("bone5");
		this.bone6 = root.getChild("bone6");
		this.bone9 = root.getChild("bone9");
		this.bone7 = root.getChild("bone7");
		this.bone8 = root.getChild("bone8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(80, 35).addBox(-3.0F, -2.0F, 2.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 57).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 70).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(60, 57).addBox(-3.0F, -1.0F, -10.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(80, 17).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(80, 49).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -11.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 64).addBox(-3.0F, -0.5F, -6.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -4.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone12 = head.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(84, 67).addBox(0.0F, -2.0F, 9.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 92).addBox(0.0F, -3.0F, 11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 92).addBox(0.0F, -4.0F, 13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 93).addBox(0.0F, -5.0F, 15.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -7.0F));

		PartDefinition bone13 = head.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(40, 93).addBox(0.0F, -2.0F, 9.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 93).addBox(-1.0F, -3.0F, 11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 93).addBox(-2.0F, -4.0F, 13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 93).addBox(-3.0F, -5.0F, 15.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, -7.0F));

		PartDefinition bone14 = head.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(56, 93).addBox(0.0F, -2.0F, 9.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 93).addBox(1.0F, -3.0F, 11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 93).addBox(2.0F, -4.0F, 13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(74, 93).addBox(3.0F, -5.0F, 15.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, -7.0F));

		PartDefinition bone15 = head.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(78, 93).addBox(0.0F, -2.0F, 9.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(82, 93).addBox(1.0F, -3.0F, 11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(86, 93).addBox(2.0F, -4.0F, 13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 93).addBox(3.0F, -5.0F, 15.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -9.0F));

		PartDefinition bone16 = head.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(94, 12).addBox(0.0F, -2.0F, 9.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 94).addBox(-1.0F, -3.0F, 11.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 94).addBox(-2.0F, -4.0F, 13.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(94, 35).addBox(-3.0F, -5.0F, 15.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -9.0F));

		PartDefinition bone10 = head.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(90, 73).addBox(3.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(3.0F, -6.0F, 5.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -7.0F));

		PartDefinition bone11 = head.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(90, 77).addBox(-5.0F, -2.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 91).addBox(-4.0F, -6.0F, 5.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -7.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -18.0F, -4.0F, 6.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(44, 40).addBox(-1.0F, -19.0F, -4.0F, 2.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 22).addBox(0.0F, -20.0F, -4.0F, 0.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(2.0F, -19.0F, -4.0F, 0.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(-2.0F, -19.0F, -4.0F, 0.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-4.0F, -17.0F, -4.0F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -15.0F, -4.0F, 10.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -4.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(56, 71).addBox(-4.0F, -17.0F, 8.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 42).addBox(-3.0F, -16.0F, 10.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(80, 23).addBox(-2.0F, -17.0F, 10.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(80, 29).addBox(-1.0F, -16.0F, 13.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 81).addBox(0.0F, -18.0F, 16.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(82, 81).addBox(0.0F, -20.0F, 19.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 88).addBox(0.0F, -23.0F, 22.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 88).addBox(0.0F, -26.0F, 23.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(84, 0).addBox(-1.0F, -17.0F, 10.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(84, 6).addBox(0.0F, -16.0F, 13.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 87).addBox(1.0F, -18.0F, 16.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(70, 87).addBox(1.0F, -20.0F, 19.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(76, 17).addBox(1.0F, -23.0F, 22.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 88).addBox(1.0F, -26.0F, 23.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(84, 55).addBox(-1.0F, -17.0F, 10.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(84, 61).addBox(0.0F, -16.0F, 13.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(78, 87).addBox(1.0F, -18.0F, 16.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(86, 87).addBox(1.0F, -20.0F, 19.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 91).addBox(1.0F, -23.0F, 22.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 91).addBox(1.0F, -26.0F, 23.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 74).addBox(6.0F, -14.0F, -8.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 81).addBox(6.0F, -9.0F, -7.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 85).addBox(6.0F, -6.0F, -6.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 17).addBox(6.0F, -1.0F, -7.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, 1.0F));

		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(32, 77).addBox(6.0F, -14.0F, -8.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(10, 85).addBox(6.0F, -9.0F, -7.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(90, 67).addBox(6.0F, -6.0F, -6.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 12).addBox(6.0F, -1.0F, -7.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.0F, 11.0F));

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(16, 74).addBox(-8.0F, -14.0F, -8.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(58, 81).addBox(-8.0F, -9.0F, -7.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 87).addBox(-8.0F, -6.0F, -6.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 17).addBox(-8.0F, -1.0F, -7.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 24.0F, 1.0F));

		PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(76, 71).addBox(-8.0F, -14.0F, -8.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 85).addBox(-8.0F, -9.0F, -7.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 88).addBox(-8.0F, -6.0F, -6.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 77).addBox(-8.0F, -1.0F, -7.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 24.0F, 11.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}