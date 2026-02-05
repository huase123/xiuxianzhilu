package huase.xiuxianzhilu.entity.moster.zuoying;// Made with Blockbench 5.0.7
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

public class ZuoyingModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "zuoyingmodel"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/zuoying.png"), "main");
	private final ModelPart head;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone8;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart body;
	private final ModelPart body2;
	private final ModelPart body3;
	private final ModelPart body4;
	private final ModelPart body5;
	private final ModelPart body6;
	private final ModelPart body7;
	private final ModelPart body8;
	private final ModelPart body9;
	private final ModelPart body10;
	private final ModelPart body11;
	private final ModelPart body12;
	private final ModelPart body13;
	private final ModelPart body14;
	private final ModelPart body15;
	private final ModelPart body16;
	private final ModelPart body17;
	private final ModelPart body18;
	private final ModelPart body19;

	public ZuoyingModel(ModelPart root) {
		this.head = root.getChild("head");
		this.bone = this.head.getChild("bone");
		this.bone2 = this.head.getChild("bone2");
		this.bone3 = this.head.getChild("bone3");
		this.bone4 = this.head.getChild("bone4");
		this.bone5 = this.head.getChild("bone5");
		this.bone8 = this.head.getChild("bone8");
		this.bone6 = this.head.getChild("bone6");
		this.bone7 = this.head.getChild("bone7");
		this.body = root.getChild("body");
		this.body2 = root.getChild("body2");
		this.body3 = root.getChild("body3");
		this.body4 = root.getChild("body4");
		this.body5 = root.getChild("body5");
		this.body6 = root.getChild("body6");
		this.body7 = root.getChild("body7");
		this.body8 = root.getChild("body8");
		this.body9 = root.getChild("body9");
		this.body10 = root.getChild("body10");
		this.body11 = root.getChild("body11");
		this.body12 = root.getChild("body12");
		this.body13 = root.getChild("body13");
		this.body14 = root.getChild("body14");
		this.body15 = root.getChild("body15");
		this.body16 = root.getChild("body16");
		this.body17 = root.getChild("body17");
		this.body18 = root.getChild("body18");
		this.body19 = root.getChild("body19");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(5, 21).addBox(-4.0F, -31.0F, -10.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(14, 10).addBox(-3.0F, -30.0F, -15.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, -1.0F, -5.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -27.0F, -9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(3, 14).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(-1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(-1.5F, -2.0F, 4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -33.0F, 1.0F));

		PartDefinition bone2 = head.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(3, 14).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(0.5F, -2.0F, 4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -33.0F, 1.0F));

		PartDefinition bone3 = head.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(3, 14).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(2.5F, -2.0F, 4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -33.0F, 1.0F));

		PartDefinition bone4 = head.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(3, 14).mirror().addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-1.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-3.5F, -2.0F, 4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -33.0F, 1.0F));

		PartDefinition bone5 = head.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(3, 14).mirror().addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-1.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -30.0F, -2.0F));

		PartDefinition bone8 = head.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(3, 14).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -30.0F, -2.0F));

		PartDefinition bone6 = head.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(3, 14).mirror().addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-1.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(3, 14).mirror().addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -27.0F, -2.0F));

		PartDefinition bone7 = head.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(3, 14).addBox(-0.5F, 1.0F, -8.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(0.5F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(3, 14).addBox(1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -27.0F, -2.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.5F, -0.6667F));

		PartDefinition body2 = partdefinition.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.5F, 1.3333F));

		PartDefinition body3 = partdefinition.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.5F, 2.3333F));

		PartDefinition body4 = partdefinition.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 8.5F, 3.3333F));

		PartDefinition body5 = partdefinition.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 11.5F, 5.3333F));

		PartDefinition body6 = partdefinition.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 16.5F, 6.3333F));

		PartDefinition body7 = partdefinition.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 17.5F, 2.3333F));

		PartDefinition body8 = partdefinition.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-8, -4).addBox(-2.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.5F, 0.3333F));

		PartDefinition body9 = partdefinition.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(-8, -4).addBox(-2.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 19.5F, -3.6667F));

		PartDefinition body10 = partdefinition.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 19.5F, -9.6667F));

		PartDefinition body11 = partdefinition.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 19.5F, -6.6667F));

		PartDefinition body12 = partdefinition.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 19.5F, -2.6667F));

		PartDefinition body13 = partdefinition.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 19.5F, 2.3333F));

		PartDefinition body14 = partdefinition.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 19.5F, 6.3333F));

		PartDefinition body15 = partdefinition.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 17.5F, 9.3333F));

		PartDefinition body16 = partdefinition.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 17.5F, 12.3333F));

		PartDefinition body17 = partdefinition.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 17.5F, 15.3333F));

		PartDefinition body18 = partdefinition.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 19.5F, 15.3333F));

		PartDefinition body19 = partdefinition.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(-8, -4).addBox(-3.0F, -1.5F, -4.3333F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-2, -4).addBox(0.0F, -3.5F, -4.3333F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(0.0F, -2.5F, 1.6667F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 19.5F, 13.3333F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}