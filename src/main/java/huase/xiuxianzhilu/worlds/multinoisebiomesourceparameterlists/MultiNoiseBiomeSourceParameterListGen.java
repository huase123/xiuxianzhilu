package huase.xiuxianzhilu.worlds.multinoisebiomesourceparameterlists;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import huase.xiuxianzhilu.ModMain;
import huase.xiuxianzhilu.worlds.biomes.BiomesInit;
import net.minecraft.SharedConstants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * - @description:MultiNoiseBiomeSourceParameterListGen类
 */
public class MultiNoiseBiomeSourceParameterListGen {
    public static final ResourceKey<MultiNoiseBiomeSourceParameterList> XIEXIANJIE_BiomeSourceParameterList_Registries = ResourceKey.create(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, ModMain.prefix("xiexianjie"));

    public static final MultiNoiseBiomeSourceParameterList.Preset xiexianjiemultinoisebiome = new MultiNoiseBiomeSourceParameterList.Preset(ModMain.prefix("xiexianjiemultinoisebiome"), MultiNoiseBiomeSourceParameterListGen::generateOverworldBiomes);

    public static void bootstrap(BootstapContext<MultiNoiseBiomeSourceParameterList> pContext) {
        HolderGetter<Biome> holdergetter = pContext.lookup(Registries.BIOME);
//        pContext.register(XIEXIANJIE_BiomeSourceParameterList, new MultiNoiseBiomeSourceParameterList(MultiNoiseBiomeSourceParameterList.Preset.OVERWORLD, holdergetter));
        pContext.register(XIEXIANJIE_BiomeSourceParameterList_Registries, new MultiNoiseBiomeSourceParameterList(xiexianjiemultinoisebiome, holdergetter));
    }


    static <T> Climate.ParameterList<T> generateOverworldBiomes(Function<ResourceKey<Biome>, T> p_277826_) {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, T>> builder = ImmutableList.builder();
        (new MultiNoiseBiomeSourceParameterListGen()).addBiomes((p_275579_) -> {
            builder.add(p_275579_.mapSecond(p_277826_));
        });
        return new Climate.ParameterList<>(builder.build());
    }


    protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pKey) {
        if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
            this.addDebugBiomes(pKey);
        } else {
//            this.addbugBiomes(pKey);
            this.addOffCoastBiomes(pKey);
            this.addInlandBiomes(pKey);
            this.addUndergroundBiomes(pKey);
        }
    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer) {
//        this.addPeaks(pConsumer, Climate.Parameter.span(-1.0F, -0.93333334F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.56666666F, -0.4F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.4F, -0.26666668F));
//        this.addLowSlice(pConsumer, Climate.Parameter.span(-0.26666668F, -0.05F));
//        this.addValleys(pConsumer, Climate.Parameter.span(-0.05F, 0.05F));
//        this.addLowSlice(pConsumer, Climate.Parameter.span(0.05F, 0.26666668F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.26666668F, 0.4F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.4F, 0.56666666F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.93333334F, 1.0F));


        this.highland(pConsumer, Climate.Parameter.span(-1.0F, -0.3F));
        this.plain(pConsumer, Climate.Parameter.span(-0.3F, -0.1F));
        this.river(pConsumer, Climate.Parameter.span(-0.05F, 0.05F));
        this.plain(pConsumer, Climate.Parameter.span(0.05F, 0.3F));
        this.highland(pConsumer, Climate.Parameter.span(0.3F, 1.0F));


    }

    private void highland(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> highland = this.pickHighland(i, j, pParam);
                ResourceKey<Biome> plain = this.pickPlainBiome(i, j, pParam);

                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[4]), pParam, 0.0F, highland);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[4], this.erosions[6]), pParam, 0.0F, plain);
            }
        }
    }

    private void plain(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {
        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> highland = this.pickHighland(i, j, pParam);
                ResourceKey<Biome> plain = this.pickPlainBiome(i, j, pParam);

                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[2]), pParam, 0.0F, highland);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[6]), pParam, 0.0F, plain);
            }
        }

    }

    private void river(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {

        if(pParam.max() >= 0L){
            this.addSurfaceBiome(pConsumer,  this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
            this.addSurfaceBiome(pConsumer,  this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F,  BiomesInit.xiuxianjie_biome0);

        }
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pParam, 0.0F,  BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pParam, 0.0F,  BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], pParam, 0.0F, BiomesInit.xiuxianjie_biome0);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> plain = this.pickPlainBiome(i, j, pParam);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, plain);
            }
        }
    }


    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {
        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickHighland(i, j, pParam);
                ResourceKey<Biome> resourcekey3 = this.pickPlainBiome(i, j, pParam);

                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[2]), pParam, 0.0F, resourcekey);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[6]), pParam, 0.0F, resourcekey3);
            }
        }

    }
    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickHighland(i, j, pParam);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[6]), pParam, 0.0F, resourcekey);
            }
        }


    }
    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pParam) {

        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pParam, 0.0F,BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], pParam, 0.0F, BiomesInit.xiuxianjie_biome0);

        if(pParam.max() >= 0L){

            this.addSurfaceBiome(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, BiomesInit.xiuxianjie_biome0);
            this.addSurfaceBiome(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F,  BiomesInit.xiuxianjie_biome0);
        }

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];

            for(int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter climate$parameter1 = this.humidities[j];
                ResourceKey<Biome> resourcekey = this.pickHighland(i, j, pParam);
                this.addSurfaceBiome(pConsumer, climate$parameter, climate$parameter1, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), pParam, 0.0F, resourcekey);
            }
        }

    }

    private ResourceKey<Biome> pickPlainBiome(int pTemperature, int pHumidity, Climate.Parameter pParam) {
//        if (pParam.max() >= 0L) {
//            ResourceKey<Biome> resourcekey = this.PLATEAU_BIOMES_VARIANT[pTemperature][pHumidity];
//            if (resourcekey != null) {
//                return resourcekey;
//            }
//        }

        return this.Plain_BIOMES[pTemperature][pHumidity];
    }


    private ResourceKey<Biome> pickHighland(int pTemperature, int pHumidity, Climate.Parameter pParam) {

        return this.Highland_BIOMES[pTemperature][pHumidity];
//        if (pParam.max() < 0L) {
//            return this.MIDDLE_BIOMES[pTemperature][pHumidity];
//        } else {
//            ResourceKey<Biome> resourcekey = this.MIDDLE_BIOMES_VARIANT[pTemperature][pHumidity];
//            return resourcekey == null ? this.MIDDLE_BIOMES[pTemperature][pHumidity] : resourcekey;
//        }
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer) {
//        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);

        for(int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter climate$parameter = this.temperatures[i];
            this.addSurfaceBiome(pConsumer, climate$parameter, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
            this.addSurfaceBiome(pConsumer, climate$parameter, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
        }

    }
    private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsume) {
        this.addUndergroundBiome(pConsume, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome3);
        this.addBottomBiome(pConsume, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome3);
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemperature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWeirdness, float offte, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(0.0F), pWeirdness, offte), pKey));
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(1.0F), pWeirdness, offte), pKey));
    }
    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemperature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWeirdness, float offte, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.span(0.2F, 0.9F), pWeirdness, offte), pKey));
    }

    private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemerature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWeirdness, float offte, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemerature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(1.1F), pWeirdness, offte), pKey));
    }
    private void addbugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer) {
//        addbiomesDemo(pKey,-1.0f,BiomesInit.JIN_BIOME);
//        addbiomesDemo(pKey,-0.5f,BiomesInit.MU_BIOME);
//        addbiomesDemo(pKey,0.0f,BiomesInit.SHUI_BIOME);
//        addbiomesDemo(pKey,0.5f,BiomesInit.HUO_BIOME);
//        addbiomesDemo(pKey,1.0f,BiomesInit.TU_BIOME);

//        this.addPeaks(pConsumer, Climate.Parameter.span(-1.0F, -0.93333334F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.56666666F, -0.4F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(-0.4F, -0.26666668F));
//        this.addLowSlice(pConsumer, Climate.Parameter.span(-0.26666668F, -0.05F));
//        this.addValleys(pConsumer, Climate.Parameter.span(-0.05F, 0.05F));
//        this.addLowSlice(pConsumer, Climate.Parameter.span(0.05F, 0.26666668F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.26666668F, 0.4F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.4F, 0.56666666F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
//        this.addPeaks(pConsumer, Climate.Parameter.span(0.93333334F, 1.0F));

//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-1.0F, -0.7666667F), 0.0F), BiomesInit.xiuxianjie_biome0  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-0.7666667F, -0.56666666F), 0.0F), BiomesInit.xiuxianjie_biome1  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-0.56666666F, -0.4F), 0.0F), BiomesInit.xiuxianjie_biome2  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-0.4F, -0.26666668F), 0.0F), BiomesInit.xiuxianjie_biome3  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-0.26666668F,  -0.05F), 0.0F), BiomesInit.xiuxianjie_biome4  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(-0.05F, 0.05F), 0.0F), BiomesInit.xiuxianjie_biome5  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.05F, 0.26666668F), 0.0F), BiomesInit.xiuxianjie_biome5  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.26666668F, 0.4F), 0.0F), BiomesInit.xiuxianjie_biome6  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.4F, 0.56666666F), 0.0F), BiomesInit.xiuxianjie_biome7  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.56666666F, 0.7666667F), 0.0F), BiomesInit.xiuxianjie_biome8  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.7666667F, 0.93333334F), 0.0F), BiomesInit.xiuxianjie_biome9  ));
//        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.93333334F, 1.0F), 0.0F), BiomesInit.xiuxianjie_biome10  ));

//        this.addSurfaceBiome(pConsumer,this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.93333334F, 1.0F), 0.0F), BiomesInit.xiuxianjie_biome10);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[0], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome0);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[1], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome1);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[2], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome2);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[3], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome3);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[4], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome4);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[5], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome5);
        this.addSurfaceBiome(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE,this.erosions[6], this.FULL_RANGE, 0.0F, BiomesInit.xiuxianjie_biome6);

    }

    private void addbiomesDemo(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pKey, float v, ResourceKey<Biome> jinBiome) {
        pKey.accept(Pair.of(Climate.parameters(
                Climate.Parameter.point(v),
                Climate.Parameter.point(v),
                this.FULL_RANGE,
                this.FULL_RANGE,
                this.FULL_RANGE,
                this.FULL_RANGE,
                0.0F
        ), jinBiome));
    }

    private void addDebugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pKey) {
        HolderLookup.Provider holderlookup$provider = VanillaRegistries.createLookup();
        HolderGetter<DensityFunction> holdergetter = holderlookup$provider.lookupOrThrow(Registries.DENSITY_FUNCTION);
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.CONTINENTS));
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate1 = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.EROSION));
        DensityFunctions.Spline.Coordinate densityfunctions$spline$coordinate2 = new DensityFunctions.Spline.Coordinate(holdergetter.getOrThrow(NoiseRouterData.RIDGES_FOLDED));
        pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.01F), Biomes.PLAINS));
        CubicSpline<?, ?> cubicspline = TerrainProvider.buildErosionOffsetSpline(densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, ToFloatFunction.IDENTITY);
        if (cubicspline instanceof CubicSpline.Multipoint<?, ?> multipoint) {
            ResourceKey<Biome> resourcekey = Biomes.DESERT;

            for(float f : multipoint.locations()) {
                pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f), Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), resourcekey));
                resourcekey = resourcekey == Biomes.DESERT ? Biomes.BADLANDS : Biomes.DESERT;
            }
        }

        CubicSpline<?, ?> cubicspline1 = TerrainProvider.overworldOffset(densityfunctions$spline$coordinate, densityfunctions$spline$coordinate1, densityfunctions$spline$coordinate2, false);
        if (cubicspline1 instanceof CubicSpline.Multipoint<?, ?> multipoint1) {
            for(float f1 : multipoint1.locations()) {
                pKey.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f1), this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), Biomes.SNOWY_TAIGA));
            }
        }

    }

    private static final float VALLEY_SIZE = 0.05F;
    private static final float LOW_START = 0.26666668F;
    public static final float HIGH_START = 0.4F;
    private static final float HIGH_END = 0.93333334F;
    private static final float PEAK_SIZE = 0.1F;
    public static final float PEAK_START = 0.56666666F;
    private static final float PEAK_END = 0.7666667F;
    public static final float NEAR_INLAND_START = -0.11F;
    public static final float MID_INLAND_START = 0.03F;
    public static final float FAR_INLAND_START = 0.3F;
    public static final float EROSION_INDEX_1_START = -0.78F;
    public static final float EROSION_INDEX_2_START = -0.375F;
    private static final float EROSION_DEEP_DARK_DRYNESS_THRESHOLD = -0.225F;
    private static final float DEPTH_DEEP_DARK_DRYNESS_THRESHOLD = 0.9F;
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {BiomesInit.xiuxianjie_biome10,
            BiomesInit.xiuxianjie_biome10,
            BiomesInit.xiuxianjie_biome10,
            BiomesInit.xiuxianjie_biome10,
            BiomesInit.xiuxianjie_biome10},
            {BiomesInit.xiuxianjie_biome9
                    , BiomesInit.xiuxianjie_biome6
                    ,BiomesInit.xiuxianjie_biome6
                    , BiomesInit.xiuxianjie_biome6
                    , BiomesInit.xiuxianjie_biome6}
    };
    private final ResourceKey<Biome>[][] Plain_BIOMES =
            new ResourceKey[][]{
                    {BiomesInit.xiuxianjie_biome4, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome5},
                    {BiomesInit.xiuxianjie_biome4, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome5},
                    {BiomesInit.xiuxianjie_biome4, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome5},
                    {BiomesInit.xiuxianjie_biome4, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome5},
                    {BiomesInit.xiuxianjie_biome4, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome1, BiomesInit.xiuxianjie_biome5},
    };
    private final ResourceKey<Biome>[][] Highland_BIOMES =
            new ResourceKey[][]{
                    {BiomesInit.xiuxianjie_biome8, BiomesInit.xiuxianjie_biome8, BiomesInit.xiuxianjie_biome8, BiomesInit.xiuxianjie_biome8, BiomesInit.xiuxianjie_biome8},
                    {BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2},
                    {BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2},
                    {BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2, BiomesInit.xiuxianjie_biome2},
                    {BiomesInit.xiuxianjie_biome7, BiomesInit.xiuxianjie_biome7, BiomesInit.xiuxianjie_biome7, BiomesInit.xiuxianjie_biome7, BiomesInit.xiuxianjie_biome7},
            };
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT =
            new ResourceKey[][]{{Biomes.ICE_SPIKES, null, Biomes.SNOWY_TAIGA, null, null},
                    {null, null, null, null, Biomes.OLD_GROWTH_PINE_TAIGA},
                    {Biomes.SUNFLOWER_PLAINS, null, null,
                            Biomes.OLD_GROWTH_BIRCH_FOREST, null},
                    {null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
                    {null, null, null, null, null}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT =
            new ResourceKey[][]{{Biomes.ICE_SPIKES, null, null, null, null},
                    {Biomes.CHERRY_GROVE, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
                    {Biomes.CHERRY_GROVE, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST, null},
                    {null, null, null, null, null},
                    {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null, null, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{{Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {null, null, null, null, null}, {null, null, null, null, null}};

}
