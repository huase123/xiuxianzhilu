package huase.xiuxianzhilu.entity.moster.huanduzhu;// Made with Blockbench 5.0.7
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

public class HuanduzhuModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "huanduzhumodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/huanduzhu.png"), "main");
	private final ModelPart head;
	private final ModelPart body0;
	private final ModelPart body1;
	private final ModelPart bone;
	private final ModelPart bone7;
	private final ModelPart bone14;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone12;

	public HuanduzhuModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body0 = root.getChild("body0");
		this.body1 = root.getChild("body1");
		this.bone = root.getChild("bone");
		this.bone7 = this.bone.getChild("bone7");
		this.bone14 = this.bone.getChild("bone14");
		this.bone2 = this.bone.getChild("bone2");
		this.bone3 = this.bone.getChild("bone3");
		this.bone8 = root.getChild("bone8");
		this.bone9 = this.bone8.getChild("bone9");
		this.bone10 = this.bone8.getChild("bone10");
		this.bone11 = this.bone8.getChild("bone11");
		this.bone12 = this.bone8.getChild("bone12");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -3.0F));

		PartDefinition body0 = partdefinition.addOrReplaceChild("body0", CubeListBuilder.create().texOffs(32, 24).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition body1 = partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 9.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, 0.0F));

		PartDefinition bone7 = bone.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg7_r1 = bone7.addOrReplaceChild("leg7_r1", CubeListBuilder.create().texOffs(0, 40).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 51.0F, 6.0F, -0.2074F, -0.0999F, 1.1448F));

		PartDefinition leg6_r1 = bone7.addOrReplaceChild("leg6_r1", CubeListBuilder.create().texOffs(32, 36).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 49.0F, 4.0F, -0.0846F, -0.2013F, 0.4013F));

		PartDefinition leg5_r1 = bone7.addOrReplaceChild("leg5_r1", CubeListBuilder.create().texOffs(20, 40).addBox(1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 53.0F, 3.0F, 0.1104F, -0.1886F, -0.534F));

		PartDefinition bone14 = bone.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg4_r1 = bone14.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(0, 40).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 51.0F, -3.0F, -0.0095F, 0.3407F, 1.1308F));

		PartDefinition leg3_r1 = bone14.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(32, 36).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 49.0F, -2.0F, 0.0F, 0.1745F, 0.3927F));

		PartDefinition leg2_r1 = bone14.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(20, 40).addBox(1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 53.0F, -1.0F, 0.0F, 0.1309F, -0.5236F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg5_r2 = bone2.addOrReplaceChild("leg5_r2", CubeListBuilder.create().texOffs(0, 40).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 51.0F, -1.0F, -0.009F, -0.0083F, 1.1341F));

		PartDefinition leg4_r2 = bone2.addOrReplaceChild("leg4_r2", CubeListBuilder.create().texOffs(32, 36).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 49.0F, -1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition leg3_r2 = bone2.addOrReplaceChild("leg3_r2", CubeListBuilder.create().texOffs(20, 40).addBox(1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 53.0F, -1.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg6_r2 = bone3.addOrReplaceChild("leg6_r2", CubeListBuilder.create().texOffs(0, 40).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 51.0F, 3.0F, -0.0881F, -0.0452F, 1.1362F));

		PartDefinition leg5_r3 = bone3.addOrReplaceChild("leg5_r3", CubeListBuilder.create().texOffs(32, 36).addBox(1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 49.0F, 2.0F, -0.0335F, -0.0806F, 0.394F));

		PartDefinition leg4_r3 = bone3.addOrReplaceChild("leg4_r3", CubeListBuilder.create().texOffs(20, 40).addBox(1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 53.0F, 1.0F, 0.0437F, -0.0756F, -0.5253F));

		PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, 0.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg8_r1 = bone9.addOrReplaceChild("leg8_r1", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 51.0F, 6.0F, -0.2074F, 0.0999F, -1.1448F));

		PartDefinition leg7_r2 = bone9.addOrReplaceChild("leg7_r2", CubeListBuilder.create().texOffs(32, 36).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 49.0F, 4.0F, -0.0846F, 0.2013F, -0.4013F));

		PartDefinition leg6_r3 = bone9.addOrReplaceChild("leg6_r3", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 53.0F, 3.0F, 0.1104F, 0.1886F, 0.534F));

		PartDefinition bone10 = bone8.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg5_r4 = bone10.addOrReplaceChild("leg5_r4", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 51.0F, -3.0F, -0.0095F, -0.3407F, -1.1308F));

		PartDefinition leg4_r4 = bone10.addOrReplaceChild("leg4_r4", CubeListBuilder.create().texOffs(32, 36).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 49.0F, -2.0F, 0.0F, -0.1745F, -0.3927F));

		PartDefinition leg3_r3 = bone10.addOrReplaceChild("leg3_r3", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 53.0F, -1.0F, 0.0F, -0.1309F, 0.5236F));

		PartDefinition bone11 = bone8.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg6_r4 = bone11.addOrReplaceChild("leg6_r4", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 51.0F, -1.0F, -0.009F, 0.0083F, -1.1341F));

		PartDefinition leg5_r5 = bone11.addOrReplaceChild("leg5_r5", CubeListBuilder.create().texOffs(32, 36).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 49.0F, -1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition leg4_r5 = bone11.addOrReplaceChild("leg4_r5", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 53.0F, -1.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition bone12 = bone8.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg7_r3 = bone12.addOrReplaceChild("leg7_r3", CubeListBuilder.create().texOffs(0, 40).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 51.0F, 3.0F, -0.0881F, 0.0452F, -1.1362F));

		PartDefinition leg6_r5 = bone12.addOrReplaceChild("leg6_r5", CubeListBuilder.create().texOffs(32, 36).mirror().addBox(-9.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 49.0F, 2.0F, -0.0335F, 0.0806F, -0.394F));

		PartDefinition leg5_r6 = bone12.addOrReplaceChild("leg5_r6", CubeListBuilder.create().texOffs(20, 40).mirror().addBox(-7.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 53.0F, 1.0F, 0.0437F, 0.0756F, 0.5253F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}