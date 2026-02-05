package huase.xiuxianzhilu.entity.moster.youmingguishou;// Made with Blockbench 5.0.7
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

public class YoumingguishouModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "youmingguishoumodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/youmingguishou.png"), "main");
	private final ModelPart bone;
	private final ModelPart bb_main;

	public YoumingguishouModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 78).mirror().addBox(-23.0F, 30.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 78).mirror().addBox(-22.0F, 28.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(42, 74).mirror().addBox(-21.0F, 26.0F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(66, 28).mirror().addBox(-19.0F, 24.0F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(78, 27).mirror().addBox(-24.0F, 32.0F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 74).mirror().addBox(-16.0F, 22.0F, 6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 28).mirror().addBox(-14.0F, 20.0F, 6.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 70).mirror().addBox(-9.0F, 18.0F, 6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 25).mirror().addBox(-15.0F, 21.0F, 5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 74).mirror().addBox(-7.0F, 18.0F, 5.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(62, 74).mirror().addBox(-6.0F, 14.0F, 6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 70).mirror().addBox(-4.0F, 11.0F, 6.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 12).mirror().addBox(-1.0F, 10.0F, 3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 75).mirror().addBox(-1.0F, 6.0F, 2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 78).mirror().addBox(0.0F, 3.0F, 0.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(80, 4).mirror().addBox(0.0F, 1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 76).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(76, 47).mirror().addBox(-5.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(58, 61).mirror().addBox(-6.0F, -4.0F, -1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(80, 8).mirror().addBox(-6.0F, -5.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0F, 7.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 47).addBox(-7.0F, 7.0F, 1.0F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 33).addBox(-9.0F, 6.0F, 1.0F, 11.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(42, 40).addBox(-10.0F, 5.0F, 1.0F, 13.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-11.0F, 4.0F, 1.0F, 15.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-12.0F, 3.0F, 1.0F, 17.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(-12.0F, 1.0F, 1.0F, 18.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-13.0F, -1.0F, 1.0F, 20.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(6.0F, -6.0F, 2.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(8.0F, -6.0F, 2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 10).addBox(7.0F, -10.0F, 2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 70).addBox(8.0F, -13.0F, 3.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-14.0F, -12.0F, 1.0F, 20.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 55).addBox(3.0F, -14.0F, 2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 61).addBox(3.3F, -17.0F, 1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 63).addBox(4.0F, -21.0F, 1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 70).addBox(4.5F, -23.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 68).addBox(3.9F, -25.0F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 18).addBox(-3.0F, -14.0F, 2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 47).addBox(-2.5F, -18.0F, -0.4F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 62).addBox(-2.0F, -23.0F, -0.4F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(76, 55).addBox(-1.5F, -26.0F, -0.4F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 68).addBox(-1.5F, -29.0F, -0.4F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 47).addBox(-2.0F, -33.0F, 0.6F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(40, 62).addBox(-1.0F, -36.0F, 1.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 76).addBox(-7.9F, -22.0F, 1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 68).addBox(-7.9F, -25.0F, 1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(66, 0).addBox(-8.0F, -19.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(62, 55).addBox(-8.0F, -16.0F, 1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 56).addBox(-8.0F, -14.0F, 2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 47).addBox(-15.0F, -16.0F, 2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(72, 61).addBox(-14.0F, -19.0F, 3.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 25).addBox(-10.0F, 4.0F, 7.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 24).addBox(0.0F, 2.0F, 7.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 73).addBox(1.0F, 0.0F, 7.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 74).addBox(2.0F, -2.0F, 7.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 0).addBox(5.0F, -5.0F, 7.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 74).addBox(-12.0F, 1.0F, 7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 78).addBox(-12.0F, -1.0F, 7.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 66).addBox(-8.0F, 3.0F, 7.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 77).addBox(-13.0F, -5.0F, 7.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 76).addBox(-13.0F, -9.0F, 7.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 47).addBox(-8.5F, -29.0F, 1.6F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(-7.5F, -31.0F, 2.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 47).addBox(-13.7F, -23.0F, 2.3F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(-12.7F, -25.0F, 3.3F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 6).addBox(3.5F, -28.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(4.5F, -30.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 68).addBox(8.3F, -16.0F, 2.3F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(40, 62).addBox(8.8F, -19.0F, 3.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 63).addBox(4.0F, -32.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 80).addBox(-7.0F, -33.0F, 2.6F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 80).addBox(-12.2F, -27.0F, 3.3F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 27).addBox(7.0F, 15.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 78).addBox(6.0F, 13.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 78).addBox(5.0F, 11.0F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 74).addBox(3.0F, 9.0F, 6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 28).addBox(0.0F, 7.0F, 7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(52, 74).addBox(-2.0F, 5.0F, 8.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 28).addBox(-8.0F, 3.0F, 8.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(-10.0F, 1.0F, 8.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 74).addBox(-11.0F, -3.0F, 8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 70).addBox(-14.0F, -6.0F, 8.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 12).addBox(-16.0F, -7.0F, 5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 75).addBox(-16.0F, -11.0F, 4.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 78).addBox(-16.0F, -14.0F, 2.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(12, 76).addBox(-16.0F, -18.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 4).addBox(-16.0F, -16.0F, 1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 47).addBox(-13.0F, -19.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(58, 61).addBox(-11.0F, -21.0F, 1.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(80, 8).addBox(-10.0F, -22.0F, 6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(80, 8).addBox(5.0F, 4.0F, 4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -1.0F, 2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 61).addBox(4.0F, 3.0F, 4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.0F, -3.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(76, 47).addBox(4.0F, 3.0F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -4.0F, -3.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 76).addBox(4.0F, 3.0F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -5.0F, -3.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(76, 51).addBox(2.0F, 3.0F, 3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -7.0F, -2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(70, 18).addBox(4.0F, 1.0F, 4.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -9.0F, -2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(22, 75).addBox(4.0F, 1.0F, 4.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -12.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(68, 12).addBox(4.0F, 1.0F, 2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -14.0F, 3.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 70).addBox(4.0F, 0.0F, 4.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -16.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(62, 74).addBox(5.0F, 0.0F, 4.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -19.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(32, 74).addBox(-10.0F, 0.0F, 1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -22.0F, 6.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r12 = bb_main.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(48, 25).addBox(-10.0F, 0.0F, 1.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -24.0F, 6.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r13 = bb_main.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 70).addBox(3.0F, 0.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -21.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r14 = bb_main.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(48, 28).addBox(0.0F, 0.0F, 4.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -23.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r15 = bb_main.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(52, 74).addBox(3.0F, 0.0F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -25.0F, 4.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r16 = bb_main.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(78, 27).addBox(4.0F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -35.0F, 1.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r17 = bb_main.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(66, 28).addBox(2.0F, 0.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -27.0F, 3.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r18 = bb_main.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(42, 74).addBox(3.0F, 0.0F, 4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -29.0F, 2.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bb_main.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(38, 78).addBox(4.0F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -31.0F, 1.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r20 = bb_main.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(30, 78).addBox(4.0F, 0.0F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -33.0F, 1.0F, -0.7418F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}