package huase.xiuxianzhilu.entity.moster.shayingmoxie;// Made with Blockbench 5.0.7
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

public class ShayingmoxieModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "shayingmoxiemodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/shayingmoxie.png"), "main");
	private final ModelPart bone2;
	private final ModelPart bone;
	private final ModelPart bb_main;

	public ShayingmoxieModel(ModelPart root) {
		this.bone2 = root.getChild("bone2");
		this.bone = root.getChild("bone");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(18, 52).addBox(-6.5F, -3.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 21).addBox(-6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 21).addBox(-7.0F, -2.0F, -4.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 52).addBox(-25.0F, -1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(-23.0F, -1.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 0).addBox(-23.5F, -3.0F, -4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(38, 51).addBox(-24.0F, -2.0F, -4.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 51).addBox(-5.0F, -1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 23.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(24, 34).addBox(-8.0F, -13.2028F, 10.8149F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(34, 54).addBox(-6.5F, -6.2028F, 11.8149F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 5.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(28, 12).addBox(-5.0F, -5.0F, -3.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 24).addBox(-6.0F, -6.0F, 2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-7.0F, -7.0F, 6.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -9.0F, 12.0F, 10.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-7.0F, -11.0F, 17.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-6.0F, -12.0F, 21.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-5.0F, -19.0F, 23.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(40, 34).addBox(-5.0F, -25.0F, 27.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(54, 3).addBox(-4.0F, -20.0F, 27.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 7).addBox(-4.0F, -30.0F, 28.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-5.0F, -41.0F, 23.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 35).addBox(-4.0F, -38.0F, 26.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 43).addBox(-5.0F, -35.0F, 27.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(54, 7).addBox(-4.0F, -38.0F, 25.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 44).addBox(-4.0F, -41.0F, 20.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 29).addBox(-6.0F, -15.0F, 21.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 54).addBox(-4.0F, -22.0F, 26.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 27).addBox(-4.0F, -19.0F, 27.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(56, 57).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 11).addBox(-0.5F, -3.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 43).addBox(1.0F, -4.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 63).addBox(2.5F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 40).addBox(6.5F, -3.0F, -5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 53).addBox(5.5F, -3.5F, -6.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 44).addBox(5.5F, -4.5F, -10.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 58).addBox(6.0F, -4.0F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 21).addBox(6.0F, -2.0F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 47).addBox(5.1F, -5.0F, -12.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 49).addBox(4.3F, -4.6F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 55).addBox(3.3F, -4.6F, -14.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 14).addBox(2.3F, -4.3F, -16.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 55).addBox(5.1F, -1.0F, -12.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 55).addBox(4.3F, -0.6F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 56).addBox(3.3F, -0.6F, -14.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 17).addBox(2.3F, -0.3F, -16.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 68).addBox(3.3F, -3.3F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 26).addBox(3.3F, -1.3F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 33).addBox(5.3F, -1.6F, -13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(5.3F, -3.6F, -13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 35).addBox(4.3F, -1.6F, -14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 2).addBox(4.3F, -3.6F, -14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 37).addBox(2.3F, -1.3F, -16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 68).addBox(2.3F, -3.3F, -16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 58).addBox(-7.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 13).addBox(-8.5F, -3.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 42).addBox(-10.0F, -4.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 27).addBox(-10.5F, -5.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 51).addBox(-13.5F, -3.0F, -5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-14.5F, -3.5F, -6.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 21).addBox(-14.5F, -4.5F, -10.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 15).addBox(-14.5F, -5.5F, -8.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 22).addBox(0.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 59).addBox(5.5F, -4.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 59).addBox(6.5F, -3.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(58, 59).addBox(7.5F, -1.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 13).addBox(6.5F, 1.5F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 24).addBox(6.2F, 3.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 29).addBox(6.2F, 4.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(4.3F, 7.9F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 31).addBox(0.5F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 3).addBox(1.0F, -4.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 39).addBox(2.5F, -5.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 5).addBox(4.5F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 66).addBox(3.5F, -5.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 66).addBox(5.2F, 4.9F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 16).addBox(4.9F, 5.9F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 41).addBox(1.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 63).addBox(6.5F, -5.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 60).addBox(7.5F, -4.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 60).addBox(8.5F, -2.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 19).addBox(7.5F, 0.5F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 43).addBox(7.2F, 2.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 45).addBox(7.2F, 3.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 9).addBox(5.3F, 7.9F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 60).addBox(5.5F, -6.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 64).addBox(6.2F, 3.9F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 64).addBox(5.9F, 5.9F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 50).addBox(4.5F, -6.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 52).addBox(3.5F, -6.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 29).addBox(2.0F, -5.0F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 54).addBox(1.5F, -4.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 56).addBox(2.0F, -4.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 60).addBox(7.5F, -6.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 60).addBox(8.5F, -5.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 61).addBox(9.5F, -3.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 64).addBox(8.5F, -0.5F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 60).addBox(8.2F, 1.5F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 33).addBox(8.2F, 2.5F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 31).addBox(6.3F, 7.9F, 14.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 5).addBox(6.5F, -7.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 64).addBox(7.2F, 3.9F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 36).addBox(6.9F, 5.9F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 62).addBox(5.5F, -7.5F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 67).addBox(4.5F, -7.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 61).addBox(3.0F, -6.0F, 14.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 67).addBox(2.5F, -5.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 61).addBox(-12.5F, -4.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 62).addBox(-13.5F, -3.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 62).addBox(-14.5F, -1.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 64).addBox(-13.5F, 1.5F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 67).addBox(-13.2F, 3.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 67).addBox(-13.2F, 4.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 0).addBox(-12.3F, 7.9F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 57).addBox(-9.0F, -4.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 67).addBox(-9.5F, -5.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 23).addBox(-11.5F, -5.0F, 3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 67).addBox(-10.5F, -5.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 67).addBox(-12.2F, 4.9F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 64).addBox(-11.9F, 5.9F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 62).addBox(-13.5F, -5.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 40).addBox(-14.5F, -4.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 57).addBox(-15.5F, -2.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 65).addBox(-14.5F, 0.5F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 67).addBox(-14.2F, 2.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 68).addBox(-14.2F, 3.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 11).addBox(-13.3F, 7.9F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 44).addBox(-12.5F, -6.0F, 8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 65).addBox(-13.2F, 3.9F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 65).addBox(-12.9F, 5.9F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-11.5F, -6.5F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 68).addBox(-10.5F, -6.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 48).addBox(-10.0F, -5.0F, 8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 4).addBox(-8.5F, -4.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 6).addBox(-9.0F, -4.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 50).addBox(-14.5F, -6.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 57).addBox(-15.5F, -5.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 54).addBox(-16.5F, -3.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 64).addBox(-15.5F, -0.5F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 11).addBox(-15.2F, 1.5F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 65).addBox(-15.2F, 2.5F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 58).addBox(-14.3F, 7.9F, 14.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 60).addBox(-13.5F, -7.0F, 14.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 65).addBox(-14.2F, 3.9F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 65).addBox(-13.9F, 5.9F, 14.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 68).addBox(-12.5F, -7.5F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 13).addBox(-11.5F, -7.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 63).addBox(-11.0F, -6.0F, 14.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 15).addBox(-9.5F, -5.0F, 14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 68).addBox(-7.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 17).addBox(-7.5F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 19).addBox(-8.0F, -3.0F, 8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 58).mirror().addBox(-14.0F, -4.0F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(58, 21).mirror().addBox(-14.0F, -2.0F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(54, 47).mirror().addBox(-14.1F, -5.0F, -12.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(54, 49).mirror().addBox(-13.3F, -4.6F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 55).mirror().addBox(-12.3F, -4.6F, -14.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 14).mirror().addBox(-11.3F, -4.3F, -16.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 55).mirror().addBox(-14.1F, -1.0F, -12.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(54, 55).mirror().addBox(-13.3F, -0.6F, -13.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 56).mirror().addBox(-12.3F, -0.6F, -14.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 17).mirror().addBox(-11.3F, -0.3F, -16.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(20, 68).mirror().addBox(-10.3F, -3.3F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 26).mirror().addBox(-10.3F, -1.3F, -15.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 33).mirror().addBox(-12.3F, -1.6F, -13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 66).mirror().addBox(-12.3F, -3.6F, -13.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 35).mirror().addBox(-11.3F, -1.6F, -14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(66, 2).mirror().addBox(-11.3F, -3.6F, -14.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 37).mirror().addBox(-9.3F, -1.3F, -16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(40, 68).mirror().addBox(-9.3F, -3.3F, -16.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 15).addBox(5.5F, -5.5F, -8.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(73, 1).addBox(-4.5F, -2.2F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(73, 1).addBox(-2.5F, -2.2F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 57).addBox(5.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 58).addBox(9.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 58).addBox(-11.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 57).addBox(-15.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.5F, -6.0F, -0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}