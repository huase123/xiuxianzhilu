package huase.xiuxianzhilu.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.datagens.multiblock.MultiBlockPattern;
import huase.xiuxianzhilu.datagens.multiblock.REBlockPredicate;
import huase.xiuxianzhilu.recipe.multiblock.MultiBlockRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.data.ModelData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiBlockRecipeCategory implements IRecipeCategory<MultiBlockRecipe> {

    public static final RecipeType<MultiBlockRecipe> MULTIBLOCKRECIPE_TYPE = new RecipeType<>(ModMain.prefix("multiblockrecipe_type"), MultiBlockRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public MultiBlockRecipeCategory(IGuiHelper helper) {
        IDrawableBuilder iDrawableBuilder = helper.drawableBuilder(mutilblockbg, 0, 0, 148, 148);
        this.background = iDrawableBuilder.setTextureSize(148, 148).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.STRUCTURE_BLOCK));
    }

    private static final ResourceLocation mutilblockbg = ModMain.prefix("textures/gui/jei/mutilblockbg.png");

    @Override
    public RecipeType<MultiBlockRecipe> getRecipeType() {

        return MULTIBLOCKRECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("多方块结构");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MultiBlockRecipe recipe, IFocusGroup focuses) {
        Map<Character, REBlockPredicate> lookup = recipe.getMultiBlockPatternBuilder().getLookup();
        List<String[]> pattern = recipe.getMultiBlockPatternBuilder().getPattern();

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (String[] strings : pattern) {
            for (String string : strings) {
                for (char c : string.toCharArray()) {
                    charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                }
            }
        }

        List<ItemStack> list = new ArrayList<>();
        for (Map.Entry<Character, REBlockPredicate> characterREBlockPredicateEntry : lookup.entrySet()) {
            if(characterREBlockPredicateEntry != null && characterREBlockPredicateEntry.getValue() != null ){
                Block block = characterREBlockPredicateEntry.getValue().getBlock();
                if(!block.defaultBlockState().isAir()){
                    list.add(new ItemStack(block,charCountMap.get(characterREBlockPredicateEntry.getKey())));
                }
            }
        }

        builder
            .addSlot(RecipeIngredientRole.INPUT, 8, 8)
            .setOutputSlotBackground()
            .addItemStacks(list);

        Block block = recipe.getMultiBlockPatternBuilder().getResult().getBlock();
        if(!block.defaultBlockState().isAir()){
            builder.addSlot(RecipeIngredientRole.OUTPUT, 127,  8)
                    .setOutputSlotBackground()
                    .addItemStack(new ItemStack(block));
        }
    }


    @Override
    public void draw(MultiBlockRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        ClientLevel level = Minecraft.getInstance().level;
        MultiBlockPattern multiBlockPattern = recipe.getMultiBlockPattern();
        REBlockPredicate[][][] pattern = multiBlockPattern.getPattern();
        int width = multiBlockPattern.getWidth();
        int height = multiBlockPattern.getHeight();
        int depth = multiBlockPattern.getDepth();
        ModelData empty = ModelData.EMPTY;
        PoseStack posestack = guiGraphics.pose();
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();

        posestack.pushPose();
        posestack.translate(74,74, Math.max(width,Math.max(height,depth)));

        posestack.scale(16,-16,1);

        posestack.mulPose(Axis.YP.rotationDegrees((float) mouseX*0.4f));
        posestack.mulPose(Axis.XP.rotationDegrees((float) mouseY*0.5f));
        for(int i = 0; i < width; ++i) {
            for(int j = 0; j < height; ++j) {
                for(int k = 0; k < depth; ++k) {
                    REBlockPredicate reBlockPredicate = pattern[k][j][i];
                    Block block = reBlockPredicate.getBlock();
                    BlockState blockState = block.defaultBlockState();
                    BlockPos blockPos = new BlockPos(i, k, j);
                    final BakedModel model = blockRenderer.getBlockModel(blockState);
                    ChunkRenderTypeSet renderTypes = model.getRenderTypes(blockState, level.random, empty);
                    for (RenderType renderType : renderTypes) {
                        posestack.pushPose();
                        posestack.translate(i,k,j);
                        posestack.translate(-width/2.0,-depth/2.0,-height/2.0);
                        VertexConsumer buffer1 = bufferSource.getBuffer(renderType);
                        blockRenderer.getModelRenderer().tesselateBlock(
                                level, model, blockState, blockPos, posestack,
                                buffer1, true, level.random, blockState.getSeed(blockPos),
                                OverlayTexture.NO_OVERLAY, empty, renderType
                        );

                        posestack.popPose();
                    }
                }
            }
        }
        posestack.popPose();


    }

}
