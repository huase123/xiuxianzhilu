package huase.xiuxianzhilu.entity.moster.bingfenghuang;// Made with Blockbench 5.0.7
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

public class BingfenghuangModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "bingfenghuang"), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModMain.prefix("textures/entity/moster/bingfenghuang.png"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;

	public BingfenghuangModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
		this.bone4 = root.getChild("bone4");
		this.bone5 = root.getChild("bone5");
		this.bone6 = this.bone5.getChild("bone6");
		this.bone7 = this.bone5.getChild("bone7");
		this.bone8 = this.bone5.getChild("bone8");
		this.bone9 = this.bone5.getChild("bone9");
		this.bone10 = this.bone5.getChild("bone10");
		this.bone11 = this.bone5.getChild("bone11");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(106, 111).addBox(-1.0F, -3.7857F, -9.1429F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(98, 111).addBox(-1.0F, -4.7857F, -7.1429F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(104, 94).addBox(-2.0F, -5.7857F, -5.1429F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(98, 101).addBox(-3.0F, -6.7857F, -3.1429F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(76, 101).addBox(-4.0F, -3.7857F, -0.1429F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(40, 94).addBox(-5.0F, -1.7857F, 2.8571F, 10.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 94).addBox(-6.0F, 8.2143F, 6.8571F, 12.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.7857F, -6.8571F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 109).addBox(-2.0F, -8.0F, -1.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 109).addBox(-1.0F, -3.0F, -0.375F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(90, 111).addBox(-1.0F, 1.0F, -1.375F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 111).addBox(-2.0F, 4.0F, -2.375F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.0F, -0.625F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 109).mirror().addBox(-2.0F, -8.0F, -1.375F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 109).mirror().addBox(-1.0F, -3.0F, -0.375F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(90, 111).mirror().addBox(-1.0F, 1.0F, -1.375F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(76, 111).mirror().addBox(-2.0F, 4.0F, -2.375F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 19.0F, -0.625F));

		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 0).addBox(-68.0F, -47.0F, 0.0F, 64.0F, 94.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(4.0F, -47.0F, 0.0F, 64.0F, 94.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(76, 94).addBox(-4.0F, -6.0714F, -1.2857F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0714F, 9.2857F));

		PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(18, 109).addBox(0.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.9286F, -0.2857F));

		PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(18, 109).addBox(0.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.9286F, -0.2857F));

		PartDefinition bone8 = bone5.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(18, 109).addBox(0.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.9286F, -0.2857F));

		PartDefinition bone9 = bone5.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(18, 109).addBox(0.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 0.9286F, -0.2857F));

		PartDefinition bone10 = bone5.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(18, 109).addBox(2.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(1.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 109).addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.9286F, -0.2857F));

		PartDefinition bone11 = bone5.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(18, 109).mirror().addBox(-2.0F, -7.0F, 4.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 109).mirror().addBox(-1.0F, -6.0F, 10.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 109).mirror().addBox(0.0F, -5.0F, 16.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 0.9286F, -0.2857F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}