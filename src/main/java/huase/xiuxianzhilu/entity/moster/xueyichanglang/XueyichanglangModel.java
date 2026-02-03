package huase.xiuxianzhilu.entity.moster.xueyichanglang;// Made with Blockbench 5.0.7
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

public class XueyichanglangModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "xueyichanglangmodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/xueyichanglang.png"), "main");
	private final ModelPart bb_main;

	public XueyichanglangModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(60, 6).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(56, 43).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 59).addBox(-2.0F, -9.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -13.0F, -1.3F, 9.0F, 4.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(10, 60).addBox(4.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 59).addBox(4.0F, -8.0F, 0.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 59).addBox(4.0F, -9.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 11).addBox(-2.6F, -2.0F, 10.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 42).addBox(-2.6F, -5.0F, 11.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(-2.6F, -11.0F, 9.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 65).addBox(-2.6F, -8.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 56).addBox(-2.6F, -6.0F, 10.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 60).addBox(5.6F, -2.0F, 10.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 47).addBox(5.6F, -5.0F, 11.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 0).addBox(5.6F, -11.0F, 9.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(5.6F, -8.0F, 10.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 67).addBox(5.6F, -6.0F, 10.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-1.0F, -18.0F, -4.3F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(22, 69).addBox(0.0F, -22.0F, -2.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 11).addBox(-1.0F, -21.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 24).addBox(1.0F, -21.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 71).addBox(2.0F, -19.0F, -2.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 69).addBox(4.0F, -22.0F, -2.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 70).addBox(3.0F, -21.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 70).addBox(5.0F, -21.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 69).addBox(-2.0F, -18.0F, -2.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 21).addBox(-1.0F, -19.0F, -4.3F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 63).addBox(3.0F, -19.0F, -4.3F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 69).addBox(6.0F, -18.0F, -2.3F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 70).addBox(-3.0F, -18.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 70).addBox(7.0F, -18.0F, -2.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 25).addBox(-1.0F, -13.0F, -2.3F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 25).addBox(1.0F, -13.0F, -4.3F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(68, 30).addBox(0.0F, -13.0F, -4.3F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 68).addBox(4.0F, -13.0F, -4.3F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 52).addBox(1.5F, -10.0F, -4.3F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(33, 39).addBox(0.0F, -16.0F, 2.7F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 72).addBox(6.0F, -18.0F, -1.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 72).addBox(-2.0F, -18.0F, -1.3F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 19).addBox(-0.5F, -19.0F, -1.3F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 44).addBox(-1.0F, -20.0F, -1.3F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 65).addBox(1.4F, -13.0F, 13.7F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 63).addBox(1.4F, -12.0F, 15.7F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 63).addBox(1.4F, -10.0F, 17.7F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(60, 30).addBox(1.4F, -8.0F, 19.7F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 15).addBox(3.4F, -12.0F, 13.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 72).addBox(0.4F, -12.0F, 13.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 43).addBox(3.4F, -11.0F, 15.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 65).addBox(3.4F, -12.0F, 14.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 37).addBox(3.4F, -12.0F, 15.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 50).addBox(0.4F, -12.0F, 15.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 41).addBox(0.4F, -12.0F, 14.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 54).addBox(0.4F, -11.0F, 15.7F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(34, 72).addBox(3.4F, -10.0F, 17.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 44).addBox(3.4F, -9.0F, 18.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 69).addBox(3.4F, -8.0F, 19.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).addBox(0.4F, -8.0F, 19.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 47).addBox(0.4F, -9.0F, 18.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 37).addBox(0.4F, -10.0F, 17.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 19).addBox(1.4F, -11.0F, 17.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 70).addBox(1.4F, -13.0F, 15.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 28).addBox(1.4F, -9.0F, 19.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 32).addBox(-2.0F, -14.0F, -0.3F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 59).addBox(-2.0F, -17.0F, -0.3F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 68).addBox(6.0F, -17.0F, -0.3F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(49, 1).addBox(6.0F, -14.0F, -0.3F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(45, 23).addBox(-1.0F, -14.0F, 4.7F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 60).mirror().addBox(7.0F, -13.0F, 4.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(62, 16).mirror().addBox(6.0F, -14.0F, 3.7F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 13).mirror().addBox(6.0F, -15.0F, 3.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 30).mirror().addBox(6.0F, -16.0F, 4.7F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 47).mirror().addBox(6.0F, -17.0F, 5.7F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 31).mirror().addBox(6.0F, -18.0F, 6.7F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 19).mirror().addBox(6.0F, -22.0F, 8.7F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(42, 53).mirror().addBox(6.0F, -23.0F, 10.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 54).mirror().addBox(6.0F, -24.0F, 11.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 54).mirror().addBox(6.0F, -25.0F, 13.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 54).mirror().addBox(6.0F, -26.0F, 14.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(70, 0).mirror().addBox(7.0F, -21.0F, 6.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 72).mirror().addBox(7.0F, -20.0F, 5.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(68, 34).mirror().addBox(7.0F, -17.0F, 3.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 69).mirror().addBox(7.0F, -16.0F, 3.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 51).mirror().addBox(5.0F, -16.0F, 2.7F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 69).mirror().addBox(7.0F, -23.0F, 7.7F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(4, 70).mirror().addBox(7.0F, -23.0F, 8.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(70, 5).mirror().addBox(7.0F, -24.0F, 9.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 66).mirror().addBox(7.0F, -25.0F, 10.7F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(70, 8).mirror().addBox(7.0F, -26.0F, 12.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(72, 66).mirror().addBox(7.0F, -19.0F, 4.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 60).addBox(-3.0F, -13.0F, 4.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 16).addBox(-2.0F, -14.0F, 3.7F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 13).addBox(-2.0F, -15.0F, 3.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(46, 30).addBox(-2.0F, -16.0F, 4.7F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-2.0F, -17.0F, 5.7F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-2.0F, -18.0F, 6.7F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(28, 19).addBox(-2.0F, -22.0F, 8.7F, 1.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(42, 53).addBox(-2.0F, -23.0F, 10.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-2.0F, -24.0F, 11.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 54).addBox(-2.0F, -25.0F, 13.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 54).addBox(-2.0F, -26.0F, 14.7F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(70, 0).addBox(-3.0F, -21.0F, 6.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 72).addBox(-3.0F, -20.0F, 5.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 34).addBox(-3.0F, -17.0F, 3.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 69).addBox(-3.0F, -16.0F, 3.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 51).addBox(-3.0F, -16.0F, 2.7F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 69).addBox(-3.0F, -23.0F, 7.7F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 70).addBox(-3.0F, -23.0F, 8.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 5).addBox(-3.0F, -24.0F, 9.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 66).addBox(-3.0F, -25.0F, 10.7F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(70, 8).addBox(-3.0F, -26.0F, 12.7F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(72, 66).addBox(-3.0F, -19.0F, 4.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 53).addBox(-7.0F, -2.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -20.0F, 15.7F, 0.48F, -0.2182F, 0.0F));

		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 39).addBox(-7.0F, -5.0F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(16, 39).mirror().addBox(3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -21.8F, 15.7F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 47).addBox(-7.0F, -2.0F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 39).addBox(-7.0F, -3.0F, 3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(28, 30).addBox(-7.0F, -4.0F, 3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -21.0F, 15.7F, 0.48F, -0.2182F, 0.0F));

		PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 47).addBox(-7.0F, -4.0F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(50, 37).addBox(-7.0F, -3.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(30, 63).addBox(-7.0F, -2.0F, 3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -17.0F, 11.7F, 0.2182F, -0.2182F, 0.0F));

		PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(62, 37).addBox(-7.0F, -2.0F, 3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -16.0F, 11.7F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 53).mirror().addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -20.0F, 15.7F, 0.48F, 0.2182F, 0.0F));

		PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 47).mirror().addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(6.0F, -3.0F, 3.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 30).mirror().addBox(6.0F, -4.0F, 3.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -21.0F, 15.7F, 0.48F, 0.2182F, 0.0F));

		PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 47).mirror().addBox(6.0F, -4.0F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(50, 37).mirror().addBox(6.0F, -3.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 63).mirror().addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -17.0F, 11.7F, 0.2182F, 0.2182F, 0.0F));

		PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(62, 37).mirror().addBox(6.0F, -2.0F, 3.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -16.0F, 11.7F, 0.0F, 0.2182F, 0.0F));

		PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 7).addBox(-3.0F, -2.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -13.1F, -6.5F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(42, 47).addBox(-3.0F, -2.0F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -14.0F, -7.2F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}